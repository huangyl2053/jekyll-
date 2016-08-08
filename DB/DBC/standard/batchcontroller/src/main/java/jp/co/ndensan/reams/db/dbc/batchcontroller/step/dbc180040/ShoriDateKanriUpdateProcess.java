/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040;

import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理のProcessクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class ShoriDateKanriUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko."
                    + "IFutanwariaishoHakkoMapper.select処理日付管理");
    private FutanwariaishoHakkoProcessParameter parameter;
    private boolean updateFlag;
    @BatchWriter
    BatchPermanentTableWriter TableWriter;
    Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();

    private static final RString 処理名 = new RString("負担割合証発行（一括）");
    private static final RString 処理枝番_0000 = new RString("0000");
    private static final RString 処理枝番_0001 = new RString("0001");
    private static final RString 処理枝番_0002 = new RString("0002");
    private static final RString 年度内連番_0001 = new RString("0001");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");

    @Override
    protected void initialize() {
        updateFlag = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        TableWriter = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        updateFlag = false;
        TableWriter.update(get処理日付管理());
    }

    @Override
    protected void afterExecute() {
        if (updateFlag) {
            TableWriter.insert(get処理日付管理());
        }
    }

    private DbT7022ShoriDateKanriEntity get処理日付管理() {
        DbT7022ShoriDateKanriEntity item = new DbT7022ShoriDateKanriEntity();
        item.setSubGyomuCode(SubGyomuCode.DBC介護給付);
        item.setShichosonCode(導入団体クラス.getLasdecCode_());
        item.setShoriName(処理名);
        if (ZERO.equals(parameter.get出力対象())) {
            item.setShoriEdaban(処理枝番_0000);
        } else if (ONE.equals(parameter.get出力対象())) {
            item.setShoriEdaban(処理枝番_0001);
            item.setTaishoKaishiTimestamp(new YMDHMS(parameter.get抽出期間開始日時()));
            item.setTaishoShuryoTimestamp(new YMDHMS(parameter.get抽出期間終了日時()));
        } else if (TWO.equals(parameter.get出力対象())) {
            item.setShoriEdaban(処理枝番_0002);
            item.setTaishoKaishiTimestamp(new YMDHMS(parameter.get抽出期間開始日時()));
            item.setTaishoShuryoTimestamp(new YMDHMS(parameter.get抽出期間終了日時()));
        }
        item.setNendo(parameter.get年度());
        item.setNendoNaiRenban(年度内連番_0001);
        item.setKijunTimestamp(new YMDHMS(parameter.getバッチ起動時処理日時()));
        return item;
    }

}
