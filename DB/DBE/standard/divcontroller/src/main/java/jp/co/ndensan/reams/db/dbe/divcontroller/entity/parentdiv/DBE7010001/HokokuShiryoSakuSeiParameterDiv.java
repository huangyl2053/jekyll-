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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HokokuShiryoSakuSeiParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokokuShiryoSakuSeiParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
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
    public RadioButton getRadhutsuryokuChohyo() {
        return this.getShutsuryokuChohyo().getRadhutsuryokuChohyo();
    }

    @JsonIgnore
    public void  setRadhutsuryokuChohyo(RadioButton radhutsuryokuChohyo) {
        this.getShutsuryokuChohyo().setRadhutsuryokuChohyo(radhutsuryokuChohyo);
    }

    @JsonIgnore
    public RadioButton getRadCsvShutsuryoku() {
        return this.getCsvKenHokokuShiryoSakusei().getRadCsvShutsuryoku();
    }

    @JsonIgnore
    public void  setRadCsvShutsuryoku(RadioButton radCsvShutsuryoku) {
        this.getCsvKenHokokuShiryoSakusei().setRadCsvShutsuryoku(radCsvShutsuryoku);
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
    public TextBoxFlexibleYearMonth getTxtNengetsu() {
        return this.getChushutsuJoken().getTxtNengetsu();
    }

    @JsonIgnore
    public void  setTxtNengetsu(TextBoxFlexibleYearMonth txtNengetsu) {
        this.getChushutsuJoken().setTxtNengetsu(txtNengetsu);
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
    public TextBoxDateRange getTxtTaishoGappi() {
        return this.getChushutsuJoken().getTxtTaishoGappi();
    }

    @JsonIgnore
    public void  setTxtTaishoGappi(TextBoxDateRange txtTaishoGappi) {
        this.getChushutsuJoken().setTxtTaishoGappi(txtTaishoGappi);
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
