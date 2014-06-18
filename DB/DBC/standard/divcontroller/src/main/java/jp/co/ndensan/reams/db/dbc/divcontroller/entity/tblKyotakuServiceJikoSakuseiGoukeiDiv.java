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
 * tblKyotakuServiceJikoSakuseiGoukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyotakuServiceJikoSakuseiGoukeiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiGoukeiCell")
    private tblKyotakuServiceJikoSakuseiGoukeiCellAttblKyotakuServiceJikoSakuseiGoukei tblKyotakuServiceJikoSakuseiGoukeiCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailUnitTanka() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailUnitTanka();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailHiyoTotal() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailHiyoTotal();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailHokenKyufu() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailHokenKyufu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal() {
        return this.tblKyotakuServiceJikoSakuseiGoukeiCell.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiGoukeiCell")
    private tblKyotakuServiceJikoSakuseiGoukeiCellAttblKyotakuServiceJikoSakuseiGoukei getTblKyotakuServiceJikoSakuseiGoukeiCell() {
        return tblKyotakuServiceJikoSakuseiGoukeiCell;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiGoukeiCell")
    private void setTblKyotakuServiceJikoSakuseiGoukeiCell(tblKyotakuServiceJikoSakuseiGoukeiCellAttblKyotakuServiceJikoSakuseiGoukei tblKyotakuServiceJikoSakuseiGoukeiCell) {
        this.tblKyotakuServiceJikoSakuseiGoukeiCell=tblKyotakuServiceJikoSakuseiGoukeiCell;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiGoukeiCell のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiGoukeiCellAttblKyotakuServiceJikoSakuseiGoukei extends TableCell {
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailUnitTanka")
    private TextBox txtKyotakuServiceJikoSakuseiDetailUnitTanka;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKyufuRitsu")
    private TextBox txtKyotakuServiceJikoSakuseiDetailKyufuRitsu;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailHiyoTotal")
    private TextBox txtKyotakuServiceJikoSakuseiDetailHiyoTotal;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailHokenKyufu")
    private TextBox txtKyotakuServiceJikoSakuseiDetailHokenKyufu;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken")
    private TextBox txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal")
    private TextBox txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal;

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit() {
        return txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit")
    public void setTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit(TextBox txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit) {
        this.txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit=txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit() {
        return txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit")
    public void setTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit(TextBox txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit) {
        this.txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit=txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailUnitTanka")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailUnitTanka() {
        return txtKyotakuServiceJikoSakuseiDetailUnitTanka;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailUnitTanka")
    public void setTxtKyotakuServiceJikoSakuseiDetailUnitTanka(TextBox txtKyotakuServiceJikoSakuseiDetailUnitTanka) {
        this.txtKyotakuServiceJikoSakuseiDetailUnitTanka=txtKyotakuServiceJikoSakuseiDetailUnitTanka;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKyufuRitsu")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu() {
        return txtKyotakuServiceJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKyufuRitsu")
    public void setTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu(TextBox txtKyotakuServiceJikoSakuseiDetailKyufuRitsu) {
        this.txtKyotakuServiceJikoSakuseiDetailKyufuRitsu=txtKyotakuServiceJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit() {
        return txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit")
    public void setTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit(TextBox txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit) {
        this.txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit=txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit() {
        return txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit")
    public void setTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit(TextBox txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit) {
        this.txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit=txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailHiyoTotal")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailHiyoTotal() {
        return txtKyotakuServiceJikoSakuseiDetailHiyoTotal;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailHiyoTotal")
    public void setTxtKyotakuServiceJikoSakuseiDetailHiyoTotal(TextBox txtKyotakuServiceJikoSakuseiDetailHiyoTotal) {
        this.txtKyotakuServiceJikoSakuseiDetailHiyoTotal=txtKyotakuServiceJikoSakuseiDetailHiyoTotal;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailHokenKyufu")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailHokenKyufu() {
        return txtKyotakuServiceJikoSakuseiDetailHokenKyufu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailHokenKyufu")
    public void setTxtKyotakuServiceJikoSakuseiDetailHokenKyufu(TextBox txtKyotakuServiceJikoSakuseiDetailHokenKyufu) {
        this.txtKyotakuServiceJikoSakuseiDetailHokenKyufu=txtKyotakuServiceJikoSakuseiDetailHokenKyufu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken() {
        return txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken")
    public void setTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken(TextBox txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken) {
        this.txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken=txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal() {
        return txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal")
    public void setTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal(TextBox txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal) {
        this.txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal=txtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal;
    }

}
