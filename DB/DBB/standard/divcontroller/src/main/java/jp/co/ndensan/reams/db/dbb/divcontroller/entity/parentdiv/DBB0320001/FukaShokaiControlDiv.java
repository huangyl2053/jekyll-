package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001;
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
 * FukaShokaiControl のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaShokaiControlDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBoxFlexibleYear txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBoxFlexibleYear txtFukaNendo;
    @JsonProperty("txtKoseiM")
    private TextBox txtKoseiM;
    @JsonProperty("txtKoseiYMD")
    private TextBoxFlexibleDate txtKoseiYMD;
    @JsonProperty("txtKoseiTime")
    private TextBoxTime txtKoseiTime;
    @JsonProperty("btnRirekiHyoji")
    private Button btnRirekiHyoji;
    @JsonProperty("btnFukakonkyoKiwari")
    private Button btnFukakonkyoKiwari;
    @JsonProperty("btnSetaiinShotoku")
    private Button btnSetaiinShotoku;
    @JsonProperty("btnTokucho")
    private Button btnTokucho;
    @JsonProperty("btnGemmen")
    private Button btnGemmen;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBoxFlexibleYear getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBoxFlexibleYear txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBoxFlexibleYear getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBoxFlexibleYear txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtKoseiM
     * @return txtKoseiM
     */
    @JsonProperty("txtKoseiM")
    public TextBox getTxtKoseiM() {
        return txtKoseiM;
    }

    /*
     * settxtKoseiM
     * @param txtKoseiM txtKoseiM
     */
    @JsonProperty("txtKoseiM")
    public void setTxtKoseiM(TextBox txtKoseiM) {
        this.txtKoseiM = txtKoseiM;
    }

    /*
     * gettxtKoseiYMD
     * @return txtKoseiYMD
     */
    @JsonProperty("txtKoseiYMD")
    public TextBoxFlexibleDate getTxtKoseiYMD() {
        return txtKoseiYMD;
    }

    /*
     * settxtKoseiYMD
     * @param txtKoseiYMD txtKoseiYMD
     */
    @JsonProperty("txtKoseiYMD")
    public void setTxtKoseiYMD(TextBoxFlexibleDate txtKoseiYMD) {
        this.txtKoseiYMD = txtKoseiYMD;
    }

    /*
     * gettxtKoseiTime
     * @return txtKoseiTime
     */
    @JsonProperty("txtKoseiTime")
    public TextBoxTime getTxtKoseiTime() {
        return txtKoseiTime;
    }

    /*
     * settxtKoseiTime
     * @param txtKoseiTime txtKoseiTime
     */
    @JsonProperty("txtKoseiTime")
    public void setTxtKoseiTime(TextBoxTime txtKoseiTime) {
        this.txtKoseiTime = txtKoseiTime;
    }

    /*
     * getbtnRirekiHyoji
     * @return btnRirekiHyoji
     */
    @JsonProperty("btnRirekiHyoji")
    public Button getBtnRirekiHyoji() {
        return btnRirekiHyoji;
    }

    /*
     * setbtnRirekiHyoji
     * @param btnRirekiHyoji btnRirekiHyoji
     */
    @JsonProperty("btnRirekiHyoji")
    public void setBtnRirekiHyoji(Button btnRirekiHyoji) {
        this.btnRirekiHyoji = btnRirekiHyoji;
    }

    /*
     * getbtnFukakonkyoKiwari
     * @return btnFukakonkyoKiwari
     */
    @JsonProperty("btnFukakonkyoKiwari")
    public Button getBtnFukakonkyoKiwari() {
        return btnFukakonkyoKiwari;
    }

    /*
     * setbtnFukakonkyoKiwari
     * @param btnFukakonkyoKiwari btnFukakonkyoKiwari
     */
    @JsonProperty("btnFukakonkyoKiwari")
    public void setBtnFukakonkyoKiwari(Button btnFukakonkyoKiwari) {
        this.btnFukakonkyoKiwari = btnFukakonkyoKiwari;
    }

    /*
     * getbtnSetaiinShotoku
     * @return btnSetaiinShotoku
     */
    @JsonProperty("btnSetaiinShotoku")
    public Button getBtnSetaiinShotoku() {
        return btnSetaiinShotoku;
    }

    /*
     * setbtnSetaiinShotoku
     * @param btnSetaiinShotoku btnSetaiinShotoku
     */
    @JsonProperty("btnSetaiinShotoku")
    public void setBtnSetaiinShotoku(Button btnSetaiinShotoku) {
        this.btnSetaiinShotoku = btnSetaiinShotoku;
    }

    /*
     * getbtnTokucho
     * @return btnTokucho
     */
    @JsonProperty("btnTokucho")
    public Button getBtnTokucho() {
        return btnTokucho;
    }

    /*
     * setbtnTokucho
     * @param btnTokucho btnTokucho
     */
    @JsonProperty("btnTokucho")
    public void setBtnTokucho(Button btnTokucho) {
        this.btnTokucho = btnTokucho;
    }

    /*
     * getbtnGemmen
     * @return btnGemmen
     */
    @JsonProperty("btnGemmen")
    public Button getBtnGemmen() {
        return btnGemmen;
    }

    /*
     * setbtnGemmen
     * @param btnGemmen btnGemmen
     */
    @JsonProperty("btnGemmen")
    public void setBtnGemmen(Button btnGemmen) {
        this.btnGemmen = btnGemmen;
    }

    // </editor-fold>
}
