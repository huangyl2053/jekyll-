package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * ChushutsuJoken2 のクラスファイル
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class ChushutsuJoken2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lbl01")
    private Label lbl01;
    @JsonProperty("chkSelectKyotaku")
    private Button chkSelectKyotaku;
    @JsonProperty("btnSelectShisetsu")
    private Button btnSelectShisetsu;
    @JsonProperty("dgServiceShuruiList")
    private DataGrid<dgServiceShuruiList_Row> dgServiceShuruiList;
    @JsonProperty("txtServiceKomokuCode1")
    private TextBox txtServiceKomokuCode1;
    @JsonProperty("txtServiceKomokuCode2")
    private TextBox txtServiceKomokuCode2;
    @JsonProperty("txtServiceKomokuCode3")
    private TextBox txtServiceKomokuCode3;
    @JsonProperty("txtServiceKomokuCode4")
    private TextBox txtServiceKomokuCode4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlbl01
     * @return lbl01
     */
    @JsonProperty("lbl01")
    public Label getLbl01() {
        return lbl01;
    }

    /*
     * setlbl01
     * @param lbl01 lbl01
     */
    @JsonProperty("lbl01")
    public void setLbl01(Label lbl01) {
        this.lbl01 = lbl01;
    }

    /*
     * getchkSelectKyotaku
     * @return chkSelectKyotaku
     */
    @JsonProperty("chkSelectKyotaku")
    public Button getChkSelectKyotaku() {
        return chkSelectKyotaku;
    }

    /*
     * setchkSelectKyotaku
     * @param chkSelectKyotaku chkSelectKyotaku
     */
    @JsonProperty("chkSelectKyotaku")
    public void setChkSelectKyotaku(Button chkSelectKyotaku) {
        this.chkSelectKyotaku = chkSelectKyotaku;
    }

    /*
     * getbtnSelectShisetsu
     * @return btnSelectShisetsu
     */
    @JsonProperty("btnSelectShisetsu")
    public Button getBtnSelectShisetsu() {
        return btnSelectShisetsu;
    }

    /*
     * setbtnSelectShisetsu
     * @param btnSelectShisetsu btnSelectShisetsu
     */
    @JsonProperty("btnSelectShisetsu")
    public void setBtnSelectShisetsu(Button btnSelectShisetsu) {
        this.btnSelectShisetsu = btnSelectShisetsu;
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

    /*
     * gettxtServiceKomokuCode1
     * @return txtServiceKomokuCode1
     */
    @JsonProperty("txtServiceKomokuCode1")
    public TextBox getTxtServiceKomokuCode1() {
        return txtServiceKomokuCode1;
    }

    /*
     * settxtServiceKomokuCode1
     * @param txtServiceKomokuCode1 txtServiceKomokuCode1
     */
    @JsonProperty("txtServiceKomokuCode1")
    public void setTxtServiceKomokuCode1(TextBox txtServiceKomokuCode1) {
        this.txtServiceKomokuCode1 = txtServiceKomokuCode1;
    }

    /*
     * gettxtServiceKomokuCode2
     * @return txtServiceKomokuCode2
     */
    @JsonProperty("txtServiceKomokuCode2")
    public TextBox getTxtServiceKomokuCode2() {
        return txtServiceKomokuCode2;
    }

    /*
     * settxtServiceKomokuCode2
     * @param txtServiceKomokuCode2 txtServiceKomokuCode2
     */
    @JsonProperty("txtServiceKomokuCode2")
    public void setTxtServiceKomokuCode2(TextBox txtServiceKomokuCode2) {
        this.txtServiceKomokuCode2 = txtServiceKomokuCode2;
    }

    /*
     * gettxtServiceKomokuCode3
     * @return txtServiceKomokuCode3
     */
    @JsonProperty("txtServiceKomokuCode3")
    public TextBox getTxtServiceKomokuCode3() {
        return txtServiceKomokuCode3;
    }

    /*
     * settxtServiceKomokuCode3
     * @param txtServiceKomokuCode3 txtServiceKomokuCode3
     */
    @JsonProperty("txtServiceKomokuCode3")
    public void setTxtServiceKomokuCode3(TextBox txtServiceKomokuCode3) {
        this.txtServiceKomokuCode3 = txtServiceKomokuCode3;
    }

    /*
     * gettxtServiceKomokuCode4
     * @return txtServiceKomokuCode4
     */
    @JsonProperty("txtServiceKomokuCode4")
    public TextBox getTxtServiceKomokuCode4() {
        return txtServiceKomokuCode4;
    }

    /*
     * settxtServiceKomokuCode4
     * @param txtServiceKomokuCode4 txtServiceKomokuCode4
     */
    @JsonProperty("txtServiceKomokuCode4")
    public void setTxtServiceKomokuCode4(TextBox txtServiceKomokuCode4) {
        this.txtServiceKomokuCode4 = txtServiceKomokuCode4;
    }

    // </editor-fold>
}
