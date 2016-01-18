/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.jyukirendotorokushalist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist.JukiRendoTorokuListItem;
import jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist.JukiRendoTorokuListReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.PsmShikibetsuTaishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListBatchEntity;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.TaJushochiTokureiShayouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;
import jp.co.ndensan.reams.db.dba.persistence.mapper.jyukirendojouhou.IJyukiRendoJouhouMapper;
import jp.co.ndensan.reams.db.dba.service.jukirendotorokushalist.JyukiRendoTorokushaListBatch;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 住基連動登録者リストを作成します。
 */
public class JyukiRendoJouhouProcess extends SimpleBatchProcessBase {

    private static final int 対象情報_被保険者台帳 = 1;
    private static final int 対象情報_他市町村住所地特例者台帳 = 2;
    private static final int 対象情報_適用除外者台帳 = 3;
    private static final RString CODE_SHUBETSU_0008 = new RString("0008");
    private static final RString CODE_SHUBETSU_0011 = new RString("0011");
    private static final RString CODE_SHUBETSU_0009 = new RString("0009");
    private static final RString CODE_SHUBETSU_0012 = new RString("0012");
    private static final RString データ種別_被保険者台帳 = new RString("データ種別：被保険者台帳");
    private static final RString 取得情報 = new RString("取得情報");
    private static final RString 喪失情報 = new RString("喪失情報");
    private static final RString 資格 = new RString("資格");
    private static final RString 異動情報 = new RString("異動情報");
    private static final RString データ種別_他市町村住所地特例者台帳 = new RString("データ種別：他市町村住所地特例者台帳");
    private static final RString 適用情報 = new RString("適用情報");
    private static final RString 解除情報 = new RString("解除情報");
    private static final RString 施設コード = new RString("施設コード");
    private static final RString 入所年月日 = new RString("入所年月日");
    private static final RString 退所年月日 = new RString("退所年月日");
    private static final RString データ種別_適用除外者台帳 = new RString("データ種別：適用除外者台帳");
    private static final RString 適用異動 = new RString("適用異動");
    private static final RString 入所異動 = new RString("入所異動");
    private static final RString 退所異動 = new RString("退所異動");
    private static final RString 解除異動 = new RString("解除異動");
    private static final RString 適用削除 = new RString("適用削除");
    private static final RString 解除削除 = new RString("解除削除");

    private IJyukiRendoJouhouMapper jyukiRendoJouhouMapper;
    private JyukiRendoTorokushaListBatchProcessParameter processParameter;
    private RString loginId;

