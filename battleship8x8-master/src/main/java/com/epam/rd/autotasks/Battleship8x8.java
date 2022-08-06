package com.epam.rd.autotasks;

import java.util.List;
import java.util.Objects;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        //throw new UnsupportedOperationException();
        String str=Long.toBinaryString(this.ships);
        if(str.length()==63)
        {
            str=String.valueOf(new StringBuffer(str).insert(0,"0"));
        }

        String[] shootMap=str.split("");
        String[] cr=shot.split("");
        List<String> ab=List.of("A","B","C","D","E","F","G","H");
        int shotIndex=ab.indexOf(cr[0]);
        int index=8*(Integer.parseInt(cr[1])-1)+shotIndex;
        this.shots|=1L<<63-index;

        return Objects.equals(shootMap[index],"1");
    }

    public String state() {
        //throw new UnsupportedOperationException();
        String str1=Long.toBinaryString(this.ships);
        if(ships>0)
        {
            str1="0"+str1;
        }
        StringBuilder builder= new StringBuilder(Long.toBinaryString(shots));
        System.out.println(builder.length());
        if(builder.length()<64)
        {
            int c=64-builder.length();
            for(int i=0;i<c;i++)
            {
                builder.insert(0, "0");
            }
        }

        System.out.println(builder.length());
        char []arr1=str1.toCharArray();
        char []arr= builder.toString().toCharArray();
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]=='1'&&arr[i]=='1')
            {
                arr[i]='☒';
            }else if (arr1[i]=='0'&&arr[i]=='1')
            {
                arr[i]='×';
            }else if(arr1[i]=='1'&&arr[i]=='0')
            {
                arr[i]='☐';
            }else if(arr1[i]=='0'&&arr[i]=='0')
                arr[i]='.';
        }

        StringBuilder builder1= new StringBuilder();
        for (char c : arr) {
            builder1.append(c);
        }
        String []t=new String[8];
        for(int i=0;i<builder1.length()/8;i++)
        {
            t[i]=builder1.substring(i*8,i*8+8);
        }
        StringBuilder m= new StringBuilder();
        for (String value : t) {
            m.append(value).append("\n");
        }
        System.out.println(m);
        return m.toString();
    }
}
