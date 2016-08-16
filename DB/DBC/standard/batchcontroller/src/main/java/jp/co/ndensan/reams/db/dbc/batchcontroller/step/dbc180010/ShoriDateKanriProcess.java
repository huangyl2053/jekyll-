/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * @author LDNS 袁震霞
 */
public class ShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString DB_READER_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei"
                    + ".INenjiRiyoshaFutanwariaiHanteiMapper.get処理日付管理マスタ");
    private NenjiRiyoshaFutanwariaiHanteiProcessParameter processParameter;
    private boolean 処理日付管理マスタを登録FLAG = true;
    private Association 市町村コード;
    private final RString 処理枝番 = new RString("0001");
    private final RString 年度内連番 = new RString("0001");
    private final RString 理由 = new RString("年次利用者負担割合判定更新");
    private static final RString ONERSTRING = new RString("1");
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;

    @Override
    protected void initialize() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        市町村コード = finder.getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DB_READER_MAPPER_ID, processParameter.toNenjiRiyoshaFutanwariaiHanteiMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        entity.setShichosonCode(市町村コード.get地方公共団体コード());
        entity.setNendo(processParameter.get対象年度());
        entity.setKijunTimestamp(processParameter.get処理日時());
        tableWrite.update(entity);
        処理日付管理マスタを登録FLAG = false;
    }

    @Override
    protected void afterExecute() {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        if (処理日付管理マスタを登録FLAG) {
            entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            entity.setShichosonCode(市町村コード.get地方公共団体コード());
            entity.setShoriName(ShoriName.年次負担割合判定.get名称());
            entity.setShoriEdaban(処理枝番);
            entity.setNendoNaiRenban(年度内連番);
            entity.setNendo(processParameter.get対象年度());
            entity.setKijunTimestamp(processParameter.get処理日時());
            tableWrite.insert(entity);
        }
        BusinessConfig.update(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理済年度, processParameter.get対象年度().toDateString(), 理由,
                RString.EMPTY, RDate.getNowDate());
        BusinessConfig.update(ConfigNameDBC.利用者負担割合判定管理_年次負担割合処理状態, ONERSTRING, 理由, RString.EMPTY, RDate.getNowDate());
    }
}
