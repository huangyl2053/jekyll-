package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokiKoreiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokuhoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoKokiKoreiKokuho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKokiKorei")
    private JukyushaIdoRenrakuhyoKokiKoreiDiv JukyushaIdoRenrakuhyoKokiKorei;
    @JsonProperty("JukyushaIdoRenrakuhyoKokuho")
    private JukyushaIdoRenrakuhyoKokuhoDiv JukyushaIdoRenrakuhyoKokuho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKokiKorei")
    public JukyushaIdoRenrakuhyoKokiKoreiDiv getJukyushaIdoRenrakuhyoKokiKorei() {
        return JukyushaIdoRenrakuhyoKokiKorei;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKokiKorei")
    public void setJukyushaIdoRenrakuhyoKokiKorei(JukyushaIdoRenrakuhyoKokiKoreiDiv JukyushaIdoRenrakuhyoKokiKorei) {
        this.JukyushaIdoRenrakuhyoKokiKorei=JukyushaIdoRenrakuhyoKokiKorei;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKokuho")
    public JukyushaIdoRenrakuhyoKokuhoDiv getJukyushaIdoRenrakuhyoKokuho() {
        return JukyushaIdoRenrakuhyoKokuho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKokuho")
    public void setJukyushaIdoRenrakuhyoKokuho(JukyushaIdoRenrakuhyoKokuhoDiv JukyushaIdoRenrakuhyoKokuho) {
        this.JukyushaIdoRenrakuhyoKokuho=JukyushaIdoRenrakuhyoKokuho;
    }

}
