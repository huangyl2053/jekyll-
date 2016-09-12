package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * KokuhorenSofuBaitaiShijiPanel のクラスファイル
 *
 * @reamsid_L DBC-3362-010 xuxin
 */
public class KokuhorenSofuBaitaiShijiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKokuhorenSofuBaitaiShiji")
    private DataGrid<dgKokuhorenSofuBaitaiShiji_Row> dgKokuhorenSofuBaitaiShiji;
    @JsonProperty("HenshuPanel")
    private HenshuPanelDiv HenshuPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKokuhorenSofuBaitaiShiji
     * @return dgKokuhorenSofuBaitaiShiji
     */
    @JsonProperty("dgKokuhorenSofuBaitaiShiji")
    public DataGrid<dgKokuhorenSofuBaitaiShiji_Row> getDgKokuhorenSofuBaitaiShiji() {
        return dgKokuhorenSofuBaitaiShiji;
    }

    /*
     * setdgKokuhorenSofuBaitaiShiji
     * @param dgKokuhorenSofuBaitaiShiji dgKokuhorenSofuBaitaiShiji
     */
    @JsonProperty("dgKokuhorenSofuBaitaiShiji")
    public void setDgKokuhorenSofuBaitaiShiji(DataGrid<dgKokuhorenSofuBaitaiShiji_Row> dgKokuhorenSofuBaitaiShiji) {
        this.dgKokuhorenSofuBaitaiShiji = dgKokuhorenSofuBaitaiShiji;
    }

    /*
     * getHenshuPanel
     * @return HenshuPanel
     */
    @JsonProperty("HenshuPanel")
    public HenshuPanelDiv getHenshuPanel() {
        return HenshuPanel;
    }

    /*
     * setHenshuPanel
     * @param HenshuPanel HenshuPanel
     */
    @JsonProperty("HenshuPanel")
    public void setHenshuPanel(HenshuPanelDiv HenshuPanel) {
        this.HenshuPanel = HenshuPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnJikko() {
        return this.getHenshuPanel().getBtnJikko();
    }

    @JsonIgnore
    public void setBtnJikko(Button btnJikko) {
        this.getHenshuPanel().setBtnJikko(btnJikko);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getHenshuPanel().getBtnTorikeshi();
    }

    @JsonIgnore
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.getHenshuPanel().setBtnTorikeshi(btnTorikeshi);
    }

    @JsonIgnore
    public TextBox getTxtFileNm() {
        return this.getHenshuPanel().getTxtFileNm();
    }

    @JsonIgnore
    public void setTxtFileNm(TextBox txtFileNm) {
        this.getHenshuPanel().setTxtFileNm(txtFileNm);
    }

    @JsonIgnore
    public DropDownList getDdlBaitai() {
        return this.getHenshuPanel().getDdlBaitai();
    }

    @JsonIgnore
    public void setDdlBaitai(DropDownList ddlBaitai) {
        this.getHenshuPanel().setDdlBaitai(ddlBaitai);
    }

    @JsonIgnore
    public TextBox getTxtGaibuCSVFileNm() {
        return this.getHenshuPanel().getTxtGaibuCSVFileNm();
    }

    @JsonIgnore
    public void setTxtGaibuCSVFileNm(TextBox txtGaibuCSVFileNm) {
        this.getHenshuPanel().setTxtGaibuCSVFileNm(txtGaibuCSVFileNm);
    }

    // </editor-fold>
}
