/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoReport;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.SogoJigyoTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashohakkoichiranhyo.IchiranyoShohakkoshaEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashohakkoichiranhyo.HihokenshashoHakkoIchiranHyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 一時テーブルの作成_バッチフ処理クラスです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public class IchijiTableCreateProcess extends SimpleBatchProcessBase {

    private static final int NENREI_VALUE = 65;
    private static final ReportId 帳票ID = ReportIdDBA.DBA200003.getReportId();
    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;
    private boolean 両方フラグ;
    private List<HihokenshashoHakkoIchiranHyoItem> itemList;
    @BatchWriter
    private BatchReportWriter<HihokenshashoHakkoIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshashoHakkoIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        itemList = new ArrayList<>();
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        iIkkatsuHakkoMapper = getMapper(IIkkatsuHakkoMapper.class);
        iIkkatsuHakkoMapper.createTmpHihokenshasho_Ichi();
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process() {
        List<IkkatsuHakkoRelateEntity> データ抽出list = データ抽出();
        if (データ抽出list != null && !データ抽出list.isEmpty()) {
            for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : データ抽出list) {
                ikkatsuHakkoRelateEntity.setShisetyuJotaiFlag(FALSE);
                アクセスログ(ikkatsuHakkoRelateEntity);
                iIkkatsuHakkoMapper.insertTmpHihokenshasho_Ichi(ikkatsuHakkoRelateEntity);
            }
            iIkkatsuHakkoMapper.updateShisetyuJotaiFlag();
        } else {
            Map<Integer, RString> 改頁Map = ReportUtil.get改頁項目(SubGyomuCode.DBA介護資格,
                    processPrm.getShutsuryokujunId(),
                    帳票ID);
            Map<Integer, ISetSortItem> 出力順Map = ReportUtil.get出力順項目(SubGyomuCode.DBA介護資格,
                    processPrm.getShutsuryokujunId(),
                    帳票ID);
            List<IchiranyoShohakkoshaEntity> ichiranyoShohakkoshaEntityList = new HihokenshashoHakkoIchiranHyoFinder().
                    createHihokenshashoHakkoIchiranHyo(processPrm.getKofuYMD(), データ抽出list, 出力順Map, 改頁Map);
            for (IchiranyoShohakkoshaEntity ichiranyoShohakkoshaEntity : ichiranyoShohakkoshaEntityList) {
                itemList.add(setItem(ichiranyoShohakkoshaEntity));
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (itemList != null && !itemList.isEmpty()) {
            HihokenshashoHakkoIchiranHyoReport report = HihokenshashoHakkoIchiranHyoReport.createReport(itemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private HihokenshashoHakkoIchiranHyoItem setItem(IchiranyoShohakkoshaEntity entity) {
        return new HihokenshashoHakkoIchiranHyoItem(entity.get作成日付(),
                entity.get保険者名(),
                entity.get保険者番号(),
                entity.getソート順１(),
                entity.getソート順２(),
                entity.getソート順３(),
                entity.getソート順４(),
                entity.getソート順５(),
                entity.get改頁１(),
                entity.get改頁２(),
                entity.get改頁３(),
                entity.get改頁４(),
                entity.get改頁５(),
                entity.get交付事由_非交付理由タイトル(),
                entity.get帳票連番(),
                entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty() ? entity.get被保険者番号().value() : RString.EMPTY,
                entity.get氏名(),
                entity.get生年月日_年齢(),
                entity.get送付先住所(),
                entity.get要介護(),
                entity.get認定開始日_認定終了日(),
                entity.get施設名(),
                entity.get計画事業所名(),
                entity.get交付_非交付事由());
    }

    private void アクセスログ(IkkatsuHakkoRelateEntity entity) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(entity.getShikibetsuCode()));
    }

    private List<IkkatsuHakkoRelateEntity> データ抽出() {
        List<IkkatsuHakkoRelateEntity> データ抽出list = new ArrayList<>();
        switch (processPrm.getShutsuryokuJokenCode().toString()) {
            case "2":
                データ抽出list = get受給者のみ();
                break;
            case "3":
                データ抽出list = get該当者全員();
                break;
            case "4":
                データ抽出list = get年齢到達予定者();
                break;
            default:
                break;
        }
        return データ抽出list;
    }

    private List<IkkatsuHakkoRelateEntity> get受給者のみ() {
        List<IkkatsuHakkoRelateEntity> 受給者EntityList = new ArrayList<>();
        iIkkatsuHakkoMapper.create受給者台帳Temp(mybatisPrm);
        iIkkatsuHakkoMapper.create総合事業対象者Temp(mybatisPrm);
        List<SogoJigyoTaishoshaRelateEntity> 受給者台帳EntityList = iIkkatsuHakkoMapper.get受給者台帳Tempのみ();
        for (SogoJigyoTaishoshaRelateEntity entity : 受給者台帳EntityList) {
            受給者EntityList.add(get受給者台帳編集処理(entity));
        }
        List<SogoJigyoTaishoshaRelateEntity> 総合事業対象者EntityList = iIkkatsuHakkoMapper.get総合事業対象者Tempのみ();
        for (SogoJigyoTaishoshaRelateEntity entity : 総合事業対象者EntityList) {
            両方フラグ = false;
            受給者EntityList.add(get総合事業対象者編集処理(entity, 両方フラグ));
        }
        List<SogoJigyoTaishoshaRelateEntity> 両方EntityList = iIkkatsuHakkoMapper.get受給者台帳と総合事業対象者の両方();
        for (SogoJigyoTaishoshaRelateEntity entity : 両方EntityList) {
            両方フラグ = false;
            if (entity.get認定年月日().isBefore(entity.getチェックリスト実施日())) {
                両方フラグ = true;
                受給者EntityList.add(get総合事業対象者編集処理(entity, 両方フラグ));
            } else {
                受給者EntityList.add(get受給者台帳編集処理(entity));
            }
        }
        return 受給者EntityList;
    }

    private IkkatsuHakkoRelateEntity get総合事業対象者編集処理(SogoJigyoTaishoshaRelateEntity entity, boolean 両方フラグ) {
        IkkatsuHakkoRelateEntity 総合事業対象者Entity = new IkkatsuHakkoRelateEntity();
        総合事業対象者Entity.setHihokenshaNo(entity.get被保険者番号());
        if (両方フラグ) {
            総合事業対象者Entity.setSeibetsuCode(entity.get識別コード_受給());
            総合事業対象者Entity.setShichosonCode(entity.get市町村コード_受給());
        } else {
            総合事業対象者Entity.setSeibetsuCode(entity.get識別コード_ビュー());
            総合事業対象者Entity.setShichosonCode(entity.get市町村コード_ビュー());
        }
        総合事業対象者Entity.setInsertTimestamp(entity.get挿入日時_総合());
        総合事業対象者Entity.setLastUpdateTimestamp(entity.get更新日時_総合());
        総合事業対象者Entity.setTaisyoKubun(new RString("2"));
        return 総合事業対象者Entity;
    }

    private IkkatsuHakkoRelateEntity get受給者台帳編集処理(SogoJigyoTaishoshaRelateEntity entity) {
        IkkatsuHakkoRelateEntity 受給者のみEntity = new IkkatsuHakkoRelateEntity();
        受給者のみEntity.setHihokenshaNo(entity.get被保険者番号());
        受給者のみEntity.setSeibetsuCode(entity.get識別コード_受給());
        受給者のみEntity.setShichosonCode(entity.get市町村コード_受給());
        受給者のみEntity.setInsertTimestamp(entity.get挿入日時_受給());
        受給者のみEntity.setLastUpdateTimestamp(entity.get更新日時_受給());
        受給者のみEntity.setTaisyoKubun(new RString("1"));
        return 受給者のみEntity;
    }

    private List<IkkatsuHakkoRelateEntity> get年齢到達予定者() {
        List<IkkatsuHakkoRelateEntity> nenreiTotatsuYoteshalist = new ArrayList<>();
        if (processPrm.getKonkaiKijunYMD().isBefore(processPrm.getKonkaiToYMD())) {
            ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                    createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
            List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
            key.setデータ取得区分(DataShutokuKubun.直近レコード);
            juminShubetsuList.add(JuminShubetsu.日本人);
            juminShubetsuList.add(JuminShubetsu.外国人);
            key.set住民種別(juminShubetsuList);
            List<JuminJotai> juminJotaiList = new ArrayList<>();
            juminJotaiList.add(JuminJotai.住民);
            key.set住民状態(juminJotaiList);
            UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
            IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                    mybatisPrm.getKonkaiFromYMDHMS(),
                    mybatisPrm.getKonkaiToYMD(),
                    mybatisPrm.getKonkaiToYMDHMS(),
                    mybatisPrm.getKonkaikijunYMD(),
                    mybatisPrm.getKonkaikijunYMDHMS(),
                    mybatisPrm.getKofuYMD(),
                    mybatisPrm.getShinseishoKanriNo(),
                    mybatisPrm.getKonkaikijunYMD().plusDay(1).minusYear(NENREI_VALUE).plusDay(1),
                    mybatisPrm.getKonkaiToYMD().minusYear(NENREI_VALUE).plusDay(1),
                    mybatisPrm.getHihokenshaNo(),
                    mybatisPrm.getShikibetsuCode(),
                    new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                    mybatisPrm.getPsmAtesaki(),
                    mybatisPrm.getNenreiTotatsuYMD(),
                    RString.EMPTY);
            List<IkkatsuHakkoRelateEntity> 年齢到達予定者List = iIkkatsuHakkoMapper.getNenreiTotatsuYotesha(mybatisParam);
            for (IkkatsuHakkoRelateEntity nenreiTotatsuYotesha : 年齢到達予定者List) {
                HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().
                        getHihokenshanotsukiban(nenreiTotatsuYotesha.getShikibetsuCode());
                nenreiTotatsuYotesha.setHihokenshaNo(hihokenshaNo);
                nenreiTotatsuYoteshalist.add(nenreiTotatsuYotesha);
            }
        }
        return nenreiTotatsuYoteshalist;
    }

    private List<IkkatsuHakkoRelateEntity> get該当者全員() {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 受給者台帳異動List = get受給者のみ();
        List<IkkatsuHakkoRelateEntity> 年齢到達予定者List = get年齢到達予定者();
        List<IkkatsuHakkoRelateEntity> 被保険者異動List = iIkkatsuHakkoMapper.getHihokenshaDaichoIdo(mybatisPrm);
        List<IkkatsuHakkoRelateEntity> 該当者全員List = new ArrayList<>();
        該当者全員List.addAll(年齢到達予定者List);
        for (IkkatsuHakkoRelateEntity 年齢到達予定者Entity : 年齢到達予定者List) {
            list.add(年齢到達予定者Entity.getHihokenshaNo().value());
        }
        Map<RString, IkkatsuHakkoRelateEntity> 受給者台帳異動Map = new HashMap();
        for (IkkatsuHakkoRelateEntity 受給者台帳異動Entity : 受給者台帳異動List) {
            if (!list.contains(受給者台帳異動Entity.getHihokenshaNo().value())) {
                受給者台帳異動Map.put(受給者台帳異動Entity.getHihokenshaNo().value(), 受給者台帳異動Entity);
            }
        }
        for (IkkatsuHakkoRelateEntity 被保険者異動Entiy : 被保険者異動List) {
            if (!list.contains(被保険者異動Entiy.getHihokenshaNo().value())) {
                get最新データ(受給者台帳異動Map, 被保険者異動Entiy);
            }
        }
        該当者全員List.addAll(受給者台帳異動Map.values());

        return 該当者全員List;
    }

    private void get最新データ(Map<RString, IkkatsuHakkoRelateEntity> 受給者台帳異動Map, IkkatsuHakkoRelateEntity 被保険者異動Entiy) {
        RString hihokenshaNo = 被保険者異動Entiy.getHihokenshaNo().value();
        if (受給者台帳異動Map.containsKey(hihokenshaNo)) {
            IkkatsuHakkoRelateEntity 受給者台帳異動Entity = 受給者台帳異動Map.get(hihokenshaNo);
            if (受給者台帳異動Entity.getInsertTimestamp().isBefore(被保険者異動Entiy.getInsertTimestamp())) {
                受給者台帳異動Map.put(被保険者異動Entiy.getHihokenshaNo().value(), 被保険者異動Entiy);
            }
        } else {
            受給者台帳異動Map.put(被保険者異動Entiy.getHihokenshaNo().value(), 被保険者異動Entiy);
        }
    }
}
