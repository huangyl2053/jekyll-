package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011;
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
 * TorikomiFuairu のクラスファイル 
 * 
 * @author 自動生成
 */
public class TorikomiFuairuDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplAppurodoFuairu")
    private UploadPanel uplAppurodoFuairu;
    @JsonProperty("btnAppurodo")
    private Button btnAppurodo;
    @JsonProperty("Yohaku")
    private Space Yohaku;
    @JsonProperty("txtFuairuName")
    private TextBox txtFuairuName;
    @JsonProperty("txtKoshinNichiji")
    private TextBox txtKoshinNichiji;
    @JsonProperty("txtFuairuRekodoSu")
    private TextBoxNum txtFuairuRekodoSu;
    @JsonProperty("hdnFilePath")
    private RString hdnFilePath;
    @JsonProperty("hdnLine")
    private RString hdnLine;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplAppurodoFuairu
     * @return uplAppurodoFuairu
     */
    @JsonProperty("uplAppurodoFuairu")
    public UploadPanel getUplAppurodoFuairu() {
        return uplAppurodoFuairu;
    }

    /*
     * setuplAppurodoFuairu
     * @param uplAppurodoFuairu uplAppurodoFuairu
     */
    @JsonProperty("uplAppurodoFuairu")
    public void setUplAppurodoFuairu(UploadPanel uplAppurodoFuairu) {
        this.uplAppurodoFuairu = uplAppurodoFuairu;
    }

    /*
     * getbtnAppurodo
     * @return btnAppurodo
     */
    @JsonProperty("btnAppurodo")
    public Button getBtnAppurodo() {
        return btnAppurodo;
    }

    /*
     * setbtnAppurodo
     * @param btnAppurodo btnAppurodo
     */
    @JsonProperty("btnAppurodo")
    public void setBtnAppurodo(Button btnAppurodo) {
        this.btnAppurodo = btnAppurodo;
    }

    /*
     * getYohaku
     * @return Yohaku
     */
    @JsonProperty("Yohaku")
    public Space getYohaku() {
        return Yohaku;
    }

    /*
     * setYohaku
     * @param Yohaku Yohaku
     */
    @JsonProperty("Yohaku")
    public void setYohaku(Space Yohaku) {
        this.Yohaku = Yohaku;
    }

    /*
     * gettxtFuairuName
     * @return txtFuairuName
     */
    @JsonProperty("txtFuairuName")
    public TextBox getTxtFuairuName() {
        return txtFuairuName;
    }

    /*
     * settxtFuairuName
     * @param txtFuairuName txtFuairuName
     */
    @JsonProperty("txtFuairuName")
    public void setTxtFuairuName(TextBox txtFuairuName) {
        this.txtFuairuName = txtFuairuName;
    }

    /*
     * gettxtKoshinNichiji
     * @return txtKoshinNichiji
     */
    @JsonProperty("txtKoshinNichiji")
    public TextBox getTxtKoshinNichiji() {
        return txtKoshinNichiji;
    }

    /*
     * settxtKoshinNichiji
     * @param txtKoshinNichiji txtKoshinNichiji
     */
    @JsonProperty("txtKoshinNichiji")
    public void setTxtKoshinNichiji(TextBox txtKoshinNichiji) {
        this.txtKoshinNichiji = txtKoshinNichiji;
    }

    /*
     * gettxtFuairuRekodoSu
     * @return txtFuairuRekodoSu
     */
    @JsonProperty("txtFuairuRekodoSu")
    public TextBoxNum getTxtFuairuRekodoSu() {
        return txtFuairuRekodoSu;
    }

    /*
     * settxtFuairuRekodoSu
     * @param txtFuairuRekodoSu txtFuairuRekodoSu
     */
    @JsonProperty("txtFuairuRekodoSu")
    public void setTxtFuairuRekodoSu(TextBoxNum txtFuairuRekodoSu) {
        this.txtFuairuRekodoSu = txtFuairuRekodoSu;
    }

    /*
     * gethdnFilePath
     * @return hdnFilePath
     */
    @JsonProperty("hdnFilePath")
    public RString getHdnFilePath() {
        return hdnFilePath;
    }

    /*
     * sethdnFilePath
     * @param hdnFilePath hdnFilePath
     */
    @JsonProperty("hdnFilePath")
    public void setHdnFilePath(RString hdnFilePath) {
        this.hdnFilePath = hdnFilePath;
    }

    /*
     * gethdnLine
     * @return hdnLine
     */
    @JsonProperty("hdnLine")
    public RString getHdnLine() {
        return hdnLine;
    }

    /*
     * sethdnLine
     * @param hdnLine hdnLine
     */
    @JsonProperty("hdnLine")
    public void setHdnLine(RString hdnLine) {
        this.hdnLine = hdnLine;
    }

    // </editor-fold>
}
