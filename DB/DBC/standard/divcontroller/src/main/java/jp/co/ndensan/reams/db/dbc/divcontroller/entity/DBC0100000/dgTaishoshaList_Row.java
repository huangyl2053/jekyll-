package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 20:33:23 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;


/**
 * dgTaishoshaList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaishoshaList_Row extends DataRow {

    private Button btnSelect;

    public dgTaishoshaList_Row() {
        super();
        this.btnSelect = new Button();
    }

    public dgTaishoshaList_Row(Button btnSelect) {
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