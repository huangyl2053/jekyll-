package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuminFukaShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminFukaShokaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kaigoatena")
    private KaigoAtenaInfoDiv Kaigoatena;
    @JsonProperty("KaigoKihon")
    private KaigoFukaKihonDiv KaigoKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Kaigoatena")
    public KaigoAtenaInfoDiv getKaigoatena() {
        return Kaigoatena;
    }

    @JsonProperty("Kaigoatena")
    public void setKaigoatena(KaigoAtenaInfoDiv Kaigoatena) {
        this.Kaigoatena=Kaigoatena;
    }

    @JsonProperty("KaigoKihon")
    public KaigoFukaKihonDiv getKaigoKihon() {
        return KaigoKihon;
    }

    @JsonProperty("KaigoKihon")
    public void setKaigoKihon(KaigoFukaKihonDiv KaigoKihon) {
         this.KaigoKihon=KaigoKihon;
    }

}
