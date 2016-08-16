package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003;
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
 * shoSaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class shoSaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbYear")
    private TextBox tbYear;
    @JsonProperty("tbNenkinHokenshaCode")
    private TextBox tbNenkinHokenshaCode;
    @JsonProperty("tbKisoNenkinNo")
    private TextBox tbKisoNenkinNo;
    @JsonProperty("tbNenkinCode")
    private TextBox tbNenkinCode;
    @JsonProperty("btnDisplay")
    private Button btnDisplay;
    @JsonProperty("BtnDelete")
    private Button BtnDelete;
    @JsonProperty("NaiyoArea")
    private NaiyoAreaDiv NaiyoArea;
    @JsonProperty("NenkinJohoTukiaiKeyArea")
    private NenkinJohoTukiaiKeyAreaDiv NenkinJohoTukiaiKeyArea;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbYear
     * @return tbYear
     */
    @JsonProperty("tbYear")
    public TextBox getTbYear() {
        return tbYear;
    }

    /*
     * settbYear
     * @param tbYear tbYear
     */
    @JsonProperty("tbYear")
    public void setTbYear(TextBox tbYear) {
        this.tbYear = tbYear;
    }

    /*
     * gettbNenkinHokenshaCode
     * @return tbNenkinHokenshaCode
     */
    @JsonProperty("tbNenkinHokenshaCode")
    public TextBox getTbNenkinHokenshaCode() {
        return tbNenkinHokenshaCode;
    }

    /*
     * settbNenkinHokenshaCode
     * @param tbNenkinHokenshaCode tbNenkinHokenshaCode
     */
    @JsonProperty("tbNenkinHokenshaCode")
    public void setTbNenkinHokenshaCode(TextBox tbNenkinHokenshaCode) {
        this.tbNenkinHokenshaCode = tbNenkinHokenshaCode;
    }

    /*
     * gettbKisoNenkinNo
     * @return tbKisoNenkinNo
     */
    @JsonProperty("tbKisoNenkinNo")
    public TextBox getTbKisoNenkinNo() {
        return tbKisoNenkinNo;
    }

    /*
     * settbKisoNenkinNo
     * @param tbKisoNenkinNo tbKisoNenkinNo
     */
    @JsonProperty("tbKisoNenkinNo")
    public void setTbKisoNenkinNo(TextBox tbKisoNenkinNo) {
        this.tbKisoNenkinNo = tbKisoNenkinNo;
    }

    /*
     * gettbNenkinCode
     * @return tbNenkinCode
     */
    @JsonProperty("tbNenkinCode")
    public TextBox getTbNenkinCode() {
        return tbNenkinCode;
    }

    /*
     * settbNenkinCode
     * @param tbNenkinCode tbNenkinCode
     */
    @JsonProperty("tbNenkinCode")
    public void setTbNenkinCode(TextBox tbNenkinCode) {
        this.tbNenkinCode = tbNenkinCode;
    }

    /*
     * getbtnDisplay
     * @return btnDisplay
     */
    @JsonProperty("btnDisplay")
    public Button getBtnDisplay() {
        return btnDisplay;
    }

    /*
     * setbtnDisplay
     * @param btnDisplay btnDisplay
     */
    @JsonProperty("btnDisplay")
    public void setBtnDisplay(Button btnDisplay) {
        this.btnDisplay = btnDisplay;
    }

    /*
     * getBtnDelete
     * @return BtnDelete
     */
    @JsonProperty("BtnDelete")
    public Button getBtnDelete() {
        return BtnDelete;
    }

    /*
     * setBtnDelete
     * @param BtnDelete BtnDelete
     */
    @JsonProperty("BtnDelete")
    public void setBtnDelete(Button BtnDelete) {
        this.BtnDelete = BtnDelete;
    }

    /*
     * getNaiyoArea
     * @return NaiyoArea
     */
    @JsonProperty("NaiyoArea")
    public NaiyoAreaDiv getNaiyoArea() {
        return NaiyoArea;
    }

    /*
     * setNaiyoArea
     * @param NaiyoArea NaiyoArea
     */
    @JsonProperty("NaiyoArea")
    public void setNaiyoArea(NaiyoAreaDiv NaiyoArea) {
        this.NaiyoArea = NaiyoArea;
    }

    /*
     * getNenkinJohoTukiaiKeyArea
     * @return NenkinJohoTukiaiKeyArea
     */
    @JsonProperty("NenkinJohoTukiaiKeyArea")
    public NenkinJohoTukiaiKeyAreaDiv getNenkinJohoTukiaiKeyArea() {
        return NenkinJohoTukiaiKeyArea;
    }

    /*
     * setNenkinJohoTukiaiKeyArea
     * @param NenkinJohoTukiaiKeyArea NenkinJohoTukiaiKeyArea
     */
    @JsonProperty("NenkinJohoTukiaiKeyArea")
    public void setNenkinJohoTukiaiKeyArea(NenkinJohoTukiaiKeyAreaDiv NenkinJohoTukiaiKeyArea) {
        this.NenkinJohoTukiaiKeyArea = NenkinJohoTukiaiKeyArea;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxMultiLine getTbNenKinHokenshaName() {
        return this.getNaiyoArea().getTbNenKinHokenshaName();
    }

    @JsonIgnore
    public void  setTbNenKinHokenshaName(TextBoxMultiLine tbNenKinHokenshaName) {
        this.getNaiyoArea().setTbNenKinHokenshaName(tbNenKinHokenshaName);
    }

    @JsonIgnore
    public TextBox getTbGenkisoNenkinNo() {
        return this.getNaiyoArea().getTbGenkisoNenkinNo();
    }

    @JsonIgnore
    public void  setTbGenkisoNenkinNo(TextBox tbGenkisoNenkinNo) {
        this.getNaiyoArea().setTbGenkisoNenkinNo(tbGenkisoNenkinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTbTaishoNenKin() {
        return this.getNaiyoArea().getTbTaishoNenKin();
    }

    @JsonIgnore
    public void  setTbTaishoNenKin(TextBoxMultiLine tbTaishoNenKin) {
        this.getNaiyoArea().setTbTaishoNenKin(tbTaishoNenKin);
    }

    @JsonIgnore
    public DropDownList getDdlTsuki() {
        return this.getNaiyoArea().getDdlTsuki();
    }

    @JsonIgnore
    public void  setDdlTsuki(DropDownList ddlTsuki) {
        this.getNaiyoArea().setDdlTsuki(ddlTsuki);
    }

    @JsonIgnore
    public TextBoxNum getTbKingaku() {
        return this.getNaiyoArea().getTbKingaku();
    }

    @JsonIgnore
    public void  setTbKingaku(TextBoxNum tbKingaku) {
        this.getNaiyoArea().setTbKingaku(tbKingaku);
    }

    @JsonIgnore
    public TextBoxDate getTbCreateDate() {
        return this.getNaiyoArea().getTbCreateDate();
    }

    @JsonIgnore
    public void  setTbCreateDate(TextBoxDate tbCreateDate) {
        this.getNaiyoArea().setTbCreateDate(tbCreateDate);
    }

    @JsonIgnore
    public TextBox getTbTaishoNen() {
        return this.getNaiyoArea().getTbTaishoNen();
    }

    @JsonIgnore
    public void  setTbTaishoNen(TextBox tbTaishoNen) {
        this.getNaiyoArea().setTbTaishoNen(tbTaishoNen);
    }

    @JsonIgnore
    public TextBox getTbLoadCata() {
        return this.getNaiyoArea().getTbLoadCata();
    }

    @JsonIgnore
    public void  setTbLoadCata(TextBox tbLoadCata) {
        this.getNaiyoArea().setTbLoadCata(tbLoadCata);
    }

    @JsonIgnore
    public TextBox getTbNameKana() {
        return this.getNenkinJohoTukiaiKeyArea().getTbNameKana();
    }

    @JsonIgnore
    public void  setTbNameKana(TextBox tbNameKana) {
        this.getNenkinJohoTukiaiKeyArea().setTbNameKana(tbNameKana);
    }

    @JsonIgnore
    public DropDownList getDdlSex() {
        return this.getNenkinJohoTukiaiKeyArea().getDdlSex();
    }

    @JsonIgnore
    public void  setDdlSex(DropDownList ddlSex) {
        this.getNenkinJohoTukiaiKeyArea().setDdlSex(ddlSex);
    }

    @JsonIgnore
    public TextBoxDate getTbBirthday() {
        return this.getNenkinJohoTukiaiKeyArea().getTbBirthday();
    }

    @JsonIgnore
    public void  setTbBirthday(TextBoxDate tbBirthday) {
        this.getNenkinJohoTukiaiKeyArea().setTbBirthday(tbBirthday);
    }

    @JsonIgnore
    public TextBox getTbNameKanji() {
        return this.getNenkinJohoTukiaiKeyArea().getTbNameKanji();
    }

    @JsonIgnore
    public void  setTbNameKanji(TextBox tbNameKanji) {
        this.getNenkinJohoTukiaiKeyArea().setTbNameKanji(tbNameKanji);
    }

    @JsonIgnore
    public TextBox getTbAddressKana() {
        return this.getNenkinJohoTukiaiKeyArea().getTbAddressKana();
    }

    @JsonIgnore
    public void  setTbAddressKana(TextBox tbAddressKana) {
        this.getNenkinJohoTukiaiKeyArea().setTbAddressKana(tbAddressKana);
    }

    @JsonIgnore
    public TextBox getTbAddressKanji() {
        return this.getNenkinJohoTukiaiKeyArea().getTbAddressKanji();
    }

    @JsonIgnore
    public void  setTbAddressKanji(TextBox tbAddressKanji) {
        this.getNenkinJohoTukiaiKeyArea().setTbAddressKanji(tbAddressKanji);
    }

    // </editor-fold>
}
