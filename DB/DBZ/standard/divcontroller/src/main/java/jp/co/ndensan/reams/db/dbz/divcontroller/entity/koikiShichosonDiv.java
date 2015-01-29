package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * koikiShichoson のクラスファイル 
 * 
 * @author 自動生成
 */
public class koikiShichosonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShichoson")
    private DropDownList ddlShichoson;
    @JsonProperty("ddlKyushichosonKoiki")
    private DropDownList ddlKyushichosonKoiki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlShichoson")
    public DropDownList getDdlShichoson() {
        return ddlShichoson;
    }

    @JsonProperty("ddlShichoson")
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.ddlShichoson=ddlShichoson;
    }

    @JsonProperty("ddlKyushichosonKoiki")
    public DropDownList getDdlKyushichosonKoiki() {
        return ddlKyushichosonKoiki;
    }

    @JsonProperty("ddlKyushichosonKoiki")
    public void setDdlKyushichosonKoiki(DropDownList ddlKyushichosonKoiki) {
        this.ddlKyushichosonKoiki=ddlKyushichosonKoiki;
    }

}
