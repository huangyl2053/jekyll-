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
 * PublishingConditionForJimukyoku1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingConditionForJimukyoku1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCopyNumForJimukyoku1")
    private TextBoxNum txtCopyNumForJimukyoku1;
    @JsonProperty("chkReportTypeForJimukyoku1")
    private CheckBoxList chkReportTypeForJimukyoku1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtCopyNumForJimukyoku1")
    public TextBoxNum getTxtCopyNumForJimukyoku1() {
        return txtCopyNumForJimukyoku1;
    }

    @JsonProperty("txtCopyNumForJimukyoku1")
    public void setTxtCopyNumForJimukyoku1(TextBoxNum txtCopyNumForJimukyoku1) {
        this.txtCopyNumForJimukyoku1=txtCopyNumForJimukyoku1;
    }

    @JsonProperty("chkReportTypeForJimukyoku1")
    public CheckBoxList getChkReportTypeForJimukyoku1() {
        return chkReportTypeForJimukyoku1;
    }

    @JsonProperty("chkReportTypeForJimukyoku1")
    public void setChkReportTypeForJimukyoku1(CheckBoxList chkReportTypeForJimukyoku1) {
        this.chkReportTypeForJimukyoku1=chkReportTypeForJimukyoku1;
    }

}
