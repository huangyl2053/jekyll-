package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * DvKogakuServiceJuryoInin のクラスファイル
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
public class DvKogakuServiceJuryoIninDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvKyotsuJoho")
    private DvKyotsuJohoDiv DvKyotsuJoho;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("DvHaraiKetteiToroku")
    private DvHaraiKetteiTorokuDiv DvHaraiKetteiToroku;
    @JsonProperty("DvHaraiKetteiShusei")
    private DvHaraiKetteiShuseiDiv DvHaraiKetteiShusei;
    @JsonProperty("DvHakko")
    private DvHakkoDiv DvHakko;
    @JsonProperty("operateState")
    private RString operateState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvKyotsuJoho
     * @return DvKyotsuJoho
     */
    @JsonProperty("DvKyotsuJoho")
    public DvKyotsuJohoDiv getDvKyotsuJoho() {
        return DvKyotsuJoho;
    }

    /*
     * setDvKyotsuJoho
     * @param DvKyotsuJoho DvKyotsuJoho
     */
    @JsonProperty("DvKyotsuJoho")
    public void setDvKyotsuJoho(DvKyotsuJohoDiv DvKyotsuJoho) {
        this.DvKyotsuJoho = DvKyotsuJoho;
    }

    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getDvHaraiKetteiToroku
     * @return DvHaraiKetteiToroku
     */
    @JsonProperty("DvHaraiKetteiToroku")
    public DvHaraiKetteiTorokuDiv getDvHaraiKetteiToroku() {
        return DvHaraiKetteiToroku;
    }

    /*
     * setDvHaraiKetteiToroku
     * @param DvHaraiKetteiToroku DvHaraiKetteiToroku
     */
    @JsonProperty("DvHaraiKetteiToroku")
    public void setDvHaraiKetteiToroku(DvHaraiKetteiTorokuDiv DvHaraiKetteiToroku) {
        this.DvHaraiKetteiToroku = DvHaraiKetteiToroku;
    }

    /*
     * getDvHaraiKetteiShusei
     * @return DvHaraiKetteiShusei
     */
    @JsonProperty("DvHaraiKetteiShusei")
    public DvHaraiKetteiShuseiDiv getDvHaraiKetteiShusei() {
        return DvHaraiKetteiShusei;
    }

    /*
     * setDvHaraiKetteiShusei
     * @param DvHaraiKetteiShusei DvHaraiKetteiShusei
     */
    @JsonProperty("DvHaraiKetteiShusei")
    public void setDvHaraiKetteiShusei(DvHaraiKetteiShuseiDiv DvHaraiKetteiShusei) {
        this.DvHaraiKetteiShusei = DvHaraiKetteiShusei;
    }

    /*
     * getDvHakko
     * @return DvHakko
     */
    @JsonProperty("DvHakko")
    public DvHakkoDiv getDvHakko() {
        return DvHakko;
    }

    /*
     * setDvHakko
     * @param DvHakko DvHakko
     */
    @JsonProperty("DvHakko")
    public void setDvHakko(DvHakkoDiv DvHakko) {
        this.DvHakko = DvHakko;
    }

    /*
     * getoperateState
     * @return operateState
     */
    @JsonProperty("operateState")
    public RString getOperateState() {
        return operateState;
    }

    /*
     * setoperateState
     * @param operateState operateState
     */
    @JsonProperty("operateState")
    public void setOperateState(RString operateState) {
        this.operateState = operateState;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCddShikakuKihon() {
        return this.getDvKyotsuJoho().getCddShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCddAtenaInfo() {
        return this.getDvKyotsuJoho().getCddAtenaInfo();
    }

    @JsonIgnore
    public Button getBtnTorokuSeitaiIchiran() {
        return this.getDvHaraiKetteiToroku().getBtnTorokuSeitaiIchiran();
    }

    @JsonIgnore
    public void setBtnTorokuSeitaiIchiran(Button btnTorokuSeitaiIchiran) {
        this.getDvHaraiKetteiToroku().setBtnTorokuSeitaiIchiran(btnTorokuSeitaiIchiran);
    }

    @JsonIgnore
    public HorizontalLine getLinLine2() {
        return this.getDvHaraiKetteiToroku().getLinLine2();
    }

    @JsonIgnore
    public void setLinLine2(HorizontalLine linLine2) {
        this.getDvHaraiKetteiToroku().setLinLine2(linLine2);
    }

    @JsonIgnore
    public DataGrid<dgHaraiKettei_Row> getDgHaraiKettei() {
        return this.getDvHaraiKetteiToroku().getDgHaraiKettei();
    }

    @JsonIgnore
    public void setDgHaraiKettei(DataGrid<dgHaraiKettei_Row> dgHaraiKettei) {
        this.getDvHaraiKetteiToroku().setDgHaraiKettei(dgHaraiKettei);
    }

    @JsonIgnore
    public Button getBtnShuseiSeitaiIchiran() {
        return this.getDvHaraiKetteiShusei().getBtnShuseiSeitaiIchiran();
    }

    @JsonIgnore
    public void setBtnShuseiSeitaiIchiran(Button btnShuseiSeitaiIchiran) {
        this.getDvHaraiKetteiShusei().setBtnShuseiSeitaiIchiran(btnShuseiSeitaiIchiran);
    }

    @JsonIgnore
    public TextBox getTxtRirekiNo() {
        return this.getDvHaraiKetteiShusei().getTxtRirekiNo();
    }

    @JsonIgnore
    public void setTxtRirekiNo(TextBox txtRirekiNo) {
        this.getDvHaraiKetteiShusei().setTxtRirekiNo(txtRirekiNo);
    }

    @JsonIgnore
    public HorizontalLine getLinLine3() {
        return this.getDvHaraiKetteiShusei().getLinLine3();
    }

    @JsonIgnore
    public void setLinLine3(HorizontalLine linLine3) {
        this.getDvHaraiKetteiShusei().setLinLine3(linLine3);
    }

    @JsonIgnore
    public TextBoxDate getBtnShinseiDate() {
        return this.getDvHaraiKetteiShusei().getBtnShinseiDate();
    }

    @JsonIgnore
    public void setBtnShinseiDate(TextBoxDate btnShinseiDate) {
        this.getDvHaraiKetteiShusei().setBtnShinseiDate(btnShinseiDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeDate() {
        return this.getDvHaraiKetteiShusei().getTxtUketsukeDate();
    }

    @JsonIgnore
    public void setTxtUketsukeDate(TextBoxDate txtUketsukeDate) {
        this.getDvHaraiKetteiShusei().setTxtUketsukeDate(txtUketsukeDate);
    }

    @JsonIgnore
    public TextBoxDate getBtnKetteiDate() {
        return this.getDvHaraiKetteiShusei().getBtnKetteiDate();
    }

    @JsonIgnore
    public void setBtnKetteiDate(TextBoxDate btnKetteiDate) {
        this.getDvHaraiKetteiShusei().setBtnKetteiDate(btnKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getBtnShoninDate() {
        return this.getDvHaraiKetteiShusei().getBtnShoninDate();
    }

    @JsonIgnore
    public void setBtnShoninDate(TextBoxDateRange btnShoninDate) {
        this.getDvHaraiKetteiShusei().setBtnShoninDate(btnShoninDate);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyosha() {
        return this.getDvHaraiKetteiShusei().getCcdJigyosha();
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getDvHaraiKetteiShusei().getRadKetteiKubun();
    }

    @JsonIgnore
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getDvHaraiKetteiShusei().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninShinaiRiyu() {
        return this.getDvHaraiKetteiShusei().getTxtShoninShinaiRiyu();
    }

    @JsonIgnore
    public void setTxtShoninShinaiRiyu(TextBoxMultiLine txtShoninShinaiRiyu) {
        this.getDvHaraiKetteiShusei().setTxtShoninShinaiRiyu(txtShoninShinaiRiyu);
    }

    @JsonIgnore
    public HorizontalLine getLinLine5() {
        return this.getDvHaraiKetteiShusei().getLinLine5();
    }

    @JsonIgnore
    public void setLinLine5(HorizontalLine linLine5) {
        this.getDvHaraiKetteiShusei().setLinLine5(linLine5);
    }

    @JsonIgnore
    public DropDownList getDdlRiyoshafutanJogenGaku() {
        return this.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku();
    }

    @JsonIgnore
    public void setDdlRiyoshafutanJogenGaku(DropDownList ddlRiyoshafutanJogenGaku) {
        this.getDvHaraiKetteiShusei().setDdlRiyoshafutanJogenGaku(ddlRiyoshafutanJogenGaku);
    }

    @JsonIgnore
    public HorizontalLine getLinLine6() {
        return this.getDvHaraiKetteiShusei().getLinLine6();
    }

    @JsonIgnore
    public void setLinLine6(HorizontalLine linLine6) {
        this.getDvHaraiKetteiShusei().setLinLine6(linLine6);
    }

    @JsonIgnore
    public DvKakuninshoDiv getDvKakuninsho() {
        return this.getDvHakko().getDvKakuninsho();
    }

    @JsonIgnore
    public void setDvKakuninsho(DvKakuninshoDiv DvKakuninsho) {
        this.getDvHakko().setDvKakuninsho(DvKakuninsho);
    }

    @JsonIgnore
    public TextBoxDate getTxtTsuchiDate() {
        return this.getDvHakko().getDvKakuninsho().getTxtTsuchiDate();
    }

    @JsonIgnore
    public void setTxtTsuchiDate(TextBoxDate txtTsuchiDate) {
        this.getDvHakko().getDvKakuninsho().setTxtTsuchiDate(txtTsuchiDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return this.getDvHakko().getDvKakuninsho().getCcdBunshoBango();
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return this.getDvHakko().getCcdKanryoMessage();
    }

    // </editor-fold>
}
