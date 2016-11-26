/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kanendoriyoshafutanwariaihantei.KanendoRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 処理日付管理の登録処理クラスです。
 *
 * @reamsid_L DBC-4940-030 wangrenze
 */
public class ShoriHizukeKanriTblUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.kanendoriyoshafutanwariaihantei.IKanendoRiyoshaFutanwariaiHanteiMapper.selectDate");
    private static final RString 連番 = new RString("0000");
    private static final RString 年度内連番 = new RString("0001");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private KanendoRiyoshaFutanwariaiHanteiProcessParameter parameter;
    private boolean isあり;
    private Association association;

    @Override
    protected void initialize() {
        isあり = false;
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        isあり = true;
        entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        entity.setShoriName(ShoriName.異動分利用者負担割合判定_過年度.get名称());
        entity.setKijunTimestamp(parameter.getChushutsuShuryoTime());
        entity.setTaishoKaishiTimestamp(parameter.getChushutsuKaishiTime());
        entity.setTaishoShuryoTimestamp(parameter.getChushutsuShuryoTime());
        entity.setState(EntityDataState.Modified);
        dbWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
        if (!isあり) {
            DbT7022ShoriDateKanriEntity tmpEntity = new DbT7022ShoriDateKanriEntity();
            tmpEntity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            tmpEntity.setShichosonCode(association.get地方公共団体コード());
            tmpEntity.setShoriName(ShoriName.異動分利用者負担割合判定_過年度.get名称());
            tmpEntity.setShoriEdaban(連番);
            tmpEntity.setNendo(年度);
            tmpEntity.setNendoNaiRenban(年度内連番);
            tmpEntity.setKijunTimestamp(parameter.getChushutsuShuryoTime());
            tmpEntity.setTaishoKaishiYMD(FlexibleDate.EMPTY);
            tmpEntity.setTaishoShuryoYMD(FlexibleDate.EMPTY);
            tmpEntity.setTaishoKaishiTimestamp(parameter.getChushutsuKaishiTime());
            tmpEntity.setTaishoShuryoTimestamp(parameter.getChushutsuShuryoTime());
            tmpEntity.setState(EntityDataState.Added);
            dbWriter.insert(tmpEntity);
        }
    }
}
