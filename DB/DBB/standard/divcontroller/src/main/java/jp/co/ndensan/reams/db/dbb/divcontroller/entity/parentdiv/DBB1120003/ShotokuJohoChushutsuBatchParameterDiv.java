package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShotokuJohoChushutsuBatchParameter のクラスファイル
 *
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public class ShotokuJohoChushutsuBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriNendo")
    private TextBoxDate txtShoriNendo;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ShichosonIchiran")
    private ShichosonIchiranDiv ShichosonIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriNendo
     * @return txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public TextBoxDate getTxtShoriNendo() {
        return txtShoriNendo;
    }

    /*
     * settxtShoriNendo
     * @param txtShoriNendo txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public void setTxtShoriNendo(TextBoxDate txtShoriNendo) {
        this.txtShoriNendo = txtShoriNendo;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getShichosonIchiran
     * @return ShichosonIchiran
     */
    @JsonProperty("ShichosonIchiran")
    public ShichosonIchiranDiv getShichosonIchiran() {
        return ShichosonIchiran;
    }

    /*
     * setShichosonIchiran
     * @param ShichosonIchiran ShichosonIchiran
     */
    @JsonProperty("ShichosonIchiran")
    public void setShichosonIchiran(ShichosonIchiranDiv ShichosonIchiran) {
        this.ShichosonIchiran = ShichosonIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<DataGrid1_Row> getDataGrid1() {
        return this.getShichosonIchiran().getDataGrid1();
    }

    @JsonIgnore
    public void setDataGrid1(DataGrid<DataGrid1_Row> DataGrid1) {
        this.getShichosonIchiran().setDataGrid1(DataGrid1);
    }

    // </editor-fold>
}
