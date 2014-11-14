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
 * kaijojiHokenshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class kaijojiHokenshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKaijojiShozaiHokensha")
    private DropDownList ddlKaijojiShozaiHokensha;
    @JsonProperty("ddlKaijojiSochimotoHokensha")
    private DropDownList ddlKaijojiSochimotoHokensha;
    @JsonProperty("ddlKaijojiKyuHokensha")
    private DropDownList ddlKaijojiKyuHokensha;
    @JsonProperty("ddlKaijojiJuminJono")
    private DropDownList ddlKaijojiJuminJono;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlKaijojiShozaiHokensha")
    public DropDownList getDdlKaijojiShozaiHokensha() {
        return ddlKaijojiShozaiHokensha;
    }

    @JsonProperty("ddlKaijojiShozaiHokensha")
    public void setDdlKaijojiShozaiHokensha(DropDownList ddlKaijojiShozaiHokensha) {
        this.ddlKaijojiShozaiHokensha=ddlKaijojiShozaiHokensha;
    }

    @JsonProperty("ddlKaijojiSochimotoHokensha")
    public DropDownList getDdlKaijojiSochimotoHokensha() {
        return ddlKaijojiSochimotoHokensha;
    }

    @JsonProperty("ddlKaijojiSochimotoHokensha")
    public void setDdlKaijojiSochimotoHokensha(DropDownList ddlKaijojiSochimotoHokensha) {
        this.ddlKaijojiSochimotoHokensha=ddlKaijojiSochimotoHokensha;
    }

    @JsonProperty("ddlKaijojiKyuHokensha")
    public DropDownList getDdlKaijojiKyuHokensha() {
        return ddlKaijojiKyuHokensha;
    }

    @JsonProperty("ddlKaijojiKyuHokensha")
    public void setDdlKaijojiKyuHokensha(DropDownList ddlKaijojiKyuHokensha) {
        this.ddlKaijojiKyuHokensha=ddlKaijojiKyuHokensha;
    }

    @JsonProperty("ddlKaijojiJuminJono")
    public DropDownList getDdlKaijojiJuminJono() {
        return ddlKaijojiJuminJono;
    }

    @JsonProperty("ddlKaijojiJuminJono")
    public void setDdlKaijojiJuminJono(DropDownList ddlKaijojiJuminJono) {
        this.ddlKaijojiJuminJono=ddlKaijojiJuminJono;
    }

}
