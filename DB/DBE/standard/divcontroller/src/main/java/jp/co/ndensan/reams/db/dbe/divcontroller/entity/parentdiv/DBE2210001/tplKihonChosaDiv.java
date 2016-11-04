package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKihonChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKihonChosaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKiteichiSettei")
    private Button btnKiteichiSettei;
    @JsonProperty("btnZenkaiCopy")
    private Button btnZenkaiCopy;
    @JsonProperty("txtIchijiHanteiKekka")
    private TextBox txtIchijiHanteiKekka;
    @JsonProperty("btnIchiHanteiJisshi")
    private ButtonDialog btnIchiHanteiJisshi;
    @JsonProperty("kihonchosaSelect")
    private kihonchosaSelectDiv kihonchosaSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKiteichiSettei
     * @return btnKiteichiSettei
     */
    @JsonProperty("btnKiteichiSettei")
    public Button getBtnKiteichiSettei() {
        return btnKiteichiSettei;
    }

    /*
     * setbtnKiteichiSettei
     * @param btnKiteichiSettei btnKiteichiSettei
     */
    @JsonProperty("btnKiteichiSettei")
    public void setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.btnKiteichiSettei = btnKiteichiSettei;
    }

    /*
     * getbtnZenkaiCopy
     * @return btnZenkaiCopy
     */
    @JsonProperty("btnZenkaiCopy")
    public Button getBtnZenkaiCopy() {
        return btnZenkaiCopy;
    }

    /*
     * setbtnZenkaiCopy
     * @param btnZenkaiCopy btnZenkaiCopy
     */
    @JsonProperty("btnZenkaiCopy")
    public void setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.btnZenkaiCopy = btnZenkaiCopy;
    }

    /*
     * gettxtIchijiHanteiKekka
     * @return txtIchijiHanteiKekka
     */
    @JsonProperty("txtIchijiHanteiKekka")
    public TextBox getTxtIchijiHanteiKekka() {
        return txtIchijiHanteiKekka;
    }

    /*
     * settxtIchijiHanteiKekka
     * @param txtIchijiHanteiKekka txtIchijiHanteiKekka
     */
    @JsonProperty("txtIchijiHanteiKekka")
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.txtIchijiHanteiKekka = txtIchijiHanteiKekka;
    }

    /*
     * getbtnIchiHanteiJisshi
     * @return btnIchiHanteiJisshi
     */
    @JsonProperty("btnIchiHanteiJisshi")
    public ButtonDialog getBtnIchiHanteiJisshi() {
        return btnIchiHanteiJisshi;
    }

    /*
     * setbtnIchiHanteiJisshi
     * @param btnIchiHanteiJisshi btnIchiHanteiJisshi
     */
    @JsonProperty("btnIchiHanteiJisshi")
    public void setBtnIchiHanteiJisshi(ButtonDialog btnIchiHanteiJisshi) {
        this.btnIchiHanteiJisshi = btnIchiHanteiJisshi;
    }

    /*
     * getkihonchosaSelect
     * @return kihonchosaSelect
     */
    @JsonProperty("kihonchosaSelect")
    public kihonchosaSelectDiv getKihonchosaSelect() {
        return kihonchosaSelect;
    }

    /*
     * setkihonchosaSelect
     * @param kihonchosaSelect kihonchosaSelect
     */
    @JsonProperty("kihonchosaSelect")
    public void setKihonchosaSelect(kihonchosaSelectDiv kihonchosaSelect) {
        this.kihonchosaSelect = kihonchosaSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnKihonchosa1() {
        return this.getKihonchosaSelect().getBtnKihonchosa1();
    }

    @JsonIgnore
    public void  setBtnKihonchosa1(ButtonDialog btnKihonchosa1) {
        this.getKihonchosaSelect().setBtnKihonchosa1(btnKihonchosa1);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa2() {
        return this.getKihonchosaSelect().getBtnKihonchosa2();
    }

    @JsonIgnore
    public void  setBtnKihonchosa2(ButtonDialog btnKihonchosa2) {
        this.getKihonchosaSelect().setBtnKihonchosa2(btnKihonchosa2);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa3() {
        return this.getKihonchosaSelect().getBtnKihonchosa3();
    }

    @JsonIgnore
    public void  setBtnKihonchosa3(ButtonDialog btnKihonchosa3) {
        this.getKihonchosaSelect().setBtnKihonchosa3(btnKihonchosa3);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa4() {
        return this.getKihonchosaSelect().getBtnKihonchosa4();
    }

    @JsonIgnore
    public void  setBtnKihonchosa4(ButtonDialog btnKihonchosa4) {
        this.getKihonchosaSelect().setBtnKihonchosa4(btnKihonchosa4);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa5() {
        return this.getKihonchosaSelect().getBtnKihonchosa5();
    }

    @JsonIgnore
    public void  setBtnKihonchosa5(ButtonDialog btnKihonchosa5) {
        this.getKihonchosaSelect().setBtnKihonchosa5(btnKihonchosa5);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa6() {
        return this.getKihonchosaSelect().getBtnKihonchosa6();
    }

    @JsonIgnore
    public void  setBtnKihonchosa6(ButtonDialog btnKihonchosa6) {
        this.getKihonchosaSelect().setBtnKihonchosa6(btnKihonchosa6);
    }

    @JsonIgnore
    public ButtonDialog getBtnKihonchosa7() {
        return this.getKihonchosaSelect().getBtnKihonchosa7();
    }

    @JsonIgnore
    public void  setBtnKihonchosa7(ButtonDialog btnKihonchosa7) {
        this.getKihonchosaSelect().setBtnKihonchosa7(btnKihonchosa7);
    }

    // </editor-fold>
}
