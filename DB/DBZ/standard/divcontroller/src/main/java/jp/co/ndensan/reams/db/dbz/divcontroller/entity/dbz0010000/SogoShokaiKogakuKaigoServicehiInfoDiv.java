package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000.SogoShokaiKogakuFurikomiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiKogakuKaigoServicehiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKogakuKaigoServicehiInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKogakuTeikyoYM")
    private TextBoxDate txtKogakuTeikyoYM;
    @JsonProperty("txtKogakuShinseiYMD")
    private TextBoxDate txtKogakuShinseiYMD;
    @JsonProperty("txtKogakuShiharaigaku")
    private TextBoxNum txtKogakuShiharaigaku;
    @JsonProperty("txtKogakuShiharaiHoho")
    private TextBox txtKogakuShiharaiHoho;
    @JsonProperty("txtKogakuKinyuKikanCode")
    private TextBoxCode txtKogakuKinyuKikanCode;
    @JsonProperty("txtKogakuKinyuKikanName")
    private TextBox txtKogakuKinyuKikanName;
    @JsonProperty("txtKogakuKozaShubetsu")
    private TextBox txtKogakuKozaShubetsu;
    @JsonProperty("txtKogakuKozaMeiginin")
    private TextBox txtKogakuKozaMeiginin;
    @JsonProperty("txtKogakuShitenCode")
    private TextBoxCode txtKogakuShitenCode;
    @JsonProperty("txtKogakuShitenName")
    private TextBox txtKogakuShitenName;
    @JsonProperty("txtKogakuKozaNo")
    private TextBoxCode txtKogakuKozaNo;
    @JsonProperty("txtKogakuKozaMeigininKana")
    private TextBoxKana txtKogakuKozaMeigininKana;
    @JsonProperty("txtKogakuKetteiYMD")
    private TextBoxDate txtKogakuKetteiYMD;
    @JsonProperty("txtKogakuShikyuKubun")
    private TextBox txtKogakuShikyuKubun;
    @JsonProperty("txtKogakuShikyugaku")
    private TextBoxNum txtKogakuShikyugaku;
    @JsonProperty("txtKogakuFushikyuRiyu")
    private TextBox txtKogakuFushikyuRiyu;
    @JsonProperty("txtKogakuSetaiShuyakuNo")
    private TextBox txtKogakuSetaiShuyakuNo;
    @JsonProperty("SogoShokaiKogakuKokuhorenKettei")
    private SogoShokaiKogakuKokuhorenKetteiDiv SogoShokaiKogakuKokuhorenKettei;
    @JsonProperty("txtKogakuTsuchishoSakuseiYMD")
    private TextBoxDate txtKogakuTsuchishoSakuseiYMD;
    @JsonProperty("SogoShokaiKogakuFurikomi")
    private SogoShokaiKogakuFurikomiDiv SogoShokaiKogakuFurikomi;
    @JsonProperty("SogoShokaiKogakuKokuhorenSofu")
    private SogoShokaiKogakuKokuhorenSofuDiv SogoShokaiKogakuKokuhorenSofu;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKogakuTeikyoYM")
    public TextBoxDate getTxtKogakuTeikyoYM() {
        return txtKogakuTeikyoYM;
    }

    @JsonProperty("txtKogakuTeikyoYM")
    public void setTxtKogakuTeikyoYM(TextBoxDate txtKogakuTeikyoYM) {
        this.txtKogakuTeikyoYM=txtKogakuTeikyoYM;
    }

    @JsonProperty("txtKogakuShinseiYMD")
    public TextBoxDate getTxtKogakuShinseiYMD() {
        return txtKogakuShinseiYMD;
    }

    @JsonProperty("txtKogakuShinseiYMD")
    public void setTxtKogakuShinseiYMD(TextBoxDate txtKogakuShinseiYMD) {
        this.txtKogakuShinseiYMD=txtKogakuShinseiYMD;
    }

    @JsonProperty("txtKogakuShiharaigaku")
    public TextBoxNum getTxtKogakuShiharaigaku() {
        return txtKogakuShiharaigaku;
    }

    @JsonProperty("txtKogakuShiharaigaku")
    public void setTxtKogakuShiharaigaku(TextBoxNum txtKogakuShiharaigaku) {
        this.txtKogakuShiharaigaku=txtKogakuShiharaigaku;
    }

    @JsonProperty("txtKogakuShiharaiHoho")
    public TextBox getTxtKogakuShiharaiHoho() {
        return txtKogakuShiharaiHoho;
    }

    @JsonProperty("txtKogakuShiharaiHoho")
    public void setTxtKogakuShiharaiHoho(TextBox txtKogakuShiharaiHoho) {
        this.txtKogakuShiharaiHoho=txtKogakuShiharaiHoho;
    }

    @JsonProperty("txtKogakuKinyuKikanCode")
    public TextBoxCode getTxtKogakuKinyuKikanCode() {
        return txtKogakuKinyuKikanCode;
    }

    @JsonProperty("txtKogakuKinyuKikanCode")
    public void setTxtKogakuKinyuKikanCode(TextBoxCode txtKogakuKinyuKikanCode) {
        this.txtKogakuKinyuKikanCode=txtKogakuKinyuKikanCode;
    }

    @JsonProperty("txtKogakuKinyuKikanName")
    public TextBox getTxtKogakuKinyuKikanName() {
        return txtKogakuKinyuKikanName;
    }

    @JsonProperty("txtKogakuKinyuKikanName")
    public void setTxtKogakuKinyuKikanName(TextBox txtKogakuKinyuKikanName) {
        this.txtKogakuKinyuKikanName=txtKogakuKinyuKikanName;
    }

    @JsonProperty("txtKogakuKozaShubetsu")
    public TextBox getTxtKogakuKozaShubetsu() {
        return txtKogakuKozaShubetsu;
    }

    @JsonProperty("txtKogakuKozaShubetsu")
    public void setTxtKogakuKozaShubetsu(TextBox txtKogakuKozaShubetsu) {
        this.txtKogakuKozaShubetsu=txtKogakuKozaShubetsu;
    }

    @JsonProperty("txtKogakuKozaMeiginin")
    public TextBox getTxtKogakuKozaMeiginin() {
        return txtKogakuKozaMeiginin;
    }

    @JsonProperty("txtKogakuKozaMeiginin")
    public void setTxtKogakuKozaMeiginin(TextBox txtKogakuKozaMeiginin) {
        this.txtKogakuKozaMeiginin=txtKogakuKozaMeiginin;
    }

    @JsonProperty("txtKogakuShitenCode")
    public TextBoxCode getTxtKogakuShitenCode() {
        return txtKogakuShitenCode;
    }

    @JsonProperty("txtKogakuShitenCode")
    public void setTxtKogakuShitenCode(TextBoxCode txtKogakuShitenCode) {
        this.txtKogakuShitenCode=txtKogakuShitenCode;
    }

    @JsonProperty("txtKogakuShitenName")
    public TextBox getTxtKogakuShitenName() {
        return txtKogakuShitenName;
    }

    @JsonProperty("txtKogakuShitenName")
    public void setTxtKogakuShitenName(TextBox txtKogakuShitenName) {
        this.txtKogakuShitenName=txtKogakuShitenName;
    }

    @JsonProperty("txtKogakuKozaNo")
    public TextBoxCode getTxtKogakuKozaNo() {
        return txtKogakuKozaNo;
    }

    @JsonProperty("txtKogakuKozaNo")
    public void setTxtKogakuKozaNo(TextBoxCode txtKogakuKozaNo) {
        this.txtKogakuKozaNo=txtKogakuKozaNo;
    }

    @JsonProperty("txtKogakuKozaMeigininKana")
    public TextBoxKana getTxtKogakuKozaMeigininKana() {
        return txtKogakuKozaMeigininKana;
    }

    @JsonProperty("txtKogakuKozaMeigininKana")
    public void setTxtKogakuKozaMeigininKana(TextBoxKana txtKogakuKozaMeigininKana) {
        this.txtKogakuKozaMeigininKana=txtKogakuKozaMeigininKana;
    }

    @JsonProperty("txtKogakuKetteiYMD")
    public TextBoxDate getTxtKogakuKetteiYMD() {
        return txtKogakuKetteiYMD;
    }

    @JsonProperty("txtKogakuKetteiYMD")
    public void setTxtKogakuKetteiYMD(TextBoxDate txtKogakuKetteiYMD) {
        this.txtKogakuKetteiYMD=txtKogakuKetteiYMD;
    }

    @JsonProperty("txtKogakuShikyuKubun")
    public TextBox getTxtKogakuShikyuKubun() {
        return txtKogakuShikyuKubun;
    }

    @JsonProperty("txtKogakuShikyuKubun")
    public void setTxtKogakuShikyuKubun(TextBox txtKogakuShikyuKubun) {
        this.txtKogakuShikyuKubun=txtKogakuShikyuKubun;
    }

    @JsonProperty("txtKogakuShikyugaku")
    public TextBoxNum getTxtKogakuShikyugaku() {
        return txtKogakuShikyugaku;
    }

    @JsonProperty("txtKogakuShikyugaku")
    public void setTxtKogakuShikyugaku(TextBoxNum txtKogakuShikyugaku) {
        this.txtKogakuShikyugaku=txtKogakuShikyugaku;
    }

    @JsonProperty("txtKogakuFushikyuRiyu")
    public TextBox getTxtKogakuFushikyuRiyu() {
        return txtKogakuFushikyuRiyu;
    }

    @JsonProperty("txtKogakuFushikyuRiyu")
    public void setTxtKogakuFushikyuRiyu(TextBox txtKogakuFushikyuRiyu) {
        this.txtKogakuFushikyuRiyu=txtKogakuFushikyuRiyu;
    }

    @JsonProperty("txtKogakuSetaiShuyakuNo")
    public TextBox getTxtKogakuSetaiShuyakuNo() {
        return txtKogakuSetaiShuyakuNo;
    }

    @JsonProperty("txtKogakuSetaiShuyakuNo")
    public void setTxtKogakuSetaiShuyakuNo(TextBox txtKogakuSetaiShuyakuNo) {
        this.txtKogakuSetaiShuyakuNo=txtKogakuSetaiShuyakuNo;
    }

    @JsonProperty("SogoShokaiKogakuKokuhorenKettei")
    public SogoShokaiKogakuKokuhorenKetteiDiv getSogoShokaiKogakuKokuhorenKettei() {
        return SogoShokaiKogakuKokuhorenKettei;
    }

    @JsonProperty("SogoShokaiKogakuKokuhorenKettei")
    public void setSogoShokaiKogakuKokuhorenKettei(SogoShokaiKogakuKokuhorenKetteiDiv SogoShokaiKogakuKokuhorenKettei) {
        this.SogoShokaiKogakuKokuhorenKettei=SogoShokaiKogakuKokuhorenKettei;
    }

    @JsonProperty("txtKogakuTsuchishoSakuseiYMD")
    public TextBoxDate getTxtKogakuTsuchishoSakuseiYMD() {
        return txtKogakuTsuchishoSakuseiYMD;
    }

    @JsonProperty("txtKogakuTsuchishoSakuseiYMD")
    public void setTxtKogakuTsuchishoSakuseiYMD(TextBoxDate txtKogakuTsuchishoSakuseiYMD) {
        this.txtKogakuTsuchishoSakuseiYMD=txtKogakuTsuchishoSakuseiYMD;
    }

    @JsonProperty("SogoShokaiKogakuFurikomi")
    public SogoShokaiKogakuFurikomiDiv getSogoShokaiKogakuFurikomi() {
        return SogoShokaiKogakuFurikomi;
    }

    @JsonProperty("SogoShokaiKogakuFurikomi")
    public void setSogoShokaiKogakuFurikomi(SogoShokaiKogakuFurikomiDiv SogoShokaiKogakuFurikomi) {
        this.SogoShokaiKogakuFurikomi=SogoShokaiKogakuFurikomi;
    }

    @JsonProperty("SogoShokaiKogakuKokuhorenSofu")
    public SogoShokaiKogakuKokuhorenSofuDiv getSogoShokaiKogakuKokuhorenSofu() {
        return SogoShokaiKogakuKokuhorenSofu;
    }

    @JsonProperty("SogoShokaiKogakuKokuhorenSofu")
    public void setSogoShokaiKogakuKokuhorenSofu(SogoShokaiKogakuKokuhorenSofuDiv SogoShokaiKogakuKokuhorenSofu) {
        this.SogoShokaiKogakuKokuhorenSofu=SogoShokaiKogakuKokuhorenSofu;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

}
