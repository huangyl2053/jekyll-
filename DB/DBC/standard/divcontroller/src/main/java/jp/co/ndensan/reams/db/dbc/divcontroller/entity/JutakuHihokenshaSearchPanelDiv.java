package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBCommonSearchInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.MaeShorishaRirekiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ReamsCommonSearchInfoPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuHihokenshaSearchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuHihokenshaSearchPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ReamsCommonSearchInfoPanel")
    private ReamsCommonSearchInfoPanelDiv ReamsCommonSearchInfoPanel;
    @JsonProperty("DBCommonSearchInfoPanel")
    private DBCommonSearchInfoPanelDiv DBCommonSearchInfoPanel;
    @JsonProperty("MaeShorishaRirekiPanel")
    private MaeShorishaRirekiPanelDiv MaeShorishaRirekiPanel;
    @JsonProperty("btnHihokenshaSearch")
    private Button btnHihokenshaSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ReamsCommonSearchInfoPanel")
    public ReamsCommonSearchInfoPanelDiv getReamsCommonSearchInfoPanel() {
        return ReamsCommonSearchInfoPanel;
    }

    @JsonProperty("ReamsCommonSearchInfoPanel")
    public void setReamsCommonSearchInfoPanel(ReamsCommonSearchInfoPanelDiv ReamsCommonSearchInfoPanel) {
        this.ReamsCommonSearchInfoPanel=ReamsCommonSearchInfoPanel;
    }

    @JsonProperty("DBCommonSearchInfoPanel")
    public DBCommonSearchInfoPanelDiv getDBCommonSearchInfoPanel() {
        return DBCommonSearchInfoPanel;
    }

    @JsonProperty("DBCommonSearchInfoPanel")
    public void setDBCommonSearchInfoPanel(DBCommonSearchInfoPanelDiv DBCommonSearchInfoPanel) {
        this.DBCommonSearchInfoPanel=DBCommonSearchInfoPanel;
    }

    @JsonProperty("MaeShorishaRirekiPanel")
    public MaeShorishaRirekiPanelDiv getMaeShorishaRirekiPanel() {
        return MaeShorishaRirekiPanel;
    }

    @JsonProperty("MaeShorishaRirekiPanel")
    public void setMaeShorishaRirekiPanel(MaeShorishaRirekiPanelDiv MaeShorishaRirekiPanel) {
        this.MaeShorishaRirekiPanel=MaeShorishaRirekiPanel;
    }

    @JsonProperty("btnHihokenshaSearch")
    public Button getBtnHihokenshaSearch() {
        return btnHihokenshaSearch;
    }

    @JsonProperty("btnHihokenshaSearch")
    public void setBtnHihokenshaSearch(Button btnHihokenshaSearch) {
        this.btnHihokenshaSearch=btnHihokenshaSearch;
    }

}
