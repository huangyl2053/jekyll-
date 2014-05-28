package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.HihokenshaOutlineDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.HihokenshaShujiiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.KankeiIinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.LatestNinteiResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.N2HihokenshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.NinteiShinseishaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.NinteichosainAdvanceEntryDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.NyuinNyushoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.ShichosonRenrakuJikoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.SinseiRiyuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseiJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaOutline")
    private HihokenshaOutlineDiv HihokenshaOutline;
    @JsonProperty("lblYokaigoOrYoshienKubun")
    private Label lblYokaigoOrYoshienKubun;
    @JsonProperty("radYokaigoOrYoshien")
    private RadioButton radYokaigoOrYoshien;
    @JsonProperty("txtShinseiYukoKubun")
    private TextBox txtShinseiYukoKubun;
    @JsonProperty("lblShinseiDate")
    private Label lblShinseiDate;
    @JsonProperty("txtShinseiDate")
    private TextBoxDate txtShinseiDate;
    @JsonProperty("lblShinseiKubunShinseiji")
    private Label lblShinseiKubunShinseiji;
    @JsonProperty("ddlShinseiKubunShinseiji")
    private DropDownList ddlShinseiKubunShinseiji;
    @JsonProperty("lblChiku")
    private Label lblChiku;
    @JsonProperty("ddlChiku")
    private DropDownList ddlChiku;
    @JsonProperty("SinseiRiyu")
    private SinseiRiyuDiv SinseiRiyu;
    @JsonProperty("NinteiShinseisha")
    private NinteiShinseishaDiv NinteiShinseisha;
    @JsonProperty("LatestNinteiResult")
    private LatestNinteiResultDiv LatestNinteiResult;
    @JsonProperty("N2Hihokensha")
    private N2HihokenshaDiv N2Hihokensha;
    @JsonProperty("HihokenshaShujii")
    private HihokenshaShujiiDiv HihokenshaShujii;
    @JsonProperty("NinteichosainAdvanceEntry")
    private NinteichosainAdvanceEntryDiv NinteichosainAdvanceEntry;
    @JsonProperty("NyuinNyusho")
    private NyuinNyushoDiv NyuinNyusho;
    @JsonProperty("lblEnkitsuchiHakkoAgreement")
    private Label lblEnkitsuchiHakkoAgreement;
    @JsonProperty("radEnkitsuchiHakkoAgreement")
    private RadioButton radEnkitsuchiHakkoAgreement;
    @JsonProperty("lblJohoteikyoAgreement")
    private Label lblJohoteikyoAgreement;
    @JsonProperty("radJohoteikyoAgreement")
    private RadioButton radJohoteikyoAgreement;
    @JsonProperty("ShichosonRenrakuJiko")
    private ShichosonRenrakuJikoDiv ShichosonRenrakuJiko;
    @JsonProperty("KankeiIin")
    private KankeiIinDiv KankeiIin;
    @JsonProperty("btnToSaveShinsei")
    private Button btnToSaveShinsei;
    @JsonProperty("btnToBack")
    private Button btnToBack;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaOutline")
    public HihokenshaOutlineDiv getHihokenshaOutline() {
        return HihokenshaOutline;
    }

    @JsonProperty("HihokenshaOutline")
    public void setHihokenshaOutline(HihokenshaOutlineDiv HihokenshaOutline) {
        this.HihokenshaOutline=HihokenshaOutline;
    }

    @JsonProperty("lblYokaigoOrYoshienKubun")
    public Label getLblYokaigoOrYoshienKubun() {
        return lblYokaigoOrYoshienKubun;
    }

    @JsonProperty("lblYokaigoOrYoshienKubun")
    public void setLblYokaigoOrYoshienKubun(Label lblYokaigoOrYoshienKubun) {
        this.lblYokaigoOrYoshienKubun=lblYokaigoOrYoshienKubun;
    }

    @JsonProperty("radYokaigoOrYoshien")
    public RadioButton getRadYokaigoOrYoshien() {
        return radYokaigoOrYoshien;
    }

    @JsonProperty("radYokaigoOrYoshien")
    public void setRadYokaigoOrYoshien(RadioButton radYokaigoOrYoshien) {
        this.radYokaigoOrYoshien=radYokaigoOrYoshien;
    }

    @JsonProperty("txtShinseiYukoKubun")
    public TextBox getTxtShinseiYukoKubun() {
        return txtShinseiYukoKubun;
    }

    @JsonProperty("txtShinseiYukoKubun")
    public void setTxtShinseiYukoKubun(TextBox txtShinseiYukoKubun) {
        this.txtShinseiYukoKubun=txtShinseiYukoKubun;
    }

    @JsonProperty("lblShinseiDate")
    public Label getLblShinseiDate() {
        return lblShinseiDate;
    }

    @JsonProperty("lblShinseiDate")
    public void setLblShinseiDate(Label lblShinseiDate) {
        this.lblShinseiDate=lblShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("lblShinseiKubunShinseiji")
    public Label getLblShinseiKubunShinseiji() {
        return lblShinseiKubunShinseiji;
    }

    @JsonProperty("lblShinseiKubunShinseiji")
    public void setLblShinseiKubunShinseiji(Label lblShinseiKubunShinseiji) {
        this.lblShinseiKubunShinseiji=lblShinseiKubunShinseiji;
    }

    @JsonProperty("ddlShinseiKubunShinseiji")
    public DropDownList getDdlShinseiKubunShinseiji() {
        return ddlShinseiKubunShinseiji;
    }

    @JsonProperty("ddlShinseiKubunShinseiji")
    public void setDdlShinseiKubunShinseiji(DropDownList ddlShinseiKubunShinseiji) {
        this.ddlShinseiKubunShinseiji=ddlShinseiKubunShinseiji;
    }

    @JsonProperty("lblChiku")
    public Label getLblChiku() {
        return lblChiku;
    }

    @JsonProperty("lblChiku")
    public void setLblChiku(Label lblChiku) {
        this.lblChiku=lblChiku;
    }

    @JsonProperty("ddlChiku")
    public DropDownList getDdlChiku() {
        return ddlChiku;
    }

    @JsonProperty("ddlChiku")
    public void setDdlChiku(DropDownList ddlChiku) {
        this.ddlChiku=ddlChiku;
    }

    @JsonProperty("SinseiRiyu")
    public SinseiRiyuDiv getSinseiRiyu() {
        return SinseiRiyu;
    }

    @JsonProperty("SinseiRiyu")
    public void setSinseiRiyu(SinseiRiyuDiv SinseiRiyu) {
        this.SinseiRiyu=SinseiRiyu;
    }

    @JsonProperty("NinteiShinseisha")
    public NinteiShinseishaDiv getNinteiShinseisha() {
        return NinteiShinseisha;
    }

    @JsonProperty("NinteiShinseisha")
    public void setNinteiShinseisha(NinteiShinseishaDiv NinteiShinseisha) {
        this.NinteiShinseisha=NinteiShinseisha;
    }

    @JsonProperty("LatestNinteiResult")
    public LatestNinteiResultDiv getLatestNinteiResult() {
        return LatestNinteiResult;
    }

    @JsonProperty("LatestNinteiResult")
    public void setLatestNinteiResult(LatestNinteiResultDiv LatestNinteiResult) {
        this.LatestNinteiResult=LatestNinteiResult;
    }

    @JsonProperty("N2Hihokensha")
    public N2HihokenshaDiv getN2Hihokensha() {
        return N2Hihokensha;
    }

    @JsonProperty("N2Hihokensha")
    public void setN2Hihokensha(N2HihokenshaDiv N2Hihokensha) {
        this.N2Hihokensha=N2Hihokensha;
    }

    @JsonProperty("HihokenshaShujii")
    public HihokenshaShujiiDiv getHihokenshaShujii() {
        return HihokenshaShujii;
    }

    @JsonProperty("HihokenshaShujii")
    public void setHihokenshaShujii(HihokenshaShujiiDiv HihokenshaShujii) {
        this.HihokenshaShujii=HihokenshaShujii;
    }

    @JsonProperty("NinteichosainAdvanceEntry")
    public NinteichosainAdvanceEntryDiv getNinteichosainAdvanceEntry() {
        return NinteichosainAdvanceEntry;
    }

    @JsonProperty("NinteichosainAdvanceEntry")
    public void setNinteichosainAdvanceEntry(NinteichosainAdvanceEntryDiv NinteichosainAdvanceEntry) {
        this.NinteichosainAdvanceEntry=NinteichosainAdvanceEntry;
    }

    @JsonProperty("NyuinNyusho")
    public NyuinNyushoDiv getNyuinNyusho() {
        return NyuinNyusho;
    }

    @JsonProperty("NyuinNyusho")
    public void setNyuinNyusho(NyuinNyushoDiv NyuinNyusho) {
        this.NyuinNyusho=NyuinNyusho;
    }

    @JsonProperty("lblEnkitsuchiHakkoAgreement")
    public Label getLblEnkitsuchiHakkoAgreement() {
        return lblEnkitsuchiHakkoAgreement;
    }

    @JsonProperty("lblEnkitsuchiHakkoAgreement")
    public void setLblEnkitsuchiHakkoAgreement(Label lblEnkitsuchiHakkoAgreement) {
        this.lblEnkitsuchiHakkoAgreement=lblEnkitsuchiHakkoAgreement;
    }

    @JsonProperty("radEnkitsuchiHakkoAgreement")
    public RadioButton getRadEnkitsuchiHakkoAgreement() {
        return radEnkitsuchiHakkoAgreement;
    }

    @JsonProperty("radEnkitsuchiHakkoAgreement")
    public void setRadEnkitsuchiHakkoAgreement(RadioButton radEnkitsuchiHakkoAgreement) {
        this.radEnkitsuchiHakkoAgreement=radEnkitsuchiHakkoAgreement;
    }

    @JsonProperty("lblJohoteikyoAgreement")
    public Label getLblJohoteikyoAgreement() {
        return lblJohoteikyoAgreement;
    }

    @JsonProperty("lblJohoteikyoAgreement")
    public void setLblJohoteikyoAgreement(Label lblJohoteikyoAgreement) {
        this.lblJohoteikyoAgreement=lblJohoteikyoAgreement;
    }

    @JsonProperty("radJohoteikyoAgreement")
    public RadioButton getRadJohoteikyoAgreement() {
        return radJohoteikyoAgreement;
    }

    @JsonProperty("radJohoteikyoAgreement")
    public void setRadJohoteikyoAgreement(RadioButton radJohoteikyoAgreement) {
        this.radJohoteikyoAgreement=radJohoteikyoAgreement;
    }

    @JsonProperty("ShichosonRenrakuJiko")
    public ShichosonRenrakuJikoDiv getShichosonRenrakuJiko() {
        return ShichosonRenrakuJiko;
    }

    @JsonProperty("ShichosonRenrakuJiko")
    public void setShichosonRenrakuJiko(ShichosonRenrakuJikoDiv ShichosonRenrakuJiko) {
        this.ShichosonRenrakuJiko=ShichosonRenrakuJiko;
    }

    @JsonProperty("KankeiIin")
    public KankeiIinDiv getKankeiIin() {
        return KankeiIin;
    }

    @JsonProperty("KankeiIin")
    public void setKankeiIin(KankeiIinDiv KankeiIin) {
        this.KankeiIin=KankeiIin;
    }

    @JsonProperty("btnToSaveShinsei")
    public Button getBtnToSaveShinsei() {
        return btnToSaveShinsei;
    }

    @JsonProperty("btnToSaveShinsei")
    public void setBtnToSaveShinsei(Button btnToSaveShinsei) {
        this.btnToSaveShinsei=btnToSaveShinsei;
    }

    @JsonProperty("btnToBack")
    public Button getBtnToBack() {
        return btnToBack;
    }

    @JsonProperty("btnToBack")
    public void setBtnToBack(Button btnToBack) {
        this.btnToBack=btnToBack;
    }

}
