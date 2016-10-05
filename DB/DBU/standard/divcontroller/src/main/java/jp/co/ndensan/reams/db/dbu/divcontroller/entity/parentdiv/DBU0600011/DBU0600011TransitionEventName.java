package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU0600011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU0600011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了"),
    検索に戻る("検索に戻る"),
    総合照会受給情報("総合照会受給情報"),
    総合照会給付情報("総合照会給付情報"),
    総合照会賦課情報("総合照会賦課情報"),
    総合照会住民情報("総合照会住民情報"),
    総合照会他市町村住所地特例者情報("総合照会他市町村住所地特例者情報"),
    総合照会被保険者情報("総合照会被保険者情報"),
    総合照会適用除外情報("総合照会適用除外情報");

    private final RString name;

    private DBU0600011TransitionEventName(String name) {
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
