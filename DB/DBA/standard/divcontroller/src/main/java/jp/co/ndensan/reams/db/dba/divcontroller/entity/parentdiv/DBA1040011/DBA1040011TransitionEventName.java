package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1040011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA1040011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBA1040011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    再検索("再検索"),
    完了("完了"),
    検索結果一覧へ("検索結果一覧へ");

    private final RString name;

    private DBA1040011TransitionEventName(String name) {
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
