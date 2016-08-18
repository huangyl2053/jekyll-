package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * PanelEdit のクラスファイル
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class PanelEditDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShikaku")
    private DropDownList ddlShikaku;
    @JsonProperty("ddlFutanWariai")
    private DropDownList ddlFutanWariai;
    @JsonProperty("txtTekiyoKaishibi")
    private TextBoxDate txtTekiyoKaishibi;
    @JsonProperty("txtTekiyoShuryobi")
    private TextBoxDate txtTekiyoShuryobi;
    @JsonProperty("txtHonninGokeiShotoku")
    private TextBoxNum txtHonninGokeiShotoku;
    @JsonProperty("txtSetaiinsu")
    private TextBoxNum txtSetaiinsu;
    @JsonProperty("txtNenkinShunyuGokei")
    private TextBoxNum txtNenkinShunyuGokei;
    @JsonProperty("txtSonotaGokei")
    private TextBoxNum txtSonotaGokei;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;
    @JsonProperty("PanelEditItem")
    private PanelEditItemDiv PanelEditItem;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShikaku
     * @return ddlShikaku
     */
    @JsonProperty("ddlShikaku")
    public DropDownList getDdlShikaku() {
        return ddlShikaku;
    }

    /*
     * setddlShikaku
     * @param ddlShikaku ddlShikaku
     */
    @JsonProperty("ddlShikaku")
    public void setDdlShikaku(DropDownList ddlShikaku) {
        this.ddlShikaku = ddlShikaku;
    }

    /*
     * getddlFutanWariai
     * @return ddlFutanWariai
     */
    @JsonProperty("ddlFutanWariai")
    public DropDownList getDdlFutanWariai() {
        return ddlFutanWariai;
    }

    /*
     * setddlFutanWariai
     * @param ddlFutanWariai ddlFutanWariai
     */
    @JsonProperty("ddlFutanWariai")
    public void setDdlFutanWariai(DropDownList ddlFutanWariai) {
        this.ddlFutanWariai = ddlFutanWariai;
    }

    /*
     * gettxtTekiyoKaishibi
     * @return txtTekiyoKaishibi
     */
    @JsonProperty("txtTekiyoKaishibi")
    public TextBoxDate getTxtTekiyoKaishibi() {
        return txtTekiyoKaishibi;
    }

    /*
     * settxtTekiyoKaishibi
     * @param txtTekiyoKaishibi txtTekiyoKaishibi
     */
    @JsonProperty("txtTekiyoKaishibi")
    public void setTxtTekiyoKaishibi(TextBoxDate txtTekiyoKaishibi) {
        this.txtTekiyoKaishibi = txtTekiyoKaishibi;
    }

    /*
     * gettxtTekiyoShuryobi
     * @return txtTekiyoShuryobi
     */
    @JsonProperty("txtTekiyoShuryobi")
    public TextBoxDate getTxtTekiyoShuryobi() {
        return txtTekiyoShuryobi;
    }

    /*
     * settxtTekiyoShuryobi
     * @param txtTekiyoShuryobi txtTekiyoShuryobi
     */
    @JsonProperty("txtTekiyoShuryobi")
    public void setTxtTekiyoShuryobi(TextBoxDate txtTekiyoShuryobi) {
        this.txtTekiyoShuryobi = txtTekiyoShuryobi;
    }

    /*
     * gettxtHonninGokeiShotoku
     * @return txtHonninGokeiShotoku
     */
    @JsonProperty("txtHonninGokeiShotoku")
    public TextBoxNum getTxtHonninGokeiShotoku() {
        return txtHonninGokeiShotoku;
    }

    /*
     * settxtHonninGokeiShotoku
     * @param txtHonninGokeiShotoku txtHonninGokeiShotoku
     */
    @JsonProperty("txtHonninGokeiShotoku")
    public void setTxtHonninGokeiShotoku(TextBoxNum txtHonninGokeiShotoku) {
        this.txtHonninGokeiShotoku = txtHonninGokeiShotoku;
    }

    /*
     * gettxtSetaiinsu
     * @return txtSetaiinsu
     */
    @JsonProperty("txtSetaiinsu")
    public TextBoxNum getTxtSetaiinsu() {
        return txtSetaiinsu;
    }

    /*
     * settxtSetaiinsu
     * @param txtSetaiinsu txtSetaiinsu
     */
    @JsonProperty("txtSetaiinsu")
    public void setTxtSetaiinsu(TextBoxNum txtSetaiinsu) {
        this.txtSetaiinsu = txtSetaiinsu;
    }

    /*
     * gettxtNenkinShunyuGokei
     * @return txtNenkinShunyuGokei
     */
    @JsonProperty("txtNenkinShunyuGokei")
    public TextBoxNum getTxtNenkinShunyuGokei() {
        return txtNenkinShunyuGokei;
    }

    /*
     * settxtNenkinShunyuGokei
     * @param txtNenkinShunyuGokei txtNenkinShunyuGokei
     */
    @JsonProperty("txtNenkinShunyuGokei")
    public void setTxtNenkinShunyuGokei(TextBoxNum txtNenkinShunyuGokei) {
        this.txtNenkinShunyuGokei = txtNenkinShunyuGokei;
    }

    /*
     * gettxtSonotaGokei
     * @return txtSonotaGokei
     */
    @JsonProperty("txtSonotaGokei")
    public TextBoxNum getTxtSonotaGokei() {
        return txtSonotaGokei;
    }

    /*
     * settxtSonotaGokei
     * @param txtSonotaGokei txtSonotaGokei
     */
    @JsonProperty("txtSonotaGokei")
    public void setTxtSonotaGokei(TextBoxNum txtSonotaGokei) {
        this.txtSonotaGokei = txtSonotaGokei;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    /*
     * getPanelEditItem
     * @return PanelEditItem
     */
    @JsonProperty("PanelEditItem")
    public PanelEditItemDiv getPanelEditItem() {
        return PanelEditItem;
    }

    /*
     * setPanelEditItem
     * @param PanelEditItem PanelEditItem
     */
    @JsonProperty("PanelEditItem")
    public void setPanelEditItem(PanelEditItemDiv PanelEditItem) {
        this.PanelEditItem = PanelEditItem;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getPanelEditItem().getBtnKakutei();
    }

    @JsonIgnore
    public void setBtnKakutei(Button btnKakutei) {
        this.getPanelEditItem().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelEditItem().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getPanelEditItem().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
