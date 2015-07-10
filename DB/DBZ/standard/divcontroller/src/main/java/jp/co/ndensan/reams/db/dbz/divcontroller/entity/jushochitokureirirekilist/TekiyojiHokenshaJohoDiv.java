package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;
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
 * TekiyojiHokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyojiHokenshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTekiyojiSochimotoHokensha")
    private DropDownList ddlTekiyojiSochimotoHokensha;
    @JsonProperty("ddlTekiyojiKyuHokensha")
    private DropDownList ddlTekiyojiKyuHokensha;
    @JsonProperty("ddlTekiyojiJuminJoho")
    private DropDownList ddlTekiyojiJuminJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTekiyojiSochimotoHokensha")
    public DropDownList getDdlTekiyojiSochimotoHokensha() {
        return ddlTekiyojiSochimotoHokensha;
    }

    @JsonProperty("ddlTekiyojiSochimotoHokensha")
    public void setDdlTekiyojiSochimotoHokensha(DropDownList ddlTekiyojiSochimotoHokensha) {
        this.ddlTekiyojiSochimotoHokensha=ddlTekiyojiSochimotoHokensha;
    }

    @JsonProperty("ddlTekiyojiKyuHokensha")
    public DropDownList getDdlTekiyojiKyuHokensha() {
        return ddlTekiyojiKyuHokensha;
    }

    @JsonProperty("ddlTekiyojiKyuHokensha")
    public void setDdlTekiyojiKyuHokensha(DropDownList ddlTekiyojiKyuHokensha) {
        this.ddlTekiyojiKyuHokensha=ddlTekiyojiKyuHokensha;
    }

    @JsonProperty("ddlTekiyojiJuminJoho")
    public DropDownList getDdlTekiyojiJuminJoho() {
        return ddlTekiyojiJuminJoho;
    }

    @JsonProperty("ddlTekiyojiJuminJoho")
    public void setDdlTekiyojiJuminJoho(DropDownList ddlTekiyojiJuminJoho) {
        this.ddlTekiyojiJuminJoho=ddlTekiyojiJuminJoho;
    }

}
