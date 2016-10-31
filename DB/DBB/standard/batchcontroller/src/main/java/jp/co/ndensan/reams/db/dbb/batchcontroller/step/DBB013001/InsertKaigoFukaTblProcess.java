/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.setaiinhaakuinputtable.TmpSetaiHaaku;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握入力テーブルに登録クラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class InsertKaigoFukaTblProcess extends BatchProcessBase<TmpSetaiHaaku> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper.do世帯員把握入力テーブルに登録");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員把握入力テーブルWriter;
    private static final RString 世帯員把握入力テーブル_TABLE_NAME = new RString("TmpSetaiHaaku");

    @Override
    protected void initialize() {

    }

    @Override
    protected void createWriter() {
        世帯員把握入力テーブルWriter = new BatchEntityCreatedTempTableWriter(
                世帯員把握入力テーブル_TABLE_NAME, TmpSetaiHaaku.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(TmpSetaiHaaku entity) {
        世帯員把握入力テーブルWriter.insert(entity);
    }
}
