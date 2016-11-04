package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShikakuHenkoRirekiDialogButtonDiv extends ICommonChildDivBaseProperties {

    /**
     * 資格変更履歴ダイアログを開くための初期化処理を行います。
     *
     * @param hihoData 被保険者台帳
     * @param hihoNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @param shutokuDate 資格取得日
     * @param state 状態
     */
    void initialize(IItemList<HihokenshaDaicho> hihoData, HihokenshaNo hihoNo, ShikibetsuCode shikibetsuCode,
            FlexibleDate shutokuDate, ShikakuHenkoState state);

    /**
     * ダイアログ内で修正されたデータを反映した被保険者台帳データを取得します。
     *
     * @return
     */
    IItemList<HihokenshaDaicho> get修正後被保険者データ();
}
