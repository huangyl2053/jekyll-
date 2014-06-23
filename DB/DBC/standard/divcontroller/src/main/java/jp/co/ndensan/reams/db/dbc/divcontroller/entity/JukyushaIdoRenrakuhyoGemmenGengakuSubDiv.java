package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoHyojunFutanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoRiyoshaFutanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoGemmenGengakuSub のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoGemmenGengakuSubDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoRiyoshaFutan")
    private JukyushaIdoRenrakuhyoRiyoshaFutanDiv JukyushaIdoRenrakuhyoRiyoshaFutan;
    @JsonProperty("JukyushaIdoRenrakuhyoFukushiHojinKeigen")
    private JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv JukyushaIdoRenrakuhyoFukushiHojinKeigen;
    @JsonProperty("JukyushaIdoRenrakuhyoHyojunFutan")
    private JukyushaIdoRenrakuhyoHyojunFutanDiv JukyushaIdoRenrakuhyoHyojunFutan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoRiyoshaFutan")
    public JukyushaIdoRenrakuhyoRiyoshaFutanDiv getJukyushaIdoRenrakuhyoRiyoshaFutan() {
        return JukyushaIdoRenrakuhyoRiyoshaFutan;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoRiyoshaFutan")
    public void setJukyushaIdoRenrakuhyoRiyoshaFutan(JukyushaIdoRenrakuhyoRiyoshaFutanDiv JukyushaIdoRenrakuhyoRiyoshaFutan) {
        this.JukyushaIdoRenrakuhyoRiyoshaFutan=JukyushaIdoRenrakuhyoRiyoshaFutan;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoFukushiHojinKeigen")
    public JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv getJukyushaIdoRenrakuhyoFukushiHojinKeigen() {
        return JukyushaIdoRenrakuhyoFukushiHojinKeigen;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoFukushiHojinKeigen")
    public void setJukyushaIdoRenrakuhyoFukushiHojinKeigen(JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv JukyushaIdoRenrakuhyoFukushiHojinKeigen) {
        this.JukyushaIdoRenrakuhyoFukushiHojinKeigen=JukyushaIdoRenrakuhyoFukushiHojinKeigen;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoHyojunFutan")
    public JukyushaIdoRenrakuhyoHyojunFutanDiv getJukyushaIdoRenrakuhyoHyojunFutan() {
        return JukyushaIdoRenrakuhyoHyojunFutan;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoHyojunFutan")
    public void setJukyushaIdoRenrakuhyoHyojunFutan(JukyushaIdoRenrakuhyoHyojunFutanDiv JukyushaIdoRenrakuhyoHyojunFutan) {
        this.JukyushaIdoRenrakuhyoHyojunFutan=JukyushaIdoRenrakuhyoHyojunFutan;
    }

}
