package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxSetaiCode;

/**
 * ShotokuJohoTorokuTotal のクラスファイル
 *
 * @reamsid_L DBB-1750-010 zhangrui
 */
public class ShotokuJohoTorokuTotalDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaInfo")
    private AtenaInfoDiv AtenaInfo;
    @JsonProperty("SetaiShotokuInfo")
    private SetaiShotokuInfoDiv SetaiShotokuInfo;
    @JsonProperty("ShotokuJohoToroku")
    private ShotokuJohoTorokuDiv ShotokuJohoToroku;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaInfo
     * @return AtenaInfo
     */
    @JsonProperty("AtenaInfo")
    public AtenaInfoDiv getAtenaInfo() {
        return AtenaInfo;
    }

    /*
     * setAtenaInfo
     * @param AtenaInfo AtenaInfo
     */
    @JsonProperty("AtenaInfo")
    public void setAtenaInfo(AtenaInfoDiv AtenaInfo) {
        this.AtenaInfo = AtenaInfo;
    }

    /*
     * getSetaiShotokuInfo
     * @return SetaiShotokuInfo
     */
    @JsonProperty("SetaiShotokuInfo")
    public SetaiShotokuInfoDiv getSetaiShotokuInfo() {
        return SetaiShotokuInfo;
    }

    /*
     * setSetaiShotokuInfo
     * @param SetaiShotokuInfo SetaiShotokuInfo
     */
    @JsonProperty("SetaiShotokuInfo")
    public void setSetaiShotokuInfo(SetaiShotokuInfoDiv SetaiShotokuInfo) {
        this.SetaiShotokuInfo = SetaiShotokuInfo;
    }

    /*
     * getShotokuJohoToroku
     * @return ShotokuJohoToroku
     */
    @JsonProperty("ShotokuJohoToroku")
    public ShotokuJohoTorokuDiv getShotokuJohoToroku() {
        return ShotokuJohoToroku;
    }

    /*
     * setShotokuJohoToroku
     * @param ShotokuJohoToroku ShotokuJohoToroku
     */
    @JsonProperty("ShotokuJohoToroku")
    public void setShotokuJohoToroku(ShotokuJohoTorokuDiv ShotokuJohoToroku) {
        this.ShotokuJohoToroku = ShotokuJohoToroku;
    }

    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public KanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * setKanryoMessage
     * @param KanryoMessage KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoFukaKihonDiv getKaigoFukaKihon() {
        return this.getAtenaInfo().getKaigoFukaKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getKaigoAtenaInfo() {
        return this.getAtenaInfo().getKaigoAtenaInfo();
    }

    @JsonIgnore
    public TextBoxDate getTxtSetaiIchiranKijunYMD() {
        return this.getSetaiShotokuInfo().getTxtSetaiIchiranKijunYMD();
    }

    @JsonIgnore
    public void setTxtSetaiIchiranKijunYMD(TextBoxDate txtSetaiIchiranKijunYMD) {
        this.getSetaiShotokuInfo().setTxtSetaiIchiranKijunYMD(txtSetaiIchiranKijunYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtSetaiIchiranKazeiNendo() {
        return this.getSetaiShotokuInfo().getTxtSetaiIchiranKazeiNendo();
    }

    @JsonIgnore
    public void setTxtSetaiIchiranKazeiNendo(TextBoxFlexibleYear txtSetaiIchiranKazeiNendo) {
        this.getSetaiShotokuInfo().setTxtSetaiIchiranKazeiNendo(txtSetaiIchiranKazeiNendo);
    }

    @JsonIgnore
    public DropDownList getDdlSetaiIchiranKazeiNendo() {
        return this.getSetaiShotokuInfo().getDdlSetaiIchiranKazeiNendo();
    }

    @JsonIgnore
    public void setDdlSetaiIchiranKazeiNendo(DropDownList ddlSetaiIchiranKazeiNendo) {
        this.getSetaiShotokuInfo().setDdlSetaiIchiranKazeiNendo(ddlSetaiIchiranKazeiNendo);
    }

    @JsonIgnore
    public Button getBtnSaiHyoji() {
        return this.getSetaiShotokuInfo().getBtnSaiHyoji();
    }

    @JsonIgnore
    public void setBtnSaiHyoji(Button btnSaiHyoji) {
        this.getSetaiShotokuInfo().setBtnSaiHyoji(btnSaiHyoji);
    }

    @JsonIgnore
    public TextBoxSetaiCode getTxtSetaiIchiranSetaiCode() {
        return this.getSetaiShotokuInfo().getTxtSetaiIchiranSetaiCode();
    }

    @JsonIgnore
    public void setTxtSetaiIchiranSetaiCode(TextBoxSetaiCode txtSetaiIchiranSetaiCode) {
        this.getSetaiShotokuInfo().setTxtSetaiIchiranSetaiCode(txtSetaiIchiranSetaiCode);
    }

    @JsonIgnore
    public CheckBoxList getChkSetaiIchiranAll() {
        return this.getSetaiShotokuInfo().getChkSetaiIchiranAll();
    }

    @JsonIgnore
    public void setChkSetaiIchiranAll(CheckBoxList chkSetaiIchiranAll) {
        this.getSetaiShotokuInfo().setChkSetaiIchiranAll(chkSetaiIchiranAll);
    }

    @JsonIgnore
    public Label getLblSetaiIchiranMsg() {
        return this.getSetaiShotokuInfo().getLblSetaiIchiranMsg();
    }

    @JsonIgnore
    public void setLblSetaiIchiranMsg(Label lblSetaiIchiranMsg) {
        this.getSetaiShotokuInfo().setLblSetaiIchiranMsg(lblSetaiIchiranMsg);
    }

    @JsonIgnore
    public DataGrid<dgSetaiShotoku_Row> getDgSetaiShotoku() {
        return this.getSetaiShotokuInfo().getDgSetaiShotoku();
    }

    @JsonIgnore
    public void setDgSetaiShotoku(DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku) {
        this.getSetaiShotokuInfo().setDgSetaiShotoku(dgSetaiShotoku);
    }

    @JsonIgnore
    public Label getLblJuminZeiHikazeiKbn() {
        return this.getShotokuJohoToroku().getLblJuminZeiHikazeiKbn();
    }

    @JsonIgnore
    public void setLblJuminZeiHikazeiKbn(Label lblJuminZeiHikazeiKbn) {
        this.getShotokuJohoToroku().setLblJuminZeiHikazeiKbn(lblJuminZeiHikazeiKbn);
    }

    @JsonIgnore
    public DropDownList getDdlJuminzeiGenmenMae() {
        return this.getShotokuJohoToroku().getDdlJuminzeiGenmenMae();
    }

    @JsonIgnore
    public void setDdlJuminzeiGenmenMae(DropDownList ddlJuminzeiGenmenMae) {
        this.getShotokuJohoToroku().setDdlJuminzeiGenmenMae(ddlJuminzeiGenmenMae);
    }

    @JsonIgnore
    public DropDownList getDdlJuminzeiGenmenAto() {
        return this.getShotokuJohoToroku().getDdlJuminzeiGenmenAto();
    }

    @JsonIgnore
    public void setDdlJuminzeiGenmenAto(DropDownList ddlJuminzeiGenmenAto) {
        this.getShotokuJohoToroku().setDdlJuminzeiGenmenAto(ddlJuminzeiGenmenAto);
    }

    @JsonIgnore
    public DropDownList getDdlJuminzei() {
        return this.getShotokuJohoToroku().getDdlJuminzei();
    }

    @JsonIgnore
    public void setDdlJuminzei(DropDownList ddlJuminzei) {
        this.getShotokuJohoToroku().setDdlJuminzei(ddlJuminzei);
    }

    @JsonIgnore
    public DropDownList getDdlGekihenKanwa() {
        return this.getShotokuJohoToroku().getDdlGekihenKanwa();
    }

    @JsonIgnore
    public void setDdlGekihenKanwa(DropDownList ddlGekihenKanwa) {
        this.getShotokuJohoToroku().setDdlGekihenKanwa(ddlGekihenKanwa);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiShotokuGaku() {
        return this.getShotokuJohoToroku().getTxtGokeiShotokuGaku();
    }

    @JsonIgnore
    public void setTxtGokeiShotokuGaku(TextBoxNum txtGokeiShotokuGaku) {
        this.getShotokuJohoToroku().setTxtGokeiShotokuGaku(txtGokeiShotokuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShunyuGaku() {
        return this.getShotokuJohoToroku().getTxtNenkinShunyuGaku();
    }

    @JsonIgnore
    public void setTxtNenkinShunyuGaku(TextBoxNum txtNenkinShunyuGaku) {
        this.getShotokuJohoToroku().setTxtNenkinShunyuGaku(txtNenkinShunyuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShotokuGaku() {
        return this.getShotokuJohoToroku().getTxtNenkinShotokuGaku();
    }

    @JsonIgnore
    public void setTxtNenkinShotokuGaku(TextBoxNum txtNenkinShotokuGaku) {
        this.getShotokuJohoToroku().setTxtNenkinShotokuGaku(txtNenkinShotokuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKazeiShotokuGaku() {
        return this.getShotokuJohoToroku().getTxtKazeiShotokuGaku();
    }

    @JsonIgnore
    public void setTxtKazeiShotokuGaku(TextBoxNum txtKazeiShotokuGaku) {
        this.getShotokuJohoToroku().setTxtKazeiShotokuGaku(txtKazeiShotokuGaku);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getShotokuJohoToroku().getBtnKakutei();
    }

    @JsonIgnore
    public void setBtnKakutei(Button btnKakutei) {
        this.getShotokuJohoToroku().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getShotokuJohoToroku().getBtnTorikeshi();
    }

    @JsonIgnore
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.getShotokuJohoToroku().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
}
