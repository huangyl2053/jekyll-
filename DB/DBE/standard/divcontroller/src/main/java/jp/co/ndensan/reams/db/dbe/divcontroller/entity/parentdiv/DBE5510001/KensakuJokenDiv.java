package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKensakuHoho")
    private RadioButton radKensakuHoho;
    @JsonProperty("SerchFromHohokensha")
    private SerchFromHohokenshaDiv SerchFromHohokensha;
    @JsonProperty("SerchFromShinchokuJokyo")
    private SerchFromShinchokuJokyoDiv SerchFromShinchokuJokyo;
    @JsonProperty("KensakuOption")
    private KensakuOptionDiv KensakuOption;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKensakuHoho
     * @return radKensakuHoho
     */
    @JsonProperty("radKensakuHoho")
    public RadioButton getRadKensakuHoho() {
        return radKensakuHoho;
    }

    /*
     * setradKensakuHoho
     * @param radKensakuHoho radKensakuHoho
     */
    @JsonProperty("radKensakuHoho")
    public void setRadKensakuHoho(RadioButton radKensakuHoho) {
        this.radKensakuHoho = radKensakuHoho;
    }

    /*
     * getSerchFromHohokensha
     * @return SerchFromHohokensha
     */
    @JsonProperty("SerchFromHohokensha")
    public SerchFromHohokenshaDiv getSerchFromHohokensha() {
        return SerchFromHohokensha;
    }

    /*
     * setSerchFromHohokensha
     * @param SerchFromHohokensha SerchFromHohokensha
     */
    @JsonProperty("SerchFromHohokensha")
    public void setSerchFromHohokensha(SerchFromHohokenshaDiv SerchFromHohokensha) {
        this.SerchFromHohokensha = SerchFromHohokensha;
    }

    /*
     * getSerchFromShinchokuJokyo
     * @return SerchFromShinchokuJokyo
     */
    @JsonProperty("SerchFromShinchokuJokyo")
    public SerchFromShinchokuJokyoDiv getSerchFromShinchokuJokyo() {
        return SerchFromShinchokuJokyo;
    }

    /*
     * setSerchFromShinchokuJokyo
     * @param SerchFromShinchokuJokyo SerchFromShinchokuJokyo
     */
    @JsonProperty("SerchFromShinchokuJokyo")
    public void setSerchFromShinchokuJokyo(SerchFromShinchokuJokyoDiv SerchFromShinchokuJokyo) {
        this.SerchFromShinchokuJokyo = SerchFromShinchokuJokyo;
    }

    /*
     * getKensakuOption
     * @return KensakuOption
     */
    @JsonProperty("KensakuOption")
    public KensakuOptionDiv getKensakuOption() {
        return KensakuOption;
    }

    /*
     * setKensakuOption
     * @param KensakuOption KensakuOption
     */
    @JsonProperty("KensakuOption")
    public void setKensakuOption(KensakuOptionDiv KensakuOption) {
        this.KensakuOption = KensakuOption;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getSerchFromHohokensha().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getSerchFromHohokensha().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikibetsuCode() {
        return this.getSerchFromHohokensha().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.getSerchFromHohokensha().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getSerchFromHohokensha().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getSerchFromHohokensha().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public DropDownList getDdlNameMatchType() {
        return this.getSerchFromHohokensha().getDdlNameMatchType();
    }

    @JsonIgnore
    public void  setDdlNameMatchType(DropDownList ddlNameMatchType) {
        this.getSerchFromHohokensha().setDdlNameMatchType(ddlNameMatchType);
    }

    @JsonIgnore
    public HizukeRangeDiv getHizukeRange() {
        return this.getSerchFromShinchokuJokyo().getHizukeRange();
    }

    @JsonIgnore
    public void  setHizukeRange(HizukeRangeDiv HizukeRange) {
        this.getSerchFromShinchokuJokyo().setHizukeRange(HizukeRange);
    }

    @JsonIgnore
    public RadioButton getRadHizukeHani() {
        return this.getSerchFromShinchokuJokyo().getHizukeRange().getRadHizukeHani();
    }

    @JsonIgnore
    public void  setRadHizukeHani(RadioButton radHizukeHani) {
        this.getSerchFromShinchokuJokyo().getHizukeRange().setRadHizukeHani(radHizukeHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShiteiHizukeRange() {
        return this.getSerchFromShinchokuJokyo().getHizukeRange().getTxtShiteiHizukeRange();
    }

    @JsonIgnore
    public void  setTxtShiteiHizukeRange(TextBoxDateRange txtShiteiHizukeRange) {
        this.getSerchFromShinchokuJokyo().getHizukeRange().setTxtShiteiHizukeRange(txtShiteiHizukeRange);
    }

    @JsonIgnore
    public NinteiChosaDiv getNinteiChosa() {
        return this.getSerchFromShinchokuJokyo().getNinteiChosa();
    }

    @JsonIgnore
    public void  setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.getSerchFromShinchokuJokyo().setNinteiChosa(NinteiChosa);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIrai() {
        return this.getSerchFromShinchokuJokyo().getNinteiChosa().getChkNinteiChosaIrai();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIrai(CheckBoxList chkNinteiChosaIrai) {
        this.getSerchFromShinchokuJokyo().getNinteiChosa().setChkNinteiChosaIrai(chkNinteiChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaJisshi() {
        return this.getSerchFromShinchokuJokyo().getNinteiChosa().getChkNinteiChosaJisshi();
    }

    @JsonIgnore
    public void  setChkNinteiChosaJisshi(CheckBoxList chkNinteiChosaJisshi) {
        this.getSerchFromShinchokuJokyo().getNinteiChosa().setChkNinteiChosaJisshi(chkNinteiChosaJisshi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaTokki() {
        return this.getSerchFromShinchokuJokyo().getNinteiChosa().getChkNinteiChosaTokki();
    }

    @JsonIgnore
    public void  setChkNinteiChosaTokki(CheckBoxList chkNinteiChosaTokki) {
        this.getSerchFromShinchokuJokyo().getNinteiChosa().setChkNinteiChosaTokki(chkNinteiChosaTokki);
    }

    @JsonIgnore
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return this.getSerchFromShinchokuJokyo().getShujiiIkensho();
    }

    @JsonIgnore
    public void  setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.getSerchFromShinchokuJokyo().setShujiiIkensho(ShujiiIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoIrai() {
        return this.getSerchFromShinchokuJokyo().getShujiiIkensho().getChkShujiiIkenshoIrai();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoIrai(CheckBoxList chkShujiiIkenshoIrai) {
        this.getSerchFromShinchokuJokyo().getShujiiIkensho().setChkShujiiIkenshoIrai(chkShujiiIkenshoIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoJuryo() {
        return this.getSerchFromShinchokuJokyo().getShujiiIkensho().getChkShujiiIkenshoJuryo();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoJuryo(CheckBoxList chkShujiiIkenshoJuryo) {
        this.getSerchFromShinchokuJokyo().getShujiiIkensho().setChkShujiiIkenshoJuryo(chkShujiiIkenshoJuryo);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getSerchFromShinchokuJokyo().getShujiiIkensho().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getSerchFromShinchokuJokyo().getShujiiIkensho().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public IchijiHanteiDiv getIchijiHantei() {
        return this.getSerchFromShinchokuJokyo().getIchijiHantei();
    }

    @JsonIgnore
    public void  setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.getSerchFromShinchokuJokyo().setIchijiHantei(IchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHanteiKanryo() {
        return this.getSerchFromShinchokuJokyo().getIchijiHantei().getChkIchijiHanteiKanryo();
    }

    @JsonIgnore
    public void  setChkIchijiHanteiKanryo(CheckBoxList chkIchijiHanteiKanryo) {
        this.getSerchFromShinchokuJokyo().getIchijiHantei().setChkIchijiHanteiKanryo(chkIchijiHanteiKanryo);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getSerchFromShinchokuJokyo().getIchijiHantei().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getSerchFromShinchokuJokyo().getIchijiHantei().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getSerchFromShinchokuJokyo().getIchijiHantei().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getSerchFromShinchokuJokyo().getIchijiHantei().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public MaskingDiv getMasking() {
        return this.getSerchFromShinchokuJokyo().getMasking();
    }

    @JsonIgnore
    public void  setMasking(MaskingDiv Masking) {
        this.getSerchFromShinchokuJokyo().setMasking(Masking);
    }

    @JsonIgnore
    public CheckBoxList getChkMaskingKanryo() {
        return this.getSerchFromShinchokuJokyo().getMasking().getChkMaskingKanryo();
    }

    @JsonIgnore
    public void  setChkMaskingKanryo(CheckBoxList chkMaskingKanryo) {
        this.getSerchFromShinchokuJokyo().getMasking().setChkMaskingKanryo(chkMaskingKanryo);
    }

    @JsonIgnore
    public Space getSpSpace4() {
        return this.getSerchFromShinchokuJokyo().getMasking().getSpSpace4();
    }

    @JsonIgnore
    public void  setSpSpace4(Space spSpace4) {
        this.getSerchFromShinchokuJokyo().getMasking().setSpSpace4(spSpace4);
    }

    @JsonIgnore
    public Space getSpSpace5() {
        return this.getSerchFromShinchokuJokyo().getMasking().getSpSpace5();
    }

    @JsonIgnore
    public void  setSpSpace5(Space spSpace5) {
        this.getSerchFromShinchokuJokyo().getMasking().setSpSpace5(spSpace5);
    }

    @JsonIgnore
    public ShinsakaiDiv getShinsakai() {
        return this.getSerchFromShinchokuJokyo().getShinsakai();
    }

    @JsonIgnore
    public void  setShinsakai(ShinsakaiDiv Shinsakai) {
        this.getSerchFromShinchokuJokyo().setShinsakai(Shinsakai);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiWaritsuke() {
        return this.getSerchFromShinchokuJokyo().getShinsakai().getChkShinsakaiWaritsuke();
    }

    @JsonIgnore
    public void  setChkShinsakaiWaritsuke(CheckBoxList chkShinsakaiWaritsuke) {
        this.getSerchFromShinchokuJokyo().getShinsakai().setChkShinsakaiWaritsuke(chkShinsakaiWaritsuke);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiJisshi() {
        return this.getSerchFromShinchokuJokyo().getShinsakai().getChkShinsakaiJisshi();
    }

    @JsonIgnore
    public void  setChkShinsakaiJisshi(CheckBoxList chkShinsakaiJisshi) {
        this.getSerchFromShinchokuJokyo().getShinsakai().setChkShinsakaiJisshi(chkShinsakaiJisshi);
    }

    @JsonIgnore
    public Space getSpSpace6() {
        return this.getSerchFromShinchokuJokyo().getShinsakai().getSpSpace6();
    }

    @JsonIgnore
    public void  setSpSpace6(Space spSpace6) {
        this.getSerchFromShinchokuJokyo().getShinsakai().setSpSpace6(spSpace6);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaximumDisplayNumber() {
        return this.getKensakuOption().getTxtMaximumDisplayNumber();
    }

    @JsonIgnore
    public void  setTxtMaximumDisplayNumber(TextBoxNum txtMaximumDisplayNumber) {
        this.getKensakuOption().setTxtMaximumDisplayNumber(txtMaximumDisplayNumber);
    }

    @JsonIgnore
    public CheckBoxList getChkKensakuOption() {
        return this.getKensakuOption().getChkKensakuOption();
    }

    @JsonIgnore
    public void  setChkKensakuOption(CheckBoxList chkKensakuOption) {
        this.getKensakuOption().setChkKensakuOption(chkKensakuOption);
    }

    @JsonIgnore
    public Button getBtnConditionClear() {
        return this.getKensakuOption().getBtnConditionClear();
    }

    @JsonIgnore
    public void  setBtnConditionClear(Button btnConditionClear) {
        this.getKensakuOption().setBtnConditionClear(btnConditionClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuOption().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuOption().setBtnKensaku(btnKensaku);
    }

    // </editor-fold>
}
