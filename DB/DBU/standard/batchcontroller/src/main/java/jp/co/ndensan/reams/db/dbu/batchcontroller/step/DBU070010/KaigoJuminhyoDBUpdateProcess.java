/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU070010;

import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyo.KaigoJuminhyoProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護住民票個別事項連携情報作成【他社住基】のバッチ処理のDB更新のプロセスクラスです。
 *
 * @reamsid_L DBU-0350-020 lijia
 *
 */
public class KaigoJuminhyoDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT7022ShoriDateKanriMapper.getTaishoShuryoYMD");
    private boolean isEmpty = true;
    private KaigoJuminhyoProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        isEmpty = false;
        entity.setKijunTimestamp(new YMDHMS(parameter.getTaishoShuryoTimestamp()));
        entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.getTaishoKaishiTimestamp()));
        entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.getTaishoShuryoTimestamp()));
        tableWrite.update(entity);
    }

    @Override
    protected void afterExecute() {
        if (isEmpty) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBU介護統計報告);
            entity.setShichosonCode(new LasdecCode("000000"));
            entity.setShoriEdaban(new RString("0000"));
            entity.setShoriName(new RString("介護住民票個別事項連携情報作成【他社住基】"));
            entity.setNendo(new FlexibleYear("0000"));
            entity.setNendoNaiRenban(new RString("0000"));
            entity.setKijunTimestamp(new YMDHMS(parameter.getTaishoShuryoTimestamp()));
            entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.getTaishoKaishiTimestamp()));
            entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.getTaishoShuryoTimestamp()));
            tableWrite.insert(entity);
        }
    }
}
