package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
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
 * ShokanShikyuKetteiShomeishoKihonNyutaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoKihonNyutaishoDiv extends Panel {
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
    @JsonProperty("txtShomeishoKihonNyushoMaeJokyo")
    private TextBox txtShomeishoKihonNyushoMaeJokyo;
    @JsonProperty("txtShomeishoKihonTaishoGoJokyo")
    private TextBox txtShomeishoKihonTaishoGoJokyo;

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

    @JsonProperty("txtShomeishoKihonNyushoMaeJokyo")
    public TextBox getTxtShomeishoKihonNyushoMaeJokyo() {
        return txtShomeishoKihonNyushoMaeJokyo;
    }

    @JsonProperty("txtShomeishoKihonNyushoMaeJokyo")
    public void setTxtShomeishoKihonNyushoMaeJokyo(TextBox txtShomeishoKihonNyushoMaeJokyo) {
        this.txtShomeishoKihonNyushoMaeJokyo=txtShomeishoKihonNyushoMaeJokyo;
    }

    @JsonProperty("txtShomeishoKihonTaishoGoJokyo")
    public TextBox getTxtShomeishoKihonTaishoGoJokyo() {
        return txtShomeishoKihonTaishoGoJokyo;
    }

    @JsonProperty("txtShomeishoKihonTaishoGoJokyo")
    public void setTxtShomeishoKihonTaishoGoJokyo(TextBox txtShomeishoKihonTaishoGoJokyo) {
        this.txtShomeishoKihonTaishoGoJokyo=txtShomeishoKihonTaishoGoJokyo;
    }

}
