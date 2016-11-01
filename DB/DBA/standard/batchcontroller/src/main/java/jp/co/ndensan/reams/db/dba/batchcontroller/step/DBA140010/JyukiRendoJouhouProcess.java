/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA140010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jyukirendotorokushalist.JyukiRendoJouhouBusiness;
import jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist.JukiRendoTorokuListItem;
import jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist.JukiRendoTorokuListReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba140010.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListBatchEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.TaJushochiTokureiShayouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jyukirendojouhou.IJyukiRendoJouhouMapper;
import jp.co.ndensan.reams.db.dba.service.core.jukirendotorokushalist.JyukiRendoTorokushaListBatch;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
    private ShutsuryokujunRelateEntity 出力順Entity;

    @BatchWriter
    private BatchReportWriter<JukiRendoTorokuListReportSource> batchReportWriter;
    private ReportSourceWriter<JukiRendoTorokuListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        jyukiRendoJouhouMapper = getMapper(IJyukiRendoJouhouMapper.class);
        business = new JyukiRendoJouhouBusiness();
        List<RString> 出力順 = new ArrayList<>();
        出力順.add(改ページ);
        出力順Entity = get出力順項目();
        if (出力順Entity.getPageBreakKeys() != null) {
            出力順.addAll(出力順Entity.getPageBreakKeys());
        }
        page_break_keys = Collections.unmodifiableList(出力順);
    }

    @Override
    protected void process() {
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                        GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
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
        if (RString.isNullOrEmpty(出力順Entity.get出力順OrderBy())) {
            processParameter.setOrderByFlag(false);
        } else {
            processParameter.setOrderByFlag(true);
            processParameter.setOrderBy(出力順Entity.get出力順OrderBy().replace("order by ", ","));
        }
        if (processParameter.isHihokenshadaichoFLG()) {
            processParameter = business.setPsetParameter(processParameter, uaFt200Psm);
            processParameter.setOrderBy(出力順Entity.get出力順OrderBy());
            JyukiRendoTorokushaListBatchMybatisParameter mybatisParameter
                    = processParameter.toJyukiRendoTorokushaListBatchMybatisParameter();
            jyukiRendoJouhouList.addAll(get被保険者台帳リスト(mybatisParameter));
        }
        if (processParameter.isTajushochitokureishakanriFLG()) {
            processParameter = business.setPsetParameter(processParameter, uaFt200Psm);
            JyukiRendoTorokushaListBatchMybatisParameter mybatisParameter
                    = processParameter.toJyukiRendoTorokushaListBatchMybatisParameter();
            jyukiRendoJouhouList.addAll(get他住所地特例者管理リスト(mybatisParameter));
        }
        if (processParameter.isTekiyojogaishadaichoFLG()) {
            processParameter = business.setPsetParameter(processParameter, uaFt200Psm);
            JyukiRendoTorokushaListBatchMybatisParameter mybatisParameter
                    = processParameter.toJyukiRendoTorokushaListBatchMybatisParameter();
            jyukiRendoJouhouList.addAll(get適用除外者台帳リスト(mybatisParameter));
        }
        for (JyukiRendoJouhouEntity entity : jyukiRendoJouhouList) {
            getPSM宛名情報(entity);
            business.set事由名称(entity);
            entity.set改頁１(出力順Entity.get改頁項目1());
            entity.set改頁２(出力順Entity.get改頁項目2());
            entity.set改頁３(出力順Entity.get改頁項目3());
            entity.set改頁４(出力順Entity.get改頁項目4());
            entity.set改頁５(出力順Entity.get改頁項目5());
        }
        JyukiRendoTorokushaListBatchEntity jyukiRendoTorokushaEntity = new JyukiRendoTorokushaListBatchEntity();
        jyukiRendoTorokushaEntity.set市町村コード(AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード());
        jyukiRendoTorokushaEntity.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        jyukiRendoTorokushaEntity.set並び順_1(出力順Entity.get出力順1());
        jyukiRendoTorokushaEntity.set並び順_2(出力順Entity.get出力順2());
        jyukiRendoTorokushaEntity.set並び順_3(出力順Entity.get出力順3());
        jyukiRendoTorokushaEntity.set並び順_4(出力順Entity.get出力順4());
        jyukiRendoTorokushaEntity.set並び順_5(出力順Entity.get出力順5());
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

    private void getPSM宛名情報(JyukiRendoJouhouEntity entity) {
        if (entity.getPsmEntity() != null) {
            entity.set世帯コード(ShikibetsuTaishoFactory
                    .createKojin(entity.getPsmEntity()).get世帯コード());
            entity.set被保険者カナ氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(entity.getPsmEntity()).get名称()
                    .getKana());
            entity.set被保険者氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(entity.getPsmEntity()).get名称()
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

    private ShutsuryokujunRelateEntity get出力順項目() {
        return ReportUtil.get出力順情報(JyukiRendoJouhouBusiness.ShutsuryokujunEnum.class,
                SubGyomuCode.DBA介護資格,
                ReportIdDBA.DBA200007.getReportId(),
                processParameter.getShuturyokujunID());
    }
}
