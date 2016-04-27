package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HokokuShiryoSakuSeiParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokokuShiryoSakuSeiParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShutsuryokuChohyo")
    private ShutsuryokuChohyoDiv ShutsuryokuChohyo;
    @JsonProperty("CsvKenHokokuShiryoSakusei")
    private CsvKenHokokuShiryoSakuseiDiv CsvKenHokokuShiryoSakusei;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ShukeiTani")
    private ShukeiTaniDiv ShukeiTani;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShutsuryokuChohyo
     * @return ShutsuryokuChohyo
     */
    @JsonProperty("ShutsuryokuChohyo")
    public ShutsuryokuChohyoDiv getShutsuryokuChohyo() {
        return ShutsuryokuChohyo;
    }

    /*
     * setShutsuryokuChohyo
     * @param ShutsuryokuChohyo ShutsuryokuChohyo
     */
    @JsonProperty("ShutsuryokuChohyo")
    public void setShutsuryokuChohyo(ShutsuryokuChohyoDiv ShutsuryokuChohyo) {
        this.ShutsuryokuChohyo = ShutsuryokuChohyo;
    }

    /*
     * getCsvKenHokokuShiryoSakusei
     * @return CsvKenHokokuShiryoSakusei
     */
    @JsonProperty("CsvKenHokokuShiryoSakusei")
    public CsvKenHokokuShiryoSakuseiDiv getCsvKenHokokuShiryoSakusei() {
        return CsvKenHokokuShiryoSakusei;
    }

    /*
     * setCsvKenHokokuShiryoSakusei
     * @param CsvKenHokokuShiryoSakusei CsvKenHokokuShiryoSakusei
     */
    @JsonProperty("CsvKenHokokuShiryoSakusei")
    public void setCsvKenHokokuShiryoSakusei(CsvKenHokokuShiryoSakuseiDiv CsvKenHokokuShiryoSakusei) {
        this.CsvKenHokokuShiryoSakusei = CsvKenHokokuShiryoSakusei;
    }

    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getShukeiTani
     * @return ShukeiTani
     */
    @JsonProperty("ShukeiTani")
    public ShukeiTaniDiv getShukeiTani() {
        return ShukeiTani;
    }

    /*
     * setShukeiTani
     * @param ShukeiTani ShukeiTani
     */
    @JsonProperty("ShukeiTani")
    public void setShukeiTani(ShukeiTaniDiv ShukeiTani) {
        this.ShukeiTani = ShukeiTani;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkShutsuryokuChohyo() {
        return this.getShutsuryokuChohyo().getChkShutsuryokuChohyo();
    }

    @JsonIgnore
    public void  setChkShutsuryokuChohyo(CheckBoxList chkShutsuryokuChohyo) {
        this.getShutsuryokuChohyo().setChkShutsuryokuChohyo(chkShutsuryokuChohyo);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvShutsuryoku() {
        return this.getCsvKenHokokuShiryoSakusei().getChkCsvShutsuryoku();
    }

    @JsonIgnore
    public void  setChkCsvShutsuryoku(CheckBoxList chkCsvShutsuryoku) {
        this.getCsvKenHokokuShiryoSakusei().setChkCsvShutsuryoku(chkCsvShutsuryoku);
    }

    @JsonIgnore
    public TextBox getTxtShuturyokuSaki() {
        return this.getCsvKenHokokuShiryoSakusei().getTxtShuturyokuSaki();
    }

    @JsonIgnore
    public void  setTxtShuturyokuSaki(TextBox txtShuturyokuSaki) {
        this.getCsvKenHokokuShiryoSakusei().setTxtShuturyokuSaki(txtShuturyokuSaki);
    }

    @JsonIgnore
    public CheckBoxList getChkHihokenshaKubun() {
        return this.getChushutsuJoken().getChkHihokenshaKubun();
    }

    @JsonIgnore
    public void  setChkHihokenshaKubun(CheckBoxList chkHihokenshaKubun) {
        this.getChushutsuJoken().setChkHihokenshaKubun(chkHihokenshaKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishoNendo() {
        return this.getChushutsuJoken().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void  setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.getChushutsuJoken().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public DropDownList getDdlGogitaiBango() {
        return this.getChushutsuJoken().getDdlGogitaiBango();
    }

    @JsonIgnore
    public void  setDdlGogitaiBango(DropDownList ddlGogitaiBango) {
        this.getChushutsuJoken().setDdlGogitaiBango(ddlGogitaiBango);
    }

    @JsonIgnore
    public CheckBoxList getChkModifyTaishoTsuki() {
        return this.getChushutsuJoken().getChkModifyTaishoTsuki();
    }

    @JsonIgnore
    public void  setChkModifyTaishoTsuki(CheckBoxList chkModifyTaishoTsuki) {
        this.getChushutsuJoken().setChkModifyTaishoTsuki(chkModifyTaishoTsuki);
    }

    @JsonIgnore
    public DropDownList getDdlTsuki() {
        return this.getChushutsuJoken().getDdlTsuki();
    }

    @JsonIgnore
    public void  setDdlTsuki(DropDownList ddlTsuki) {
        this.getChushutsuJoken().setDdlTsuki(ddlTsuki);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunYMD() {
        return this.getChushutsuJoken().getTxtKijyunYMD();
    }

    @JsonIgnore
    public void  setTxtKijyunYMD(TextBoxDate txtKijyunYMD) {
        this.getChushutsuJoken().setTxtKijyunYMD(txtKijyunYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkModifyTaishoGeppi() {
        return this.getChushutsuJoken().getChkModifyTaishoGeppi();
    }

    @JsonIgnore
    public void  setChkModifyTaishoGeppi(CheckBoxList chkModifyTaishoGeppi) {
        this.getChushutsuJoken().setChkModifyTaishoGeppi(chkModifyTaishoGeppi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoGappi() {
        return this.getChushutsuJoken().getTxtTaishoGappi();
    }

    @JsonIgnore
    public void  setTxtTaishoGappi(TextBoxDateRange txtTaishoGappi) {
        this.getChushutsuJoken().setTxtTaishoGappi(txtTaishoGappi);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChushutsuJoken().getCcdHokenshaList();
    }

    @JsonIgnore
    public CheckBoxList getChkShukeiTani() {
        return this.getShukeiTani().getChkShukeiTani();
    }

    @JsonIgnore
    public void  setChkShukeiTani(CheckBoxList chkShukeiTani) {
        this.getShukeiTani().setChkShukeiTani(chkShukeiTani);
    }

    // </editor-fold>
}
