package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1171011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * JikoFutanShomeishoSakusei のクラスファイル
 *
 * @reamsid_L DBC-2380-010 yuqingzhang
 */
public class JikoFutanShomeishoSakuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJikoFutangaku")
    private RadioButton radJikoFutangaku;
    @JsonProperty("txtZenkaiTaishoDate")
    private TextBoxDateRange txtZenkaiTaishoDate;
    @JsonProperty("txtShinseiDate")
    private TextBoxDateRange txtShinseiDate;
    @JsonProperty("radKokuhoren")
    private RadioButton radKokuhoren;
    @JsonProperty("txtUketoriDate")
    private TextBoxDate txtUketoriDate;
    @JsonProperty("spcInsho")
    private Space spcInsho;
    @JsonProperty("ddlInsho")
    private DropDownList ddlInsho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJikoFutangaku
     * @return radJikoFutangaku
     */
    @JsonProperty("radJikoFutangaku")
    public RadioButton getRadJikoFutangaku() {
        return radJikoFutangaku;
    }

    /*
     * setradJikoFutangaku
     * @param radJikoFutangaku radJikoFutangaku
     */
    @JsonProperty("radJikoFutangaku")
    public void setRadJikoFutangaku(RadioButton radJikoFutangaku) {
        this.radJikoFutangaku = radJikoFutangaku;
    }

    /*
     * gettxtZenkaiTaishoDate
     * @return txtZenkaiTaishoDate
     */
    @JsonProperty("txtZenkaiTaishoDate")
    public TextBoxDateRange getTxtZenkaiTaishoDate() {
        return txtZenkaiTaishoDate;
    }

    /*
     * settxtZenkaiTaishoDate
     * @param txtZenkaiTaishoDate txtZenkaiTaishoDate
     */
    @JsonProperty("txtZenkaiTaishoDate")
    public void setTxtZenkaiTaishoDate(TextBoxDateRange txtZenkaiTaishoDate) {
        this.txtZenkaiTaishoDate = txtZenkaiTaishoDate;
    }

    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxDateRange getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxDateRange txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * getradKokuhoren
     * @return radKokuhoren
     */
    @JsonProperty("radKokuhoren")
    public RadioButton getRadKokuhoren() {
        return radKokuhoren;
    }

    /*
     * setradKokuhoren
     * @param radKokuhoren radKokuhoren
     */
    @JsonProperty("radKokuhoren")
    public void setRadKokuhoren(RadioButton radKokuhoren) {
        this.radKokuhoren = radKokuhoren;
    }

    /*
     * gettxtUketoriDate
     * @return txtUketoriDate
     */
    @JsonProperty("txtUketoriDate")
    public TextBoxDate getTxtUketoriDate() {
        return txtUketoriDate;
    }

    /*
     * settxtUketoriDate
     * @param txtUketoriDate txtUketoriDate
     */
    @JsonProperty("txtUketoriDate")
    public void setTxtUketoriDate(TextBoxDate txtUketoriDate) {
        this.txtUketoriDate = txtUketoriDate;
    }

    /*
     * getspcInsho
     * @return spcInsho
     */
    @JsonProperty("spcInsho")
    public Space getSpcInsho() {
        return spcInsho;
    }

    /*
     * setspcInsho
     * @param spcInsho spcInsho
     */
    @JsonProperty("spcInsho")
    public void setSpcInsho(Space spcInsho) {
        this.spcInsho = spcInsho;
    }

    /*
     * getddlInsho
     * @return ddlInsho
     */
    @JsonProperty("ddlInsho")
    public DropDownList getDdlInsho() {
        return ddlInsho;
    }

    /*
     * setddlInsho
     * @param ddlInsho ddlInsho
     */
    @JsonProperty("ddlInsho")
    public void setDdlInsho(DropDownList ddlInsho) {
        this.ddlInsho = ddlInsho;
    }

    // </editor-fold>
}
