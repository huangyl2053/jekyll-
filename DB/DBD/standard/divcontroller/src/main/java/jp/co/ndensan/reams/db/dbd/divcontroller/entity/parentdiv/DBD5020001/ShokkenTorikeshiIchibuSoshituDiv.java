package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShokkenTorikeshiIchibuSoshitu のクラスファイル
 *
 * @author 自動生成
 */
public class ShokkenTorikeshiIchibuSoshituDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokkenTorikeshiIchibuSoshituMain")
    private ShokkenTorikeshiIchibuSoshituMainDiv ShokkenTorikeshiIchibuSoshituMain;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;
    @JsonProperty("hdnZenkaiSerializedBusiness")
    private RString hdnZenkaiSerializedBusiness;
    @JsonProperty("hdnKonkaiSerializedBusiness")
    private RString hdnKonkaiSerializedBusiness;
    @JsonProperty("hdnDisplayModeKey")
    private RString hdnDisplayModeKey;
    @JsonProperty("hdnYokaigodoCodeZenkai")
    private RString hdnYokaigodoCodeZenkai;
    @JsonProperty("hdnYokaigodoCodeKonkai")
    private RString hdnYokaigodoCodeKonkai;
    @JsonProperty("hdnZenkaiRirekiNo")
    private RString hdnZenkaiRirekiNo;
    @JsonProperty("hdnKonkaiRirekiNo")
    private RString hdnKonkaiRirekiNo;
    @JsonProperty("hdnKekkaCommonDivMode")
    private RString hdnKekkaCommonDivMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShokkenTorikeshiIchibuSoshituMain
     * @return ShokkenTorikeshiIchibuSoshituMain
     */
    @JsonProperty("ShokkenTorikeshiIchibuSoshituMain")
    public ShokkenTorikeshiIchibuSoshituMainDiv getShokkenTorikeshiIchibuSoshituMain() {
        return ShokkenTorikeshiIchibuSoshituMain;
    }

    /*
     * setShokkenTorikeshiIchibuSoshituMain
     * @param ShokkenTorikeshiIchibuSoshituMain ShokkenTorikeshiIchibuSoshituMain
     */
    @JsonProperty("ShokkenTorikeshiIchibuSoshituMain")
    public void setShokkenTorikeshiIchibuSoshituMain(ShokkenTorikeshiIchibuSoshituMainDiv ShokkenTorikeshiIchibuSoshituMain) {
        this.ShokkenTorikeshiIchibuSoshituMain = ShokkenTorikeshiIchibuSoshituMain;
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
     * gethdnZenkaiRirekiNo
     * @return hdnZenkaiRirekiNo
     */
    @JsonProperty("hdnZenkaiRirekiNo")
    public RString getHdnZenkaiRirekiNo() {
        return hdnZenkaiRirekiNo;
    }

    /*
     * sethdnZenkaiRirekiNo
     * @param hdnZenkaiRirekiNo hdnZenkaiRirekiNo
     */
    @JsonProperty("hdnZenkaiRirekiNo")
    public void setHdnZenkaiRirekiNo(RString hdnZenkaiRirekiNo) {
        this.hdnZenkaiRirekiNo = hdnZenkaiRirekiNo;
    }

    /*
     * gethdnKonkaiRirekiNo
     * @return hdnKonkaiRirekiNo
     */
    @JsonProperty("hdnKonkaiRirekiNo")
    public RString getHdnKonkaiRirekiNo() {
        return hdnKonkaiRirekiNo;
    }

    /*
     * sethdnKonkaiRirekiNo
     * @param hdnKonkaiRirekiNo hdnKonkaiRirekiNo
     */
    @JsonProperty("hdnKonkaiRirekiNo")
    public void setHdnKonkaiRirekiNo(RString hdnKonkaiRirekiNo) {
        this.hdnKonkaiRirekiNo = hdnKonkaiRirekiNo;
    }

    /*
     * gethdnKekkaCommonDivMode
     * @return hdnKekkaCommonDivMode
     */
    @JsonProperty("hdnKekkaCommonDivMode")
    public RString getHdnKekkaCommonDivMode() {
        return hdnKekkaCommonDivMode;
    }

    /*
     * sethdnKekkaCommonDivMode
     * @param hdnKekkaCommonDivMode hdnKekkaCommonDivMode
     */
    @JsonProperty("hdnKekkaCommonDivMode")
    public void setHdnKekkaCommonDivMode(RString hdnKekkaCommonDivMode) {
        this.hdnKekkaCommonDivMode = hdnKekkaCommonDivMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnIryohokenGuide() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getBtnIryohokenGuide();
    }

    @JsonIgnore
    public void setBtnIryohokenGuide(ButtonDialog btnIryohokenGuide) {
        this.getShokkenTorikeshiIchibuSoshituMain().setBtnIryohokenGuide(btnIryohokenGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnRenrakusaki() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getBtnRenrakusaki();
    }

    @JsonIgnore
    public void setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.getShokkenTorikeshiIchibuSoshituMain().setBtnRenrakusaki(btnRenrakusaki);
    }

    @JsonIgnore
    public ButtonDialog getBtnNyuinShisetsuNyujo() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getBtnNyuinShisetsuNyujo();
    }

    @JsonIgnore
    public void setBtnNyuinShisetsuNyujo(ButtonDialog btnNyuinShisetsuNyujo) {
        this.getShokkenTorikeshiIchibuSoshituMain().setBtnNyuinShisetsuNyujo(btnNyuinShisetsuNyujo);
    }

    @JsonIgnore
    public ButtonDialog getBtnShichosonRenrakuJiko() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getBtnShichosonRenrakuJiko();
    }

    @JsonIgnore
    public void setBtnShichosonRenrakuJiko(ButtonDialog btnShichosonRenrakuJiko) {
        this.getShokkenTorikeshiIchibuSoshituMain().setBtnShichosonRenrakuJiko(btnShichosonRenrakuJiko);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaJokyo() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getBtnChosaJokyo();
    }

    @JsonIgnore
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.getShokkenTorikeshiIchibuSoshituMain().setBtnChosaJokyo(btnChosaJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnTainoJokyo() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getBtnTainoJokyo();
    }

    @JsonIgnore
    public void setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.getShokkenTorikeshiIchibuSoshituMain().setBtnTainoJokyo(btnTainoJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJogaiShinsain() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getBtnJogaiShinsain();
    }

    @JsonIgnore
    public void setBtnJogaiShinsain(ButtonDialog btnJogaiShinsain) {
        this.getShokkenTorikeshiIchibuSoshituMain().setBtnJogaiShinsain(btnJogaiShinsain);
    }

    @JsonIgnore
    public ShujiiIryokikanAndShujiiDiv getShujiiIryokikanAndShujii() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getShujiiIryokikanAndShujii();
    }

    @JsonIgnore
    public void setShujiiIryokikanAndShujii(ShujiiIryokikanAndShujiiDiv ShujiiIryokikanAndShujii) {
        this.getShokkenTorikeshiIchibuSoshituMain().setShujiiIryokikanAndShujii(ShujiiIryokikanAndShujii);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getShujiiIryokikanAndShujii().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public ChosaItakusakiAndChosainDiv getChosaItakusakiAndChosain() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getChosaItakusakiAndChosain();
    }

    @JsonIgnore
    public void setChosaItakusakiAndChosain(ChosaItakusakiAndChosainDiv ChosaItakusakiAndChosain) {
        this.getShokkenTorikeshiIchibuSoshituMain().setChosaItakusakiAndChosain(ChosaItakusakiAndChosain);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getChosaItakusakiAndChosain().getCcdChosaItakusakiAndChosainInput();
    }

    @JsonIgnore
    public TextBoxDate getTxtSoshitsubi() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTxtSoshitsubi();
    }

    @JsonIgnore
    public void setTxtSoshitsubi(TextBoxDate txtSoshitsubi) {
        this.getShokkenTorikeshiIchibuSoshituMain().setTxtSoshitsubi(txtSoshitsubi);
    }

    @JsonIgnore
    public tblRirekiDiv getTblRireki() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki();
    }

    @JsonIgnore
    public void setTblRireki(tblRirekiDiv tblRireki) {
        this.getShokkenTorikeshiIchibuSoshituMain().setTblRireki(tblRireki);
    }

    @JsonIgnore
    public Label getLblYokaigodo() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getLblYokaigodo();
    }

    @JsonIgnore
    public Label getLblYukoKaishibi() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getLblYukoKaishibi();
    }

    @JsonIgnore
    public Label getLblYukoShuryobi() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getLblYukoShuryobi();
    }

    @JsonIgnore
    public Label getLblNinteibi() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getLblNinteibi();
    }

    @JsonIgnore
    public Label getLblServiceShurui() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getLblServiceShurui();
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getLblShinsakaiIken();
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiNinteichi() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getBtnZenkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunZenkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtKubunZenkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoZenkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtYokaigodoZenkai();
    }

    @JsonIgnore
    public TextBox getTxtYukoKaishibiZenkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtYukoKaishibiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtYukoShuryobiZenkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtYukoShuryobiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtNinteibiZenkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtNinteibiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiZenkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtServiceShuruiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenZenkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtShinsakaiIkenZenkai();
    }

    @JsonIgnore
    public ButtonDialog getBtnKonkaiNinteichi() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getBtnKonkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunKonkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtKubunKonkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoKonkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtYokaigodoKonkai();
    }

    @JsonIgnore
    public TextBox getTxtYukoKaishibiKonkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtYukoKaishibiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtYukoShuryobiKonkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtYukoShuryobiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtNinteibiKonkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtNinteibiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiKonkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtServiceShuruiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenKonkai() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getTblRireki().getTxtShinsakaiIkenKonkai();
    }

    @JsonIgnore
    public IKaigoninteiShikakuInfoDiv getCcdKaigoNinteiShikakuInfo() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getCcdKaigoNinteiShikakuInfo();
    }

    @JsonIgnore
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getCcdKaigoNinteiAtenaInfo();
    }

    @JsonIgnore
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihonJohoInput() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getCcdKaigoNinteiShinseiKihonJohoInput();
    }

    @JsonIgnore
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return this.getShokkenTorikeshiIchibuSoshituMain().getCcdShinseiTodokedesha();
    }

    // </editor-fold>
}
