package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoGemmenGengakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyufuSeigenDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoSub2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoSub2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengaku")
    private JukyushaIdoRenrakuhyoGemmenGengakuDiv JukyushaIdoRenrakuhyoGemmenGengaku;
    @JsonProperty("JukyushaIdoRenrakuhyoKyufuSeigen")
    private JukyushaIdoRenrakuhyoKyufuSeigenDiv JukyushaIdoRenrakuhyoKyufuSeigen;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengaku")
    public JukyushaIdoRenrakuhyoGemmenGengakuDiv getJukyushaIdoRenrakuhyoGemmenGengaku() {
        return JukyushaIdoRenrakuhyoGemmenGengaku;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengaku")
    public void setJukyushaIdoRenrakuhyoGemmenGengaku(JukyushaIdoRenrakuhyoGemmenGengakuDiv JukyushaIdoRenrakuhyoGemmenGengaku) {
        this.JukyushaIdoRenrakuhyoGemmenGengaku=JukyushaIdoRenrakuhyoGemmenGengaku;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKyufuSeigen")
    public JukyushaIdoRenrakuhyoKyufuSeigenDiv getJukyushaIdoRenrakuhyoKyufuSeigen() {
        return JukyushaIdoRenrakuhyoKyufuSeigen;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKyufuSeigen")
    public void setJukyushaIdoRenrakuhyoKyufuSeigen(JukyushaIdoRenrakuhyoKyufuSeigenDiv JukyushaIdoRenrakuhyoKyufuSeigen) {
        this.JukyushaIdoRenrakuhyoKyufuSeigen=JukyushaIdoRenrakuhyoKyufuSeigen;
    }

}
