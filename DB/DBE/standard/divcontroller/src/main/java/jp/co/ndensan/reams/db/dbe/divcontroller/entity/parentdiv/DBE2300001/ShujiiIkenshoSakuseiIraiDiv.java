package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoSakuseiIrai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoSakuseiIraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Search")
    private SearchDiv Search;
    @JsonProperty("IkenshoSakuseiTaishoWaritsuke")
    private IkenshoSakuseiTaishoWaritsukeDiv IkenshoSakuseiTaishoWaritsuke;
    @JsonProperty("KanryoMessage")
    private KaigoKanryoMessageDiv KanryoMessage;
    @JsonProperty("shinseishaKanriNo")
    private RString shinseishaKanriNo;
    @JsonProperty("hiddenIuputModel")
    private RString hiddenIuputModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearch
     * @return Search
     */
    @JsonProperty("Search")
    public SearchDiv getSearch() {
        return Search;
    }

    /*
     * setSearch
     * @param Search Search
     */
    @JsonProperty("Search")
    public void setSearch(SearchDiv Search) {
        this.Search = Search;
    }

    /*
     * getIkenshoSakuseiTaishoWaritsuke
     * @return IkenshoSakuseiTaishoWaritsuke
     */
    @JsonProperty("IkenshoSakuseiTaishoWaritsuke")
    public IkenshoSakuseiTaishoWaritsukeDiv getIkenshoSakuseiTaishoWaritsuke() {
        return IkenshoSakuseiTaishoWaritsuke;
    }

    /*
     * setIkenshoSakuseiTaishoWaritsuke
     * @param IkenshoSakuseiTaishoWaritsuke IkenshoSakuseiTaishoWaritsuke
     */
    @JsonProperty("IkenshoSakuseiTaishoWaritsuke")
    public void setIkenshoSakuseiTaishoWaritsuke(IkenshoSakuseiTaishoWaritsukeDiv IkenshoSakuseiTaishoWaritsuke) {
        this.IkenshoSakuseiTaishoWaritsuke = IkenshoSakuseiTaishoWaritsuke;
    }

    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public IKaigoKanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * getshinseishaKanriNo
     * @return shinseishaKanriNo
     */
    @JsonProperty("shinseishaKanriNo")
    public RString getShinseishaKanriNo() {
        return shinseishaKanriNo;
    }

    /*
     * setshinseishaKanriNo
     * @param shinseishaKanriNo shinseishaKanriNo
     */
    @JsonProperty("shinseishaKanriNo")
    public void setShinseishaKanriNo(RString shinseishaKanriNo) {
        this.shinseishaKanriNo = shinseishaKanriNo;
    }

    /*
     * gethiddenIuputModel
     * @return hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public RString getHiddenIuputModel() {
        return hiddenIuputModel;
    }

    /*
     * sethiddenIuputModel
     * @param hiddenIuputModel hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public void setHiddenIuputModel(RString hiddenIuputModel) {
        this.hiddenIuputModel = hiddenIuputModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnClearKensakuJoken() {
        return this.getSearch().getBtnClearKensakuJoken();
    }

    @JsonIgnore
    public void  setBtnClearKensakuJoken(Button btnClearKensakuJoken) {
        this.getSearch().setBtnClearKensakuJoken(btnClearKensakuJoken);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getSearch().getCcdHokenshaList();
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryoKikanAndShujiiInput() {
        return this.getSearch().getCcdShujiiIryoKikanAndShujiiInput();
    }

    @JsonIgnore
    public WaritsukeZumiTaishoshaDiv getWaritsukeZumiTaishosha() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getWaritsukeZumiTaishosha();
    }

    @JsonIgnore
    public void  setWaritsukeZumiTaishosha(WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha) {
        this.getIkenshoSakuseiTaishoWaritsuke().setWaritsukeZumiTaishosha(WaritsukeZumiTaishosha);
    }

    @JsonIgnore
    public DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> getDgWaritsukeZumiShinseishaIchiran() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getWaritsukeZumiTaishosha().getDgWaritsukeZumiShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgWaritsukeZumiShinseishaIchiran(DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran) {
        this.getIkenshoSakuseiTaishoWaritsuke().getWaritsukeZumiTaishosha().setDgWaritsukeZumiShinseishaIchiran(dgWaritsukeZumiShinseishaIchiran);
    }

    @JsonIgnore
    public ShinseishaWaritsukeKaijoDiv getShinseishaWaritsukeKaijo() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getShinseishaWaritsukeKaijo();
    }

    @JsonIgnore
    public void  setShinseishaWaritsukeKaijo(ShinseishaWaritsukeKaijoDiv ShinseishaWaritsukeKaijo) {
        this.getIkenshoSakuseiTaishoWaritsuke().setShinseishaWaritsukeKaijo(ShinseishaWaritsukeKaijo);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoSakuseiIraiDay() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getShinseishaWaritsukeKaijo().getTxtIkenshoSakuseiIraiDay();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiDay(TextBoxDate txtIkenshoSakuseiIraiDay) {
        this.getIkenshoSakuseiTaishoWaritsuke().getShinseishaWaritsukeKaijo().setTxtIkenshoSakuseiIraiDay(txtIkenshoSakuseiIraiDay);
    }

    @JsonIgnore
    public Button getBtnWaritsuke() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getShinseishaWaritsukeKaijo().getBtnWaritsuke();
    }

    @JsonIgnore
    public void  setBtnWaritsuke(Button btnWaritsuke) {
        this.getIkenshoSakuseiTaishoWaritsuke().getShinseishaWaritsukeKaijo().setBtnWaritsuke(btnWaritsuke);
    }

    @JsonIgnore
    public Button getBtnKaijo() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getShinseishaWaritsukeKaijo().getBtnKaijo();
    }

    @JsonIgnore
    public void  setBtnKaijo(Button btnKaijo) {
        this.getIkenshoSakuseiTaishoWaritsuke().getShinseishaWaritsukeKaijo().setBtnKaijo(btnKaijo);
    }

    @JsonIgnore
    public ButtonDialog getBtnPrint() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getBtnPrint();
    }

    @JsonIgnore
    public void  setBtnPrint(ButtonDialog btnPrint) {
        this.getIkenshoSakuseiTaishoWaritsuke().setBtnPrint(btnPrint);
    }

    @JsonIgnore
    public MiwaritsukeShinseishaDiv getMiwaritsukeShinseisha() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getMiwaritsukeShinseisha();
    }

    @JsonIgnore
    public void  setMiwaritsukeShinseisha(MiwaritsukeShinseishaDiv MiwaritsukeShinseisha) {
        this.getIkenshoSakuseiTaishoWaritsuke().setMiwaritsukeShinseisha(MiwaritsukeShinseisha);
    }

    @JsonIgnore
    public DataGrid<dgMiwaritsukeShinseishaIchiran_Row> getDgMiwaritsukeShinseishaIchiran() {
        return this.getIkenshoSakuseiTaishoWaritsuke().getMiwaritsukeShinseisha().getDgMiwaritsukeShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgMiwaritsukeShinseishaIchiran(DataGrid<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran) {
        this.getIkenshoSakuseiTaishoWaritsuke().getMiwaritsukeShinseisha().setDgMiwaritsukeShinseishaIchiran(dgMiwaritsukeShinseishaIchiran);
    }

    // </editor-fold>
}
