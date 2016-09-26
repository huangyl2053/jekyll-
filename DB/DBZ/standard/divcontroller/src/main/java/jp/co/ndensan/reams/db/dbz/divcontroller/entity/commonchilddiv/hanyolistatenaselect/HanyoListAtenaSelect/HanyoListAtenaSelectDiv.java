package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku1Input.IChiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku3Input.IChiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNumRange;

/**
 * HanyoListAtenaSelect のクラスファイル
 *
 * @reamsid_L DBA-1610-040 dingyi
 */
public class HanyoListAtenaSelectDiv extends Panel implements IHanyoListAtenaSelectDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvAtena")
    private DvAtenaDiv DvAtena;
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    private RString hdnTxtDonyuKeitaiCode;
    @JsonProperty("hdnTxtIsMultiSelected")
    private RString hdnTxtIsMultiSelected;
    @JsonProperty("hdnTxtChikuShubetsu")
    private RString hdnTxtChikuShubetsu;
    @JsonProperty("hdnMapMultiSelect")
    private RString hdnMapMultiSelect;
    @JsonProperty("hdnTxtTitle")
    private RString hdnTxtTitle;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvAtena
     * @return DvAtena
     */
    @JsonProperty("DvAtena")
    public DvAtenaDiv getDvAtena() {
        return DvAtena;
    }

    /*
     * setDvAtena
     * @param DvAtena DvAtena
     */
    @JsonProperty("DvAtena")
    public void setDvAtena(DvAtenaDiv DvAtena) {
        this.DvAtena = DvAtena;
    }

    /*
     * gethdnTxtDonyuKeitaiCode
     * @return hdnTxtDonyuKeitaiCode
     */
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    public RString getHdnTxtDonyuKeitaiCode() {
        return hdnTxtDonyuKeitaiCode;
    }

    /*
     * sethdnTxtDonyuKeitaiCode
     * @param hdnTxtDonyuKeitaiCode hdnTxtDonyuKeitaiCode
     */
    @JsonProperty("hdnTxtDonyuKeitaiCode")
    public void setHdnTxtDonyuKeitaiCode(RString hdnTxtDonyuKeitaiCode) {
        this.hdnTxtDonyuKeitaiCode = hdnTxtDonyuKeitaiCode;
    }

    /*
     * gethdnTxtIsMultiSelected
     * @return hdnTxtIsMultiSelected
     */
    @JsonProperty("hdnTxtIsMultiSelected")
    public RString getHdnTxtIsMultiSelected() {
        return hdnTxtIsMultiSelected;
    }

    /*
     * sethdnTxtIsMultiSelected
     * @param hdnTxtIsMultiSelected hdnTxtIsMultiSelected
     */
    @JsonProperty("hdnTxtIsMultiSelected")
    public void setHdnTxtIsMultiSelected(RString hdnTxtIsMultiSelected) {
        this.hdnTxtIsMultiSelected = hdnTxtIsMultiSelected;
    }

    /*
     * gethdnTxtChikuShubetsu
     * @return hdnTxtChikuShubetsu
     */
    @JsonProperty("hdnTxtChikuShubetsu")
    public RString getHdnTxtChikuShubetsu() {
        return hdnTxtChikuShubetsu;
    }

    /*
     * sethdnTxtChikuShubetsu
     * @param hdnTxtChikuShubetsu hdnTxtChikuShubetsu
     */
    @JsonProperty("hdnTxtChikuShubetsu")
    public void setHdnTxtChikuShubetsu(RString hdnTxtChikuShubetsu) {
        this.hdnTxtChikuShubetsu = hdnTxtChikuShubetsu;
    }

    /*
     * gethdnMapMultiSelect
     * @return hdnMapMultiSelect
     */
    @JsonProperty("hdnMapMultiSelect")
    public RString getHdnMapMultiSelect() {
        return hdnMapMultiSelect;
    }

    /*
     * sethdnMapMultiSelect
     * @param hdnMapMultiSelect hdnMapMultiSelect
     */
    @JsonProperty("hdnMapMultiSelect")
    public void setHdnMapMultiSelect(RString hdnMapMultiSelect) {
        this.hdnMapMultiSelect = hdnMapMultiSelect;
    }

    /*
     * gethdnTxtTitle
     * @return hdnTxtTitle
     */
    @JsonProperty("hdnTxtTitle")
    public RString getHdnTxtTitle() {
        return hdnTxtTitle;
    }

    /*
     * sethdnTxtTitle
     * @param hdnTxtTitle hdnTxtTitle
     */
    @JsonProperty("hdnTxtTitle")
    public void setHdnTxtTitle(RString hdnTxtTitle) {
        this.hdnTxtTitle = hdnTxtTitle;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DvJokenSelectDiv getDvJokenSelect() {
        return this.getDvAtena().getDvJokenSelect();
    }

    @JsonIgnore
    public void setDvJokenSelect(DvJokenSelectDiv DvJokenSelect) {
        this.getDvAtena().setDvJokenSelect(DvJokenSelect);
    }

    @JsonIgnore
    public RadioButton getRadSelectKijun() {
        return this.getDvAtena().getDvJokenSelect().getRadSelectKijun();
    }

    @JsonIgnore
    public void setRadSelectKijun(RadioButton radSelectKijun) {
        this.getDvAtena().getDvJokenSelect().setRadSelectKijun(radSelectKijun);
    }

    @JsonIgnore
    public dvKensakuJokenDiv getDvKensakuJoken() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken();
    }

    @JsonIgnore
    public void setDvKensakuJoken(dvKensakuJokenDiv dvKensakuJoken) {
        this.getDvAtena().getDvJokenSelect().setDvKensakuJoken(dvKensakuJoken);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtNenrei() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().getTxtNenrei();
    }

    @JsonIgnore
    public void setTxtNenrei(TextBoxNumRange txtNenrei) {
        this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().setTxtNenrei(txtNenrei);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunbi() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().getTxtNenreiKijunbi();
    }

    @JsonIgnore
    public void setTxtNenreiKijunbi(TextBoxDate txtNenreiKijunbi) {
        this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().setTxtNenreiKijunbi(txtNenreiKijunbi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSeinengappi() {
        return this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().getTxtSeinengappi();
    }

    @JsonIgnore
    public void setTxtSeinengappi(TextBoxDateRange txtSeinengappi) {
        this.getDvAtena().getDvJokenSelect().getDvKensakuJoken().setTxtSeinengappi(txtSeinengappi);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getDvAtena().getDvJokenSelect().getCcdHokenshaList();
    }

    @JsonIgnore
    public DvChikuDiv getDvChiku() {
        return this.getDvAtena().getDvChiku();
    }

    @JsonIgnore
    public void setDvChiku(DvChikuDiv DvChiku) {
        this.getDvAtena().setDvChiku(DvChiku);
    }

    @JsonIgnore
    public DropDownList getDdlChikuSelect() {
        return this.getDvAtena().getDvChiku().getDdlChikuSelect();
    }

    @JsonIgnore
    public void setDdlChikuSelect(DropDownList ddlChikuSelect) {
        this.getDvAtena().getDvChiku().setDdlChikuSelect(ddlChikuSelect);
    }

    @JsonIgnore
    public Label getLblStart() {
        return this.getDvAtena().getDvChiku().getLblStart();
    }

    @JsonIgnore
    public void setLblStart(Label lblStart) {
        this.getDvAtena().getDvChiku().setLblStart(lblStart);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJushoFrom() {
        return this.getDvAtena().getDvChiku().getCcdJushoFrom();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuFrom() {
        return this.getDvAtena().getDvChiku().getCcdGyoseikuFrom();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1From() {
        return this.getDvAtena().getDvChiku().getCcdChiku1From();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2From() {
        return this.getDvAtena().getDvChiku().getCcdChiku2From();
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3From() {
        return this.getDvAtena().getDvChiku().getCcdChiku3From();
    }

    @JsonIgnore
    public Label getLblEnd() {
        return this.getDvAtena().getDvChiku().getLblEnd();
    }

    @JsonIgnore
    public void setLblEnd(Label lblEnd) {
        this.getDvAtena().getDvChiku().setLblEnd(lblEnd);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJushoTo() {
        return this.getDvAtena().getDvChiku().getCcdJushoTo();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuTo() {
        return this.getDvAtena().getDvChiku().getCcdGyoseikuTo();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1To() {
        return this.getDvAtena().getDvChiku().getCcdChiku1To();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2To() {
        return this.getDvAtena().getDvChiku().getCcdChiku2To();
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3To() {
        return this.getDvAtena().getDvChiku().getCcdChiku3To();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(HokenshaKosei 保険者構成) {
        getHandler().initialize(保険者構成);
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public NenreiSoChushutsuHoho get年齢層抽出方法() {
        return getHandler().get年齢層抽出方法();
    }

    @Override
    public void set年齢層抽出方法(RString 年齢層抽出方法) {
        getHandler().set年齢層抽出方法(年齢層抽出方法);
    }

    @Override
    public Decimal get年齢開始() {
        return getHandler().get年齢開始();
    }

    @Override
    public void set年齢開始(Decimal 年齢開始) {
        getHandler().set年齢開始(年齢開始);
    }

    @Override
    public Decimal get年齢終了() {
        return getHandler().get年齢終了();
    }

    @Override
    public void set年齢終了(Decimal 年齢終了) {
        getHandler().set年齢終了(年齢終了);
    }

    @Override
    public RDate get年齢基準日() {
        return getHandler().get年齢基準日();
    }

    @Override
    public void set年齢基準日(RDate 年齢基準日) {
        getHandler().set年齢基準日(年齢基準日);
    }

    @Override
    public RDate get生年月日開始() {
        return getHandler().get生年月日開始();
    }

    @Override
    public void set生年月日開始(RDate 生年月日開始) {
        getHandler().set生年月日開始(生年月日開始);
    }

    @Override
    public RDate get生年月日終了() {
        return getHandler().get生年月日終了();
    }

    @Override
    public void set生年月日終了(RDate 生年月日終了) {
        getHandler().set生年月日終了(生年月日終了);
    }

    @Override
    public HokenshaSummary get保険者() {
        return getHandler().get保険者();
    }

    @Override
    public void set保険者() {
        getHandler().set保険者();
    }

    @Override
    public void set保険者(LasdecCode 市町村コード) {
        getHandler().set保険者(市町村コード);
    }

    @Override
    public Chiku get地区() {
        return getHandler().get地区();
    }

    @Override
    public void set地区(RString 地区) {
        getHandler().set地区(地区);
    }

    @Override
    public RString get住所開始() {
        return getHandler().get住所開始();
    }

    @Override
    public void set住所開始(ChoikiCode 町域コード) {
        getHandler().set住所開始(町域コード);
    }

    @Override
    public RString get行政区開始() {
        return getHandler().get行政区開始();
    }

    @Override
    public void set行政区開始(GyoseikuCode 行政区コード) {
        getHandler().set行政区開始(行政区コード);
    }

    @Override
    public RString get地区１開始() {
        return getHandler().get地区１開始();
    }

    @Override
    public void set地区１開始(ChikuCode 地区1コード) {
        getHandler().set地区１開始(地区1コード);
    }

    @Override
    public RString get地区２開始() {
        return getHandler().get地区２開始();
    }

    @Override
    public void set地区２開始(ChikuCode 地区2コード) {
        getHandler().set地区２開始(地区2コード);
    }

    @Override
    public RString get地区３開始() {
        return getHandler().get地区３開始();
    }

    @Override
    public void set地区３開始(ChikuCode 地区3コード) {
        getHandler().set地区３開始(地区3コード);
    }

    @Override
    public RString get住所終了() {
        return getHandler().get住所終了();
    }

    @Override
    public void set住所終了(ChoikiCode 町域コード) {
        getHandler().set住所終了(町域コード);
    }

    @Override
    public RString get行政区終了() {
        return getHandler().get行政区終了();
    }

    @Override
    public void set行政区終了(GyoseikuCode 行政区コード) {
        getHandler().set行政区終了(行政区コード);
    }

    @Override
    public RString get地区１終了() {
        return getHandler().get地区１終了();
    }

    @Override
    public void set地区１終了(ChikuCode 地区1コード) {
        getHandler().set地区１終了(地区1コード);
    }

    @Override
    public RString get地区２終了() {
        return getHandler().get地区２終了();
    }

    @Override
    public void set地区２終了(ChikuCode 地区2コード) {
        getHandler().set地区２終了(地区2コード);
    }

    @Override
    public RString get地区３終了() {
        return getHandler().get地区３終了();
    }

    @Override
    public void set地区３終了(ChikuCode 地区3コード) {
        getHandler().set地区３終了(地区3コード);
    }

    @Override
    public AtenaSelectBatchParameter get宛名抽出条件() {
        return getHandler().get宛名抽出条件();
    }

    @Override
    public HanyoListAtenaSelectDiv get宛名抽出条件子Div() {
        return getHandler().get宛名抽出条件子Div();
    }

    private HanyoListAtenaSelectHandler getHandler() {
        return new HanyoListAtenaSelectHandler(this);
    }

}
