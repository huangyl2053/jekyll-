package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ZenkaiJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class ZenkaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiChosaItakusaki")
    private TextBoxDomainCode txtZenkaiChosaItakusaki;
    @JsonProperty("btnZenkaiChosaItakusakiGuide")
    private ButtonDialog btnZenkaiChosaItakusakiGuide;
    @JsonProperty("txtZenkaiNinteiChosaItakusakiName")
    private TextBox txtZenkaiNinteiChosaItakusakiName;
    @JsonProperty("txtZenkaiShujiiIryokikan")
    private TextBoxDomainCode txtZenkaiShujiiIryokikan;
    @JsonProperty("btnZenkaiShujiiIryokikanGuide")
    private ButtonDialog btnZenkaiShujiiIryokikanGuide;
    @JsonProperty("txtZenkaiShujiiIryokikanName")
    private TextBox txtZenkaiShujiiIryokikanName;
    @JsonProperty("ddlZenkaiNijiHanteiKekka")
    private DropDownList ddlZenkaiNijiHanteiKekka;
    @JsonProperty("txtZenkaiNinteiYukoKikan")
    private TextBox txtZenkaiNinteiYukoKikan;
    @JsonProperty("txtZenkaiYukoKaishiDateRange")
    private TextBoxDateRange txtZenkaiYukoKaishiDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiChosaItakusaki
     * @return txtZenkaiChosaItakusaki
     */
    @JsonProperty("txtZenkaiChosaItakusaki")
    public TextBoxDomainCode getTxtZenkaiChosaItakusaki() {
        return txtZenkaiChosaItakusaki;
    }

    /*
     * settxtZenkaiChosaItakusaki
     * @param txtZenkaiChosaItakusaki txtZenkaiChosaItakusaki
     */
    @JsonProperty("txtZenkaiChosaItakusaki")
    public void setTxtZenkaiChosaItakusaki(TextBoxDomainCode txtZenkaiChosaItakusaki) {
        this.txtZenkaiChosaItakusaki = txtZenkaiChosaItakusaki;
    }

    /*
     * getbtnZenkaiChosaItakusakiGuide
     * @return btnZenkaiChosaItakusakiGuide
     */
    @JsonProperty("btnZenkaiChosaItakusakiGuide")
    public ButtonDialog getBtnZenkaiChosaItakusakiGuide() {
        return btnZenkaiChosaItakusakiGuide;
    }

    /*
     * setbtnZenkaiChosaItakusakiGuide
     * @param btnZenkaiChosaItakusakiGuide btnZenkaiChosaItakusakiGuide
     */
    @JsonProperty("btnZenkaiChosaItakusakiGuide")
    public void setBtnZenkaiChosaItakusakiGuide(ButtonDialog btnZenkaiChosaItakusakiGuide) {
        this.btnZenkaiChosaItakusakiGuide = btnZenkaiChosaItakusakiGuide;
    }

    /*
     * gettxtZenkaiNinteiChosaItakusakiName
     * @return txtZenkaiNinteiChosaItakusakiName
     */
    @JsonProperty("txtZenkaiNinteiChosaItakusakiName")
    public TextBox getTxtZenkaiNinteiChosaItakusakiName() {
        return txtZenkaiNinteiChosaItakusakiName;
    }

    /*
     * settxtZenkaiNinteiChosaItakusakiName
     * @param txtZenkaiNinteiChosaItakusakiName txtZenkaiNinteiChosaItakusakiName
     */
    @JsonProperty("txtZenkaiNinteiChosaItakusakiName")
    public void setTxtZenkaiNinteiChosaItakusakiName(TextBox txtZenkaiNinteiChosaItakusakiName) {
        this.txtZenkaiNinteiChosaItakusakiName = txtZenkaiNinteiChosaItakusakiName;
    }

    /*
     * gettxtZenkaiShujiiIryokikan
     * @return txtZenkaiShujiiIryokikan
     */
    @JsonProperty("txtZenkaiShujiiIryokikan")
    public TextBoxDomainCode getTxtZenkaiShujiiIryokikan() {
        return txtZenkaiShujiiIryokikan;
    }

    /*
     * settxtZenkaiShujiiIryokikan
     * @param txtZenkaiShujiiIryokikan txtZenkaiShujiiIryokikan
     */
    @JsonProperty("txtZenkaiShujiiIryokikan")
    public void setTxtZenkaiShujiiIryokikan(TextBoxDomainCode txtZenkaiShujiiIryokikan) {
        this.txtZenkaiShujiiIryokikan = txtZenkaiShujiiIryokikan;
    }

    /*
     * getbtnZenkaiShujiiIryokikanGuide
     * @return btnZenkaiShujiiIryokikanGuide
     */
    @JsonProperty("btnZenkaiShujiiIryokikanGuide")
    public ButtonDialog getBtnZenkaiShujiiIryokikanGuide() {
        return btnZenkaiShujiiIryokikanGuide;
    }

    /*
     * setbtnZenkaiShujiiIryokikanGuide
     * @param btnZenkaiShujiiIryokikanGuide btnZenkaiShujiiIryokikanGuide
     */
    @JsonProperty("btnZenkaiShujiiIryokikanGuide")
    public void setBtnZenkaiShujiiIryokikanGuide(ButtonDialog btnZenkaiShujiiIryokikanGuide) {
        this.btnZenkaiShujiiIryokikanGuide = btnZenkaiShujiiIryokikanGuide;
    }

    /*
     * gettxtZenkaiShujiiIryokikanName
     * @return txtZenkaiShujiiIryokikanName
     */
    @JsonProperty("txtZenkaiShujiiIryokikanName")
    public TextBox getTxtZenkaiShujiiIryokikanName() {
        return txtZenkaiShujiiIryokikanName;
    }

    /*
     * settxtZenkaiShujiiIryokikanName
     * @param txtZenkaiShujiiIryokikanName txtZenkaiShujiiIryokikanName
     */
    @JsonProperty("txtZenkaiShujiiIryokikanName")
    public void setTxtZenkaiShujiiIryokikanName(TextBox txtZenkaiShujiiIryokikanName) {
        this.txtZenkaiShujiiIryokikanName = txtZenkaiShujiiIryokikanName;
    }

    /*
     * getddlZenkaiNijiHanteiKekka
     * @return ddlZenkaiNijiHanteiKekka
     */
    @JsonProperty("ddlZenkaiNijiHanteiKekka")
    public DropDownList getDdlZenkaiNijiHanteiKekka() {
        return ddlZenkaiNijiHanteiKekka;
    }

    /*
     * setddlZenkaiNijiHanteiKekka
     * @param ddlZenkaiNijiHanteiKekka ddlZenkaiNijiHanteiKekka
     */
    @JsonProperty("ddlZenkaiNijiHanteiKekka")
    public void setDdlZenkaiNijiHanteiKekka(DropDownList ddlZenkaiNijiHanteiKekka) {
        this.ddlZenkaiNijiHanteiKekka = ddlZenkaiNijiHanteiKekka;
    }

    /*
     * gettxtZenkaiNinteiYukoKikan
     * @return txtZenkaiNinteiYukoKikan
     */
    @JsonProperty("txtZenkaiNinteiYukoKikan")
    public TextBox getTxtZenkaiNinteiYukoKikan() {
        return txtZenkaiNinteiYukoKikan;
    }

    /*
     * settxtZenkaiNinteiYukoKikan
     * @param txtZenkaiNinteiYukoKikan txtZenkaiNinteiYukoKikan
     */
    @JsonProperty("txtZenkaiNinteiYukoKikan")
    public void setTxtZenkaiNinteiYukoKikan(TextBox txtZenkaiNinteiYukoKikan) {
        this.txtZenkaiNinteiYukoKikan = txtZenkaiNinteiYukoKikan;
    }

    /*
     * gettxtZenkaiYukoKaishiDateRange
     * @return txtZenkaiYukoKaishiDateRange
     */
    @JsonProperty("txtZenkaiYukoKaishiDateRange")
    public TextBoxDateRange getTxtZenkaiYukoKaishiDateRange() {
        return txtZenkaiYukoKaishiDateRange;
    }

    /*
     * settxtZenkaiYukoKaishiDateRange
     * @param txtZenkaiYukoKaishiDateRange txtZenkaiYukoKaishiDateRange
     */
    @JsonProperty("txtZenkaiYukoKaishiDateRange")
    public void setTxtZenkaiYukoKaishiDateRange(TextBoxDateRange txtZenkaiYukoKaishiDateRange) {
        this.txtZenkaiYukoKaishiDateRange = txtZenkaiYukoKaishiDateRange;
    }

    // </editor-fold>
}
