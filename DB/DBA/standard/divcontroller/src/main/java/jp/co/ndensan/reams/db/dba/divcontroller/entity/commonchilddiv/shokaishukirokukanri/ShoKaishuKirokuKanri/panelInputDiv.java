package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shokaishukirokukanri.ShoKaishuKirokuKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKoufuType")
    private TextBox txtKoufuType;
    @JsonProperty("txtKoufuDate")
    private TextBoxDate txtKoufuDate;
    @JsonProperty("ddlKoufuJiyu")
    private DropDownList ddlKoufuJiyu;
    @JsonProperty("txaKoufuRiyu")
    private TextBoxMultiLine txaKoufuRiyu;
    @JsonProperty("txaKaishuRiyu")
    private TextBoxMultiLine txaKaishuRiyu;
    @JsonProperty("ddlKaisyuJiyu")
    private DropDownList ddlKaisyuJiyu;
    @JsonProperty("txtKaisyuDate")
    private TextBoxDate txtKaisyuDate;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKoufuType
     * @return txtKoufuType
     */
    @JsonProperty("txtKoufuType")
    public TextBox getTxtKoufuType() {
        return txtKoufuType;
    }

    /*
     * settxtKoufuType
     * @param txtKoufuType txtKoufuType
     */
    @JsonProperty("txtKoufuType")
    public void setTxtKoufuType(TextBox txtKoufuType) {
        this.txtKoufuType = txtKoufuType;
    }

    /*
     * gettxtKoufuDate
     * @return txtKoufuDate
     */
    @JsonProperty("txtKoufuDate")
    public TextBoxDate getTxtKoufuDate() {
        return txtKoufuDate;
    }

    /*
     * settxtKoufuDate
     * @param txtKoufuDate txtKoufuDate
     */
    @JsonProperty("txtKoufuDate")
    public void setTxtKoufuDate(TextBoxDate txtKoufuDate) {
        this.txtKoufuDate = txtKoufuDate;
    }

    /*
     * getddlKoufuJiyu
     * @return ddlKoufuJiyu
     */
    @JsonProperty("ddlKoufuJiyu")
    public DropDownList getDdlKoufuJiyu() {
        return ddlKoufuJiyu;
    }

    /*
     * setddlKoufuJiyu
     * @param ddlKoufuJiyu ddlKoufuJiyu
     */
    @JsonProperty("ddlKoufuJiyu")
    public void setDdlKoufuJiyu(DropDownList ddlKoufuJiyu) {
        this.ddlKoufuJiyu = ddlKoufuJiyu;
    }

    /*
     * gettxaKoufuRiyu
     * @return txaKoufuRiyu
     */
    @JsonProperty("txaKoufuRiyu")
    public TextBoxMultiLine getTxaKoufuRiyu() {
        return txaKoufuRiyu;
    }

    /*
     * settxaKoufuRiyu
     * @param txaKoufuRiyu txaKoufuRiyu
     */
    @JsonProperty("txaKoufuRiyu")
    public void setTxaKoufuRiyu(TextBoxMultiLine txaKoufuRiyu) {
        this.txaKoufuRiyu = txaKoufuRiyu;
    }

    /*
     * gettxaKaishuRiyu
     * @return txaKaishuRiyu
     */
    @JsonProperty("txaKaishuRiyu")
    public TextBoxMultiLine getTxaKaishuRiyu() {
        return txaKaishuRiyu;
    }

    /*
     * settxaKaishuRiyu
     * @param txaKaishuRiyu txaKaishuRiyu
     */
    @JsonProperty("txaKaishuRiyu")
    public void setTxaKaishuRiyu(TextBoxMultiLine txaKaishuRiyu) {
        this.txaKaishuRiyu = txaKaishuRiyu;
    }

    /*
     * getddlKaisyuJiyu
     * @return ddlKaisyuJiyu
     */
    @JsonProperty("ddlKaisyuJiyu")
    public DropDownList getDdlKaisyuJiyu() {
        return ddlKaisyuJiyu;
    }

    /*
     * setddlKaisyuJiyu
     * @param ddlKaisyuJiyu ddlKaisyuJiyu
     */
    @JsonProperty("ddlKaisyuJiyu")
    public void setDdlKaisyuJiyu(DropDownList ddlKaisyuJiyu) {
        this.ddlKaisyuJiyu = ddlKaisyuJiyu;
    }

    /*
     * gettxtKaisyuDate
     * @return txtKaisyuDate
     */
    @JsonProperty("txtKaisyuDate")
    public TextBoxDate getTxtKaisyuDate() {
        return txtKaisyuDate;
    }

    /*
     * settxtKaisyuDate
     * @param txtKaisyuDate txtKaisyuDate
     */
    @JsonProperty("txtKaisyuDate")
    public void setTxtKaisyuDate(TextBoxDate txtKaisyuDate) {
        this.txtKaisyuDate = txtKaisyuDate;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    // </editor-fold>
}
