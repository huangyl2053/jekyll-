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
 * tblTankiNyushoJikoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTankiNyushoJikoSakuseiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakusei1")
    private tblTankiNyushoJikoSakusei1AttblTankiNyushoJikoSakusei tblTankiNyushoJikoSakusei1;
    @JsonProperty("tblTankiNyushoJikoSakusei2")
    private tblTankiNyushoJikoSakusei2AttblTankiNyushoJikoSakusei tblTankiNyushoJikoSakusei2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailJigyoshaNo() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailJigyoshaNo();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailJigyoshaName() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailJigyoshaName();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode1() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailServiceCode1();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode2() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailServiceCode2();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode3() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailServiceCode3();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailUnit() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailUnit();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailDateNum() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailDateNum();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum() {
        return this.tblTankiNyushoJikoSakusei1.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailUnitTanka() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailUnitTanka();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuRitsu() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailKyufuRitsu();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailKubunLimitNaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHiyoTotal() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailHiyoTotal();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailHokenKyufuGaku();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailHokenRiyoshaFutanGaku();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiUnit();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal() {
        return this.tblTankiNyushoJikoSakusei2.getTxtTankiNyushoJikoSakuseiDetailRiyoshaFutanTotal();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakusei1")
    private tblTankiNyushoJikoSakusei1AttblTankiNyushoJikoSakusei getTblTankiNyushoJikoSakusei1() {
        return tblTankiNyushoJikoSakusei1;
    }

    @JsonProperty("tblTankiNyushoJikoSakusei1")
    private void setTblTankiNyushoJikoSakusei1(tblTankiNyushoJikoSakusei1AttblTankiNyushoJikoSakusei tblTankiNyushoJikoSakusei1) {
        this.tblTankiNyushoJikoSakusei1=tblTankiNyushoJikoSakusei1;
    }

    @JsonProperty("tblTankiNyushoJikoSakusei2")
    private tblTankiNyushoJikoSakusei2AttblTankiNyushoJikoSakusei getTblTankiNyushoJikoSakusei2() {
        return tblTankiNyushoJikoSakusei2;
    }

    @JsonProperty("tblTankiNyushoJikoSakusei2")
    private void setTblTankiNyushoJikoSakusei2(tblTankiNyushoJikoSakusei2AttblTankiNyushoJikoSakusei tblTankiNyushoJikoSakusei2) {
        this.tblTankiNyushoJikoSakusei2=tblTankiNyushoJikoSakusei2;
    }

}
/**
 * tblTankiNyushoJikoSakusei1 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblTankiNyushoJikoSakusei1AttblTankiNyushoJikoSakusei extends TableCell {
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailJigyoshaNo")
    private TextBox txtTankiNyushoJikoSakuseiDetailJigyoshaNo;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailJigyoshaName")
    private TextBox txtTankiNyushoJikoSakuseiDetailJigyoshaName;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode1")
    private TextBox txtTankiNyushoJikoSakuseiDetailServiceCode1;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode2")
    private TextBox txtTankiNyushoJikoSakuseiDetailServiceCode2;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode3")
    private TextBox txtTankiNyushoJikoSakuseiDetailServiceCode3;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailUnit")
    private TextBox txtTankiNyushoJikoSakuseiDetailUnit;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailDateNum")
    private TextBox txtTankiNyushoJikoSakuseiDetailDateNum;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum")
    private TextBox txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum;
    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum")
    private TextBox txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum;

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailJigyoshaNo")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailJigyoshaNo() {
        return txtTankiNyushoJikoSakuseiDetailJigyoshaNo;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailJigyoshaNo")
    public void setTxtTankiNyushoJikoSakuseiDetailJigyoshaNo(TextBox txtTankiNyushoJikoSakuseiDetailJigyoshaNo) {
        this.txtTankiNyushoJikoSakuseiDetailJigyoshaNo=txtTankiNyushoJikoSakuseiDetailJigyoshaNo;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailJigyoshaName")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailJigyoshaName() {
        return txtTankiNyushoJikoSakuseiDetailJigyoshaName;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailJigyoshaName")
    public void setTxtTankiNyushoJikoSakuseiDetailJigyoshaName(TextBox txtTankiNyushoJikoSakuseiDetailJigyoshaName) {
        this.txtTankiNyushoJikoSakuseiDetailJigyoshaName=txtTankiNyushoJikoSakuseiDetailJigyoshaName;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode1")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode1() {
        return txtTankiNyushoJikoSakuseiDetailServiceCode1;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode1")
    public void setTxtTankiNyushoJikoSakuseiDetailServiceCode1(TextBox txtTankiNyushoJikoSakuseiDetailServiceCode1) {
        this.txtTankiNyushoJikoSakuseiDetailServiceCode1=txtTankiNyushoJikoSakuseiDetailServiceCode1;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode2")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode2() {
        return txtTankiNyushoJikoSakuseiDetailServiceCode2;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode2")
    public void setTxtTankiNyushoJikoSakuseiDetailServiceCode2(TextBox txtTankiNyushoJikoSakuseiDetailServiceCode2) {
        this.txtTankiNyushoJikoSakuseiDetailServiceCode2=txtTankiNyushoJikoSakuseiDetailServiceCode2;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode3")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode3() {
        return txtTankiNyushoJikoSakuseiDetailServiceCode3;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailServiceCode3")
    public void setTxtTankiNyushoJikoSakuseiDetailServiceCode3(TextBox txtTankiNyushoJikoSakuseiDetailServiceCode3) {
        this.txtTankiNyushoJikoSakuseiDetailServiceCode3=txtTankiNyushoJikoSakuseiDetailServiceCode3;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailUnit")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailUnit() {
        return txtTankiNyushoJikoSakuseiDetailUnit;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailUnit")
    public void setTxtTankiNyushoJikoSakuseiDetailUnit(TextBox txtTankiNyushoJikoSakuseiDetailUnit) {
        this.txtTankiNyushoJikoSakuseiDetailUnit=txtTankiNyushoJikoSakuseiDetailUnit;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailDateNum")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailDateNum() {
        return txtTankiNyushoJikoSakuseiDetailDateNum;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailDateNum")
    public void setTxtTankiNyushoJikoSakuseiDetailDateNum(TextBox txtTankiNyushoJikoSakuseiDetailDateNum) {
        this.txtTankiNyushoJikoSakuseiDetailDateNum=txtTankiNyushoJikoSakuseiDetailDateNum;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum() {
        return txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum")
    public void setTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum(TextBox txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum) {
        this.txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum=txtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum")
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum() {
        return txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum;
    }

    @JsonProperty("txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum")
    public void setTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum(TextBox txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum) {
        this.txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum=txtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum;
    }

}
/**
 * tblTankiNyushoJikoSakusei2 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblTankiNyushoJikoSakusei2AttblTankiNyushoJikoSakusei extends TableCell {
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
