package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5710001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE5710001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索へ戻る("検索へ戻る"),
    要介護認定イメージ情報出力へ("要介護認定イメージ情報出力へ"),
    要介護認定イメージ情報削除へ("要介護認定イメージ情報削除へ"),
    完了("完了");

    private final RString name;

    private DBE5710001TransitionEventName(String name) {
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
