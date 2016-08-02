package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * EnkitsuchiNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class EnkitsuchiNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtnkiKetteiDate")
    private TextBoxDate txtnkiKetteiDate;
    @JsonProperty("txtMikomiDateTsuchisho")
    private TextBoxDateRange txtMikomiDateTsuchisho;
    @JsonProperty("txtTsuchishoHakkoDate")
    private TextBoxDate txtTsuchishoHakkoDate;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("btnInputClear")
    private Button btnInputClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtnkiKetteiDate
     * @return txtnkiKetteiDate
     */
    @JsonProperty("txtnkiKetteiDate")
    public TextBoxDate getTxtnkiKetteiDate() {
        return txtnkiKetteiDate;
    }

    /*
     * settxtnkiKetteiDate
     * @param txtnkiKetteiDate txtnkiKetteiDate
     */
    @JsonProperty("txtnkiKetteiDate")
    public void setTxtnkiKetteiDate(TextBoxDate txtnkiKetteiDate) {
        this.txtnkiKetteiDate = txtnkiKetteiDate;
    }

    /*
     * gettxtMikomiDateTsuchisho
     * @return txtMikomiDateTsuchisho
     */
    @JsonProperty("txtMikomiDateTsuchisho")
    public TextBoxDateRange getTxtMikomiDateTsuchisho() {
        return txtMikomiDateTsuchisho;
    }

    /*
     * settxtMikomiDateTsuchisho
     * @param txtMikomiDateTsuchisho txtMikomiDateTsuchisho
     */
    @JsonProperty("txtMikomiDateTsuchisho")
    public void setTxtMikomiDateTsuchisho(TextBoxDateRange txtMikomiDateTsuchisho) {
        this.txtMikomiDateTsuchisho = txtMikomiDateTsuchisho;
    }

    /*
     * gettxtTsuchishoHakkoDate
     * @return txtTsuchishoHakkoDate
     */
    @JsonProperty("txtTsuchishoHakkoDate")
    public TextBoxDate getTxtTsuchishoHakkoDate() {
        return txtTsuchishoHakkoDate;
    }

    /*
     * settxtTsuchishoHakkoDate
     * @param txtTsuchishoHakkoDate txtTsuchishoHakkoDate
     */
    @JsonProperty("txtTsuchishoHakkoDate")
    public void setTxtTsuchishoHakkoDate(TextBoxDate txtTsuchishoHakkoDate) {
        this.txtTsuchishoHakkoDate = txtTsuchishoHakkoDate;
    }

    /*
     * getbtnUpdate
     * @return btnUpdate
     */
    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    /*
     * setbtnUpdate
     * @param btnUpdate btnUpdate
     */
    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    /*
     * getbtnInputClear
     * @return btnInputClear
     */
    @JsonProperty("btnInputClear")
    public Button getBtnInputClear() {
        return btnInputClear;
    }

    /*
     * setbtnInputClear
     * @param btnInputClear btnInputClear
     */
    @JsonProperty("btnInputClear")
    public void setBtnInputClear(Button btnInputClear) {
        this.btnInputClear = btnInputClear;
    }

    // </editor-fold>
}
