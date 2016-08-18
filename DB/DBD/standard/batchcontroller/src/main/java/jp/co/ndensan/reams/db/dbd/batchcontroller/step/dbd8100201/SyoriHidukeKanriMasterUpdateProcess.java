/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.SyoriHidukeKanriMasterUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ更新_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public class SyoriHidukeKanriMasterUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "hikazeinennkintaishousyajohotorikomi.ISyoriHidukeKanriMasterUpdateMapper.get処理日付管理マスタを更新する");

    private SyoriHidukeKanriMasterUpdateProcessParameter processParameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> hikazeNenkinTableEntity;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, processParameter.MybatisParameter(processParameter.get保険者情報_保険者番号(),
                processParameter.get処理名(), processParameter.get処理年度(), processParameter.get処理区分(), processParameter.get対象月()));
    }

    @Override
    protected void createWriter() {
        hikazeNenkinTableEntity = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity t) {
        if (hikazeNenkinTableEntity.getUpdateCount() != 0) {
            edit処理日付管理マスタ更新データ(t);
            hikazeNenkinTableEntity.update(t);
        } else if (hikazeNenkinTableEntity.getUpdateCount() == 0) {
            edit処理日付管理マスタ挿入データ(t);
            hikazeNenkinTableEntity.insert(t);
        }
    }

    private void edit処理日付管理マスタ更新データ(DbT7022ShoriDateKanriEntity t) {
        t.setShoriEdaban(new RString("2"));
        t.setKijunYMD(processParameter.get処理年月日());
        t.setKijunTimestamp(processParameter.get処理日時());
    }

    private void edit処理日付管理マスタ挿入データ(DbT7022ShoriDateKanriEntity t) {
        t.setSubGyomuCode(SubGyomuCode.DBD介護受給);
        t.setShichosonCode(processParameter.get保険者情報_保険者番号());
        t.setShoriName(processParameter.get処理名());
        t.setShoriEdaban(new RString("2"));
        t.setNendo(processParameter.get処理年度());
        t.setNendoNaiRenban(processParameter.get処理区分_対象月());
        t.setKijunYMD(processParameter.get処理年月日());
        t.setKijunTimestamp(processParameter.get処理日時());
    }

}
