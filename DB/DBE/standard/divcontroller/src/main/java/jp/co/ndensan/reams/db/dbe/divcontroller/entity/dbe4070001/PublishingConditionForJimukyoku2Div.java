package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.PageRangeForJimukyokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PublishingConditionForJimukyoku2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingConditionForJimukyoku2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ttxtCopyNumForJimukyoku2")
    private TextBoxNum ttxtCopyNumForJimukyoku2;
    @JsonProperty("chkReportTypeForJimukyoku2")
    private CheckBoxList chkReportTypeForJimukyoku2;
    @JsonProperty("PageRangeForJimukyoku")
    private PageRangeForJimukyokuDiv PageRangeForJimukyoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ttxtCopyNumForJimukyoku2")
    public TextBoxNum getTtxtCopyNumForJimukyoku2() {
        return ttxtCopyNumForJimukyoku2;
    }

    @JsonProperty("ttxtCopyNumForJimukyoku2")
    public void setTtxtCopyNumForJimukyoku2(TextBoxNum ttxtCopyNumForJimukyoku2) {
        this.ttxtCopyNumForJimukyoku2=ttxtCopyNumForJimukyoku2;
    }

    @JsonProperty("chkReportTypeForJimukyoku2")
    public CheckBoxList getChkReportTypeForJimukyoku2() {
        return chkReportTypeForJimukyoku2;
    }

    @JsonProperty("chkReportTypeForJimukyoku2")
    public void setChkReportTypeForJimukyoku2(CheckBoxList chkReportTypeForJimukyoku2) {
        this.chkReportTypeForJimukyoku2=chkReportTypeForJimukyoku2;
    }

    @JsonProperty("PageRangeForJimukyoku")
    public PageRangeForJimukyokuDiv getPageRangeForJimukyoku() {
        return PageRangeForJimukyoku;
    }

    @JsonProperty("PageRangeForJimukyoku")
    public void setPageRangeForJimukyoku(PageRangeForJimukyokuDiv PageRangeForJimukyoku) {
        this.PageRangeForJimukyoku=PageRangeForJimukyoku;
    }

}
