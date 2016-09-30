/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA140010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jyukirendotorokushalist.JyukiRendoJouhouBusiness;
import jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist.JukiRendoTorokuListItem;
import jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist.JukiRendoTorokuListReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.PsmShikibetsuTaishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba140010.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListBatchEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.TaJushochiTokureiShayouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jyukirendojouhou.IJyukiRendoJouhouMapper;
import jp.co.ndensan.reams.db.dba.service.core.jukirendotorokushalist.JyukiRendoTorokushaListBatch;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住基連動登録者リストを作成します。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
public class JyukiRendoJouhouProcess extends SimpleBatchProcessBase {

    private static final RString 改ページ = new RString("taishoJohotitle");
    private List<RString> page_break_keys;
    private IJyukiRendoJouhouMapper jyukiRendoJouhouMapper;
    private JyukiRendoTorokushaListBatchProcessParameter processParameter;
    private JyukiRendoJouhouBusiness business;

    @BatchWriter
    private BatchReportWriter<JukiRendoTorokuListReportSource> batchReportWriter;
    private ReportSourceWriter<JukiRendoTorokuListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        jyukiRendoJouhouMapper = getMapper(IJyukiRendoJouhouMapper.class);
        page_break_keys = Collections.unmodifiableList(Arrays.asList(改ページ));
        business = new JyukiRendoJouhouBusiness();
    }

    @Override
    protected void process() {
        ShikibetsuCode old識別コード = new ShikibetsuCode("");
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        processParameter = business.setPsetParameter(processParameter);
        JyukiRendoTorokushaListBatchMybatisParameter mybatisParameter
                = processParameter.toJyukiRendoTorokushaListBatchMybatisParameter();
        if (processParameter.isHihokenshadaichoFLG()) {
            jyukiRendoJouhouList.addAll(get被保険者台帳リスト(mybatisParameter));
        }
        if (processParameter.isTajushochitokureishakanriFLG()) {
            jyukiRendoJouhouList.addAll(get他住所地特例者管理リスト(mybatisParameter));
        }
        if (processParameter.isTekiyojogaishadaichoFLG()) {
            jyukiRendoJouhouList.addAll(get適用除外者台帳リスト(mybatisParameter));
        }
        for (JyukiRendoJouhouEntity entity : jyukiRendoJouhouList) {
            if (entity.get識別コード() != null) {
                ShikibetsuCode new識別コード = entity.get識別コード();
                if (!new識別コード.equals(old識別コード)) {
                    ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                            ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                                    GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
                    key.setデータ取得区分(DataShutokuKubun.直近レコード);
                    key.set識別コード(entity.get識別コード());
                    List<JuminShubetsu> 住民種別 = new ArrayList();
                    List<JuminJotai> 住名状態 = new ArrayList();
                    住民種別.add(JuminShubetsu.日本人);
                    住民種別.add(JuminShubetsu.外国人);
                    住民種別.add(JuminShubetsu.住登外個人_日本人);
                    住民種別.add(JuminShubetsu.住登外個人_外国人);
                    住名状態.add(JuminJotai.住民);
                    住名状態.add(JuminJotai.住登外);
                    住名状態.add(JuminJotai.消除者);
                    住名状態.add(JuminJotai.転出者);
                    住名状態.add(JuminJotai.死亡者);
                    key.set住民種別(住民種別);
                    key.set住民状態(住名状態);
                    UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(
                            key.getPSM検索キー());
                    UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity = jyukiRendoJouhouMapper
                            .getPsmShikibetsuTaisho(new PsmShikibetsuTaishoMybatisParameter(
                                            new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString())));
                    getPSM宛名情報(shikibetsuTaishoentity, entity);
                    old識別コード = new識別コード;
                }
            }
            business.set事由名称(entity);
        }
        // TODO 2-上記取得した住基連動情報リストをソートする(技術点を提出しました)
        JyukiRendoTorokushaListBatchEntity jyukiRendoTorokushaEntity = new JyukiRendoTorokushaListBatchEntity();
        jyukiRendoTorokushaEntity.set市町村コード(AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード());
        jyukiRendoTorokushaEntity.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        // TODO 並び順について、技術点を提出しました
        jyukiRendoTorokushaEntity.set並び順_1(RString.EMPTY);
        jyukiRendoTorokushaEntity.set並び順_2(RString.EMPTY);
        jyukiRendoTorokushaEntity.set並び順_3(RString.EMPTY);
        jyukiRendoTorokushaEntity.set並び順_4(RString.EMPTY);
        jyukiRendoTorokushaEntity.set並び順_5(RString.EMPTY);
        jyukiRendoTorokushaEntity.set住基連動情報(jyukiRendoJouhouList);
        JyukiRendoTorokushaListBatch jyukiRendoTorokushaListBatch = new JyukiRendoTorokushaListBatch();
        List<JukiRendoTorokuListItem> item = jyukiRendoTorokushaListBatch.getIdoCheckChohyoData(jyukiRendoTorokushaEntity);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200007.getReportId().value())
                .addBreak(new BreakerCatalog<JukiRendoTorokuListReportSource>().simplePageBreaker(page_break_keys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        JukiRendoTorokuListReport report = JukiRendoTorokuListReport.createFrom(item);
        report.writeBy(reportSourceWriter);
        batchReportWriter.close();
    }

    private void getPSM宛名情報(UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity,
            JyukiRendoJouhouEntity entity) {
        if (shikibetsuTaishoentity != null) {
            entity.set世帯コード(ShikibetsuTaishoFactory
                    .createKojin(shikibetsuTaishoentity).get世帯コード());
            entity.set被保険者カナ氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(shikibetsuTaishoentity).get名称()
                    .getKana());
            entity.set被保険者氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(shikibetsuTaishoentity).get名称()
                    .getName());
        }
    }

    private List<JyukiRendoJouhouEntity> get被保険者台帳リスト(
            JyukiRendoTorokushaListBatchMybatisParameter parameter) {
        JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
        List<JyukiRendoJouhouEntity> jyukiRendoTorokushalist = jyukiRendoJouhouMapper
                .getHiHokenshaDaichoList(parameter);
        return business.get被保険者台帳リスト(jyukiRendoTorokushalist, entity);
    }

    private List<JyukiRendoJouhouEntity> get他住所地特例者管理リスト(
            JyukiRendoTorokushaListBatchMybatisParameter parameter) {
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        List<TaJushochiTokureiShayouhouEntity> taJushochiTokureiShayouhoulist = new ArrayList<>();
        taJushochiTokureiShayouhoulist.addAll(jyukiRendoJouhouMapper
                .getTaJushochiTokureiShaKanriList_0008Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(jyukiRendoJouhouMapper.getShisetsuNyutaisho_2Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(jyukiRendoJouhouMapper
                .getTaJushochiTokureiShaKanriList_0011Code(parameter));
        return business.get他住所地特例者管理リスト(taJushochiTokureiShayouhoulist, jyukiRendoJouhouList);
    }

    private List<JyukiRendoJouhouEntity> get適用除外者台帳リスト(
            JyukiRendoTorokushaListBatchMybatisParameter parameter) {
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        List<TaJushochiTokureiShayouhouEntity> taJushochiTokureiShayouhoulist = new ArrayList<>();
        taJushochiTokureiShayouhoulist.addAll(jyukiRendoJouhouMapper
                .getTekiyoJogaishaDaichoList_0009Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(jyukiRendoJouhouMapper.getShisetsuNyutaisho_3Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(jyukiRendoJouhouMapper
                .getTekiyoJogaishaDaichoList_0012Code(parameter));
        return business.get適用除外者台帳リスト(taJushochiTokureiShayouhoulist, jyukiRendoJouhouList);
    }
}
