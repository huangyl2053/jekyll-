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
import jp.co.ndensan.reams.db.dba.definition.core.jyukirendotorokushalistbatch.BreakPageRelateItem;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba140010.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListBatchEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.TaJushochiTokureiShayouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jyukirendojouhou.IJyukiRendoJouhouMapper;
import jp.co.ndensan.reams.db.dba.service.core.jukirendotorokushalist.JyukiRendoTorokushaListBatch;
import jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator.BreakPageCreator;
import jp.co.ndensan.reams.db.dbz.business.report.reportitem.KaigoReportItems;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住基連動登録者リストを作成します。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
public class JyukiRendoJouhouProcess extends SimpleBatchProcessBase {

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int MAX_OUTPUT_BREAKKEYLIST = 5;
    private static final int MAX_OUTPUTCOUNT = 6;
    private static final int SIZE_YMD = 8;
    private IJyukiRendoJouhouMapper jyukiRendoJouhouMapper;
    private JyukiRendoTorokushaListBatchProcessParameter processParameter;
    private JyukiRendoJouhouBusiness business;
    private IOutputOrder chohyoShuturyokujun;
    private RString 出力順;
    List<RString> 出力順リスト;
    List<RString> 改頁リスト;
    private static List<RString> pageBreakKeys;

