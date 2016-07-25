package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShokkenTorikeshiIchibuSoshituMain のクラスファイル
 *
 * @author 自動生成
 */
public class ShokkenTorikeshiIchibuSoshituMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIryohokenGuide")
    private ButtonDialog btnIryohokenGuide;
    @JsonProperty("btnRenrakusaki")
    private ButtonDialog btnRenrakusaki;
    @JsonProperty("btnNyuinShisetsuNyujo")
    private ButtonDialog btnNyuinShisetsuNyujo;
    @JsonProperty("btnShichosonRenrakuJiko")
    private ButtonDialog btnShichosonRenrakuJiko;
    @JsonProperty("btnChosaJokyo")
    private ButtonDialog btnChosaJokyo;
    @JsonProperty("btnTainoJokyo")
    private ButtonDialog btnTainoJokyo;
    @JsonProperty("btnJogaiShinsain")
    private ButtonDialog btnJogaiShinsain;
    @JsonProperty("ShujiiIryokikanAndShujii")
    private ShujiiIryokikanAndShujiiDiv ShujiiIryokikanAndShujii;
    @JsonProperty("ChosaItakusakiAndChosain")
    private ChosaItakusakiAndChosainDiv ChosaItakusakiAndChosain;
    @JsonProperty("txtSoshitsubi")
    private TextBoxDate txtSoshitsubi;
    @JsonProperty("tblRireki")
    private tblRirekiDiv tblRireki;
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdKaigoNinteiShikakuInfo;
    @JsonProperty("ccdKaigoNinteiShinseiKihonJohoInput")
    private KaigoNinteiShinseiKihonJohoInputDiv ccdKaigoNinteiShinseiKihonJohoInput;
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("ccdShinseiTodokedesha")
    private NinteiShinseiTodokedeshaDiv ccdShinseiTodokedesha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIryohokenGuide
     * @return btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public ButtonDialog getBtnIryohokenGuide() {
        return btnIryohokenGuide;
    }

    /*
     * setbtnIryohokenGuide
     * @param btnIryohokenGuide btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public void setBtnIryohokenGuide(ButtonDialog btnIryohokenGuide) {
        this.btnIryohokenGuide = btnIryohokenGuide;
    }

    /*
     * getbtnRenrakusaki
     * @return btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public ButtonDialog getBtnRenrakusaki() {
        return btnRenrakusaki;
    }

    /*
     * setbtnRenrakusaki
     * @param btnRenrakusaki btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public void setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.btnRenrakusaki = btnRenrakusaki;
    }

    /*
     * getbtnNyuinShisetsuNyujo
     * @return btnNyuinShisetsuNyujo
     */
    @JsonProperty("btnNyuinShisetsuNyujo")
    public ButtonDialog getBtnNyuinShisetsuNyujo() {
        return btnNyuinShisetsuNyujo;
    }

    /*
     * setbtnNyuinShisetsuNyujo
     * @param btnNyuinShisetsuNyujo btnNyuinShisetsuNyujo
     */
    @JsonProperty("btnNyuinShisetsuNyujo")
    public void setBtnNyuinShisetsuNyujo(ButtonDialog btnNyuinShisetsuNyujo) {
        this.btnNyuinShisetsuNyujo = btnNyuinShisetsuNyujo;
    }

    /*
     * getbtnShichosonRenrakuJiko
     * @return btnShichosonRenrakuJiko
     */
    @JsonProperty("btnShichosonRenrakuJiko")
    public ButtonDialog getBtnShichosonRenrakuJiko() {
        return btnShichosonRenrakuJiko;
    }

    /*
     * setbtnShichosonRenrakuJiko
     * @param btnShichosonRenrakuJiko btnShichosonRenrakuJiko
     */
    @JsonProperty("btnShichosonRenrakuJiko")
    public void setBtnShichosonRenrakuJiko(ButtonDialog btnShichosonRenrakuJiko) {
        this.btnShichosonRenrakuJiko = btnShichosonRenrakuJiko;
    }

    /*
     * getbtnChosaJokyo
     * @return btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public ButtonDialog getBtnChosaJokyo() {
        return btnChosaJokyo;
    }

    /*
     * setbtnChosaJokyo
     * @param btnChosaJokyo btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.btnChosaJokyo = btnChosaJokyo;
    }

    /*
     * getbtnTainoJokyo
     * @return btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public ButtonDialog getBtnTainoJokyo() {
        return btnTainoJokyo;
    }

    /*
     * setbtnTainoJokyo
     * @param btnTainoJokyo btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public void setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.btnTainoJokyo = btnTainoJokyo;
    }

    /*
     * getbtnJogaiShinsain
     * @return btnJogaiShinsain
     */
    @JsonProperty("btnJogaiShinsain")
    public ButtonDialog getBtnJogaiShinsain() {
        return btnJogaiShinsain;
    }

    /*
     * setbtnJogaiShinsain
     * @param btnJogaiShinsain btnJogaiShinsain
     */
    @JsonProperty("btnJogaiShinsain")
    public void setBtnJogaiShinsain(ButtonDialog btnJogaiShinsain) {
        this.btnJogaiShinsain = btnJogaiShinsain;
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
     * gettxtSoshitsubi
     * @return txtSoshitsubi
     */
    @JsonProperty("txtSoshitsubi")
    public TextBoxDate getTxtSoshitsubi() {
        return txtSoshitsubi;
    }

    /*
     * settxtSoshitsubi
     * @param txtSoshitsubi txtSoshitsubi
     */
    @JsonProperty("txtSoshitsubi")
    public void setTxtSoshitsubi(TextBoxDate txtSoshitsubi) {
        this.txtSoshitsubi = txtSoshitsubi;
    }

    /*
     * gettblRireki
     * @return tblRireki
     */
    @JsonProperty("tblRireki")
    public tblRirekiDiv getTblRireki() {
        return tblRireki;
    }

    /*
     * settblRireki
     * @param tblRireki tblRireki
     */
    @JsonProperty("tblRireki")
    public void setTblRireki(tblRirekiDiv tblRireki) {
        this.tblRireki = tblRireki;
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
     * getccdKaigoNinteiShinseiKihonJohoInput
     * @return ccdKaigoNinteiShinseiKihonJohoInput
     */
    @JsonProperty("ccdKaigoNinteiShinseiKihonJohoInput")
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihonJohoInput() {
        return ccdKaigoNinteiShinseiKihonJohoInput;
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
     * getccdShinseiTodokedesha
     * @return ccdShinseiTodokedesha
     */
    @JsonProperty("ccdShinseiTodokedesha")
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return ccdShinseiTodokedesha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getShujiiIryokikanAndShujii().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getChosaItakusakiAndChosain().getCcdChosaItakusakiAndChosainInput();
    }

    @JsonIgnore
    public Label getLblYokaigodo() {
        return this.getTblRireki().getLblYokaigodo();
    }

    @JsonIgnore
    public Label getLblYukoKaishibi() {
        return this.getTblRireki().getLblYukoKaishibi();
    }

    @JsonIgnore
    public Label getLblYukoShuryobi() {
        return this.getTblRireki().getLblYukoShuryobi();
    }

    @JsonIgnore
    public Label getLblNinteibi() {
        return this.getTblRireki().getLblNinteibi();
    }

    @JsonIgnore
    public Label getLblServiceShurui() {
        return this.getTblRireki().getLblServiceShurui();
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.getTblRireki().getLblShinsakaiIken();
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiNinteichi() {
        return this.getTblRireki().getBtnZenkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunZenkai() {
        return this.getTblRireki().getTxtKubunZenkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoZenkai() {
        return this.getTblRireki().getTxtYokaigodoZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiZenkai() {
        return this.getTblRireki().getTxtYukoKaishibiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiZenkai() {
        return this.getTblRireki().getTxtYukoShuryobiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiZenkai() {
        return this.getTblRireki().getTxtNinteibiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiZenkai() {
        return this.getTblRireki().getTxtServiceShuruiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenZenkai() {
        return this.getTblRireki().getTxtShinsakaiIkenZenkai();
    }

    @JsonIgnore
    public ButtonDialog getBtnKonkaiNinteichi() {
        return this.getTblRireki().getBtnKonkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunKonkai() {
        return this.getTblRireki().getTxtKubunKonkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoKonkai() {
        return this.getTblRireki().getTxtYokaigodoKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiKonkai() {
        return this.getTblRireki().getTxtYukoKaishibiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiKonkai() {
        return this.getTblRireki().getTxtYukoShuryobiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiKonkai() {
        return this.getTblRireki().getTxtNinteibiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiKonkai() {
        return this.getTblRireki().getTxtServiceShuruiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenKonkai() {
        return this.getTblRireki().getTxtShinsakaiIkenKonkai();
    }

    // </editor-fold>
}
