package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001;
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
 * TaishouWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishouWaritsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiTaishoshaWaritsuke")
    private ShinsakaiTaishoshaWaritsukeDiv ShinsakaiTaishoshaWaritsuke;
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiTaishoshaWaritsuke
     * @return ShinsakaiTaishoshaWaritsuke
     */
    @JsonProperty("ShinsakaiTaishoshaWaritsuke")
    public ShinsakaiTaishoshaWaritsukeDiv getShinsakaiTaishoshaWaritsuke() {
        return ShinsakaiTaishoshaWaritsuke;
    }

    /*
     * setShinsakaiTaishoshaWaritsuke
     * @param ShinsakaiTaishoshaWaritsuke ShinsakaiTaishoshaWaritsuke
     */
    @JsonProperty("ShinsakaiTaishoshaWaritsuke")
    public void setShinsakaiTaishoshaWaritsuke(ShinsakaiTaishoshaWaritsukeDiv ShinsakaiTaishoshaWaritsuke) {
        this.ShinsakaiTaishoshaWaritsuke = ShinsakaiTaishoshaWaritsuke;
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
    public ShinsakaiJohoDiv getShinsakaiJoho() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho();
    }

    @JsonIgnore
    public void  setShinsakaiJoho(ShinsakaiJohoDiv ShinsakaiJoho) {
        this.getShinsakaiTaishoshaWaritsuke().setShinsakaiJoho(ShinsakaiJoho);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiName() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtShinsakaiName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiName(TextBox txtShinsakaiName) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtShinsakaiName(txtShinsakaiName);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiNumber() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtGogitaiNumber();
    }

    @JsonIgnore
    public void  setTxtGogitaiNumber(TextBox txtGogitaiNumber) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtGogitaiNumber(txtGogitaiNumber);
    }

    @JsonIgnore
    public TextBoxNum getTxtWaritsukeNinzu() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtWaritsukeNinzu();
    }

    @JsonIgnore
    public void  setTxtWaritsukeNinzu(TextBoxNum txtWaritsukeNinzu) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtWaritsukeNinzu(txtWaritsukeNinzu);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijo() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtShinsakaiKaijo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtShinsakaiKaijo(txtShinsakaiKaijo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiChiku() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtShinsakaiChiku();
    }

    @JsonIgnore
    public void  setTxtShinsakaiChiku(TextBox txtShinsakaiChiku) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtShinsakaiChiku(txtShinsakaiChiku);
    }

    @JsonIgnore
    public TextBox getTxtShinsakauChikuName() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtShinsakauChikuName();
    }

    @JsonIgnore
    public void  setTxtShinsakauChikuName(TextBox txtShinsakauChikuName) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtShinsakauChikuName(txtShinsakauChikuName);
    }

    @JsonIgnore
    public TextBoxNum getTxtYoteiTeiin() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtYoteiTeiin();
    }

    @JsonIgnore
    public void  setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtYoteiTeiin(txtYoteiTeiin);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDate() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtKaisaiDate();
    }

    @JsonIgnore
    public void  setTxtKaisaiDate(TextBoxFlexibleDate txtKaisaiDate) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtKaisaiDate(txtKaisaiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiKaishiTime() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtYoteiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtYoteiKaishiTime(TextBoxTime txtYoteiKaishiTime) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtYoteiKaishiTime(txtYoteiKaishiTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiShuryoTime() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtYoteiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtYoteiShuryoTime(TextBoxTime txtYoteiShuryoTime) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtYoteiShuryoTime(txtYoteiShuryoTime);
    }

    @JsonIgnore
    public CheckBoxList getChkNinchishoOnly() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getChkNinchishoOnly();
    }

    @JsonIgnore
    public void  setChkNinchishoOnly(CheckBoxList chkNinchishoOnly) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setChkNinchishoOnly(chkNinchishoOnly);
    }

    @JsonIgnore
    public CheckBoxList getChkKenshuMogi() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getChkKenshuMogi();
    }

    @JsonIgnore
    public void  setChkKenshuMogi(CheckBoxList chkKenshuMogi) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setChkKenshuMogi(chkKenshuMogi);
    }

    @JsonIgnore
    public TextBox getTxtStatus() {
        return this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().getTxtStatus();
    }

    @JsonIgnore
    public void  setTxtStatus(TextBox txtStatus) {
        this.getShinsakaiTaishoshaWaritsuke().getShinsakaiJoho().setTxtStatus(txtStatus);
    }

    @JsonIgnore
    public WaritsukeTaishoshaIchiranDiv getWaritsukeTaishoshaIchiran() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setWaritsukeTaishoshaIchiran(WaritsukeTaishoshaIchiranDiv WaritsukeTaishoshaIchiran) {
        this.getShinsakaiTaishoshaWaritsuke().setWaritsukeTaishoshaIchiran(WaritsukeTaishoshaIchiran);
    }

    @JsonIgnore
    public Label getLblTaishosha() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().getLblTaishosha();
    }

    @JsonIgnore
    public void  setLblTaishosha(Label lblTaishosha) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().setLblTaishosha(lblTaishosha);
    }

    @JsonIgnore
    public CheckBoxList getChkTaishoshaFilter() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().getChkTaishoshaFilter();
    }

    @JsonIgnore
    public void  setChkTaishoshaFilter(CheckBoxList chkTaishoshaFilter) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().setChkTaishoshaFilter(chkTaishoshaFilter);
    }

    @JsonIgnore
    public DropDownList getDdlSortOrder() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().getDdlSortOrder();
    }

    @JsonIgnore
    public void  setDdlSortOrder(DropDownList ddlSortOrder) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().setDdlSortOrder(ddlSortOrder);
    }

    @JsonIgnore
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().getDgTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeTaishoshaIchiran().setDgTaishoshaIchiran(dgTaishoshaIchiran);
    }

    @JsonIgnore
    public WaritsukeKohoshaIchiranDiv getWaritsukeKohoshaIchiran() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran();
    }

    @JsonIgnore
    public void  setWaritsukeKohoshaIchiran(WaritsukeKohoshaIchiranDiv WaritsukeKohoshaIchiran) {
        this.getShinsakaiTaishoshaWaritsuke().setWaritsukeKohoshaIchiran(WaritsukeKohoshaIchiran);
    }

    @JsonIgnore
    public Label getLblKohoshaIchiran() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().getLblKohoshaIchiran();
    }

    @JsonIgnore
    public void  setLblKohoshaIchiran(Label lblKohoshaIchiran) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().setLblKohoshaIchiran(lblKohoshaIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkKohoshaFilter() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().getChkKohoshaFilter();
    }

    @JsonIgnore
    public void  setChkKohoshaFilter(CheckBoxList chkKohoshaFilter) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().setChkKohoshaFilter(chkKohoshaFilter);
    }

    @JsonIgnore
    public Button getBtnJidoWaritsuke() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().getBtnJidoWaritsuke();
    }

    @JsonIgnore
    public void  setBtnJidoWaritsuke(Button btnJidoWaritsuke) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().setBtnJidoWaritsuke(btnJidoWaritsuke);
    }

    @JsonIgnore
    public Button getBtnWaritsuke() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().getBtnWaritsuke();
    }

    @JsonIgnore
    public void  setBtnWaritsuke(Button btnWaritsuke) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().setBtnWaritsuke(btnWaritsuke);
    }

    @JsonIgnore
    public CheckBoxList getChkShiryosakuseizumiKomi() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().getChkShiryosakuseizumiKomi();
    }

    @JsonIgnore
    public void  setChkShiryosakuseizumiKomi(CheckBoxList chkShiryosakuseizumiKomi) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().setChkShiryosakuseizumiKomi(chkShiryosakuseizumiKomi);
    }

    @JsonIgnore
    public Button getBtnWaritsukeKaijo() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().getBtnWaritsukeKaijo();
    }

    @JsonIgnore
    public void  setBtnWaritsukeKaijo(Button btnWaritsukeKaijo) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().setBtnWaritsukeKaijo(btnWaritsukeKaijo);
    }

    @JsonIgnore
    public DataGrid<dgWaritsukeKohoshaIchiran_Row> getDgWaritsukeKohoshaIchiran() {
        return this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().getDgWaritsukeKohoshaIchiran();
    }

    @JsonIgnore
    public void  setDgWaritsukeKohoshaIchiran(DataGrid<dgWaritsukeKohoshaIchiran_Row> dgWaritsukeKohoshaIchiran) {
        this.getShinsakaiTaishoshaWaritsuke().getWaritsukeKohoshaIchiran().setDgWaritsukeKohoshaIchiran(dgWaritsukeKohoshaIchiran);
    }

    // </editor-fold>
}
