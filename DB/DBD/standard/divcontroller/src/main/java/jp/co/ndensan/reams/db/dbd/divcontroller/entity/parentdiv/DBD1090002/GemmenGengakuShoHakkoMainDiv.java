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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenGengakuShoHakkoMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenGengakuShoHakkoMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshashoHakkoTaishoshaJoho")
    private HihokenshashoHakkoTaishoshaJohoDiv HihokenshashoHakkoTaishoshaJoho;
    @JsonProperty("HakkoChohyoSentaku")
    private HakkoChohyoSentakuDiv HakkoChohyoSentaku;
    @JsonProperty("SetaiShotokuShokai")
    private SetaiShotokuShokaiDiv SetaiShotokuShokai;
    @JsonProperty("ccdHakkoTaishosaInfo")
    private KaigoAtenaInfoDiv ccdHakkoTaishosaInfo;
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
     * getHihokenshashoHakkoTaishoshaJoho
     * @return HihokenshashoHakkoTaishoshaJoho
     */
    @JsonProperty("HihokenshashoHakkoTaishoshaJoho")
    public HihokenshashoHakkoTaishoshaJohoDiv getHihokenshashoHakkoTaishoshaJoho() {
        return HihokenshashoHakkoTaishoshaJoho;
    }

    /*
     * setHihokenshashoHakkoTaishoshaJoho
     * @param HihokenshashoHakkoTaishoshaJoho HihokenshashoHakkoTaishoshaJoho
     */
    @JsonProperty("HihokenshashoHakkoTaishoshaJoho")
    public void setHihokenshashoHakkoTaishoshaJoho(HihokenshashoHakkoTaishoshaJohoDiv HihokenshashoHakkoTaishoshaJoho) {
        this.HihokenshashoHakkoTaishoshaJoho = HihokenshashoHakkoTaishoshaJoho;
    }

    /*
     * getHakkoChohyoSentaku
     * @return HakkoChohyoSentaku
     */
    @JsonProperty("HakkoChohyoSentaku")
    public HakkoChohyoSentakuDiv getHakkoChohyoSentaku() {
        return HakkoChohyoSentaku;
    }

    /*
     * setHakkoChohyoSentaku
     * @param HakkoChohyoSentaku HakkoChohyoSentaku
     */
    @JsonProperty("HakkoChohyoSentaku")
    public void setHakkoChohyoSentaku(HakkoChohyoSentakuDiv HakkoChohyoSentaku) {
        this.HakkoChohyoSentaku = HakkoChohyoSentaku;
    }

    /*
     * getSetaiShotokuShokai
     * @return SetaiShotokuShokai
     */
    @JsonProperty("SetaiShotokuShokai")
    public SetaiShotokuShokaiDiv getSetaiShotokuShokai() {
        return SetaiShotokuShokai;
    }

    /*
     * setSetaiShotokuShokai
     * @param SetaiShotokuShokai SetaiShotokuShokai
     */
    @JsonProperty("SetaiShotokuShokai")
    public void setSetaiShotokuShokai(SetaiShotokuShokaiDiv SetaiShotokuShokai) {
        this.SetaiShotokuShokai = SetaiShotokuShokai;
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
    public Button getBtnOutputSetaiJoho() {
        return this.getHakkoChohyoSentaku().getBtnOutputSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnOutputSetaiJoho(Button btnOutputSetaiJoho) {
        this.getHakkoChohyoSentaku().setBtnOutputSetaiJoho(btnOutputSetaiJoho);
    }

    @JsonIgnore
    public TsuchishoSakuseiKobetsuDiv getTsuchishoSakuseiKobetsu() {
        return this.getHakkoChohyoSentaku().getTsuchishoSakuseiKobetsu();
    }

    @JsonIgnore
    public void  setTsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu) {
        this.getHakkoChohyoSentaku().setTsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsu);
    }

    @JsonIgnore
    public GemmenRirekiDiv getGemmenRireki() {
        return this.getHakkoChohyoSentaku().getGemmenRireki();
    }

    @JsonIgnore
    public void  setGemmenRireki(GemmenRirekiDiv GemmenRireki) {
        this.getHakkoChohyoSentaku().setGemmenRireki(GemmenRireki);
    }

    @JsonIgnore
    public RiyoshaFutangakuGenmenDiv getRiyoshaFutangakuGenmen() {
        return this.getHakkoChohyoSentaku().getGemmenRireki().getRiyoshaFutangakuGenmen();
    }

    @JsonIgnore
    public void  setRiyoshaFutangakuGenmen(RiyoshaFutangakuGenmenDiv RiyoshaFutangakuGenmen) {
        this.getHakkoChohyoSentaku().getGemmenRireki().setRiyoshaFutangakuGenmen(RiyoshaFutangakuGenmen);
    }

    @JsonIgnore
    public FutanGendogakuNinteiDiv getFutanGendogakuNintei() {
        return this.getHakkoChohyoSentaku().getGemmenRireki().getFutanGendogakuNintei();
    }

    @JsonIgnore
    public void  setFutanGendogakuNintei(FutanGendogakuNinteiDiv FutanGendogakuNintei) {
        this.getHakkoChohyoSentaku().getGemmenRireki().setFutanGendogakuNintei(FutanGendogakuNintei);
    }

    @JsonIgnore
    public HomonKaigoRiyoshaFutangakuGengakuDiv getHomonKaigoRiyoshaFutangakuGengaku() {
        return this.getHakkoChohyoSentaku().getGemmenRireki().getHomonKaigoRiyoshaFutangakuGengaku();
    }

    @JsonIgnore
    public void  setHomonKaigoRiyoshaFutangakuGengaku(HomonKaigoRiyoshaFutangakuGengakuDiv HomonKaigoRiyoshaFutangakuGengaku) {
        this.getHakkoChohyoSentaku().getGemmenRireki().setHomonKaigoRiyoshaFutangakuGengaku(HomonKaigoRiyoshaFutangakuGengaku);
    }

    @JsonIgnore
    public ShafukuHojinToRiyushaFutanKeigenDiv getShafukuHojinToRiyushaFutanKeigen() {
        return this.getHakkoChohyoSentaku().getGemmenRireki().getShafukuHojinToRiyushaFutanKeigen();
    }

    @JsonIgnore
    public void  setShafukuHojinToRiyushaFutanKeigen(ShafukuHojinToRiyushaFutanKeigenDiv ShafukuHojinToRiyushaFutanKeigen) {
        this.getHakkoChohyoSentaku().getGemmenRireki().setShafukuHojinToRiyushaFutanKeigen(ShafukuHojinToRiyushaFutanKeigen);
    }

    @JsonIgnore
    public TokubetsuChilkiKasanGenmenDiv getTokubetsuChilkiKasanGenmen() {
        return this.getHakkoChohyoSentaku().getGemmenRireki().getTokubetsuChilkiKasanGenmen();
    }

    @JsonIgnore
    public void  setTokubetsuChilkiKasanGenmen(TokubetsuChilkiKasanGenmenDiv TokubetsuChilkiKasanGenmen) {
        this.getHakkoChohyoSentaku().getGemmenRireki().setTokubetsuChilkiKasanGenmen(TokubetsuChilkiKasanGenmen);
    }

    @JsonIgnore
    public Button getBtnOutputAtoRireki() {
        return this.getHakkoChohyoSentaku().getGemmenRireki().getBtnOutputAtoRireki();
    }

    @JsonIgnore
    public void  setBtnOutputAtoRireki(Button btnOutputAtoRireki) {
        this.getHakkoChohyoSentaku().getGemmenRireki().setBtnOutputAtoRireki(btnOutputAtoRireki);
    }

    @JsonIgnore
    public Button getBtnOutputMaeRireki() {
        return this.getHakkoChohyoSentaku().getGemmenRireki().getBtnOutputMaeRireki();
    }

    @JsonIgnore
    public void  setBtnOutputMaeRireki(Button btnOutputMaeRireki) {
        this.getHakkoChohyoSentaku().getGemmenRireki().setBtnOutputMaeRireki(btnOutputMaeRireki);
    }

    @JsonIgnore
    public Button getBtnReturnChohyoHakko() {
        return this.getSetaiShotokuShokai().getBtnReturnChohyoHakko();
    }

    @JsonIgnore
    public void  setBtnReturnChohyoHakko(Button btnReturnChohyoHakko) {
        this.getSetaiShotokuShokai().setBtnReturnChohyoHakko(btnReturnChohyoHakko);
    }

    @JsonIgnore
    public SetaiJohoDiv getSetaiJoho() {
        return this.getSetaiShotokuShokai().getSetaiJoho();
    }

    @JsonIgnore
    public void  setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.getSetaiShotokuShokai().setSetaiJoho(SetaiJoho);
    }

    // </editor-fold>
}
