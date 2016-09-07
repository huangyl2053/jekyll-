package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShinseiJohoMeisai のクラスファイル
 *
 * @author 自動生成
 */
public class ShinseiJohoMeisaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseibi")
    private TextBoxFlexibleDate txtShinseibi;
    @JsonProperty("xtIkenshoSakuseiIraiNengappi")
    private TextBoxFlexibleDate xtIkenshoSakuseiIraiNengappi;
    @JsonProperty("txtIkenshoKinyuNengappi")
    private TextBoxFlexibleDate txtIkenshoKinyuNengappi;
    @JsonProperty("txtIkenshoJuryoNengappi")
    private TextBoxFlexibleDate txtIkenshoJuryoNengappi;
    @JsonProperty("txtIshiKubun")
    private TextBox txtIshiKubun;
    @JsonProperty("ddlZaitakuShisetsuKubun")
    private DropDownList ddlZaitakuShisetsuKubun;
    @JsonProperty("ddlIkenshoSakuseiKaisuKubun")
    private DropDownList ddlIkenshoSakuseiKaisuKubun;
    @JsonProperty("txtIkenshoSakuseiryo")
    private TextBoxNum txtIkenshoSakuseiryo;
    @JsonProperty("txtIkenshoBettoShinsahi")
    private TextBoxNum txtIkenshoBettoShinsahi;
    @JsonProperty("txtIkenshoHoshu")
    private TextBoxNum txtIkenshoHoshu;
    @JsonProperty("txtShiharaiMemo")
    private TextBox txtShiharaiMemo;
    @JsonProperty("radGinkoFurikomi")
    private RadioButton radGinkoFurikomi;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnNyuryokuToriyameru")
    private Button btnNyuryokuToriyameru;
    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    private ShujiiIryokikanAndShujiiInputDiv ccdShujiiIryokikanAndShujiiInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseibi
     * @return txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public TextBoxFlexibleDate getTxtShinseibi() {
        return txtShinseibi;
    }

    /*
     * settxtShinseibi
     * @param txtShinseibi txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxFlexibleDate txtShinseibi) {
        this.txtShinseibi = txtShinseibi;
    }

    /*
     * getxtIkenshoSakuseiIraiNengappi
     * @return xtIkenshoSakuseiIraiNengappi
     */
    @JsonProperty("xtIkenshoSakuseiIraiNengappi")
    public TextBoxFlexibleDate getXtIkenshoSakuseiIraiNengappi() {
        return xtIkenshoSakuseiIraiNengappi;
    }

    /*
     * setxtIkenshoSakuseiIraiNengappi
     * @param xtIkenshoSakuseiIraiNengappi xtIkenshoSakuseiIraiNengappi
     */
    @JsonProperty("xtIkenshoSakuseiIraiNengappi")
    public void setXtIkenshoSakuseiIraiNengappi(TextBoxFlexibleDate xtIkenshoSakuseiIraiNengappi) {
        this.xtIkenshoSakuseiIraiNengappi = xtIkenshoSakuseiIraiNengappi;
    }

    /*
     * gettxtIkenshoKinyuNengappi
     * @return txtIkenshoKinyuNengappi
     */
    @JsonProperty("txtIkenshoKinyuNengappi")
    public TextBoxFlexibleDate getTxtIkenshoKinyuNengappi() {
        return txtIkenshoKinyuNengappi;
    }

    /*
     * settxtIkenshoKinyuNengappi
     * @param txtIkenshoKinyuNengappi txtIkenshoKinyuNengappi
     */
    @JsonProperty("txtIkenshoKinyuNengappi")
    public void setTxtIkenshoKinyuNengappi(TextBoxFlexibleDate txtIkenshoKinyuNengappi) {
        this.txtIkenshoKinyuNengappi = txtIkenshoKinyuNengappi;
    }

    /*
     * gettxtIkenshoJuryoNengappi
     * @return txtIkenshoJuryoNengappi
     */
    @JsonProperty("txtIkenshoJuryoNengappi")
    public TextBoxFlexibleDate getTxtIkenshoJuryoNengappi() {
        return txtIkenshoJuryoNengappi;
    }

    /*
     * settxtIkenshoJuryoNengappi
     * @param txtIkenshoJuryoNengappi txtIkenshoJuryoNengappi
     */
    @JsonProperty("txtIkenshoJuryoNengappi")
    public void setTxtIkenshoJuryoNengappi(TextBoxFlexibleDate txtIkenshoJuryoNengappi) {
        this.txtIkenshoJuryoNengappi = txtIkenshoJuryoNengappi;
    }

    /*
     * gettxtIshiKubun
     * @return txtIshiKubun
     */
    @JsonProperty("txtIshiKubun")
    public TextBox getTxtIshiKubun() {
        return txtIshiKubun;
    }

    /*
     * settxtIshiKubun
     * @param txtIshiKubun txtIshiKubun
     */
    @JsonProperty("txtIshiKubun")
    public void setTxtIshiKubun(TextBox txtIshiKubun) {
        this.txtIshiKubun = txtIshiKubun;
    }

    /*
     * getddlZaitakuShisetsuKubun
     * @return ddlZaitakuShisetsuKubun
     */
    @JsonProperty("ddlZaitakuShisetsuKubun")
    public DropDownList getDdlZaitakuShisetsuKubun() {
        return ddlZaitakuShisetsuKubun;
    }

    /*
     * setddlZaitakuShisetsuKubun
     * @param ddlZaitakuShisetsuKubun ddlZaitakuShisetsuKubun
     */
    @JsonProperty("ddlZaitakuShisetsuKubun")
    public void setDdlZaitakuShisetsuKubun(DropDownList ddlZaitakuShisetsuKubun) {
        this.ddlZaitakuShisetsuKubun = ddlZaitakuShisetsuKubun;
    }

    /*
     * getddlIkenshoSakuseiKaisuKubun
     * @return ddlIkenshoSakuseiKaisuKubun
     */
    @JsonProperty("ddlIkenshoSakuseiKaisuKubun")
    public DropDownList getDdlIkenshoSakuseiKaisuKubun() {
        return ddlIkenshoSakuseiKaisuKubun;
    }

    /*
     * setddlIkenshoSakuseiKaisuKubun
     * @param ddlIkenshoSakuseiKaisuKubun ddlIkenshoSakuseiKaisuKubun
     */
    @JsonProperty("ddlIkenshoSakuseiKaisuKubun")
    public void setDdlIkenshoSakuseiKaisuKubun(DropDownList ddlIkenshoSakuseiKaisuKubun) {
        this.ddlIkenshoSakuseiKaisuKubun = ddlIkenshoSakuseiKaisuKubun;
    }

    /*
     * gettxtIkenshoSakuseiryo
     * @return txtIkenshoSakuseiryo
     */
    @JsonProperty("txtIkenshoSakuseiryo")
    public TextBoxNum getTxtIkenshoSakuseiryo() {
        return txtIkenshoSakuseiryo;
    }

    /*
     * settxtIkenshoSakuseiryo
     * @param txtIkenshoSakuseiryo txtIkenshoSakuseiryo
     */
    @JsonProperty("txtIkenshoSakuseiryo")
    public void setTxtIkenshoSakuseiryo(TextBoxNum txtIkenshoSakuseiryo) {
        this.txtIkenshoSakuseiryo = txtIkenshoSakuseiryo;
    }

    /*
     * gettxtIkenshoBettoShinsahi
     * @return txtIkenshoBettoShinsahi
     */
    @JsonProperty("txtIkenshoBettoShinsahi")
    public TextBoxNum getTxtIkenshoBettoShinsahi() {
        return txtIkenshoBettoShinsahi;
    }

    /*
     * settxtIkenshoBettoShinsahi
     * @param txtIkenshoBettoShinsahi txtIkenshoBettoShinsahi
     */
    @JsonProperty("txtIkenshoBettoShinsahi")
    public void setTxtIkenshoBettoShinsahi(TextBoxNum txtIkenshoBettoShinsahi) {
        this.txtIkenshoBettoShinsahi = txtIkenshoBettoShinsahi;
    }

    /*
     * gettxtIkenshoHoshu
     * @return txtIkenshoHoshu
     */
    @JsonProperty("txtIkenshoHoshu")
    public TextBoxNum getTxtIkenshoHoshu() {
        return txtIkenshoHoshu;
    }

    /*
     * settxtIkenshoHoshu
     * @param txtIkenshoHoshu txtIkenshoHoshu
     */
    @JsonProperty("txtIkenshoHoshu")
    public void setTxtIkenshoHoshu(TextBoxNum txtIkenshoHoshu) {
        this.txtIkenshoHoshu = txtIkenshoHoshu;
    }

    /*
     * gettxtShiharaiMemo
     * @return txtShiharaiMemo
     */
    @JsonProperty("txtShiharaiMemo")
    public TextBox getTxtShiharaiMemo() {
        return txtShiharaiMemo;
    }

    /*
     * settxtShiharaiMemo
     * @param txtShiharaiMemo txtShiharaiMemo
     */
    @JsonProperty("txtShiharaiMemo")
    public void setTxtShiharaiMemo(TextBox txtShiharaiMemo) {
        this.txtShiharaiMemo = txtShiharaiMemo;
    }

    /*
     * getradGinkoFurikomi
     * @return radGinkoFurikomi
     */
    @JsonProperty("radGinkoFurikomi")
    public RadioButton getRadGinkoFurikomi() {
        return radGinkoFurikomi;
    }

    /*
     * setradGinkoFurikomi
     * @param radGinkoFurikomi radGinkoFurikomi
     */
    @JsonProperty("radGinkoFurikomi")
    public void setRadGinkoFurikomi(RadioButton radGinkoFurikomi) {
        this.radGinkoFurikomi = radGinkoFurikomi;
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
     * getbtnNyuryokuToriyameru
     * @return btnNyuryokuToriyameru
     */
    @JsonProperty("btnNyuryokuToriyameru")
    public Button getBtnNyuryokuToriyameru() {
        return btnNyuryokuToriyameru;
    }

    /*
     * setbtnNyuryokuToriyameru
     * @param btnNyuryokuToriyameru btnNyuryokuToriyameru
     */
    @JsonProperty("btnNyuryokuToriyameru")
    public void setBtnNyuryokuToriyameru(Button btnNyuryokuToriyameru) {
        this.btnNyuryokuToriyameru = btnNyuryokuToriyameru;
    }

    /*
     * getccdShujiiIryokikanAndShujiiInput
     * @return ccdShujiiIryokikanAndShujiiInput
     */
    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return ccdShujiiIryokikanAndShujiiInput;
    }

    // </editor-fold>
}
