package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijyouDate")
    private TextBoxDate txtKijyouDate;
    @JsonProperty("radMeisaiGokeiOut")
    private RadioButton radMeisaiGokeiOut;
    @JsonProperty("panServiceSyurui")
    private panServiceSyuruiDiv panServiceSyurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijyouDate
     * @return txtKijyouDate
     */
    @JsonProperty("txtKijyouDate")
    public TextBoxDate getTxtKijyouDate() {
        return txtKijyouDate;
    }

    /*
     * settxtKijyouDate
     * @param txtKijyouDate txtKijyouDate
     */
    @JsonProperty("txtKijyouDate")
    public void setTxtKijyouDate(TextBoxDate txtKijyouDate) {
        this.txtKijyouDate = txtKijyouDate;
    }

    /*
     * getradMeisaiGokeiOut
     * @return radMeisaiGokeiOut
     */
    @JsonProperty("radMeisaiGokeiOut")
    public RadioButton getRadMeisaiGokeiOut() {
        return radMeisaiGokeiOut;
    }

    /*
     * setradMeisaiGokeiOut
     * @param radMeisaiGokeiOut radMeisaiGokeiOut
     */
    @JsonProperty("radMeisaiGokeiOut")
    public void setRadMeisaiGokeiOut(RadioButton radMeisaiGokeiOut) {
        this.radMeisaiGokeiOut = radMeisaiGokeiOut;
    }

    /*
     * getpanServiceSyurui
     * @return panServiceSyurui
     */
    @JsonProperty("panServiceSyurui")
    public panServiceSyuruiDiv getPanServiceSyurui() {
        return panServiceSyurui;
    }

    /*
     * setpanServiceSyurui
     * @param panServiceSyurui panServiceSyurui
     */
    @JsonProperty("panServiceSyurui")
    public void setPanServiceSyurui(panServiceSyuruiDiv panServiceSyurui) {
        this.panServiceSyurui = panServiceSyurui;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnServiceCode() {
        return this.getPanServiceSyurui().getBtnServiceCode();
    }

    @JsonIgnore
    public void setBtnServiceCode(ButtonDialog btnServiceCode) {
        this.getPanServiceSyurui().setBtnServiceCode(btnServiceCode);
    }

    @JsonIgnore
    public TextBoxCode getTxtSyuruiCode() {
        return this.getPanServiceSyurui().getTxtSyuruiCode();
    }

    @JsonIgnore
    public void setTxtSyuruiCode(TextBoxCode txtSyuruiCode) {
        this.getPanServiceSyurui().setTxtSyuruiCode(txtSyuruiCode);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode() {
        return this.getPanServiceSyurui().getTxtServiceCode();
    }

    @JsonIgnore
    public void setTxtServiceCode(TextBoxCode txtServiceCode) {
        this.getPanServiceSyurui().setTxtServiceCode(txtServiceCode);
    }

    @JsonIgnore
    public DataGrid<dgServiceShuruiList_Row> getDgServiceShuruiList() {
        return this.getPanServiceSyurui().getDgServiceShuruiList();
    }

    @JsonIgnore
    public void setDgServiceShuruiList(DataGrid<dgServiceShuruiList_Row> dgServiceShuruiList) {
        this.getPanServiceSyurui().setDgServiceShuruiList(dgServiceShuruiList);
    }

    // </editor-fold>
}
