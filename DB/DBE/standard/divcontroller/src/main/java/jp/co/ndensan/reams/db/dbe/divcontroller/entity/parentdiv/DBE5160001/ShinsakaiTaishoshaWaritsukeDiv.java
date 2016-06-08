package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiTaishoshaWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiTaishoshaWaritsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiJoho")
    private ShinsakaiJohoDiv ShinsakaiJoho;
    @JsonProperty("WaritsukeTaishoshaIchiran")
    private WaritsukeTaishoshaIchiranDiv WaritsukeTaishoshaIchiran;
    @JsonProperty("btnJidoWaritsuke")
    private Button btnJidoWaritsuke;
    @JsonProperty("btnWaritsuke")
    private Button btnWaritsuke;
    @JsonProperty("btnWaritsukeKaijo")
    private Button btnWaritsukeKaijo;
    @JsonProperty("WaritsukeKohoshaIchiran")
    private WaritsukeKohoshaIchiranDiv WaritsukeKohoshaIchiran;
    @JsonProperty("KaigoNinteiShinsakaiKaisaiNo")
    private RString KaigoNinteiShinsakaiKaisaiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiJoho
     * @return ShinsakaiJoho
     */
    @JsonProperty("ShinsakaiJoho")
    public ShinsakaiJohoDiv getShinsakaiJoho() {
        return ShinsakaiJoho;
    }

    /*
     * setShinsakaiJoho
     * @param ShinsakaiJoho ShinsakaiJoho
     */
    @JsonProperty("ShinsakaiJoho")
    public void setShinsakaiJoho(ShinsakaiJohoDiv ShinsakaiJoho) {
        this.ShinsakaiJoho = ShinsakaiJoho;
    }

    /*
     * getWaritsukeTaishoshaIchiran
     * @return WaritsukeTaishoshaIchiran
     */
    @JsonProperty("WaritsukeTaishoshaIchiran")
    public WaritsukeTaishoshaIchiranDiv getWaritsukeTaishoshaIchiran() {
        return WaritsukeTaishoshaIchiran;
    }

    /*
     * setWaritsukeTaishoshaIchiran
     * @param WaritsukeTaishoshaIchiran WaritsukeTaishoshaIchiran
     */
    @JsonProperty("WaritsukeTaishoshaIchiran")
    public void setWaritsukeTaishoshaIchiran(WaritsukeTaishoshaIchiranDiv WaritsukeTaishoshaIchiran) {
        this.WaritsukeTaishoshaIchiran = WaritsukeTaishoshaIchiran;
    }

    /*
     * getbtnJidoWaritsuke
     * @return btnJidoWaritsuke
     */
    @JsonProperty("btnJidoWaritsuke")
    public Button getBtnJidoWaritsuke() {
        return btnJidoWaritsuke;
    }

    /*
     * setbtnJidoWaritsuke
     * @param btnJidoWaritsuke btnJidoWaritsuke
     */
    @JsonProperty("btnJidoWaritsuke")
    public void setBtnJidoWaritsuke(Button btnJidoWaritsuke) {
        this.btnJidoWaritsuke = btnJidoWaritsuke;
    }

    /*
     * getbtnWaritsuke
     * @return btnWaritsuke
     */
    @JsonProperty("btnWaritsuke")
    public Button getBtnWaritsuke() {
        return btnWaritsuke;
    }

    /*
     * setbtnWaritsuke
     * @param btnWaritsuke btnWaritsuke
     */
    @JsonProperty("btnWaritsuke")
    public void setBtnWaritsuke(Button btnWaritsuke) {
        this.btnWaritsuke = btnWaritsuke;
    }

    /*
     * getbtnWaritsukeKaijo
     * @return btnWaritsukeKaijo
     */
    @JsonProperty("btnWaritsukeKaijo")
    public Button getBtnWaritsukeKaijo() {
        return btnWaritsukeKaijo;
    }

    /*
     * setbtnWaritsukeKaijo
     * @param btnWaritsukeKaijo btnWaritsukeKaijo
     */
    @JsonProperty("btnWaritsukeKaijo")
    public void setBtnWaritsukeKaijo(Button btnWaritsukeKaijo) {
        this.btnWaritsukeKaijo = btnWaritsukeKaijo;
    }

    /*
     * getWaritsukeKohoshaIchiran
     * @return WaritsukeKohoshaIchiran
     */
    @JsonProperty("WaritsukeKohoshaIchiran")
    public WaritsukeKohoshaIchiranDiv getWaritsukeKohoshaIchiran() {
        return WaritsukeKohoshaIchiran;
    }

    /*
     * setWaritsukeKohoshaIchiran
     * @param WaritsukeKohoshaIchiran WaritsukeKohoshaIchiran
     */
    @JsonProperty("WaritsukeKohoshaIchiran")
    public void setWaritsukeKohoshaIchiran(WaritsukeKohoshaIchiranDiv WaritsukeKohoshaIchiran) {
        this.WaritsukeKohoshaIchiran = WaritsukeKohoshaIchiran;
    }

    /*
     * getKaigoNinteiShinsakaiKaisaiNo
     * @return KaigoNinteiShinsakaiKaisaiNo
     */
    @JsonProperty("KaigoNinteiShinsakaiKaisaiNo")
    public RString getKaigoNinteiShinsakaiKaisaiNo() {
        return KaigoNinteiShinsakaiKaisaiNo;
    }

    /*
     * setKaigoNinteiShinsakaiKaisaiNo
     * @param KaigoNinteiShinsakaiKaisaiNo KaigoNinteiShinsakaiKaisaiNo
     */
    @JsonProperty("KaigoNinteiShinsakaiKaisaiNo")
    public void setKaigoNinteiShinsakaiKaisaiNo(RString KaigoNinteiShinsakaiKaisaiNo) {
        this.KaigoNinteiShinsakaiKaisaiNo = KaigoNinteiShinsakaiKaisaiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinsakaiName() {
        return this.getShinsakaiJoho().getTxtShinsakaiName();
    }

    @JsonIgnore
    public void  setTxtShinsakaiName(TextBox txtShinsakaiName) {
        this.getShinsakaiJoho().setTxtShinsakaiName(txtShinsakaiName);
    }

    @JsonIgnore
    public TextBox getTxtGogitaiNumber() {
        return this.getShinsakaiJoho().getTxtGogitaiNumber();
    }

    @JsonIgnore
    public void  setTxtGogitaiNumber(TextBox txtGogitaiNumber) {
        this.getShinsakaiJoho().setTxtGogitaiNumber(txtGogitaiNumber);
    }

    @JsonIgnore
    public TextBoxNum getTxtYoteiTeiin() {
        return this.getShinsakaiJoho().getTxtYoteiTeiin();
    }

    @JsonIgnore
    public void  setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.getShinsakaiJoho().setTxtYoteiTeiin(txtYoteiTeiin);
    }

    @JsonIgnore
    public TextBoxNum getTxtWaritsukeNinzu() {
        return this.getShinsakaiJoho().getTxtWaritsukeNinzu();
    }

    @JsonIgnore
    public void  setTxtWaritsukeNinzu(TextBoxNum txtWaritsukeNinzu) {
        this.getShinsakaiJoho().setTxtWaritsukeNinzu(txtWaritsukeNinzu);
    }

    @JsonIgnore
    public TextBox getTxtStatus() {
        return this.getShinsakaiJoho().getTxtStatus();
    }

    @JsonIgnore
    public void  setTxtStatus(TextBox txtStatus) {
        this.getShinsakaiJoho().setTxtStatus(txtStatus);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiKaijo() {
        return this.getShinsakaiJoho().getTxtShinsakaiKaijo();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaijo(TextBox txtShinsakaiKaijo) {
        this.getShinsakaiJoho().setTxtShinsakaiKaijo(txtShinsakaiKaijo);
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiChiku() {
        return this.getShinsakaiJoho().getTxtShinsakaiChiku();
    }

    @JsonIgnore
    public void  setTxtShinsakaiChiku(TextBox txtShinsakaiChiku) {
        this.getShinsakaiJoho().setTxtShinsakaiChiku(txtShinsakaiChiku);
    }

    @JsonIgnore
    public TextBox getTxtShinsakauChikuName() {
        return this.getShinsakaiJoho().getTxtShinsakauChikuName();
    }

    @JsonIgnore
    public void  setTxtShinsakauChikuName(TextBox txtShinsakauChikuName) {
        this.getShinsakaiJoho().setTxtShinsakauChikuName(txtShinsakauChikuName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiDate() {
        return this.getShinsakaiJoho().getTxtKaisaiDate();
    }

    @JsonIgnore
    public void  setTxtKaisaiDate(TextBoxFlexibleDate txtKaisaiDate) {
        this.getShinsakaiJoho().setTxtKaisaiDate(txtKaisaiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiKaishiTime() {
        return this.getShinsakaiJoho().getTxtYoteiKaishiTime();
    }

    @JsonIgnore
    public void  setTxtYoteiKaishiTime(TextBoxTime txtYoteiKaishiTime) {
        this.getShinsakaiJoho().setTxtYoteiKaishiTime(txtYoteiKaishiTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiShuryoTime() {
        return this.getShinsakaiJoho().getTxtYoteiShuryoTime();
    }

    @JsonIgnore
    public void  setTxtYoteiShuryoTime(TextBoxTime txtYoteiShuryoTime) {
        this.getShinsakaiJoho().setTxtYoteiShuryoTime(txtYoteiShuryoTime);
    }

    @JsonIgnore
    public CheckBoxList getChkNinchishoOnly() {
        return this.getShinsakaiJoho().getChkNinchishoOnly();
    }

    @JsonIgnore
    public void  setChkNinchishoOnly(CheckBoxList chkNinchishoOnly) {
        this.getShinsakaiJoho().setChkNinchishoOnly(chkNinchishoOnly);
    }

    @JsonIgnore
    public Label getLblTaishosha() {
        return this.getWaritsukeTaishoshaIchiran().getLblTaishosha();
    }

    @JsonIgnore
    public void  setLblTaishosha(Label lblTaishosha) {
        this.getWaritsukeTaishoshaIchiran().setLblTaishosha(lblTaishosha);
    }

    @JsonIgnore
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return this.getWaritsukeTaishoshaIchiran().getDgTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.getWaritsukeTaishoshaIchiran().setDgTaishoshaIchiran(dgTaishoshaIchiran);
    }

    @JsonIgnore
    public Label getLblKohoshaIchiran() {
        return this.getWaritsukeKohoshaIchiran().getLblKohoshaIchiran();
    }

    @JsonIgnore
    public void  setLblKohoshaIchiran(Label lblKohoshaIchiran) {
        this.getWaritsukeKohoshaIchiran().setLblKohoshaIchiran(lblKohoshaIchiran);
    }

    @JsonIgnore
    public DataGrid<dgWaritsukeKohoshaIchiran_Row> getDgWaritsukeKohoshaIchiran() {
        return this.getWaritsukeKohoshaIchiran().getDgWaritsukeKohoshaIchiran();
    }

    @JsonIgnore
    public void  setDgWaritsukeKohoshaIchiran(DataGrid<dgWaritsukeKohoshaIchiran_Row> dgWaritsukeKohoshaIchiran) {
        this.getWaritsukeKohoshaIchiran().setDgWaritsukeKohoshaIchiran(dgWaritsukeKohoshaIchiran);
    }

    // </editor-fold>
}
