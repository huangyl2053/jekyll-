package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public interface IShunoJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     */
    void load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号);
}
