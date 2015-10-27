package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.Kiwarigaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 期割額Divのインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKiwarigakuDiv {

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     */
    void initialize(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時);
}
