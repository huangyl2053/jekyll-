package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE5140002のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE5140002TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    開催予定登録に戻る("開催予定登録に戻る"),
    完了("完了"),
    検索結果一覧に戻る("検索結果一覧に戻る");

    private final RString name;

    private DBE5140002TransitionEventName(String name) {
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
