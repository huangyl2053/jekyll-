/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU050010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchigenmenhoseiichiran.KyufuhiTuchiGenmenhoseiIchiranReportSource;
import jp.co.ndensan.reams.db.dbu.business.report.koikinaijushochitokurei.KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei;
import jp.co.ndensan.reams.db.dbu.business.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoBody;
import jp.co.ndensan.reams.db.dbu.business.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoHead;
import jp.co.ndensan.reams.db.dbu.business.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReport;
import jp.co.ndensan.reams.db.dbu.definition.core.koikinaijushochitokurei.KoikinaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbu.definition.core.koikinaijushochitokurei.KoikinaiJushochiTokureiItiranEntity;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.koikinaijushochitokurei.KoikinaiKaijoParamter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.koikinaijushochitokurei.KoikinaiJushochiTokureiProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.koikinaijushochitokurei.KoikinaiJushochiTokureiRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.koikinaijushochitokureishaichiranhyo.KoikinaiJushochitokureishaIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.koikinaijushochitokurei.IKoikinaiJushochiTokureiMapper;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 広域内住所地特例者情報の設定クラスです。
 *
 * @reamsid_L DBU-1140-020 dongyabin
 */
public class KoikinaiJushochiTokureiProcess extends SimpleBatchProcessBase {

    private static final RString 直近 = new RString("1");
    private static final RString 基準日 = new RString("2");
    private static final RString 範囲 = new RString("3");
    private static final RString 市町村DDL1件目コード = new RString("000000");
    private KoikinaiJushochiTokureiProcessParamter paramter;
    private IKoikinaiJushochiTokureiMapper mapper;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 並び順;
    private RString 改頁;
    @BatchWriter
    private BatchReportWriter<KoikinaiJushochitokureishaIchiranhyoReportSource> batchWrite;
    private ReportSourceWriter<KoikinaiJushochitokureishaIchiranhyoReportSource> retortWrite;
    private ShutsuryokujunRelateEntity 出力順entity;

