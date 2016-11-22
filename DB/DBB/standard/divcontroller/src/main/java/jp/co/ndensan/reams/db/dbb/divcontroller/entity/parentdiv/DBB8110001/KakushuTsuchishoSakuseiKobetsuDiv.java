package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KakushuTsuchishoSakuseiKobetsu のクラスファイル
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KakushuTsuchishoSakuseiKobetsuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JuminFukaShokai")
    private JuminFukaShokaiDiv JuminFukaShokai;
    @JsonProperty("TsuchishoSakuseiKobetsu")
    private TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu;
    @JsonProperty("FukaShokaiGrandsonTsuchisho")
    private FukaShokaiGrandsonTsuchishoDiv FukaShokaiGrandsonTsuchisho;
    @JsonProperty("hdnPublishFlag")
    private RString hdnPublishFlag;
    @JsonProperty("hdnKouseizenFlag")
    private RString hdnKouseizenFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getJuminFukaShokai
     * @return JuminFukaShokai
     */
    @JsonProperty("JuminFukaShokai")
    public JuminFukaShokaiDiv getJuminFukaShokai() {
        return JuminFukaShokai;
    }

    /*
     * setJuminFukaShokai
     * @param JuminFukaShokai JuminFukaShokai
     */
    @JsonProperty("JuminFukaShokai")
    public void setJuminFukaShokai(JuminFukaShokaiDiv JuminFukaShokai) {
        this.JuminFukaShokai = JuminFukaShokai;
    }

    /*
     * getTsuchishoSakuseiKobetsu
     * @return TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public TsuchishoSakuseiKobetsuDiv getTsuchishoSakuseiKobetsu() {
        return TsuchishoSakuseiKobetsu;
    }

    /*
     * setTsuchishoSakuseiKobetsu
     * @param TsuchishoSakuseiKobetsu TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public void setTsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu) {
        this.TsuchishoSakuseiKobetsu = TsuchishoSakuseiKobetsu;
    }

    /*
     * getFukaShokaiGrandsonTsuchisho
     * @return FukaShokaiGrandsonTsuchisho
     */
    @JsonProperty("FukaShokaiGrandsonTsuchisho")
    public FukaShokaiGrandsonTsuchishoDiv getFukaShokaiGrandsonTsuchisho() {
        return FukaShokaiGrandsonTsuchisho;
    }

    /*
     * setFukaShokaiGrandsonTsuchisho
     * @param FukaShokaiGrandsonTsuchisho FukaShokaiGrandsonTsuchisho
     */
    @JsonProperty("FukaShokaiGrandsonTsuchisho")
    public void setFukaShokaiGrandsonTsuchisho(FukaShokaiGrandsonTsuchishoDiv FukaShokaiGrandsonTsuchisho) {
        this.FukaShokaiGrandsonTsuchisho = FukaShokaiGrandsonTsuchisho;
    }

    /*
     * gethdnPublishFlag
     * @return hdnPublishFlag
     */
    @JsonProperty("hdnPublishFlag")
    public RString getHdnPublishFlag() {
        return hdnPublishFlag;
    }

    /*
     * sethdnPublishFlag
     * @param hdnPublishFlag hdnPublishFlag
     */
    @JsonProperty("hdnPublishFlag")
    public void setHdnPublishFlag(RString hdnPublishFlag) {
        this.hdnPublishFlag = hdnPublishFlag;
    }

    /*
     * getHdnKouseizenFlag
     * @return hdnKouseizenFlag
     */
    @JsonProperty("hdnKouseizenFlag")
    public RString getHdnKouseizenFlag() {
        return hdnKouseizenFlag;
    }

    /*
     * hdnKouseizenFlag
     * @param hdnKouseizenFlag hdnKouseizenFlag
     */
    @JsonProperty("hdnKouseizenFlag")
    public void setHdnKouseizenFlag(RString hdnKouseizenFlag) {
        this.hdnKouseizenFlag = hdnKouseizenFlag;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkPublishKetteiTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().getChkPublishKetteiTsuchiKobetsu();
    }

    @JsonIgnore
    public void setChkPublishKetteiTsuchiKobetsu(CheckBoxList chkPublishKetteiTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().setChkPublishKetteiTsuchiKobetsu(chkPublishKetteiTsuchiKobetsu);
    }

    @JsonIgnore
    public Label getLblKetteiTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().getLblKetteiTsuchiKobetsu();
    }

    @JsonIgnore
    public void setLblKetteiTsuchiKobetsu(Label lblKetteiTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().setLblKetteiTsuchiKobetsu(lblKetteiTsuchiKobetsu);
    }

    @JsonIgnore
    public KetteiTsuchiKobetsuDiv getKetteiTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().getKetteiTsuchiKobetsu();
    }

    @JsonIgnore
    public void setKetteiTsuchiKobetsu(KetteiTsuchiKobetsuDiv KetteiTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().setKetteiTsuchiKobetsu(KetteiTsuchiKobetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkPublishHenkoTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().getChkPublishHenkoTsuchiKobetsu();
    }

    @JsonIgnore
    public void setChkPublishHenkoTsuchiKobetsu(CheckBoxList chkPublishHenkoTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().setChkPublishHenkoTsuchiKobetsu(chkPublishHenkoTsuchiKobetsu);
    }

    @JsonIgnore
    public Label getLblHenkoTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().getLblHenkoTsuchiKobetsu();
    }

    @JsonIgnore
    public void setLblHenkoTsuchiKobetsu(Label lblHenkoTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().setLblHenkoTsuchiKobetsu(lblHenkoTsuchiKobetsu);
    }

    @JsonIgnore
    public HenkoTsuchiKobetsuDiv getHenkoTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().getHenkoTsuchiKobetsu();
    }

    @JsonIgnore
    public void setHenkoTsuchiKobetsu(HenkoTsuchiKobetsuDiv HenkoTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().setHenkoTsuchiKobetsu(HenkoTsuchiKobetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkPublishNotsuKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapNotsuKobetsu().getChkPublishNotsuKobetsu();
    }

    @JsonIgnore
    public void setChkPublishNotsuKobetsu(CheckBoxList chkPublishNotsuKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapNotsuKobetsu().setChkPublishNotsuKobetsu(chkPublishNotsuKobetsu);
    }

    @JsonIgnore
    public Label getLblNotsuKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapNotsuKobetsu().getLblNotsuKobetsu();
    }

    @JsonIgnore
    public void setLblNotsuKobetsu(Label lblNotsuKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapNotsuKobetsu().setLblNotsuKobetsu(lblNotsuKobetsu);
    }

    @JsonIgnore
    public NotsuKobetsuDiv getNotsuKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapNotsuKobetsu().getNotsuKobetsu();
    }

    @JsonIgnore
    public void setNotsuKobetsu(NotsuKobetsuDiv NotsuKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapNotsuKobetsu().setNotsuKobetsu(NotsuKobetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkPublishYufuriKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapYufuriKobetsu().getChkPublishYufuriKobetsu();
    }

    @JsonIgnore
    public void setChkPublishYufuriKobetsu(CheckBoxList chkPublishYufuriKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapYufuriKobetsu().setChkPublishYufuriKobetsu(chkPublishYufuriKobetsu);
    }

    @JsonIgnore
    public Label getLblYufuriKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapYufuriKobetsu().getLblYufuriKobetsu();
    }

    @JsonIgnore
    public void setLblYufuriKobetsu(Label lblYufuriKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapYufuriKobetsu().setLblYufuriKobetsu(lblYufuriKobetsu);
    }

    @JsonIgnore
    public YufuriKobetsuDiv getYufuriKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapYufuriKobetsu().getYufuriKobetsu();
    }

    @JsonIgnore
    public void setYufuriKobetsu(YufuriKobetsuDiv YufuriKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapYufuriKobetsu().setYufuriKobetsu(YufuriKobetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkPublishTokuKaishiTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapTokuKaishiTsuchiKobetsu().getChkPublishTokuKaishiTsuchiKobetsu();
    }

    @JsonIgnore
    public void setChkPublishTokuKaishiTsuchiKobetsu(CheckBoxList chkPublishTokuKaishiTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapTokuKaishiTsuchiKobetsu().setChkPublishTokuKaishiTsuchiKobetsu(chkPublishTokuKaishiTsuchiKobetsu);
    }

    @JsonIgnore
    public Label getLblTokuKaishiTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapTokuKaishiTsuchiKobetsu().getLblTokuKaishiTsuchiKobetsu();
    }

    @JsonIgnore
    public void setLblTokuKaishiTsuchiKobetsu(Label lblTokuKaishiTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapTokuKaishiTsuchiKobetsu().setLblTokuKaishiTsuchiKobetsu(lblTokuKaishiTsuchiKobetsu);
    }

    @JsonIgnore
    public TokuKaishiTsuchiKobetsuDiv getTokuKaishiTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapTokuKaishiTsuchiKobetsu().getTokuKaishiTsuchiKobetsu();
    }

    @JsonIgnore
    public void setTokuKaishiTsuchiKobetsu(TokuKaishiTsuchiKobetsuDiv TokuKaishiTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapTokuKaishiTsuchiKobetsu().setTokuKaishiTsuchiKobetsu(TokuKaishiTsuchiKobetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkPublishGemmenTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapGemmenTsuchiKobetsu().getChkPublishGemmenTsuchiKobetsu();
    }

    @JsonIgnore
    public void setChkPublishGemmenTsuchiKobetsu(CheckBoxList chkPublishGemmenTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapGemmenTsuchiKobetsu().setChkPublishGemmenTsuchiKobetsu(chkPublishGemmenTsuchiKobetsu);
    }

    @JsonIgnore
    public Label getLblGemmenTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapGemmenTsuchiKobetsu().getLblGemmenTsuchiKobetsu();
    }

    @JsonIgnore
    public void setLblGemmenTsuchiKobetsu(Label lblGemmenTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapGemmenTsuchiKobetsu().setLblGemmenTsuchiKobetsu(lblGemmenTsuchiKobetsu);
    }

    @JsonIgnore
    public GemmenTsuchiKobetsuDiv getGemmenTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapGemmenTsuchiKobetsu().getGemmenTsuchiKobetsu();
    }

    @JsonIgnore
    public void setGemmenTsuchiKobetsu(GemmenTsuchiKobetsuDiv GemmenTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapGemmenTsuchiKobetsu().setGemmenTsuchiKobetsu(GemmenTsuchiKobetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkPublishChoshuYuyoTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapChoshuYuyoTsuchiKobetsu().getChkPublishChoshuYuyoTsuchiKobetsu();
    }

    @JsonIgnore
    public void setChkPublishChoshuYuyoTsuchiKobetsu(CheckBoxList chkPublishChoshuYuyoTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapChoshuYuyoTsuchiKobetsu().setChkPublishChoshuYuyoTsuchiKobetsu(chkPublishChoshuYuyoTsuchiKobetsu);
    }

    @JsonIgnore
    public Label getLblChoshuYuyoTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapChoshuYuyoTsuchiKobetsu().getLblChoshuYuyoTsuchiKobetsu();
    }

    @JsonIgnore
    public void setLblChoshuYuyoTsuchiKobetsu(Label lblChoshuYuyoTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapChoshuYuyoTsuchiKobetsu().setLblChoshuYuyoTsuchiKobetsu(lblChoshuYuyoTsuchiKobetsu);
    }

    @JsonIgnore
    public ChoshuYuyoTsuchiKobetsuDiv getChoshuYuyoTsuchiKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapChoshuYuyoTsuchiKobetsu().getChoshuYuyoTsuchiKobetsu();
    }

    @JsonIgnore
    public void setChoshuYuyoTsuchiKobetsu(ChoshuYuyoTsuchiKobetsuDiv ChoshuYuyoTsuchiKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapChoshuYuyoTsuchiKobetsu().setChoshuYuyoTsuchiKobetsu(ChoshuYuyoTsuchiKobetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkPublishFukadaichoKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapFukadaichoKobetsu().getChkPublishFukadaichoKobetsu();
    }

    @JsonIgnore
    public void setChkPublishFukadaichoKobetsu(CheckBoxList chkPublishFukadaichoKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapFukadaichoKobetsu().setChkPublishFukadaichoKobetsu(chkPublishFukadaichoKobetsu);
    }

    @JsonIgnore
    public Label getLblFukadaichoKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapFukadaichoKobetsu().getLblFukadaichoKobetsu();
    }

    @JsonIgnore
    public void setLblFukadaichoKobetsu(Label lblFukadaichoKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapFukadaichoKobetsu().setLblFukadaichoKobetsu(lblFukadaichoKobetsu);
    }

    @JsonIgnore
    public FukadaichoKobetsuDiv getFukadaichoKobetsu() {
        return this.getTsuchishoSakuseiKobetsu().getWrapFukadaichoKobetsu().getFukadaichoKobetsu();
    }

    @JsonIgnore
    public void setFukadaichoKobetsu(FukadaichoKobetsuDiv FukadaichoKobetsu) {
        this.getTsuchishoSakuseiKobetsu().getWrapFukadaichoKobetsu().setFukadaichoKobetsu(FukadaichoKobetsu);
    }

    // </editor-fold>
}
