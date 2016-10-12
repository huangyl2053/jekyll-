/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030;

import jp.co.ndensan.reams.db.dbc.business.report.dbc200031.GassanJikofutangakuHoseiIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030.KogakugassanJikofutangakuInfoHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.FutangakuTashoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担額補正対象者データプロセスです。
 *
 * @reamsid_L DBC-2320-060 yuanzhenxia
 */
public class FutangakuTashoshaInsertProcess extends BatchProcessBase<KogakugassanJikofutangakuInfoHoseiTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030."
            + "IKogakugassanJikofutangakuInfoHoseiMapper.get中間DB");
    private static final RString 負担額補正対象者データTEMP = new RString("FutangakuTaishoshaTemp");
    private static final ReportId 高額合算自己負担額補正結果一覧表帳票ID = ReportIdDBC.DBC200031.getReportId();
    private static final RString ZERO = new RString("0");
    private static final RString ORDERBY = new RString("order by");
    private KogakugassanJikofutangakuInfoHoseiProcessParameter processParameter;
    private IOutputOrder 出力順;
    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(負担額補正対象者データTEMP, FutangakuTashoshaEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toKogakugassanJikofutangakuMybatisParameter());
    }

    @Override
    protected void initialize() {
        if (!RString.isNullOrEmpty(processParameter.get改頁出力順ID()) && !ZERO.equals(processParameter.get改頁出力順ID())) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    高額合算自己負担額補正結果一覧表帳票ID, UrControlDataFactory.createInstance().getLoginInfo().getUserId(),
                    Long.valueOf(processParameter.get改頁出力順ID().toString()));
            if (出力順 != null) {
                processParameter.set改頁出力順ID(MyBatisOrderByClauseCreator.create(
                        GassanJikofutangakuHoseiIchiranOutPutOrder.class, 出力順).replace(ORDERBY, RString.EMPTY));
            }
        } else {
            processParameter.set改頁出力順ID(null);
        }
    }

    @Override
    protected void process(KogakugassanJikofutangakuInfoHoseiTempEntity entity) {
        FutangakuTashoshaEntity futangakuTashoshaEntity = new FutangakuTashoshaEntity();
        futangakuTashoshaEntity.setHihokenshaNo(entity.getHihokenshaNo());
        futangakuTashoshaEntity.setTaishoNendo(entity.getTaishoNendo());
        futangakuTashoshaEntity.setHokenshaNo(entity.getHokenshaNo());
        futangakuTashoshaEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        futangakuTashoshaEntity.setRirekiNo2(entity.getRirekiNo2());
        futangakuTashoshaEntity.setHokenSeidoCode(entity.getHokenSeidoCode());
        futangakuTashoshaEntity.setHokenshaMei(entity.getHokenshaMei());
        futangakuTashoshaEntity.setKokuho_HihokenshaShoKigo(entity.getKokuho_HihokenshaShoKigo());
        futangakuTashoshaEntity.setHihokenshaShimeiKana(entity.getHihokenshaShimeiKana());
        futangakuTashoshaEntity.setHihokenshaShimei(entity.getHihokenshaShimei());
        futangakuTashoshaEntity.setUmareYMD(entity.getUmareYMD());
        futangakuTashoshaEntity.setSeibetsuCode(entity.getSeibetsuCode());
        futangakuTashoshaEntity.setTaishoKeisanKaishiYMD(entity.getTaishoKeisanKaishiYMD());
        futangakuTashoshaEntity.setTaishoKeisanShuryoYMD(entity.getTaishoKeisanShuryoYMD());
        futangakuTashoshaEntity.setHihokenshaKaishiYMD(entity.getHihokenshaKaishiYMD());
        futangakuTashoshaEntity.setHihokenshaShuryoYMD(entity.getHihokenshaShuryoYMD());
        futangakuTashoshaEntity.setShinseiYMD(entity.getShinseiYMD());
        futangakuTashoshaEntity.setGokei_JikoFutanGaku(entity.getGokei_JikoFutanGaku());
        futangakuTashoshaEntity.setGokei_70_74JikoFutanGaku(entity.getGokei_70_74JikoFutanGaku());
        futangakuTashoshaEntity.setGokei_Under70KogakuShikyuGaku(entity.getGokei_Under70KogakuShikyuGaku());
        futangakuTashoshaEntity.setGokei_70_74KogakuShikyuGaku(entity.getGokei_70_74KogakuShikyuGaku());
        futangakuTashoshaEntity.setSumi_Gokei_JikoFutanGaku(entity.getSumi_Gokei_JikoFutanGaku());
        futangakuTashoshaEntity.setSumi_Gokei_70_74JikoFutanGaku(entity.getSumi_Gokei_70_74JikoFutanGaku());
        futangakuTashoshaEntity.setSumi_Gokei_Under70KogakuShikyuGaku(entity.getSumi_Gokei_Under70KogakuShikyuGaku());
        futangakuTashoshaEntity.setSumi_Gokei_70_74KogakuShikyuGaku(entity.getSumi_Gokei_70_74KogakuShikyuGaku());
        futangakuTashoshaEntity.setDataSakuseiKubun(entity.getDataSakuseiKubun());
        futangakuTashoshaEntity.setKakunin_UketoriYM(entity.getKakunin_UketoriYM());
        futangakuTashoshaEntity.setHoseiZumi_SofuYM(entity.getHoseiZumi_SofuYM());
        futangakuTashoshaEntity.setShomeisho_UketoriYM(entity.getShomeisho_UketoriYM());
        futangakuTashoshaEntity.setSaisoFlag(entity.getSaisoFlag());
        futangakuTashoshaEntity.setSofuTaishoGaiFlag(entity.getSofuTaishoGaiFlag());
        futangakuTashoshaEntity.setJikoFutanKeisanYMD(entity.getJikoFutanKeisanYMD());
        futangakuTashoshaEntity.setShomeiShoSakuseiYMD(entity.getShomeiShoSakuseiYMD());
        futangakuTashoshaEntity.setJikoFutangakuShomeishoRealHakkoFlag(entity.getJikoFutangakuShomeishoRealHakkoFlag());
        futangakuTashoshaEntity.setBatchHoseiJissiYMD(entity.getBatchHoseiJissiYMD());
        futangakuTashoshaEntity.setRealHoseiJissiYMD(entity.getRealHoseiJissiYMD());
        futangakuTashoshaEntity.setJuminShubetsuCode(entity.getJuminShubetsuCode());
        futangakuTashoshaEntity.setShichosonCode(entity.getShichosonCode());
        futangakuTashoshaEntity.setYubinNo(entity.getYubinNo());
        futangakuTashoshaEntity.setZenkokuJushoCode(entity.getZenkokuJushoCode());
        futangakuTashoshaEntity.setGyoseikuCode(entity.getGyoseikuCode());
        futangakuTashoshaEntity.setIchiranBiko(entity.getIchiranBiko());
        futangakuTashoshaEntity.setJikoFutanGakuHoseiJissi(entity.getJikoFutanGakuHoseiJissi());
        futangakuTashoshaEntity.setKogakuShikyuGakuGakuHoseiJissi(entity.getKogakuShikyuGakuGakuHoseiJissi());
        futangakuTashoshaEntity.setIchiranKakuninKubun(entity.getIchiranKakuninKubun());
        futangakuTashoshaEntity.setIchiranKakuninKubun2(entity.getIchiranKakuninKubun2());
        tempDbWriter.insert(futangakuTashoshaEntity);
    }

}
