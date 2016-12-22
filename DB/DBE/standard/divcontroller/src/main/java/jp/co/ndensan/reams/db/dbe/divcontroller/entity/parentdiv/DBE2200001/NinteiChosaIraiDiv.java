package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaIrai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaIraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaItakusakiAndChosainKihonJoho")
    private ChosaItakusakiAndChosainKihonJohoDiv ChosaItakusakiAndChosainKihonJoho;
    @JsonProperty("ChoisaItakusakiIchiran")
    private ChoisaItakusakiIchiranDiv ChoisaItakusakiIchiran;
    @JsonProperty("ChosainIchiran")
    private ChosainIchiranDiv ChosainIchiran;
    @JsonProperty("ChosaTaishoWaritsuke")
    private ChosaTaishoWaritsukeDiv ChosaTaishoWaritsuke;
    @JsonProperty("iraiprint")
    private iraiprintDiv iraiprint;
    @JsonProperty("KanryoMessage")
    private KaigoKanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaItakusakiAndChosainKihonJoho
     * @return ChosaItakusakiAndChosainKihonJoho
     */
    @JsonProperty("ChosaItakusakiAndChosainKihonJoho")
    public ChosaItakusakiAndChosainKihonJohoDiv getChosaItakusakiAndChosainKihonJoho() {
        return ChosaItakusakiAndChosainKihonJoho;
    }

    /*
     * setChosaItakusakiAndChosainKihonJoho
     * @param ChosaItakusakiAndChosainKihonJoho ChosaItakusakiAndChosainKihonJoho
     */
    @JsonProperty("ChosaItakusakiAndChosainKihonJoho")
    public void setChosaItakusakiAndChosainKihonJoho(ChosaItakusakiAndChosainKihonJohoDiv ChosaItakusakiAndChosainKihonJoho) {
        this.ChosaItakusakiAndChosainKihonJoho = ChosaItakusakiAndChosainKihonJoho;
    }

    /*
     * getChoisaItakusakiIchiran
     * @return ChoisaItakusakiIchiran
     */
    @JsonProperty("ChoisaItakusakiIchiran")
    public ChoisaItakusakiIchiranDiv getChoisaItakusakiIchiran() {
        return ChoisaItakusakiIchiran;
    }

    /*
     * setChoisaItakusakiIchiran
     * @param ChoisaItakusakiIchiran ChoisaItakusakiIchiran
     */
    @JsonProperty("ChoisaItakusakiIchiran")
    public void setChoisaItakusakiIchiran(ChoisaItakusakiIchiranDiv ChoisaItakusakiIchiran) {
        this.ChoisaItakusakiIchiran = ChoisaItakusakiIchiran;
    }

    /*
     * getChosainIchiran
     * @return ChosainIchiran
     */
    @JsonProperty("ChosainIchiran")
    public ChosainIchiranDiv getChosainIchiran() {
        return ChosainIchiran;
    }

    /*
     * setChosainIchiran
     * @param ChosainIchiran ChosainIchiran
     */
    @JsonProperty("ChosainIchiran")
    public void setChosainIchiran(ChosainIchiranDiv ChosainIchiran) {
        this.ChosainIchiran = ChosainIchiran;
    }

    /*
     * getChosaTaishoWaritsuke
     * @return ChosaTaishoWaritsuke
     */
    @JsonProperty("ChosaTaishoWaritsuke")
    public ChosaTaishoWaritsukeDiv getChosaTaishoWaritsuke() {
        return ChosaTaishoWaritsuke;
    }

    /*
     * setChosaTaishoWaritsuke
     * @param ChosaTaishoWaritsuke ChosaTaishoWaritsuke
     */
    @JsonProperty("ChosaTaishoWaritsuke")
    public void setChosaTaishoWaritsuke(ChosaTaishoWaritsukeDiv ChosaTaishoWaritsuke) {
        this.ChosaTaishoWaritsuke = ChosaTaishoWaritsuke;
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
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public IKaigoKanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtChosaItakusakiCode() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosaItakusakiCode(txtChosaItakusakiCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiMeisho() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosaItakusakiMeisho();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiMeisho(TextBox txtChosaItakusakiMeisho) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosaItakusakiMeisho(txtChosaItakusakiMeisho);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiChiku() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosaItakusakiChiku();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiChiku(TextBox txtChosaItakusakiChiku) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosaItakusakiChiku(txtChosaItakusakiChiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCode() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosainCode();
    }

    @JsonIgnore
    public void  setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosainCode(txtChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtChosainShimei() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosainShimei();
    }

    @JsonIgnore
    public void  setTxtChosainShimei(TextBox txtChosainShimei) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosainShimei(txtChosainShimei);
    }

    @JsonIgnore
    public TextBox getTxtChosainChiku() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosainChiku();
    }

    @JsonIgnore
    public void  setTxtChosainChiku(TextBox txtChosainChiku) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosainChiku(txtChosainChiku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChosaItakusakiAndChosainKihonJoho().getCcdHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgChosaItakusakiIchiran_Row> getDgChosaItakusakiIchiran() {
        return this.getChoisaItakusakiIchiran().getDgChosaItakusakiIchiran();
    }

    @JsonIgnore
    public void  setDgChosaItakusakiIchiran(DataGrid<dgChosaItakusakiIchiran_Row> dgChosaItakusakiIchiran) {
        this.getChoisaItakusakiIchiran().setDgChosaItakusakiIchiran(dgChosaItakusakiIchiran);
    }

    @JsonIgnore
    public DataGrid<dgchosainIchiran_Row> getDgchosainIchiran() {
        return this.getChosainIchiran().getDgchosainIchiran();
    }

    @JsonIgnore
    public void  setDgchosainIchiran(DataGrid<dgchosainIchiran_Row> dgchosainIchiran) {
        this.getChosainIchiran().setDgchosainIchiran(dgchosainIchiran);
    }

    @JsonIgnore
    public WaritsukeZumiTaishoshaDiv getWaritsukeZumiTaishosha() {
        return this.getChosaTaishoWaritsuke().getWaritsukeZumiTaishosha();
    }

    @JsonIgnore
    public void  setWaritsukeZumiTaishosha(WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha) {
        this.getChosaTaishoWaritsuke().setWaritsukeZumiTaishosha(WaritsukeZumiTaishosha);
    }

    @JsonIgnore
    public DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> getDgWaritsukeZumiShinseishaIchiran() {
        return this.getChosaTaishoWaritsuke().getWaritsukeZumiTaishosha().getDgWaritsukeZumiShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgWaritsukeZumiShinseishaIchiran(DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran) {
        this.getChosaTaishoWaritsuke().getWaritsukeZumiTaishosha().setDgWaritsukeZumiShinseishaIchiran(dgWaritsukeZumiShinseishaIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiDay() {
        return this.getChosaTaishoWaritsuke().getTxtChosaIraiDay();
    }

    @JsonIgnore
    public void  setTxtChosaIraiDay(TextBoxDate txtChosaIraiDay) {
        this.getChosaTaishoWaritsuke().setTxtChosaIraiDay(txtChosaIraiDay);
    }

    @JsonIgnore
    public Button getBtnWaritsuke() {
        return this.getChosaTaishoWaritsuke().getBtnWaritsuke();
    }

    @JsonIgnore
    public void  setBtnWaritsuke(Button btnWaritsuke) {
        this.getChosaTaishoWaritsuke().setBtnWaritsuke(btnWaritsuke);
    }

    @JsonIgnore
    public Button getBtnKaijo() {
        return this.getChosaTaishoWaritsuke().getBtnKaijo();
    }

    @JsonIgnore
    public void  setBtnKaijo(Button btnKaijo) {
        this.getChosaTaishoWaritsuke().setBtnKaijo(btnKaijo);
    }

    @JsonIgnore
    public MiwaritsukeShinseishaDiv getMiwaritsukeShinseisha() {
        return this.getChosaTaishoWaritsuke().getMiwaritsukeShinseisha();
    }

    @JsonIgnore
    public void  setMiwaritsukeShinseisha(MiwaritsukeShinseishaDiv MiwaritsukeShinseisha) {
        this.getChosaTaishoWaritsuke().setMiwaritsukeShinseisha(MiwaritsukeShinseisha);
    }

    @JsonIgnore
    public DataGrid<dgMiwaritsukeShinseishaIchiran_Row> getDgMiwaritsukeShinseishaIchiran() {
        return this.getChosaTaishoWaritsuke().getMiwaritsukeShinseisha().getDgMiwaritsukeShinseishaIchiran();
    }

    @JsonIgnore
    public void  setDgMiwaritsukeShinseishaIchiran(DataGrid<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran) {
        this.getChosaTaishoWaritsuke().getMiwaritsukeShinseisha().setDgMiwaritsukeShinseishaIchiran(dgMiwaritsukeShinseishaIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxthokkoymd() {
        return this.getIraiprint().getTxthokkoymd();
    }

    @JsonIgnore
    public void  setTxthokkoymd(TextBoxDate txthokkoymd) {
        this.getIraiprint().setTxthokkoymd(txthokkoymd);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return this.getIraiprint().getCcdBunshoBangoInput();
    }

    @JsonIgnore
    public CheckBoxList getChkirai() {
        return this.getIraiprint().getChkirai();
    }

    @JsonIgnore
    public void  setChkirai(CheckBoxList Chkirai) {
        this.getIraiprint().setChkirai(Chkirai);
    }

    @JsonIgnore
    public RadioButton getRadkigen() {
        return this.getIraiprint().getRadkigen();
    }

    @JsonIgnore
    public void  setRadkigen(RadioButton radkigen) {
        this.getIraiprint().setRadkigen(radkigen);
    }

    @JsonIgnore
    public TextBoxDate getTxtkigenymd() {
        return this.getIraiprint().getTxtkigenymd();
    }

    @JsonIgnore
    public void  setTxtkigenymd(TextBoxDate txtkigenymd) {
        this.getIraiprint().setTxtkigenymd(txtkigenymd);
    }

    @JsonIgnore
    public NinteiChosahyoPrintListDiv getNinteiChosahyoPrintList() {
        return this.getIraiprint().getNinteiChosahyoPrintList();
    }

    @JsonIgnore
    public void  setNinteiChosahyoPrintList(NinteiChosahyoPrintListDiv NinteiChosahyoPrintList) {
        this.getIraiprint().setNinteiChosahyoPrintList(NinteiChosahyoPrintList);
    }

    @JsonIgnore
    public CheckBoxList getChkchosa() {
        return this.getIraiprint().getNinteiChosahyoPrintList().getChkchosa();
    }

    @JsonIgnore
    public void  setChkchosa(CheckBoxList Chkchosa) {
        this.getIraiprint().getNinteiChosahyoPrintList().setChkchosa(Chkchosa);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaOcr() {
        return this.getIraiprint().getNinteiChosahyoPrintList().getChkchosaOcr();
    }

    @JsonIgnore
    public void  setChkchosaOcr(CheckBoxList ChkchosaOcr) {
        this.getIraiprint().getNinteiChosahyoPrintList().setChkchosaOcr(ChkchosaOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaSonota() {
        return this.getIraiprint().getNinteiChosahyoPrintList().getChkchosaSonota();
    }

    @JsonIgnore
    public void  setChkchosaSonota(CheckBoxList ChkchosaSonota) {
        this.getIraiprint().getNinteiChosahyoPrintList().setChkchosaSonota(ChkchosaSonota);
    }

    @JsonIgnore
    public ChosahyoTokkijikoSelectDiv getChosahyoTokkijikoSelect() {
        return this.getIraiprint().getChosahyoTokkijikoSelect();
    }

    @JsonIgnore
    public void  setChosahyoTokkijikoSelect(ChosahyoTokkijikoSelectDiv ChosahyoTokkijikoSelect) {
        this.getIraiprint().setChosahyoTokkijikoSelect(ChosahyoTokkijikoSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoTokkijiko() {
        return this.getIraiprint().getChosahyoTokkijikoSelect().getChkChosahyoTokkijiko();
    }

    @JsonIgnore
    public void  setChkChosahyoTokkijiko(CheckBoxList chkChosahyoTokkijiko) {
        this.getIraiprint().getChosahyoTokkijikoSelect().setChkChosahyoTokkijiko(chkChosahyoTokkijiko);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkijikoTenyuryoku() {
        return this.getIraiprint().getChosahyoTokkijikoSelect().getChkTokkijikoTenyuryoku();
    }

    @JsonIgnore
    public void  setChkTokkijikoTenyuryoku(CheckBoxList chkTokkijikoTenyuryoku) {
        this.getIraiprint().getChosahyoTokkijikoSelect().setChkTokkijikoTenyuryoku(chkTokkijikoTenyuryoku);
    }

    // </editor-fold>
}
