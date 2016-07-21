package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001;
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
 * KoikinaiTenkyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikinaiTenkyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KoikinaiTenkyoTenkyomae")
    private KoikinaiTenkyoTenkyomaeDiv KoikinaiTenkyoTenkyomae;
    @JsonProperty("KoikinaiTenkyoTenkyosaki")
    private KoikinaiTenkyoTenkyosakiDiv KoikinaiTenkyoTenkyosaki;
    @JsonProperty("btnToroku")
    private Button btnToroku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKoikinaiTenkyoTenkyomae
     * @return KoikinaiTenkyoTenkyomae
     */
    @JsonProperty("KoikinaiTenkyoTenkyomae")
    public KoikinaiTenkyoTenkyomaeDiv getKoikinaiTenkyoTenkyomae() {
        return KoikinaiTenkyoTenkyomae;
    }

    /*
     * setKoikinaiTenkyoTenkyomae
     * @param KoikinaiTenkyoTenkyomae KoikinaiTenkyoTenkyomae
     */
    @JsonProperty("KoikinaiTenkyoTenkyomae")
    public void setKoikinaiTenkyoTenkyomae(KoikinaiTenkyoTenkyomaeDiv KoikinaiTenkyoTenkyomae) {
        this.KoikinaiTenkyoTenkyomae = KoikinaiTenkyoTenkyomae;
    }

    /*
     * getKoikinaiTenkyoTenkyosaki
     * @return KoikinaiTenkyoTenkyosaki
     */
    @JsonProperty("KoikinaiTenkyoTenkyosaki")
    public KoikinaiTenkyoTenkyosakiDiv getKoikinaiTenkyoTenkyosaki() {
        return KoikinaiTenkyoTenkyosaki;
    }

    /*
     * setKoikinaiTenkyoTenkyosaki
     * @param KoikinaiTenkyoTenkyosaki KoikinaiTenkyoTenkyosaki
     */
    @JsonProperty("KoikinaiTenkyoTenkyosaki")
    public void setKoikinaiTenkyoTenkyosaki(KoikinaiTenkyoTenkyosakiDiv KoikinaiTenkyoTenkyosaki) {
        this.KoikinaiTenkyoTenkyosaki = KoikinaiTenkyoTenkyosaki;
    }

    /*
     * getbtnToroku
     * @return btnToroku
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    /*
     * setbtnToroku
     * @param btnToroku btnToroku
     */
    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku = btnToroku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShokisaiHokenshaNo() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtShokisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokenshaNo(TextBox txtShokisaiHokenshaNo) {
        this.getKoikinaiTenkyoTenkyomae().setTxtShokisaiHokenshaNo(txtShokisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtShokisaiHokensha() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtShokisaiHokensha();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokensha(TextBox txtShokisaiHokensha) {
        this.getKoikinaiTenkyoTenkyomae().setTxtShokisaiHokensha(txtShokisaiHokensha);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getKoikinaiTenkyoTenkyomae().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getKoikinaiTenkyoTenkyomae().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJusho() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBox txtJusho) {
        this.getKoikinaiTenkyoTenkyomae().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBox getTxtSex() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtSex();
    }

    @JsonIgnore
    public void  setTxtSex(TextBox txtSex) {
        this.getKoikinaiTenkyoTenkyomae().setTxtSex(txtSex);
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthYMD() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtBirthYMD();
    }

    @JsonIgnore
    public void  setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.getKoikinaiTenkyoTenkyomae().setTxtBirthYMD(txtBirthYMD);
    }

    @JsonIgnore
    public TextBox getTxtAge() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtAge();
    }

    @JsonIgnore
    public void  setTxtAge(TextBox txtAge) {
        this.getKoikinaiTenkyoTenkyomae().setTxtAge(txtAge);
    }

    @JsonIgnore
    public TextBox getTxtTelNo() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBox txtTelNo) {
        this.getKoikinaiTenkyoTenkyomae().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBox getTxtYubinNo() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBox txtYubinNo) {
        this.getKoikinaiTenkyoTenkyomae().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtNijiHanteiKekka() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiKekka(TextBox txtNijiHanteiKekka) {
        this.getKoikinaiTenkyoTenkyomae().setTxtNijiHanteiKekka(txtNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBoxDate getTxtNijiHanteibi() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtNijiHanteibi();
    }

    @JsonIgnore
    public void  setTxtNijiHanteibi(TextBoxDate txtNijiHanteibi) {
        this.getKoikinaiTenkyoTenkyomae().setTxtNijiHanteibi(txtNijiHanteibi);
    }

    @JsonIgnore
    public TextBox getTxtNinteiYukoKikan() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtNinteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikan(TextBox txtNinteiYukoKikan) {
        this.getKoikinaiTenkyoTenkyomae().setTxtNinteiYukoKikan(txtNinteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukoKikanKaishiShuryo() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtNinteiYukoKikanKaishiShuryo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanKaishiShuryo(TextBoxDateRange txtNinteiYukoKikanKaishiShuryo) {
        this.getKoikinaiTenkyoTenkyomae().setTxtNinteiYukoKikanKaishiShuryo(txtNinteiYukoKikanKaishiShuryo);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiMeisho() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtNinteiChosaItakusakiMeisho();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiMeisho(TextBox txtNinteiChosaItakusakiMeisho) {
        this.getKoikinaiTenkyoTenkyomae().setTxtNinteiChosaItakusakiMeisho(txtNinteiChosaItakusakiMeisho);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getKoikinaiTenkyoTenkyomae().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryoKikanMeisho() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtShujiiIryoKikanMeisho();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanMeisho(TextBox txtShujiiIryoKikanMeisho) {
        this.getKoikinaiTenkyoTenkyomae().setTxtShujiiIryoKikanMeisho(txtShujiiIryoKikanMeisho);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getKoikinaiTenkyoTenkyomae().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public TextBox getTxtKaigoNinteiShinsakaiNo() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtKaigoNinteiShinsakaiNo();
    }

    @JsonIgnore
    public void  setTxtKaigoNinteiShinsakaiNo(TextBox txtKaigoNinteiShinsakaiNo) {
        this.getKoikinaiTenkyoTenkyomae().setTxtKaigoNinteiShinsakaiNo(txtKaigoNinteiShinsakaiNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiKaisabi() {
        return this.getKoikinaiTenkyoTenkyomae().getTxtKaigoNinteiShinsakaiKaisabi();
    }

    @JsonIgnore
    public void  setTxtKaigoNinteiShinsakaiKaisabi(TextBoxDate txtKaigoNinteiShinsakaiKaisabi) {
        this.getKoikinaiTenkyoTenkyomae().setTxtKaigoNinteiShinsakaiKaisabi(txtKaigoNinteiShinsakaiKaisabi);
    }

    @JsonIgnore
    public DropDownList getDdlShokisaiHokenshaNoSaki() {
        return this.getKoikinaiTenkyoTenkyosaki().getDdlShokisaiHokenshaNoSaki();
    }

    @JsonIgnore
    public void  setDdlShokisaiHokenshaNoSaki(DropDownList ddlShokisaiHokenshaNoSaki) {
        this.getKoikinaiTenkyoTenkyosaki().setDdlShokisaiHokenshaNoSaki(ddlShokisaiHokenshaNoSaki);
    }

    @JsonIgnore
    public TextBox getTxtShokisaiHokenshaSaki() {
        return this.getKoikinaiTenkyoTenkyosaki().getTxtShokisaiHokenshaSaki();
    }

    @JsonIgnore
    public void  setTxtShokisaiHokenshaSaki(TextBox txtShokisaiHokenshaSaki) {
        this.getKoikinaiTenkyoTenkyosaki().setTxtShokisaiHokenshaSaki(txtShokisaiHokenshaSaki);
    }

    // </editor-fold>
}
