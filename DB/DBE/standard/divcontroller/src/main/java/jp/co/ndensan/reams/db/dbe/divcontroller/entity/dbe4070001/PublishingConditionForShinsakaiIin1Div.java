package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
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
 * PublishingConditionForShinsakaiIin1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingConditionForShinsakaiIin1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCopyNumForShinsakaiIin1")
    private TextBoxNum txtCopyNumForShinsakaiIin1;
    @JsonProperty("chkReportTypeForShinsakaiIin1")
    private CheckBoxList chkReportTypeForShinsakaiIin1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtCopyNumForShinsakaiIin1")
    public TextBoxNum getTxtCopyNumForShinsakaiIin1() {
        return txtCopyNumForShinsakaiIin1;
    }

    @JsonProperty("txtCopyNumForShinsakaiIin1")
    public void setTxtCopyNumForShinsakaiIin1(TextBoxNum txtCopyNumForShinsakaiIin1) {
        this.txtCopyNumForShinsakaiIin1=txtCopyNumForShinsakaiIin1;
    }

    @JsonProperty("chkReportTypeForShinsakaiIin1")
    public CheckBoxList getChkReportTypeForShinsakaiIin1() {
        return chkReportTypeForShinsakaiIin1;
    }

    @JsonProperty("chkReportTypeForShinsakaiIin1")
    public void setChkReportTypeForShinsakaiIin1(CheckBoxList chkReportTypeForShinsakaiIin1) {
        this.chkReportTypeForShinsakaiIin1=chkReportTypeForShinsakaiIin1;
    }

}
