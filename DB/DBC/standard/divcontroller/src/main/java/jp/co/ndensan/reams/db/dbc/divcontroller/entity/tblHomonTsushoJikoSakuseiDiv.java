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
 * tblHomonTsushoJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblHomonTsushoJikoSakuseiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakusei1")
    private tblHomonTsushoJikoSakusei1AttblHomonTsushoJikoSakusei tblHomonTsushoJikoSakusei1;
    @JsonProperty("tblHomonTsushoJikoSakusei2")
    private tblHomonTsushoJikoSakusei2AttblHomonTsushoJikoSakusei tblHomonTsushoJikoSakusei2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailJigyoshaNo() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailJigyoshaNo();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailJigyoshaName() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailJigyoshaName();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode1() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailServiceCode1();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode2() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailServiceCode2();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode3() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailServiceCode3();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailUnit() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKaisu() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailKaisu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceUnit() {
        return this.tblHomonTsushoJikoSakusei1.getTxtHomonTsushoJikoSakuseiDetailServiceUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailUnitTanka() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailUnitTanka();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailKubunLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailKubunLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailHiyoTotal() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailHiyoTotal();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailHokenKyufu() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailHokenKyufu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanHoken();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal() {
        return this.tblHomonTsushoJikoSakusei2.getTxtHomonTsushoJikoSakuseiDetailRiyoshaFutanTotal();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakusei1")
    private tblHomonTsushoJikoSakusei1AttblHomonTsushoJikoSakusei getTblHomonTsushoJikoSakusei1() {
        return tblHomonTsushoJikoSakusei1;
    }

    @JsonProperty("tblHomonTsushoJikoSakusei1")
    private void setTblHomonTsushoJikoSakusei1(tblHomonTsushoJikoSakusei1AttblHomonTsushoJikoSakusei tblHomonTsushoJikoSakusei1) {
        this.tblHomonTsushoJikoSakusei1=tblHomonTsushoJikoSakusei1;
    }

    @JsonProperty("tblHomonTsushoJikoSakusei2")
    private tblHomonTsushoJikoSakusei2AttblHomonTsushoJikoSakusei getTblHomonTsushoJikoSakusei2() {
        return tblHomonTsushoJikoSakusei2;
    }

    @JsonProperty("tblHomonTsushoJikoSakusei2")
    private void setTblHomonTsushoJikoSakusei2(tblHomonTsushoJikoSakusei2AttblHomonTsushoJikoSakusei tblHomonTsushoJikoSakusei2) {
        this.tblHomonTsushoJikoSakusei2=tblHomonTsushoJikoSakusei2;
    }

}
/**
 * tblHomonTsushoJikoSakusei1 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHomonTsushoJikoSakusei1AttblHomonTsushoJikoSakusei extends TableCell {
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailJigyoshaNo")
    private TextBox txtHomonTsushoJikoSakuseiDetailJigyoshaNo;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailJigyoshaName")
    private TextBox txtHomonTsushoJikoSakuseiDetailJigyoshaName;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode1")
    private TextBox txtHomonTsushoJikoSakuseiDetailServiceCode1;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode2")
    private TextBox txtHomonTsushoJikoSakuseiDetailServiceCode2;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode3")
    private TextBox txtHomonTsushoJikoSakuseiDetailServiceCode3;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu")
    private TextBox txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKyufuRitsu")
    private TextBox txtHomonTsushoJikoSakuseiDetailKyufuRitsu;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKaisu")
    private TextBox txtHomonTsushoJikoSakuseiDetailKaisu;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailServiceUnit;

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailJigyoshaNo")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailJigyoshaNo() {
        return txtHomonTsushoJikoSakuseiDetailJigyoshaNo;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailJigyoshaNo")
    public void setTxtHomonTsushoJikoSakuseiDetailJigyoshaNo(TextBox txtHomonTsushoJikoSakuseiDetailJigyoshaNo) {
        this.txtHomonTsushoJikoSakuseiDetailJigyoshaNo=txtHomonTsushoJikoSakuseiDetailJigyoshaNo;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailJigyoshaName")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailJigyoshaName() {
        return txtHomonTsushoJikoSakuseiDetailJigyoshaName;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailJigyoshaName")
    public void setTxtHomonTsushoJikoSakuseiDetailJigyoshaName(TextBox txtHomonTsushoJikoSakuseiDetailJigyoshaName) {
        this.txtHomonTsushoJikoSakuseiDetailJigyoshaName=txtHomonTsushoJikoSakuseiDetailJigyoshaName;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode1")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode1() {
        return txtHomonTsushoJikoSakuseiDetailServiceCode1;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode1")
    public void setTxtHomonTsushoJikoSakuseiDetailServiceCode1(TextBox txtHomonTsushoJikoSakuseiDetailServiceCode1) {
        this.txtHomonTsushoJikoSakuseiDetailServiceCode1=txtHomonTsushoJikoSakuseiDetailServiceCode1;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode2")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode2() {
        return txtHomonTsushoJikoSakuseiDetailServiceCode2;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode2")
    public void setTxtHomonTsushoJikoSakuseiDetailServiceCode2(TextBox txtHomonTsushoJikoSakuseiDetailServiceCode2) {
        this.txtHomonTsushoJikoSakuseiDetailServiceCode2=txtHomonTsushoJikoSakuseiDetailServiceCode2;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode3")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode3() {
        return txtHomonTsushoJikoSakuseiDetailServiceCode3;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceCode3")
    public void setTxtHomonTsushoJikoSakuseiDetailServiceCode3(TextBox txtHomonTsushoJikoSakuseiDetailServiceCode3) {
        this.txtHomonTsushoJikoSakuseiDetailServiceCode3=txtHomonTsushoJikoSakuseiDetailServiceCode3;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailUnit")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailUnit() {
        return txtHomonTsushoJikoSakuseiDetailUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailUnit")
    public void setTxtHomonTsushoJikoSakuseiDetailUnit(TextBox txtHomonTsushoJikoSakuseiDetailUnit) {
        this.txtHomonTsushoJikoSakuseiDetailUnit=txtHomonTsushoJikoSakuseiDetailUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu() {
        return txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu")
    public void setTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu(TextBox txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu) {
        this.txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu=txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit() {
        return txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit")
    public void setTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit(TextBox txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit) {
        this.txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit=txtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKyufuRitsu")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKyufuRitsu() {
        return txtHomonTsushoJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKyufuRitsu")
    public void setTxtHomonTsushoJikoSakuseiDetailKyufuRitsu(TextBox txtHomonTsushoJikoSakuseiDetailKyufuRitsu) {
        this.txtHomonTsushoJikoSakuseiDetailKyufuRitsu=txtHomonTsushoJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKaisu")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKaisu() {
        return txtHomonTsushoJikoSakuseiDetailKaisu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailKaisu")
    public void setTxtHomonTsushoJikoSakuseiDetailKaisu(TextBox txtHomonTsushoJikoSakuseiDetailKaisu) {
        this.txtHomonTsushoJikoSakuseiDetailKaisu=txtHomonTsushoJikoSakuseiDetailKaisu;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceUnit")
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceUnit() {
        return txtHomonTsushoJikoSakuseiDetailServiceUnit;
    }

    @JsonProperty("txtHomonTsushoJikoSakuseiDetailServiceUnit")
    public void setTxtHomonTsushoJikoSakuseiDetailServiceUnit(TextBox txtHomonTsushoJikoSakuseiDetailServiceUnit) {
        this.txtHomonTsushoJikoSakuseiDetailServiceUnit=txtHomonTsushoJikoSakuseiDetailServiceUnit;
    }

}
/**
 * tblHomonTsushoJikoSakusei2 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHomonTsushoJikoSakusei2AttblHomonTsushoJikoSakusei extends TableCell {
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailShuruiLimitChokaUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit")
    private TextBox txtHomonTsushoJikoSakuseiDetailShuruiLimitNaiUnit;
    @JsonProperty("txtHomonTsushoJikoSakuseiDetailUnitTanka")
    private TextBox txtHomonTsushoJikoSakuseiDetailUnitTanka;
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
