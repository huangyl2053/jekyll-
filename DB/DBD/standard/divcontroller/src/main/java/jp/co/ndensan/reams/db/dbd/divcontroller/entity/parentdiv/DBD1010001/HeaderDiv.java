package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.IShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetSunyushoInfo.ShisetSunyushoInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Header のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeaderDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("HosokuJoho")
    private HosokuJohoDiv HosokuJoho;
    @JsonProperty("Dialogs")
    private DialogsDiv Dialogs;
    @JsonProperty("ccdShisetsuNyushoInfo")
    private ShisetSunyushoInfoDiv ccdShisetsuNyushoInfo;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getHosokuJoho
     * @return HosokuJoho
     */
    @JsonProperty("HosokuJoho")
    public HosokuJohoDiv getHosokuJoho() {
        return HosokuJoho;
    }

    /*
     * setHosokuJoho
     * @param HosokuJoho HosokuJoho
     */
    @JsonProperty("HosokuJoho")
    public void setHosokuJoho(HosokuJohoDiv HosokuJoho) {
        this.HosokuJoho = HosokuJoho;
    }

    /*
     * getDialogs
     * @return Dialogs
     */
    @JsonProperty("Dialogs")
    public DialogsDiv getDialogs() {
        return Dialogs;
    }

    /*
     * setDialogs
     * @param Dialogs Dialogs
     */
    @JsonProperty("Dialogs")
    public void setDialogs(DialogsDiv Dialogs) {
        this.Dialogs = Dialogs;
    }

    /*
     * getccdShisetsuNyushoInfo
     * @return ccdShisetsuNyushoInfo
     */
    @JsonProperty("ccdShisetsuNyushoInfo")
    public IShisetSunyushoInfoDiv getCcdShisetsuNyushoInfo() {
        return ccdShisetsuNyushoInfo;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtRiyoshaFutanDankai() {
        return this.getHosokuJoho().getTxtRiyoshaFutanDankai();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanDankai(TextBox txtRiyoshaFutanDankai) {
        this.getHosokuJoho().setTxtRiyoshaFutanDankai(txtRiyoshaFutanDankai);
    }

    @JsonIgnore
    public Button getBtnDispSetaiJoho() {
        return this.getHosokuJoho().getBtnDispSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnDispSetaiJoho(Button btnDispSetaiJoho) {
        this.getHosokuJoho().setBtnDispSetaiJoho(btnDispSetaiJoho);
    }

    @JsonIgnore
    public Button getBtnCloseSetaiJoho() {
        return this.getHosokuJoho().getBtnCloseSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.getHosokuJoho().setBtnCloseSetaiJoho(btnCloseSetaiJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnDispShisetsuJoho() {
        return this.getDialogs().getBtnDispShisetsuJoho();
    }

    @JsonIgnore
    public void  setBtnDispShisetsuJoho(ButtonDialog btnDispShisetsuJoho) {
        this.getDialogs().setBtnDispShisetsuJoho(btnDispShisetsuJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnDispGemmenJoho() {
        return this.getDialogs().getBtnDispGemmenJoho();
    }

    @JsonIgnore
    public void  setBtnDispGemmenJoho(ButtonDialog btnDispGemmenJoho) {
        this.getDialogs().setBtnDispGemmenJoho(btnDispGemmenJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnHikazeiNenkinSho() {
        return this.getDialogs().getBtnHikazeiNenkinSho();
    }

    @JsonIgnore
    public void  setBtnHikazeiNenkinSho(ButtonDialog btnHikazeiNenkinSho) {
        this.getDialogs().setBtnHikazeiNenkinSho(btnHikazeiNenkinSho);
    }

    // </editor-fold>
}
