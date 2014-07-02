package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigokanryomessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoComplete のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoCompleteDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoCompleteInfo")
    private KaigoKanryoMessageDiv JukyushaIdoRenrakuhyoCompleteInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoCompleteInfo")
    public KaigoKanryoMessageDiv getJukyushaIdoRenrakuhyoCompleteInfo() {
        return JukyushaIdoRenrakuhyoCompleteInfo;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoCompleteInfo")
    public void setJukyushaIdoRenrakuhyoCompleteInfo(KaigoKanryoMessageDiv JukyushaIdoRenrakuhyoCompleteInfo) {
        this.JukyushaIdoRenrakuhyoCompleteInfo=JukyushaIdoRenrakuhyoCompleteInfo;
    }

}
