package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HokokuNendo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokokuNendoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokokuNendo")
    private DropDownList ddlHokokuNendo;
    @JsonProperty("lblHokokuYM")
    private Label lblHokokuYM;
    @JsonProperty("ddlShukeiFromYM")
    private DropDownList ddlShukeiFromYM;
    @JsonProperty("lblShukeiHani")
    private Label lblShukeiHani;
    @JsonProperty("ddlShukeiToYM")
    private DropDownList ddlShukeiToYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHokokuNendo
     * @return ddlHokokuNendo
     */
    @JsonProperty("ddlHokokuNendo")
    public DropDownList getDdlHokokuNendo() {
        return ddlHokokuNendo;
    }

    /*
     * setddlHokokuNendo
     * @param ddlHokokuNendo ddlHokokuNendo
     */
    @JsonProperty("ddlHokokuNendo")
    public void setDdlHokokuNendo(DropDownList ddlHokokuNendo) {
        this.ddlHokokuNendo = ddlHokokuNendo;
    }

    /*
     * getlblHokokuYM
     * @return lblHokokuYM
     */
    @JsonProperty("lblHokokuYM")
    public Label getLblHokokuYM() {
        return lblHokokuYM;
    }

    /*
     * setlblHokokuYM
     * @param lblHokokuYM lblHokokuYM
     */
    @JsonProperty("lblHokokuYM")
    public void setLblHokokuYM(Label lblHokokuYM) {
        this.lblHokokuYM = lblHokokuYM;
    }

    /*
     * getddlShukeiFromYM
     * @return ddlShukeiFromYM
     */
    @JsonProperty("ddlShukeiFromYM")
    public DropDownList getDdlShukeiFromYM() {
        return ddlShukeiFromYM;
    }

    /*
     * setddlShukeiFromYM
     * @param ddlShukeiFromYM ddlShukeiFromYM
     */
    @JsonProperty("ddlShukeiFromYM")
    public void setDdlShukeiFromYM(DropDownList ddlShukeiFromYM) {
        this.ddlShukeiFromYM = ddlShukeiFromYM;
    }

    /*
     * getlblShukeiHani
     * @return lblShukeiHani
     */
    @JsonProperty("lblShukeiHani")
    public Label getLblShukeiHani() {
        return lblShukeiHani;
    }

    /*
     * setlblShukeiHani
     * @param lblShukeiHani lblShukeiHani
     */
    @JsonProperty("lblShukeiHani")
    public void setLblShukeiHani(Label lblShukeiHani) {
        this.lblShukeiHani = lblShukeiHani;
    }

    /*
     * getddlShukeiToYM
     * @return ddlShukeiToYM
     */
    @JsonProperty("ddlShukeiToYM")
    public DropDownList getDdlShukeiToYM() {
        return ddlShukeiToYM;
    }

    /*
     * setddlShukeiToYM
     * @param ddlShukeiToYM ddlShukeiToYM
     */
    @JsonProperty("ddlShukeiToYM")
    public void setDdlShukeiToYM(DropDownList ddlShukeiToYM) {
        this.ddlShukeiToYM = ddlShukeiToYM;
    }

    // </editor-fold>
}
