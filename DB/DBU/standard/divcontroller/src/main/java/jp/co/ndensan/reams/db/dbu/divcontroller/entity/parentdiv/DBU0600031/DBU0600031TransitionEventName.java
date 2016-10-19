package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0600031のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU0600031TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    対象者検索に戻る("対象者検索に戻る"),
    総合照会資格得喪情報("総合照会資格得喪情報"),
    総合照会受給者情報("総合照会受給者情報"),
    総合照会賦課情報("総合照会賦課情報"),
    総合照会住民固有情報("総合照会住民固有情報"),
    居宅サービス計画情報("居宅サービス計画情報"),
    償還払い情報("償還払い情報"),
    高額サービス費情報("高額サービス費情報"),
    給付実績情報("給付実績情報"),
    完了("完了");

    private final RString name;

    private DBU0600031TransitionEventName(String name) {
        this.name = new RString(name);
    }

    /**
     * getName
     *
     * @return 名前
     */
    @Override
    public RString getName() {
        return name;
    }
// </editor-fold>
}
