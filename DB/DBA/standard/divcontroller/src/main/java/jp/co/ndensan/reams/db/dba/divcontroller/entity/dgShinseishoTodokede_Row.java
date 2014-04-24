package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Apr 24 19:08:40 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinseishoTodokede_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseishoTodokede_Row extends DataRow {

    private RString todokedeYMD;
    private RString shinseishoKanriNo;
    private RString todokedeShubetsu;

    public dgShinseishoTodokede_Row() {
        super();
    }

    public dgShinseishoTodokede_Row(RString todokedeYMD, RString shinseishoKanriNo, RString todokedeShubetsu) {
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