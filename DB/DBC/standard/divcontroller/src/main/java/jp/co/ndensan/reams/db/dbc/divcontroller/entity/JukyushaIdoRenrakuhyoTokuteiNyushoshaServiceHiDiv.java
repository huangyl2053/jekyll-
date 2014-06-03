package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNinteiShinseichuKubun")
    private Label lblNinteiShinseichuKubun;
    @JsonProperty("radNinteiShinseichuKubun")
    private RadioButton radNinteiShinseichuKubun;
    @JsonProperty("lblServiceKubun")
    private Label lblServiceKubun;
    @JsonProperty("radServiceKubun")
    private RadioButton radServiceKubun;
    @JsonProperty("lblTokureiKeigenSochiTaisho")
    private Label lblTokureiKeigenSochiTaisho;
    @JsonProperty("radTokureiKeigenSochiTaisho")
    private RadioButton radTokureiKeigenSochiTaisho;
    @JsonProperty("txtShokuhiFutanGendogaku")
    private TextBoxNum txtShokuhiFutanGendogaku;
    @JsonProperty("txtFutanGendogakuTekiyoDateRange")
    private TextBoxDateRange txtFutanGendogakuTekiyoDateRange;
    @JsonProperty("lblKyojuhiFutanGendogaku")
    private Label lblKyojuhiFutanGendogaku;
    @JsonProperty("txtUnitKoshitsuGendogaku")
    private TextBoxNum txtUnitKoshitsuGendogaku;
    @JsonProperty("txtUnitJunKoshitsuFutanGendogaku")
    private TextBoxNum txtUnitJunKoshitsuFutanGendogaku;
    @JsonProperty("txtJuraigataKoshitsuTokuyoFutanGendogaku")
    private TextBoxNum txtJuraigataKoshitsuTokuyoFutanGendogaku;
    @JsonProperty("txtJuraigataKoshitsuRokenRyoyoFutanGendogaku")
    private TextBoxNum txtJuraigataKoshitsuRokenRyoyoFutanGendogaku;
    @JsonProperty("txtTashoshitsu")
    private TextBoxNum txtTashoshitsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblNinteiShinseichuKubun")
    public Label getLblNinteiShinseichuKubun() {
        return lblNinteiShinseichuKubun;
    }

    @JsonProperty("lblNinteiShinseichuKubun")
    public void setLblNinteiShinseichuKubun(Label lblNinteiShinseichuKubun) {
        this.lblNinteiShinseichuKubun=lblNinteiShinseichuKubun;
    }

    @JsonProperty("radNinteiShinseichuKubun")
    public RadioButton getRadNinteiShinseichuKubun() {
        return radNinteiShinseichuKubun;
    }

    @JsonProperty("radNinteiShinseichuKubun")
    public void setRadNinteiShinseichuKubun(RadioButton radNinteiShinseichuKubun) {
        this.radNinteiShinseichuKubun=radNinteiShinseichuKubun;
    }

    @JsonProperty("lblServiceKubun")
    public Label getLblServiceKubun() {
        return lblServiceKubun;
    }

    @JsonProperty("lblServiceKubun")
    public void setLblServiceKubun(Label lblServiceKubun) {
        this.lblServiceKubun=lblServiceKubun;
    }

    @JsonProperty("radServiceKubun")
    public RadioButton getRadServiceKubun() {
        return radServiceKubun;
    }

    @JsonProperty("radServiceKubun")
    public void setRadServiceKubun(RadioButton radServiceKubun) {
        this.radServiceKubun=radServiceKubun;
    }

    @JsonProperty("lblTokureiKeigenSochiTaisho")
    public Label getLblTokureiKeigenSochiTaisho() {
        return lblTokureiKeigenSochiTaisho;
    }

    @JsonProperty("lblTokureiKeigenSochiTaisho")
    public void setLblTokureiKeigenSochiTaisho(Label lblTokureiKeigenSochiTaisho) {
        this.lblTokureiKeigenSochiTaisho=lblTokureiKeigenSochiTaisho;
    }

    @JsonProperty("radTokureiKeigenSochiTaisho")
    public RadioButton getRadTokureiKeigenSochiTaisho() {
        return radTokureiKeigenSochiTaisho;
    }

    @JsonProperty("radTokureiKeigenSochiTaisho")
    public void setRadTokureiKeigenSochiTaisho(RadioButton radTokureiKeigenSochiTaisho) {
        this.radTokureiKeigenSochiTaisho=radTokureiKeigenSochiTaisho;
    }

    @JsonProperty("txtShokuhiFutanGendogaku")
    public TextBoxNum getTxtShokuhiFutanGendogaku() {
        return txtShokuhiFutanGendogaku;
    }

    @JsonProperty("txtShokuhiFutanGendogaku")
    public void setTxtShokuhiFutanGendogaku(TextBoxNum txtShokuhiFutanGendogaku) {
        this.txtShokuhiFutanGendogaku=txtShokuhiFutanGendogaku;
    }

    @JsonProperty("txtFutanGendogakuTekiyoDateRange")
    public TextBoxDateRange getTxtFutanGendogakuTekiyoDateRange() {
        return txtFutanGendogakuTekiyoDateRange;
    }

    @JsonProperty("txtFutanGendogakuTekiyoDateRange")
    public void setTxtFutanGendogakuTekiyoDateRange(TextBoxDateRange txtFutanGendogakuTekiyoDateRange) {
        this.txtFutanGendogakuTekiyoDateRange=txtFutanGendogakuTekiyoDateRange;
    }

    @JsonProperty("lblKyojuhiFutanGendogaku")
    public Label getLblKyojuhiFutanGendogaku() {
        return lblKyojuhiFutanGendogaku;
    }

    @JsonProperty("lblKyojuhiFutanGendogaku")
    public void setLblKyojuhiFutanGendogaku(Label lblKyojuhiFutanGendogaku) {
        this.lblKyojuhiFutanGendogaku=lblKyojuhiFutanGendogaku;
    }

    @JsonProperty("txtUnitKoshitsuGendogaku")
    public TextBoxNum getTxtUnitKoshitsuGendogaku() {
        return txtUnitKoshitsuGendogaku;
    }

    @JsonProperty("txtUnitKoshitsuGendogaku")
    public void setTxtUnitKoshitsuGendogaku(TextBoxNum txtUnitKoshitsuGendogaku) {
        this.txtUnitKoshitsuGendogaku=txtUnitKoshitsuGendogaku;
    }

    @JsonProperty("txtUnitJunKoshitsuFutanGendogaku")
    public TextBoxNum getTxtUnitJunKoshitsuFutanGendogaku() {
        return txtUnitJunKoshitsuFutanGendogaku;
    }

    @JsonProperty("txtUnitJunKoshitsuFutanGendogaku")
    public void setTxtUnitJunKoshitsuFutanGendogaku(TextBoxNum txtUnitJunKoshitsuFutanGendogaku) {
        this.txtUnitJunKoshitsuFutanGendogaku=txtUnitJunKoshitsuFutanGendogaku;
    }

    @JsonProperty("txtJuraigataKoshitsuTokuyoFutanGendogaku")
    public TextBoxNum getTxtJuraigataKoshitsuTokuyoFutanGendogaku() {
        return txtJuraigataKoshitsuTokuyoFutanGendogaku;
    }

    @JsonProperty("txtJuraigataKoshitsuTokuyoFutanGendogaku")
    public void setTxtJuraigataKoshitsuTokuyoFutanGendogaku(TextBoxNum txtJuraigataKoshitsuTokuyoFutanGendogaku) {
        this.txtJuraigataKoshitsuTokuyoFutanGendogaku=txtJuraigataKoshitsuTokuyoFutanGendogaku;
    }

    @JsonProperty("txtJuraigataKoshitsuRokenRyoyoFutanGendogaku")
    public TextBoxNum getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku() {
        return txtJuraigataKoshitsuRokenRyoyoFutanGendogaku;
    }

    @JsonProperty("txtJuraigataKoshitsuRokenRyoyoFutanGendogaku")
    public void setTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku(TextBoxNum txtJuraigataKoshitsuRokenRyoyoFutanGendogaku) {
        this.txtJuraigataKoshitsuRokenRyoyoFutanGendogaku=txtJuraigataKoshitsuRokenRyoyoFutanGendogaku;
    }

    @JsonProperty("txtTashoshitsu")
    public TextBoxNum getTxtTashoshitsu() {
        return txtTashoshitsu;
    }

    @JsonProperty("txtTashoshitsu")
    public void setTxtTashoshitsu(TextBoxNum txtTashoshitsu) {
        this.txtTashoshitsu=txtTashoshitsu;
    }

}
