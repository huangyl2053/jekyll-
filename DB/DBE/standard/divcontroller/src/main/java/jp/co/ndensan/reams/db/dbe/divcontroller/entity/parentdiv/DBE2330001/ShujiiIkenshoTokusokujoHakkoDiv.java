package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoTokusokujoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoTokusokujoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HakkoJoken")
    private HakkoJokenDiv HakkoJoken;
    @JsonProperty("ShujiiIkenshoTokusokujo")
    private ShujiiIkenshoTokusokujoDiv ShujiiIkenshoTokusokujo;
    @JsonProperty("NinteiChosaTokusokuTaishoshaIchiranhyo")
    private NinteiChosaTokusokuTaishoshaIchiranhyoDiv NinteiChosaTokusokuTaishoshaIchiranhyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHakkoJoken
     * @return HakkoJoken
     */
    @JsonProperty("HakkoJoken")
    public HakkoJokenDiv getHakkoJoken() {
        return HakkoJoken;
    }

    /*
     * setHakkoJoken
     * @param HakkoJoken HakkoJoken
     */
    @JsonProperty("HakkoJoken")
    public void setHakkoJoken(HakkoJokenDiv HakkoJoken) {
        this.HakkoJoken = HakkoJoken;
    }

    /*
     * getShujiiIkenshoTokusokujo
     * @return ShujiiIkenshoTokusokujo
     */
    @JsonProperty("ShujiiIkenshoTokusokujo")
    public ShujiiIkenshoTokusokujoDiv getShujiiIkenshoTokusokujo() {
        return ShujiiIkenshoTokusokujo;
    }

    /*
     * setShujiiIkenshoTokusokujo
     * @param ShujiiIkenshoTokusokujo ShujiiIkenshoTokusokujo
     */
    @JsonProperty("ShujiiIkenshoTokusokujo")
    public void setShujiiIkenshoTokusokujo(ShujiiIkenshoTokusokujoDiv ShujiiIkenshoTokusokujo) {
        this.ShujiiIkenshoTokusokujo = ShujiiIkenshoTokusokujo;
    }

    /*
     * getNinteiChosaTokusokuTaishoshaIchiranhyo
     * @return NinteiChosaTokusokuTaishoshaIchiranhyo
     */
    @JsonProperty("NinteiChosaTokusokuTaishoshaIchiranhyo")
    public NinteiChosaTokusokuTaishoshaIchiranhyoDiv getNinteiChosaTokusokuTaishoshaIchiranhyo() {
        return NinteiChosaTokusokuTaishoshaIchiranhyo;
    }

    /*
     * setNinteiChosaTokusokuTaishoshaIchiranhyo
     * @param NinteiChosaTokusokuTaishoshaIchiranhyo NinteiChosaTokusokuTaishoshaIchiranhyo
     */
    @JsonProperty("NinteiChosaTokusokuTaishoshaIchiranhyo")
    public void setNinteiChosaTokusokuTaishoshaIchiranhyo(NinteiChosaTokusokuTaishoshaIchiranhyoDiv NinteiChosaTokusokuTaishoshaIchiranhyo) {
        this.NinteiChosaTokusokuTaishoshaIchiranhyo = NinteiChosaTokusokuTaishoshaIchiranhyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChohyoSentaku() {
        return this.getHakkoJoken().getRadChohyoSentaku();
    }

    @JsonIgnore
    public void  setRadChohyoSentaku(RadioButton radChohyoSentaku) {
        this.getHakkoJoken().setRadChohyoSentaku(radChohyoSentaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getHakkoJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public TextBoxNum getTxtOverChosaIraiDay() {
        return this.getShujiiIkenshoTokusokujo().getTxtOverChosaIraiDay();
    }

    @JsonIgnore
    public void  setTxtOverChosaIraiDay(TextBoxNum txtOverChosaIraiDay) {
        this.getShujiiIkenshoTokusokujo().setTxtOverChosaIraiDay(txtOverChosaIraiDay);
    }

    @JsonIgnore
    public Label getLabOverChosaIraiDay() {
        return this.getShujiiIkenshoTokusokujo().getLabOverChosaIraiDay();
    }

    @JsonIgnore
    public void  setLabOverChosaIraiDay(Label labOverChosaIraiDay) {
        this.getShujiiIkenshoTokusokujo().setLabOverChosaIraiDay(labOverChosaIraiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDay() {
        return this.getShujiiIkenshoTokusokujo().getTxtKijunDay();
    }

    @JsonIgnore
    public void  setTxtKijunDay(TextBoxDate txtKijunDay) {
        this.getShujiiIkenshoTokusokujo().setTxtKijunDay(txtKijunDay);
    }

    @JsonIgnore
    public CheckBoxList getChkInsatsuzumiTaisho() {
        return this.getShujiiIkenshoTokusokujo().getChkInsatsuzumiTaisho();
    }

    @JsonIgnore
    public void  setChkInsatsuzumiTaisho(CheckBoxList chkInsatsuzumiTaisho) {
        this.getShujiiIkenshoTokusokujo().setChkInsatsuzumiTaisho(chkInsatsuzumiTaisho);
    }

    @JsonIgnore
    public RadioButton getRadTokusokuHoho() {
        return this.getShujiiIkenshoTokusokujo().getRadTokusokuHoho();
    }

    @JsonIgnore
    public void  setRadTokusokuHoho(RadioButton radTokusokuHoho) {
        this.getShujiiIkenshoTokusokujo().setRadTokusokuHoho(radTokusokuHoho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokusokuMemo() {
        return this.getShujiiIkenshoTokusokujo().getTxtTokusokuMemo();
    }

    @JsonIgnore
    public void  setTxtTokusokuMemo(TextBoxMultiLine txtTokusokuMemo) {
        this.getShujiiIkenshoTokusokujo().setTxtTokusokuMemo(txtTokusokuMemo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkoDay() {
        return this.getShujiiIkenshoTokusokujo().getTxtHakkoDay();
    }

    @JsonIgnore
    public void  setTxtHakkoDay(TextBoxDate txtHakkoDay) {
        this.getShujiiIkenshoTokusokujo().setTxtHakkoDay(txtHakkoDay);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdIryokikanShujii() {
        return this.getShujiiIkenshoTokusokujo().getCcdIryokikanShujii();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return this.getShujiiIkenshoTokusokujo().getCcdBunshoNo();
    }

    @JsonIgnore
    public CheckBoxList getChkInsatsuChohyo() {
        return this.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo();
    }

    @JsonIgnore
    public void  setChkInsatsuChohyo(CheckBoxList chkInsatsuChohyo) {
        this.getNinteiChosaTokusokuTaishoshaIchiranhyo().setChkInsatsuChohyo(chkInsatsuChohyo);
    }

    @JsonIgnore
    public CheckBoxList getChkCSVShutsuryoku() {
        return this.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkCSVShutsuryoku();
    }

    @JsonIgnore
    public void  setChkCSVShutsuryoku(CheckBoxList chkCSVShutsuryoku) {
        this.getNinteiChosaTokusokuTaishoshaIchiranhyo().setChkCSVShutsuryoku(chkCSVShutsuryoku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtInsatsuKikan() {
        return this.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan();
    }

    @JsonIgnore
    public void  setTxtInsatsuKikan(TextBoxDateRange txtInsatsuKikan) {
        this.getNinteiChosaTokusokuTaishoshaIchiranhyo().setTxtInsatsuKikan(txtInsatsuKikan);
    }

    // </editor-fold>
}
