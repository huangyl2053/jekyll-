package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChikuShichosonSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChikuShichosonSelectDiv extends Panel implements IChikuShichosonSelectDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuJoken")
    private Label lblChushutsuJoken;
    @JsonProperty("TanitsuShichoson")
    private TanitsuShichosonDiv TanitsuShichoson;
    @JsonProperty("KoikiShichoson")
    private KoikiShichosonDiv KoikiShichoson;
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
     * getlblChushutsuJoken
     * @return lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public Label getLblChushutsuJoken() {
        return lblChushutsuJoken;
    }

    /*
     * setlblChushutsuJoken
     * @param lblChushutsuJoken lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.lblChushutsuJoken = lblChushutsuJoken;
    }

    /*
     * getTanitsuShichoson
     * @return TanitsuShichoson
     */
    @JsonProperty("TanitsuShichoson")
    public TanitsuShichosonDiv getTanitsuShichoson() {
        return TanitsuShichoson;
    }

    /*
     * setTanitsuShichoson
     * @param TanitsuShichoson TanitsuShichoson
     */
    @JsonProperty("TanitsuShichoson")
    public void setTanitsuShichoson(TanitsuShichosonDiv TanitsuShichoson) {
        this.TanitsuShichoson = TanitsuShichoson;
    }

    /*
     * getKoikiShichoson
     * @return KoikiShichoson
     */
    @JsonProperty("KoikiShichoson")
    public KoikiShichosonDiv getKoikiShichoson() {
        return KoikiShichoson;
    }

    /*
     * setKoikiShichoson
     * @param KoikiShichoson KoikiShichoson
     */
    @JsonProperty("KoikiShichoson")
    public void setKoikiShichoson(KoikiShichosonDiv KoikiShichoson) {
        this.KoikiShichoson = KoikiShichoson;
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
    public DropDownList getDdlChiku() {
        return this.getTanitsuShichoson().getDdlChiku();
    }

    @JsonIgnore
    public void  setDdlChiku(DropDownList ddlChiku) {
        this.getTanitsuShichoson().setDdlChiku(ddlChiku);
    }

    @JsonIgnore
    public ButtonDialog getBtnChoikiGuide() {
        return this.getTanitsuShichoson().getBtnChoikiGuide();
    }

    @JsonIgnore
    public void  setBtnChoikiGuide(ButtonDialog btnChoikiGuide) {
        this.getTanitsuShichoson().setBtnChoikiGuide(btnChoikiGuide);
    }

    @JsonIgnore
    public ButtonDialog getBtnChikuNyuryokuGuide() {
        return this.getTanitsuShichoson().getBtnChikuNyuryokuGuide();
    }

    @JsonIgnore
    public void  setBtnChikuNyuryokuGuide(ButtonDialog btnChikuNyuryokuGuide) {
        this.getTanitsuShichoson().setBtnChikuNyuryokuGuide(btnChikuNyuryokuGuide);
    }

    @JsonIgnore
    public SelectedResultDiv getSelectedResult() {
        return this.getTanitsuShichoson().getSelectedResult();
    }

    @JsonIgnore
    public void  setSelectedResult(SelectedResultDiv SelectedResult) {
        this.getTanitsuShichoson().setSelectedResult(SelectedResult);
    }

    @JsonIgnore
    public DataGrid<ddlCodeList_Row> getDdlCodeList() {
        return this.getTanitsuShichoson().getSelectedResult().getDdlCodeList();
    }

    @JsonIgnore
    public void  setDdlCodeList(DataGrid<ddlCodeList_Row> ddlCodeList) {
        this.getTanitsuShichoson().getSelectedResult().setDdlCodeList(ddlCodeList);
    }

    @JsonIgnore
    public DropDownList getDdlShichoson() {
        return this.getKoikiShichoson().getDdlShichoson();
    }

    @JsonIgnore
    public void  setDdlShichoson(DropDownList ddlShichoson) {
        this.getKoikiShichoson().setDdlShichoson(ddlShichoson);
    }

    @JsonIgnore
    public DropDownList getDdlKyushichosonKoiki() {
        return this.getKoikiShichoson().getDdlKyushichosonKoiki();
    }

    @JsonIgnore
    public void  setDdlKyushichosonKoiki(DropDownList ddlKyushichosonKoiki) {
        this.getKoikiShichoson().setDdlKyushichosonKoiki(ddlKyushichosonKoiki);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
