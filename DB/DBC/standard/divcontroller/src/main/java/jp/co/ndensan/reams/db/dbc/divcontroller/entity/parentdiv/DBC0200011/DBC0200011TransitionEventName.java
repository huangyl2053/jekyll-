package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0200011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public enum DBC0200011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    バッチ起動("バッチ起動"),
    スケジュール設定へ("スケジュール設定へ"),
    戻る("戻る");

    private final RString name;

    private DBC0200011TransitionEventName(String name) {
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
