/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.jyukirendotorokushalist;

import java.util.ArrayList;
import java.util.Arrays;
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
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住基連動登録者リストを作成する
 */
public class JyukiRendoJouhouProcess extends SimpleBatchProcessBase {

    private static final String[] CODE_SHUBETSU_0008 = {"01", "08", "99"};
    private static final String[] CODE_SHUBETSU_0011 = {"51", "52", "53", "58", "99"};
    private static final String[] CODE_SHUBETSU_0009 = {"01", "08", "99"};
    private static final String[] CODE_SHUBETSU_0012 = {"51", "52", "53", "58", "99"};
    private IJyukiRendoJouhouMapper JyukiRendoJouhouMapper;
    private JyukiRendoTorokushaListBatchProcessParameter processParameter;

    @BatchWriter
    private BatchReportWriter<JukiRendoTorokuListReportSource> batchReportWriter;
    private ReportSourceWriter<JukiRendoTorokuListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        JyukiRendoJouhouMapper = getMapper(IJyukiRendoJouhouMapper.class);
    }

    @Override
    protected void process() {
        ShikibetsuCode old識別コード = new ShikibetsuCode("");
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        if (processParameter.isHihokenshadaichoFLG()) {
            jyukiRendoJouhouList.addAll(get被保険者台帳リスト(
                    processParameter.toJyukiRendoTorokushaListBatchMybatisParameter()));
        }
        if (processParameter.isTajushochitokureishakanriFLG()) {
            jyukiRendoJouhouList.addAll(get他住所地特例者管理リスト(
                    processParameter.toJyukiRendoTorokushaListBatchMybatisParameter()));
        }
        if (processParameter.isTekiyojogaishadaichoFLG()) {
            jyukiRendoJouhouList.addAll(get適用除外者台帳リスト(
                    processParameter.toJyukiRendoTorokushaListBatchMybatisParameter()));
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
                    UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity = JyukiRendoJouhouMapper
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
        ReportId ID = new ReportId("DBA200007");
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        JukiRendoTorokuListReport report = JukiRendoTorokuListReport
                .createFrom(item);
        report.writeBy(reportSourceWriter);
        batchReportWriter.close();
    }

    /**
     * 被保険者台帳リストを取得します
     *
     * @param parameter 住基連動登録者リスト作成バッチパラメータ
     * @return List<JyukiRendoJouhouEntity>
     */
    private List<JyukiRendoJouhouEntity> get被保険者台帳リスト(
            JyukiRendoTorokushaListBatchMybatisParameter parameter) {
        JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
        List<JyukiRendoJouhouEntity> JyukiRendoTorokushalist = JyukiRendoJouhouMapper
                .getHiHokenshaDaichoList(parameter);
        if (0 == JyukiRendoTorokushalist.size()) {
            entity.set世帯コード(null);
            entity.set被保険者カナ氏名(null);
            entity.set被保険者氏名(null);
            entity.set対象情報(1);
            entity.set改頁１(null);
            entity.set改頁２(null);
            entity.set改頁３(null);
            entity.set改頁４(null);
            entity.set改頁５(null);
            entity.set対象情報タイトル(new RString("データ種別：被保険者台帳"));
            entity.set開始タイトル(new RString("取得情報"));
            entity.set終了タイトル(new RString("喪失情報"));
            entity.set区分タイトル(new RString("資格"));
            entity.set異動情報タイトル1(null);
            entity.set異動情報タイトル2(null);
            entity.set異動情報タイトル3(null);
            entity.set開始年月日タイトル(null);
            entity.set終了年月日タイトル(null);
            entity.set異動情報タイトル4(new RString("異動情報"));
            entity.set異動情報タイトル5(null);
            entity.set異動情報タイトル6(null);
            entity.set開始年月日データ_前(null);
            entity.set終了年月日データ_前(null);
            entity.set開始年月日データ_後(null);
            entity.set終了年月日データ_後(null);
            entity.set異動情報データ1(null);
            entity.set異動情報データ2(null);
            entity.set異動情報データ3(null);
            entity.set異動情報データ4(null);
            entity.set異動情報データ5(null);
            entity.set異動情報データ6(null);
            entity.set被保険者番号(null);
            entity.set識別コード(null);
            entity.set取得情報_前_事由(null);
            entity.set取得情報_前_異動年月日(null);
            entity.set取得情報_前_届出年月日(null);
            entity.set喪失情報_前_事由(null);
            entity.set喪失情報_前_異動年月日(null);
            entity.set喪失情報_前_届出年月日(null);
            entity.set取得情報_後_事由(null);
            entity.set取得情報_後_異動年月日(null);
            entity.set取得情報_後_届出年月日(null);
            entity.set喪失情報_後_事由(null);
            entity.set喪失情報_後_異動年月日(null);
            entity.set喪失情報_後_届出年月日(null);
            entity.set区分_前_資格(null);
            entity.set区分_後_資格(null);
            JyukiRendoTorokushalist.add(entity);
        }
        return JyukiRendoTorokushalist;
    }

    /**
     * 他住所地特例者管理リストを取得します
     *
     * @param parameter 住基連動登録者リスト作成バッチパラメータ
     * @return List<JyukiRendoJouhouEntity>
     */
    private List<JyukiRendoJouhouEntity> get他住所地特例者管理リスト(
            JyukiRendoTorokushaListBatchMybatisParameter parameter) {
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        List<TaJushochiTokureiShayouhouEntity> taJushochiTokureiShayouhoulist = new ArrayList<>();

        taJushochiTokureiShayouhoulist.addAll(JyukiRendoJouhouMapper
                .getTaJushochiTokureiShaKanriList_0008Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(JyukiRendoJouhouMapper.getShisetsuNyutaisho_2Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(JyukiRendoJouhouMapper
                .getTaJushochiTokureiShaKanriList_0011Code(parameter));

        Collections.sort(taJushochiTokureiShayouhoulist, new Comparator<TaJushochiTokureiShayouhouEntity>() {

            // TODO QA384
            @Override
            public int compare(TaJushochiTokureiShayouhouEntity entity1, TaJushochiTokureiShayouhouEntity entity2) {
                return entity1.getLastUpdateTimestamp().compareTo(entity2.getLastUpdateTimestamp());
            }
        });
        for (TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity : taJushochiTokureiShayouhoulist) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set世帯コード(null);
            entity.set被保険者カナ氏名(null);
            entity.set被保険者氏名(null);
            if (!taJushochiTokureiShayouhouentity.isLogicalDeletedFlag()) {
                entity.set対象情報(2);
                entity.set改頁１(null);
                entity.set改頁２(null);
                entity.set改頁３(null);
                entity.set改頁４(null);
                entity.set改頁５(null);
                entity.set対象情報タイトル(new RString("データ種別：他市町村住所地特例者台帳"));
                entity.set開始タイトル(new RString("適用情報"));
                entity.set終了タイトル(new RString("解除情報"));
                entity.set区分タイトル(null);
                entity.set異動情報タイトル1(new RString("施設コード"));
                entity.set異動情報タイトル2(null);
                entity.set異動情報タイトル3(null);
                entity.set開始年月日タイトル(new RString("入所年月日"));
                entity.set終了年月日タイトル(new RString("退所年月日"));
                entity.set異動情報タイトル4(new RString("異動情報"));
                entity.set異動情報タイトル5(null);
                entity.set異動情報タイトル6(null);
                entity.set開始年月日データ_前(null);
                entity.set終了年月日データ_前(null);
                entity.set異動情報データ1(taJushochiTokureiShayouhouentity.getNyushoShisetsuCode());
                entity.set被保険者番号(null);
                entity.set識別コード(taJushochiTokureiShayouhouentity.getShikibetsuCode());
                entity.set取得情報_前_事由(null);
                entity.set取得情報_前_異動年月日(null);
                entity.set取得情報_前_届出年月日(null);
                entity.set喪失情報_前_事由(null);
                entity.set喪失情報_前_異動年月日(null);
                entity.set喪失情報_前_届出年月日(null);
                entity.set区分_前_資格(null);
                entity.set区分_後_資格(null);
                entity.set異動情報データ2(null);
                entity.set異動情報データ3(null);
                entity.set異動情報データ5(null);
                entity.set異動情報データ6(null);

                // TODO 技術点を提出しました
                if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0008).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {

                    set適用異動情報(entity, taJushochiTokureiShayouhouentity);
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() == null
                        && taJushochiTokureiShayouhouentity.getNyushoYMD() != null
                        && taJushochiTokureiShayouhouentity.getTaishoYMD() == null) {

                    set入所異動情報(entity, taJushochiTokureiShayouhouentity);
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() == null
                        && taJushochiTokureiShayouhouentity.getNyushoYMD() != null
                        && taJushochiTokureiShayouhouentity.getTaishoYMD() != null) {

                    set退所異動情報(entity, taJushochiTokureiShayouhouentity);
                    // TODO 技術点を提出しました
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0011).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {
                    set解除異動情報(entity, taJushochiTokureiShayouhouentity);
                }
            } else {
                entity.set対象情報(2);
                entity.set改頁１(null);
                entity.set改頁２(null);
                entity.set改頁３(null);
                entity.set改頁４(null);
                entity.set改頁５(null);
                entity.set対象情報タイトル(new RString("データ種別：他市町村住所地特例者台帳"));
                entity.set開始タイトル(new RString("適用情報"));
                entity.set終了タイトル(new RString("解除情報"));
                entity.set区分タイトル(null);
                entity.set異動情報タイトル1(new RString("施設コード"));
                entity.set異動情報タイトル2(null);
                entity.set異動情報タイトル3(null);
                entity.set開始年月日タイトル(new RString("入所年月日"));
                entity.set終了年月日タイトル(new RString("退所年月日"));
                entity.set異動情報タイトル4(new RString("異動情報"));
                entity.set異動情報タイトル5(null);
                entity.set異動情報タイトル6(null);
                entity.set開始年月日データ_後(null);
                entity.set終了年月日データ_後(null);
                entity.set異動情報データ1(taJushochiTokureiShayouhouentity.getNyushoShisetsuCode());
                entity.set被保険者番号(null);
                entity.set識別コード(taJushochiTokureiShayouhouentity.getShikibetsuCode());
                entity.set取得情報_後_事由(null);
                entity.set取得情報_後_異動年月日(null);
                entity.set取得情報_後_届出年月日(null);
                entity.set喪失情報_後_事由(null);
                entity.set喪失情報_後_異動年月日(null);
                entity.set喪失情報_後_届出年月日(null);
                entity.set区分_前_資格(null);
                entity.set区分_後_資格(null);
                entity.set異動情報データ2(null);
                entity.set異動情報データ3(null);
                entity.set異動情報データ5(null);
                entity.set異動情報データ6(null);
                // TODO 技術点を提出しました
                if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0008).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {

                    set適用削除情報(entity, taJushochiTokureiShayouhouentity);
                    // TODO 技術点を提出しました
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0011).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {

                    set解除削除情報(entity, taJushochiTokureiShayouhouentity);
                }
            }
            jyukiRendoJouhouList.add(entity);
        }
        if (0 == taJushochiTokureiShayouhoulist.size()) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(2);
            entity.set対象情報タイトル(new RString("データ種別：他市町村住所地特例者台帳"));
            set住基連動情報(entity);
            jyukiRendoJouhouList.add(entity);
        }
        return jyukiRendoJouhouList;
    }

    /**
     * 適用除外者台帳リストを取得します
     *
     * @param parameter 住基連動登録者リスト作成バッチパラメータ
     * @return List<JyukiRendoJouhouEntity>
     */
    private List<JyukiRendoJouhouEntity> get適用除外者台帳リスト(
            JyukiRendoTorokushaListBatchMybatisParameter parameter) {
        List<JyukiRendoJouhouEntity> jyukiRendoJouhouList = new ArrayList<>();
        List<TaJushochiTokureiShayouhouEntity> taJushochiTokureiShayouhoulist = new ArrayList<>();

        taJushochiTokureiShayouhoulist.addAll(JyukiRendoJouhouMapper
                .getTekiyoJogaishaDaichoList_0009Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(JyukiRendoJouhouMapper.getShisetsuNyutaisho_3Code(parameter));
        taJushochiTokureiShayouhoulist.addAll(JyukiRendoJouhouMapper
                .getTekiyoJogaishaDaichoList_0012Code(parameter));

        Collections.sort(taJushochiTokureiShayouhoulist, new Comparator<TaJushochiTokureiShayouhouEntity>() {

            // TODO QA384
            @Override
            public int compare(TaJushochiTokureiShayouhouEntity entity1, TaJushochiTokureiShayouhouEntity entity2) {
                int flag = entity1.getShikibetsuCode().compareTo(entity2.getShikibetsuCode());
                if (0 == flag) {
                    flag = entity1.getLastUpdateTimestamp().compareTo(entity2.getLastUpdateTimestamp());
                }
                return flag;
            }
        });
        for (TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity : taJushochiTokureiShayouhoulist) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set世帯コード(null);
            entity.set被保険者カナ氏名(null);
            entity.set被保険者氏名(null);
            if (!taJushochiTokureiShayouhouentity.isLogicalDeletedFlag()) {
                entity.set対象情報(3);
                entity.set改頁１(null);
                entity.set改頁２(null);
                entity.set改頁３(null);
                entity.set改頁４(null);
                entity.set改頁５(null);
                entity.set対象情報タイトル(new RString("データ種別：適用除外者台帳"));
                entity.set開始タイトル(new RString("適用情報"));
                entity.set終了タイトル(new RString("解除情報"));
                entity.set区分タイトル(null);
                entity.set異動情報タイトル1(new RString("施設コード"));
                entity.set異動情報タイトル2(null);
                entity.set異動情報タイトル3(null);
                entity.set開始年月日タイトル(new RString("入所年月日"));
                entity.set終了年月日タイトル(new RString("退所年月日"));
                entity.set異動情報タイトル4(new RString("異動情報"));
                entity.set異動情報タイトル5(null);
                entity.set異動情報タイトル6(null);
                entity.set開始年月日データ_前(null);
                entity.set終了年月日データ_前(null);
                entity.set異動情報データ1(taJushochiTokureiShayouhouentity.getNyushoShisetsuCode());
                entity.set被保険者番号(null);
                entity.set識別コード(taJushochiTokureiShayouhouentity.getShikibetsuCode());
                entity.set取得情報_前_事由(null);
                entity.set取得情報_前_異動年月日(null);
                entity.set取得情報_前_届出年月日(null);
                entity.set喪失情報_前_事由(null);
                entity.set喪失情報_前_異動年月日(null);
                entity.set喪失情報_前_届出年月日(null);
                entity.set区分_前_資格(null);
                entity.set区分_後_資格(null);
                entity.set異動情報データ2(null);
                entity.set異動情報データ3(null);
                entity.set異動情報データ5(null);
                entity.set異動情報データ6(null);
                // TODO 技術点を提出しました
                if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0009).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {

                    set適用異動情報(entity, taJushochiTokureiShayouhouentity);
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() == null
                        && taJushochiTokureiShayouhouentity.getNyushoYMD() != null
                        && taJushochiTokureiShayouhouentity.getTaishoYMD() == null) {

                    set入所異動情報(entity, taJushochiTokureiShayouhouentity);
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() == null
                        && taJushochiTokureiShayouhouentity.getNyushoYMD() != null
                        && taJushochiTokureiShayouhouentity.getTaishoYMD() != null) {

                    set退所異動情報(entity, taJushochiTokureiShayouhouentity);
                    // TODO 技術点を提出しました
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0012).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {

                    set解除異動情報(entity, taJushochiTokureiShayouhouentity);
                }
            } else {
                entity.set対象情報(3);
                entity.set改頁１(null);
                entity.set改頁２(null);
                entity.set改頁３(null);
                entity.set改頁４(null);
                entity.set改頁５(null);
                entity.set対象情報タイトル(new RString("データ種別：適用除外者台帳"));
                entity.set開始タイトル(new RString("適用情報"));
                entity.set終了タイトル(new RString("解除情報"));
                entity.set区分タイトル(null);
                entity.set異動情報タイトル1(new RString("施設コード"));
                entity.set異動情報タイトル2(null);
                entity.set異動情報タイトル3(null);
                entity.set開始年月日タイトル(new RString("入所年月日"));
                entity.set終了年月日タイトル(new RString("退所年月日"));
                entity.set異動情報タイトル4(new RString("異動情報"));
                entity.set異動情報タイトル5(null);
                entity.set異動情報タイトル6(null);
                entity.set開始年月日データ_後(null);
                entity.set終了年月日データ_後(null);
                entity.set異動情報データ1(taJushochiTokureiShayouhouentity.getNyushoShisetsuCode());
                entity.set被保険者番号(null);
                entity.set識別コード(taJushochiTokureiShayouhouentity.getShikibetsuCode());
                entity.set取得情報_後_事由(null);
                entity.set取得情報_後_異動年月日(null);
                entity.set取得情報_後_届出年月日(null);
                entity.set喪失情報_後_事由(null);
                entity.set喪失情報_後_異動年月日(null);
                entity.set喪失情報_後_届出年月日(null);
                entity.set区分_前_資格(null);
                entity.set区分_後_資格(null);
                entity.set異動情報データ2(null);
                entity.set異動情報データ3(null);
                entity.set異動情報データ5(null);
                entity.set異動情報データ6(null);
                // TODO 技術点を提出しました
                if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0009).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {

                    set適用削除情報(entity, taJushochiTokureiShayouhouentity);
                    // TODO 技術点を提出しました
                } else if (taJushochiTokureiShayouhouentity.getIdoJiyuCode() != null
                        && Arrays.asList(CODE_SHUBETSU_0012).contains(
                                taJushochiTokureiShayouhouentity.getIdoJiyuCode().toString())) {

                    set解除削除情報(entity, taJushochiTokureiShayouhouentity);
                }
            }
            jyukiRendoJouhouList.add(entity);
        }
        if (0 == jyukiRendoJouhouList.size()) {
            JyukiRendoJouhouEntity entity = new JyukiRendoJouhouEntity();
            entity.set対象情報(3);
            entity.set対象情報タイトル(new RString("データ種別：適用除外者台帳"));
            set住基連動情報(entity);
            jyukiRendoJouhouList.add(entity);
        }
        return jyukiRendoJouhouList;
    }

    /**
     * 適用異動情報を取得します
     *
     * @param entity 住基連動情報Entity
     * @param taJushochiTokureiShayouhouentity 他住所地特例者情報Entity
     */
    private void set適用異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity) {
        entity.set取得情報_後_事由(taJushochiTokureiShayouhouentity.getIdoJiyuCode());
        entity.set取得情報_後_異動年月日(taJushochiTokureiShayouhouentity.getTekiyoYMD());
        entity.set取得情報_後_届出年月日(taJushochiTokureiShayouhouentity.getTekiyoTodokedeYMD());
        entity.set開始年月日データ_後(taJushochiTokureiShayouhouentity.getNyushoYMD());
        entity.set喪失情報_後_事由(null);
        entity.set喪失情報_後_異動年月日(null);
        entity.set喪失情報_後_届出年月日(null);
        entity.set終了年月日データ_後(null);
        entity.set異動情報データ4(new RString("適用異動"));
    }

    /**
     * 入所異動情報を取得します
     *
     * @param entity 住基連動情報Entity
     * @param taJushochiTokureiShayouhouentity 他住所地特例者情報Entity
     */
    private void set入所異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity) {
        entity.set取得情報_後_事由(null);
        entity.set取得情報_後_異動年月日(null);
        entity.set取得情報_後_届出年月日(null);
        entity.set開始年月日データ_後(taJushochiTokureiShayouhouentity.getNyushoYMD());
        entity.set喪失情報_後_事由(null);
        entity.set喪失情報_後_異動年月日(null);
        entity.set喪失情報_後_届出年月日(null);
        entity.set終了年月日データ_後(null);
        entity.set異動情報データ4(new RString("入所異動"));
    }

    /**
     * 退所異動情報を取得します
     *
     * @param entity 住基連動情報Entity
     * @param taJushochiTokureiShayouhouentity 他住所地特例者情報Entity
     */
    private void set退所異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity) {
        entity.set取得情報_後_事由(null);
        entity.set取得情報_後_異動年月日(null);
        entity.set取得情報_後_届出年月日(null);
        entity.set開始年月日データ_後(taJushochiTokureiShayouhouentity.getNyushoYMD());
        entity.set喪失情報_後_事由(null);
        entity.set喪失情報_後_異動年月日(null);
        entity.set喪失情報_後_届出年月日(null);
        entity.set終了年月日データ_後(taJushochiTokureiShayouhouentity.getTaishoYMD());
        entity.set異動情報データ4(new RString("退所異動"));
    }

    /**
     * 解除異動情報を取得します
     *
     * @param entity 住基連動情報Entity
     * @param taJushochiTokureiShayouhouentity 他住所地特例者情報Entity
     */
    private void set解除異動情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity) {
        entity.set取得情報_後_事由(null);
        entity.set取得情報_後_異動年月日(null);
        entity.set取得情報_後_届出年月日(null);
        entity.set開始年月日データ_後(null);
        entity.set喪失情報_後_事由(taJushochiTokureiShayouhouentity.getIdoJiyuCode());
        entity.set喪失情報_後_異動年月日(taJushochiTokureiShayouhouentity.getKaijoYMD());
        entity.set喪失情報_後_届出年月日(taJushochiTokureiShayouhouentity.getKaijoTodokedeYMD());
        entity.set終了年月日データ_後(taJushochiTokureiShayouhouentity.getTaishoYMD());
        entity.set異動情報データ4(new RString("解除異動"));
    }

    /**
     * 適用削除情報を取得します
     *
     * @param entity 住基連動情報Entity
     * @param taJushochiTokureiShayouhouentity 他住所地特例者情報Entity
     */
    private void set適用削除情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity) {
        entity.set取得情報_前_事由(taJushochiTokureiShayouhouentity.getIdoJiyuCode());
        entity.set取得情報_前_異動年月日(taJushochiTokureiShayouhouentity.getTekiyoYMD());
        entity.set取得情報_前_届出年月日(taJushochiTokureiShayouhouentity.getTekiyoTodokedeYMD());
        entity.set開始年月日データ_前(taJushochiTokureiShayouhouentity.getNyushoYMD());
        entity.set喪失情報_前_事由(null);
        entity.set喪失情報_前_異動年月日(null);
        entity.set喪失情報_前_届出年月日(null);
        entity.set終了年月日データ_前(null);
        entity.set異動情報データ4(new RString("適用削除"));
    }

    /**
     * 解除削除情報を取得します
     *
     * @param entity 住基連動情報Entity
     * @param taJushochiTokureiShayouhouentity 他住所地特例者情報Entity
     */
    private void set解除削除情報(JyukiRendoJouhouEntity entity,
            TaJushochiTokureiShayouhouEntity taJushochiTokureiShayouhouentity) {
        entity.set取得情報_前_事由(null);
        entity.set取得情報_前_異動年月日(null);
        entity.set取得情報_前_届出年月日(null);
        entity.set開始年月日データ_前(null);
        entity.set喪失情報_前_事由(taJushochiTokureiShayouhouentity.getIdoJiyuCode());
        entity.set喪失情報_前_異動年月日(taJushochiTokureiShayouhouentity.getKaijoYMD());
        entity.set喪失情報_前_届出年月日(taJushochiTokureiShayouhouentity.getKaijoTodokedeYMD());
        entity.set終了年月日データ_前(taJushochiTokureiShayouhouentity.getTaishoYMD());
        // TODO QA384
        entity.set異動情報データ4(new RString("解除削除"));
    }

    /**
     * １件データ住基連動情報を追加します
     *
     * @param entity 住基連動情報Entity
     */
    private void set住基連動情報(JyukiRendoJouhouEntity entity) {
        entity.set世帯コード(null);
        entity.set被保険者カナ氏名(null);
        entity.set被保険者氏名(null);
        entity.set改頁１(null);
        entity.set改頁２(null);
        entity.set改頁３(null);
        entity.set改頁４(null);
        entity.set改頁５(null);
        entity.set開始タイトル(new RString("適用情報"));
        entity.set終了タイトル(new RString("解除情報"));
        entity.set区分タイトル(null);
        entity.set異動情報タイトル1(new RString("施設コード"));
        entity.set異動情報タイトル2(null);
        entity.set異動情報タイトル3(null);
        entity.set開始年月日タイトル(new RString("入所年月日"));
        entity.set終了年月日タイトル(new RString("退所年月日"));
        entity.set異動情報タイトル4(new RString("異動情報"));
        entity.set異動情報タイトル5(null);
        entity.set異動情報タイトル6(null);
        entity.set開始年月日データ_前(null);
        entity.set終了年月日データ_前(null);
        entity.set開始年月日データ_後(null);
        entity.set終了年月日データ_後(null);
        entity.set異動情報データ1(null);
        entity.set異動情報データ2(null);
        entity.set異動情報データ3(null);
        entity.set異動情報データ4(null);
        entity.set異動情報データ5(null);
        entity.set異動情報データ6(null);
        entity.set被保険者番号(null);
        entity.set識別コード(null);
        entity.set取得情報_前_事由(null);
        entity.set取得情報_前_異動年月日(null);
        entity.set取得情報_前_届出年月日(null);
        entity.set喪失情報_前_事由(null);
        entity.set喪失情報_前_異動年月日(null);
        entity.set喪失情報_前_届出年月日(null);
        entity.set取得情報_後_事由(null);
        entity.set取得情報_後_異動年月日(null);
        entity.set取得情報_後_届出年月日(null);
        entity.set喪失情報_後_事由(null);
        entity.set喪失情報_後_異動年月日(null);
        entity.set喪失情報_後_届出年月日(null);
        entity.set区分_前_資格(null);
        entity.set区分_後_資格(null);
    }

}
