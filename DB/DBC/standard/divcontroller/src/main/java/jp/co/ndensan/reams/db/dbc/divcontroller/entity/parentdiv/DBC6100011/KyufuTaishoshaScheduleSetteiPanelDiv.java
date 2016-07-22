package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYearMonth;

/**
 * KyufuTaishoshaScheduleSetteiPanel のクラスファイル
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class KyufuTaishoshaScheduleSetteiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuTaishoshaScheduleSettei")
    private KyufuTaishoshaScheduleSetteiDiv KyufuTaishoshaScheduleSettei;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;
    @JsonProperty("hdnFlag")
    private RString hdnFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufuTaishoshaScheduleSettei
     * @return KyufuTaishoshaScheduleSettei
     */
    @JsonProperty("KyufuTaishoshaScheduleSettei")
    public KyufuTaishoshaScheduleSetteiDiv getKyufuTaishoshaScheduleSettei() {
        return KyufuTaishoshaScheduleSettei;
    }

    /*
     * setKyufuTaishoshaScheduleSettei
     * @param KyufuTaishoshaScheduleSettei KyufuTaishoshaScheduleSettei
     */
    @JsonProperty("KyufuTaishoshaScheduleSettei")
    public void setKyufuTaishoshaScheduleSettei(KyufuTaishoshaScheduleSetteiDiv KyufuTaishoshaScheduleSettei) {
        this.KyufuTaishoshaScheduleSettei = KyufuTaishoshaScheduleSettei;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * gethdnFlag
     * @return hdnFlag
     */
    @JsonProperty("hdnFlag")
    public RString getHdnFlag() {
        return hdnFlag;
    }

    /*
     * sethdnFlag
     * @param hdnFlag hdnFlag
     */
    @JsonProperty("hdnFlag")
    public void setHdnFlag(RString hdnFlag) {
        this.hdnFlag = hdnFlag;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getKyufuTaishoshaScheduleSettei().getBtnAdd();
    }

    @JsonIgnore
    public void setBtnAdd(Button btnAdd) {
        this.getKyufuTaishoshaScheduleSettei().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgScheduleList_Row> getDgScheduleList() {
        return this.getKyufuTaishoshaScheduleSettei().getDgScheduleList();
    }

    @JsonIgnore
    public void setDgScheduleList(DataGrid<dgScheduleList_Row> dgScheduleList) {
        this.getKyufuTaishoshaScheduleSettei().setDgScheduleList(dgScheduleList);
    }

    @JsonIgnore
    public SaishinShoriNengetsuNyuryokuDiv getSaishinShoriNengetsuNyuryoku() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku();
    }

    @JsonIgnore
    public void setSaishinShoriNengetsuNyuryoku(SaishinShoriNengetsuNyuryokuDiv SaishinShoriNengetsuNyuryoku) {
        this.getKyufuTaishoshaScheduleSettei().setSaishinShoriNengetsuNyuryoku(SaishinShoriNengetsuNyuryoku);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtShoriNengetsu() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().getTxtShoriNengetsu();
    }

    @JsonIgnore
    public void setTxtShoriNengetsu(TextBoxFlexibleYearMonth txtShoriNengetsu) {
        this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().setTxtShoriNengetsu(txtShoriNengetsu);
    }

    @JsonIgnore
    public Label getLblShinsaNengetsuKikan() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().getLblShinsaNengetsuKikan();
    }

    @JsonIgnore
    public void setLblShinsaNengetsuKikan(Label lblShinsaNengetsuKikan) {
        this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().setLblShinsaNengetsuKikan(lblShinsaNengetsuKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtShinsaNengetsuFrom() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuFrom();
    }

    @JsonIgnore
    public void setTxtShinsaNengetsuFrom(TextBoxFlexibleYearMonth txtShinsaNengetsuFrom) {
        this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().setTxtShinsaNengetsuFrom(txtShinsaNengetsuFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtShinsaNengetsuTo() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().getTxtShinsaNengetsuTo();
    }

    @JsonIgnore
    public void setTxtShinsaNengetsuTo(TextBoxFlexibleYearMonth txtShinsaNengetsuTo) {
        this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().setTxtShinsaNengetsuTo(txtShinsaNengetsuTo);
    }

    @JsonIgnore
    public DropDownList getDdlShoriJokyo() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().getDdlShoriJokyo();
    }

    @JsonIgnore
    public void setDdlShoriJokyo(DropDownList ddlShoriJokyo) {
        this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().setDdlShoriJokyo(ddlShoriJokyo);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().getBtnKakutei();
    }

    @JsonIgnore
    public void setBtnKakutei(Button btnKakutei) {
        this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().getBtnTorikeshi();
    }

    @JsonIgnore
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.getKyufuTaishoshaScheduleSettei().getSaishinShoriNengetsuNyuryoku().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
}
