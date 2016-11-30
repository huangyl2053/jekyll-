package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1170011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * JikoFutanShomeishoSakuseiPrint のクラスファイル
 *
 * @author 自動生成
 */
public class JikoFutanShomeishoSakuseiPrintDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("ddlShikyuShinseishoSeiriNo")
    private DropDownList ddlShikyuShinseishoSeiriNo;
    @JsonProperty("txtJikoFutangakuShomeishoSeiriNo")
    private TextBox txtJikoFutangakuShomeishoSeiriNo;
    @JsonProperty("linHakkoJoho")
    private HorizontalLine linHakkoJoho;
    @JsonProperty("txtHakkoDate")
    private TextBoxFlexibleDate txtHakkoDate;
    @JsonProperty("txtZenkaiHakkoDate")
    private TextBoxFlexibleDate txtZenkaiHakkoDate;
    @JsonProperty("ccdBunshoNo")
    private BunshoBangoInputDiv ccdBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTaishoNendo
     * @return ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public DropDownList getDdlTaishoNendo() {
        return ddlTaishoNendo;
    }

    /*
     * setddlTaishoNendo
     * @param ddlTaishoNendo ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.ddlTaishoNendo = ddlTaishoNendo;
    }

    /*
     * getddlShikyuShinseishoSeiriNo
     * @return ddlShikyuShinseishoSeiriNo
     */
    @JsonProperty("ddlShikyuShinseishoSeiriNo")
    public DropDownList getDdlShikyuShinseishoSeiriNo() {
        return ddlShikyuShinseishoSeiriNo;
    }

    /*
     * setddlShikyuShinseishoSeiriNo
     * @param ddlShikyuShinseishoSeiriNo ddlShikyuShinseishoSeiriNo
     */
    @JsonProperty("ddlShikyuShinseishoSeiriNo")
    public void setDdlShikyuShinseishoSeiriNo(DropDownList ddlShikyuShinseishoSeiriNo) {
        this.ddlShikyuShinseishoSeiriNo = ddlShikyuShinseishoSeiriNo;
    }

    /*
     * gettxtJikoFutangakuShomeishoSeiriNo
     * @return txtJikoFutangakuShomeishoSeiriNo
     */
    @JsonProperty("txtJikoFutangakuShomeishoSeiriNo")
    public TextBox getTxtJikoFutangakuShomeishoSeiriNo() {
        return txtJikoFutangakuShomeishoSeiriNo;
    }

    /*
     * settxtJikoFutangakuShomeishoSeiriNo
     * @param txtJikoFutangakuShomeishoSeiriNo txtJikoFutangakuShomeishoSeiriNo
     */
    @JsonProperty("txtJikoFutangakuShomeishoSeiriNo")
    public void setTxtJikoFutangakuShomeishoSeiriNo(TextBox txtJikoFutangakuShomeishoSeiriNo) {
        this.txtJikoFutangakuShomeishoSeiriNo = txtJikoFutangakuShomeishoSeiriNo;
    }

    /*
     * getlinHakkoJoho
     * @return linHakkoJoho
     */
    @JsonProperty("linHakkoJoho")
    public HorizontalLine getLinHakkoJoho() {
        return linHakkoJoho;
    }

    /*
     * setlinHakkoJoho
     * @param linHakkoJoho linHakkoJoho
     */
    @JsonProperty("linHakkoJoho")
    public void setLinHakkoJoho(HorizontalLine linHakkoJoho) {
        this.linHakkoJoho = linHakkoJoho;
    }

    /*
     * gettxtHakkoDate
     * @return txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public TextBoxFlexibleDate getTxtHakkoDate() {
        return txtHakkoDate;
    }

    /*
     * settxtHakkoDate
     * @param txtHakkoDate txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public void setTxtHakkoDate(TextBoxFlexibleDate txtHakkoDate) {
        this.txtHakkoDate = txtHakkoDate;
    }

    /*
     * gettxtZenkaiHakkoDate
     * @return txtZenkaiHakkoDate
     */
    @JsonProperty("txtZenkaiHakkoDate")
    public TextBoxFlexibleDate getTxtZenkaiHakkoDate() {
        return txtZenkaiHakkoDate;
    }

    /*
     * settxtZenkaiHakkoDate
     * @param txtZenkaiHakkoDate txtZenkaiHakkoDate
     */
    @JsonProperty("txtZenkaiHakkoDate")
    public void setTxtZenkaiHakkoDate(TextBoxFlexibleDate txtZenkaiHakkoDate) {
        this.txtZenkaiHakkoDate = txtZenkaiHakkoDate;
    }

    /*
     * getccdBunshoNo
     * @return ccdBunshoNo
     */
    @JsonProperty("ccdBunshoNo")
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return ccdBunshoNo;
    }

    // </editor-fold>
}
