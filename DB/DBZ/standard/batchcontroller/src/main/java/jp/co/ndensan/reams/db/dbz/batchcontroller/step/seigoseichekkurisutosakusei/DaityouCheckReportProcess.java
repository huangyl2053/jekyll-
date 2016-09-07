/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.step.seigoseichekkurisutosakusei;

import jp.co.ndensan.reams.db.dbz.business.core.seigoseichekkurisutosakusei.SeigoseiChekkuRisutoBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei.SeigoseiChekkuRisutoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei.SeigoseiChekkuTempTableBEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.seigoseichekkurisutosakusei.ISeigoseiChekkuRisutoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳の作成クラスです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
public class DaityouCheckReportProcess extends BatchProcessBase<SeigoseiChekkuRisutoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.seigoseichekkurisutosakusei."
            + "ISeigoseiChekkuRisutoMapper.select被保険者台帳情報");
    ISeigoseiChekkuRisutoMapper mapper;
    private static final RString TABLE_整合性チェック情報D = new RString("SeigoseiChekkuRisutoDTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 整合性チェック情報一時ファイルD;
    @BatchWriter
    private BatchPermanentTableWriter<DbT1014SeigoseiCheckEntity> dbT1014Temp;

    @Override
    protected void initialize() {
        整合性チェック情報一時ファイルD = new BatchEntityCreatedTempTableWriter(TABLE_整合性チェック情報D,
                SeigoseiChekkuTempTableBEntity.class);
        mapper = getMapper(ISeigoseiChekkuRisutoMapper.class);
        mapper.del被保険者台帳情報削除();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        dbT1014Temp = new BatchPermanentTableWriter<>(DbT1014SeigoseiCheckEntity.class);
    }

    @Override
    protected void process(SeigoseiChekkuRisutoEntity entity) {
        dbT1014Temp.insert(SeigoseiChekkuRisutoBusiness.set整合性チェック情報登録D(entity));
    }
}
