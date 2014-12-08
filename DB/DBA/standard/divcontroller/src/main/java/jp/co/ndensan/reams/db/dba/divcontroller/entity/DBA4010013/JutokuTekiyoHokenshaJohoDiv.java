package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
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
 * JutokuTekiyoHokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuTekiyoHokenshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTekiyoShozaiHokensha")
    private DropDownList ddlTekiyoShozaiHokensha;
    @JsonProperty("ddlTekiyoSochimotoHokensha")
    private DropDownList ddlTekiyoSochimotoHokensha;
    @JsonProperty("ddlTekiyoKyuHokensha")
    private DropDownList ddlTekiyoKyuHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlTekiyoShozaiHokensha")
    public DropDownList getDdlTekiyoShozaiHokensha() {
        return ddlTekiyoShozaiHokensha;
    }

    @JsonProperty("ddlTekiyoShozaiHokensha")
    public void setDdlTekiyoShozaiHokensha(DropDownList ddlTekiyoShozaiHokensha) {
        this.ddlTekiyoShozaiHokensha=ddlTekiyoShozaiHokensha;
    }

    @JsonProperty("ddlTekiyoSochimotoHokensha")
    public DropDownList getDdlTekiyoSochimotoHokensha() {
        return ddlTekiyoSochimotoHokensha;
    }

    @JsonProperty("ddlTekiyoSochimotoHokensha")
    public void setDdlTekiyoSochimotoHokensha(DropDownList ddlTekiyoSochimotoHokensha) {
        this.ddlTekiyoSochimotoHokensha=ddlTekiyoSochimotoHokensha;
    }

    @JsonProperty("ddlTekiyoKyuHokensha")
    public DropDownList getDdlTekiyoKyuHokensha() {
        return ddlTekiyoKyuHokensha;
    }

    @JsonProperty("ddlTekiyoKyuHokensha")
    public void setDdlTekiyoKyuHokensha(DropDownList ddlTekiyoKyuHokensha) {
        this.ddlTekiyoKyuHokensha=ddlTekiyoKyuHokensha;
    }

}
