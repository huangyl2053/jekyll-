/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.ShoriHidukeKanriTeburuKoshiProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(処理日付管理テーブル更新)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class ShoriHidukeKanriTeburuKoshiProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get処理日付管理マスタ");
    private ShoriHidukeKanriTeburuKoshiProcessParameter processParameter;
    private boolean データ取得flag;
    @BatchWriter
    private IBatchTableWriter<DbT7022ShoriDateKanriEntity> 処理管理日付マスタWriter;
    private static final RString 処理名 = new RString("更正対象給付実績一覧");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString 年度 = new RString("0000");
    private static final RString 年度内連番 = new RString("0001");

    @Override
    protected void initialize() {
        データ取得flag = false;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        処理管理日付マスタWriter = BatchWriters.batchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class).build();
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        データ取得flag = true;
        entity.setTaishoKaishiTimestamp(new YMDHMS(processParameter.get抽出期間開始日時()));
        entity.setTaishoShuryoTimestamp(new YMDHMS(processParameter.get抽出期間開始日時()));
        処理管理日付マスタWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
        if (!データ取得flag) {
            処理管理日付マスタWriter.insert(get処理管理日付マスタ());
        }
    }

    private DbT7022ShoriDateKanriEntity get処理管理日付マスタ() {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        entity.setShichosonCode(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
        entity.setShoriName(処理名);
        entity.setShoriEdaban(処理枝番);
        entity.setNendo(new FlexibleYear(年度));
        entity.setNendoNaiRenban(年度内連番);
        entity.setTaishoKaishiTimestamp(new YMDHMS(processParameter.get抽出期間開始日時()));
        entity.setTaishoShuryoTimestamp(new YMDHMS(processParameter.get抽出期間終了日時()));
        return entity;
    }
}
