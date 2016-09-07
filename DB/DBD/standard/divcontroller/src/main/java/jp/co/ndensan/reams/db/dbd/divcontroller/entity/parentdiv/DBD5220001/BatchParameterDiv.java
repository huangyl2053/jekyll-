package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * BatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class BatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("EnkiTsuchiHakkoTaishosha")
    private EnkiTsuchiHakkoTaishoshaDiv EnkiTsuchiHakkoTaishosha;
    @JsonProperty("NinteiEnkiTsuchiHakkoJyoken1")
    private NinteiEnkiTsuchiHakkoJyoken1Div NinteiEnkiTsuchiHakkoJyoken1;
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getEnkiTsuchiHakkoTaishosha
     * @return EnkiTsuchiHakkoTaishosha
     */
    @JsonProperty("EnkiTsuchiHakkoTaishosha")
    public EnkiTsuchiHakkoTaishoshaDiv getEnkiTsuchiHakkoTaishosha() {
        return EnkiTsuchiHakkoTaishosha;
    }

    /*
     * setEnkiTsuchiHakkoTaishosha
     * @param EnkiTsuchiHakkoTaishosha EnkiTsuchiHakkoTaishosha
     */
    @JsonProperty("EnkiTsuchiHakkoTaishosha")
    public void setEnkiTsuchiHakkoTaishosha(EnkiTsuchiHakkoTaishoshaDiv EnkiTsuchiHakkoTaishosha) {
        this.EnkiTsuchiHakkoTaishosha = EnkiTsuchiHakkoTaishosha;
    }

    /*
     * getNinteiEnkiTsuchiHakkoJyoken1
     * @return NinteiEnkiTsuchiHakkoJyoken1
     */
    @JsonProperty("NinteiEnkiTsuchiHakkoJyoken1")
    public NinteiEnkiTsuchiHakkoJyoken1Div getNinteiEnkiTsuchiHakkoJyoken1() {
        return NinteiEnkiTsuchiHakkoJyoken1;
    }

    /*
     * setNinteiEnkiTsuchiHakkoJyoken1
     * @param NinteiEnkiTsuchiHakkoJyoken1 NinteiEnkiTsuchiHakkoJyoken1
     */
    @JsonProperty("NinteiEnkiTsuchiHakkoJyoken1")
    public void setNinteiEnkiTsuchiHakkoJyoken1(NinteiEnkiTsuchiHakkoJyoken1Div NinteiEnkiTsuchiHakkoJyoken1) {
        this.NinteiEnkiTsuchiHakkoJyoken1 = NinteiEnkiTsuchiHakkoJyoken1;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KensakujyokenHissuDiv getKensakujyokenHissu() {
        return this.getKensakuJoken().getKensakujyokenHissu();
    }

    @JsonIgnore
    public void  setKensakujyokenHissu(KensakujyokenHissuDiv KensakujyokenHissu) {
        this.getKensakuJoken().setKensakujyokenHissu(KensakujyokenHissu);
    }

    @JsonIgnore
    public CheckBoxList getCblShinseiKubun() {
        return this.getKensakuJoken().getKensakujyokenHissu().getCblShinseiKubun();
    }

    @JsonIgnore
    public void  setCblShinseiKubun(CheckBoxList cblShinseiKubun) {
        this.getKensakuJoken().getKensakujyokenHissu().setCblShinseiKubun(cblShinseiKubun);
    }

    @JsonIgnore
    public CheckBoxList getCblHakkoUmu() {
        return this.getKensakuJoken().getKensakujyokenHissu().getCblHakkoUmu();
    }

    @JsonIgnore
    public void  setCblHakkoUmu(CheckBoxList cblHakkoUmu) {
        this.getKensakuJoken().getKensakujyokenHissu().setCblHakkoUmu(cblHakkoUmu);
    }

    @JsonIgnore
    public RadioButton getRadMinashiNigo() {
        return this.getKensakuJoken().getKensakujyokenHissu().getRadMinashiNigo();
    }

    @JsonIgnore
    public void  setRadMinashiNigo(RadioButton radMinashiNigo) {
        this.getKensakuJoken().getKensakujyokenHissu().setRadMinashiNigo(radMinashiNigo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikaNissu() {
        return this.getKensakuJoken().getKensakujyokenHissu().getTxtKeikaNissu();
    }

    @JsonIgnore
    public void  setTxtKeikaNissu(TextBoxNum txtKeikaNissu) {
        this.getKensakuJoken().getKensakujyokenHissu().setTxtKeikaNissu(txtKeikaNissu);
    }

    @JsonIgnore
    public KensakujyokenNiniDiv getKensakujyokenNini() {
        return this.getKensakuJoken().getKensakujyokenNini();
    }

    @JsonIgnore
    public void  setKensakujyokenNini(KensakujyokenNiniDiv KensakujyokenNini) {
        this.getKensakuJoken().setKensakujyokenNini(KensakujyokenNini);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDate() {
        return this.getKensakuJoken().getKensakujyokenNini().getTxtMikomiDate();
    }

    @JsonIgnore
    public void  setTxtMikomiDate(TextBoxDateRange txtMikomiDate) {
        this.getKensakuJoken().getKensakujyokenNini().setTxtMikomiDate(txtMikomiDate);
    }

    @JsonIgnore
    public DropDownList getDdlEnkiRiyu() {
        return this.getKensakuJoken().getKensakujyokenNini().getDdlEnkiRiyu();
    }

    @JsonIgnore
    public void  setDdlEnkiRiyu(DropDownList ddlEnkiRiyu) {
        this.getKensakuJoken().getKensakujyokenNini().setDdlEnkiRiyu(ddlEnkiRiyu);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getKensakuJoken().getKensakujyokenNini().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getKensakuJoken().getKensakujyokenNini().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getKensakuJoken().getKensakujyokenNini().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getKensakuJoken().getKensakujyokenNini().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public CheckBoxList getCblNinteiChosa() {
        return this.getKensakuJoken().getKensakujyokenNini().getCblNinteiChosa();
    }

    @JsonIgnore
    public void  setCblNinteiChosa(CheckBoxList cblNinteiChosa) {
        this.getKensakuJoken().getKensakujyokenNini().setCblNinteiChosa(cblNinteiChosa);
    }

    @JsonIgnore
    public CheckBoxList getCblIkenshoJyuryo() {
        return this.getKensakuJoken().getKensakujyokenNini().getCblIkenshoJyuryo();
    }

    @JsonIgnore
    public void  setCblIkenshoJyuryo(CheckBoxList cblIkenshoJyuryo) {
        this.getKensakuJoken().getKensakujyokenNini().setCblIkenshoJyuryo(cblIkenshoJyuryo);
    }

    @JsonIgnore
    public CheckBoxList getCblIchijiHantei() {
        return this.getKensakuJoken().getKensakujyokenNini().getCblIchijiHantei();
    }

    @JsonIgnore
    public void  setCblIchijiHantei(CheckBoxList cblIchijiHantei) {
        this.getKensakuJoken().getKensakujyokenNini().setCblIchijiHantei(cblIchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getCblShinsakaiWaritsuke() {
        return this.getKensakuJoken().getKensakujyokenNini().getCblShinsakaiWaritsuke();
    }

    @JsonIgnore
    public void  setCblShinsakaiWaritsuke(CheckBoxList cblShinsakaiWaritsuke) {
        this.getKensakuJoken().getKensakujyokenNini().setCblShinsakaiWaritsuke(cblShinsakaiWaritsuke);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getKensakuJoken().getKensakujyokenNini().getCcdHokenshaList();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxDisp() {
        return this.getKensakuJoken().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.getKensakuJoken().setTxtMaxDisp(txtMaxDisp);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getKensakuJoken().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getKensakuJoken().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgHakkotaishosha_Row> getDgHakkotaishosha() {
        return this.getEnkiTsuchiHakkoTaishosha().getDgHakkotaishosha();
    }

    @JsonIgnore
    public void  setDgHakkotaishosha(DataGrid<dgHakkotaishosha_Row> dgHakkotaishosha) {
        this.getEnkiTsuchiHakkoTaishosha().setDgHakkotaishosha(dgHakkotaishosha);
    }

    @JsonIgnore
    public EnkiRiyuSettingDiv getEnkiRiyuSetting() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting();
    }

    @JsonIgnore
    public void  setEnkiRiyuSetting(EnkiRiyuSettingDiv EnkiRiyuSetting) {
        this.getEnkiTsuchiHakkoTaishosha().setEnkiRiyuSetting(EnkiRiyuSetting);
    }

    @JsonIgnore
    public DropDownList getDdlEnkiRiyuInput() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().getDdlEnkiRiyuInput();
    }

    @JsonIgnore
    public void  setDdlEnkiRiyuInput(DropDownList ddlEnkiRiyuInput) {
        this.getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().setDdlEnkiRiyuInput(ddlEnkiRiyuInput);
    }

    @JsonIgnore
    public Button getBtnSetting() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().getBtnSetting();
    }

    @JsonIgnore
    public void  setBtnSetting(Button btnSetting) {
        this.getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().setBtnSetting(btnSetting);
    }

    @JsonIgnore
    public EnkitsuchiNaiyoDiv getEnkitsuchiNaiyo() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo();
    }

    @JsonIgnore
    public void  setEnkitsuchiNaiyo(EnkitsuchiNaiyoDiv EnkitsuchiNaiyo) {
        this.getEnkiTsuchiHakkoTaishosha().setEnkitsuchiNaiyo(EnkitsuchiNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtnkiKetteiDate() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getTxtnkiKetteiDate();
    }

    @JsonIgnore
    public void  setTxtnkiKetteiDate(TextBoxDate txtnkiKetteiDate) {
        this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setTxtnkiKetteiDate(txtnkiKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDateTsuchisho() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getTxtMikomiDateTsuchisho();
    }

    @JsonIgnore
    public void  setTxtMikomiDateTsuchisho(TextBoxDateRange txtMikomiDateTsuchisho) {
        this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setTxtMikomiDateTsuchisho(txtMikomiDateTsuchisho);
    }

    @JsonIgnore
    public TextBoxDate getTxtTsuchishoHakkoDate() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getTxtTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtTsuchishoHakkoDate(TextBoxDate txtTsuchishoHakkoDate) {
        this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setTxtTsuchishoHakkoDate(txtTsuchishoHakkoDate);
    }

    @JsonIgnore
    public Button getBtnUpdate() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getBtnUpdate();
    }

    @JsonIgnore
    public void  setBtnUpdate(Button btnUpdate) {
        this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setBtnUpdate(btnUpdate);
    }

    @JsonIgnore
    public Button getBtnInputClear() {
        return this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getBtnInputClear();
    }

    @JsonIgnore
    public void  setBtnInputClear(Button btnInputClear) {
        this.getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setBtnInputClear(btnInputClear);
    }

    @JsonIgnore
    public RadioButton getRadEnkiTsuchiHakkoIchiranhyo() {
        return this.getNinteiEnkiTsuchiHakkoJyoken1().getRadEnkiTsuchiHakkoIchiranhyo();
    }

    @JsonIgnore
    public void  setRadEnkiTsuchiHakkoIchiranhyo(RadioButton radEnkiTsuchiHakkoIchiranhyo) {
        this.getNinteiEnkiTsuchiHakkoJyoken1().setRadEnkiTsuchiHakkoIchiranhyo(radEnkiTsuchiHakkoIchiranhyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDateIchiran() {
        return this.getNinteiEnkiTsuchiHakkoJyoken1().getTxtMikomiDateIchiran();
    }

    @JsonIgnore
    public void  setTxtMikomiDateIchiran(TextBoxDateRange txtMikomiDateIchiran) {
        this.getNinteiEnkiTsuchiHakkoJyoken1().setTxtMikomiDateIchiran(txtMikomiDateIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtInsatsuDate() {
        return this.getNinteiEnkiTsuchiHakkoJyoken1().getTxtInsatsuDate();
    }

    @JsonIgnore
    public void  setTxtInsatsuDate(TextBoxDate txtInsatsuDate) {
        this.getNinteiEnkiTsuchiHakkoJyoken1().setTxtInsatsuDate(txtInsatsuDate);
    }

    // </editor-fold>
}
