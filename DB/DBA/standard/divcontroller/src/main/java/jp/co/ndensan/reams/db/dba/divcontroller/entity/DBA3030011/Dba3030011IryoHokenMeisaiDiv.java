package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA3030011;
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
 * Dba3030011IryoHokenMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class Dba3030011IryoHokenMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIryoHokenKanyuDate")
    private TextBoxFlexibleDate txtIryoHokenKanyuDate;
    @JsonProperty("txtIryoHokenDattaiDate")
    private TextBoxFlexibleDate txtIryoHokenDattaiDate;
    @JsonProperty("ddlIryoHokenShubetsu")
    private DropDownList ddlIryoHokenShubetsu;
    @JsonProperty("txtHokensha")
    private TextBoxCode txtHokensha;
    @JsonProperty("txtHokenshamei")
    private TextBox txtHokenshamei;
    @JsonProperty("txtIryoHokenKigoNo")
    private TextBox txtIryoHokenKigoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIryoHokenKanyuDate")
    public TextBoxFlexibleDate getTxtIryoHokenKanyuDate() {
        return txtIryoHokenKanyuDate;
    }

    @JsonProperty("txtIryoHokenKanyuDate")
    public void setTxtIryoHokenKanyuDate(TextBoxFlexibleDate txtIryoHokenKanyuDate) {
        this.txtIryoHokenKanyuDate=txtIryoHokenKanyuDate;
    }

    @JsonProperty("txtIryoHokenDattaiDate")
    public TextBoxFlexibleDate getTxtIryoHokenDattaiDate() {
        return txtIryoHokenDattaiDate;
    }

    @JsonProperty("txtIryoHokenDattaiDate")
    public void setTxtIryoHokenDattaiDate(TextBoxFlexibleDate txtIryoHokenDattaiDate) {
        this.txtIryoHokenDattaiDate=txtIryoHokenDattaiDate;
    }

    @JsonProperty("ddlIryoHokenShubetsu")
    public DropDownList getDdlIryoHokenShubetsu() {
        return ddlIryoHokenShubetsu;
    }

    @JsonProperty("ddlIryoHokenShubetsu")
    public void setDdlIryoHokenShubetsu(DropDownList ddlIryoHokenShubetsu) {
        this.ddlIryoHokenShubetsu=ddlIryoHokenShubetsu;
    }

    @JsonProperty("txtHokensha")
    public TextBoxCode getTxtHokensha() {
        return txtHokensha;
    }

    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBoxCode txtHokensha) {
        this.txtHokensha=txtHokensha;
    }

    @JsonProperty("txtHokenshamei")
    public TextBox getTxtHokenshamei() {
        return txtHokenshamei;
    }

    @JsonProperty("txtHokenshamei")
    public void setTxtHokenshamei(TextBox txtHokenshamei) {
        this.txtHokenshamei=txtHokenshamei;
    }

    @JsonProperty("txtIryoHokenKigoNo")
    public TextBox getTxtIryoHokenKigoNo() {
        return txtIryoHokenKigoNo;
    }

    @JsonProperty("txtIryoHokenKigoNo")
    public void setTxtIryoHokenKigoNo(TextBox txtIryoHokenKigoNo) {
        this.txtIryoHokenKigoNo=txtIryoHokenKigoNo;
    }

}
