package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshashoHakkoTaishoshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshashoHakkoTaishoshaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linTaishosha")
    private HorizontalLine linTaishosha;
    @JsonProperty("btnOutputSetaiJoho")
    private Button btnOutputSetaiJoho;
    @JsonProperty("TsuchishoSakuseiKobetsu")
    private TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu;
    @JsonProperty("RiyoshaFutangakuGenmen")
    private RiyoshaFutangakuGenmenDiv RiyoshaFutangakuGenmen;
    @JsonProperty("FutanGendogakuNintei")
    private FutanGendogakuNinteiDiv FutanGendogakuNintei;
    @JsonProperty("HomonKaigoRiyoshaFutangakuGengaku")
    private HomonKaigoRiyoshaFutangakuGengakuDiv HomonKaigoRiyoshaFutangakuGengaku;
    @JsonProperty("ShafukuHojinToRiyushaFutanKeigen")
    private ShafukuHojinToRiyushaFutanKeigenDiv ShafukuHojinToRiyushaFutanKeigen;
    @JsonProperty("TokubetsuChilkiKasanGenmen")
    private TokubetsuChilkiKasanGenmenDiv TokubetsuChilkiKasanGenmen;
    @JsonProperty("ZengoRireki")
    private ZengoRirekiDiv ZengoRireki;
    @JsonProperty("ccdHakkoTaishosaInfo")
    private KaigoAtenaInfoDiv ccdHakkoTaishosaInfo;
    @JsonProperty("ccdHakkoTaishoshaShikaku")
    private KaigoShikakuKihonDiv ccdHakkoTaishoshaShikaku;
    @JsonProperty("riyoshaFutanGenmenInfoIndex")
    private RString riyoshaFutanGenmenInfoIndex;
    @JsonProperty("futanGendogakuNinteiIndex")
    private RString futanGendogakuNinteiIndex;
    @JsonProperty("homonKaigoRiyoshaFutangakuGengakuIndex")
    private RString homonKaigoRiyoshaFutangakuGengakuIndex;
    @JsonProperty("shafukuHojinToRiyushaFutanKeigenIndex")
    private RString shafukuHojinToRiyushaFutanKeigenIndex;
    @JsonProperty("tokubetsuChilkiKasanGenmenIndex")
    private RString tokubetsuChilkiKasanGenmenIndex;
    @JsonProperty("hiddenRirekiNo")
    private RString hiddenRirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinTaishosha
     * @return linTaishosha
     */
    @JsonProperty("linTaishosha")
    public HorizontalLine getLinTaishosha() {
        return linTaishosha;
    }

    /*
     * setlinTaishosha
     * @param linTaishosha linTaishosha
     */
    @JsonProperty("linTaishosha")
    public void setLinTaishosha(HorizontalLine linTaishosha) {
        this.linTaishosha = linTaishosha;
    }

    /*
     * getbtnOutputSetaiJoho
     * @return btnOutputSetaiJoho
     */
    @JsonProperty("btnOutputSetaiJoho")
    public Button getBtnOutputSetaiJoho() {
        return btnOutputSetaiJoho;
    }

    /*
     * setbtnOutputSetaiJoho
     * @param btnOutputSetaiJoho btnOutputSetaiJoho
     */
    @JsonProperty("btnOutputSetaiJoho")
    public void setBtnOutputSetaiJoho(Button btnOutputSetaiJoho) {
        this.btnOutputSetaiJoho = btnOutputSetaiJoho;
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
     * getRiyoshaFutangakuGenmen
     * @return RiyoshaFutangakuGenmen
     */
    @JsonProperty("RiyoshaFutangakuGenmen")
    public RiyoshaFutangakuGenmenDiv getRiyoshaFutangakuGenmen() {
        return RiyoshaFutangakuGenmen;
    }

    /*
     * setRiyoshaFutangakuGenmen
     * @param RiyoshaFutangakuGenmen RiyoshaFutangakuGenmen
     */
    @JsonProperty("RiyoshaFutangakuGenmen")
    public void setRiyoshaFutangakuGenmen(RiyoshaFutangakuGenmenDiv RiyoshaFutangakuGenmen) {
        this.RiyoshaFutangakuGenmen = RiyoshaFutangakuGenmen;
    }

    /*
     * getFutanGendogakuNintei
     * @return FutanGendogakuNintei
     */
    @JsonProperty("FutanGendogakuNintei")
    public FutanGendogakuNinteiDiv getFutanGendogakuNintei() {
        return FutanGendogakuNintei;
    }

    /*
     * setFutanGendogakuNintei
     * @param FutanGendogakuNintei FutanGendogakuNintei
     */
    @JsonProperty("FutanGendogakuNintei")
    public void setFutanGendogakuNintei(FutanGendogakuNinteiDiv FutanGendogakuNintei) {
        this.FutanGendogakuNintei = FutanGendogakuNintei;
    }

    /*
     * getHomonKaigoRiyoshaFutangakuGengaku
     * @return HomonKaigoRiyoshaFutangakuGengaku
     */
    @JsonProperty("HomonKaigoRiyoshaFutangakuGengaku")
    public HomonKaigoRiyoshaFutangakuGengakuDiv getHomonKaigoRiyoshaFutangakuGengaku() {
        return HomonKaigoRiyoshaFutangakuGengaku;
    }

    /*
     * setHomonKaigoRiyoshaFutangakuGengaku
     * @param HomonKaigoRiyoshaFutangakuGengaku HomonKaigoRiyoshaFutangakuGengaku
     */
    @JsonProperty("HomonKaigoRiyoshaFutangakuGengaku")
    public void setHomonKaigoRiyoshaFutangakuGengaku(HomonKaigoRiyoshaFutangakuGengakuDiv HomonKaigoRiyoshaFutangakuGengaku) {
        this.HomonKaigoRiyoshaFutangakuGengaku = HomonKaigoRiyoshaFutangakuGengaku;
    }

    /*
     * getShafukuHojinToRiyushaFutanKeigen
     * @return ShafukuHojinToRiyushaFutanKeigen
     */
    @JsonProperty("ShafukuHojinToRiyushaFutanKeigen")
    public ShafukuHojinToRiyushaFutanKeigenDiv getShafukuHojinToRiyushaFutanKeigen() {
        return ShafukuHojinToRiyushaFutanKeigen;
    }

    /*
     * setShafukuHojinToRiyushaFutanKeigen
     * @param ShafukuHojinToRiyushaFutanKeigen ShafukuHojinToRiyushaFutanKeigen
     */
    @JsonProperty("ShafukuHojinToRiyushaFutanKeigen")
    public void setShafukuHojinToRiyushaFutanKeigen(ShafukuHojinToRiyushaFutanKeigenDiv ShafukuHojinToRiyushaFutanKeigen) {
        this.ShafukuHojinToRiyushaFutanKeigen = ShafukuHojinToRiyushaFutanKeigen;
    }

    /*
     * getTokubetsuChilkiKasanGenmen
     * @return TokubetsuChilkiKasanGenmen
     */
    @JsonProperty("TokubetsuChilkiKasanGenmen")
    public TokubetsuChilkiKasanGenmenDiv getTokubetsuChilkiKasanGenmen() {
        return TokubetsuChilkiKasanGenmen;
    }

    /*
     * setTokubetsuChilkiKasanGenmen
     * @param TokubetsuChilkiKasanGenmen TokubetsuChilkiKasanGenmen
     */
    @JsonProperty("TokubetsuChilkiKasanGenmen")
    public void setTokubetsuChilkiKasanGenmen(TokubetsuChilkiKasanGenmenDiv TokubetsuChilkiKasanGenmen) {
        this.TokubetsuChilkiKasanGenmen = TokubetsuChilkiKasanGenmen;
    }

    /*
     * getZengoRireki
     * @return ZengoRireki
     */
    @JsonProperty("ZengoRireki")
    public ZengoRirekiDiv getZengoRireki() {
        return ZengoRireki;
    }

    /*
     * setZengoRireki
     * @param ZengoRireki ZengoRireki
     */
    @JsonProperty("ZengoRireki")
    public void setZengoRireki(ZengoRirekiDiv ZengoRireki) {
        this.ZengoRireki = ZengoRireki;
    }

    /*
     * getccdHakkoTaishosaInfo
     * @return ccdHakkoTaishosaInfo
     */
    @JsonProperty("ccdHakkoTaishosaInfo")
    public IKaigoAtenaInfoDiv getCcdHakkoTaishosaInfo() {
        return ccdHakkoTaishosaInfo;
    }

    /*
     * getccdHakkoTaishoshaShikaku
     * @return ccdHakkoTaishoshaShikaku
     */
    @JsonProperty("ccdHakkoTaishoshaShikaku")
    public IKaigoShikakuKihonDiv getCcdHakkoTaishoshaShikaku() {
        return ccdHakkoTaishoshaShikaku;
    }

    /*
     * getriyoshaFutanGenmenInfoIndex
     * @return riyoshaFutanGenmenInfoIndex
     */
    @JsonProperty("riyoshaFutanGenmenInfoIndex")
    public RString getRiyoshaFutanGenmenInfoIndex() {
        return riyoshaFutanGenmenInfoIndex;
    }

    /*
     * setriyoshaFutanGenmenInfoIndex
     * @param riyoshaFutanGenmenInfoIndex riyoshaFutanGenmenInfoIndex
     */
    @JsonProperty("riyoshaFutanGenmenInfoIndex")
    public void setRiyoshaFutanGenmenInfoIndex(RString riyoshaFutanGenmenInfoIndex) {
        this.riyoshaFutanGenmenInfoIndex = riyoshaFutanGenmenInfoIndex;
    }

    /*
     * getfutanGendogakuNinteiIndex
     * @return futanGendogakuNinteiIndex
     */
    @JsonProperty("futanGendogakuNinteiIndex")
    public RString getFutanGendogakuNinteiIndex() {
        return futanGendogakuNinteiIndex;
    }

    /*
     * setfutanGendogakuNinteiIndex
     * @param futanGendogakuNinteiIndex futanGendogakuNinteiIndex
     */
    @JsonProperty("futanGendogakuNinteiIndex")
    public void setFutanGendogakuNinteiIndex(RString futanGendogakuNinteiIndex) {
        this.futanGendogakuNinteiIndex = futanGendogakuNinteiIndex;
    }

    /*
     * gethomonKaigoRiyoshaFutangakuGengakuIndex
     * @return homonKaigoRiyoshaFutangakuGengakuIndex
     */
    @JsonProperty("homonKaigoRiyoshaFutangakuGengakuIndex")
    public RString getHomonKaigoRiyoshaFutangakuGengakuIndex() {
        return homonKaigoRiyoshaFutangakuGengakuIndex;
    }

    /*
     * sethomonKaigoRiyoshaFutangakuGengakuIndex
     * @param homonKaigoRiyoshaFutangakuGengakuIndex homonKaigoRiyoshaFutangakuGengakuIndex
     */
    @JsonProperty("homonKaigoRiyoshaFutangakuGengakuIndex")
    public void setHomonKaigoRiyoshaFutangakuGengakuIndex(RString homonKaigoRiyoshaFutangakuGengakuIndex) {
        this.homonKaigoRiyoshaFutangakuGengakuIndex = homonKaigoRiyoshaFutangakuGengakuIndex;
    }

    /*
     * getshafukuHojinToRiyushaFutanKeigenIndex
     * @return shafukuHojinToRiyushaFutanKeigenIndex
     */
    @JsonProperty("shafukuHojinToRiyushaFutanKeigenIndex")
    public RString getShafukuHojinToRiyushaFutanKeigenIndex() {
        return shafukuHojinToRiyushaFutanKeigenIndex;
    }

    /*
     * setshafukuHojinToRiyushaFutanKeigenIndex
     * @param shafukuHojinToRiyushaFutanKeigenIndex shafukuHojinToRiyushaFutanKeigenIndex
     */
    @JsonProperty("shafukuHojinToRiyushaFutanKeigenIndex")
    public void setShafukuHojinToRiyushaFutanKeigenIndex(RString shafukuHojinToRiyushaFutanKeigenIndex) {
        this.shafukuHojinToRiyushaFutanKeigenIndex = shafukuHojinToRiyushaFutanKeigenIndex;
    }

    /*
     * gettokubetsuChilkiKasanGenmenIndex
     * @return tokubetsuChilkiKasanGenmenIndex
     */
    @JsonProperty("tokubetsuChilkiKasanGenmenIndex")
    public RString getTokubetsuChilkiKasanGenmenIndex() {
        return tokubetsuChilkiKasanGenmenIndex;
    }

    /*
     * settokubetsuChilkiKasanGenmenIndex
     * @param tokubetsuChilkiKasanGenmenIndex tokubetsuChilkiKasanGenmenIndex
     */
    @JsonProperty("tokubetsuChilkiKasanGenmenIndex")
    public void setTokubetsuChilkiKasanGenmenIndex(RString tokubetsuChilkiKasanGenmenIndex) {
        this.tokubetsuChilkiKasanGenmenIndex = tokubetsuChilkiKasanGenmenIndex;
    }

    /*
     * gethiddenRirekiNo
     * @return hiddenRirekiNo
     */
    @JsonProperty("hiddenRirekiNo")
    public RString getHiddenRirekiNo() {
        return hiddenRirekiNo;
    }

    /*
     * sethiddenRirekiNo
     * @param hiddenRirekiNo hiddenRirekiNo
     */
    @JsonProperty("hiddenRirekiNo")
    public void setHiddenRirekiNo(RString hiddenRirekiNo) {
        this.hiddenRirekiNo = hiddenRirekiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtRiyoshaFutanGendogakuKetteiKubun() {
        return this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuKetteiKubun(TextBox txtRiyoshaFutanGendogakuKetteiKubun) {
        this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuKetteiKubun(txtRiyoshaFutanGendogakuKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshaFutanGendogakuKyufuRitsu() {
        return this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuKyufuRitsu(TextBox txtRiyoshaFutanGendogakuKyufuRitsu) {
        this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuKyufuRitsu(txtRiyoshaFutanGendogakuKyufuRitsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuShinseibi() {
        return this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuShinseibi();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuShinseibi(TextBoxFlexibleDate txtRiyoshaFutanGendogakuShinseibi) {
        this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuShinseibi(txtRiyoshaFutanGendogakuShinseibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuKetteibi() {
        return this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuKetteibi();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuKetteibi(TextBoxFlexibleDate txtRiyoshaFutanGendogakuKetteibi) {
        this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuKetteibi(txtRiyoshaFutanGendogakuKetteibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuTekiyobi() {
        return this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuTekiyobi();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuTekiyobi(TextBoxFlexibleDate txtRiyoshaFutanGendogakuTekiyobi) {
        this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuTekiyobi(txtRiyoshaFutanGendogakuTekiyobi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtRiyoshaFutanGendogakuYukoKigen() {
        return this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuYukoKigen();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuYukoKigen(TextBoxFlexibleDate txtRiyoshaFutanGendogakuYukoKigen) {
        this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuYukoKigen(txtRiyoshaFutanGendogakuYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRiyoshaFutanGendogakuShoninShinaiRiyu() {
        return this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().getTxtRiyoshaFutanGendogakuShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanGendogakuShoninShinaiRiyu(TextBoxMultiLine txtRiyoshaFutanGendogakuShoninShinaiRiyu) {
        this.getRiyoshaFutangakuGenmen().getRiyoshaFutanGenmenInfo().setTxtRiyoshaFutanGendogakuShoninShinaiRiyu(txtRiyoshaFutanGendogakuShoninShinaiRiyu);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiKetteiKubun() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiKetteiKubun(TextBox txtFutanGendogakuNinteiKetteiKubun) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiKetteiKubun(txtFutanGendogakuNinteiKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiShinseiRiyu() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShinseiRiyu(TextBox txtFutanGendogakuNinteiShinseiRiyu) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShinseiRiyu(txtFutanGendogakuNinteiShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteiShinseibi() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShinseibi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShinseibi(TextBoxFlexibleDate txtFutanGendogakuNinteiShinseibi) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShinseibi(txtFutanGendogakuNinteiShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiFutanDankai() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiFutanDankai();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiFutanDankai(TextBox txtFutanGendogakuNinteiFutanDankai) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiFutanDankai(txtFutanGendogakuNinteiFutanDankai);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiKyuSochi() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiKyuSochi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiKyuSochi(TextBox txtFutanGendogakuNinteiKyuSochi) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiKyuSochi(txtFutanGendogakuNinteiKyuSochi);
    }

    @JsonIgnore
    public TextBox getTxtFutanGendogakuNinteiKyokaiso() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiKyokaiso();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiKyokaiso(TextBox txtFutanGendogakuNinteiKyokaiso) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiKyokaiso(txtFutanGendogakuNinteiKyokaiso);
    }

    @JsonIgnore
    public TextBox getFutanGendogakuNinteiGekihenKanwa() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getFutanGendogakuNinteiGekihenKanwa();
    }

    @JsonIgnore
    public void  setFutanGendogakuNinteiGekihenKanwa(TextBox FutanGendogakuNinteiGekihenKanwa) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setFutanGendogakuNinteiGekihenKanwa(FutanGendogakuNinteiGekihenKanwa);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getFutanGendogakuNinteiKetteibi() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getFutanGendogakuNinteiKetteibi();
    }

    @JsonIgnore
    public void  setFutanGendogakuNinteiKetteibi(TextBoxFlexibleDate FutanGendogakuNinteiKetteibi) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setFutanGendogakuNinteiKetteibi(FutanGendogakuNinteiKetteibi);
    }

    @JsonIgnore
    public Label getLblFutanGendogakuNinteiFutanGendogaku() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getLblFutanGendogakuNinteiFutanGendogaku();
    }

    @JsonIgnore
    public void  setLblFutanGendogakuNinteiFutanGendogaku(Label lblFutanGendogakuNinteiFutanGendogaku) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setLblFutanGendogakuNinteiFutanGendogaku(lblFutanGendogakuNinteiFutanGendogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiShokuhi() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShokuhi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShokuhi(TextBoxNum txtFutanGendogakuNinteiShokuhi) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShokuhi(txtFutanGendogakuNinteiShokuhi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteiTekiyobi() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiTekiyobi();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiTekiyobi(TextBoxFlexibleDate txtFutanGendogakuNinteiTekiyobi) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiTekiyobi(txtFutanGendogakuNinteiTekiyobi);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiUnitGataKoshitsu() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiUnitGataKoshitsu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiUnitGataKoshitsu(TextBoxNum txtFutanGendogakuNinteiUnitGataKoshitsu) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiUnitGataKoshitsu(txtFutanGendogakuNinteiUnitGataKoshitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiUnitGataJunkoshitsu() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiUnitGataJunkoshitsu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiUnitGataJunkoshitsu(TextBoxNum txtFutanGendogakuNinteiUnitGataJunkoshitsu) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiUnitGataJunkoshitsu(txtFutanGendogakuNinteiUnitGataJunkoshitsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtFutanGendogakuNinteiYukoKigen() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiYukoKigen();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiYukoKigen(TextBoxFlexibleDate txtFutanGendogakuNinteiYukoKigen) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiYukoKigen(txtFutanGendogakuNinteiYukoKigen);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo(TextBoxNum txtFutanGendogakuNinteiJuraigataKoshitsuTokuyo) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiJuraigataKoshitsuTokuyo(txtFutanGendogakuNinteiJuraigataKoshitsuTokuyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiJuraigataKoshitsuRoken() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiJuraigataKoshitsuRoken();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiJuraigataKoshitsuRoken(TextBoxNum txtFutanGendogakuNinteiJuraigataKoshitsuRoken) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiJuraigataKoshitsuRoken(txtFutanGendogakuNinteiJuraigataKoshitsuRoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutanGendogakuNinteiTashoshitsu() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiTashoshitsu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiTashoshitsu(TextBoxNum txtFutanGendogakuNinteiTashoshitsu) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiTashoshitsu(txtFutanGendogakuNinteiTashoshitsu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFutanGendogakuNinteiShoninShinsaiRiyu() {
        return this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().getTxtFutanGendogakuNinteiShoninShinsaiRiyu();
    }

    @JsonIgnore
    public void  setTxtFutanGendogakuNinteiShoninShinsaiRiyu(TextBoxMultiLine txtFutanGendogakuNinteiShoninShinsaiRiyu) {
        this.getFutanGendogakuNintei().getFutanGendogakuNinteiInfo().setTxtFutanGendogakuNinteiShoninShinsaiRiyu(txtFutanGendogakuNinteiShoninShinsaiRiyu);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun(TextBox txtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun(txtHomonKaigoRiyoshaFutangakuGengakuKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun(TextBox txtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun(txtHomonKaigoRiyoshaFutangakuGengakuHobetsuKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuShinseibi) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuShinseibi(txtHomonKaigoRiyoshaFutangakuGengakuShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu(TextBox txtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu(txtHomonKaigoRiyoshaFutangakuGengakuKyufuritsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuKetteibi) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKetteibi(txtHomonKaigoRiyoshaFutangakuGengakuKetteibi);
    }

    @JsonIgnore
    public TextBoxCode getTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo(TextBoxCode txtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo(txtHomonKaigoRiyoshaFutangakuGengakuKohiJukyushaNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuTekiyobi) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuTekiyobi(txtHomonKaigoRiyoshaFutangakuGengakuTekiyobi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen(TextBoxFlexibleDate txtHomonKaigoRiyoshaFutangakuGengakuYukoKigen) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuYukoKigen(txtHomonKaigoRiyoshaFutangakuGengakuYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu() {
        return this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().getTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu(TextBoxMultiLine txtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu) {
        this.getHomonKaigoRiyoshaFutangakuGengaku().getHomonKaigoRiyoshaFutangakuGengakuInfo().setTxtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu(txtHomonKaigoRiyoshaFutangakuGengakuShoninShinaiRiyu);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun(TextBox txtShafukuHojinToRiyushaFutanKeigenKetteiKubun) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKetteiKubun(txtShafukuHojinToRiyushaFutanKeigenKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu(TextBox txtShafukuHojinToRiyushaFutanKeigenKeigenJiyu) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKeigenJiyu(txtShafukuHojinToRiyushaFutanKeigenKeigenJiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenShinseibi() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenShinseibi();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenShinseibi(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenShinseibi) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenShinseibi(txtShafukuHojinToRiyushaFutanKeigenShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu(TextBox txtShafukuHojinToRiyushaFutanKeigenKeigenritsu) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKeigenritsu(txtShafukuHojinToRiyushaFutanKeigenKeigenritsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtShafukuHojinToRiyushaFutanKeigenKakuninNo() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKakuninNo();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKakuninNo(TextBoxCode txtShafukuHojinToRiyushaFutanKeigenKakuninNo) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKakuninNo(txtShafukuHojinToRiyushaFutanKeigenKakuninNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenKetteibi() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKetteibi();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKetteibi(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenKetteibi) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKetteibi(txtShafukuHojinToRiyushaFutanKeigenKetteibi);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei(TextBox txtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei(txtShafukuHojinToRiyushaFutanKeigenKyotakuServiceGentei);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei(TextBox txtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei(txtShafukuHojinToRiyushaFutanKeigenKyojuhiShokuhiGentei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenTekiyobi() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenTekiyobi();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenTekiyobi(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenTekiyobi) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenTekiyobi(txtShafukuHojinToRiyushaFutanKeigenTekiyobi);
    }

    @JsonIgnore
    public TextBox getTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei(TextBox txtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei(txtShafukuHojinToRiyushaFutanKeigenKyuSothishaUnitgataKoshitsuGentei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShafukuHojinToRiyushaFutanKeigenYukoKigen() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenYukoKigen();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenYukoKigen(TextBoxFlexibleDate txtShafukuHojinToRiyushaFutanKeigenYukoKigen) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenYukoKigen(txtShafukuHojinToRiyushaFutanKeigenYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu() {
        return this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().getTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu(TextBoxMultiLine txtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu) {
        this.getShafukuHojinToRiyushaFutanKeigen().getShafukuHojinToRiyushaFutanKeigenInfo().setTxtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu(txtShafukuHojinToRiyushaFutanKeigenShoninShinaiRiyu);
    }

    @JsonIgnore
    public TextBox getTxtTokubetsuChilkiKasanGenmenKetteiKubun() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKetteiKubun();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKetteiKubun(TextBox txtTokubetsuChilkiKasanGenmenKetteiKubun) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKetteiKubun(txtTokubetsuChilkiKasanGenmenKetteiKubun);
    }

    @JsonIgnore
    public TextBox getTxtTokubetsuChilkiKasanGenmenKeigenritsu() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKeigenritsu();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKeigenritsu(TextBox txtTokubetsuChilkiKasanGenmenKeigenritsu) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKeigenritsu(txtTokubetsuChilkiKasanGenmenKeigenritsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtTokubetsuChilkiKasanGenmenKakuninNo() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKakuninNo();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKakuninNo(TextBoxCode txtTokubetsuChilkiKasanGenmenKakuninNo) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKakuninNo(txtTokubetsuChilkiKasanGenmenKakuninNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenShinseibi() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenShinseibi();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenShinseibi(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenShinseibi) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenShinseibi(txtTokubetsuChilkiKasanGenmenShinseibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenKetteibi() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenKetteibi();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenKetteibi(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenKetteibi) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenKetteibi(txtTokubetsuChilkiKasanGenmenKetteibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenTekiyobi() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenTekiyobi();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenTekiyobi(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenTekiyobi) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenTekiyobi(txtTokubetsuChilkiKasanGenmenTekiyobi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTokubetsuChilkiKasanGenmenYukoKigen() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenYukoKigen();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenYukoKigen(TextBoxFlexibleDate txtTokubetsuChilkiKasanGenmenYukoKigen) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenYukoKigen(txtTokubetsuChilkiKasanGenmenYukoKigen);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu() {
        return this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().getTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu();
    }

    @JsonIgnore
    public void  setTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu(TextBoxMultiLine txtTokubetsuChilkiKasanGenmenShoninShinaiRiyu) {
        this.getTokubetsuChilkiKasanGenmen().getTokubetsuChilkiKasanGenmenInfo().setTxtTokubetsuChilkiKasanGenmenShoninShinaiRiyu(txtTokubetsuChilkiKasanGenmenShoninShinaiRiyu);
    }

    @JsonIgnore
    public Button getBtnOutputMaeRireki() {
        return this.getZengoRireki().getBtnOutputMaeRireki();
    }

    @JsonIgnore
    public void  setBtnOutputMaeRireki(Button btnOutputMaeRireki) {
        this.getZengoRireki().setBtnOutputMaeRireki(btnOutputMaeRireki);
    }

    @JsonIgnore
    public Button getBtnOutputAtoRireki() {
        return this.getZengoRireki().getBtnOutputAtoRireki();
    }

    @JsonIgnore
    public void  setBtnOutputAtoRireki(Button btnOutputAtoRireki) {
        this.getZengoRireki().setBtnOutputAtoRireki(btnOutputAtoRireki);
    }

    // </editor-fold>
}
