package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shikakuhenkorireki;
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
 * HenkoHokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HenkoHokenshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHenkoSochimotoHokensha")
    private DropDownList ddlHenkoSochimotoHokensha;
    @JsonProperty("ddlHenkoKyuHokensha")
    private DropDownList ddlHenkoKyuHokensha;
    @JsonProperty("ddlJuminJoho")
    private DropDownList ddlJuminJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHenkoSochimotoHokensha")
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return ddlHenkoSochimotoHokensha;
    }

    @JsonProperty("ddlHenkoSochimotoHokensha")
    public void setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.ddlHenkoSochimotoHokensha=ddlHenkoSochimotoHokensha;
    }

    @JsonProperty("ddlHenkoKyuHokensha")
    public DropDownList getDdlHenkoKyuHokensha() {
        return ddlHenkoKyuHokensha;
    }

    @JsonProperty("ddlHenkoKyuHokensha")
    public void setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.ddlHenkoKyuHokensha=ddlHenkoKyuHokensha;
    }

    @JsonProperty("ddlJuminJoho")
    public DropDownList getDdlJuminJoho() {
        return ddlJuminJoho;
    }

    @JsonProperty("ddlJuminJoho")
    public void setDdlJuminJoho(DropDownList ddlJuminJoho) {
        this.ddlJuminJoho=ddlJuminJoho;
    }

}
