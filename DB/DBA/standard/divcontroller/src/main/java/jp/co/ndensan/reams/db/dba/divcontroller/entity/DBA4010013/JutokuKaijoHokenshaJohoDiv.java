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
 * JutokuKaijoHokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuKaijoHokenshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKaijoShozaiHokensha")
    private DropDownList ddlKaijoShozaiHokensha;
    @JsonProperty("ddlKaijoSochimotoHokensha")
    private DropDownList ddlKaijoSochimotoHokensha;
    @JsonProperty("ddlKaijoKyuHokensha")
    private DropDownList ddlKaijoKyuHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlKaijoShozaiHokensha")
    public DropDownList getDdlKaijoShozaiHokensha() {
        return ddlKaijoShozaiHokensha;
    }

    @JsonProperty("ddlKaijoShozaiHokensha")
    public void setDdlKaijoShozaiHokensha(DropDownList ddlKaijoShozaiHokensha) {
        this.ddlKaijoShozaiHokensha=ddlKaijoShozaiHokensha;
    }

    @JsonProperty("ddlKaijoSochimotoHokensha")
    public DropDownList getDdlKaijoSochimotoHokensha() {
        return ddlKaijoSochimotoHokensha;
    }

    @JsonProperty("ddlKaijoSochimotoHokensha")
    public void setDdlKaijoSochimotoHokensha(DropDownList ddlKaijoSochimotoHokensha) {
        this.ddlKaijoSochimotoHokensha=ddlKaijoSochimotoHokensha;
    }

    @JsonProperty("ddlKaijoKyuHokensha")
    public DropDownList getDdlKaijoKyuHokensha() {
        return ddlKaijoKyuHokensha;
    }

    @JsonProperty("ddlKaijoKyuHokensha")
    public void setDdlKaijoKyuHokensha(DropDownList ddlKaijoKyuHokensha) {
        this.ddlKaijoKyuHokensha=ddlKaijoKyuHokensha;
    }

}
