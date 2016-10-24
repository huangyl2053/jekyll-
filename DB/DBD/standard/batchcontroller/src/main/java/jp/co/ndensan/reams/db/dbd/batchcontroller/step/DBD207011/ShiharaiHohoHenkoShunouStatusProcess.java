/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakuOneProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuOneEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShunoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShunoStatusTempTableEntity;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenkohaakuichiran.ShiharaiHohoHenkoShunouStatusService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス１クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoShunouStatusProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuOneEntity> {

    private static final int 年_3 = 3;
    private boolean is行削除;

    private ShiharaiHohoHenkoHaakuOneProcessParameter processParamter;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find支払方法変更情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShiharaiHohoHenkoHakuListMainMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShunoStatusTempTableEntity.class)
                .tempTableName(ShunoStatusTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuOneEntity t) {
        create収納状況一時テーブル(t);
    }

    private void create収納状況一時テーブル(ShiharaiHohoHenkoHaakuOneEntity t) {
        ShiharaiHohoHenkoShunouStatusService service = ShiharaiHohoHenkoShunouStatusService.createIntance();
        FlexibleDate 以前納期限 = service.get以前未納情報_以前納期限(t, processParamter.get基準日());
        FlexibleDate 仮の最古滞納期 = service.get仮の最古滞納期(t, processParamter.get基準日());

        List<ShunoJohoEntity> 収納情報List = t.get収納情報リスト();
        if (収納情報List != null && !収納情報List.isEmpty()) {

            for (ShunoJohoEntity entity : 収納情報List) {
                ShunoStatusTempTableEntity data = new ShunoStatusTempTableEntity();
                data.setChoteiNendo(entity.get介護期別_調定年度());
                data.setFukaNendo(entity.get賦課_賦課年度());
                data.setTsuchishoNo(entity.get賦課_通知書番号());
                data.setKi(entity.get介護期別_期());
                data.setHihokenshaNo(t.get対象者情報_被保険者番号());
                data.setShikibetsuCode(entity.get賦課_識別コード());
                data.setNokigenYMD(entity.get調定共通_介護継承_納期限());
                data.setChoteigaku(entity.get調定共通_介護継承_調定額());
                data.setJikoKisambiYMD(service.edit仮の時効起算日(entity));
                data.setShunyuYMD(service.edit最大の収入年月日(entity));
                data.setShunyuGaku(service.edit収入額(entity));
                data.setDunningHakkoYMD(edit日期(entity.get督促状発行履歴_督促状発行年月日()));

                RString 完納_未納区分 = service.edit完納_未納区分(processParamter.get基準日(), edit日期(entity.get調定共通_介護継承_納期限()),
                        entity.get調定共通_介護継承_調定額(), data.getShunyuGaku());
                set完納_未納区分について情報(data, service, entity, 完納_未納区分);
                set以前と以降未納情報について情報(data, service, 収納情報List, 完納_未納区分);
                data.setTainoKubun(service.edit滞納区分(data.getNokigenYMD(), data.getJikoKisambiYMD(), data.getMiNoGaku(), processParamter.get基準日()));

                clear行設定値(edit日期(data.getNokigenYMD()), data.getChoteigaku(), data.getMiNoGaku(), data.getTainoKubun(), data);

                FlexibleDate 最古滞納期 = service.get最古滞納期Date(仮の最古滞納期, 以前納期限);
                set最古滞納期について情報(data, service, 最古滞納期, 以前納期限);
                if (!is行削除) {
                    tmpTableWriter.insert(data);
                }
            }
        }
    }

    private FlexibleDate edit日期(RDate 納期限) {
        if (納期限 != null) {
            return new FlexibleDate(納期限.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private void set以前と以降未納情報について情報(ShunoStatusTempTableEntity data, ShiharaiHohoHenkoShunouStatusService service,
            List<ShunoJohoEntity> 収納情報List, RString 完納_未納区分) {
        if (is以前未納情報(data.getNokigenYMD())) {
            data.setBeforeTainoGaku(service.edit以前未納情報_以前滞納額(完納_未納区分, data.getJikoKubun(), data.getMiNoGaku()));
            data.setBeforeTainoKubun(service.edit以前未納情報_以前滞納区分(完納_未納区分,
                    data.getJikoKubun(), data.getJikoKisambiYMD(), processParamter.get基準日()));
        } else {
            service.edit以降未納情報(完納_未納区分, data, 収納情報List, processParamter.get基準日());
        }
    }

    private void set完納_未納区分について情報(ShunoStatusTempTableEntity data, ShiharaiHohoHenkoShunouStatusService service,
            ShunoJohoEntity entity, RString 完納_未納区分) {
        data.setFinshNoKubun(完納_未納区分);
        data.setJikoKubun(service.edit時効区分(完納_未納区分, entity.get時効_時効起算年月日(), processParamter.get基準日()));
        data.setMiNoGaku(service.edit未納額(entity.get調定共通_介護継承_調定額(), data.getShunyuGaku()));
        data.setJikoKisambiJiyu(service.edit時効起算事由(entity));

    }

    private void set最古滞納期について情報(ShunoStatusTempTableEntity data, ShiharaiHohoHenkoShunouStatusService service, FlexibleDate 最古滞納期,
            FlexibleDate 以前納期限) {
        data.setBeforeTainoKubun(service.edit以前滞納区分(最古滞納期, 以前納期限, data.getBeforeTainoGaku()));
        RString 該当期滞納区分 = service.edit該当期滞納区分(最古滞納期, edit日期(data.getNokigenYMD()), data.getMiNoGaku());
        if (TainoKubun.空白.get名称().equals(該当期滞納区分)) {
            data.setTainoKubun(該当期滞納区分);
        }
        data.setLongestTainoPeriod(service.edit最長滞納期間(最古滞納期, processParamter.get基準日()));
    }

    private void clear行設定値(FlexibleDate 納期限, Decimal 調定額, Decimal 滞納額, RString 滞納区分, ShunoStatusTempTableEntity data) {
        if ((納期限 == null || 納期限.isEmpty()) && is以前未納情報(data.getNokigenYMD())) {
            滞納区分 = RString.EMPTY;
        }

        if (Decimal.ZERO == 滞納額) {
            data.setJikoKisambiYMD(FlexibleDate.EMPTY);
            data.setJikoKisambiJiyu(RString.EMPTY);
        }

        if (TainoKubun.納期限未到来.get名称().equals(滞納区分)) {
            data.setJikoKisambiYMD(FlexibleDate.EMPTY);
            data.setJikoKisambiJiyu(RString.EMPTY);
            data.setBeforeTainoGaku(null);
        }
        data.setTainoKubun(滞納区分);
        is行削除 = Decimal.ZERO.equals(調定額) && Decimal.ZERO.equals(滞納額);
    }

    private boolean is以前未納情報(RDate 納期限) {
        return edit日期(納期限).isBefore(processParamter.get基準日().minusYear(年_3));
    }
}
