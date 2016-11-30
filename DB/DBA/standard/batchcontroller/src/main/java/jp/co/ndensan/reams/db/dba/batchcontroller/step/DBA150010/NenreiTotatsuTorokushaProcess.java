/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA150010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.nenreitotatsutorokushalist.NenreiTotatsuTorokushaBusiness;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListItem;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReport;
import jp.co.ndensan.reams.db.dba.definition.core.nenreitotatsutorokushalistbatch.BreakPageRelateItem;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba150010.NenreiTotatsuTorokushaListProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsuTorokushaListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsushaJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitoutatsuyoteishachecklist.INenreiToutatsuYoteishaCheckListMapper;
import jp.co.ndensan.reams.db.dba.service.core.nenreitotatsutorokushalist.NenreiTotatsushaTorokuListBatch;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
 * 年齢到達登録者リストを作成します。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 */
public class NenreiTotatsuTorokushaProcess extends BatchProcessBase<NenreiTotatsushaJouhouEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsutorokusha."
            + "INenreiTotatsuTorokushaMapper.getHiHokenshaDaichoList");
    private static final RString 処理名 = new RString("年齢到達登録者リスト");
    private static final int 日付桁数 = 8;
    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int MAX_OUTPUT_BREAKKEYLIST = 5;
    private static final int MAX_OUTPUTCOUNT = 6;
    private static final int SIZE_YMD = 8;
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("NP_UNWRITTEN_FIELD")
    private NenreiTotatsuTorokushaListProcessParameter processParameter;
    private List<NenreitotatsuKakuninListItem> item;
    private List<NenreiTotatsushaJouhouEntity> nenreiTotatsushaJouhoulist;
    private NenreiTotatsuTorokushaBusiness business;
    private ShikibetsuCode old識別コード;
    private IOutputOrder chohyoShuturyokujun;
    private RString 出力順;
    List<RString> 出力順リスト;
    List<RString> 改頁リスト;
    private static List<RString> pageBreakKeys;

    @BatchWriter
    private BatchReportWriter<NenreitotatsuKakuninListReportSource> batchReportWriter;
    private ReportSourceWriter<NenreitotatsuKakuninListReportSource> reportSourceWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWriter;
    private INenreiToutatsuYoteishaCheckListMapper nenreiCheckListMapper;

    @Override
    protected void initialize() {
        item = new ArrayList<>();
        nenreiTotatsushaJouhoulist = new ArrayList<>();
        business = new NenreiTotatsuTorokushaBusiness();
        old識別コード = new ShikibetsuCode("");
        出力順リスト = new ArrayList<>();
        改頁リスト = new ArrayList<>();
        nenreiCheckListMapper = getMapper(INenreiToutatsuYoteishaCheckListMapper.class);
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (processParameter.getShutsuryokujunID() != null) {
            chohyoShuturyokujun = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBA介護資格,
                    ReportIdDBA.DBA200008.getReportId(), processParameter.getShutsuryokujunID());
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
    }

    @Override
    protected IBatchReader createReader() {
        processParameter = business.setParameter(processParameter);
        IShikibetsuTaishoPSMSearchKey key = getPSM検索条件();
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toNenreiTotatsushaTorokuListMybatisParameter(出力順, key));
    }

    @Override
    protected void createWriter() {
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty() && !pageBreakKeys.contains(null) && !pageBreakKeys.contains(RString.EMPTY)) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200008.getReportId().value()).
                    addBreak(new BreakerCatalog<NenreitotatsuKakuninListReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200008.getReportId().value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        tableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity) {
        if (nenreiTotatsushaJouhouEntity.get識別コード() != null) {
            ShikibetsuCode new識別コード = nenreiTotatsushaJouhouEntity.get識別コード();
            if (!new識別コード.equals(old識別コード)) {
                bak();
                getPSM宛名情報(nenreiTotatsushaJouhouEntity);
                old識別コード = new識別コード;
            }
        }
        nenreiTotatsushaJouhoulist.add(business.setCodeToName(nenreiTotatsushaJouhouEntity));
    }

    @Override
    protected void afterExecute() {
        NenreiTotatsuTorokushaListEntity entity = new NenreiTotatsuTorokushaListEntity();
        entity = setヘッダー情報(entity);
        NenreiTotatsushaTorokuListBatch batch = new NenreiTotatsushaTorokuListBatch();
        item = batch.getNenreiTotatsushaTorokuChohyoData(entity);
        NenreitotatsuKakuninListReport report = NenreitotatsuKakuninListReport.createFrom(item);
        report.writeBy(reportSourceWriter);
        処理日付管理マスタ更新();
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

    private void getPSM宛名情報(NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity) {
        if (nenreiTotatsushaJouhouEntity.get宛名対象者() != null) {
            nenreiTotatsushaJouhouEntity.set世帯コード(ShikibetsuTaishoFactory
                    .createKojin(nenreiTotatsushaJouhouEntity.get宛名対象者())
                    .get世帯コード());
            nenreiTotatsushaJouhouEntity.set被保険者カナ氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(nenreiTotatsushaJouhouEntity.get宛名対象者())
                    .get名称()
                    .getKana());
            nenreiTotatsushaJouhouEntity.set被保険者氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(nenreiTotatsushaJouhouEntity.get宛名対象者())
                    .get名称()
                    .getName());
        }
    }

    private NenreiTotatsuTorokushaListEntity setヘッダー情報(NenreiTotatsuTorokushaListEntity entity) {
        entity.set市町村コード(AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード());
        entity.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        entity.set並び順_1(出力順リスト.get(LISTINDEX_0));
        entity.set並び順_2(出力順リスト.get(LISTINDEX_1));
        entity.set並び順_3(出力順リスト.get(LISTINDEX_2));
        entity.set並び順_4(出力順リスト.get(LISTINDEX_3));
        entity.set並び順_5(出力順リスト.get(LISTINDEX_4));
        entity.set改頁１(改頁リスト.get(LISTINDEX_0));
        entity.set改頁２(改頁リスト.get(LISTINDEX_1));
        entity.set改頁３(改頁リスト.get(LISTINDEX_2));
        entity.set改頁４(改頁リスト.get(LISTINDEX_3));
        entity.set改頁５(改頁リスト.get(LISTINDEX_4));
        entity.set年齢到達者情報(business.setPrintTitleData(nenreiTotatsushaJouhoulist));
        entity.set抽出期間From(toWarekiFormat(processParameter.getKonkaikaishiYMDHMS()));
        entity.set抽出期間To(toWarekiFormat(processParameter.getKonkaishuryoYMDHMS()));
        return entity;
    }

    private RString toWarekiFormat(RString date) {
        date = date.replace("-", "");
        date = date.substring(LISTINDEX_0, SIZE_YMD);
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
    }

    private void 処理日付管理マスタ更新() {
        DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanri = new DbT7022ShoriDateKanriEntity();
        dbT7022ShoriDateKanri.setTaishoKaishiYMD(new FlexibleDate(processParameter.getKonkaikaishiYMDHMS()
                .replace("-", "").substring(0, 日付桁数)));
        dbT7022ShoriDateKanri.setTaishoShuryoYMD(new FlexibleDate(processParameter.getKonkaishuryoYMDHMS()
                .replace("-", "").substring(0, 日付桁数)));
        dbT7022ShoriDateKanri.setShoriName(処理名);
        nenreiCheckListMapper.getInsert(dbT7022ShoriDateKanri);
    }

    private void bak() {
//                nenreiTotatsushaJouhouEntity.set世帯コード(ShikibetsuTaishoFactory
//                        .createKojin(nenreiTotatsushaJouhouEntity.get宛名対象者()).get世帯コード());
//                nenreiTotatsushaJouhouEntity.set被保険者カナ氏名(ShikibetsuTaishoFactory
//                        .createShikibetsuTaisho(nenreiTotatsushaJouhouEntity.get宛名対象者()).get名称()
//                        .getKana());
//                nenreiTotatsushaJouhouEntity.set被保険者氏名(ShikibetsuTaishoFactory
//                        .createShikibetsuTaisho(nenreiTotatsushaJouhouEntity.get宛名対象者()).get名称()
//                        .getName());
//                ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
//                        ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
//                                GyomuCode.DB介護保険,
//                                KensakuYusenKubun.住登外優先));
//                key.setデータ取得区分(DataShutokuKubun.直近レコード);
//                key.set識別コード(nenreiTotatsushaJouhouEntity.get識別コード());
//                List<JuminShubetsu> 住民種別 = new ArrayList();
//                List<JuminJotai> 住名状態 = new ArrayList();
//                住民種別.add(JuminShubetsu.日本人);
//                住民種別.add(JuminShubetsu.外国人);
//                住民種別.add(JuminShubetsu.住登外個人_日本人);
//                住民種別.add(JuminShubetsu.住登外個人_外国人);
//                住名状態.add(JuminJotai.住民);
//                住名状態.add(JuminJotai.住登外);
//                住名状態.add(JuminJotai.消除者);
//                住名状態.add(JuminJotai.転出者);
//                住名状態.add(JuminJotai.死亡者);
//                key.set住民種別(住民種別);
//                key.set住民状態(住名状態);
//                UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(
//                        key.getPSM検索キー());
//                processParameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap()
//                        .get("psmShikibetsuTaisho").toString()));
//                UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity = iNenreiTotatsuTorokushaMapper
//                        .getPsmShikibetsuTaisho(processParameter.toNenreiTotatsushaTorokuListMybatisParameter());
    }
}
