/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import jp.co.ndensan.reams.db.dbc.definition.processprm.idoriyoshafutanwariaihentei.IdoRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 処理日付管理の登録処理クラスです。
 *
 * @reamsid_L DBC-4950-031 zhujun
 */
public class UpdateShoriDateKanriTblProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "idoriyoshafutanwariaihentei.IIdoRiyoshaFutanwariaiHanteiMapper.selectMaxRenban");

    private static final RString 連番 = new RString("01");
    private static final RString FORMAT = new RString("0000");

    private IdoRiyoshaFutanwariaiHanteiProcessParameter parameter;

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
        // TODO QA.1249あり
        isあり = true;
        DbT7022ShoriDateKanriEntity tmpEntity = new DbT7022ShoriDateKanriEntity();
        tmpEntity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        tmpEntity.setShichosonCode(association.getLasdecCode_());
        tmpEntity.setShoriName(ShoriName.異動分負担割合判定.get名称());
        tmpEntity.setShoriEdaban(getNext(entity.getShoriEdaban()));
        tmpEntity.setNendo(parameter.getTaishoNendo());
        tmpEntity.setNendoNaiRenban(getNext(entity.getNendoNaiRenban()));
        tmpEntity.setTaishoKaishiYMD(new FlexibleDate(parameter.getChushutsuKaishiTime().getDate().toDateString()));
        tmpEntity.setTaishoShuryoYMD(new FlexibleDate(parameter.getChushutsuShuryoTime().getDate().toDateString()));
        tmpEntity.setTaishoKaishiTimestamp(parameter.getChushutsuKaishiTime());
        tmpEntity.setTaishoShuryoTimestamp(parameter.getChushutsuShuryoTime());
        tmpEntity.setState(EntityDataState.Added);
        dbWriter.insert(tmpEntity);
    }

    @Override
    protected void afterExecute() {
        // TODO QA.1249あり
        if (!isあり) {
            DbT7022ShoriDateKanriEntity tmpEntity = new DbT7022ShoriDateKanriEntity();
            tmpEntity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            tmpEntity.setShichosonCode(association.getLasdecCode_());
            tmpEntity.setShoriName(ShoriName.異動分負担割合判定.get名称());
            tmpEntity.setShoriEdaban(連番);
            tmpEntity.setNendo(parameter.getTaishoNendo());
            tmpEntity.setNendoNaiRenban(連番);
            tmpEntity.setTaishoKaishiYMD(new FlexibleDate(parameter.getChushutsuKaishiTime().getDate().toDateString()));
            tmpEntity.setTaishoShuryoYMD(new FlexibleDate(parameter.getChushutsuShuryoTime().getDate().toDateString()));
            tmpEntity.setTaishoKaishiTimestamp(parameter.getChushutsuKaishiTime());
            tmpEntity.setTaishoShuryoTimestamp(parameter.getChushutsuShuryoTime());
            tmpEntity.setState(EntityDataState.Added);
            dbWriter.insert(tmpEntity);
        }
    }

    private RString getNext(RString renban) {
        int num = Integer.parseInt(renban.toString());
        num = num + 1;
        NumberFormat format = new DecimalFormat(FORMAT.toString());
        return new RString(format.format(num));
    }
}
