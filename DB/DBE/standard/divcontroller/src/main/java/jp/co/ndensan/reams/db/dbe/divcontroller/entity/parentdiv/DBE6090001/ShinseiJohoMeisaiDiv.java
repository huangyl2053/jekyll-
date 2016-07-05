package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
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
    @JsonProperty("txtNinteiChosaIraiNengappi")
    private TextBoxFlexibleDate txtNinteiChosaIraiNengappi;
    @JsonProperty("txtNinteiChosaJisshiNengappi")
    private TextBoxFlexibleDate txtNinteiChosaJisshiNengappi;
    @JsonProperty("txtNinteiJuryoNengappi")
    private TextBoxFlexibleDate txtNinteiJuryoNengappi;
    @JsonProperty("txtHomonShurui")
    private TextBox txtHomonShurui;
    @JsonProperty("txtShiharaiMemo")
    private TextBox txtShiharaiMemo;
    @JsonProperty("txtNinteiChosaItakuryo")
    private TextBoxNum txtNinteiChosaItakuryo;
    @JsonProperty("radGinkoFurikomi")
    private RadioButton radGinkoFurikomi;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnNyuryokuToriyameru")
    private Button btnNyuryokuToriyameru;
    @JsonProperty("ccdChosaItakusakiAndChosainInput")
    private ChosaItakusakiAndChosainInputDiv ccdChosaItakusakiAndChosainInput;

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
     * gettxtNinteiChosaIraiNengappi
     * @return txtNinteiChosaIraiNengappi
     */
    @JsonProperty("txtNinteiChosaIraiNengappi")
    public TextBoxFlexibleDate getTxtNinteiChosaIraiNengappi() {
        return txtNinteiChosaIraiNengappi;
    }

    /*
     * settxtNinteiChosaIraiNengappi
     * @param txtNinteiChosaIraiNengappi txtNinteiChosaIraiNengappi
     */
    @JsonProperty("txtNinteiChosaIraiNengappi")
    public void setTxtNinteiChosaIraiNengappi(TextBoxFlexibleDate txtNinteiChosaIraiNengappi) {
        this.txtNinteiChosaIraiNengappi = txtNinteiChosaIraiNengappi;
    }

    /*
     * gettxtNinteiChosaJisshiNengappi
     * @return txtNinteiChosaJisshiNengappi
     */
    @JsonProperty("txtNinteiChosaJisshiNengappi")
    public TextBoxFlexibleDate getTxtNinteiChosaJisshiNengappi() {
        return txtNinteiChosaJisshiNengappi;
    }

    /*
     * settxtNinteiChosaJisshiNengappi
     * @param txtNinteiChosaJisshiNengappi txtNinteiChosaJisshiNengappi
     */
    @JsonProperty("txtNinteiChosaJisshiNengappi")
    public void setTxtNinteiChosaJisshiNengappi(TextBoxFlexibleDate txtNinteiChosaJisshiNengappi) {
        this.txtNinteiChosaJisshiNengappi = txtNinteiChosaJisshiNengappi;
    }

    /*
     * gettxtNinteiJuryoNengappi
     * @return txtNinteiJuryoNengappi
     */
    @JsonProperty("txtNinteiJuryoNengappi")
    public TextBoxFlexibleDate getTxtNinteiJuryoNengappi() {
        return txtNinteiJuryoNengappi;
    }

    /*
     * settxtNinteiJuryoNengappi
     * @param txtNinteiJuryoNengappi txtNinteiJuryoNengappi
     */
    @JsonProperty("txtNinteiJuryoNengappi")
    public void setTxtNinteiJuryoNengappi(TextBoxFlexibleDate txtNinteiJuryoNengappi) {
        this.txtNinteiJuryoNengappi = txtNinteiJuryoNengappi;
    }

    /*
     * gettxtHomonShurui
     * @return txtHomonShurui
     */
    @JsonProperty("txtHomonShurui")
    public TextBox getTxtHomonShurui() {
        return txtHomonShurui;
    }

    /*
     * settxtHomonShurui
     * @param txtHomonShurui txtHomonShurui
     */
    @JsonProperty("txtHomonShurui")
    public void setTxtHomonShurui(TextBox txtHomonShurui) {
        this.txtHomonShurui = txtHomonShurui;
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
     * gettxtNinteiChosaItakuryo
     * @return txtNinteiChosaItakuryo
     */
    @JsonProperty("txtNinteiChosaItakuryo")
    public TextBoxNum getTxtNinteiChosaItakuryo() {
        return txtNinteiChosaItakuryo;
    }

    /*
     * settxtNinteiChosaItakuryo
     * @param txtNinteiChosaItakuryo txtNinteiChosaItakuryo
     */
    @JsonProperty("txtNinteiChosaItakuryo")
    public void setTxtNinteiChosaItakuryo(TextBoxNum txtNinteiChosaItakuryo) {
        this.txtNinteiChosaItakuryo = txtNinteiChosaItakuryo;
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
     * getccdChosaItakusakiAndChosainInput
     * @return ccdChosaItakusakiAndChosainInput
     */
    @JsonProperty("ccdChosaItakusakiAndChosainInput")
    public ChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return ccdChosaItakusakiAndChosainInput;
    }

    // </editor-fold>
}
