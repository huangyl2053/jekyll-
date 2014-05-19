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
 * tblHomonTsushoJikoSakuseiGoukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblHomonTsushoJikoSakuseiGoukeiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiGoukeiCell")
    private tblHomonTsushoJikoSakuseiGoukeiCellAttblHomonTsushoJikoSakuseiGoukei tblHomonTsushoJikoSakuseiGoukeiCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailUnitTanka() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailUnitTanka();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailHiyoTotal() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailHiyoTotal();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailHokenKyufu() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailHokenKyufu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal() {
        return this.tblHomonTsushoJikoSakuseiGoukeiCell.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiGoukeiCell")
    private tblHomonTsushoJikoSakuseiGoukeiCellAttblHomonTsushoJikoSakuseiGoukei getTblHomonTsushoJikoSakuseiGoukeiCell() {
        return tblHomonTsushoJikoSakuseiGoukeiCell;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiGoukeiCell")
    private void setTblHomonTsushoJikoSakuseiGoukeiCell(tblHomonTsushoJikoSakuseiGoukeiCellAttblHomonTsushoJikoSakuseiGoukei tblHomonTsushoJikoSakuseiGoukeiCell) {
        this.tblHomonTsushoJikoSakuseiGoukeiCell=tblHomonTsushoJikoSakuseiGoukeiCell;
    }

}
/**
 * tblHomonTsushoJikoSakuseiGoukeiCell のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHomonTsushoJikoSakuseiGoukeiCellAttblHomonTsushoJikoSakuseiGoukei extends TableCell {
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailUnitTanka")
    private TextBox txtHomonTsushoJikoSakuseiDetailUnitTanka;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKyufuRitsu")
    private TextBox txtHomonTsushoJikoSakuseiDetailKyufuRitsu;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailHiyoTotal")
    private TextBox txtHomonTsushoJikoSakuseiDetailHiyoTotal;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailHokenKyufu")
    private TextBox txtHomonTsushoJikoSakuseiDetailHokenKyufu;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken")
    private TextBox txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal")
    private TextBox txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal;

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit() {
        return txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit")
    public void setTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit(TextBox txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit) {
        this.txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit=txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit() {
        return txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit")
    public void setTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit(TextBox txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit) {
        this.txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit=txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailUnitTanka")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailUnitTanka() {
        return txtHomonTsushoJikoSakuseiDetailUnitTanka;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailUnitTanka")
    public void setTxtHomonTsushoJikoSakuseiDetailUnitTanka(TextBox txtHomonTsushoJikoSakuseiDetailUnitTanka) {
        this.txtHomonTsushoJikoSakuseiDetailUnitTanka=txtHomonTsushoJikoSakuseiDetailUnitTanka;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKyufuRitsu")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu() {
        return txtHomonTsushoJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKyufuRitsu")
    public void setTxtHomonTsushoJikoSakuseiDetailKyufuRitsu(TextBox txtHomonTsushoJikoSakuseiDetailKyufuRitsu) {
        this.txtHomonTsushoJikoSakuseiDetailKyufuRitsu=txtHomonTsushoJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit() {
        return txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit")
    public void setTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit(TextBox txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit) {
        this.txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit=txtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit() {
        return txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit")
    public void setTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit(TextBox txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit) {
        this.txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit=txtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailHiyoTotal")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailHiyoTotal() {
        return txtHomonTsushoJikoSakuseiDetailHiyoTotal;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailHiyoTotal")
    public void setTxtHomonTsushoJikoSakuseiDetailHiyoTotal(TextBox txtHomonTsushoJikoSakuseiDetailHiyoTotal) {
        this.txtHomonTsushoJikoSakuseiDetailHiyoTotal=txtHomonTsushoJikoSakuseiDetailHiyoTotal;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailHokenKyufu")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailHokenKyufu() {
        return txtHomonTsushoJikoSakuseiDetailHokenKyufu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailHokenKyufu")
    public void setTxtHomonTsushoJikoSakuseiDetailHokenKyufu(TextBox txtHomonTsushoJikoSakuseiDetailHokenKyufu) {
        this.txtHomonTsushoJikoSakuseiDetailHokenKyufu=txtHomonTsushoJikoSakuseiDetailHokenKyufu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken() {
        return txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken")
    public void setTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken(TextBox txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken) {
        this.txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken=txtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal() {
        return txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal")
    public void setTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal(TextBox txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal) {
        this.txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal=txtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal;
    }

}
