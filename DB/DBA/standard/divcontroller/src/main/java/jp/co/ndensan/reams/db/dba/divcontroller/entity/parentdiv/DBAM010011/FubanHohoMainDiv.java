package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * FubanHohoMain のクラスファイル
 *
 * @reamsid_L DBA-1200-010 suguangjun
 */
public class FubanHohoMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FubanHoho")
    private FubanHohoDiv FubanHoho;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFubanHoho
     * @return FubanHoho
     */
    @JsonProperty("FubanHoho")
    public FubanHohoDiv getFubanHoho() {
        return FubanHoho;
    }

    /*
     * setFubanHoho
     * @param FubanHoho FubanHoho
     */
    @JsonProperty("FubanHoho")
    public void setFubanHoho(FubanHohoDiv FubanHoho) {
        this.FubanHoho = FubanHoho;
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
    public DropDownList getDdlHihokenshaBangoFubanHoho() {
        return this.getFubanHoho().getDdlHihokenshaBangoFubanHoho();
    }

    @JsonIgnore
    public void setDdlHihokenshaBangoFubanHoho(DropDownList ddlHihokenshaBangoFubanHoho) {
        this.getFubanHoho().setDdlHihokenshaBangoFubanHoho(ddlHihokenshaBangoFubanHoho);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getFubanHoho().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getFubanHoho().setLin1(lin1);
    }

    @JsonIgnore
    public JidoFubanKaishiNoDiv getJidoFubanKaishiNo() {
        return this.getFubanHoho().getJidoFubanKaishiNo();
    }

    @JsonIgnore
    public void setJidoFubanKaishiNo(JidoFubanKaishiNoDiv JidoFubanKaishiNo) {
        this.getFubanHoho().setJidoFubanKaishiNo(JidoFubanKaishiNo);
    }

    @JsonIgnore
    public Space getSpaceJidoFuban() {
        return this.getFubanHoho().getJidoFubanKaishiNo().getSpaceJidoFuban();
    }

    @JsonIgnore
    public void setSpaceJidoFuban(Space spaceJidoFuban) {
        this.getFubanHoho().getJidoFubanKaishiNo().setSpaceJidoFuban(spaceJidoFuban);
    }

    @JsonIgnore
    public TextBoxCode getTxtJidoFubanKaishiNo() {
        return this.getFubanHoho().getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo();
    }

    @JsonIgnore
    public void setTxtJidoFubanKaishiNo(TextBoxCode txtJidoFubanKaishiNo) {
        this.getFubanHoho().getJidoFubanKaishiNo().setTxtJidoFubanKaishiNo(txtJidoFubanKaishiNo);
    }

    @JsonIgnore
    public Label getLblJidoFubanKaishiNo() {
        return this.getFubanHoho().getLblJidoFubanKaishiNo();
    }

    @JsonIgnore
    public void setLblJidoFubanKaishiNo(Label lblJidoFubanKaishiNo) {
        this.getFubanHoho().setLblJidoFubanKaishiNo(lblJidoFubanKaishiNo);
    }

    @JsonIgnore
    public HorizontalLine getLn2() {
        return this.getFubanHoho().getLn2();
    }

    @JsonIgnore
    public void setLn2(HorizontalLine ln2) {
        this.getFubanHoho().setLn2(ln2);
    }

    @JsonIgnore
    public FubanMotoJohoDiv getFubanMotoJoho() {
        return this.getFubanHoho().getFubanMotoJoho();
    }

    @JsonIgnore
    public void setFubanMotoJoho(FubanMotoJohoDiv FubanMotoJoho) {
        this.getFubanHoho().setFubanMotoJoho(FubanMotoJoho);
    }

    @JsonIgnore
    public DropDownList getDdlFubanmotoJoho() {
        return this.getFubanHoho().getFubanMotoJoho().getDdlFubanmotoJoho();
    }

    @JsonIgnore
    public void setDdlFubanmotoJoho(DropDownList ddlFubanmotoJoho) {
        this.getFubanHoho().getFubanMotoJoho().setDdlFubanmotoJoho(ddlFubanmotoJoho);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaishiKetaIchi() {
        return this.getFubanHoho().getFubanMotoJoho().getTxtKaishiKetaIchi();
    }

    @JsonIgnore
    public void setTxtKaishiKetaIchi(TextBoxNum txtKaishiKetaIchi) {
        this.getFubanHoho().getFubanMotoJoho().setTxtKaishiKetaIchi(txtKaishiKetaIchi);
    }

    @JsonIgnore
    public TextBoxNum getTxtYukoKetasu() {
        return this.getFubanHoho().getFubanMotoJoho().getTxtYukoKetasu();
    }

    @JsonIgnore
    public void setTxtYukoKetasu(TextBoxNum txtYukoKetasu) {
        this.getFubanHoho().getFubanMotoJoho().setTxtYukoKetasu(txtYukoKetasu);
    }

    @JsonIgnore
    public MaeFukaJohoDiv getMaeFukaJoho() {
        return this.getFubanHoho().getMaeFukaJoho();
    }

    @JsonIgnore
    public void setMaeFukaJoho(MaeFukaJohoDiv MaeFukaJoho) {
        this.getFubanHoho().setMaeFukaJoho(MaeFukaJoho);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeFukaKetasu() {
        return this.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaKetasu();
    }

    @JsonIgnore
    public void setTxtMaeFukaKetasu(TextBoxNum txtMaeFukaKetasu) {
        this.getFubanHoho().getMaeFukaJoho().setTxtMaeFukaKetasu(txtMaeFukaKetasu);
    }

    @JsonIgnore
    public TextBoxCode getTxtMaeFukaCode() {
        return this.getFubanHoho().getMaeFukaJoho().getTxtMaeFukaCode();
    }

    @JsonIgnore
    public void setTxtMaeFukaCode(TextBoxCode txtMaeFukaCode) {
        this.getFubanHoho().getMaeFukaJoho().setTxtMaeFukaCode(txtMaeFukaCode);
    }

    @JsonIgnore
    public AtoFukaJohoDiv getAtoFukaJoho() {
        return this.getFubanHoho().getAtoFukaJoho();
    }

    @JsonIgnore
    public void setAtoFukaJoho(AtoFukaJohoDiv AtoFukaJoho) {
        this.getFubanHoho().setAtoFukaJoho(AtoFukaJoho);
    }

    @JsonIgnore
    public TextBoxNum getTxtAtoFukaKetasu() {
        return this.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaKetasu();
    }

    @JsonIgnore
    public void setTxtAtoFukaKetasu(TextBoxNum txtAtoFukaKetasu) {
        this.getFubanHoho().getAtoFukaJoho().setTxtAtoFukaKetasu(txtAtoFukaKetasu);
    }

    @JsonIgnore
    public TextBoxCode getTxtAtoFukaCode() {
        return this.getFubanHoho().getAtoFukaJoho().getTxtAtoFukaCode();
    }

    @JsonIgnore
    public void setTxtAtoFukaCode(TextBoxCode txtAtoFukaCode) {
        this.getFubanHoho().getAtoFukaJoho().setTxtAtoFukaCode(txtAtoFukaCode);
    }

    // </editor-fold>
}
