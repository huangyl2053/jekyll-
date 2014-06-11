package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanChoshuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanKeisanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanRisokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanTsuchishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KashitsukeHenkanInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeHenkanInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtRiyoKikan")
    private TextBoxDateRange txtRiyoKikan;
    @JsonProperty("txtSeikyugaku")
    private TextBoxNum txtSeikyugaku;
    @JsonProperty("txtShinseiKingaku")
    private TextBoxNum txtShinseiKingaku;
    @JsonProperty("txtService1")
    private TextBox txtService1;
    @JsonProperty("txtService2")
    private TextBox txtService2;
    @JsonProperty("txtService3")
    private TextBox txtService3;
    @JsonProperty("txtService4")
    private TextBox txtService4;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("txtShoninKubun")
    private TextBox txtShoninKubun;
    @JsonProperty("txtKariukeYMD")
    private TextBoxDate txtKariukeYMD;
    @JsonProperty("txtEnchoShinseiYMD")
    private TextBoxDate txtEnchoShinseiYMD;
    @JsonProperty("txtEnchoKikan")
    private TextBoxDateRange txtEnchoKikan;
    @JsonProperty("txtMishokanKingaku")
    private TextBoxNum txtMishokanKingaku;
    @JsonProperty("btnKashitsukeInfo")
    private ButtonDialog btnKashitsukeInfo;
    @JsonProperty("KashitsukeHenkanKeisan")
    private KashitsukeHenkanKeisanDiv KashitsukeHenkanKeisan;
    @JsonProperty("KashitsukeHenkanRisoku")
    private KashitsukeHenkanRisokuDiv KashitsukeHenkanRisoku;
    @JsonProperty("KashitsukeHenkanChoshu")
    private KashitsukeHenkanChoshuDiv KashitsukeHenkanChoshu;
    @JsonProperty("KashitsukeHenkanTsuchisho")
    private KashitsukeHenkanTsuchishoDiv KashitsukeHenkanTsuchisho;
    @JsonProperty("btnReturn")
    private Button btnReturn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD=txtShinseiYMD;
    }

    @JsonProperty("txtRiyoKikan")
    public TextBoxDateRange getTxtRiyoKikan() {
        return txtRiyoKikan;
    }

    @JsonProperty("txtRiyoKikan")
    public void setTxtRiyoKikan(TextBoxDateRange txtRiyoKikan) {
        this.txtRiyoKikan=txtRiyoKikan;
    }

    @JsonProperty("txtSeikyugaku")
    public TextBoxNum getTxtSeikyugaku() {
        return txtSeikyugaku;
    }

    @JsonProperty("txtSeikyugaku")
    public void setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.txtSeikyugaku=txtSeikyugaku;
    }

    @JsonProperty("txtShinseiKingaku")
    public TextBoxNum getTxtShinseiKingaku() {
        return txtShinseiKingaku;
    }

    @JsonProperty("txtShinseiKingaku")
    public void setTxtShinseiKingaku(TextBoxNum txtShinseiKingaku) {
        this.txtShinseiKingaku=txtShinseiKingaku;
    }

    @JsonProperty("txtService1")
    public TextBox getTxtService1() {
        return txtService1;
    }

    @JsonProperty("txtService1")
    public void setTxtService1(TextBox txtService1) {
        this.txtService1=txtService1;
    }

    @JsonProperty("txtService2")
    public TextBox getTxtService2() {
        return txtService2;
    }

    @JsonProperty("txtService2")
    public void setTxtService2(TextBox txtService2) {
        this.txtService2=txtService2;
    }

    @JsonProperty("txtService3")
    public TextBox getTxtService3() {
        return txtService3;
    }

    @JsonProperty("txtService3")
    public void setTxtService3(TextBox txtService3) {
        this.txtService3=txtService3;
    }

    @JsonProperty("txtService4")
    public TextBox getTxtService4() {
        return txtService4;
    }

    @JsonProperty("txtService4")
    public void setTxtService4(TextBox txtService4) {
        this.txtService4=txtService4;
    }

    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD=txtKetteiYMD;
    }

    @JsonProperty("txtShoninKubun")
    public TextBox getTxtShoninKubun() {
        return txtShoninKubun;
    }

    @JsonProperty("txtShoninKubun")
    public void setTxtShoninKubun(TextBox txtShoninKubun) {
        this.txtShoninKubun=txtShoninKubun;
    }

    @JsonProperty("txtKariukeYMD")
    public TextBoxDate getTxtKariukeYMD() {
        return txtKariukeYMD;
    }

    @JsonProperty("txtKariukeYMD")
    public void setTxtKariukeYMD(TextBoxDate txtKariukeYMD) {
        this.txtKariukeYMD=txtKariukeYMD;
    }

    @JsonProperty("txtEnchoShinseiYMD")
    public TextBoxDate getTxtEnchoShinseiYMD() {
        return txtEnchoShinseiYMD;
    }

    @JsonProperty("txtEnchoShinseiYMD")
    public void setTxtEnchoShinseiYMD(TextBoxDate txtEnchoShinseiYMD) {
        this.txtEnchoShinseiYMD=txtEnchoShinseiYMD;
    }

    @JsonProperty("txtEnchoKikan")
    public TextBoxDateRange getTxtEnchoKikan() {
        return txtEnchoKikan;
    }

    @JsonProperty("txtEnchoKikan")
    public void setTxtEnchoKikan(TextBoxDateRange txtEnchoKikan) {
        this.txtEnchoKikan=txtEnchoKikan;
    }

    @JsonProperty("txtMishokanKingaku")
    public TextBoxNum getTxtMishokanKingaku() {
        return txtMishokanKingaku;
    }

    @JsonProperty("txtMishokanKingaku")
    public void setTxtMishokanKingaku(TextBoxNum txtMishokanKingaku) {
        this.txtMishokanKingaku=txtMishokanKingaku;
    }

    @JsonProperty("btnKashitsukeInfo")
    public ButtonDialog getBtnKashitsukeInfo() {
        return btnKashitsukeInfo;
    }

    @JsonProperty("btnKashitsukeInfo")
    public void setBtnKashitsukeInfo(ButtonDialog btnKashitsukeInfo) {
        this.btnKashitsukeInfo=btnKashitsukeInfo;
    }

    @JsonProperty("KashitsukeHenkanKeisan")
    public KashitsukeHenkanKeisanDiv getKashitsukeHenkanKeisan() {
        return KashitsukeHenkanKeisan;
    }

    @JsonProperty("KashitsukeHenkanKeisan")
    public void setKashitsukeHenkanKeisan(KashitsukeHenkanKeisanDiv KashitsukeHenkanKeisan) {
        this.KashitsukeHenkanKeisan=KashitsukeHenkanKeisan;
    }

    @JsonProperty("KashitsukeHenkanRisoku")
    public KashitsukeHenkanRisokuDiv getKashitsukeHenkanRisoku() {
        return KashitsukeHenkanRisoku;
    }

    @JsonProperty("KashitsukeHenkanRisoku")
    public void setKashitsukeHenkanRisoku(KashitsukeHenkanRisokuDiv KashitsukeHenkanRisoku) {
        this.KashitsukeHenkanRisoku=KashitsukeHenkanRisoku;
    }

    @JsonProperty("KashitsukeHenkanChoshu")
    public KashitsukeHenkanChoshuDiv getKashitsukeHenkanChoshu() {
        return KashitsukeHenkanChoshu;
    }

    @JsonProperty("KashitsukeHenkanChoshu")
    public void setKashitsukeHenkanChoshu(KashitsukeHenkanChoshuDiv KashitsukeHenkanChoshu) {
        this.KashitsukeHenkanChoshu=KashitsukeHenkanChoshu;
    }

    @JsonProperty("KashitsukeHenkanTsuchisho")
    public KashitsukeHenkanTsuchishoDiv getKashitsukeHenkanTsuchisho() {
        return KashitsukeHenkanTsuchisho;
    }

    @JsonProperty("KashitsukeHenkanTsuchisho")
    public void setKashitsukeHenkanTsuchisho(KashitsukeHenkanTsuchishoDiv KashitsukeHenkanTsuchisho) {
        this.KashitsukeHenkanTsuchisho=KashitsukeHenkanTsuchisho;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

}
