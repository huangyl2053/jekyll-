package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IJushochiTokureiDialogButtonDiv extends ICommonChildDivBaseProperties {

    /**
     * ダイアログが正しく開けるように初期化をします。
     *
     * @param hihoData 被保険者台帳データ
     * @param hihoNo 被保険者番号
     * @param shutokuDate 資格取得年月日
     * @param state 開いたダイアログの状態を指定。
     */
    public void initialize(IItemList<HihokenshaDaicho> hihoData, HihokenshaNo hihoNo, FlexibleDate shutokuDate, JushochiTokureiState state);

    /**
     * ダイアログ内で修正された住所地特例データを反映した、被保険者台帳情報を取得します。
     *
     * @return
     */
    public IItemList<HihokenshaDaicho> get修正後被保険者データ();
}
