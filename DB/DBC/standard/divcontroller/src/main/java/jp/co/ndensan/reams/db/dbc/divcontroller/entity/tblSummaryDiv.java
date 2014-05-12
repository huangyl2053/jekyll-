package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * tblSummary のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSummaryDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel11")
    private cel11AttblSummary cel11;
    @JsonProperty("cel12")
    private cel12AttblSummary cel12;
    @JsonProperty("cel13")
    private cel13AttblSummary cel13;
    @JsonProperty("cel21")
    private cel21AttblSummary cel21;
    @JsonProperty("cel22")
    private cel22AttblSummary cel22;
    @JsonProperty("cel23")
    private cel23AttblSummary cel23;
    @JsonProperty("cel31")
    private cel31AttblSummary cel31;
    @JsonProperty("cel32")
    private cel32AttblSummary cel32;
    @JsonProperty("cel33")
    private cel33AttblSummary cel33;
    @JsonProperty("cel14")
    private cel14AttblSummary cel14;
    @JsonProperty("cel15")
    private cel15AttblSummary cel15;
    @JsonProperty("cel24")
    private cel24AttblSummary cel24;
    @JsonProperty("cel25")
    private cel25AttblSummary cel25;
    @JsonProperty("cel34")
    private cel34AttblSummary cel34;
    @JsonProperty("cel35")
    private cel35AttblSummary cel35;
    @JsonProperty("cel36")
    private cel36AttblSummary cel36;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblSummary() {
        return this.cel11.getLblSummary();
    }

    @JsonIgnore
    public Label getLblPayTotal() {
        return this.cel12.getLblPayTotal();
    }

    @JsonIgnore
    public Label getLblHokenSeikyuAmount() {
        return this.cel13.getLblHokenSeikyuAmount();
    }

    @JsonIgnore
    public Label getLblSummaryMae() {
        return this.cel21.getLblSummaryMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtPayTotalMae() {
        return this.cel22.getTxtPayTotalMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenSeikyuAmountMae() {
        return this.cel23.getTxtHokenSeikyuAmountMae();
    }

    @JsonIgnore
    public Label getLblSummaryNow() {
        return this.cel31.getLblSummaryNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtPayTotalNow() {
        return this.cel32.getTxtPayTotalNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenSeikyuAmountNow() {
        return this.cel33.getTxtHokenSeikyuAmountNow();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanAmount() {
        return this.cel14.getLblRiyoshaFutanAmount();
    }

    @JsonIgnore
    public Label getLblLimitOverAmount() {
        return this.cel15.getLblLimitOverAmount();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return this.cel24.getTxtRiyoshaFutanAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtLimitOverAmountMae() {
        return this.cel25.getTxtLimitOverAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return this.cel34.getTxtRiyoshaFutanAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtLimitOverAmountNow() {
        return this.cel35.getTxtLimitOverAmountNow();
    }

    @JsonIgnore
    public Button getBtnLimitOverCheck() {
        return this.cel36.getBtnLimitOverCheck();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("cel11")
    private cel11AttblSummary getCel11() {
        return cel11;
    }

    @JsonProperty("cel11")
    private void setCel11(cel11AttblSummary cel11) {
        this.cel11=cel11;
    }

    @JsonProperty("cel12")
    private cel12AttblSummary getCel12() {
        return cel12;
    }

    @JsonProperty("cel12")
    private void setCel12(cel12AttblSummary cel12) {
        this.cel12=cel12;
    }

    @JsonProperty("cel13")
    private cel13AttblSummary getCel13() {
        return cel13;
    }

    @JsonProperty("cel13")
    private void setCel13(cel13AttblSummary cel13) {
        this.cel13=cel13;
    }

    @JsonProperty("cel21")
    private cel21AttblSummary getCel21() {
        return cel21;
    }

    @JsonProperty("cel21")
    private void setCel21(cel21AttblSummary cel21) {
        this.cel21=cel21;
    }

    @JsonProperty("cel22")
    private cel22AttblSummary getCel22() {
        return cel22;
    }

    @JsonProperty("cel22")
    private void setCel22(cel22AttblSummary cel22) {
        this.cel22=cel22;
    }

    @JsonProperty("cel23")
    private cel23AttblSummary getCel23() {
        return cel23;
    }

    @JsonProperty("cel23")
    private void setCel23(cel23AttblSummary cel23) {
        this.cel23=cel23;
    }

    @JsonProperty("cel31")
    private cel31AttblSummary getCel31() {
        return cel31;
    }

    @JsonProperty("cel31")
    private void setCel31(cel31AttblSummary cel31) {
        this.cel31=cel31;
    }

    @JsonProperty("cel32")
    private cel32AttblSummary getCel32() {
        return cel32;
    }

    @JsonProperty("cel32")
    private void setCel32(cel32AttblSummary cel32) {
        this.cel32=cel32;
    }

    @JsonProperty("cel33")
    private cel33AttblSummary getCel33() {
        return cel33;
    }

    @JsonProperty("cel33")
    private void setCel33(cel33AttblSummary cel33) {
        this.cel33=cel33;
    }

    @JsonProperty("cel14")
    private cel14AttblSummary getCel14() {
        return cel14;
    }

    @JsonProperty("cel14")
    private void setCel14(cel14AttblSummary cel14) {
        this.cel14=cel14;
    }

    @JsonProperty("cel15")
    private cel15AttblSummary getCel15() {
        return cel15;
    }

    @JsonProperty("cel15")
    private void setCel15(cel15AttblSummary cel15) {
        this.cel15=cel15;
    }

    @JsonProperty("cel24")
    private cel24AttblSummary getCel24() {
        return cel24;
    }

    @JsonProperty("cel24")
    private void setCel24(cel24AttblSummary cel24) {
        this.cel24=cel24;
    }

    @JsonProperty("cel25")
    private cel25AttblSummary getCel25() {
        return cel25;
    }

    @JsonProperty("cel25")
    private void setCel25(cel25AttblSummary cel25) {
        this.cel25=cel25;
    }

    @JsonProperty("cel34")
    private cel34AttblSummary getCel34() {
        return cel34;
    }

    @JsonProperty("cel34")
    private void setCel34(cel34AttblSummary cel34) {
        this.cel34=cel34;
    }

    @JsonProperty("cel35")
    private cel35AttblSummary getCel35() {
        return cel35;
    }

    @JsonProperty("cel35")
    private void setCel35(cel35AttblSummary cel35) {
        this.cel35=cel35;
    }

    @JsonProperty("cel36")
    private cel36AttblSummary getCel36() {
        return cel36;
    }

    @JsonProperty("cel36")
    private void setCel36(cel36AttblSummary cel36) {
        this.cel36=cel36;
    }

}
/**
 * cel11 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel11AttblSummary extends TableCell {
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
class cel12AttblSummary extends TableCell {
    @JsonProperty("lblPayTotal")
    private Label lblPayTotal;

    @JsonProperty("lblPayTotal")
    public Label getLblPayTotal() {
        return lblPayTotal;
    }

    @JsonProperty("lblPayTotal")
    public void setLblPayTotal(Label lblPayTotal) {
        this.lblPayTotal=lblPayTotal;
    }

}
/**
 * cel13 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel13AttblSummary extends TableCell {
    @JsonProperty("lblHokenSeikyuAmount")
    private Label lblHokenSeikyuAmount;

    @JsonProperty("lblHokenSeikyuAmount")
    public Label getLblHokenSeikyuAmount() {
        return lblHokenSeikyuAmount;
    }

    @JsonProperty("lblHokenSeikyuAmount")
    public void setLblHokenSeikyuAmount(Label lblHokenSeikyuAmount) {
        this.lblHokenSeikyuAmount=lblHokenSeikyuAmount;
    }

}
/**
 * cel21 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel21AttblSummary extends TableCell {
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
class cel22AttblSummary extends TableCell {
    @JsonProperty("txtPayTotalMae")
    private TextBoxNum txtPayTotalMae;

    @JsonProperty("txtPayTotalMae")
    public TextBoxNum getTxtPayTotalMae() {
        return txtPayTotalMae;
    }

    @JsonProperty("txtPayTotalMae")
    public void setTxtPayTotalMae(TextBoxNum txtPayTotalMae) {
        this.txtPayTotalMae=txtPayTotalMae;
    }

}
/**
 * cel23 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel23AttblSummary extends TableCell {
    @JsonProperty("txtHokenSeikyuAmountMae")
    private TextBoxNum txtHokenSeikyuAmountMae;

    @JsonProperty("txtHokenSeikyuAmountMae")
    public TextBoxNum getTxtHokenSeikyuAmountMae() {
        return txtHokenSeikyuAmountMae;
    }

    @JsonProperty("txtHokenSeikyuAmountMae")
    public void setTxtHokenSeikyuAmountMae(TextBoxNum txtHokenSeikyuAmountMae) {
        this.txtHokenSeikyuAmountMae=txtHokenSeikyuAmountMae;
    }

}
/**
 * cel31 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel31AttblSummary extends TableCell {
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
class cel32AttblSummary extends TableCell {
    @JsonProperty("txtPayTotalNow")
    private TextBoxNum txtPayTotalNow;

    @JsonProperty("txtPayTotalNow")
    public TextBoxNum getTxtPayTotalNow() {
        return txtPayTotalNow;
    }

    @JsonProperty("txtPayTotalNow")
    public void setTxtPayTotalNow(TextBoxNum txtPayTotalNow) {
        this.txtPayTotalNow=txtPayTotalNow;
    }

}
/**
 * cel33 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel33AttblSummary extends TableCell {
    @JsonProperty("txtHokenSeikyuAmountNow")
    private TextBoxNum txtHokenSeikyuAmountNow;

    @JsonProperty("txtHokenSeikyuAmountNow")
    public TextBoxNum getTxtHokenSeikyuAmountNow() {
        return txtHokenSeikyuAmountNow;
    }

    @JsonProperty("txtHokenSeikyuAmountNow")
    public void setTxtHokenSeikyuAmountNow(TextBoxNum txtHokenSeikyuAmountNow) {
        this.txtHokenSeikyuAmountNow=txtHokenSeikyuAmountNow;
    }

}
/**
 * cel14 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel14AttblSummary extends TableCell {
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
 * cel15 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel15AttblSummary extends TableCell {
    @JsonProperty("lblLimitOverAmount")
    private Label lblLimitOverAmount;

    @JsonProperty("lblLimitOverAmount")
    public Label getLblLimitOverAmount() {
        return lblLimitOverAmount;
    }

    @JsonProperty("lblLimitOverAmount")
    public void setLblLimitOverAmount(Label lblLimitOverAmount) {
        this.lblLimitOverAmount=lblLimitOverAmount;
    }

}
/**
 * cel24 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel24AttblSummary extends TableCell {
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
 * cel25 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel25AttblSummary extends TableCell {
    @JsonProperty("txtLimitOverAmountMae")
    private TextBoxNum txtLimitOverAmountMae;

    @JsonProperty("txtLimitOverAmountMae")
    public TextBoxNum getTxtLimitOverAmountMae() {
        return txtLimitOverAmountMae;
    }

    @JsonProperty("txtLimitOverAmountMae")
    public void setTxtLimitOverAmountMae(TextBoxNum txtLimitOverAmountMae) {
        this.txtLimitOverAmountMae=txtLimitOverAmountMae;
    }

}
/**
 * cel34 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel34AttblSummary extends TableCell {
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
 * cel35 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel35AttblSummary extends TableCell {
    @JsonProperty("txtLimitOverAmountNow")
    private TextBoxNum txtLimitOverAmountNow;

    @JsonProperty("txtLimitOverAmountNow")
    public TextBoxNum getTxtLimitOverAmountNow() {
        return txtLimitOverAmountNow;
    }

    @JsonProperty("txtLimitOverAmountNow")
    public void setTxtLimitOverAmountNow(TextBoxNum txtLimitOverAmountNow) {
        this.txtLimitOverAmountNow=txtLimitOverAmountNow;
    }

}
/**
 * cel36 のクラスファイル 
 * 
 * @author 自動生成
 */
class cel36AttblSummary extends TableCell {
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
