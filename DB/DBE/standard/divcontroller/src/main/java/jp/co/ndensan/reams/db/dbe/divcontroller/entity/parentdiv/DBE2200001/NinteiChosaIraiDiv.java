package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaIrai のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosaIraiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
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
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosaItakusakiCode(txtChosaItakusakiCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiMeisho() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosaItakusakiMeisho();
    }

    @JsonIgnore
    public void setTxtChosaItakusakiMeisho(TextBox txtChosaItakusakiMeisho) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosaItakusakiMeisho(txtChosaItakusakiMeisho);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiChiku() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosaItakusakiChiku();
    }

    @JsonIgnore
    public void setTxtChosaItakusakiChiku(TextBox txtChosaItakusakiChiku) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosaItakusakiChiku(txtChosaItakusakiChiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCode() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosainCode();
    }

    @JsonIgnore
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosainCode(txtChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtChosainShimei() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosainShimei();
    }

    @JsonIgnore
    public void setTxtChosainShimei(TextBox txtChosainShimei) {
        this.getChosaItakusakiAndChosainKihonJoho().setTxtChosainShimei(txtChosainShimei);
    }

    @JsonIgnore
    public TextBox getTxtChosainChiku() {
        return this.getChosaItakusakiAndChosainKihonJoho().getTxtChosainChiku();
    }

    @JsonIgnore
    public void setTxtChosainChiku(TextBox txtChosainChiku) {
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
    public void setDgChosaItakusakiIchiran(DataGrid<dgChosaItakusakiIchiran_Row> dgChosaItakusakiIchiran) {
        this.getChoisaItakusakiIchiran().setDgChosaItakusakiIchiran(dgChosaItakusakiIchiran);
    }

    @JsonIgnore
    public DataGrid<dgchosainIchiran_Row> getDgchosainIchiran() {
        return this.getChosainIchiran().getDgchosainIchiran();
    }

    @JsonIgnore
    public void setDgchosainIchiran(DataGrid<dgchosainIchiran_Row> dgchosainIchiran) {
        this.getChosainIchiran().setDgchosainIchiran(dgchosainIchiran);
    }

    @JsonIgnore
    public WaritsukeZumiTaishoshaDiv getWaritsukeZumiTaishosha() {
        return this.getChosaTaishoWaritsuke().getWaritsukeZumiTaishosha();
    }

    @JsonIgnore
    public void setWaritsukeZumiTaishosha(WaritsukeZumiTaishoshaDiv WaritsukeZumiTaishosha) {
        this.getChosaTaishoWaritsuke().setWaritsukeZumiTaishosha(WaritsukeZumiTaishosha);
    }

    @JsonIgnore
    public DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> getDgWaritsukeZumiShinseishaIchiran() {
        return this.getChosaTaishoWaritsuke().getWaritsukeZumiTaishosha().getDgWaritsukeZumiShinseishaIchiran();
    }

    @JsonIgnore
    public void setDgWaritsukeZumiShinseishaIchiran(DataGrid<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran) {
        this.getChosaTaishoWaritsuke().getWaritsukeZumiTaishosha().setDgWaritsukeZumiShinseishaIchiran(dgWaritsukeZumiShinseishaIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiDay() {
        return this.getChosaTaishoWaritsuke().getTxtChosaIraiDay();
    }

    @JsonIgnore
    public void setTxtChosaIraiDay(TextBoxDate txtChosaIraiDay) {
        this.getChosaTaishoWaritsuke().setTxtChosaIraiDay(txtChosaIraiDay);
    }

    @JsonIgnore
    public Button getBtnWaritsuke() {
        return this.getChosaTaishoWaritsuke().getBtnWaritsuke();
    }

    @JsonIgnore
    public void setBtnWaritsuke(Button btnWaritsuke) {
        this.getChosaTaishoWaritsuke().setBtnWaritsuke(btnWaritsuke);
    }

    @JsonIgnore
    public Button getBtnKaijo() {
        return this.getChosaTaishoWaritsuke().getBtnKaijo();
    }

    @JsonIgnore
    public void setBtnKaijo(Button btnKaijo) {
        this.getChosaTaishoWaritsuke().setBtnKaijo(btnKaijo);
    }

    @JsonIgnore
    public MiwaritsukeShinseishaDiv getMiwaritsukeShinseisha() {
        return this.getChosaTaishoWaritsuke().getMiwaritsukeShinseisha();
    }

    @JsonIgnore
    public void setMiwaritsukeShinseisha(MiwaritsukeShinseishaDiv MiwaritsukeShinseisha) {
        this.getChosaTaishoWaritsuke().setMiwaritsukeShinseisha(MiwaritsukeShinseisha);
    }

    @JsonIgnore
    public DataGrid<dgMiwaritsukeShinseishaIchiran_Row> getDgMiwaritsukeShinseishaIchiran() {
        return this.getChosaTaishoWaritsuke().getMiwaritsukeShinseisha().getDgMiwaritsukeShinseishaIchiran();
    }

    @JsonIgnore
    public void setDgMiwaritsukeShinseishaIchiran(DataGrid<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran) {
        this.getChosaTaishoWaritsuke().getMiwaritsukeShinseisha().setDgMiwaritsukeShinseishaIchiran(dgMiwaritsukeShinseishaIchiran);
    }

    @JsonIgnore
    public Button getBtnBackToChosaItakusakiSentaku() {
        return this.getChosaTaishoWaritsuke().getBtnBackToChosaItakusakiSentaku();
    }

    @JsonIgnore
    public void setBtnBackToChosaItakusakiSentaku(Button btnBackToChosaItakusakiSentaku) {
        this.getChosaTaishoWaritsuke().setBtnBackToChosaItakusakiSentaku(btnBackToChosaItakusakiSentaku);
    }

    @JsonIgnore
    public Button getBtnBackToChosainSentaku() {
        return this.getChosaTaishoWaritsuke().getBtnBackToChosainSentaku();
    }

    @JsonIgnore
    public void setBtnBackToChosainSentaku(Button btnBackToChosainSentaku) {
        this.getChosaTaishoWaritsuke().setBtnBackToChosainSentaku(btnBackToChosainSentaku);
    }

    @JsonIgnore
    public Button getBtnHozon() {
        return this.getChosaTaishoWaritsuke().getBtnHozon();
    }

    @JsonIgnore
    public void setBtnHozon(Button btnHozon) {
        this.getChosaTaishoWaritsuke().setBtnHozon(btnHozon);
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
    public TextBox getTxthokkoymd() {
        return this.getIraiprint().getTxthokkoymd();
    }

    @JsonIgnore
    public void setTxthokkoymd(TextBox txthokkoymd) {
        this.getIraiprint().setTxthokkoymd(txthokkoymd);
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
    public TextBox getTxtkigenymd() {
        return this.getIraiprint().getTxtkigenymd();
    }

    @JsonIgnore
    public void setTxtkigenymd(TextBox txtkigenymd) {
        this.getIraiprint().setTxtkigenymd(txtkigenymd);
    }

    @JsonIgnore
    public Space getSP() {
        return this.getIraiprint().getSP();
    }

    @JsonIgnore
    public void setSP(Space SP) {
        this.getIraiprint().setSP(SP);
    }

    @JsonIgnore
    public CheckBoxList getChkchosa() {
        return this.getIraiprint().getChkchosa();
    }

    @JsonIgnore
    public void setChkchosa(CheckBoxList Chkchosa) {
        this.getIraiprint().setChkchosa(Chkchosa);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaOcr() {
        return this.getIraiprint().getChkchosaOcr();
    }

    @JsonIgnore
    public void setChkchosaOcr(CheckBoxList ChkchosaOcr) {
        this.getIraiprint().setChkchosaOcr(ChkchosaOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaSonota() {
        return this.getIraiprint().getChkchosaSonota();
    }

    @JsonIgnore
    public void setChkchosaSonota(CheckBoxList ChkchosaSonota) {
        this.getIraiprint().setChkchosaSonota(ChkchosaSonota);
    }

    @JsonIgnore
    public ButtonPrint getBtnPrint() {
        return this.getIraiprint().getBtnPrint();
    }

    @JsonIgnore
    public void setBtnPrint(ButtonPrint BtnPrint) {
        this.getIraiprint().setBtnPrint(BtnPrint);
    }

    // </editor-fold>
}
