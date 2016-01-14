package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YokaigoNinteiChosaTokusokujo のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigoNinteiChosaTokusokujoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunDay")
    private TextBoxFlexibleDate txtKijunDay;
    @JsonProperty("txtOverChosaIraiDay")
    private TextBoxNum txtOverChosaIraiDay;
    @JsonProperty("chkInsatsuzumiTaisho")
    private CheckBoxList chkInsatsuzumiTaisho;
    @JsonProperty("chkHakkoRireki")
    private CheckBoxList chkHakkoRireki;
    @JsonProperty("radTokusokuHoho")
    private RadioButton radTokusokuHoho;
    @JsonProperty("txtTokusokuMemo")
    private TextBoxMultiLine txtTokusokuMemo;
    @JsonProperty("txtHakkoDay")
    private TextBoxFlexibleDate txtHakkoDay;
    @JsonProperty("ccdItakusakiAndChosain")
    private ChosaItakusakiAndChosainInputDiv ccdItakusakiAndChosain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunDay
     * @return txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public TextBoxFlexibleDate getTxtKijunDay() {
        return txtKijunDay;
    }

    /*
     * settxtKijunDay
     * @param txtKijunDay txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public void setTxtKijunDay(TextBoxFlexibleDate txtKijunDay) {
        this.txtKijunDay = txtKijunDay;
    }

    /*
     * gettxtOverChosaIraiDay
     * @return txtOverChosaIraiDay
     */
    @JsonProperty("txtOverChosaIraiDay")
    public TextBoxNum getTxtOverChosaIraiDay() {
        return txtOverChosaIraiDay;
    }

    /*
     * settxtOverChosaIraiDay
     * @param txtOverChosaIraiDay txtOverChosaIraiDay
     */
    @JsonProperty("txtOverChosaIraiDay")
    public void setTxtOverChosaIraiDay(TextBoxNum txtOverChosaIraiDay) {
        this.txtOverChosaIraiDay = txtOverChosaIraiDay;
    }

    /*
     * getchkInsatsuzumiTaisho
     * @return chkInsatsuzumiTaisho
     */
    @JsonProperty("chkInsatsuzumiTaisho")
    public CheckBoxList getChkInsatsuzumiTaisho() {
        return chkInsatsuzumiTaisho;
    }

    /*
     * setchkInsatsuzumiTaisho
     * @param chkInsatsuzumiTaisho chkInsatsuzumiTaisho
     */
    @JsonProperty("chkInsatsuzumiTaisho")
    public void setChkInsatsuzumiTaisho(CheckBoxList chkInsatsuzumiTaisho) {
        this.chkInsatsuzumiTaisho = chkInsatsuzumiTaisho;
    }

    /*
     * getchkHakkoRireki
     * @return chkHakkoRireki
     */
    @JsonProperty("chkHakkoRireki")
    public CheckBoxList getChkHakkoRireki() {
        return chkHakkoRireki;
    }

    /*
     * setchkHakkoRireki
     * @param chkHakkoRireki chkHakkoRireki
     */
    @JsonProperty("chkHakkoRireki")
    public void setChkHakkoRireki(CheckBoxList chkHakkoRireki) {
        this.chkHakkoRireki = chkHakkoRireki;
    }

    /*
     * getradTokusokuHoho
     * @return radTokusokuHoho
     */
    @JsonProperty("radTokusokuHoho")
    public RadioButton getRadTokusokuHoho() {
        return radTokusokuHoho;
    }

    /*
     * setradTokusokuHoho
     * @param radTokusokuHoho radTokusokuHoho
     */
    @JsonProperty("radTokusokuHoho")
    public void setRadTokusokuHoho(RadioButton radTokusokuHoho) {
        this.radTokusokuHoho = radTokusokuHoho;
    }

    /*
     * gettxtTokusokuMemo
     * @return txtTokusokuMemo
     */
    @JsonProperty("txtTokusokuMemo")
    public TextBoxMultiLine getTxtTokusokuMemo() {
        return txtTokusokuMemo;
    }

    /*
     * settxtTokusokuMemo
     * @param txtTokusokuMemo txtTokusokuMemo
     */
    @JsonProperty("txtTokusokuMemo")
    public void setTxtTokusokuMemo(TextBoxMultiLine txtTokusokuMemo) {
        this.txtTokusokuMemo = txtTokusokuMemo;
    }

    /*
     * gettxtHakkoDay
     * @return txtHakkoDay
     */
    @JsonProperty("txtHakkoDay")
    public TextBoxFlexibleDate getTxtHakkoDay() {
        return txtHakkoDay;
    }

    /*
     * settxtHakkoDay
     * @param txtHakkoDay txtHakkoDay
     */
    @JsonProperty("txtHakkoDay")
    public void setTxtHakkoDay(TextBoxFlexibleDate txtHakkoDay) {
        this.txtHakkoDay = txtHakkoDay;
    }

    /*
     * getccdItakusakiAndChosain
     * @return ccdItakusakiAndChosain
     */
    @JsonProperty("ccdItakusakiAndChosain")
    public IChosaItakusakiAndChosainInputDiv getCcdItakusakiAndChosain() {
        return ccdItakusakiAndChosain;
    }

    // </editor-fold>
}
