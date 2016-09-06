package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * panServiceSyurui のクラスファイル
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class panServiceSyuruiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnServiceCode")
    private ButtonDialog btnServiceCode;
    @JsonProperty("txtSyuruiCode")
    private TextBoxCode txtSyuruiCode;
    @JsonProperty("txtServiceCode")
    private TextBoxCode txtServiceCode;
    @JsonProperty("dgServiceShuruiList")
    private DataGrid<dgServiceShuruiList_Row> dgServiceShuruiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnServiceCode
     * @return btnServiceCode
     */
    @JsonProperty("btnServiceCode")
    public ButtonDialog getBtnServiceCode() {
        return btnServiceCode;
    }

    /*
     * setbtnServiceCode
     * @param btnServiceCode btnServiceCode
     */
    @JsonProperty("btnServiceCode")
    public void setBtnServiceCode(ButtonDialog btnServiceCode) {
        this.btnServiceCode = btnServiceCode;
    }

    /*
     * gettxtSyuruiCode
     * @return txtSyuruiCode
     */
    @JsonProperty("txtSyuruiCode")
    public TextBoxCode getTxtSyuruiCode() {
        return txtSyuruiCode;
    }

    /*
     * settxtSyuruiCode
     * @param txtSyuruiCode txtSyuruiCode
     */
    @JsonProperty("txtSyuruiCode")
    public void setTxtSyuruiCode(TextBoxCode txtSyuruiCode) {
        this.txtSyuruiCode = txtSyuruiCode;
    }

    /*
     * gettxtServiceCode
     * @return txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public TextBoxCode getTxtServiceCode() {
        return txtServiceCode;
    }

    /*
     * settxtServiceCode
     * @param txtServiceCode txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public void setTxtServiceCode(TextBoxCode txtServiceCode) {
        this.txtServiceCode = txtServiceCode;
    }

    /*
     * getdgServiceShuruiList
     * @return dgServiceShuruiList
     */
    @JsonProperty("dgServiceShuruiList")
    public DataGrid<dgServiceShuruiList_Row> getDgServiceShuruiList() {
        return dgServiceShuruiList;
    }

    /*
     * setdgServiceShuruiList
     * @param dgServiceShuruiList dgServiceShuruiList
     */
    @JsonProperty("dgServiceShuruiList")
    public void setDgServiceShuruiList(DataGrid<dgServiceShuruiList_Row> dgServiceShuruiList) {
        this.dgServiceShuruiList = dgServiceShuruiList;
    }

    // </editor-fold>
}
