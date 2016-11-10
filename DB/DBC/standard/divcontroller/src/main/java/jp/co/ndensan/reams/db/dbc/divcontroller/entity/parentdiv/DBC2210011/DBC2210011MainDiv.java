package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBC2210011Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBC2210011MainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearch")
    private TokubetsuKyufuJigyoshaSearchDiv TokubetsuKyufuJigyoshaSearch;
    @JsonProperty("TokubetsuKyufuJigyoshaList")
    private TokubetsuKyufuJigyoshaListDiv TokubetsuKyufuJigyoshaList;
    @JsonProperty("TokubetsuKyufuJigyoshaDetail")
    private TokubetsuKyufuJigyoshaDetailDiv TokubetsuKyufuJigyoshaDetail;
    @JsonProperty("TokubetsuKyufuJigyoshaDetailServiceInfo")
    private TokubetsuKyufuJigyoshaDetailServiceInfoDiv TokubetsuKyufuJigyoshaDetailServiceInfo;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("事業者情報件数 ")
    private RString 事業者情報件数 ;
    @JsonProperty("hiddenModel")
    private RString hiddenModel;
    @JsonProperty("hiddenModelOne")
    private RString hiddenModelOne;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokubetsuKyufuJigyoshaSearch
     * @return TokubetsuKyufuJigyoshaSearch
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearch")
    public TokubetsuKyufuJigyoshaSearchDiv getTokubetsuKyufuJigyoshaSearch() {
        return TokubetsuKyufuJigyoshaSearch;
    }

    /*
     * setTokubetsuKyufuJigyoshaSearch
     * @param TokubetsuKyufuJigyoshaSearch TokubetsuKyufuJigyoshaSearch
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearch")
    public void setTokubetsuKyufuJigyoshaSearch(TokubetsuKyufuJigyoshaSearchDiv TokubetsuKyufuJigyoshaSearch) {
        this.TokubetsuKyufuJigyoshaSearch = TokubetsuKyufuJigyoshaSearch;
    }

    /*
     * getTokubetsuKyufuJigyoshaList
     * @return TokubetsuKyufuJigyoshaList
     */
    @JsonProperty("TokubetsuKyufuJigyoshaList")
    public TokubetsuKyufuJigyoshaListDiv getTokubetsuKyufuJigyoshaList() {
        return TokubetsuKyufuJigyoshaList;
    }

    /*
     * setTokubetsuKyufuJigyoshaList
     * @param TokubetsuKyufuJigyoshaList TokubetsuKyufuJigyoshaList
     */
    @JsonProperty("TokubetsuKyufuJigyoshaList")
    public void setTokubetsuKyufuJigyoshaList(TokubetsuKyufuJigyoshaListDiv TokubetsuKyufuJigyoshaList) {
        this.TokubetsuKyufuJigyoshaList = TokubetsuKyufuJigyoshaList;
    }

    /*
     * getTokubetsuKyufuJigyoshaDetail
     * @return TokubetsuKyufuJigyoshaDetail
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetail")
    public TokubetsuKyufuJigyoshaDetailDiv getTokubetsuKyufuJigyoshaDetail() {
        return TokubetsuKyufuJigyoshaDetail;
    }

    /*
     * setTokubetsuKyufuJigyoshaDetail
     * @param TokubetsuKyufuJigyoshaDetail TokubetsuKyufuJigyoshaDetail
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetail")
    public void setTokubetsuKyufuJigyoshaDetail(TokubetsuKyufuJigyoshaDetailDiv TokubetsuKyufuJigyoshaDetail) {
        this.TokubetsuKyufuJigyoshaDetail = TokubetsuKyufuJigyoshaDetail;
    }

    /*
     * getTokubetsuKyufuJigyoshaDetailServiceInfo
     * @return TokubetsuKyufuJigyoshaDetailServiceInfo
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailServiceInfo")
    public TokubetsuKyufuJigyoshaDetailServiceInfoDiv getTokubetsuKyufuJigyoshaDetailServiceInfo() {
        return TokubetsuKyufuJigyoshaDetailServiceInfo;
    }

    /*
     * setTokubetsuKyufuJigyoshaDetailServiceInfo
     * @param TokubetsuKyufuJigyoshaDetailServiceInfo TokubetsuKyufuJigyoshaDetailServiceInfo
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailServiceInfo")
    public void setTokubetsuKyufuJigyoshaDetailServiceInfo(TokubetsuKyufuJigyoshaDetailServiceInfoDiv TokubetsuKyufuJigyoshaDetailServiceInfo) {
        this.TokubetsuKyufuJigyoshaDetailServiceInfo = TokubetsuKyufuJigyoshaDetailServiceInfo;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * get事業者情報件数 
     * @return 事業者情報件数 
     */
    @JsonProperty("事業者情報件数 ")
    public RString get事業者情報件数 () {
        return 事業者情報件数 ;
    }

    /*
     * set事業者情報件数 
     * @param 事業者情報件数  事業者情報件数 
     */
    @JsonProperty("事業者情報件数 ")
    public void set事業者情報件数 (RString 事業者情報件数 ) {
        this.事業者情報件数  = 事業者情報件数 ;
    }

    /*
     * gethiddenModel
     * @return hiddenModel
     */
    @JsonProperty("hiddenModel")
    public RString getHiddenModel() {
        return hiddenModel;
    }

    /*
     * sethiddenModel
     * @param hiddenModel hiddenModel
     */
    @JsonProperty("hiddenModel")
    public void setHiddenModel(RString hiddenModel) {
        this.hiddenModel = hiddenModel;
    }

    /*
     * gethiddenModelOne
     * @return hiddenModelOne
     */
    @JsonProperty("hiddenModelOne")
    public RString getHiddenModelOne() {
        return hiddenModelOne;
    }

    /*
     * sethiddenModelOne
     * @param hiddenModelOne hiddenModelOne
     */
    @JsonProperty("hiddenModelOne")
    public void setHiddenModelOne(RString hiddenModelOne) {
        this.hiddenModelOne = hiddenModelOne;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getSpc01() {
        return this.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchBottonArea().getSpc01();
    }

    @JsonIgnore
    public void  setSpc01(Space spc01) {
        this.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchBottonArea().setSpc01(spc01);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchBottonArea().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchBottonArea().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public Space getSpc02() {
        return this.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailHojinShubetsu().getSpc02();
    }

    @JsonIgnore
    public void  setSpc02(Space spc02) {
        this.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailHojinShubetsu().setSpc02(spc02);
    }

    @JsonIgnore
    public DropDownList getDdlHojinShubetsu() {
        return this.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailHojinShubetsu().getDdlHojinShubetsu();
    }

    @JsonIgnore
    public void  setDdlHojinShubetsu(DropDownList ddlHojinShubetsu) {
        this.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailHojinShubetsu().setDdlHojinShubetsu(ddlHojinShubetsu);
    }

    // </editor-fold>
}
