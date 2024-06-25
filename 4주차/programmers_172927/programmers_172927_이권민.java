class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
      
        if (dia > 0)
            dfs(0, "d", 0, minerals, dia-1, iron, stone);
        if (iron > 0)
            dfs(0, "i", 0, minerals, dia, iron-1, stone);
        if (stone > 0)
            dfs(0, "s", 0, minerals, dia, iron, stone-1);
        
        return min;
    }
    
    public void dfs(int fatigue, String tool, int index, String[] minerals, int dia, int iron, int stone) {
        if ( index >= minerals.length ) {
            min = Math.min(min, fatigue);
            return;
        }
        
        if (minerals[index].equals("diamond")) {
            if ("d".equals(tool)) {
                fatigue += 1;
            } else if ("i".equals(tool)) {
                fatigue += 5;
            } else {
                fatigue += 25;
            }
        } else if (minerals[index].equals("iron")) {
            if ("d".equals(tool)) {
                fatigue += 1;
            } else if ("i".equals(tool)) {
                fatigue += 1;
            } else {
                fatigue += 5;
            }
        } else if (minerals[index].equals("stone")) {
            if ("d".equals(tool)) {
                fatigue += 1;
            } else if ("i".equals(tool)) {
                fatigue += 1;
            } else {
                fatigue += 1;
            }
        }
        
        if ((index + 1) % 5 == 0) {
            if ((dia == 0 && iron == 0 && stone == 0) ) {
                min = Math.min(min, fatigue);
                return;
            }
            
            if (dia > 0) {
                dfs (fatigue, "d", index+1, minerals, dia-1, iron, stone);
            }
            
            if (iron > 0) {
                dfs(fatigue, "i", index+1, minerals, dia, iron-1, stone);
            }
            
            if (stone > 0) {
                dfs(fatigue, "s", index+1, minerals, dia, iron, stone-1);
            }
        } else {
            dfs(fatigue, tool, index+1, minerals, dia, iron, stone);
        }
    }
}
출처: https://chamggae.tistory.com/195 [suhaha 개발 일지:티스토리]