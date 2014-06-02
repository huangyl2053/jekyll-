package jp.co.ndensan.reams.db.dbz.divcontroller.entity.TokuteiShinryoShikibetsuCodeInputGuide;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 02 11:36:06 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTokuteiShinryoShikibetsuCode_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTokuteiShinryoShikibetsuCode_Row extends DataRow {

    private Button btnSelectRow;
    private RString txtTokuteiShinryoShikibetsuCode;

    public dgTokuteiShinryoShikibetsuCode_Row() {
        super();
    }

    public dgTokuteiShinryoShikibetsuCode_Row(Button btnSelectRow, RString txtTokuteiShinryoShikibetsuCode) {
        super();
        this.setOriginalData("btnSelectRow", btnSelectRow);
        this.setOriginalData("txtTokuteiShinryoShikibetsuCode", txtTokuteiShinryoShikibetsuCode);
        this.btnSelectRow = btnSelectRow;
        this.txtTokuteiShinryoShikibetsuCode = txtTokuteiShinryoShikibetsuCode;
    }

    public Button getBtnSelectRow() {
        return btnSelectRow;
    }

    public RString getTxtTokuteiShinryoShikibetsuCode() {
        return txtTokuteiShinryoShikibetsuCode;
    }

    public void setBtnSelectRow(Button btnSelectRow) {
        this.setOriginalData("btnSelectRow", btnSelectRow);
        this.btnSelectRow = btnSelectRow;
    }

    public void setTxtTokuteiShinryoShikibetsuCode(RString txtTokuteiShinryoShikibetsuCode) {
        this.setOriginalData("txtTokuteiShinryoShikibetsuCode", txtTokuteiShinryoShikibetsuCode);
        this.txtTokuteiShinryoShikibetsuCode = txtTokuteiShinryoShikibetsuCode;
    }

}