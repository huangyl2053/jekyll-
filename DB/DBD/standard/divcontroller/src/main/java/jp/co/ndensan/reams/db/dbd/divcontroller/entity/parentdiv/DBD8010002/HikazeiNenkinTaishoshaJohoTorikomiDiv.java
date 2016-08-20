package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HikazeiNenkinTaishoshaJohoTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class HikazeiNenkinTaishoshaJohoTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Heddaeria")
    private HeddaeriaDiv Heddaeria;
    @JsonProperty("ShoriSetteibotan")
    private ShoriSetteibotanDiv ShoriSetteibotan;
    @JsonProperty("TaishoIchiranRain")
    private TaishoIchiranRainDiv TaishoIchiranRain;
    @JsonProperty("TanitsuTaishoShoriIchiran")
    private TanitsuTaishoShoriIchiranDiv TanitsuTaishoShoriIchiran;
    @JsonProperty("KoikiTaishoShoriIchiran")
    private KoikiTaishoShoriIchiranDiv KoikiTaishoShoriIchiran;
    @JsonProperty("linChohyoShutsuryoku")
    private HorizontalLine linChohyoShutsuryoku;
    @JsonProperty("ChohyoShutsuryokuSiji")
    private ChohyoShutsuryokuSijiDiv ChohyoShutsuryokuSiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHeddaeria
     * @return Heddaeria
     */
    @JsonProperty("Heddaeria")
    public HeddaeriaDiv getHeddaeria() {
        return Heddaeria;
    }

    /*
     * setHeddaeria
     * @param Heddaeria Heddaeria
     */
    @JsonProperty("Heddaeria")
    public void setHeddaeria(HeddaeriaDiv Heddaeria) {
        this.Heddaeria = Heddaeria;
    }

    /*
     * getShoriSetteibotan
     * @return ShoriSetteibotan
     */
    @JsonProperty("ShoriSetteibotan")
    public ShoriSetteibotanDiv getShoriSetteibotan() {
        return ShoriSetteibotan;
    }

    /*
     * setShoriSetteibotan
     * @param ShoriSetteibotan ShoriSetteibotan
     */
    @JsonProperty("ShoriSetteibotan")
    public void setShoriSetteibotan(ShoriSetteibotanDiv ShoriSetteibotan) {
        this.ShoriSetteibotan = ShoriSetteibotan;
    }

    /*
     * getTaishoIchiranRain
     * @return TaishoIchiranRain
     */
    @JsonProperty("TaishoIchiranRain")
    public TaishoIchiranRainDiv getTaishoIchiranRain() {
        return TaishoIchiranRain;
    }

    /*
     * setTaishoIchiranRain
     * @param TaishoIchiranRain TaishoIchiranRain
     */
    @JsonProperty("TaishoIchiranRain")
    public void setTaishoIchiranRain(TaishoIchiranRainDiv TaishoIchiranRain) {
        this.TaishoIchiranRain = TaishoIchiranRain;
    }

    /*
     * getTanitsuTaishoShoriIchiran
     * @return TanitsuTaishoShoriIchiran
     */
    @JsonProperty("TanitsuTaishoShoriIchiran")
    public TanitsuTaishoShoriIchiranDiv getTanitsuTaishoShoriIchiran() {
        return TanitsuTaishoShoriIchiran;
    }

    /*
     * setTanitsuTaishoShoriIchiran
     * @param TanitsuTaishoShoriIchiran TanitsuTaishoShoriIchiran
     */
    @JsonProperty("TanitsuTaishoShoriIchiran")
    public void setTanitsuTaishoShoriIchiran(TanitsuTaishoShoriIchiranDiv TanitsuTaishoShoriIchiran) {
        this.TanitsuTaishoShoriIchiran = TanitsuTaishoShoriIchiran;
    }

    /*
     * getKoikiTaishoShoriIchiran
     * @return KoikiTaishoShoriIchiran
     */
    @JsonProperty("KoikiTaishoShoriIchiran")
    public KoikiTaishoShoriIchiranDiv getKoikiTaishoShoriIchiran() {
        return KoikiTaishoShoriIchiran;
    }

    /*
     * setKoikiTaishoShoriIchiran
     * @param KoikiTaishoShoriIchiran KoikiTaishoShoriIchiran
     */
    @JsonProperty("KoikiTaishoShoriIchiran")
    public void setKoikiTaishoShoriIchiran(KoikiTaishoShoriIchiranDiv KoikiTaishoShoriIchiran) {
        this.KoikiTaishoShoriIchiran = KoikiTaishoShoriIchiran;
    }

    /*
     * getlinChohyoShutsuryoku
     * @return linChohyoShutsuryoku
     */
    @JsonProperty("linChohyoShutsuryoku")
    public HorizontalLine getLinChohyoShutsuryoku() {
        return linChohyoShutsuryoku;
    }

    /*
     * setlinChohyoShutsuryoku
     * @param linChohyoShutsuryoku linChohyoShutsuryoku
     */
    @JsonProperty("linChohyoShutsuryoku")
    public void setLinChohyoShutsuryoku(HorizontalLine linChohyoShutsuryoku) {
        this.linChohyoShutsuryoku = linChohyoShutsuryoku;
    }

    /*
     * getChohyoShutsuryokuSiji
     * @return ChohyoShutsuryokuSiji
     */
    @JsonProperty("ChohyoShutsuryokuSiji")
    public ChohyoShutsuryokuSijiDiv getChohyoShutsuryokuSiji() {
        return ChohyoShutsuryokuSiji;
    }

    /*
     * setChohyoShutsuryokuSiji
     * @param ChohyoShutsuryokuSiji ChohyoShutsuryokuSiji
     */
    @JsonProperty("ChohyoShutsuryokuSiji")
    public void setChohyoShutsuryokuSiji(ChohyoShutsuryokuSijiDiv ChohyoShutsuryokuSiji) {
        this.ChohyoShutsuryokuSiji = ChohyoShutsuryokuSiji;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShoriNendoDiv getShoriNendo() {
        return this.getHeddaeria().getShoriNendo();
    }

    @JsonIgnore
    public void  setShoriNendo(ShoriNendoDiv ShoriNendo) {
        this.getHeddaeria().setShoriNendo(ShoriNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShoriNendo() {
        return this.getHeddaeria().getShoriNendo().getDdlShoriNendo();
    }

    @JsonIgnore
    public void  setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.getHeddaeria().getShoriNendo().setDdlShoriNendo(ddlShoriNendo);
    }

    @JsonIgnore
    public KoikiHeddaJoho1Div getKoikiHeddaJoho1() {
        return this.getHeddaeria().getKoikiHeddaJoho1();
    }

    @JsonIgnore
    public void  setKoikiHeddaJoho1(KoikiHeddaJoho1Div KoikiHeddaJoho1) {
        this.getHeddaeria().setKoikiHeddaJoho1(KoikiHeddaJoho1);
    }

    @JsonIgnore
    public DropDownList getDdlTuki() {
        return this.getHeddaeria().getKoikiHeddaJoho1().getDdlTuki();
    }

    @JsonIgnore
    public void  setDdlTuki(DropDownList ddlTuki) {
        this.getHeddaeria().getKoikiHeddaJoho1().setDdlTuki(ddlTuki);
    }

    @JsonIgnore
    public KoikiHeddaJoho2Div getKoikiHeddaJoho2() {
        return this.getHeddaeria().getKoikiHeddaJoho2();
    }

    @JsonIgnore
    public void  setKoikiHeddaJoho2(KoikiHeddaJoho2Div KoikiHeddaJoho2) {
        this.getHeddaeria().setKoikiHeddaJoho2(KoikiHeddaJoho2);
    }

    @JsonIgnore
    public TextBox getTxtTaishoFuairu() {
        return this.getHeddaeria().getKoikiHeddaJoho2().getTxtTaishoFuairu();
    }

    @JsonIgnore
    public void  setTxtTaishoFuairu(TextBox txtTaishoFuairu) {
        this.getHeddaeria().getKoikiHeddaJoho2().setTxtTaishoFuairu(txtTaishoFuairu);
    }

    @JsonIgnore
    public TextBox getTxtShoriJotai() {
        return this.getHeddaeria().getKoikiHeddaJoho2().getTxtShoriJotai();
    }

    @JsonIgnore
    public void  setTxtShoriJotai(TextBox txtShoriJotai) {
        this.getHeddaeria().getKoikiHeddaJoho2().setTxtShoriJotai(txtShoriJotai);
    }

    @JsonIgnore
    public TextBox getTxtShoriNichiji() {
        return this.getHeddaeria().getKoikiHeddaJoho2().getTxtShoriNichiji();
    }

    @JsonIgnore
    public void  setTxtShoriNichiji(TextBox txtShoriNichiji) {
        this.getHeddaeria().getKoikiHeddaJoho2().setTxtShoriNichiji(txtShoriNichiji);
    }

    @JsonIgnore
    public CheckBoxList getChkTesutoShoriTorikomi() {
        return this.getHeddaeria().getChkTesutoShoriTorikomi();
    }

    @JsonIgnore
    public void  setChkTesutoShoriTorikomi(CheckBoxList chkTesutoShoriTorikomi) {
        this.getHeddaeria().setChkTesutoShoriTorikomi(chkTesutoShoriTorikomi);
    }

    @JsonIgnore
    public Button getBtnShoriSettei() {
        return this.getShoriSetteibotan().getBtnShoriSettei();
    }

    @JsonIgnore
    public void  setBtnShoriSettei(Button btnShoriSettei) {
        this.getShoriSetteibotan().setBtnShoriSettei(btnShoriSettei);
    }

    @JsonIgnore
    public HorizontalLine getLinTaishoIchiran() {
        return this.getTaishoIchiranRain().getLinTaishoIchiran();
    }

    @JsonIgnore
    public void  setLinTaishoIchiran(HorizontalLine linTaishoIchiran) {
        this.getTaishoIchiranRain().setLinTaishoIchiran(linTaishoIchiran);
    }

    @JsonIgnore
    public DataGrid<dgTanitsuTaishoShoriItchiran_Row> getDgTanitsuTaishoShoriItchiran() {
        return this.getTanitsuTaishoShoriIchiran().getDgTanitsuTaishoShoriItchiran();
    }

    @JsonIgnore
    public void  setDgTanitsuTaishoShoriItchiran(DataGrid<dgTanitsuTaishoShoriItchiran_Row> dgTanitsuTaishoShoriItchiran) {
        this.getTanitsuTaishoShoriIchiran().setDgTanitsuTaishoShoriItchiran(dgTanitsuTaishoShoriItchiran);
    }

    @JsonIgnore
    public FuairuAppurodoDiv getFuairuAppurodo() {
        return this.getTanitsuTaishoShoriIchiran().getFuairuAppurodo();
    }

    @JsonIgnore
    public void  setFuairuAppurodo(FuairuAppurodoDiv FuairuAppurodo) {
        this.getTanitsuTaishoShoriIchiran().setFuairuAppurodo(FuairuAppurodo);
    }

    @JsonIgnore
    public UploadPanel getUplTaishoFuairu() {
        return this.getTanitsuTaishoShoriIchiran().getFuairuAppurodo().getUplTaishoFuairu();
    }

    @JsonIgnore
    public void  setUplTaishoFuairu(UploadPanel uplTaishoFuairu) {
        this.getTanitsuTaishoShoriIchiran().getFuairuAppurodo().setUplTaishoFuairu(uplTaishoFuairu);
    }

    @JsonIgnore
    public Button getBtnAppurodo() {
        return this.getTanitsuTaishoShoriIchiran().getFuairuAppurodo().getBtnAppurodo();
    }

    @JsonIgnore
    public void  setBtnAppurodo(Button btnAppurodo) {
        this.getTanitsuTaishoShoriIchiran().getFuairuAppurodo().setBtnAppurodo(btnAppurodo);
    }

    @JsonIgnore
    public TextBox getTxtShoriNendo() {
        return this.getTanitsuTaishoShoriIchiran().getTxtShoriNendo();
    }

    @JsonIgnore
    public void  setTxtShoriNendo(TextBox txtShoriNendo) {
        this.getTanitsuTaishoShoriIchiran().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public TextBox getTxtTuki() {
        return this.getTanitsuTaishoShoriIchiran().getTxtTuki();
    }

    @JsonIgnore
    public void  setTxtTuki(TextBox txtTuki) {
        this.getTanitsuTaishoShoriIchiran().setTxtTuki(txtTuki);
    }

    @JsonIgnore
    public TextBox getTxtShori() {
        return this.getTanitsuTaishoShoriIchiran().getTxtShori();
    }

    @JsonIgnore
    public void  setTxtShori(TextBox txtShori) {
        this.getTanitsuTaishoShoriIchiran().setTxtShori(txtShori);
    }

    @JsonIgnore
    public TextBox getTxtFuairuMei() {
        return this.getTanitsuTaishoShoriIchiran().getTxtFuairuMei();
    }

    @JsonIgnore
    public void  setTxtFuairuMei(TextBox txtFuairuMei) {
        this.getTanitsuTaishoShoriIchiran().setTxtFuairuMei(txtFuairuMei);
    }

    @JsonIgnore
    public DataGrid<dgKoikiTaishoShoriItiran_Row> getDgKoikiTaishoShoriItiran() {
        return this.getKoikiTaishoShoriIchiran().getDgKoikiTaishoShoriItiran();
    }

    @JsonIgnore
    public void  setDgKoikiTaishoShoriItiran(DataGrid<dgKoikiTaishoShoriItiran_Row> dgKoikiTaishoShoriItiran) {
        this.getKoikiTaishoShoriIchiran().setDgKoikiTaishoShoriItiran(dgKoikiTaishoShoriItiran);
    }

    @JsonIgnore
    public ChohyoShutsuryokuUmuDiv getChohyoShutsuryokuUmu() {
        return this.getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu();
    }

    @JsonIgnore
    public void  setChohyoShutsuryokuUmu(ChohyoShutsuryokuUmuDiv ChohyoShutsuryokuUmu) {
        this.getChohyoShutsuryokuSiji().setChohyoShutsuryokuUmu(ChohyoShutsuryokuUmu);
    }

    @JsonIgnore
    public Label getLblItiranhyo() {
        return this.getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().getLblItiranhyo();
    }

    @JsonIgnore
    public void  setLblItiranhyo(Label lblItiranhyo) {
        this.getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().setLblItiranhyo(lblItiranhyo);
    }

    @JsonIgnore
    public Label getLblShutsuryoku() {
        return this.getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().getLblShutsuryoku();
    }

    @JsonIgnore
    public void  setLblShutsuryoku(Label lblShutsuryoku) {
        this.getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().setLblShutsuryoku(lblShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadSonotaChohyo() {
        return this.getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().getRadSonotaChohyo();
    }

    @JsonIgnore
    public void  setRadSonotaChohyo(RadioButton radSonotaChohyo) {
        this.getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().setRadSonotaChohyo(radSonotaChohyo);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun1() {
        return this.getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun1();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun4() {
        return this.getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun4();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun3() {
        return this.getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun3();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun2() {
        return this.getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun2();
    }

    // </editor-fold>
}
