package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * NinteiChosaTokusokujoHakko のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosaTokusokujoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

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
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlHokensha() {
        return this.getHakkoJoken().getDdlHokensha();
    }

    @JsonIgnore
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.getHakkoJoken().setDdlHokensha(ddlHokensha);
    }

    @JsonIgnore
    public RadioButton getRadChohyoSentaku() {
        return this.getHakkoJoken().getRadChohyoSentaku();
    }

    @JsonIgnore
    public void setRadChohyoSentaku(RadioButton radChohyoSentaku) {
        this.getHakkoJoken().setRadChohyoSentaku(radChohyoSentaku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunDay() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtKijunDay();
    }

    @JsonIgnore
    public void setTxtKijunDay(TextBoxFlexibleDate txtKijunDay) {
        this.getYokaigoNinteiChosaTokusokujo().setTxtKijunDay(txtKijunDay);
    }

    @JsonIgnore
    public TextBoxNum getTxtOverChosaIraiDay() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtOverChosaIraiDay();
    }

    @JsonIgnore
    public void setTxtOverChosaIraiDay(TextBoxNum txtOverChosaIraiDay) {
        this.getYokaigoNinteiChosaTokusokujo().setTxtOverChosaIraiDay(txtOverChosaIraiDay);
    }

    @JsonIgnore
    public CheckBoxList getChkInsatsuzumiTaisho() {
        return this.getYokaigoNinteiChosaTokusokujo().getChkInsatsuzumiTaisho();
    }

    @JsonIgnore
    public void setChkInsatsuzumiTaisho(CheckBoxList chkInsatsuzumiTaisho) {
        this.getYokaigoNinteiChosaTokusokujo().setChkInsatsuzumiTaisho(chkInsatsuzumiTaisho);
    }

    @JsonIgnore
    public CheckBoxList getChkHakkoRireki() {
        return this.getYokaigoNinteiChosaTokusokujo().getChkHakkoRireki();
    }

    @JsonIgnore
    public void setChkHakkoRireki(CheckBoxList chkHakkoRireki) {
        this.getYokaigoNinteiChosaTokusokujo().setChkHakkoRireki(chkHakkoRireki);
    }

    @JsonIgnore
    public RadioButton getRadTokusokuHoho() {
        return this.getYokaigoNinteiChosaTokusokujo().getRadTokusokuHoho();
    }

    @JsonIgnore
    public void setRadTokusokuHoho(RadioButton radTokusokuHoho) {
        this.getYokaigoNinteiChosaTokusokujo().setRadTokusokuHoho(radTokusokuHoho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokusokuMemo() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtTokusokuMemo();
    }

    @JsonIgnore
    public void setTxtTokusokuMemo(TextBoxMultiLine txtTokusokuMemo) {
        this.getYokaigoNinteiChosaTokusokujo().setTxtTokusokuMemo(txtTokusokuMemo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakkoDay() {
        return this.getYokaigoNinteiChosaTokusokujo().getTxtHakkoDay();
    }

    @JsonIgnore
    public void setTxtHakkoDay(TextBoxFlexibleDate txtHakkoDay) {
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
    public void setChkInsatsuChohyo(CheckBoxList chkInsatsuChohyo) {
        this.getNinteiChosaTokusokuTaishoshaIchiranhyo().setChkInsatsuChohyo(chkInsatsuChohyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtInsatsuKikan() {
        return this.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan();
    }

    @JsonIgnore
    public void setTxtInsatsuKikan(TextBoxDateRange txtInsatsuKikan) {
        this.getNinteiChosaTokusokuTaishoshaIchiranhyo().setTxtInsatsuKikan(txtInsatsuKikan);
    }

    // </editor-fold>
    private NinteiChosaTokusokujoHakkoTempData tempData;

    /**
     * @return the tempData
     */
    public NinteiChosaTokusokujoHakkoTempData getTempData() {
        return tempData;
    }

    /**
     * @param tempData the tempData to set
     */
    public void setTempData(NinteiChosaTokusokujoHakkoTempData tempData) {
        this.tempData = tempData;
    }

}
