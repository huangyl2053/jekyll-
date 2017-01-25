package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
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
 * IkenshoSakuseiTaishoWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoSakuseiTaishoWaritsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("WaritsukeZumiTaishosha")
    private WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha;
    @JsonProperty("ShinseishaWaritsukeKaijo")
    private ShinseishaWaritsukeKaijoDiv ShinseishaWaritsukeKaijo;
    @JsonProperty("btnPrint")
    private ButtonDialog btnPrint;
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
     * getbtnPrint
     * @return btnPrint
     */
    @JsonProperty("btnPrint")
    public ButtonDialog getBtnPrint() {
        return btnPrint;
    }

    /*
     * setbtnPrint
     * @param btnPrint btnPrint
     */
    @JsonProperty("btnPrint")
    public void setBtnPrint(ButtonDialog btnPrint) {
        this.btnPrint = btnPrint;
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
    public TextBoxDate getTxtIkenshoSakuseiIraiDay() {
        return this.getShinseishaWaritsukeKaijo().getTxtIkenshoSakuseiIraiDay();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiDay(TextBoxDate txtIkenshoSakuseiIraiDay) {
        this.getShinseishaWaritsukeKaijo().setTxtIkenshoSakuseiIraiDay(txtIkenshoSakuseiIraiDay);
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
