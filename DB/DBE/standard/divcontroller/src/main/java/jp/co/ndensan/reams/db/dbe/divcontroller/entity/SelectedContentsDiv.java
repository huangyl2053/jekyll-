package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * SelectedContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class SelectedContentsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtiryoKikanCode")
    private TextBoxCode txtiryoKikanCode;
    @JsonProperty("txtiryoKikanName")
    private TextBox txtiryoKikanName;
    @JsonProperty("txtishiCode")
    private TextBoxCode txtishiCode;
    @JsonProperty("txtishiName")
    private TextBox txtishiName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtiryoKikanCode")
    public TextBoxCode getTxtiryoKikanCode() {
        return txtiryoKikanCode;
    }

    @JsonProperty("txtiryoKikanCode")
    public void setTxtiryoKikanCode(TextBoxCode txtiryoKikanCode) {
        this.txtiryoKikanCode=txtiryoKikanCode;
    }

    @JsonProperty("txtiryoKikanName")
    public TextBox getTxtiryoKikanName() {
        return txtiryoKikanName;
    }

    @JsonProperty("txtiryoKikanName")
    public void setTxtiryoKikanName(TextBox txtiryoKikanName) {
        this.txtiryoKikanName=txtiryoKikanName;
    }

    @JsonProperty("txtishiCode")
    public TextBoxCode getTxtishiCode() {
        return txtishiCode;
    }

    @JsonProperty("txtishiCode")
    public void setTxtishiCode(TextBoxCode txtishiCode) {
        this.txtishiCode=txtishiCode;
    }

    @JsonProperty("txtishiName")
    public TextBox getTxtishiName() {
        return txtishiName;
    }

    @JsonProperty("txtishiName")
    public void setTxtishiName(TextBox txtishiName) {
        this.txtishiName=txtishiName;
    }

}
