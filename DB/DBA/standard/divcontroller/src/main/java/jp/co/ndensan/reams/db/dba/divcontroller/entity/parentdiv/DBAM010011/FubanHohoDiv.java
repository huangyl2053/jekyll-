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
 * FubanHoho のクラスファイル
 *
 * @reamsid_L DBA-1200-010 suguangjun
 */
public class FubanHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHihokenshaBangoFubanHoho")
    private DropDownList ddlHihokenshaBangoFubanHoho;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("JidoFubanKaishiNo")
    private JidoFubanKaishiNoDiv JidoFubanKaishiNo;
    @JsonProperty("lblJidoFubanKaishiNo")
    private Label lblJidoFubanKaishiNo;
    @JsonProperty("ln2")
    private HorizontalLine ln2;
    @JsonProperty("FubanMotoJoho")
    private FubanMotoJohoDiv FubanMotoJoho;
    @JsonProperty("MaeFukaJoho")
    private MaeFukaJohoDiv MaeFukaJoho;
    @JsonProperty("AtoFukaJoho")
    private AtoFukaJohoDiv AtoFukaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHihokenshaBangoFubanHoho
     * @return ddlHihokenshaBangoFubanHoho
     */
    @JsonProperty("ddlHihokenshaBangoFubanHoho")
    public DropDownList getDdlHihokenshaBangoFubanHoho() {
        return ddlHihokenshaBangoFubanHoho;
    }

    /*
     * setddlHihokenshaBangoFubanHoho
     * @param ddlHihokenshaBangoFubanHoho ddlHihokenshaBangoFubanHoho
     */
    @JsonProperty("ddlHihokenshaBangoFubanHoho")
    public void setDdlHihokenshaBangoFubanHoho(DropDownList ddlHihokenshaBangoFubanHoho) {
        this.ddlHihokenshaBangoFubanHoho = ddlHihokenshaBangoFubanHoho;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getJidoFubanKaishiNo
     * @return JidoFubanKaishiNo
     */
    @JsonProperty("JidoFubanKaishiNo")
    public JidoFubanKaishiNoDiv getJidoFubanKaishiNo() {
        return JidoFubanKaishiNo;
    }

    /*
     * setJidoFubanKaishiNo
     * @param JidoFubanKaishiNo JidoFubanKaishiNo
     */
    @JsonProperty("JidoFubanKaishiNo")
    public void setJidoFubanKaishiNo(JidoFubanKaishiNoDiv JidoFubanKaishiNo) {
        this.JidoFubanKaishiNo = JidoFubanKaishiNo;
    }

    /*
     * getlblJidoFubanKaishiNo
     * @return lblJidoFubanKaishiNo
     */
    @JsonProperty("lblJidoFubanKaishiNo")
    public Label getLblJidoFubanKaishiNo() {
        return lblJidoFubanKaishiNo;
    }

    /*
     * setlblJidoFubanKaishiNo
     * @param lblJidoFubanKaishiNo lblJidoFubanKaishiNo
     */
    @JsonProperty("lblJidoFubanKaishiNo")
    public void setLblJidoFubanKaishiNo(Label lblJidoFubanKaishiNo) {
        this.lblJidoFubanKaishiNo = lblJidoFubanKaishiNo;
    }

    /*
     * getln2
     * @return ln2
     */
    @JsonProperty("ln2")
    public HorizontalLine getLn2() {
        return ln2;
    }

    /*
     * setln2
     * @param ln2 ln2
     */
    @JsonProperty("ln2")
    public void setLn2(HorizontalLine ln2) {
        this.ln2 = ln2;
    }

    /*
     * getFubanMotoJoho
     * @return FubanMotoJoho
     */
    @JsonProperty("FubanMotoJoho")
    public FubanMotoJohoDiv getFubanMotoJoho() {
        return FubanMotoJoho;
    }

    /*
     * setFubanMotoJoho
     * @param FubanMotoJoho FubanMotoJoho
     */
    @JsonProperty("FubanMotoJoho")
    public void setFubanMotoJoho(FubanMotoJohoDiv FubanMotoJoho) {
        this.FubanMotoJoho = FubanMotoJoho;
    }

    /*
     * getMaeFukaJoho
     * @return MaeFukaJoho
     */
    @JsonProperty("MaeFukaJoho")
    public MaeFukaJohoDiv getMaeFukaJoho() {
        return MaeFukaJoho;
    }

    /*
     * setMaeFukaJoho
     * @param MaeFukaJoho MaeFukaJoho
     */
    @JsonProperty("MaeFukaJoho")
    public void setMaeFukaJoho(MaeFukaJohoDiv MaeFukaJoho) {
        this.MaeFukaJoho = MaeFukaJoho;
    }

    /*
     * getAtoFukaJoho
     * @return AtoFukaJoho
     */
    @JsonProperty("AtoFukaJoho")
    public AtoFukaJohoDiv getAtoFukaJoho() {
        return AtoFukaJoho;
    }

    /*
     * setAtoFukaJoho
     * @param AtoFukaJoho AtoFukaJoho
     */
    @JsonProperty("AtoFukaJoho")
    public void setAtoFukaJoho(AtoFukaJohoDiv AtoFukaJoho) {
        this.AtoFukaJoho = AtoFukaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getSpaceJidoFuban() {
        return this.getJidoFubanKaishiNo().getSpaceJidoFuban();
    }

    @JsonIgnore
    public void setSpaceJidoFuban(Space spaceJidoFuban) {
        this.getJidoFubanKaishiNo().setSpaceJidoFuban(spaceJidoFuban);
    }

    @JsonIgnore
    public TextBoxCode getTxtJidoFubanKaishiNo() {
        return this.getJidoFubanKaishiNo().getTxtJidoFubanKaishiNo();
    }

    @JsonIgnore
    public void setTxtJidoFubanKaishiNo(TextBoxCode txtJidoFubanKaishiNo) {
        this.getJidoFubanKaishiNo().setTxtJidoFubanKaishiNo(txtJidoFubanKaishiNo);
    }

    @JsonIgnore
    public DropDownList getDdlFubanmotoJoho() {
        return this.getFubanMotoJoho().getDdlFubanmotoJoho();
    }

    @JsonIgnore
    public void setDdlFubanmotoJoho(DropDownList ddlFubanmotoJoho) {
        this.getFubanMotoJoho().setDdlFubanmotoJoho(ddlFubanmotoJoho);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaishiKetaIchi() {
        return this.getFubanMotoJoho().getTxtKaishiKetaIchi();
    }

    @JsonIgnore
    public void setTxtKaishiKetaIchi(TextBoxNum txtKaishiKetaIchi) {
        this.getFubanMotoJoho().setTxtKaishiKetaIchi(txtKaishiKetaIchi);
    }

    @JsonIgnore
    public TextBoxNum getTxtYukoKetasu() {
        return this.getFubanMotoJoho().getTxtYukoKetasu();
    }

    @JsonIgnore
    public void setTxtYukoKetasu(TextBoxNum txtYukoKetasu) {
        this.getFubanMotoJoho().setTxtYukoKetasu(txtYukoKetasu);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaeFukaKetasu() {
        return this.getMaeFukaJoho().getTxtMaeFukaKetasu();
    }

    @JsonIgnore
    public void setTxtMaeFukaKetasu(TextBoxNum txtMaeFukaKetasu) {
        this.getMaeFukaJoho().setTxtMaeFukaKetasu(txtMaeFukaKetasu);
    }

    @JsonIgnore
    public TextBoxCode getTxtMaeFukaCode() {
        return this.getMaeFukaJoho().getTxtMaeFukaCode();
    }

    @JsonIgnore
    public void setTxtMaeFukaCode(TextBoxCode txtMaeFukaCode) {
        this.getMaeFukaJoho().setTxtMaeFukaCode(txtMaeFukaCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtAtoFukaKetasu() {
        return this.getAtoFukaJoho().getTxtAtoFukaKetasu();
    }

    @JsonIgnore
    public void setTxtAtoFukaKetasu(TextBoxNum txtAtoFukaKetasu) {
        this.getAtoFukaJoho().setTxtAtoFukaKetasu(txtAtoFukaKetasu);
    }

    @JsonIgnore
    public TextBoxCode getTxtAtoFukaCode() {
        return this.getAtoFukaJoho().getTxtAtoFukaCode();
    }

    @JsonIgnore
    public void setTxtAtoFukaCode(TextBoxCode txtAtoFukaCode) {
        this.getAtoFukaJoho().setTxtAtoFukaCode(txtAtoFukaCode);
    }

    // </editor-fold>
}
