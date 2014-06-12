package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002.TermBusinessYearDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002.TermDateRangeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002.TermYearDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002.TermYearMonthDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ExtractedTerm のクラスファイル 
 * 
 * @author 自動生成
 */
public class ExtractedTermDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radExtractedTermType")
    private RadioButton radExtractedTermType;
    @JsonProperty("TermYear")
    private TermYearDiv TermYear;
    @JsonProperty("TermBusinessYear")
    private TermBusinessYearDiv TermBusinessYear;
    @JsonProperty("TermYearMonth")
    private TermYearMonthDiv TermYearMonth;
    @JsonProperty("TermDateRange")
    private TermDateRangeDiv TermDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radExtractedTermType")
    public RadioButton getRadExtractedTermType() {
        return radExtractedTermType;
    }

    @JsonProperty("radExtractedTermType")
    public void setRadExtractedTermType(RadioButton radExtractedTermType) {
        this.radExtractedTermType=radExtractedTermType;
    }

    @JsonProperty("TermYear")
    public TermYearDiv getTermYear() {
        return TermYear;
    }

    @JsonProperty("TermYear")
    public void setTermYear(TermYearDiv TermYear) {
        this.TermYear=TermYear;
    }

    @JsonProperty("TermBusinessYear")
    public TermBusinessYearDiv getTermBusinessYear() {
        return TermBusinessYear;
    }

    @JsonProperty("TermBusinessYear")
    public void setTermBusinessYear(TermBusinessYearDiv TermBusinessYear) {
        this.TermBusinessYear=TermBusinessYear;
    }

    @JsonProperty("TermYearMonth")
    public TermYearMonthDiv getTermYearMonth() {
        return TermYearMonth;
    }

    @JsonProperty("TermYearMonth")
    public void setTermYearMonth(TermYearMonthDiv TermYearMonth) {
        this.TermYearMonth=TermYearMonth;
    }

    @JsonProperty("TermDateRange")
    public TermDateRangeDiv getTermDateRange() {
        return TermDateRange;
    }

    @JsonProperty("TermDateRange")
    public void setTermDateRange(TermDateRangeDiv TermDateRange) {
        this.TermDateRange=TermDateRange;
    }

}
