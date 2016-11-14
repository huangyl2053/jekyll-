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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.CareManagementEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.HukushiYouguEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.JuutakuKaishuuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KeikakuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShakaiHukushiHouzinKeigenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShoteiShikkanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiShinryouHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaTmpMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
public class KyuuhuZissekiKihonProcess extends BatchProcessBase<KihonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get基本");
    private static final ReportId ID = ReportIdDBC.DBC100055.getReportId();
    private static final RString MESSAGE = new RString("**　対象データは存在しません　**");
    private boolean flag = false;
    private JukyushaKyufuJissekidaichoData jukyushaKyufuDaicho;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;
    private IJukyushaTmpMapper mapper;
    private JukyushaKyufuDaichoEdit edit;
    List<MeisaiEntity> 明細;
    List<KinkyuuziShisetuRyouyouEntity> 緊急時施設療養;
    List<TokuteiShinryouHiEntity> 特定診療費;
    List<KeikakuHiEntity> 計画費;
    List<HukushiYouguEntity> 福祉用具;
    List<JuutakuKaishuuEntity> 住宅改修;
    List<TokuteiServiceHiEntity> 特定入所者介護サービス費用;
    List<ShakaiHukushiHouzinKeigenEntity> 社会福祉法人軽減額;
    List<CareManagementEntity> ケアマネジメント費;
    List<ShoteiShikkanEntity> 所定疾患施設療養費;
    List<ShuukeiEntity> 集計;
    List<KihonEntity> 給付実績高額;
    private RString 保険者コード;
    private RString 保険者名;

    @BatchWriter
    private BatchReportWriter<JukyushaKyufuJissekidaichoReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaKyufuJissekidaichoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IJukyushaTmpMapper.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        parameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
        edit = new JukyushaKyufuDaichoEdit();
        保険者コード = AssociationFinderFactory.createInstance().getAssociation()
                .getLasdecCode_().value();
        保険者名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
    }

    @Override
    protected void beforeExecute() {
        明細 = mapper.get明細();
        緊急時施設療養 = mapper.get緊急時施設療養();
        特定診療費 = mapper.get特定診療費();
        計画費 = mapper.get計画費();
        福祉用具 = mapper.get福祉用具();
        住宅改修 = mapper.get住宅改修();
        特定入所者介護サービス費用 = mapper.get特定入所者介護サービス費用();
        社会福祉法人軽減額 = mapper.get社会福祉法人軽減額();
        ケアマネジメント費 = mapper.getケアマネジメント費();
        所定疾患施設療養費 = mapper.get所定疾患施設療養費();
        集計 = mapper.get集計();
        給付実績高額 = mapper.get給付実績高額();
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
    protected void process(KihonEntity entity) {
        flag = true;
        jukyushaKyufuDaicho = new JukyushaKyufuJissekidaichoData();
        edit.report受給者給付台帳(entity,
                給付実績高額,
                jukyushaKyufuDaicho,
                reportSourceWriter,
                明細,
                集計,
                特定入所者介護サービス費用,
                緊急時施設療養,
                特定診療費,
                計画費,
                所定疾患施設療養費,
                福祉用具,
                住宅改修,
                ケアマネジメント費,
                社会福祉法人軽減額,
                保険者コード,
                保険者名);
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            jukyushaKyufuDaicho = new JukyushaKyufuJissekidaichoData();
            jukyushaKyufuDaicho.set被保険者氏名(MESSAGE);
            JukyushaKyufuJissekidaichoReport report = new JukyushaKyufuJissekidaichoReport(jukyushaKyufuDaicho);
            report.writeBy(reportSourceWriter);
        }
    }
}
