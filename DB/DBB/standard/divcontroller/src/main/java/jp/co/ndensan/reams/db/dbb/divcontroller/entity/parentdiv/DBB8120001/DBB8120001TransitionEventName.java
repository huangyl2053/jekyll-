package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB8120001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBB8120001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    通知書作成("通知書作成"),
    完了("完了"),
    賦課エラー修正完了("賦課エラー修正完了"),
    前画面に戻る("前画面に戻る"),
    再検索する("再検索する"),
    検索結果一覧に戻る("検索結果一覧に戻る");

    private final RString name;

    private DBB8120001TransitionEventName(String name) {
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
