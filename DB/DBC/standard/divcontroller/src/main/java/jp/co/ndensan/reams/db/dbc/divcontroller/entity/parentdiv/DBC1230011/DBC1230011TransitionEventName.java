package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1230011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public enum DBC1230011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    初期表示("初期表示"),
    完了("完了"),
    対象者検索に戻る("対象者検索に戻る"),
    検索結果一覧に戻る("検索結果一覧に戻る");

    private final RString name;

    private DBC1230011TransitionEventName(String name) {
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
