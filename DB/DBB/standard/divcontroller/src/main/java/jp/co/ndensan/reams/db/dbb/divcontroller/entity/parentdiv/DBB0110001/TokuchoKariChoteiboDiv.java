package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * TokuchoKariChoteibo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoKariChoteiboDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChoteiboFromDate")
    private Label lblChoteiboFromDate;
    @JsonProperty("lblChoteiboFromTime")
    private Label lblChoteiboFromTime;
    @JsonProperty("txtChoteiboFromDate")
    private TextBoxDate txtChoteiboFromDate;
    @JsonProperty("txtChoteiboFromTime")
    private TextBoxTime txtChoteiboFromTime;
    @JsonProperty("lblChoteboTo")
    private Label lblChoteboTo;
    @JsonProperty("ShutsuryokuJunTokuchoKariChoteibo")
    private ChohyoShutsuryokujunDiv ShutsuryokuJunTokuchoKariChoteibo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblChoteiboFromDate")
    public Label getLblChoteiboFromDate() {
        return lblChoteiboFromDate;
    }

    @JsonProperty("lblChoteiboFromDate")
    public void setLblChoteiboFromDate(Label lblChoteiboFromDate) {
        this.lblChoteiboFromDate=lblChoteiboFromDate;
    }

    @JsonProperty("lblChoteiboFromTime")
    public Label getLblChoteiboFromTime() {
        return lblChoteiboFromTime;
    }

    @JsonProperty("lblChoteiboFromTime")
    public void setLblChoteiboFromTime(Label lblChoteiboFromTime) {
        this.lblChoteiboFromTime=lblChoteiboFromTime;
    }

    @JsonProperty("txtChoteiboFromDate")
    public TextBoxDate getTxtChoteiboFromDate() {
        return txtChoteiboFromDate;
    }

    @JsonProperty("txtChoteiboFromDate")
    public void setTxtChoteiboFromDate(TextBoxDate txtChoteiboFromDate) {
        this.txtChoteiboFromDate=txtChoteiboFromDate;
    }

    @JsonProperty("txtChoteiboFromTime")
    public TextBoxTime getTxtChoteiboFromTime() {
        return txtChoteiboFromTime;
    }

    @JsonProperty("txtChoteiboFromTime")
    public void setTxtChoteiboFromTime(TextBoxTime txtChoteiboFromTime) {
        this.txtChoteiboFromTime=txtChoteiboFromTime;
    }

    @JsonProperty("lblChoteboTo")
    public Label getLblChoteboTo() {
        return lblChoteboTo;
    }

    @JsonProperty("lblChoteboTo")
    public void setLblChoteboTo(Label lblChoteboTo) {
        this.lblChoteboTo=lblChoteboTo;
    }

    @JsonProperty("ShutsuryokuJunTokuchoKariChoteibo")
    public IChohyoShutsuryokujunDiv getShutsuryokuJunTokuchoKariChoteibo() {
        return ShutsuryokuJunTokuchoKariChoteibo;
    }

    // </editor-fold>
}
