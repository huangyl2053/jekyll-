/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.nenreikaikyuriyojokyo.KyufujissekiEdit;
import jp.co.ndensan.reams.db.dbc.definition.processprm.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoRelateEntity;
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
 * 給付実績居宅サービス計画費データ取得、 「給付実績データ一時TBL」に登録クラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
public class KyufujissekiKyotakuProcess extends BatchProcessBase<NenreikaikyuRiyojokyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenreikaikyuriyojokyo."
            + "INenreikaikyuRiyojokyoMapper.getKyufujissekiKyotaku");
    private static final RString 給付実績NAME = new RString("DbKyufujissekiTemp");
    private static final RString 出力用NAME = new RString("DbSyuturyokuYoTemp");
    private NenreikaikyuRiyojokyoProcessParameter processParameter;
    private KyufujissekiEdit edit;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績Temp;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 出力用Temp;

    @Override
    protected void beforeExecute() {
        edit = new KyufujissekiEdit();
    }

    @Override
    protected void createWriter() {
        給付実績Temp = new BatchEntityCreatedTempTableWriter(給付実績NAME,
                TmpKyufujissekiRelateEntity.class);
        出力用Temp = new BatchEntityCreatedTempTableWriter(出力用NAME,
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

    @Override
    protected void afterExecute() {
        List<TmpSyuturyokuYoRelateEntity> dataList = edit.set出力用一時TBL();
        for (TmpSyuturyokuYoRelateEntity entity : dataList) {
            出力用Temp.insert(entity);
        }
    }

}
