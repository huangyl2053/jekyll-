/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100010.KaishuriyushoSeikyushoShinseishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010.IKaishuriyushoSeikyushoShinseishoMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 *
 */
public class ShoriDateKanriDataProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get処理日付管理マスタデータ");
    private KaishuriyushoSeikyushoShinseishoProcessParameter processParameter;
    private IKaishuriyushoSeikyushoShinseishoMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022EntityWriter;
    private List<DbT7022ShoriDateKanriEntity> dbT7022EntityList = new ArrayList<>();

    @Override
    protected void initialize() {
        mapper = getMapper(IKaishuriyushoSeikyushoShinseishoMapper.class);
        dbT7022EntityList = mapper.get処理日付管理マスタデータ(processParameter.toKaishuriyushoSeikyushoShinseishoMybatisParameter());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaishuriyushoSeikyushoShinseishoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT7022EntityWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        entity.setTaishoKaishiYMD(processParameter.get作成申請年月日開始());
        entity.setTaishoShuryoYMD(processParameter.get作成申請年月日終了());
        dbT7022EntityWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
        if (dbT7022EntityList.isEmpty()) {
            DbT7022ShoriDateKanriEntity dbt7022Entity = new DbT7022ShoriDateKanriEntity();
            dbt7022Entity.setSubGyomuCode(new SubGyomuCode("DBC"));
            dbt7022Entity.setShichosonCode(processParameter.get市町村コード());
            dbt7022Entity.setShoriName(new RString("住宅改修理由書作成手数料請求書兼申請書作成"));
            dbt7022Entity.setShoriEdaban(new RString("0000"));
            dbt7022Entity.setNendo(new FlexibleYear("0000"));
            dbt7022Entity.setNendoNaiRenban(new RString("0001"));
            dbt7022Entity.setTaishoKaishiYMD(processParameter.get作成申請年月日開始());
            dbt7022Entity.setTaishoShuryoYMD(processParameter.get作成申請年月日終了());
            dbT7022EntityWriter.insert(dbt7022Entity);
        }
    }
}
