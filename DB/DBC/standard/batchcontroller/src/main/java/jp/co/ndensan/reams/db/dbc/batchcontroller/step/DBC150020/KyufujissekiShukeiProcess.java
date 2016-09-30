/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020;

import jp.co.ndensan.reams.db.dbc.business.core.nenreikaikyuriyojokyo.KyufujissekiEdit;
import jp.co.ndensan.reams.db.dbc.definition.processprm.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpKyufujissekiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpSyuturyokuYoRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績集計データ取得、「給付実績データ一時TBL」に登録するクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
public class KyufujissekiShukeiProcess extends BatchProcessBase<NenreikaikyuRiyojokyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenreikaikyuriyojokyo."
            + "INenreikaikyuRiyojokyoMapper.getKyufujissekiShukei");
    private static final RString 給付実績NAME = new RString("DbKyufujissekiTemp");
    private NenreikaikyuRiyojokyoProcessParameter processParameter;
    private KyufujissekiEdit edit;
    private static final RString 処理結果リスト一時TBL_NAME = new RString("DbWSyorikekkatempTbl");
    private static final RString 出力用一時TBL_NAME = new RString("DbSyuturyokuYoTemp");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 出力用一時TBL;

    @Override
    protected void beforeExecute() {
        edit = new KyufujissekiEdit();
    }

    @Override
    protected void createWriter() {
        給付実績Temp = new BatchEntityCreatedTempTableWriter(給付実績NAME,
                TmpKyufujissekiRelateEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TBL_NAME,
                SyorikekkatempTblEntity.class);
        出力用一時TBL = new BatchEntityCreatedTempTableWriter(出力用一時TBL_NAME,
                TmpSyuturyokuYoRelateEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toNenreikaikyuRiyojokyoMybatisParameter());
    }

    @Override
    protected void process(NenreikaikyuRiyojokyoRelateEntity entity) {
        if (null != entity) {
            給付実績Temp.insert(edit.editEntity(entity));
        }
    }

}
