package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE0100001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE0100001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    要介護認定個人状況照会へ("要介護認定個人状況照会へ"),
    要介護認定情報提供へ("要介護認定情報提供へ"),
    主治医意見書登録へ("主治医意見書登録へ"),
    認定調査結果登録1へ("認定調査結果登録1へ"),
    完了処理("完了処理"),
    要介護認定イメージ情報管理へ("要介護認定イメージ情報管理へ"),
    個人依頼内容更新へ("個人依頼内容更新へ"),
    審査依頼受付へ("審査依頼受付へ");

    private final RString name;

    private DBE0100001TransitionEventName(String name) {
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
