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
 * PageRangeForJimukyoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class PageRangeForJimukyokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblPageRangeForJimukyoku")
    private Label lblPageRangeForJimukyoku;
    @JsonProperty("txtPageRangeForJimukyokuFrom")
    private TextBoxNum txtPageRangeForJimukyokuFrom;
    @JsonProperty("lblPageRangeForJimukyokuWave")
    private Label lblPageRangeForJimukyokuWave;
    @JsonProperty("txtPageRangeForJimukyokuTo")
    private TextBoxNum txtPageRangeForJimukyokuTo;
    @JsonProperty("lblPageRangeForJimukyoku2")
    private Label lblPageRangeForJimukyoku2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblPageRangeForJimukyoku")
    public Label getLblPageRangeForJimukyoku() {
        return lblPageRangeForJimukyoku;
    }

    @JsonProperty("lblPageRangeForJimukyoku")
    public void setLblPageRangeForJimukyoku(Label lblPageRangeForJimukyoku) {
        this.lblPageRangeForJimukyoku=lblPageRangeForJimukyoku;
    }

    @JsonProperty("txtPageRangeForJimukyokuFrom")
    public TextBoxNum getTxtPageRangeForJimukyokuFrom() {
        return txtPageRangeForJimukyokuFrom;
    }

    @JsonProperty("txtPageRangeForJimukyokuFrom")
    public void setTxtPageRangeForJimukyokuFrom(TextBoxNum txtPageRangeForJimukyokuFrom) {
        this.txtPageRangeForJimukyokuFrom=txtPageRangeForJimukyokuFrom;
    }

    @JsonProperty("lblPageRangeForJimukyokuWave")
    public Label getLblPageRangeForJimukyokuWave() {
        return lblPageRangeForJimukyokuWave;
    }

    @JsonProperty("lblPageRangeForJimukyokuWave")
    public void setLblPageRangeForJimukyokuWave(Label lblPageRangeForJimukyokuWave) {
        this.lblPageRangeForJimukyokuWave=lblPageRangeForJimukyokuWave;
    }

    @JsonProperty("txtPageRangeForJimukyokuTo")
    public TextBoxNum getTxtPageRangeForJimukyokuTo() {
        return txtPageRangeForJimukyokuTo;
    }

    @JsonProperty("txtPageRangeForJimukyokuTo")
    public void setTxtPageRangeForJimukyokuTo(TextBoxNum txtPageRangeForJimukyokuTo) {
        this.txtPageRangeForJimukyokuTo=txtPageRangeForJimukyokuTo;
    }

    @JsonProperty("lblPageRangeForJimukyoku2")
    public Label getLblPageRangeForJimukyoku2() {
        return lblPageRangeForJimukyoku2;
    }

    @JsonProperty("lblPageRangeForJimukyoku2")
    public void setLblPageRangeForJimukyoku2(Label lblPageRangeForJimukyoku2) {
        this.lblPageRangeForJimukyoku2=lblPageRangeForJimukyoku2;
    }

}
