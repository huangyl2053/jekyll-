package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 13 19:55:12 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;


/**
 * dgShoruiJokyoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShoruiJokyoList_Row extends DataRow {

    private Button btnSelect;

    public dgShoruiJokyoList_Row() {
        super();
    }

    public dgShoruiJokyoList_Row(Button btnSelect) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

}