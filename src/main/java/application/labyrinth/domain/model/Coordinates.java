package application.labyrinth.domain.model;

public class Coordinates
{
    class coord
    {
        protected int x;
        protected int y;
    }
    private int leng = 0;
    private int nrOfElem = 0;
    private boolean empty = true;
    private coord[] pairXY = new coord[leng];
    private void decide()
    {
        empty = nrOfElem == 0;
    }
    public Coordinates(int length)
    {
        this.leng = length;
    }
    public void push(int X, int Y)
    {
        pairXY[nrOfElem].x = X;
        pairXY[nrOfElem].y = Y;
        nrOfElem ++;
    }
    public void remove()
    {
        if(nrOfElem > 0)
        {
            pairXY[nrOfElem].x = 0;
            pairXY[nrOfElem].y = 0;
            nrOfElem--;
        }
    }
    public int length()
    {
        return nrOfElem;
    }
    public int[] top()
    {
        int [] temp = new int [2];
        int x = pairXY[nrOfElem].x;
        int y = pairXY[nrOfElem].y;
        temp[0] = x;
        temp[1] = y;
        return temp;
    }
    public boolean isEmpty()
    {
        decide();
        return empty;
    }

}
