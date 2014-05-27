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
 * ShokanShikyuTorokuShomeishoShokujiGokei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShokujiGokeiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGokeiNobeNissu")
    private TextBoxNum txtGokeiNobeNissu;
    @JsonProperty("txtGokeiFutanNichigaku")
    private TextBoxNum txtGokeiFutanNichigaku;
    @JsonProperty("txtGokeiTeikyoGokei")
    private TextBoxNum txtGokeiTeikyoGokei;
    @JsonProperty("txtGokeiFutanGetsugaku")
    private TextBoxNum txtGokeiFutanGetsugaku;
    @JsonProperty("txtGokeiSeikyugaku")
    private TextBoxNum txtGokeiSeikyugaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtGokeiNobeNissu")
    public TextBoxNum getTxtGokeiNobeNissu() {
        return txtGokeiNobeNissu;
    }

    @JsonProperty("txtGokeiNobeNissu")
    public void setTxtGokeiNobeNissu(TextBoxNum txtGokeiNobeNissu) {
        this.txtGokeiNobeNissu=txtGokeiNobeNissu;
    }

    @JsonProperty("txtGokeiFutanNichigaku")
    public TextBoxNum getTxtGokeiFutanNichigaku() {
        return txtGokeiFutanNichigaku;
    }

    @JsonProperty("txtGokeiFutanNichigaku")
    public void setTxtGokeiFutanNichigaku(TextBoxNum txtGokeiFutanNichigaku) {
        this.txtGokeiFutanNichigaku=txtGokeiFutanNichigaku;
    }

    @JsonProperty("txtGokeiTeikyoGokei")
    public TextBoxNum getTxtGokeiTeikyoGokei() {
        return txtGokeiTeikyoGokei;
    }

    @JsonProperty("txtGokeiTeikyoGokei")
    public void setTxtGokeiTeikyoGokei(TextBoxNum txtGokeiTeikyoGokei) {
        this.txtGokeiTeikyoGokei=txtGokeiTeikyoGokei;
    }

    @JsonProperty("txtGokeiFutanGetsugaku")
    public TextBoxNum getTxtGokeiFutanGetsugaku() {
        return txtGokeiFutanGetsugaku;
    }

    @JsonProperty("txtGokeiFutanGetsugaku")
    public void setTxtGokeiFutanGetsugaku(TextBoxNum txtGokeiFutanGetsugaku) {
        this.txtGokeiFutanGetsugaku=txtGokeiFutanGetsugaku;
    }

    @JsonProperty("txtGokeiSeikyugaku")
    public TextBoxNum getTxtGokeiSeikyugaku() {
        return txtGokeiSeikyugaku;
    }

    @JsonProperty("txtGokeiSeikyugaku")
    public void setTxtGokeiSeikyugaku(TextBoxNum txtGokeiSeikyugaku) {
        this.txtGokeiSeikyugaku=txtGokeiSeikyugaku;
    }

}
