/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri.JikoKisanbiKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakuOneProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuOneEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShunoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShunyuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShunoStatusTempTableEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス１クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoShunouStatusProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuOneEntity> {

    private static final RString 未来納期 = new RString("未来納期");
    private static final RString 完納_未納区分_0円 = new RString("0円");
    private static final RString 完納 = new RString("完納");
    private static final RString 過納 = new RString("過納");
    private static final RString 未納あり = new RString("未納あり");

    private static final RString 時効到来 = new RString("時効到来");
    private static final RString 時効未到来 = new RString("時効未到来");

    private static final RString 時効成立 = new RString("時効成立");
    private static final RString 滞納期 = new RString("滞納期");
    private static final RString 納期限未到来 = new RString("納期限未到来");
    private static final RString 最古滞納期 = new RString("最古滞納期");

    private boolean is時効起算日;
    private boolean is督促状発行年月日;
    private boolean is納期限の翌日;
    private boolean is収入年月日;

    private Decimal 収入額 = Decimal.ZERO;
    private FlexibleDate 最大の収入年月日;

    private ShiharaiHohoHenkoHaakuOneProcessParameter processParamter;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find支払方法変更情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShiharaiHohoHenkoHakuListMainMybatisParameter(psmShikibetsuTaisho));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShunoStatusTempTableEntity.class)
                .tempTableName(ShunoStatusTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuOneEntity t) {;
        ShunoStatusTempTableEntity tempTableEntity = create収納状況一時テーブル(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private ShunoStatusTempTableEntity create収納状況一時テーブル(ShiharaiHohoHenkoHaakuOneEntity t) {

        FlexibleDate 以前納期限 = get以前未納情報_以前納期限(t);
        FlexibleDate 仮の最古滞納期 = get仮の最古滞納期(t);

        ShunoStatusTempTableEntity data = new ShunoStatusTempTableEntity();
        List<ShunoJohoEntity> 収納情報List = t.get収納情報リスト();

        if (収納情報List != null && !収納情報List.isEmpty()) {

            for (ShunoJohoEntity entity : 収納情報List) {
                data.setChoteiNendo(entity.get介護期別_調定年度());
                data.setFukaNendo(entity.get賦課_賦課年度());
                data.setTsuchishoNo(entity.get賦課_通知書番号());
                data.setKi(entity.get介護期別_期());
                data.setHihokenshaNo(t.get対象者情報_被保険者番号());
                data.setShikibetsuCode(entity.get賦課_識別コード());
                data.setNokigenYMD(entity.get調定共通_介護継承_納期限());
                data.setChoteigaku(entity.get調定共通_介護継承_調定額());
                data.setJikoKisambiYMD(edit仮の時効起算日(entity));

                data.setShunyuYMD(最大の収入年月日);
                data.setShunyuGaku(収入額);
                data.setDunningHakkoYMD(edit日期(entity.get督促状発行履歴_督促状発行年月日()));

                RString 完納_未納区分 = edit完納_未納区分(processParamter.get基準日(), edit日期(entity.get調定共通_介護継承_納期限()),
                        entity.get調定共通_介護継承_調定額(), data.getShunyuGaku());

                data.setFinshNoKubun(完納_未納区分);
                data.setJikoKubun(edit時効区分(完納_未納区分, entity.get時効_時効起算年月日(), processParamter.get基準日()));
                Decimal 未納額 = edit未納額(entity.get調定共通_介護継承_調定額(), 収入額);
                data.setMiNoGaku(未納額);
                data.setJikoKisambiJiyu(edit時効起算事由(entity));

                if (edit日期(data.getNokigenYMD()).isBefore(processParamter.get基準日().minusYear(3))) {
                    edit以前未納情報(完納_未納区分, data.getJikoKubun(), data.getMiNoGaku(), data.getJikoKisambiYMD(), processParamter.get基準日(), data);
                } else {
                    edit以降未納情報(完納_未納区分, data, 収納情報List);
                }
                RString 滞納区分 = edit滞納区分(edit日期(data.getNokigenYMD()), data.getJikoKisambiYMD(), 未納額);
                clear行設定値(edit日期(data.getNokigenYMD()), data.getChoteigaku(), data.getMiNoGaku(), 滞納区分, data);
                edit以前滞納区分と当該期の滞納区分(仮の最古滞納期, 以前納期限, data.getBeforeTainoGaku(),
                        edit日期(data.getNokigenYMD()), data.getMiNoGaku(), data);
            }
        }
        return data;
    }

    private FlexibleDate edit日期(RDate 納期限) {
        if (納期限 != null) {
            return new FlexibleDate(納期限.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private FlexibleDate edit仮の時効起算日(ShunoJohoEntity 収納情報) {

        FlexibleDate 時効起算日 = 収納情報.get時効_時効起算年月日();
        FlexibleDate 督促状発行年月日 = edit日期(収納情報.get督促状発行履歴_督促状発行年月日());
        FlexibleDate 納期限の翌日 = FlexibleDate.EMPTY;

        RDate 納期限 = 収納情報.get調定共通_介護継承_納期限();
        if (納期限 != null) {
            納期限の翌日 = new FlexibleDate(納期限.toDateString()).plusDay(1);
        } else {
            納期限の翌日 = FlexibleDate.EMPTY;
        }

        FlexibleDate 仮の時効起算日 = FlexibleDate.EMPTY;
        if ((時効起算日 == null || FlexibleDate.EMPTY.equals(時効起算日)) && (督促状発行年月日 == null || FlexibleDate.EMPTY.equals(督促状発行年月日))
                && (納期限の翌日 == null || FlexibleDate.EMPTY.equals(納期限の翌日))) {
            return FlexibleDate.EMPTY;
        }

        if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
            is時効起算日 = true;
            仮の時効起算日 = 時効起算日;
        }
        if (督促状発行年月日 != null && !FlexibleDate.EMPTY.equals(督促状発行年月日)) {
            is督促状発行年月日 = true;
            仮の時効起算日 = 督促状発行年月日;
        }
        if (納期限の翌日 != null && !FlexibleDate.EMPTY.equals(納期限の翌日)) {
            is納期限の翌日 = true;
            仮の時効起算日 = 督促状発行年月日;
        }

        if (収納情報.get収入情報リスト() != null && !収納情報.get収入情報リスト().isEmpty()) {
            for (ShunyuJohoEntity 収入情報 : 収納情報.get収入情報リスト()) {
                if (収入情報.get収入額() != null) {
                    収入額 = 収入額.add(収入情報.get収入額());
                }
                最大の収入年月日 = edit日期(収入情報.get収入日());
                if ((仮の時効起算日 == null || 仮の時効起算日.isEmpty())
                        || 時効起算日 == null || 時効起算日.isEmpty() || 仮の時効起算日.plusYear(2).isBeforeOrEquals(時効起算日)) {
                    break;
                } else {
                    仮の時効起算日 = edit日期(収入情報.get収入日());
                }
            }
        }
        return 仮の時効起算日;
    }

    private RString edit時効起算事由(ShunoJohoEntity entity) {
        RString 時効起算事由 = RString.EMPTY;

        if (is収入年月日) {
            時効起算事由 = JikoKisanbiKubun.収入日.get名称();
        } else if (is時効起算日) {
            時効起算事由 = entity.get時効_時効起算日区分();
        } else if (is督促状発行年月日) {
            時効起算事由 = JikoKisanbiKubun.督促状発行日.get名称();
        } else if (is納期限の翌日) {
            時効起算事由 = JikoKisanbiKubun.納期限翌日.get名称();
        } else {
            時効起算事由 = JikoKisanbiKubun.不明_調定無し.get名称();
        }
        return 時効起算事由;
    }

    private RString edit完納_未納区分(FlexibleDate 基準日, FlexibleDate 納期限, Decimal 調定額, Decimal 収入額) {
        if (基準日.isBeforeOrEquals(納期限)) {
            return 未来納期;
        }
        if (Decimal.ZERO == 調定額 && Decimal.ZERO == 収入額) {
            return 完納_未納区分_0円;
        }
        if (Decimal.ZERO != 調定額 && Decimal.ZERO == 収入額) {
            return 完納;
        }

        if (調定額.compareTo(収入額) < 0) {
            return 過納;
        }
        if (調定額.compareTo(収入額) > 0) {
            return 未納あり;
        }
        return RString.EMPTY;
    }

    private RString edit時効区分(RString 完納_未納区分, FlexibleDate 時効起算日, FlexibleDate 基準日) {

        FlexibleDate 時効起算日2年後 = FlexibleDate.EMPTY;
        if (時効起算日 != null && FlexibleDate.EMPTY.equals(時効起算日)) {
            時効起算日2年後 = 時効起算日.plusYear(2);
        }

        if (MinoKannoKubun.未納あり.getコード().equals(完納_未納区分) && 時効起算日2年後.isBeforeOrEquals(基準日)) {
            return 時効到来;
        }
        return 時効未到来;
    }

    private Decimal edit未納額(Decimal 調定額, Decimal 収入額) {
        Decimal 未納額 = 調定額.subtract(収入額);

        if (未納額.compareTo(Decimal.ZERO) < 0) {
            return Decimal.ZERO;
        }
        return 未納額;
    }

    private void edit以前未納情報(RString 完納_未納区分, RString 時効区分, Decimal 未納額, FlexibleDate 時効起算日,
            FlexibleDate 基準日, ShunoStatusTempTableEntity data) {

        Decimal 以前滞納額 = Decimal.ZERO;
        RString 以前滞納区分 = RString.EMPTY;

        if (未納あり.equals(完納_未納区分) && 時効未到来.equals(時効区分)) {
            if (未納額 != null) {
                以前滞納額 = 以前滞納額.add(未納額);
            }

            FlexibleDate 時効成立日 = FlexibleDate.EMPTY;
            if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
                時効成立日 = 時効起算日.plusYear(2);
            }

            if (時効成立日.isBeforeOrEquals(基準日)) {
                以前滞納区分 = 時効成立;
            } else {
                以前滞納区分 = 滞納期;
            }
        }
        data.setBeforeTainoGaku(以前滞納額);
        data.setBeforeTainoKubun(以前滞納区分);
    }

    private void edit以降未納情報(RString 完納_未納区分, ShunoStatusTempTableEntity data, List<ShunoJohoEntity> 収納情報List) {

        Decimal 調定額 = data.getChoteigaku();
        FlexibleDate 納期限 = edit日期(data.getNokigenYMD());
        FlexibleDate 収納状況_納期限 = edit日期(data.getNokigenYMD());
        Decimal 未納額 = Decimal.ZERO;
        FlexibleDate 収納状況_時効起算日 = data.getJikoKisambiYMD();
        RString 収納状況_時効起算事由 = data.getJikoKisambiJiyu();
        FlexibleYear 賦課年度 = data.getFukaNendo();
        FlexibleYear 調定年度 = data.getChoteiNendo();
        RString 時効区分 = data.getJikoKubun();

        boolean 過年度フラグ = false;
        Decimal 調定額合計 = Decimal.ZERO;
        Decimal 滞納額合計 = Decimal.ZERO;
        FlexibleDate 時効起算日 = FlexibleDate.EMPTY;
        RString 時効起算事由 = RString.EMPTY;

        if (賦課年度.equals(調定年度)) {
            if (調定額 != null) {
                調定額合計 = 調定額合計.add(調定額);
            }

            if (未納額 != null) {
                滞納額合計 = 滞納額合計.add(未納額);
            }
        } else {
            過年度フラグ = true;
            調定年度 = FlexibleYear.EMPTY;

            for (ShunoJohoEntity 収納情報 : 収納情報List) {
                if (収納情報.get賦課_調定年度() != null && !FlexibleYear.EMPTY.equals(収納情報.get賦課_調定年度())
                        && 収納情報.get賦課_賦課年度() != null && !FlexibleYear.EMPTY.equals(収納情報.get賦課_賦課年度())
                        && !収納情報.get賦課_賦課年度().equals(収納情報.get賦課_調定年度())
                        && 賦課年度.equals(収納情報.get賦課_賦課年度())) {

                    FlexibleDate 時効成立日 = FlexibleDate.EMPTY;
                    if (収納状況_時効起算日 != null && !FlexibleDate.EMPTY.equals(収納状況_時効起算日)) {
                        時効成立日 = 収納状況_時効起算日.plusYear(2);
                    }

                    if (!FlexibleDate.EMPTY.equals(時効成立日) && processParamter.get基準日().isBefore(時効成立日)) {
                        if (未納あり.equals(完納_未納区分)) {
                            if (納期限 == null || FlexibleDate.EMPTY.equals(納期限)) {
                                時効起算日 = 収納状況_時効起算日;
                                時効起算事由 = 収納状況_時効起算事由;
                                納期限 = 収納状況_納期限;
                            } else if (収納状況_納期限.isBefore(納期限)) {
                                時効起算日 = 収納状況_時効起算日;
                                時効起算事由 = 収納状況_時効起算事由;
                                納期限 = 収納状況_納期限;
                            }
                        }
                    }

                    if (時効到来.equals(時効区分) && 完納_未納区分.equals(未納あり)) {
                        if (未納額 != null) {
                            滞納額合計 = 滞納額合計.add(未納額);
                        }
                    }
                }
            }
        }
        data.setJikoKisambiYMD(時効起算日);
        data.setJikoKisambiJiyu(時効起算事由);
        data.setPastYearflag(過年度フラグ);
    }

    private RString edit滞納区分(FlexibleDate 納期限, FlexibleDate 時効起算日, Decimal 未納額) {
        RString 滞納区分 = RString.EMPTY;
        if (未納額 != null && !Decimal.ZERO.equals(未納額)) {
            if (processParamter.get基準日().isBeforeOrEquals(納期限)) {
                滞納区分 = 納期限未到来;
            } else {
                滞納区分 = 滞納期;
                if (時効起算日 != null && !FlexibleDate.EMPTY.equals(時効起算日)) {
                    FlexibleDate 時効成立日 = FlexibleDate.EMPTY;
                    時効成立日 = 時効起算日.plusYear(2);
                    if (時効成立日.isBeforeOrEquals(processParamter.get基準日())) {
                        滞納区分 = 時効成立;
                    }
                }
            }
        }
        return 滞納区分;
    }

    private void clear行設定値(FlexibleDate 納期限, Decimal 調定額, Decimal 滞納額, RString 滞納区分, ShunoStatusTempTableEntity data) {
        if (納期限 == null || 納期限.isEmpty()) {
            滞納区分 = RString.EMPTY;
        }

        if (Decimal.ZERO == 滞納額) {
            data.setJikoKisambiYMD(FlexibleDate.EMPTY);
            data.setJikoKisambiJiyu(RString.EMPTY);
        }

        if (納期限未到来.equals(滞納区分)) {
            data.setJikoKisambiYMD(FlexibleDate.EMPTY);
            data.setJikoKisambiJiyu(RString.EMPTY);
            data.setBeforeTainoGaku(Decimal.ZERO);
        }

        if (Decimal.ZERO.equals(調定額) && Decimal.ZERO.equals(滞納額)) {
            // 行クリア TODO
            clear行データ(data);
        }
    }

    private void edit以前滞納区分と当該期の滞納区分(FlexibleDate 仮の最古滞納期, FlexibleDate 以前納期限, Decimal 以前滞納額,
            FlexibleDate 該当期の納期限, Decimal 未納額, ShunoStatusTempTableEntity data) {

        FlexibleDate 最古滞納期Date = FlexibleDate.EMPTY;
        int 最長滞納期間 = 0;

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

        if ((以前納期限 != null && !FlexibleDate.EMPTY.equals(以前納期限))
                && 以前納期限.equals(最古滞納期Date)
                && 以前滞納額.compareTo(Decimal.ZERO) > 0) {
            RString 以前滞納区分 = 最古滞納期;
            data.setBeforeTainoKubun(以前滞納区分);
        }

        if ((該当期の納期限 != null && !該当期の納期限.isEmpty())
                && 該当期の納期限.equals(最古滞納期Date)
                && 未納額.compareTo(Decimal.ZERO) > 0) {
            RString 当該期の滞納区分 = 最古滞納期;
            data.setTainoKubun(当該期の滞納区分);
        }
        if (最古滞納期Date != null && !FlexibleDate.EMPTY.equals(最古滞納期Date)) {
            最長滞納期間 = 最古滞納期Date.compareTo(processParamter.get基準日());
            data.setLongestTainoPeriod(最長滞納期間);
        }
    }

    private void clear行データ(ShunoStatusTempTableEntity data) {
        // この該当はQAですが、行空白の場合、この行データ該当は一時テーブルに追加しませんが
    }

    private FlexibleDate get以前未納情報_以前納期限(ShiharaiHohoHenkoHaakuOneEntity entity) {
        FlexibleDate 以前納期限 = FlexibleDate.EMPTY;
        List<ShunoJohoEntity> 収納情報リスト = entity.get収納情報リスト();

        if (収納情報リスト != null && !収納情報リスト.isEmpty()) {
            for (ShunoJohoEntity 収納情報 : 収納情報リスト) {
                FlexibleDate 納期限Date = edit日期(収納情報.get調定共通_介護継承_納期限());
                if (納期限Date != null && !納期限Date.isEmpty() && 納期限Date.isBefore(processParamter.get基準日().minusYear(3))) {

                    if (以前納期限 == null || FlexibleDate.EMPTY.equals(以前納期限)) {
                        以前納期限 = 納期限Date;
                    } else {
                        if (以前納期限.isBefore(納期限Date)) {
                            以前納期限 = 納期限Date;
                        }
                    }
                }
            }
        }
        return 以前納期限;
    }

    private FlexibleDate get仮の最古滞納期(ShiharaiHohoHenkoHaakuOneEntity entity) {
        FlexibleDate 仮の最古滞納期 = FlexibleDate.EMPTY;

        Decimal 仮の最古滞納期用_収入額 = Decimal.ZERO;
        List<ShunoJohoEntity> 収納情報リスト = entity.get収納情報リスト();

        if (収納情報リスト != null && !収納情報リスト.isEmpty()) {
            for (ShunoJohoEntity 収納情報 : 収納情報リスト) {
                if (収納情報.get収入情報リスト() != null && !収納情報.get収入情報リスト().isEmpty()) {
                    for (ShunyuJohoEntity 収入情報 : 収納情報.get収入情報リスト()) {
                        if (収入情報.get収入額() != null) {
                            仮の最古滞納期用_収入額 = 仮の最古滞納期用_収入額.add(収入情報.get収入額());
                        }
                    }
                }
                Decimal 未納額 = edit未納額(収納情報.get調定共通_介護継承_調定額(), 仮の最古滞納期用_収入額);
                FlexibleDate 時効起算日 = edit仮の時効起算日(収納情報);
                RString 滞納区分 = edit滞納区分(edit日期(収納情報.get調定共通_介護継承_納期限()), 時効起算日, 未納額);

                if (滞納期.equals(滞納区分)) {
                    if (仮の最古滞納期 == null || 仮の最古滞納期.isEmpty()) {
                        仮の最古滞納期 = edit日期(収納情報.get調定共通_介護継承_納期限());
                    } else {
                        if (収納情報.get調定共通_介護継承_納期限() != null && 仮の最古滞納期.isBefore(edit日期(収納情報.get調定共通_介護継承_納期限()))) {
                            仮の最古滞納期 = edit日期(収納情報.get調定共通_介護継承_納期限());
                        }
                    }
                }
            }
        }
        return 仮の最古滞納期;
    }
}
