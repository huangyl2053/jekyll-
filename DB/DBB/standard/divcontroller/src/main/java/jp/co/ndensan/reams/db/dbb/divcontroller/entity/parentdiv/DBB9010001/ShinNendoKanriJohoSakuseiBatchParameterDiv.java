package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShinNendoKanriJohoSakuseiBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinNendoKanriJohoSakuseiBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblMessage")
    private Label lblMessage;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtTonendo")
    private TextBox txtTonendo;
    @JsonProperty("lblYajirushi")
    private Label lblYajirushi;
    @JsonProperty("txtShiNendo")
    private TextBox txtShiNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblMessage
     * @return lblMessage
     */
    @JsonProperty("lblMessage")
    public Label getLblMessage() {
        return lblMessage;
    }

    /*
     * setlblMessage
     * @param lblMessage lblMessage
     */
    @JsonProperty("lblMessage")
    public void setLblMessage(Label lblMessage) {
        this.lblMessage = lblMessage;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtTonendo
     * @return txtTonendo
     */
    @JsonProperty("txtTonendo")
    public TextBox getTxtTonendo() {
        return txtTonendo;
    }

    /*
     * settxtTonendo
     * @param txtTonendo txtTonendo
     */
    @JsonProperty("txtTonendo")
    public void setTxtTonendo(TextBox txtTonendo) {
        this.txtTonendo = txtTonendo;
    }

    /*
     * getlblYajirushi
     * @return lblYajirushi
     */
    @JsonProperty("lblYajirushi")
    public Label getLblYajirushi() {
        return lblYajirushi;
    }

    /*
     * setlblYajirushi
     * @param lblYajirushi lblYajirushi
     */
    @JsonProperty("lblYajirushi")
    public void setLblYajirushi(Label lblYajirushi) {
        this.lblYajirushi = lblYajirushi;
    }

    /*
     * gettxtShiNendo
     * @return txtShiNendo
     */
    @JsonProperty("txtShiNendo")
    public TextBox getTxtShiNendo() {
        return txtShiNendo;
    }

    /*
     * settxtShiNendo
     * @param txtShiNendo txtShiNendo
     */
    @JsonProperty("txtShiNendo")
    public void setTxtShiNendo(TextBox txtShiNendo) {
        this.txtShiNendo = txtShiNendo;
    }

    // </editor-fold>

    public Object getShinNendoKanriJohoSakuseiShoriNaiyo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
