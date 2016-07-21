package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYearMonth;

/**
 * KyufuTaishoshaScheduleSettei のクラスファイル
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class KyufuTaishoshaScheduleSetteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgScheduleList")
    private DataGrid<dgScheduleList_Row> dgScheduleList;
    @JsonProperty("SaishinShoriNengetsuNyuryoku")
    private SaishinShoriNengetsuNyuryokuDiv SaishinShoriNengetsuNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgScheduleList
     * @return dgScheduleList
     */
    @JsonProperty("dgScheduleList")
    public DataGrid<dgScheduleList_Row> getDgScheduleList() {
        return dgScheduleList;
    }

    /*
     * setdgScheduleList
     * @param dgScheduleList dgScheduleList
     */
    @JsonProperty("dgScheduleList")
    public void setDgScheduleList(DataGrid<dgScheduleList_Row> dgScheduleList) {
        this.dgScheduleList = dgScheduleList;
    }

    /*
     * getSaishinShoriNengetsuNyuryoku
     * @return SaishinShoriNengetsuNyuryoku
     */
    @JsonProperty("SaishinShoriNengetsuNyuryoku")
    public SaishinShoriNengetsuNyuryokuDiv getSaishinShoriNengetsuNyuryoku() {
        return SaishinShoriNengetsuNyuryoku;
    }

    /*
     * setSaishinShoriNengetsuNyuryoku
     * @param SaishinShoriNengetsuNyuryoku SaishinShoriNengetsuNyuryoku
     */
    @JsonProperty("SaishinShoriNengetsuNyuryoku")
    public void setSaishinShoriNengetsuNyuryoku(SaishinShoriNengetsuNyuryokuDiv SaishinShoriNengetsuNyuryoku) {
        this.SaishinShoriNengetsuNyuryoku = SaishinShoriNengetsuNyuryoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtShoriNengetsu() {
        return this.getSaishinShoriNengetsuNyuryoku().getTxtShoriNengetsu();
    }

    @JsonIgnore
    public void setTxtShoriNengetsu(TextBoxFlexibleYearMonth txtShoriNengetsu) {
        this.getSaishinShoriNengetsuNyuryoku().setTxtShoriNengetsu(txtShoriNengetsu);
    }

    @JsonIgnore
    public Label getLblShinsaNengetsuKikan() {
        return this.getSaishinShoriNengetsuNyuryoku().getLblShinsaNengetsuKikan();
    }

    @JsonIgnore
    public void setLblShinsaNengetsuKikan(Label lblShinsaNengetsuKikan) {
        this.getSaishinShoriNengetsuNyuryoku().setLblShinsaNengetsuKikan(lblShinsaNengetsuKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtShinsaNengetsuFrom() {
        return this.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuFrom();
    }

    @JsonIgnore
    public void setTxtShinsaNengetsuFrom(TextBoxFlexibleYearMonth txtShinsaNengetsuFrom) {
        this.getSaishinShoriNengetsuNyuryoku().setTxtShinsaNengetsuFrom(txtShinsaNengetsuFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtShinsaNengetsuTo() {
        return this.getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuTo();
    }

    @JsonIgnore
    public void setTxtShinsaNengetsuTo(TextBoxFlexibleYearMonth txtShinsaNengetsuTo) {
        this.getSaishinShoriNengetsuNyuryoku().setTxtShinsaNengetsuTo(txtShinsaNengetsuTo);
    }

    @JsonIgnore
    public DropDownList getDdlShoriJokyo() {
        return this.getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo();
    }

    @JsonIgnore
    public void setDdlShoriJokyo(DropDownList ddlShoriJokyo) {
        this.getSaishinShoriNengetsuNyuryoku().setDdlShoriJokyo(ddlShoriJokyo);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getSaishinShoriNengetsuNyuryoku().getBtnKakutei();
    }

    @JsonIgnore
    public void setBtnKakutei(Button btnKakutei) {
        this.getSaishinShoriNengetsuNyuryoku().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getSaishinShoriNengetsuNyuryoku().getBtnTorikeshi();
    }

    @JsonIgnore
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.getSaishinShoriNengetsuNyuryoku().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
}
