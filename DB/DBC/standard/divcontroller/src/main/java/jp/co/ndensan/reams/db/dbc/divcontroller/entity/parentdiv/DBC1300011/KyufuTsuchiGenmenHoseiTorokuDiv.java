package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.IServiceTypeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiGenmenHoseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuTsuchiGenmenHoseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuSearch")
    private KyufuTsuchiGenmenHoseiTorokuSearchDiv KyufuTsuchiGenmenHoseiTorokuSearch;
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuList")
    private KyufuTsuchiGenmenHoseiTorokuListDiv KyufuTsuchiGenmenHoseiTorokuList;
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuDetail")
    private KyufuTsuchiGenmenHoseiTorokuDetailDiv KyufuTsuchiGenmenHoseiTorokuDetail;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuKihon")
    private KaigoAtenaInfoDiv KyufuTsuchiGenmenHoseiTorokuKihon;
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuKaigoKihon")
    private KaigoShikakuKihonDiv KyufuTsuchiGenmenHoseiTorokuKaigoKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuTsuchiGenmenHoseiTorokuSearch
     * @return KyufuTsuchiGenmenHoseiTorokuSearch
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuSearch")
    public KyufuTsuchiGenmenHoseiTorokuSearchDiv getKyufuTsuchiGenmenHoseiTorokuSearch() {
        return KyufuTsuchiGenmenHoseiTorokuSearch;
    }

    /*
     * setKyufuTsuchiGenmenHoseiTorokuSearch
     * @param KyufuTsuchiGenmenHoseiTorokuSearch KyufuTsuchiGenmenHoseiTorokuSearch
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuSearch")
    public void setKyufuTsuchiGenmenHoseiTorokuSearch(KyufuTsuchiGenmenHoseiTorokuSearchDiv KyufuTsuchiGenmenHoseiTorokuSearch) {
        this.KyufuTsuchiGenmenHoseiTorokuSearch = KyufuTsuchiGenmenHoseiTorokuSearch;
    }

    /*
     * getKyufuTsuchiGenmenHoseiTorokuList
     * @return KyufuTsuchiGenmenHoseiTorokuList
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuList")
    public KyufuTsuchiGenmenHoseiTorokuListDiv getKyufuTsuchiGenmenHoseiTorokuList() {
        return KyufuTsuchiGenmenHoseiTorokuList;
    }

    /*
     * setKyufuTsuchiGenmenHoseiTorokuList
     * @param KyufuTsuchiGenmenHoseiTorokuList KyufuTsuchiGenmenHoseiTorokuList
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuList")
    public void setKyufuTsuchiGenmenHoseiTorokuList(KyufuTsuchiGenmenHoseiTorokuListDiv KyufuTsuchiGenmenHoseiTorokuList) {
        this.KyufuTsuchiGenmenHoseiTorokuList = KyufuTsuchiGenmenHoseiTorokuList;
    }

    /*
     * getKyufuTsuchiGenmenHoseiTorokuDetail
     * @return KyufuTsuchiGenmenHoseiTorokuDetail
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuDetail")
    public KyufuTsuchiGenmenHoseiTorokuDetailDiv getKyufuTsuchiGenmenHoseiTorokuDetail() {
        return KyufuTsuchiGenmenHoseiTorokuDetail;
    }

    /*
     * setKyufuTsuchiGenmenHoseiTorokuDetail
     * @param KyufuTsuchiGenmenHoseiTorokuDetail KyufuTsuchiGenmenHoseiTorokuDetail
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuDetail")
    public void setKyufuTsuchiGenmenHoseiTorokuDetail(KyufuTsuchiGenmenHoseiTorokuDetailDiv KyufuTsuchiGenmenHoseiTorokuDetail) {
        this.KyufuTsuchiGenmenHoseiTorokuDetail = KyufuTsuchiGenmenHoseiTorokuDetail;
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
     * getKyufuTsuchiGenmenHoseiTorokuKihon
     * @return KyufuTsuchiGenmenHoseiTorokuKihon
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuKihon")
    public IKaigoAtenaInfoDiv getKyufuTsuchiGenmenHoseiTorokuKihon() {
        return KyufuTsuchiGenmenHoseiTorokuKihon;
    }

    /*
     * getKyufuTsuchiGenmenHoseiTorokuKaigoKihon
     * @return KyufuTsuchiGenmenHoseiTorokuKaigoKihon
     */
    @JsonProperty("KyufuTsuchiGenmenHoseiTorokuKaigoKihon")
    public IKaigoShikakuKihonDiv getKyufuTsuchiGenmenHoseiTorokuKaigoKihon() {
        return KyufuTsuchiGenmenHoseiTorokuKaigoKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getHorizontalLineUe2() {
        return this.getKyufuTsuchiGenmenHoseiTorokuSearch().getHorizontalLineUe2();
    }

    @JsonIgnore
    public void  setHorizontalLineUe2(HorizontalLine HorizontalLineUe2) {
        this.getKyufuTsuchiGenmenHoseiTorokuSearch().setHorizontalLineUe2(HorizontalLineUe2);
    }

    @JsonIgnore
    public Label getLabelSaabisuNengetu() {
        return this.getKyufuTsuchiGenmenHoseiTorokuSearch().getLabelSaabisuNengetu();
    }

    @JsonIgnore
    public void  setLabelSaabisuNengetu(Label LabelSaabisuNengetu) {
        this.getKyufuTsuchiGenmenHoseiTorokuSearch().setLabelSaabisuNengetu(LabelSaabisuNengetu);
    }

    @JsonIgnore
    public TextBoxDateRange getTextBoxDateService() {
        return this.getKyufuTsuchiGenmenHoseiTorokuSearch().getTextBoxDateService();
    }

    @JsonIgnore
    public void  setTextBoxDateService(TextBoxDateRange TextBoxDateService) {
        this.getKyufuTsuchiGenmenHoseiTorokuSearch().setTextBoxDateService(TextBoxDateService);
    }

    @JsonIgnore
    public Button getButtonSearch() {
        return this.getKyufuTsuchiGenmenHoseiTorokuSearch().getButtonSearch();
    }

    @JsonIgnore
    public void  setButtonSearch(Button ButtonSearch) {
        this.getKyufuTsuchiGenmenHoseiTorokuSearch().setButtonSearch(ButtonSearch);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNumKensuu() {
        return this.getKyufuTsuchiGenmenHoseiTorokuSearch().getTextBoxNumKensuu();
    }

    @JsonIgnore
    public void  setTextBoxNumKensuu(TextBoxNum TextBoxNumKensuu) {
        this.getKyufuTsuchiGenmenHoseiTorokuSearch().setTextBoxNumKensuu(TextBoxNumKensuu);
    }

    @JsonIgnore
    public Button getButtonHyouji() {
        return this.getKyufuTsuchiGenmenHoseiTorokuSearch().getButtonHyouji();
    }

    @JsonIgnore
    public void  setButtonHyouji(Button ButtonHyouji) {
        this.getKyufuTsuchiGenmenHoseiTorokuSearch().setButtonHyouji(ButtonHyouji);
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLineUe() {
        return this.getKyufuTsuchiGenmenHoseiTorokuSearch().getHorizontalLineUe();
    }

    @JsonIgnore
    public void  setHorizontalLineUe(HorizontalLine HorizontalLineUe) {
        this.getKyufuTsuchiGenmenHoseiTorokuSearch().setHorizontalLineUe(HorizontalLineUe);
    }

    @JsonIgnore
    public Button getButtonTuika() {
        return this.getKyufuTsuchiGenmenHoseiTorokuList().getButtonTuika();
    }

    @JsonIgnore
    public void  setButtonTuika(Button ButtonTuika) {
        this.getKyufuTsuchiGenmenHoseiTorokuList().setButtonTuika(ButtonTuika);
    }

    @JsonIgnore
    public DataGrid<DataGridItiran_Row> getDataGridItiran() {
        return this.getKyufuTsuchiGenmenHoseiTorokuList().getDataGridItiran();
    }

    @JsonIgnore
    public void  setDataGridItiran(DataGrid<DataGridItiran_Row> DataGridItiran) {
        this.getKyufuTsuchiGenmenHoseiTorokuList().setDataGridItiran(DataGridItiran);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDateSaabisu() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxDateSaabisu();
    }

    @JsonIgnore
    public void  setTextBoxDateSaabisu(TextBoxDate TextBoxDateSaabisu) {
        this.getKyufuTsuchiGenmenHoseiTorokuDetail().setTextBoxDateSaabisu(TextBoxDateSaabisu);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxFudangoukei() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxFudangoukei();
    }

    @JsonIgnore
    public void  setTextBoxFudangoukei(TextBoxNum TextBoxFudangoukei) {
        this.getKyufuTsuchiGenmenHoseiTorokuDetail().setTextBoxFudangoukei(TextBoxFudangoukei);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNumHiyouGoukei() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxNumHiyouGoukei();
    }

    @JsonIgnore
    public void  setTextBoxNumHiyouGoukei(TextBoxNum TextBoxNumHiyouGoukei) {
        this.getKyufuTsuchiGenmenHoseiTorokuDetail().setTextBoxNumHiyouGoukei(TextBoxNumHiyouGoukei);
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLineSita() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getHorizontalLineSita();
    }

    @JsonIgnore
    public void  setHorizontalLineSita(HorizontalLine HorizontalLineSita) {
        this.getKyufuTsuchiGenmenHoseiTorokuDetail().setHorizontalLineSita(HorizontalLineSita);
    }

    @JsonIgnore
    public Button getButtonBack() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getButtonBack();
    }

    @JsonIgnore
    public void  setButtonBack(Button ButtonBack) {
        this.getKyufuTsuchiGenmenHoseiTorokuDetail().setButtonBack(ButtonBack);
    }

    @JsonIgnore
    public Button getButtonYes() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getButtonYes();
    }

    @JsonIgnore
    public void  setButtonYes(Button ButtonYes) {
        this.getKyufuTsuchiGenmenHoseiTorokuDetail().setButtonYes(ButtonYes);
    }

    @JsonIgnore
    public IServiceTypeInputCommonChildDiv getCcdServiceTypeInput() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdServiceTypeInput();
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaInput() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput();
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdHokenshaList();
    }

    // </editor-fold>
}
