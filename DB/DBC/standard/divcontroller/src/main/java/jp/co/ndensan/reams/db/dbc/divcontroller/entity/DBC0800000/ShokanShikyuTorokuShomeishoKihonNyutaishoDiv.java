package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
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
 * ShokanShikyuTorokuShomeishoKihonNyutaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoKihonNyutaishoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShomeishoKihonNyushoYMD")
    private TextBoxDate txtShomeishoKihonNyushoYMD;
    @JsonProperty("txtShomeishoKihonNyushoNissu")
    private TextBoxNum txtShomeishoKihonNyushoNissu;
    @JsonProperty("txtShomeishoKihonTaishoYMD")
    private TextBoxDate txtShomeishoKihonTaishoYMD;
    @JsonProperty("txtShomeishoKihonGaihakuNissu")
    private TextBoxNum txtShomeishoKihonGaihakuNissu;
    @JsonProperty("ddlShomeishoKihonNyushoMaeJokyo")
    private DropDownList ddlShomeishoKihonNyushoMaeJokyo;
    @JsonProperty("ddlShomeishoKihonTaishoGoJokyo")
    private DropDownList ddlShomeishoKihonTaishoGoJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShomeishoKihonNyushoYMD")
    public TextBoxDate getTxtShomeishoKihonNyushoYMD() {
        return txtShomeishoKihonNyushoYMD;
    }

    @JsonProperty("txtShomeishoKihonNyushoYMD")
    public void setTxtShomeishoKihonNyushoYMD(TextBoxDate txtShomeishoKihonNyushoYMD) {
        this.txtShomeishoKihonNyushoYMD=txtShomeishoKihonNyushoYMD;
    }

    @JsonProperty("txtShomeishoKihonNyushoNissu")
    public TextBoxNum getTxtShomeishoKihonNyushoNissu() {
        return txtShomeishoKihonNyushoNissu;
    }

    @JsonProperty("txtShomeishoKihonNyushoNissu")
    public void setTxtShomeishoKihonNyushoNissu(TextBoxNum txtShomeishoKihonNyushoNissu) {
        this.txtShomeishoKihonNyushoNissu=txtShomeishoKihonNyushoNissu;
    }

    @JsonProperty("txtShomeishoKihonTaishoYMD")
    public TextBoxDate getTxtShomeishoKihonTaishoYMD() {
        return txtShomeishoKihonTaishoYMD;
    }

    @JsonProperty("txtShomeishoKihonTaishoYMD")
    public void setTxtShomeishoKihonTaishoYMD(TextBoxDate txtShomeishoKihonTaishoYMD) {
        this.txtShomeishoKihonTaishoYMD=txtShomeishoKihonTaishoYMD;
    }

    @JsonProperty("txtShomeishoKihonGaihakuNissu")
    public TextBoxNum getTxtShomeishoKihonGaihakuNissu() {
        return txtShomeishoKihonGaihakuNissu;
    }

    @JsonProperty("txtShomeishoKihonGaihakuNissu")
    public void setTxtShomeishoKihonGaihakuNissu(TextBoxNum txtShomeishoKihonGaihakuNissu) {
        this.txtShomeishoKihonGaihakuNissu=txtShomeishoKihonGaihakuNissu;
    }

    @JsonProperty("ddlShomeishoKihonNyushoMaeJokyo")
    public DropDownList getDdlShomeishoKihonNyushoMaeJokyo() {
        return ddlShomeishoKihonNyushoMaeJokyo;
    }

    @JsonProperty("ddlShomeishoKihonNyushoMaeJokyo")
    public void setDdlShomeishoKihonNyushoMaeJokyo(DropDownList ddlShomeishoKihonNyushoMaeJokyo) {
        this.ddlShomeishoKihonNyushoMaeJokyo=ddlShomeishoKihonNyushoMaeJokyo;
    }

    @JsonProperty("ddlShomeishoKihonTaishoGoJokyo")
    public DropDownList getDdlShomeishoKihonTaishoGoJokyo() {
        return ddlShomeishoKihonTaishoGoJokyo;
    }

    @JsonProperty("ddlShomeishoKihonTaishoGoJokyo")
    public void setDdlShomeishoKihonTaishoGoJokyo(DropDownList ddlShomeishoKihonTaishoGoJokyo) {
        this.ddlShomeishoKihonTaishoGoJokyo=ddlShomeishoKihonTaishoGoJokyo;
    }

}
