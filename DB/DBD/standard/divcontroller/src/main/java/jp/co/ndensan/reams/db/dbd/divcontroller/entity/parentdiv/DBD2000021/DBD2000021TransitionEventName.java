package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2000021;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBD2000021のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBD2000021TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    初期表示("初期表示"),
    終了("終了"),
    再検索("再検索"),
    検索結果一覧("検索結果一覧"),
    判定実行("判定実行");

    private final RString name;

    private DBD2000021TransitionEventName(String name) {
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
