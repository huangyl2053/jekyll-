package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5710002のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE5710002TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    要介護認定イメージ情報管理へ戻る("要介護認定イメージ情報管理へ戻る"),
    完了("完了");

    private final RString name;

    private DBE5710002TransitionEventName(String name) {
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
