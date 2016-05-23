/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.kaigojyuminhyokoukiu;

import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
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
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public class KaiGoJuminHyokouKiuDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT7022ShoriDateKanriMapper"
            + ".get処理日付管理マスタ登録処理");
    private boolean isEmpty = true;
    private int i = 0;
    private KaiGoJuminHyokouKiuProcessParameter parameter;

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
        entity.setKijunTimestamp(new YMDHMS(parameter.getKobetsuKoikiunyoParameterList().get(0).getDateTo()));
        処理日更新処理(entity);
        entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.getKobetsuKoikiunyoParameterList().get(0).getDateTo()));
        tableWrite.update(entity);
        i++;
    }

    @Override
    protected void afterExecute() {
        if (isEmpty) {
            for (int i = 0; i < parameter.getKobetsuKoikiunyoParameterList().size(); i++) {
                DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
                entity.setSubGyomuCode(SubGyomuCode.DBU介護統計報告);
                entity.setShichosonCode(new LasdecCode(parameter.getKobetsuKoikiunyoParameterList().get(i).getShichosonCode().toString()));
                entity.setShoriName(new RString("介護住民票個別事項連携情報作成【広域運用】"));
                entity.setNendo(new FlexibleYear("0000"));
                entity.setNendoNaiRenban(new RString("0000"));
                entity.setKijunTimestamp(new YMDHMS(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateTo().toString()));
                entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateFrom().toString()));
                entity.setTaishoShuryoTimestamp(new YMDHMS(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateTo().toString()));
                tableWrite.insert(entity);
            }
        }
    }

    private void 処理日更新処理(DbT7022ShoriDateKanriEntity entity) {
        if (i <= parameter.getKobetsuKoikiunyoParameterList().size() - 1) {
            entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateFrom()));
        }

    }
}
