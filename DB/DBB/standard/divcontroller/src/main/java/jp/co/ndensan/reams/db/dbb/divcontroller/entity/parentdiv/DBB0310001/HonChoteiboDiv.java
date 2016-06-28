package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * HonChoteibo のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonChoteiboDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiboFromDate")
    private TextBoxDate txtChoteiboFromDate;
    @JsonProperty("txtChoteiboFromTime")
    private TextBoxTime txtChoteiboFromTime;
    @JsonProperty("lblChoteboTo")
    private Label lblChoteboTo;
    @JsonProperty("ShutsuryokuJunHonChoteibo")
    private ChohyoShutsuryokujunDiv ShutsuryokuJunHonChoteibo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiboFromDate
     * @return txtChoteiboFromDate
     */
    @JsonProperty("txtChoteiboFromDate")
    public TextBoxDate getTxtChoteiboFromDate() {
        return txtChoteiboFromDate;
    }

    /*
     * settxtChoteiboFromDate
     * @param txtChoteiboFromDate txtChoteiboFromDate
     */
    @JsonProperty("txtChoteiboFromDate")
    public void setTxtChoteiboFromDate(TextBoxDate txtChoteiboFromDate) {
        this.txtChoteiboFromDate = txtChoteiboFromDate;
    }

    /*
     * gettxtChoteiboFromTime
     * @return txtChoteiboFromTime
     */
    @JsonProperty("txtChoteiboFromTime")
    public TextBoxTime getTxtChoteiboFromTime() {
        return txtChoteiboFromTime;
    }

    /*
     * settxtChoteiboFromTime
     * @param txtChoteiboFromTime txtChoteiboFromTime
     */
    @JsonProperty("txtChoteiboFromTime")
    public void setTxtChoteiboFromTime(TextBoxTime txtChoteiboFromTime) {
        this.txtChoteiboFromTime = txtChoteiboFromTime;
    }

    /*
     * getlblChoteboTo
     * @return lblChoteboTo
     */
    @JsonProperty("lblChoteboTo")
    public Label getLblChoteboTo() {
        return lblChoteboTo;
    }

    /*
     * setlblChoteboTo
     * @param lblChoteboTo lblChoteboTo
     */
    @JsonProperty("lblChoteboTo")
    public void setLblChoteboTo(Label lblChoteboTo) {
        this.lblChoteboTo = lblChoteboTo;
    }

    /*
     * getShutsuryokuJunHonChoteibo
     * @return ShutsuryokuJunHonChoteibo
     */
    @JsonProperty("ShutsuryokuJunHonChoteibo")
    public IChohyoShutsuryokujunDiv getShutsuryokuJunHonChoteibo() {
        return ShutsuryokuJunHonChoteibo;
    }

    // </editor-fold>
}
