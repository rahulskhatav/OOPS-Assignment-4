```
/*
To calculate coupling of a program:
di: number of input data parameters
ci: number of input control parameters
do: number of output data parameters
co: number of output control parameters

For global coupling:
gd: number of global variables used as data
gc: number of global variables used as control
For environmental coupling:

w: number of modules called (fan-out)
r: number of modules calling the module under consideration (fan-in)
*/
#include <iostream>
using namespace std;

int main ()
{
  int din, ctrlin, dout, ctrlout, gdata, gctrl, w, r, factor;

  float coupling;

  // Input data
  std::cout << "Input data members: ";
  cin >> din; 
  std::cout << "Input control members: ";
  cin >> ctrlin; 
  std::cout << "Output data members: ";
  cin >> dout; 
  std::cout << "Output control members: ";
  cin >> ctrlout; 
  std::cout << "Global data variables: ";
  cin >> gdata; 
  std::cout << "Global control variables: ";
  cin >> gctrl; 
  std::cout << "Fan-out modules: ";
  cin >> w; 
  std::cout << "Fan-in variables: ";
  cin >> r; 

  factor = din + (2*ctrlin) + dout + (2*ctrlout) + gdata + (2*gctrl) + w + r;

  coupling = 1/(float) factor;
  coupling = 1 - coupling;

  std::cout << "Coupling: " << coupling << "\n";

  return 0;
}

```
