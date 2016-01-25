/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.idochecklist;

import jp.co.ndensan.reams.db.dba.definition.processprm.idochecklist.UpdShoriDataKanriProcessParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist.IIdoCheckListMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 処理日付管理マスタを更新のプロセスグラス
 */
public class UpdShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private UpdShoriDataKanriProcessParameter param;
    private IIdoCheckListMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022EntityWriter;

    @Override
    protected void createWriter() {
        dbT7022EntityWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void initialize() {
        mapper = getMapper(IIdoCheckListMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(RString.EMPTY);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity t) {
    }

    @Override
    protected void afterExecute() {
        if (param.getZenkaiKaishi() == null && param.getZenkaiShuryo() == null) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShichosonCode(association.get地方公共団体コード());
            entity.setShoriName(new RString("異動チェックリスト"));
            entity.setShoriEdaban(new RString("0000"));
            entity.setNendo(FlexibleYear.MIN);
            entity.setNendoNaiRenban(new RString("0000"));
            entity.setTaishoKaishiYMD(new FlexibleDate(
                    param.getKonkaiKaishi().getYear(),
                    param.getKonkaiKaishi().getMonthOfYear(),
                    param.getKonkaiKaishi().getDayOfMonth()));
            entity.setTaishoShuryoYMD(new FlexibleDate(
                    param.getKonkaiShuryo().getYear(),
                    param.getKonkaiShuryo().getMonthOfYear(),
                    param.getKonkaiShuryo().getDayOfMonth()));
            dbT7022EntityWriter.insert(entity);
        }
        if (param.getZenkaiKaishi() != null && param.getZenkaiShuryo() != null) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShoriName(new RString("異動チェックリスト"));
            entity.setTaishoKaishiYMD(new FlexibleDate(
                    param.getKonkaiKaishi().getYear(),
                    param.getKonkaiKaishi().getMonthOfYear(),
                    param.getKonkaiKaishi().getDayOfMonth()));
            entity.setTaishoShuryoYMD(new FlexibleDate(
                    param.getKonkaiShuryo().getYear(),
                    param.getKonkaiShuryo().getMonthOfYear(),
                    param.getKonkaiShuryo().getDayOfMonth()));
            int count = mapper.updDbt7022ShoriDateKanri(entity);
        }

    }

}
