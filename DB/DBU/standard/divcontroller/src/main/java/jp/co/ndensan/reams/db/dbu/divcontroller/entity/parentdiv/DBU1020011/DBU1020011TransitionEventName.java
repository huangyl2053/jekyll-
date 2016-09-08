package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1020011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBU1020011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBU1020011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    結果確認へ("結果確認へ"),
    照会依頼へ戻る("照会依頼へ戻る");

    private final RString name;

    private DBU1020011TransitionEventName(String name) {
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
