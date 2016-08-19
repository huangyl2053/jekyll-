package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShokkenTorikeshiIchibuNintei のクラスファイル
 *
 * @author 自動生成
 */
public class ShokkenTorikeshiIchibuNinteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ButtonArea")
    private ButtonAreaDiv ButtonArea;
    @JsonProperty("ShujiiIryokikanAndShujii")
    private ShujiiIryokikanAndShujiiDiv ShujiiIryokikanAndShujii;
    @JsonProperty("ChosaItakusakiAndChosain")
    private ChosaItakusakiAndChosainDiv ChosaItakusakiAndChosain;
    @JsonProperty("RirekiNintei")
    private RirekiNinteiDiv RirekiNintei;
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("ccdKaigoNinteiShinseiKihonJohoInput")
    private KaigoNinteiShinseiKihonJohoInputDiv ccdKaigoNinteiShinseiKihonJohoInput;
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdKaigoNinteiShikakuInfo;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;
    @JsonProperty("ccdShinseiTodokedesha")
    private NinteiShinseiTodokedeshaDiv ccdShinseiTodokedesha;
    @JsonProperty("hdnZenkaiSerializedBusiness")
    private RString hdnZenkaiSerializedBusiness;
    @JsonProperty("hdnKonkaiSerializedBusiness")
    private RString hdnKonkaiSerializedBusiness;
    @JsonProperty("hdnDisplayModeKey")
    private RString hdnDisplayModeKey;
    @JsonProperty("hdnKekkaShosaiJohoOutModel")
    private RString hdnKekkaShosaiJohoOutModel;
    @JsonProperty("hdnYokaigodoCodeZenkai")
    private RString hdnYokaigodoCodeZenkai;
    @JsonProperty("hdnYokaigodoCodeKonkai")
    private RString hdnYokaigodoCodeKonkai;
    @JsonProperty("hdnShichosonRenrakuJiko")
    private RString hdnShichosonRenrakuJiko;
    @JsonProperty("hdnRenrakusakiJoho")
    private RString hdnRenrakusakiJoho;
    @JsonProperty("hdnRenrakusakiReadOnly")
    private RString hdnRenrakusakiReadOnly;
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    private RString hdnZenkaiRenrakusakiJoho;
    @JsonProperty("hdnRenrakuJiko")
    private RString hdnRenrakuJiko;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;
    @JsonProperty("hdnSyokikaMode")
    private RString hdnSyokikaMode;
    @JsonProperty("hdnShokikomoku")
    private RString hdnShokikomoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getButtonArea
     * @return ButtonArea
     */
    @JsonProperty("ButtonArea")
    public ButtonAreaDiv getButtonArea() {
        return ButtonArea;
    }

    /*
     * setButtonArea
     * @param ButtonArea ButtonArea
     */
    @JsonProperty("ButtonArea")
    public void setButtonArea(ButtonAreaDiv ButtonArea) {
        this.ButtonArea = ButtonArea;
    }

    /*
     * getShujiiIryokikanAndShujii
     * @return ShujiiIryokikanAndShujii
     */
    @JsonProperty("ShujiiIryokikanAndShujii")
    public ShujiiIryokikanAndShujiiDiv getShujiiIryokikanAndShujii() {
        return ShujiiIryokikanAndShujii;
    }

    /*
     * setShujiiIryokikanAndShujii
     * @param ShujiiIryokikanAndShujii ShujiiIryokikanAndShujii
     */
    @JsonProperty("ShujiiIryokikanAndShujii")
    public void setShujiiIryokikanAndShujii(ShujiiIryokikanAndShujiiDiv ShujiiIryokikanAndShujii) {
        this.ShujiiIryokikanAndShujii = ShujiiIryokikanAndShujii;
    }

    /*
     * getChosaItakusakiAndChosain
     * @return ChosaItakusakiAndChosain
     */
    @JsonProperty("ChosaItakusakiAndChosain")
    public ChosaItakusakiAndChosainDiv getChosaItakusakiAndChosain() {
        return ChosaItakusakiAndChosain;
    }

    /*
     * setChosaItakusakiAndChosain
     * @param ChosaItakusakiAndChosain ChosaItakusakiAndChosain
     */
    @JsonProperty("ChosaItakusakiAndChosain")
    public void setChosaItakusakiAndChosain(ChosaItakusakiAndChosainDiv ChosaItakusakiAndChosain) {
        this.ChosaItakusakiAndChosain = ChosaItakusakiAndChosain;
    }

    /*
     * getRirekiNintei
     * @return RirekiNintei
     */
    @JsonProperty("RirekiNintei")
    public RirekiNinteiDiv getRirekiNintei() {
        return RirekiNintei;
    }

    /*
     * setRirekiNintei
     * @param RirekiNintei RirekiNintei
     */
    @JsonProperty("RirekiNintei")
    public void setRirekiNintei(RirekiNinteiDiv RirekiNintei) {
        this.RirekiNintei = RirekiNintei;
    }

    /*
     * getccdKaigoNinteiAtenaInfo
     * @return ccdKaigoNinteiAtenaInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
    }

    /*
     * getccdKaigoNinteiShinseiKihonJohoInput
     * @return ccdKaigoNinteiShinseiKihonJohoInput
     */
    @JsonProperty("ccdKaigoNinteiShinseiKihonJohoInput")
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihonJohoInput() {
        return ccdKaigoNinteiShinseiKihonJohoInput;
    }

    /*
     * getccdKaigoNinteiShikakuInfo
     * @return ccdKaigoNinteiShikakuInfo
     */
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    public IKaigoninteiShikakuInfoDiv getCcdKaigoNinteiShikakuInfo() {
        return ccdKaigoNinteiShikakuInfo;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * getccdShinseiTodokedesha
     * @return ccdShinseiTodokedesha
     */
    @JsonProperty("ccdShinseiTodokedesha")
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return ccdShinseiTodokedesha;
    }

    /*
     * gethdnZenkaiSerializedBusiness
     * @return hdnZenkaiSerializedBusiness
     */
    @JsonProperty("hdnZenkaiSerializedBusiness")
    public RString getHdnZenkaiSerializedBusiness() {
        return hdnZenkaiSerializedBusiness;
    }

    /*
     * sethdnZenkaiSerializedBusiness
     * @param hdnZenkaiSerializedBusiness hdnZenkaiSerializedBusiness
     */
    @JsonProperty("hdnZenkaiSerializedBusiness")
    public void setHdnZenkaiSerializedBusiness(RString hdnZenkaiSerializedBusiness) {
        this.hdnZenkaiSerializedBusiness = hdnZenkaiSerializedBusiness;
    }

    /*
     * gethdnKonkaiSerializedBusiness
     * @return hdnKonkaiSerializedBusiness
     */
    @JsonProperty("hdnKonkaiSerializedBusiness")
    public RString getHdnKonkaiSerializedBusiness() {
        return hdnKonkaiSerializedBusiness;
    }

    /*
     * sethdnKonkaiSerializedBusiness
     * @param hdnKonkaiSerializedBusiness hdnKonkaiSerializedBusiness
     */
    @JsonProperty("hdnKonkaiSerializedBusiness")
    public void setHdnKonkaiSerializedBusiness(RString hdnKonkaiSerializedBusiness) {
        this.hdnKonkaiSerializedBusiness = hdnKonkaiSerializedBusiness;
    }

    /*
     * gethdnDisplayModeKey
     * @return hdnDisplayModeKey
     */
    @JsonProperty("hdnDisplayModeKey")
    public RString getHdnDisplayModeKey() {
        return hdnDisplayModeKey;
    }

    /*
     * sethdnDisplayModeKey
     * @param hdnDisplayModeKey hdnDisplayModeKey
     */
    @JsonProperty("hdnDisplayModeKey")
    public void setHdnDisplayModeKey(RString hdnDisplayModeKey) {
        this.hdnDisplayModeKey = hdnDisplayModeKey;
    }

    /*
     * gethdnKekkaShosaiJohoOutModel
     * @return hdnKekkaShosaiJohoOutModel
     */
    @JsonProperty("hdnKekkaShosaiJohoOutModel")
    public RString getHdnKekkaShosaiJohoOutModel() {
        return hdnKekkaShosaiJohoOutModel;
    }

    /*
     * sethdnKekkaShosaiJohoOutModel
     * @param hdnKekkaShosaiJohoOutModel hdnKekkaShosaiJohoOutModel
     */
    @JsonProperty("hdnKekkaShosaiJohoOutModel")
    public void setHdnKekkaShosaiJohoOutModel(RString hdnKekkaShosaiJohoOutModel) {
        this.hdnKekkaShosaiJohoOutModel = hdnKekkaShosaiJohoOutModel;
    }

    /*
     * gethdnYokaigodoCodeZenkai
     * @return hdnYokaigodoCodeZenkai
     */
    @JsonProperty("hdnYokaigodoCodeZenkai")
    public RString getHdnYokaigodoCodeZenkai() {
        return hdnYokaigodoCodeZenkai;
    }

    /*
     * sethdnYokaigodoCodeZenkai
     * @param hdnYokaigodoCodeZenkai hdnYokaigodoCodeZenkai
     */
    @JsonProperty("hdnYokaigodoCodeZenkai")
    public void setHdnYokaigodoCodeZenkai(RString hdnYokaigodoCodeZenkai) {
        this.hdnYokaigodoCodeZenkai = hdnYokaigodoCodeZenkai;
    }

    /*
     * gethdnYokaigodoCodeKonkai
     * @return hdnYokaigodoCodeKonkai
     */
    @JsonProperty("hdnYokaigodoCodeKonkai")
    public RString getHdnYokaigodoCodeKonkai() {
        return hdnYokaigodoCodeKonkai;
    }

    /*
     * sethdnYokaigodoCodeKonkai
     * @param hdnYokaigodoCodeKonkai hdnYokaigodoCodeKonkai
     */
    @JsonProperty("hdnYokaigodoCodeKonkai")
    public void setHdnYokaigodoCodeKonkai(RString hdnYokaigodoCodeKonkai) {
        this.hdnYokaigodoCodeKonkai = hdnYokaigodoCodeKonkai;
    }

    /*
     * gethdnShichosonRenrakuJiko
     * @return hdnShichosonRenrakuJiko
     */
    @JsonProperty("hdnShichosonRenrakuJiko")
    public RString getHdnShichosonRenrakuJiko() {
        return hdnShichosonRenrakuJiko;
    }

    /*
     * sethdnShichosonRenrakuJiko
     * @param hdnShichosonRenrakuJiko hdnShichosonRenrakuJiko
     */
    @JsonProperty("hdnShichosonRenrakuJiko")
    public void setHdnShichosonRenrakuJiko(RString hdnShichosonRenrakuJiko) {
        this.hdnShichosonRenrakuJiko = hdnShichosonRenrakuJiko;
    }

    /*
     * gethdnRenrakusakiJoho
     * @return hdnRenrakusakiJoho
     */
    @JsonProperty("hdnRenrakusakiJoho")
    public RString getHdnRenrakusakiJoho() {
        return hdnRenrakusakiJoho;
    }

    /*
     * sethdnRenrakusakiJoho
     * @param hdnRenrakusakiJoho hdnRenrakusakiJoho
     */
    @JsonProperty("hdnRenrakusakiJoho")
    public void setHdnRenrakusakiJoho(RString hdnRenrakusakiJoho) {
        this.hdnRenrakusakiJoho = hdnRenrakusakiJoho;
    }

    /*
     * gethdnRenrakusakiReadOnly
     * @return hdnRenrakusakiReadOnly
     */
    @JsonProperty("hdnRenrakusakiReadOnly")
    public RString getHdnRenrakusakiReadOnly() {
        return hdnRenrakusakiReadOnly;
    }

    /*
     * sethdnRenrakusakiReadOnly
     * @param hdnRenrakusakiReadOnly hdnRenrakusakiReadOnly
     */
    @JsonProperty("hdnRenrakusakiReadOnly")
    public void setHdnRenrakusakiReadOnly(RString hdnRenrakusakiReadOnly) {
        this.hdnRenrakusakiReadOnly = hdnRenrakusakiReadOnly;
    }

    /*
     * gethdnZenkaiRenrakusakiJoho
     * @return hdnZenkaiRenrakusakiJoho
     */
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    public RString getHdnZenkaiRenrakusakiJoho() {
        return hdnZenkaiRenrakusakiJoho;
    }

    /*
     * sethdnZenkaiRenrakusakiJoho
     * @param hdnZenkaiRenrakusakiJoho hdnZenkaiRenrakusakiJoho
     */
    @JsonProperty("hdnZenkaiRenrakusakiJoho")
    public void setHdnZenkaiRenrakusakiJoho(RString hdnZenkaiRenrakusakiJoho) {
        this.hdnZenkaiRenrakusakiJoho = hdnZenkaiRenrakusakiJoho;
    }

    /*
     * gethdnRenrakuJiko
     * @return hdnRenrakuJiko
     */
    @JsonProperty("hdnRenrakuJiko")
    public RString getHdnRenrakuJiko() {
        return hdnRenrakuJiko;
    }

    /*
     * sethdnRenrakuJiko
     * @param hdnRenrakuJiko hdnRenrakuJiko
     */
    @JsonProperty("hdnRenrakuJiko")
    public void setHdnRenrakuJiko(RString hdnRenrakuJiko) {
        this.hdnRenrakuJiko = hdnRenrakuJiko;
    }

    /*
     * gethdnShikibetsuCode
     * @return hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    /*
     * sethdnShikibetsuCode
     * @param hdnShikibetsuCode hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.hdnShikibetsuCode = hdnShikibetsuCode;
    }

    /*
     * gethdnSyokikaMode
     * @return hdnSyokikaMode
     */
    @JsonProperty("hdnSyokikaMode")
    public RString getHdnSyokikaMode() {
        return hdnSyokikaMode;
    }

    /*
     * sethdnSyokikaMode
     * @param hdnSyokikaMode hdnSyokikaMode
     */
    @JsonProperty("hdnSyokikaMode")
    public void setHdnSyokikaMode(RString hdnSyokikaMode) {
        this.hdnSyokikaMode = hdnSyokikaMode;
    }

    /*
     * gethdnShokikomoku
     * @return hdnShokikomoku
     */
    @JsonProperty("hdnShokikomoku")
    public RString getHdnShokikomoku() {
        return hdnShokikomoku;
    }

    /*
     * sethdnShokikomoku
     * @param hdnShokikomoku hdnShokikomoku
     */
    @JsonProperty("hdnShokikomoku")
    public void setHdnShokikomoku(RString hdnShokikomoku) {
        this.hdnShokikomoku = hdnShokikomoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnIryohokenGuide() {
        return this.getButtonArea().getBtnIryohokenGuide();
    }

    @JsonIgnore
    public void setBtnIryohokenGuide(ButtonDialog btnIryohokenGuide) {
        this.getButtonArea().setBtnIryohokenGuide(btnIryohokenGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnRenrakusaki() {
        return this.getButtonArea().getBtnRenrakusaki();
    }

    @JsonIgnore
    public void setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.getButtonArea().setBtnRenrakusaki(btnRenrakusaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnNyuinShisetsuNyujo() {
        return this.getButtonArea().getBtnNyuinShisetsuNyujo();
    }

    @JsonIgnore
    public void setBtnNyuinShisetsuNyujo(ButtonDialog btnNyuinShisetsuNyujo) {
        this.getButtonArea().setBtnNyuinShisetsuNyujo(btnNyuinShisetsuNyujo);
    }

    @JsonIgnore
    public ButtonDialog getBtnShichosonRenrakuJiko() {
        return this.getButtonArea().getBtnShichosonRenrakuJiko();
    }

    @JsonIgnore
    public void setBtnShichosonRenrakuJiko(ButtonDialog btnShichosonRenrakuJiko) {
        this.getButtonArea().setBtnShichosonRenrakuJiko(btnShichosonRenrakuJiko);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaJokyo() {
        return this.getButtonArea().getBtnChosaJokyo();
    }

    @JsonIgnore
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.getButtonArea().setBtnChosaJokyo(btnChosaJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTainoJokyo() {
        return this.getButtonArea().getBtnTainoJokyo();
    }

    @JsonIgnore
    public void setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.getButtonArea().setBtnTainoJokyo(btnTainoJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJogaiShinsain() {
        return this.getButtonArea().getBtnJogaiShinsain();
    }

    @JsonIgnore
    public void setBtnJogaiShinsain(ButtonDialog btnJogaiShinsain) {
        this.getButtonArea().setBtnJogaiShinsain(btnJogaiShinsain);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getShujiiIryokikanAndShujii().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getChosaItakusakiAndChosain().getCcdChosaItakusakiAndChosainInput();
    }

    @JsonIgnore
    public TextBoxDate getTxtSoshitsubi() {
        return this.getRirekiNintei().getTxtSoshitsubi();
    }

    @JsonIgnore
    public void setTxtSoshitsubi(TextBoxDate txtSoshitsubi) {
        this.getRirekiNintei().setTxtSoshitsubi(txtSoshitsubi);
    }

    @JsonIgnore
    public tblRirekiDiv getTblRireki() {
        return this.getRirekiNintei().getTblRireki();
    }

    @JsonIgnore
    public void setTblRireki(tblRirekiDiv tblRireki) {
        this.getRirekiNintei().setTblRireki(tblRireki);
    }

    @JsonIgnore
    public Label getLblYokaigodo() {
        return this.getRirekiNintei().getTblRireki().getLblYokaigodo();
    }

    @JsonIgnore
    public Label getLblYukoKaishibi() {
        return this.getRirekiNintei().getTblRireki().getLblYukoKaishibi();
    }

    @JsonIgnore
    public Label getLblYukoShuryobi() {
        return this.getRirekiNintei().getTblRireki().getLblYukoShuryobi();
    }

    @JsonIgnore
    public Label getLblNinteibi() {
        return this.getRirekiNintei().getTblRireki().getLblNinteibi();
    }

    @JsonIgnore
    public Label getLblServiceShurui() {
        return this.getRirekiNintei().getTblRireki().getLblServiceShurui();
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getRirekiNintei().getTblRireki().getLblShinsakaiIken();
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiNinteichi() {
        return this.getRirekiNintei().getTblRireki().getBtnZenkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunZenkai() {
        return this.getRirekiNintei().getTblRireki().getTxtKubunZenkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoZenkai() {
        return this.getRirekiNintei().getTblRireki().getTxtYokaigodoZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiZenkai() {
        return this.getRirekiNintei().getTblRireki().getTxtYukoKaishibiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiZenkai() {
        return this.getRirekiNintei().getTblRireki().getTxtYukoShuryobiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiZenkai() {
        return this.getRirekiNintei().getTblRireki().getTxtNinteibiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiZenkai() {
        return this.getRirekiNintei().getTblRireki().getTxtServiceShuruiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenZenkai() {
        return this.getRirekiNintei().getTblRireki().getTxtShinsakaiIkenZenkai();
    }

    @JsonIgnore
    public ButtonDialog getBtnKonkaiNinteichi() {
        return this.getRirekiNintei().getTblRireki().getBtnKonkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunKonkai() {
        return this.getRirekiNintei().getTblRireki().getTxtKubunKonkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoKonkai() {
        return this.getRirekiNintei().getTblRireki().getTxtYokaigodoKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiKonkai() {
        return this.getRirekiNintei().getTblRireki().getTxtYukoKaishibiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiKonkai() {
        return this.getRirekiNintei().getTblRireki().getTxtYukoShuryobiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiKonkai() {
        return this.getRirekiNintei().getTblRireki().getTxtNinteibiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiKonkai() {
        return this.getRirekiNintei().getTblRireki().getTxtServiceShuruiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenKonkai() {
        return this.getRirekiNintei().getTblRireki().getTxtShinsakaiIkenKonkai();
    }

    // </editor-fold>
}
