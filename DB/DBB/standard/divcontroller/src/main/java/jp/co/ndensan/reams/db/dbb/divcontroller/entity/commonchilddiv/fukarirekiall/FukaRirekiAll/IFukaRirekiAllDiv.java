package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll;

import jp.co.ndensan.reams.db.dbb.business.core.FukaRireki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IFukaRirekiAllDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 表示件数
     */
    int load(HihokenshaNo 被保険者番号);

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return 表示件数
     */
    int load(HihokenshaNo 被保険者番号, FukaNendo 賦課年度);

    /**
     * 調定年度、賦課年度、通知書番号に該当する処理日時の直近データをDivに設定します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return 表示件数
     */
    int load(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号);

    /**
     * 通知書番号に該当する処理日時の直近データをDivに設定します。
     *
     * @param 通知書番号 通知書番号
     * @return 表示件数
     */
    int reload(TsuchishoNo 通知書番号);

    /**
     * 引数の被保険者番号に該当するデータをDivに設定し、調定年度、賦課年度、通知書番号に該当する行を選択状態にします。
     *
     * @param 被保険者番号 被保険者番号
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return 表示件数
     */
    int reload(HihokenshaNo 被保険者番号, ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号);

    /**
     * 選択されている行の賦課履歴を返します。行が選択されていない場合は全賦課履歴を返します。
     *
     * @return 賦課履歴
     */
    FukaRireki get賦課履歴();

}
