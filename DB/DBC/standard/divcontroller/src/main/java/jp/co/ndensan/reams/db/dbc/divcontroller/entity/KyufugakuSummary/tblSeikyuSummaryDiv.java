package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufugakuSummary;
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
 * tblSeikyuSummary のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSeikyuSummaryDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel11")
    private cel11AttblSeikyuSummary cel11;
    @JsonProperty("cel12")
    private cel12AttblSeikyuSummary cel12;
    @JsonProperty("cel13")
    private cel13AttblSeikyuSummary cel13;
    @JsonProperty("cel21")
    private cel21AttblSeikyuSummary cel21;
    @JsonProperty("cel22")
    private cel22AttblSeikyuSummary cel22;
    @JsonProperty("cel23")
    private cel23AttblSeikyuSummary cel23;
    @JsonProperty("cel31")
    private cel31AttblSeikyuSummary cel31;
    @JsonProperty("cel32")
    private cel32AttblSeikyuSummary cel32;
    @JsonProperty("cel33")
    private cel33AttblSeikyuSummary cel33;
    @JsonProperty("cel14")
    private cel14AttblSeikyuSummary cel14;
    @JsonProperty("cel15")
    private cel15AttblSeikyuSummary cel15;
    @JsonProperty("cel24")
    private cel24AttblSeikyuSummary cel24;
    @JsonProperty("cel25")
    private cel25AttblSeikyuSummary cel25;
    @JsonProperty("cel34")
    private cel34AttblSeikyuSummary cel34;
    @JsonProperty("cel35")
    private cel35AttblSeikyuSummary cel35;
    @JsonProperty("cel36")
    private cel36AttblSeikyuSummary cel36;
    @JsonProperty("cell26")
    private cell26AttblSeikyuSummary cell26;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblSummary() {
        return this.cel11.getLblSummary();
    }

    @JsonIgnore
    public Label getLblHiyoTotal() {
        return this.cel12.getLblHiyoTotal();
    }

    @JsonIgnore
    public Label getLblHokenTaishoHiyo() {
        return this.cel13.getLblHokenTaishoHiyo();
    }

    @JsonIgnore
    public Label getLblSummaryMae() {
        return this.cel21.getLblSummaryMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyoTotalMae() {
        return this.cel22.getTxtHiyoTotalMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenTaishoHiyoMae() {
        return this.cel23.getTxtHokenTaishoHiyoMae();
    }

    @JsonIgnore
    public Label getLblSummaryNow() {
        return this.cel31.getLblSummaryNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyoTotalNow() {
        return this.cel32.getTxtHiyoTotalNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenTaishoHiyoNow() {
        return this.cel33.getTxtHokenTaishoHiyoNow();
    }

    @JsonIgnore
    public Label getLblHokenKyufuAmount() {
        return this.cel14.getLblHokenKyufuAmount();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanAmount() {
        return this.cel15.getLblRiyoshaFutanAmount();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenKyufuAmountMae() {
        return this.cel24.getTxtHokenKyufuAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return this.cel25.getTxtRiyoshaFutanAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenKyufuAmountNow() {
        return this.cel34.getTxtHokenKyufuAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return this.cel35.getTxtRiyoshaFutanAmountNow();
    }

    @JsonIgnore
    public Button getBtnLimitOverCheck() {
        return this.cel36.getBtnLimitOverCheck();
    }

    @JsonIgnore
    public ButtonDialog getBtnRireki() {
        return this.cell26.getBtnRireki();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("cel11")
    private cel11AttblSeikyuSummary getCel11() {
        return cel11;
    }

    @JsonProperty("cel11")
    private void setCel11(cel11AttblSeikyuSummary cel11) {
        this.cel11=cel11;
    }

    @JsonProperty("cel12")
    private cel12AttblSeikyuSummary getCel12() {
        return cel12;
    }

    @JsonProperty("cel12")
    private void setCel12(cel12AttblSeikyuSummary cel12) {
        this.cel12=cel12;
    }

    @JsonProperty("cel13")
    private cel13AttblSeikyuSummary getCel13() {
        return cel13;
    }

    @JsonProperty("cel13")
    private void setCel13(cel13AttblSeikyuSummary cel13) {
        this.cel13=cel13;
    }

    @JsonProperty("cel21")
    private cel21AttblSeikyuSummary getCel21() {
        return cel21;
    }

    @JsonProperty("cel21")
    private void setCel21(cel21AttblSeikyuSummary cel21) {
        this.cel21=cel21;
    }

    @JsonProperty("cel22")
    private cel22AttblSeikyuSummary getCel22() {
        return cel22;
    }

    @JsonProperty("cel22")
    private void setCel22(cel22AttblSeikyuSummary cel22) {
        this.cel22=cel22;
    }

    @JsonProperty("cel23")
    private cel23AttblSeikyuSummary getCel23() {
        return cel23;
    }

    @JsonProperty("cel23")
    private void setCel23(cel23AttblSeikyuSummary cel23) {
        this.cel23=cel23;
    }

    @JsonProperty("cel31")
    private cel31AttblSeikyuSummary getCel31() {
        return cel31;
    }

    @JsonProperty("cel31")
    private void setCel31(cel31AttblSeikyuSummary cel31) {
        this.cel31=cel31;
    }

    @JsonProperty("cel32")
    private cel32AttblSeikyuSummary getCel32() {
        return cel32;
    }

    @JsonProperty("cel32")
    private void setCel32(cel32AttblSeikyuSummary cel32) {
        this.cel32=cel32;
    }

    @JsonProperty("cel33")
    private cel33AttblSeikyuSummary getCel33() {
        return cel33;
    }

    @JsonProperty("cel33")
    private void setCel33(cel33AttblSeikyuSummary cel33) {
        this.cel33=cel33;
    }

    @JsonProperty("cel14")
    private cel14AttblSeikyuSummary getCel14() {
        return cel14;
    }

    @JsonProperty("cel14")
    private void setCel14(cel14AttblSeikyuSummary cel14) {
        this.cel14=cel14;
    }

    @JsonProperty("cel15")
    private cel15AttblSeikyuSummary getCel15() {
        return cel15;
    }

    @JsonProperty("cel15")
    private void setCel15(cel15AttblSeikyuSummary cel15) {
        this.cel15=cel15;
    }

    @JsonProperty("cel24")
    private cel24AttblSeikyuSummary getCel24() {
        return cel24;
    }

    @JsonProperty("cel24")
    private void setCel24(cel24AttblSeikyuSummary cel24) {
        this.cel24=cel24;
    }

    @JsonProperty("cel25")
    private cel25AttblSeikyuSummary getCel25() {
        return cel25;
    }

    @JsonProperty("cel25")
    private void setCel25(cel25AttblSeikyuSummary cel25) {
        this.cel25=cel25;
    }

    @JsonProperty("cel34")
    private cel34AttblSeikyuSummary getCel34() {
        return cel34;
    }

    @JsonProperty("cel34")
    private void setCel34(cel34AttblSeikyuSummary cel34) {
        this.cel34=cel34;
    }

    @JsonProperty("cel35")
    private cel35AttblSeikyuSummary getCel35() {
        return cel35;
    }

    @JsonProperty("cel35")
    private void setCel35(cel35AttblSeikyuSummary cel35) {
        this.cel35=cel35;
    }

    @JsonProperty("cel36")
    private cel36AttblSeikyuSummary getCel36() {
        return cel36;
    }

    @JsonProperty("cel36")
    private void setCel36(cel36AttblSeikyuSummary cel36) {
        this.cel36=cel36;
    }

    @JsonProperty("cell26")
    private cell26AttblSeikyuSummary getCell26() {
        return cell26;
    }

    @JsonProperty("cell26")
    private void setCell26(cell26AttblSeikyuSummary cell26) {
        this.cell26=cell26;
    }

}
/**
 * cel11 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel11AttblSeikyuSummary extends TableCell {
    @JsonProperty("lblSummary")
    private Label lblSummary;

    @JsonProperty("lblSummary")
    public Label getLblSummary() {
        return lblSummary;
    }

    @JsonProperty("lblSummary")
    public void setLblSummary(Label lblSummary) {
        this.lblSummary=lblSummary;
    }

}
/**
 * cel12 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel12AttblSeikyuSummary extends TableCell {
    @JsonProperty("lblHiyoTotal")
    private Label lblHiyoTotal;

    @JsonProperty("lblHiyoTotal")
    public Label getLblHiyoTotal() {
        return lblHiyoTotal;
    }

    @JsonProperty("lblHiyoTotal")
    public void setLblHiyoTotal(Label lblHiyoTotal) {
        this.lblHiyoTotal=lblHiyoTotal;
    }

}
/**
 * cel13 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel13AttblSeikyuSummary extends TableCell {
    @JsonProperty("lblHokenTaishoHiyo")
    private Label lblHokenTaishoHiyo;

    @JsonProperty("lblHokenTaishoHiyo")
    public Label getLblHokenTaishoHiyo() {
        return lblHokenTaishoHiyo;
    }

    @JsonProperty("lblHokenTaishoHiyo")
    public void setLblHokenTaishoHiyo(Label lblHokenTaishoHiyo) {
        this.lblHokenTaishoHiyo=lblHokenTaishoHiyo;
    }

}
/**
 * cel21 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel21AttblSeikyuSummary extends TableCell {
    @JsonProperty("lblSummaryMae")
    private Label lblSummaryMae;

    @JsonProperty("lblSummaryMae")
    public Label getLblSummaryMae() {
        return lblSummaryMae;
    }

    @JsonProperty("lblSummaryMae")
    public void setLblSummaryMae(Label lblSummaryMae) {
        this.lblSummaryMae=lblSummaryMae;
    }

}
/**
 * cel22 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel22AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtHiyoTotalMae")
    private TextBoxNum txtHiyoTotalMae;

    @JsonProperty("txtHiyoTotalMae")
    public TextBoxNum getTxtHiyoTotalMae() {
        return txtHiyoTotalMae;
    }

    @JsonProperty("txtHiyoTotalMae")
    public void setTxtHiyoTotalMae(TextBoxNum txtHiyoTotalMae) {
        this.txtHiyoTotalMae=txtHiyoTotalMae;
    }

}
/**
 * cel23 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel23AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtHokenTaishoHiyoMae")
    private TextBoxNum txtHokenTaishoHiyoMae;

    @JsonProperty("txtHokenTaishoHiyoMae")
    public TextBoxNum getTxtHokenTaishoHiyoMae() {
        return txtHokenTaishoHiyoMae;
    }

    @JsonProperty("txtHokenTaishoHiyoMae")
    public void setTxtHokenTaishoHiyoMae(TextBoxNum txtHokenTaishoHiyoMae) {
        this.txtHokenTaishoHiyoMae=txtHokenTaishoHiyoMae;
    }

}
/**
 * cel31 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel31AttblSeikyuSummary extends TableCell {
    @JsonProperty("lblSummaryNow")
    private Label lblSummaryNow;

    @JsonProperty("lblSummaryNow")
    public Label getLblSummaryNow() {
        return lblSummaryNow;
    }

    @JsonProperty("lblSummaryNow")
    public void setLblSummaryNow(Label lblSummaryNow) {
        this.lblSummaryNow=lblSummaryNow;
    }

}
/**
 * cel32 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel32AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtHiyoTotalNow")
    private TextBoxNum txtHiyoTotalNow;

    @JsonProperty("txtHiyoTotalNow")
    public TextBoxNum getTxtHiyoTotalNow() {
        return txtHiyoTotalNow;
    }

    @JsonProperty("txtHiyoTotalNow")
    public void setTxtHiyoTotalNow(TextBoxNum txtHiyoTotalNow) {
        this.txtHiyoTotalNow=txtHiyoTotalNow;
    }

}
/**
 * cel33 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel33AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtHokenTaishoHiyoNow")
    private TextBoxNum txtHokenTaishoHiyoNow;

    @JsonProperty("txtHokenTaishoHiyoNow")
    public TextBoxNum getTxtHokenTaishoHiyoNow() {
        return txtHokenTaishoHiyoNow;
    }

    @JsonProperty("txtHokenTaishoHiyoNow")
    public void setTxtHokenTaishoHiyoNow(TextBoxNum txtHokenTaishoHiyoNow) {
        this.txtHokenTaishoHiyoNow=txtHokenTaishoHiyoNow;
    }

}
/**
 * cel14 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel14AttblSeikyuSummary extends TableCell {
    @JsonProperty("lblHokenKyufuAmount")
    private Label lblHokenKyufuAmount;

    @JsonProperty("lblHokenKyufuAmount")
    public Label getLblHokenKyufuAmount() {
        return lblHokenKyufuAmount;
    }

    @JsonProperty("lblHokenKyufuAmount")
    public void setLblHokenKyufuAmount(Label lblHokenKyufuAmount) {
        this.lblHokenKyufuAmount=lblHokenKyufuAmount;
    }

}
/**
 * cel15 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel15AttblSeikyuSummary extends TableCell {
    @JsonProperty("lblRiyoshaFutanAmount")
    private Label lblRiyoshaFutanAmount;

    @JsonProperty("lblRiyoshaFutanAmount")
    public Label getLblRiyoshaFutanAmount() {
        return lblRiyoshaFutanAmount;
    }

    @JsonProperty("lblRiyoshaFutanAmount")
    public void setLblRiyoshaFutanAmount(Label lblRiyoshaFutanAmount) {
        this.lblRiyoshaFutanAmount=lblRiyoshaFutanAmount;
    }

}
/**
 * cel24 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel24AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtHokenKyufuAmountMae")
    private TextBoxNum txtHokenKyufuAmountMae;

    @JsonProperty("txtHokenKyufuAmountMae")
    public TextBoxNum getTxtHokenKyufuAmountMae() {
        return txtHokenKyufuAmountMae;
    }

    @JsonProperty("txtHokenKyufuAmountMae")
    public void setTxtHokenKyufuAmountMae(TextBoxNum txtHokenKyufuAmountMae) {
        this.txtHokenKyufuAmountMae=txtHokenKyufuAmountMae;
    }

}
/**
 * cel25 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel25AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtRiyoshaFutanAmountMae")
    private TextBoxNum txtRiyoshaFutanAmountMae;

    @JsonProperty("txtRiyoshaFutanAmountMae")
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return txtRiyoshaFutanAmountMae;
    }

    @JsonProperty("txtRiyoshaFutanAmountMae")
    public void setTxtRiyoshaFutanAmountMae(TextBoxNum txtRiyoshaFutanAmountMae) {
        this.txtRiyoshaFutanAmountMae=txtRiyoshaFutanAmountMae;
    }

}
/**
 * cel34 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel34AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtHokenKyufuAmountNow")
    private TextBoxNum txtHokenKyufuAmountNow;

    @JsonProperty("txtHokenKyufuAmountNow")
    public TextBoxNum getTxtHokenKyufuAmountNow() {
        return txtHokenKyufuAmountNow;
    }

    @JsonProperty("txtHokenKyufuAmountNow")
    public void setTxtHokenKyufuAmountNow(TextBoxNum txtHokenKyufuAmountNow) {
        this.txtHokenKyufuAmountNow=txtHokenKyufuAmountNow;
    }

}
/**
 * cel35 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel35AttblSeikyuSummary extends TableCell {
    @JsonProperty("txtRiyoshaFutanAmountNow")
    private TextBoxNum txtRiyoshaFutanAmountNow;

    @JsonProperty("txtRiyoshaFutanAmountNow")
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return txtRiyoshaFutanAmountNow;
    }

    @JsonProperty("txtRiyoshaFutanAmountNow")
    public void setTxtRiyoshaFutanAmountNow(TextBoxNum txtRiyoshaFutanAmountNow) {
        this.txtRiyoshaFutanAmountNow=txtRiyoshaFutanAmountNow;
    }

}
/**
 * cel36 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel36AttblSeikyuSummary extends TableCell {
    @JsonProperty("btnLimitOverCheck")
    private Button btnLimitOverCheck;

    @JsonProperty("btnLimitOverCheck")
    public Button getBtnLimitOverCheck() {
        return btnLimitOverCheck;
    }

    @JsonProperty("btnLimitOverCheck")
    public void setBtnLimitOverCheck(Button btnLimitOverCheck) {
        this.btnLimitOverCheck=btnLimitOverCheck;
    }

}
/**
 * cell26 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell26AttblSeikyuSummary extends TableCell {
    @JsonProperty("btnRireki")
    private ButtonDialog btnRireki;

    @JsonProperty("btnRireki")
    public ButtonDialog getBtnRireki() {
        return btnRireki;
    }

    @JsonProperty("btnRireki")
    public void setBtnRireki(ButtonDialog btnRireki) {
        this.btnRireki=btnRireki;
    }

}
