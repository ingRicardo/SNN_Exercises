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

for i=1:No_steps
  dV = (-1 ./ tau_m) .* V(i) .* delta_t;
  V(i+1) = V(i) + dV;
end

clf % clear the graphics
plot(times, V);