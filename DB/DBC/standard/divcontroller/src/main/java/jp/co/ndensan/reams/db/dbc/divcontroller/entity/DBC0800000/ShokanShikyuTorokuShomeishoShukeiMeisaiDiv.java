package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShukeiDekidakaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShukeiGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShukeiHokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShukeiTankiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeishoShukeiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShukeiMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShukeiShuruiCode")
    private TextBoxCode txtShukeiShuruiCode;
    @JsonProperty("btnShukeiShurui")
    private Button btnShukeiShurui;
    @JsonProperty("txtShukeiShuruiName")
    private TextBox txtShukeiShuruiName;
    @JsonProperty("txtShukeiJitsuNissu")
    private TextBoxNum txtShukeiJitsuNissu;
    @JsonProperty("radShukeiShinsaHoho")
    private RadioButton radShukeiShinsaHoho;
    @JsonProperty("txtShukeiKyufuritsu")
    private TextBoxNum txtShukeiKyufuritsu;
    @JsonProperty("txtShukeiKeikakuTani")
    private TextBoxNum txtShukeiKeikakuTani;
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiGendogaku")
    private ShokanShikyuTorokuShomeishoShukeiGendogakuDiv ShokanShikyuTorokuShomeishoShukeiGendogaku;
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiTanki")
    private ShokanShikyuTorokuShomeishoShukeiTankiDiv ShokanShikyuTorokuShomeishoShukeiTanki;
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiHoken")
    private ShokanShikyuTorokuShomeishoShukeiHokenDiv ShokanShikyuTorokuShomeishoShukeiHoken;
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiDekidaka")
    private ShokanShikyuTorokuShomeishoShukeiDekidakaDiv ShokanShikyuTorokuShomeishoShukeiDekidaka;
    @JsonProperty("btnShukeiKakutei")
    private Button btnShukeiKakutei;
    @JsonProperty("txtShukeiSelectedIndex")
    private TextBox txtShukeiSelectedIndex;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShukeiShuruiCode")
    public TextBoxCode getTxtShukeiShuruiCode() {
        return txtShukeiShuruiCode;
    }

    @JsonProperty("txtShukeiShuruiCode")
    public void setTxtShukeiShuruiCode(TextBoxCode txtShukeiShuruiCode) {
        this.txtShukeiShuruiCode=txtShukeiShuruiCode;
    }

    @JsonProperty("btnShukeiShurui")
    public Button getBtnShukeiShurui() {
        return btnShukeiShurui;
    }

    @JsonProperty("btnShukeiShurui")
    public void setBtnShukeiShurui(Button btnShukeiShurui) {
        this.btnShukeiShurui=btnShukeiShurui;
    }

    @JsonProperty("txtShukeiShuruiName")
    public TextBox getTxtShukeiShuruiName() {
        return txtShukeiShuruiName;
    }

    @JsonProperty("txtShukeiShuruiName")
    public void setTxtShukeiShuruiName(TextBox txtShukeiShuruiName) {
        this.txtShukeiShuruiName=txtShukeiShuruiName;
    }

    @JsonProperty("txtShukeiJitsuNissu")
    public TextBoxNum getTxtShukeiJitsuNissu() {
        return txtShukeiJitsuNissu;
    }

    @JsonProperty("txtShukeiJitsuNissu")
    public void setTxtShukeiJitsuNissu(TextBoxNum txtShukeiJitsuNissu) {
        this.txtShukeiJitsuNissu=txtShukeiJitsuNissu;
    }

    @JsonProperty("radShukeiShinsaHoho")
    public RadioButton getRadShukeiShinsaHoho() {
        return radShukeiShinsaHoho;
    }

    @JsonProperty("radShukeiShinsaHoho")
    public void setRadShukeiShinsaHoho(RadioButton radShukeiShinsaHoho) {
        this.radShukeiShinsaHoho=radShukeiShinsaHoho;
    }

    @JsonProperty("txtShukeiKyufuritsu")
    public TextBoxNum getTxtShukeiKyufuritsu() {
        return txtShukeiKyufuritsu;
    }

    @JsonProperty("txtShukeiKyufuritsu")
    public void setTxtShukeiKyufuritsu(TextBoxNum txtShukeiKyufuritsu) {
        this.txtShukeiKyufuritsu=txtShukeiKyufuritsu;
    }

    @JsonProperty("txtShukeiKeikakuTani")
    public TextBoxNum getTxtShukeiKeikakuTani() {
        return txtShukeiKeikakuTani;
    }

    @JsonProperty("txtShukeiKeikakuTani")
    public void setTxtShukeiKeikakuTani(TextBoxNum txtShukeiKeikakuTani) {
        this.txtShukeiKeikakuTani=txtShukeiKeikakuTani;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiGendogaku")
    public ShokanShikyuTorokuShomeishoShukeiGendogakuDiv getShokanShikyuTorokuShomeishoShukeiGendogaku() {
        return ShokanShikyuTorokuShomeishoShukeiGendogaku;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiGendogaku")
    public void setShokanShikyuTorokuShomeishoShukeiGendogaku(ShokanShikyuTorokuShomeishoShukeiGendogakuDiv ShokanShikyuTorokuShomeishoShukeiGendogaku) {
        this.ShokanShikyuTorokuShomeishoShukeiGendogaku=ShokanShikyuTorokuShomeishoShukeiGendogaku;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiTanki")
    public ShokanShikyuTorokuShomeishoShukeiTankiDiv getShokanShikyuTorokuShomeishoShukeiTanki() {
        return ShokanShikyuTorokuShomeishoShukeiTanki;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiTanki")
    public void setShokanShikyuTorokuShomeishoShukeiTanki(ShokanShikyuTorokuShomeishoShukeiTankiDiv ShokanShikyuTorokuShomeishoShukeiTanki) {
        this.ShokanShikyuTorokuShomeishoShukeiTanki=ShokanShikyuTorokuShomeishoShukeiTanki;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiHoken")
    public ShokanShikyuTorokuShomeishoShukeiHokenDiv getShokanShikyuTorokuShomeishoShukeiHoken() {
        return ShokanShikyuTorokuShomeishoShukeiHoken;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiHoken")
    public void setShokanShikyuTorokuShomeishoShukeiHoken(ShokanShikyuTorokuShomeishoShukeiHokenDiv ShokanShikyuTorokuShomeishoShukeiHoken) {
        this.ShokanShikyuTorokuShomeishoShukeiHoken=ShokanShikyuTorokuShomeishoShukeiHoken;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiDekidaka")
    public ShokanShikyuTorokuShomeishoShukeiDekidakaDiv getShokanShikyuTorokuShomeishoShukeiDekidaka() {
        return ShokanShikyuTorokuShomeishoShukeiDekidaka;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiDekidaka")
    public void setShokanShikyuTorokuShomeishoShukeiDekidaka(ShokanShikyuTorokuShomeishoShukeiDekidakaDiv ShokanShikyuTorokuShomeishoShukeiDekidaka) {
        this.ShokanShikyuTorokuShomeishoShukeiDekidaka=ShokanShikyuTorokuShomeishoShukeiDekidaka;
    }

    @JsonProperty("btnShukeiKakutei")
    public Button getBtnShukeiKakutei() {
        return btnShukeiKakutei;
    }

    @JsonProperty("btnShukeiKakutei")
    public void setBtnShukeiKakutei(Button btnShukeiKakutei) {
        this.btnShukeiKakutei=btnShukeiKakutei;
    }

    @JsonProperty("txtShukeiSelectedIndex")
    public TextBox getTxtShukeiSelectedIndex() {
        return txtShukeiSelectedIndex;
    }

    @JsonProperty("txtShukeiSelectedIndex")
    public void setTxtShukeiSelectedIndex(TextBox txtShukeiSelectedIndex) {
        this.txtShukeiSelectedIndex=txtShukeiSelectedIndex;
    }

}
