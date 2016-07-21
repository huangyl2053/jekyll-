package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * AtenaInfo のクラスファイル<br/>
 *
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public class AtenaInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCode")
    private TextBox txtShikibetsuCode;
    @JsonProperty("txtAtenaShimeiKana")
    private TextBox txtAtenaShimeiKana;
    @JsonProperty("txtAtenaUmareYMD")
    private TextBoxDate txtAtenaUmareYMD;
    @JsonProperty("txtJuminshu")
    private TextBox txtJuminshu;
    @JsonProperty("txtAtenaShimeiKanji")
    private TextBox txtAtenaShimeiKanji;
    @JsonProperty("txtAtenaSebetsu")
    private TextBox txtAtenaSebetsu;
    @JsonProperty("txtJutoYMD")
    private TextBoxFlexibleDate txtJutoYMD;
    @JsonProperty("txtAtenaJushoKana")
    private TextBox txtAtenaJushoKana;
    @JsonProperty("txtShojoYMD")
    private TextBoxFlexibleDate txtShojoYMD;
    @JsonProperty("txtAtenaJushoKanji")
    private TextBox txtAtenaJushoKanji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBox getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtAtenaShimeiKana
     * @return txtAtenaShimeiKana
     */
    @JsonProperty("txtAtenaShimeiKana")
    public TextBox getTxtAtenaShimeiKana() {
        return txtAtenaShimeiKana;
    }

    /*
     * settxtAtenaShimeiKana
     * @param txtAtenaShimeiKana txtAtenaShimeiKana
     */
    @JsonProperty("txtAtenaShimeiKana")
    public void setTxtAtenaShimeiKana(TextBox txtAtenaShimeiKana) {
        this.txtAtenaShimeiKana = txtAtenaShimeiKana;
    }

    /*
     * gettxtAtenaUmareYMD
     * @return txtAtenaUmareYMD
     */
    @JsonProperty("txtAtenaUmareYMD")
    public TextBoxDate getTxtAtenaUmareYMD() {
        return txtAtenaUmareYMD;
    }

    /*
     * settxtAtenaUmareYMD
     * @param txtAtenaUmareYMD txtAtenaUmareYMD
     */
    @JsonProperty("txtAtenaUmareYMD")
    public void setTxtAtenaUmareYMD(TextBoxDate txtAtenaUmareYMD) {
        this.txtAtenaUmareYMD = txtAtenaUmareYMD;
    }

    /*
     * gettxtJuminshu
     * @return txtJuminshu
     */
    @JsonProperty("txtJuminshu")
    public TextBox getTxtJuminshu() {
        return txtJuminshu;
    }

    /*
     * settxtJuminshu
     * @param txtJuminshu txtJuminshu
     */
    @JsonProperty("txtJuminshu")
    public void setTxtJuminshu(TextBox txtJuminshu) {
        this.txtJuminshu = txtJuminshu;
    }

    /*
     * gettxtAtenaShimeiKanji
     * @return txtAtenaShimeiKanji
     */
    @JsonProperty("txtAtenaShimeiKanji")
    public TextBox getTxtAtenaShimeiKanji() {
        return txtAtenaShimeiKanji;
    }

    /*
     * settxtAtenaShimeiKanji
     * @param txtAtenaShimeiKanji txtAtenaShimeiKanji
     */
    @JsonProperty("txtAtenaShimeiKanji")
    public void setTxtAtenaShimeiKanji(TextBox txtAtenaShimeiKanji) {
        this.txtAtenaShimeiKanji = txtAtenaShimeiKanji;
    }

    /*
     * gettxtAtenaSebetsu
     * @return txtAtenaSebetsu
     */
    @JsonProperty("txtAtenaSebetsu")
    public TextBox getTxtAtenaSebetsu() {
        return txtAtenaSebetsu;
    }

    /*
     * settxtAtenaSebetsu
     * @param txtAtenaSebetsu txtAtenaSebetsu
     */
    @JsonProperty("txtAtenaSebetsu")
    public void setTxtAtenaSebetsu(TextBox txtAtenaSebetsu) {
        this.txtAtenaSebetsu = txtAtenaSebetsu;
    }

    /*
     * gettxtJutoYMD
     * @return txtJutoYMD
     */
    @JsonProperty("txtJutoYMD")
    public TextBoxFlexibleDate getTxtJutoYMD() {
        return txtJutoYMD;
    }

    /*
     * settxtJutoYMD
     * @param txtJutoYMD txtJutoYMD
     */
    @JsonProperty("txtJutoYMD")
    public void setTxtJutoYMD(TextBoxFlexibleDate txtJutoYMD) {
        this.txtJutoYMD = txtJutoYMD;
    }

    /*
     * gettxtAtenaJushoKana
     * @return txtAtenaJushoKana
     */
    @JsonProperty("txtAtenaJushoKana")
    public TextBox getTxtAtenaJushoKana() {
        return txtAtenaJushoKana;
    }

    /*
     * settxtAtenaJushoKana
     * @param txtAtenaJushoKana txtAtenaJushoKana
     */
    @JsonProperty("txtAtenaJushoKana")
    public void setTxtAtenaJushoKana(TextBox txtAtenaJushoKana) {
        this.txtAtenaJushoKana = txtAtenaJushoKana;
    }

    /*
     * gettxtShojoYMD
     * @return txtShojoYMD
     */
    @JsonProperty("txtShojoYMD")
    public TextBoxFlexibleDate getTxtShojoYMD() {
        return txtShojoYMD;
    }

    /*
     * settxtShojoYMD
     * @param txtShojoYMD txtShojoYMD
     */
    @JsonProperty("txtShojoYMD")
    public void setTxtShojoYMD(TextBoxFlexibleDate txtShojoYMD) {
        this.txtShojoYMD = txtShojoYMD;
    }

    /*
     * gettxtAtenaJushoKanji
     * @return txtAtenaJushoKanji
     */
    @JsonProperty("txtAtenaJushoKanji")
    public TextBox getTxtAtenaJushoKanji() {
        return txtAtenaJushoKanji;
    }

    /*
     * settxtAtenaJushoKanji
     * @param txtAtenaJushoKanji txtAtenaJushoKanji
     */
    @JsonProperty("txtAtenaJushoKanji")
    public void setTxtAtenaJushoKanji(TextBox txtAtenaJushoKanji) {
        this.txtAtenaJushoKanji = txtAtenaJushoKanji;
    }

    // </editor-fold>
}
