package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA2010013のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBA2010013TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    サービス追加("サービス追加"),
    サービス修正("サービス修正"),
    サービス削除("サービス削除"),
    事業者保存("事業者保存"),
    完了("完了"),
    検索に戻る("検索に戻る");

    private final RString name;

    private DBA2010013TransitionEventName(String name) {
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
