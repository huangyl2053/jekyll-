package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinshinIken;
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
 * @author 自動生成
 */
public class SonotaShojoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkSonotaShojo")
    private CheckBoxList chkSonotaShojo;
    @JsonProperty("txtShojomei")
    private TextBox txtShojomei;
    @JsonProperty("chkSenmonJushin")
    private CheckBoxList chkSenmonJushin;
    @JsonProperty("txtShosaiTokkiJiko")
    private TextBox txtShosaiTokkiJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkSonotaShojo")
    public CheckBoxList getChkSonotaShojo() {
        return chkSonotaShojo;
    }

    @JsonProperty("chkSonotaShojo")
    public void setChkSonotaShojo(CheckBoxList chkSonotaShojo) {
        this.chkSonotaShojo=chkSonotaShojo;
    }

    @JsonProperty("txtShojomei")
    public TextBox getTxtShojomei() {
        return txtShojomei;
    }

    @JsonProperty("txtShojomei")
    public void setTxtShojomei(TextBox txtShojomei) {
        this.txtShojomei=txtShojomei;
    }

    @JsonProperty("chkSenmonJushin")
    public CheckBoxList getChkSenmonJushin() {
        return chkSenmonJushin;
    }

    @JsonProperty("chkSenmonJushin")
    public void setChkSenmonJushin(CheckBoxList chkSenmonJushin) {
        this.chkSenmonJushin=chkSenmonJushin;
    }

    @JsonProperty("txtShosaiTokkiJiko")
    public TextBox getTxtShosaiTokkiJiko() {
        return txtShosaiTokkiJiko;
    }

    @JsonProperty("txtShosaiTokkiJiko")
    public void setTxtShosaiTokkiJiko(TextBox txtShosaiTokkiJiko) {
        this.txtShosaiTokkiJiko=txtShosaiTokkiJiko;
    }

    // </editor-fold>
}
