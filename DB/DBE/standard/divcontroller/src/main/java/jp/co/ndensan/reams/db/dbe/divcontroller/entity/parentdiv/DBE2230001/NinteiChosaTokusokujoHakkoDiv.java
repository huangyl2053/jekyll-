package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaTokusokujoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaTokusokujoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HakkoJoken")
    private HakkoJokenDiv HakkoJoken;
    @JsonProperty("YokaigoNinteiChosaTokusokujo")
    private YokaigoNinteiChosaTokusokujoDiv YokaigoNinteiChosaTokusokujo;
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
     * getYokaigoNinteiChosaTokusokujo
     * @return YokaigoNinteiChosaTokusokujo
     */
    @JsonProperty("YokaigoNinteiChosaTokusokujo")
    public YokaigoNinteiChosaTokusokujoDiv getYokaigoNinteiChosaTokusokujo() {
        return YokaigoNinteiChosaTokusokujo;
    }

    /*
     * setYokaigoNinteiChosaTokusokujo
     * @param YokaigoNinteiChosaTokusokujo YokaigoNinteiChosaTokusokujo
     */
    @JsonProperty("YokaigoNinteiChosaTokusokujo")
    public void setYokaigoNinteiChosaTokusokujo(YokaigoNinteiChosaTokusokujoDiv YokaigoNinteiChosaTokusokujo) {
        this.YokaigoNinteiChosaTokusokujo = YokaigoNinteiChosaTokusokujo;
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
    public IHokenshaListDiv getCcdHokensha() {
        return this.getHakkoJoken().getCcdHokensha();
    }

    @JsonIgnore
    public RadioButton getRadChohyoSentaku() {
        return this.getHakkoJoken().getRadChohyoSentaku();
    }

    @JsonIgnore
    public void  setRadChohyoSentaku(RadioButton radChohyoSentaku) {
        this.getHakkoJoken().setRadChohyoSentaku(radChohyoSentaku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunDay() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtKijunDay();
    }

    @JsonIgnore
    public void  setTxtKijunDay(TextBoxFlexibleDate txtKijunDay) {
        this.getYokaigoNinteiChosaTokusokujo().setTxtKijunDay(txtKijunDay);
    }

    @JsonIgnore
    public TextBoxNum getTxtOverChosaIraiDay() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtOverChosaIraiDay();
    }

    @JsonIgnore
    public void  setTxtOverChosaIraiDay(TextBoxNum txtOverChosaIraiDay) {
        this.getYokaigoNinteiChosaTokusokujo().setTxtOverChosaIraiDay(txtOverChosaIraiDay);
    }

    @JsonIgnore
    public CheckBoxList getChkInsatsuzumiTaisho() {
        return this.getYokaigoNinteiChosaTokusokujo().getChkInsatsuzumiTaisho();
    }

    @JsonIgnore
    public void  setChkInsatsuzumiTaisho(CheckBoxList chkInsatsuzumiTaisho) {
        this.getYokaigoNinteiChosaTokusokujo().setChkInsatsuzumiTaisho(chkInsatsuzumiTaisho);
    }

    @JsonIgnore
    public CheckBoxList getChkHakkoRireki() {
        return this.getYokaigoNinteiChosaTokusokujo().getChkHakkoRireki();
    }

    @JsonIgnore
    public void  setChkHakkoRireki(CheckBoxList chkHakkoRireki) {
        this.getYokaigoNinteiChosaTokusokujo().setChkHakkoRireki(chkHakkoRireki);
    }

    @JsonIgnore
    public RadioButton getRadTokusokuHoho() {
        return this.getYokaigoNinteiChosaTokusokujo().getRadTokusokuHoho();
    }

    @JsonIgnore
    public void  setRadTokusokuHoho(RadioButton radTokusokuHoho) {
        this.getYokaigoNinteiChosaTokusokujo().setRadTokusokuHoho(radTokusokuHoho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokusokuMemo() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtTokusokuMemo();
    }

    @JsonIgnore
    public void  setTxtTokusokuMemo(TextBoxMultiLine txtTokusokuMemo) {
        this.getYokaigoNinteiChosaTokusokujo().setTxtTokusokuMemo(txtTokusokuMemo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakkoDay() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtHakkoDay();
    }

    @JsonIgnore
    public void  setTxtHakkoDay(TextBoxFlexibleDate txtHakkoDay) {
        this.getYokaigoNinteiChosaTokusokujo().setTxtHakkoDay(txtHakkoDay);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdItakusakiAndChosain() {
        return this.getYokaigoNinteiChosaTokusokujo().getCcdItakusakiAndChosain();
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
    public TextBoxDateRange getTxtInsatsuKikan() {
        return this.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan();
    }

    @JsonIgnore
    public void  setTxtInsatsuKikan(TextBoxDateRange txtInsatsuKikan) {
        this.getNinteiChosaTokusokuTaishoshaIchiranhyo().setTxtInsatsuKikan(txtInsatsuKikan);
    }

    // </editor-fold>
}
