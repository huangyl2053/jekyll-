package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran.ITaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran.TaishoshaIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoHenkoSearchResultListPanel のクラスファイル
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
public class JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnResearch")
    private Button btnResearch;
    @JsonProperty("ccdTaishoshaIchiran")
    private TaishoshaIchiranDiv ccdTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnResearch
     * @return btnResearch
     */
    @JsonProperty("btnResearch")
    public Button getBtnResearch() {
        return btnResearch;
    }

    /*
     * setbtnResearch
     * @param btnResearch btnResearch
     */
    @JsonProperty("btnResearch")
    public void setBtnResearch(Button btnResearch) {
        this.btnResearch = btnResearch;
    }

    /*
     * getccdTaishoshaIchiran
     * @return ccdTaishoshaIchiran
     */
    @JsonProperty("ccdTaishoshaIchiran")
    public ITaishoshaIchiranDiv getCcdTaishoshaIchiran() {
        return ccdTaishoshaIchiran;
    }

    // </editor-fold>
}
