package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeishoShafukuMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShafukuMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShafukugakuShurui")
    private DropDownList ddlShafukugakuShurui;
    @JsonProperty("ddlShafukugakuKeigenritsu")
    private DropDownList ddlShafukugakuKeigenritsu;
    @JsonProperty("txtShafukugakuFutanSogaku")
    private TextBoxNum txtShafukugakuFutanSogaku;
    @JsonProperty("txtShafukugakuKeigengaku")
    private TextBoxNum txtShafukugakuKeigengaku;
    @JsonProperty("txtShafukugakuKeigengoFutangaku")
    private TextBoxNum txtShafukugakuKeigengoFutangaku;
    @JsonProperty("txtShafukugakuBiko")
    private TextBox txtShafukugakuBiko;
    @JsonProperty("btnShafukugakuKakutei")
    private Button btnShafukugakuKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlShafukugakuShurui")
    public DropDownList getDdlShafukugakuShurui() {
        return ddlShafukugakuShurui;
    }

    @JsonProperty("ddlShafukugakuShurui")
    public void setDdlShafukugakuShurui(DropDownList ddlShafukugakuShurui) {
        this.ddlShafukugakuShurui=ddlShafukugakuShurui;
    }

    @JsonProperty("ddlShafukugakuKeigenritsu")
    public DropDownList getDdlShafukugakuKeigenritsu() {
        return ddlShafukugakuKeigenritsu;
    }

    @JsonProperty("ddlShafukugakuKeigenritsu")
    public void setDdlShafukugakuKeigenritsu(DropDownList ddlShafukugakuKeigenritsu) {
        this.ddlShafukugakuKeigenritsu=ddlShafukugakuKeigenritsu;
    }

    @JsonProperty("txtShafukugakuFutanSogaku")
    public TextBoxNum getTxtShafukugakuFutanSogaku() {
        return txtShafukugakuFutanSogaku;
    }

    @JsonProperty("txtShafukugakuFutanSogaku")
    public void setTxtShafukugakuFutanSogaku(TextBoxNum txtShafukugakuFutanSogaku) {
        this.txtShafukugakuFutanSogaku=txtShafukugakuFutanSogaku;
    }

    @JsonProperty("txtShafukugakuKeigengaku")
    public TextBoxNum getTxtShafukugakuKeigengaku() {
        return txtShafukugakuKeigengaku;
    }

    @JsonProperty("txtShafukugakuKeigengaku")
    public void setTxtShafukugakuKeigengaku(TextBoxNum txtShafukugakuKeigengaku) {
        this.txtShafukugakuKeigengaku=txtShafukugakuKeigengaku;
    }

    @JsonProperty("txtShafukugakuKeigengoFutangaku")
    public TextBoxNum getTxtShafukugakuKeigengoFutangaku() {
        return txtShafukugakuKeigengoFutangaku;
    }

    @JsonProperty("txtShafukugakuKeigengoFutangaku")
    public void setTxtShafukugakuKeigengoFutangaku(TextBoxNum txtShafukugakuKeigengoFutangaku) {
        this.txtShafukugakuKeigengoFutangaku=txtShafukugakuKeigengoFutangaku;
    }

    @JsonProperty("txtShafukugakuBiko")
    public TextBox getTxtShafukugakuBiko() {
        return txtShafukugakuBiko;
    }

    @JsonProperty("txtShafukugakuBiko")
    public void setTxtShafukugakuBiko(TextBox txtShafukugakuBiko) {
        this.txtShafukugakuBiko=txtShafukugakuBiko;
    }

    @JsonProperty("btnShafukugakuKakutei")
    public Button getBtnShafukugakuKakutei() {
        return btnShafukugakuKakutei;
    }

    @JsonProperty("btnShafukugakuKakutei")
    public void setBtnShafukugakuKakutei(Button btnShafukugakuKakutei) {
        this.btnShafukugakuKakutei=btnShafukugakuKakutei;
    }

}