    @BatchWriter
    private BatchReportWriter<JukiRendoTorokuListReportSource> batchReportWriter;
    private ReportSourceWriter<JukiRendoTorokuListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        jyukiRendoJouhouMapper = getMapper(IJyukiRendoJouhouMapper.class);
        IUrControlData controlData = UrControlDataFactory.createInstance();
        loginId = controlData.getLoginInfo().getUserId();
    }

    @Override
    protected void process() {
        ShikibetsuCode old識別コード = new ShikibetsuCode("");
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        JyukiRendoTorokushaListBatchMybatisParameter mybatisParameter
                = processParameter.toJyukiRendoTorokushaListBatchMybatisParameter();
        processParameter.setLoginId(loginId);
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
                                    GyomuCode.DB介護保険,
                                    KensakuYusenKubun.住登外優先));
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
                                            new RString(uaFt200Psm.getParameterMap()
                                                    .get("psmShikibetsuTaisho").toString())));
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
                    old識別コード = new識別コード;
                }
            }
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
        List<JukiRendoTorokuListItem> item = jyukiRendoTorokushaListBatch
                .getIdoCheckChohyoData(jyukiRendoTorokushaEntity);
        ReportId id = new ReportId("DBA200007");
        batchReportWriter = BatchReportFactory.createBatchReportWriter(id.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        JukiRendoTorokuListReport report = JukiRendoTorokuListReport
                .createFrom(item);
        report.writeBy(reportSourceWriter);
        batchReportWriter.close();
    }

    private List<JyukiRendoJouhouEntity> get被保険者台帳リスト(
            JyukiRendoTorokushaListBatchMybatisParameter parameter) {
        JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
        List<JyukiRendoJouhouEntity> jyukiRendoTorokushalist = jyukiRendoJouhouMapper
                .getHiHokenshaDaichoList(parameter);
        if (jyukiRendoTorokushalist.isEmpty()) {
            entity.set対象情報(対象情報_被保険者台帳);
            entity.set対象情報タイトル(データ種別_被保険者台帳);
            entity.set開始タイトル(取得情報);
            entity.set終了タイトル(喪失情報);
            entity.set区分タイトル(資格);
            entity.set異動情報タイトル4(異動情報);
            jyukiRendoTorokushalist.add(entity);
        }
        return jyukiRendoTorokushalist;
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
        Collections.sort(taJushochiTokureiShayouhoulist, new Comparator<TaJushochiTokureiShayouhouEntity>() {
            @Override
            public int compare(TaJushochiTokureiShayouhouEntity entity1, TaJushochiTokureiShayouhouEntity entity2) {
                return entity2.getLastUpdateTimestamp().compareTo(entity1.getLastUpdateTimestamp());
            }
        });
        for (TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou : taJushochiTokureiShayouhoulist) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_他市町村住所地特例者台帳);
            entity.set対象情報タイトル(データ種別_他市町村住所地特例者台帳);
            entity.set開始タイトル(適用情報);
            entity.set終了タイトル(解除情報);
            entity.set異動情報タイトル1(施設コード);
            entity.set開始年月日タイトル(入所年月日);
            entity.set終了年月日タイトル(退所年月日);
            entity.set異動情報タイトル4(異動情報);
            entity.set異動情報データ1(taJushochiTokureiShayouhou.getNyushoShisetsuCode());
            entity.set識別コード(taJushochiTokureiShayouhou.getShikibetsuCode());
            if (!taJushochiTokureiShayouhou.isLogicalDeletedFlag()) {
                set異動情報(entity, taJushochiTokureiShayouhou, CODE_SHUBETSU_0008, CODE_SHUBETSU_0011);
            } else {
                if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格,
                                new CodeShubetsu(CODE_SHUBETSU_0008.toString()),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString())).isEmpty()) {
                    set適用削除情報(entity, taJushochiTokureiShayouhou);
                } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格,
                                new CodeShubetsu(CODE_SHUBETSU_0011.toString()),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString())).isEmpty()) {
                    set解除削除情報(entity, taJushochiTokureiShayouhou);
                }
            }
            jyukiRendoJouhouList.add(entity);
        }
        if (taJushochiTokureiShayouhoulist.isEmpty()) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_他市町村住所地特例者台帳);
            entity.set対象情報タイトル(データ種別_他市町村住所地特例者台帳);
            set住基連動情報(entity);
            jyukiRendoJouhouList.add(entity);
        }
        return jyukiRendoJouhouList;
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
        Collections.sort(taJushochiTokureiShayouhoulist, new Comparator<TaJushochiTokureiShayouhouEntity>() {
            @Override
            public int compare(TaJushochiTokureiShayouhouEntity entity1, TaJushochiTokureiShayouhouEntity entity2) {
                int flag = entity2.getShikibetsuCode().compareTo(entity1.getShikibetsuCode());
                if (0 == flag) {
                    flag = entity2.getLastUpdateTimestamp().compareTo(entity1.getLastUpdateTimestamp());
                }
                return flag;
            }
        });
        for (TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou : taJushochiTokureiShayouhoulist) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_適用除外者台帳);
            entity.set対象情報タイトル(データ種別_適用除外者台帳);
            entity.set開始タイトル(適用情報);
            entity.set終了タイトル(解除情報);
            entity.set異動情報タイトル1(施設コード);
            entity.set開始年月日タイトル(入所年月日);
            entity.set終了年月日タイトル(退所年月日);
            entity.set異動情報タイトル4(異動情報);
            entity.set異動情報データ1(taJushochiTokureiShayouhou.getNyushoShisetsuCode());
            entity.set識別コード(taJushochiTokureiShayouhou.getShikibetsuCode());
            if (!taJushochiTokureiShayouhou.isLogicalDeletedFlag()) {
                set異動情報(entity, taJushochiTokureiShayouhou, CODE_SHUBETSU_0009, CODE_SHUBETSU_0012);
            } else {
                if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格,
                                new CodeShubetsu(CODE_SHUBETSU_0009.toString()),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString())).isEmpty()) {
                    set適用削除情報(entity, taJushochiTokureiShayouhou);
                } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                        && !CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格,
                                new CodeShubetsu(CODE_SHUBETSU_0012.toString()),
                                new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString())).isEmpty()) {
                    set解除削除情報(entity, taJushochiTokureiShayouhou);
                }
            }
            jyukiRendoJouhouList.add(entity);
        }
        if (jyukiRendoJouhouList.isEmpty()) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(対象情報_適用除外者台帳);
            entity.set対象情報タイトル(データ種別_適用除外者台帳);
            set住基連動情報(entity);
            jyukiRendoJouhouList.add(entity);
        }
        return jyukiRendoJouhouList;
    }

    private void set異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou,
            RString codeShuBetsuIti,
            RString codeShuBetsuNi) {
        if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                && !CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(codeShuBetsuIti.toString()),
                        new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString())).isEmpty()) {
            set適用異動情報(entity, taJushochiTokureiShayouhou);
        } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() == null
                && taJushochiTokureiShayouhou.getNyushoYMD() != null
                && taJushochiTokureiShayouhou.getTaishoYMD() == null) {
            set入所異動情報(entity, taJushochiTokureiShayouhou);
        } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() == null
                && taJushochiTokureiShayouhou.getNyushoYMD() != null
                && taJushochiTokureiShayouhou.getTaishoYMD() != null) {
            set退所異動情報(entity, taJushochiTokureiShayouhou);
        } else if (taJushochiTokureiShayouhou.getIdoJiyuCode() != null
                && !CodeMaster.getCodeRireki(SubGyomuCode.DBA介護資格,
                        new CodeShubetsu(codeShuBetsuNi.toString()),
                        new Code(taJushochiTokureiShayouhou.getIdoJiyuCode().toString())).isEmpty()) {
            set解除異動情報(entity, taJushochiTokureiShayouhou);
        }
    }

    private void set適用異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set取得情報_後_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set取得情報_後_異動年月日(taJushochiTokureiShayouhou.getTekiyoYMD());
        entity.set取得情報_後_届出年月日(taJushochiTokureiShayouhou.getTekiyoTodokedeYMD());
        entity.set開始年月日データ_後(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set異動情報データ4(適用異動);
    }

    private void set入所異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set開始年月日データ_後(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set異動情報データ4(入所異動);
    }

    private void set退所異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set開始年月日データ_後(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set終了年月日データ_後(taJushochiTokureiShayouhou.getTaishoYMD());
        entity.set異動情報データ4(退所異動);
    }

    private void set解除異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set喪失情報_後_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set喪失情報_後_異動年月日(taJushochiTokureiShayouhou.getKaijoYMD());
        entity.set喪失情報_後_届出年月日(taJushochiTokureiShayouhou.getKaijoTodokedeYMD());
        entity.set終了年月日データ_後(taJushochiTokureiShayouhou.getTaishoYMD());
        entity.set異動情報データ4(解除異動);
    }

    private void set適用削除情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set取得情報_前_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set取得情報_前_異動年月日(taJushochiTokureiShayouhou.getTekiyoYMD());
        entity.set取得情報_前_届出年月日(taJushochiTokureiShayouhou.getTekiyoTodokedeYMD());
        entity.set開始年月日データ_前(taJushochiTokureiShayouhou.getNyushoYMD());
        entity.set異動情報データ4(適用削除);
    }

    private void set解除削除情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhou) {
        entity.set喪失情報_前_事由(taJushochiTokureiShayouhou.getIdoJiyuCode());
        entity.set喪失情報_前_異動年月日(taJushochiTokureiShayouhou.getKaijoYMD());
        entity.set喪失情報_前_届出年月日(taJushochiTokureiShayouhou.getKaijoTodokedeYMD());
        entity.set終了年月日データ_前(taJushochiTokureiShayouhou.getTaishoYMD());
        entity.set異動情報データ4(解除削除);
    }

    private void set住基連動情報(JyukiRendoJouhouEntity entity) {
        entity.set開始タイトル(適用情報);
        entity.set終了タイトル(解除情報);
        entity.set異動情報タイトル1(施設コード);
        entity.set開始年月日タイトル(入所年月日);
        entity.set終了年月日タイトル(退所年月日);
        entity.set異動情報タイトル4(異動情報);
    }

}
