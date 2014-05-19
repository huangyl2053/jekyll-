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
 * tblHomonTsushoJikoSakuseiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblHomonTsushoJikoSakuseiMeisaiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiMeisaiCell")
    private tblHomonTsushoJikoSakuseiMeisaiCellAttblHomonTsushoJikoSakuseiMeisai tblHomonTsushoJikoSakuseiMeisaiCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailJigyoshaNo() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailJigyoshaNo();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailJigyoshaName() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailJigyoshaName();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode1() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailServiceCode1();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode2() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailServiceCode2();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceCode3() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailServiceCode3();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailUnit() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoRitsu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailWaribikiTekiyougoUnit();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailKaisu() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailKaisu();
    }

    @JsonIgnore
    public TextBox getTxtHomonTsushoJikoSakuseiDetailServiceUnit() {
        return this.tblHomonTsushoJikoSakuseiMeisaiCell.getTxtHomonTsushoJikoSakuseiDetailServiceUnit();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblHomonTsushoJikoSakuseiMeisaiCell")
    private tblHomonTsushoJikoSakuseiMeisaiCellAttblHomonTsushoJikoSakuseiMeisai getTblHomonTsushoJikoSakuseiMeisaiCell() {
        return tblHomonTsushoJikoSakuseiMeisaiCell;
    }

    @JsonProperty("tblHomonTsushoJikoSakuseiMeisaiCell")
    private void setTblHomonTsushoJikoSakuseiMeisaiCell(tblHomonTsushoJikoSakuseiMeisaiCellAttblHomonTsushoJikoSakuseiMeisai tblHomonTsushoJikoSakuseiMeisaiCell) {
        this.tblHomonTsushoJikoSakuseiMeisaiCell=tblHomonTsushoJikoSakuseiMeisaiCell;
    }

}
/**
 * tblHomonTsushoJikoSakuseiMeisaiCell のクラスファイル 
 * 
 * @author 自動生成
 */
class tblHomonTsushoJikoSakuseiMeisaiCellAttblHomonTsushoJikoSakuseiMeisai extends TableCell {
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
