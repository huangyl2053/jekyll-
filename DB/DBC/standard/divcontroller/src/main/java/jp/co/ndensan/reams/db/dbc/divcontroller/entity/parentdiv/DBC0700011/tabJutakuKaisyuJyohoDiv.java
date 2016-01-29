package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.IJyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabJutakuKaisyuJyoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabJutakuKaisyuJyohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TotalPanel")
    private TotalPanelDiv TotalPanel;
    @JsonProperty("ccdJutakuJizenShinseiDetail")
    private JyutakugaisyunaiyoListDiv ccdJutakuJizenShinseiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTotalPanel
     * @return TotalPanel
     */
    @JsonProperty("TotalPanel")
    public TotalPanelDiv getTotalPanel() {
        return TotalPanel;
    }

    /*
     * setTotalPanel
     * @param TotalPanel TotalPanel
     */
    @JsonProperty("TotalPanel")
    public void setTotalPanel(TotalPanelDiv TotalPanel) {
        this.TotalPanel = TotalPanel;
    }

    /*
     * getccdJutakuJizenShinseiDetail
     * @return ccdJutakuJizenShinseiDetail
     */
    @JsonProperty("ccdJutakuJizenShinseiDetail")
    public IJyutakugaisyunaiyoListDiv getCcdJutakuJizenShinseiDetail() {
        return ccdJutakuJizenShinseiDetail;
    }

    // </editor-fold>
}
