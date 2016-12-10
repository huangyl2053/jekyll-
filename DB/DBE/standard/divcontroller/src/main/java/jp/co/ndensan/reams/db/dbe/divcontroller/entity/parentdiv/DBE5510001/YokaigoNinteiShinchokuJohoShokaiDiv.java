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
 * YokaigoNinteiShinchokuJohoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigoNinteiShinchokuJohoShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShinseiJohoIchiran")
    private ShinseiJohoIchiranDiv ShinseiJohoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getShinseiJohoIchiran
     * @return ShinseiJohoIchiran
     */
    @JsonProperty("ShinseiJohoIchiran")
    public ShinseiJohoIchiranDiv getShinseiJohoIchiran() {
        return ShinseiJohoIchiran;
    }

    /*
     * setShinseiJohoIchiran
     * @param ShinseiJohoIchiran ShinseiJohoIchiran
     */
    @JsonProperty("ShinseiJohoIchiran")
    public void setShinseiJohoIchiran(ShinseiJohoIchiranDiv ShinseiJohoIchiran) {
        this.ShinseiJohoIchiran = ShinseiJohoIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKensakuHoho() {
        return this.getKensakuJoken().getRadKensakuHoho();
    }

    @JsonIgnore
    public void  setRadKensakuHoho(RadioButton radKensakuHoho) {
        this.getKensakuJoken().setRadKensakuHoho(radKensakuHoho);
    }

    @JsonIgnore
    public SerchFromHohokenshaDiv getSerchFromHohokensha() {
        return this.getKensakuJoken().getSerchFromHohokensha();
    }

    @JsonIgnore
    public void  setSerchFromHohokensha(SerchFromHohokenshaDiv SerchFromHohokensha) {
        this.getKensakuJoken().setSerchFromHohokensha(SerchFromHohokensha);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getKensakuJoken().getSerchFromHohokensha().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getKensakuJoken().getSerchFromHohokensha().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtShikibetsuCode() {
        return this.getKensakuJoken().getSerchFromHohokensha().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.getKensakuJoken().getSerchFromHohokensha().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getKensakuJoken().getSerchFromHohokensha().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getKensakuJoken().getSerchFromHohokensha().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public DropDownList getDdlNameMatchType() {
        return this.getKensakuJoken().getSerchFromHohokensha().getDdlNameMatchType();
    }

    @JsonIgnore
    public void  setDdlNameMatchType(DropDownList ddlNameMatchType) {
        this.getKensakuJoken().getSerchFromHohokensha().setDdlNameMatchType(ddlNameMatchType);
    }

    @JsonIgnore
    public SerchFromShinchokuJokyoDiv getSerchFromShinchokuJokyo() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo();
    }

    @JsonIgnore
    public void  setSerchFromShinchokuJokyo(SerchFromShinchokuJokyoDiv SerchFromShinchokuJokyo) {
        this.getKensakuJoken().setSerchFromShinchokuJokyo(SerchFromShinchokuJokyo);
    }

    @JsonIgnore
    public HizukeRangeDiv getHizukeRange() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getHizukeRange();
    }

    @JsonIgnore
    public void  setHizukeRange(HizukeRangeDiv HizukeRange) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().setHizukeRange(HizukeRange);
    }

    @JsonIgnore
    public RadioButton getRadHizukeHani() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getHizukeRange().getRadHizukeHani();
    }

    @JsonIgnore
    public void  setRadHizukeHani(RadioButton radHizukeHani) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getHizukeRange().setRadHizukeHani(radHizukeHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShiteiHizukeRange() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getHizukeRange().getTxtShiteiHizukeRange();
    }

    @JsonIgnore
    public void  setTxtShiteiHizukeRange(TextBoxDateRange txtShiteiHizukeRange) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getHizukeRange().setTxtShiteiHizukeRange(txtShiteiHizukeRange);
    }

    @JsonIgnore
    public NinteiChosaDiv getNinteiChosa() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getNinteiChosa();
    }

    @JsonIgnore
    public void  setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().setNinteiChosa(NinteiChosa);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIrai() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getNinteiChosa().getChkNinteiChosaIrai();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIrai(CheckBoxList chkNinteiChosaIrai) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getNinteiChosa().setChkNinteiChosaIrai(chkNinteiChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaJisshi() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getNinteiChosa().getChkNinteiChosaJisshi();
    }

    @JsonIgnore
    public void  setChkNinteiChosaJisshi(CheckBoxList chkNinteiChosaJisshi) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getNinteiChosa().setChkNinteiChosaJisshi(chkNinteiChosaJisshi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaTokki() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getNinteiChosa().getChkNinteiChosaTokki();
    }

    @JsonIgnore
    public void  setChkNinteiChosaTokki(CheckBoxList chkNinteiChosaTokki) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getNinteiChosa().setChkNinteiChosaTokki(chkNinteiChosaTokki);
    }

    @JsonIgnore
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShujiiIkensho();
    }

    @JsonIgnore
    public void  setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().setShujiiIkensho(ShujiiIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoIrai() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShujiiIkensho().getChkShujiiIkenshoIrai();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoIrai(CheckBoxList chkShujiiIkenshoIrai) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getShujiiIkensho().setChkShujiiIkenshoIrai(chkShujiiIkenshoIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoJuryo() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShujiiIkensho().getChkShujiiIkenshoJuryo();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoJuryo(CheckBoxList chkShujiiIkenshoJuryo) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getShujiiIkensho().setChkShujiiIkenshoJuryo(chkShujiiIkenshoJuryo);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShujiiIkensho().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getShujiiIkensho().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public IchijiHanteiDiv getIchijiHantei() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getIchijiHantei();
    }

    @JsonIgnore
    public void  setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().setIchijiHantei(IchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHanteiKanryo() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getIchijiHantei().getChkIchijiHanteiKanryo();
    }

    @JsonIgnore
    public void  setChkIchijiHanteiKanryo(CheckBoxList chkIchijiHanteiKanryo) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getIchijiHantei().setChkIchijiHanteiKanryo(chkIchijiHanteiKanryo);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getIchijiHantei().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getIchijiHantei().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getIchijiHantei().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getIchijiHantei().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public MaskingDiv getMasking() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getMasking();
    }

    @JsonIgnore
    public void  setMasking(MaskingDiv Masking) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().setMasking(Masking);
    }

    @JsonIgnore
    public CheckBoxList getChkMaskingKanryo() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getMasking().getChkMaskingKanryo();
    }

    @JsonIgnore
    public void  setChkMaskingKanryo(CheckBoxList chkMaskingKanryo) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getMasking().setChkMaskingKanryo(chkMaskingKanryo);
    }

    @JsonIgnore
    public Space getSpSpace4() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getMasking().getSpSpace4();
    }

    @JsonIgnore
    public void  setSpSpace4(Space spSpace4) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getMasking().setSpSpace4(spSpace4);
    }

    @JsonIgnore
    public Space getSpSpace5() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getMasking().getSpSpace5();
    }

    @JsonIgnore
    public void  setSpSpace5(Space spSpace5) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getMasking().setSpSpace5(spSpace5);
    }

    @JsonIgnore
    public ShinsakaiDiv getShinsakai() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShinsakai();
    }

    @JsonIgnore
    public void  setShinsakai(ShinsakaiDiv Shinsakai) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().setShinsakai(Shinsakai);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiWaritsuke() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShinsakai().getChkShinsakaiWaritsuke();
    }

    @JsonIgnore
    public void  setChkShinsakaiWaritsuke(CheckBoxList chkShinsakaiWaritsuke) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getShinsakai().setChkShinsakaiWaritsuke(chkShinsakaiWaritsuke);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiJisshi() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShinsakai().getChkShinsakaiJisshi();
    }

    @JsonIgnore
    public void  setChkShinsakaiJisshi(CheckBoxList chkShinsakaiJisshi) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getShinsakai().setChkShinsakaiJisshi(chkShinsakaiJisshi);
    }

    @JsonIgnore
    public Space getSpSpace6() {
        return this.getKensakuJoken().getSerchFromShinchokuJokyo().getShinsakai().getSpSpace6();
    }

    @JsonIgnore
    public void  setSpSpace6(Space spSpace6) {
        this.getKensakuJoken().getSerchFromShinchokuJokyo().getShinsakai().setSpSpace6(spSpace6);
    }

    @JsonIgnore
    public KensakuOptionDiv getKensakuOption() {
        return this.getKensakuJoken().getKensakuOption();
    }

    @JsonIgnore
    public void  setKensakuOption(KensakuOptionDiv KensakuOption) {
        this.getKensakuJoken().setKensakuOption(KensakuOption);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaximumDisplayNumber() {
        return this.getKensakuJoken().getKensakuOption().getTxtMaximumDisplayNumber();
    }

    @JsonIgnore
    public void  setTxtMaximumDisplayNumber(TextBoxNum txtMaximumDisplayNumber) {
        this.getKensakuJoken().getKensakuOption().setTxtMaximumDisplayNumber(txtMaximumDisplayNumber);
    }

    @JsonIgnore
    public CheckBoxList getChkKensakuOption() {
        return this.getKensakuJoken().getKensakuOption().getChkKensakuOption();
    }

    @JsonIgnore
    public void  setChkKensakuOption(CheckBoxList chkKensakuOption) {
        this.getKensakuJoken().getKensakuOption().setChkKensakuOption(chkKensakuOption);
    }

    @JsonIgnore
    public Button getBtnConditionClear() {
        return this.getKensakuJoken().getKensakuOption().getBtnConditionClear();
    }

    @JsonIgnore
    public void  setBtnConditionClear(Button btnConditionClear) {
        this.getKensakuJoken().getKensakuOption().setBtnConditionClear(btnConditionClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getKensakuOption().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().getKensakuOption().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getKensakuJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgShinseiJoho_Row> getDgShinseiJoho() {
        return this.getShinseiJohoIchiran().getDgShinseiJoho();
    }

    @JsonIgnore
    public void  setDgShinseiJoho(DataGrid<dgShinseiJoho_Row> dgShinseiJoho) {
        this.getShinseiJohoIchiran().setDgShinseiJoho(dgShinseiJoho);
    }

    // </editor-fold>
}
