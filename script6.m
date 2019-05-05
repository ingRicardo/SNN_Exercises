#/1 A simple leaky membrane

clear
% membrane constants
tau_m = 0.030;
Rm = 3e7;

% Time
delta_t = 0.001; % Integration time step
duration = 0.5; % duration of the simulation
No_steps = round(duration ./ delta_t);
times = linspace(0, duration, No_steps + 1); % The time points for update


% membrane potential
V_0 = 0.05; % The initial membrane potential
V = zeros(1, No_steps + 1);
V(1) = V_0;

% Injection current
I_0 = 2e-9;
I_duration = 0.25;
I_start = 0.05;
I_start_index = round(I_start ./ delta_t);
I_finish_index = round((I_start + I_duration) ./ delta_t);
Iinj = zeros(1, No_steps + 1);
Iinj(I_start_index:I_finish_index) = I_0;
thresh = 0.055;
t_spikes = [];
tau_s = 0.003;



%%%% set up PSC events
% Times of PSCs
T_psc(1) = 0.05;
T_psc(2) = 0.07;
T_psc(3) = 0.09;
No_pscs = length(T_psc);
Q = 40e-12; % charge deliverd by a single PSC event
I_0 = Q ./ tau_s; % resulting ’normalisation’ constant for the
% exponential description of the PSC
index_pscs = round(T_psc ./ delta_t);
% initialise synaptic current
I_syn = zeros(1, No_steps + 1);


% noise current
std_dev_noise = 15e-9;
#I_noise = std_dev_noise .* randn(1, No_steps);


for i=1:No_steps
  
  I_noise(i) = std_dev_noise .* randn;
% first check for synaptic event
  if find(index_pscs == i)
    I_syn(i) = I_syn(i) + I_0;
  end
% update the synaptic current
I_syn(i+1) = I_syn(i) - (1 ./ tau_s) .* I_syn(i) .* delta_t;

dV = (1 ./ tau_m) .* (-V(i) + Rm .* (I_syn(i) + Iinj(i) + I_noise(i))) .* delta_t;
V(i+1) = V(i) + dV;
  if V(i+1) > thresh
    V(i+1) = 0;
    t_spikes = [t_spikes (i - 1) * delta_t];
  end
end

%%% plotting spikes
spike_height = 0.1;
No_spikes = length(t_spikes);
if No_spikes > 0
  spts = [t_spikes; t_spikes];
  y1 = thresh .* ones(1, No_spikes);
  y2 = y1 + spike_height;
  sp = [y2; y1];
end
%%%

clf % clear the graphics
subplot(2,1,1)
plot(times, V, 'r');
Vheight = 1.2 .* (thresh + spike_height);
if No_spikes > 0
  h = line(spts, sp);
  for k=1:length(h)
    set(h(k), 'Color', [0 1 0])
  end
end

axis([0 duration 0 Vheight])
subplot(2,1,2)
plot(times, Iinj, 'b');
Iheight = 1.2 .* I_0;
axis([0 duration 0 Iheight])
