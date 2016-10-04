/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateGetSoufuDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateMeisyoKanrenEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護給付費再審査申立書情報作成・DB更新を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateDoDBKoushinProcess extends BatchProcessBase<SaishinsaMoshitateMeisyoKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.selectDB更新データ関連リスト");
    SaishinsaMoshitateGetSoufuDataProcessParameter parameter;
    @BatchWriter
    private BatchPermanentTableWriter 再審査申立tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        再審査申立tableWriter
                = new BatchPermanentTableWriter(DbT3062SaishinsaMoshitateEntity.class);
    }

    @Override
    protected void process(SaishinsaMoshitateMeisyoKanrenEntity entity) {
        DbWT1741SaishinsaMoshitateEntity 再審査申立一時 = entity.get再審査申立();
        DbT3062SaishinsaMoshitateEntity 再審査申立データ = entity.get再審査申立データ();
        if (null != 再審査申立一時 && !再審査申立一時.isSofuJogaiFlag()) {
            再審査申立データ.setKokuhorenSofuYM(new FlexibleYearMonth(parameter.get処理年月().toDateString()));
            再審査申立データ.setKokuhirenSaiSofuAriFlag(false);
            再審査申立データ.setState(EntityDataState.Modified);
            再審査申立tableWriter.update(再審査申立データ);
        } else if (null != 再審査申立一時 && 再審査申立一時.isSofuJogaiFlag()) {
            再審査申立データ.setKokuhorenSofuYM(FlexibleYearMonth.EMPTY);
            再審査申立データ.setKokuhirenSaiSofuAriFlag(false);
            再審査申立データ.setState(EntityDataState.Modified);
            再審査申立tableWriter.update(再審査申立データ);
        }
    }

}
