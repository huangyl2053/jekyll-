package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.PageRangeAssignmentForShinsakaiIinDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PublishingConditionForShinsakaiIin2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingConditionForShinsakaiIin2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCopyNumForShinsakaiIin2")
    private TextBoxNum txtCopyNumForShinsakaiIin2;
    @JsonProperty("chkReportTypeForShinsakaiIin2")
    private CheckBoxList chkReportTypeForShinsakaiIin2;
    @JsonProperty("PageRangeAssignmentForShinsakaiIin")
    private PageRangeAssignmentForShinsakaiIinDiv PageRangeAssignmentForShinsakaiIin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtCopyNumForShinsakaiIin2")
    public TextBoxNum getTxtCopyNumForShinsakaiIin2() {
        return txtCopyNumForShinsakaiIin2;
    }

    @JsonProperty("txtCopyNumForShinsakaiIin2")
    public void setTxtCopyNumForShinsakaiIin2(TextBoxNum txtCopyNumForShinsakaiIin2) {
        this.txtCopyNumForShinsakaiIin2=txtCopyNumForShinsakaiIin2;
    }

    @JsonProperty("chkReportTypeForShinsakaiIin2")
    public CheckBoxList getChkReportTypeForShinsakaiIin2() {
        return chkReportTypeForShinsakaiIin2;
    }

    @JsonProperty("chkReportTypeForShinsakaiIin2")
    public void setChkReportTypeForShinsakaiIin2(CheckBoxList chkReportTypeForShinsakaiIin2) {
        this.chkReportTypeForShinsakaiIin2=chkReportTypeForShinsakaiIin2;
    }

    @JsonProperty("PageRangeAssignmentForShinsakaiIin")
    public PageRangeAssignmentForShinsakaiIinDiv getPageRangeAssignmentForShinsakaiIin() {
        return PageRangeAssignmentForShinsakaiIin;
    }

    @JsonProperty("PageRangeAssignmentForShinsakaiIin")
    public void setPageRangeAssignmentForShinsakaiIin(PageRangeAssignmentForShinsakaiIinDiv PageRangeAssignmentForShinsakaiIin) {
        this.PageRangeAssignmentForShinsakaiIin=PageRangeAssignmentForShinsakaiIin;
    }

}
