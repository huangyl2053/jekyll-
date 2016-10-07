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
 * JutokuKaijoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuKaijoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaijoDate")
    private TextBoxFlexibleDate txtKaijoDate;
    @JsonProperty("txtKaijoTodokedeDate")
    private TextBoxFlexibleDate txtKaijoTodokedeDate;
    @JsonProperty("ddlKaijoJiyu")
    private DropDownList ddlKaijoJiyu;
    @JsonProperty("kaijojiShichosonCode")
    private RString kaijojiShichosonCode;
    @JsonProperty("kaijojiHihokenshaNo")
    private RString kaijojiHihokenshaNo;
    @JsonProperty("kaijojiShoriDatetime")
    private RString kaijojiShoriDatetime;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKaijoDate
     * @return txtKaijoDate
     */
    @JsonProperty("txtKaijoDate")
    public TextBoxFlexibleDate getTxtKaijoDate() {
        return txtKaijoDate;
    }

    /*
     * settxtKaijoDate
     * @param txtKaijoDate txtKaijoDate
     */
    @JsonProperty("txtKaijoDate")
    public void setTxtKaijoDate(TextBoxFlexibleDate txtKaijoDate) {
        this.txtKaijoDate = txtKaijoDate;
    }

    /*
     * gettxtKaijoTodokedeDate
     * @return txtKaijoTodokedeDate
     */
    @JsonProperty("txtKaijoTodokedeDate")
    public TextBoxFlexibleDate getTxtKaijoTodokedeDate() {
        return txtKaijoTodokedeDate;
    }

    /*
     * settxtKaijoTodokedeDate
     * @param txtKaijoTodokedeDate txtKaijoTodokedeDate
     */
    @JsonProperty("txtKaijoTodokedeDate")
    public void setTxtKaijoTodokedeDate(TextBoxFlexibleDate txtKaijoTodokedeDate) {
        this.txtKaijoTodokedeDate = txtKaijoTodokedeDate;
    }

    /*
     * getddlKaijoJiyu
     * @return ddlKaijoJiyu
     */
    @JsonProperty("ddlKaijoJiyu")
    public DropDownList getDdlKaijoJiyu() {
        return ddlKaijoJiyu;
    }

    /*
     * setddlKaijoJiyu
     * @param ddlKaijoJiyu ddlKaijoJiyu
     */
    @JsonProperty("ddlKaijoJiyu")
    public void setDdlKaijoJiyu(DropDownList ddlKaijoJiyu) {
        this.ddlKaijoJiyu = ddlKaijoJiyu;
    }

    /*
     * getkaijojiShichosonCode
     * @return kaijojiShichosonCode
     */
    @JsonProperty("kaijojiShichosonCode")
    public RString getKaijojiShichosonCode() {
        return kaijojiShichosonCode;
    }

    /*
     * setkaijojiShichosonCode
     * @param kaijojiShichosonCode kaijojiShichosonCode
     */
    @JsonProperty("kaijojiShichosonCode")
    public void setKaijojiShichosonCode(RString kaijojiShichosonCode) {
        this.kaijojiShichosonCode = kaijojiShichosonCode;
    }

    /*
     * getkaijojiHihokenshaNo
     * @return kaijojiHihokenshaNo
     */
    @JsonProperty("kaijojiHihokenshaNo")
    public RString getKaijojiHihokenshaNo() {
        return kaijojiHihokenshaNo;
    }

    /*
     * setkaijojiHihokenshaNo
     * @param kaijojiHihokenshaNo kaijojiHihokenshaNo
     */
    @JsonProperty("kaijojiHihokenshaNo")
    public void setKaijojiHihokenshaNo(RString kaijojiHihokenshaNo) {
        this.kaijojiHihokenshaNo = kaijojiHihokenshaNo;
    }

    /*
     * getkaijojiShoriDatetime
     * @return kaijojiShoriDatetime
     */
    @JsonProperty("kaijojiShoriDatetime")
    public RString getKaijojiShoriDatetime() {
        return kaijojiShoriDatetime;
    }

    /*
     * setkaijojiShoriDatetime
     * @param kaijojiShoriDatetime kaijojiShoriDatetime
     */
    @JsonProperty("kaijojiShoriDatetime")
    public void setKaijojiShoriDatetime(RString kaijojiShoriDatetime) {
        this.kaijojiShoriDatetime = kaijojiShoriDatetime;
    }

    // </editor-fold>
}
