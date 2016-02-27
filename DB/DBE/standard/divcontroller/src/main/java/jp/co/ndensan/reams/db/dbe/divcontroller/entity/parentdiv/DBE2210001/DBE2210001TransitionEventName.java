package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2210001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE2210001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索結果一覧に戻る("検索結果一覧に戻る"),
    特記事項一覧を表示("特記事項一覧を表示"),
    概況特記入力を表示("概況特記入力を表示"),
    処理終了("処理終了");

    private final RString name;

    private DBE2210001TransitionEventName(String name) {
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
