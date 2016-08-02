package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiKekkaTsuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiKekkaTsuchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNinteiKekkaRireki")
    private RadioButton radNinteiKekkaRireki;
    @JsonProperty("txtNinteiKekkaSakuseiDay")
    private TextBoxFlexibleDate txtNinteiKekkaSakuseiDay;
    @JsonProperty("txtNinteikekkaJoho")
    private TextBox txtNinteikekkaJoho;
    @JsonProperty("txtNinteiKekka")
    private TextBoxDateRange txtNinteiKekka;
    @JsonProperty("txtNinteiKekkaShinsakaiIken")
    private TextBoxMultiLine txtNinteiKekkaShinsakaiIken;
    @JsonProperty("txtNinteiKekkaRiyu")
    private TextBoxMultiLine txtNinteiKekkaRiyu;
    @JsonProperty("ccdKobetsuNinteiKekkaBunshoBango")
    private BunshoBangoInputDiv ccdKobetsuNinteiKekkaBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradNinteiKekkaRireki
     * @return radNinteiKekkaRireki
     */
    @JsonProperty("radNinteiKekkaRireki")
    public RadioButton getRadNinteiKekkaRireki() {
        return radNinteiKekkaRireki;
    }

    /*
     * setradNinteiKekkaRireki
     * @param radNinteiKekkaRireki radNinteiKekkaRireki
     */
    @JsonProperty("radNinteiKekkaRireki")
    public void setRadNinteiKekkaRireki(RadioButton radNinteiKekkaRireki) {
        this.radNinteiKekkaRireki = radNinteiKekkaRireki;
    }

    /*
     * gettxtNinteiKekkaSakuseiDay
     * @return txtNinteiKekkaSakuseiDay
     */
    @JsonProperty("txtNinteiKekkaSakuseiDay")
    public TextBoxFlexibleDate getTxtNinteiKekkaSakuseiDay() {
        return txtNinteiKekkaSakuseiDay;
    }

    /*
     * settxtNinteiKekkaSakuseiDay
     * @param txtNinteiKekkaSakuseiDay txtNinteiKekkaSakuseiDay
     */
    @JsonProperty("txtNinteiKekkaSakuseiDay")
    public void setTxtNinteiKekkaSakuseiDay(TextBoxFlexibleDate txtNinteiKekkaSakuseiDay) {
        this.txtNinteiKekkaSakuseiDay = txtNinteiKekkaSakuseiDay;
    }

    /*
     * gettxtNinteikekkaJoho
     * @return txtNinteikekkaJoho
     */
    @JsonProperty("txtNinteikekkaJoho")
    public TextBox getTxtNinteikekkaJoho() {
        return txtNinteikekkaJoho;
    }

    /*
     * settxtNinteikekkaJoho
     * @param txtNinteikekkaJoho txtNinteikekkaJoho
     */
    @JsonProperty("txtNinteikekkaJoho")
    public void setTxtNinteikekkaJoho(TextBox txtNinteikekkaJoho) {
        this.txtNinteikekkaJoho = txtNinteikekkaJoho;
    }

    /*
     * gettxtNinteiKekka
     * @return txtNinteiKekka
     */
    @JsonProperty("txtNinteiKekka")
    public TextBoxDateRange getTxtNinteiKekka() {
        return txtNinteiKekka;
    }

    /*
     * settxtNinteiKekka
     * @param txtNinteiKekka txtNinteiKekka
     */
    @JsonProperty("txtNinteiKekka")
    public void setTxtNinteiKekka(TextBoxDateRange txtNinteiKekka) {
        this.txtNinteiKekka = txtNinteiKekka;
    }

    /*
     * gettxtNinteiKekkaShinsakaiIken
     * @return txtNinteiKekkaShinsakaiIken
     */
    @JsonProperty("txtNinteiKekkaShinsakaiIken")
    public TextBoxMultiLine getTxtNinteiKekkaShinsakaiIken() {
        return txtNinteiKekkaShinsakaiIken;
    }

    /*
     * settxtNinteiKekkaShinsakaiIken
     * @param txtNinteiKekkaShinsakaiIken txtNinteiKekkaShinsakaiIken
     */
    @JsonProperty("txtNinteiKekkaShinsakaiIken")
    public void setTxtNinteiKekkaShinsakaiIken(TextBoxMultiLine txtNinteiKekkaShinsakaiIken) {
        this.txtNinteiKekkaShinsakaiIken = txtNinteiKekkaShinsakaiIken;
    }

    /*
     * gettxtNinteiKekkaRiyu
     * @return txtNinteiKekkaRiyu
     */
    @JsonProperty("txtNinteiKekkaRiyu")
    public TextBoxMultiLine getTxtNinteiKekkaRiyu() {
        return txtNinteiKekkaRiyu;
    }

    /*
     * settxtNinteiKekkaRiyu
     * @param txtNinteiKekkaRiyu txtNinteiKekkaRiyu
     */
    @JsonProperty("txtNinteiKekkaRiyu")
    public void setTxtNinteiKekkaRiyu(TextBoxMultiLine txtNinteiKekkaRiyu) {
        this.txtNinteiKekkaRiyu = txtNinteiKekkaRiyu;
    }

    /*
     * getccdKobetsuNinteiKekkaBunshoBango
     * @return ccdKobetsuNinteiKekkaBunshoBango
     */
    @JsonProperty("ccdKobetsuNinteiKekkaBunshoBango")
    public IBunshoBangoInputDiv getCcdKobetsuNinteiKekkaBunshoBango() {
        return ccdKobetsuNinteiKekkaBunshoBango;
    }

    // </editor-fold>
}
