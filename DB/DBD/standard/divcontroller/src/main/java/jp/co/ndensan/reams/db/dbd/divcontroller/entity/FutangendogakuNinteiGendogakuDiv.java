package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
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
 * FutangendogakuNinteiGendogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutangendogakuNinteiGendogakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShokuhi")
    private Label lblShokuhi;
    @JsonProperty("txtShokuhi")
    private TextBoxNum txtShokuhi;
    @JsonProperty("lblShokuhiYen")
    private Label lblShokuhiYen;
    @JsonProperty("lblUnitgataKoshitsu")
    private Label lblUnitgataKoshitsu;
    @JsonProperty("txtUnitKoshitsu")
    private TextBoxNum txtUnitKoshitsu;
    @JsonProperty("lblUnitKoshitsuYen")
    private Label lblUnitKoshitsuYen;
    @JsonProperty("lblUnitJunKoshitsu")
    private Label lblUnitJunKoshitsu;
    @JsonProperty("txtUnitJunKoshitsu")
    private TextBoxNum txtUnitJunKoshitsu;
    @JsonProperty("lblUnitJungataKoshitsuYen")
    private Label lblUnitJungataKoshitsuYen;
    @JsonProperty("lblTashoshitsu")
    private Label lblTashoshitsu;
    @JsonProperty("txtTashoshitsu")
    private TextBoxNum txtTashoshitsu;
    @JsonProperty("lblTashoshitsuYen")
    private Label lblTashoshitsuYen;
    @JsonProperty("lblJuraigataKoshitsuTokuyo")
    private Label lblJuraigataKoshitsuTokuyo;
    @JsonProperty("txtJuraigataKoshitsuTokuyo")
    private TextBoxNum txtJuraigataKoshitsuTokuyo;
    @JsonProperty("lblJuraigataKoshitsuTokuyoYen")
    private Label lblJuraigataKoshitsuTokuyoYen;
    @JsonProperty("lblJuraigataKoshitsuRoken")
    private Label lblJuraigataKoshitsuRoken;
    @JsonProperty("txtJuraigataKoshitsuRoken")
    private TextBoxNum txtJuraigataKoshitsuRoken;
    @JsonProperty("lblJuraigataKoshitsuRokenYen")
    private Label lblJuraigataKoshitsuRokenYen;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShokuhi")
    public Label getLblShokuhi() {
        return lblShokuhi;
    }

    @JsonProperty("lblShokuhi")
    public void setLblShokuhi(Label lblShokuhi) {
        this.lblShokuhi=lblShokuhi;
    }

    @JsonProperty("txtShokuhi")
    public TextBoxNum getTxtShokuhi() {
        return txtShokuhi;
    }

    @JsonProperty("txtShokuhi")
    public void setTxtShokuhi(TextBoxNum txtShokuhi) {
        this.txtShokuhi=txtShokuhi;
    }

    @JsonProperty("lblShokuhiYen")
    public Label getLblShokuhiYen() {
        return lblShokuhiYen;
    }

    @JsonProperty("lblShokuhiYen")
    public void setLblShokuhiYen(Label lblShokuhiYen) {
        this.lblShokuhiYen=lblShokuhiYen;
    }

    @JsonProperty("lblUnitgataKoshitsu")
    public Label getLblUnitgataKoshitsu() {
        return lblUnitgataKoshitsu;
    }

    @JsonProperty("lblUnitgataKoshitsu")
    public void setLblUnitgataKoshitsu(Label lblUnitgataKoshitsu) {
        this.lblUnitgataKoshitsu=lblUnitgataKoshitsu;
    }

    @JsonProperty("txtUnitKoshitsu")
    public TextBoxNum getTxtUnitKoshitsu() {
        return txtUnitKoshitsu;
    }

    @JsonProperty("txtUnitKoshitsu")
    public void setTxtUnitKoshitsu(TextBoxNum txtUnitKoshitsu) {
        this.txtUnitKoshitsu=txtUnitKoshitsu;
    }

    @JsonProperty("lblUnitKoshitsuYen")
    public Label getLblUnitKoshitsuYen() {
        return lblUnitKoshitsuYen;
    }

    @JsonProperty("lblUnitKoshitsuYen")
    public void setLblUnitKoshitsuYen(Label lblUnitKoshitsuYen) {
        this.lblUnitKoshitsuYen=lblUnitKoshitsuYen;
    }

    @JsonProperty("lblUnitJunKoshitsu")
    public Label getLblUnitJunKoshitsu() {
        return lblUnitJunKoshitsu;
    }

    @JsonProperty("lblUnitJunKoshitsu")
    public void setLblUnitJunKoshitsu(Label lblUnitJunKoshitsu) {
        this.lblUnitJunKoshitsu=lblUnitJunKoshitsu;
    }

    @JsonProperty("txtUnitJunKoshitsu")
    public TextBoxNum getTxtUnitJunKoshitsu() {
        return txtUnitJunKoshitsu;
    }

    @JsonProperty("txtUnitJunKoshitsu")
    public void setTxtUnitJunKoshitsu(TextBoxNum txtUnitJunKoshitsu) {
        this.txtUnitJunKoshitsu=txtUnitJunKoshitsu;
    }

    @JsonProperty("lblUnitJungataKoshitsuYen")
    public Label getLblUnitJungataKoshitsuYen() {
        return lblUnitJungataKoshitsuYen;
    }

    @JsonProperty("lblUnitJungataKoshitsuYen")
    public void setLblUnitJungataKoshitsuYen(Label lblUnitJungataKoshitsuYen) {
        this.lblUnitJungataKoshitsuYen=lblUnitJungataKoshitsuYen;
    }

    @JsonProperty("lblTashoshitsu")
    public Label getLblTashoshitsu() {
        return lblTashoshitsu;
    }

    @JsonProperty("lblTashoshitsu")
    public void setLblTashoshitsu(Label lblTashoshitsu) {
        this.lblTashoshitsu=lblTashoshitsu;
    }

    @JsonProperty("txtTashoshitsu")
    public TextBoxNum getTxtTashoshitsu() {
        return txtTashoshitsu;
    }

    @JsonProperty("txtTashoshitsu")
    public void setTxtTashoshitsu(TextBoxNum txtTashoshitsu) {
        this.txtTashoshitsu=txtTashoshitsu;
    }

    @JsonProperty("lblTashoshitsuYen")
    public Label getLblTashoshitsuYen() {
        return lblTashoshitsuYen;
    }

    @JsonProperty("lblTashoshitsuYen")
    public void setLblTashoshitsuYen(Label lblTashoshitsuYen) {
        this.lblTashoshitsuYen=lblTashoshitsuYen;
    }

    @JsonProperty("lblJuraigataKoshitsuTokuyo")
    public Label getLblJuraigataKoshitsuTokuyo() {
        return lblJuraigataKoshitsuTokuyo;
    }

    @JsonProperty("lblJuraigataKoshitsuTokuyo")
    public void setLblJuraigataKoshitsuTokuyo(Label lblJuraigataKoshitsuTokuyo) {
        this.lblJuraigataKoshitsuTokuyo=lblJuraigataKoshitsuTokuyo;
    }

    @JsonProperty("txtJuraigataKoshitsuTokuyo")
    public TextBoxNum getTxtJuraigataKoshitsuTokuyo() {
        return txtJuraigataKoshitsuTokuyo;
    }

    @JsonProperty("txtJuraigataKoshitsuTokuyo")
    public void setTxtJuraigataKoshitsuTokuyo(TextBoxNum txtJuraigataKoshitsuTokuyo) {
        this.txtJuraigataKoshitsuTokuyo=txtJuraigataKoshitsuTokuyo;
    }

    @JsonProperty("lblJuraigataKoshitsuTokuyoYen")
    public Label getLblJuraigataKoshitsuTokuyoYen() {
        return lblJuraigataKoshitsuTokuyoYen;
    }

    @JsonProperty("lblJuraigataKoshitsuTokuyoYen")
    public void setLblJuraigataKoshitsuTokuyoYen(Label lblJuraigataKoshitsuTokuyoYen) {
        this.lblJuraigataKoshitsuTokuyoYen=lblJuraigataKoshitsuTokuyoYen;
    }

    @JsonProperty("lblJuraigataKoshitsuRoken")
    public Label getLblJuraigataKoshitsuRoken() {
        return lblJuraigataKoshitsuRoken;
    }

    @JsonProperty("lblJuraigataKoshitsuRoken")
    public void setLblJuraigataKoshitsuRoken(Label lblJuraigataKoshitsuRoken) {
        this.lblJuraigataKoshitsuRoken=lblJuraigataKoshitsuRoken;
    }

    @JsonProperty("txtJuraigataKoshitsuRoken")
    public TextBoxNum getTxtJuraigataKoshitsuRoken() {
        return txtJuraigataKoshitsuRoken;
    }

    @JsonProperty("txtJuraigataKoshitsuRoken")
    public void setTxtJuraigataKoshitsuRoken(TextBoxNum txtJuraigataKoshitsuRoken) {
        this.txtJuraigataKoshitsuRoken=txtJuraigataKoshitsuRoken;
    }

    @JsonProperty("lblJuraigataKoshitsuRokenYen")
    public Label getLblJuraigataKoshitsuRokenYen() {
        return lblJuraigataKoshitsuRokenYen;
    }

    @JsonProperty("lblJuraigataKoshitsuRokenYen")
    public void setLblJuraigataKoshitsuRokenYen(Label lblJuraigataKoshitsuRokenYen) {
        this.lblJuraigataKoshitsuRokenYen=lblJuraigataKoshitsuRokenYen;
    }

}
