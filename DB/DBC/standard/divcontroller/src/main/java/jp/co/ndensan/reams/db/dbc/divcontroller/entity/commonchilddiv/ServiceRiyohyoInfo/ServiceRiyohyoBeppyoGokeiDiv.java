package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ServiceRiyohyoBeppyoGokei のクラスファイル
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoBeppyoGokeiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShuruiGendoChokaTani")
    private TextBoxNum txtShuruiGendoChokaTani;
    @JsonProperty("txtShuruiGendonaiTani")
    private TextBoxNum txtShuruiGendonaiTani;
    @JsonProperty("txtTanisuTanka")
    private TextBoxNum txtTanisuTanka;
    @JsonProperty("txtKubunGendoChokaTani")
    private TextBoxNum txtKubunGendoChokaTani;
    @JsonProperty("txtKubunGendonaiTani")
    private TextBoxNum txtKubunGendonaiTani;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("txtHiyoSogaku")
    private TextBoxNum txtHiyoSogaku;
    @JsonProperty("lblHiyoSogaku")
    private Label lblHiyoSogaku;
    @JsonProperty("txtHokenKyufugaku")
    private TextBoxNum txtHokenKyufugaku;
    @JsonProperty("lblHokenKyufugaku")
    private Label lblHokenKyufugaku;
    @JsonProperty("txtRiyoshaFutangakuHoken")
    private TextBoxNum txtRiyoshaFutangakuHoken;
    @JsonProperty("lblRiyoshaFutangakuHoken")
    private Label lblRiyoshaFutangakuHoken;
    @JsonProperty("txtRiyoshaFutangakuZengaku")
    private TextBoxNum txtRiyoshaFutangakuZengaku;
    @JsonProperty("lblRiyoshaFutangakuZengaku")
    private Label lblRiyoshaFutangakuZengaku;
    @JsonProperty("ServiceRiyohyoBeppyoGokeiFooter")
    private ServiceRiyohyoBeppyoGokeiFooterDiv ServiceRiyohyoBeppyoGokeiFooter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShuruiGendoChokaTani
     * @return txtShuruiGendoChokaTani
     */
    @JsonProperty("txtShuruiGendoChokaTani")
    public TextBoxNum getTxtShuruiGendoChokaTani() {
        return txtShuruiGendoChokaTani;
    }

    /*
     * settxtShuruiGendoChokaTani
     * @param txtShuruiGendoChokaTani txtShuruiGendoChokaTani
     */
    @JsonProperty("txtShuruiGendoChokaTani")
    public void setTxtShuruiGendoChokaTani(TextBoxNum txtShuruiGendoChokaTani) {
        this.txtShuruiGendoChokaTani = txtShuruiGendoChokaTani;
    }

    /*
     * gettxtShuruiGendonaiTani
     * @return txtShuruiGendonaiTani
     */
    @JsonProperty("txtShuruiGendonaiTani")
    public TextBoxNum getTxtShuruiGendonaiTani() {
        return txtShuruiGendonaiTani;
    }

    /*
     * settxtShuruiGendonaiTani
     * @param txtShuruiGendonaiTani txtShuruiGendonaiTani
     */
    @JsonProperty("txtShuruiGendonaiTani")
    public void setTxtShuruiGendonaiTani(TextBoxNum txtShuruiGendonaiTani) {
        this.txtShuruiGendonaiTani = txtShuruiGendonaiTani;
    }

    /*
     * gettxtTanisuTanka
     * @return txtTanisuTanka
     */
    @JsonProperty("txtTanisuTanka")
    public TextBoxNum getTxtTanisuTanka() {
        return txtTanisuTanka;
    }

    /*
     * settxtTanisuTanka
     * @param txtTanisuTanka txtTanisuTanka
     */
    @JsonProperty("txtTanisuTanka")
    public void setTxtTanisuTanka(TextBoxNum txtTanisuTanka) {
        this.txtTanisuTanka = txtTanisuTanka;
    }

    /*
     * gettxtKubunGendoChokaTani
     * @return txtKubunGendoChokaTani
     */
    @JsonProperty("txtKubunGendoChokaTani")
    public TextBoxNum getTxtKubunGendoChokaTani() {
        return txtKubunGendoChokaTani;
    }

    /*
     * settxtKubunGendoChokaTani
     * @param txtKubunGendoChokaTani txtKubunGendoChokaTani
     */
    @JsonProperty("txtKubunGendoChokaTani")
    public void setTxtKubunGendoChokaTani(TextBoxNum txtKubunGendoChokaTani) {
        this.txtKubunGendoChokaTani = txtKubunGendoChokaTani;
    }

    /*
     * gettxtKubunGendonaiTani
     * @return txtKubunGendonaiTani
     */
    @JsonProperty("txtKubunGendonaiTani")
    public TextBoxNum getTxtKubunGendonaiTani() {
        return txtKubunGendonaiTani;
    }

    /*
     * settxtKubunGendonaiTani
     * @param txtKubunGendonaiTani txtKubunGendonaiTani
     */
    @JsonProperty("txtKubunGendonaiTani")
    public void setTxtKubunGendonaiTani(TextBoxNum txtKubunGendonaiTani) {
        this.txtKubunGendonaiTani = txtKubunGendonaiTani;
    }

    /*
     * gettxtKyufuritsu
     * @return txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    /*
     * settxtKyufuritsu
     * @param txtKyufuritsu txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu = txtKyufuritsu;
    }

    /*
     * gettxtHiyoSogaku
     * @return txtHiyoSogaku
     */
    @JsonProperty("txtHiyoSogaku")
    public TextBoxNum getTxtHiyoSogaku() {
        return txtHiyoSogaku;
    }

    /*
     * settxtHiyoSogaku
     * @param txtHiyoSogaku txtHiyoSogaku
     */
    @JsonProperty("txtHiyoSogaku")
    public void setTxtHiyoSogaku(TextBoxNum txtHiyoSogaku) {
        this.txtHiyoSogaku = txtHiyoSogaku;
    }

    /*
     * getlblHiyoSogaku
     * @return lblHiyoSogaku
     */
    @JsonProperty("lblHiyoSogaku")
    public Label getLblHiyoSogaku() {
        return lblHiyoSogaku;
    }

    /*
     * setlblHiyoSogaku
     * @param lblHiyoSogaku lblHiyoSogaku
     */
    @JsonProperty("lblHiyoSogaku")
    public void setLblHiyoSogaku(Label lblHiyoSogaku) {
        this.lblHiyoSogaku = lblHiyoSogaku;
    }

    /*
     * gettxtHokenKyufugaku
     * @return txtHokenKyufugaku
     */
    @JsonProperty("txtHokenKyufugaku")
    public TextBoxNum getTxtHokenKyufugaku() {
        return txtHokenKyufugaku;
    }

    /*
     * settxtHokenKyufugaku
     * @param txtHokenKyufugaku txtHokenKyufugaku
     */
    @JsonProperty("txtHokenKyufugaku")
    public void setTxtHokenKyufugaku(TextBoxNum txtHokenKyufugaku) {
        this.txtHokenKyufugaku = txtHokenKyufugaku;
    }

    /*
     * getlblHokenKyufugaku
     * @return lblHokenKyufugaku
     */
    @JsonProperty("lblHokenKyufugaku")
    public Label getLblHokenKyufugaku() {
        return lblHokenKyufugaku;
    }

    /*
     * setlblHokenKyufugaku
     * @param lblHokenKyufugaku lblHokenKyufugaku
     */
    @JsonProperty("lblHokenKyufugaku")
    public void setLblHokenKyufugaku(Label lblHokenKyufugaku) {
        this.lblHokenKyufugaku = lblHokenKyufugaku;
    }

    /*
     * gettxtRiyoshaFutangakuHoken
     * @return txtRiyoshaFutangakuHoken
     */
    @JsonProperty("txtRiyoshaFutangakuHoken")
    public TextBoxNum getTxtRiyoshaFutangakuHoken() {
        return txtRiyoshaFutangakuHoken;
    }

    /*
     * settxtRiyoshaFutangakuHoken
     * @param txtRiyoshaFutangakuHoken txtRiyoshaFutangakuHoken
     */
    @JsonProperty("txtRiyoshaFutangakuHoken")
    public void setTxtRiyoshaFutangakuHoken(TextBoxNum txtRiyoshaFutangakuHoken) {
        this.txtRiyoshaFutangakuHoken = txtRiyoshaFutangakuHoken;
    }

    /*
     * getlblRiyoshaFutangakuHoken
     * @return lblRiyoshaFutangakuHoken
     */
    @JsonProperty("lblRiyoshaFutangakuHoken")
    public Label getLblRiyoshaFutangakuHoken() {
        return lblRiyoshaFutangakuHoken;
    }

    /*
     * setlblRiyoshaFutangakuHoken
     * @param lblRiyoshaFutangakuHoken lblRiyoshaFutangakuHoken
     */
    @JsonProperty("lblRiyoshaFutangakuHoken")
    public void setLblRiyoshaFutangakuHoken(Label lblRiyoshaFutangakuHoken) {
        this.lblRiyoshaFutangakuHoken = lblRiyoshaFutangakuHoken;
    }

    /*
     * gettxtRiyoshaFutangakuZengaku
     * @return txtRiyoshaFutangakuZengaku
     */
    @JsonProperty("txtRiyoshaFutangakuZengaku")
    public TextBoxNum getTxtRiyoshaFutangakuZengaku() {
        return txtRiyoshaFutangakuZengaku;
    }

    /*
     * settxtRiyoshaFutangakuZengaku
     * @param txtRiyoshaFutangakuZengaku txtRiyoshaFutangakuZengaku
     */
    @JsonProperty("txtRiyoshaFutangakuZengaku")
    public void setTxtRiyoshaFutangakuZengaku(TextBoxNum txtRiyoshaFutangakuZengaku) {
        this.txtRiyoshaFutangakuZengaku = txtRiyoshaFutangakuZengaku;
    }

    /*
     * getlblRiyoshaFutangakuZengaku
     * @return lblRiyoshaFutangakuZengaku
     */
    @JsonProperty("lblRiyoshaFutangakuZengaku")
    public Label getLblRiyoshaFutangakuZengaku() {
        return lblRiyoshaFutangakuZengaku;
    }

    /*
     * setlblRiyoshaFutangakuZengaku
     * @param lblRiyoshaFutangakuZengaku lblRiyoshaFutangakuZengaku
     */
    @JsonProperty("lblRiyoshaFutangakuZengaku")
    public void setLblRiyoshaFutangakuZengaku(Label lblRiyoshaFutangakuZengaku) {
        this.lblRiyoshaFutangakuZengaku = lblRiyoshaFutangakuZengaku;
    }

    /*
     * getServiceRiyohyoBeppyoGokeiFooter
     * @return ServiceRiyohyoBeppyoGokeiFooter
     */
    @JsonProperty("ServiceRiyohyoBeppyoGokeiFooter")
    public ServiceRiyohyoBeppyoGokeiFooterDiv getServiceRiyohyoBeppyoGokeiFooter() {
        return ServiceRiyohyoBeppyoGokeiFooter;
    }

    /*
     * setServiceRiyohyoBeppyoGokeiFooter
     * @param ServiceRiyohyoBeppyoGokeiFooter ServiceRiyohyoBeppyoGokeiFooter
     */
    @JsonProperty("ServiceRiyohyoBeppyoGokeiFooter")
    public void setServiceRiyohyoBeppyoGokeiFooter(ServiceRiyohyoBeppyoGokeiFooterDiv ServiceRiyohyoBeppyoGokeiFooter) {
        this.ServiceRiyohyoBeppyoGokeiFooter = ServiceRiyohyoBeppyoGokeiFooter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnBeppyoGokeiKakutei() {
        return this.getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei();
    }

    @JsonIgnore
    public void setBtnBeppyoGokeiKakutei(Button btnBeppyoGokeiKakutei) {
        this.getServiceRiyohyoBeppyoGokeiFooter().setBtnBeppyoGokeiKakutei(btnBeppyoGokeiKakutei);
    }

    @JsonIgnore
    public Button getBtnCancelGokeiInput() {
        return this.getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput();
    }

    @JsonIgnore
    public void setBtnCancelGokeiInput(Button btnCancelGokeiInput) {
        this.getServiceRiyohyoBeppyoGokeiFooter().setBtnCancelGokeiInput(btnCancelGokeiInput);
    }

    @JsonIgnore
    public Button getBtnCalcGokei() {
        return this.getServiceRiyohyoBeppyoGokeiFooter().getBtnCalcGokei();
    }

    @JsonIgnore
    public void setBtnCalcGokei(Button btnCalcGokei) {
        this.getServiceRiyohyoBeppyoGokeiFooter().setBtnCalcGokei(btnCalcGokei);
    }

    // </editor-fold>
}