    @BatchWriter
    private BatchReportWriter<JukiRendoTorokuListReportSource> batchReportWriter;
    private ReportSourceWriter<JukiRendoTorokuListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        jyukiRendoJouhouMapper = getMapper(IJyukiRendoJouhouMapper.class);
        business = new JyukiRendoJouhouBusiness();
        出力順リスト = new ArrayList<>();
        改頁リスト = new ArrayList<>();

        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (processParameter.getShuturyokujunID() != null) {
            chohyoShuturyokujun = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBA介護資格,
                    ReportIdDBA.DBA200007.getReportId(), processParameter.getShuturyokujunID());
            if (chohyoShuturyokujun != null) {
                出力順 = MyBatisOrderByClauseCreator.create(
                        KaigoReportItems.class, chohyoShuturyokujun).replace(
                                new RString("order by"), RString.EMPTY);
                get出力順項目();
            }
        }
        while (出力順リスト.size() < MAX_OUTPUT_BREAKKEYLIST) {
            出力順リスト.add(RString.EMPTY);
        }
        while (改頁リスト.size() < MAX_OUTPUT_BREAKKEYLIST) {
            改頁リスト.add(RString.EMPTY);
        }
        createWriter();
    }

    @Override
    protected void process() {
        ShikibetsuCode old識別コード = new ShikibetsuCode("");
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        JyukiRendoTorokushaListBatchEntity jyukiRendoTorokushaEntity = new JyukiRendoTorokushaListBatchEntity();
        JyukiRendoTorokushaListBatch jyukiRendoTorokushaListBatch = new JyukiRendoTorokushaListBatch();

        processParameter = business.setPsetParameter(processParameter);
        IShikibetsuTaishoPSMSearchKey key = getPSM検索条件();
        JyukiRendoTorokushaListBatchMybatisParameter mybatisParameter
                = processParameter.toJyukiRendoTorokushaListBatchMybatisParameter(出力順, key);
        jyukiRendoJouhouList = get住基連動情報リスト(jyukiRendoJouhouList, mybatisParameter);
        for (JyukiRendoJouhouEntity entity : jyukiRendoJouhouList) {
            if (entity.get識別コード() != null) {
                bak();
                ShikibetsuCode new識別コード = entity.get識別コード();
                if (!new識別コード.equals(old識別コード)) {
                    getPSM宛名情報(entity);
                    old識別コード = new識別コード;
                }
            }
            business.set事由名称(entity);
        }
        jyukiRendoTorokushaEntity = setヘッダー情報(jyukiRendoTorokushaEntity, jyukiRendoJouhouList);
        List<JukiRendoTorokuListItem> item = jyukiRendoTorokushaListBatch.getIdoCheckChohyoData(jyukiRendoTorokushaEntity);
        JukiRendoTorokuListReport report = JukiRendoTorokuListReport.createFrom(item);
        report.writeBy(reportSourceWriter);
        batchReportWriter.close();
    }

    private void get出力順項目() {
        List<ISetSortItem> 出力改頁リスト = chohyoShuturyokujun.get設定項目リスト();
        for (ISetSortItem 出力改頁 : 出力改頁リスト) {
            if (出力改頁.get出力順位() < MAX_OUTPUTCOUNT) {
                出力順リスト.add(出力改頁.get出力順位(), 出力改頁.get項目名());
            }
            if (Boolean.TRUE.equals(出力改頁.is改頁項目())) {
                改頁リスト.add(出力改頁.get項目名());
            }
        }
        getPageBreakKeys(改頁リスト);
    }

    private void getPageBreakKeys(List<RString> 改頁リスト) {
        List<RString> pageBreakKeyList = new ArrayList<>();
        for (RString 改頁項目 : 改頁リスト) {
            if (!(RString.isNullOrEmpty(改頁項目))) {
                pageBreakKeyList.add(BreakPageCreator.getBreakPageName(BreakPageRelateItem.class, 改頁項目));
            }
        }
        pageBreakKeys = Collections.unmodifiableList(pageBreakKeyList);
    }

    private void createWriter() {
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty() && !pageBreakKeys.contains(null) && !pageBreakKeys.contains(RString.EMPTY)) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200007.getReportId().value())
                    .addBreak(new BreakerCatalog<JukiRendoTorokuListReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200007.getReportId().value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    private IShikibetsuTaishoPSMSearchKey getPSM検索条件() {
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
        return new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先)
                .setデータ取得区分(DataShutokuKubun.直近レコード)
                .set住民種別(住民種別)
                .set住民状態(住名状態)
                .build();
    }

    private void getPSM宛名情報(JyukiRendoJouhouEntity entity) {
        if (entity.get宛名対象者() != null) {
            entity.set世帯コード(ShikibetsuTaishoFactory
                    .createKojin(entity.get宛名対象者())
                    .get世帯コード());
            entity.set被保険者カナ氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(entity.get宛名対象者())
                    .get名称()
                    .getKana());
            entity.set被保険者氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(entity.get宛名対象者())
                    .get名称()
                    .getName());
        }
    }

    private List<JyukiRendoJouhouEntity> get住基連動情報リスト(List<JyukiRendoJouhouEntity> jyukiRendoJouhouList,
            JyukiRendoTorokushaListBatchMybatisParameter mybatisParameter) {
        if (processParameter.isHihokenshadaichoFLG()) {
            jyukiRendoJouhouList.addAll(get被保険者台帳リスト(mybatisParameter));
        }
        if (processParameter.isTajushochitokureishakanriFLG()) {
            jyukiRendoJouhouList.addAll(get他住所地特例者管理リスト(mybatisParameter));
        }
        if (processParameter.isTekiyojogaishadaichoFLG()) {
            jyukiRendoJouhouList.addAll(get適用除外者台帳リスト(mybatisParameter));
        }
        return jyukiRendoJouhouList;
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

    private JyukiRendoTorokushaListBatchEntity setヘッダー情報(JyukiRendoTorokushaListBatchEntity jyukiRendoTorokushaEntity,
            List<JyukiRendoJouhouEntity> jyukiRendoJouhouList) {
        jyukiRendoTorokushaEntity.set市町村コード(AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード());
        jyukiRendoTorokushaEntity.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        jyukiRendoTorokushaEntity.set並び順_1(出力順リスト.get(LISTINDEX_0));
        jyukiRendoTorokushaEntity.set並び順_2(出力順リスト.get(LISTINDEX_1));
        jyukiRendoTorokushaEntity.set並び順_3(出力順リスト.get(LISTINDEX_2));
        jyukiRendoTorokushaEntity.set並び順_4(出力順リスト.get(LISTINDEX_3));
        jyukiRendoTorokushaEntity.set並び順_5(出力順リスト.get(LISTINDEX_4));
        jyukiRendoTorokushaEntity.set改頁_1(改頁リスト.get(LISTINDEX_0));
        jyukiRendoTorokushaEntity.set改頁_2(改頁リスト.get(LISTINDEX_1));
        jyukiRendoTorokushaEntity.set改頁_3(改頁リスト.get(LISTINDEX_2));
        jyukiRendoTorokushaEntity.set改頁_4(改頁リスト.get(LISTINDEX_3));
        jyukiRendoTorokushaEntity.set改頁_5(改頁リスト.get(LISTINDEX_4));
        jyukiRendoTorokushaEntity.set抽出期間F(toWarekiFormat(processParameter.getKonkaikaishiYMDHMS()));
        jyukiRendoTorokushaEntity.set抽出期間T(toWarekiFormat(processParameter.getKonkaishuryoYMDHMS()));
        jyukiRendoTorokushaEntity.set住基連動情報(jyukiRendoJouhouList);
        return jyukiRendoTorokushaEntity;
    }

    private RString toWarekiFormat(RString date) {
        date = date.replace("-", "");
        date = date.substring(LISTINDEX_0, SIZE_YMD);
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
    }

    private void bak() {
//                    ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
//                            ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
//                                    GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
//                    key.setデータ取得区分(DataShutokuKubun.直近レコード);
//                    key.set識別コード(entity.get識別コード());
//                    List<JuminShubetsu> 住民種別 = new ArrayList();
//                    List<JuminJotai> 住名状態 = new ArrayList();
//                    住民種別.add(JuminShubetsu.日本人);
//                    住民種別.add(JuminShubetsu.外国人);
//                    住民種別.add(JuminShubetsu.住登外個人_日本人);
//                    住民種別.add(JuminShubetsu.住登外個人_外国人);
//                    住名状態.add(JuminJotai.住民);
//                    住名状態.add(JuminJotai.住登外);
//                    住名状態.add(JuminJotai.消除者);
//                    住名状態.add(JuminJotai.転出者);
//                    住名状態.add(JuminJotai.死亡者);
//                    key.set住民種別(住民種別);
//                    key.set住民状態(住名状態);
//                    UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(
//                            key.getPSM検索キー());
//                    UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity = jyukiRendoJouhouMapper
//                            .getPsmShikibetsuTaisho(new PsmShikibetsuTaishoMybatisParameter(
//                                            new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString())));

    }
}
