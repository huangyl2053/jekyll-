package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0810011のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0810011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    福祉用具購入費支給("福祉用具購入費支給"),
    住宅改修費事前申請("住宅改修費事前申請"),
    住宅改修費支給申請("住宅改修費支給申請"),
    償還払い費支給申請("償還払い費支給申請"),
    検索に戻る("検索に戻る"),
    処理完了("処理完了");

    private final RString name;

    private DBC0810011TransitionEventName(String name) {
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
