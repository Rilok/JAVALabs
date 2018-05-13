public class Sorting {

    Integer[] table;

    public Sorting(Integer[] tab){
        table = tab;
    }

    public Integer[] getTable() {
        return table;
    }

    public void SortArray(String option) {
        if (table == null)
            throw new IllegalArgumentException();
        if (table.length == 0)
            throw new NullPointerException();
        if (option.equals("R")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length - 1; j++) {
                    if (table[j] > table[j + 1]) {
                        int temp;
                        temp = table[j + 1];
                        table[j + 1] = table[j];
                        table[j] = temp;
                    }
                }
            }
        }
        if (option.equals("M")) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length - 1; j++) {
                    if (table[j] < table[j + 1]) {
                        int temp;
                        temp = table[j + 1];
                        table[j + 1] = table[j];
                        table[j] = temp;
                    }
                }
            }
        }
    }

    public void showArray(){
        for (int i = 0; i < table.length; i++){
            System.out.print(table[i] + " ");
        }
    }

    public boolean isSorted(String option){

        boolean flag = true;

        if (table == null)
            throw new IllegalArgumentException();
        if (table.length == 0)
            throw new NullPointerException();
        if (option.equals("R")){
            for (int i = 0; i < table.length; i++){
                for (int j = 0; j < table.length - 1; j++){
                    if (table[j] < table[j+1])
                        continue;
                    else{
                        flag = false;
                        break;
                    }
                }
            }
        }

        if (option.equals(("M"))) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length - 1; j++) {
                    if (table[j] > table[j + 1]) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}
