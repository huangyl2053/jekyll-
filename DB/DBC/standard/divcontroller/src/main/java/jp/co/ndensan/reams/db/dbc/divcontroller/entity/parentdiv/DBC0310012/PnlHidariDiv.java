package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlHidari のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlHidariDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKeyakuNo")
    private Label lblKeyakuNo;
    @JsonProperty("ddlYear")
    private DropDownList ddlYear;
    @JsonProperty("txtBango1")
    private TextBoxNum txtBango1;
    @JsonProperty("txtBango2")
    private TextBoxCode txtBango2;
    @JsonProperty("txtSyoninkikan")
    private TextBoxDateRange txtSyoninkikan;
    @JsonProperty("txtSyoninchutisyosakuseibi")
    private TextBoxDate txtSyoninchutisyosakuseibi;
    @JsonProperty("chkSaihakoukubun")
    private CheckBoxList chkSaihakoukubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKeyakuNo
     * @return lblKeyakuNo
     */
    @JsonProperty("lblKeyakuNo")
    public Label getLblKeyakuNo() {
        return lblKeyakuNo;
    }

    /*
     * setlblKeyakuNo
     * @param lblKeyakuNo lblKeyakuNo
     */
    @JsonProperty("lblKeyakuNo")
    public void setLblKeyakuNo(Label lblKeyakuNo) {
        this.lblKeyakuNo = lblKeyakuNo;
    }

    /*
     * getddlYear
     * @return ddlYear
     */
    @JsonProperty("ddlYear")
    public DropDownList getDdlYear() {
        return ddlYear;
    }

    /*
     * setddlYear
     * @param ddlYear ddlYear
     */
    @JsonProperty("ddlYear")
    public void setDdlYear(DropDownList ddlYear) {
        this.ddlYear = ddlYear;
    }

    /*
     * gettxtBango1
     * @return txtBango1
     */
    @JsonProperty("txtBango1")
    public TextBoxNum getTxtBango1() {
        return txtBango1;
    }

    /*
     * settxtBango1
     * @param txtBango1 txtBango1
     */
    @JsonProperty("txtBango1")
    public void setTxtBango1(TextBoxNum txtBango1) {
        this.txtBango1 = txtBango1;
    }

    /*
     * gettxtBango2
     * @return txtBango2
     */
    @JsonProperty("txtBango2")
    public TextBoxCode getTxtBango2() {
        return txtBango2;
    }

    /*
     * settxtBango2
     * @param txtBango2 txtBango2
     */
    @JsonProperty("txtBango2")
    public void setTxtBango2(TextBoxCode txtBango2) {
        this.txtBango2 = txtBango2;
    }

    /*
     * gettxtSyoninkikan
     * @return txtSyoninkikan
     */
    @JsonProperty("txtSyoninkikan")
    public TextBoxDateRange getTxtSyoninkikan() {
        return txtSyoninkikan;
    }

    /*
     * settxtSyoninkikan
     * @param txtSyoninkikan txtSyoninkikan
     */
    @JsonProperty("txtSyoninkikan")
    public void setTxtSyoninkikan(TextBoxDateRange txtSyoninkikan) {
        this.txtSyoninkikan = txtSyoninkikan;
    }

    /*
     * gettxtSyoninchutisyosakuseibi
     * @return txtSyoninchutisyosakuseibi
     */
    @JsonProperty("txtSyoninchutisyosakuseibi")
    public TextBoxDate getTxtSyoninchutisyosakuseibi() {
        return txtSyoninchutisyosakuseibi;
    }

    /*
     * settxtSyoninchutisyosakuseibi
     * @param txtSyoninchutisyosakuseibi txtSyoninchutisyosakuseibi
     */
    @JsonProperty("txtSyoninchutisyosakuseibi")
    public void setTxtSyoninchutisyosakuseibi(TextBoxDate txtSyoninchutisyosakuseibi) {
        this.txtSyoninchutisyosakuseibi = txtSyoninchutisyosakuseibi;
    }

    /*
     * getchkSaihakoukubun
     * @return chkSaihakoukubun
     */
    @JsonProperty("chkSaihakoukubun")
    public CheckBoxList getChkSaihakoukubun() {
        return chkSaihakoukubun;
    }

    /*
     * setchkSaihakoukubun
     * @param chkSaihakoukubun chkSaihakoukubun
     */
    @JsonProperty("chkSaihakoukubun")
    public void setChkSaihakoukubun(CheckBoxList chkSaihakoukubun) {
        this.chkSaihakoukubun = chkSaihakoukubun;
    }

    // </editor-fold>
}
