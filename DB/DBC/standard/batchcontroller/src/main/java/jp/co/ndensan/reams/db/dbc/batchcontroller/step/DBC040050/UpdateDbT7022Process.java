/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタを更新processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class UpdateDbT7022Process extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private KogakugassanShikyuKetteitsuchishoProcessParameter processParameter;
    private static final RString 日付選択区分_受取年月 = new RString("1");
    private static final RString 日付選択区分_申請年月日 = new RString("2");
    private static final RString 処理枝番_受取年月 = new RString("0001");
    private static final RString 処理枝番_申請年月日 = new RString("0002");
    private static final RString 処理枝番_決定年月日 = new RString("0003");
    private static final RString 日_01 = new RString("01");
    private static final RString INSERT_RENBAN = new RString("0001");
    private static DbT7022ShoriDateKanriEntity tempEntity;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassanshikyuketteitsuchisho.IKogakugassanShikyuKetteitsuchishoMapper.update処理日付管理マスタ");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        KogakugassanShikyuKetteitsuchishoMybatisParameter updateParameter
                = new KogakugassanShikyuKetteitsuchishoMybatisParameter();
        updateParameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        if (地方公共団体 != null) {
            updateParameter.set市町村コード(地方公共団体.get地方公共団体コード());
        }
        updateParameter.set処理名(ShoriName.高額合算支給決定通知書_一括.get名称());
        if (日付選択区分_受取年月.equals(processParameter.get日付選択区分())) {
            updateParameter.set処理枝番(処理枝番_受取年月);
        } else if (日付選択区分_申請年月日.equals(processParameter.get日付選択区分())) {
            updateParameter.set処理枝番(処理枝番_申請年月日);
        } else {
            updateParameter.set処理枝番(処理枝番_決定年月日);
        }
        return new BatchDbReader(READ_DATA_ID, updateParameter);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        tempEntity = entity;
        entity = entityUpdate(entity);
        tempDbWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
        if (tempEntity == null) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            entity.setShichosonCode(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
            entity.setShoriName(ShoriName.高額合算支給決定通知書_一括.get名称());
            entity = entityUpdate(entity);
            if (日付選択区分_受取年月.equals(processParameter.get日付選択区分())) {
                entity.setShoriEdaban(処理枝番_受取年月);
            } else if (日付選択区分_申請年月日.equals(processParameter.get日付選択区分())) {
                entity.setShoriEdaban(処理枝番_申請年月日);
            } else {
                entity.setShoriEdaban(処理枝番_決定年月日);
            }
            entity.setKijunYMD(FlexibleDate.EMPTY);
            entity.setNendo(new FlexibleYear("0000"));
            entity.setNendoNaiRenban(INSERT_RENBAN);
            entity.setTaishoKaishiTimestamp(new YMDHMS(RString.EMPTY));
            entity.setTaishoShuryoTimestamp(new YMDHMS(RString.EMPTY));
            tempDbWriter.insert(entity);
        }
    }

    private DbT7022ShoriDateKanriEntity entityUpdate(DbT7022ShoriDateKanriEntity entity) {
        if (日付選択区分_受取年月.equals(processParameter.get日付選択区分())) {
            entity.setTaishoKaishiYMD(new FlexibleDate(processParameter.get受取年月().toDateString().concat(日_01)));
        } else if (日付選択区分_申請年月日.equals(processParameter.get日付選択区分())) {
            entity.setTaishoKaishiYMD(processParameter.get申請開始年月日());
            entity.setTaishoShuryoYMD(processParameter.get申請終了年月日());
        } else {
            entity.setTaishoKaishiYMD(processParameter.get決定開始年月日());
            entity.setTaishoShuryoYMD(processParameter.get決定終了年月日());
        }
        return entity;
    }

}
