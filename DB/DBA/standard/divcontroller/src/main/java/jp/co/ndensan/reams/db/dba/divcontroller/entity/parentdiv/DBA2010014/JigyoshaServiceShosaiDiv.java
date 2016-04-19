package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * JigyoshaServiceShosai のクラスファイル 
 * 
 */
public class JigyoshaServiceShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShisetsunadoKubun")
    private DropDownList ddlShisetsunadoKubun;
    @JsonProperty("ddlJininHaichiKubun")
    private DropDownList ddlJininHaichiKubun;
    @JsonProperty("radTokubetsuChiikiKasanUmu")
    private RadioButton radTokubetsuChiikiKasanUmu;
    @JsonProperty("radKinkyujiHomonkaigoKasanUmu")
    private RadioButton radKinkyujiHomonkaigoKasanUmu;
    @JsonProperty("radTokubetsuKanriTaisei")
    private RadioButton radTokubetsuKanriTaisei;
    @JsonProperty("radKinoKunrenShidoTaiseiUmu")
    private RadioButton radKinoKunrenShidoTaiseiUmu;
    @JsonProperty("radShokujiTeikyoTaiseiUmu")
    private RadioButton radShokujiTeikyoTaiseiUmu;
    @JsonProperty("radNyuyokuKaijoTaiseiUmu")
    private RadioButton radNyuyokuKaijoTaiseiUmu;
    @JsonProperty("radTokubetsuNyuyokuKaijoTaiseiUmu")
    private RadioButton radTokubetsuNyuyokuKaijoTaiseiUmu;
    @JsonProperty("radJoukinsenjuIshiHaichiUmu")
    private RadioButton radJoukinsenjuIshiHaichiUmu;
    @JsonProperty("radIshiHaichiKijun")
    private RadioButton radIshiHaichiKijun;
    @JsonProperty("radSeisinkaIshiTeikitekiRyouyousidouUmu")
    private RadioButton radSeisinkaIshiTeikitekiRyouyousidouUmu;
    @JsonProperty("ddlYakanKinmuJokenKijun")
    private DropDownList ddlYakanKinmuJokenKijun;
    @JsonProperty("radNinchishouSenmontouUmu")
    private RadioButton radNinchishouSenmontouUmu;
    @JsonProperty("ddlShokujiTeikyoJokyo")
    private DropDownList ddlShokujiTeikyoJokyo;
    @JsonProperty("radSougeiTaisei")
    private RadioButton radSougeiTaisei;
    @JsonProperty("Rihabiri")
    private RihabiriDiv Rihabiri;
    @JsonProperty("radRehabilitationKasanJokyoUmu")
    private RadioButton radRehabilitationKasanJokyoUmu;
    @JsonProperty("ddlRyoyoKankyoKijun")
    private DropDownList ddlRyoyoKankyoKijun;
    @JsonProperty("radIshiKetuinGenzanJokyoUmu")
    private RadioButton radIshiKetuinGenzanJokyoUmu;
    @JsonProperty("radKangoShokuinKetsuinGenzanJokyoUmu")
    private RadioButton radKangoShokuinKetsuinGenzanJokyoUmu;
    @JsonProperty("radRigakuRyouhousiKetsuinGenzanJokyoUmu")
    private RadioButton radRigakuRyouhousiKetsuinGenzanJokyoUmu;
    @JsonProperty("radSagyouRyouhousiKetsuinGenzanJokyoUmu")
    private RadioButton radSagyouRyouhousiKetsuinGenzanJokyoUmu;
    @JsonProperty("radKaigoShokuinKetsuinGenzanJokyoUmu")
    private RadioButton radKaigoShokuinKetsuinGenzanJokyoUmu;
    @JsonProperty("radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu")
    private RadioButton radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu;
    @JsonProperty("radKaigoJujishaKetsuinGenzanJokyoUmu")
    private RadioButton radKaigoJujishaKetsuinGenzanJokyoUmu;
    @JsonProperty("radKansenTaisakuSidoKanriUmu")
    private RadioButton radKansenTaisakuSidoKanriUmu;
    @JsonProperty("radJushoHifuKaiyouShidoKanriUmu")
    private RadioButton radJushoHifuKaiyouShidoKanriUmu;
    @JsonProperty("radYakuzaiKaniriShidoUmu")
    private RadioButton radYakuzaiKaniriShidoUmu;
    @JsonProperty("radShogaishaSeikatsuShienTaiseiUmu")
    private RadioButton radShogaishaSeikatsuShienTaiseiUmu;
    @JsonProperty("ddlChiikiKubun")
    private DropDownList ddlChiikiKubun;
    @JsonProperty("radJikanEnchoServiceTaisei")
    private RadioButton radJikanEnchoServiceTaisei;
    @JsonProperty("radKobetsuRehabilitationTeikyoTaisei")
    private RadioButton radKobetsuRehabilitationTeikyoTaisei;
    @JsonProperty("radKyojuhiTaisaku")
    private RadioButton radKyojuhiTaisaku;
    @JsonProperty("radYakanCareUmu")
    private RadioButton radYakanCareUmu;
    @JsonProperty("radRehabilitationKinoKyokaUmu")
    private RadioButton radRehabilitationKinoKyokaUmu;
    @JsonProperty("KobetsuRihabiri1")
    private KobetsuRihabiri1Div KobetsuRihabiri1;
    @JsonProperty("radGengoChokakushiKetsuinGenzanJokyoUmu")
    private RadioButton radGengoChokakushiKetsuinGenzanJokyoUmu;
    @JsonProperty("ddlEiyouKanriHyoka")
    private DropDownList ddlEiyouKanriHyoka;
    @JsonProperty("radTokuteijigyoushoKasanHomonKaigoUmu")
    private RadioButton radTokuteijigyoushoKasanHomonKaigoUmu;
    @JsonProperty("radJakunenseiNinchishoCareTaiseiUmu")
    private RadioButton radJakunenseiNinchishoCareTaiseiUmu;
    @JsonProperty("radUndokiKinoKojoTaiseiUmu")
    private RadioButton radUndokiKinoKojoTaiseiUmu;
    @JsonProperty("radEiyoManagementKaizenTaiseiUmu")
    private RadioButton radEiyoManagementKaizenTaiseiUmu;
    @JsonProperty("radKokuKinoKojoTaiseiUmu")
    private RadioButton radKokuKinoKojoTaiseiUmu;
    @JsonProperty("radJigyoshoHyokaKasanMoshideUmu")
    private RadioButton radJigyoshoHyokaKasanMoshideUmu;
    @JsonProperty("radJigyoshoHyokaKasanKetteiUmu")
    private RadioButton radJigyoshoHyokaKasanKetteiUmu;
    @JsonProperty("radKinkyuUkeireTaiseiUmu")
    private RadioButton radKinkyuUkeireTaiseiUmu;
    @JsonProperty("radYakanKangoTaiseiUmu")
    private RadioButton radYakanKangoTaiseiUmu;
    @JsonProperty("ddlTokuteijigyoshoKasanKyotakukaigoshienUmu")
    private DropDownList ddlTokuteijigyoshoKasanKyotakukaigoshienUmu;
    @JsonProperty("KaigoShienSenmonin")
    private KaigoShienSenmoninDiv KaigoShienSenmonin;
    @JsonProperty("txtHomonkaigoServiceTeikyoSekininshaNinsu")
    private TextBoxNum txtHomonkaigoServiceTeikyoSekininshaNinsu;
    @JsonProperty("HomonKaigoIn")
    private HomonKaigoInDiv HomonKaigoIn;
    @JsonProperty("txtRiyoTeiinNinsu")
    private TextBoxNum txtRiyoTeiinNinsu;
    @JsonProperty("txtShiteiYukoKaishiYMD")
    private TextBoxFlexibleDate txtShiteiYukoKaishiYMD;
    @JsonProperty("txtShiteiYukoShuryoYMD")
    private TextBoxFlexibleDate txtShiteiYukoShuryoYMD;
    @JsonProperty("radShiteiKoshinShinseichuKubun")
    private RadioButton radShiteiKoshinShinseichuKubun;
    @JsonProperty("txtKoryokuTeishiKaishiYMD")
    private TextBoxFlexibleDate txtKoryokuTeishiKaishiYMD;
    @JsonProperty("txtKoryokuTeishiShuryoYMD")
    private TextBoxFlexibleDate txtKoryokuTeishiShuryoYMD;
    @JsonProperty("radDaikiboJigyoshaGaitoUmu")
    private RadioButton radDaikiboJigyoshaGaitoUmu;
    @JsonProperty("radJunUnitCareTaiseiUmu")
    private RadioButton radJunUnitCareTaiseiUmu;
    @JsonProperty("radJudokaTaioTaiseiUmu")
    private RadioButton radJudokaTaioTaiseiUmu;
    @JsonProperty("radIryoRenkeiTaiseiUmu")
    private RadioButton radIryoRenkeiTaiseiUmu;
    @JsonProperty("radUnitCareTaiseiUmu")
    private RadioButton radUnitCareTaiseiUmu;
    @JsonProperty("radZaitakuNyushoSogoRiyoTaiseiUmu")
    private RadioButton radZaitakuNyushoSogoRiyoTaiseiUmu;
    @JsonProperty("radTerminalCareTaiseiUmu")
    private RadioButton radTerminalCareTaiseiUmu;
    @JsonProperty("radShintaiKosokuHaishiTorikumiUmu")
    private RadioButton radShintaiKosokuHaishiTorikumiUmu;
    @JsonProperty("radShokiboKyotenShugoTaiseiUmu")
    private RadioButton radShokiboKyotenShugoTaiseiUmu;
    @JsonProperty("radNinchishoCareKasanUmu")
    private RadioButton radNinchishoCareKasanUmu;
    @JsonProperty("ddlKobetsuKinoKunrenTaiseiUmu")
    private DropDownList ddlKobetsuKinoKunrenTaiseiUmu;
    @JsonProperty("KobetsuRihabiri2")
    private KobetsuRihabiri2Div KobetsuRihabiri2;
    @JsonProperty("radSetsubiKijun")
    private RadioButton radSetsubiKijun;
    @JsonProperty("radRyoyoTaiseiIjiTokubetsuKasan")
    private RadioButton radRyoyoTaiseiIjiTokubetsuKasan;
    @JsonProperty("KobetsuRihabiri3")
    private KobetsuRihabiri3Div KobetsuRihabiri3;
    @JsonProperty("radSankyuHelperTaisei")
    private RadioButton radSankyuHelperTaisei;
    @JsonProperty("ChusankanChiiki")
    private ChusankanChiikiDiv ChusankanChiiki;
    @JsonProperty("ddlServiceTeikyoTaiseiKyokaKasan")
    private DropDownList ddlServiceTeikyoTaiseiKyokaKasan;
    @JsonProperty("radNinchishoTankiShuchuRehabilitationKasan")
    private RadioButton radNinchishoTankiShuchuRehabilitationKasan;
    @JsonProperty("radKakunenseiNinchishoRiyoushaUkeeireKasan")
    private RadioButton radKakunenseiNinchishoRiyoushaUkeeireKasan;
    @JsonProperty("radKangoTaiseiKasan")
    private RadioButton radKangoTaiseiKasan;
    @JsonProperty("radYakinShokuinHaichiKasan")
    private RadioButton radYakinShokuinHaichiKasan;
    @JsonProperty("radRyoyoShokuKasan")
    private RadioButton radRyoyoShokuKasan;
    @JsonProperty("radNichijoSeikatsuKeizokuShienKasan")
    private RadioButton radNichijoSeikatsuKeizokuShienKasan;
    @JsonProperty("radNinchishoSemmonCareKasan")
    private RadioButton radNinchishoSemmonCareKasan;
    @JsonProperty("rad24JikanTsuhoTaioKasan")
    private RadioButton rad24JikanTsuhoTaioKasan;
    @JsonProperty("radKangoShokuinHaichiKasan")
    private RadioButton radKangoShokuinHaichiKasan;
    @JsonProperty("radYakanCareKasan")
    private RadioButton radYakanCareKasan;
    @JsonProperty("radShudanCommunicationRyohoUmu")
    private RadioButton radShudanCommunicationRyohoUmu;
    @JsonProperty("radServiceTeikyoTaiseiKyokaKasanKaradokogata")
    private RadioButton radServiceTeikyoTaiseiKyokaKasanKaradokogata;
    @JsonProperty("radNitchuShintaikaigoTaise20funmimanUmu")
    private RadioButton radNitchuShintaikaigoTaise20funmimanUmu;
    @JsonProperty("radServiceTeikyoSekininshaTaiseiUmu")
    private RadioButton radServiceTeikyoSekininshaTaiseiUmu;
    @JsonProperty("radDoitsuTatemonoKyojuRiyoshaGenzanUmu")
    private RadioButton radDoitsuTatemonoKyojuRiyoshaGenzanUmu;
    @JsonProperty("radKinkyuTankiNyushoTaiseiKakuhoKasan")
    private RadioButton radKinkyuTankiNyushoTaiseiKakuhoKasan;
    @JsonProperty("radZaitakuFukkiZaitakuRyoyoShienKinoKasan")
    private RadioButton radZaitakuFukkiZaitakuRyoyoShienKinoKasan;
    @JsonProperty("radSeikatuKinoKojoGroupKatsudoKasan")
    private RadioButton radSeikatuKinoKojoGroupKatsudoKasan;
    @JsonProperty("radKaigoShokuinShoguKaizenKasan")
    private RadioButton radKaigoShokuinShoguKaizenKasan;
    @JsonProperty("btnInputKihon")
    private Button btnInputKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShisetsunadoKubun
     * @return ddlShisetsunadoKubun
     */
    @JsonProperty("ddlShisetsunadoKubun")
    public DropDownList getDdlShisetsunadoKubun() {
        return ddlShisetsunadoKubun;
    }

    /*
     * setddlShisetsunadoKubun
     * @param ddlShisetsunadoKubun ddlShisetsunadoKubun
     */
    @JsonProperty("ddlShisetsunadoKubun")
    public void setDdlShisetsunadoKubun(DropDownList ddlShisetsunadoKubun) {
        this.ddlShisetsunadoKubun = ddlShisetsunadoKubun;
    }

    /*
     * getddlJininHaichiKubun
     * @return ddlJininHaichiKubun
     */
    @JsonProperty("ddlJininHaichiKubun")
    public DropDownList getDdlJininHaichiKubun() {
        return ddlJininHaichiKubun;
    }

    /*
     * setddlJininHaichiKubun
     * @param ddlJininHaichiKubun ddlJininHaichiKubun
     */
    @JsonProperty("ddlJininHaichiKubun")
    public void setDdlJininHaichiKubun(DropDownList ddlJininHaichiKubun) {
        this.ddlJininHaichiKubun = ddlJininHaichiKubun;
    }

    /*
     * getradTokubetsuChiikiKasanUmu
     * @return radTokubetsuChiikiKasanUmu
     */
    @JsonProperty("radTokubetsuChiikiKasanUmu")
    public RadioButton getRadTokubetsuChiikiKasanUmu() {
        return radTokubetsuChiikiKasanUmu;
    }

    /*
     * setradTokubetsuChiikiKasanUmu
     * @param radTokubetsuChiikiKasanUmu radTokubetsuChiikiKasanUmu
     */
    @JsonProperty("radTokubetsuChiikiKasanUmu")
    public void setRadTokubetsuChiikiKasanUmu(RadioButton radTokubetsuChiikiKasanUmu) {
        this.radTokubetsuChiikiKasanUmu = radTokubetsuChiikiKasanUmu;
    }

    /*
     * getradKinkyujiHomonkaigoKasanUmu
     * @return radKinkyujiHomonkaigoKasanUmu
     */
    @JsonProperty("radKinkyujiHomonkaigoKasanUmu")
    public RadioButton getRadKinkyujiHomonkaigoKasanUmu() {
        return radKinkyujiHomonkaigoKasanUmu;
    }

    /*
     * setradKinkyujiHomonkaigoKasanUmu
     * @param radKinkyujiHomonkaigoKasanUmu radKinkyujiHomonkaigoKasanUmu
     */
    @JsonProperty("radKinkyujiHomonkaigoKasanUmu")
    public void setRadKinkyujiHomonkaigoKasanUmu(RadioButton radKinkyujiHomonkaigoKasanUmu) {
        this.radKinkyujiHomonkaigoKasanUmu = radKinkyujiHomonkaigoKasanUmu;
    }

    /*
     * getradTokubetsuKanriTaisei
     * @return radTokubetsuKanriTaisei
     */
    @JsonProperty("radTokubetsuKanriTaisei")
    public RadioButton getRadTokubetsuKanriTaisei() {
        return radTokubetsuKanriTaisei;
    }

    /*
     * setradTokubetsuKanriTaisei
     * @param radTokubetsuKanriTaisei radTokubetsuKanriTaisei
     */
    @JsonProperty("radTokubetsuKanriTaisei")
    public void setRadTokubetsuKanriTaisei(RadioButton radTokubetsuKanriTaisei) {
        this.radTokubetsuKanriTaisei = radTokubetsuKanriTaisei;
    }

    /*
     * getradKinoKunrenShidoTaiseiUmu
     * @return radKinoKunrenShidoTaiseiUmu
     */
    @JsonProperty("radKinoKunrenShidoTaiseiUmu")
    public RadioButton getRadKinoKunrenShidoTaiseiUmu() {
        return radKinoKunrenShidoTaiseiUmu;
    }

    /*
     * setradKinoKunrenShidoTaiseiUmu
     * @param radKinoKunrenShidoTaiseiUmu radKinoKunrenShidoTaiseiUmu
     */
    @JsonProperty("radKinoKunrenShidoTaiseiUmu")
    public void setRadKinoKunrenShidoTaiseiUmu(RadioButton radKinoKunrenShidoTaiseiUmu) {
        this.radKinoKunrenShidoTaiseiUmu = radKinoKunrenShidoTaiseiUmu;
    }

    /*
     * getradShokujiTeikyoTaiseiUmu
     * @return radShokujiTeikyoTaiseiUmu
     */
    @JsonProperty("radShokujiTeikyoTaiseiUmu")
    public RadioButton getRadShokujiTeikyoTaiseiUmu() {
        return radShokujiTeikyoTaiseiUmu;
    }

    /*
     * setradShokujiTeikyoTaiseiUmu
     * @param radShokujiTeikyoTaiseiUmu radShokujiTeikyoTaiseiUmu
     */
    @JsonProperty("radShokujiTeikyoTaiseiUmu")
    public void setRadShokujiTeikyoTaiseiUmu(RadioButton radShokujiTeikyoTaiseiUmu) {
        this.radShokujiTeikyoTaiseiUmu = radShokujiTeikyoTaiseiUmu;
    }

    /*
     * getradNyuyokuKaijoTaiseiUmu
     * @return radNyuyokuKaijoTaiseiUmu
     */
    @JsonProperty("radNyuyokuKaijoTaiseiUmu")
    public RadioButton getRadNyuyokuKaijoTaiseiUmu() {
        return radNyuyokuKaijoTaiseiUmu;
    }

    /*
     * setradNyuyokuKaijoTaiseiUmu
     * @param radNyuyokuKaijoTaiseiUmu radNyuyokuKaijoTaiseiUmu
     */
    @JsonProperty("radNyuyokuKaijoTaiseiUmu")
    public void setRadNyuyokuKaijoTaiseiUmu(RadioButton radNyuyokuKaijoTaiseiUmu) {
        this.radNyuyokuKaijoTaiseiUmu = radNyuyokuKaijoTaiseiUmu;
    }

    /*
     * getradTokubetsuNyuyokuKaijoTaiseiUmu
     * @return radTokubetsuNyuyokuKaijoTaiseiUmu
     */
    @JsonProperty("radTokubetsuNyuyokuKaijoTaiseiUmu")
    public RadioButton getRadTokubetsuNyuyokuKaijoTaiseiUmu() {
        return radTokubetsuNyuyokuKaijoTaiseiUmu;
    }

    /*
     * setradTokubetsuNyuyokuKaijoTaiseiUmu
     * @param radTokubetsuNyuyokuKaijoTaiseiUmu radTokubetsuNyuyokuKaijoTaiseiUmu
     */
    @JsonProperty("radTokubetsuNyuyokuKaijoTaiseiUmu")
    public void setRadTokubetsuNyuyokuKaijoTaiseiUmu(RadioButton radTokubetsuNyuyokuKaijoTaiseiUmu) {
        this.radTokubetsuNyuyokuKaijoTaiseiUmu = radTokubetsuNyuyokuKaijoTaiseiUmu;
    }

    /*
     * getradJoukinsenjuIshiHaichiUmu
     * @return radJoukinsenjuIshiHaichiUmu
     */
    @JsonProperty("radJoukinsenjuIshiHaichiUmu")
    public RadioButton getRadJoukinsenjuIshiHaichiUmu() {
        return radJoukinsenjuIshiHaichiUmu;
    }

    /*
     * setradJoukinsenjuIshiHaichiUmu
     * @param radJoukinsenjuIshiHaichiUmu radJoukinsenjuIshiHaichiUmu
     */
    @JsonProperty("radJoukinsenjuIshiHaichiUmu")
    public void setRadJoukinsenjuIshiHaichiUmu(RadioButton radJoukinsenjuIshiHaichiUmu) {
        this.radJoukinsenjuIshiHaichiUmu = radJoukinsenjuIshiHaichiUmu;
    }

    /*
     * getradIshiHaichiKijun
     * @return radIshiHaichiKijun
     */
    @JsonProperty("radIshiHaichiKijun")
    public RadioButton getRadIshiHaichiKijun() {
        return radIshiHaichiKijun;
    }

    /*
     * setradIshiHaichiKijun
     * @param radIshiHaichiKijun radIshiHaichiKijun
     */
    @JsonProperty("radIshiHaichiKijun")
    public void setRadIshiHaichiKijun(RadioButton radIshiHaichiKijun) {
        this.radIshiHaichiKijun = radIshiHaichiKijun;
    }

    /*
     * getradSeisinkaIshiTeikitekiRyouyousidouUmu
     * @return radSeisinkaIshiTeikitekiRyouyousidouUmu
     */
    @JsonProperty("radSeisinkaIshiTeikitekiRyouyousidouUmu")
    public RadioButton getRadSeisinkaIshiTeikitekiRyouyousidouUmu() {
        return radSeisinkaIshiTeikitekiRyouyousidouUmu;
    }

    /*
     * setradSeisinkaIshiTeikitekiRyouyousidouUmu
     * @param radSeisinkaIshiTeikitekiRyouyousidouUmu radSeisinkaIshiTeikitekiRyouyousidouUmu
     */
    @JsonProperty("radSeisinkaIshiTeikitekiRyouyousidouUmu")
    public void setRadSeisinkaIshiTeikitekiRyouyousidouUmu(RadioButton radSeisinkaIshiTeikitekiRyouyousidouUmu) {
        this.radSeisinkaIshiTeikitekiRyouyousidouUmu = radSeisinkaIshiTeikitekiRyouyousidouUmu;
    }

    /*
     * getddlYakanKinmuJokenKijun
     * @return ddlYakanKinmuJokenKijun
     */
    @JsonProperty("ddlYakanKinmuJokenKijun")
    public DropDownList getDdlYakanKinmuJokenKijun() {
        return ddlYakanKinmuJokenKijun;
    }

    /*
     * setddlYakanKinmuJokenKijun
     * @param ddlYakanKinmuJokenKijun ddlYakanKinmuJokenKijun
     */
    @JsonProperty("ddlYakanKinmuJokenKijun")
    public void setDdlYakanKinmuJokenKijun(DropDownList ddlYakanKinmuJokenKijun) {
        this.ddlYakanKinmuJokenKijun = ddlYakanKinmuJokenKijun;
    }

    /*
     * getradNinchishouSenmontouUmu
     * @return radNinchishouSenmontouUmu
     */
    @JsonProperty("radNinchishouSenmontouUmu")
    public RadioButton getRadNinchishouSenmontouUmu() {
        return radNinchishouSenmontouUmu;
    }

    /*
     * setradNinchishouSenmontouUmu
     * @param radNinchishouSenmontouUmu radNinchishouSenmontouUmu
     */
    @JsonProperty("radNinchishouSenmontouUmu")
    public void setRadNinchishouSenmontouUmu(RadioButton radNinchishouSenmontouUmu) {
        this.radNinchishouSenmontouUmu = radNinchishouSenmontouUmu;
    }

    /*
     * getddlShokujiTeikyoJokyo
     * @return ddlShokujiTeikyoJokyo
     */
    @JsonProperty("ddlShokujiTeikyoJokyo")
    public DropDownList getDdlShokujiTeikyoJokyo() {
        return ddlShokujiTeikyoJokyo;
    }

    /*
     * setddlShokujiTeikyoJokyo
     * @param ddlShokujiTeikyoJokyo ddlShokujiTeikyoJokyo
     */
    @JsonProperty("ddlShokujiTeikyoJokyo")
    public void setDdlShokujiTeikyoJokyo(DropDownList ddlShokujiTeikyoJokyo) {
        this.ddlShokujiTeikyoJokyo = ddlShokujiTeikyoJokyo;
    }

    /*
     * getradSougeiTaisei
     * @return radSougeiTaisei
     */
    @JsonProperty("radSougeiTaisei")
    public RadioButton getRadSougeiTaisei() {
        return radSougeiTaisei;
    }

    /*
     * setradSougeiTaisei
     * @param radSougeiTaisei radSougeiTaisei
     */
    @JsonProperty("radSougeiTaisei")
    public void setRadSougeiTaisei(RadioButton radSougeiTaisei) {
        this.radSougeiTaisei = radSougeiTaisei;
    }

    /*
     * getRihabiri
     * @return Rihabiri
     */
    @JsonProperty("Rihabiri")
    public RihabiriDiv getRihabiri() {
        return Rihabiri;
    }

    /*
     * setRihabiri
     * @param Rihabiri Rihabiri
     */
    @JsonProperty("Rihabiri")
    public void setRihabiri(RihabiriDiv Rihabiri) {
        this.Rihabiri = Rihabiri;
    }

    /*
     * getradRehabilitationKasanJokyoUmu
     * @return radRehabilitationKasanJokyoUmu
     */
    @JsonProperty("radRehabilitationKasanJokyoUmu")
    public RadioButton getRadRehabilitationKasanJokyoUmu() {
        return radRehabilitationKasanJokyoUmu;
    }

    /*
     * setradRehabilitationKasanJokyoUmu
     * @param radRehabilitationKasanJokyoUmu radRehabilitationKasanJokyoUmu
     */
    @JsonProperty("radRehabilitationKasanJokyoUmu")
    public void setRadRehabilitationKasanJokyoUmu(RadioButton radRehabilitationKasanJokyoUmu) {
        this.radRehabilitationKasanJokyoUmu = radRehabilitationKasanJokyoUmu;
    }

    /*
     * getddlRyoyoKankyoKijun
     * @return ddlRyoyoKankyoKijun
     */
    @JsonProperty("ddlRyoyoKankyoKijun")
    public DropDownList getDdlRyoyoKankyoKijun() {
        return ddlRyoyoKankyoKijun;
    }

    /*
     * setddlRyoyoKankyoKijun
     * @param ddlRyoyoKankyoKijun ddlRyoyoKankyoKijun
     */
    @JsonProperty("ddlRyoyoKankyoKijun")
    public void setDdlRyoyoKankyoKijun(DropDownList ddlRyoyoKankyoKijun) {
        this.ddlRyoyoKankyoKijun = ddlRyoyoKankyoKijun;
    }

    /*
     * getradIshiKetuinGenzanJokyoUmu
     * @return radIshiKetuinGenzanJokyoUmu
     */
    @JsonProperty("radIshiKetuinGenzanJokyoUmu")
    public RadioButton getRadIshiKetuinGenzanJokyoUmu() {
        return radIshiKetuinGenzanJokyoUmu;
    }

    /*
     * setradIshiKetuinGenzanJokyoUmu
     * @param radIshiKetuinGenzanJokyoUmu radIshiKetuinGenzanJokyoUmu
     */
    @JsonProperty("radIshiKetuinGenzanJokyoUmu")
    public void setRadIshiKetuinGenzanJokyoUmu(RadioButton radIshiKetuinGenzanJokyoUmu) {
        this.radIshiKetuinGenzanJokyoUmu = radIshiKetuinGenzanJokyoUmu;
    }

    /*
     * getradKangoShokuinKetsuinGenzanJokyoUmu
     * @return radKangoShokuinKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKangoShokuinKetsuinGenzanJokyoUmu")
    public RadioButton getRadKangoShokuinKetsuinGenzanJokyoUmu() {
        return radKangoShokuinKetsuinGenzanJokyoUmu;
    }

    /*
     * setradKangoShokuinKetsuinGenzanJokyoUmu
     * @param radKangoShokuinKetsuinGenzanJokyoUmu radKangoShokuinKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKangoShokuinKetsuinGenzanJokyoUmu")
    public void setRadKangoShokuinKetsuinGenzanJokyoUmu(RadioButton radKangoShokuinKetsuinGenzanJokyoUmu) {
        this.radKangoShokuinKetsuinGenzanJokyoUmu = radKangoShokuinKetsuinGenzanJokyoUmu;
    }

    /*
     * getradRigakuRyouhousiKetsuinGenzanJokyoUmu
     * @return radRigakuRyouhousiKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radRigakuRyouhousiKetsuinGenzanJokyoUmu")
    public RadioButton getRadRigakuRyouhousiKetsuinGenzanJokyoUmu() {
        return radRigakuRyouhousiKetsuinGenzanJokyoUmu;
    }

    /*
     * setradRigakuRyouhousiKetsuinGenzanJokyoUmu
     * @param radRigakuRyouhousiKetsuinGenzanJokyoUmu radRigakuRyouhousiKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radRigakuRyouhousiKetsuinGenzanJokyoUmu")
    public void setRadRigakuRyouhousiKetsuinGenzanJokyoUmu(RadioButton radRigakuRyouhousiKetsuinGenzanJokyoUmu) {
        this.radRigakuRyouhousiKetsuinGenzanJokyoUmu = radRigakuRyouhousiKetsuinGenzanJokyoUmu;
    }

    /*
     * getradSagyouRyouhousiKetsuinGenzanJokyoUmu
     * @return radSagyouRyouhousiKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radSagyouRyouhousiKetsuinGenzanJokyoUmu")
    public RadioButton getRadSagyouRyouhousiKetsuinGenzanJokyoUmu() {
        return radSagyouRyouhousiKetsuinGenzanJokyoUmu;
    }

    /*
     * setradSagyouRyouhousiKetsuinGenzanJokyoUmu
     * @param radSagyouRyouhousiKetsuinGenzanJokyoUmu radSagyouRyouhousiKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radSagyouRyouhousiKetsuinGenzanJokyoUmu")
    public void setRadSagyouRyouhousiKetsuinGenzanJokyoUmu(RadioButton radSagyouRyouhousiKetsuinGenzanJokyoUmu) {
        this.radSagyouRyouhousiKetsuinGenzanJokyoUmu = radSagyouRyouhousiKetsuinGenzanJokyoUmu;
    }

    /*
     * getradKaigoShokuinKetsuinGenzanJokyoUmu
     * @return radKaigoShokuinKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKaigoShokuinKetsuinGenzanJokyoUmu")
    public RadioButton getRadKaigoShokuinKetsuinGenzanJokyoUmu() {
        return radKaigoShokuinKetsuinGenzanJokyoUmu;
    }

    /*
     * setradKaigoShokuinKetsuinGenzanJokyoUmu
     * @param radKaigoShokuinKetsuinGenzanJokyoUmu radKaigoShokuinKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKaigoShokuinKetsuinGenzanJokyoUmu")
    public void setRadKaigoShokuinKetsuinGenzanJokyoUmu(RadioButton radKaigoShokuinKetsuinGenzanJokyoUmu) {
        this.radKaigoShokuinKetsuinGenzanJokyoUmu = radKaigoShokuinKetsuinGenzanJokyoUmu;
    }

    /*
     * getradKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu
     * @return radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu")
    public RadioButton getRadKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu() {
        return radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu;
    }

    /*
     * setradKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu
     * @param radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu")
    public void setRadKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu(RadioButton radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu) {
        this.radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu = radKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu;
    }

    /*
     * getradKaigoJujishaKetsuinGenzanJokyoUmu
     * @return radKaigoJujishaKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKaigoJujishaKetsuinGenzanJokyoUmu")
    public RadioButton getRadKaigoJujishaKetsuinGenzanJokyoUmu() {
        return radKaigoJujishaKetsuinGenzanJokyoUmu;
    }

    /*
     * setradKaigoJujishaKetsuinGenzanJokyoUmu
     * @param radKaigoJujishaKetsuinGenzanJokyoUmu radKaigoJujishaKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radKaigoJujishaKetsuinGenzanJokyoUmu")
    public void setRadKaigoJujishaKetsuinGenzanJokyoUmu(RadioButton radKaigoJujishaKetsuinGenzanJokyoUmu) {
        this.radKaigoJujishaKetsuinGenzanJokyoUmu = radKaigoJujishaKetsuinGenzanJokyoUmu;
    }

    /*
     * getradKansenTaisakuSidoKanriUmu
     * @return radKansenTaisakuSidoKanriUmu
     */
    @JsonProperty("radKansenTaisakuSidoKanriUmu")
    public RadioButton getRadKansenTaisakuSidoKanriUmu() {
        return radKansenTaisakuSidoKanriUmu;
    }

    /*
     * setradKansenTaisakuSidoKanriUmu
     * @param radKansenTaisakuSidoKanriUmu radKansenTaisakuSidoKanriUmu
     */
    @JsonProperty("radKansenTaisakuSidoKanriUmu")
    public void setRadKansenTaisakuSidoKanriUmu(RadioButton radKansenTaisakuSidoKanriUmu) {
        this.radKansenTaisakuSidoKanriUmu = radKansenTaisakuSidoKanriUmu;
    }

    /*
     * getradJushoHifuKaiyouShidoKanriUmu
     * @return radJushoHifuKaiyouShidoKanriUmu
     */
    @JsonProperty("radJushoHifuKaiyouShidoKanriUmu")
    public RadioButton getRadJushoHifuKaiyouShidoKanriUmu() {
        return radJushoHifuKaiyouShidoKanriUmu;
    }

    /*
     * setradJushoHifuKaiyouShidoKanriUmu
     * @param radJushoHifuKaiyouShidoKanriUmu radJushoHifuKaiyouShidoKanriUmu
     */
    @JsonProperty("radJushoHifuKaiyouShidoKanriUmu")
    public void setRadJushoHifuKaiyouShidoKanriUmu(RadioButton radJushoHifuKaiyouShidoKanriUmu) {
        this.radJushoHifuKaiyouShidoKanriUmu = radJushoHifuKaiyouShidoKanriUmu;
    }

    /*
     * getradYakuzaiKaniriShidoUmu
     * @return radYakuzaiKaniriShidoUmu
     */
    @JsonProperty("radYakuzaiKaniriShidoUmu")
    public RadioButton getRadYakuzaiKaniriShidoUmu() {
        return radYakuzaiKaniriShidoUmu;
    }

    /*
     * setradYakuzaiKaniriShidoUmu
     * @param radYakuzaiKaniriShidoUmu radYakuzaiKaniriShidoUmu
     */
    @JsonProperty("radYakuzaiKaniriShidoUmu")
    public void setRadYakuzaiKaniriShidoUmu(RadioButton radYakuzaiKaniriShidoUmu) {
        this.radYakuzaiKaniriShidoUmu = radYakuzaiKaniriShidoUmu;
    }

    /*
     * getradShogaishaSeikatsuShienTaiseiUmu
     * @return radShogaishaSeikatsuShienTaiseiUmu
     */
    @JsonProperty("radShogaishaSeikatsuShienTaiseiUmu")
    public RadioButton getRadShogaishaSeikatsuShienTaiseiUmu() {
        return radShogaishaSeikatsuShienTaiseiUmu;
    }

    /*
     * setradShogaishaSeikatsuShienTaiseiUmu
     * @param radShogaishaSeikatsuShienTaiseiUmu radShogaishaSeikatsuShienTaiseiUmu
     */
    @JsonProperty("radShogaishaSeikatsuShienTaiseiUmu")
    public void setRadShogaishaSeikatsuShienTaiseiUmu(RadioButton radShogaishaSeikatsuShienTaiseiUmu) {
        this.radShogaishaSeikatsuShienTaiseiUmu = radShogaishaSeikatsuShienTaiseiUmu;
    }

    /*
     * getddlChiikiKubun
     * @return ddlChiikiKubun
     */
    @JsonProperty("ddlChiikiKubun")
    public DropDownList getDdlChiikiKubun() {
        return ddlChiikiKubun;
    }

    /*
     * setddlChiikiKubun
     * @param ddlChiikiKubun ddlChiikiKubun
     */
    @JsonProperty("ddlChiikiKubun")
    public void setDdlChiikiKubun(DropDownList ddlChiikiKubun) {
        this.ddlChiikiKubun = ddlChiikiKubun;
    }

    /*
     * getradJikanEnchoServiceTaisei
     * @return radJikanEnchoServiceTaisei
     */
    @JsonProperty("radJikanEnchoServiceTaisei")
    public RadioButton getRadJikanEnchoServiceTaisei() {
        return radJikanEnchoServiceTaisei;
    }

    /*
     * setradJikanEnchoServiceTaisei
     * @param radJikanEnchoServiceTaisei radJikanEnchoServiceTaisei
     */
    @JsonProperty("radJikanEnchoServiceTaisei")
    public void setRadJikanEnchoServiceTaisei(RadioButton radJikanEnchoServiceTaisei) {
        this.radJikanEnchoServiceTaisei = radJikanEnchoServiceTaisei;
    }

    /*
     * getradKobetsuRehabilitationTeikyoTaisei
     * @return radKobetsuRehabilitationTeikyoTaisei
     */
    @JsonProperty("radKobetsuRehabilitationTeikyoTaisei")
    public RadioButton getRadKobetsuRehabilitationTeikyoTaisei() {
        return radKobetsuRehabilitationTeikyoTaisei;
    }

    /*
     * setradKobetsuRehabilitationTeikyoTaisei
     * @param radKobetsuRehabilitationTeikyoTaisei radKobetsuRehabilitationTeikyoTaisei
     */
    @JsonProperty("radKobetsuRehabilitationTeikyoTaisei")
    public void setRadKobetsuRehabilitationTeikyoTaisei(RadioButton radKobetsuRehabilitationTeikyoTaisei) {
        this.radKobetsuRehabilitationTeikyoTaisei = radKobetsuRehabilitationTeikyoTaisei;
    }

    /*
     * getradKyojuhiTaisaku
     * @return radKyojuhiTaisaku
     */
    @JsonProperty("radKyojuhiTaisaku")
    public RadioButton getRadKyojuhiTaisaku() {
        return radKyojuhiTaisaku;
    }

    /*
     * setradKyojuhiTaisaku
     * @param radKyojuhiTaisaku radKyojuhiTaisaku
     */
    @JsonProperty("radKyojuhiTaisaku")
    public void setRadKyojuhiTaisaku(RadioButton radKyojuhiTaisaku) {
        this.radKyojuhiTaisaku = radKyojuhiTaisaku;
    }

    /*
     * getradYakanCareUmu
     * @return radYakanCareUmu
     */
    @JsonProperty("radYakanCareUmu")
    public RadioButton getRadYakanCareUmu() {
        return radYakanCareUmu;
    }

    /*
     * setradYakanCareUmu
     * @param radYakanCareUmu radYakanCareUmu
     */
    @JsonProperty("radYakanCareUmu")
    public void setRadYakanCareUmu(RadioButton radYakanCareUmu) {
        this.radYakanCareUmu = radYakanCareUmu;
    }

    /*
     * getradRehabilitationKinoKyokaUmu
     * @return radRehabilitationKinoKyokaUmu
     */
    @JsonProperty("radRehabilitationKinoKyokaUmu")
    public RadioButton getRadRehabilitationKinoKyokaUmu() {
        return radRehabilitationKinoKyokaUmu;
    }

    /*
     * setradRehabilitationKinoKyokaUmu
     * @param radRehabilitationKinoKyokaUmu radRehabilitationKinoKyokaUmu
     */
    @JsonProperty("radRehabilitationKinoKyokaUmu")
    public void setRadRehabilitationKinoKyokaUmu(RadioButton radRehabilitationKinoKyokaUmu) {
        this.radRehabilitationKinoKyokaUmu = radRehabilitationKinoKyokaUmu;
    }

    /*
     * getKobetsuRihabiri1
     * @return KobetsuRihabiri1
     */
    @JsonProperty("KobetsuRihabiri1")
    public KobetsuRihabiri1Div getKobetsuRihabiri1() {
        return KobetsuRihabiri1;
    }

    /*
     * setKobetsuRihabiri1
     * @param KobetsuRihabiri1 KobetsuRihabiri1
     */
    @JsonProperty("KobetsuRihabiri1")
    public void setKobetsuRihabiri1(KobetsuRihabiri1Div KobetsuRihabiri1) {
        this.KobetsuRihabiri1 = KobetsuRihabiri1;
    }

    /*
     * getradGengoChokakushiKetsuinGenzanJokyoUmu
     * @return radGengoChokakushiKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radGengoChokakushiKetsuinGenzanJokyoUmu")
    public RadioButton getRadGengoChokakushiKetsuinGenzanJokyoUmu() {
        return radGengoChokakushiKetsuinGenzanJokyoUmu;
    }

    /*
     * setradGengoChokakushiKetsuinGenzanJokyoUmu
     * @param radGengoChokakushiKetsuinGenzanJokyoUmu radGengoChokakushiKetsuinGenzanJokyoUmu
     */
    @JsonProperty("radGengoChokakushiKetsuinGenzanJokyoUmu")
    public void setRadGengoChokakushiKetsuinGenzanJokyoUmu(RadioButton radGengoChokakushiKetsuinGenzanJokyoUmu) {
        this.radGengoChokakushiKetsuinGenzanJokyoUmu = radGengoChokakushiKetsuinGenzanJokyoUmu;
    }

    /*
     * getddlEiyouKanriHyoka
     * @return ddlEiyouKanriHyoka
     */
    @JsonProperty("ddlEiyouKanriHyoka")
    public DropDownList getDdlEiyouKanriHyoka() {
        return ddlEiyouKanriHyoka;
    }

    /*
     * setddlEiyouKanriHyoka
     * @param ddlEiyouKanriHyoka ddlEiyouKanriHyoka
     */
    @JsonProperty("ddlEiyouKanriHyoka")
    public void setDdlEiyouKanriHyoka(DropDownList ddlEiyouKanriHyoka) {
        this.ddlEiyouKanriHyoka = ddlEiyouKanriHyoka;
    }

    /*
     * getradTokuteijigyoushoKasanHomonKaigoUmu
     * @return radTokuteijigyoushoKasanHomonKaigoUmu
     */
    @JsonProperty("radTokuteijigyoushoKasanHomonKaigoUmu")
    public RadioButton getRadTokuteijigyoushoKasanHomonKaigoUmu() {
        return radTokuteijigyoushoKasanHomonKaigoUmu;
    }

    /*
     * setradTokuteijigyoushoKasanHomonKaigoUmu
     * @param radTokuteijigyoushoKasanHomonKaigoUmu radTokuteijigyoushoKasanHomonKaigoUmu
     */
    @JsonProperty("radTokuteijigyoushoKasanHomonKaigoUmu")
    public void setRadTokuteijigyoushoKasanHomonKaigoUmu(RadioButton radTokuteijigyoushoKasanHomonKaigoUmu) {
        this.radTokuteijigyoushoKasanHomonKaigoUmu = radTokuteijigyoushoKasanHomonKaigoUmu;
    }

    /*
     * getradJakunenseiNinchishoCareTaiseiUmu
     * @return radJakunenseiNinchishoCareTaiseiUmu
     */
    @JsonProperty("radJakunenseiNinchishoCareTaiseiUmu")
    public RadioButton getRadJakunenseiNinchishoCareTaiseiUmu() {
        return radJakunenseiNinchishoCareTaiseiUmu;
    }

    /*
     * setradJakunenseiNinchishoCareTaiseiUmu
     * @param radJakunenseiNinchishoCareTaiseiUmu radJakunenseiNinchishoCareTaiseiUmu
     */
    @JsonProperty("radJakunenseiNinchishoCareTaiseiUmu")
    public void setRadJakunenseiNinchishoCareTaiseiUmu(RadioButton radJakunenseiNinchishoCareTaiseiUmu) {
        this.radJakunenseiNinchishoCareTaiseiUmu = radJakunenseiNinchishoCareTaiseiUmu;
    }

    /*
     * getradUndokiKinoKojoTaiseiUmu
     * @return radUndokiKinoKojoTaiseiUmu
     */
    @JsonProperty("radUndokiKinoKojoTaiseiUmu")
    public RadioButton getRadUndokiKinoKojoTaiseiUmu() {
        return radUndokiKinoKojoTaiseiUmu;
    }

    /*
     * setradUndokiKinoKojoTaiseiUmu
     * @param radUndokiKinoKojoTaiseiUmu radUndokiKinoKojoTaiseiUmu
     */
    @JsonProperty("radUndokiKinoKojoTaiseiUmu")
    public void setRadUndokiKinoKojoTaiseiUmu(RadioButton radUndokiKinoKojoTaiseiUmu) {
        this.radUndokiKinoKojoTaiseiUmu = radUndokiKinoKojoTaiseiUmu;
    }

    /*
     * getradEiyoManagementKaizenTaiseiUmu
     * @return radEiyoManagementKaizenTaiseiUmu
     */
    @JsonProperty("radEiyoManagementKaizenTaiseiUmu")
    public RadioButton getRadEiyoManagementKaizenTaiseiUmu() {
        return radEiyoManagementKaizenTaiseiUmu;
    }

    /*
     * setradEiyoManagementKaizenTaiseiUmu
     * @param radEiyoManagementKaizenTaiseiUmu radEiyoManagementKaizenTaiseiUmu
     */
    @JsonProperty("radEiyoManagementKaizenTaiseiUmu")
    public void setRadEiyoManagementKaizenTaiseiUmu(RadioButton radEiyoManagementKaizenTaiseiUmu) {
        this.radEiyoManagementKaizenTaiseiUmu = radEiyoManagementKaizenTaiseiUmu;
    }

    /*
     * getradKokuKinoKojoTaiseiUmu
     * @return radKokuKinoKojoTaiseiUmu
     */
    @JsonProperty("radKokuKinoKojoTaiseiUmu")
    public RadioButton getRadKokuKinoKojoTaiseiUmu() {
        return radKokuKinoKojoTaiseiUmu;
    }

    /*
     * setradKokuKinoKojoTaiseiUmu
     * @param radKokuKinoKojoTaiseiUmu radKokuKinoKojoTaiseiUmu
     */
    @JsonProperty("radKokuKinoKojoTaiseiUmu")
    public void setRadKokuKinoKojoTaiseiUmu(RadioButton radKokuKinoKojoTaiseiUmu) {
        this.radKokuKinoKojoTaiseiUmu = radKokuKinoKojoTaiseiUmu;
    }

    /*
     * getradJigyoshoHyokaKasanMoshideUmu
     * @return radJigyoshoHyokaKasanMoshideUmu
     */
    @JsonProperty("radJigyoshoHyokaKasanMoshideUmu")
    public RadioButton getRadJigyoshoHyokaKasanMoshideUmu() {
        return radJigyoshoHyokaKasanMoshideUmu;
    }

    /*
     * setradJigyoshoHyokaKasanMoshideUmu
     * @param radJigyoshoHyokaKasanMoshideUmu radJigyoshoHyokaKasanMoshideUmu
     */
    @JsonProperty("radJigyoshoHyokaKasanMoshideUmu")
    public void setRadJigyoshoHyokaKasanMoshideUmu(RadioButton radJigyoshoHyokaKasanMoshideUmu) {
        this.radJigyoshoHyokaKasanMoshideUmu = radJigyoshoHyokaKasanMoshideUmu;
    }

    /*
     * getradJigyoshoHyokaKasanKetteiUmu
     * @return radJigyoshoHyokaKasanKetteiUmu
     */
    @JsonProperty("radJigyoshoHyokaKasanKetteiUmu")
    public RadioButton getRadJigyoshoHyokaKasanKetteiUmu() {
        return radJigyoshoHyokaKasanKetteiUmu;
    }

    /*
     * setradJigyoshoHyokaKasanKetteiUmu
     * @param radJigyoshoHyokaKasanKetteiUmu radJigyoshoHyokaKasanKetteiUmu
     */
    @JsonProperty("radJigyoshoHyokaKasanKetteiUmu")
    public void setRadJigyoshoHyokaKasanKetteiUmu(RadioButton radJigyoshoHyokaKasanKetteiUmu) {
        this.radJigyoshoHyokaKasanKetteiUmu = radJigyoshoHyokaKasanKetteiUmu;
    }

    /*
     * getradKinkyuUkeireTaiseiUmu
     * @return radKinkyuUkeireTaiseiUmu
     */
    @JsonProperty("radKinkyuUkeireTaiseiUmu")
    public RadioButton getRadKinkyuUkeireTaiseiUmu() {
        return radKinkyuUkeireTaiseiUmu;
    }

    /*
     * setradKinkyuUkeireTaiseiUmu
     * @param radKinkyuUkeireTaiseiUmu radKinkyuUkeireTaiseiUmu
     */
    @JsonProperty("radKinkyuUkeireTaiseiUmu")
    public void setRadKinkyuUkeireTaiseiUmu(RadioButton radKinkyuUkeireTaiseiUmu) {
        this.radKinkyuUkeireTaiseiUmu = radKinkyuUkeireTaiseiUmu;
    }

    /*
     * getradYakanKangoTaiseiUmu
     * @return radYakanKangoTaiseiUmu
     */
    @JsonProperty("radYakanKangoTaiseiUmu")
    public RadioButton getRadYakanKangoTaiseiUmu() {
        return radYakanKangoTaiseiUmu;
    }

    /*
     * setradYakanKangoTaiseiUmu
     * @param radYakanKangoTaiseiUmu radYakanKangoTaiseiUmu
     */
    @JsonProperty("radYakanKangoTaiseiUmu")
    public void setRadYakanKangoTaiseiUmu(RadioButton radYakanKangoTaiseiUmu) {
        this.radYakanKangoTaiseiUmu = radYakanKangoTaiseiUmu;
    }

    /*
     * getddlTokuteijigyoshoKasanKyotakukaigoshienUmu
     * @return ddlTokuteijigyoshoKasanKyotakukaigoshienUmu
     */
    @JsonProperty("ddlTokuteijigyoshoKasanKyotakukaigoshienUmu")
    public DropDownList getDdlTokuteijigyoshoKasanKyotakukaigoshienUmu() {
        return ddlTokuteijigyoshoKasanKyotakukaigoshienUmu;
    }

    /*
     * setddlTokuteijigyoshoKasanKyotakukaigoshienUmu
     * @param ddlTokuteijigyoshoKasanKyotakukaigoshienUmu ddlTokuteijigyoshoKasanKyotakukaigoshienUmu
     */
    @JsonProperty("ddlTokuteijigyoshoKasanKyotakukaigoshienUmu")
    public void setDdlTokuteijigyoshoKasanKyotakukaigoshienUmu(DropDownList ddlTokuteijigyoshoKasanKyotakukaigoshienUmu) {
        this.ddlTokuteijigyoshoKasanKyotakukaigoshienUmu = ddlTokuteijigyoshoKasanKyotakukaigoshienUmu;
    }

    /*
     * getKaigoShienSenmonin
     * @return KaigoShienSenmonin
     */
    @JsonProperty("KaigoShienSenmonin")
    public KaigoShienSenmoninDiv getKaigoShienSenmonin() {
        return KaigoShienSenmonin;
    }

    /*
     * setKaigoShienSenmonin
     * @param KaigoShienSenmonin KaigoShienSenmonin
     */
    @JsonProperty("KaigoShienSenmonin")
    public void setKaigoShienSenmonin(KaigoShienSenmoninDiv KaigoShienSenmonin) {
        this.KaigoShienSenmonin = KaigoShienSenmonin;
    }

    /*
     * gettxtHomonkaigoServiceTeikyoSekininshaNinsu
     * @return txtHomonkaigoServiceTeikyoSekininshaNinsu
     */
    @JsonProperty("txtHomonkaigoServiceTeikyoSekininshaNinsu")
    public TextBoxNum getTxtHomonkaigoServiceTeikyoSekininshaNinsu() {
        return txtHomonkaigoServiceTeikyoSekininshaNinsu;
    }

    /*
     * settxtHomonkaigoServiceTeikyoSekininshaNinsu
     * @param txtHomonkaigoServiceTeikyoSekininshaNinsu txtHomonkaigoServiceTeikyoSekininshaNinsu
     */
    @JsonProperty("txtHomonkaigoServiceTeikyoSekininshaNinsu")
    public void setTxtHomonkaigoServiceTeikyoSekininshaNinsu(TextBoxNum txtHomonkaigoServiceTeikyoSekininshaNinsu) {
        this.txtHomonkaigoServiceTeikyoSekininshaNinsu = txtHomonkaigoServiceTeikyoSekininshaNinsu;
    }

    /*
     * getHomonKaigoIn
     * @return HomonKaigoIn
     */
    @JsonProperty("HomonKaigoIn")
    public HomonKaigoInDiv getHomonKaigoIn() {
        return HomonKaigoIn;
    }

    /*
     * setHomonKaigoIn
     * @param HomonKaigoIn HomonKaigoIn
     */
    @JsonProperty("HomonKaigoIn")
    public void setHomonKaigoIn(HomonKaigoInDiv HomonKaigoIn) {
        this.HomonKaigoIn = HomonKaigoIn;
    }

    /*
     * gettxtRiyoTeiinNinsu
     * @return txtRiyoTeiinNinsu
     */
    @JsonProperty("txtRiyoTeiinNinsu")
    public TextBoxNum getTxtRiyoTeiinNinsu() {
        return txtRiyoTeiinNinsu;
    }

    /*
     * settxtRiyoTeiinNinsu
     * @param txtRiyoTeiinNinsu txtRiyoTeiinNinsu
     */
    @JsonProperty("txtRiyoTeiinNinsu")
    public void setTxtRiyoTeiinNinsu(TextBoxNum txtRiyoTeiinNinsu) {
        this.txtRiyoTeiinNinsu = txtRiyoTeiinNinsu;
    }

    /*
     * gettxtShiteiYukoKaishiYMD
     * @return txtShiteiYukoKaishiYMD
     */
    @JsonProperty("txtShiteiYukoKaishiYMD")
    public TextBoxFlexibleDate getTxtShiteiYukoKaishiYMD() {
        return txtShiteiYukoKaishiYMD;
    }

    /*
     * settxtShiteiYukoKaishiYMD
     * @param txtShiteiYukoKaishiYMD txtShiteiYukoKaishiYMD
     */
    @JsonProperty("txtShiteiYukoKaishiYMD")
    public void setTxtShiteiYukoKaishiYMD(TextBoxFlexibleDate txtShiteiYukoKaishiYMD) {
        this.txtShiteiYukoKaishiYMD = txtShiteiYukoKaishiYMD;
    }

    /*
     * gettxtShiteiYukoShuryoYMD
     * @return txtShiteiYukoShuryoYMD
     */
    @JsonProperty("txtShiteiYukoShuryoYMD")
    public TextBoxFlexibleDate getTxtShiteiYukoShuryoYMD() {
        return txtShiteiYukoShuryoYMD;
    }

    /*
     * settxtShiteiYukoShuryoYMD
     * @param txtShiteiYukoShuryoYMD txtShiteiYukoShuryoYMD
     */
    @JsonProperty("txtShiteiYukoShuryoYMD")
    public void setTxtShiteiYukoShuryoYMD(TextBoxFlexibleDate txtShiteiYukoShuryoYMD) {
        this.txtShiteiYukoShuryoYMD = txtShiteiYukoShuryoYMD;
    }

    /*
     * getradShiteiKoshinShinseichuKubun
     * @return radShiteiKoshinShinseichuKubun
     */
    @JsonProperty("radShiteiKoshinShinseichuKubun")
    public RadioButton getRadShiteiKoshinShinseichuKubun() {
        return radShiteiKoshinShinseichuKubun;
    }

    /*
     * setradShiteiKoshinShinseichuKubun
     * @param radShiteiKoshinShinseichuKubun radShiteiKoshinShinseichuKubun
     */
    @JsonProperty("radShiteiKoshinShinseichuKubun")
    public void setRadShiteiKoshinShinseichuKubun(RadioButton radShiteiKoshinShinseichuKubun) {
        this.radShiteiKoshinShinseichuKubun = radShiteiKoshinShinseichuKubun;
    }

    /*
     * gettxtKoryokuTeishiKaishiYMD
     * @return txtKoryokuTeishiKaishiYMD
     */
    @JsonProperty("txtKoryokuTeishiKaishiYMD")
    public TextBoxFlexibleDate getTxtKoryokuTeishiKaishiYMD() {
        return txtKoryokuTeishiKaishiYMD;
    }

    /*
     * settxtKoryokuTeishiKaishiYMD
     * @param txtKoryokuTeishiKaishiYMD txtKoryokuTeishiKaishiYMD
     */
    @JsonProperty("txtKoryokuTeishiKaishiYMD")
    public void setTxtKoryokuTeishiKaishiYMD(TextBoxFlexibleDate txtKoryokuTeishiKaishiYMD) {
        this.txtKoryokuTeishiKaishiYMD = txtKoryokuTeishiKaishiYMD;
    }

    /*
     * gettxtKoryokuTeishiShuryoYMD
     * @return txtKoryokuTeishiShuryoYMD
     */
    @JsonProperty("txtKoryokuTeishiShuryoYMD")
    public TextBoxFlexibleDate getTxtKoryokuTeishiShuryoYMD() {
        return txtKoryokuTeishiShuryoYMD;
    }

    /*
     * settxtKoryokuTeishiShuryoYMD
     * @param txtKoryokuTeishiShuryoYMD txtKoryokuTeishiShuryoYMD
     */
    @JsonProperty("txtKoryokuTeishiShuryoYMD")
    public void setTxtKoryokuTeishiShuryoYMD(TextBoxFlexibleDate txtKoryokuTeishiShuryoYMD) {
        this.txtKoryokuTeishiShuryoYMD = txtKoryokuTeishiShuryoYMD;
    }

    /*
     * getradDaikiboJigyoshaGaitoUmu
     * @return radDaikiboJigyoshaGaitoUmu
     */
    @JsonProperty("radDaikiboJigyoshaGaitoUmu")
    public RadioButton getRadDaikiboJigyoshaGaitoUmu() {
        return radDaikiboJigyoshaGaitoUmu;
    }

    /*
     * setradDaikiboJigyoshaGaitoUmu
     * @param radDaikiboJigyoshaGaitoUmu radDaikiboJigyoshaGaitoUmu
     */
    @JsonProperty("radDaikiboJigyoshaGaitoUmu")
    public void setRadDaikiboJigyoshaGaitoUmu(RadioButton radDaikiboJigyoshaGaitoUmu) {
        this.radDaikiboJigyoshaGaitoUmu = radDaikiboJigyoshaGaitoUmu;
    }

    /*
     * getradJunUnitCareTaiseiUmu
     * @return radJunUnitCareTaiseiUmu
     */
    @JsonProperty("radJunUnitCareTaiseiUmu")
    public RadioButton getRadJunUnitCareTaiseiUmu() {
        return radJunUnitCareTaiseiUmu;
    }

    /*
     * setradJunUnitCareTaiseiUmu
     * @param radJunUnitCareTaiseiUmu radJunUnitCareTaiseiUmu
     */
    @JsonProperty("radJunUnitCareTaiseiUmu")
    public void setRadJunUnitCareTaiseiUmu(RadioButton radJunUnitCareTaiseiUmu) {
        this.radJunUnitCareTaiseiUmu = radJunUnitCareTaiseiUmu;
    }

    /*
     * getradJudokaTaioTaiseiUmu
     * @return radJudokaTaioTaiseiUmu
     */
    @JsonProperty("radJudokaTaioTaiseiUmu")
    public RadioButton getRadJudokaTaioTaiseiUmu() {
        return radJudokaTaioTaiseiUmu;
    }

    /*
     * setradJudokaTaioTaiseiUmu
     * @param radJudokaTaioTaiseiUmu radJudokaTaioTaiseiUmu
     */
    @JsonProperty("radJudokaTaioTaiseiUmu")
    public void setRadJudokaTaioTaiseiUmu(RadioButton radJudokaTaioTaiseiUmu) {
        this.radJudokaTaioTaiseiUmu = radJudokaTaioTaiseiUmu;
    }

    /*
     * getradIryoRenkeiTaiseiUmu
     * @return radIryoRenkeiTaiseiUmu
     */
    @JsonProperty("radIryoRenkeiTaiseiUmu")
    public RadioButton getRadIryoRenkeiTaiseiUmu() {
        return radIryoRenkeiTaiseiUmu;
    }

    /*
     * setradIryoRenkeiTaiseiUmu
     * @param radIryoRenkeiTaiseiUmu radIryoRenkeiTaiseiUmu
     */
    @JsonProperty("radIryoRenkeiTaiseiUmu")
    public void setRadIryoRenkeiTaiseiUmu(RadioButton radIryoRenkeiTaiseiUmu) {
        this.radIryoRenkeiTaiseiUmu = radIryoRenkeiTaiseiUmu;
    }

    /*
     * getradUnitCareTaiseiUmu
     * @return radUnitCareTaiseiUmu
     */
    @JsonProperty("radUnitCareTaiseiUmu")
    public RadioButton getRadUnitCareTaiseiUmu() {
        return radUnitCareTaiseiUmu;
    }

    /*
     * setradUnitCareTaiseiUmu
     * @param radUnitCareTaiseiUmu radUnitCareTaiseiUmu
     */
    @JsonProperty("radUnitCareTaiseiUmu")
    public void setRadUnitCareTaiseiUmu(RadioButton radUnitCareTaiseiUmu) {
        this.radUnitCareTaiseiUmu = radUnitCareTaiseiUmu;
    }

    /*
     * getradZaitakuNyushoSogoRiyoTaiseiUmu
     * @return radZaitakuNyushoSogoRiyoTaiseiUmu
     */
    @JsonProperty("radZaitakuNyushoSogoRiyoTaiseiUmu")
    public RadioButton getRadZaitakuNyushoSogoRiyoTaiseiUmu() {
        return radZaitakuNyushoSogoRiyoTaiseiUmu;
    }

    /*
     * setradZaitakuNyushoSogoRiyoTaiseiUmu
     * @param radZaitakuNyushoSogoRiyoTaiseiUmu radZaitakuNyushoSogoRiyoTaiseiUmu
     */
    @JsonProperty("radZaitakuNyushoSogoRiyoTaiseiUmu")
    public void setRadZaitakuNyushoSogoRiyoTaiseiUmu(RadioButton radZaitakuNyushoSogoRiyoTaiseiUmu) {
        this.radZaitakuNyushoSogoRiyoTaiseiUmu = radZaitakuNyushoSogoRiyoTaiseiUmu;
    }

    /*
     * getradTerminalCareTaiseiUmu
     * @return radTerminalCareTaiseiUmu
     */
    @JsonProperty("radTerminalCareTaiseiUmu")
    public RadioButton getRadTerminalCareTaiseiUmu() {
        return radTerminalCareTaiseiUmu;
    }

    /*
     * setradTerminalCareTaiseiUmu
     * @param radTerminalCareTaiseiUmu radTerminalCareTaiseiUmu
     */
    @JsonProperty("radTerminalCareTaiseiUmu")
    public void setRadTerminalCareTaiseiUmu(RadioButton radTerminalCareTaiseiUmu) {
        this.radTerminalCareTaiseiUmu = radTerminalCareTaiseiUmu;
    }

    /*
     * getradShintaiKosokuHaishiTorikumiUmu
     * @return radShintaiKosokuHaishiTorikumiUmu
     */
    @JsonProperty("radShintaiKosokuHaishiTorikumiUmu")
    public RadioButton getRadShintaiKosokuHaishiTorikumiUmu() {
        return radShintaiKosokuHaishiTorikumiUmu;
    }

    /*
     * setradShintaiKosokuHaishiTorikumiUmu
     * @param radShintaiKosokuHaishiTorikumiUmu radShintaiKosokuHaishiTorikumiUmu
     */
    @JsonProperty("radShintaiKosokuHaishiTorikumiUmu")
    public void setRadShintaiKosokuHaishiTorikumiUmu(RadioButton radShintaiKosokuHaishiTorikumiUmu) {
        this.radShintaiKosokuHaishiTorikumiUmu = radShintaiKosokuHaishiTorikumiUmu;
    }

    /*
     * getradShokiboKyotenShugoTaiseiUmu
     * @return radShokiboKyotenShugoTaiseiUmu
     */
    @JsonProperty("radShokiboKyotenShugoTaiseiUmu")
    public RadioButton getRadShokiboKyotenShugoTaiseiUmu() {
        return radShokiboKyotenShugoTaiseiUmu;
    }

    /*
     * setradShokiboKyotenShugoTaiseiUmu
     * @param radShokiboKyotenShugoTaiseiUmu radShokiboKyotenShugoTaiseiUmu
     */
    @JsonProperty("radShokiboKyotenShugoTaiseiUmu")
    public void setRadShokiboKyotenShugoTaiseiUmu(RadioButton radShokiboKyotenShugoTaiseiUmu) {
        this.radShokiboKyotenShugoTaiseiUmu = radShokiboKyotenShugoTaiseiUmu;
    }

    /*
     * getradNinchishoCareKasanUmu
     * @return radNinchishoCareKasanUmu
     */
    @JsonProperty("radNinchishoCareKasanUmu")
    public RadioButton getRadNinchishoCareKasanUmu() {
        return radNinchishoCareKasanUmu;
    }

    /*
     * setradNinchishoCareKasanUmu
     * @param radNinchishoCareKasanUmu radNinchishoCareKasanUmu
     */
    @JsonProperty("radNinchishoCareKasanUmu")
    public void setRadNinchishoCareKasanUmu(RadioButton radNinchishoCareKasanUmu) {
        this.radNinchishoCareKasanUmu = radNinchishoCareKasanUmu;
    }

    /*
     * getddlKobetsuKinoKunrenTaiseiUmu
     * @return ddlKobetsuKinoKunrenTaiseiUmu
     */
    @JsonProperty("ddlKobetsuKinoKunrenTaiseiUmu")
    public DropDownList getDdlKobetsuKinoKunrenTaiseiUmu() {
        return ddlKobetsuKinoKunrenTaiseiUmu;
    }

    /*
     * setddlKobetsuKinoKunrenTaiseiUmu
     * @param ddlKobetsuKinoKunrenTaiseiUmu ddlKobetsuKinoKunrenTaiseiUmu
     */
    @JsonProperty("ddlKobetsuKinoKunrenTaiseiUmu")
    public void setDdlKobetsuKinoKunrenTaiseiUmu(DropDownList ddlKobetsuKinoKunrenTaiseiUmu) {
        this.ddlKobetsuKinoKunrenTaiseiUmu = ddlKobetsuKinoKunrenTaiseiUmu;
    }

    /*
     * getKobetsuRihabiri2
     * @return KobetsuRihabiri2
     */
    @JsonProperty("KobetsuRihabiri2")
    public KobetsuRihabiri2Div getKobetsuRihabiri2() {
        return KobetsuRihabiri2;
    }

    /*
     * setKobetsuRihabiri2
     * @param KobetsuRihabiri2 KobetsuRihabiri2
     */
    @JsonProperty("KobetsuRihabiri2")
    public void setKobetsuRihabiri2(KobetsuRihabiri2Div KobetsuRihabiri2) {
        this.KobetsuRihabiri2 = KobetsuRihabiri2;
    }

    /*
     * getradSetsubiKijun
     * @return radSetsubiKijun
     */
    @JsonProperty("radSetsubiKijun")
    public RadioButton getRadSetsubiKijun() {
        return radSetsubiKijun;
    }

    /*
     * setradSetsubiKijun
     * @param radSetsubiKijun radSetsubiKijun
     */
    @JsonProperty("radSetsubiKijun")
    public void setRadSetsubiKijun(RadioButton radSetsubiKijun) {
        this.radSetsubiKijun = radSetsubiKijun;
    }

    /*
     * getradRyoyoTaiseiIjiTokubetsuKasan
     * @return radRyoyoTaiseiIjiTokubetsuKasan
     */
    @JsonProperty("radRyoyoTaiseiIjiTokubetsuKasan")
    public RadioButton getRadRyoyoTaiseiIjiTokubetsuKasan() {
        return radRyoyoTaiseiIjiTokubetsuKasan;
    }

    /*
     * setradRyoyoTaiseiIjiTokubetsuKasan
     * @param radRyoyoTaiseiIjiTokubetsuKasan radRyoyoTaiseiIjiTokubetsuKasan
     */
    @JsonProperty("radRyoyoTaiseiIjiTokubetsuKasan")
    public void setRadRyoyoTaiseiIjiTokubetsuKasan(RadioButton radRyoyoTaiseiIjiTokubetsuKasan) {
        this.radRyoyoTaiseiIjiTokubetsuKasan = radRyoyoTaiseiIjiTokubetsuKasan;
    }

    /*
     * getKobetsuRihabiri3
     * @return KobetsuRihabiri3
     */
    @JsonProperty("KobetsuRihabiri3")
    public KobetsuRihabiri3Div getKobetsuRihabiri3() {
        return KobetsuRihabiri3;
    }

    /*
     * setKobetsuRihabiri3
     * @param KobetsuRihabiri3 KobetsuRihabiri3
     */
    @JsonProperty("KobetsuRihabiri3")
    public void setKobetsuRihabiri3(KobetsuRihabiri3Div KobetsuRihabiri3) {
        this.KobetsuRihabiri3 = KobetsuRihabiri3;
    }

    /*
     * getradSankyuHelperTaisei
     * @return radSankyuHelperTaisei
     */
    @JsonProperty("radSankyuHelperTaisei")
    public RadioButton getRadSankyuHelperTaisei() {
        return radSankyuHelperTaisei;
    }

    /*
     * setradSankyuHelperTaisei
     * @param radSankyuHelperTaisei radSankyuHelperTaisei
     */
    @JsonProperty("radSankyuHelperTaisei")
    public void setRadSankyuHelperTaisei(RadioButton radSankyuHelperTaisei) {
        this.radSankyuHelperTaisei = radSankyuHelperTaisei;
    }

    /*
     * getChusankanChiiki
     * @return ChusankanChiiki
     */
    @JsonProperty("ChusankanChiiki")
    public ChusankanChiikiDiv getChusankanChiiki() {
        return ChusankanChiiki;
    }

    /*
     * setChusankanChiiki
     * @param ChusankanChiiki ChusankanChiiki
     */
    @JsonProperty("ChusankanChiiki")
    public void setChusankanChiiki(ChusankanChiikiDiv ChusankanChiiki) {
        this.ChusankanChiiki = ChusankanChiiki;
    }

    /*
     * getddlServiceTeikyoTaiseiKyokaKasan
     * @return ddlServiceTeikyoTaiseiKyokaKasan
     */
    @JsonProperty("ddlServiceTeikyoTaiseiKyokaKasan")
    public DropDownList getDdlServiceTeikyoTaiseiKyokaKasan() {
        return ddlServiceTeikyoTaiseiKyokaKasan;
    }

    /*
     * setddlServiceTeikyoTaiseiKyokaKasan
     * @param ddlServiceTeikyoTaiseiKyokaKasan ddlServiceTeikyoTaiseiKyokaKasan
     */
    @JsonProperty("ddlServiceTeikyoTaiseiKyokaKasan")
    public void setDdlServiceTeikyoTaiseiKyokaKasan(DropDownList ddlServiceTeikyoTaiseiKyokaKasan) {
        this.ddlServiceTeikyoTaiseiKyokaKasan = ddlServiceTeikyoTaiseiKyokaKasan;
    }

    /*
     * getradNinchishoTankiShuchuRehabilitationKasan
     * @return radNinchishoTankiShuchuRehabilitationKasan
     */
    @JsonProperty("radNinchishoTankiShuchuRehabilitationKasan")
    public RadioButton getRadNinchishoTankiShuchuRehabilitationKasan() {
        return radNinchishoTankiShuchuRehabilitationKasan;
    }

    /*
     * setradNinchishoTankiShuchuRehabilitationKasan
     * @param radNinchishoTankiShuchuRehabilitationKasan radNinchishoTankiShuchuRehabilitationKasan
     */
    @JsonProperty("radNinchishoTankiShuchuRehabilitationKasan")
    public void setRadNinchishoTankiShuchuRehabilitationKasan(RadioButton radNinchishoTankiShuchuRehabilitationKasan) {
        this.radNinchishoTankiShuchuRehabilitationKasan = radNinchishoTankiShuchuRehabilitationKasan;
    }

    /*
     * getradKakunenseiNinchishoRiyoushaUkeeireKasan
     * @return radKakunenseiNinchishoRiyoushaUkeeireKasan
     */
    @JsonProperty("radKakunenseiNinchishoRiyoushaUkeeireKasan")
    public RadioButton getRadKakunenseiNinchishoRiyoushaUkeeireKasan() {
        return radKakunenseiNinchishoRiyoushaUkeeireKasan;
    }

    /*
     * setradKakunenseiNinchishoRiyoushaUkeeireKasan
     * @param radKakunenseiNinchishoRiyoushaUkeeireKasan radKakunenseiNinchishoRiyoushaUkeeireKasan
     */
    @JsonProperty("radKakunenseiNinchishoRiyoushaUkeeireKasan")
    public void setRadKakunenseiNinchishoRiyoushaUkeeireKasan(RadioButton radKakunenseiNinchishoRiyoushaUkeeireKasan) {
        this.radKakunenseiNinchishoRiyoushaUkeeireKasan = radKakunenseiNinchishoRiyoushaUkeeireKasan;
    }

    /*
     * getradKangoTaiseiKasan
     * @return radKangoTaiseiKasan
     */
    @JsonProperty("radKangoTaiseiKasan")
    public RadioButton getRadKangoTaiseiKasan() {
        return radKangoTaiseiKasan;
    }

    /*
     * setradKangoTaiseiKasan
     * @param radKangoTaiseiKasan radKangoTaiseiKasan
     */
    @JsonProperty("radKangoTaiseiKasan")
    public void setRadKangoTaiseiKasan(RadioButton radKangoTaiseiKasan) {
        this.radKangoTaiseiKasan = radKangoTaiseiKasan;
    }

    /*
     * getradYakinShokuinHaichiKasan
     * @return radYakinShokuinHaichiKasan
     */
    @JsonProperty("radYakinShokuinHaichiKasan")
    public RadioButton getRadYakinShokuinHaichiKasan() {
        return radYakinShokuinHaichiKasan;
    }

    /*
     * setradYakinShokuinHaichiKasan
     * @param radYakinShokuinHaichiKasan radYakinShokuinHaichiKasan
     */
    @JsonProperty("radYakinShokuinHaichiKasan")
    public void setRadYakinShokuinHaichiKasan(RadioButton radYakinShokuinHaichiKasan) {
        this.radYakinShokuinHaichiKasan = radYakinShokuinHaichiKasan;
    }

    /*
     * getradRyoyoShokuKasan
     * @return radRyoyoShokuKasan
     */
    @JsonProperty("radRyoyoShokuKasan")
    public RadioButton getRadRyoyoShokuKasan() {
        return radRyoyoShokuKasan;
    }

    /*
     * setradRyoyoShokuKasan
     * @param radRyoyoShokuKasan radRyoyoShokuKasan
     */
    @JsonProperty("radRyoyoShokuKasan")
    public void setRadRyoyoShokuKasan(RadioButton radRyoyoShokuKasan) {
        this.radRyoyoShokuKasan = radRyoyoShokuKasan;
    }

    /*
     * getradNichijoSeikatsuKeizokuShienKasan
     * @return radNichijoSeikatsuKeizokuShienKasan
     */
    @JsonProperty("radNichijoSeikatsuKeizokuShienKasan")
    public RadioButton getRadNichijoSeikatsuKeizokuShienKasan() {
        return radNichijoSeikatsuKeizokuShienKasan;
    }

    /*
     * setradNichijoSeikatsuKeizokuShienKasan
     * @param radNichijoSeikatsuKeizokuShienKasan radNichijoSeikatsuKeizokuShienKasan
     */
    @JsonProperty("radNichijoSeikatsuKeizokuShienKasan")
    public void setRadNichijoSeikatsuKeizokuShienKasan(RadioButton radNichijoSeikatsuKeizokuShienKasan) {
        this.radNichijoSeikatsuKeizokuShienKasan = radNichijoSeikatsuKeizokuShienKasan;
    }

    /*
     * getradNinchishoSemmonCareKasan
     * @return radNinchishoSemmonCareKasan
     */
    @JsonProperty("radNinchishoSemmonCareKasan")
    public RadioButton getRadNinchishoSemmonCareKasan() {
        return radNinchishoSemmonCareKasan;
    }

    /*
     * setradNinchishoSemmonCareKasan
     * @param radNinchishoSemmonCareKasan radNinchishoSemmonCareKasan
     */
    @JsonProperty("radNinchishoSemmonCareKasan")
    public void setRadNinchishoSemmonCareKasan(RadioButton radNinchishoSemmonCareKasan) {
        this.radNinchishoSemmonCareKasan = radNinchishoSemmonCareKasan;
    }

    /*
     * getrad24JikanTsuhoTaioKasan
     * @return rad24JikanTsuhoTaioKasan
     */
    @JsonProperty("rad24JikanTsuhoTaioKasan")
    public RadioButton getRad24JikanTsuhoTaioKasan() {
        return rad24JikanTsuhoTaioKasan;
    }

    /*
     * setrad24JikanTsuhoTaioKasan
     * @param rad24JikanTsuhoTaioKasan rad24JikanTsuhoTaioKasan
     */
    @JsonProperty("rad24JikanTsuhoTaioKasan")
    public void setRad24JikanTsuhoTaioKasan(RadioButton rad24JikanTsuhoTaioKasan) {
        this.rad24JikanTsuhoTaioKasan = rad24JikanTsuhoTaioKasan;
    }

    /*
     * getradKangoShokuinHaichiKasan
     * @return radKangoShokuinHaichiKasan
     */
    @JsonProperty("radKangoShokuinHaichiKasan")
    public RadioButton getRadKangoShokuinHaichiKasan() {
        return radKangoShokuinHaichiKasan;
    }

    /*
     * setradKangoShokuinHaichiKasan
     * @param radKangoShokuinHaichiKasan radKangoShokuinHaichiKasan
     */
    @JsonProperty("radKangoShokuinHaichiKasan")
    public void setRadKangoShokuinHaichiKasan(RadioButton radKangoShokuinHaichiKasan) {
        this.radKangoShokuinHaichiKasan = radKangoShokuinHaichiKasan;
    }

    /*
     * getradYakanCareKasan
     * @return radYakanCareKasan
     */
    @JsonProperty("radYakanCareKasan")
    public RadioButton getRadYakanCareKasan() {
        return radYakanCareKasan;
    }

    /*
     * setradYakanCareKasan
     * @param radYakanCareKasan radYakanCareKasan
     */
    @JsonProperty("radYakanCareKasan")
    public void setRadYakanCareKasan(RadioButton radYakanCareKasan) {
        this.radYakanCareKasan = radYakanCareKasan;
    }

    /*
     * getradShudanCommunicationRyohoUmu
     * @return radShudanCommunicationRyohoUmu
     */
    @JsonProperty("radShudanCommunicationRyohoUmu")
    public RadioButton getRadShudanCommunicationRyohoUmu() {
        return radShudanCommunicationRyohoUmu;
    }

    /*
     * setradShudanCommunicationRyohoUmu
     * @param radShudanCommunicationRyohoUmu radShudanCommunicationRyohoUmu
     */
    @JsonProperty("radShudanCommunicationRyohoUmu")
    public void setRadShudanCommunicationRyohoUmu(RadioButton radShudanCommunicationRyohoUmu) {
        this.radShudanCommunicationRyohoUmu = radShudanCommunicationRyohoUmu;
    }

    /*
     * getradServiceTeikyoTaiseiKyokaKasanKaradokogata
     * @return radServiceTeikyoTaiseiKyokaKasanKaradokogata
     */
    @JsonProperty("radServiceTeikyoTaiseiKyokaKasanKaradokogata")
    public RadioButton getRadServiceTeikyoTaiseiKyokaKasanKaradokogata() {
        return radServiceTeikyoTaiseiKyokaKasanKaradokogata;
    }

    /*
     * setradServiceTeikyoTaiseiKyokaKasanKaradokogata
     * @param radServiceTeikyoTaiseiKyokaKasanKaradokogata radServiceTeikyoTaiseiKyokaKasanKaradokogata
     */
    @JsonProperty("radServiceTeikyoTaiseiKyokaKasanKaradokogata")
    public void setRadServiceTeikyoTaiseiKyokaKasanKaradokogata(RadioButton radServiceTeikyoTaiseiKyokaKasanKaradokogata) {
        this.radServiceTeikyoTaiseiKyokaKasanKaradokogata = radServiceTeikyoTaiseiKyokaKasanKaradokogata;
    }

    /*
     * getradNitchuShintaikaigoTaise20funmimanUmu
     * @return radNitchuShintaikaigoTaise20funmimanUmu
     */
    @JsonProperty("radNitchuShintaikaigoTaise20funmimanUmu")
    public RadioButton getRadNitchuShintaikaigoTaise20funmimanUmu() {
        return radNitchuShintaikaigoTaise20funmimanUmu;
    }

    /*
     * setradNitchuShintaikaigoTaise20funmimanUmu
     * @param radNitchuShintaikaigoTaise20funmimanUmu radNitchuShintaikaigoTaise20funmimanUmu
     */
    @JsonProperty("radNitchuShintaikaigoTaise20funmimanUmu")
    public void setRadNitchuShintaikaigoTaise20funmimanUmu(RadioButton radNitchuShintaikaigoTaise20funmimanUmu) {
        this.radNitchuShintaikaigoTaise20funmimanUmu = radNitchuShintaikaigoTaise20funmimanUmu;
    }

    /*
     * getradServiceTeikyoSekininshaTaiseiUmu
     * @return radServiceTeikyoSekininshaTaiseiUmu
     */
    @JsonProperty("radServiceTeikyoSekininshaTaiseiUmu")
    public RadioButton getRadServiceTeikyoSekininshaTaiseiUmu() {
        return radServiceTeikyoSekininshaTaiseiUmu;
    }

    /*
     * setradServiceTeikyoSekininshaTaiseiUmu
     * @param radServiceTeikyoSekininshaTaiseiUmu radServiceTeikyoSekininshaTaiseiUmu
     */
    @JsonProperty("radServiceTeikyoSekininshaTaiseiUmu")
    public void setRadServiceTeikyoSekininshaTaiseiUmu(RadioButton radServiceTeikyoSekininshaTaiseiUmu) {
        this.radServiceTeikyoSekininshaTaiseiUmu = radServiceTeikyoSekininshaTaiseiUmu;
    }

    /*
     * getradDoitsuTatemonoKyojuRiyoshaGenzanUmu
     * @return radDoitsuTatemonoKyojuRiyoshaGenzanUmu
     */
    @JsonProperty("radDoitsuTatemonoKyojuRiyoshaGenzanUmu")
    public RadioButton getRadDoitsuTatemonoKyojuRiyoshaGenzanUmu() {
        return radDoitsuTatemonoKyojuRiyoshaGenzanUmu;
    }

    /*
     * setradDoitsuTatemonoKyojuRiyoshaGenzanUmu
     * @param radDoitsuTatemonoKyojuRiyoshaGenzanUmu radDoitsuTatemonoKyojuRiyoshaGenzanUmu
     */
    @JsonProperty("radDoitsuTatemonoKyojuRiyoshaGenzanUmu")
    public void setRadDoitsuTatemonoKyojuRiyoshaGenzanUmu(RadioButton radDoitsuTatemonoKyojuRiyoshaGenzanUmu) {
        this.radDoitsuTatemonoKyojuRiyoshaGenzanUmu = radDoitsuTatemonoKyojuRiyoshaGenzanUmu;
    }

    /*
     * getradKinkyuTankiNyushoTaiseiKakuhoKasan
     * @return radKinkyuTankiNyushoTaiseiKakuhoKasan
     */
    @JsonProperty("radKinkyuTankiNyushoTaiseiKakuhoKasan")
    public RadioButton getRadKinkyuTankiNyushoTaiseiKakuhoKasan() {
        return radKinkyuTankiNyushoTaiseiKakuhoKasan;
    }

    /*
     * setradKinkyuTankiNyushoTaiseiKakuhoKasan
     * @param radKinkyuTankiNyushoTaiseiKakuhoKasan radKinkyuTankiNyushoTaiseiKakuhoKasan
     */
    @JsonProperty("radKinkyuTankiNyushoTaiseiKakuhoKasan")
    public void setRadKinkyuTankiNyushoTaiseiKakuhoKasan(RadioButton radKinkyuTankiNyushoTaiseiKakuhoKasan) {
        this.radKinkyuTankiNyushoTaiseiKakuhoKasan = radKinkyuTankiNyushoTaiseiKakuhoKasan;
    }

    /*
     * getradZaitakuFukkiZaitakuRyoyoShienKinoKasan
     * @return radZaitakuFukkiZaitakuRyoyoShienKinoKasan
     */
    @JsonProperty("radZaitakuFukkiZaitakuRyoyoShienKinoKasan")
    public RadioButton getRadZaitakuFukkiZaitakuRyoyoShienKinoKasan() {
        return radZaitakuFukkiZaitakuRyoyoShienKinoKasan;
    }

    /*
     * setradZaitakuFukkiZaitakuRyoyoShienKinoKasan
     * @param radZaitakuFukkiZaitakuRyoyoShienKinoKasan radZaitakuFukkiZaitakuRyoyoShienKinoKasan
     */
    @JsonProperty("radZaitakuFukkiZaitakuRyoyoShienKinoKasan")
    public void setRadZaitakuFukkiZaitakuRyoyoShienKinoKasan(RadioButton radZaitakuFukkiZaitakuRyoyoShienKinoKasan) {
        this.radZaitakuFukkiZaitakuRyoyoShienKinoKasan = radZaitakuFukkiZaitakuRyoyoShienKinoKasan;
    }

    /*
     * getradSeikatuKinoKojoGroupKatsudoKasan
     * @return radSeikatuKinoKojoGroupKatsudoKasan
     */
    @JsonProperty("radSeikatuKinoKojoGroupKatsudoKasan")
    public RadioButton getRadSeikatuKinoKojoGroupKatsudoKasan() {
        return radSeikatuKinoKojoGroupKatsudoKasan;
    }

    /*
     * setradSeikatuKinoKojoGroupKatsudoKasan
     * @param radSeikatuKinoKojoGroupKatsudoKasan radSeikatuKinoKojoGroupKatsudoKasan
     */
    @JsonProperty("radSeikatuKinoKojoGroupKatsudoKasan")
    public void setRadSeikatuKinoKojoGroupKatsudoKasan(RadioButton radSeikatuKinoKojoGroupKatsudoKasan) {
        this.radSeikatuKinoKojoGroupKatsudoKasan = radSeikatuKinoKojoGroupKatsudoKasan;
    }

    /*
     * getradKaigoShokuinShoguKaizenKasan
     * @return radKaigoShokuinShoguKaizenKasan
     */
    @JsonProperty("radKaigoShokuinShoguKaizenKasan")
    public RadioButton getRadKaigoShokuinShoguKaizenKasan() {
        return radKaigoShokuinShoguKaizenKasan;
    }

    /*
     * setradKaigoShokuinShoguKaizenKasan
     * @param radKaigoShokuinShoguKaizenKasan radKaigoShokuinShoguKaizenKasan
     */
    @JsonProperty("radKaigoShokuinShoguKaizenKasan")
    public void setRadKaigoShokuinShoguKaizenKasan(RadioButton radKaigoShokuinShoguKaizenKasan) {
        this.radKaigoShokuinShoguKaizenKasan = radKaigoShokuinShoguKaizenKasan;
    }

    /*
     * getbtnInputKihon
     * @return btnInputKihon
     */
    @JsonProperty("btnInputKihon")
    public Button getBtnInputKihon() {
        return btnInputKihon;
    }

    /*
     * setbtnInputKihon
     * @param btnInputKihon btnInputKihon
     */
    @JsonProperty("btnInputKihon")
    public void setBtnInputKihon(Button btnInputKihon) {
        this.btnInputKihon = btnInputKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSogoRehaShisetsuUmu() {
        return this.getRihabiri().getRadSogoRehaShisetsuUmu();
    }

    @JsonIgnore
    public void  setRadSogoRehaShisetsuUmu(RadioButton radSogoRehaShisetsuUmu) {
        this.getRihabiri().setRadSogoRehaShisetsuUmu(radSogoRehaShisetsuUmu);
    }

    @JsonIgnore
    public RadioButton getRadRigakuRyohoIIUmu() {
        return this.getRihabiri().getRadRigakuRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadRigakuRyohoIIUmu(RadioButton radRigakuRyohoIIUmu) {
        this.getRihabiri().setRadRigakuRyohoIIUmu(radRigakuRyohoIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadRigakuRyohoIIIUmu() {
        return this.getRihabiri().getRadRigakuRyohoIIIUmu();
    }

    @JsonIgnore
    public void  setRadRigakuRyohoIIIUmu(RadioButton radRigakuRyohoIIIUmu) {
        this.getRihabiri().setRadRigakuRyohoIIIUmu(radRigakuRyohoIIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadSagyoRyohoIIUmu() {
        return this.getRihabiri().getRadSagyoRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadSagyoRyohoIIUmu(RadioButton radSagyoRyohoIIUmu) {
        this.getRihabiri().setRadSagyoRyohoIIUmu(radSagyoRyohoIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadSeisinkaSagyouRyohoUmu() {
        return this.getRihabiri().getRadSeisinkaSagyouRyohoUmu();
    }

    @JsonIgnore
    public void  setRadSeisinkaSagyouRyohoUmu(RadioButton radSeisinkaSagyouRyohoUmu) {
        this.getRihabiri().setRadSeisinkaSagyouRyohoUmu(radSeisinkaSagyouRyohoUmu);
    }

    @JsonIgnore
    public RadioButton getRadSonotaUmu() {
        return this.getRihabiri().getRadSonotaUmu();
    }

    @JsonIgnore
    public void  setRadSonotaUmu(RadioButton radSonotaUmu) {
        this.getRihabiri().setRadSonotaUmu(radSonotaUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSogoRehaShisetsuUmu() {
        return this.getKobetsuRihabiri1().getRadKobetsuSogoRehaShisetsuUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSogoRehaShisetsuUmu(RadioButton radKobetsuSogoRehaShisetsuUmu) {
        this.getKobetsuRihabiri1().setRadKobetsuSogoRehaShisetsuUmu(radKobetsuSogoRehaShisetsuUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRigakuRyohoIIUmu1() {
        return this.getKobetsuRihabiri1().getRadKobetsuRigakuRyohoIIUmu1();
    }

    @JsonIgnore
    public void  setRadKobetsuRigakuRyohoIIUmu1(RadioButton radKobetsuRigakuRyohoIIUmu1) {
        this.getKobetsuRihabiri1().setRadKobetsuRigakuRyohoIIUmu1(radKobetsuRigakuRyohoIIUmu1);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRigakuRyohoIIIUmu() {
        return this.getKobetsuRihabiri1().getRadKobetsuRigakuRyohoIIIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuRigakuRyohoIIIUmu(RadioButton radKobetsuRigakuRyohoIIIUmu) {
        this.getKobetsuRihabiri1().setRadKobetsuRigakuRyohoIIIUmu(radKobetsuRigakuRyohoIIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSagyoRyohoIIUmu() {
        return this.getKobetsuRihabiri1().getRadKobetsuSagyoRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSagyoRyohoIIUmu(RadioButton radKobetsuSagyoRyohoIIUmu) {
        this.getKobetsuRihabiri1().setRadKobetsuSagyoRyohoIIUmu(radKobetsuSagyoRyohoIIUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuGengoChokakuRyohoIUmu() {
        return this.getKobetsuRihabiri1().getRadKobetsuGengoChokakuRyohoIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuGengoChokakuRyohoIUmu(RadioButton radKobetsuGengoChokakuRyohoIUmu) {
        this.getKobetsuRihabiri1().setRadKobetsuGengoChokakuRyohoIUmu(radKobetsuGengoChokakuRyohoIUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuGengoChokakuRyohoIIUmu() {
        return this.getKobetsuRihabiri1().getRadKobetsuGengoChokakuRyohoIIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuGengoChokakuRyohoIIUmu(RadioButton radKobetsuGengoChokakuRyohoIIUmu) {
        this.getKobetsuRihabiri1().setRadKobetsuGengoChokakuRyohoIIUmu(radKobetsuGengoChokakuRyohoIIUmu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoShienSemmoninSenjuJokinshaNinsu() {
        return this.getKaigoShienSenmonin().getTxtKaigoShienSemmoninSenjuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoShienSemmoninSenjuJokinshaNinsu(TextBoxNum txtKaigoShienSemmoninSenjuJokinshaNinsu) {
        this.getKaigoShienSenmonin().setTxtKaigoShienSemmoninSenjuJokinshaNinsu(txtKaigoShienSemmoninSenjuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSienSemmoninSenjuHijokinshaNinsu() {
        return this.getKaigoShienSenmonin().getTxtKaigoSienSemmoninSenjuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoSienSemmoninSenjuHijokinshaNinsu(TextBoxNum txtKaigoSienSemmoninSenjuHijokinshaNinsu) {
        this.getKaigoShienSenmonin().setTxtKaigoSienSemmoninSenjuHijokinshaNinsu(txtKaigoSienSemmoninSenjuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSienSemmoninKemmuJokinshaNinsu() {
        return this.getKaigoShienSenmonin().getTxtKaigoSienSemmoninKemmuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoSienSemmoninKemmuJokinshaNinsu(TextBoxNum txtKaigoSienSemmoninKemmuJokinshaNinsu) {
        this.getKaigoShienSenmonin().setTxtKaigoSienSemmoninKemmuJokinshaNinsu(txtKaigoSienSemmoninKemmuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSienSemmoninKemmuHijokinshaNinsu() {
        return this.getKaigoShienSenmonin().getTxtKaigoSienSemmoninKemmuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtKaigoSienSemmoninKemmuHijokinshaNinsu(TextBoxNum txtKaigoSienSemmoninKemmuHijokinshaNinsu) {
        this.getKaigoShienSenmonin().setTxtKaigoSienSemmoninKemmuHijokinshaNinsu(txtKaigoSienSemmoninKemmuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoSenjuJokinshaNinsu() {
        return this.getHomonKaigoIn().getTxtHomonkaigoSenjuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoSenjuJokinshaNinsu(TextBoxNum txtHomonkaigoSenjuJokinshaNinsu) {
        this.getHomonKaigoIn().setTxtHomonkaigoSenjuJokinshaNinsu(txtHomonkaigoSenjuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoSenjuHijokinshaNinsu() {
        return this.getHomonKaigoIn().getTxtHomonkaigoSenjuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoSenjuHijokinshaNinsu(TextBoxNum txtHomonkaigoSenjuHijokinshaNinsu) {
        this.getHomonKaigoIn().setTxtHomonkaigoSenjuHijokinshaNinsu(txtHomonkaigoSenjuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoKemmuJokinshaNinsu() {
        return this.getHomonKaigoIn().getTxtHomonkaigoKemmuJokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoKemmuJokinshaNinsu(TextBoxNum txtHomonkaigoKemmuJokinshaNinsu) {
        this.getHomonKaigoIn().setTxtHomonkaigoKemmuJokinshaNinsu(txtHomonkaigoKemmuJokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoKemmuHijokinshaNinsu() {
        return this.getHomonKaigoIn().getTxtHomonkaigoKemmuHijokinshaNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoKemmuHijokinshaNinsu(TextBoxNum txtHomonkaigoKemmuHijokinshaNinsu) {
        this.getHomonKaigoIn().setTxtHomonkaigoKemmuHijokinshaNinsu(txtHomonkaigoKemmuHijokinshaNinsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHomonkaigoJokinKanzangoNinsu() {
        return this.getHomonKaigoIn().getTxtHomonkaigoJokinKanzangoNinsu();
    }

    @JsonIgnore
    public void  setTxtHomonkaigoJokinKanzangoNinsu(TextBoxNum txtHomonkaigoJokinKanzangoNinsu) {
        this.getHomonKaigoIn().setTxtHomonkaigoJokinKanzangoNinsu(txtHomonkaigoJokinKanzangoNinsu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRigakuRyohoIUmu() {
        return this.getKobetsuRihabiri2().getRadKobetsuRigakuRyohoIUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuRigakuRyohoIUmu(RadioButton radKobetsuRigakuRyohoIUmu) {
        this.getKobetsuRihabiri2().setRadKobetsuRigakuRyohoIUmu(radKobetsuRigakuRyohoIUmu);
    }

    @JsonIgnore
    public RadioButton getRadRigakuRyohoIIUmu2() {
        return this.getKobetsuRihabiri2().getRadRigakuRyohoIIUmu2();
    }

    @JsonIgnore
    public void  setRadRigakuRyohoIIUmu2(RadioButton radRigakuRyohoIIUmu2) {
        this.getKobetsuRihabiri2().setRadRigakuRyohoIIUmu2(radRigakuRyohoIIUmu2);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSagyoRyohoUmu() {
        return this.getKobetsuRihabiri2().getRadKobetsuSagyoRyohoUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSagyoRyohoUmu(RadioButton radKobetsuSagyoRyohoUmu) {
        this.getKobetsuRihabiri2().setRadKobetsuSagyoRyohoUmu(radKobetsuSagyoRyohoUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuGengoChokakuRyohoUmu() {
        return this.getKobetsuRihabiri2().getRadKobetsuGengoChokakuRyohoUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuGengoChokakuRyohoUmu(RadioButton radKobetsuGengoChokakuRyohoUmu) {
        this.getKobetsuRihabiri2().setRadKobetsuGengoChokakuRyohoUmu(radKobetsuGengoChokakuRyohoUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuSonotaUmu() {
        return this.getKobetsuRihabiri2().getRadKobetsuSonotaUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuSonotaUmu(RadioButton radKobetsuSonotaUmu) {
        this.getKobetsuRihabiri2().setRadKobetsuSonotaUmu(radKobetsuSonotaUmu);
    }

    @JsonIgnore
    public RadioButton getRadKobetsuRehaShidoKanriUmu() {
        return this.getKobetsuRihabiri3().getRadKobetsuRehaShidoKanriUmu();
    }

    @JsonIgnore
    public void  setRadKobetsuRehaShidoKanriUmu(RadioButton radKobetsuRehaShidoKanriUmu) {
        this.getKobetsuRihabiri3().setRadKobetsuRehaShidoKanriUmu(radKobetsuRehaShidoKanriUmu);
    }

    @JsonIgnore
    public RadioButton getRadChuSankanChiikiShokiboJigyoshoKasanChiiki() {
        return this.getChusankanChiiki().getRadChuSankanChiikiShokiboJigyoshoKasanChiiki();
    }

    @JsonIgnore
    public void  setRadChuSankanChiikiShokiboJigyoshoKasanChiiki(RadioButton radChuSankanChiikiShokiboJigyoshoKasanChiiki) {
        this.getChusankanChiiki().setRadChuSankanChiikiShokiboJigyoshoKasanChiiki(radChuSankanChiikiShokiboJigyoshoKasanChiiki);
    }

    @JsonIgnore
    public RadioButton getRadChuSankanChiikiShokiboJigyoshoKasanKibo() {
        return this.getChusankanChiiki().getRadChuSankanChiikiShokiboJigyoshoKasanKibo();
    }

    @JsonIgnore
    public void  setRadChuSankanChiikiShokiboJigyoshoKasanKibo(RadioButton radChuSankanChiikiShokiboJigyoshoKasanKibo) {
        this.getChusankanChiiki().setRadChuSankanChiikiShokiboJigyoshoKasanKibo(radChuSankanChiikiShokiboJigyoshoKasanKibo);
    }

    // </editor-fold>
}
