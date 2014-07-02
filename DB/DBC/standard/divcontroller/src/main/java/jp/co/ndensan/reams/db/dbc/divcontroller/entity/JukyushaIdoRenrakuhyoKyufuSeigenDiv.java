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
 * JukyushaIdoRenrakuhyoKyufuSeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKyufuSeigenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKohiFutanJogengakuGengakuUmu")
    private RadioButton radKohiFutanJogengakuGengakuUmu;
    @JsonProperty("txtKyufuritsuHikisageDateRange")
    private TextBoxDateRange txtKyufuritsuHikisageDateRange;
    @JsonProperty("txtShokanBaraikaDateRange")
    private TextBoxDateRange txtShokanBaraikaDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radKohiFutanJogengakuGengakuUmu")
    public RadioButton getRadKohiFutanJogengakuGengakuUmu() {
        return radKohiFutanJogengakuGengakuUmu;
    }

    @JsonProperty("radKohiFutanJogengakuGengakuUmu")
    public void setRadKohiFutanJogengakuGengakuUmu(RadioButton radKohiFutanJogengakuGengakuUmu) {
        this.radKohiFutanJogengakuGengakuUmu=radKohiFutanJogengakuGengakuUmu;
    }

    @JsonProperty("txtKyufuritsuHikisageDateRange")
    public TextBoxDateRange getTxtKyufuritsuHikisageDateRange() {
        return txtKyufuritsuHikisageDateRange;
    }

    @JsonProperty("txtKyufuritsuHikisageDateRange")
    public void setTxtKyufuritsuHikisageDateRange(TextBoxDateRange txtKyufuritsuHikisageDateRange) {
        this.txtKyufuritsuHikisageDateRange=txtKyufuritsuHikisageDateRange;
    }

    @JsonProperty("txtShokanBaraikaDateRange")
    public TextBoxDateRange getTxtShokanBaraikaDateRange() {
        return txtShokanBaraikaDateRange;
    }

    @JsonProperty("txtShokanBaraikaDateRange")
    public void setTxtShokanBaraikaDateRange(TextBoxDateRange txtShokanBaraikaDateRange) {
        this.txtShokanBaraikaDateRange=txtShokanBaraikaDateRange;
    }

}
