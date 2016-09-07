package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * TyuusyutuHanni のクラスファイル
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class TyuusyutuHanniDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZennkaiTaisyouNenngappi")
    private TextBoxDateRange txtZennkaiTaisyouNenngappi;
    @JsonProperty("txtKonnkaiTaisyouNenngappi")
    private TextBoxDateRange txtKonnkaiTaisyouNenngappi;
    @JsonProperty("ddlHakkouTaisyou")
    private DropDownList ddlHakkouTaisyou;
    @JsonProperty("txt")
    private TextBoxDate txt;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZennkaiTaisyouNenngappi
     * @return txtZennkaiTaisyouNenngappi
     */
    @JsonProperty("txtZennkaiTaisyouNenngappi")
    public TextBoxDateRange getTxtZennkaiTaisyouNenngappi() {
        return txtZennkaiTaisyouNenngappi;
    }

    /*
     * settxtZennkaiTaisyouNenngappi
     * @param txtZennkaiTaisyouNenngappi txtZennkaiTaisyouNenngappi
     */
    @JsonProperty("txtZennkaiTaisyouNenngappi")
    public void setTxtZennkaiTaisyouNenngappi(TextBoxDateRange txtZennkaiTaisyouNenngappi) {
        this.txtZennkaiTaisyouNenngappi = txtZennkaiTaisyouNenngappi;
    }

    /*
     * gettxtKonnkaiTaisyouNenngappi
     * @return txtKonnkaiTaisyouNenngappi
     */
    @JsonProperty("txtKonnkaiTaisyouNenngappi")
    public TextBoxDateRange getTxtKonnkaiTaisyouNenngappi() {
        return txtKonnkaiTaisyouNenngappi;
    }

    /*
     * settxtKonnkaiTaisyouNenngappi
     * @param txtKonnkaiTaisyouNenngappi txtKonnkaiTaisyouNenngappi
     */
    @JsonProperty("txtKonnkaiTaisyouNenngappi")
    public void setTxtKonnkaiTaisyouNenngappi(TextBoxDateRange txtKonnkaiTaisyouNenngappi) {
        this.txtKonnkaiTaisyouNenngappi = txtKonnkaiTaisyouNenngappi;
    }

    /*
     * getddlHakkouTaisyou
     * @return ddlHakkouTaisyou
     */
    @JsonProperty("ddlHakkouTaisyou")
    public DropDownList getDdlHakkouTaisyou() {
        return ddlHakkouTaisyou;
    }

    /*
     * setddlHakkouTaisyou
     * @param ddlHakkouTaisyou ddlHakkouTaisyou
     */
    @JsonProperty("ddlHakkouTaisyou")
    public void setDdlHakkouTaisyou(DropDownList ddlHakkouTaisyou) {
        this.ddlHakkouTaisyou = ddlHakkouTaisyou;
    }

    /*
     * gettxt
     * @return txt
     */
    @JsonProperty("txt")
    public TextBoxDate getTxt() {
        return txt;
    }

    /*
     * settxt
     * @param txt txt
     */
    @JsonProperty("txt")
    public void setTxt(TextBoxDate txt) {
        this.txt = txt;
    }

    // </editor-fold>
}
