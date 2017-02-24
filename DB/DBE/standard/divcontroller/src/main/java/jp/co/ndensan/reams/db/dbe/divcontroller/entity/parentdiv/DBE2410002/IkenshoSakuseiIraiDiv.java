package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoSakuseiIrai のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoSakuseiIraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    private IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel;
    @JsonProperty("IkenshoIraiPrint")
    private IkenshoIraiPrintDiv IkenshoIraiPrint;
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihonInfo;
    @JsonProperty("KanryoMessage")
    private KaigoKanryoMessageDiv KanryoMessage;
    @JsonProperty("ikenshoIraiRirekiNo")
    private RString ikenshoIraiRirekiNo;
    @JsonProperty("hiddenIuputModel")
    private RString hiddenIuputModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIkenshoIraiTorokuPanel
     * @return IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public IkenshoIraiTorokuPanelDiv getIkenshoIraiTorokuPanel() {
        return IkenshoIraiTorokuPanel;
    }

    /*
     * setIkenshoIraiTorokuPanel
     * @param IkenshoIraiTorokuPanel IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public void setIkenshoIraiTorokuPanel(IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel) {
        this.IkenshoIraiTorokuPanel = IkenshoIraiTorokuPanel;
    }

    /*
     * getIkenshoIraiPrint
     * @return IkenshoIraiPrint
     */
    @JsonProperty("IkenshoIraiPrint")
    public IkenshoIraiPrintDiv getIkenshoIraiPrint() {
        return IkenshoIraiPrint;
    }

    /*
     * setIkenshoIraiPrint
     * @param IkenshoIraiPrint IkenshoIraiPrint
     */
    @JsonProperty("IkenshoIraiPrint")
    public void setIkenshoIraiPrint(IkenshoIraiPrintDiv IkenshoIraiPrint) {
        this.IkenshoIraiPrint = IkenshoIraiPrint;
    }

    /*
     * getccdNinteiShinseishaKihonInfo
     * @return ccdNinteiShinseishaKihonInfo
     */
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return ccdNinteiShinseishaKihonInfo;
    }

    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public IKaigoKanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * getikenshoIraiRirekiNo
     * @return ikenshoIraiRirekiNo
     */
    @JsonProperty("ikenshoIraiRirekiNo")
    public RString getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /*
     * setikenshoIraiRirekiNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     */
    @JsonProperty("ikenshoIraiRirekiNo")
    public void setIkenshoIraiRirekiNo(RString ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /*
     * gethiddenIuputModel
     * @return hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public RString getHiddenIuputModel() {
        return hiddenIuputModel;
    }

    /*
     * sethiddenIuputModel
     * @param hiddenIuputModel hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public void setHiddenIuputModel(RString hiddenIuputModel) {
        this.hiddenIuputModel = hiddenIuputModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlIraiKubun() {
        return this.getIkenshoIraiTorokuPanel().getDdlIraiKubun();
    }

    @JsonIgnore
    public void  setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.getIkenshoIraiTorokuPanel().setDdlIraiKubun(ddlIraiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiIraiD() {
        return this.getIkenshoIraiTorokuPanel().getTxtSakuseiIraiD();
    }

    @JsonIgnore
    public void  setTxtSakuseiIraiD(TextBoxDate txtSakuseiIraiD) {
        this.getIkenshoIraiTorokuPanel().setTxtSakuseiIraiD(txtSakuseiIraiD);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiInput() {
        return this.getIkenshoIraiTorokuPanel().getCcdShujiiInput();
    }

    @JsonIgnore
    public ButtonDialog getBtnPrint() {
        return this.getIkenshoIraiPrint().getBtnPrint();
    }

    @JsonIgnore
    public void  setBtnPrint(ButtonDialog btnPrint) {
        this.getIkenshoIraiPrint().setBtnPrint(btnPrint);
    }

    // </editor-fold>
}
