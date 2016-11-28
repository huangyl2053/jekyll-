/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001;

import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonBusiness;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoshaChushutsuSokyubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）のProcessです。
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class GaibuRenkeiDataoutputJohoDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper.get処理日付管理マスタ更新");
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;
    private KogakuKaigoTaishoProcessParameter paramter;
    private KogakuKaigoTaishoshaChushutsuSokyubun sokyubun;
    private LasdecCode 団体コード;
    private KakobunJissekiKihonBusiness business;
    private boolean 更新フラグ;
    private DbT7022ShoriDateKanriEntity 処理日付情報;

    @Override
    protected void initialize() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        団体コード = association.get地方公共団体コード();
        sokyubun = KogakuKaigoTaishoshaChushutsuSokyubun.createInstance();
        business = new KakobunJissekiKihonBusiness();
        更新フラグ = false;

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.setparameter(paramter, 団体コード.value(), RString.EMPTY));
    }

    @Override
    protected void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity item) {
        処理日付情報 = sokyubun.koshinShoriDateKanri(paramter.get抽出期間開始日時(), paramter.get抽出期間開始日時(),
                new FlexibleDate(paramter.get処理日時()), item, 団体コード);
        tableWrite.update(処理日付情報);
        更新フラグ = true;
    }

    @Override
    protected void afterExecute() {
        if (!更新フラグ) {
            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            処理日付情報 = sokyubun.koshinShoriDateKanri(paramter.get抽出期間開始日時(), paramter.get抽出期間開始日時(),
                    new FlexibleDate(paramter.get処理日時()), entity, 団体コード);
            tableWrite.insert(処理日付情報);
        }
    }
}
