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
 * tblTankiNyushoJikoSakuseiGoukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTankiNyushoJikoSakuseiGoukeiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiGoukeiCell")
    private tblTankiNyushoJikoSakuseiGoukeiCellAttblTankiNyushoJikoSakuseiGoukei tblTankiNyushoJikoSakuseiGoukeiCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailUnitTanka() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailUnitTanka();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuRitsu() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailKyufuRitsu();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHiyoTotal() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailHiyoTotal();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal() {
        return this.tblTankiNyushoJikoSakuseiGoukeiCell.getTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiGoukeiCell")
    private tblTankiNyushoJikoSakuseiGoukeiCellAttblTankiNyushoJikoSakuseiGoukei getTblTankiNyushoJikoSakuseiGoukeiCell() {
        return tblTankiNyushoJikoSakuseiGoukeiCell;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiGoukeiCell")
    private void setTblTankiNyushoJikoSakuseiGoukeiCell(tblTankiNyushoJikoSakuseiGoukeiCellAttblTankiNyushoJikoSakuseiGoukei tblTankiNyushoJikoSakuseiGoukeiCell) {
        this.tblTankiNyushoJikoSakuseiGoukeiCell=tblTankiNyushoJikoSakuseiGoukeiCell;
    }

}
/**
 * tblTankiNyushoJikoSakuseiGoukeiCell のクラスファイル 
 * 
 * @author 自動生成
 */
class tblTankiNyushoJikoSakuseiGoukeiCellAttblTankiNyushoJikoSakuseiGoukei extends TableCell {
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailUnitTanka")
    private TextBox txtTankiNyushoJikoSakuseiDetailUnitTanka;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuRitsu")
    private TextBox txtTankiNyushoJikoSakuseiDetailKyufuRitsu;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit")
    private TextBox txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHiyoTotal")
    private TextBox txtTankiNyushoJikoSakuseiDetailHiyoTotal;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku")
    private TextBox txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku")
    private TextBox txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit")
    private TextBox txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal")
    private TextBox txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal;

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailUnitTanka")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailUnitTanka() {
        return txtTankiNyushoJikoSakuseiDetailUnitTanka;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailUnitTanka")
    public void setTxtTankiNyushoJikoSakuseiDetailUnitTanka(TextBox txtTankiNyushoJikoSakuseiDetailUnitTanka) {
        this.txtTankiNyushoJikoSakuseiDetailUnitTanka=txtTankiNyushoJikoSakuseiDetailUnitTanka;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuRitsu")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuRitsu() {
        return txtTankiNyushoJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuRitsu")
    public void setTxtTankiNyushoJikoSakuseiDetailKyufuRitsu(TextBox txtTankiNyushoJikoSakuseiDetailKyufuRitsu) {
        this.txtTankiNyushoJikoSakuseiDetailKyufuRitsu=txtTankiNyushoJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit() {
        return txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit")
    public void setTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit(TextBox txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit) {
        this.txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit=txtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHiyoTotal")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHiyoTotal() {
        return txtTankiNyushoJikoSakuseiDetailHiyoTotal;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHiyoTotal")
    public void setTxtTankiNyushoJikoSakuseiDetailHiyoTotal(TextBox txtTankiNyushoJikoSakuseiDetailHiyoTotal) {
        this.txtTankiNyushoJikoSakuseiDetailHiyoTotal=txtTankiNyushoJikoSakuseiDetailHiyoTotal;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku() {
        return txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku")
    public void setTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku(TextBox txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku) {
        this.txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku=txtTankiNyushoJikoSakuseiDetailHokenKyufuGaku;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku() {
        return txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku")
    public void setTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku(TextBox txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku) {
        this.txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku=txtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit() {
        return txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit")
    public void setTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit(TextBox txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit) {
        this.txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit=txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal() {
        return txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal")
    public void setTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal(TextBox txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal) {
        this.txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal=txtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal;
    }

}
