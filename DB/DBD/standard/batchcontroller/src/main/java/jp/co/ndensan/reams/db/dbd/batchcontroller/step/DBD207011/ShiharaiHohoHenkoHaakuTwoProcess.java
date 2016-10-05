/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenkohaakuichiran.ShiharaiHohoHenkoTempEditJoho;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuTwoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.temptable.ShokanUnpaidTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス2クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoHaakuTwoProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuTwoEntity> {

    private static final RString 申請中 = new RString("申請中");
    private static final int 件数_0 = 0;

    private int 申請中件数 = 0;
    private int 未通知件数 = 0;

    private int 償還未払い情報件数 = 0;
    private FlexibleDate 申請日;
    private RString 整理番号;
    private FlexibleYearMonth 提供年月;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find償還未払い情報");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ShokanUnpaidTempTableEntity.class)
                .tempTableName(ShokanUnpaidTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuTwoEntity t) {
        償還未払い情報件数++;
        if (1 == 償還未払い情報件数) {
            申請日 = t.get償還払支給申請Entity().getShinseiYMD();
            整理番号 = t.get償還払支給申請Entity().getSeiriNo();
            提供年月 = t.get償還払支給申請Entity().getServiceTeikyoYM();
        }
        ShokanUnpaidTempTableEntity tempTableEntity = create償還未払い情報一時テーブル情報(t);
        tmpTableWriter.insert(tempTableEntity);
    }

    private ShokanUnpaidTempTableEntity create償還未払い情報一時テーブル情報(ShiharaiHohoHenkoHaakuTwoEntity t) {
        ShokanUnpaidTempTableEntity result = new ShokanUnpaidTempTableEntity();
        ShiharaiHohoHenkoTempEditJoho shiharaiHohoHenkoTempEditJoho = new ShiharaiHohoHenkoTempEditJoho();
        edit件数について(t.get償還払支給判定結果Entity().getKetteiTsuchishoSakuseiYMD(), t.get償還払支給判定結果Entity().getKetteiYMD());
        result.setHihokenshaNo(t.get償還払支給申請Entity().getHiHokenshaNo());
        result.setShinseiProcess(shiharaiHohoHenkoTempEditJoho.edit申請中());
        result.setShinseiYMD(申請日);
        result.setShinseiProcessNumber(申請中件数);
        result.setSeiriNo(整理番号);
        result.setTeikyoYM(提供年月);
        result.setMiTsuchiNumber(未通知件数);
        return result;
    }

    private void edit件数について(FlexibleDate 決定通知書作成年月日, FlexibleDate 決定年月日) {
        if (決定通知書作成年月日 == null || 決定通知書作成年月日.isEmpty()) {
            if (決定年月日 == null || 決定年月日.isEmpty()) {
                申請中件数 = 申請中件数 + 1;
            }
            未通知件数 = 未通知件数 + 1;
        }
    }

    private RString edit申請中() {
        if (申請中件数 > 件数_0) {
            return 申請中;
        }
        return RString.EMPTY;
    }
}
