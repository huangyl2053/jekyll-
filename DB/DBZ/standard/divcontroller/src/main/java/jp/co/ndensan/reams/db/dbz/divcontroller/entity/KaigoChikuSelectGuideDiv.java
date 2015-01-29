package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoChikuSelectGuide のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoChikuSelectGuideDiv extends Panel implements IKaigoChikuSelectGuideDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("TanitsuShichoson")
    private TanitsuShichosonDiv TanitsuShichoson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TanitsuShichoson")
    public TanitsuShichosonDiv getTanitsuShichoson() {
        return TanitsuShichoson;
    }

    @JsonProperty("TanitsuShichoson")
    public void setTanitsuShichoson(TanitsuShichosonDiv TanitsuShichoson) {
        this.TanitsuShichoson = TanitsuShichoson;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlSelectTaisho() {
        return this.getTanitsuShichoson().getDdlChiku();
    }

    @JsonIgnore
    public void setDdlSelectTaisho(DropDownList ddlSelectTaisho) {
        this.getTanitsuShichoson().setDdlChiku(ddlSelectTaisho);
    }

    //--------------- この行より下にコードを追加してください -------------------
}
