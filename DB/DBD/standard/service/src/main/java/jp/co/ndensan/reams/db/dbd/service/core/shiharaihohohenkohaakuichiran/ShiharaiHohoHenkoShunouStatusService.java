/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenkohaakuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuOneEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShunoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShunyuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShunoStatusTempTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成サービスクラスです．
 *
 * @reamsid_L DBD-36500-040 x_lilh
 */
public class ShiharaiHohoHenkoShunouStatusService {

    private static final int 年_3 = 3;

    private static boolean is時効起算日;
    private static boolean is督促状発行年月日;
    private static boolean is納期限の翌日;
    private static boolean is収入年月日;

    /**
     * Intanceを作成します。
     *
     * @return ShiharaiHohoHenkoShunouStatusService
     */
    public static ShiharaiHohoHenkoShunouStatusService createIntance() {
        return InstanceProvider.create(ShiharaiHohoHenkoShunouStatusService.class);
    }

    /**
     * 完納_未納区分を取得します．
     *
     * @param 基準日 基準日
     * @param 納期限 納期限
     * @param 調定額 調定額
     * @param 収入額 収入額
     * @return 完納_未納区分
     */
    public RString edit完納_未納区分(FlexibleDate 基準日, FlexibleDate 納期限, Decimal 調定額, Decimal 収入額) {
        if (基準日.isBeforeOrEquals(納期限)) {
            return MinoKannoKubun.未来納期.getコード();
        }
        if (Decimal.ZERO == 調定額 && Decimal.ZERO == 収入額) {
            return MinoKannoKubun._0円.getコード();
        }
        if (Decimal.ZERO != 調定額 && 調定額.equals(収入額)) {
            return MinoKannoKubun.完納.getコード();
        }

        if (調定額.compareTo(収入額) < 0) {
            return MinoKannoKubun.過納.getコード();
        }
        if (調定額.compareTo(収入額) > 0) {
            return MinoKannoKubun.未納あり.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 時効区分を取得します．
     *
     * @param 完納_未納区分 完納_未納区分
     * @param 時効起算日 時効起算日
     * @param 基準日 基準日
     * @return 時効区分
     */
    public RString edit時効区分(RString 完納_未納区分, FlexibleDate 時効起算日, FlexibleDate 基準日) {

        FlexibleDate 時効起算日2年後 = FlexibleDate.EMPTY;
        if (時効起算日 != null && FlexibleDate.EMPTY.equals(時効起算日)) {
            時効起算日2年後 = 時効起算日.plusYear(2);
        }

        if (MinoKannoKubun.未納あり.getコード().equals(完納_未納区分) && !FlexibleDate.EMPTY.equals(時効起算日2年後)
                && 時効起算日2年後.isBeforeOrEquals(基準日)) {
            return JikoKubun.時効到来.getコード();
        }
        return JikoKubun.時効未到来.getコード();
    }

    /**
     * 未納額を取得します．
     *
     * @param 調定額 調定額
     * @param 収入額 収入額
     * @return 未納額
     */
    public Decimal edit未納額(Decimal 調定額, Decimal 収入額) {
        Decimal 未納額 = 調定額.subtract(収入額);

        if (未納額.compareTo(Decimal.ZERO) < 0) {
            return Decimal.ZERO;
        }
        return 未納額;
    }

    /**
     * 仮の最古滞納期を取得します．
     *
     * @param entity 情報
     * @return 仮の最古滞納期
     */
    public FlexibleDate get仮の最古滞納期(ShiharaiHohoHenkoHaakuOneEntity entity, FlexibleDate 基準日) {
        FlexibleDate 仮の最古滞納期 = FlexibleDate.EMPTY;

        Decimal 仮の最古滞納期用_収入額 = Decimal.ZERO;
        List<ShunoJohoEntity> 収納情報リスト = entity.get収納情報リスト();

        if (収納情報リスト != null && !収納情報リスト.isEmpty()) {
            for (ShunoJohoEntity 収納情報 : 収納情報リスト) {
                仮の最古滞納期用_収入額 = edit仮の最古滞納期用_収入額(収納情報, 仮の最古滞納期用_収入額);
                Decimal 未納額 = edit未納額(収納情報.get調定共通_介護継承_調定額(), 仮の最古滞納期用_収入額);
                FlexibleDate 時効起算日 = edit仮の時効起算日(収納情報);
                RString 滞納区分 = edit滞納区分(収納情報.get調定共通_介護継承_納期限(), 時効起算日, 未納額, 基準日);
                if ((!is以前未納情報(収納情報.get調定共通_介護継承_納期限(), 基準日)) && TainoKubun.滞納期.get名称().equals(滞納区分)) {
                    仮の最古滞納期 = edit滞納区分が滞納期の仮の最古滞納期(収納情報, 仮の最古滞納期);
                }
            }
        }
        return 仮の最古滞納期;
    }

    private Decimal edit仮の最古滞納期用_収入額(ShunoJohoEntity 収納情報, Decimal 仮の最古滞納期用_収入額) {
        if (収納情報.get収入情報リスト() != null && !収納情報.get収入情報リスト().isEmpty()) {
            for (ShunyuJohoEntity 収入情報 : 収納情報.get収入情報リスト()) {
                if (収入情報.get収入額() != null) {
                    仮の最古滞納期用_収入額 = 仮の最古滞納期用_収入額.add(収入情報.get収入額());
                }
            }
        }
        return 仮の最古滞納期用_収入額;
    }

    private FlexibleDate edit滞納区分が滞納期の仮の最古滞納期(ShunoJohoEntity 収納情報, FlexibleDate 仮の最古滞納期) {
        if (仮の最古滞納期 == null || 仮の最古滞納期.isEmpty()) {
            仮の最古滞納期 = edit日期(収納情報.get調定共通_介護継承_納期限());
        } else {
            if (収納情報.get調定共通_介護継承_納期限() != null && 仮の最古滞納期.isBefore(edit日期(収納情報.get調定共通_介護継承_納期限()))) {
                仮の最古滞納期 = edit日期(収納情報.get調定共通_介護継承_納期限());
            }
        }
        return 仮の最古滞納期;
    }

    private FlexibleDate edit日期(RDate 納期限) {
        if (納期限 != null) {
            return new FlexibleDate(納期限.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    /**
     * 以前未納情報_以前滞納額を取得します．
     *
     * @param 完納_未納区分 完納_未納区分
     * @param 時効区分 時効区分
     * @param 未納額 未納額
     * @return 以前未納情報_以前滞納額
     */
    public Decimal edit以前未納情報_以前滞納額(RString 完納_未納区分, RString 時効区分, Decimal 未納額) {

        Decimal 以前滞納額 = Decimal.ZERO;
        if (MinoKannoKubun.未納あり.getコード().equals(完納_未納区分) && JikoKubun.時効未到来.getコード().equals(時効区分)) {
            if (未納額 != null) {
                以前滞納額 = 以前滞納額.add(未納額);
            }
        }
        return 以前滞納額;
    }

    /**
     * 以前未納情報_以前滞納区分を取得します．
     *
     * @param 完納_未納区分 完納_未納区分
     * @param 時効区分 時効区分
     * @param 時効起算日 時効起算日
     * @param 基準日 基準日
     * @return 以前未納情報_以前滞納区分
     */
    public RString edit以前未納情報_以前滞納区分(RString 完納_未納区分, RString 時効区分, FlexibleDate 時効起算日, FlexibleDate 基準日) {

        RString 以前滞納区分 = TainoKubun.空白.get名称();

        if (MinoKannoKubun.未納あり.getコード().equals(完納_未納区分) && JikoKubun.時効未到来.getコード().equals(時効区分)) {
            FlexibleDate 時効成立日 = FlexibleDate.EMPTY;
            if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
                時効成立日 = 時効起算日.plusYear(2);
            }

            if (時効成立日.isBeforeOrEquals(基準日)) {
                以前滞納区分 = TainoKubun.時効成立.get名称();
            } else {
                以前滞納区分 = TainoKubun.滞納期.get名称();
            }
        }
        return 以前滞納区分;
    }

    public FlexibleDate edit仮の時効起算日(ShunoJohoEntity 収納情報) {

        FlexibleDate 時効起算日 = 収納情報.get時効_時効起算年月日();
        FlexibleDate 督促状発行年月日 = edit日期(収納情報.get督促状発行履歴_督促状発行年月日());
        FlexibleDate 納期限の翌日 = FlexibleDate.EMPTY;

        RDate 納期限 = 収納情報.get調定共通_介護継承_納期限();
        if (納期限 != null) {
            納期限の翌日 = new FlexibleDate(納期限.toDateString()).plusDay(1);
        } else {
            納期限の翌日 = FlexibleDate.EMPTY;
        }
        return 収入情報について仮の時効起算日設定(収納情報, 時効起算日, 督促状発行年月日, 納期限の翌日);
    }

    private FlexibleDate 収入情報について仮の時効起算日設定(ShunoJohoEntity 収納情報, FlexibleDate 時効起算日,
            FlexibleDate 督促状発行年月日, FlexibleDate 納期限の翌日) {
        FlexibleDate 仮の時効起算日 = FlexibleDate.EMPTY;
        if ((時効起算日 == null || FlexibleDate.EMPTY.equals(時効起算日)) && (督促状発行年月日 == null || FlexibleDate.EMPTY.equals(督促状発行年月日))
                && (納期限の翌日 == null || FlexibleDate.EMPTY.equals(納期限の翌日))) {
            return FlexibleDate.EMPTY;
        }

        if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
            is時効起算日 = true;
            仮の時効起算日 = 時効起算日;
        } else if (督促状発行年月日 != null && !FlexibleDate.EMPTY.equals(督促状発行年月日)) {
            is督促状発行年月日 = true;
            仮の時効起算日 = 督促状発行年月日;
        } else if (納期限の翌日 != null && !FlexibleDate.EMPTY.equals(納期限の翌日)) {
            is納期限の翌日 = true;
            仮の時効起算日 = 納期限の翌日;
        }
        if (収納情報.get収入情報リスト() != null && !収納情報.get収入情報リスト().isEmpty()) {
            for (ShunyuJohoEntity 収入情報 : 収納情報.get収入情報リスト()) {
                if ((仮の時効起算日 == null || 仮の時効起算日.isEmpty())
                        || 時効起算日 == null || 時効起算日.isEmpty() || 仮の時効起算日.plusYear(2).isBeforeOrEquals(edit日期(収入情報.get収入日()))) {
                    break;
                } else if (時効起算日 != null && !時効起算日.isEmpty() && edit日期(収入情報.get収入日()).isBefore(時効起算日.plusYear(2))
                        && 仮の時効起算日.isBeforeOrEquals(edit日期(収入情報.get収入日()))) {
                    仮の時効起算日 = edit日期(収入情報.get収入日());
                    is収入年月日 = true;
                }
            }
        }
        return 仮の時効起算日;
    }

    /**
     * 収入額を取得します．
     *
     * @param 収納情報 収納情報
     * @return 収入額
     */
    public Decimal edit収入額(ShunoJohoEntity 収納情報) {
        Decimal 収入額 = Decimal.ZERO;
        if (収納情報.get収入情報リスト() != null && !収納情報.get収入情報リスト().isEmpty()) {
            for (ShunyuJohoEntity 収入情報 : 収納情報.get収入情報リスト()) {
                if (収入情報.get収入額() != null) {
                    収入額 = 収入額.add(収入情報.get収入額());
                }
            }
        }
        return 収入額;
    }

    /**
     * 最大の収入年月日を取得します．
     *
     * @param 収納情報 収納情報
     * @return 最大の収入年月日
     */
    public FlexibleDate edit最大の収入年月日(ShunoJohoEntity 収納情報) {
        FlexibleDate 最大の収入年月日 = FlexibleDate.EMPTY;

        if (収納情報.get収入情報リスト() != null && !収納情報.get収入情報リスト().isEmpty()) {
            for (ShunyuJohoEntity 収入情報 : 収納情報.get収入情報リスト()) {
                最大の収入年月日 = get最大の収入年月日(最大の収入年月日, edit日期(収入情報.get収入日()));
            }
        }
        return 最大の収入年月日;
    }

    private FlexibleDate get最大の収入年月日(FlexibleDate 最大の収入年月日, FlexibleDate 該当行収入年月日) {
        if (最大の収入年月日 == null || 最大の収入年月日.isEmpty()) {
            return 該当行収入年月日;
        } else if (該当行収入年月日 == null || 該当行収入年月日.isEmpty()) {
            return 最大の収入年月日;
        } else if (最大の収入年月日.isBefore(該当行収入年月日)) {
            return 該当行収入年月日;
        }
        return 最大の収入年月日;
    }

    /**
     * 時効起算事由を取得します．
     *
     * @param entity 収納情報
     * @return 時効起算事由
     */
    public RString edit時効起算事由(ShunoJohoEntity entity) {
        RString 時効起算事由 = RString.EMPTY;

        if (is収入年月日) {
            時効起算事由 = JikoKisanbiKubun.収入日.getコード();
        } else if (is時効起算日) {
            時効起算事由 = entity.get時効_時効起算日区分();
        } else if (is督促状発行年月日) {
            時効起算事由 = JikoKisanbiKubun.督促状発行日.getコード();
        } else if (is納期限の翌日) {
            時効起算事由 = JikoKisanbiKubun.納期限翌日.getコード();
        } else {
            時効起算事由 = JikoKisanbiKubun.不明_調定無し.getコード();
        }
        return 時効起算事由;
    }

    /**
     * 以前未納情報_以前納期限を取得します．
     *
     * @param entity sql検索結果情報
     * @return 以前未納情報_以前納期限
     */
    public FlexibleDate get以前未納情報_以前納期限(ShiharaiHohoHenkoHaakuOneEntity entity, FlexibleDate 基準日) {
        FlexibleDate 以前納期限 = FlexibleDate.EMPTY;
        List<ShunoJohoEntity> 収納情報リスト = entity.get収納情報リスト();

        if (収納情報リスト != null && !収納情報リスト.isEmpty()) {
            for (ShunoJohoEntity 収納情報 : 収納情報リスト) {
                FlexibleDate 納期限Date = edit日期(収納情報.get調定共通_介護継承_納期限());
                if (納期限Date != null && !納期限Date.isEmpty() && is以前未納情報(収納情報.get調定共通_介護継承_納期限(), 基準日)) {
                    以前納期限 = edit以前納期限(以前納期限, 納期限Date);
                }
            }
        }
        return 以前納期限;
    }

    private FlexibleDate edit以前納期限(FlexibleDate 以前納期限, FlexibleDate 納期限Date) {
        if (以前納期限 == null || FlexibleDate.EMPTY.equals(以前納期限)) {
            以前納期限 = 納期限Date;
        } else {
            if (以前納期限.isBefore(納期限Date)) {
                以前納期限 = 納期限Date;
            }
        }
        return 以前納期限;
    }

    /**
     * 最古滞納期を取得します．
     *
     * @param 仮の最古滞納期 仮の最古滞納期
     * @param 以前納期限 以前納期限
     * @return 最古滞納期
     */
    public FlexibleDate get最古滞納期Date(FlexibleDate 仮の最古滞納期, FlexibleDate 以前納期限) {
        FlexibleDate 最古滞納期Date = FlexibleDate.EMPTY;

        if (以前納期限 == null || FlexibleDate.EMPTY.equals(以前納期限)) {
            if (仮の最古滞納期 != null) {
                最古滞納期Date = 仮の最古滞納期;
            }
        } else {
            if (仮の最古滞納期 == null || FlexibleDate.EMPTY.equals(仮の最古滞納期)) {
                最古滞納期Date = 以前納期限;
            } else if (仮の最古滞納期.isBefore(以前納期限)) {
                最古滞納期Date = 仮の最古滞納期;
            }
        }
        return 最古滞納期Date;
    }

    /**
     * 以前滞納区分を取得します.
     *
     * @param 最古滞納期Date 最古滞納期Date
     * @param 以前納期限 以前納期限
     * @param 以前滞納額 以前滞納額
     * @return 以前滞納区分
     */
    public RString edit以前滞納区分(FlexibleDate 最古滞納期Date, FlexibleDate 以前納期限, Decimal 以前滞納額) {
        RString 以前滞納区分 = TainoKubun.空白.get名称();
        if ((以前納期限 != null && !FlexibleDate.EMPTY.equals(以前納期限))
                && 以前納期限.equals(最古滞納期Date)
                && 以前滞納額.compareTo(Decimal.ZERO) > 0) {
            以前滞納区分 = TainoKubun.最古滞納期.get名称();
        }
        return 以前滞納区分;
    }

    /**
     * 該当期滞納区分を取得します．
     *
     * @param 最古滞納期Date 最古滞納期Date
     * @param 該当期の納期限 該当期の納期限
     * @param 未納額 未納額
     * @return 該当期滞納区分
     */
    public RString edit該当期滞納区分(FlexibleDate 最古滞納期Date, FlexibleDate 該当期の納期限, Decimal 未納額) {
        RString 当該期の滞納区分 = TainoKubun.空白.get名称();
        if ((該当期の納期限 != null && !該当期の納期限.isEmpty())
                && 該当期の納期限.equals(最古滞納期Date)
                && 未納額.compareTo(Decimal.ZERO) > 0) {
            当該期の滞納区分 = TainoKubun.最古滞納期.get名称();
        }
        return 当該期の滞納区分;
    }

    /**
     * 最長滞納期間を取得します．
     *
     * @param 最古滞納期Date 最古滞納期Date
     * @param 基準日 基準日
     * @return 最長滞納期間
     */
    public int edit最長滞納期間(FlexibleDate 最古滞納期Date, FlexibleDate 基準日) {
        int 最長滞納期間 = 0;
        if (最古滞納期Date != null && !FlexibleDate.EMPTY.equals(最古滞納期Date)) {
            最長滞納期間 = 最古滞納期Date.getBetweenDays(基準日);
        }
        return 最長滞納期間;
    }

    public RString edit滞納区分(RDate 納期限, FlexibleDate 時効起算日, Decimal 未納額, FlexibleDate 基準日) {
        RString 滞納区分 = TainoKubun.空白.get名称();
        if ((未納額 != null && !Decimal.ZERO.equals(未納額)) && !is以前未納情報(納期限, 基準日)) {
            if (基準日.isBeforeOrEquals(edit日期(納期限))) {
                滞納区分 = TainoKubun.納期限未到来.get名称();
            } else {
                滞納区分 = edit基準日AFTER納期限の滞納区分(滞納区分, 時効起算日, 基準日);
            }
        }
        return 滞納区分;
    }

    private RString edit基準日AFTER納期限の滞納区分(RString 滞納区分, FlexibleDate 時効起算日, FlexibleDate 基準日) {
        滞納区分 = TainoKubun.滞納期.get名称();
        if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
            FlexibleDate 時効成立日 = FlexibleDate.EMPTY;
            時効成立日 = 時効起算日.plusYear(2);
            if (時効成立日.isBeforeOrEquals(基準日)) {
                滞納区分 = TainoKubun.時効成立.get名称();
            }
        }
        return 滞納区分;
    }

    /**
     * 以降未納情報を設定します．
     *
     * @param 完納_未納区分 完納_未納区分
     * @param data 一時情報
     * @param 収納情報List 収納情報List
     * @param 基準日 基準日
     */
    public void edit以降未納情報(RString 完納_未納区分, ShunoStatusTempTableEntity data, List<ShunoJohoEntity> 収納情報List, FlexibleDate 基準日) {

        FlexibleDate 納期限 = edit日期(data.getNokigenYMD());
        FlexibleDate 収納状況_納期限 = edit日期(data.getNokigenYMD());
        FlexibleDate 収納状況_時効起算日 = data.getJikoKisambiYMD();
        RString 収納状況_時効起算事由 = data.getJikoKisambiJiyu();
        FlexibleYear 賦課年度 = data.getFukaNendo();
        FlexibleYear 調定年度 = data.getChoteiNendo();
        FlexibleDate 時効起算日 = FlexibleDate.EMPTY;
        RString 時効起算事由 = RString.EMPTY;

        if (!賦課年度.equals(調定年度)) {
            data.setChoteiNendo(FlexibleYear.EMPTY);

            for (ShunoJohoEntity 収納情報 : 収納情報List) {
                if (収納情報.get賦課_調定年度() != null && !FlexibleYear.EMPTY.equals(収納情報.get賦課_調定年度())
                        && 収納情報.get賦課_賦課年度() != null && !FlexibleYear.EMPTY.equals(収納情報.get賦課_賦課年度())
                        && !収納情報.get賦課_賦課年度().equals(収納情報.get賦課_調定年度())
                        && 賦課年度.equals(収納情報.get賦課_賦課年度())) {

                    FlexibleDate 時効成立日 = edit以降未納情報_収納情報(収納状況_時効起算日);

                    時効起算日 = edit以降未納情報_時効起算日(完納_未納区分, 時効成立日, 時効起算日, 収納状況_時効起算日, 基準日);
                    時効起算事由 = edit以降未納情報_時効起算事由(完納_未納区分, 時効成立日, 時効起算事由, 収納状況_時効起算事由, 基準日);
                    納期限 = edit以降未納情報_納期限(完納_未納区分, 時効成立日, 納期限, 収納状況_納期限, 基準日);
                }
            }
            data.setJikoKisambiYMD(時効起算日);
            data.setJikoKisambiJiyu(時効起算事由);
            data.setNokigenYMD(new RDate(納期限.getYearValue(), 納期限.getMonthValue(), 納期限.getDayValue()));
            data.setPastYearflag(true);
        }
    }

    private FlexibleDate edit以降未納情報_時効起算日(RString 完納_未納区分, FlexibleDate 時効成立日, FlexibleDate 時効起算日,
            FlexibleDate 収納状況_時効起算日, FlexibleDate 基準日) {
        if ((!FlexibleDate.EMPTY.equals(時効成立日) && 基準日.isBefore(時効成立日))
                && MinoKannoKubun.未納あり.getコード().equals(完納_未納区分)) {
            時効起算日 = 収納状況_時効起算日;
        }
        return 時効起算日;
    }

    private RString edit以降未納情報_時効起算事由(RString 完納_未納区分, FlexibleDate 時効成立日, RString 時効起算事由,
            RString 収納状況_時効起算事由, FlexibleDate 基準日) {
        if ((!FlexibleDate.EMPTY.equals(時効成立日) && 基準日.isBefore(時効成立日))
                && MinoKannoKubun.未納あり.getコード().equals(完納_未納区分)) {
            時効起算事由 = 収納状況_時効起算事由;
        }
        return 時効起算事由;
    }

    private FlexibleDate edit以降未納情報_納期限(RString 完納_未納区分, FlexibleDate 時効成立日, FlexibleDate 納期限,
            FlexibleDate 収納状況_納期限, FlexibleDate 基準日) {
        if ((!FlexibleDate.EMPTY.equals(時効成立日) && 基準日.isBefore(時効成立日))
                && MinoKannoKubun.未納あり.getコード().equals(完納_未納区分)) {
            納期限 = 収納状況_納期限;
        }
        return 納期限;
    }

    private FlexibleDate edit以降未納情報_収納情報(FlexibleDate 収納状況_時効起算日) {
        FlexibleDate 時効成立日 = FlexibleDate.EMPTY;
        if (収納状況_時効起算日 != null && !FlexibleDate.EMPTY.equals(収納状況_時効起算日)) {
            時効成立日 = 収納状況_時効起算日.plusYear(2);
        }
        return 時効成立日;
    }

    private boolean is以前未納情報(RDate 納期限, FlexibleDate 基準日) {
        return edit日期(納期限).isBefore(基準日.minusYear(年_3));
    }
}
