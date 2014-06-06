package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * OtherShichosonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class OtherShichosonJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("ddlSochimotoHokensha")
    private DropDownList ddlSochimotoHokensha;
    @JsonProperty("ddlKyuHokensha")
    private DropDownList ddlKyuHokensha;
    @JsonProperty("txtKyuHihokenshaNo")
    private TextBoxCode txtKyuHihokenshaNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtMusubitsukeTaishosha")
    private TextBox txtMusubitsukeTaishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("ddlSochimotoHokensha")
    public DropDownList getDdlSochimotoHokensha() {
        return ddlSochimotoHokensha;
    }

    @JsonProperty("ddlSochimotoHokensha")
    public void setDdlSochimotoHokensha(DropDownList ddlSochimotoHokensha) {
        this.ddlSochimotoHokensha=ddlSochimotoHokensha;
    }

    @JsonProperty("ddlKyuHokensha")
    public DropDownList getDdlKyuHokensha() {
        return ddlKyuHokensha;
    }

    @JsonProperty("ddlKyuHokensha")
    public void setDdlKyuHokensha(DropDownList ddlKyuHokensha) {
        this.ddlKyuHokensha=ddlKyuHokensha;
    }

    @JsonProperty("txtKyuHihokenshaNo")
    public TextBoxCode getTxtKyuHihokenshaNo() {
        return txtKyuHihokenshaNo;
    }

    @JsonProperty("txtKyuHihokenshaNo")
    public void setTxtKyuHihokenshaNo(TextBoxCode txtKyuHihokenshaNo) {
        this.txtKyuHihokenshaNo=txtKyuHihokenshaNo;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtMusubitsukeTaishosha")
    public TextBox getTxtMusubitsukeTaishosha() {
        return txtMusubitsukeTaishosha;
    }

    @JsonProperty("txtMusubitsukeTaishosha")
    public void setTxtMusubitsukeTaishosha(TextBox txtMusubitsukeTaishosha) {
        this.txtMusubitsukeTaishosha=txtMusubitsukeTaishosha;
    }

}
