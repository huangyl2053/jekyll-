package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SonotaShojo のクラスファイル 
 * 
 */
public class SonotaShojoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSonotaShojo")
    private RadioButton radSonotaShojo;
    @JsonProperty("txtShojomei")
    private TextBox txtShojomei;
    @JsonProperty("radSenmonJushin")
    private RadioButton radSenmonJushin;
    @JsonProperty("txtShosaiTokkiJiko")
    private TextBox txtShosaiTokkiJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSonotaShojo
     * @return radSonotaShojo
     */
    @JsonProperty("radSonotaShojo")
    public RadioButton getRadSonotaShojo() {
        return radSonotaShojo;
    }

    /*
     * setradSonotaShojo
     * @param radSonotaShojo radSonotaShojo
     */
    @JsonProperty("radSonotaShojo")
    public void setRadSonotaShojo(RadioButton radSonotaShojo) {
        this.radSonotaShojo = radSonotaShojo;
    }

    /*
     * gettxtShojomei
     * @return txtShojomei
     */
    @JsonProperty("txtShojomei")
    public TextBox getTxtShojomei() {
        return txtShojomei;
    }

    /*
     * settxtShojomei
     * @param txtShojomei txtShojomei
     */
    @JsonProperty("txtShojomei")
    public void setTxtShojomei(TextBox txtShojomei) {
        this.txtShojomei = txtShojomei;
    }

    /*
     * getradSenmonJushin
     * @return radSenmonJushin
     */
    @JsonProperty("radSenmonJushin")
    public RadioButton getRadSenmonJushin() {
        return radSenmonJushin;
    }

    /*
     * setradSenmonJushin
     * @param radSenmonJushin radSenmonJushin
     */
    @JsonProperty("radSenmonJushin")
    public void setRadSenmonJushin(RadioButton radSenmonJushin) {
        this.radSenmonJushin = radSenmonJushin;
    }

    /*
     * gettxtShosaiTokkiJiko
     * @return txtShosaiTokkiJiko
     */
    @JsonProperty("txtShosaiTokkiJiko")
    public TextBox getTxtShosaiTokkiJiko() {
        return txtShosaiTokkiJiko;
    }

    /*
     * settxtShosaiTokkiJiko
     * @param txtShosaiTokkiJiko txtShosaiTokkiJiko
     */
    @JsonProperty("txtShosaiTokkiJiko")
    public void setTxtShosaiTokkiJiko(TextBox txtShosaiTokkiJiko) {
        this.txtShosaiTokkiJiko = txtShosaiTokkiJiko;
    }

    // </editor-fold>
}
