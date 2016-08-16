package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JikoFutangakuKeisanIkkatsuBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuKeisanIkkatsuBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutangakuKeisanChushutsuJokenPanel")
    private JikoFutangakuKeisanChushutsuJokenPanelDiv JikoFutangakuKeisanChushutsuJokenPanel;
    @JsonProperty("JikoFutangakuKeisanKekkaIchiranhyoPanelPublish")
    private JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv JikoFutangakuKeisanKekkaIchiranhyoPanelPublish;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutangakuKeisanChushutsuJokenPanel
     * @return JikoFutangakuKeisanChushutsuJokenPanel
     */
    @JsonProperty("JikoFutangakuKeisanChushutsuJokenPanel")
    public JikoFutangakuKeisanChushutsuJokenPanelDiv getJikoFutangakuKeisanChushutsuJokenPanel() {
        return JikoFutangakuKeisanChushutsuJokenPanel;
    }

    /*
     * setJikoFutangakuKeisanChushutsuJokenPanel
     * @param JikoFutangakuKeisanChushutsuJokenPanel JikoFutangakuKeisanChushutsuJokenPanel
     */
    @JsonProperty("JikoFutangakuKeisanChushutsuJokenPanel")
    public void setJikoFutangakuKeisanChushutsuJokenPanel(JikoFutangakuKeisanChushutsuJokenPanelDiv JikoFutangakuKeisanChushutsuJokenPanel) {
        this.JikoFutangakuKeisanChushutsuJokenPanel = JikoFutangakuKeisanChushutsuJokenPanel;
    }

    /*
     * getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     * @return JikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     */
    @JsonProperty("JikoFutangakuKeisanKekkaIchiranhyoPanelPublish")
    public JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish() {
        return JikoFutangakuKeisanKekkaIchiranhyoPanelPublish;
    }

    /*
     * setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     * @param JikoFutangakuKeisanKekkaIchiranhyoPanelPublish JikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     */
    @JsonProperty("JikoFutangakuKeisanKekkaIchiranhyoPanelPublish")
    public void setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish(JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv JikoFutangakuKeisanKekkaIchiranhyoPanelPublish) {
        this.JikoFutangakuKeisanKekkaIchiranhyoPanelPublish = JikoFutangakuKeisanKekkaIchiranhyoPanelPublish;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtZenkaiTaishoYMD() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getTxtZenkaiTaishoYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiTaishoYMD(TextBoxDateRange txtZenkaiTaishoYMD) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().setTxtZenkaiTaishoYMD(txtZenkaiTaishoYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiTaishoYMD() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getTxtShinseiTaishoYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiTaishoYMD(TextBoxDateRange txtShinseiTaishoYMD) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().setTxtShinseiTaishoYMD(txtShinseiTaishoYMD);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
