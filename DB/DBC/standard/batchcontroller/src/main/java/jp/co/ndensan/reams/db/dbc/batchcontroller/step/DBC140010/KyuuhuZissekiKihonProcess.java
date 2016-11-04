/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushakyufujissekidaicho.JukyushaKyufuDaichoEdit;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.CareManagementRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.HukushiYouguRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.JuutakuKaishuuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KeikakuHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KyuuhuZissekiKougakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiJuushoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShakaiHukushiHouzinKeigenRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShoteiShikkanRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiShinryouHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者給付実績台帳のバッチ処理クラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class KyuuhuZissekiKihonProcess extends BatchProcessBase<KihonRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get基本");
    private static final ReportId ID = ReportIdDBC.DBC100055.getReportId();
    private static final RString MESSAGE = new RString("**　対象データは存在しません　**");
    private boolean flag = false;
    private JukyushaKyufuJissekidaichoData jukyushaKyufuDaicho = new JukyushaKyufuJissekidaichoData();
    private JukyushaKyufujissekiDaichoProcessParameter parameter;
    private IJukyushaKyufujissekiDaichoMapper mapper;
    private JukyushaKyufuDaichoEdit edit;
    List<MeisaiRelateEntity> 明細;
    List<KinkyuuziShisetuRyouyouRelateEntity> 緊急時施設療養;
    List<TokuteiShinryouHiRelateEntity> 特定診療費;
    List<KeikakuHiRelateEntity> 計画費;
    List<HukushiYouguRelateEntity> 福祉用具;
    List<JuutakuKaishuuRelateEntity> 住宅改修;
    List<TokuteiServiceHiRelateEntity> 特定入所者介護サービス費用;
    List<ShakaiHukushiHouzinKeigenRelateEntity> 社会福祉法人軽減額;
    List<CareManagementRelateEntity> ケアマネジメント費;
    List<ShoteiShikkanRelateEntity> 所定疾患施設療養費;
    List<MeisaiJuushoRelateEntity> 明細住所地特例;
    List<ShuukeiRelateEntity> 集計;
    List<KyuuhuZissekiKougakuRelateEntity> 給付実績高額;

    @BatchWriter
    private BatchReportWriter<JukyushaKyufuJissekidaichoReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaKyufuJissekidaichoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IJukyushaKyufujissekiDaichoMapper.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        parameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
        edit = new JukyushaKyufuDaichoEdit();
    }

    @Override
    protected void beforeExecute() {
        明細 = mapper.get明細(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
        edit.setMeisaiList(明細);
        緊急時施設療養 = mapper.get緊急時施設療養(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        特定診療費 = mapper.get特定診療費(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        計画費 = mapper.get計画費(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        福祉用具 = mapper.get福祉用具(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        住宅改修 = mapper.get住宅改修(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        特定入所者介護サービス費用 = mapper.get特定入所者介護サービス費用(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        社会福祉法人軽減額 = mapper.get社会福祉法人軽減額(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        ケアマネジメント費 = mapper.getケアマネジメント費(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        所定疾患施設療養費 = mapper.get所定疾患施設療養費(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        明細住所地特例 = mapper.get明細住所地特例(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        集計 = mapper.get集計(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());

        給付実績高額 = mapper.get給付実績高額(parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void process(KihonRelateEntity entity) {
        flag = true;

    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            jukyushaKyufuDaicho.set被保険者氏名(MESSAGE);
            JukyushaKyufuJissekidaichoReport report = new JukyushaKyufuJissekidaichoReport(jukyushaKyufuDaicho);
            report.writeBy(reportSourceWriter);
        }
    }

}
