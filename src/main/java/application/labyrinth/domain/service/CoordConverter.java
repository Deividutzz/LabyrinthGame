package application.labyrinth.domain.service;

public class CoordConverter
{
    private int computeConvertion(int number, boolean abs)
    {
        int value = 26;
        int dim = 60;
        if(abs)
        {
            value = 504;
        }
        return value + number * dim;
    }
    public int convert(int coord, boolean abscisa)
    {
        return computeConvertion(coord,abscisa);
    }
}