package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Apr 22 14:56:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * ShinseishoTodokedeGrid_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class ShinseishoTodokedeGrid_Row extends DataRow {

    private RString todokedeYMD;
    private RString shinseishoKanriNo;
    private RString todokedeShubetsu;

    public ShinseishoTodokedeGrid_Row() {
        super();
    }

    public ShinseishoTodokedeGrid_Row(RString todokedeYMD, RString shinseishoKanriNo, RString todokedeShubetsu) {
        super();
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("todokedeShubetsu", todokedeShubetsu);
        this.todokedeYMD = todokedeYMD;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.todokedeShubetsu = todokedeShubetsu;
    }

    public RString getTodokedeYMD() {
        return todokedeYMD;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getTodokedeShubetsu() {
        return todokedeShubetsu;
    }

    public void setTodokedeYMD(RString todokedeYMD) {
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.todokedeYMD = todokedeYMD;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setTodokedeShubetsu(RString todokedeShubetsu) {
        this.setOriginalData("todokedeShubetsu", todokedeShubetsu);
        this.todokedeShubetsu = todokedeShubetsu;
    }

}