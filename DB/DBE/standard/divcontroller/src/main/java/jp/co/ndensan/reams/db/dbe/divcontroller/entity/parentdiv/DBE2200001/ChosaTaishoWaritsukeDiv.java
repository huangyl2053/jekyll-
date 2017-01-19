package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaTaishoWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaTaishoWaritsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("WaritsukeZumiTaishosha")
    private WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha;
    @JsonProperty("btnIraishotoPrint")
    private ButtonDialog btnIraishotoPrint;
    @JsonProperty("ShinseishaWaritsukeKaijo")
    private ShinseishaWaritsukeKaijoDiv ShinseishaWaritsukeKaijo;
    @JsonProperty("MiwaritsukeShinseisha")
    private MiwaritsukeShinseishaDiv MiwaritsukeShinseisha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getWaritsukeZumiTaishosha
     * @return WaritsukeZumiTaishosha
     */
    @JsonProperty("WaritsukeZumiTaishosha")
    public WaritsukeZumiTaishoshaDiv getWaritsukeZumiTaishosha() {
        return WaritsukeZumiTaishosha;
    }

    /*
     * setWaritsukeZumiTaishosha
     * @param WaritsukeZumiTaishosha WaritsukeZumiTaishosha
     */
    @JsonProperty("WaritsukeZumiTaishosha")
    public void setWaritsukeZumiTaishosha(WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha) {
        this.WaritsukeZumiTaishosha = WaritsukeZumiTaishosha;
    }

    /*
     * getbtnIraishotoPrint
     * @return btnIraishotoPrint
     */
    @JsonProperty("btnIraishotoPrint")
    public ButtonDialog getBtnIraishotoPrint() {
        return btnIraishotoPrint;
    }

    /*
     * setbtnIraishotoPrint
     * @param btnIraishotoPrint btnIraishotoPrint
     */
    @JsonProperty("btnIraishotoPrint")
    public void setBtnIraishotoPrint(ButtonDialog btnIraishotoPrint) {
        this.btnIraishotoPrint = btnIraishotoPrint;
    }

    /*
     * getShinseishaWaritsukeKaijo
     * @return ShinseishaWaritsukeKaijo
     */
    @JsonProperty("ShinseishaWaritsukeKaijo")
    public ShinseishaWaritsukeKaijoDiv getShinseishaWaritsukeKaijo() {
        return ShinseishaWaritsukeKaijo;
    }

    /*
     * setShinseishaWaritsukeKaijo
     * @param ShinseishaWaritsukeKaijo ShinseishaWaritsukeKaijo
     */
    @JsonProperty("ShinseishaWaritsukeKaijo")
    public void setShinseishaWaritsukeKaijo(ShinseishaWaritsukeKaijoDiv ShinseishaWaritsukeKaijo) {
        this.ShinseishaWaritsukeKaijo = ShinseishaWaritsukeKaijo;
    }

    /*
     * getMiwaritsukeShinseisha
     * @return MiwaritsukeShinseisha
     */
    @JsonProperty("MiwaritsukeShinseisha")
    public MiwaritsukeShinseishaDiv getMiwaritsukeShinseisha() {
        return MiwaritsukeShinseisha;
    }

    /*
     * setMiwaritsukeShinseisha
     * @param MiwaritsukeShinseisha MiwaritsukeShinseisha
     */
    @JsonProperty("MiwaritsukeShinseisha")
    public void setMiwaritsukeShinseisha(MiwaritsukeShinseishaDiv MiwaritsukeShinseisha) {
        this.MiwaritsukeShinseisha = MiwaritsukeShinseisha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> getDgWaritsukeZumiShinseishaIchiran() {
        return this.getWaritsukeZumiTaishosha().getDgWaritsukeZumiShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgWaritsukeZumiShinseishaIchiran(DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran) {
        this.getWaritsukeZumiTaishosha().setDgWaritsukeZumiShinseishaIchiran(dgWaritsukeZumiShinseishaIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiDay() {
        return this.getShinseishaWaritsukeKaijo().getTxtChosaIraiDay();
    }

    @JsonIgnore
    public void  setTxtChosaIraiDay(TextBoxDate txtChosaIraiDay) {
        this.getShinseishaWaritsukeKaijo().setTxtChosaIraiDay(txtChosaIraiDay);
    }

    @JsonIgnore
    public Button getBtnWaritsuke() {
        return this.getShinseishaWaritsukeKaijo().getBtnWaritsuke();
    }

    @JsonIgnore
    public void  setBtnWaritsuke(Button btnWaritsuke) {
        this.getShinseishaWaritsukeKaijo().setBtnWaritsuke(btnWaritsuke);
    }

    @JsonIgnore
    public Button getBtnKaijo() {
        return this.getShinseishaWaritsukeKaijo().getBtnKaijo();
    }

    @JsonIgnore
    public void  setBtnKaijo(Button btnKaijo) {
        this.getShinseishaWaritsukeKaijo().setBtnKaijo(btnKaijo);
    }

    @JsonIgnore
    public DataGrid<dgMiwaritsukeShinseishaIchiran_Row> getDgMiwaritsukeShinseishaIchiran() {
        return this.getMiwaritsukeShinseisha().getDgMiwaritsukeShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgMiwaritsukeShinseishaIchiran(DataGrid<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran) {
        this.getMiwaritsukeShinseisha().setDgMiwaritsukeShinseishaIchiran(dgMiwaritsukeShinseishaIchiran);
    }

    // </editor-fold>
}
