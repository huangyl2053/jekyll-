package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD8010003のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBD8010003TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了"),
    対象者検索条件へ("対象者検索条件へ"),
    対象者該当者一覧へ("対象者該当者一覧へ");

    private final RString name;

    private DBD8010003TransitionEventName(String name) {
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
