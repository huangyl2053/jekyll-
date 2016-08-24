package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0320001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBB0320001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索に戻る("検索に戻る"),
    完了("完了"),
    世帯員所得("世帯員所得"),
    特別徴収("特別徴収"),
    減免("減免"),
    比較("比較"),
    一覧に戻る("一覧に戻る"),
    総合照会賦課情報("総合照会賦課情報");

    private final RString name;

    private DBB0320001TransitionEventName(String name) {
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
