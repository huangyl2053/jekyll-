package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IPrintContentsSettingDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PrintContentsSetting のクラスファイル 
 * 
 * @author 自動生成
 */
public class PrintContentsSettingDiv extends Panel implements IPrintContentsSettingDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIssueDate")
    private TextBoxDate txtIssueDate;
    @JsonProperty("txtSendDate")
    private TextBoxDate txtSendDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIssueDate")
    public TextBoxDate getTxtIssueDate() {
        return txtIssueDate;
    }

    @JsonProperty("txtIssueDate")
    public void setTxtIssueDate(TextBoxDate txtIssueDate) {
        this.txtIssueDate=txtIssueDate;
    }

    @JsonProperty("txtSendDate")
    public TextBoxDate getTxtSendDate() {
        return txtSendDate;
    }

    @JsonProperty("txtSendDate")
    public void setTxtSendDate(TextBoxDate txtSendDate) {
        this.txtSendDate=txtSendDate;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
