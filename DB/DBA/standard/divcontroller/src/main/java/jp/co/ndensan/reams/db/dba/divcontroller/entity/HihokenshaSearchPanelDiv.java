package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBCommonSearchInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.MaeShorishaRirekiPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ReamsCommonSearchInfoPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaSearchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaSearchPanelDiv extends Panel {
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
    @JsonProperty("HihokenshaSearchButton")
    private Button HihokenshaSearchButton;

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

    @JsonProperty("HihokenshaSearchButton")
    public Button getHihokenshaSearchButton() {
        return HihokenshaSearchButton;
    }

    @JsonProperty("HihokenshaSearchButton")
    public void setHihokenshaSearchButton(Button HihokenshaSearchButton) {
        this.HihokenshaSearchButton=HihokenshaSearchButton;
    }

}
