package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShoriTaishoshaKensakuSiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriTaishoshaKensakuSijiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinsakaiKaisaiYoteiYMD")
    private Label lblShinsakaiKaisaiYoteiYMD;
    @JsonProperty("txtKaisaiYoteiYMD")
    private TextBoxFlexibleDate txtKaisaiYoteiYMD;
    @JsonProperty("lblIchijiHanteiYMD")
    private Label lblIchijiHanteiYMD;
    @JsonProperty("txtIchijiHanteiYMD")
    private TextBoxFlexibleDate txtIchijiHanteiYMD;
    @JsonProperty("lblDummy")
    private Label lblDummy;
    @JsonProperty("lblHokenshaNo")
    private Label lblHokenshaNo;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("lblHihokenshaNo")
    private Label lblHihokenshaNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("lblShinseiYMD")
    private Label lblShinseiYMD;
    @JsonProperty("txtShinseiYMDst")
    private TextBoxFlexibleDate txtShinseiYMDst;
    @JsonProperty("lblKara1")
    private Label lblKara1;
    @JsonProperty("txtShinseiYMDend")
    private TextBoxFlexibleDate txtShinseiYMDend;
    @JsonProperty("lblHihkenshaShimei")
    private Label lblHihkenshaShimei;
    @JsonProperty("txtShimeiKanji")
    private TextBox txtShimeiKanji;
    @JsonProperty("txtShimeiKana")
    private Label txtShimeiKana;
    @JsonProperty("txtShimeiKensakuKana")
    private TextBox txtShimeiKensakuKana;
    @JsonProperty("btnTaishoKensaku")
    private Button btnTaishoKensaku;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinsakaiKaisaiYoteiYMD")
    public Label getLblShinsakaiKaisaiYoteiYMD() {
        return lblShinsakaiKaisaiYoteiYMD;
    }

    @JsonProperty("lblShinsakaiKaisaiYoteiYMD")
    public void setLblShinsakaiKaisaiYoteiYMD(Label lblShinsakaiKaisaiYoteiYMD) {
        this.lblShinsakaiKaisaiYoteiYMD=lblShinsakaiKaisaiYoteiYMD;
    }

    @JsonProperty("txtKaisaiYoteiYMD")
    public TextBoxFlexibleDate getTxtKaisaiYoteiYMD() {
        return txtKaisaiYoteiYMD;
    }

    @JsonProperty("txtKaisaiYoteiYMD")
    public void setTxtKaisaiYoteiYMD(TextBoxFlexibleDate txtKaisaiYoteiYMD) {
        this.txtKaisaiYoteiYMD=txtKaisaiYoteiYMD;
    }

    @JsonProperty("lblIchijiHanteiYMD")
    public Label getLblIchijiHanteiYMD() {
        return lblIchijiHanteiYMD;
    }

    @JsonProperty("lblIchijiHanteiYMD")
    public void setLblIchijiHanteiYMD(Label lblIchijiHanteiYMD) {
        this.lblIchijiHanteiYMD=lblIchijiHanteiYMD;
    }

    @JsonProperty("txtIchijiHanteiYMD")
    public TextBoxFlexibleDate getTxtIchijiHanteiYMD() {
        return txtIchijiHanteiYMD;
    }

    @JsonProperty("txtIchijiHanteiYMD")
    public void setTxtIchijiHanteiYMD(TextBoxFlexibleDate txtIchijiHanteiYMD) {
        this.txtIchijiHanteiYMD=txtIchijiHanteiYMD;
    }

    @JsonProperty("lblDummy")
    public Label getLblDummy() {
        return lblDummy;
    }

    @JsonProperty("lblDummy")
    public void setLblDummy(Label lblDummy) {
        this.lblDummy=lblDummy;
    }

    @JsonProperty("lblHokenshaNo")
    public Label getLblHokenshaNo() {
        return lblHokenshaNo;
    }

    @JsonProperty("lblHokenshaNo")
    public void setLblHokenshaNo(Label lblHokenshaNo) {
        this.lblHokenshaNo=lblHokenshaNo;
    }

    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("lblHihokenshaNo")
    public Label getLblHihokenshaNo() {
        return lblHihokenshaNo;
    }

    @JsonProperty("lblHihokenshaNo")
    public void setLblHihokenshaNo(Label lblHihokenshaNo) {
        this.lblHihokenshaNo=lblHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("lblShinseiYMD")
    public Label getLblShinseiYMD() {
        return lblShinseiYMD;
    }

    @JsonProperty("lblShinseiYMD")
    public void setLblShinseiYMD(Label lblShinseiYMD) {
        this.lblShinseiYMD=lblShinseiYMD;
    }

    @JsonProperty("txtShinseiYMDst")
    public TextBoxFlexibleDate getTxtShinseiYMDst() {
        return txtShinseiYMDst;
    }

    @JsonProperty("txtShinseiYMDst")
    public void setTxtShinseiYMDst(TextBoxFlexibleDate txtShinseiYMDst) {
        this.txtShinseiYMDst=txtShinseiYMDst;
    }

    @JsonProperty("lblKara1")
    public Label getLblKara1() {
        return lblKara1;
    }

    @JsonProperty("lblKara1")
    public void setLblKara1(Label lblKara1) {
        this.lblKara1=lblKara1;
    }

    @JsonProperty("txtShinseiYMDend")
    public TextBoxFlexibleDate getTxtShinseiYMDend() {
        return txtShinseiYMDend;
    }

    @JsonProperty("txtShinseiYMDend")
    public void setTxtShinseiYMDend(TextBoxFlexibleDate txtShinseiYMDend) {
        this.txtShinseiYMDend=txtShinseiYMDend;
    }

    @JsonProperty("lblHihkenshaShimei")
    public Label getLblHihkenshaShimei() {
        return lblHihkenshaShimei;
    }

    @JsonProperty("lblHihkenshaShimei")
    public void setLblHihkenshaShimei(Label lblHihkenshaShimei) {
        this.lblHihkenshaShimei=lblHihkenshaShimei;
    }

    @JsonProperty("txtShimeiKanji")
    public TextBox getTxtShimeiKanji() {
        return txtShimeiKanji;
    }

    @JsonProperty("txtShimeiKanji")
    public void setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.txtShimeiKanji=txtShimeiKanji;
    }

    @JsonProperty("txtShimeiKana")
    public Label getTxtShimeiKana() {
        return txtShimeiKana;
    }

    @JsonProperty("txtShimeiKana")
    public void setTxtShimeiKana(Label txtShimeiKana) {
        this.txtShimeiKana=txtShimeiKana;
    }

    @JsonProperty("txtShimeiKensakuKana")
    public TextBox getTxtShimeiKensakuKana() {
        return txtShimeiKensakuKana;
    }

    @JsonProperty("txtShimeiKensakuKana")
    public void setTxtShimeiKensakuKana(TextBox txtShimeiKensakuKana) {
        this.txtShimeiKensakuKana=txtShimeiKensakuKana;
    }

    @JsonProperty("btnTaishoKensaku")
    public Button getBtnTaishoKensaku() {
        return btnTaishoKensaku;
    }

    @JsonProperty("btnTaishoKensaku")
    public void setBtnTaishoKensaku(Button btnTaishoKensaku) {
        this.btnTaishoKensaku=btnTaishoKensaku;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

}
