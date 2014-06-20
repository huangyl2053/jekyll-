package jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei;
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
 * FutanGendogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShokuhi")
    private TextBoxNum txtShokuhi;
    @JsonProperty("txtUnitKoshitsu")
    private TextBoxNum txtUnitKoshitsu;
    @JsonProperty("txtUnitJunKoshitsu")
    private TextBoxNum txtUnitJunKoshitsu;
    @JsonProperty("txtTashoshitsu")
    private TextBoxNum txtTashoshitsu;
    @JsonProperty("txtJuraigataKoshitsuTokuyo")
    private TextBoxNum txtJuraigataKoshitsuTokuyo;
    @JsonProperty("txtJuraigataKoshitsuRoken")
    private TextBoxNum txtJuraigataKoshitsuRoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShokuhi")
    public TextBoxNum getTxtShokuhi() {
        return txtShokuhi;
    }

    @JsonProperty("txtShokuhi")
    public void setTxtShokuhi(TextBoxNum txtShokuhi) {
        this.txtShokuhi=txtShokuhi;
    }

    @JsonProperty("txtUnitKoshitsu")
    public TextBoxNum getTxtUnitKoshitsu() {
        return txtUnitKoshitsu;
    }

    @JsonProperty("txtUnitKoshitsu")
    public void setTxtUnitKoshitsu(TextBoxNum txtUnitKoshitsu) {
        this.txtUnitKoshitsu=txtUnitKoshitsu;
    }

    @JsonProperty("txtUnitJunKoshitsu")
    public TextBoxNum getTxtUnitJunKoshitsu() {
        return txtUnitJunKoshitsu;
    }

    @JsonProperty("txtUnitJunKoshitsu")
    public void setTxtUnitJunKoshitsu(TextBoxNum txtUnitJunKoshitsu) {
        this.txtUnitJunKoshitsu=txtUnitJunKoshitsu;
    }

    @JsonProperty("txtTashoshitsu")
    public TextBoxNum getTxtTashoshitsu() {
        return txtTashoshitsu;
    }

    @JsonProperty("txtTashoshitsu")
    public void setTxtTashoshitsu(TextBoxNum txtTashoshitsu) {
        this.txtTashoshitsu=txtTashoshitsu;
    }

    @JsonProperty("txtJuraigataKoshitsuTokuyo")
    public TextBoxNum getTxtJuraigataKoshitsuTokuyo() {
        return txtJuraigataKoshitsuTokuyo;
    }

    @JsonProperty("txtJuraigataKoshitsuTokuyo")
    public void setTxtJuraigataKoshitsuTokuyo(TextBoxNum txtJuraigataKoshitsuTokuyo) {
        this.txtJuraigataKoshitsuTokuyo=txtJuraigataKoshitsuTokuyo;
    }

    @JsonProperty("txtJuraigataKoshitsuRoken")
    public TextBoxNum getTxtJuraigataKoshitsuRoken() {
        return txtJuraigataKoshitsuRoken;
    }

    @JsonProperty("txtJuraigataKoshitsuRoken")
    public void setTxtJuraigataKoshitsuRoken(TextBoxNum txtJuraigataKoshitsuRoken) {
        this.txtJuraigataKoshitsuRoken=txtJuraigataKoshitsuRoken;
    }

}
