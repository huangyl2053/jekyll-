package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.IryoHokenTabPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.RoreiFukushiTabPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SeikatsuHogoTabPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SetaiShokaiTabPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShisetsuNyutaishoTabPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * HihokenshaDetailTab のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaDetailTabDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShisetsuNyutaishoTabPanel")
    private ShisetsuNyutaishoTabPanelDiv ShisetsuNyutaishoTabPanel;
    @JsonProperty("SetaiShokaiTabPanel")
    private SetaiShokaiTabPanelDiv SetaiShokaiTabPanel;
    @JsonProperty("SeikatsuHogoTabPanel")
    private SeikatsuHogoTabPanelDiv SeikatsuHogoTabPanel;
    @JsonProperty("RoreiFukushiTabPanel")
    private RoreiFukushiTabPanelDiv RoreiFukushiTabPanel;
    @JsonProperty("IryoHokenTabPanel")
    private IryoHokenTabPanelDiv IryoHokenTabPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShisetsuNyutaishoTabPanel")
    public ShisetsuNyutaishoTabPanelDiv getShisetsuNyutaishoTabPanel() {
        return ShisetsuNyutaishoTabPanel;
    }

    @JsonProperty("ShisetsuNyutaishoTabPanel")
    public void setShisetsuNyutaishoTabPanel(ShisetsuNyutaishoTabPanelDiv ShisetsuNyutaishoTabPanel) {
        this.ShisetsuNyutaishoTabPanel=ShisetsuNyutaishoTabPanel;
    }

    @JsonProperty("SetaiShokaiTabPanel")
    public SetaiShokaiTabPanelDiv getSetaiShokaiTabPanel() {
        return SetaiShokaiTabPanel;
    }

    @JsonProperty("SetaiShokaiTabPanel")
    public void setSetaiShokaiTabPanel(SetaiShokaiTabPanelDiv SetaiShokaiTabPanel) {
        this.SetaiShokaiTabPanel=SetaiShokaiTabPanel;
    }

    @JsonProperty("SeikatsuHogoTabPanel")
    public SeikatsuHogoTabPanelDiv getSeikatsuHogoTabPanel() {
        return SeikatsuHogoTabPanel;
    }

    @JsonProperty("SeikatsuHogoTabPanel")
    public void setSeikatsuHogoTabPanel(SeikatsuHogoTabPanelDiv SeikatsuHogoTabPanel) {
        this.SeikatsuHogoTabPanel=SeikatsuHogoTabPanel;
    }

    @JsonProperty("RoreiFukushiTabPanel")
    public RoreiFukushiTabPanelDiv getRoreiFukushiTabPanel() {
        return RoreiFukushiTabPanel;
    }

    @JsonProperty("RoreiFukushiTabPanel")
    public void setRoreiFukushiTabPanel(RoreiFukushiTabPanelDiv RoreiFukushiTabPanel) {
        this.RoreiFukushiTabPanel=RoreiFukushiTabPanel;
    }

    @JsonProperty("IryoHokenTabPanel")
    public IryoHokenTabPanelDiv getIryoHokenTabPanel() {
        return IryoHokenTabPanel;
    }

    @JsonProperty("IryoHokenTabPanel")
    public void setIryoHokenTabPanel(IryoHokenTabPanelDiv IryoHokenTabPanel) {
        this.IryoHokenTabPanel=IryoHokenTabPanel;
    }

}
