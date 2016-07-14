package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
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
 * KyufuJissekiKihonShisetsuNyutaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiKihonShisetsuNyutaishoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyufuJissekiKihonNyushoYMD")
    private TextBoxDate txtKyufuJissekiKihonNyushoYMD;
    @JsonProperty("txtKyufuJissekiKihonNyushoJitsuNissu")
    private TextBox txtKyufuJissekiKihonNyushoJitsuNissu;
    @JsonProperty("txtKyufuJissekiKihonTaishoYMD")
    private TextBoxDate txtKyufuJissekiKihonTaishoYMD;
    @JsonProperty("txtKyufuJissekiKihonGaihakuNissu")
    private TextBox txtKyufuJissekiKihonGaihakuNissu;
    @JsonProperty("txtKyufuJissekiKihonNyushoMaeJokyo")
    private TextBox txtKyufuJissekiKihonNyushoMaeJokyo;
    @JsonProperty("txtKyufuJissekiKihonNyushoAtoJokyo")
    private TextBox txtKyufuJissekiKihonNyushoAtoJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKyufuJissekiKihonNyushoYMD")
    public TextBoxDate getTxtKyufuJissekiKihonNyushoYMD() {
        return txtKyufuJissekiKihonNyushoYMD;
    }

    @JsonProperty("txtKyufuJissekiKihonNyushoYMD")
    public void setTxtKyufuJissekiKihonNyushoYMD(TextBoxDate txtKyufuJissekiKihonNyushoYMD) {
        this.txtKyufuJissekiKihonNyushoYMD=txtKyufuJissekiKihonNyushoYMD;
    }

    @JsonProperty("txtKyufuJissekiKihonNyushoJitsuNissu")
    public TextBox getTxtKyufuJissekiKihonNyushoJitsuNissu() {
        return txtKyufuJissekiKihonNyushoJitsuNissu;
    }

    @JsonProperty("txtKyufuJissekiKihonNyushoJitsuNissu")
    public void setTxtKyufuJissekiKihonNyushoJitsuNissu(TextBox txtKyufuJissekiKihonNyushoJitsuNissu) {
        this.txtKyufuJissekiKihonNyushoJitsuNissu=txtKyufuJissekiKihonNyushoJitsuNissu;
    }

    @JsonProperty("txtKyufuJissekiKihonTaishoYMD")
    public TextBoxDate getTxtKyufuJissekiKihonTaishoYMD() {
        return txtKyufuJissekiKihonTaishoYMD;
    }

    @JsonProperty("txtKyufuJissekiKihonTaishoYMD")
    public void setTxtKyufuJissekiKihonTaishoYMD(TextBoxDate txtKyufuJissekiKihonTaishoYMD) {
        this.txtKyufuJissekiKihonTaishoYMD=txtKyufuJissekiKihonTaishoYMD;
    }

    @JsonProperty("txtKyufuJissekiKihonGaihakuNissu")
    public TextBox getTxtKyufuJissekiKihonGaihakuNissu() {
        return txtKyufuJissekiKihonGaihakuNissu;
    }

    @JsonProperty("txtKyufuJissekiKihonGaihakuNissu")
    public void setTxtKyufuJissekiKihonGaihakuNissu(TextBox txtKyufuJissekiKihonGaihakuNissu) {
        this.txtKyufuJissekiKihonGaihakuNissu=txtKyufuJissekiKihonGaihakuNissu;
    }

    @JsonProperty("txtKyufuJissekiKihonNyushoMaeJokyo")
    public TextBox getTxtKyufuJissekiKihonNyushoMaeJokyo() {
        return txtKyufuJissekiKihonNyushoMaeJokyo;
    }

    @JsonProperty("txtKyufuJissekiKihonNyushoMaeJokyo")
    public void setTxtKyufuJissekiKihonNyushoMaeJokyo(TextBox txtKyufuJissekiKihonNyushoMaeJokyo) {
        this.txtKyufuJissekiKihonNyushoMaeJokyo=txtKyufuJissekiKihonNyushoMaeJokyo;
    }

    @JsonProperty("txtKyufuJissekiKihonNyushoAtoJokyo")
    public TextBox getTxtKyufuJissekiKihonNyushoAtoJokyo() {
        return txtKyufuJissekiKihonNyushoAtoJokyo;
    }

    @JsonProperty("txtKyufuJissekiKihonNyushoAtoJokyo")
    public void setTxtKyufuJissekiKihonNyushoAtoJokyo(TextBox txtKyufuJissekiKihonNyushoAtoJokyo) {
        this.txtKyufuJissekiKihonNyushoAtoJokyo=txtKyufuJissekiKihonNyushoAtoJokyo;
    }

}
