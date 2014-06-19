package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuJumin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuJuminDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CommonKogakuNushiJuminJohoChildDiv1")
    private KaigoAtenaInfoDiv CommonKogakuNushiJuminJohoChildDiv1;
    @JsonProperty("CommonKogakuKaigoJuminJohoChildDiv2")
    private KaigoShikakuKihonDiv CommonKogakuKaigoJuminJohoChildDiv2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("CommonKogakuNushiJuminJohoChildDiv1")
    public KaigoAtenaInfoDiv getCommonKogakuNushiJuminJohoChildDiv1() {
        return CommonKogakuNushiJuminJohoChildDiv1;
    }

    @JsonProperty("CommonKogakuNushiJuminJohoChildDiv1")
    public void setCommonKogakuNushiJuminJohoChildDiv1(KaigoAtenaInfoDiv CommonKogakuNushiJuminJohoChildDiv1) {
        this.CommonKogakuNushiJuminJohoChildDiv1=CommonKogakuNushiJuminJohoChildDiv1;
    }

    @JsonProperty("CommonKogakuKaigoJuminJohoChildDiv2")
    public KaigoShikakuKihonDiv getCommonKogakuKaigoJuminJohoChildDiv2() {
        return CommonKogakuKaigoJuminJohoChildDiv2;
    }

    @JsonProperty("CommonKogakuKaigoJuminJohoChildDiv2")
    public void setCommonKogakuKaigoJuminJohoChildDiv2(KaigoShikakuKihonDiv CommonKogakuKaigoJuminJohoChildDiv2) {
        this.CommonKogakuKaigoJuminJohoChildDiv2=CommonKogakuKaigoJuminJohoChildDiv2;
    }

}
