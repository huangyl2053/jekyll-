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
 * tblKyotakuServiceJikoSakuseiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyotakuServiceJikoSakuseiMeisaiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiMeisaiCell")
    private tblKyotakuServiceJikoSakuseiMeisaiCellAttblKyotakuServiceJikoSakuseiMeisai tblKyotakuServiceJikoSakuseiMeisaiCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaNo();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailJigyoshaName() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailJigyoshaName();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode1() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailServiceCode1();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode2() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailServiceCode2();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceCode3() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailServiceCode3();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailUnit() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoRitsu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailWaribikiTekiyougoUnit();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailKaisu() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailKaisu();
    }

    @JsonIgnore
    public TextBox getTxtKyotakuServiceJikoSakuseiDetailServiceUnit() {
        return this.tblKyotakuServiceJikoSakuseiMeisaiCell.getTxtKyotakuServiceJikoSakuseiDetailServiceUnit();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiMeisaiCell")
    private tblKyotakuServiceJikoSakuseiMeisaiCellAttblKyotakuServiceJikoSakuseiMeisai getTblKyotakuServiceJikoSakuseiMeisaiCell() {
        return tblKyotakuServiceJikoSakuseiMeisaiCell;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiMeisaiCell")
    private void setTblKyotakuServiceJikoSakuseiMeisaiCell(tblKyotakuServiceJikoSakuseiMeisaiCellAttblKyotakuServiceJikoSakuseiMeisai tblKyotakuServiceJikoSakuseiMeisaiCell) {
        this.tblKyotakuServiceJikoSakuseiMeisaiCell=tblKyotakuServiceJikoSakuseiMeisaiCell;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiMeisaiCell のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiMeisaiCellAttblKyotakuServiceJikoSakuseiMeisai extends TableCell {
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
