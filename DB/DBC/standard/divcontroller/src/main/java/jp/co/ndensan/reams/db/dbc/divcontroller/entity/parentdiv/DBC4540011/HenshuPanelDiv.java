package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4540011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * HenshuPanel のクラスファイル
 *
 * @reamsid_L DBC-3362-010 xuxin
 */
public class HenshuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnJikko")
    private Button btnJikko;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("txtFileNm")
    private TextBox txtFileNm;
    @JsonProperty("ddlBaitai")
    private DropDownList ddlBaitai;
    @JsonProperty("txtGaibuCSVFileNm")
    private TextBox txtGaibuCSVFileNm;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnJikko
     * @return btnJikko
     */
    @JsonProperty("btnJikko")
    public Button getBtnJikko() {
        return btnJikko;
    }

    /*
     * setbtnJikko
     * @param btnJikko btnJikko
     */
    @JsonProperty("btnJikko")
    public void setBtnJikko(Button btnJikko) {
        this.btnJikko = btnJikko;
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
     * gettxtFileNm
     * @return txtFileNm
     */
    @JsonProperty("txtFileNm")
    public TextBox getTxtFileNm() {
        return txtFileNm;
    }

    /*
     * settxtFileNm
     * @param txtFileNm txtFileNm
     */
    @JsonProperty("txtFileNm")
    public void setTxtFileNm(TextBox txtFileNm) {
        this.txtFileNm = txtFileNm;
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

    /*
     * gettxtGaibuCSVFileNm
     * @return txtGaibuCSVFileNm
     */
    @JsonProperty("txtGaibuCSVFileNm")
    public TextBox getTxtGaibuCSVFileNm() {
        return txtGaibuCSVFileNm;
    }

    /*
     * settxtGaibuCSVFileNm
     * @param txtGaibuCSVFileNm txtGaibuCSVFileNm
     */
    @JsonProperty("txtGaibuCSVFileNm")
    public void setTxtGaibuCSVFileNm(TextBox txtGaibuCSVFileNm) {
        this.txtGaibuCSVFileNm = txtGaibuCSVFileNm;
    }

    // </editor-fold>
}
