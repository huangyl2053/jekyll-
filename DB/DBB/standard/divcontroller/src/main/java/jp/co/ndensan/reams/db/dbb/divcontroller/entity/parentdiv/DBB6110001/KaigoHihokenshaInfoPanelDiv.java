package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoHihokenshaInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoHihokenshaInfoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoHihokenshaInfo")
    private KaigoHihokenshaInfoDiv KaigoHihokenshaInfo;
    @JsonProperty("RentaiGimushaIchiran")
    private RentaiGimushaIchiranDiv RentaiGimushaIchiran;
    @JsonProperty("SetaiIchiran")
    private SetaiIchiranDiv SetaiIchiran;
    @JsonProperty("RentaiNofuGimushaInfo")
    private RentaiNofuGimushaInfoDiv RentaiNofuGimushaInfo;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;
    @JsonProperty("txtDialog")
    private RString txtDialog;
    @JsonProperty("txtGyomuCode")
    private RString txtGyomuCode;
    @JsonProperty("txtSearchYusenKubun")
    private RString txtSearchYusenKubun;
    @JsonProperty("txtAgeArrivalDay")
    private RString txtAgeArrivalDay;
    @JsonProperty("txtOutShikibetsuCode")
    private RString txtOutShikibetsuCode;
    @JsonProperty("txtOutSetaiCode")
    private RString txtOutSetaiCode;
    @JsonProperty("hdnFlag")
    private RString hdnFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoHihokenshaInfo
     * @return KaigoHihokenshaInfo
     */
    @JsonProperty("KaigoHihokenshaInfo")
    public KaigoHihokenshaInfoDiv getKaigoHihokenshaInfo() {
        return KaigoHihokenshaInfo;
    }

    /*
     * setKaigoHihokenshaInfo
     * @param KaigoHihokenshaInfo KaigoHihokenshaInfo
     */
    @JsonProperty("KaigoHihokenshaInfo")
    public void setKaigoHihokenshaInfo(KaigoHihokenshaInfoDiv KaigoHihokenshaInfo) {
        this.KaigoHihokenshaInfo = KaigoHihokenshaInfo;
    }

    /*
     * getRentaiGimushaIchiran
     * @return RentaiGimushaIchiran
     */
    @JsonProperty("RentaiGimushaIchiran")
    public RentaiGimushaIchiranDiv getRentaiGimushaIchiran() {
        return RentaiGimushaIchiran;
    }

    /*
     * setRentaiGimushaIchiran
     * @param RentaiGimushaIchiran RentaiGimushaIchiran
     */
    @JsonProperty("RentaiGimushaIchiran")
    public void setRentaiGimushaIchiran(RentaiGimushaIchiranDiv RentaiGimushaIchiran) {
        this.RentaiGimushaIchiran = RentaiGimushaIchiran;
    }

    /*
     * getSetaiIchiran
     * @return SetaiIchiran
     */
    @JsonProperty("SetaiIchiran")
    public SetaiIchiranDiv getSetaiIchiran() {
        return SetaiIchiran;
    }

    /*
     * setSetaiIchiran
     * @param SetaiIchiran SetaiIchiran
     */
    @JsonProperty("SetaiIchiran")
    public void setSetaiIchiran(SetaiIchiranDiv SetaiIchiran) {
        this.SetaiIchiran = SetaiIchiran;
    }

    /*
     * getRentaiNofuGimushaInfo
     * @return RentaiNofuGimushaInfo
     */
    @JsonProperty("RentaiNofuGimushaInfo")
    public RentaiNofuGimushaInfoDiv getRentaiNofuGimushaInfo() {
        return RentaiNofuGimushaInfo;
    }

    /*
     * setRentaiNofuGimushaInfo
     * @param RentaiNofuGimushaInfo RentaiNofuGimushaInfo
     */
    @JsonProperty("RentaiNofuGimushaInfo")
    public void setRentaiNofuGimushaInfo(RentaiNofuGimushaInfoDiv RentaiNofuGimushaInfo) {
        this.RentaiNofuGimushaInfo = RentaiNofuGimushaInfo;
    }

    /*
     * getKanryoMsg
     * @return KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public KanryoMsgDiv getKanryoMsg() {
        return KanryoMsg;
    }

    /*
     * setKanryoMsg
     * @param KanryoMsg KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public void setKanryoMsg(KanryoMsgDiv KanryoMsg) {
        this.KanryoMsg = KanryoMsg;
    }

    /*
     * gettxtDialog
     * @return txtDialog
     */
    @JsonProperty("txtDialog")
    public RString getTxtDialog() {
        return txtDialog;
    }

    /*
     * settxtDialog
     * @param txtDialog txtDialog
     */
    @JsonProperty("txtDialog")
    public void setTxtDialog(RString txtDialog) {
        this.txtDialog = txtDialog;
    }

    /*
     * gettxtGyomuCode
     * @return txtGyomuCode
     */
    @JsonProperty("txtGyomuCode")
    public RString getTxtGyomuCode() {
        return txtGyomuCode;
    }

    /*
     * settxtGyomuCode
     * @param txtGyomuCode txtGyomuCode
     */
    @JsonProperty("txtGyomuCode")
    public void setTxtGyomuCode(RString txtGyomuCode) {
        this.txtGyomuCode = txtGyomuCode;
    }

    /*
     * gettxtSearchYusenKubun
     * @return txtSearchYusenKubun
     */
    @JsonProperty("txtSearchYusenKubun")
    public RString getTxtSearchYusenKubun() {
        return txtSearchYusenKubun;
    }

    /*
     * settxtSearchYusenKubun
     * @param txtSearchYusenKubun txtSearchYusenKubun
     */
    @JsonProperty("txtSearchYusenKubun")
    public void setTxtSearchYusenKubun(RString txtSearchYusenKubun) {
        this.txtSearchYusenKubun = txtSearchYusenKubun;
    }

    /*
     * gettxtAgeArrivalDay
     * @return txtAgeArrivalDay
     */
    @JsonProperty("txtAgeArrivalDay")
    public RString getTxtAgeArrivalDay() {
        return txtAgeArrivalDay;
    }

    /*
     * settxtAgeArrivalDay
     * @param txtAgeArrivalDay txtAgeArrivalDay
     */
    @JsonProperty("txtAgeArrivalDay")
    public void setTxtAgeArrivalDay(RString txtAgeArrivalDay) {
        this.txtAgeArrivalDay = txtAgeArrivalDay;
    }

    /*
     * gettxtOutShikibetsuCode
     * @return txtOutShikibetsuCode
     */
    @JsonProperty("txtOutShikibetsuCode")
    public RString getTxtOutShikibetsuCode() {
        return txtOutShikibetsuCode;
    }

    /*
     * settxtOutShikibetsuCode
     * @param txtOutShikibetsuCode txtOutShikibetsuCode
     */
    @JsonProperty("txtOutShikibetsuCode")
    public void setTxtOutShikibetsuCode(RString txtOutShikibetsuCode) {
        this.txtOutShikibetsuCode = txtOutShikibetsuCode;
    }

    /*
     * gettxtOutSetaiCode
     * @return txtOutSetaiCode
     */
    @JsonProperty("txtOutSetaiCode")
    public RString getTxtOutSetaiCode() {
        return txtOutSetaiCode;
    }

    /*
     * settxtOutSetaiCode
     * @param txtOutSetaiCode txtOutSetaiCode
     */
    @JsonProperty("txtOutSetaiCode")
    public void setTxtOutSetaiCode(RString txtOutSetaiCode) {
        this.txtOutSetaiCode = txtOutSetaiCode;
    }

    /*
     * gethdnFlag
     * @return hdnFlag
     */
    @JsonProperty("hdnFlag")
    public RString getHdnFlag() {
        return hdnFlag;
    }

    /*
     * sethdnFlag
     * @param hdnFlag hdnFlag
     */
    @JsonProperty("hdnFlag")
    public void setHdnFlag(RString hdnFlag) {
        this.hdnFlag = hdnFlag;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoFukaKihonDiv getCcdKaigoFukaKihon() {
        return this.getKaigoHihokenshaInfo().getCcdKaigoFukaKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getKaigoHihokenshaInfo().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public Button getBtnAdd() {
        return this.getRentaiGimushaIchiran().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getRentaiGimushaIchiran().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgRentaiNofuGimushaIchiran_Row> getDgRentaiNofuGimushaIchiran() {
        return this.getRentaiGimushaIchiran().getDgRentaiNofuGimushaIchiran();
    }

    @JsonIgnore
    public void  setDgRentaiNofuGimushaIchiran(DataGrid<dgRentaiNofuGimushaIchiran_Row> dgRentaiNofuGimushaIchiran) {
        this.getRentaiGimushaIchiran().setDgRentaiNofuGimushaIchiran(dgRentaiNofuGimushaIchiran);
    }

    @JsonIgnore
    public DataGrid<dgSetaiIchiran_Row> getDgSetaiIchiran() {
        return this.getSetaiIchiran().getDgSetaiIchiran();
    }

    @JsonIgnore
    public void  setDgSetaiIchiran(DataGrid<dgSetaiIchiran_Row> dgSetaiIchiran) {
        this.getSetaiIchiran().setDgSetaiIchiran(dgSetaiIchiran);
    }

    @JsonIgnore
    public ButtonDialog getBtnRentaiNofuGimushaKensaku() {
        return this.getSetaiIchiran().getBtnRentaiNofuGimushaKensaku();
    }

    @JsonIgnore
    public void  setBtnRentaiNofuGimushaKensaku(ButtonDialog btnRentaiNofuGimushaKensaku) {
        this.getSetaiIchiran().setBtnRentaiNofuGimushaKensaku(btnRentaiNofuGimushaKensaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishiYMD() {
        return this.getRentaiNofuGimushaInfo().getTxtKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.getRentaiNofuGimushaInfo().setTxtKaishiYMD(txtKaishiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShuryoYMD() {
        return this.getRentaiNofuGimushaInfo().getTxtShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtShuryoYMD(TextBoxDate txtShuryoYMD) {
        this.getRentaiNofuGimushaInfo().setTxtShuryoYMD(txtShuryoYMD);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getRentaiNofuGimushaInfo().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getRentaiNofuGimushaInfo().setLin1(lin1);
    }

    @JsonIgnore
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return this.getRentaiNofuGimushaInfo().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.getRentaiNofuGimushaInfo().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBoxSetaiCode getTxtSetaiCode() {
        return this.getRentaiNofuGimushaInfo().getTxtSetaiCode();
    }

    @JsonIgnore
    public void  setTxtSetaiCode(TextBoxSetaiCode txtSetaiCode) {
        this.getRentaiNofuGimushaInfo().setTxtSetaiCode(txtSetaiCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareYMD() {
        return this.getRentaiNofuGimushaInfo().getTxtUmareYMD();
    }

    @JsonIgnore
    public void  setTxtUmareYMD(TextBoxDate txtUmareYMD) {
        this.getRentaiNofuGimushaInfo().setTxtUmareYMD(txtUmareYMD);
    }

    @JsonIgnore
    public TextBox getTxtJuminShu() {
        return this.getRentaiNofuGimushaInfo().getTxtJuminShu();
    }

    @JsonIgnore
    public void  setTxtJuminShu(TextBox txtJuminShu) {
        this.getRentaiNofuGimushaInfo().setTxtJuminShu(txtJuminShu);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getRentaiNofuGimushaInfo().getTxtShimei();
    }

    @JsonIgnore
    public void  setTxtShimei(TextBox txtShimei) {
        this.getRentaiNofuGimushaInfo().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBox getTxtSeibetsu() {
        return this.getRentaiNofuGimushaInfo().getTxtSeibetsu();
    }

    @JsonIgnore
    public void  setTxtSeibetsu(TextBox txtSeibetsu) {
        this.getRentaiNofuGimushaInfo().setTxtSeibetsu(txtSeibetsu);
    }

    @JsonIgnore
    public TextBox getTxtZokuGara() {
        return this.getRentaiNofuGimushaInfo().getTxtZokuGara();
    }

    @JsonIgnore
    public void  setTxtZokuGara(TextBox txtZokuGara) {
        this.getRentaiNofuGimushaInfo().setTxtZokuGara(txtZokuGara);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getRentaiNofuGimushaInfo().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getRentaiNofuGimushaInfo().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBox getTxtRirekiNo() {
        return this.getRentaiNofuGimushaInfo().getTxtRirekiNo();
    }

    @JsonIgnore
    public void  setTxtRirekiNo(TextBox txtRirekiNo) {
        this.getRentaiNofuGimushaInfo().setTxtRirekiNo(txtRirekiNo);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getRentaiNofuGimushaInfo().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getRentaiNofuGimushaInfo().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getRentaiNofuGimushaInfo().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getRentaiNofuGimushaInfo().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKiagoKanryoMessage() {
        return this.getKanryoMsg().getCcdKiagoKanryoMessage();
    }

    // </editor-fold>
}
