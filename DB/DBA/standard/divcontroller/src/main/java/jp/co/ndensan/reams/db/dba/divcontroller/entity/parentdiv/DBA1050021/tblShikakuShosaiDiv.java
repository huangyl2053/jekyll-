package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblShikakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblShikakuShosaiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celShutokuDate")
    private celShutokuDateAttblShikakuShosai celShutokuDate;
    @JsonProperty("celShutokuTodokedeDate")
    private celShutokuTodokedeDateAttblShikakuShosai celShutokuTodokedeDate;
    @JsonProperty("celShutokuJiyu")
    private celShutokuJiyuAttblShikakuShosai celShutokuJiyu;
    @JsonProperty("celHihoKubun")
    private celHihoKubunAttblShikakuShosai celHihoKubun;
    @JsonProperty("celShutokuShozaiHokensha")
    private celShutokuShozaiHokenshaAttblShikakuShosai celShutokuShozaiHokensha;
    @JsonProperty("celShutokuSochimotoHokensha")
    private celShutokuSochimotoHokenshaAttblShikakuShosai celShutokuSochimotoHokensha;
    @JsonProperty("celKyuHokensha")
    private celKyuHokenshaAttblShikakuShosai celKyuHokensha;
    @JsonProperty("celShutokuShoriDate")
    private celShutokuShoriDateAttblShikakuShosai celShutokuShoriDate;
    @JsonProperty("celSoshitsuDate")
    private celSoshitsuDateAttblShikakuShosai celSoshitsuDate;
    @JsonProperty("celSoshitsuTodokedeDate")
    private celSoshitsuTodokedeDateAttblShikakuShosai celSoshitsuTodokedeDate;
    @JsonProperty("celSoshitsuJiyu")
    private celSoshitsuJiyuAttblShikakuShosai celSoshitsuJiyu;
    @JsonProperty("celSoshitsuShoriDate")
    private celSoshitsuShoriDateAttblShikakuShosai celSoshitsuShoriDate;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShutokuDate() {
        return this.celShutokuDate.getLblShutokuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return this.celShutokuDate.getTxtShutokuDate();
    }

    @JsonIgnore
    public Label getLblShutokuTodokedeDate() {
        return this.celShutokuTodokedeDate.getLblShutokuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return this.celShutokuTodokedeDate.getTxtShutokuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblShutokuJiyu() {
        return this.celShutokuJiyu.getLblShutokuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuJiyu() {
        return this.celShutokuJiyu.getDdlShutokuJiyu();
    }

    @JsonIgnore
    public Label getLblHihoKubun() {
        return this.celHihoKubun.getLblHihoKubun();
    }

    @JsonIgnore
    public DropDownList getDdlHihoKubun() {
        return this.celHihoKubun.getDdlHihoKubun();
    }

    @JsonIgnore
    public Label getLblShutokuShozaiHokensha() {
        return this.celShutokuShozaiHokensha.getLblShutokuShozaiHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuShozaiHokensha() {
        return this.celShutokuShozaiHokensha.getDdlShutokuShozaiHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuSochimotoHokensha() {
        return this.celShutokuSochimotoHokensha.getLblShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return this.celShutokuSochimotoHokensha.getDdlShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public Label getLblKyuHokensha() {
        return this.celKyuHokensha.getLblKyuHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuKyuHokensha() {
        return this.celKyuHokensha.getDdlShutokuKyuHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuShoriDate() {
        return this.celShutokuShoriDate.getLblShutokuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuShoriDate() {
        return this.celShutokuShoriDate.getTxtShutokuShoriDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuDate() {
        return this.celSoshitsuDate.getLblSoshitsuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return this.celSoshitsuDate.getTxtSoshitsuDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuTodokedeDate() {
        return this.celSoshitsuTodokedeDate.getLblSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return this.celSoshitsuTodokedeDate.getTxtSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuJiyu() {
        return this.celSoshitsuJiyu.getLblSoshitsuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsuJiyu() {
        return this.celSoshitsuJiyu.getDdlSoshitsuJiyu();
    }

    @JsonIgnore
    public Label getLblSoshitsuShoriDate() {
        return this.celSoshitsuShoriDate.getLblSoshitsuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuShoriDate() {
        return this.celSoshitsuShoriDate.getTxtSoshitsuShoriDate();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelShutokuDate
     * @return celShutokuDate
     */
    @JsonProperty("celShutokuDate")
    private celShutokuDateAttblShikakuShosai getCelShutokuDate() {
        return celShutokuDate;
    }

    /*
     * setcelShutokuDate
     * @param celShutokuDate celShutokuDate
     */
    @JsonProperty("celShutokuDate")
    private void setCelShutokuDate(celShutokuDateAttblShikakuShosai celShutokuDate) {
        this.celShutokuDate = celShutokuDate;
    }

    /*
     * getcelShutokuTodokedeDate
     * @return celShutokuTodokedeDate
     */
    @JsonProperty("celShutokuTodokedeDate")
    private celShutokuTodokedeDateAttblShikakuShosai getCelShutokuTodokedeDate() {
        return celShutokuTodokedeDate;
    }

    /*
     * setcelShutokuTodokedeDate
     * @param celShutokuTodokedeDate celShutokuTodokedeDate
     */
    @JsonProperty("celShutokuTodokedeDate")
    private void setCelShutokuTodokedeDate(celShutokuTodokedeDateAttblShikakuShosai celShutokuTodokedeDate) {
        this.celShutokuTodokedeDate = celShutokuTodokedeDate;
    }

    /*
     * getcelShutokuJiyu
     * @return celShutokuJiyu
     */
    @JsonProperty("celShutokuJiyu")
    private celShutokuJiyuAttblShikakuShosai getCelShutokuJiyu() {
        return celShutokuJiyu;
    }

    /*
     * setcelShutokuJiyu
     * @param celShutokuJiyu celShutokuJiyu
     */
    @JsonProperty("celShutokuJiyu")
    private void setCelShutokuJiyu(celShutokuJiyuAttblShikakuShosai celShutokuJiyu) {
        this.celShutokuJiyu = celShutokuJiyu;
    }

    /*
     * getcelHihoKubun
     * @return celHihoKubun
     */
    @JsonProperty("celHihoKubun")
    private celHihoKubunAttblShikakuShosai getCelHihoKubun() {
        return celHihoKubun;
    }

    /*
     * setcelHihoKubun
     * @param celHihoKubun celHihoKubun
     */
    @JsonProperty("celHihoKubun")
    private void setCelHihoKubun(celHihoKubunAttblShikakuShosai celHihoKubun) {
        this.celHihoKubun = celHihoKubun;
    }

    /*
     * getcelShutokuShozaiHokensha
     * @return celShutokuShozaiHokensha
     */
    @JsonProperty("celShutokuShozaiHokensha")
    private celShutokuShozaiHokenshaAttblShikakuShosai getCelShutokuShozaiHokensha() {
        return celShutokuShozaiHokensha;
    }

    /*
     * setcelShutokuShozaiHokensha
     * @param celShutokuShozaiHokensha celShutokuShozaiHokensha
     */
    @JsonProperty("celShutokuShozaiHokensha")
    private void setCelShutokuShozaiHokensha(celShutokuShozaiHokenshaAttblShikakuShosai celShutokuShozaiHokensha) {
        this.celShutokuShozaiHokensha = celShutokuShozaiHokensha;
    }

    /*
     * getcelShutokuSochimotoHokensha
     * @return celShutokuSochimotoHokensha
     */
    @JsonProperty("celShutokuSochimotoHokensha")
    private celShutokuSochimotoHokenshaAttblShikakuShosai getCelShutokuSochimotoHokensha() {
        return celShutokuSochimotoHokensha;
    }

    /*
     * setcelShutokuSochimotoHokensha
     * @param celShutokuSochimotoHokensha celShutokuSochimotoHokensha
     */
    @JsonProperty("celShutokuSochimotoHokensha")
    private void setCelShutokuSochimotoHokensha(celShutokuSochimotoHokenshaAttblShikakuShosai celShutokuSochimotoHokensha) {
        this.celShutokuSochimotoHokensha = celShutokuSochimotoHokensha;
    }

    /*
     * getcelKyuHokensha
     * @return celKyuHokensha
     */
    @JsonProperty("celKyuHokensha")
    private celKyuHokenshaAttblShikakuShosai getCelKyuHokensha() {
        return celKyuHokensha;
    }

    /*
     * setcelKyuHokensha
     * @param celKyuHokensha celKyuHokensha
     */
    @JsonProperty("celKyuHokensha")
    private void setCelKyuHokensha(celKyuHokenshaAttblShikakuShosai celKyuHokensha) {
        this.celKyuHokensha = celKyuHokensha;
    }

    /*
     * getcelShutokuShoriDate
     * @return celShutokuShoriDate
     */
    @JsonProperty("celShutokuShoriDate")
    private celShutokuShoriDateAttblShikakuShosai getCelShutokuShoriDate() {
        return celShutokuShoriDate;
    }

    /*
     * setcelShutokuShoriDate
     * @param celShutokuShoriDate celShutokuShoriDate
     */
    @JsonProperty("celShutokuShoriDate")
    private void setCelShutokuShoriDate(celShutokuShoriDateAttblShikakuShosai celShutokuShoriDate) {
        this.celShutokuShoriDate = celShutokuShoriDate;
    }

    /*
     * getcelSoshitsuDate
     * @return celSoshitsuDate
     */
    @JsonProperty("celSoshitsuDate")
    private celSoshitsuDateAttblShikakuShosai getCelSoshitsuDate() {
        return celSoshitsuDate;
    }

    /*
     * setcelSoshitsuDate
     * @param celSoshitsuDate celSoshitsuDate
     */
    @JsonProperty("celSoshitsuDate")
    private void setCelSoshitsuDate(celSoshitsuDateAttblShikakuShosai celSoshitsuDate) {
        this.celSoshitsuDate = celSoshitsuDate;
    }

    /*
     * getcelSoshitsuTodokedeDate
     * @return celSoshitsuTodokedeDate
     */
    @JsonProperty("celSoshitsuTodokedeDate")
    private celSoshitsuTodokedeDateAttblShikakuShosai getCelSoshitsuTodokedeDate() {
        return celSoshitsuTodokedeDate;
    }

    /*
     * setcelSoshitsuTodokedeDate
     * @param celSoshitsuTodokedeDate celSoshitsuTodokedeDate
     */
    @JsonProperty("celSoshitsuTodokedeDate")
    private void setCelSoshitsuTodokedeDate(celSoshitsuTodokedeDateAttblShikakuShosai celSoshitsuTodokedeDate) {
        this.celSoshitsuTodokedeDate = celSoshitsuTodokedeDate;
    }

    /*
     * getcelSoshitsuJiyu
     * @return celSoshitsuJiyu
     */
    @JsonProperty("celSoshitsuJiyu")
    private celSoshitsuJiyuAttblShikakuShosai getCelSoshitsuJiyu() {
        return celSoshitsuJiyu;
    }

    /*
     * setcelSoshitsuJiyu
     * @param celSoshitsuJiyu celSoshitsuJiyu
     */
    @JsonProperty("celSoshitsuJiyu")
    private void setCelSoshitsuJiyu(celSoshitsuJiyuAttblShikakuShosai celSoshitsuJiyu) {
        this.celSoshitsuJiyu = celSoshitsuJiyu;
    }

    /*
     * getcelSoshitsuShoriDate
     * @return celSoshitsuShoriDate
     */
    @JsonProperty("celSoshitsuShoriDate")
    private celSoshitsuShoriDateAttblShikakuShosai getCelSoshitsuShoriDate() {
        return celSoshitsuShoriDate;
    }

    /*
     * setcelSoshitsuShoriDate
     * @param celSoshitsuShoriDate celSoshitsuShoriDate
     */
    @JsonProperty("celSoshitsuShoriDate")
    private void setCelSoshitsuShoriDate(celSoshitsuShoriDateAttblShikakuShosai celSoshitsuShoriDate) {
        this.celSoshitsuShoriDate = celSoshitsuShoriDate;
    }

    // </editor-fold>
}
/**
 * celShutokuDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblShutokuDate")
    private Label lblShutokuDate;
    @JsonProperty("txtShutokuDate")
    private TextBoxFlexibleDate txtShutokuDate;

    /*
     * getlblShutokuDate
     * @return lblShutokuDate
     */
    @JsonProperty("lblShutokuDate")
    public Label getLblShutokuDate() {
        return lblShutokuDate;
    }

    /*
     * setlblShutokuDate
     * @param lblShutokuDate lblShutokuDate
     */
    @JsonProperty("lblShutokuDate")
    public void setLblShutokuDate(Label lblShutokuDate) {
        this.lblShutokuDate = lblShutokuDate;
    }

    /*
     * gettxtShutokuDate
     * @return txtShutokuDate
     */
    @JsonProperty("txtShutokuDate")
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return txtShutokuDate;
    }

    /*
     * settxtShutokuDate
     * @param txtShutokuDate txtShutokuDate
     */
    @JsonProperty("txtShutokuDate")
    public void setTxtShutokuDate(TextBoxFlexibleDate txtShutokuDate) {
        this.txtShutokuDate = txtShutokuDate;
    }

    // </editor-fold>
}
/**
 * celShutokuTodokedeDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuTodokedeDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblShutokuTodokedeDate")
    private Label lblShutokuTodokedeDate;
    @JsonProperty("txtShutokuTodokedeDate")
    private TextBoxFlexibleDate txtShutokuTodokedeDate;

    /*
     * getlblShutokuTodokedeDate
     * @return lblShutokuTodokedeDate
     */
    @JsonProperty("lblShutokuTodokedeDate")
    public Label getLblShutokuTodokedeDate() {
        return lblShutokuTodokedeDate;
    }

    /*
     * setlblShutokuTodokedeDate
     * @param lblShutokuTodokedeDate lblShutokuTodokedeDate
     */
    @JsonProperty("lblShutokuTodokedeDate")
    public void setLblShutokuTodokedeDate(Label lblShutokuTodokedeDate) {
        this.lblShutokuTodokedeDate = lblShutokuTodokedeDate;
    }

    /*
     * gettxtShutokuTodokedeDate
     * @return txtShutokuTodokedeDate
     */
    @JsonProperty("txtShutokuTodokedeDate")
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return txtShutokuTodokedeDate;
    }

    /*
     * settxtShutokuTodokedeDate
     * @param txtShutokuTodokedeDate txtShutokuTodokedeDate
     */
    @JsonProperty("txtShutokuTodokedeDate")
    public void setTxtShutokuTodokedeDate(TextBoxFlexibleDate txtShutokuTodokedeDate) {
        this.txtShutokuTodokedeDate = txtShutokuTodokedeDate;
    }

    // </editor-fold>
}
/**
 * celShutokuJiyu のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuJiyuAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblShutokuJiyu")
    private Label lblShutokuJiyu;
    @JsonProperty("ddlShutokuJiyu")
    private DropDownList ddlShutokuJiyu;

    /*
     * getlblShutokuJiyu
     * @return lblShutokuJiyu
     */
    @JsonProperty("lblShutokuJiyu")
    public Label getLblShutokuJiyu() {
        return lblShutokuJiyu;
    }

    /*
     * setlblShutokuJiyu
     * @param lblShutokuJiyu lblShutokuJiyu
     */
    @JsonProperty("lblShutokuJiyu")
    public void setLblShutokuJiyu(Label lblShutokuJiyu) {
        this.lblShutokuJiyu = lblShutokuJiyu;
    }

    /*
     * getddlShutokuJiyu
     * @return ddlShutokuJiyu
     */
    @JsonProperty("ddlShutokuJiyu")
    public DropDownList getDdlShutokuJiyu() {
        return ddlShutokuJiyu;
    }

    /*
     * setddlShutokuJiyu
     * @param ddlShutokuJiyu ddlShutokuJiyu
     */
    @JsonProperty("ddlShutokuJiyu")
    public void setDdlShutokuJiyu(DropDownList ddlShutokuJiyu) {
        this.ddlShutokuJiyu = ddlShutokuJiyu;
    }

    // </editor-fold>
}
/**
 * celHihoKubun のクラスファイル 
 * 
 * @author 自動生成
 */
class celHihoKubunAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblHihoKubun")
    private Label lblHihoKubun;
    @JsonProperty("ddlHihoKubun")
    private DropDownList ddlHihoKubun;

    /*
     * getlblHihoKubun
     * @return lblHihoKubun
     */
    @JsonProperty("lblHihoKubun")
    public Label getLblHihoKubun() {
        return lblHihoKubun;
    }

    /*
     * setlblHihoKubun
     * @param lblHihoKubun lblHihoKubun
     */
    @JsonProperty("lblHihoKubun")
    public void setLblHihoKubun(Label lblHihoKubun) {
        this.lblHihoKubun = lblHihoKubun;
    }

    /*
     * getddlHihoKubun
     * @return ddlHihoKubun
     */
    @JsonProperty("ddlHihoKubun")
    public DropDownList getDdlHihoKubun() {
        return ddlHihoKubun;
    }

    /*
     * setddlHihoKubun
     * @param ddlHihoKubun ddlHihoKubun
     */
    @JsonProperty("ddlHihoKubun")
    public void setDdlHihoKubun(DropDownList ddlHihoKubun) {
        this.ddlHihoKubun = ddlHihoKubun;
    }

    // </editor-fold>
}
/**
 * celShutokuShozaiHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuShozaiHokenshaAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblShutokuShozaiHokensha")
    private Label lblShutokuShozaiHokensha;
    @JsonProperty("ddlShutokuShozaiHokensha")
    private DropDownList ddlShutokuShozaiHokensha;

    /*
     * getlblShutokuShozaiHokensha
     * @return lblShutokuShozaiHokensha
     */
    @JsonProperty("lblShutokuShozaiHokensha")
    public Label getLblShutokuShozaiHokensha() {
        return lblShutokuShozaiHokensha;
    }

    /*
     * setlblShutokuShozaiHokensha
     * @param lblShutokuShozaiHokensha lblShutokuShozaiHokensha
     */
    @JsonProperty("lblShutokuShozaiHokensha")
    public void setLblShutokuShozaiHokensha(Label lblShutokuShozaiHokensha) {
        this.lblShutokuShozaiHokensha = lblShutokuShozaiHokensha;
    }

    /*
     * getddlShutokuShozaiHokensha
     * @return ddlShutokuShozaiHokensha
     */
    @JsonProperty("ddlShutokuShozaiHokensha")
    public DropDownList getDdlShutokuShozaiHokensha() {
        return ddlShutokuShozaiHokensha;
    }

    /*
     * setddlShutokuShozaiHokensha
     * @param ddlShutokuShozaiHokensha ddlShutokuShozaiHokensha
     */
    @JsonProperty("ddlShutokuShozaiHokensha")
    public void setDdlShutokuShozaiHokensha(DropDownList ddlShutokuShozaiHokensha) {
        this.ddlShutokuShozaiHokensha = ddlShutokuShozaiHokensha;
    }

    // </editor-fold>
}
/**
 * celShutokuSochimotoHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuSochimotoHokenshaAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblShutokuSochimotoHokensha")
    private Label lblShutokuSochimotoHokensha;
    @JsonProperty("ddlShutokuSochimotoHokensha")
    private DropDownList ddlShutokuSochimotoHokensha;

    /*
     * getlblShutokuSochimotoHokensha
     * @return lblShutokuSochimotoHokensha
     */
    @JsonProperty("lblShutokuSochimotoHokensha")
    public Label getLblShutokuSochimotoHokensha() {
        return lblShutokuSochimotoHokensha;
    }

    /*
     * setlblShutokuSochimotoHokensha
     * @param lblShutokuSochimotoHokensha lblShutokuSochimotoHokensha
     */
    @JsonProperty("lblShutokuSochimotoHokensha")
    public void setLblShutokuSochimotoHokensha(Label lblShutokuSochimotoHokensha) {
        this.lblShutokuSochimotoHokensha = lblShutokuSochimotoHokensha;
    }

    /*
     * getddlShutokuSochimotoHokensha
     * @return ddlShutokuSochimotoHokensha
     */
    @JsonProperty("ddlShutokuSochimotoHokensha")
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return ddlShutokuSochimotoHokensha;
    }

    /*
     * setddlShutokuSochimotoHokensha
     * @param ddlShutokuSochimotoHokensha ddlShutokuSochimotoHokensha
     */
    @JsonProperty("ddlShutokuSochimotoHokensha")
    public void setDdlShutokuSochimotoHokensha(DropDownList ddlShutokuSochimotoHokensha) {
        this.ddlShutokuSochimotoHokensha = ddlShutokuSochimotoHokensha;
    }

    // </editor-fold>
}
/**
 * celKyuHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyuHokenshaAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblKyuHokensha")
    private Label lblKyuHokensha;
    @JsonProperty("ddlShutokuKyuHokensha")
    private DropDownList ddlShutokuKyuHokensha;

    /*
     * getlblKyuHokensha
     * @return lblKyuHokensha
     */
    @JsonProperty("lblKyuHokensha")
    public Label getLblKyuHokensha() {
        return lblKyuHokensha;
    }

    /*
     * setlblKyuHokensha
     * @param lblKyuHokensha lblKyuHokensha
     */
    @JsonProperty("lblKyuHokensha")
    public void setLblKyuHokensha(Label lblKyuHokensha) {
        this.lblKyuHokensha = lblKyuHokensha;
    }

    /*
     * getddlShutokuKyuHokensha
     * @return ddlShutokuKyuHokensha
     */
    @JsonProperty("ddlShutokuKyuHokensha")
    public DropDownList getDdlShutokuKyuHokensha() {
        return ddlShutokuKyuHokensha;
    }

    /*
     * setddlShutokuKyuHokensha
     * @param ddlShutokuKyuHokensha ddlShutokuKyuHokensha
     */
    @JsonProperty("ddlShutokuKyuHokensha")
    public void setDdlShutokuKyuHokensha(DropDownList ddlShutokuKyuHokensha) {
        this.ddlShutokuKyuHokensha = ddlShutokuKyuHokensha;
    }

    // </editor-fold>
}
/**
 * celShutokuShoriDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuShoriDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblShutokuShoriDate")
    private Label lblShutokuShoriDate;
    @JsonProperty("txtShutokuShoriDate")
    private TextBoxFlexibleDate txtShutokuShoriDate;

    /*
     * getlblShutokuShoriDate
     * @return lblShutokuShoriDate
     */
    @JsonProperty("lblShutokuShoriDate")
    public Label getLblShutokuShoriDate() {
        return lblShutokuShoriDate;
    }

    /*
     * setlblShutokuShoriDate
     * @param lblShutokuShoriDate lblShutokuShoriDate
     */
    @JsonProperty("lblShutokuShoriDate")
    public void setLblShutokuShoriDate(Label lblShutokuShoriDate) {
        this.lblShutokuShoriDate = lblShutokuShoriDate;
    }

    /*
     * gettxtShutokuShoriDate
     * @return txtShutokuShoriDate
     */
    @JsonProperty("txtShutokuShoriDate")
    public TextBoxFlexibleDate getTxtShutokuShoriDate() {
        return txtShutokuShoriDate;
    }

    /*
     * settxtShutokuShoriDate
     * @param txtShutokuShoriDate txtShutokuShoriDate
     */
    @JsonProperty("txtShutokuShoriDate")
    public void setTxtShutokuShoriDate(TextBoxFlexibleDate txtShutokuShoriDate) {
        this.txtShutokuShoriDate = txtShutokuShoriDate;
    }

    // </editor-fold>
}
/**
 * celSoshitsuDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celSoshitsuDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblSoshitsuDate")
    private Label lblSoshitsuDate;
    @JsonProperty("txtSoshitsuDate")
    private TextBoxFlexibleDate txtSoshitsuDate;

    /*
     * getlblSoshitsuDate
     * @return lblSoshitsuDate
     */
    @JsonProperty("lblSoshitsuDate")
    public Label getLblSoshitsuDate() {
        return lblSoshitsuDate;
    }

    /*
     * setlblSoshitsuDate
     * @param lblSoshitsuDate lblSoshitsuDate
     */
    @JsonProperty("lblSoshitsuDate")
    public void setLblSoshitsuDate(Label lblSoshitsuDate) {
        this.lblSoshitsuDate = lblSoshitsuDate;
    }

    /*
     * gettxtSoshitsuDate
     * @return txtSoshitsuDate
     */
    @JsonProperty("txtSoshitsuDate")
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return txtSoshitsuDate;
    }

    /*
     * settxtSoshitsuDate
     * @param txtSoshitsuDate txtSoshitsuDate
     */
    @JsonProperty("txtSoshitsuDate")
    public void setTxtSoshitsuDate(TextBoxFlexibleDate txtSoshitsuDate) {
        this.txtSoshitsuDate = txtSoshitsuDate;
    }

    // </editor-fold>
}
/**
 * celSoshitsuTodokedeDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celSoshitsuTodokedeDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblSoshitsuTodokedeDate")
    private Label lblSoshitsuTodokedeDate;
    @JsonProperty("txtSoshitsuTodokedeDate")
    private TextBoxFlexibleDate txtSoshitsuTodokedeDate;

    /*
     * getlblSoshitsuTodokedeDate
     * @return lblSoshitsuTodokedeDate
     */
    @JsonProperty("lblSoshitsuTodokedeDate")
    public Label getLblSoshitsuTodokedeDate() {
        return lblSoshitsuTodokedeDate;
    }

    /*
     * setlblSoshitsuTodokedeDate
     * @param lblSoshitsuTodokedeDate lblSoshitsuTodokedeDate
     */
    @JsonProperty("lblSoshitsuTodokedeDate")
    public void setLblSoshitsuTodokedeDate(Label lblSoshitsuTodokedeDate) {
        this.lblSoshitsuTodokedeDate = lblSoshitsuTodokedeDate;
    }

    /*
     * gettxtSoshitsuTodokedeDate
     * @return txtSoshitsuTodokedeDate
     */
    @JsonProperty("txtSoshitsuTodokedeDate")
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return txtSoshitsuTodokedeDate;
    }

    /*
     * settxtSoshitsuTodokedeDate
     * @param txtSoshitsuTodokedeDate txtSoshitsuTodokedeDate
     */
    @JsonProperty("txtSoshitsuTodokedeDate")
    public void setTxtSoshitsuTodokedeDate(TextBoxFlexibleDate txtSoshitsuTodokedeDate) {
        this.txtSoshitsuTodokedeDate = txtSoshitsuTodokedeDate;
    }

    // </editor-fold>
}
/**
 * celSoshitsuJiyu のクラスファイル 
 * 
 * @author 自動生成
 */
class celSoshitsuJiyuAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblSoshitsuJiyu")
    private Label lblSoshitsuJiyu;
    @JsonProperty("ddlSoshitsuJiyu")
    private DropDownList ddlSoshitsuJiyu;

    /*
     * getlblSoshitsuJiyu
     * @return lblSoshitsuJiyu
     */
    @JsonProperty("lblSoshitsuJiyu")
    public Label getLblSoshitsuJiyu() {
        return lblSoshitsuJiyu;
    }

    /*
     * setlblSoshitsuJiyu
     * @param lblSoshitsuJiyu lblSoshitsuJiyu
     */
    @JsonProperty("lblSoshitsuJiyu")
    public void setLblSoshitsuJiyu(Label lblSoshitsuJiyu) {
        this.lblSoshitsuJiyu = lblSoshitsuJiyu;
    }

    /*
     * getddlSoshitsuJiyu
     * @return ddlSoshitsuJiyu
     */
    @JsonProperty("ddlSoshitsuJiyu")
    public DropDownList getDdlSoshitsuJiyu() {
        return ddlSoshitsuJiyu;
    }

    /*
     * setddlSoshitsuJiyu
     * @param ddlSoshitsuJiyu ddlSoshitsuJiyu
     */
    @JsonProperty("ddlSoshitsuJiyu")
    public void setDdlSoshitsuJiyu(DropDownList ddlSoshitsuJiyu) {
        this.ddlSoshitsuJiyu = ddlSoshitsuJiyu;
    }

    // </editor-fold>
}
/**
 * celSoshitsuShoriDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celSoshitsuShoriDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    @JsonProperty("lblSoshitsuShoriDate")
    private Label lblSoshitsuShoriDate;
    @JsonProperty("txtSoshitsuShoriDate")
    private TextBoxFlexibleDate txtSoshitsuShoriDate;

    /*
     * getlblSoshitsuShoriDate
     * @return lblSoshitsuShoriDate
     */
    @JsonProperty("lblSoshitsuShoriDate")
    public Label getLblSoshitsuShoriDate() {
        return lblSoshitsuShoriDate;
    }

    /*
     * setlblSoshitsuShoriDate
     * @param lblSoshitsuShoriDate lblSoshitsuShoriDate
     */
    @JsonProperty("lblSoshitsuShoriDate")
    public void setLblSoshitsuShoriDate(Label lblSoshitsuShoriDate) {
        this.lblSoshitsuShoriDate = lblSoshitsuShoriDate;
    }

    /*
     * gettxtSoshitsuShoriDate
     * @return txtSoshitsuShoriDate
     */
    @JsonProperty("txtSoshitsuShoriDate")
    public TextBoxFlexibleDate getTxtSoshitsuShoriDate() {
        return txtSoshitsuShoriDate;
    }

    /*
     * settxtSoshitsuShoriDate
     * @param txtSoshitsuShoriDate txtSoshitsuShoriDate
     */
    @JsonProperty("txtSoshitsuShoriDate")
    public void setTxtSoshitsuShoriDate(TextBoxFlexibleDate txtSoshitsuShoriDate) {
        this.txtSoshitsuShoriDate = txtSoshitsuShoriDate;
    }

    // </editor-fold>
}
