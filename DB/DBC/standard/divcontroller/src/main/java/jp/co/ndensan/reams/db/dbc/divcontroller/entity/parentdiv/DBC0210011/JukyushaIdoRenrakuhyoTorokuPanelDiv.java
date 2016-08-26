package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoTorokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchHihokensha")
    private SearchHihokenshaDiv SearchHihokensha;
    @JsonProperty("JukyushaIdoRenrakuhyoShinkiTorokuPanel")
    private JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv JukyushaIdoRenrakuhyoShinkiTorokuPanel;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchHihokensha
     * @return SearchHihokensha
     */
    @JsonProperty("SearchHihokensha")
    public SearchHihokenshaDiv getSearchHihokensha() {
        return SearchHihokensha;
    }

    /*
     * setSearchHihokensha
     * @param SearchHihokensha SearchHihokensha
     */
    @JsonProperty("SearchHihokensha")
    public void setSearchHihokensha(SearchHihokenshaDiv SearchHihokensha) {
        this.SearchHihokensha = SearchHihokensha;
    }

    /*
     * getJukyushaIdoRenrakuhyoShinkiTorokuPanel
     * @return JukyushaIdoRenrakuhyoShinkiTorokuPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoShinkiTorokuPanel")
    public JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv getJukyushaIdoRenrakuhyoShinkiTorokuPanel() {
        return JukyushaIdoRenrakuhyoShinkiTorokuPanel;
    }

    /*
     * setJukyushaIdoRenrakuhyoShinkiTorokuPanel
     * @param JukyushaIdoRenrakuhyoShinkiTorokuPanel JukyushaIdoRenrakuhyoShinkiTorokuPanel
     */
    @JsonProperty("JukyushaIdoRenrakuhyoShinkiTorokuPanel")
    public void setJukyushaIdoRenrakuhyoShinkiTorokuPanel(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv JukyushaIdoRenrakuhyoShinkiTorokuPanel) {
        this.JukyushaIdoRenrakuhyoShinkiTorokuPanel = JukyushaIdoRenrakuhyoShinkiTorokuPanel;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    // </editor-fold>
}
