package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0300001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.IHihokenshaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchCondition のクラスファイル
 *
 * @author 自動生成
 */
//TODO n3317 塚田萌　ビルドを通すための暫定対応。再生成してください。
public class SearchConditionDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdSearchCondition")
    private IHihokenshaFinderDiv ccdSearchCondition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdSearchCondition")
    public IHihokenshaFinderDiv getCcdSearchCondition() {
        return ccdSearchCondition;
    }
}
