package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001;
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
 * SerchFromShinchokuJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SerchFromShinchokuJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HizukeRange")
    private HizukeRangeDiv HizukeRange;
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("ShujiiIkensho")
    private ShujiiIkenshoDiv ShujiiIkensho;
    @JsonProperty("IchijiHantei")
    private IchijiHanteiDiv IchijiHantei;
    @JsonProperty("Masking")
    private MaskingDiv Masking;
    @JsonProperty("Shinsakai")
    private ShinsakaiDiv Shinsakai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHizukeRange
     * @return HizukeRange
     */
    @JsonProperty("HizukeRange")
    public HizukeRangeDiv getHizukeRange() {
        return HizukeRange;
    }

    /*
     * setHizukeRange
     * @param HizukeRange HizukeRange
     */
    @JsonProperty("HizukeRange")
    public void setHizukeRange(HizukeRangeDiv HizukeRange) {
        this.HizukeRange = HizukeRange;
    }

    /*
     * getNinteiChosa
     * @return NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    /*
     * setNinteiChosa
     * @param NinteiChosa NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa = NinteiChosa;
    }

    /*
     * getShujiiIkensho
     * @return ShujiiIkensho
     */
    @JsonProperty("ShujiiIkensho")
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return ShujiiIkensho;
    }

    /*
     * setShujiiIkensho
     * @param ShujiiIkensho ShujiiIkensho
     */
    @JsonProperty("ShujiiIkensho")
    public void setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.ShujiiIkensho = ShujiiIkensho;
    }

    /*
     * getIchijiHantei
     * @return IchijiHantei
     */
    @JsonProperty("IchijiHantei")
    public IchijiHanteiDiv getIchijiHantei() {
        return IchijiHantei;
    }

    /*
     * setIchijiHantei
     * @param IchijiHantei IchijiHantei
     */
    @JsonProperty("IchijiHantei")
    public void setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.IchijiHantei = IchijiHantei;
    }

    /*
     * getMasking
     * @return Masking
     */
    @JsonProperty("Masking")
    public MaskingDiv getMasking() {
        return Masking;
    }

    /*
     * setMasking
     * @param Masking Masking
     */
    @JsonProperty("Masking")
    public void setMasking(MaskingDiv Masking) {
        this.Masking = Masking;
    }

    /*
     * getShinsakai
     * @return Shinsakai
     */
    @JsonProperty("Shinsakai")
    public ShinsakaiDiv getShinsakai() {
        return Shinsakai;
    }

    /*
     * setShinsakai
     * @param Shinsakai Shinsakai
     */
    @JsonProperty("Shinsakai")
    public void setShinsakai(ShinsakaiDiv Shinsakai) {
        this.Shinsakai = Shinsakai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHizukeHani() {
        return this.getHizukeRange().getRadHizukeHani();
    }

    @JsonIgnore
    public void  setRadHizukeHani(RadioButton radHizukeHani) {
        this.getHizukeRange().setRadHizukeHani(radHizukeHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShiteiHizukeRange() {
        return this.getHizukeRange().getTxtShiteiHizukeRange();
    }

    @JsonIgnore
    public void  setTxtShiteiHizukeRange(TextBoxDateRange txtShiteiHizukeRange) {
        this.getHizukeRange().setTxtShiteiHizukeRange(txtShiteiHizukeRange);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIrai() {
        return this.getNinteiChosa().getChkNinteiChosaIrai();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIrai(CheckBoxList chkNinteiChosaIrai) {
        this.getNinteiChosa().setChkNinteiChosaIrai(chkNinteiChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaJisshi() {
        return this.getNinteiChosa().getChkNinteiChosaJisshi();
    }

    @JsonIgnore
    public void  setChkNinteiChosaJisshi(CheckBoxList chkNinteiChosaJisshi) {
        this.getNinteiChosa().setChkNinteiChosaJisshi(chkNinteiChosaJisshi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaTokki() {
        return this.getNinteiChosa().getChkNinteiChosaTokki();
    }

    @JsonIgnore
    public void  setChkNinteiChosaTokki(CheckBoxList chkNinteiChosaTokki) {
        this.getNinteiChosa().setChkNinteiChosaTokki(chkNinteiChosaTokki);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoIrai() {
        return this.getShujiiIkensho().getChkShujiiIkenshoIrai();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoIrai(CheckBoxList chkShujiiIkenshoIrai) {
        this.getShujiiIkensho().setChkShujiiIkenshoIrai(chkShujiiIkenshoIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoJuryo() {
        return this.getShujiiIkensho().getChkShujiiIkenshoJuryo();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoJuryo(CheckBoxList chkShujiiIkenshoJuryo) {
        this.getShujiiIkensho().setChkShujiiIkenshoJuryo(chkShujiiIkenshoJuryo);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getShujiiIkensho().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getShujiiIkensho().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHanteiKanryo() {
        return this.getIchijiHantei().getChkIchijiHanteiKanryo();
    }

    @JsonIgnore
    public void  setChkIchijiHanteiKanryo(CheckBoxList chkIchijiHanteiKanryo) {
        this.getIchijiHantei().setChkIchijiHanteiKanryo(chkIchijiHanteiKanryo);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getIchijiHantei().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getIchijiHantei().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getIchijiHantei().getSpSpace3();
    }

    @JsonIgnore
    public void  setSpSpace3(Space spSpace3) {
        this.getIchijiHantei().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public CheckBoxList getChkMaskingKanryo() {
        return this.getMasking().getChkMaskingKanryo();
    }

    @JsonIgnore
    public void  setChkMaskingKanryo(CheckBoxList chkMaskingKanryo) {
        this.getMasking().setChkMaskingKanryo(chkMaskingKanryo);
    }

    @JsonIgnore
    public Space getSpSpace4() {
        return this.getMasking().getSpSpace4();
    }

    @JsonIgnore
    public void  setSpSpace4(Space spSpace4) {
        this.getMasking().setSpSpace4(spSpace4);
    }

    @JsonIgnore
    public Space getSpSpace5() {
        return this.getMasking().getSpSpace5();
    }

    @JsonIgnore
    public void  setSpSpace5(Space spSpace5) {
        this.getMasking().setSpSpace5(spSpace5);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiWaritsuke() {
        return this.getShinsakai().getChkShinsakaiWaritsuke();
    }

    @JsonIgnore
    public void  setChkShinsakaiWaritsuke(CheckBoxList chkShinsakaiWaritsuke) {
        this.getShinsakai().setChkShinsakaiWaritsuke(chkShinsakaiWaritsuke);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsakaiJisshi() {
        return this.getShinsakai().getChkShinsakaiJisshi();
    }

    @JsonIgnore
    public void  setChkShinsakaiJisshi(CheckBoxList chkShinsakaiJisshi) {
        this.getShinsakai().setChkShinsakaiJisshi(chkShinsakaiJisshi);
    }

    @JsonIgnore
    public Space getSpSpace6() {
        return this.getShinsakai().getSpSpace6();
    }

    @JsonIgnore
    public void  setSpSpace6(Space spSpace6) {
        this.getShinsakai().setSpSpace6(spSpace6);
    }

    // </editor-fold>
}
