package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YoshikiyonMeisai")
    private YoshikiyonMeisaiDiv YoshikiyonMeisai;
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYoshikiyonMeisai
     * @return YoshikiyonMeisai
     */
    @JsonProperty("YoshikiyonMeisai")
    public YoshikiyonMeisaiDiv getYoshikiyonMeisai() {
        return YoshikiyonMeisai;
    }

    /*
     * setYoshikiyonMeisai
     * @param YoshikiyonMeisai YoshikiyonMeisai
     */
    @JsonProperty("YoshikiyonMeisai")
    public void setYoshikiyonMeisai(YoshikiyonMeisaiDiv YoshikiyonMeisai) {
        this.YoshikiyonMeisai = YoshikiyonMeisai;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtHoukokuY() {
        return this.getYoshikiyonMeisai().getPanelHihokensyabango().getTxtHoukokuY();
    }

    @JsonIgnore
    public void  setTxtHoukokuY(TextBoxDate txtHoukokuY) {
        this.getYoshikiyonMeisai().getPanelHihokensyabango().setTxtHoukokuY(txtHoukokuY);
    }

    @JsonIgnore
    public TextBoxDate getTxtShukeiY() {
        return this.getYoshikiyonMeisai().getPanelHihokensyabango().getTxtShukeiY();
    }

    @JsonIgnore
    public void  setTxtShukeiY(TextBoxDate txtShukeiY) {
        this.getYoshikiyonMeisai().getPanelHihokensyabango().setTxtShukeiY(txtShukeiY);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshabango() {
        return this.getYoshikiyonMeisai().getPanelHihokensyabango().getTxtHihokenshabango();
    }

    @JsonIgnore
    public void  setTxtHihokenshabango(TextBoxCode txtHihokenshabango) {
        this.getYoshikiyonMeisai().getPanelHihokensyabango().setTxtHihokenshabango(txtHihokenshabango);
    }

    @JsonIgnore
    public TextBox getTxthihokenshamei() {
        return this.getYoshikiyonMeisai().getPanelHihokensyabango().getTxthihokenshamei();
    }

    @JsonIgnore
    public void  setTxthihokenshamei(TextBox txthihokenshamei) {
        this.getYoshikiyonMeisai().getPanelHihokensyabango().setTxthihokenshamei(txthihokenshamei);
    }

    @JsonIgnore
    public DropDownList getDdlShicyoson() {
        return this.getYoshikiyonMeisai().getPanelHihokensyabango().getDdlShicyoson();
    }

    @JsonIgnore
    public void  setDdlShicyoson(DropDownList ddlShicyoson) {
        this.getYoshikiyonMeisai().getPanelHihokensyabango().setDdlShicyoson(ddlShicyoson);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getYoshikiyonMeisai().getPanelHihokensyabango().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getYoshikiyonMeisai().getPanelHihokensyabango().setBtnKakutei(btnKakutei);
    }

    // </editor-fold>
}
