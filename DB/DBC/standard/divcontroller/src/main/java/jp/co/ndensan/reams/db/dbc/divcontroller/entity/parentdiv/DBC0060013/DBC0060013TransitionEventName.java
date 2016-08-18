package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060013;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0060013のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0060013TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索結果一覧へ("検索結果一覧へ"),
    短期入所サービスへ("短期入所サービスへ");

    private final RString name;

    private DBC0060013TransitionEventName(String name) {
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
