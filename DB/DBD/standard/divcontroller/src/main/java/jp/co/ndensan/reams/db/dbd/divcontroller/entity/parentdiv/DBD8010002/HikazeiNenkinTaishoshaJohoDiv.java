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
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HikazeiNenkinTaishoshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HikazeiNenkinTaishoshaJohoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HikazeiNenkinTaishoshaJohoTorikomi")
    private HikazeiNenkinTaishoshaJohoTorikomiDiv HikazeiNenkinTaishoshaJohoTorikomi;
    @JsonProperty("ShoriSettei")
    private ShoriSetteiDiv ShoriSettei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHikazeiNenkinTaishoshaJohoTorikomi
     * @return HikazeiNenkinTaishoshaJohoTorikomi
     */
    @JsonProperty("HikazeiNenkinTaishoshaJohoTorikomi")
    public HikazeiNenkinTaishoshaJohoTorikomiDiv getHikazeiNenkinTaishoshaJohoTorikomi() {
        return HikazeiNenkinTaishoshaJohoTorikomi;
    }

    /*
     * setHikazeiNenkinTaishoshaJohoTorikomi
     * @param HikazeiNenkinTaishoshaJohoTorikomi HikazeiNenkinTaishoshaJohoTorikomi
     */
    @JsonProperty("HikazeiNenkinTaishoshaJohoTorikomi")
    public void setHikazeiNenkinTaishoshaJohoTorikomi(HikazeiNenkinTaishoshaJohoTorikomiDiv HikazeiNenkinTaishoshaJohoTorikomi) {
        this.HikazeiNenkinTaishoshaJohoTorikomi = HikazeiNenkinTaishoshaJohoTorikomi;
    }

    /*
     * getShoriSettei
     * @return ShoriSettei
     */
    @JsonProperty("ShoriSettei")
    public ShoriSetteiDiv getShoriSettei() {
        return ShoriSettei;
    }

    /*
     * setShoriSettei
     * @param ShoriSettei ShoriSettei
     */
    @JsonProperty("ShoriSettei")
    public void setShoriSettei(ShoriSetteiDiv ShoriSettei) {
        this.ShoriSettei = ShoriSettei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HeddaeriaDiv getHeddaeria() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria();
    }

    @JsonIgnore
    public void  setHeddaeria(HeddaeriaDiv Heddaeria) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().setHeddaeria(Heddaeria);
    }

    @JsonIgnore
    public ShoriNendoDiv getShoriNendo() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getShoriNendo();
    }

    @JsonIgnore
    public void  setShoriNendo(ShoriNendoDiv ShoriNendo) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().setShoriNendo(ShoriNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShoriNendo() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getShoriNendo().getDdlShoriNendo();
    }

    @JsonIgnore
    public void  setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getShoriNendo().setDdlShoriNendo(ddlShoriNendo);
    }

    @JsonIgnore
    public KoikiHeddaJoho1Div getKoikiHeddaJoho1() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho1();
    }

    @JsonIgnore
    public void  setKoikiHeddaJoho1(KoikiHeddaJoho1Div KoikiHeddaJoho1) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().setKoikiHeddaJoho1(KoikiHeddaJoho1);
    }

    @JsonIgnore
    public DropDownList getDdlTuki() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho1().getDdlTuki();
    }

    @JsonIgnore
    public void  setDdlTuki(DropDownList ddlTuki) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho1().setDdlTuki(ddlTuki);
    }

    @JsonIgnore
    public KoikiHeddaJoho2Div getKoikiHeddaJoho2() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho2();
    }

    @JsonIgnore
    public void  setKoikiHeddaJoho2(KoikiHeddaJoho2Div KoikiHeddaJoho2) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().setKoikiHeddaJoho2(KoikiHeddaJoho2);
    }

    @JsonIgnore
    public TextBox getTxtTaishoFuairu() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho2().getTxtTaishoFuairu();
    }

    @JsonIgnore
    public void  setTxtTaishoFuairu(TextBox txtTaishoFuairu) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho2().setTxtTaishoFuairu(txtTaishoFuairu);
    }

    @JsonIgnore
    public TextBox getTxtShoriJotai() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho2().getTxtShoriJotai();
    }

    @JsonIgnore
    public void  setTxtShoriJotai(TextBox txtShoriJotai) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho2().setTxtShoriJotai(txtShoriJotai);
    }

    @JsonIgnore
    public TextBox getTxtShoriNichiji() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho2().getTxtShoriNichiji();
    }

    @JsonIgnore
    public void  setTxtShoriNichiji(TextBox txtShoriNichiji) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getKoikiHeddaJoho2().setTxtShoriNichiji(txtShoriNichiji);
    }

    @JsonIgnore
    public CheckBoxList getChkTesutoShoriTorikomi() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().getChkTesutoShoriTorikomi();
    }

    @JsonIgnore
    public void  setChkTesutoShoriTorikomi(CheckBoxList chkTesutoShoriTorikomi) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getHeddaeria().setChkTesutoShoriTorikomi(chkTesutoShoriTorikomi);
    }

    @JsonIgnore
    public ShoriSetteibotanDiv getShoriSetteibotan() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getShoriSetteibotan();
    }

    @JsonIgnore
    public void  setShoriSetteibotan(ShoriSetteibotanDiv ShoriSetteibotan) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().setShoriSetteibotan(ShoriSetteibotan);
    }

    @JsonIgnore
    public Button getBtnShoriSettei() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getShoriSetteibotan().getBtnShoriSettei();
    }

    @JsonIgnore
    public void  setBtnShoriSettei(Button btnShoriSettei) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getShoriSetteibotan().setBtnShoriSettei(btnShoriSettei);
    }

    @JsonIgnore
    public TaishoIchiranRainDiv getTaishoIchiranRain() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTaishoIchiranRain();
    }

    @JsonIgnore
    public void  setTaishoIchiranRain(TaishoIchiranRainDiv TaishoIchiranRain) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().setTaishoIchiranRain(TaishoIchiranRain);
    }

    @JsonIgnore
    public HorizontalLine getLinTaishoIchiran() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTaishoIchiranRain().getLinTaishoIchiran();
    }

    @JsonIgnore
    public void  setLinTaishoIchiran(HorizontalLine linTaishoIchiran) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTaishoIchiranRain().setLinTaishoIchiran(linTaishoIchiran);
    }

    @JsonIgnore
    public TanitsuTaishoShoriIchiranDiv getTanitsuTaishoShoriIchiran() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran();
    }

    @JsonIgnore
    public void  setTanitsuTaishoShoriIchiran(TanitsuTaishoShoriIchiranDiv TanitsuTaishoShoriIchiran) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().setTanitsuTaishoShoriIchiran(TanitsuTaishoShoriIchiran);
    }

    @JsonIgnore
    public DataGrid<dgTanitsuTaishoShoriItchiran_Row> getDgTanitsuTaishoShoriItchiran() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getDgTanitsuTaishoShoriItchiran();
    }

    @JsonIgnore
    public void  setDgTanitsuTaishoShoriItchiran(DataGrid<dgTanitsuTaishoShoriItchiran_Row> dgTanitsuTaishoShoriItchiran) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().setDgTanitsuTaishoShoriItchiran(dgTanitsuTaishoShoriItchiran);
    }

    @JsonIgnore
    public FuairuAppurodoDiv getFuairuAppurodo() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getFuairuAppurodo();
    }

    @JsonIgnore
    public void  setFuairuAppurodo(FuairuAppurodoDiv FuairuAppurodo) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().setFuairuAppurodo(FuairuAppurodo);
    }

    @JsonIgnore
    public UploadPanel getUplTaishoFuairu() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getFuairuAppurodo().getUplTaishoFuairu();
    }

    @JsonIgnore
    public void  setUplTaishoFuairu(UploadPanel uplTaishoFuairu) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getFuairuAppurodo().setUplTaishoFuairu(uplTaishoFuairu);
    }

    @JsonIgnore
    public Button getBtnAppurodo() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getFuairuAppurodo().getBtnAppurodo();
    }

    @JsonIgnore
    public void  setBtnAppurodo(Button btnAppurodo) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getFuairuAppurodo().setBtnAppurodo(btnAppurodo);
    }

    @JsonIgnore
    public TextBox getTxtShoriNendo() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getTxtShoriNendo();
    }

    @JsonIgnore
    public void  setTxtShoriNendo(TextBox txtShoriNendo) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public TextBox getTxtTuki() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getTxtTuki();
    }

    @JsonIgnore
    public void  setTxtTuki(TextBox txtTuki) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().setTxtTuki(txtTuki);
    }

    @JsonIgnore
    public TextBox getTxtShori() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getTxtShori();
    }

    @JsonIgnore
    public void  setTxtShori(TextBox txtShori) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().setTxtShori(txtShori);
    }

    @JsonIgnore
    public TextBox getTxtFuairuMei() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().getTxtFuairuMei();
    }

    @JsonIgnore
    public void  setTxtFuairuMei(TextBox txtFuairuMei) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getTanitsuTaishoShoriIchiran().setTxtFuairuMei(txtFuairuMei);
    }

    @JsonIgnore
    public KoikiTaishoShoriIchiranDiv getKoikiTaishoShoriIchiran() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getKoikiTaishoShoriIchiran();
    }

    @JsonIgnore
    public void  setKoikiTaishoShoriIchiran(KoikiTaishoShoriIchiranDiv KoikiTaishoShoriIchiran) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().setKoikiTaishoShoriIchiran(KoikiTaishoShoriIchiran);
    }

    @JsonIgnore
    public DataGrid<dgKoikiTaishoShoriItiran_Row> getDgKoikiTaishoShoriItiran() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getKoikiTaishoShoriIchiran().getDgKoikiTaishoShoriItiran();
    }

    @JsonIgnore
    public void  setDgKoikiTaishoShoriItiran(DataGrid<dgKoikiTaishoShoriItiran_Row> dgKoikiTaishoShoriItiran) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getKoikiTaishoShoriIchiran().setDgKoikiTaishoShoriItiran(dgKoikiTaishoShoriItiran);
    }

    @JsonIgnore
    public HorizontalLine getLinChohyoShutsuryoku() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getLinChohyoShutsuryoku();
    }

    @JsonIgnore
    public void  setLinChohyoShutsuryoku(HorizontalLine linChohyoShutsuryoku) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().setLinChohyoShutsuryoku(linChohyoShutsuryoku);
    }

    @JsonIgnore
    public ChohyoShutsuryokuSijiDiv getChohyoShutsuryokuSiji() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji();
    }

    @JsonIgnore
    public void  setChohyoShutsuryokuSiji(ChohyoShutsuryokuSijiDiv ChohyoShutsuryokuSiji) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().setChohyoShutsuryokuSiji(ChohyoShutsuryokuSiji);
    }

    @JsonIgnore
    public ChohyoShutsuryokuUmuDiv getChohyoShutsuryokuUmu() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu();
    }

    @JsonIgnore
    public void  setChohyoShutsuryokuUmu(ChohyoShutsuryokuUmuDiv ChohyoShutsuryokuUmu) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().setChohyoShutsuryokuUmu(ChohyoShutsuryokuUmu);
    }

    @JsonIgnore
    public Label getLblItiranhyo() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().getLblItiranhyo();
    }

    @JsonIgnore
    public void  setLblItiranhyo(Label lblItiranhyo) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().setLblItiranhyo(lblItiranhyo);
    }

    @JsonIgnore
    public Label getLblShutsuryoku() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().getLblShutsuryoku();
    }

    @JsonIgnore
    public void  setLblShutsuryoku(Label lblShutsuryoku) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().setLblShutsuryoku(lblShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadSonotaChohyo() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().getRadSonotaChohyo();
    }

    @JsonIgnore
    public void  setRadSonotaChohyo(RadioButton radSonotaChohyo) {
        this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getChohyoShutsuryokuUmu().setRadSonotaChohyo(radSonotaChohyo);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun4() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun4();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun1() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun1();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun3() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun3();
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoSyuturyokuJun2() {
        return this.getHikazeiNenkinTaishoshaJohoTorikomi().getChohyoShutsuryokuSiji().getCcdChohyoSyuturyokuJun2();
    }

    @JsonIgnore
    public TextBox getTxtShoriSetteiNendo() {
        return this.getShoriSettei().getTxtShoriSetteiNendo();
    }

    @JsonIgnore
    public void  setTxtShoriSetteiNendo(TextBox txtShoriSetteiNendo) {
        this.getShoriSettei().setTxtShoriSetteiNendo(txtShoriSetteiNendo);
    }

    @JsonIgnore
    public HorizontalLine getLinShoriSettei() {
        return this.getShoriSettei().getLinShoriSettei();
    }

    @JsonIgnore
    public void  setLinShoriSettei(HorizontalLine linShoriSettei) {
        this.getShoriSettei().setLinShoriSettei(linShoriSettei);
    }

    @JsonIgnore
    public DataGrid<dgShoriSettei_Row> getDgShoriSettei() {
        return this.getShoriSettei().getDgShoriSettei();
    }

    @JsonIgnore
    public void  setDgShoriSettei(DataGrid<dgShoriSettei_Row> dgShoriSettei) {
        this.getShoriSettei().setDgShoriSettei(dgShoriSettei);
    }

    // </editor-fold>
}