    @Override
    protected void beforeExecute() {
        出力順entity = ReportUtil.get出力順情報(KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei.ShutsuryokujunEnum.class,
                SubGyomuCode.DBU介護統計報告,
                ReportIdDBU.DBU200005.getReportId(),
                paramter.getNarabiId());
        if (!出力順entity.getPageBreakKeys().isEmpty()) {
            batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU200005.getReportId().value())
                    .addBreak(new BreakerCatalog<KyufuhiTuchiGenmenhoseiIchiranReportSource>().
                            simplePageBreaker(出力順entity.getPageBreakKeys())).create();
        } else {
            batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU200005.getReportId().value()).create();
        }
        retortWrite = new ReportSourceWriter<>(batchWrite);
        mapper = getMapper(IKoikinaiJushochiTokureiMapper.class);
        super.beforeExecute();
    }

    @Override
    protected void process() {
        get市町村コードと市町村名称();
        List<KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei> 帳票データlist = is帳票データ作成(is広域内住所地特例者一覧表情報Entity作成(get広域内住所地特例者情報()));
        for (KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei 帳票データ : 帳票データlist) {
            AccessLogger.log(AccessLogType.照会, toPersonalData(帳票データ.get識別コード(), 帳票データ.get被保険者番号()));
            KoikinaiJushochitokureishaIchiranhyoReport report = new KoikinaiJushochitokureishaIchiranhyoReport(
                    getHeadItem(帳票データ), getBodyItem(帳票データ));
            report.writeBy(retortWrite);
        }
    }

    @Override
    protected void afterExecute() {
        batchWrite.close();
    }

    private KoikinaiJushochitokureishaIchiranhyoHead getHeadItem(KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei 帳票データ) {
        return new KoikinaiJushochitokureishaIchiranhyoHead(帳票データ.get印刷日時(),
                帳票データ.get市町村コード(),
                帳票データ.get市町村名(),
                帳票データ.get並び順１(),
                帳票データ.get並び順２(),
                帳票データ.get並び順３(),
                帳票データ.get並び順４(),
                帳票データ.get並び順５(),
                帳票データ.get改頁１(),
                帳票データ.get改頁２(),
                帳票データ.get改頁３(),
                帳票データ.get改頁４(),
                帳票データ.get改頁５());
    }

    private KoikinaiJushochitokureishaIchiranhyoBody getBodyItem(KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei data) {
        KoikinaiJushochitokureishaIchiranhyoBody item = new KoikinaiJushochitokureishaIchiranhyoBody(data.get被保険者番号(),
                data.get氏名カナ(),
                data.get生年月日(),
                data.get住所コード(),
                data.get行政区CD(),
                data.get行政区(),
                data.get取得日(),
                data.get取得届出日(),
                data.get喪失日(),
                data.get喪失届出日(),
                data.get資格区分(),
                data.get住特(),
                data.get識別コード(),
                data.get氏名(),
                data.get性別(),
                data.get世帯コード(),
                data.get住所(),
                data.get広住取得日(),
                data.get広住取得届出日(),
                data.get広住喪失日(),
                data.get広住喪失届出日(),
                data.get措置市町村コード(),
                data.get措置市町村名称());
        return item;
    }

    private List<KoikinaiJushochiTokureiEntity> get広域内住所地特例者情報() {
        if (直近.equals(paramter.getModel())) {
            return get直近広住特適用();
        } else if (基準日.equals(paramter.getModel())) {
            return get基準日広住特適用();
        } else if (範囲.equals(paramter.getModel())) {
            return get範囲広住特適用();
        }
        return new ArrayList<>();
    }

    private List<KoikinaiJushochiTokureiEntity> get直近広住特適用() {
        List<KoikinaiJushochiTokureiRelateEntity> 直近広住特適用情報List = mapper.
                get直近広住特適用情報(paramter.toMybatisParamter(getPsmParamter(直近), 出力順entity.get出力順OrderBy()));
        return set広域内住所地特例者(直近広住特適用情報List, 直近);
    }

    private List<KoikinaiJushochiTokureiEntity> get基準日広住特適用() {
        List<KoikinaiJushochiTokureiRelateEntity> 基準日広住特適用情報List = mapper.
                get基準日広住特適用情報(paramter.toMybatisParamter(getPsmParamter(基準日), 出力順entity.get出力順OrderBy()));

        return set広域内住所地特例者(基準日広住特適用情報List, 基準日);
    }

    private List<KoikinaiJushochiTokureiEntity> get範囲広住特適用() {
        List<KoikinaiJushochiTokureiRelateEntity> 範囲広住特適用情報List = mapper.
                get範囲広住特適用情報(paramter.toMybatisParamter(getPsmParamter(範囲), 出力順entity.get出力順OrderBy()));
        return set広域内住所地特例者(範囲広住特適用情報List, 範囲);
    }

    private RString getPsmParamter(RString hanteiFlag) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        if (直近.equals(hanteiFlag)) {
            key.setデータ取得区分(DataShutokuKubun.直近レコード);
        } else if (基準日.equals(hanteiFlag) || 範囲.equals(hanteiFlag)) {
            key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        }
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.死亡者);
        key.set住民種別(住民種別);
        key.set住民状態(住民状態);

        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
    }

    private List<KoikinaiJushochiTokureiEntity> set広域内住所地特例者(List<KoikinaiJushochiTokureiRelateEntity> 広住特適用情報List,
            RString hanteiFlag) {
        List<KoikinaiJushochiTokureiEntity> 広域内住所地特例者List = new ArrayList<>();
        for (KoikinaiJushochiTokureiRelateEntity entity : 広住特適用情報List) {
            KoikinaiJushochiTokureiEntity 広域内住所地特例者Entity = new KoikinaiJushochiTokureiEntity();
            広域内住所地特例者Entity.set被保険者番号(entity.getHihokenshaNo().value());
            広域内住所地特例者Entity.set氏名カナ(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get名称().getKana().value());
            広域内住所地特例者Entity.set生年月日(new RString(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get生年月日().toFlexibleDate().toString()));
            広域内住所地特例者Entity.set住所コード(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get住所().get全国住所コード().value());
            広域内住所地特例者Entity.set行政区CD(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get行政区画().getGyoseiku().getコード().value());
            広域内住所地特例者Entity.set行政区(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get行政区画().getGyoseiku().get名称());
            広域内住所地特例者Entity.set取得日(nullToEmtiy(entity.getShikakuShutokuYMD()));
            広域内住所地特例者Entity.set取得届出日(nullToEmtiy(entity.getShikakuShutokuTodokedeYMD()));
            広域内住所地特例者Entity.set喪失日(nullToEmtiy(entity.getShikakuSoshitsuYMD()));
            広域内住所地特例者Entity.set喪失届出日(nullToEmtiy(entity.getShikakuSoshitsuTodokedeYMD()));
            広域内住所地特例者Entity.set資格区分(entity.getHihokennshaKubunCode());
            広域内住所地特例者Entity.set住特(entity.getJushochiTokureiFlag());
            広域内住所地特例者Entity.set識別コード(entity.getShikibetsuCode() == null ? RString.EMPTY : entity.getShikibetsuCode().value());
            広域内住所地特例者Entity.set氏名(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get名称().getName().value());
            広域内住所地特例者Entity.set性別(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get性別().getCode());
            広域内住所地特例者Entity.set世帯コード(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get世帯コード().value());
            広域内住所地特例者Entity.set住所(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get住所().get住所());
            広域内住所地特例者Entity.set広住取得日(nullToEmtiy(entity.getShikakuHenkoYMD()));
            広域内住所地特例者Entity.set広住取得届出日(nullToEmtiy(entity.getShikakuHenkoTodokedeYMD()));
            if (基準日.equals(hanteiFlag)) {
                set広住喪失日_基準日(entity, 広域内住所地特例者Entity);
            } else if (範囲.equals(hanteiFlag)) {
                set広住喪失日_範囲(entity, 広域内住所地特例者Entity);
            }
            if (entity.getSochimotoShichosonCode() != null) {
                広域内住所地特例者Entity.set措置市町村コード(entity.getSochimotoShichosonCode().value());
                List<ShichosonCodeYoriShichoson> 市町村情報 = KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(entity
                        .getSochimotoShichosonCode()).records();
                広域内住所地特例者Entity.set措置市町村名称(市町村情報.isEmpty() ? RString.EMPTY : 市町村情報.get(0).get市町村名称());
            }
            広域内住所地特例者Entity.set住民種別コード(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get住民種別().getCode());
            広域内住所地特例者List.add(広域内住所地特例者Entity);
        }
        return 広域内住所地特例者List;
    }

    private void set広住喪失日_範囲(KoikinaiJushochiTokureiRelateEntity entity,
            KoikinaiJushochiTokureiEntity 広域内住所地特例者Entity) {
        KoikinaiJushochiTokureiRelateEntity 広域特解除情報 = mapper.get広域特解除情報(KoikinaiKaijoParamter.
                createParam(entity.getHihokenshaNo().value(),
                        new RString(entity.getIdoYMD().toString()),
                        new RString(entity.getShikakuShutokuYMD().toString())));
        if (広域特解除情報 != null
                && entity.getIdoYMD().isBefore(広域特解除情報.getIdoYMD())) {
            if (広域特解除情報.getIdoJiyuCode().equals(広域特解除情報.getShikakuSoshitsuJiyuCode())) {
                広域内住所地特例者Entity.set広住喪失日(nullToEmtiy(entity.getShikakuSoshitsuYMD()));
                広域内住所地特例者Entity.set広住喪失届出日(nullToEmtiy(entity.getShikakuSoshitsuTodokedeYMD()));
            }
            if (広域特解除情報.getIdoJiyuCode().equals(広域特解除情報.getShikakuHenkoJiyuCode())) {
                広域内住所地特例者Entity.set広住喪失日(nullToEmtiy(entity.getShikakuHenkoYMD()));
                広域内住所地特例者Entity.set広住喪失届出日(nullToEmtiy(entity.getShikakuHenkoTodokedeYMD()));
            }
        }
    }

    private void set広住喪失日_基準日(KoikinaiJushochiTokureiRelateEntity entity,
            KoikinaiJushochiTokureiEntity 広域内住所地特例者Entity) {
        KoikinaiJushochiTokureiRelateEntity 広域特解除情報 = mapper.get広域特解除情報(KoikinaiKaijoParamter.
                createParam(entity.getHihokenshaNo().value(),
                        new RString(entity.getIdoYMD().toString()),
                        new RString(entity.getShikakuShutokuYMD().toString())));
        if (広域特解除情報 != null
                && new FlexibleDate(paramter.getIdoYMD()).isBefore(広域特解除情報.getIdoYMD())) {
            if (広域特解除情報.getIdoJiyuCode().equals(広域特解除情報.getShikakuSoshitsuJiyuCode())) {
                広域内住所地特例者Entity.set広住喪失日(nullToEmtiy(entity.getShikakuSoshitsuYMD()));
                広域内住所地特例者Entity.set広住喪失届出日(nullToEmtiy(entity.getShikakuSoshitsuTodokedeYMD()));
            }
            if (広域特解除情報.getIdoJiyuCode().equals(広域特解除情報.getShikakuHenkoJiyuCode())) {
                広域内住所地特例者Entity.set広住喪失日(nullToEmtiy(entity.getShikakuHenkoYMD()));
                広域内住所地特例者Entity.set広住喪失届出日(nullToEmtiy(entity.getShikakuHenkoTodokedeYMD()));
            }
        }
    }

    private void get市町村コードと市町村名称() {
        if (!市町村DDL1件目コード.equals(paramter.getShichosonCode())) {
            this.市町村コード = paramter.getShichosonCode();
            this.市町村名称 = paramter.getShichosonName();
        } else {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            this.市町村コード = new RString(
                    association.get地方公共団体コード().toString());
            this.市町村名称 = association.get市町村名();
        }
    }

    private KoikinaiJushochiTokureiItiranEntity is広域内住所地特例者一覧表情報Entity作成(List<KoikinaiJushochiTokureiEntity> entityList) {
        return new KoikinaiJushochiTokureiItiranEntity(並び順, 改頁, 市町村コード, 市町村名称, entityList);
    }

    private RString nullToEmtiy(Object obj) {
        return obj == null ? RString.EMPTY : new RString(obj.toString());
    }

    private List<KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei> is帳票データ作成(KoikinaiJushochiTokureiItiranEntity entity) {
        return KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei.createReportDate(entity, 出力順entity);
    }

    private PersonalData toPersonalData(RString 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(new ShikibetsuCode(識別コード), expandedInfo);
    }
}
