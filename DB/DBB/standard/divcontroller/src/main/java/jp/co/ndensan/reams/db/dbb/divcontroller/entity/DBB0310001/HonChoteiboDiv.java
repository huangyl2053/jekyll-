package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
//import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonChoteibo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonChoteiboDiv extends PanelPublish {
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
//    @JsonProperty("ShutsuryokuJunHonChoteibo")
//    private ChohyoShutsuryokujunDiv ShutsuryokuJunHonChoteibo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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

//    @JsonProperty("ShutsuryokuJunHonChoteibo")
//    public ChohyoShutsuryokujunDiv getShutsuryokuJunHonChoteibo() {
//        return ShutsuryokuJunHonChoteibo;
//    }
//
//    @JsonProperty("ShutsuryokuJunHonChoteibo")
//    public void setShutsuryokuJunHonChoteibo(ChohyoShutsuryokujunDiv ShutsuryokuJunHonChoteibo) {
//        this.ShutsuryokuJunHonChoteibo=ShutsuryokuJunHonChoteibo;
//    }

}
