package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBCommonInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ReamsCommonInfoPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ReamsCommonInfoPanel")
    private ReamsCommonInfoPanelDiv ReamsCommonInfoPanel;
    @JsonProperty("DBCommonInfoPanel")
    private DBCommonInfoPanelDiv DBCommonInfoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ReamsCommonInfoPanel")
    public ReamsCommonInfoPanelDiv getReamsCommonInfoPanel() {
        return ReamsCommonInfoPanel;
    }

    @JsonProperty("ReamsCommonInfoPanel")
    public void setReamsCommonInfoPanel(ReamsCommonInfoPanelDiv ReamsCommonInfoPanel) {
        this.ReamsCommonInfoPanel=ReamsCommonInfoPanel;
    }

    @JsonProperty("DBCommonInfoPanel")
    public DBCommonInfoPanelDiv getDBCommonInfoPanel() {
        return DBCommonInfoPanel;
    }

    @JsonProperty("DBCommonInfoPanel")
    public void setDBCommonInfoPanel(DBCommonInfoPanelDiv DBCommonInfoPanel) {
        this.DBCommonInfoPanel=DBCommonInfoPanel;
    }

}
