package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA6020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaDaichoIkkatsuHakkoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaDaichoIkkatsuHakkoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaDaichoHakkoChushutsuJokenPanel")
    private HihokenshaDaichoHakkoChushutsuJokenPanelDiv HihokenshaDaichoHakkoChushutsuJokenPanel;
    @JsonProperty("HihokenshaDaichoHakkoListPanel")
    private HihokenshaDaichoHakkoListPanelDiv HihokenshaDaichoHakkoListPanel;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHihokenshaDaichoHakkoChushutsuJokenPanel
     * @return HihokenshaDaichoHakkoChushutsuJokenPanel
     */
    @JsonProperty("HihokenshaDaichoHakkoChushutsuJokenPanel")
    public HihokenshaDaichoHakkoChushutsuJokenPanelDiv getHihokenshaDaichoHakkoChushutsuJokenPanel() {
        return HihokenshaDaichoHakkoChushutsuJokenPanel;
    }

    /*
     * setHihokenshaDaichoHakkoChushutsuJokenPanel
     * @param HihokenshaDaichoHakkoChushutsuJokenPanel HihokenshaDaichoHakkoChushutsuJokenPanel
     */
    @JsonProperty("HihokenshaDaichoHakkoChushutsuJokenPanel")
    public void setHihokenshaDaichoHakkoChushutsuJokenPanel(HihokenshaDaichoHakkoChushutsuJokenPanelDiv HihokenshaDaichoHakkoChushutsuJokenPanel) {
        this.HihokenshaDaichoHakkoChushutsuJokenPanel = HihokenshaDaichoHakkoChushutsuJokenPanel;
    }

    /*
     * getHihokenshaDaichoHakkoListPanel
     * @return HihokenshaDaichoHakkoListPanel
     */
    @JsonProperty("HihokenshaDaichoHakkoListPanel")
    public HihokenshaDaichoHakkoListPanelDiv getHihokenshaDaichoHakkoListPanel() {
        return HihokenshaDaichoHakkoListPanel;
    }

    /*
     * setHihokenshaDaichoHakkoListPanel
     * @param HihokenshaDaichoHakkoListPanel HihokenshaDaichoHakkoListPanel
     */
    @JsonProperty("HihokenshaDaichoHakkoListPanel")
    public void setHihokenshaDaichoHakkoListPanel(HihokenshaDaichoHakkoListPanelDiv HihokenshaDaichoHakkoListPanel) {
        this.HihokenshaDaichoHakkoListPanel = HihokenshaDaichoHakkoListPanel;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
