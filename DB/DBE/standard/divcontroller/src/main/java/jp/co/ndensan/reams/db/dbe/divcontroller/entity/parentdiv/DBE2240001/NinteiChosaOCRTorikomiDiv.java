package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * NinteiChosaOCRTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaOCRTorikomiDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblExplanation")
    private Label lblExplanation;
    @JsonProperty("txtTorikomiPath")
    private TextBox txtTorikomiPath;
    @JsonProperty("hdnSharedFileEntryInfo")
    private RString hdnSharedFileEntryInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblExplanation
     * @return lblExplanation
     */
    @JsonProperty("lblExplanation")
    public Label getLblExplanation() {
        return lblExplanation;
    }

    /*
     * setlblExplanation
     * @param lblExplanation lblExplanation
     */
    @JsonProperty("lblExplanation")
    public void setLblExplanation(Label lblExplanation) {
        this.lblExplanation = lblExplanation;
    }

    /*
     * gettxtTorikomiPath
     * @return txtTorikomiPath
     */
    @JsonProperty("txtTorikomiPath")
    public TextBox getTxtTorikomiPath() {
        return txtTorikomiPath;
    }

    /*
     * settxtTorikomiPath
     * @param txtTorikomiPath txtTorikomiPath
     */
    @JsonProperty("txtTorikomiPath")
    public void setTxtTorikomiPath(TextBox txtTorikomiPath) {
        this.txtTorikomiPath = txtTorikomiPath;
    }

    /*
     * gethdnSharedFileEntryInfo
     * @return hdnSharedFileEntryInfo
     */
    @JsonProperty("hdnSharedFileEntryInfo")
    public RString getHdnSharedFileEntryInfo() {
        return hdnSharedFileEntryInfo;
    }

    /*
     * sethdnSharedFileEntryInfo
     * @param hdnSharedFileEntryInfo hdnSharedFileEntryInfo
     */
    @JsonProperty("hdnSharedFileEntryInfo")
    public void setHdnSharedFileEntryInfo(RString hdnSharedFileEntryInfo) {
        this.hdnSharedFileEntryInfo = hdnSharedFileEntryInfo;
    }

    // </editor-fold>
}
