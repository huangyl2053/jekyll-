package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002;
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
 * Iryohokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryohokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIryohokenType")
    private DropDownList ddlIryohokenType;
    @JsonProperty("txtIryohokenshaNo")
    private TextBoxCode txtIryohokenshaNo;
    @JsonProperty("txtIryohokenshaName")
    private TextBox txtIryohokenshaName;
    @JsonProperty("txtIryohokenKigo")
    private TextBoxCode txtIryohokenKigo;
    @JsonProperty("txtIryohokenBango")
    private TextBoxCode txtIryohokenBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlIryohokenType")
    public DropDownList getDdlIryohokenType() {
        return ddlIryohokenType;
    }

    @JsonProperty("ddlIryohokenType")
    public void setDdlIryohokenType(DropDownList ddlIryohokenType) {
        this.ddlIryohokenType=ddlIryohokenType;
    }

    @JsonProperty("txtIryohokenshaNo")
    public TextBoxCode getTxtIryohokenshaNo() {
        return txtIryohokenshaNo;
    }

    @JsonProperty("txtIryohokenshaNo")
    public void setTxtIryohokenshaNo(TextBoxCode txtIryohokenshaNo) {
        this.txtIryohokenshaNo=txtIryohokenshaNo;
    }

    @JsonProperty("txtIryohokenshaName")
    public TextBox getTxtIryohokenshaName() {
        return txtIryohokenshaName;
    }

    @JsonProperty("txtIryohokenshaName")
    public void setTxtIryohokenshaName(TextBox txtIryohokenshaName) {
        this.txtIryohokenshaName=txtIryohokenshaName;
    }

    @JsonProperty("txtIryohokenKigo")
    public TextBoxCode getTxtIryohokenKigo() {
        return txtIryohokenKigo;
    }

    @JsonProperty("txtIryohokenKigo")
    public void setTxtIryohokenKigo(TextBoxCode txtIryohokenKigo) {
        this.txtIryohokenKigo=txtIryohokenKigo;
    }

    @JsonProperty("txtIryohokenBango")
    public TextBoxCode getTxtIryohokenBango() {
        return txtIryohokenBango;
    }

    @JsonProperty("txtIryohokenBango")
    public void setTxtIryohokenBango(TextBoxCode txtIryohokenBango) {
        this.txtIryohokenBango=txtIryohokenBango;
    }

}
