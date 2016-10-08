/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSofuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050.ShokanRenrakuhyoSofuIchiranParam;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutputReportProcessParam;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DB更新のクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
public class ShokanRenrakuhyoUpdateDBProcess extends BatchProcessBase<DbT3034ShokanShinseiEntity> {

    private static final RString 送付済の登録 = new RString("jp.co.ndensan.reams.db.dbc.persistence"
            + ".db.mapper.relate.dbc110050.IShokanRenrakuhyoOutMapper.get償還払支給申請データ");

    @BatchWriter
    private BatchPermanentTableWriter 償還払支給申請TBL;
    private ShokanRenrakuhyoOutputReportProcessParam processParameter;

    @Override
    protected IBatchReader createReader() {
        ShokanRenrakuhyoSofuIchiranParam parameterDB = new ShokanRenrakuhyoSofuIchiranParam();
        parameterDB.set送付除外フラグ(false);
        return new BatchDbReader(送付済の登録, parameterDB);
    }

    @Override
    protected void createWriter() {
        償還払支給申請TBL = new BatchPermanentTableWriter(DbT3034ShokanShinseiEntity.class);
    }

    @Override
    protected void process(DbT3034ShokanShinseiEntity entity) {
        entity.setSofuKubun(KokuhorenDataSofuKubun.送付済.getコード());
        entity.setSofuYM(processParameter.getSyoriYM());
        entity.setKokuhorenSaisofuFlag(false);
        償還払支給申請TBL.update(entity);
    }

}
