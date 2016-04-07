package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2310001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBE-0070-010 chengsanyuan
 */
public enum DBE2310001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    申請者検索に戻る("申請者検索に戻る"),
    申請者検索結果一覧に戻る("申請者検索結果一覧に戻る"),
    処理完了("処理完了");

    private final RString name;

    private DBE2310001TransitionEventName(String name) {
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
