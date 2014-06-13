package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001;
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
 * tblIkensho5Komoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblIkensho5KomokuDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celNetakiridoHeader")
    private celNetakiridoHeaderAttblIkensho5Komoku celNetakiridoHeader;
    @JsonProperty("celNinchiHeader")
    private celNinchiHeaderAttblIkensho5Komoku celNinchiHeader;
    @JsonProperty("celTankikiokuHeader")
    private celTankikiokuHeaderAttblIkensho5Komoku celTankikiokuHeader;
    @JsonProperty("celNinchiNoryokuHeader")
    private celNinchiNoryokuHeaderAttblIkensho5Komoku celNinchiNoryokuHeader;
    @JsonProperty("celDentatsuNoryokuHeader")
    private celDentatsuNoryokuHeaderAttblIkensho5Komoku celDentatsuNoryokuHeader;
    @JsonProperty("celNetakirido")
    private celNetakiridoAttblIkensho5Komoku celNetakirido;
    @JsonProperty("celNinchi")
    private celNinchiAttblIkensho5Komoku celNinchi;
    @JsonProperty("celTankikioku")
    private celTankikiokuAttblIkensho5Komoku celTankikioku;
    @JsonProperty("celNinchiNoryoku")
    private celNinchiNoryokuAttblIkensho5Komoku celNinchiNoryoku;
    @JsonProperty("celDentatsuNoryoku")
    private celDentatsuNoryokuAttblIkensho5Komoku celDentatsuNoryoku;
    @JsonProperty("celShokujiKoiHeader")
    private celShokujiKoiHeaderAttblIkensho5Komoku celShokujiKoiHeader;
    @JsonProperty("celShokujiKoi")
    private celShokujiKoiAttblIkensho5Komoku celShokujiKoi;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblNetakirido() {
        return this.celNetakiridoHeader.getLblNetakirido();
    }

    @JsonIgnore
    public Label getLblNinchi() {
        return this.celNinchiHeader.getLblNinchi();
    }

    @JsonIgnore
    public Label getLblTankikioku() {
        return this.celTankikiokuHeader.getLblTankikioku();
    }

    @JsonIgnore
    public Label getLblNinchiNoryoku() {
        return this.celNinchiNoryokuHeader.getLblNinchiNoryoku();
    }

    @JsonIgnore
    public Label getLblDentatsuNoryoku() {
        return this.celDentatsuNoryokuHeader.getLblDentatsuNoryoku();
    }

    @JsonIgnore
    public DropDownList getDdlNetakirido() {
        return this.celNetakirido.getDdlNetakirido();
    }

    @JsonIgnore
    public DropDownList getDdlNinchi() {
        return this.celNinchi.getDdlNinchi();
    }

    @JsonIgnore
    public DropDownList getDdlTankikioku() {
        return this.celTankikioku.getDdlTankikioku();
    }

    @JsonIgnore
    public DropDownList getDdlNinchiNoryoku() {
        return this.celNinchiNoryoku.getDdlNinchiNoryoku();
    }

    @JsonIgnore
    public DropDownList getDdlDentatsuNoryoku() {
        return this.celDentatsuNoryoku.getDdlDentatsuNoryoku();
    }

    @JsonIgnore
    public Label getLblShokujiKoi() {
        return this.celShokujiKoiHeader.getLblShokujiKoi();
    }

    @JsonIgnore
    public DropDownList getDdlShokujiKoi() {
        return this.celShokujiKoi.getDdlShokujiKoi();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celNetakiridoHeader")
    private celNetakiridoHeaderAttblIkensho5Komoku getCelNetakiridoHeader() {
        return celNetakiridoHeader;
    }

    @JsonProperty("celNetakiridoHeader")
    private void setCelNetakiridoHeader(celNetakiridoHeaderAttblIkensho5Komoku celNetakiridoHeader) {
        this.celNetakiridoHeader=celNetakiridoHeader;
    }

    @JsonProperty("celNinchiHeader")
    private celNinchiHeaderAttblIkensho5Komoku getCelNinchiHeader() {
        return celNinchiHeader;
    }

    @JsonProperty("celNinchiHeader")
    private void setCelNinchiHeader(celNinchiHeaderAttblIkensho5Komoku celNinchiHeader) {
        this.celNinchiHeader=celNinchiHeader;
    }

    @JsonProperty("celTankikiokuHeader")
    private celTankikiokuHeaderAttblIkensho5Komoku getCelTankikiokuHeader() {
        return celTankikiokuHeader;
    }

    @JsonProperty("celTankikiokuHeader")
    private void setCelTankikiokuHeader(celTankikiokuHeaderAttblIkensho5Komoku celTankikiokuHeader) {
        this.celTankikiokuHeader=celTankikiokuHeader;
    }

    @JsonProperty("celNinchiNoryokuHeader")
    private celNinchiNoryokuHeaderAttblIkensho5Komoku getCelNinchiNoryokuHeader() {
        return celNinchiNoryokuHeader;
    }

    @JsonProperty("celNinchiNoryokuHeader")
    private void setCelNinchiNoryokuHeader(celNinchiNoryokuHeaderAttblIkensho5Komoku celNinchiNoryokuHeader) {
        this.celNinchiNoryokuHeader=celNinchiNoryokuHeader;
    }

    @JsonProperty("celDentatsuNoryokuHeader")
    private celDentatsuNoryokuHeaderAttblIkensho5Komoku getCelDentatsuNoryokuHeader() {
        return celDentatsuNoryokuHeader;
    }

    @JsonProperty("celDentatsuNoryokuHeader")
    private void setCelDentatsuNoryokuHeader(celDentatsuNoryokuHeaderAttblIkensho5Komoku celDentatsuNoryokuHeader) {
        this.celDentatsuNoryokuHeader=celDentatsuNoryokuHeader;
    }

    @JsonProperty("celNetakirido")
    private celNetakiridoAttblIkensho5Komoku getCelNetakirido() {
        return celNetakirido;
    }

    @JsonProperty("celNetakirido")
    private void setCelNetakirido(celNetakiridoAttblIkensho5Komoku celNetakirido) {
        this.celNetakirido=celNetakirido;
    }

    @JsonProperty("celNinchi")
    private celNinchiAttblIkensho5Komoku getCelNinchi() {
        return celNinchi;
    }

    @JsonProperty("celNinchi")
    private void setCelNinchi(celNinchiAttblIkensho5Komoku celNinchi) {
        this.celNinchi=celNinchi;
    }

    @JsonProperty("celTankikioku")
    private celTankikiokuAttblIkensho5Komoku getCelTankikioku() {
        return celTankikioku;
    }

    @JsonProperty("celTankikioku")
    private void setCelTankikioku(celTankikiokuAttblIkensho5Komoku celTankikioku) {
        this.celTankikioku=celTankikioku;
    }

    @JsonProperty("celNinchiNoryoku")
    private celNinchiNoryokuAttblIkensho5Komoku getCelNinchiNoryoku() {
        return celNinchiNoryoku;
    }

    @JsonProperty("celNinchiNoryoku")
    private void setCelNinchiNoryoku(celNinchiNoryokuAttblIkensho5Komoku celNinchiNoryoku) {
        this.celNinchiNoryoku=celNinchiNoryoku;
    }

    @JsonProperty("celDentatsuNoryoku")
    private celDentatsuNoryokuAttblIkensho5Komoku getCelDentatsuNoryoku() {
        return celDentatsuNoryoku;
    }

    @JsonProperty("celDentatsuNoryoku")
    private void setCelDentatsuNoryoku(celDentatsuNoryokuAttblIkensho5Komoku celDentatsuNoryoku) {
        this.celDentatsuNoryoku=celDentatsuNoryoku;
    }

    @JsonProperty("celShokujiKoiHeader")
    private celShokujiKoiHeaderAttblIkensho5Komoku getCelShokujiKoiHeader() {
        return celShokujiKoiHeader;
    }

    @JsonProperty("celShokujiKoiHeader")
    private void setCelShokujiKoiHeader(celShokujiKoiHeaderAttblIkensho5Komoku celShokujiKoiHeader) {
        this.celShokujiKoiHeader=celShokujiKoiHeader;
    }

    @JsonProperty("celShokujiKoi")
    private celShokujiKoiAttblIkensho5Komoku getCelShokujiKoi() {
        return celShokujiKoi;
    }

    @JsonProperty("celShokujiKoi")
    private void setCelShokujiKoi(celShokujiKoiAttblIkensho5Komoku celShokujiKoi) {
        this.celShokujiKoi=celShokujiKoi;
    }

}
/**
 * celNetakiridoHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celNetakiridoHeaderAttblIkensho5Komoku extends TableCell {
    @JsonProperty("lblNetakirido")
    private Label lblNetakirido;

    @JsonProperty("lblNetakirido")
    public Label getLblNetakirido() {
        return lblNetakirido;
    }

    @JsonProperty("lblNetakirido")
    public void setLblNetakirido(Label lblNetakirido) {
        this.lblNetakirido=lblNetakirido;
    }

}
/**
 * celNinchiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchiHeaderAttblIkensho5Komoku extends TableCell {
    @JsonProperty("lblNinchi")
    private Label lblNinchi;

    @JsonProperty("lblNinchi")
    public Label getLblNinchi() {
        return lblNinchi;
    }

    @JsonProperty("lblNinchi")
    public void setLblNinchi(Label lblNinchi) {
        this.lblNinchi=lblNinchi;
    }

}
/**
 * celTankikiokuHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celTankikiokuHeaderAttblIkensho5Komoku extends TableCell {
    @JsonProperty("lblTankikioku")
    private Label lblTankikioku;

    @JsonProperty("lblTankikioku")
    public Label getLblTankikioku() {
        return lblTankikioku;
    }

    @JsonProperty("lblTankikioku")
    public void setLblTankikioku(Label lblTankikioku) {
        this.lblTankikioku=lblTankikioku;
    }

}
/**
 * celNinchiNoryokuHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchiNoryokuHeaderAttblIkensho5Komoku extends TableCell {
    @JsonProperty("lblNinchiNoryoku")
    private Label lblNinchiNoryoku;

    @JsonProperty("lblNinchiNoryoku")
    public Label getLblNinchiNoryoku() {
        return lblNinchiNoryoku;
    }

    @JsonProperty("lblNinchiNoryoku")
    public void setLblNinchiNoryoku(Label lblNinchiNoryoku) {
        this.lblNinchiNoryoku=lblNinchiNoryoku;
    }

}
/**
 * celDentatsuNoryokuHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celDentatsuNoryokuHeaderAttblIkensho5Komoku extends TableCell {
    @JsonProperty("lblDentatsuNoryoku")
    private Label lblDentatsuNoryoku;

    @JsonProperty("lblDentatsuNoryoku")
    public Label getLblDentatsuNoryoku() {
        return lblDentatsuNoryoku;
    }

    @JsonProperty("lblDentatsuNoryoku")
    public void setLblDentatsuNoryoku(Label lblDentatsuNoryoku) {
        this.lblDentatsuNoryoku=lblDentatsuNoryoku;
    }

}
/**
 * celNetakirido のクラスファイル 
 * 
 * @author 自動生成
 */
