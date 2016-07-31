package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceRiyohyoBeppyoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoBeppyoMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTani")
    private TextBoxNum txtTani;
    @JsonProperty("txtWaribikigoRitsu")
    private TextBoxNum txtWaribikigoRitsu;
    @JsonProperty("txtWaribikigoTani")
    private TextBoxNum txtWaribikigoTani;
    @JsonProperty("txtKaisu")
    private TextBoxNum txtKaisu;
    @JsonProperty("lblKaisu")
    private Label lblKaisu;
    @JsonProperty("txtServiceTani")
    private TextBoxNum txtServiceTani;
    @JsonProperty("lblServiceTani")
    private Label lblServiceTani;
    @JsonProperty("txtRiyoushaFutangaku")
    private TextBoxNum txtRiyoushaFutangaku;
    @JsonProperty("txtTeigakuRiyoushaFutangaku")
    private TextBoxNum txtTeigakuRiyoushaFutangaku;
    @JsonProperty("ServiceRiyohyoBeppyoMeisaiFooter")
    private ServiceRiyohyoBeppyoMeisaiFooterDiv ServiceRiyohyoBeppyoMeisaiFooter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTani
     * @return txtTani
     */
    @JsonProperty("txtTani")
    public TextBoxNum getTxtTani() {
        return txtTani;
    }

    /*
     * settxtTani
     * @param txtTani txtTani
     */
    @JsonProperty("txtTani")
    public void setTxtTani(TextBoxNum txtTani) {
        this.txtTani = txtTani;
    }

    /*
     * gettxtWaribikigoRitsu
     * @return txtWaribikigoRitsu
     */
    @JsonProperty("txtWaribikigoRitsu")
    public TextBoxNum getTxtWaribikigoRitsu() {
        return txtWaribikigoRitsu;
    }

    /*
     * settxtWaribikigoRitsu
     * @param txtWaribikigoRitsu txtWaribikigoRitsu
     */
    @JsonProperty("txtWaribikigoRitsu")
    public void setTxtWaribikigoRitsu(TextBoxNum txtWaribikigoRitsu) {
        this.txtWaribikigoRitsu = txtWaribikigoRitsu;
    }

    /*
     * gettxtWaribikigoTani
     * @return txtWaribikigoTani
     */
    @JsonProperty("txtWaribikigoTani")
    public TextBoxNum getTxtWaribikigoTani() {
        return txtWaribikigoTani;
    }

    /*
     * settxtWaribikigoTani
     * @param txtWaribikigoTani txtWaribikigoTani
     */
    @JsonProperty("txtWaribikigoTani")
    public void setTxtWaribikigoTani(TextBoxNum txtWaribikigoTani) {
        this.txtWaribikigoTani = txtWaribikigoTani;
    }

    /*
     * gettxtKaisu
     * @return txtKaisu
     */
    @JsonProperty("txtKaisu")
    public TextBoxNum getTxtKaisu() {
        return txtKaisu;
    }

    /*
     * settxtKaisu
     * @param txtKaisu txtKaisu
     */
    @JsonProperty("txtKaisu")
    public void setTxtKaisu(TextBoxNum txtKaisu) {
        this.txtKaisu = txtKaisu;
    }

    /*
     * getlblKaisu
     * @return lblKaisu
     */
    @JsonProperty("lblKaisu")
    public Label getLblKaisu() {
        return lblKaisu;
    }

    /*
     * setlblKaisu
     * @param lblKaisu lblKaisu
     */
    @JsonProperty("lblKaisu")
    public void setLblKaisu(Label lblKaisu) {
        this.lblKaisu = lblKaisu;
    }

    /*
     * gettxtServiceTani
     * @return txtServiceTani
     */
    @JsonProperty("txtServiceTani")
    public TextBoxNum getTxtServiceTani() {
        return txtServiceTani;
    }

    /*
     * settxtServiceTani
     * @param txtServiceTani txtServiceTani
     */
    @JsonProperty("txtServiceTani")
    public void setTxtServiceTani(TextBoxNum txtServiceTani) {
        this.txtServiceTani = txtServiceTani;
    }

    /*
     * getlblServiceTani
     * @return lblServiceTani
     */
    @JsonProperty("lblServiceTani")
    public Label getLblServiceTani() {
        return lblServiceTani;
    }

    /*
     * setlblServiceTani
     * @param lblServiceTani lblServiceTani
     */
    @JsonProperty("lblServiceTani")
    public void setLblServiceTani(Label lblServiceTani) {
        this.lblServiceTani = lblServiceTani;
    }

    /*
     * gettxtRiyoushaFutangaku
     * @return txtRiyoushaFutangaku
     */
    @JsonProperty("txtRiyoushaFutangaku")
    public TextBoxNum getTxtRiyoushaFutangaku() {
        return txtRiyoushaFutangaku;
    }

    /*
     * settxtRiyoushaFutangaku
     * @param txtRiyoushaFutangaku txtRiyoushaFutangaku
     */
    @JsonProperty("txtRiyoushaFutangaku")
    public void setTxtRiyoushaFutangaku(TextBoxNum txtRiyoushaFutangaku) {
        this.txtRiyoushaFutangaku = txtRiyoushaFutangaku;
    }

    /*
     * gettxtTeigakuRiyoushaFutangaku
     * @return txtTeigakuRiyoushaFutangaku
     */
    @JsonProperty("txtTeigakuRiyoushaFutangaku")
    public TextBoxNum getTxtTeigakuRiyoushaFutangaku() {
        return txtTeigakuRiyoushaFutangaku;
    }

    /*
     * settxtTeigakuRiyoushaFutangaku
     * @param txtTeigakuRiyoushaFutangaku txtTeigakuRiyoushaFutangaku
     */
    @JsonProperty("txtTeigakuRiyoushaFutangaku")
    public void setTxtTeigakuRiyoushaFutangaku(TextBoxNum txtTeigakuRiyoushaFutangaku) {
        this.txtTeigakuRiyoushaFutangaku = txtTeigakuRiyoushaFutangaku;
    }

    /*
     * getServiceRiyohyoBeppyoMeisaiFooter
     * @return ServiceRiyohyoBeppyoMeisaiFooter
     */
    @JsonProperty("ServiceRiyohyoBeppyoMeisaiFooter")
    public ServiceRiyohyoBeppyoMeisaiFooterDiv getServiceRiyohyoBeppyoMeisaiFooter() {
        return ServiceRiyohyoBeppyoMeisaiFooter;
    }

    /*
     * setServiceRiyohyoBeppyoMeisaiFooter
     * @param ServiceRiyohyoBeppyoMeisaiFooter ServiceRiyohyoBeppyoMeisaiFooter
     */
    @JsonProperty("ServiceRiyohyoBeppyoMeisaiFooter")
    public void setServiceRiyohyoBeppyoMeisaiFooter(ServiceRiyohyoBeppyoMeisaiFooterDiv ServiceRiyohyoBeppyoMeisaiFooter) {
        this.ServiceRiyohyoBeppyoMeisaiFooter = ServiceRiyohyoBeppyoMeisaiFooter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnBeppyoMeisaiKakutei() {
        return this.getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei();
    }

    @JsonIgnore
    public void  setBtnBeppyoMeisaiKakutei(Button btnBeppyoMeisaiKakutei) {
        this.getServiceRiyohyoBeppyoMeisaiFooter().setBtnBeppyoMeisaiKakutei(btnBeppyoMeisaiKakutei);
    }

    @JsonIgnore
    public Button getBtnCalcMeisaiGokei() {
        return this.getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisaiGokei();
    }

    @JsonIgnore
    public void  setBtnCalcMeisaiGokei(Button btnCalcMeisaiGokei) {
        this.getServiceRiyohyoBeppyoMeisaiFooter().setBtnCalcMeisaiGokei(btnCalcMeisaiGokei);
    }

    @JsonIgnore
    public Button getBtnCancelMeisaiInput() {
        return this.getServiceRiyohyoBeppyoMeisaiFooter().getBtnCancelMeisaiInput();
    }

    @JsonIgnore
    public void  setBtnCancelMeisaiInput(Button btnCancelMeisaiInput) {
        this.getServiceRiyohyoBeppyoMeisaiFooter().setBtnCancelMeisaiInput(btnCancelMeisaiInput);
    }

    @JsonIgnore
    public Button getBtnCalcMeisai() {
        return this.getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai();
    }

    @JsonIgnore
    public void  setBtnCalcMeisai(Button btnCalcMeisai) {
        this.getServiceRiyohyoBeppyoMeisaiFooter().setBtnCalcMeisai(btnCalcMeisai);
    }

    // </editor-fold>
}
