package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblSeikyuSummaryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SeikyuSummary のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuSummaryDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblSeikyuSummary")
    private tblSeikyuSummaryDiv tblSeikyuSummary;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblSeikyuSummary")
    public tblSeikyuSummaryDiv getTblSeikyuSummary() {
        return tblSeikyuSummary;
    }

    @JsonProperty("tblSeikyuSummary")
    public void setTblSeikyuSummary(tblSeikyuSummaryDiv tblSeikyuSummary) {
        this.tblSeikyuSummary=tblSeikyuSummary;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSummary() {
        return this.getTblSeikyuSummary().getLblSummary();
    }

    @JsonIgnore
    public Label getLblPayTotal() {
        return this.getTblSeikyuSummary().getLblPayTotal();
    }

    @JsonIgnore
    public Label getLblHokenSeikyuAmount() {
        return this.getTblSeikyuSummary().getLblHokenSeikyuAmount();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanAmount() {
        return this.getTblSeikyuSummary().getLblRiyoshaFutanAmount();
    }

    @JsonIgnore
    public Label getLblLimitOverAmount() {
        return this.getTblSeikyuSummary().getLblLimitOverAmount();
    }

    @JsonIgnore
    public Label getLblSummaryMae() {
        return this.getTblSeikyuSummary().getLblSummaryMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtPayTotalMae() {
        return this.getTblSeikyuSummary().getTxtPayTotalMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenSeikyuAmountMae() {
        return this.getTblSeikyuSummary().getTxtHokenSeikyuAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return this.getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtLimitOverAmountMae() {
        return this.getTblSeikyuSummary().getTxtLimitOverAmountMae();
    }

    @JsonIgnore
    public Label getLblSummaryNow() {
        return this.getTblSeikyuSummary().getLblSummaryNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtPayTotalNow() {
        return this.getTblSeikyuSummary().getTxtPayTotalNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenSeikyuAmountNow() {
        return this.getTblSeikyuSummary().getTxtHokenSeikyuAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return this.getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtLimitOverAmountNow() {
        return this.getTblSeikyuSummary().getTxtLimitOverAmountNow();
    }

    @JsonIgnore
    public Button getBtnLimitOverCheck() {
        return this.getTblSeikyuSummary().getBtnLimitOverCheck();
    }

}
