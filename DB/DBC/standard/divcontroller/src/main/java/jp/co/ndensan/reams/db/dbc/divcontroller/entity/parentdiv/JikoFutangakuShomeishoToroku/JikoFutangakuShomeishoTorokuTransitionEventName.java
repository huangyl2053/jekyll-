package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JikoFutangakuShomeishoToroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * JikoFutangakuShomeishoTorokuのイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum JikoFutangakuShomeishoTorokuTransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    対象者検索に戻る("対象者検索に戻る"),
    検索結果一覧に戻る("検索結果一覧に戻る"),
    処理完了("処理完了");

    private final RString name;

    private JikoFutangakuShomeishoTorokuTransitionEventName(String name) {
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
