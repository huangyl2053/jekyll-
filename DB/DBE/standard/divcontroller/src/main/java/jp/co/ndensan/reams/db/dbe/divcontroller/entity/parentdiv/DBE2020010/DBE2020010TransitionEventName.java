package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020010のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE2020010TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    更新_スケジュール詳細に戻る("更新_スケジュール詳細に戻る"),
    照会_該当者一覧に戻る("照会_該当者一覧に戻る"),
    未定者_スケジュール詳細に戻る("未定者_スケジュール詳細に戻る"),
    更新_対象者を検索する("更新_対象者を検索する"),
    処理完了("処理完了");

    private final RString name;

    private DBE2020010TransitionEventName(String name) {
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
