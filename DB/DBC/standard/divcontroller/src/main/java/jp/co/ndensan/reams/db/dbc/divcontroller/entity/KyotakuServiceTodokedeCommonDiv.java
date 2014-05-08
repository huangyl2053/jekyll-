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
 * KyotakuServiceTodokedeCommon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceTodokedeCommonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtPlanSakuseiKubun1")
    private TextBox txtPlanSakuseiKubun1;
    @JsonProperty("txtPlanSakuseiKubun2")
    private TextBox txtPlanSakuseiKubun2;
    @JsonProperty("txtPlanSakuseiKubun3")
    private TextBox txtPlanSakuseiKubun3;
    @JsonProperty("txtTodokedeStatus1")
    private TextBox txtTodokedeStatus1;
    @JsonProperty("txtTodokedeStatus2")
    private TextBox txtTodokedeStatus2;
    @JsonProperty("txtTodokedeStatus3")
    private TextBox txtTodokedeStatus3;
    @JsonProperty("txtTodokedeStatus4")
    private TextBox txtTodokedeStatus4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtPlanSakuseiKubun1")
    public TextBox getTxtPlanSakuseiKubun1() {
        return txtPlanSakuseiKubun1;
    }

    @JsonProperty("txtPlanSakuseiKubun1")
    public void setTxtPlanSakuseiKubun1(TextBox txtPlanSakuseiKubun1) {
        this.txtPlanSakuseiKubun1=txtPlanSakuseiKubun1;
    }

    @JsonProperty("txtPlanSakuseiKubun2")
    public TextBox getTxtPlanSakuseiKubun2() {
        return txtPlanSakuseiKubun2;
    }

    @JsonProperty("txtPlanSakuseiKubun2")
    public void setTxtPlanSakuseiKubun2(TextBox txtPlanSakuseiKubun2) {
        this.txtPlanSakuseiKubun2=txtPlanSakuseiKubun2;
    }

    @JsonProperty("txtPlanSakuseiKubun3")
    public TextBox getTxtPlanSakuseiKubun3() {
        return txtPlanSakuseiKubun3;
    }

    @JsonProperty("txtPlanSakuseiKubun3")
    public void setTxtPlanSakuseiKubun3(TextBox txtPlanSakuseiKubun3) {
        this.txtPlanSakuseiKubun3=txtPlanSakuseiKubun3;
    }

    @JsonProperty("txtTodokedeStatus1")
    public TextBox getTxtTodokedeStatus1() {
        return txtTodokedeStatus1;
    }

    @JsonProperty("txtTodokedeStatus1")
    public void setTxtTodokedeStatus1(TextBox txtTodokedeStatus1) {
        this.txtTodokedeStatus1=txtTodokedeStatus1;
    }

    @JsonProperty("txtTodokedeStatus2")
    public TextBox getTxtTodokedeStatus2() {
        return txtTodokedeStatus2;
    }

    @JsonProperty("txtTodokedeStatus2")
    public void setTxtTodokedeStatus2(TextBox txtTodokedeStatus2) {
        this.txtTodokedeStatus2=txtTodokedeStatus2;
    }

    @JsonProperty("txtTodokedeStatus3")
    public TextBox getTxtTodokedeStatus3() {
        return txtTodokedeStatus3;
    }

    @JsonProperty("txtTodokedeStatus3")
    public void setTxtTodokedeStatus3(TextBox txtTodokedeStatus3) {
        this.txtTodokedeStatus3=txtTodokedeStatus3;
    }

    @JsonProperty("txtTodokedeStatus4")
    public TextBox getTxtTodokedeStatus4() {
        return txtTodokedeStatus4;
    }

    @JsonProperty("txtTodokedeStatus4")
    public void setTxtTodokedeStatus4(TextBox txtTodokedeStatus4) {
        this.txtTodokedeStatus4=txtTodokedeStatus4;
    }

}
