package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoChohyoShutsuryokujunDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoChohyoShutsuryokujun のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoChohyoShutsuryokujunDiv extends Panel implements IKaigoChohyoShutsuryokujunDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("kaigoChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv kaigoChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("kaigoChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getKaigoChohyoShutsuryokujun() {
        return kaigoChohyoShutsuryokujun;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
