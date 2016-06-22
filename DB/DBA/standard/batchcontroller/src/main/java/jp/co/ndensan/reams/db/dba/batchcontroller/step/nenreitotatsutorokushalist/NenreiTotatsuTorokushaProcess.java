/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitotatsutorokushalist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListItem;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReport;
import jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsuTorokushaListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsushaJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsutorokusha.INenreiTotatsuTorokushaMapper;
import jp.co.ndensan.reams.db.dba.service.core.nenreitotatsutorokushalist.NenreiTotatsushaTorokuListBatch;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 年齢到達登録者リストを作成します。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 */
public class NenreiTotatsuTorokushaProcess extends BatchProcessBase<NenreiTotatsushaJouhouEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsutorokusha."
            + "INenreiTotatsuTorokushaMapper.getHiHokenshaDaichoList");
    private static final RString データ種別_被保険者台帳 = new RString("データ種別：被保険者台帳");
    private static final RString 取得情報 = new RString("取得情報");
    private static final RString 喪失情報 = new RString("喪失情報");
    private static final RString 資格 = new RString("資格");
    private static final RString 異動情報 = new RString("異動情報");
    private static final RString 処理名 = new RString("年齢到達登録者リスト");
    private static final RString 処理枝番 = new RString("0000");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度内連番 = new RString("0000");
    private static final int 日付桁数 = 8;
    private static final int 対象情報 = 1;
    private static final Code CODE_取得事由被保険者 = new Code("02");
    private static final Code CODE_変更事由被保険者 = new Code("31");
    private INenreiTotatsuTorokushaMapper iNenreiTotatsuTorokushaMapper;
    private NenreiTotatsuTorokushaListProcessParameter processParameter;
    private List<NenreitotatsuKakuninListItem> item;
    private List<NenreiTotatsushaJouhouEntity> nenreiTotatsushaJouhoulist;
    private ShikibetsuCode old識別コード;

    @BatchWriter
    private BatchReportWriter<NenreitotatsuKakuninListReportSource> batchReportWriter;
    private ReportSourceWriter<NenreitotatsuKakuninListReportSource> reportSourceWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWriter;

    @Override
    protected void initialize() {
        item = new ArrayList<>();
        nenreiTotatsushaJouhoulist = new ArrayList<>();
        old識別コード = new ShikibetsuCode("");
    }

    @Override
    protected IBatchReader createReader() {
        List<Code> 喪失事由被保険者Codes = new ArrayList<>();
        List<Code> 住特適用Codes = new ArrayList<>();
        List<Code> 住特解除Codes = new ArrayList<>();
        List<UzT0007CodeEntity> 喪失事由被保険者List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 住特適用LIst = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格住特適用.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        List<UzT0007CodeEntity> 住特解除List = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格住特解除.getコード(), new FlexibleDate(RDate.getNowDate().toDateString()));
        for (UzT0007CodeEntity uzT0007CodeEntity : 喪失事由被保険者List) {
            喪失事由被保険者Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 住特適用LIst) {
            住特適用Codes.add(uzT0007CodeEntity.getコード());
        }
        for (UzT0007CodeEntity uzT0007CodeEntity : 住特解除List) {
            住特解除Codes.add(uzT0007CodeEntity.getコード());
        }
        processParameter.setShutokuJiyu_Hihokensha(CODE_取得事由被保険者);
        processParameter.setSoshitsuJiyu_Hihokensha(喪失事由被保険者Codes);
        processParameter.setHenkoJiyu_Hihokensha(CODE_変更事由被保険者);
        processParameter.setJutokuTekiyo(住特適用Codes);
        processParameter.setJutokuKaijo(住特解除Codes);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toNenreiTotatsushaTorokuListMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200008.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        tableWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        iNenreiTotatsuTorokushaMapper = getMapper(INenreiTotatsuTorokushaMapper.class);
    }

    @Override
    protected void process(NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity) {
        if (nenreiTotatsushaJouhouEntity.get識別コード() != null) {
            ShikibetsuCode new識別コード = nenreiTotatsushaJouhouEntity.get識別コード();
            if (!new識別コード.equals(old識別コード)) {
                ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                        ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                                GyomuCode.DB介護保険,
                                KensakuYusenKubun.住登外優先));
                key.setデータ取得区分(DataShutokuKubun.直近レコード);
                key.set識別コード(nenreiTotatsushaJouhouEntity.get識別コード());
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
                processParameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap()
                        .get("psmShikibetsuTaisho").toString()));
                UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity = iNenreiTotatsuTorokushaMapper
                        .getPsmShikibetsuTaisho(processParameter.toNenreiTotatsushaTorokuListMybatisParameter());
                getPSM宛名情報(shikibetsuTaishoentity, nenreiTotatsushaJouhouEntity);
                old識別コード = new識別コード;
            }
        }
        nenreiTotatsushaJouhouEntity.set取得情報_前_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), nenreiTotatsushaJouhouEntity.get取得情報_前_事由()));
        nenreiTotatsushaJouhouEntity.set取得情報_後_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(), nenreiTotatsushaJouhouEntity.get取得情報_後_事由()));
        nenreiTotatsushaJouhouEntity.set喪失情報_前_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), nenreiTotatsushaJouhouEntity.get喪失情報_前_事由()));
        nenreiTotatsushaJouhouEntity.set喪失情報_後_事由(
                getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), nenreiTotatsushaJouhouEntity.get喪失情報_後_事由()));
        nenreiTotatsushaJouhoulist.add(nenreiTotatsushaJouhouEntity);
    }

    @Override
    protected void afterExecute() {
        if (nenreiTotatsushaJouhoulist.isEmpty()) {
            NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity = new NenreiTotatsushaJouhouEntity();
            nenreiTotatsushaJouhouEntity.set対象情報タイトル(データ種別_被保険者台帳);
            nenreiTotatsushaJouhouEntity.set対象情報(対象情報);
            nenreiTotatsushaJouhouEntity.set開始タイトル(取得情報);
            nenreiTotatsushaJouhouEntity.set終了タイトル(喪失情報);
            nenreiTotatsushaJouhouEntity.set区分タイトル(資格);
            nenreiTotatsushaJouhouEntity.set異動情報タイトル4(異動情報);
            nenreiTotatsushaJouhoulist.add(nenreiTotatsushaJouhouEntity);
        }

        // TODO 2-上記取得した年齢到達者情報リストをソートする(技術点を提出しました)
        NenreiTotatsuTorokushaListEntity entity = new NenreiTotatsuTorokushaListEntity();
        entity.set市町村コード(AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード());
        entity.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        // TODO 並び順について、技術点を提出しました
        entity.set並び順_1(RString.EMPTY);
        entity.set並び順_2(RString.EMPTY);
        entity.set並び順_3(RString.EMPTY);
        entity.set並び順_4(RString.EMPTY);
        entity.set並び順_5(RString.EMPTY);
        entity.set改頁１(RString.EMPTY);
        entity.set改頁２(RString.EMPTY);
        entity.set改頁３(RString.EMPTY);
        entity.set改頁４(RString.EMPTY);
        entity.set改頁５(RString.EMPTY);
        entity.set年齢到達者情報(nenreiTotatsushaJouhoulist);
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

    private void getPSM宛名情報(UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity,
            NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity) {
        if (shikibetsuTaishoentity != null) {
            nenreiTotatsushaJouhouEntity.set世帯コード(ShikibetsuTaishoFactory
                    .createKojin(shikibetsuTaishoentity).get世帯コード());
            nenreiTotatsushaJouhouEntity.set被保険者カナ氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(shikibetsuTaishoentity).get名称()
                    .getKana());
            nenreiTotatsushaJouhouEntity.set被保険者氏名(ShikibetsuTaishoFactory
                    .createShikibetsuTaisho(shikibetsuTaishoentity).get名称()
                    .getName());
        }
    }

    private RString getCodeNameByCode(CodeShubetsu codeShubetsu, RString code) {
        if (RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBA介護資格,
                codeShubetsu,
                new Code(code),
                new FlexibleDate(RDate.getNowDate().toDateString()));
    }
}
