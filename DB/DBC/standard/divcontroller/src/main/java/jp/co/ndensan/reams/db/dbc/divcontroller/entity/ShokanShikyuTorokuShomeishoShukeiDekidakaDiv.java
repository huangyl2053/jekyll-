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
 * ShokanShikyuTorokuShomeishoShukeiDekidaka のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShukeiDekidakaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShukeiDekidakaTanisuGokei")
    private TextBoxNum txtShukeiDekidakaTanisuGokei;
    @JsonProperty("txtShukeiDekidakaTanisuTanka")
    private TextBoxNum txtShukeiDekidakaTanisuTanka;
    @JsonProperty("txtShukeiDekidakaSeikyugaku")
    private TextBoxNum txtShukeiDekidakaSeikyugaku;
    @JsonProperty("txtShukeiDekidakaRiyoshaFutangaku")
    private TextBoxNum txtShukeiDekidakaRiyoshaFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShukeiDekidakaTanisuGokei")
    public TextBoxNum getTxtShukeiDekidakaTanisuGokei() {
        return txtShukeiDekidakaTanisuGokei;
    }

    @JsonProperty("txtShukeiDekidakaTanisuGokei")
    public void setTxtShukeiDekidakaTanisuGokei(TextBoxNum txtShukeiDekidakaTanisuGokei) {
        this.txtShukeiDekidakaTanisuGokei=txtShukeiDekidakaTanisuGokei;
    }

    @JsonProperty("txtShukeiDekidakaTanisuTanka")
    public TextBoxNum getTxtShukeiDekidakaTanisuTanka() {
        return txtShukeiDekidakaTanisuTanka;
    }

    @JsonProperty("txtShukeiDekidakaTanisuTanka")
    public void setTxtShukeiDekidakaTanisuTanka(TextBoxNum txtShukeiDekidakaTanisuTanka) {
        this.txtShukeiDekidakaTanisuTanka=txtShukeiDekidakaTanisuTanka;
    }

    @JsonProperty("txtShukeiDekidakaSeikyugaku")
    public TextBoxNum getTxtShukeiDekidakaSeikyugaku() {
        return txtShukeiDekidakaSeikyugaku;
    }

    @JsonProperty("txtShukeiDekidakaSeikyugaku")
    public void setTxtShukeiDekidakaSeikyugaku(TextBoxNum txtShukeiDekidakaSeikyugaku) {
        this.txtShukeiDekidakaSeikyugaku=txtShukeiDekidakaSeikyugaku;
    }

    @JsonProperty("txtShukeiDekidakaRiyoshaFutangaku")
    public TextBoxNum getTxtShukeiDekidakaRiyoshaFutangaku() {
        return txtShukeiDekidakaRiyoshaFutangaku;
    }

    @JsonProperty("txtShukeiDekidakaRiyoshaFutangaku")
    public void setTxtShukeiDekidakaRiyoshaFutangaku(TextBoxNum txtShukeiDekidakaRiyoshaFutangaku) {
        this.txtShukeiDekidakaRiyoshaFutangaku=txtShukeiDekidakaRiyoshaFutangaku;
    }

}
