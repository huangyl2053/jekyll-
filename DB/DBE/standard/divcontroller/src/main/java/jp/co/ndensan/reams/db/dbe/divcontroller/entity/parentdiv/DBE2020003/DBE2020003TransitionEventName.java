package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE2020003のイベント名定義クラスです</br>
 *
 * @reamsid_L DBE-0020-030 wanghui
 */
public enum DBE2020003TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    更新モード_スケジュール入力に戻る("更新モード_スケジュール入力に戻る"),
    照会モード_スケジュール一覧に戻る("照会モード_スケジュール一覧に戻る"),
    未定モード_スケジュール一覧に戻る("未定モード_スケジュール一覧に戻る"),
    更新モード_該当者選択("更新モード_該当者選択"),
    照会モード_該当者選択("照会モード_該当者選択"),
    未定モード_該当者選択("未定モード_該当者選択");

    private final RString name;

    private DBE2020003TransitionEventName(String name) {
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
