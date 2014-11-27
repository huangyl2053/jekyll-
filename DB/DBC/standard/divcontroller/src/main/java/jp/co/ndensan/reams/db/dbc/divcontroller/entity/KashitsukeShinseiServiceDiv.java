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
 * KashitsukeShinseiService のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeShinseiServiceDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtService1")
    private TextBox txtService1;
    @JsonProperty("txtService2")
    private TextBox txtService2;
    @JsonProperty("txtService3")
    private TextBox txtService3;
    @JsonProperty("txtService4")
    private TextBox txtService4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtService1")
    public TextBox getTxtService1() {
        return txtService1;
    }

    @JsonProperty("txtService1")
    public void setTxtService1(TextBox txtService1) {
        this.txtService1=txtService1;
    }

    @JsonProperty("txtService2")
    public TextBox getTxtService2() {
        return txtService2;
    }

    @JsonProperty("txtService2")
    public void setTxtService2(TextBox txtService2) {
        this.txtService2=txtService2;
    }

    @JsonProperty("txtService3")
    public TextBox getTxtService3() {
        return txtService3;
    }

    @JsonProperty("txtService3")
    public void setTxtService3(TextBox txtService3) {
        this.txtService3=txtService3;
    }

    @JsonProperty("txtService4")
    public TextBox getTxtService4() {
        return txtService4;
    }

    @JsonProperty("txtService4")
    public void setTxtService4(TextBox txtService4) {
        this.txtService4=txtService4;
    }

}
