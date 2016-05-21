package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE4020001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE4020001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    介護認定審査会審査結果登録_OCR_へ遷移する("介護認定審査会審査結果登録_OCR_へ遷移する"),
    審査会対象者個別結果登録へ遷移する("審査会対象者個別結果登録へ遷移する"),
    処理完了("処理完了");

    private final RString name;

    private DBE4020001TransitionEventName(String name) {
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
