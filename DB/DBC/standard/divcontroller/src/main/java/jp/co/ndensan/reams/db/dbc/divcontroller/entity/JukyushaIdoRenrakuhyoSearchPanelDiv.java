package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchConditionDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchResultIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoSearchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoSearchPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoSearchCondition")
    private JukyushaIdoRenrakuhyoSearchConditionDiv JukyushaIdoRenrakuhyoSearchCondition;
    @JsonProperty("JukyushaIdoRenrakuhyoSearchResultIchiran")
    private JukyushaIdoRenrakuhyoSearchResultIchiranDiv JukyushaIdoRenrakuhyoSearchResultIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoSearchCondition")
    public JukyushaIdoRenrakuhyoSearchConditionDiv getJukyushaIdoRenrakuhyoSearchCondition() {
        return JukyushaIdoRenrakuhyoSearchCondition;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoSearchCondition")
    public void setJukyushaIdoRenrakuhyoSearchCondition(JukyushaIdoRenrakuhyoSearchConditionDiv JukyushaIdoRenrakuhyoSearchCondition) {
        this.JukyushaIdoRenrakuhyoSearchCondition=JukyushaIdoRenrakuhyoSearchCondition;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoSearchResultIchiran")
    public JukyushaIdoRenrakuhyoSearchResultIchiranDiv getJukyushaIdoRenrakuhyoSearchResultIchiran() {
        return JukyushaIdoRenrakuhyoSearchResultIchiran;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoSearchResultIchiran")
    public void setJukyushaIdoRenrakuhyoSearchResultIchiran(JukyushaIdoRenrakuhyoSearchResultIchiranDiv JukyushaIdoRenrakuhyoSearchResultIchiran) {
        this.JukyushaIdoRenrakuhyoSearchResultIchiran=JukyushaIdoRenrakuhyoSearchResultIchiran;
    }

}
