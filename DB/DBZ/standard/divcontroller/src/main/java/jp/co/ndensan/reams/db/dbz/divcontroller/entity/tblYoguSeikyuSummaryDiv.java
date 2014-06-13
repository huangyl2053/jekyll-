package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblYoguSeikyuSummary のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblYoguSeikyuSummaryDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celYogu11")
    private celYogu11AttblYoguSeikyuSummary celYogu11;
    @JsonProperty("celYogu12")
    private celYogu12AttblYoguSeikyuSummary celYogu12;
    @JsonProperty("celYogu13")
    private celYogu13AttblYoguSeikyuSummary celYogu13;
    @JsonProperty("celYogu21")
    private celYogu21AttblYoguSeikyuSummary celYogu21;
    @JsonProperty("celYogu22")
    private celYogu22AttblYoguSeikyuSummary celYogu22;
    @JsonProperty("celYogu23")
    private celYogu23AttblYoguSeikyuSummary celYogu23;
    @JsonProperty("celYogu31")
    private celYogu31AttblYoguSeikyuSummary celYogu31;
    @JsonProperty("celYogu32")
    private celYogu32AttblYoguSeikyuSummary celYogu32;
    @JsonProperty("celYogu33")
    private celYogu33AttblYoguSeikyuSummary celYogu33;
    @JsonProperty("celYogu14")
    private celYogu14AttblYoguSeikyuSummary celYogu14;
    @JsonProperty("celYogu15")
    private celYogu15AttblYoguSeikyuSummary celYogu15;
    @JsonProperty("celYogu24")
    private celYogu24AttblYoguSeikyuSummary celYogu24;
    @JsonProperty("celYogu25")
    private celYogu25AttblYoguSeikyuSummary celYogu25;
    @JsonProperty("celYogu34")
    private celYogu34AttblYoguSeikyuSummary celYogu34;
    @JsonProperty("celYogu35")
    private celYogu35AttblYoguSeikyuSummary celYogu35;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblYoguSummary() {
        return this.celYogu11.getLblYoguSummary();
    }

    @JsonIgnore
    public Label getLblYoguPayTotal() {
        return this.celYogu12.getLblYoguPayTotal();
    }

    @JsonIgnore
    public Label getLblYoguHokenSeikyuAmount() {
        return this.celYogu13.getLblYoguHokenSeikyuAmount();
    }

    @JsonIgnore
    public Label getLblYoguSummaryMae() {
        return this.celYogu21.getLblYoguSummaryMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguPayTotalMae() {
        return this.celYogu22.getTxtYoguPayTotalMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguHokenSeikyuAmountMae() {
        return this.celYogu23.getTxtYoguHokenSeikyuAmountMae();
    }

    @JsonIgnore
    public Label getLblYoguSummaryNow() {
        return this.celYogu31.getLblYoguSummaryNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguPayTotalNow() {
        return this.celYogu32.getTxtYoguPayTotalNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguHokenSeikyuAmountNow() {
        return this.celYogu33.getTxtYoguHokenSeikyuAmountNow();
    }

    @JsonIgnore
    public Label getLblYoguRiyoshaFutanAmount() {
        return this.celYogu14.getLblYoguRiyoshaFutanAmount();
    }

    @JsonIgnore
    public Label getLblYoguLimitOverAmount() {
        return this.celYogu15.getLblYoguLimitOverAmount();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguRiyoshaFutanAmountMae() {
        return this.celYogu24.getTxtYoguRiyoshaFutanAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguLimitOverAmountMae() {
        return this.celYogu25.getTxtYoguLimitOverAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguRiyoshaFutanAmountNow() {
        return this.celYogu34.getTxtYoguRiyoshaFutanAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoguLimitOverAmountNow() {
        return this.celYogu35.getTxtYoguLimitOverAmountNow();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celYogu11")
    private celYogu11AttblYoguSeikyuSummary getCelYogu11() {
        return celYogu11;
    }

    @JsonProperty("celYogu11")
    private void setCelYogu11(celYogu11AttblYoguSeikyuSummary celYogu11) {
        this.celYogu11=celYogu11;
    }

    @JsonProperty("celYogu12")
    private celYogu12AttblYoguSeikyuSummary getCelYogu12() {
        return celYogu12;
    }

    @JsonProperty("celYogu12")
    private void setCelYogu12(celYogu12AttblYoguSeikyuSummary celYogu12) {
        this.celYogu12=celYogu12;
    }

    @JsonProperty("celYogu13")
    private celYogu13AttblYoguSeikyuSummary getCelYogu13() {
        return celYogu13;
    }

    @JsonProperty("celYogu13")
    private void setCelYogu13(celYogu13AttblYoguSeikyuSummary celYogu13) {
        this.celYogu13=celYogu13;
    }

    @JsonProperty("celYogu21")
    private celYogu21AttblYoguSeikyuSummary getCelYogu21() {
        return celYogu21;
    }

    @JsonProperty("celYogu21")
    private void setCelYogu21(celYogu21AttblYoguSeikyuSummary celYogu21) {
        this.celYogu21=celYogu21;
    }

    @JsonProperty("celYogu22")
    private celYogu22AttblYoguSeikyuSummary getCelYogu22() {
        return celYogu22;
    }

    @JsonProperty("celYogu22")
    private void setCelYogu22(celYogu22AttblYoguSeikyuSummary celYogu22) {
        this.celYogu22=celYogu22;
    }

    @JsonProperty("celYogu23")
    private celYogu23AttblYoguSeikyuSummary getCelYogu23() {
        return celYogu23;
    }

    @JsonProperty("celYogu23")
    private void setCelYogu23(celYogu23AttblYoguSeikyuSummary celYogu23) {
        this.celYogu23=celYogu23;
    }

    @JsonProperty("celYogu31")
    private celYogu31AttblYoguSeikyuSummary getCelYogu31() {
        return celYogu31;
    }

    @JsonProperty("celYogu31")
    private void setCelYogu31(celYogu31AttblYoguSeikyuSummary celYogu31) {
        this.celYogu31=celYogu31;
    }

    @JsonProperty("celYogu32")
    private celYogu32AttblYoguSeikyuSummary getCelYogu32() {
        return celYogu32;
    }

    @JsonProperty("celYogu32")
    private void setCelYogu32(celYogu32AttblYoguSeikyuSummary celYogu32) {
        this.celYogu32=celYogu32;
    }

    @JsonProperty("celYogu33")
    private celYogu33AttblYoguSeikyuSummary getCelYogu33() {
        return celYogu33;
    }

    @JsonProperty("celYogu33")
    private void setCelYogu33(celYogu33AttblYoguSeikyuSummary celYogu33) {
        this.celYogu33=celYogu33;
    }

    @JsonProperty("celYogu14")
    private celYogu14AttblYoguSeikyuSummary getCelYogu14() {
        return celYogu14;
    }

    @JsonProperty("celYogu14")
    private void setCelYogu14(celYogu14AttblYoguSeikyuSummary celYogu14) {
        this.celYogu14=celYogu14;
    }

    @JsonProperty("celYogu15")
    private celYogu15AttblYoguSeikyuSummary getCelYogu15() {
        return celYogu15;
    }

    @JsonProperty("celYogu15")
    private void setCelYogu15(celYogu15AttblYoguSeikyuSummary celYogu15) {
        this.celYogu15=celYogu15;
    }

    @JsonProperty("celYogu24")
    private celYogu24AttblYoguSeikyuSummary getCelYogu24() {
        return celYogu24;
    }

    @JsonProperty("celYogu24")
    private void setCelYogu24(celYogu24AttblYoguSeikyuSummary celYogu24) {
        this.celYogu24=celYogu24;
    }

    @JsonProperty("celYogu25")
    private celYogu25AttblYoguSeikyuSummary getCelYogu25() {
        return celYogu25;
    }

    @JsonProperty("celYogu25")
    private void setCelYogu25(celYogu25AttblYoguSeikyuSummary celYogu25) {
        this.celYogu25=celYogu25;
    }

    @JsonProperty("celYogu34")
    private celYogu34AttblYoguSeikyuSummary getCelYogu34() {
        return celYogu34;
    }

    @JsonProperty("celYogu34")
    private void setCelYogu34(celYogu34AttblYoguSeikyuSummary celYogu34) {
        this.celYogu34=celYogu34;
    }

    @JsonProperty("celYogu35")
    private celYogu35AttblYoguSeikyuSummary getCelYogu35() {
        return celYogu35;
    }

    @JsonProperty("celYogu35")
    private void setCelYogu35(celYogu35AttblYoguSeikyuSummary celYogu35) {
        this.celYogu35=celYogu35;
    }

}
/**
 * celYogu11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu11AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("lblYoguSummary")
    private Label lblYoguSummary;

    @JsonProperty("lblYoguSummary")
    public Label getLblYoguSummary() {
        return lblYoguSummary;
    }

    @JsonProperty("lblYoguSummary")
    public void setLblYoguSummary(Label lblYoguSummary) {
        this.lblYoguSummary=lblYoguSummary;
    }

}
/**
 * celYogu12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu12AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("lblYoguPayTotal")
    private Label lblYoguPayTotal;

    @JsonProperty("lblYoguPayTotal")
    public Label getLblYoguPayTotal() {
        return lblYoguPayTotal;
    }

    @JsonProperty("lblYoguPayTotal")
    public void setLblYoguPayTotal(Label lblYoguPayTotal) {
        this.lblYoguPayTotal=lblYoguPayTotal;
    }

}
/**
 * celYogu13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu13AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("lblYoguHokenSeikyuAmount")
    private Label lblYoguHokenSeikyuAmount;

    @JsonProperty("lblYoguHokenSeikyuAmount")
    public Label getLblYoguHokenSeikyuAmount() {
        return lblYoguHokenSeikyuAmount;
    }

    @JsonProperty("lblYoguHokenSeikyuAmount")
    public void setLblYoguHokenSeikyuAmount(Label lblYoguHokenSeikyuAmount) {
        this.lblYoguHokenSeikyuAmount=lblYoguHokenSeikyuAmount;
    }

}
/**
 * celYogu21 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu21AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("lblYoguSummaryMae")
    private Label lblYoguSummaryMae;

    @JsonProperty("lblYoguSummaryMae")
    public Label getLblYoguSummaryMae() {
        return lblYoguSummaryMae;
    }

    @JsonProperty("lblYoguSummaryMae")
    public void setLblYoguSummaryMae(Label lblYoguSummaryMae) {
        this.lblYoguSummaryMae=lblYoguSummaryMae;
    }

}
/**
 * celYogu22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu22AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguPayTotalMae")
    private TextBoxNum txtYoguPayTotalMae;

    @JsonProperty("txtYoguPayTotalMae")
    public TextBoxNum getTxtYoguPayTotalMae() {
        return txtYoguPayTotalMae;
    }

    @JsonProperty("txtYoguPayTotalMae")
    public void setTxtYoguPayTotalMae(TextBoxNum txtYoguPayTotalMae) {
        this.txtYoguPayTotalMae=txtYoguPayTotalMae;
    }

}
/**
 * celYogu23 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu23AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguHokenSeikyuAmountMae")
    private TextBoxNum txtYoguHokenSeikyuAmountMae;

    @JsonProperty("txtYoguHokenSeikyuAmountMae")
    public TextBoxNum getTxtYoguHokenSeikyuAmountMae() {
        return txtYoguHokenSeikyuAmountMae;
    }

    @JsonProperty("txtYoguHokenSeikyuAmountMae")
    public void setTxtYoguHokenSeikyuAmountMae(TextBoxNum txtYoguHokenSeikyuAmountMae) {
        this.txtYoguHokenSeikyuAmountMae=txtYoguHokenSeikyuAmountMae;
    }

}
/**
 * celYogu31 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu31AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("lblYoguSummaryNow")
    private Label lblYoguSummaryNow;

    @JsonProperty("lblYoguSummaryNow")
    public Label getLblYoguSummaryNow() {
        return lblYoguSummaryNow;
    }

    @JsonProperty("lblYoguSummaryNow")
    public void setLblYoguSummaryNow(Label lblYoguSummaryNow) {
        this.lblYoguSummaryNow=lblYoguSummaryNow;
    }

}
/**
 * celYogu32 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu32AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguPayTotalNow")
    private TextBoxNum txtYoguPayTotalNow;

    @JsonProperty("txtYoguPayTotalNow")
    public TextBoxNum getTxtYoguPayTotalNow() {
        return txtYoguPayTotalNow;
    }

    @JsonProperty("txtYoguPayTotalNow")
    public void setTxtYoguPayTotalNow(TextBoxNum txtYoguPayTotalNow) {
        this.txtYoguPayTotalNow=txtYoguPayTotalNow;
    }

}
/**
 * celYogu33 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu33AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguHokenSeikyuAmountNow")
    private TextBoxNum txtYoguHokenSeikyuAmountNow;

    @JsonProperty("txtYoguHokenSeikyuAmountNow")
    public TextBoxNum getTxtYoguHokenSeikyuAmountNow() {
        return txtYoguHokenSeikyuAmountNow;
    }

    @JsonProperty("txtYoguHokenSeikyuAmountNow")
    public void setTxtYoguHokenSeikyuAmountNow(TextBoxNum txtYoguHokenSeikyuAmountNow) {
        this.txtYoguHokenSeikyuAmountNow=txtYoguHokenSeikyuAmountNow;
    }

}
/**
 * celYogu14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu14AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("lblYoguRiyoshaFutanAmount")
    private Label lblYoguRiyoshaFutanAmount;

    @JsonProperty("lblYoguRiyoshaFutanAmount")
    public Label getLblYoguRiyoshaFutanAmount() {
        return lblYoguRiyoshaFutanAmount;
    }

    @JsonProperty("lblYoguRiyoshaFutanAmount")
    public void setLblYoguRiyoshaFutanAmount(Label lblYoguRiyoshaFutanAmount) {
        this.lblYoguRiyoshaFutanAmount=lblYoguRiyoshaFutanAmount;
    }

}
/**
 * celYogu15 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu15AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("lblYoguLimitOverAmount")
    private Label lblYoguLimitOverAmount;

    @JsonProperty("lblYoguLimitOverAmount")
    public Label getLblYoguLimitOverAmount() {
        return lblYoguLimitOverAmount;
    }

    @JsonProperty("lblYoguLimitOverAmount")
    public void setLblYoguLimitOverAmount(Label lblYoguLimitOverAmount) {
        this.lblYoguLimitOverAmount=lblYoguLimitOverAmount;
    }

}
/**
 * celYogu24 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu24AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguRiyoshaFutanAmountMae")
    private TextBoxNum txtYoguRiyoshaFutanAmountMae;

    @JsonProperty("txtYoguRiyoshaFutanAmountMae")
    public TextBoxNum getTxtYoguRiyoshaFutanAmountMae() {
        return txtYoguRiyoshaFutanAmountMae;
    }

    @JsonProperty("txtYoguRiyoshaFutanAmountMae")
    public void setTxtYoguRiyoshaFutanAmountMae(TextBoxNum txtYoguRiyoshaFutanAmountMae) {
        this.txtYoguRiyoshaFutanAmountMae=txtYoguRiyoshaFutanAmountMae;
    }

}
/**
 * celYogu25 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu25AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguLimitOverAmountMae")
    private TextBoxNum txtYoguLimitOverAmountMae;

    @JsonProperty("txtYoguLimitOverAmountMae")
    public TextBoxNum getTxtYoguLimitOverAmountMae() {
        return txtYoguLimitOverAmountMae;
    }

    @JsonProperty("txtYoguLimitOverAmountMae")
    public void setTxtYoguLimitOverAmountMae(TextBoxNum txtYoguLimitOverAmountMae) {
        this.txtYoguLimitOverAmountMae=txtYoguLimitOverAmountMae;
    }

}
/**
 * celYogu34 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu34AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguRiyoshaFutanAmountNow")
    private TextBoxNum txtYoguRiyoshaFutanAmountNow;

    @JsonProperty("txtYoguRiyoshaFutanAmountNow")
    public TextBoxNum getTxtYoguRiyoshaFutanAmountNow() {
        return txtYoguRiyoshaFutanAmountNow;
    }

    @JsonProperty("txtYoguRiyoshaFutanAmountNow")
    public void setTxtYoguRiyoshaFutanAmountNow(TextBoxNum txtYoguRiyoshaFutanAmountNow) {
        this.txtYoguRiyoshaFutanAmountNow=txtYoguRiyoshaFutanAmountNow;
    }

}
/**
 * celYogu35 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYogu35AttblYoguSeikyuSummary extends TableCell {
    @JsonProperty("txtYoguLimitOverAmountNow")
    private TextBoxNum txtYoguLimitOverAmountNow;

    @JsonProperty("txtYoguLimitOverAmountNow")
    public TextBoxNum getTxtYoguLimitOverAmountNow() {
        return txtYoguLimitOverAmountNow;
    }

    @JsonProperty("txtYoguLimitOverAmountNow")
    public void setTxtYoguLimitOverAmountNow(TextBoxNum txtYoguLimitOverAmountNow) {
        this.txtYoguLimitOverAmountNow=txtYoguLimitOverAmountNow;
    }

}
