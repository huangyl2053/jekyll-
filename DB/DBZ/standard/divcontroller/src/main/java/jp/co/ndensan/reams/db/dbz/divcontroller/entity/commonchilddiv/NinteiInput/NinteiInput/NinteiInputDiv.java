package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.dgServiceIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiInputDiv extends Panel implements INinteiInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiJoho")
    private NinteiJohoDiv NinteiJoho;
    @JsonProperty("ServiceShitei")
    private ServiceShiteiDiv ServiceShitei;
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    private RString hdnKoroshoIfShikibetsuCode;
    @JsonProperty("hdnHihokenshaNo")
    private RString hdnHihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteiJoho")
    public NinteiJohoDiv getNinteiJoho() {
        return NinteiJoho;
    }

    @JsonProperty("NinteiJoho")
    public void setNinteiJoho(NinteiJohoDiv NinteiJoho) {
        this.NinteiJoho=NinteiJoho;
    }

    @JsonProperty("ServiceShitei")
    public ServiceShiteiDiv getServiceShitei() {
        return ServiceShitei;
    }

    @JsonProperty("ServiceShitei")
    public void setServiceShitei(ServiceShiteiDiv ServiceShitei) {
        this.ServiceShitei=ServiceShitei;
    }

    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken=txtShinsakaiIken;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode=hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo=hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    public RString getHdnKoroshoIfShikibetsuCode() {
        return hdnKoroshoIfShikibetsuCode;
    }

    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    public void setHdnKoroshoIfShikibetsuCode(RString hdnKoroshoIfShikibetsuCode) {
        this.hdnKoroshoIfShikibetsuCode=hdnKoroshoIfShikibetsuCode;
    }

    @JsonProperty("hdnHihokenshaNo")
    public RString getHdnHihokenshaNo() {
        return hdnHihokenshaNo;
    }

    @JsonProperty("hdnHihokenshaNo")
    public void setHdnHihokenshaNo(RString hdnHihokenshaNo) {
        this.hdnHihokenshaNo=hdnHihokenshaNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadNinteiKubun() {
        return this.getNinteiJoho().getRadNinteiKubun();
    }

    @JsonIgnore
    public void  setRadNinteiKubun(RadioButton radNinteiKubun) {
        this.getNinteiJoho().setRadNinteiKubun(radNinteiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkMinashiKoshinNintei() {
        return this.getNinteiJoho().getChkMinashiKoshinNintei();
    }

    @JsonIgnore
    public void  setChkMinashiKoshinNintei(CheckBoxList chkMinashiKoshinNintei) {
        this.getNinteiJoho().setChkMinashiKoshinNintei(chkMinashiKoshinNintei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMD() {
        return this.getNinteiJoho().getTxtNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiYMD(TextBoxFlexibleDate txtNinteiYMD) {
        this.getNinteiJoho().setTxtNinteiYMD(txtNinteiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtYokaigodoCode() {
        return this.getNinteiJoho().getTxtYokaigodoCode();
    }

    @JsonIgnore
    public void  setTxtYokaigodoCode(TextBoxCode txtYokaigodoCode) {
        this.getNinteiJoho().setTxtYokaigodoCode(txtYokaigodoCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnYokaigodoGuide() {
        return this.getNinteiJoho().getBtnYokaigodoGuide();
    }

    @JsonIgnore
    public void  setBtnYokaigodoGuide(ButtonDialog btnYokaigodoGuide) {
        this.getNinteiJoho().setBtnYokaigodoGuide(btnYokaigodoGuide);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoName() {
        return this.getNinteiJoho().getTxtYokaigodoName();
    }

    @JsonIgnore
    public void  setTxtYokaigodoName(TextBox txtYokaigodoName) {
        this.getNinteiJoho().setTxtYokaigodoName(txtYokaigodoName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishiYMD() {
        return this.getNinteiJoho().getTxtYukoKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKaishiYMD(TextBoxFlexibleDate txtYukoKaishiYMD) {
        this.getNinteiJoho().setTxtYukoKaishiYMD(txtYukoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryoYMD() {
        return this.getNinteiJoho().getTxtYukoShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtYukoShuryoYMD(TextBoxFlexibleDate txtYukoShuryoYMD) {
        this.getNinteiJoho().setTxtYukoShuryoYMD(txtYukoShuryoYMD);
    }

    @JsonIgnore
    public Button getBtnAfter6Month() {
        return this.getNinteiJoho().getBtnAfter6Month();
    }

    @JsonIgnore
    public void  setBtnAfter6Month(Button btnAfter6Month) {
        this.getNinteiJoho().setBtnAfter6Month(btnAfter6Month);
    }

    @JsonIgnore
    public Button getBtnAfter12Month() {
        return this.getNinteiJoho().getBtnAfter12Month();
    }

    @JsonIgnore
    public void  setBtnAfter12Month(Button btnAfter12Month) {
        this.getNinteiJoho().setBtnAfter12Month(btnAfter12Month);
    }

    @JsonIgnore
    public Button getBtnAfter18Month() {
        return this.getNinteiJoho().getBtnAfter18Month();
    }

    @JsonIgnore
    public void  setBtnAfter18Month(Button btnAfter18Month) {
        this.getNinteiJoho().setBtnAfter18Month(btnAfter18Month);
    }

    @JsonIgnore
    public Button getBtnAfter24Month() {
        return this.getNinteiJoho().getBtnAfter24Month();
    }

    @JsonIgnore
    public void  setBtnAfter24Month(Button btnAfter24Month) {
        this.getNinteiJoho().setBtnAfter24Month(btnAfter24Month);
    }

    @JsonIgnore
    public Label getLblServiceIken() {
        return this.getServiceShitei().getLblServiceIken();
    }

    @JsonIgnore
    public void  setLblServiceIken(Label lblServiceIken) {
        this.getServiceShitei().setLblServiceIken(lblServiceIken);
    }

    @JsonIgnore
    public DataGrid<dgServiceIchiran_Row> getDgServiceIchiran() {
        return this.getServiceShitei().getDgServiceIchiran();
    }

    @JsonIgnore
    public void  setDgServiceIchiran(DataGrid<dgServiceIchiran_Row> dgServiceIchiran) {
        this.getServiceShitei().setDgServiceIchiran(dgServiceIchiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
