package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SokujiKouseiJumin のクラスファイル
 *
 * @author 自動生成
 */
public class SokujiKouseiJuminDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("SokujiKouseiAtena")
    private KaigoAtenaInfoDiv SokujiKouseiAtena;
    @JsonProperty("SokujiKouseiKihon")
    private KaigoFukaKihonDiv SokujiKouseiKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujiKouseiAtena")
    public KaigoAtenaInfoDiv getSokujiKouseiAtena() {
        return SokujiKouseiAtena;
    }

    @JsonProperty("SokujiKouseiAtena")
    public void setSokujiKouseiAtena(KaigoAtenaInfoDiv SokujiKouseiAtena) {
        this.SokujiKouseiAtena = SokujiKouseiAtena;
    }

    @JsonProperty("SokujiKouseiKihon")
    public KaigoFukaKihonDiv getSokujiKouseiKihon() {
        return SokujiKouseiKihon;
    }

    @JsonProperty("SokujiKouseiKihon")
    public void setSokujiKouseiKihon(KaigoFukaKihonDiv SokujiKouseiKihon) {
        this.SokujiKouseiKihon = SokujiKouseiKihon;
    }

}
