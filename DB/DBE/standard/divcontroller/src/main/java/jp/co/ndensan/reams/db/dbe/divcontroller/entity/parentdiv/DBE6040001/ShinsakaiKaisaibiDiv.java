package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiKaisaibi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaibiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("txtShinsakaiKaisaiYM")
    private TextBoxDate txtShinsakaiKaisaiYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * gettxtShinsakaiKaisaiYM
     * @return txtShinsakaiKaisaiYM
     */
    @JsonProperty("txtShinsakaiKaisaiYM")
    public TextBoxDate getTxtShinsakaiKaisaiYM() {
        return txtShinsakaiKaisaiYM;
    }

    /*
     * settxtShinsakaiKaisaiYM
     * @param txtShinsakaiKaisaiYM txtShinsakaiKaisaiYM
     */
    @JsonProperty("txtShinsakaiKaisaiYM")
    public void setTxtShinsakaiKaisaiYM(TextBoxDate txtShinsakaiKaisaiYM) {
        this.txtShinsakaiKaisaiYM = txtShinsakaiKaisaiYM;
    }

    // </editor-fold>
}
