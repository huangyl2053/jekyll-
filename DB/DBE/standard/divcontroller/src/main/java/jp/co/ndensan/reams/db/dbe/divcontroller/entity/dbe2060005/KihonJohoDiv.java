package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005;
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
 * KihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokenNo")
    private TextBoxCode txtHokenNo;
    @JsonProperty("txtHihokenNo")
    private TextBoxCode txtHihokenNo;
    @JsonProperty("txtShinseibi")
    private TextBoxDate txtShinseibi;
    @JsonProperty("btnShinseiJohoSearch")
    private Button btnShinseiJohoSearch;
    @JsonProperty("ddlShinseiKbn")
    private DropDownList ddlShinseiKbn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHokenNo")
    public TextBoxCode getTxtHokenNo() {
        return txtHokenNo;
    }

    @JsonProperty("txtHokenNo")
    public void setTxtHokenNo(TextBoxCode txtHokenNo) {
        this.txtHokenNo=txtHokenNo;
    }

    @JsonProperty("txtHihokenNo")
    public TextBoxCode getTxtHihokenNo() {
        return txtHihokenNo;
    }

    @JsonProperty("txtHihokenNo")
    public void setTxtHihokenNo(TextBoxCode txtHihokenNo) {
        this.txtHihokenNo=txtHihokenNo;
    }

    @JsonProperty("txtShinseibi")
    public TextBoxDate getTxtShinseibi() {
        return txtShinseibi;
    }

    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.txtShinseibi=txtShinseibi;
    }

    @JsonProperty("btnShinseiJohoSearch")
    public Button getBtnShinseiJohoSearch() {
        return btnShinseiJohoSearch;
    }

    @JsonProperty("btnShinseiJohoSearch")
    public void setBtnShinseiJohoSearch(Button btnShinseiJohoSearch) {
        this.btnShinseiJohoSearch=btnShinseiJohoSearch;
    }

    @JsonProperty("ddlShinseiKbn")
    public DropDownList getDdlShinseiKbn() {
        return ddlShinseiKbn;
    }

    @JsonProperty("ddlShinseiKbn")
    public void setDdlShinseiKbn(DropDownList ddlShinseiKbn) {
        this.ddlShinseiKbn=ddlShinseiKbn;
    }

}
