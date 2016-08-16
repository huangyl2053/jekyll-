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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC1120011Panel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC1120011PanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutangakuKeisanIkkatsuBatchParameter")
    private JikoFutangakuKeisanIkkatsuBatchParameterDiv JikoFutangakuKeisanIkkatsuBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutangakuKeisanIkkatsuBatchParameter
     * @return JikoFutangakuKeisanIkkatsuBatchParameter
     */
    @JsonProperty("JikoFutangakuKeisanIkkatsuBatchParameter")
    public JikoFutangakuKeisanIkkatsuBatchParameterDiv getJikoFutangakuKeisanIkkatsuBatchParameter() {
        return JikoFutangakuKeisanIkkatsuBatchParameter;
    }

    /*
     * setJikoFutangakuKeisanIkkatsuBatchParameter
     * @param JikoFutangakuKeisanIkkatsuBatchParameter JikoFutangakuKeisanIkkatsuBatchParameter
     */
    @JsonProperty("JikoFutangakuKeisanIkkatsuBatchParameter")
    public void setJikoFutangakuKeisanIkkatsuBatchParameter(JikoFutangakuKeisanIkkatsuBatchParameterDiv JikoFutangakuKeisanIkkatsuBatchParameter) {
        this.JikoFutangakuKeisanIkkatsuBatchParameter = JikoFutangakuKeisanIkkatsuBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JikoFutangakuKeisanChushutsuJokenPanelDiv getJikoFutangakuKeisanChushutsuJokenPanel() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel();
    }

    @JsonIgnore
    public void  setJikoFutangakuKeisanChushutsuJokenPanel(JikoFutangakuKeisanChushutsuJokenPanelDiv JikoFutangakuKeisanChushutsuJokenPanel) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().setJikoFutangakuKeisanChushutsuJokenPanel(JikoFutangakuKeisanChushutsuJokenPanel);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtZenkaiTaishoYMD() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTxtZenkaiTaishoYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiTaishoYMD(TextBoxDateRange txtZenkaiTaishoYMD) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().setTxtZenkaiTaishoYMD(txtZenkaiTaishoYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseiTaishoYMD() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTxtShinseiTaishoYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiTaishoYMD(TextBoxDateRange txtShinseiTaishoYMD) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().setTxtShinseiTaishoYMD(txtShinseiTaishoYMD);
    }

    @JsonIgnore
    public JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish();
    }

    @JsonIgnore
    public void  setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish(JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv JikoFutangakuKeisanKekkaIchiranhyoPanelPublish) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish(JikoFutangakuKeisanKekkaIchiranhyoPanelPublish);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
