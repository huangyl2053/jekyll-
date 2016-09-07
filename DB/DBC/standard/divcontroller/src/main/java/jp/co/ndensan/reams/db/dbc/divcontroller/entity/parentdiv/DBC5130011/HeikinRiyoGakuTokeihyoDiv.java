package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HeikinRiyoGakuTokeihyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeikinRiyoGakuTokeihyoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenSaveRestore")
    private JokenSaveRestoreDiv JokenSaveRestore;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ChikuShitei")
    private ChikuShiteiDiv ChikuShitei;
    @JsonProperty("ShukeiInformation")
    private ShukeiInformationDiv ShukeiInformation;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJokenSaveRestore
     * @return JokenSaveRestore
     */
    @JsonProperty("JokenSaveRestore")
    public JokenSaveRestoreDiv getJokenSaveRestore() {
        return JokenSaveRestore;
    }

    /*
     * setJokenSaveRestore
     * @param JokenSaveRestore JokenSaveRestore
     */
    @JsonProperty("JokenSaveRestore")
    public void setJokenSaveRestore(JokenSaveRestoreDiv JokenSaveRestore) {
        this.JokenSaveRestore = JokenSaveRestore;
    }

    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getChikuShitei
     * @return ChikuShitei
     */
    @JsonProperty("ChikuShitei")
    public ChikuShiteiDiv getChikuShitei() {
        return ChikuShitei;
    }

    /*
     * setChikuShitei
     * @param ChikuShitei ChikuShitei
     */
    @JsonProperty("ChikuShitei")
    public void setChikuShitei(ChikuShiteiDiv ChikuShitei) {
        this.ChikuShitei = ChikuShitei;
    }

    /*
     * getShukeiInformation
     * @return ShukeiInformation
     */
    @JsonProperty("ShukeiInformation")
    public ShukeiInformationDiv getShukeiInformation() {
        return ShukeiInformation;
    }

    /*
     * setShukeiInformation
     * @param ShukeiInformation ShukeiInformation
     */
    @JsonProperty("ShukeiInformation")
    public void setShukeiInformation(ShukeiInformationDiv ShukeiInformation) {
        this.ShukeiInformation = ShukeiInformation;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return this.getJokenSaveRestore().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getJokenSaveRestore().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getJokenSaveRestore().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getJokenSaveRestore().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public RadioButton getRadTaishoYM() {
        return this.getChushutsuJoken().getRadTaishoYM();
    }

    @JsonIgnore
    public void  setRadTaishoYM(RadioButton radTaishoYM) {
        this.getChushutsuJoken().setRadTaishoYM(radTaishoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoYmRange() {
        return this.getChushutsuJoken().getTxtTaishoYmRange();
    }

    @JsonIgnore
    public void  setTxtTaishoYmRange(TextBoxDateRange txtTaishoYmRange) {
        this.getChushutsuJoken().setTxtTaishoYmRange(txtTaishoYmRange);
    }

    @JsonIgnore
    public Label getLblInformation1() {
        return this.getShukeiInformation().getLblInformation1();
    }

    @JsonIgnore
    public void  setLblInformation1(Label lblInformation1) {
        this.getShukeiInformation().setLblInformation1(lblInformation1);
    }

    @JsonIgnore
    public Label getLblInformation2() {
        return this.getShukeiInformation().getLblInformation2();
    }

    @JsonIgnore
    public void  setLblInformation2(Label lblInformation2) {
        this.getShukeiInformation().setLblInformation2(lblInformation2);
    }

    @JsonIgnore
    public Label getLblInformation3() {
        return this.getShukeiInformation().getLblInformation3();
    }

    @JsonIgnore
    public void  setLblInformation3(Label lblInformation3) {
        this.getShukeiInformation().setLblInformation3(lblInformation3);
    }

    @JsonIgnore
    public Label getLblInformation4() {
        return this.getShukeiInformation().getLblInformation4();
    }

    @JsonIgnore
    public void  setLblInformation4(Label lblInformation4) {
        this.getShukeiInformation().setLblInformation4(lblInformation4);
    }

    @JsonIgnore
    public Label getLblInformation5() {
        return this.getShukeiInformation().getLblInformation5();
    }

    @JsonIgnore
    public void  setLblInformation5(Label lblInformation5) {
        this.getShukeiInformation().setLblInformation5(lblInformation5);
    }

    // </editor-fold>
}
