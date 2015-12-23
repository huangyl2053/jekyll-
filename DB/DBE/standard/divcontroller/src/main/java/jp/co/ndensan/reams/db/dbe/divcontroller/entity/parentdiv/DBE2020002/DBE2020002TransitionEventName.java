package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020002;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020002のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE2020002TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    更新モード_スケジュール入力("更新モード_スケジュール入力"),
    未定モード_スケジュール入力("未定モード_スケジュール入力"),
    更新モード_スケジュール一覧に戻る("更新モード_スケジュール一覧に戻る"),
    未定モード_該当者一覧に戻る("未定モード_該当者一覧に戻る"),
    メモ入力("メモ入力");

    private final RString name;

    private DBE2020002TransitionEventName(String name) {
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
