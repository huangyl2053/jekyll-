/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.jutakairiyusakuteseikenshin.JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100010.KaishuriyushoSeikyushoShinseishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.ChouhyouShuturyokuYouDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakairiyusakuteseikenshin.JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakairiyusakuteseikenshin.JutakuKaishuRSTSKSReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 *
 */
public class KaishuriyushoSeikyushoShinseishoDBC100045Process extends BatchProcessBase<ChouhyouShuturyokuYouDataEntity> {

    private static final ReportId REPORT_ID = ReportIdDBC.DBC100045.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get帳票出力用データ");
    private KaishuriyushoSeikyushoShinseishoProcessParameter processParameter;
    @BatchWriter
    private BatchReportWriter<JutakuKaishuRSTSKSReportSource> batchWrite;
    private ReportSourceWriter<JutakuKaishuRSTSKSReportSource> reportSourceWriter;
    private static final int パターン番号 = 1;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.日本人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.外国人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.住登外個人_日本人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.住登外個人_外国人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.法人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.共有者);
        key.getPSM検索キー().get住民状態().add(JuminJotai.住民);
        key.getPSM検索キー().get住民状態().add(JuminJotai.住登外);
        key.getPSM検索キー().get住民状態().add(JuminJotai.消除者);
        key.getPSM検索キー().get住民状態().add(JuminJotai.転出者);
        key.getPSM検索キー().get住民状態().add(JuminJotai.死亡者);
        key.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        processParameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaishuriyushoSeikyushoShinseishoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ChouhyouShuturyokuYouDataEntity entity) {
        JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData data = new JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData();
        if (entity.get郵便番号() != null) {
            data.set請求者_郵便番号(entity.get郵便番号().value());
        }
        if (entity.get住所() != null) {
            data.set請求者_所在地(entity.get住所().value());
        }
        if (entity.get事業者名() != null) {
            data.set請求者_名称(entity.get事業者名().value());
        }
        if (entity.get代表者名() != null) {
            data.set請求者_代表者氏名(entity.get代表者名().value());
        }
        if (entity.get電話番号() != null) {
            data.set請求者_電話番号(entity.get電話番号().value());
        }
        data.set通知文(get通知文().get(1));
        if (entity.get介護住宅改修理由書作成事業者番号() != null) {
            data.set指定事業者番号(entity.get介護住宅改修理由書作成事業者番号().value());
        }
        data.set請求金額(entity.get介護住宅改修理由書作成請求金額());
        if (entity.get介護住宅改修理由書作成単価() != null) {
            data.set単価(new RString(entity.get介護住宅改修理由書作成単価().toString()));
        }
        data.set件数(new RString(entity.get介護住宅改修理由書作成件数()));
        data.set発行日(get認証者().hakkoYMD);
        data.set認証者役職名(get認証者().ninshoshaYakushokuMei);
        JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoReport report = new JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoReport(data);
        report.writeBy(reportSourceWriter);
    }

    private NinshoshaSource get認証者() {
        return ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                REPORT_ID,
                FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(),
                KenmeiFuyoKubunType.付与なし,
                reportSourceWriter);
    }

    /**
     * 通知文の編集処理です。
     *
     * @return 通知文
     */
    public static Map<Integer, RString> get通知文() {
        return ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_ID, KamokuCode.EMPTY, パターン番号);
    }
}
