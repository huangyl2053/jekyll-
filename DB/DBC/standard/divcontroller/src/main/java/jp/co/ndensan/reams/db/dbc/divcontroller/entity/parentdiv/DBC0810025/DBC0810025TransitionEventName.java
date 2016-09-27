package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810025;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0810025のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0810025TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    一覧に戻る("一覧に戻る"),
    基本情報("基本情報"),
    給付費明細("給付費明細"),
    特定診療費("特定診療費"),
    サービス計画費("サービス計画費"),
    合計費用("合計費用"),
    緊急時施設療養型("緊急時施設療養型"),
    緊急時_所定疾患("緊急時_所定疾患"),
    食事("食事"),
    請求額集計("請求額集計"),
    社福軽減額("社福軽減額"),
    給付費明細_住特("給付費明細_住特");

    private final RString name;

    private DBC0810025TransitionEventName(String name) {
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
