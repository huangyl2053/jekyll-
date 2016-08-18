package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8140011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC8140011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-4850-010 chenyadong
 */
public enum DBC8140011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    該当者検索へ("該当者検索へ"),
    完了("完了"),
    検索結果一覧へ("検索結果一覧へ");

    private final RString name;

    private DBC8140011TransitionEventName(String name) {
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
