package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.INinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShinseishaDataOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseishaDataOutputDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuOption")
    private KensakuOptionDiv KensakuOption;
    @JsonProperty("ShinseiJohoIchiran")
    private ShinseiJohoIchiranDiv ShinseiJohoIchiran;
    @JsonProperty("OutputCsvSelect")
    private OutputCsvSelectDiv OutputCsvSelect;
    @JsonProperty("ccdNinteishinseishaFinder")
    private NinteiShinseishaFinderDiv ccdNinteishinseishaFinder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuOption
     * @return KensakuOption
     */
    @JsonProperty("KensakuOption")
    public KensakuOptionDiv getKensakuOption() {
        return KensakuOption;
    }

    /*
     * setKensakuOption
     * @param KensakuOption KensakuOption
     */
    @JsonProperty("KensakuOption")
    public void setKensakuOption(KensakuOptionDiv KensakuOption) {
        this.KensakuOption = KensakuOption;
    }

    /*
     * getShinseiJohoIchiran
     * @return ShinseiJohoIchiran
     */
    @JsonProperty("ShinseiJohoIchiran")
    public ShinseiJohoIchiranDiv getShinseiJohoIchiran() {
        return ShinseiJohoIchiran;
    }

    /*
     * setShinseiJohoIchiran
     * @param ShinseiJohoIchiran ShinseiJohoIchiran
     */
    @JsonProperty("ShinseiJohoIchiran")
    public void setShinseiJohoIchiran(ShinseiJohoIchiranDiv ShinseiJohoIchiran) {
        this.ShinseiJohoIchiran = ShinseiJohoIchiran;
    }

    /*
     * getOutputCsvSelect
     * @return OutputCsvSelect
     */
    @JsonProperty("OutputCsvSelect")
    public OutputCsvSelectDiv getOutputCsvSelect() {
        return OutputCsvSelect;
    }

    /*
     * setOutputCsvSelect
     * @param OutputCsvSelect OutputCsvSelect
     */
    @JsonProperty("OutputCsvSelect")
    public void setOutputCsvSelect(OutputCsvSelectDiv OutputCsvSelect) {
        this.OutputCsvSelect = OutputCsvSelect;
    }

    /*
     * getccdNinteishinseishaFinder
     * @return ccdNinteishinseishaFinder
     */
    @JsonProperty("ccdNinteishinseishaFinder")
    public INinteiShinseishaFinderDiv getCcdNinteishinseishaFinder() {
        return ccdNinteishinseishaFinder;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuOption().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuOption().setBtnClear(btnClear);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxDisp() {
        return this.getKensakuOption().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.getKensakuOption().setTxtMaxDisp(txtMaxDisp);
    }

    @JsonIgnore
    public DataGrid<dgShinseiJoho_Row> getDgShinseiJoho() {
        return this.getShinseiJohoIchiran().getDgShinseiJoho();
    }

    @JsonIgnore
    public void  setDgShinseiJoho(DataGrid<dgShinseiJoho_Row> dgShinseiJoho) {
        this.getShinseiJohoIchiran().setDgShinseiJoho(dgShinseiJoho);
    }

    @JsonIgnore
    public Button getBtnModoru() {
        return this.getShinseiJohoIchiran().getBtnModoru();
    }

    @JsonIgnore
    public void  setBtnModoru(Button btnModoru) {
        this.getShinseiJohoIchiran().setBtnModoru(btnModoru);
    }

    @JsonIgnore
    public CheckBoxList getChkOutputCsv() {
        return this.getOutputCsvSelect().getChkOutputCsv();
    }

    @JsonIgnore
    public void  setChkOutputCsv(CheckBoxList chkOutputCsv) {
        this.getOutputCsvSelect().setChkOutputCsv(chkOutputCsv);
    }

    // </editor-fold>
}
