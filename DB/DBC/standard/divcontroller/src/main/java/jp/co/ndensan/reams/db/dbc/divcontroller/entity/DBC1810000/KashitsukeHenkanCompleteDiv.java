package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigokanryomessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KashitsukeHenkanComplete のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeHenkanCompleteDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KashitsukeHenkanInfoCompleteInfo")
    private KaigoKanryoMessageDiv KashitsukeHenkanInfoCompleteInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KashitsukeHenkanInfoCompleteInfo")
    public KaigoKanryoMessageDiv getKashitsukeHenkanInfoCompleteInfo() {
        return KashitsukeHenkanInfoCompleteInfo;
    }

    @JsonProperty("KashitsukeHenkanInfoCompleteInfo")
    public void setKashitsukeHenkanInfoCompleteInfo(KaigoKanryoMessageDiv KashitsukeHenkanInfoCompleteInfo) {
        this.KashitsukeHenkanInfoCompleteInfo=KashitsukeHenkanInfoCompleteInfo;
    }

}
