/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA130010;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba130010.UpdShoriDataKanriProcessParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist.IIdoCheckListMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 処理日付管理マスタを更新のプロセスグラス
 *
 * @reamsid_L DBA-0530-020 chengsanyuan
 */
public class UpdShoriDateKanriProcess extends BatchProcessBase<RString> {

    private UpdShoriDataKanriProcessParameter param;
    private OutputParameter<Integer> count;
    private IIdoCheckListMapper mapper;
    private static final RString SHORI_NAME_IDOCHECKLIST = new RString("異動チェックリスト");
    private static final RString SHORI_EDABAN = new RString("0000");
    private static final RString NENDO_NAI_RENBAN = new RString("0000");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist.IIdoCheckListMapper."
            + "getListForProcess");
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022EntityWriter;

    @Override
    protected void createWriter() {
        dbT7022EntityWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void initialize() {
        mapper = getMapper(IIdoCheckListMapper.class);
        count = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(RString t) {
    }

    @Override
    protected void afterExecute() {
        if (param.getZenkaiKaishi() == null && param.getZenkaiShuryo() == null) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShichosonCode(association.get地方公共団体コード());
            entity.setShoriName(SHORI_NAME_IDOCHECKLIST);
            entity.setShoriEdaban(SHORI_EDABAN);
            entity.setNendo(FlexibleYear.MIN);
            entity.setNendoNaiRenban(NENDO_NAI_RENBAN);
            entity.setTaishoKaishiYMD(new FlexibleDate(
                    param.getKonkaiKaishi().getYear(),
                    param.getKonkaiKaishi().getMonthOfYear(),
                    param.getKonkaiKaishi().getDayOfMonth()));
            entity.setTaishoShuryoYMD(new FlexibleDate(
                    param.getKonkaiShuryo().getYear(),
                    param.getKonkaiShuryo().getMonthOfYear(),
                    param.getKonkaiShuryo().getDayOfMonth()));
            entity.setIsDeleted(false);
            dbT7022EntityWriter.insert(entity);
            count.setValue(1);
        }
        if (param.getZenkaiKaishi() != null && param.getZenkaiShuryo() != null) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            entity.setShoriName(SHORI_NAME_IDOCHECKLIST);
            entity.setTaishoKaishiYMD(new FlexibleDate(
                    param.getKonkaiKaishi().getYear(),
                    param.getKonkaiKaishi().getMonthOfYear(),
                    param.getKonkaiKaishi().getDayOfMonth()));
            entity.setTaishoShuryoYMD(new FlexibleDate(
                    param.getKonkaiShuryo().getYear(),
                    param.getKonkaiShuryo().getMonthOfYear(),
                    param.getKonkaiShuryo().getDayOfMonth()));
            entity.setIsDeleted(false);
            count.setValue(mapper.updDbt7022ShoriDateKanri(entity));
        }

    }

}
