package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList;
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
 * JutokuTekiyoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuTekiyoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoDate")
    private TextBoxFlexibleDate txtTekiyoDate;
    @JsonProperty("txtTekiyoTodokedeDate")
    private TextBoxFlexibleDate txtTekiyoTodokedeDate;
    @JsonProperty("ddlTekiyoJiyu")
    private DropDownList ddlTekiyoJiyu;
    @JsonProperty("tekiyojiShichosonCode")
    private RString tekiyojiShichosonCode;
    @JsonProperty("tekiyojiHihokenshaNo")
    private RString tekiyojiHihokenshaNo;
    @JsonProperty("tekiyojiShoriDatetime")
    private RString tekiyojiShoriDatetime;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoDate
     * @return txtTekiyoDate
     */
    @JsonProperty("txtTekiyoDate")
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    /*
     * settxtTekiyoDate
     * @param txtTekiyoDate txtTekiyoDate
     */
    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.txtTekiyoDate = txtTekiyoDate;
    }

    /*
     * gettxtTekiyoTodokedeDate
     * @return txtTekiyoTodokedeDate
     */
    @JsonProperty("txtTekiyoTodokedeDate")
    public TextBoxFlexibleDate getTxtTekiyoTodokedeDate() {
        return txtTekiyoTodokedeDate;
    }

    /*
     * settxtTekiyoTodokedeDate
     * @param txtTekiyoTodokedeDate txtTekiyoTodokedeDate
     */
    @JsonProperty("txtTekiyoTodokedeDate")
    public void setTxtTekiyoTodokedeDate(TextBoxFlexibleDate txtTekiyoTodokedeDate) {
        this.txtTekiyoTodokedeDate = txtTekiyoTodokedeDate;
    }

    /*
     * getddlTekiyoJiyu
     * @return ddlTekiyoJiyu
     */
    @JsonProperty("ddlTekiyoJiyu")
    public DropDownList getDdlTekiyoJiyu() {
        return ddlTekiyoJiyu;
    }

    /*
     * setddlTekiyoJiyu
     * @param ddlTekiyoJiyu ddlTekiyoJiyu
     */
    @JsonProperty("ddlTekiyoJiyu")
    public void setDdlTekiyoJiyu(DropDownList ddlTekiyoJiyu) {
        this.ddlTekiyoJiyu = ddlTekiyoJiyu;
    }

    /*
     * gettekiyojiShichosonCode
     * @return tekiyojiShichosonCode
     */
    @JsonProperty("tekiyojiShichosonCode")
    public RString getTekiyojiShichosonCode() {
        return tekiyojiShichosonCode;
    }

    /*
     * settekiyojiShichosonCode
     * @param tekiyojiShichosonCode tekiyojiShichosonCode
     */
    @JsonProperty("tekiyojiShichosonCode")
    public void setTekiyojiShichosonCode(RString tekiyojiShichosonCode) {
        this.tekiyojiShichosonCode = tekiyojiShichosonCode;
    }

    /*
     * gettekiyojiHihokenshaNo
     * @return tekiyojiHihokenshaNo
     */
    @JsonProperty("tekiyojiHihokenshaNo")
    public RString getTekiyojiHihokenshaNo() {
        return tekiyojiHihokenshaNo;
    }

    /*
     * settekiyojiHihokenshaNo
     * @param tekiyojiHihokenshaNo tekiyojiHihokenshaNo
     */
    @JsonProperty("tekiyojiHihokenshaNo")
    public void setTekiyojiHihokenshaNo(RString tekiyojiHihokenshaNo) {
        this.tekiyojiHihokenshaNo = tekiyojiHihokenshaNo;
    }

    /*
     * gettekiyojiShoriDatetime
     * @return tekiyojiShoriDatetime
     */
    @JsonProperty("tekiyojiShoriDatetime")
    public RString getTekiyojiShoriDatetime() {
        return tekiyojiShoriDatetime;
    }

    /*
     * settekiyojiShoriDatetime
     * @param tekiyojiShoriDatetime tekiyojiShoriDatetime
     */
    @JsonProperty("tekiyojiShoriDatetime")
    public void setTekiyojiShoriDatetime(RString tekiyojiShoriDatetime) {
        this.tekiyojiShoriDatetime = tekiyojiShoriDatetime;
    }

    // </editor-fold>
}
