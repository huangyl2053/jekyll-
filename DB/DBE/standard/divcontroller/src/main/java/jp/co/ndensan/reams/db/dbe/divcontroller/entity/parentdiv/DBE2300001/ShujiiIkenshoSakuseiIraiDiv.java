package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.IHihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * ShujiiIkenshoSakuseiIrai のクラスファイル
 *
 * @author 自動生成
 */
public class ShujiiIkenshoSakuseiIraiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinseishaIchiran")
    private ShinseishaIchiranDiv ShinseishaIchiran;
    @JsonProperty("ShujiiIkenshoIraiJohoInput")
    private ShujiiIkenshoIraiJohoInputDiv ShujiiIkenshoIraiJohoInput;
    @JsonProperty("iraiprint")
    private iraiprintDiv iraiprint;
    @JsonProperty("meireisho")
    private meireishoDiv meireisho;
    @JsonProperty("ccdHihokenshaFinder")
    private HihokenshaFinderDiv ccdHihokenshaFinder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinseishaIchiran
     * @return ShinseishaIchiran
     */
    @JsonProperty("ShinseishaIchiran")
    public ShinseishaIchiranDiv getShinseishaIchiran() {
        return ShinseishaIchiran;
    }

    /*
     * setShinseishaIchiran
     * @param ShinseishaIchiran ShinseishaIchiran
     */
    @JsonProperty("ShinseishaIchiran")
    public void setShinseishaIchiran(ShinseishaIchiranDiv ShinseishaIchiran) {
        this.ShinseishaIchiran = ShinseishaIchiran;
    }

    /*
     * getShujiiIkenshoIraiJohoInput
     * @return ShujiiIkenshoIraiJohoInput
     */
    @JsonProperty("ShujiiIkenshoIraiJohoInput")
    public ShujiiIkenshoIraiJohoInputDiv getShujiiIkenshoIraiJohoInput() {
        return ShujiiIkenshoIraiJohoInput;
    }

    /*
     * setShujiiIkenshoIraiJohoInput
     * @param ShujiiIkenshoIraiJohoInput ShujiiIkenshoIraiJohoInput
     */
    @JsonProperty("ShujiiIkenshoIraiJohoInput")
    public void setShujiiIkenshoIraiJohoInput(ShujiiIkenshoIraiJohoInputDiv ShujiiIkenshoIraiJohoInput) {
        this.ShujiiIkenshoIraiJohoInput = ShujiiIkenshoIraiJohoInput;
    }

    /*
     * getiraiprint
     * @return iraiprint
     */
    @JsonProperty("iraiprint")
    public iraiprintDiv getIraiprint() {
        return iraiprint;
    }

    /*
     * setiraiprint
     * @param iraiprint iraiprint
     */
    @JsonProperty("iraiprint")
    public void setIraiprint(iraiprintDiv iraiprint) {
        this.iraiprint = iraiprint;
    }

    /*
     * getmeireisho
     * @return meireisho
     */
    @JsonProperty("meireisho")
    public meireishoDiv getMeireisho() {
        return meireisho;
    }

    /*
     * setmeireisho
     * @param meireisho meireisho
     */
    @JsonProperty("meireisho")
    public void setMeireisho(meireishoDiv meireisho) {
        this.meireisho = meireisho;
    }

    /*
     * getccdHihokenshaFinder
     * @return ccdHihokenshaFinder
     */
    @JsonProperty("ccdHihokenshaFinder")
    public IHihokenshaFinderDiv getCcdHihokenshaFinder() {
        return ccdHihokenshaFinder;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgShinseishaIchiran_Row> getDgShinseishaIchiran() {
        return this.getShinseishaIchiran().getDgShinseishaIchiran();
    }

    @JsonIgnore
    public void setDgShinseishaIchiran(DataGrid<dgShinseishaIchiran_Row> dgShinseishaIchiran) {
        this.getShinseishaIchiran().setDgShinseishaIchiran(dgShinseishaIchiran);
    }

    @JsonIgnore
    public ShujiiIryoKikanNyuryokuDiv getShujiiIryoKikanNyuryoku() {
        return this.getShujiiIkenshoIraiJohoInput().getShujiiIryoKikanNyuryoku();
    }

    @JsonIgnore
    public void setShujiiIryoKikanNyuryoku(ShujiiIryoKikanNyuryokuDiv ShujiiIryoKikanNyuryoku) {
        this.getShujiiIkenshoIraiJohoInput().setShujiiIryoKikanNyuryoku(ShujiiIryoKikanNyuryoku);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryoKikanAndShujiiInput() {
        return this.getShujiiIkenshoIraiJohoInput().getShujiiIryoKikanNyuryoku().getCcdShujiiIryoKikanAndShujiiInput();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkensahoSakuseiIraiDay() {
        return this.getShujiiIkenshoIraiJohoInput().getTxtShujiiIkensahoSakuseiIraiDay();
    }

    @JsonIgnore
    public void setTxtShujiiIkensahoSakuseiIraiDay(TextBoxDate txtShujiiIkensahoSakuseiIraiDay) {
        this.getShujiiIkenshoIraiJohoInput().setTxtShujiiIkensahoSakuseiIraiDay(txtShujiiIkensahoSakuseiIraiDay);
    }

    @JsonIgnore
    public Button getBtnHozon() {
        return this.getShujiiIkenshoIraiJohoInput().getBtnHozon();
    }

    @JsonIgnore
    public void setBtnHozon(Button btnHozon) {
        this.getShujiiIkenshoIraiJohoInput().setBtnHozon(btnHozon);
    }

    @JsonIgnore
    public Button getBtnIrai() {
        return this.getShujiiIkenshoIraiJohoInput().getBtnIrai();
    }

    @JsonIgnore
    public void setBtnIrai(Button btnIrai) {
        this.getShujiiIkenshoIraiJohoInput().setBtnIrai(btnIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkirai() {
        return this.getIraiprint().getChkirai();
    }

    @JsonIgnore
    public void setChkirai(CheckBoxList Chkirai) {
        this.getIraiprint().setChkirai(Chkirai);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakobi() {
        return this.getIraiprint().getTxtHakobi();
    }

    @JsonIgnore
    public void setTxtHakobi(TextBoxDate txtHakobi) {
        this.getIraiprint().setTxtHakobi(txtHakobi);
    }

    @JsonIgnore
    public RadioButton getRadkigen() {
        return this.getIraiprint().getRadkigen();
    }

    @JsonIgnore
    public void setRadkigen(RadioButton radkigen) {
        this.getIraiprint().setRadkigen(radkigen);
    }

    @JsonIgnore
    public TextBoxDate getTxtkigenymd() {
        return this.getIraiprint().getTxtkigenymd();
    }

    @JsonIgnore
    public void setTxtkigenymd(TextBoxDate txtkigenymd) {
        this.getIraiprint().setTxtkigenymd(txtkigenymd);
    }

    @JsonIgnore
    public Space getSp() {
        return this.getIraiprint().getSp();
    }

    @JsonIgnore
    public void setSp(Space Sp) {
        this.getIraiprint().setSp(Sp);
    }

    @JsonIgnore
    public CheckBoxList getChkprint() {
        return this.getIraiprint().getChkprint();
    }

    @JsonIgnore
    public void setChkprint(CheckBoxList Chkprint) {
        this.getIraiprint().setChkprint(Chkprint);
    }

    @JsonIgnore
    public RadioButton getRadjyushin() {
        return this.getMeireisho().getRadjyushin();
    }

    @JsonIgnore
    public void setRadjyushin(RadioButton radjyushin) {
        this.getMeireisho().setRadjyushin(radjyushin);
    }

    @JsonIgnore
    public TextBoxDate getTxtjyushinymd() {
        return this.getMeireisho().getTxtjyushinymd();
    }

    @JsonIgnore
    public void setTxtjyushinymd(TextBoxDate txtjyushinymd) {
        this.getMeireisho().setTxtjyushinymd(txtjyushinymd);
    }

    @JsonIgnore
    public TextBoxTime getTxtjyushintime() {
        return this.getMeireisho().getTxtjyushintime();
    }

    @JsonIgnore
    public void setTxtjyushintime(TextBoxTime txtjyushintime) {
        this.getMeireisho().setTxtjyushintime(txtjyushintime);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getMeireisho().getSpSpace1();
    }

    @JsonIgnore
    public void setSpSpace1(Space spSpace1) {
        this.getMeireisho().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJyushinKikan() {
        return this.getMeireisho().getTxtJyushinKikan();
    }

    @JsonIgnore
    public void setTxtJyushinKikan(TextBoxDateRange txtJyushinKikan) {
        this.getMeireisho().setTxtJyushinKikan(txtJyushinKikan);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getMeireisho().getSpSpace2();
    }

    @JsonIgnore
    public void setSpSpace2(Space spSpace2) {
        this.getMeireisho().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public TextBox getTxtjyushinbasho() {
        return this.getMeireisho().getTxtjyushinbasho();
    }

    @JsonIgnore
    public void setTxtjyushinbasho(TextBox txtjyushinbasho) {
        this.getMeireisho().setTxtjyushinbasho(txtjyushinbasho);
    }

    // </editor-fold>
}
