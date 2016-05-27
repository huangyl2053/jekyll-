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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public class KaiGoJuminHyokouKiuDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojyuminhyokoukiu."
            + "IkaigojyuminhyokoukiuMapper.get処理日付管理マスタ登録処理");
    private boolean isEmpty = true;
    private int i = 0;
    private KaiGoJuminHyokouKiuProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toKaiGoJuminHyokouKiuMapperParameter());
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
                entity.setShoriEdaban(new RString("0000"));
                日付TO(entity);
                対象開始日時(entity);
                対象終了日時(entity);
                tableWrite.insert(entity);
            }
        }
    }

    private void 処理日更新処理(DbT7022ShoriDateKanriEntity entity) {
        if (i <= parameter.getKobetsuKoikiunyoParameterList().size() - 1) {
            entity.setTaishoKaishiTimestamp(new YMDHMS(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateFrom()));
        }
    }

    private void 日付TO(DbT7022ShoriDateKanriEntity entity) {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateTo().getDate());
        日時.append(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateTo().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setKijunTimestamp(new YMDHMS(日時.toString().replace(":", "")));
    }

    private void 対象開始日時(DbT7022ShoriDateKanriEntity entity) {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateFrom().getDate());
        日時.append(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateFrom().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setTaishoKaishiTimestamp(new YMDHMS(日時.toString().replace(":", "")));
    }

    private void 対象終了日時(DbT7022ShoriDateKanriEntity entity) {
        RStringBuilder 日時 = new RStringBuilder();
        日時.append(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateTo().getDate());
        日時.append(parameter.getKobetsuKoikiunyoParameterList().get(i).getDateTo().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setTaishoShuryoTimestamp(new YMDHMS(日時.toString().replace(":", "")));
    }
}
