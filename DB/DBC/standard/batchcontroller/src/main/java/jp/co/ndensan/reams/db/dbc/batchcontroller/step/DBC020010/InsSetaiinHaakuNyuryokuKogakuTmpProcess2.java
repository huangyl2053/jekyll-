/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.SetaiHihokenshaResultEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握入力生成_世帯員把握入力高額一時の作成2
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class InsSetaiinHaakuNyuryokuKogakuTmpProcess2 extends BatchProcessBase<SetaiHihokenshaResultEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select世帯員把握の結果");

    private static final RString DATE = new RString("01");
    private static final RString 住所地特例該当_1 = new RString("1");
    private static final RString 住所地特例該当_0 = new RString("0");

    private static final RString TABLE_世帯員把握 = new RString("TmpSetaiHaaku");
    private static final RString TABLE_世帯員所得判定明細一時 = new RString("TempSetaiinShotokuHanteiMeisai");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempMeisaiTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATISPATH);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員把握, TempSetaiinHaakuNyuryokuEntity.class);
        tempMeisaiTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細一時,
                TempSetaiinShotokuHanteiEntity.class);
    }

    @Override
    protected void process(SetaiHihokenshaResultEntity entity) {
        HihokenshaDaicho 被保険者情報 = new HihokenshaDaicho(entity.get被保険者情報Entity());
        FlexibleDate 資格取得年月日 = 被保険者情報.get資格取得年月日();
        FlexibleDate 基準年月日 = entity.get世帯員所得情報Entity().getKijunYMD();
        FlexibleDate 世帯員基準日 = null;
        TempSetaiinHaakuNyuryokuEntity 世帯員把握Entity = new TempSetaiinHaakuNyuryokuEntity();
        if (!isNullOrEntity(資格取得年月日) && !isNullOrEntity(基準年月日) && 資格取得年月日.getYearMonth().equals(基準年月日.getYearMonth())) {
            世帯員基準日 = 資格取得年月日;
            世帯員把握Entity.setKijunYMD(世帯員基準日);
        } else if (!isNullOrEntity(資格取得年月日) && !isNullOrEntity(基準年月日)
                && 資格取得年月日.getYearMonth().isBefore(基準年月日.getYearMonth())) {
            世帯員基準日 = new FlexibleDate(基準年月日.getYearMonth().toDateString().concat(DATE));
            世帯員把握Entity.setKijunYMD(世帯員基準日);
        }
        世帯員把握Entity.setShotokuNendo(entity.get世帯員所得情報Entity().getShotokuNendo());
        FlexibleDate 適用年月日 = 被保険者情報.get適用年月日();
        FlexibleDate 解除年月日 = 被保険者情報.get解除年月日();
        if ((!isNullOrEntity(適用年月日) && !isNullOrEntity(世帯員基準日) && !isNullOrEntity(解除年月日)
                && 適用年月日.isBeforeOrEquals(世帯員基準日)
                && 世帯員基準日.isBefore(解除年月日))
                || (!isNullOrEntity(適用年月日) && !isNullOrEntity(世帯員基準日)
                && 適用年月日.isBeforeOrEquals(世帯員基準日)
                && (isNullOrEntity(解除年月日)))) {
            世帯員把握Entity.setJushochiTokureiFlag(住所地特例該当_1);
        } else {
            世帯員把握Entity.setJushochiTokureiFlag(住所地特例該当_0);
        }
        世帯員把握Entity.setHihokenshaNo(被保険者情報.get被保険者番号());
        世帯員把握Entity.setShikibetsuCode(被保険者情報.get識別コード());
        tableWriter.insert(世帯員把握Entity);
    }

    @Override
    protected void afterExecute() {
        tempMeisaiTableWriter.getInsertCount();
    }

    private boolean isNullOrEntity(FlexibleDate date) {
        return date == null || date.isEmpty();
    }
}
