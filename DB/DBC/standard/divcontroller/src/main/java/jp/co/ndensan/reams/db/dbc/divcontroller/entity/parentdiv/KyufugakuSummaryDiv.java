package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.IKyufugakuSummaryDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufugakuSummary のクラスファイル
 *
 * @author 自動生成
 */
public class KyufugakuSummaryDiv extends Panel implements IKyufugakuSummaryDiv {
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
        this.tblSeikyuSummary = tblSeikyuSummary;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSummary() {
        return this.getTblSeikyuSummary().getLblSummary();
    }

//    @JsonIgnore
//    public Label getLblHiyoTotal() {
//        return this.getTblSeikyuSummary().getLblHiyoTotal();
//    }
//
//    @JsonIgnore
//    public Label getLblHokenTaishoHiyo() {
//        return this.getTblSeikyuSummary().getLblHokenTaishoHiyo();
//    }
//
//    @JsonIgnore
//    public Label getLblHokenKyufuAmount() {
//        return this.getTblSeikyuSummary().getLblHokenKyufuAmount();
//    }
    @JsonIgnore
    public Label getLblRiyoshaFutanAmount() {
        return this.getTblSeikyuSummary().getLblRiyoshaFutanAmount();
    }

    @JsonIgnore
    public Label getLblSummaryMae() {
        return this.getTblSeikyuSummary().getLblSummaryMae();
    }

//    @JsonIgnore
//    public TextBoxNum getTxtHiyoTotalMae() {
//        return this.getTblSeikyuSummary().getTxtHiyoTotalMae();
//    }
//
//    @JsonIgnore
//    public TextBoxNum getTxtHokenTaishoHiyoMae() {
//        return this.getTblSeikyuSummary().getTxtHokenTaishoHiyoMae();
//    }
//
//    @JsonIgnore
//    public TextBoxNum getTxtHokenKyufuAmountMae() {
//        return this.getTblSeikyuSummary().getTxtHokenKyufuAmountMae();
//    }
    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return this.getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae();
    }

//    @JsonIgnore
//    public ButtonDialog getBtnRireki() {
//        return this.getTblSeikyuSummary().getBtnRireki();
//    }
    @JsonIgnore
    public Label getLblSummaryNow() {
        return this.getTblSeikyuSummary().getLblSummaryNow();
    }

//    @JsonIgnore
//    public TextBoxNum getTxtHiyoTotalNow() {
//        return this.getTblSeikyuSummary().getTxtHiyoTotalNow();
//    }
//    @JsonIgnore
//    public TextBoxNum getTxtHokenTaishoHiyoNow() {
//        return this.getTblSeikyuSummary().getTxtHokenTaishoHiyoNow();
//    }
//
//    @JsonIgnore
//    public TextBoxNum getTxtHokenKyufuAmountNow() {
//        return this.getTblSeikyuSummary().getTxtHokenKyufuAmountNow();
//    }
    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return this.getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow();
    }

    @JsonIgnore
    public Button getBtnLimitOverCheck() {
        return this.getTblSeikyuSummary().getBtnLimitOverCheck();
    }

    //--------------- この行より下にコードを追加してください -------------------
}
