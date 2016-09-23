package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012003;

import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty.DBB100012ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.ShutsuRyokuTaishoShutokuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoIdoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.DbT2002FukaTempTableEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「通知書発行後異動者の登録」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TsuchishoIdoshaTorokuProcess extends BatchProcessBase<DbT2002FukaTempTableEntity> {

    private TsuchishoIdoshaTorokuProcessParameter parameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT2017TsuchishoHakkogoIdoshaEntity> dbT2017Writer;

    private int 連番;
    private static final int NUM5 = 5;
    private static final ReportId REPORT_ID_DBB100012 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako."
            + "ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.select賦課For通知書発行後異動者");

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, REPORT_ID_DBB100012, Long.parseLong(parameter.get出力順ID().toString()));
        RString 出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(DBB100012ShutsuryokujunEnum.class, outputOrder), NUM5);

        return new BatchDbReader(MYBATIS_SELECT_ID, new ShutsuRyokuTaishoShutokuMyBatisParameter(出力順, parameter.get出力対象区分()));
    }

    @Override
    protected void createWriter() {
        dbT2017Writer = new BatchPermanentTableWriter<>(DbT2017TsuchishoHakkogoIdoshaEntity.class);
    }

    @Override
    protected void process(DbT2002FukaTempTableEntity entity) {

        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
        DbT2017TsuchishoHakkogoIdoshaEntity dbT2017 = service.insTsuchishoHakkogoIdosha(entity, parameter, 連番);
        dbT2017Writer.insert(dbT2017);
        連番++;
    }

}
