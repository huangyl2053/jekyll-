/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakuservicehijuryoininkeiyakukakuninsho;

import jp.co.ndensan.reams.db.dbc.business.core.kogakuservicehijuryoininkeiyakukakuninsho.KogakuServiceHiJuryoininKeiyakuKakuninshoResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuservicehijuryoininkeiyakukakuninsho.KogakuServiceHiJuryoininKeiyakuKakuninshoParameter;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書
 *
 * @reamsid_L DBC-1980-030 yuqingzhang
 */
public class KogakuServiceHiJuryoininKeiyakuKakuninsho {

    private static final RString 帳票分類ID = new RString("DBC100031_KogakuServiceHiJyuryoItakuKeiyakuKakuninSho");
    private static final RString 帳票制御共通_首長名印字位置_公印にかける = new RString("1");
    private ReportSourceWriter<KogakuServiceJyuryoKakuninShoSource> reportSourceWriter;
    private DbT7060KaigoJigyoshaDac 介護事業者情報DAC;
    private DbT7062KaigoJigyoshaDaihyoshaDac 介護事業者代表者情報DAC;
    private DbT7065ChohyoSeigyoKyotsuDac 帳票制御情報DAC;
    private DbT7068ChohyoBunruiKanriDac 帳票分類管理DAC;

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuServiceHiJuryoininKeiyakuKakuninsho}のインスタンス
     */
    public static KogakuServiceHiJuryoininKeiyakuKakuninsho createInstance() {
        return InstanceProvider.create(KogakuServiceHiJuryoininKeiyakuKakuninsho.class);
    }

    /**
     * 高額サービス費等受領委任払管理登録パネルから取った入力パラメータ等により、帳票データを作成します。
     *
     * @param param KogakuServiceHiJuryoininKeiyakuKakuninshoParameter
     * @return result KogakuServiceHiJuryoininKeiyakuKakuninshoResult
     */
    public KogakuServiceHiJuryoininKeiyakuKakuninshoResult getKogakuServiceHiJuryoininKeiyakuKakuninshoData(
            KogakuServiceHiJuryoininKeiyakuKakuninshoParameter param) {
        KogakuServiceHiJuryoininKeiyakuKakuninshoResult result = new KogakuServiceHiJuryoininKeiyakuKakuninshoResult();
        result.set文書番号(param.get文書番号());
        result.set被保険者番号(param.get被保険者番号().getColumnValue());
        result.set被保険者氏名(param.get被保険者氏名());
        result.set被保険者氏名フリガナ(param.get被保険者氏名フリガナ());
        result.set受付年月日(param.get受付日().wareki().eraType(EraType.KANJI_RYAKU).toDateString());
        result.set承認不承認(param.get決定区分());
        result.set承認年月日(param.get決定日().wareki().eraType(EraType.KANJI_RYAKU).toDateString());
        result.set不承認の理由(param.get承認しない理由());

        介護事業者情報を取得する(result, param.get事業者番号());
        介護事業者代表者情報を取得する(result, param.get事業者番号());
        認証者情報を取得する(result, param.get決定日());
        通知書定型文情報を取得する(result);
        送付物宛先情報を取得する(result, param.get決定日());

        return result;
    }

    private void 介護事業者情報を取得する(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result, RString 事業者番号) {
        this.介護事業者情報DAC = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        DbT7060KaigoJigyoshaEntity entity = 介護事業者情報DAC.select介護事業者情報の最新(new JigyoshaNo(事業者番号));
        RString jigyoshaName = null == entity.getJigyoshaName() || RString.isNullOrEmpty(entity.getJigyoshaName().value())
                ? RString.EMPTY : entity.getJigyoshaName().value();
        result.set事業所名(jigyoshaName);
        result.set事業所郵便番号(getYubinNo(entity.getYubinNo()));
        result.set事業所電話番号(getTelNo(entity.getTelNo()));
        result.set事業所所在地(RString.isNullOrEmpty(entity.getJigyoshaKanaAddress()) ? RString.EMPTY : entity.getJigyoshaKanaAddress());
    }

    private RString getYubinNo(YubinNo yubinNo) {
        if (null == yubinNo || RString.isNullOrEmpty(yubinNo.value())) {
            return RString.EMPTY;
        }
        return yubinNo.value();
    }

    private RString getTelNo(TelNo telNo) {
        if (null == telNo || RString.isNullOrEmpty(telNo.value())) {
            return RString.EMPTY;
        }
        return telNo.value();
    }

    private void 介護事業者代表者情報を取得する(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result, RString 事業者番号) {
        this.介護事業者代表者情報DAC = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
        DbT7062KaigoJigyoshaDaihyoshaEntity entity = 介護事業者代表者情報DAC.select介護事業者代表者情報の最新(new JigyoshaNo(事業者番号));
        result.set代表者氏名((null == entity || null == entity.getDaihyoshaShimei())
                ? RString.EMPTY : entity.getDaihyoshaShimei().getColumnValue());
    }

    private void 認証者情報を取得する(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result, FlexibleDate 通知日) {
        this.帳票制御情報DAC = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御情報Entity = 帳票制御情報DAC.selectByKey(SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID));

        INinshoshaManager manager = NinshoshaFinderFactory.createInstance();
        Ninshosha 帳票認証者情報Business = manager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 通知日);

        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association 地方公共団体Business = finder.getAssociation();

        if (null != 帳票認証者情報Business && null != 地方公共団体Business
                && null != 帳票制御情報Entity && null != reportSourceWriter.getImageFolderPath()) {
            INinshoshaSourceBuilder builder = NinshoshaSourceBuilderFactory.createInstance(帳票認証者情報Business,
                    地方公共団体Business, reportSourceWriter.getImageFolderPath(), new RDate(通知日.toString()),
                    帳票制御共通_首長名印字位置_公印にかける.equals(帳票制御情報Entity.getShuchoMeiInjiIchi()),
                    !帳票制御情報Entity.getDenshiKoinInjiUmu(), KenmeiFuyoKubunType.付与なし);
            NinshoshaSource source = builder.buildSource();

            result.set発行日(null == source.hakkoYMD ? RString.EMPTY : source.hakkoYMD);
            result.set認証者役職名(null == source.ninshoshaYakushokuMei ? RString.EMPTY : source.ninshoshaYakushokuMei);
            result.set認証者役職名1(null == source.ninshoshaYakushokuMei1 ? RString.EMPTY : source.ninshoshaYakushokuMei1);
            result.set認証者役職名2(null == source.ninshoshaYakushokuMei2 ? RString.EMPTY : source.ninshoshaYakushokuMei2);
            result.set電子公印(null == source.denshiKoin ? RString.EMPTY : source.denshiKoin);
            result.set公印文字列(null == source.koinMojiretsu ? RString.EMPTY : source.koinMojiretsu);
            result.set認証者氏名掛ける(null == source.ninshoshaShimeiKakeru ? RString.EMPTY : source.ninshoshaShimeiKakeru);
            result.set認証者氏名掛けない(null == source.ninshoshaShimeiKakenai ? RString.EMPTY : source.ninshoshaShimeiKakenai);
            result.set公印省略(null == source.koinShoryaku ? RString.EMPTY : source.koinShoryaku);
        }
    }

    private void 通知書定型文情報を取得する(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result) {
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo 通知書定型文項目Business = manager.get通知書定型文項目(SubGyomuCode.DBC介護給付,
                new ReportId(帳票分類ID), KamokuCode.EMPTY, 1);

        this.帳票分類管理DAC = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
        DbT7068ChohyoBunruiKanriEntity 帳票分類管理Entity = 帳票分類管理DAC.selectByKey(SubGyomuCode.DBC介護給付, new ReportId(帳票分類ID));

        ITextHenkanRule 介護定型文変換ルールBusiness = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBC介護給付,
                帳票分類管理Entity.getChohyoBunruiID());

        for (TsuchishoTeikeibunEntity tsuchishoTeikeibunEntity : 通知書定型文項目Business.get通知書定型文List()) {
            int 項目番号 = tsuchishoTeikeibunEntity.getTsuchishoTeikeibunEntity().getSentenceNo();
            if (1 == 項目番号) {
                result.set通知文1(介護定型文変換ルールBusiness.editText(tsuchishoTeikeibunEntity.getTsuchishoTeikeibunEntity().getSentence()));
            }
            if (2 == 項目番号) {
                result.set通知文2(介護定型文変換ルールBusiness.editText(tsuchishoTeikeibunEntity.getTsuchishoTeikeibunEntity().getSentence()));
            }
            if ((!RString.isNullOrEmpty(result.get通知文1())) && (!RString.isNullOrEmpty(result.get通知文2()))) {
                break;
            }
        }
    }

    private void 送付物宛先情報を取得する(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result, FlexibleDate 通知日) {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set基準日(通知日);
        IAtesaki 宛先情報Entity = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        ReportAtesakiEditorBuilder sofubutsuAtesakiEditorBuilder = new ReportAtesakiEditorBuilder(宛先情報Entity);
        ReportAtesakiEditor reportAtesakiEditor = new ReportAtesakiEditor(sofubutsuAtesakiEditorBuilder);
        SofubutsuAtesakiSourceBuilder sofubutsuAtesakiSourceBuilder = new SofubutsuAtesakiSourceBuilder(reportAtesakiEditor);
        SofubutsuAtesakiSource 宛先Source = sofubutsuAtesakiSourceBuilder.buildSource();

        result.set郵便番号(null == 宛先Source.yubinNo ? RString.EMPTY : 宛先Source.yubinNo);
        result.set行政区名(null == 宛先Source.gyoseiku ? RString.EMPTY : 宛先Source.gyoseiku);
        result.set住所(null == 宛先Source.jushoText ? RString.EMPTY : 宛先Source.jushoText);
        result.set住所5(null == 宛先Source.jusho1 ? RString.EMPTY : 宛先Source.jusho1);
        result.set住所6(null == 宛先Source.jusho2 ? RString.EMPTY : 宛先Source.jusho2);
        result.set住所4(null == 宛先Source.jusho3 ? RString.EMPTY : 宛先Source.jusho3);
        result.set方書(null == 宛先Source.katagakiText ? RString.EMPTY : 宛先Source.katagakiText);
        result.set方書4(null == 宛先Source.katagaki1 ? RString.EMPTY : 宛先Source.katagaki1);
        result.set方書3(null == 宛先Source.katagaki2 ? RString.EMPTY : 宛先Source.katagaki2);
        result.set方書小1(null == 宛先Source.katagakiSmall1 ? RString.EMPTY : 宛先Source.katagakiSmall1);
        result.set方書小2(null == 宛先Source.katagakiSmall2 ? RString.EMPTY : 宛先Source.katagakiSmall2);
        result.set代納人区分(null == 宛先Source.dainoKubunMei ? RString.EMPTY : 宛先Source.dainoKubunMei);
        result.set氏名(null == 宛先Source.shimeiText ? RString.EMPTY : 宛先Source.shimeiText);
        setResult(result, 宛先Source);
    }

    private void setResult(KogakuServiceHiJuryoininKeiyakuKakuninshoResult result, SofubutsuAtesakiSource 宛先Source) {
        result.set氏名6(null == 宛先Source.shimei1 ? RString.EMPTY : 宛先Source.shimei1);
        result.set氏名5(null == 宛先Source.shimei2 ? RString.EMPTY : 宛先Source.shimei2);
        result.set氏名小1(null == 宛先Source.shimeiSmall1 ? RString.EMPTY : 宛先Source.shimeiSmall1);
        result.set氏名小2(null == 宛先Source.shimeiSmall2 ? RString.EMPTY : 宛先Source.shimeiSmall2);
        result.set様文氏名(null == 宛先Source.samabunShimeiText ? RString.EMPTY : 宛先Source.samabunShimeiText);
        result.set様文氏名1(null == 宛先Source.samabunShimei1 ? RString.EMPTY : 宛先Source.samabunShimei1);
        result.set様文氏名2(null == 宛先Source.samabunShimei2 ? RString.EMPTY : 宛先Source.samabunShimei2);
        result.set様文氏名小1(null == 宛先Source.samabunShimeiSmall1 ? RString.EMPTY : 宛先Source.samabunShimeiSmall1);
        result.set様文氏名小2(null == 宛先Source.samabunShimeiSmall2 ? RString.EMPTY : 宛先Source.samabunShimeiSmall2);
        result.set名称付与1(null == 宛先Source.meishoFuyo1 ? RString.EMPTY : 宛先Source.meishoFuyo1);
        result.set名称付与2(null == 宛先Source.meishoFuyo2 ? RString.EMPTY : 宛先Source.meishoFuyo2);
        result.set様文1(null == 宛先Source.samaBun1 ? RString.EMPTY : 宛先Source.samaBun1);
        result.set様文2(null == 宛先Source.samaBun2 ? RString.EMPTY : 宛先Source.samaBun2);
        result.set左括弧1(null == 宛先Source.kakkoLeft1 ? RString.EMPTY : 宛先Source.kakkoLeft1);
        result.set左括弧2(null == 宛先Source.kakkoLeft2 ? RString.EMPTY : 宛先Source.kakkoLeft2);
        result.set右括弧1(null == 宛先Source.kakkoRight1 ? RString.EMPTY : 宛先Source.kakkoRight1);
        result.set右括弧2(null == 宛先Source.kakkoRight2 ? RString.EMPTY : 宛先Source.kakkoRight2);
        result.setカスタマーバーコード(null == 宛先Source.customerBarCode ? RString.EMPTY : 宛先Source.customerBarCode);
    }
}
