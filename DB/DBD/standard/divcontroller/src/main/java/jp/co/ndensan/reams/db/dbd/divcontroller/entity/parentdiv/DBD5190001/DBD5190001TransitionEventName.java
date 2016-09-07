package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD5190001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBD5190001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    被保険者検索("被保険者検索"),
    完了状態("完了状態"),
    被保険者番号選択("被保険者番号選択");

    private final RString name;

    private DBD5190001TransitionEventName(String name) {
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
