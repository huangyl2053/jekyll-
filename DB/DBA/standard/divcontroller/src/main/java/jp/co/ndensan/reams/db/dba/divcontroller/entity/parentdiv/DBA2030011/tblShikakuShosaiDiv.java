package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2030011;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
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
    @JsonProperty("celSoshitsuDate")
    private celSoshitsuDateAttblShikakuShosai celSoshitsuDate;
    @JsonProperty("celSoshitsuTodokedeDate")
    private celSoshitsuTodokedeDateAttblShikakuShosai celSoshitsuTodokedeDate;
    @JsonProperty("celSoshitsuJiyu")
    private celSoshitsuJiyuAttblShikakuShosai celSoshitsuJiyu;

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

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celShutokuDate")
    private celShutokuDateAttblShikakuShosai getCelShutokuDate() {
        return celShutokuDate;
    }

    @JsonProperty("celShutokuDate")
    private void setCelShutokuDate(celShutokuDateAttblShikakuShosai celShutokuDate) {
        this.celShutokuDate=celShutokuDate;
    }

    @JsonProperty("celShutokuTodokedeDate")
    private celShutokuTodokedeDateAttblShikakuShosai getCelShutokuTodokedeDate() {
        return celShutokuTodokedeDate;
    }

    @JsonProperty("celShutokuTodokedeDate")
    private void setCelShutokuTodokedeDate(celShutokuTodokedeDateAttblShikakuShosai celShutokuTodokedeDate) {
        this.celShutokuTodokedeDate=celShutokuTodokedeDate;
    }

    @JsonProperty("celShutokuJiyu")
    private celShutokuJiyuAttblShikakuShosai getCelShutokuJiyu() {
        return celShutokuJiyu;
    }

    @JsonProperty("celShutokuJiyu")
    private void setCelShutokuJiyu(celShutokuJiyuAttblShikakuShosai celShutokuJiyu) {
        this.celShutokuJiyu=celShutokuJiyu;
    }

    @JsonProperty("celHihoKubun")
    private celHihoKubunAttblShikakuShosai getCelHihoKubun() {
        return celHihoKubun;
    }

    @JsonProperty("celHihoKubun")
    private void setCelHihoKubun(celHihoKubunAttblShikakuShosai celHihoKubun) {
        this.celHihoKubun=celHihoKubun;
    }

    @JsonProperty("celShutokuShozaiHokensha")
    private celShutokuShozaiHokenshaAttblShikakuShosai getCelShutokuShozaiHokensha() {
        return celShutokuShozaiHokensha;
    }

    @JsonProperty("celShutokuShozaiHokensha")
    private void setCelShutokuShozaiHokensha(celShutokuShozaiHokenshaAttblShikakuShosai celShutokuShozaiHokensha) {
        this.celShutokuShozaiHokensha=celShutokuShozaiHokensha;
    }

    @JsonProperty("celShutokuSochimotoHokensha")
    private celShutokuSochimotoHokenshaAttblShikakuShosai getCelShutokuSochimotoHokensha() {
        return celShutokuSochimotoHokensha;
    }

    @JsonProperty("celShutokuSochimotoHokensha")
    private void setCelShutokuSochimotoHokensha(celShutokuSochimotoHokenshaAttblShikakuShosai celShutokuSochimotoHokensha) {
        this.celShutokuSochimotoHokensha=celShutokuSochimotoHokensha;
    }

    @JsonProperty("celKyuHokensha")
    private celKyuHokenshaAttblShikakuShosai getCelKyuHokensha() {
        return celKyuHokensha;
    }

    @JsonProperty("celKyuHokensha")
    private void setCelKyuHokensha(celKyuHokenshaAttblShikakuShosai celKyuHokensha) {
        this.celKyuHokensha=celKyuHokensha;
    }

    @JsonProperty("celSoshitsuDate")
    private celSoshitsuDateAttblShikakuShosai getCelSoshitsuDate() {
        return celSoshitsuDate;
    }

    @JsonProperty("celSoshitsuDate")
    private void setCelSoshitsuDate(celSoshitsuDateAttblShikakuShosai celSoshitsuDate) {
        this.celSoshitsuDate=celSoshitsuDate;
    }

    @JsonProperty("celSoshitsuTodokedeDate")
    private celSoshitsuTodokedeDateAttblShikakuShosai getCelSoshitsuTodokedeDate() {
        return celSoshitsuTodokedeDate;
    }

    @JsonProperty("celSoshitsuTodokedeDate")
    private void setCelSoshitsuTodokedeDate(celSoshitsuTodokedeDateAttblShikakuShosai celSoshitsuTodokedeDate) {
        this.celSoshitsuTodokedeDate=celSoshitsuTodokedeDate;
    }

    @JsonProperty("celSoshitsuJiyu")
    private celSoshitsuJiyuAttblShikakuShosai getCelSoshitsuJiyu() {
        return celSoshitsuJiyu;
    }

    @JsonProperty("celSoshitsuJiyu")
    private void setCelSoshitsuJiyu(celSoshitsuJiyuAttblShikakuShosai celSoshitsuJiyu) {
        this.celSoshitsuJiyu=celSoshitsuJiyu;
    }

    // </editor-fold>
}
/**
 * celShutokuDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblShutokuDate")
    private Label lblShutokuDate;
    @JsonProperty("txtShutokuDate")
    private TextBoxFlexibleDate txtShutokuDate;

    @JsonProperty("lblShutokuDate")
    public Label getLblShutokuDate() {
        return lblShutokuDate;
    }

    @JsonProperty("lblShutokuDate")
    public void setLblShutokuDate(Label lblShutokuDate) {
        this.lblShutokuDate=lblShutokuDate;
    }

    @JsonProperty("txtShutokuDate")
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return txtShutokuDate;
    }

    @JsonProperty("txtShutokuDate")
    public void setTxtShutokuDate(TextBoxFlexibleDate txtShutokuDate) {
        this.txtShutokuDate=txtShutokuDate;
    }

    // </editor-fold>
}
/**
 * celShutokuTodokedeDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuTodokedeDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblShutokuTodokedeDate")
    private Label lblShutokuTodokedeDate;
    @JsonProperty("txtShutokuTodokedeDate")
    private TextBoxFlexibleDate txtShutokuTodokedeDate;

    @JsonProperty("lblShutokuTodokedeDate")
    public Label getLblShutokuTodokedeDate() {
        return lblShutokuTodokedeDate;
    }

    @JsonProperty("lblShutokuTodokedeDate")
    public void setLblShutokuTodokedeDate(Label lblShutokuTodokedeDate) {
        this.lblShutokuTodokedeDate=lblShutokuTodokedeDate;
    }

    @JsonProperty("txtShutokuTodokedeDate")
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return txtShutokuTodokedeDate;
    }

    @JsonProperty("txtShutokuTodokedeDate")
    public void setTxtShutokuTodokedeDate(TextBoxFlexibleDate txtShutokuTodokedeDate) {
        this.txtShutokuTodokedeDate=txtShutokuTodokedeDate;
    }

    // </editor-fold>
}
/**
 * celShutokuJiyu のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuJiyuAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblShutokuJiyu")
    private Label lblShutokuJiyu;
    @JsonProperty("ddlShutokuJiyu")
    private DropDownList ddlShutokuJiyu;

    @JsonProperty("lblShutokuJiyu")
    public Label getLblShutokuJiyu() {
        return lblShutokuJiyu;
    }

    @JsonProperty("lblShutokuJiyu")
    public void setLblShutokuJiyu(Label lblShutokuJiyu) {
        this.lblShutokuJiyu=lblShutokuJiyu;
    }

    @JsonProperty("ddlShutokuJiyu")
    public DropDownList getDdlShutokuJiyu() {
        return ddlShutokuJiyu;
    }

    @JsonProperty("ddlShutokuJiyu")
    public void setDdlShutokuJiyu(DropDownList ddlShutokuJiyu) {
        this.ddlShutokuJiyu=ddlShutokuJiyu;
    }

    // </editor-fold>
}
/**
 * celHihoKubun のクラスファイル 
 * 
 * @author 自動生成
 */
class celHihoKubunAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblHihoKubun")
    private Label lblHihoKubun;
    @JsonProperty("ddlHihoKubun")
    private DropDownList ddlHihoKubun;

    @JsonProperty("lblHihoKubun")
    public Label getLblHihoKubun() {
        return lblHihoKubun;
    }

    @JsonProperty("lblHihoKubun")
    public void setLblHihoKubun(Label lblHihoKubun) {
        this.lblHihoKubun=lblHihoKubun;
    }

    @JsonProperty("ddlHihoKubun")
    public DropDownList getDdlHihoKubun() {
        return ddlHihoKubun;
    }

    @JsonProperty("ddlHihoKubun")
    public void setDdlHihoKubun(DropDownList ddlHihoKubun) {
        this.ddlHihoKubun=ddlHihoKubun;
    }

    // </editor-fold>
}
/**
 * celShutokuShozaiHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuShozaiHokenshaAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblShutokuShozaiHokensha")
    private Label lblShutokuShozaiHokensha;
    @JsonProperty("ddlShutokuShozaiHokensha")
    private DropDownList ddlShutokuShozaiHokensha;

    @JsonProperty("lblShutokuShozaiHokensha")
    public Label getLblShutokuShozaiHokensha() {
        return lblShutokuShozaiHokensha;
    }

    @JsonProperty("lblShutokuShozaiHokensha")
    public void setLblShutokuShozaiHokensha(Label lblShutokuShozaiHokensha) {
        this.lblShutokuShozaiHokensha=lblShutokuShozaiHokensha;
    }

    @JsonProperty("ddlShutokuShozaiHokensha")
    public DropDownList getDdlShutokuShozaiHokensha() {
        return ddlShutokuShozaiHokensha;
    }

    @JsonProperty("ddlShutokuShozaiHokensha")
    public void setDdlShutokuShozaiHokensha(DropDownList ddlShutokuShozaiHokensha) {
        this.ddlShutokuShozaiHokensha=ddlShutokuShozaiHokensha;
    }

    // </editor-fold>
}
/**
 * celShutokuSochimotoHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
class celShutokuSochimotoHokenshaAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblShutokuSochimotoHokensha")
    private Label lblShutokuSochimotoHokensha;
    @JsonProperty("ddlShutokuSochimotoHokensha")
    private DropDownList ddlShutokuSochimotoHokensha;

    @JsonProperty("lblShutokuSochimotoHokensha")
    public Label getLblShutokuSochimotoHokensha() {
        return lblShutokuSochimotoHokensha;
    }

    @JsonProperty("lblShutokuSochimotoHokensha")
    public void setLblShutokuSochimotoHokensha(Label lblShutokuSochimotoHokensha) {
        this.lblShutokuSochimotoHokensha=lblShutokuSochimotoHokensha;
    }

    @JsonProperty("ddlShutokuSochimotoHokensha")
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return ddlShutokuSochimotoHokensha;
    }

    @JsonProperty("ddlShutokuSochimotoHokensha")
    public void setDdlShutokuSochimotoHokensha(DropDownList ddlShutokuSochimotoHokensha) {
        this.ddlShutokuSochimotoHokensha=ddlShutokuSochimotoHokensha;
    }

    // </editor-fold>
}
/**
 * celKyuHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyuHokenshaAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblKyuHokensha")
    private Label lblKyuHokensha;
    @JsonProperty("ddlShutokuKyuHokensha")
    private DropDownList ddlShutokuKyuHokensha;

    @JsonProperty("lblKyuHokensha")
    public Label getLblKyuHokensha() {
        return lblKyuHokensha;
    }

    @JsonProperty("lblKyuHokensha")
    public void setLblKyuHokensha(Label lblKyuHokensha) {
        this.lblKyuHokensha=lblKyuHokensha;
    }

    @JsonProperty("ddlShutokuKyuHokensha")
    public DropDownList getDdlShutokuKyuHokensha() {
        return ddlShutokuKyuHokensha;
    }

    @JsonProperty("ddlShutokuKyuHokensha")
    public void setDdlShutokuKyuHokensha(DropDownList ddlShutokuKyuHokensha) {
        this.ddlShutokuKyuHokensha=ddlShutokuKyuHokensha;
    }

    // </editor-fold>
}
/**
 * celSoshitsuDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celSoshitsuDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblSoshitsuDate")
    private Label lblSoshitsuDate;
    @JsonProperty("txtSoshitsuDate")
    private TextBoxFlexibleDate txtSoshitsuDate;

    @JsonProperty("lblSoshitsuDate")
    public Label getLblSoshitsuDate() {
        return lblSoshitsuDate;
    }

    @JsonProperty("lblSoshitsuDate")
    public void setLblSoshitsuDate(Label lblSoshitsuDate) {
        this.lblSoshitsuDate=lblSoshitsuDate;
    }

    @JsonProperty("txtSoshitsuDate")
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return txtSoshitsuDate;
    }

    @JsonProperty("txtSoshitsuDate")
    public void setTxtSoshitsuDate(TextBoxFlexibleDate txtSoshitsuDate) {
        this.txtSoshitsuDate=txtSoshitsuDate;
    }

    // </editor-fold>
}
/**
 * celSoshitsuTodokedeDate のクラスファイル 
 * 
 * @author 自動生成
 */
class celSoshitsuTodokedeDateAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblSoshitsuTodokedeDate")
    private Label lblSoshitsuTodokedeDate;
    @JsonProperty("txtSoshitsuTodokedeDate")
    private TextBoxFlexibleDate txtSoshitsuTodokedeDate;

    @JsonProperty("lblSoshitsuTodokedeDate")
    public Label getLblSoshitsuTodokedeDate() {
        return lblSoshitsuTodokedeDate;
    }

    @JsonProperty("lblSoshitsuTodokedeDate")
    public void setLblSoshitsuTodokedeDate(Label lblSoshitsuTodokedeDate) {
        this.lblSoshitsuTodokedeDate=lblSoshitsuTodokedeDate;
    }

    @JsonProperty("txtSoshitsuTodokedeDate")
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return txtSoshitsuTodokedeDate;
    }

    @JsonProperty("txtSoshitsuTodokedeDate")
    public void setTxtSoshitsuTodokedeDate(TextBoxFlexibleDate txtSoshitsuTodokedeDate) {
        this.txtSoshitsuTodokedeDate=txtSoshitsuTodokedeDate;
    }

    // </editor-fold>
}
/**
 * celSoshitsuJiyu のクラスファイル 
 * 
 * @author 自動生成
 */
class celSoshitsuJiyuAttblShikakuShosai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    @JsonProperty("lblSoshitsuJiyu")
    private Label lblSoshitsuJiyu;
    @JsonProperty("ddlSoshitsuJiyu")
    private DropDownList ddlSoshitsuJiyu;

    @JsonProperty("lblSoshitsuJiyu")
    public Label getLblSoshitsuJiyu() {
        return lblSoshitsuJiyu;
    }

    @JsonProperty("lblSoshitsuJiyu")
    public void setLblSoshitsuJiyu(Label lblSoshitsuJiyu) {
        this.lblSoshitsuJiyu=lblSoshitsuJiyu;
    }

    @JsonProperty("ddlSoshitsuJiyu")
    public DropDownList getDdlSoshitsuJiyu() {
        return ddlSoshitsuJiyu;
    }

    @JsonProperty("ddlSoshitsuJiyu")
    public void setDdlSoshitsuJiyu(DropDownList ddlSoshitsuJiyu) {
        this.ddlSoshitsuJiyu=ddlSoshitsuJiyu;
    }

    // </editor-fold>
}
