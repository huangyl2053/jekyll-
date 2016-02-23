package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kiwarigaku.Kiwarigaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKiwarigakuDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    void load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, Decimal 履歴番号);
}