class celNetakiridoAttblIkensho5Komoku extends TableCell {
    @JsonProperty("ddlNetakirido")
    private DropDownList ddlNetakirido;

    @JsonProperty("ddlNetakirido")
    public DropDownList getDdlNetakirido() {
        return ddlNetakirido;
    }

    @JsonProperty("ddlNetakirido")
    public void setDdlNetakirido(DropDownList ddlNetakirido) {
        this.ddlNetakirido=ddlNetakirido;
    }

}
/**
 * celNinchi のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchiAttblIkensho5Komoku extends TableCell {
    @JsonProperty("ddlNinchi")
    private DropDownList ddlNinchi;

    @JsonProperty("ddlNinchi")
    public DropDownList getDdlNinchi() {
        return ddlNinchi;
    }

    @JsonProperty("ddlNinchi")
    public void setDdlNinchi(DropDownList ddlNinchi) {
        this.ddlNinchi=ddlNinchi;
    }

}
/**
 * celTankikioku のクラスファイル 
 * 
 * @author 自動生成
 */
class celTankikiokuAttblIkensho5Komoku extends TableCell {
    @JsonProperty("ddlTankikioku")
    private DropDownList ddlTankikioku;

    @JsonProperty("ddlTankikioku")
    public DropDownList getDdlTankikioku() {
        return ddlTankikioku;
    }

