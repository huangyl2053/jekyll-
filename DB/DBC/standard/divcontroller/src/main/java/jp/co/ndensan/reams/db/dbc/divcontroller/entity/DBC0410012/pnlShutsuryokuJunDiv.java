package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * pnlShutsuryokuJun のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlShutsuryokuJunDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CommonShutsuryokuJun")
    private ChohyoShutsuryokujunDiv CommonShutsuryokuJun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("CommonShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCommonShutsuryokuJun() {
        return CommonShutsuryokuJun;
    }

}
