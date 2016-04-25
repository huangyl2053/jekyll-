package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;
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
 * ShikakuShutokuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShutokuInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("txtShutokuDate")
    private TextBoxFlexibleDate txtShutokuDate;
    @JsonProperty("txtShutokuTodokedeDate")
    private TextBoxFlexibleDate txtShutokuTodokedeDate;
    @JsonProperty("ddlShikakuShutokuJiyu")
    private DropDownList ddlShikakuShutokuJiyu;
    @JsonProperty("btnShikakuShutokuKakutei")
    private Button btnShikakuShutokuKakutei;
    @JsonProperty("btnShikakuShutokuTorikeshi")
    private Button btnShikakuShutokuTorikeshi;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihoNo
     * @return txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
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

    /*
     * getddlShikakuShutokuJiyu
     * @return ddlShikakuShutokuJiyu
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    public DropDownList getDdlShikakuShutokuJiyu() {
        return ddlShikakuShutokuJiyu;
    }

    /*
     * setddlShikakuShutokuJiyu
     * @param ddlShikakuShutokuJiyu ddlShikakuShutokuJiyu
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    public void setDdlShikakuShutokuJiyu(DropDownList ddlShikakuShutokuJiyu) {
        this.ddlShikakuShutokuJiyu = ddlShikakuShutokuJiyu;
    }

    /*
     * getbtnShikakuShutokuKakutei
     * @return btnShikakuShutokuKakutei
     */
    @JsonProperty("btnShikakuShutokuKakutei")
    public Button getBtnShikakuShutokuKakutei() {
        return btnShikakuShutokuKakutei;
    }

    /*
     * setbtnShikakuShutokuKakutei
     * @param btnShikakuShutokuKakutei btnShikakuShutokuKakutei
     */
    @JsonProperty("btnShikakuShutokuKakutei")
    public void setBtnShikakuShutokuKakutei(Button btnShikakuShutokuKakutei) {
        this.btnShikakuShutokuKakutei = btnShikakuShutokuKakutei;
    }

    /*
     * getbtnShikakuShutokuTorikeshi
     * @return btnShikakuShutokuTorikeshi
     */
    @JsonProperty("btnShikakuShutokuTorikeshi")
    public Button getBtnShikakuShutokuTorikeshi() {
        return btnShikakuShutokuTorikeshi;
    }

    /*
     * setbtnShikakuShutokuTorikeshi
     * @param btnShikakuShutokuTorikeshi btnShikakuShutokuTorikeshi
     */
    @JsonProperty("btnShikakuShutokuTorikeshi")
    public void setBtnShikakuShutokuTorikeshi(Button btnShikakuShutokuTorikeshi) {
        this.btnShikakuShutokuTorikeshi = btnShikakuShutokuTorikeshi;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    // </editor-fold>
}
