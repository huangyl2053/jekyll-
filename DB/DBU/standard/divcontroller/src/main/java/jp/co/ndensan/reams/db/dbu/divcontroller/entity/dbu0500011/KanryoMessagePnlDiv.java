package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanryoMessagePnl のクラスファイル 
 * 
 * @author 自動生成
 */
public class KanryoMessagePnlDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKanryoMessage")
    public KanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    @JsonProperty("ccdKanryoMessage")
    public void setCcdKanryoMessage(KanryoMessageDiv ccdKanryoMessage) {
        this.ccdKanryoMessage=ccdKanryoMessage;
    }

}
