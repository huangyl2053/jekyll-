package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0320003のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBB0320003TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索に戻る("検索に戻る"),
    履歴("履歴"),
    期割("期割"),
    世帯員所得("世帯員所得"),
    減免("減免"),
    初期化("初期化");

    private final RString name;

    private DBB0320003TransitionEventName(String name) {
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
