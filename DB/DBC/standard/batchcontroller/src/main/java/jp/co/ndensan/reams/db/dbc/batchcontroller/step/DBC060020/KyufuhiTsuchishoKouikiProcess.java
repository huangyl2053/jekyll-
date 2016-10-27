/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費福祉用具貸与品目一時TBLを作成します。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchishoKouikiProcess extends BatchProcessBase<KyufuhiTuchiHakkoIchiranRelateEntity> {

    private static final RString 介護給付費福祉用具貸与品目情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufuhitsuchisho.IKyufuhiTsuchishoMapper.get広域の場合");

    private static final RString TABLE_介護給付費福祉用具貸与品目情報 = new RString("KaigoKyufuHiFukushiYouguTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 介護給付費福祉用具貸与品目一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(介護給付費福祉用具貸与品目情報取得SQL);
    }

    @Override
    protected void createWriter() {
        介護給付費福祉用具貸与品目一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_介護給付費福祉用具貸与品目情報,
                KyufuhiTuchiHakkoIchiranRelateEntity.class);
    }

    @Override
    protected void process(KyufuhiTuchiHakkoIchiranRelateEntity entity) {
        介護給付費福祉用具貸与品目一時TBL.update(entity);
    }
}
