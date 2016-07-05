/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.taino;

import jp.co.ndensan.reams.db.dbd.definition.core.common.TokuchoFuchoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.JikoGoShunyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.taino.ShunyuSummaryEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.taino.TainoJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 滞納情報Entityのクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
public final class TainoKiSummaryBuilder {

    private TainoKiSummaryBuilder() {
    }

    /**
     * 滞納情報を作成
     *
     * @param relateEntity 滞納情報Entity
     * @param 基準日 基準日
     * @return 滞納情報
     */
    public static TainoKiSummary createTainoKiSummary(TainoJohoRelateEntity relateEntity, FlexibleDate 基準日) {
        Decimal 収入額合計 = Decimal.ZERO;
        FlexibleDate 最大収入日 = FlexibleDate.MIN;
        Decimal 最大収入 = Decimal.ZERO;
        JikoKisanbiKubun 時効起算日区分 = JikoKisanbiKubun.不明_調定無し;

        for (ShunyuSummaryEntity entity : relateEntity.get収入リスト()) {
            収入額合計 = 収入額合計.add(entity.get収入額());
            if (最大収入.compareTo(entity.get収入額()) < 0) {
                最大収入日 = new FlexibleDate(entity.get収入年月日().toDateString());
            }
        }
        FlexibleDate 時効起算日 = FlexibleDate.MIN;
        if (relateEntity.get時効起算年月日() != null && !relateEntity.get時効起算年月日().isEmpty()
                && 時効起算日.isBeforeOrEquals(relateEntity.get時効起算年月日())) {
            時効起算日 = relateEntity.get時効起算年月日();
            時効起算日区分 = JikoKisanbiKubun.toValue(relateEntity.get時効起算日区分());
        }
        if (relateEntity.get督促状発行年月日() != null && 時効起算日.isBeforeOrEquals(new FlexibleDate(relateEntity.get督促状発行年月日().toString()))) {
            時効起算日 = new FlexibleDate(relateEntity.get督促状発行年月日().toString());
            時効起算日区分 = JikoKisanbiKubun.督促状発行日;
        }
        if (relateEntity.get納期限() != null && 時効起算日.isBeforeOrEquals(new FlexibleDate(relateEntity.get納期限().plusDay(1).toString()))) {
            時効起算日 = new FlexibleDate(relateEntity.get納期限().plusDay(1).toString());
            時効起算日区分 = JikoKisanbiKubun.納期限翌日;
        }
        if (FlexibleDate.MIN.equals(時効起算日)) {
            時効起算日区分 = JikoKisanbiKubun.不明_調定無し;
            時効起算日 = FlexibleDate.EMPTY;
        } else {
            時効起算日 = new FlexibleDate(時効起算日.toString());
        }
        for (ShunyuSummaryEntity entity : relateEntity.get収入リスト()) {
            if (entity.get収入年月日() != null) {
                FlexibleDate 収入年月日 = new FlexibleDate(entity.get収入年月日().toDateString());
                if (時効起算日.plusYear(2).isBeforeOrEquals(収入年月日)) {
                    continue;
                }
                if (収入年月日.isBefore(時効起算日.plusYear(2)) && 時効起算日.isBefore(収入年月日)) {
                    時効起算日 = 収入年月日;
                    時効起算日区分 = JikoKisanbiKubun.収入日;
                }
            }
        }
        Decimal 滞納額 = ObjectUtil.defaultIfNull(relateEntity.get調定額(), Decimal.ZERO).subtract(収入額合計);
        MinoKannoKubun 未納完納区分 = get未納完納区分(relateEntity, 基準日, 滞納額);
        return new TainoKiSummary(
                relateEntity.get賦課年度(),
                relateEntity.get調定年度(),
                !relateEntity.get調定年度().equals(relateEntity.get賦課年度()),
                relateEntity.get期(),
                relateEntity.get調定額(),
                収入額合計,
                滞納額,
                relateEntity.get納期限(),
                時効起算日,
                時効起算日区分,
                未納完納区分,
                get時効区分(時効起算日, 基準日, 未納完納区分),
                relateEntity.get通知書番号(),
                TokuchoFuchoKubun.toValue(relateEntity.get徴収方法()),
                最大収入日.isBefore(時効起算日) ? JikoGoShunyuKubun.なし : JikoGoShunyuKubun.あり,
                TaishoHanteiKubun._空,
                Decimal.ZERO);
    }

    private static MinoKannoKubun get未納完納区分(TainoJohoRelateEntity relateEntity, FlexibleDate 基準日, Decimal 滞納額) {
        if (基準日.isBefore(new FlexibleDate(relateEntity.get納期限().toString()))) {
            return MinoKannoKubun.未来納期;
        }
        if ((relateEntity.get時効起算年月日() == null || relateEntity.get時効起算年月日().isEmpty()) || Decimal.ZERO.equals(relateEntity.get調定額())) {
            return MinoKannoKubun._0円;
        }
        if (Decimal.ZERO.equals(滞納額)) {
            return MinoKannoKubun.完納;
        } else if (Decimal.ZERO.compareTo(滞納額) < 0) {
            return MinoKannoKubun.未納あり;
        } else {
            return MinoKannoKubun.過納;
        }
    }

    private static JikoKubun get時効区分(FlexibleDate 時効起算日, FlexibleDate 基準日, MinoKannoKubun 未納完納区分) {
        if (MinoKannoKubun.未納あり.equals(未納完納区分)) {
            if (時効起算日.plusYear(2).isBeforeOrEquals(基準日)) {
                return JikoKubun.時効到来;
            } else {
                return JikoKubun.時効未到来;
            }
        } else {
            return JikoKubun.空;
        }
    }
}
