package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0710021のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0710021TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    to償還払決定情報("to償還払決定情報"),
    処理完了("処理完了"),
    to住宅改修費事前申請登録("to住宅改修費事前申請登録"),
    to申請一覧("to申請一覧"),
    to受領委任契約番号検索("to受領委任契約番号検索"),
    戻る("戻る");

    private final RString name;

    private DBC0710021TransitionEventName(String name) {
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
