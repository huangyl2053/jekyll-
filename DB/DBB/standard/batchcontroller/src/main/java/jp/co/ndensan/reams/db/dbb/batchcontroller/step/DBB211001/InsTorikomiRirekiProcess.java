/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTorikomiRirekiProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT1704KaigoTokuchoTorikomiRirekiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護特別徴収情報取込履歴の登録します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsTorikomiRirekiProcess extends BatchProcessBase<Integer> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.getMAX連番");

    private static final RString 処理対象月_07月 = new RString("07");
    private static final RString 処理対象月_7月 = new RString("7");
    private static final RString バイト_依頼情報 = new RString("6");
    private static final RString バイト_異動情報 = new RString("7");

    private InsTorikomiRirekiProcessParameter parameter;
    private boolean is連番Null;

    @BatchWriter
    BatchPermanentTableWriter 介護特別徴収情報Writer;

    @Override
    protected void initialize() {
        is連番Null = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        介護特別徴収情報Writer = new BatchPermanentTableWriter(UeT1704KaigoTokuchoTorikomiRirekiEntity.class);
    }

    @Override
    protected void process(Integer max連番) {
        is連番Null = false;
        UeT1704KaigoTokuchoTorikomiRirekiEntity entity = 介護特別徴収情報の設定(max連番);
        介護特別徴収情報Writer.insert(entity);
    }

    @Override
    protected void afterExecute() {
        if (is連番Null) {
            UeT1704KaigoTokuchoTorikomiRirekiEntity entity = 介護特別徴収情報の設定(0);
            介護特別徴収情報Writer.insert(entity);
        }
    }

    private UeT1704KaigoTokuchoTorikomiRirekiEntity 介護特別徴収情報の設定(int max連番) {
        UeT1704KaigoTokuchoTorikomiRirekiEntity entity = new UeT1704KaigoTokuchoTorikomiRirekiEntity();
        entity.setRenban(max連番 + 1);
        if (処理対象月_7月.equals(parameter.get処理対象月())
                || 処理対象月_07月.equals(parameter.get処理対象月())) {
            entity.setDataShubetsu(バイト_依頼情報);
        } else {
            entity.setDataShubetsu(バイト_異動情報);
        }
        entity.setShoriTimestamp(parameter.getシステム日時().getRDateTime());
        entity.setFileName(RString.EMPTY);
        return entity;
    }
}
