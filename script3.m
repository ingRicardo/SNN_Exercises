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
for i=1:No_steps
  dV = (1 ./ tau_m) .* (-V(i) + Rm .* Iinj(i)) .* delta_t;
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
