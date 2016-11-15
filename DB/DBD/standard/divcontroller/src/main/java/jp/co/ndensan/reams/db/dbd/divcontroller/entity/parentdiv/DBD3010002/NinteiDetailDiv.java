package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvShinseiJoho")
    private DvShinseiJohoDiv DvShinseiJoho;
    @JsonProperty("ShiteiServiceIchiran")
    private ShiteiServiceIchiranDiv ShiteiServiceIchiran;
    @JsonProperty("Ninteichosa")
    private NinteichosaDiv Ninteichosa;
    @JsonProperty("linLine4")
    private HorizontalLine linLine4;
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;
    @JsonProperty("txtNinteiResultIdoJiyu")
    private TextBox txtNinteiResultIdoJiyu;
    @JsonProperty("txtSakujoJiyu")
    private TextBox txtSakujoJiyu;
    @JsonProperty("txtRiyu")
    private TextBox txtRiyu;
    @JsonProperty("linIdoJiyu")
    private HorizontalLine linIdoJiyu;
    @JsonProperty("txtTokuteiShippei")
    private TextBox txtTokuteiShippei;
    @JsonProperty("txtNinteiSoshitsuYMD")
    private TextBoxFlexibleDate txtNinteiSoshitsuYMD;
    @JsonProperty("txtTorikeshiYMD")
    private TextBoxFlexibleDate txtTorikeshiYMD;
    @JsonProperty("NinteiResult")
    private NinteiResultDiv NinteiResult;
    @JsonProperty("linLine5")
    private HorizontalLine linLine5;
    @JsonProperty("txtNinteiShinseiKubunShinseiji")
    private TextBox txtNinteiShinseiKubunShinseiji;
    @JsonProperty("txtNinteiShinseiKubunHorei")
    private TextBox txtNinteiShinseiKubunHorei;
    @JsonProperty("txtYukokigen")
    private TextBoxFlexibleDate txtYukokigen;
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvShinseiJoho
     * @return DvShinseiJoho
     */
    @JsonProperty("DvShinseiJoho")
    public DvShinseiJohoDiv getDvShinseiJoho() {
        return DvShinseiJoho;
    }

    /*
     * setDvShinseiJoho
     * @param DvShinseiJoho DvShinseiJoho
     */
    @JsonProperty("DvShinseiJoho")
    public void setDvShinseiJoho(DvShinseiJohoDiv DvShinseiJoho) {
        this.DvShinseiJoho = DvShinseiJoho;
    }

    /*
     * getShiteiServiceIchiran
     * @return ShiteiServiceIchiran
     */
    @JsonProperty("ShiteiServiceIchiran")
    public ShiteiServiceIchiranDiv getShiteiServiceIchiran() {
        return ShiteiServiceIchiran;
    }

    /*
     * setShiteiServiceIchiran
     * @param ShiteiServiceIchiran ShiteiServiceIchiran
     */
    @JsonProperty("ShiteiServiceIchiran")
    public void setShiteiServiceIchiran(ShiteiServiceIchiranDiv ShiteiServiceIchiran) {
        this.ShiteiServiceIchiran = ShiteiServiceIchiran;
    }

    /*
     * getNinteichosa
     * @return Ninteichosa
     */
    @JsonProperty("Ninteichosa")
    public NinteichosaDiv getNinteichosa() {
        return Ninteichosa;
    }

    /*
     * setNinteichosa
     * @param Ninteichosa Ninteichosa
     */
    @JsonProperty("Ninteichosa")
    public void setNinteichosa(NinteichosaDiv Ninteichosa) {
        this.Ninteichosa = Ninteichosa;
    }

    /*
     * getlinLine4
     * @return linLine4
     */
    @JsonProperty("linLine4")
    public HorizontalLine getLinLine4() {
        return linLine4;
    }

    /*
     * setlinLine4
     * @param linLine4 linLine4
     */
    @JsonProperty("linLine4")
    public void setLinLine4(HorizontalLine linLine4) {
        this.linLine4 = linLine4;
    }

    /*
     * gettxtShinsakaiIken
     * @return txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    /*
     * settxtShinsakaiIken
     * @param txtShinsakaiIken txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken = txtShinsakaiIken;
    }

    /*
     * gettxtNinteiResultIdoJiyu
     * @return txtNinteiResultIdoJiyu
     */
    @JsonProperty("txtNinteiResultIdoJiyu")
    public TextBox getTxtNinteiResultIdoJiyu() {
        return txtNinteiResultIdoJiyu;
    }

    /*
     * settxtNinteiResultIdoJiyu
     * @param txtNinteiResultIdoJiyu txtNinteiResultIdoJiyu
     */
    @JsonProperty("txtNinteiResultIdoJiyu")
    public void setTxtNinteiResultIdoJiyu(TextBox txtNinteiResultIdoJiyu) {
        this.txtNinteiResultIdoJiyu = txtNinteiResultIdoJiyu;
    }

    /*
     * gettxtSakujoJiyu
     * @return txtSakujoJiyu
     */
    @JsonProperty("txtSakujoJiyu")
    public TextBox getTxtSakujoJiyu() {
        return txtSakujoJiyu;
    }

    /*
     * settxtSakujoJiyu
     * @param txtSakujoJiyu txtSakujoJiyu
     */
    @JsonProperty("txtSakujoJiyu")
    public void setTxtSakujoJiyu(TextBox txtSakujoJiyu) {
        this.txtSakujoJiyu = txtSakujoJiyu;
    }

    /*
     * gettxtRiyu
     * @return txtRiyu
     */
    @JsonProperty("txtRiyu")
    public TextBox getTxtRiyu() {
        return txtRiyu;
    }

    /*
     * settxtRiyu
     * @param txtRiyu txtRiyu
     */
    @JsonProperty("txtRiyu")
    public void setTxtRiyu(TextBox txtRiyu) {
        this.txtRiyu = txtRiyu;
    }

    /*
     * getlinIdoJiyu
     * @return linIdoJiyu
     */
    @JsonProperty("linIdoJiyu")
    public HorizontalLine getLinIdoJiyu() {
        return linIdoJiyu;
    }

    /*
     * setlinIdoJiyu
     * @param linIdoJiyu linIdoJiyu
     */
    @JsonProperty("linIdoJiyu")
    public void setLinIdoJiyu(HorizontalLine linIdoJiyu) {
        this.linIdoJiyu = linIdoJiyu;
    }

    /*
     * gettxtTokuteiShippei
     * @return txtTokuteiShippei
     */
    @JsonProperty("txtTokuteiShippei")
    public TextBox getTxtTokuteiShippei() {
        return txtTokuteiShippei;
    }

    /*
     * settxtTokuteiShippei
     * @param txtTokuteiShippei txtTokuteiShippei
     */
    @JsonProperty("txtTokuteiShippei")
    public void setTxtTokuteiShippei(TextBox txtTokuteiShippei) {
        this.txtTokuteiShippei = txtTokuteiShippei;
    }

    /*
     * gettxtNinteiSoshitsuYMD
     * @return txtNinteiSoshitsuYMD
     */
    @JsonProperty("txtNinteiSoshitsuYMD")
    public TextBoxFlexibleDate getTxtNinteiSoshitsuYMD() {
        return txtNinteiSoshitsuYMD;
    }

    /*
     * settxtNinteiSoshitsuYMD
     * @param txtNinteiSoshitsuYMD txtNinteiSoshitsuYMD
     */
    @JsonProperty("txtNinteiSoshitsuYMD")
    public void setTxtNinteiSoshitsuYMD(TextBoxFlexibleDate txtNinteiSoshitsuYMD) {
        this.txtNinteiSoshitsuYMD = txtNinteiSoshitsuYMD;
    }

    /*
     * gettxtTorikeshiYMD
     * @return txtTorikeshiYMD
     */
    @JsonProperty("txtTorikeshiYMD")
    public TextBoxFlexibleDate getTxtTorikeshiYMD() {
        return txtTorikeshiYMD;
    }

    /*
     * settxtTorikeshiYMD
     * @param txtTorikeshiYMD txtTorikeshiYMD
     */
    @JsonProperty("txtTorikeshiYMD")
    public void setTxtTorikeshiYMD(TextBoxFlexibleDate txtTorikeshiYMD) {
        this.txtTorikeshiYMD = txtTorikeshiYMD;
    }

    /*
     * getNinteiResult
     * @return NinteiResult
     */
    @JsonProperty("NinteiResult")
    public NinteiResultDiv getNinteiResult() {
        return NinteiResult;
    }

    /*
     * setNinteiResult
     * @param NinteiResult NinteiResult
     */
    @JsonProperty("NinteiResult")
    public void setNinteiResult(NinteiResultDiv NinteiResult) {
        this.NinteiResult = NinteiResult;
    }

    /*
     * getlinLine5
     * @return linLine5
     */
    @JsonProperty("linLine5")
    public HorizontalLine getLinLine5() {
        return linLine5;
    }

    /*
     * setlinLine5
     * @param linLine5 linLine5
     */
    @JsonProperty("linLine5")
    public void setLinLine5(HorizontalLine linLine5) {
        this.linLine5 = linLine5;
    }

    /*
     * gettxtNinteiShinseiKubunShinseiji
     * @return txtNinteiShinseiKubunShinseiji
     */
    @JsonProperty("txtNinteiShinseiKubunShinseiji")
    public TextBox getTxtNinteiShinseiKubunShinseiji() {
        return txtNinteiShinseiKubunShinseiji;
    }

    /*
     * settxtNinteiShinseiKubunShinseiji
     * @param txtNinteiShinseiKubunShinseiji txtNinteiShinseiKubunShinseiji
     */
    @JsonProperty("txtNinteiShinseiKubunShinseiji")
    public void setTxtNinteiShinseiKubunShinseiji(TextBox txtNinteiShinseiKubunShinseiji) {
        this.txtNinteiShinseiKubunShinseiji = txtNinteiShinseiKubunShinseiji;
    }

    /*
     * gettxtNinteiShinseiKubunHorei
     * @return txtNinteiShinseiKubunHorei
     */
    @JsonProperty("txtNinteiShinseiKubunHorei")
    public TextBox getTxtNinteiShinseiKubunHorei() {
        return txtNinteiShinseiKubunHorei;
    }

    /*
     * settxtNinteiShinseiKubunHorei
     * @param txtNinteiShinseiKubunHorei txtNinteiShinseiKubunHorei
     */
    @JsonProperty("txtNinteiShinseiKubunHorei")
    public void setTxtNinteiShinseiKubunHorei(TextBox txtNinteiShinseiKubunHorei) {
        this.txtNinteiShinseiKubunHorei = txtNinteiShinseiKubunHorei;
    }

    /*
     * gettxtYukokigen
     * @return txtYukokigen
     */
    @JsonProperty("txtYukokigen")
    public TextBoxFlexibleDate getTxtYukokigen() {
        return txtYukokigen;
    }

    /*
     * settxtYukokigen
     * @param txtYukokigen txtYukokigen
     */
    @JsonProperty("txtYukokigen")
    public void setTxtYukokigen(TextBoxFlexibleDate txtYukokigen) {
        this.txtYukokigen = txtYukokigen;
    }

    /*
     * gettxtKofuDate
     * @return txtKofuDate
     */
    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    /*
     * settxtKofuDate
     * @param txtKofuDate txtKofuDate
     */
    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate = txtKofuDate;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return this.getDvShinseiJoho().getTxtShinseiDate();
    }

    @JsonIgnore
    public void  setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.getDvShinseiJoho().setTxtShinseiDate(txtShinseiDate);
    }

    @JsonIgnore
    public TextBox getTxtShinseiShubetsu1() {
        return this.getDvShinseiJoho().getTxtShinseiShubetsu1();
    }

    @JsonIgnore
    public void  setTxtShinseiShubetsu1(TextBox txtShinseiShubetsu1) {
        this.getDvShinseiJoho().setTxtShinseiShubetsu1(txtShinseiShubetsu1);
    }

    @JsonIgnore
    public TextBox getTxtShinseiShubetsu2() {
        return this.getDvShinseiJoho().getTxtShinseiShubetsu2();
    }

    @JsonIgnore
    public void  setTxtShinseiShubetsu2(TextBox txtShinseiShubetsu2) {
        this.getDvShinseiJoho().setTxtShinseiShubetsu2(txtShinseiShubetsu2);
    }

    @JsonIgnore
    public TextBox getTxtShujiiMeisho() {
        return this.getDvShinseiJoho().getTxtShujiiMeisho();
    }

    @JsonIgnore
    public void  setTxtShujiiMeisho(TextBox txtShujiiMeisho) {
        this.getDvShinseiJoho().setTxtShujiiMeisho(txtShujiiMeisho);
    }

    @JsonIgnore
    public CheckBoxList getChkShiteii() {
        return this.getDvShinseiJoho().getChkShiteii();
    }

    @JsonIgnore
    public void  setChkShiteii(CheckBoxList chkShiteii) {
        this.getDvShinseiJoho().setChkShiteii(chkShiteii);
    }

    @JsonIgnore
    public TextBox getTxtShujiIryokikanMeisho() {
        return this.getDvShinseiJoho().getTxtShujiIryokikanMeisho();
    }

    @JsonIgnore
    public void  setTxtShujiIryokikanMeisho(TextBox txtShujiIryokikanMeisho) {
        this.getDvShinseiJoho().setTxtShujiIryokikanMeisho(txtShujiIryokikanMeisho);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaJokyo() {
        return this.getDvShinseiJoho().getBtnChosaJokyo();
    }

    @JsonIgnore
    public void  setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.getDvShinseiJoho().setBtnChosaJokyo(btnChosaJokyo);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsei() {
        return this.getDvShinseiJoho().getChkShinsei();
    }

    @JsonIgnore
    public void  setChkShinsei(CheckBoxList chkShinsei) {
        this.getDvShinseiJoho().setChkShinsei(chkShinsei);
    }

    @JsonIgnore
    public TextBox getTxtShinseisha() {
        return this.getDvShinseiJoho().getTxtShinseisha();
    }

    @JsonIgnore
    public void  setTxtShinseisha(TextBox txtShinseisha) {
        this.getDvShinseiJoho().setTxtShinseisha(txtShinseisha);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getDvShinseiJoho().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getDvShinseiJoho().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxCode getTxtYokaigodoCode() {
        return this.getDvShinseiJoho().getTxtYokaigodoCode();
    }

    @JsonIgnore
    public void  setTxtYokaigodoCode(TextBoxCode txtYokaigodoCode) {
        this.getDvShinseiJoho().setTxtYokaigodoCode(txtYokaigodoCode);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getDvShinseiJoho().getTxtYokaigodo();
    }

    @JsonIgnore
    public void  setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getDvShinseiJoho().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMD() {
        return this.getDvShinseiJoho().getTxtNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiYMD(TextBoxFlexibleDate txtNinteiYMD) {
        this.getDvShinseiJoho().setTxtNinteiYMD(txtNinteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtYukoKikan() {
        return this.getDvShinseiJoho().getTxtYukoKikan();
    }

    @JsonIgnore
    public void  setTxtYukoKikan(TextBoxDateRange txtYukoKikan) {
        this.getDvShinseiJoho().setTxtYukoKikan(txtYukoKikan);
    }

    // </editor-fold>
}
