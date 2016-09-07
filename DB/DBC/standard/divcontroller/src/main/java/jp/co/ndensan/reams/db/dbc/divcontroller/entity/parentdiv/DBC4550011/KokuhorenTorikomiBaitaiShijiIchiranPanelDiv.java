package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4550011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KokuhorenTorikomiBaitaiShijiIchiranPanel のクラスファイル
 *
 * @reamsid_L DBC-3361-010 xuxin
 */
public class KokuhorenTorikomiBaitaiShijiIchiranPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKokuhorenTorikomiBaitaiShijiIchiran")
    private DataGrid<dgKokuhorenTorikomiBaitaiShijiIchiran_Row> dgKokuhorenTorikomiBaitaiShijiIchiran;
    @JsonProperty("btnjikko")
    private Button btnjikko;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("txtFileMeisho")
    private TextBox txtFileMeisho;
    @JsonProperty("ddlBaitai")
    private DropDownList ddlBaitai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKokuhorenTorikomiBaitaiShijiIchiran
     * @return dgKokuhorenTorikomiBaitaiShijiIchiran
     */
    @JsonProperty("dgKokuhorenTorikomiBaitaiShijiIchiran")
    public DataGrid<dgKokuhorenTorikomiBaitaiShijiIchiran_Row> getDgKokuhorenTorikomiBaitaiShijiIchiran() {
        return dgKokuhorenTorikomiBaitaiShijiIchiran;
    }

    /*
     * setdgKokuhorenTorikomiBaitaiShijiIchiran
     * @param dgKokuhorenTorikomiBaitaiShijiIchiran dgKokuhorenTorikomiBaitaiShijiIchiran
     */
    @JsonProperty("dgKokuhorenTorikomiBaitaiShijiIchiran")
    public void setDgKokuhorenTorikomiBaitaiShijiIchiran(DataGrid<dgKokuhorenTorikomiBaitaiShijiIchiran_Row> dgKokuhorenTorikomiBaitaiShijiIchiran) {
        this.dgKokuhorenTorikomiBaitaiShijiIchiran = dgKokuhorenTorikomiBaitaiShijiIchiran;
    }

    /*
     * getbtnjikko
     * @return btnjikko
     */
    @JsonProperty("btnjikko")
    public Button getBtnjikko() {
        return btnjikko;
    }

    /*
     * setbtnjikko
     * @param btnjikko btnjikko
     */
    @JsonProperty("btnjikko")
    public void setBtnjikko(Button btnjikko) {
        this.btnjikko = btnjikko;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * gettxtFileMeisho
     * @return txtFileMeisho
     */
    @JsonProperty("txtFileMeisho")
    public TextBox getTxtFileMeisho() {
        return txtFileMeisho;
    }

    /*
     * settxtFileMeisho
     * @param txtFileMeisho txtFileMeisho
     */
    @JsonProperty("txtFileMeisho")
    public void setTxtFileMeisho(TextBox txtFileMeisho) {
        this.txtFileMeisho = txtFileMeisho;
    }

    /*
     * getddlBaitai
     * @return ddlBaitai
     */
    @JsonProperty("ddlBaitai")
    public DropDownList getDdlBaitai() {
        return ddlBaitai;
    }

    /*
     * setddlBaitai
     * @param ddlBaitai ddlBaitai
     */
    @JsonProperty("ddlBaitai")
    public void setDdlBaitai(DropDownList ddlBaitai) {
        this.ddlBaitai = ddlBaitai;
    }

    // </editor-fold>
}
