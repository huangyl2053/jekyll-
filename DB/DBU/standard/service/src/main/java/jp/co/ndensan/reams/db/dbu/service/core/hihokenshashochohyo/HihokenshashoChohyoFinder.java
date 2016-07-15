/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshashochohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.config.ConfigKeysHihokenshashoIndicationMethod;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashochohyo.HihokenshashoChoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.AtenaMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.HihokenshashoChohyoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashochohyo.HonninJohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashochohyo.SofusakiJohoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IHihokenshashoChohyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者証帳票Entity作成です。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
public class HihokenshashoChohyoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7060KaigoJigyoshaDac dbt7060Dac;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbt1005Dac;
    private final DbT7065ChohyoSeigyoKyotsuDac dbt7065dac;
    private static final RString 要介護認定期限切れ_表示有無 = new RString("要介護認定期限切れ_表示有無");
    private static final RString 居宅支援事業者適用切れ_表示有無 = new RString("居宅支援事業者適用切れ_表示有無");
    private static final RString 居宅支援事業者履歴_表示方法 = new RString("居宅支援事業者履歴_表示方法");
    private static final RString 該当データはありません = new RString("該当データはありません");
    private static final ReportId 帳票分類ID = new ReportId("DBA100001_Hihokenshasho");
    private static final RString 全角スペース = new RString("　");
    private static final RString 半角スペース = new RString(" ");
    private static final RString 枚目3の = new RString("3枚目の");
    private static final RString 下段参照 = new RString("下段参照");
    private static final RString 戸籍上の = new RString("戸籍上の");
    private static final RString 単位 = new RString("単位");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString TRUE = new RString("true");
    private static final RString FALSE = new RString("false");
    private static final RString 月1あたり = new RString("1月あたり");
    private static final RString 波線 = new RString("～");
    private static final RString 郵便番号表示有 = new RString("1");
    private static final RString 氏名カナ表示有 = new RString("1");
    private static final RString 星アイコン = new RString("＊");
    private static final RString 性別1 = new RString("1");
    private static final RString 住民種別コード2 = new RString("2");
    private static final RString 性別2 = new RString("2");
    private static final RString 住民種別コード4 = new RString("4");
    private static final RString 住民種別コード1 = new RString("1");
    private static final RString 住民種別コード3 = new RString("3");
    private static final RString 管外 = new RString("管外");
    private static final RString 管内 = new RString("管内");
    private static final RString 文字_0 = new RString("0");
    private static final RString 文字_1 = new RString("1");
    private static final RString 文字_2 = new RString("2");
    private static final RString 文字_3 = new RString("3");
    private static final RString 文字_4 = new RString("4");
    private static final RString 文字_6 = new RString("6");
    private static final RString 文字_11 = new RString("11");
    private static final RString 文字_12 = new RString("12");
    private static final int 桁数_0 = 0;
    private static final int 桁数_1 = 1;
    private static final int 桁数_2 = 2;
    private static final int 桁数_3 = 3;
    private static final int 桁数_4 = 4;
    private static final int 桁数_5 = 5;
    private static final int 桁数_6 = 6;
    private static final int 桁数_13 = 13;
    private static final int 文字数_8 = 8;
    private static final int 文字数_40 = 40;
    private static final RString PSMYO = new RString("psmShikibetsuTaisho");
    private static final RString PSMWM = new RString("psmAtesaki");

    /**
     * コンストラクタ。
     *
     */
    public HihokenshashoChohyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbt1005Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
        this.dbt7065dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dbt7060Dac DbT7060KaigoJigyoshaDac
     * @param dbt1005Dac DbT1005KaigoJogaiTokureiTaishoShisetsuDac
     * @param dbt7065dac DbT7065ChohyoSeigyoKyotsuDac
     */
    HihokenshashoChohyoFinder(MapperProvider mapperProvider, DbT7060KaigoJigyoshaDac dbt7060Dac,
            DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbt1005Dac, DbT7065ChohyoSeigyoKyotsuDac dbt7065dac) {
        this.mapperProvider = mapperProvider;
        this.dbt7060Dac = dbt7060Dac;
        this.dbt1005Dac = dbt1005Dac;
        this.dbt7065dac = dbt7065dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshashoChohyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshashoChohyoFinder}のインスタンス
     */
    public static HihokenshashoChohyoFinder createInstance() {
        return InstanceProvider.create(HihokenshashoChohyoFinder.class);
    }

    /**
     * 被保険者証一括作成バッチより、被保険者証帳票Entityを作成します。
     *
     * @param hihoken 被保険者証用データ
     * @return 被保険者証帳票ソースデータリスト
     */
    public SearchResult<HihokenshashoChoBusiness> createHihokenshashoChohyo(List<HihokenshashoChohyoParameter> hihoken) {
        return setHihokenshashoChohyo(hihoken);
    }

    private SearchResult<HihokenshashoChoBusiness> setHihokenshashoChohyo(List<HihokenshashoChohyoParameter> hihoken) {
        List<HihokenshashoChoBusiness> businessList = new ArrayList<>();
        if (hihoken == null || hihoken.isEmpty()) {
            HihokenshashoChoBusiness entity = new HihokenshashoChoBusiness();
            entity.set住所(該当データはありません);
            businessList.add(entity);
            return SearchResult.of(businessList, businessList.size(), true);
        }
        for (int i = 0; i < hihoken.size(); i++) {
            HihokenshashoChoBusiness business = new HihokenshashoChoBusiness();
            business.set有効期限1(RString.EMPTY);
            business.set有効期限2(RString.EMPTY);
            business.set被保険者番号(hihoken.get(i).get被保険者番号());
            List<HonninJohoEntity> honni = get本人情報(hihoken.get(i).get識別コード());
            if (郵便番号表示有.equals(DbBusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_郵便番号表示有無,
                    RDate.getNowDate(), SubGyomuCode.DBA介護資格))) {
                business.set郵便番号(honni.get(0).getYubinNo() == null ? RString.EMPTY : honni.get(0).getYubinNo().getEditedYubinNo());
            }
            RString gyoseiku = honni.get(0).getGyoseikuName();
            if (!gyoseiku.isNullOrEmpty()) {
                if (gyoseiku.length() <= 桁数_13) {
                    business.set行政区1(gyoseiku);
                    business.set行政区2(RString.EMPTY);
                } else {
                    business.set行政区1(gyoseiku.substring(桁数_0, 桁数_13));
                    business.set行政区2(gyoseiku.substring(桁数_13));
                }
            } else {
                business.set行政区1(RString.EMPTY);
                business.set行政区2(RString.EMPTY);
            }
            List<SofusakiJohoEntity> sofusa = get送付先情報(hihoken.get(i).get識別コード());
            if (sofusa != null && !sofusa.isEmpty()) {
                if (管外.equals(sofusa.get(桁数_0).getKannaiKangaiKubun())) {
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(sofusa.get(桁数_0).getJusho());
                    builder.append(sofusa.get(桁数_0).getBanchi());
                    builder.append(全角スペース);
                    builder.append(sofusa.get(桁数_0).getKatagaki());
                    business.set住所(builder.toRString());
                }
                if (管内.equals(sofusa.get(桁数_0).getKannaiKangaiKubun())) {
                    set住所(business, sofusa.get(桁数_0), honni.get(桁数_0));
                }
            }
            if (氏名カナ表示有.equals(DbBusinessConfig.get(ConfigKeysHihokenshashoIndicationMethod.被保険者証表示方法_氏名カナ表示有無,
                    RDate.getNowDate(), SubGyomuCode.DBA介護資格))) {
                business.set氏名カナ(honni.get(0).getKanaMeisho());
            }
            business.set氏名(honni.get(0).getMeisho());
            set生年月日(business, honni.get(0));
            business.set交付年月日(hihoken.get(i).get交付日() == null ? RString.EMPTY : new RString(hihoken.get(i).get交付日().toString()));
            if (!RString.isNullOrEmpty(hihoken.get(i).get保険者())) {
                RString 保険者 = hihoken.get(i).get保険者();
                if (hihoken.get(i).get保険者().length() < 桁数_6) {
                    保険者 = hihoken.get(i).get保険者().padRight(RString.HALF_SPACE, 桁数_6);
                }
                business.set保険者NO1(保険者.substring(桁数_0, 桁数_1));
                business.set保険者NO2(保険者.substring(桁数_1, 桁数_2));
                business.set保険者NO3(保険者.substring(桁数_2, 桁数_3));
                business.set保険者NO4(保険者.substring(桁数_3, 桁数_4));
                business.set保険者NO5(保険者.substring(桁数_4, 桁数_5));
                business.set保険者NO6(保険者.substring(桁数_5, 桁数_6));
            }
            if (hihoken.get(i).get指定サービス種類() != null && !hihoken.get(i).get指定サービス種類().isEmpty()) {
                setサービス種類(business, hihoken.get(i));
            }
            set入退所(business, hihoken.get(i));
            set帳票制御(business, hihoken.get(i));
            business.set連番(new RString(String.valueOf(i + 1)).padLeft(文字_0, 桁数_6));
            set入退所チェック(business, hihoken.get(i));
            set期間年月日(business, hihoken.get(i));
            businessList.add(business);
        }
        return SearchResult.of(businessList, businessList.size(), true);
    }

    private void set期間年月日(HihokenshashoChoBusiness business, HihokenshashoChohyoParameter hihoken) {
        business.set要介護認定区分(hihoken.get要介護認定状態区分コード());
        business.set認定年月日(hihoken.get認定年月日() == null ? RString.EMPTY : hihoken.get認定年月日()
                .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString());
        business.set認定有効期間開始年月日(hihoken.get認定有効期間開始年月日() == null ? RString.EMPTY : hihoken
                .get認定有効期間開始年月日().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        business.set認定有効期間終了年月日(hihoken.get認定有効期間終了年月日() == null ? RString.EMPTY : hihoken
                .get認定有効期間終了年月日().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        business.set訪問期間開始年月日(hihoken.get支給限度有効開始年月日() == null ? RString.EMPTY : hihoken
                .get支給限度有効開始年月日().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        business.set訪問期間終了年月日(hihoken.get支給限度有効終了年月日() == null ? RString.EMPTY : hihoken
                .get支給限度有効終了年月日().wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        business.setサービス(new RString(hihoken.get支給限度単位数().toString()));
    }

    private void set住所(HihokenshashoChoBusiness business, SofusakiJohoEntity sofusa, HonninJohoEntity honni) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        association.get都道府県名();
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通Entity = dbt7065dac.selectByKey(SubGyomuCode.DBA介護資格,
                帳票分類ID);
        if (文字_1.equals(帳票制御共通Entity.getJushoHenshuKubun())) {
            RStringBuilder builder = new RStringBuilder();
            if (帳票制御共通Entity.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                builder.append(association.get都道府県名());
            }
            if (帳票制御共通Entity.getJushoHenshuGunMeiHyojiUmu()) {
                builder.append(RString.EMPTY);
            }
            if (帳票制御共通Entity.getJushoHenshuShichosonMeiHyojiUmu()) {
                builder.append(RString.EMPTY);
            }
            if (文字_1.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                builder.append(sofusa.getJusho());
                builder.append(sofusa.getBanchi());
            }
            if (文字_2.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                builder.append(honni.getGyoseikuName());
                builder.append(sofusa.getBanchi());
            }
            if (文字_3.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                builder.append(sofusa.getJusho());
                builder.append(sofusa.getBanchi());
                builder.append(honni.getGyoseikuName());
            }
            if (文字_4.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                builder.append(sofusa.getBanchi());
            }
            if (帳票制御共通Entity.getJushoHenshuKatagakiHyojiUmu()) {
                builder.append(半角スペース);
                builder.append(sofusa.getKatagaki());
            }
            business.set住所(builder.toRString());
        }
        if (文字_0.equals(帳票制御共通Entity.getJushoHenshuKubun())) {
            RStringBuilder builder = new RStringBuilder();
            if (文字_1.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(association.get都道府県名());
            }
            if (文字_1.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(RString.EMPTY);
            }
            if (文字_1.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(RString.EMPTY);
            }
            if (文字_1.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(sofusa.getJusho());
                builder.append(sofusa.getBanchi());
            }
            if (文字_2.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(honni.getGyoseikuName());
                builder.append(sofusa.getBanchi());
            }
            if (文字_3.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(sofusa.getJusho());
                builder.append(sofusa.getBanchi());
                builder.append(honni.getGyoseikuName());
            }
            if (文字_4.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(sofusa.getBanchi());
            }
            if (文字_1.equals(DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告))) {
                builder.append(半角スペース);
                builder.append(sofusa.getKatagaki());
            }
            business.set住所(builder.toRString());
        }
    }

    private RString get入所施設種類(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get入退所年月日().size()) {
            return parameter.get入退所年月日().get(連番).get入所施設種類();
        }
        return RString.EMPTY;
    }

    private RString get入所年月日(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get入退所年月日().size() && parameter.get入退所年月日().get(連番).get入所年月日() != null
                && !parameter.get入退所年月日().get(連番).get入所年月日().isEmpty()) {
            return parameter.get入退所年月日().get(連番).get入所年月日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get退所年月日(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get入退所年月日().size() && parameter.get入退所年月日().get(連番).get退所年月日() != null
                && !parameter.get入退所年月日().get(連番).get退所年月日().isEmpty()) {
            return parameter.get入退所年月日().get(連番).get退所年月日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private void set入退所チェック(HihokenshashoChoBusiness business, HihokenshashoChohyoParameter parameter) {
        business.set施設種類11(get入所施設種類(parameter, 桁数_0));
        business.set施設種類2(get入所施設種類(parameter, 桁数_1));
        business.set入所年月日2(get入所年月日(parameter, 桁数_1));
        business.set退院年月日2(get退所年月日(parameter, 桁数_1));
        if (文字_11.equals(get入所施設種類(parameter, 桁数_1))) {
            business.set施設名2(dbt7060Dac.select事業者名称(new JigyoshaNo(parameter.get入退所年月日().get(桁数_1).get入所施設コード()))
                    .get(桁数_0).getJigyoshaName().getColumnValue());
        }
        if (文字_12.equals(get入所施設種類(parameter, 桁数_1))) {
            business.set施設名2(dbt1005Dac.select事業者名称(new JigyoshaNo(parameter.get入退所年月日().get(桁数_0).get入所施設コード()))
                    .get(桁数_0).getJigyoshaMeisho().getColumnValue());
        }
        business.set入所年月日1(get入所年月日(parameter, 桁数_0));
        business.set退院年月日1(get退所年月日(parameter, 桁数_0));
        if (文字_11.equals(get入所施設種類(parameter, 桁数_0))) {
            business.set施設名1(dbt7060Dac.select事業者名称(new JigyoshaNo(parameter.get入退所年月日().get(桁数_0).get入所施設コード()))
                    .get(桁数_0).getJigyoshaName().getColumnValue());
        }
        if (文字_12.equals(get入所施設種類(parameter, 桁数_0))) {
            business.set施設名1(dbt1005Dac.select事業者名称(new JigyoshaNo(parameter.get入退所年月日().get(桁数_0).get入所施設コード()))
                    .get(桁数_0).getJigyoshaMeisho().getColumnValue());
        }
        if (文字_11.equals(get入所施設種類(parameter, 桁数_0))
                && (文字_1.equals(parameter.get入退所年月日().get(桁数_0).get入所施設コード().substring(桁数_2, 桁数_3))
                || 文字_3.equals(parameter.get入退所年月日().get(桁数_0).get入所施設コード().substring(桁数_2, 桁数_3))
                || 文字_4.equals(parameter.get入退所年月日().get(桁数_0).get入所施設コード().substring(桁数_2, 桁数_3))
                || 文字_6.equals(parameter.get入退所年月日().get(桁数_0).get入所施設コード().substring(桁数_2, 桁数_3)))) {
            business.set入所チェック1(星アイコン);
            business.set退所チェック1(星アイコン);
        } else {
            business.set入院チェック1(星アイコン);
            business.set退院チェック1(星アイコン);
        }
        if (文字_11.equals(get入所施設種類(parameter, 桁数_1))
                && (文字_1.equals(parameter.get入退所年月日().get(桁数_1).get入所施設コード().substring(桁数_2, 桁数_3))
                || 文字_3.equals(parameter.get入退所年月日().get(桁数_1).get入所施設コード().substring(桁数_2, 桁数_3))
                || 文字_4.equals(parameter.get入退所年月日().get(桁数_1).get入所施設コード().substring(桁数_2, 桁数_3))
                || 文字_6.equals(parameter.get入退所年月日().get(桁数_1).get入所施設コード().substring(桁数_2, 桁数_3)))) {
            business.set入所チェック2(星アイコン);
            business.set退所チェック2(星アイコン);
        } else {
            business.set入院チェック2(星アイコン);
            business.set退院チェック2(星アイコン);
        }
    }

    private FlexibleDate get適用終了日(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get届出年月日().size() && parameter.get届出年月日().get(連番).get適用終了日() != null) {
            return parameter.get届出年月日().get(連番).get適用終了日();
        }
        return FlexibleDate.MIN;
    }

    private void set帳票制御(HihokenshashoChoBusiness business, HihokenshashoChohyoParameter parameter) {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, 帳票分類ID,
                FlexibleDate.getNowDate().getYear(), 要介護認定期限切れ_表示有無);
        ChohyoSeigyoHanyo chohyoSeigyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, 帳票分類ID,
                FlexibleDate.getNowDate().getYear(), 居宅支援事業者適用切れ_表示有無);
        if (文字_1.equals(chohyoSeigyoHanyo.get設定値()) && 文字_0.equals(chohyoSeigyo.get設定値())) {
            if (parameter.get届出年月日().get(桁数_0).get適用終了日() == null
                    || get適用終了日(parameter, 桁数_0).isBefore(getNull(parameter.get交付日()))) {
                business.set居宅介護事業者1(RString.EMPTY);
                business.set届出年月日1(RString.EMPTY);
                business.set居宅介護事業者長1(RString.EMPTY);
                business.set居宅介護事業者2(RString.EMPTY);
                business.set居宅介護事業者3(RString.EMPTY);
                business.set届出年月日2(RString.EMPTY);
                business.set届出年月日3(RString.EMPTY);
                business.set居宅介護事業者長2(RString.EMPTY);
                business.set居宅介護事業者長3(RString.EMPTY);
                business.set居宅介護事業者取消2(RString.EMPTY);
                business.set居宅介護事業者取消3(RString.EMPTY);
                business.set居宅介護事業者星2(RString.EMPTY);
                business.set居宅介護事業者星3(RString.EMPTY);
                business.set届出年月日取消3(RString.EMPTY);
                business.set届出年月日取消2(RString.EMPTY);
                business.set届出年月日星3(RString.EMPTY);
                business.set届出年月日星2(RString.EMPTY);
                business.set居宅介護事業者長取消2(RString.EMPTY);
                business.set居宅介護事業者長取消3(RString.EMPTY);
                business.set居宅介護事業者長星2(RString.EMPTY);
                business.set居宅介護事業者長星3(RString.EMPTY);
            } else {
                chohyoHensu(business);
            }
        }
        if (文字_1.equals(chohyoSeigyoHanyo.get設定値()) && 文字_1.equals(chohyoSeigyo.get設定値())) {
            chohyoHensu(business);
        }
    }

    private RString get計画事業者番号(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get届出年月日().size() && !RString.isNullOrEmpty(parameter.get届出年月日().get(連番).get計画事業者番号())) {
            return parameter.get届出年月日().get(連番).get計画事業者番号();
        }
        return RString.EMPTY;
    }

    private RString get届出年月日(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get届出年月日().size() && parameter.get届出年月日().get(連番).get届出年月日() != null) {
            return parameter.get届出年月日().get(連番).get届出年月日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private void set計画事業者番号(HihokenshashoChoBusiness business, HihokenshashoChohyoParameter parameter) {
        if (!RString.isNullOrEmpty(get計画事業者番号(parameter, 桁数_0))) {
            if (parameter.get届出年月日().get(桁数_0).get計画事業者番号().length() <= 文字数_40) {
                business.set居宅介護事業者1(parameter.get届出年月日().get(桁数_0).get計画事業者番号());
            } else {
                business.set居宅介護事業者長1(parameter.get届出年月日().get(桁数_0).get計画事業者番号());
            }
        }
        if (!RString.isNullOrEmpty(get計画事業者番号(parameter, 桁数_1))) {
            if (parameter.get届出年月日().get(桁数_1).get計画事業者番号().length() <= 文字数_40) {
                business.set居宅介護事業者2(parameter.get届出年月日().get(桁数_1).get計画事業者番号());
            } else {
                business.set居宅介護事業者長2(parameter.get届出年月日().get(桁数_1).get計画事業者番号());
            }
        }
        if (!RString.isNullOrEmpty(get計画事業者番号(parameter, 桁数_2))) {
            if (parameter.get届出年月日().get(桁数_2).get計画事業者番号().length() <= 文字数_40) {
                business.set居宅介護事業者3(parameter.get届出年月日().get(桁数_2).get計画事業者番号());
            } else {
                business.set居宅介護事業者長3(parameter.get届出年月日().get(桁数_2).get計画事業者番号());
            }
        }

    }

    private void set入退所(HihokenshashoChoBusiness business, HihokenshashoChohyoParameter parameter) {
        set計画事業者番号(business, parameter);
        business.set届出年月日1(get届出年月日(parameter, 桁数_0));
        business.set届出年月日2(get届出年月日(parameter, 桁数_1));
        business.set届出年月日3(get届出年月日(parameter, 桁数_2));
        business.set性障害1(枚目3の);
        business.set性障害2(下段参照);
        business.set構成性別1(戸籍上の);
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                FlexibleDate.EMPTY);
        business.set複合コントロール(new RString(ninshosha.toString()));
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, 帳票分類ID,
                FlexibleDate.getNowDate().getYear(), 要介護認定期限切れ_表示有無);
        if (文字_0.equals(chohyoSeigyoHanyo.get設定値()) && (parameter.get認定有効期間終了年月日() == null
                || parameter.get認定有効期間終了年月日().isBefore(parameter.get交付日() == null ? RDate.MIN
                        : new RDate(parameter.get交付日().toString())))) {
            business.set要介護認定区分(RString.EMPTY);
            business.set認定年月日(RString.EMPTY);
            business.set認定有効期間開始年月日(RString.EMPTY);
            business.set有効期間波線(RString.EMPTY);
            business.set認定有効期間終了年月日(RString.EMPTY);
            business.set訪問期間開始年月日(RString.EMPTY);
            business.set訪問期間終了年月日(RString.EMPTY);
            business.set訪問期間波線(RString.EMPTY);
            business.setサービス種類1(RString.EMPTY);
            business.setサービス種類2(RString.EMPTY);
            business.setサービス種類3(RString.EMPTY);
            business.setサービス種類4(RString.EMPTY);
            business.setサービス種類5(RString.EMPTY);
            business.setサービス種類6(RString.EMPTY);
            business.setサービス種類1つ目の限度額(RString.EMPTY);
            business.setサービス種類2つ目の限度額(RString.EMPTY);
            business.setサービス種類3つ目の限度額(RString.EMPTY);
            business.setサービス種類4つ目の限度額(RString.EMPTY);
            business.setサービス種類5つ目の限度額(RString.EMPTY);
            business.setサービス種類6つ目の限度額(RString.EMPTY);
            business.set点数1(RString.EMPTY);
            business.set点数2(RString.EMPTY);
            business.set点数3(RString.EMPTY);
            business.set点数4(RString.EMPTY);
            business.set点数5(RString.EMPTY);
            business.set点数6(RString.EMPTY);
            business.set給付制限1(RString.EMPTY);
            business.set給付制限2(RString.EMPTY);
            business.set給付制限3(RString.EMPTY);
            business.set給付制限4(RString.EMPTY);
            business.set給付制限5(RString.EMPTY);
            business.set給付制限6(RString.EMPTY);
            business.set給付制限長1(RString.EMPTY);
            business.set給付制限長2(RString.EMPTY);
            business.set給付制限長3(RString.EMPTY);
            business.set給付制限長4(RString.EMPTY);
            business.set給付制限長5(RString.EMPTY);
            business.set給付制限長6(RString.EMPTY);
            business.set給付制限開始年月日1(RString.EMPTY);
            business.set給付制限開始年月日2(RString.EMPTY);
            business.set給付制限開始年月日3(RString.EMPTY);
            business.set給付制限終了年月日1(RString.EMPTY);
            business.set給付制限終了年月日2(RString.EMPTY);
            business.set給付制限終了年月日3(RString.EMPTY);
            business.set居宅介護事業者1(RString.EMPTY);
            business.set届出年月日1(RString.EMPTY);
            business.set居宅介護事業者長1(RString.EMPTY);
            business.set居宅介護事業者2(RString.EMPTY);
            business.set居宅介護事業者3(RString.EMPTY);
            business.set届出年月日2(RString.EMPTY);
            business.set届出年月日3(RString.EMPTY);
            business.set居宅介護事業者長2(RString.EMPTY);
            business.set居宅介護事業者長3(RString.EMPTY);
            business.set居宅介護事業者取消2(RString.EMPTY);
            business.set居宅介護事業者取消3(RString.EMPTY);
            business.set居宅介護事業者星2(RString.EMPTY);
            business.set居宅介護事業者星3(RString.EMPTY);
            business.set届出年月日取消3(RString.EMPTY);
            business.set届出年月日取消2(RString.EMPTY);
            business.set届出年月日星3(RString.EMPTY);
            business.set届出年月日星2(RString.EMPTY);
            business.set居宅介護事業者長取消2(RString.EMPTY);
            business.set居宅介護事業者長取消3(RString.EMPTY);
            business.set居宅介護事業者長星2(RString.EMPTY);
            business.set居宅介護事業者長星3(RString.EMPTY);
        }
        ChohyoSeigyoHanyo chohyoSeigyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, 帳票分類ID,
                FlexibleDate.getNowDate().getYear(), 居宅支援事業者適用切れ_表示有無);
        if (文字_0.equals(chohyoSeigyoHanyo.get設定値()) && getNull(parameter.get交付日()).isBeforeOrEquals(parameter
                .get認定有効期間終了年月日() == null ? FlexibleDate.MIN : new FlexibleDate(parameter.get認定有効期間終了年月日().toDateString()))
                && 文字_0.equals(chohyoSeigyo.get設定値())) {
            if (parameter.get届出年月日().size() < 1 || parameter.get届出年月日().get(桁数_0).get適用終了日() == null
                    || get適用終了日(parameter, 桁数_0).isBefore(getNull(parameter.get交付日()))) {
                business.set居宅介護事業者1(RString.EMPTY);
                business.set届出年月日1(RString.EMPTY);
                business.set居宅介護事業者長1(RString.EMPTY);
                business.set居宅介護事業者2(RString.EMPTY);
                business.set居宅介護事業者3(RString.EMPTY);
                business.set届出年月日2(RString.EMPTY);
                business.set届出年月日3(RString.EMPTY);
                business.set居宅介護事業者長2(RString.EMPTY);
                business.set居宅介護事業者長3(RString.EMPTY);
                business.set居宅介護事業者取消2(RString.EMPTY);
                business.set居宅介護事業者取消3(RString.EMPTY);
                business.set居宅介護事業者星2(RString.EMPTY);
                business.set居宅介護事業者星3(RString.EMPTY);
                business.set届出年月日取消3(RString.EMPTY);
                business.set届出年月日取消2(RString.EMPTY);
                business.set届出年月日星3(RString.EMPTY);
                business.set届出年月日星2(RString.EMPTY);
                business.set居宅介護事業者長取消2(RString.EMPTY);
                business.set居宅介護事業者長取消3(RString.EMPTY);
                business.set居宅介護事業者長星2(RString.EMPTY);
                business.set居宅介護事業者長星3(RString.EMPTY);
            } else {
                chohyoHensu(business);
            }
        }
        if (文字_0.equals(chohyoSeigyoHanyo.get設定値()) && (getNull(parameter.get交付日())
                .isBeforeOrEquals(parameter.get認定有効期間終了年月日() == null ? FlexibleDate.MIN
                        : new FlexibleDate(parameter.get認定有効期間終了年月日().toDateString()))) && 文字_1.equals(chohyoSeigyo.get設定値())) {
            chohyoHensu(business);
        }
    }

    private FlexibleDate getNull(FlexibleDate parameter) {
        if (parameter != null && !parameter.isEmpty()) {
            return parameter;
        }
        return FlexibleDate.MIN;
    }

    private void chohyoHensu(HihokenshashoChoBusiness business) {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo chohyoHensu = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, 帳票分類ID,
                FlexibleDate.getNowDate().getYear(), 居宅支援事業者履歴_表示方法);
        if (文字_0.equals(chohyoHensu.get設定値())) {
            business.set居宅介護事業者取消2(RString.EMPTY);
            business.set居宅介護事業者取消3(RString.EMPTY);
            business.set居宅介護事業者星2(RString.EMPTY);
            business.set居宅介護事業者星3(RString.EMPTY);
            business.set届出年月日取消3(RString.EMPTY);
            business.set届出年月日取消2(RString.EMPTY);
            business.set届出年月日星3(RString.EMPTY);
            business.set届出年月日星2(RString.EMPTY);
            business.set居宅介護事業者長取消2(RString.EMPTY);
            business.set居宅介護事業者長取消3(RString.EMPTY);
            business.set居宅介護事業者長星2(RString.EMPTY);
            business.set居宅介護事業者長星3(RString.EMPTY);
        }
        if (文字_1.equals(chohyoHensu.get設定値())) {
            business.set居宅介護事業者2(RString.EMPTY);
            business.set居宅介護事業者3(RString.EMPTY);
            business.set届出年月日2(RString.EMPTY);
            business.set届出年月日3(RString.EMPTY);
            business.set居宅介護事業者長2(RString.EMPTY);
            business.set居宅介護事業者長3(RString.EMPTY);
            business.set居宅介護事業者取消2(RString.EMPTY);
            business.set居宅介護事業者取消3(RString.EMPTY);
            business.set居宅介護事業者星2(RString.EMPTY);
            business.set居宅介護事業者星3(RString.EMPTY);
            business.set届出年月日取消3(RString.EMPTY);
            business.set届出年月日取消2(RString.EMPTY);
            business.set届出年月日星3(RString.EMPTY);
            business.set届出年月日星2(RString.EMPTY);
            business.set居宅介護事業者長取消2(RString.EMPTY);
            business.set居宅介護事業者長取消3(RString.EMPTY);
            business.set居宅介護事業者長星2(RString.EMPTY);
            business.set居宅介護事業者長星3(RString.EMPTY);
        }
        if (文字_2.equals(chohyoHensu.get設定値())) {
            business.set居宅介護事業者取消2(RString.EMPTY);
            business.set居宅介護事業者取消3(RString.EMPTY);
            business.set居宅介護事業者星2(星アイコン);
            business.set居宅介護事業者星3(星アイコン);
            business.set届出年月日取消3(RString.EMPTY);
            business.set届出年月日取消2(RString.EMPTY);
            business.set届出年月日星3(星アイコン);
            business.set届出年月日星2(星アイコン);
            business.set居宅介護事業者長取消2(RString.EMPTY);
            business.set居宅介護事業者長取消3(RString.EMPTY);
            business.set居宅介護事業者長星2(星アイコン);
            business.set居宅介護事業者長星3(星アイコン);
        }
        if (文字_3.equals(chohyoHensu.get設定値())) {
            business.set居宅介護事業者2(RString.EMPTY);
            business.set居宅介護事業者3(RString.EMPTY);
            business.set届出年月日2(RString.EMPTY);
            business.set届出年月日3(RString.EMPTY);
            business.set居宅介護事業者長2(RString.EMPTY);
            business.set居宅介護事業者長3(RString.EMPTY);
            business.set居宅介護事業者星2(RString.EMPTY);
            business.set居宅介護事業者星3(RString.EMPTY);
            business.set届出年月日星3(RString.EMPTY);
            business.set届出年月日星2(RString.EMPTY);
            business.set居宅介護事業者長星2(RString.EMPTY);
            business.set居宅介護事業者長星3(RString.EMPTY);
        }
    }

    private RString get指定サービス種類(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get指定サービス種類().size()) {
            return parameter.get指定サービス種類().get(連番).get指定サービス種類();
        }
        return RString.EMPTY;
    }

    private RString getサービス種類限度額(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get指定サービス種類().size()) {
            return parameter.get指定サービス種類().get(連番).getサービス種類限度額();
        }
        return RString.EMPTY;
    }

    private RString get給付制限内容(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get適用年月日().size() && !RString.isNullOrEmpty(parameter.get適用年月日().get(連番).get給付制限内容())) {
            return parameter.get適用年月日().get(連番).get給付制限内容();
        }
        return RString.EMPTY;
    }

    private void setサービス種類(HihokenshashoChoBusiness business, HihokenshashoChohyoParameter parameter) {
        business.setサービス種類1(get指定サービス種類(parameter, 桁数_0));
        business.setサービス種類2(get指定サービス種類(parameter, 桁数_1));
        business.setサービス種類3(get指定サービス種類(parameter, 桁数_2));
        business.setサービス種類4(get指定サービス種類(parameter, 桁数_3));
        business.setサービス種類5(get指定サービス種類(parameter, 桁数_4));
        business.setサービス種類6(get指定サービス種類(parameter, 桁数_5));
        business.setサービス種類1つ目の限度額(getサービス種類限度額(parameter, 桁数_0));
        business.setサービス種類2つ目の限度額(getサービス種類限度額(parameter, 桁数_1));
        business.setサービス種類3つ目の限度額(getサービス種類限度額(parameter, 桁数_2));
        business.setサービス種類4つ目の限度額(getサービス種類限度額(parameter, 桁数_3));
        business.setサービス種類5つ目の限度額(getサービス種類限度額(parameter, 桁数_4));
        business.setサービス種類6つ目の限度額(getサービス種類限度額(parameter, 桁数_5));
        if (!RString.isNullOrEmpty(getサービス種類限度額(parameter, 桁数_0))) {
            business.set点数1(単位);
        }
        if (!RString.isNullOrEmpty(getサービス種類限度額(parameter, 桁数_1))) {
            business.set点数2(単位);
        }
        if (!RString.isNullOrEmpty(getサービス種類限度額(parameter, 桁数_2))) {
            business.set点数3(単位);
        }
        if (!RString.isNullOrEmpty(getサービス種類限度額(parameter, 桁数_3))) {
            business.set点数4(単位);
        }
        if (!RString.isNullOrEmpty(getサービス種類限度額(parameter, 桁数_4))) {
            business.set点数5(単位);
        }
        if (!RString.isNullOrEmpty(getサービス種類限度額(parameter, 桁数_5))) {
            business.set点数6(単位);
        }
        business.set認定審査会意見等(parameter.get介護認定審査会意見());
        business.set再交付2(RString.EMPTY);
        if (!RString.isNullOrEmpty(get給付制限内容(parameter, 桁数_0))) {
            if (parameter.get適用年月日().get(桁数_0).get給付制限内容().length() <= 文字数_8) {
                business.set給付制限1(parameter.get適用年月日().get(桁数_0).get給付制限内容().substring(桁数_0, 桁数_4));
                business.set給付制限2(parameter.get適用年月日().get(桁数_0).get給付制限内容().substring(桁数_4));
            } else {
                business.set給付制限長1(parameter.get適用年月日().get(桁数_0).get給付制限内容().substring(桁数_0, 桁数_6));
                business.set給付制限長2(parameter.get適用年月日().get(桁数_0).get給付制限内容().substring(桁数_6));
            }
        }
        if (!RString.isNullOrEmpty(get給付制限内容(parameter, 桁数_1))) {
            if (parameter.get適用年月日().get(桁数_1).get給付制限内容().length() <= 文字数_8) {
                business.set給付制限3(parameter.get適用年月日().get(桁数_1).get給付制限内容().substring(桁数_0, 桁数_4));
                business.set給付制限4(parameter.get適用年月日().get(桁数_1).get給付制限内容().substring(桁数_4));
            } else {
                business.set給付制限長3(parameter.get適用年月日().get(桁数_1).get給付制限内容().substring(桁数_0, 桁数_6));
                business.set給付制限長4(parameter.get適用年月日().get(桁数_1).get給付制限内容().substring(桁数_6));
            }
        }
        if (!RString.isNullOrEmpty(get給付制限内容(parameter, 桁数_2))) {
            if (parameter.get適用年月日().get(桁数_2).get給付制限内容().length() <= 文字数_8) {
                business.set給付制限5(parameter.get適用年月日().get(桁数_2).get給付制限内容().substring(桁数_0, 桁数_4));
                business.set給付制限6(parameter.get適用年月日().get(桁数_2).get給付制限内容().substring(桁数_4));
            } else {
                business.set給付制限長5(parameter.get適用年月日().get(桁数_2).get給付制限内容().substring(桁数_0, 桁数_6));
                business.set給付制限長6(parameter.get適用年月日().get(桁数_2).get給付制限内容().substring(桁数_6));
            }
        }
        business.set給付制限開始年月日1(get適用開始年月日(parameter, 桁数_0));
        business.set給付制限開始年月日2(get適用開始年月日(parameter, 桁数_1));
        business.set給付制限開始年月日3(get適用開始年月日(parameter, 桁数_2));
        business.set給付制限終了年月日1(get適用終了年月日(parameter, 桁数_0));
        business.set給付制限終了年月日2(get適用終了年月日(parameter, 桁数_1));
        business.set給付制限終了年月日3(get適用終了年月日(parameter, 桁数_2));
    }

    private RString get適用終了年月日(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get適用年月日().size() && parameter.get適用年月日().get(連番).get適用終了年月日() != null) {
            return parameter.get適用年月日().get(連番).get適用終了年月日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get適用開始年月日(HihokenshashoChohyoParameter parameter, int 連番) {
        if (連番 < parameter.get適用年月日().size() && parameter.get適用年月日().get(連番).get適用開始年月日() != null) {
            return parameter.get適用年月日().get(連番).get適用開始年月日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private void set生年月日(HihokenshashoChoBusiness business, HonninJohoEntity entity) {
        if (住民種別コード2.equals(entity.getJuminShubetsuCode()) || 住民種別コード4.equals(entity.getJuminShubetsuCode())) {
            if (DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)
                    .equals(GaikokujinSeinengappiHyojihoho.西暦表示.getコード())) {
                business.set西暦年(entity.getSeinengappiYMD().seireki()
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear());
                business.set月(entity.getSeinengappiYMD().seireki()
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth());
                business.set日(entity.getSeinengappiYMD().seireki()
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).getDay());
                business.set明治(星アイコン);
                business.set大正(星アイコン);
                business.set昭和(星アイコン);
            }
            if (DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)
                    .equals(GaikokujinSeinengappiHyojihoho.和暦表示.getコード())
                    && FALSE.equals(entity.getSeinengappiFushoKubun())) {
                business.set年号(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getEra());
                business.set和暦年(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear());
                business.set月(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth());
                business.set日(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getDay());
                business.set明治(星アイコン);
                business.set大正(星アイコン);
            }
            if (DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)
                    .equals(GaikokujinSeinengappiHyojihoho.和暦表示.getコード())
                    && TRUE.equals(entity.getSeinengappiFushoKubun())) {
                business.set年号(RString.EMPTY);
                business.set和暦年(RString.EMPTY);
                business.set西暦年(RString.EMPTY);
                business.set月(RString.EMPTY);
                business.set日(RString.EMPTY);
            }
        }
        if (住民種別コード1.equals(entity.getJuminShubetsuCode()) || 住民種別コード3.equals(entity.getJuminShubetsuCode())) {
            business.set明治(星アイコン);
            business.set大正(星アイコン);
            business.set年号(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getEra());
            business.set和暦年(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getYear());
            business.set月(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getMonth());
            business.set日(entity.getSeinengappiYMD().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).getDay());
        }
        business.set生年月日(new RString(entity.getSeinengappiYMD().toString()));
        if (性別1.equals(entity.getSeibetsuCode())) {
            business.set男(星アイコン);
            business.set性別(男);
            business.set構成性別2(男);
        }
        if (性別2.equals(entity.getSeibetsuCode())) {
            business.set女(星アイコン);
            business.set性別(女);
            business.set構成性別2(女);
        }
        business.set再交付(RString.EMPTY);
        business.set有効期間波線(波線);
        business.setサービス単位(月1あたり);
        business.set点数(単位);
    }

    private List<HonninJohoEntity> get本人情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        key.set住民種別(住民種別);
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        key.set住民状態(住民状態);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        AtenaMybatisParameter parameter = new AtenaMybatisParameter(new RString(uaFt200Psm.getParameterMap()
                .get(PSMYO.toString()).toString()), RString.EMPTY);
        IHihokenshashoChohyoMapper mapper = mapperProvider.create(IHihokenshashoChohyoMapper.class);
        return mapper.get本人情報取得(parameter);
    }

    private List<SofusakiJohoEntity> get送付先情報(ShikibetsuCode 識別コード) {
        AtesakiPSMSearchKeyBuilder apsmskb = new AtesakiPSMSearchKeyBuilder(AtesakiGyomuHanteiKeyFactory
                .createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBU介護統計報告));
        apsmskb.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用する);
        apsmskb.set識別コード(識別コード);
        apsmskb.set基準日(FlexibleDate.getNowDate());
        apsmskb.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        apsmskb.set代納人利用区分(DainoRiyoKubun.利用しない);
        apsmskb.set送付先利用区分(SofusakiRiyoKubun.利用する);
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(apsmskb.build());
        AtenaMybatisParameter parameter = new AtenaMybatisParameter(RString.EMPTY, new RString(uaFt250Psm.getParameterMap()
                .get(PSMWM.toString()).toString()));
        IHihokenshashoChohyoMapper mapper = mapperProvider.create(IHihokenshashoChohyoMapper.class);
        List<SofusakiJohoEntity> entity = mapper.get送付先情報取得(parameter);
        List<SofusakiJohoEntity> list = new ArrayList<>();
        for (SofusakiJohoEntity sofu : entity) {
            if (文字_2.equals(sofu.getAtesakiShubetsu())) {
                list.add(sofu);
            }
        }
        return list;
    }
}
