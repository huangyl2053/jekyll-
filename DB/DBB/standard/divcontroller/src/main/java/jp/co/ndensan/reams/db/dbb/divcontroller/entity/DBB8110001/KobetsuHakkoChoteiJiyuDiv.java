package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001;
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
 * KobetsuHakkoChoteiJiyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuHakkoChoteiJiyuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKobetsuHakkoChoteiJiyu")
    private RadioButton radKobetsuHakkoChoteiJiyu;
    @JsonProperty("txtChoteiJiyu1")
    private TextBox txtChoteiJiyu1;
    @JsonProperty("txtChoteiJiyu2")
    private TextBox txtChoteiJiyu2;
    @JsonProperty("txtChoteiJiyu3")
    private TextBox txtChoteiJiyu3;
    @JsonProperty("txtChoteiJiyu4")
    private TextBox txtChoteiJiyu4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radKobetsuHakkoChoteiJiyu")
    public RadioButton getRadKobetsuHakkoChoteiJiyu() {
        return radKobetsuHakkoChoteiJiyu;
    }

    @JsonProperty("radKobetsuHakkoChoteiJiyu")
    public void setRadKobetsuHakkoChoteiJiyu(RadioButton radKobetsuHakkoChoteiJiyu) {
        this.radKobetsuHakkoChoteiJiyu=radKobetsuHakkoChoteiJiyu;
    }

    @JsonProperty("txtChoteiJiyu1")
    public TextBox getTxtChoteiJiyu1() {
        return txtChoteiJiyu1;
    }

    @JsonProperty("txtChoteiJiyu1")
    public void setTxtChoteiJiyu1(TextBox txtChoteiJiyu1) {
        this.txtChoteiJiyu1=txtChoteiJiyu1;
    }

    @JsonProperty("txtChoteiJiyu2")
    public TextBox getTxtChoteiJiyu2() {
        return txtChoteiJiyu2;
    }

    @JsonProperty("txtChoteiJiyu2")
    public void setTxtChoteiJiyu2(TextBox txtChoteiJiyu2) {
        this.txtChoteiJiyu2=txtChoteiJiyu2;
    }

    @JsonProperty("txtChoteiJiyu3")
    public TextBox getTxtChoteiJiyu3() {
        return txtChoteiJiyu3;
    }

    @JsonProperty("txtChoteiJiyu3")
    public void setTxtChoteiJiyu3(TextBox txtChoteiJiyu3) {
        this.txtChoteiJiyu3=txtChoteiJiyu3;
    }

    @JsonProperty("txtChoteiJiyu4")
    public TextBox getTxtChoteiJiyu4() {
        return txtChoteiJiyu4;
    }

    @JsonProperty("txtChoteiJiyu4")
    public void setTxtChoteiJiyu4(TextBox txtChoteiJiyu4) {
        this.txtChoteiJiyu4=txtChoteiJiyu4;
    }

}
