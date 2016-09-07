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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiEnkiTsuchishoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiEnkiTsuchishoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BatchParameter")
    private BatchParameterDiv BatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBatchParameter
     * @return BatchParameter
     */
    @JsonProperty("BatchParameter")
    public BatchParameterDiv getBatchParameter() {
        return BatchParameter;
    }

    /*
     * setBatchParameter
     * @param BatchParameter BatchParameter
     */
    @JsonProperty("BatchParameter")
    public void setBatchParameter(BatchParameterDiv BatchParameter) {
        this.BatchParameter = BatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KensakuJokenDiv getKensakuJoken() {
        return this.getBatchParameter().getKensakuJoken();
    }

    @JsonIgnore
    public void  setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.getBatchParameter().setKensakuJoken(KensakuJoken);
    }

    @JsonIgnore
    public KensakujyokenHissuDiv getKensakujyokenHissu() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu();
    }

    @JsonIgnore
    public void  setKensakujyokenHissu(KensakujyokenHissuDiv KensakujyokenHissu) {
        this.getBatchParameter().getKensakuJoken().setKensakujyokenHissu(KensakujyokenHissu);
    }

    @JsonIgnore
    public CheckBoxList getCblShinseiKubun() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().getCblShinseiKubun();
    }

    @JsonIgnore
    public void  setCblShinseiKubun(CheckBoxList cblShinseiKubun) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().setCblShinseiKubun(cblShinseiKubun);
    }

    @JsonIgnore
    public CheckBoxList getCblHakkoUmu() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().getCblHakkoUmu();
    }

    @JsonIgnore
    public void  setCblHakkoUmu(CheckBoxList cblHakkoUmu) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().setCblHakkoUmu(cblHakkoUmu);
    }

    @JsonIgnore
    public RadioButton getRadMinashiNigo() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().getRadMinashiNigo();
    }

    @JsonIgnore
    public void  setRadMinashiNigo(RadioButton radMinashiNigo) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().setRadMinashiNigo(radMinashiNigo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikaNissu() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().getTxtKeikaNissu();
    }

    @JsonIgnore
    public void  setTxtKeikaNissu(TextBoxNum txtKeikaNissu) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenHissu().setTxtKeikaNissu(txtKeikaNissu);
    }

    @JsonIgnore
    public KensakujyokenNiniDiv getKensakujyokenNini() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini();
    }

    @JsonIgnore
    public void  setKensakujyokenNini(KensakujyokenNiniDiv KensakujyokenNini) {
        this.getBatchParameter().getKensakuJoken().setKensakujyokenNini(KensakujyokenNini);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDate() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getTxtMikomiDate();
    }

    @JsonIgnore
    public void  setTxtMikomiDate(TextBoxDateRange txtMikomiDate) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setTxtMikomiDate(txtMikomiDate);
    }

    @JsonIgnore
    public DropDownList getDdlEnkiRiyu() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getDdlEnkiRiyu();
    }

    @JsonIgnore
    public void  setDdlEnkiRiyu(DropDownList ddlEnkiRiyu) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setDdlEnkiRiyu(ddlEnkiRiyu);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getSpSpace1();
    }

    @JsonIgnore
    public void  setSpSpace1(Space spSpace1) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getSpSpace2();
    }

    @JsonIgnore
    public void  setSpSpace2(Space spSpace2) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public CheckBoxList getCblNinteiChosa() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getCblNinteiChosa();
    }

    @JsonIgnore
    public void  setCblNinteiChosa(CheckBoxList cblNinteiChosa) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setCblNinteiChosa(cblNinteiChosa);
    }

    @JsonIgnore
    public CheckBoxList getCblIkenshoJyuryo() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getCblIkenshoJyuryo();
    }

    @JsonIgnore
    public void  setCblIkenshoJyuryo(CheckBoxList cblIkenshoJyuryo) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setCblIkenshoJyuryo(cblIkenshoJyuryo);
    }

    @JsonIgnore
    public CheckBoxList getCblIchijiHantei() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getCblIchijiHantei();
    }

    @JsonIgnore
    public void  setCblIchijiHantei(CheckBoxList cblIchijiHantei) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setCblIchijiHantei(cblIchijiHantei);
    }

    @JsonIgnore
    public CheckBoxList getCblShinsakaiWaritsuke() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getCblShinsakaiWaritsuke();
    }

    @JsonIgnore
    public void  setCblShinsakaiWaritsuke(CheckBoxList cblShinsakaiWaritsuke) {
        this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().setCblShinsakaiWaritsuke(cblShinsakaiWaritsuke);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getBatchParameter().getKensakuJoken().getKensakujyokenNini().getCcdHokenshaList();
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxDisp() {
        return this.getBatchParameter().getKensakuJoken().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.getBatchParameter().getKensakuJoken().setTxtMaxDisp(txtMaxDisp);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getBatchParameter().getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getBatchParameter().getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getBatchParameter().getKensakuJoken().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getBatchParameter().getKensakuJoken().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public EnkiTsuchiHakkoTaishoshaDiv getEnkiTsuchiHakkoTaishosha() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha();
    }

    @JsonIgnore
    public void  setEnkiTsuchiHakkoTaishosha(EnkiTsuchiHakkoTaishoshaDiv EnkiTsuchiHakkoTaishosha) {
        this.getBatchParameter().setEnkiTsuchiHakkoTaishosha(EnkiTsuchiHakkoTaishosha);
    }

    @JsonIgnore
    public DataGrid<dgHakkotaishosha_Row> getDgHakkotaishosha() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getDgHakkotaishosha();
    }

    @JsonIgnore
    public void  setDgHakkotaishosha(DataGrid<dgHakkotaishosha_Row> dgHakkotaishosha) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().setDgHakkotaishosha(dgHakkotaishosha);
    }

    @JsonIgnore
    public EnkiRiyuSettingDiv getEnkiRiyuSetting() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting();
    }

    @JsonIgnore
    public void  setEnkiRiyuSetting(EnkiRiyuSettingDiv EnkiRiyuSetting) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().setEnkiRiyuSetting(EnkiRiyuSetting);
    }

    @JsonIgnore
    public DropDownList getDdlEnkiRiyuInput() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().getDdlEnkiRiyuInput();
    }

    @JsonIgnore
    public void  setDdlEnkiRiyuInput(DropDownList ddlEnkiRiyuInput) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().setDdlEnkiRiyuInput(ddlEnkiRiyuInput);
    }

    @JsonIgnore
    public Button getBtnSetting() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().getBtnSetting();
    }

    @JsonIgnore
    public void  setBtnSetting(Button btnSetting) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkiRiyuSetting().setBtnSetting(btnSetting);
    }

    @JsonIgnore
    public EnkitsuchiNaiyoDiv getEnkitsuchiNaiyo() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo();
    }

    @JsonIgnore
    public void  setEnkitsuchiNaiyo(EnkitsuchiNaiyoDiv EnkitsuchiNaiyo) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().setEnkitsuchiNaiyo(EnkitsuchiNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtnkiKetteiDate() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getTxtnkiKetteiDate();
    }

    @JsonIgnore
    public void  setTxtnkiKetteiDate(TextBoxDate txtnkiKetteiDate) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setTxtnkiKetteiDate(txtnkiKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDateTsuchisho() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getTxtMikomiDateTsuchisho();
    }

    @JsonIgnore
    public void  setTxtMikomiDateTsuchisho(TextBoxDateRange txtMikomiDateTsuchisho) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setTxtMikomiDateTsuchisho(txtMikomiDateTsuchisho);
    }

    @JsonIgnore
    public TextBoxDate getTxtTsuchishoHakkoDate() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getTxtTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtTsuchishoHakkoDate(TextBoxDate txtTsuchishoHakkoDate) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setTxtTsuchishoHakkoDate(txtTsuchishoHakkoDate);
    }

    @JsonIgnore
    public Button getBtnUpdate() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getBtnUpdate();
    }

    @JsonIgnore
    public void  setBtnUpdate(Button btnUpdate) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setBtnUpdate(btnUpdate);
    }

    @JsonIgnore
    public Button getBtnInputClear() {
        return this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().getBtnInputClear();
    }

    @JsonIgnore
    public void  setBtnInputClear(Button btnInputClear) {
        this.getBatchParameter().getEnkiTsuchiHakkoTaishosha().getEnkitsuchiNaiyo().setBtnInputClear(btnInputClear);
    }

    @JsonIgnore
    public NinteiEnkiTsuchiHakkoJyoken1Div getNinteiEnkiTsuchiHakkoJyoken1() {
        return this.getBatchParameter().getNinteiEnkiTsuchiHakkoJyoken1();
    }

    @JsonIgnore
    public void  setNinteiEnkiTsuchiHakkoJyoken1(NinteiEnkiTsuchiHakkoJyoken1Div NinteiEnkiTsuchiHakkoJyoken1) {
        this.getBatchParameter().setNinteiEnkiTsuchiHakkoJyoken1(NinteiEnkiTsuchiHakkoJyoken1);
    }

    @JsonIgnore
    public RadioButton getRadEnkiTsuchiHakkoIchiranhyo() {
        return this.getBatchParameter().getNinteiEnkiTsuchiHakkoJyoken1().getRadEnkiTsuchiHakkoIchiranhyo();
    }

    @JsonIgnore
    public void  setRadEnkiTsuchiHakkoIchiranhyo(RadioButton radEnkiTsuchiHakkoIchiranhyo) {
        this.getBatchParameter().getNinteiEnkiTsuchiHakkoJyoken1().setRadEnkiTsuchiHakkoIchiranhyo(radEnkiTsuchiHakkoIchiranhyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDateIchiran() {
        return this.getBatchParameter().getNinteiEnkiTsuchiHakkoJyoken1().getTxtMikomiDateIchiran();
    }

    @JsonIgnore
    public void  setTxtMikomiDateIchiran(TextBoxDateRange txtMikomiDateIchiran) {
        this.getBatchParameter().getNinteiEnkiTsuchiHakkoJyoken1().setTxtMikomiDateIchiran(txtMikomiDateIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtInsatsuDate() {
        return this.getBatchParameter().getNinteiEnkiTsuchiHakkoJyoken1().getTxtInsatsuDate();
    }

    @JsonIgnore
    public void  setTxtInsatsuDate(TextBoxDate txtInsatsuDate) {
        this.getBatchParameter().getNinteiEnkiTsuchiHakkoJyoken1().setTxtInsatsuDate(txtInsatsuDate);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return this.getBatchParameter().getCcdKanryoMessage();
    }

    // </editor-fold>
}
