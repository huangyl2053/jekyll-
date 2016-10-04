/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD206010;

import jp.co.ndensan.reams.db.dbd.business.core.dbd206010.JigyoshomukeshakaiDataManager;
import jp.co.ndensan.reams.db.dbd.business.core.dbd206010.TyohyoShutuyukuOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd206010.DBD206010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.KeikakuJigyoshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.TyohyoShutuyukuItokiTempEntity;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のprocessクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public class KeikakuJigyoshaJohoProcess extends BatchProcessBase<KeikakuJigyoshaJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.jigyoshomukeshakai.IKeikakuJigyoshaJohoMapper.get計画事業者情報");
    private DBD206010ProcessParameter processParameter;
    private IOutputOrder outputOrder;
    private static final int NUM5 = 5;
    private RString orderBy = null;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tyohyoShutuyukuItokiTemp;

    @Override
    protected void initialize() {
        if (processParameter.get出力順ID() != 0) {
            IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            long 帳票出力順ID = processParameter.get出力順ID();
            outputOrder = chohyoShutsuryokujunFinder.get出力順(
                    SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200017.getReportId(), 帳票出力順ID);
            if (null != outputOrder) {
                orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(TyohyoShutuyukuOrderKey.class, outputOrder), NUM5);
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDBD206010MybatisParameter(orderBy));
    }

    @Override
    protected void createWriter() {
        tyohyoShutuyukuItokiTemp = new BatchEntityCreatedTempTableWriter(TyohyoShutuyukuItokiTempEntity.TABLE_NAME,
                TyohyoShutuyukuItokiTempEntity.class);
    }

    @Override
    protected void process(KeikakuJigyoshaJohoEntity entity) {
        if (entity.get計画事業者番号() != null && !entity.get計画事業者番号().isEmpty()) {
            TyohyoShutuyukuItokiTempEntity tempTable = new TyohyoShutuyukuItokiTempEntity();
            JigyoshomukeshakaiDataManager manager = new JigyoshomukeshakaiDataManager();
            manager.set帳票出力用一時テーブル(entity, tempTable);
            tyohyoShutuyukuItokiTemp.insert(tempTable);
        }
    }
}
