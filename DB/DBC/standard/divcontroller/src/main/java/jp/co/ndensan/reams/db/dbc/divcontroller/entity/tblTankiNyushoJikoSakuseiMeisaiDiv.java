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
 * tblTankiNyushoJikoSakuseiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTankiNyushoJikoSakuseiMeisaiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiMeisaiCell")
    private tblTankiNyushoJikoSakuseiMeisaiCellAttblTankiNyushoJikoSakuseiMeisai tblTankiNyushoJikoSakuseiMeisaiCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailJigyoshaNo() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailJigyoshaNo();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailJigyoshaName() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailJigyoshaName();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode1() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailServiceCode1();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode2() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailServiceCode2();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailServiceCode3() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailServiceCode3();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailUnit() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailUnit();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailDateNum() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailDateNum();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishoDateNum();
    }

    @JsonIgnore
    public TextBox getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum() {
        return this.tblTankiNyushoJikoSakuseiMeisaiCell.getTxtTankiNyushoJikoSakuseiDetailKyufuTaishogaiDateNum();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblTankiNyushoJikoSakuseiMeisaiCell")
    private tblTankiNyushoJikoSakuseiMeisaiCellAttblTankiNyushoJikoSakuseiMeisai getTblTankiNyushoJikoSakuseiMeisaiCell() {
        return tblTankiNyushoJikoSakuseiMeisaiCell;
    }

    @JsonProperty("tblTankiNyushoJikoSakuseiMeisaiCell")
    private void setTblTankiNyushoJikoSakuseiMeisaiCell(tblTankiNyushoJikoSakuseiMeisaiCellAttblTankiNyushoJikoSakuseiMeisai tblTankiNyushoJikoSakuseiMeisaiCell) {
        this.tblTankiNyushoJikoSakuseiMeisaiCell=tblTankiNyushoJikoSakuseiMeisaiCell;
    }

}
/**
 * tblTankiNyushoJikoSakuseiMeisaiCell のクラスファイル 
 * 
 * @author 自動生成
 */
class tblTankiNyushoJikoSakuseiMeisaiCellAttblTankiNyushoJikoSakuseiMeisai extends TableCell {
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
