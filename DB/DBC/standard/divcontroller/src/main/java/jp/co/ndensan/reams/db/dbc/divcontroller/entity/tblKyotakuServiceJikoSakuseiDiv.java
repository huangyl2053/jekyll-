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
 * tblKyotakuServiceJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyotakuServiceJikoSakuseiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakusei1")
    private tblKyotakuServiceJikoSakusei1AttblKyotakuServiceJikoSakusei tblKyotakuServiceJikoSakusei1;
    @JsonProperty("tblKyotakuServiceJikoSakusei2")
    private tblKyotakuServiceJikoSakusei2AttblKyotakuServiceJikoSakusei tblKyotakuServiceJikoSakusei2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailJigyoshaName() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaName();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode1() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailServiceCode1();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode2() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailServiceCode2();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode3() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailServiceCode3();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailUnit() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKaisu() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailKaisu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceUnit() {
        return this.tblKyotakuServiceJikoSakusei1.getTxtKyotakuServiceJikoSakuseiDetailServiceUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailUnitTanka() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailUnitTanka();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailHiyoTotal() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailHiyoTotal();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailHokenKyufu() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailHokenKyufu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanHoken();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal() {
        return this.tblKyotakuServiceJikoSakusei2.getTxtKyotakuServiceJikoSakuseiDetailRiyoshaFutanTotal();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakusei1")
    private tblKyotakuServiceJikoSakusei1AttblKyotakuServiceJikoSakusei getTblKyotakuServiceJikoSakusei1() {
        return tblKyotakuServiceJikoSakusei1;
    }

    @JsonProperty("tblKyotakuServiceJikoSakusei1")
    private void setTblKyotakuServiceJikoSakusei1(tblKyotakuServiceJikoSakusei1AttblKyotakuServiceJikoSakusei tblKyotakuServiceJikoSakusei1) {
        this.tblKyotakuServiceJikoSakusei1=tblKyotakuServiceJikoSakusei1;
    }

    @JsonProperty("tblKyotakuServiceJikoSakusei2")
    private tblKyotakuServiceJikoSakusei2AttblKyotakuServiceJikoSakusei getTblKyotakuServiceJikoSakusei2() {
        return tblKyotakuServiceJikoSakusei2;
    }

    @JsonProperty("tblKyotakuServiceJikoSakusei2")
    private void setTblKyotakuServiceJikoSakusei2(tblKyotakuServiceJikoSakusei2AttblKyotakuServiceJikoSakusei tblKyotakuServiceJikoSakusei2) {
        this.tblKyotakuServiceJikoSakusei2=tblKyotakuServiceJikoSakusei2;
    }

}
/**
 * tblKyotakuServiceJikoSakusei1 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakusei1AttblKyotakuServiceJikoSakusei extends TableCell {
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailJigyoshaNo")
    private TextBox txtKyotakuServiceJikoSakuseiDetailJigyoshaNo;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailJigyoshaName")
    private TextBox txtKyotakuServiceJikoSakuseiDetailJigyoshaName;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode1")
    private TextBox txtKyotakuServiceJikoSakuseiDetailServiceCode1;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode2")
    private TextBox txtKyotakuServiceJikoSakuseiDetailServiceCode2;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode3")
    private TextBox txtKyotakuServiceJikoSakuseiDetailServiceCode3;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu")
    private TextBox txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKaisu")
    private TextBox txtKyotakuServiceJikoSakuseiDetailKaisu;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailServiceUnit;

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailJigyoshaNo")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo() {
        return txtKyotakuServiceJikoSakuseiDetailJigyoshaNo;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailJigyoshaNo")
    public void setTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo(TextBox txtKyotakuServiceJikoSakuseiDetailJigyoshaNo) {
        this.txtKyotakuServiceJikoSakuseiDetailJigyoshaNo=txtKyotakuServiceJikoSakuseiDetailJigyoshaNo;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailJigyoshaName")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailJigyoshaName() {
        return txtKyotakuServiceJikoSakuseiDetailJigyoshaName;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailJigyoshaName")
    public void setTxtKyotakuServiceJikoSakuseiDetailJigyoshaName(TextBox txtKyotakuServiceJikoSakuseiDetailJigyoshaName) {
        this.txtKyotakuServiceJikoSakuseiDetailJigyoshaName=txtKyotakuServiceJikoSakuseiDetailJigyoshaName;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode1")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode1() {
        return txtKyotakuServiceJikoSakuseiDetailServiceCode1;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode1")
    public void setTxtKyotakuServiceJikoSakuseiDetailServiceCode1(TextBox txtKyotakuServiceJikoSakuseiDetailServiceCode1) {
        this.txtKyotakuServiceJikoSakuseiDetailServiceCode1=txtKyotakuServiceJikoSakuseiDetailServiceCode1;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode2")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode2() {
        return txtKyotakuServiceJikoSakuseiDetailServiceCode2;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode2")
    public void setTxtKyotakuServiceJikoSakuseiDetailServiceCode2(TextBox txtKyotakuServiceJikoSakuseiDetailServiceCode2) {
        this.txtKyotakuServiceJikoSakuseiDetailServiceCode2=txtKyotakuServiceJikoSakuseiDetailServiceCode2;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode3")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode3() {
        return txtKyotakuServiceJikoSakuseiDetailServiceCode3;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceCode3")
    public void setTxtKyotakuServiceJikoSakuseiDetailServiceCode3(TextBox txtKyotakuServiceJikoSakuseiDetailServiceCode3) {
        this.txtKyotakuServiceJikoSakuseiDetailServiceCode3=txtKyotakuServiceJikoSakuseiDetailServiceCode3;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailUnit")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailUnit() {
        return txtKyotakuServiceJikoSakuseiDetailUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailUnit")
    public void setTxtKyotakuServiceJikoSakuseiDetailUnit(TextBox txtKyotakuServiceJikoSakuseiDetailUnit) {
        this.txtKyotakuServiceJikoSakuseiDetailUnit=txtKyotakuServiceJikoSakuseiDetailUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu() {
        return txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu")
    public void setTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu(TextBox txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu) {
        this.txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu=txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit() {
        return txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit")
    public void setTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit(TextBox txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit) {
        this.txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit=txtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKaisu")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKaisu() {
        return txtKyotakuServiceJikoSakuseiDetailKaisu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKaisu")
    public void setTxtKyotakuServiceJikoSakuseiDetailKaisu(TextBox txtKyotakuServiceJikoSakuseiDetailKaisu) {
        this.txtKyotakuServiceJikoSakuseiDetailKaisu=txtKyotakuServiceJikoSakuseiDetailKaisu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceUnit")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceUnit() {
        return txtKyotakuServiceJikoSakuseiDetailServiceUnit;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailServiceUnit")
    public void setTxtKyotakuServiceJikoSakuseiDetailServiceUnit(TextBox txtKyotakuServiceJikoSakuseiDetailServiceUnit) {
        this.txtKyotakuServiceJikoSakuseiDetailServiceUnit=txtKyotakuServiceJikoSakuseiDetailServiceUnit;
    }

}
/**
 * tblKyotakuServiceJikoSakusei2 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakusei2AttblKyotakuServiceJikoSakusei extends TableCell {
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailShuruiLimitChokaUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailShuruiLimitNaiUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailUnitTanka")
    private TextBox txtKyotakuServiceJikoSakuseiDetailUnitTanka;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailKubunLimitChokaUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit")
    private TextBox txtKyotakuServiceJikoSakuseiDetailKubunLimitNaiUnit;
    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKyufuRitsu")
    private TextBox txtKyotakuServiceJikoSakuseiDetailKyufuRitsu;
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

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKyufuRitsu")
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu() {
        return txtKyotakuServiceJikoSakuseiDetailKyufuRitsu;
    }

    @JsonProperty("txtKyotakuServiceJikoSakuseiDetailKyufuRitsu")
    public void setTxtKyotakuServiceJikoSakuseiDetailKyufuRitsu(TextBox txtKyotakuServiceJikoSakuseiDetailKyufuRitsu) {
        this.txtKyotakuServiceJikoSakuseiDetailKyufuRitsu=txtKyotakuServiceJikoSakuseiDetailKyufuRitsu;
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
