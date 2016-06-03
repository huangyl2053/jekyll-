package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuJizenShinseiToroku のクラスファイル
 *
 * @reamsid_L DBC-0990-060 panhe
 */
public class JutakuKaishuJizenShinseiTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoShikakuKihonShaPanel")
    private KaigoShikakuKihonShaPanelDiv KaigoShikakuKihonShaPanel;
    @JsonProperty("JutakuJizenKanryo")
    private JutakuJizenKanryoDiv JutakuJizenKanryo;
    @JsonProperty("hidShinseiJyohoFlg")
    private RString hidShinseiJyohoFlg;
    @JsonProperty("hidKozaJyohoFlg")
    private RString hidKozaJyohoFlg;
    @JsonProperty("hidJutakuKaisyuJyohoFlg")
    private RString hidJutakuKaisyuJyohoFlg;
    @JsonProperty("hidSeikyuSummaryFlg")
    private RString hidSeikyuSummaryFlg;
    @JsonProperty("jigyoshaCode")
    private RString jigyoshaCode;
    @JsonProperty("jigyoshaMeisho")
    private RString jigyoshaMeisho;
    @JsonProperty("jigyoshaCodeMeisho")
    private RString jigyoshaCodeMeisho;
    @JsonProperty("hidSandannkaiMsgFlg")
    private RString hidSandannkaiMsgFlg;
    @JsonProperty("hidLimitMsgDisplayedFlg")
    private RString hidLimitMsgDisplayedFlg;
    @JsonProperty("hidLimitMsgNotNeedFlg")
    private RString hidLimitMsgNotNeedFlg;
    @JsonProperty("hidLimitNGMsgDisplayedFlg")
    private RString hidLimitNGMsgDisplayedFlg;
    @JsonProperty("hidTxtHiyoTotalNow")
    private RString hidTxtHiyoTotalNow;
    @JsonProperty("hidTxtHokenTaishoHiyoNow")
    private RString hidTxtHokenTaishoHiyoNow;
    @JsonProperty("hidTxtHokenKyufuAmountNow")
    private RString hidTxtHokenKyufuAmountNow;
    @JsonProperty("hidTxtRiyoshaFutanAmountNow")
    private RString hidTxtRiyoshaFutanAmountNow;
    @JsonProperty("hidDataChangeFlg")
    private RString hidDataChangeFlg;
    @JsonProperty("hidInputConfirmMsgDisplayedFlg")
    private RString hidInputConfirmMsgDisplayedFlg;
    @JsonProperty("hidInputCheckMsgDisplayedFlg")
    private RString hidInputCheckMsgDisplayedFlg;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoShikakuKihonShaPanel
     * @return KaigoShikakuKihonShaPanel
     */
    @JsonProperty("KaigoShikakuKihonShaPanel")
    public KaigoShikakuKihonShaPanelDiv getKaigoShikakuKihonShaPanel() {
        return KaigoShikakuKihonShaPanel;
    }

    /*
     * setKaigoShikakuKihonShaPanel
     * @param KaigoShikakuKihonShaPanel KaigoShikakuKihonShaPanel
     */
    @JsonProperty("KaigoShikakuKihonShaPanel")
    public void setKaigoShikakuKihonShaPanel(KaigoShikakuKihonShaPanelDiv KaigoShikakuKihonShaPanel) {
        this.KaigoShikakuKihonShaPanel = KaigoShikakuKihonShaPanel;
    }

    /*
     * getJutakuJizenKanryo
     * @return JutakuJizenKanryo
     */
    @JsonProperty("JutakuJizenKanryo")
    public JutakuJizenKanryoDiv getJutakuJizenKanryo() {
        return JutakuJizenKanryo;
    }

    /*
     * setJutakuJizenKanryo
     * @param JutakuJizenKanryo JutakuJizenKanryo
     */
    @JsonProperty("JutakuJizenKanryo")
    public void setJutakuJizenKanryo(JutakuJizenKanryoDiv JutakuJizenKanryo) {
        this.JutakuJizenKanryo = JutakuJizenKanryo;
    }

    /*
     * gethidShinseiJyohoFlg
     * @return hidShinseiJyohoFlg
     */
    @JsonProperty("hidShinseiJyohoFlg")
    public RString getHidShinseiJyohoFlg() {
        return hidShinseiJyohoFlg;
    }

    /*
     * sethidShinseiJyohoFlg
     * @param hidShinseiJyohoFlg hidShinseiJyohoFlg
     */
    @JsonProperty("hidShinseiJyohoFlg")
    public void setHidShinseiJyohoFlg(RString hidShinseiJyohoFlg) {
        this.hidShinseiJyohoFlg = hidShinseiJyohoFlg;
    }

    /*
     * gethidKozaJyohoFlg
     * @return hidKozaJyohoFlg
     */
    @JsonProperty("hidKozaJyohoFlg")
    public RString getHidKozaJyohoFlg() {
        return hidKozaJyohoFlg;
    }

    /*
     * sethidKozaJyohoFlg
     * @param hidKozaJyohoFlg hidKozaJyohoFlg
     */
    @JsonProperty("hidKozaJyohoFlg")
    public void setHidKozaJyohoFlg(RString hidKozaJyohoFlg) {
        this.hidKozaJyohoFlg = hidKozaJyohoFlg;
    }

    /*
     * gethidJutakuKaisyuJyohoFlg
     * @return hidJutakuKaisyuJyohoFlg
     */
    @JsonProperty("hidJutakuKaisyuJyohoFlg")
    public RString getHidJutakuKaisyuJyohoFlg() {
        return hidJutakuKaisyuJyohoFlg;
    }

    /*
     * sethidJutakuKaisyuJyohoFlg
     * @param hidJutakuKaisyuJyohoFlg hidJutakuKaisyuJyohoFlg
     */
    @JsonProperty("hidJutakuKaisyuJyohoFlg")
    public void setHidJutakuKaisyuJyohoFlg(RString hidJutakuKaisyuJyohoFlg) {
        this.hidJutakuKaisyuJyohoFlg = hidJutakuKaisyuJyohoFlg;
    }

    /*
     * gethidSeikyuSummaryFlg
     * @return hidSeikyuSummaryFlg
     */
    @JsonProperty("hidSeikyuSummaryFlg")
    public RString getHidSeikyuSummaryFlg() {
        return hidSeikyuSummaryFlg;
    }

    /*
     * sethidSeikyuSummaryFlg
     * @param hidSeikyuSummaryFlg hidSeikyuSummaryFlg
     */
    @JsonProperty("hidSeikyuSummaryFlg")
    public void setHidSeikyuSummaryFlg(RString hidSeikyuSummaryFlg) {
        this.hidSeikyuSummaryFlg = hidSeikyuSummaryFlg;
    }

    /*
     * getjigyoshaCode
     * @return jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    /*
     * setjigyoshaCode
     * @param jigyoshaCode jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public void setJigyoshaCode(RString jigyoshaCode) {
        this.jigyoshaCode = jigyoshaCode;
    }

    /*
     * getjigyoshaMeisho
     * @return jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /*
     * setjigyoshaMeisho
     * @param jigyoshaMeisho jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /*
     * getjigyoshaCodeMeisho
     * @return jigyoshaCodeMeisho
     */
    @JsonProperty("jigyoshaCodeMeisho")
    public RString getJigyoshaCodeMeisho() {
        return jigyoshaCodeMeisho;
    }

    /*
     * setjigyoshaCodeMeisho
     * @param jigyoshaCodeMeisho jigyoshaCodeMeisho
     */
    @JsonProperty("jigyoshaCodeMeisho")
    public void setJigyoshaCodeMeisho(RString jigyoshaCodeMeisho) {
        this.jigyoshaCodeMeisho = jigyoshaCodeMeisho;
    }

    /*
     * gethidSandannkaiMsgFlg
     * @return hidSandannkaiMsgFlg
     */
    @JsonProperty("hidSandannkaiMsgFlg")
    public RString getHidSandannkaiMsgFlg() {
        return hidSandannkaiMsgFlg;
    }

    /*
     * sethidSandannkaiMsgFlg
     * @param hidSandannkaiMsgFlg hidSandannkaiMsgFlg
     */
    @JsonProperty("hidSandannkaiMsgFlg")
    public void setHidSandannkaiMsgFlg(RString hidSandannkaiMsgFlg) {
        this.hidSandannkaiMsgFlg = hidSandannkaiMsgFlg;
    }

    /*
     * gethidLimitMsgDisplayedFlg
     * @return hidLimitMsgDisplayedFlg
     */
    @JsonProperty("hidLimitMsgDisplayedFlg")
    public RString getHidLimitMsgDisplayedFlg() {
        return hidLimitMsgDisplayedFlg;
    }

    /*
     * sethidLimitMsgDisplayedFlg
     * @param hidLimitMsgDisplayedFlg hidLimitMsgDisplayedFlg
     */
    @JsonProperty("hidLimitMsgDisplayedFlg")
    public void setHidLimitMsgDisplayedFlg(RString hidLimitMsgDisplayedFlg) {
        this.hidLimitMsgDisplayedFlg = hidLimitMsgDisplayedFlg;
    }

    /*
     * gethidLimitMsgNotNeedFlg
     * @return hidLimitMsgNotNeedFlg
     */
    @JsonProperty("hidLimitMsgNotNeedFlg")
    public RString getHidLimitMsgNotNeedFlg() {
        return hidLimitMsgNotNeedFlg;
    }

    /*
     * sethidLimitMsgNotNeedFlg
     * @param hidLimitMsgNotNeedFlg hidLimitMsgNotNeedFlg
     */
    @JsonProperty("hidLimitMsgNotNeedFlg")
    public void setHidLimitMsgNotNeedFlg(RString hidLimitMsgNotNeedFlg) {
        this.hidLimitMsgNotNeedFlg = hidLimitMsgNotNeedFlg;
    }

    /*
     * gethidLimitNGMsgDisplayedFlg
     * @return hidLimitNGMsgDisplayedFlg
     */
    @JsonProperty("hidLimitNGMsgDisplayedFlg")
    public RString getHidLimitNGMsgDisplayedFlg() {
        return hidLimitNGMsgDisplayedFlg;
    }

    /*
     * sethidLimitNGMsgDisplayedFlg
     * @param hidLimitNGMsgDisplayedFlg hidLimitNGMsgDisplayedFlg
     */
    @JsonProperty("hidLimitNGMsgDisplayedFlg")
    public void setHidLimitNGMsgDisplayedFlg(RString hidLimitNGMsgDisplayedFlg) {
        this.hidLimitNGMsgDisplayedFlg = hidLimitNGMsgDisplayedFlg;
    }

    /*
     * gethidTxtHiyoTotalNow
     * @return hidTxtHiyoTotalNow
     */
    @JsonProperty("hidTxtHiyoTotalNow")
    public RString getHidTxtHiyoTotalNow() {
        return hidTxtHiyoTotalNow;
    }

    /*
     * sethidTxtHiyoTotalNow
     * @param hidTxtHiyoTotalNow hidTxtHiyoTotalNow
     */
    @JsonProperty("hidTxtHiyoTotalNow")
    public void setHidTxtHiyoTotalNow(RString hidTxtHiyoTotalNow) {
        this.hidTxtHiyoTotalNow = hidTxtHiyoTotalNow;
    }

    /*
     * gethidTxtHokenTaishoHiyoNow
     * @return hidTxtHokenTaishoHiyoNow
     */
    @JsonProperty("hidTxtHokenTaishoHiyoNow")
    public RString getHidTxtHokenTaishoHiyoNow() {
        return hidTxtHokenTaishoHiyoNow;
    }

    /*
     * sethidTxtHokenTaishoHiyoNow
     * @param hidTxtHokenTaishoHiyoNow hidTxtHokenTaishoHiyoNow
     */
    @JsonProperty("hidTxtHokenTaishoHiyoNow")
    public void setHidTxtHokenTaishoHiyoNow(RString hidTxtHokenTaishoHiyoNow) {
        this.hidTxtHokenTaishoHiyoNow = hidTxtHokenTaishoHiyoNow;
    }

    /*
     * gethidTxtHokenKyufuAmountNow
     * @return hidTxtHokenKyufuAmountNow
     */
    @JsonProperty("hidTxtHokenKyufuAmountNow")
    public RString getHidTxtHokenKyufuAmountNow() {
        return hidTxtHokenKyufuAmountNow;
    }

    /*
     * sethidTxtHokenKyufuAmountNow
     * @param hidTxtHokenKyufuAmountNow hidTxtHokenKyufuAmountNow
     */
    @JsonProperty("hidTxtHokenKyufuAmountNow")
    public void setHidTxtHokenKyufuAmountNow(RString hidTxtHokenKyufuAmountNow) {
        this.hidTxtHokenKyufuAmountNow = hidTxtHokenKyufuAmountNow;
    }

    /*
     * gethidTxtRiyoshaFutanAmountNow
     * @return hidTxtRiyoshaFutanAmountNow
     */
    @JsonProperty("hidTxtRiyoshaFutanAmountNow")
    public RString getHidTxtRiyoshaFutanAmountNow() {
        return hidTxtRiyoshaFutanAmountNow;
    }

    /*
     * sethidTxtRiyoshaFutanAmountNow
     * @param hidTxtRiyoshaFutanAmountNow hidTxtRiyoshaFutanAmountNow
     */
    @JsonProperty("hidTxtRiyoshaFutanAmountNow")
    public void setHidTxtRiyoshaFutanAmountNow(RString hidTxtRiyoshaFutanAmountNow) {
        this.hidTxtRiyoshaFutanAmountNow = hidTxtRiyoshaFutanAmountNow;
    }

    /*
     * gethidDataChangeFlg
     * @return hidDataChangeFlg
     */
    @JsonProperty("hidDataChangeFlg")
    public RString getHidDataChangeFlg() {
        return hidDataChangeFlg;
    }

    /*
     * sethidDataChangeFlg
     * @param hidDataChangeFlg hidDataChangeFlg
     */
    @JsonProperty("hidDataChangeFlg")
    public void setHidDataChangeFlg(RString hidDataChangeFlg) {
        this.hidDataChangeFlg = hidDataChangeFlg;
    }

    /*
     * gethidInputConfirmMsgDisplayedFlg
     * @return hidInputConfirmMsgDisplayedFlg
     */
    @JsonProperty("hidInputConfirmMsgDisplayedFlg")
    public RString getHidInputConfirmMsgDisplayedFlg() {
        return hidInputConfirmMsgDisplayedFlg;
    }

    /*
     * sethidInputConfirmMsgDisplayedFlg
     * @param hidInputConfirmMsgDisplayedFlg hidInputConfirmMsgDisplayedFlg
     */
    @JsonProperty("hidInputConfirmMsgDisplayedFlg")
    public void setHidInputConfirmMsgDisplayedFlg(RString hidInputConfirmMsgDisplayedFlg) {
        this.hidInputConfirmMsgDisplayedFlg = hidInputConfirmMsgDisplayedFlg;
    }

    /*
     * gethidInputCheckMsgDisplayedFlg
     * @return hidInputCheckMsgDisplayedFlg
     */
    @JsonProperty("hidInputCheckMsgDisplayedFlg")
    public RString getHidInputCheckMsgDisplayedFlg() {
        return hidInputCheckMsgDisplayedFlg;
    }

    /*
     * sethidInputCheckMsgDisplayedFlg
     * @param hidInputCheckMsgDisplayedFlg hidInputCheckMsgDisplayedFlg
     */
    @JsonProperty("hidInputCheckMsgDisplayedFlg")
    public void setHidInputCheckMsgDisplayedFlg(RString hidInputCheckMsgDisplayedFlg) {
        this.hidInputCheckMsgDisplayedFlg = hidInputCheckMsgDisplayedFlg;
    }

    /*
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    // </editor-fold>
}
