package jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestShisetsuJoho;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.IShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TestShisetsuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TestShisetsuJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSetDaicho")
    private RadioButton radSetDaicho;
    @JsonProperty("btnSetDaicho")
    private Button btnSetDaicho;
    @JsonProperty("radSetShisetsu")
    private RadioButton radSetShisetsu;
    @JsonProperty("btnSetShisetsu")
    private Button btnSetShisetsu;
    @JsonProperty("txtSetCode")
    private TextBox txtSetCode;
    @JsonProperty("btnSetCode")
    private Button btnSetCode;
    @JsonProperty("txtSetMeisho")
    private TextBox txtSetMeisho;
    @JsonProperty("btnSetMeisho")
    private Button btnSetMeisho;
    @JsonProperty("line0")
    private HorizontalLine line0;
    @JsonProperty("txtDaicho")
    private TextBox txtDaicho;
    @JsonProperty("btnGetDaicho")
    private Button btnGetDaicho;
    @JsonProperty("txtDaichoKey")
    private TextBoxCode txtDaichoKey;
    @JsonProperty("btnGetDaichoKey")
    private Button btnGetDaichoKey;
    @JsonProperty("txtShisetsu")
    private TextBox txtShisetsu;
    @JsonProperty("btnGetShisetsu")
    private Button btnGetShisetsu;
    @JsonProperty("txtShisetsuKey")
    private TextBoxCode txtShisetsuKey;
    @JsonProperty("btnGetShisetsuKey")
    private Button btnGetShisetsuKey;
    @JsonProperty("txtCode")
    private TextBox txtCode;
    @JsonProperty("btnGetCode")
    private Button btnGetCode;
    @JsonProperty("txtMeisho")
    private TextBox txtMeisho;
    @JsonProperty("btnGetMeisho")
    private Button btnGetMeisho;
    @JsonProperty("btnInitialize")
    private Button btnInitialize;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("line1")
    private HorizontalLine line1;
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoDiv ccdShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radSetDaicho")
    public RadioButton getRadSetDaicho() {
        return radSetDaicho;
    }

    @JsonProperty("radSetDaicho")
    public void setRadSetDaicho(RadioButton radSetDaicho) {
        this.radSetDaicho=radSetDaicho;
    }

    @JsonProperty("btnSetDaicho")
    public Button getBtnSetDaicho() {
        return btnSetDaicho;
    }

    @JsonProperty("btnSetDaicho")
    public void setBtnSetDaicho(Button btnSetDaicho) {
        this.btnSetDaicho=btnSetDaicho;
    }

    @JsonProperty("radSetShisetsu")
    public RadioButton getRadSetShisetsu() {
        return radSetShisetsu;
    }

    @JsonProperty("radSetShisetsu")
    public void setRadSetShisetsu(RadioButton radSetShisetsu) {
        this.radSetShisetsu=radSetShisetsu;
    }

    @JsonProperty("btnSetShisetsu")
    public Button getBtnSetShisetsu() {
        return btnSetShisetsu;
    }

    @JsonProperty("btnSetShisetsu")
    public void setBtnSetShisetsu(Button btnSetShisetsu) {
        this.btnSetShisetsu=btnSetShisetsu;
    }

    @JsonProperty("txtSetCode")
    public TextBox getTxtSetCode() {
        return txtSetCode;
    }

    @JsonProperty("txtSetCode")
    public void setTxtSetCode(TextBox txtSetCode) {
        this.txtSetCode=txtSetCode;
    }

    @JsonProperty("btnSetCode")
    public Button getBtnSetCode() {
        return btnSetCode;
    }

    @JsonProperty("btnSetCode")
    public void setBtnSetCode(Button btnSetCode) {
        this.btnSetCode=btnSetCode;
    }

    @JsonProperty("txtSetMeisho")
    public TextBox getTxtSetMeisho() {
        return txtSetMeisho;
    }

    @JsonProperty("txtSetMeisho")
    public void setTxtSetMeisho(TextBox txtSetMeisho) {
        this.txtSetMeisho=txtSetMeisho;
    }

    @JsonProperty("btnSetMeisho")
    public Button getBtnSetMeisho() {
        return btnSetMeisho;
    }

    @JsonProperty("btnSetMeisho")
    public void setBtnSetMeisho(Button btnSetMeisho) {
        this.btnSetMeisho=btnSetMeisho;
    }

    @JsonProperty("line0")
    public HorizontalLine getLine0() {
        return line0;
    }

    @JsonProperty("line0")
    public void setLine0(HorizontalLine line0) {
        this.line0=line0;
    }

    @JsonProperty("txtDaicho")
    public TextBox getTxtDaicho() {
        return txtDaicho;
    }

    @JsonProperty("txtDaicho")
    public void setTxtDaicho(TextBox txtDaicho) {
        this.txtDaicho=txtDaicho;
    }

    @JsonProperty("btnGetDaicho")
    public Button getBtnGetDaicho() {
        return btnGetDaicho;
    }

    @JsonProperty("btnGetDaicho")
    public void setBtnGetDaicho(Button btnGetDaicho) {
        this.btnGetDaicho=btnGetDaicho;
    }

    @JsonProperty("txtDaichoKey")
    public TextBoxCode getTxtDaichoKey() {
        return txtDaichoKey;
    }

    @JsonProperty("txtDaichoKey")
    public void setTxtDaichoKey(TextBoxCode txtDaichoKey) {
        this.txtDaichoKey=txtDaichoKey;
    }

    @JsonProperty("btnGetDaichoKey")
    public Button getBtnGetDaichoKey() {
        return btnGetDaichoKey;
    }

    @JsonProperty("btnGetDaichoKey")
    public void setBtnGetDaichoKey(Button btnGetDaichoKey) {
        this.btnGetDaichoKey=btnGetDaichoKey;
    }

    @JsonProperty("txtShisetsu")
    public TextBox getTxtShisetsu() {
        return txtShisetsu;
    }

    @JsonProperty("txtShisetsu")
    public void setTxtShisetsu(TextBox txtShisetsu) {
        this.txtShisetsu=txtShisetsu;
    }

    @JsonProperty("btnGetShisetsu")
    public Button getBtnGetShisetsu() {
        return btnGetShisetsu;
    }

    @JsonProperty("btnGetShisetsu")
    public void setBtnGetShisetsu(Button btnGetShisetsu) {
        this.btnGetShisetsu=btnGetShisetsu;
    }

    @JsonProperty("txtShisetsuKey")
    public TextBoxCode getTxtShisetsuKey() {
        return txtShisetsuKey;
    }

    @JsonProperty("txtShisetsuKey")
    public void setTxtShisetsuKey(TextBoxCode txtShisetsuKey) {
        this.txtShisetsuKey=txtShisetsuKey;
    }

    @JsonProperty("btnGetShisetsuKey")
    public Button getBtnGetShisetsuKey() {
        return btnGetShisetsuKey;
    }

    @JsonProperty("btnGetShisetsuKey")
    public void setBtnGetShisetsuKey(Button btnGetShisetsuKey) {
        this.btnGetShisetsuKey=btnGetShisetsuKey;
    }

    @JsonProperty("txtCode")
    public TextBox getTxtCode() {
        return txtCode;
    }

    @JsonProperty("txtCode")
    public void setTxtCode(TextBox txtCode) {
        this.txtCode=txtCode;
    }

    @JsonProperty("btnGetCode")
    public Button getBtnGetCode() {
        return btnGetCode;
    }

    @JsonProperty("btnGetCode")
    public void setBtnGetCode(Button btnGetCode) {
        this.btnGetCode=btnGetCode;
    }

    @JsonProperty("txtMeisho")
    public TextBox getTxtMeisho() {
        return txtMeisho;
    }

    @JsonProperty("txtMeisho")
    public void setTxtMeisho(TextBox txtMeisho) {
        this.txtMeisho=txtMeisho;
    }

    @JsonProperty("btnGetMeisho")
    public Button getBtnGetMeisho() {
        return btnGetMeisho;
    }

    @JsonProperty("btnGetMeisho")
    public void setBtnGetMeisho(Button btnGetMeisho) {
        this.btnGetMeisho=btnGetMeisho;
    }

    @JsonProperty("btnInitialize")
    public Button getBtnInitialize() {
        return btnInitialize;
    }

    @JsonProperty("btnInitialize")
    public void setBtnInitialize(Button btnInitialize) {
        this.btnInitialize=btnInitialize;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("line1")
    public HorizontalLine getLine1() {
        return line1;
    }

    @JsonProperty("line1")
    public void setLine1(HorizontalLine line1) {
        this.line1=line1;
    }

    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
    }

}