    @JsonProperty("ddlTankikioku")
    public void setDdlTankikioku(DropDownList ddlTankikioku) {
        this.ddlTankikioku=ddlTankikioku;
    }

}
/**
 * celNinchiNoryoku のクラスファイル 
 * 
 * @author 自動生成
 */
class celNinchiNoryokuAttblIkensho5Komoku extends TableCell {
    @JsonProperty("ddlNinchiNoryoku")
    private DropDownList ddlNinchiNoryoku;

    @JsonProperty("ddlNinchiNoryoku")
    public DropDownList getDdlNinchiNoryoku() {
        return ddlNinchiNoryoku;
    }

    @JsonProperty("ddlNinchiNoryoku")
    public void setDdlNinchiNoryoku(DropDownList ddlNinchiNoryoku) {
        this.ddlNinchiNoryoku=ddlNinchiNoryoku;
    }

}
/**
 * celDentatsuNoryoku のクラスファイル 
 * 
 * @author 自動生成
 */
class celDentatsuNoryokuAttblIkensho5Komoku extends TableCell {
    @JsonProperty("ddlDentatsuNoryoku")
    private DropDownList ddlDentatsuNoryoku;

    @JsonProperty("ddlDentatsuNoryoku")
    public DropDownList getDdlDentatsuNoryoku() {
        return ddlDentatsuNoryoku;
    }

    @JsonProperty("ddlDentatsuNoryoku")
    public void setDdlDentatsuNoryoku(DropDownList ddlDentatsuNoryoku) {
        this.ddlDentatsuNoryoku=ddlDentatsuNoryoku;
    }

}
/**
 * celShokujiKoiHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokujiKoiHeaderAttblIkensho5Komoku extends TableCell {
    @JsonProperty("lblShokujiKoi")
    private Label lblShokujiKoi;

    @JsonProperty("lblShokujiKoi")
    public Label getLblShokujiKoi() {
        return lblShokujiKoi;
    }

    @JsonProperty("lblShokujiKoi")
    public void setLblShokujiKoi(Label lblShokujiKoi) {
        this.lblShokujiKoi=lblShokujiKoi;
    }

}
/**
 * celShokujiKoi のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokujiKoiAttblIkensho5Komoku extends TableCell {
    @JsonProperty("ddlShokujiKoi")
    private DropDownList ddlShokujiKoi;

    @JsonProperty("ddlShokujiKoi")
    public DropDownList getDdlShokujiKoi() {
        return ddlShokujiKoi;
    }

    @JsonProperty("ddlShokujiKoi")
    public void setDdlShokujiKoi(DropDownList ddlShokujiKoi) {
        this.ddlShokujiKoi=ddlShokujiKoi;
    }

}
