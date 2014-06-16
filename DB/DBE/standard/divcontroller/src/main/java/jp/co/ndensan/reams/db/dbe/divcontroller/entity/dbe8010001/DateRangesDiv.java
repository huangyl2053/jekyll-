package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001;
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
 * DateRanges のクラスファイル 
 * 
 * @author 自動生成
 */
public class DateRangesDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radDateRangeCriteriaType")
    private RadioButton radDateRangeCriteriaType;
    @JsonProperty("txtDateRangeCriteria")
    private TextBoxDateRange txtDateRangeCriteria;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radDateRangeCriteriaType")
    public RadioButton getRadDateRangeCriteriaType() {
        return radDateRangeCriteriaType;
    }

    @JsonProperty("radDateRangeCriteriaType")
    public void setRadDateRangeCriteriaType(RadioButton radDateRangeCriteriaType) {
        this.radDateRangeCriteriaType=radDateRangeCriteriaType;
    }

    @JsonProperty("txtDateRangeCriteria")
    public TextBoxDateRange getTxtDateRangeCriteria() {
        return txtDateRangeCriteria;
    }

    @JsonProperty("txtDateRangeCriteria")
    public void setTxtDateRangeCriteria(TextBoxDateRange txtDateRangeCriteria) {
        this.txtDateRangeCriteria=txtDateRangeCriteria;
    }

}
