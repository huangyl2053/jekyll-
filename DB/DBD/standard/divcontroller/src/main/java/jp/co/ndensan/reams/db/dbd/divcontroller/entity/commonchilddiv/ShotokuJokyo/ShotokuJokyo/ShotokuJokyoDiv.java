package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShotokuJokyo.ShotokuJokyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuJokyoDiv extends Panel implements IShotokuJokyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiKijunYMD")
    private TextBoxDate txtSetaiKijunYMD;
    @JsonProperty("ddShotokuNendo")
    private DropDownList ddShotokuNendo;
    @JsonProperty("btnSaiHyoji")
    private Button btnSaiHyoji;
    @JsonProperty("dgSetaiShotoku")
    private DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku;
    @JsonProperty("btnRirekiClose")
    private Button btnRirekiClose;
    @JsonProperty("txtShikibetsuCode")
    private RString txtShikibetsuCode;
    @JsonProperty("txtShotokuKijunYMDHMS")
    private RString txtShotokuKijunYMDHMS;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetaiKijunYMD
     * @return txtSetaiKijunYMD
     */
    @JsonProperty("txtSetaiKijunYMD")
    public TextBoxDate getTxtSetaiKijunYMD() {
        return txtSetaiKijunYMD;
    }

    /*
     * settxtSetaiKijunYMD
     * @param txtSetaiKijunYMD txtSetaiKijunYMD
     */
    @JsonProperty("txtSetaiKijunYMD")
    public void setTxtSetaiKijunYMD(TextBoxDate txtSetaiKijunYMD) {
        this.txtSetaiKijunYMD = txtSetaiKijunYMD;
    }

    /*
     * getddShotokuNendo
     * @return ddShotokuNendo
     */
    @JsonProperty("ddShotokuNendo")
    public DropDownList getDdShotokuNendo() {
        return ddShotokuNendo;
    }

    /*
     * setddShotokuNendo
     * @param ddShotokuNendo ddShotokuNendo
     */
    @JsonProperty("ddShotokuNendo")
    public void setDdShotokuNendo(DropDownList ddShotokuNendo) {
        this.ddShotokuNendo = ddShotokuNendo;
    }

    /*
     * getbtnSaiHyoji
     * @return btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public Button getBtnSaiHyoji() {
        return btnSaiHyoji;
    }

    /*
     * setbtnSaiHyoji
     * @param btnSaiHyoji btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public void setBtnSaiHyoji(Button btnSaiHyoji) {
        this.btnSaiHyoji = btnSaiHyoji;
    }

    /*
     * getdgSetaiShotoku
     * @return dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public DataGrid<dgSetaiShotoku_Row> getDgSetaiShotoku() {
        return dgSetaiShotoku;
    }

    /*
     * setdgSetaiShotoku
     * @param dgSetaiShotoku dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public void setDgSetaiShotoku(DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku) {
        this.dgSetaiShotoku = dgSetaiShotoku;
    }

    /*
     * getbtnRirekiClose
     * @return btnRirekiClose
     */
    @JsonProperty("btnRirekiClose")
    public Button getBtnRirekiClose() {
        return btnRirekiClose;
    }

    /*
     * setbtnRirekiClose
     * @param btnRirekiClose btnRirekiClose
     */
    @JsonProperty("btnRirekiClose")
    public void setBtnRirekiClose(Button btnRirekiClose) {
        this.btnRirekiClose = btnRirekiClose;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShotokuKijunYMDHMS
     * @return txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public RString getTxtShotokuKijunYMDHMS() {
        return txtShotokuKijunYMDHMS;
    }

    /*
     * settxtShotokuKijunYMDHMS
     * @param txtShotokuKijunYMDHMS txtShotokuKijunYMDHMS
     */
    @JsonProperty("txtShotokuKijunYMDHMS")
    public void setTxtShotokuKijunYMDHMS(RString txtShotokuKijunYMDHMS) {
        this.txtShotokuKijunYMDHMS = txtShotokuKijunYMDHMS;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
