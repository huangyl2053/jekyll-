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
 * ShokanShikyuTorokuShomeishoShukeiHoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShukeiHokenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShukeiHokenTanisuGokei")
    private TextBoxNum txtShukeiHokenTanisuGokei;
    @JsonProperty("txtShukeiHokenTanisuTanka")
    private TextBoxNum txtShukeiHokenTanisuTanka;
    @JsonProperty("txtShukeiHokenSeikyugaku")
    private TextBoxNum txtShukeiHokenSeikyugaku;
    @JsonProperty("txtShukeiHokenRiyoshaFutangaku")
    private TextBoxNum txtShukeiHokenRiyoshaFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShukeiHokenTanisuGokei")
    public TextBoxNum getTxtShukeiHokenTanisuGokei() {
        return txtShukeiHokenTanisuGokei;
    }

    @JsonProperty("txtShukeiHokenTanisuGokei")
    public void setTxtShukeiHokenTanisuGokei(TextBoxNum txtShukeiHokenTanisuGokei) {
        this.txtShukeiHokenTanisuGokei=txtShukeiHokenTanisuGokei;
    }

    @JsonProperty("txtShukeiHokenTanisuTanka")
    public TextBoxNum getTxtShukeiHokenTanisuTanka() {
        return txtShukeiHokenTanisuTanka;
    }

    @JsonProperty("txtShukeiHokenTanisuTanka")
    public void setTxtShukeiHokenTanisuTanka(TextBoxNum txtShukeiHokenTanisuTanka) {
        this.txtShukeiHokenTanisuTanka=txtShukeiHokenTanisuTanka;
    }

    @JsonProperty("txtShukeiHokenSeikyugaku")
    public TextBoxNum getTxtShukeiHokenSeikyugaku() {
        return txtShukeiHokenSeikyugaku;
    }

    @JsonProperty("txtShukeiHokenSeikyugaku")
    public void setTxtShukeiHokenSeikyugaku(TextBoxNum txtShukeiHokenSeikyugaku) {
        this.txtShukeiHokenSeikyugaku=txtShukeiHokenSeikyugaku;
    }

    @JsonProperty("txtShukeiHokenRiyoshaFutangaku")
    public TextBoxNum getTxtShukeiHokenRiyoshaFutangaku() {
        return txtShukeiHokenRiyoshaFutangaku;
    }

    @JsonProperty("txtShukeiHokenRiyoshaFutangaku")
    public void setTxtShukeiHokenRiyoshaFutangaku(TextBoxNum txtShukeiHokenRiyoshaFutangaku) {
        this.txtShukeiHokenRiyoshaFutangaku=txtShukeiHokenRiyoshaFutangaku;
    }

}
