/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitotatsutorokushalist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.nenreitotatsutorokushalist.NenreiTotatsuTorokushaBusiness;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListItem;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReport;
import jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsuTorokushaListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsushaJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsutorokusha.INenreiTotatsuTorokushaMapper;
import jp.co.ndensan.reams.db.dba.service.core.nenreitotatsutorokushalist.NenreiTotatsushaTorokuListBatch;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 年齢到達登録者リストを作成します。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 * @deprecated 削除予定.
 * {@link jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA150010.NenreiTotatsuTorokushaProcess}を使用してください。
 */
public class NenreiTotatsuTorokushaProcess extends BatchProcessBase<NenreiTotatsushaJouhouEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsutorokusha."
            + "INenreiTotatsuTorokushaMapper.getHiHokenshaDaichoList");
    private static final RString 処理名 = new RString("年齢到達登録者リスト");
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("0000");
    private static final int 日付桁数 = 8;
    private INenreiTotatsuTorokushaMapper iNenreiTotatsuTorokushaMapper;
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("NP_UNWRITTEN_FIELD")
    private NenreiTotatsuTorokushaListProcessParameter processParameter;
    private List<NenreitotatsuKakuninListItem> item;
    private List<NenreiTotatsushaJouhouEntity> nenreiTotatsushaJouhoulist;
    private NenreiTotatsuTorokushaBusiness business;
    private ShutsuryokujunRelateEntity 出力順Entity;
    private List<RString> page_break_keys;

    @BatchWriter
    private BatchReportWriter<NenreitotatsuKakuninListReportSource> batchReportWriter;
    private ReportSourceWriter<NenreitotatsuKakuninListReportSource> reportSourceWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWriter;

    @Override
    protected void initialize() {
        item = new ArrayList<>();
        nenreiTotatsushaJouhoulist = new ArrayList<>();
        business = new NenreiTotatsuTorokushaBusiness();
        出力順Entity = get出力順項目();
        if (出力順Entity.getPageBreakKeys() != null) {
            page_break_keys = Collections.unmodifiableList(出力順Entity.getPageBreakKeys());
        } else {
            page_break_keys = new ArrayList<>();
        }
//        TODO 修正中
//        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
//        if (processParameter.getShuturyokujunID() != null) {
//            chohyoShuturyokujun = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBA介護資格,
//                    ReportIdDBA.DBA200008.getReportId(), processParameter.getShuturyokujunID());
//            if (chohyoShuturyokujun != null) {
//                出力順 = MyBatisOrderByClauseCreator.create(
//                        NenreitotatsuKakuninListItem.class, chohyoShuturyokujun).replace(
//                                new RString("order by"), RString.EMPTY);
//            }
//        }
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                        GyomuCode.DB介護保険,
                        KensakuYusenKubun.住登外優先));
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
            processParameter.setUserShutsuryokuSort(false);
        } else {
            processParameter.setUserShutsuryokuSort(true);
            processParameter.setShutsuryokuSort(出力順Entity.get出力順OrderBy());
        }
        processParameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap()
                .get("psmShikibetsuTaisho").toString()));
//XXX n3327 エラー回避のためのコメントアウト。削除予定のクラスのため、本対応は不要。
//        processParameter = business.setParameter(processParameter);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toNenreiTotatsushaTorokuListMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200008.getReportId().value())
                .addBreak(new BreakerCatalog<NenreitotatsuKakuninListReportSource>().simplePageBreaker(page_break_keys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        tableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        iNenreiTotatsuTorokushaMapper = getMapper(INenreiTotatsuTorokushaMapper.class);
    }

    @Override
    protected void process(NenreiTotatsushaJouhouEntity entity) {
        getPSM宛名情報(entity);
        nenreiTotatsushaJouhoulist.add(business.setCodeToName(entity));
    }

    @Override
    protected void afterExecute() {
        NenreiTotatsuTorokushaListEntity entity = new NenreiTotatsuTorokushaListEntity();
        entity.set市町村コード(AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード());
        entity.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        entity.set並び順_1(出力順Entity.get出力順1());
        entity.set並び順_2(出力順Entity.get出力順2());
        entity.set並び順_3(出力順Entity.get出力順3());
        entity.set並び順_4(出力順Entity.get出力順4());
        entity.set並び順_5(出力順Entity.get出力順5());
        entity.set改頁１(出力順Entity.get改頁項目1());
        entity.set改頁２(出力順Entity.get改頁項目2());
        entity.set改頁３(出力順Entity.get改頁項目3());
        entity.set改頁４(出力順Entity.get改頁項目4());
        entity.set改頁５(出力順Entity.get改頁項目5());
        entity.set年齢到達者情報(business.setPrintTitleData(nenreiTotatsushaJouhoulist));
        NenreiTotatsushaTorokuListBatch batch = new NenreiTotatsushaTorokuListBatch();
        item = batch.getNenreiTotatsushaTorokuChohyoData(entity);
        NenreitotatsuKakuninListReport report = NenreitotatsuKakuninListReport
                .createFrom(item);
        report.writeBy(reportSourceWriter);
        DbT7022ShoriDateKanriEntity shoriDateKanriEntity = new DbT7022ShoriDateKanriEntity();
        shoriDateKanriEntity.setTaishoKaishiYMD(new FlexibleDate(processParameter.getKonkaikaishiYMDHMS()
                .replace("-", "").substring(0, 日付桁数)));
        shoriDateKanriEntity.setTaishoShuryoYMD(new FlexibleDate(processParameter.getKonkaishuryoYMDHMS()
                .replace("-", "").substring(0, 日付桁数)));
        if (processParameter.getZenkaikaishiYMDHMS() == null && processParameter.getZenkaishuryoYMDHMS() == null) {
            shoriDateKanriEntity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            shoriDateKanriEntity.setShichosonCode(AssociationFinderFactory.createInstance().getAssociation()
                    .get地方公共団体コード());
            shoriDateKanriEntity.setShoriName(処理名);
            shoriDateKanriEntity.setShoriEdaban(処理枝番);
            shoriDateKanriEntity.setNendo(年度);
            shoriDateKanriEntity.setNendoNaiRenban(年度内連番);
            tableWriter.insert(shoriDateKanriEntity);
        } else {
            shoriDateKanriEntity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
            shoriDateKanriEntity.setShoriName(処理名);
            iNenreiTotatsuTorokushaMapper.updateShoriDateKanri(shoriDateKanriEntity);
        }
    }

    private void getPSM宛名情報(NenreiTotatsushaJouhouEntity entity) {
        if (entity.get宛名対象者() != null) {
            entity.set世帯コード(ShikibetsuTaishoFactory
                    .createKojin(entity.get宛名対象者()).get世帯コード());
            entity.set被保険者カナ氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(entity.get宛名対象者()).get名称()
                    .getKana());
            entity.set被保険者氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(entity.get宛名対象者()).get名称()
                    .getName());
        }
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        return ReportUtil.get出力順情報(NenreiTotatsuTorokushaBusiness.ShutsuryokujunEnum.class,
                SubGyomuCode.DBA介護資格,
                ReportIdDBA.DBA200008.getReportId(),
                processParameter.getShuturyokujunID());
    }
}
