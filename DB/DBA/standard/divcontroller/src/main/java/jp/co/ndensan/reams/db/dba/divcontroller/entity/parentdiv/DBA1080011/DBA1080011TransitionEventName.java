package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBA1080011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBA1080011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    除外者登録へ("除外者登録へ"),
    年齢到達条件へ("年齢到達条件へ"),
    完了状態へ("完了状態へ"),
    終了する("終了する");

    private final RString name;

    private DBA1080011TransitionEventName(String name) {
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
