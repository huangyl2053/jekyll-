package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.IGemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * DBD1030001 のクラスファイル
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public class DBD1030001Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShafukuRiyoshaKeigen")
    private ShafukuRiyoshaKeigenDiv ShafukuRiyoshaKeigen;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShafukuRiyoshaKeigen
     * @return ShafukuRiyoshaKeigen
     */
    @JsonProperty("ShafukuRiyoshaKeigen")
    public ShafukuRiyoshaKeigenDiv getShafukuRiyoshaKeigen() {
        return ShafukuRiyoshaKeigen;
    }

    /*
     * setShafukuRiyoshaKeigen
     * @param ShafukuRiyoshaKeigen ShafukuRiyoshaKeigen
     */
    @JsonProperty("ShafukuRiyoshaKeigen")
    public void setShafukuRiyoshaKeigen(ShafukuRiyoshaKeigenDiv ShafukuRiyoshaKeigen) {
        this.ShafukuRiyoshaKeigen = ShafukuRiyoshaKeigen;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShafukuRiyoshaKeigen().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getShafukuRiyoshaKeigen().setLin1(lin1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiJokyo() {
        return this.getShafukuRiyoshaKeigen().getTxtSetaiKazeiJokyo();
    }

    @JsonIgnore
    public void setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.getShafukuRiyoshaKeigen().setTxtSetaiKazeiJokyo(txtSetaiKazeiJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnShowSetaiJoho() {
        return this.getShafukuRiyoshaKeigen().getBtnShowSetaiJoho();
    }

    @JsonIgnore
    public void setBtnShowSetaiJoho(ButtonDialog btnShowSetaiJoho) {
        this.getShafukuRiyoshaKeigen().setBtnShowSetaiJoho(btnShowSetaiJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnShowGenmenJoho() {
        return this.getShafukuRiyoshaKeigen().getBtnShowGenmenJoho();
    }

    @JsonIgnore
    public void setBtnShowGenmenJoho(ButtonDialog btnShowGenmenJoho) {
        this.getShafukuRiyoshaKeigen().setBtnShowGenmenJoho(btnShowGenmenJoho);
    }

    @JsonIgnore
    public ShinseiListDiv getShinseiList() {
        return this.getShafukuRiyoshaKeigen().getShinseiList();
    }

    @JsonIgnore
    public void setShinseiList(ShinseiListDiv ShinseiList) {
        this.getShafukuRiyoshaKeigen().setShinseiList(ShinseiList);
    }

    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getShafukuRiyoshaKeigen().getShinseiList().getBtnAddShinsei();
    }

    @JsonIgnore
    public void setBtnAddShinsei(Button btnAddShinsei) {
        this.getShafukuRiyoshaKeigen().getShinseiList().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getShafukuRiyoshaKeigen().getShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getShafukuRiyoshaKeigen().getShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public ShinseiDetailDiv getShinseiDetail() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail();
    }

    @JsonIgnore
    public void setShinseiDetail(ShinseiDetailDiv ShinseiDetail) {
        this.getShafukuRiyoshaKeigen().setShinseiDetail(ShinseiDetail);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public ShoninJohoDiv getShoninJoho() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho();
    }

    @JsonIgnore
    public void setShoninJoho(ShoninJohoDiv ShoninJoho) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().setShoninJoho(ShoninJoho);
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getRadKetteiKubun();
    }

    @JsonIgnore
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getTxtTekiyoYMD();
    }

    @JsonIgnore
    public void setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setTxtTekiyoYMD(txtTekiyoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getTxtYukoKigenYMD();
    }

    @JsonIgnore
    public void setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setTxtYukoKigenYMD(txtYukoKigenYMD);
    }

    @JsonIgnore
    public DropDownList getDdlKeigenJiyu() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getDdlKeigenJiyu();
    }

    @JsonIgnore
    public void setDdlKeigenJiyu(DropDownList ddlKeigenJiyu) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setDdlKeigenJiyu(ddlKeigenJiyu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsuBunshi() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getTxtKeigenRitsuBunshi();
    }

    @JsonIgnore
    public void setTxtKeigenRitsuBunshi(TextBoxNum txtKeigenRitsuBunshi) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setTxtKeigenRitsuBunshi(txtKeigenRitsuBunshi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsuBunbo() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getTxtKeigenRitsuBunbo();
    }

    @JsonIgnore
    public void setTxtKeigenRitsuBunbo(TextBoxNum txtKeigenRitsuBunbo) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setTxtKeigenRitsuBunbo(txtKeigenRitsuBunbo);
    }

    @JsonIgnore
    public CheckBoxList getChkTokureiTaisho() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getChkTokureiTaisho();
    }

    @JsonIgnore
    public void setChkTokureiTaisho(CheckBoxList chkTokureiTaisho) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setChkTokureiTaisho(chkTokureiTaisho);
    }

    @JsonIgnore
    public CheckBoxList getChkKyotakuServiceGentei() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getChkKyotakuServiceGentei();
    }

    @JsonIgnore
    public void setChkKyotakuServiceGentei(CheckBoxList chkKyotakuServiceGentei) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setChkKyotakuServiceGentei(chkKyotakuServiceGentei);
    }

    @JsonIgnore
    public CheckBoxList getChkKyojuhiShokuhiGentei() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getChkKyojuhiShokuhiGentei();
    }

    @JsonIgnore
    public void setChkKyojuhiShokuhiGentei(CheckBoxList chkKyojuhiShokuhiGentei) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setChkKyojuhiShokuhiGentei(chkKyojuhiShokuhiGentei);
    }

    @JsonIgnore
    public CheckBoxList getChkKyusochiUnitGataJunKoshitsu() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getChkKyusochiUnitGataJunKoshitsu();
    }

    @JsonIgnore
    public void setChkKyusochiUnitGataJunKoshitsu(CheckBoxList chkKyusochiUnitGataJunKoshitsu) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setChkKyusochiUnitGataJunKoshitsu(chkKyusochiUnitGataJunKoshitsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKakuninNo() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getTxtKakuninNo();
    }

    @JsonIgnore
    public void setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setTxtKakuninNo(txtKakuninNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnSelectHiShoninRiyu() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getBtnSelectHiShoninRiyu();
    }

    @JsonIgnore
    public void setBtnSelectHiShoninRiyu(ButtonDialog btnSelectHiShoninRiyu) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setBtnSelectHiShoninRiyu(btnSelectHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().getShoninJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getBtnShinseiKakutei() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getBtnShinseiKakutei();
    }

    @JsonIgnore
    public void setBtnShinseiKakutei(Button btnShinseiKakutei) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().setBtnShinseiKakutei(btnShinseiKakutei);
    }

    @JsonIgnore
    public Button getBtnShoninKakutei() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getBtnShoninKakutei();
    }

    @JsonIgnore
    public void setBtnShoninKakutei(Button btnShoninKakutei) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().setBtnShoninKakutei(btnShoninKakutei);
    }

    @JsonIgnore
    public Button getBtnBackToShinseiList() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getBtnBackToShinseiList();
    }

    @JsonIgnore
    public void setBtnBackToShinseiList(Button btnBackToShinseiList) {
        this.getShafukuRiyoshaKeigen().getShinseiDetail().setBtnBackToShinseiList(btnBackToShinseiList);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return this.getShafukuRiyoshaKeigen().getShinseiDetail().getCcdShinseiJoho();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdShikakuKihon() {
        return this.getShafukuRiyoshaKeigen().getCcdShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return this.getShafukuRiyoshaKeigen().getCcdAtenaInfo();
    }

    // </editor-fold>
}
