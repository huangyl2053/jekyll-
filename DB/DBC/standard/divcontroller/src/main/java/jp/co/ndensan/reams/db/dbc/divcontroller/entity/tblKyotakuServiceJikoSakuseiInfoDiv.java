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
 * tblKyotakuServiceJikoSakuseiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyotakuServiceJikoSakuseiInfoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo1")
    private tblKyotakuServiceJikoSakuseiInfo1AttblKyotakuServiceJikoSakuseiInfo tblKyotakuServiceJikoSakuseiInfo1;
    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo2")
    private tblKyotakuServiceJikoSakuseiInfo2AttblKyotakuServiceJikoSakuseiInfo tblKyotakuServiceJikoSakuseiInfo2;
    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo3")
    private tblKyotakuServiceJikoSakuseiInfo3AttblKyotakuServiceJikoSakuseiInfo tblKyotakuServiceJikoSakuseiInfo3;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtJikoSakuseiTishoYM() {
        return this.tblKyotakuServiceJikoSakuseiInfo1.getTxtJikoSakuseiTishoYM();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJikoSakuseiCreateYMD() {
        return this.tblKyotakuServiceJikoSakuseiInfo2.getTxtJikoSakuseiCreateYMD();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJikoSakuseiTodokedeYMD() {
        return this.tblKyotakuServiceJikoSakuseiInfo2.getTxtJikoSakuseiTodokedeYMD();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJikoSakuseiStartYMD() {
        return this.tblKyotakuServiceJikoSakuseiInfo2.getTxtJikoSakuseiStartYMD();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJikoSakuseiEndYMD() {
        return this.tblKyotakuServiceJikoSakuseiInfo2.getTxtJikoSakuseiEndYMD();
    }

    @JsonIgnore
    public TextBox getTxtJikoSakuseiYoukaigodo() {
        return this.tblKyotakuServiceJikoSakuseiInfo3.getTxtJikoSakuseiYoukaigodo();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJikoSakuseiYukoKikan() {
        return this.tblKyotakuServiceJikoSakuseiInfo3.getTxtJikoSakuseiYukoKikan();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo1")
    private tblKyotakuServiceJikoSakuseiInfo1AttblKyotakuServiceJikoSakuseiInfo getTblKyotakuServiceJikoSakuseiInfo1() {
        return tblKyotakuServiceJikoSakuseiInfo1;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo1")
    private void setTblKyotakuServiceJikoSakuseiInfo1(tblKyotakuServiceJikoSakuseiInfo1AttblKyotakuServiceJikoSakuseiInfo tblKyotakuServiceJikoSakuseiInfo1) {
        this.tblKyotakuServiceJikoSakuseiInfo1=tblKyotakuServiceJikoSakuseiInfo1;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo2")
    private tblKyotakuServiceJikoSakuseiInfo2AttblKyotakuServiceJikoSakuseiInfo getTblKyotakuServiceJikoSakuseiInfo2() {
        return tblKyotakuServiceJikoSakuseiInfo2;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo2")
    private void setTblKyotakuServiceJikoSakuseiInfo2(tblKyotakuServiceJikoSakuseiInfo2AttblKyotakuServiceJikoSakuseiInfo tblKyotakuServiceJikoSakuseiInfo2) {
        this.tblKyotakuServiceJikoSakuseiInfo2=tblKyotakuServiceJikoSakuseiInfo2;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo3")
    private tblKyotakuServiceJikoSakuseiInfo3AttblKyotakuServiceJikoSakuseiInfo getTblKyotakuServiceJikoSakuseiInfo3() {
        return tblKyotakuServiceJikoSakuseiInfo3;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo3")
    private void setTblKyotakuServiceJikoSakuseiInfo3(tblKyotakuServiceJikoSakuseiInfo3AttblKyotakuServiceJikoSakuseiInfo tblKyotakuServiceJikoSakuseiInfo3) {
        this.tblKyotakuServiceJikoSakuseiInfo3=tblKyotakuServiceJikoSakuseiInfo3;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiInfo1 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiInfo1AttblKyotakuServiceJikoSakuseiInfo extends TableCell {
    @JsonProperty("txtJikoSakuseiTishoYM")
    private TextBoxFlexibleDate txtJikoSakuseiTishoYM;

    @JsonProperty("txtJikoSakuseiTishoYM")
    public TextBoxFlexibleDate getTxtJikoSakuseiTishoYM() {
        return txtJikoSakuseiTishoYM;
    }

    @JsonProperty("txtJikoSakuseiTishoYM")
    public void setTxtJikoSakuseiTishoYM(TextBoxFlexibleDate txtJikoSakuseiTishoYM) {
        this.txtJikoSakuseiTishoYM=txtJikoSakuseiTishoYM;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiInfo2 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiInfo2AttblKyotakuServiceJikoSakuseiInfo extends TableCell {
    @JsonProperty("txtJikoSakuseiCreateYMD")
    private TextBoxFlexibleDate txtJikoSakuseiCreateYMD;
    @JsonProperty("txtJikoSakuseiTodokedeYMD")
    private TextBoxFlexibleDate txtJikoSakuseiTodokedeYMD;
    @JsonProperty("txtJikoSakuseiStartYMD")
    private TextBoxFlexibleDate txtJikoSakuseiStartYMD;
    @JsonProperty("txtJikoSakuseiEndYMD")
    private TextBoxFlexibleDate txtJikoSakuseiEndYMD;

    @JsonProperty("txtJikoSakuseiCreateYMD")
    public TextBoxFlexibleDate getTxtJikoSakuseiCreateYMD() {
        return txtJikoSakuseiCreateYMD;
    }

    @JsonProperty("txtJikoSakuseiCreateYMD")
    public void setTxtJikoSakuseiCreateYMD(TextBoxFlexibleDate txtJikoSakuseiCreateYMD) {
        this.txtJikoSakuseiCreateYMD=txtJikoSakuseiCreateYMD;
    }

    @JsonProperty("txtJikoSakuseiTodokedeYMD")
    public TextBoxFlexibleDate getTxtJikoSakuseiTodokedeYMD() {
        return txtJikoSakuseiTodokedeYMD;
    }

    @JsonProperty("txtJikoSakuseiTodokedeYMD")
    public void setTxtJikoSakuseiTodokedeYMD(TextBoxFlexibleDate txtJikoSakuseiTodokedeYMD) {
        this.txtJikoSakuseiTodokedeYMD=txtJikoSakuseiTodokedeYMD;
    }

    @JsonProperty("txtJikoSakuseiStartYMD")
    public TextBoxFlexibleDate getTxtJikoSakuseiStartYMD() {
        return txtJikoSakuseiStartYMD;
    }

    @JsonProperty("txtJikoSakuseiStartYMD")
    public void setTxtJikoSakuseiStartYMD(TextBoxFlexibleDate txtJikoSakuseiStartYMD) {
        this.txtJikoSakuseiStartYMD=txtJikoSakuseiStartYMD;
    }

    @JsonProperty("txtJikoSakuseiEndYMD")
    public TextBoxFlexibleDate getTxtJikoSakuseiEndYMD() {
        return txtJikoSakuseiEndYMD;
    }

    @JsonProperty("txtJikoSakuseiEndYMD")
    public void setTxtJikoSakuseiEndYMD(TextBoxFlexibleDate txtJikoSakuseiEndYMD) {
        this.txtJikoSakuseiEndYMD=txtJikoSakuseiEndYMD;
    }

}
/**
 * tblKyotakuServiceJikoSakuseiInfo3 のクラスファイル 
 * 
 * @author 自動生成
 */
class tblKyotakuServiceJikoSakuseiInfo3AttblKyotakuServiceJikoSakuseiInfo extends TableCell {
    @JsonProperty("txtJikoSakuseiYoukaigodo")
    private TextBox txtJikoSakuseiYoukaigodo;
    @JsonProperty("txtJikoSakuseiYukoKikan")
    private TextBoxDateRange txtJikoSakuseiYukoKikan;

    @JsonProperty("txtJikoSakuseiYoukaigodo")
    public TextBox getTxtJikoSakuseiYoukaigodo() {
        return txtJikoSakuseiYoukaigodo;
    }

    @JsonProperty("txtJikoSakuseiYoukaigodo")
    public void setTxtJikoSakuseiYoukaigodo(TextBox txtJikoSakuseiYoukaigodo) {
        this.txtJikoSakuseiYoukaigodo=txtJikoSakuseiYoukaigodo;
    }

    @JsonProperty("txtJikoSakuseiYukoKikan")
    public TextBoxDateRange getTxtJikoSakuseiYukoKikan() {
        return txtJikoSakuseiYukoKikan;
    }

    @JsonProperty("txtJikoSakuseiYukoKikan")
    public void setTxtJikoSakuseiYukoKikan(TextBoxDateRange txtJikoSakuseiYukoKikan) {
        this.txtJikoSakuseiYukoKikan=txtJikoSakuseiYukoKikan;
    }

}
