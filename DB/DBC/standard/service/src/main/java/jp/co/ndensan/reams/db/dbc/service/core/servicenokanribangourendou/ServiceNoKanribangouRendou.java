/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.servicenokanribangourendou;

import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicenokanribangourendou.JigyouKetteiTutisyoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.JigyouKetteiTutisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.ServiceNoKanribangouRendouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicenokanribangourendou.IServiceNoKanribangouRendouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.IKozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 新総合事業・事業高額決定通知書（単）のビジネスクラスです。
 *
 * @reamsid_L DBC-4760-050 cuilin
 */
public class ServiceNoKanribangouRendou {

    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private static final ReportId 帳票分類ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString 取り消し線ない = new RString("0");
    private static final RString 取り消し線あり = new RString("1");
    private static final RString ﾀｲﾄﾙ_2_1 = new RString("総合事業高額介護（予防）サービス費");
    private static final RString ﾀｲﾄﾙ_3_1 = new RString("総合事業高額介護（予防）サービス費");
    private static final RString 括弧全角_L = new RString("（");
    private static final RString 括弧全角_R = new RString("）");
    private static final RString 定値_決定通知書 = new RString("決定通知書");
    private static final RString 定値_決定通知書調整用 = new RString("決定通知書　調整用");
    private static final RString 定値_0 = new RString("0");
    private static final RString 定値_1 = new RString("1");
    private static final RString 定値_2 = new RString("2");
    private static final RString 定値_3 = new RString("3");
    private static final RString 定値_4 = new RString("4");
    private static final RString 全角のコンマ = new RString("，");
    private static final RString 定値_する = new RString("する");
    private static final RString 定値_しない = new RString("しない");
    private static final RString 定値_支給金額 = new RString("支給金額");
    private static final RString 定値_決定額 = new RString("決定額");
    private static final RString 定値_増減の理由 = new RString("増減の理由");
    private static final RString 定値_不支給の理由 = new RString("不支給の理由");
    private static final RString 定値_アスタリスク１２桁 = new RString("************");
    private static final RString 定値_アスタリスク１４桁 = new RString("**************");
    private static final RString 定値_持ち物内容文言１ = new RString("持ち物内容文言１");
    private static final RString 定値_持ち物内容文言２ = new RString("持ち物内容文言２");
    private static final RString 定値_持ち物内容文言３ = new RString("持ち物内容文言３");
    private static final RString 定値_曲線 = new RString("～");
    private static final RString 午前 = new RString("午前");
    private static final RString 午後 = new RString("午後");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString RSTRING_12 = new RString("12");
    private static final RString RSTRING_9900 = new RString("9900");
    private static final RString 定値_口座種別 = new RString("口座種別");
    private static final RString 定値_口座番号 = new RString("口座番号");
    private static final RString 定値_店番 = new RString("店番");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_13 = 13;
    private static final int NUM_14 = 14;
    private static final int NUM_21 = 21;
    private static final int NUM_22 = 22;
    private static final int NUM_23 = 23;
    private static final int NUM_24 = 24;
    private static final int NUM_30 = 30;
    private static final int NUM_38 = 38;
    private static final int NUM_76 = 76;
    private static final int NUM_114 = 114;
    private static final char ZERO = '0';

    /**
     * コンストラクタです
     */
    public ServiceNoKanribangouRendou() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 帳票制御共通Dac DbT7065ChohyoSeigyoKyotsuDac
     * @param 帳票制御汎用Dac DbT7067ChohyoSeigyoHanyoDac
     */
    ServiceNoKanribangouRendou(MapperProvider mapperProvider,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac,
            DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.mapperProvider = mapperProvider;
        this.帳票制御共通Dac = 帳票制御共通Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ServiceNoKanribangouRendou}のインスタンスを返します。
     *
     * @return ServiceNoKanribangouRendou
     */
    public static ServiceNoKanribangouRendou createInstance() {
        return InstanceProvider.create(ServiceNoKanribangouRendou.class);
    }

    /**
     * 決定通知書データ作成のメソッドです。
     *
     * @param 文書番号 RString
     * @param 発行日 FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 様式 RString
     * @param 履歴番号 int
     * @param 識別コード ShikibetsuCode
     * @param 支払予定日 FlexibleDate
     * @param 証記載保険者番号 HokenshaNo
     * @param 氏名 RString
     * @return JigyouKetteiTutisyoResult
     */
    public JigyouKetteiTutisyoResult selectKougakuJigyouKetteiTutisyo(RString 文書番号,
            FlexibleDate 発行日,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 様式,
            int 履歴番号,
            ShikibetsuCode 識別コード,
            FlexibleDate 支払予定日,
            HokenshaNo 証記載保険者番号,
            RString 氏名) {
        JigyouKetteiTutisyoEntity 決定通知書Entity = new JigyouKetteiTutisyoEntity();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票分類ID);

        set送付物宛先(決定通知書Entity, 地方公共団体, 帳票制御共通, 識別コード);

        IServiceNoKanribangouRendouMapper mapper = mapperProvider.create(IServiceNoKanribangouRendouMapper.class);
        JigyouKetteiTutisyoParameter param = JigyouKetteiTutisyoParameter.createParam(被保険者番号,
                サービス提供年月, 履歴番号, 証記載保険者番号);
        ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報 = mapper.get事業高額介護サービス費支給情報(param);
        setﾀｲﾄﾙ(決定通知書Entity, 事業高額介護サービス費支給情報);

        決定通知書Entity.set文書番号(文書番号);
        決定通知書Entity.set作成年月日(発行日 == null || 発行日.isEmpty() ? RString.EMPTY : 発行日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        決定通知書Entity.set被保険者氏名(氏名 == null ? RString.EMPTY
                : (氏名.length() <= NUM_30 ? 氏名 : 氏名.substring(1, NUM_30)));
        決定通知書Entity.set対象年月(サービス提供年月 == null || サービス提供年月.isEmpty() ? RString.EMPTY
                : サービス提供年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        set被保険者番号(決定通知書Entity, 被保険者番号);
        if (事業高額介護サービス費支給情報 != null) {
            if (定値_0.equals(様式) && 事業高額介護サービス費支給情報.get受付年月日() != null
                    && !事業高額介護サービス費支給情報.get受付年月日().isEmpty()) {
                決定通知書Entity.set受付年月日(事業高額介護サービス費支給情報.get受付年月日().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            } else if (定値_1.equals(様式)) {
                決定通知書Entity.set受付年月日(RString.EMPTY);
            }
            決定通知書Entity.set決定年月日(事業高額介護サービス費支給情報.get決定年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            if (事業高額介護サービス費支給情報.get本人支払額() != null) {
                決定通知書Entity.set本人支払額(toDecimal(事業高額介護サービス費支給情報.get本人支払額()));
            }
            set給付の種類(決定通知書Entity, 事業高額介護サービス費支給情報.get審査方法区分(), param);
            if (ShikyuKubun.支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())) {
                決定通知書Entity.set支給(定値_する);
                決定通知書Entity.set理由ﾀｲﾄﾙ(定値_増減の理由);
            } else {
                決定通知書Entity.set支給(定値_しない);
                決定通知書Entity.set理由ﾀｲﾄﾙ(定値_不支給の理由);
            }
            if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0) {
                決定通知書Entity.set支給金額ﾀｲﾄﾙ(定値_支給金額);
            } else {
                決定通知書Entity.set支給金額ﾀｲﾄﾙ(定値_決定額);
            }
            決定通知書Entity.set支給金額(toDecimal(事業高額介護サービス費支給情報.get支給金額()));
            決定通知書Entity.set通知書番号(事業高額介護サービス費支給情報.get通知書番号());

            set理由(決定通知書Entity, 事業高額介護サービス費支給情報.get不支給理由());
            set取消(決定通知書Entity, 事業高額介護サービス費支給情報);
            set窓口払い_口座払い(決定通知書Entity, 事業高額介護サービス費支給情報, 識別コード, 支払予定日);
            set問い合わせ文言(決定通知書Entity, 様式, 事業高額介護サービス費支給情報);
        } else {
            決定通知書Entity.set支給(定値_しない);
            決定通知書Entity.set支給金額ﾀｲﾄﾙ(定値_決定額);
            決定通知書Entity.set理由ﾀｲﾄﾙ(定値_不支給の理由);
        }
        決定通知書Entity.set連番(RString.EMPTY);
        RString 窓口項目見出し制御 = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_窓口項目見出し制御,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (定値_1.equals(窓口項目見出し制御)) {
            決定通知書Entity.set持ち物1_取り消し用(定値_アスタリスク１２桁);
            決定通知書Entity.set持ち物2_取り消し用(定値_アスタリスク１２桁);
            決定通知書Entity.set支払場所_取り消し用(定値_アスタリスク１２桁);
            決定通知書Entity.set支払期間_取り消し用(定値_アスタリスク１２桁);
        }
        JigyouKetteiTutisyoResult result = new JigyouKetteiTutisyoResult();
        result.set決定通知書Entity(決定通知書Entity);
        return result;
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類ID) throws NullPointerException {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類ID.toString()));
        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    private ChohyoSeigyoHanyo load帳票制御汎用(ReportId 帳票分類ID, RString 項目名) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類ID.toString()));
        DbT7067ChohyoSeigyoHanyoEntity entity = 帳票制御汎用Dac.get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票分類ID, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    private void set送付物宛先(JigyouKetteiTutisyoEntity 決定通知書Entity, Association 地方公共団体,
            ChohyoSeigyoKyotsu 帳票制御共通, ShikibetsuCode 識別コード) {
        IAtesakiGyomuHanteiKey 宛先業務判定キー
                = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        IAtesakiPSMSearchKey searchKey = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー)
                .set識別コード(識別コード)
                .set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない)
                .set送付先利用区分(SofusakiRiyoKubun.利用する).build();
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(searchKey);

        if (宛先 != null) {
            EditedAtesaki 編集後宛先 = EditedAtesakiBuilder.create編集後宛先(宛先, 地方公共団体, 帳票制御共通);
            SofubutsuAtesakiSource 送付物宛先 = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
            決定通知書Entity.set郵便番号(送付物宛先.yubinNo);
            決定通知書Entity.set行政区(送付物宛先.gyoseiku);
            決定通知書Entity.set住所１(送付物宛先.jusho1);
            決定通知書Entity.set住所２(送付物宛先.jusho2);
            決定通知書Entity.set住所３(送付物宛先.jusho3);
            決定通知書Entity.set住所(送付物宛先.jushoText);
            決定通知書Entity.set方書１(送付物宛先.katagaki1);
            決定通知書Entity.set方書２(送付物宛先.katagaki2);
            決定通知書Entity.set方書小1(送付物宛先.katagakiSmall1);
            決定通知書Entity.set方書小2(送付物宛先.katagakiSmall2);
            決定通知書Entity.set方書(送付物宛先.katagakiText);
            決定通知書Entity.set氏名1(送付物宛先.shimei1);
            決定通知書Entity.set氏名2(送付物宛先.shimei2);
            決定通知書Entity.set小氏名1(送付物宛先.shimeiSmall1);
            決定通知書Entity.set小氏名2(送付物宛先.shimeiSmall2);
            決定通知書Entity.set氏名(送付物宛先.shimeiText);
            決定通知書Entity.set名称付与1(送付物宛先.meishoFuyo1);
            決定通知書Entity.set名称付与2(送付物宛先.meishoFuyo2);
            決定通知書Entity.set代納区分名(送付物宛先.dainoKubunMei);
            決定通知書Entity.set様文1(送付物宛先.samaBun1);
            決定通知書Entity.set様文2(送付物宛先.samaBun2);
            決定通知書Entity.set様文氏名1(送付物宛先.samabunShimei1);
            決定通知書Entity.set様文氏名2(送付物宛先.samabunShimei2);
            決定通知書Entity.set小様文氏名1(送付物宛先.samabunShimeiSmall1);
            決定通知書Entity.set小様文氏名2(送付物宛先.samabunShimeiSmall2);
            決定通知書Entity.set様文氏名(送付物宛先.samabunShimeiText);
            決定通知書Entity.set左括弧1(送付物宛先.kakkoLeft1);
            決定通知書Entity.set左括弧2(送付物宛先.kakkoLeft2);
            決定通知書Entity.set右括弧1(送付物宛先.kakkoRight1);
            決定通知書Entity.set右括弧2(送付物宛先.kakkoRight2);
            決定通知書Entity.setカスタマバーコード(送付物宛先.customerBarCode);
        }
    }

    private void setﾀｲﾄﾙ(JigyouKetteiTutisyoEntity 決定通知書Entity, ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        RString 取り消し線 = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_取り消し線,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (取り消し線あり.equals(取り消し線) && 事業高額介護サービス費支給情報 != null) {
            if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0) {
                決定通知書Entity.setﾀｲﾄﾙ_2_1_取消し線用(ﾀｲﾄﾙ_2_1);
                setﾀｲﾄﾙ_取消し線用(決定通知書Entity, 事業高額介護サービス費支給情報);
            } else if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) > 0) {
                決定通知書Entity.setﾀｲﾄﾙ_3_1_取消し線用_調整用(ﾀｲﾄﾙ_3_1);
                setﾀｲﾄﾙ_取消し線用_調整用(決定通知書Entity, 事業高額介護サービス費支給情報);
            }
        } else if (取り消し線ない.equals(取り消し線)) {
            RString ﾀｲﾄﾙ = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_DF6101, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            決定通知書Entity.setﾀｲﾄﾙ(ﾀｲﾄﾙ);
        }
    }

    private void set被保険者番号(JigyouKetteiTutisyoEntity 決定通知書Entity, HihokenshaNo 被保険者番号) {
        if (被保険者番号 != null) {
            決定通知書Entity.set被保険者番号１(被保険者番号.getColumnValue().substring(0, NUM_1));
            決定通知書Entity.set被保険者番号２(被保険者番号.getColumnValue().length() < NUM_2 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_1, NUM_2));
            決定通知書Entity.set被保険者番号３(被保険者番号.getColumnValue().length() < NUM_3 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_2, NUM_3));
            決定通知書Entity.set被保険者番号４(被保険者番号.getColumnValue().length() < NUM_4 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_3, NUM_4));
            決定通知書Entity.set被保険者番号５(被保険者番号.getColumnValue().length() < NUM_5 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_4, NUM_5));
            決定通知書Entity.set被保険者番号６(被保険者番号.getColumnValue().length() < NUM_6 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_5, NUM_6));
            決定通知書Entity.set被保険者番号７(被保険者番号.getColumnValue().length() < NUM_7 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_6, NUM_7));
            決定通知書Entity.set被保険者番号８(被保険者番号.getColumnValue().length() < NUM_8 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_7, NUM_8));
            決定通知書Entity.set被保険者番号９(被保険者番号.getColumnValue().length() < NUM_9 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_8, NUM_9));
            決定通知書Entity.set被保険者番号１０(被保険者番号.getColumnValue().length() < NUM_10 ? RString.EMPTY
                    : 被保険者番号.getColumnValue().substring(NUM_9, NUM_10));
        }
    }

    private void set給付の種類(JigyouKetteiTutisyoEntity 決定通知書Entity,
            RString 審査方法区分, JigyouKetteiTutisyoParameter param) {
        if (!ShinsaHohoKubun.審査依頼.getコード().equals(審査方法区分)) {
            決定通知書Entity.set給付の種類１(RString.EMPTY);
            決定通知書Entity.set給付の種類２(RString.EMPTY);
            決定通知書Entity.set給付の種類３(RString.EMPTY);
            return;
        }
        IServiceNoKanribangouRendouMapper mapper = mapperProvider.create(IServiceNoKanribangouRendouMapper.class);
        List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> 対象者明細 = mapper.get対象者明細情報(param);
        if (対象者明細 == null || 対象者明細.isEmpty()) {
            決定通知書Entity.set給付の種類１(RString.EMPTY);
            決定通知書Entity.set給付の種類２(RString.EMPTY);
            決定通知書Entity.set給付の種類３(RString.EMPTY);
            return;
        }
        RString 給付の種類 = RString.EMPTY;
        boolean isFirst = true;
        for (DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity : 対象者明細) {
            if (isFirst) {
                給付の種類 = 給付の種類.concat(ServiceCategoryShurui.toValue(entity.getServiceShuruiCode().getColumnValue()).get略称());
                isFirst = false;
            } else {
                給付の種類 = 給付の種類.concat(全角のコンマ)
                        .concat(ServiceCategoryShurui.toValue(entity.getServiceShuruiCode().getColumnValue()).get略称());
            }
        }
        if (給付の種類.length() <= NUM_38) {
            決定通知書Entity.set給付の種類１(給付の種類);
            決定通知書Entity.set給付の種類２(RString.EMPTY);
            決定通知書Entity.set給付の種類３(RString.EMPTY);
        } else {
            決定通知書Entity.set給付の種類１(給付の種類.substring(0, NUM_38));
            if (給付の種類.length() <= NUM_76) {
                決定通知書Entity.set給付の種類２(給付の種類.substring(NUM_38, 給付の種類.length()));
                決定通知書Entity.set給付の種類３(RString.EMPTY);
            } else {
                決定通知書Entity.set給付の種類２(給付の種類.substring(NUM_38, NUM_76));
                決定通知書Entity.set給付の種類３(給付の種類.length() <= NUM_114
                        ? 給付の種類.substring(NUM_76, 給付の種類.length()) : 給付の種類.substring(NUM_76, NUM_114));
            }
        }
    }

    private void set理由(JigyouKetteiTutisyoEntity 決定通知書Entity, RString 不支給理由) {
        if (RString.isNullOrEmpty(不支給理由)) {
            決定通知書Entity.set理由１(RString.EMPTY);
            決定通知書Entity.set理由２(RString.EMPTY);
            決定通知書Entity.set理由３(RString.EMPTY);
            return;
        }
        if (不支給理由.length() <= NUM_38) {
            決定通知書Entity.set理由１(不支給理由);
            決定通知書Entity.set理由２(RString.EMPTY);
            決定通知書Entity.set理由３(RString.EMPTY);
        } else {
            決定通知書Entity.set理由１(不支給理由.substring(0, NUM_38));
            if (不支給理由.length() <= NUM_76) {
                決定通知書Entity.set理由２(不支給理由.substring(NUM_38, 不支給理由.length()));
                決定通知書Entity.set理由３(RString.EMPTY);
            } else {
                決定通知書Entity.set理由２(不支給理由.substring(NUM_38, NUM_76));
                決定通知書Entity.set理由３(不支給理由.length() <= NUM_114
                        ? 不支給理由.substring(NUM_76, 不支給理由.length()) : 不支給理由.substring(NUM_76, NUM_114));
            }
        }
    }

    private void set取消(JigyouKetteiTutisyoEntity 決定通知書Entity, ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0
                && ShikyuKubun.支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())
                && ShiharaiHohoKubun.窓口払.getコード().equals(事業高額介護サービス費支給情報.get支払方法区分コード())) {
            決定通知書Entity.set取消１(RString.EMPTY);
            決定通知書Entity.set取消２(定値_アスタリスク１４桁);
        } else if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0
                && ShikyuKubun.支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())
                && ShiharaiHohoKubun.口座払.getコード().equals(事業高額介護サービス費支給情報.get支払方法区分コード())) {
            決定通知書Entity.set取消１(定値_アスタリスク１４桁);
            決定通知書Entity.set取消２(RString.EMPTY);
        } else if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0
                && ShikyuKubun.不支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())) {
            決定通知書Entity.set取消１(定値_アスタリスク１４桁);
            決定通知書Entity.set取消２(定値_アスタリスク１４桁);
        } else if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) > 0) {
            決定通知書Entity.set取消１(定値_アスタリスク１４桁);
            決定通知書Entity.set取消２(定値_アスタリスク１４桁);
        }
    }

    private void set窓口払い_口座払い(JigyouKetteiTutisyoEntity 決定通知書Entity,
            ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報, ShikibetsuCode 識別コード, FlexibleDate 支払予定日) {
        if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0
                && ShikyuKubun.支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())
                && ShiharaiHohoKubun.窓口払.getコード().equals(事業高額介護サービス費支給情報.get支払方法区分コード())) {
            set窓口払い(決定通知書Entity, 事業高額介護サービス費支給情報);
        } else if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0
                && ShikyuKubun.支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())
                && ShiharaiHohoKubun.口座払.getコード().equals(事業高額介護サービス費支給情報.get支払方法区分コード())) {
            set口座払い(決定通知書Entity, 識別コード, 支払予定日, 事業高額介護サービス費支給情報);
        } else {
            決定通知書Entity.set金融機関名(RString.EMPTY);
            決定通知書Entity.set金融機関支店名(RString.EMPTY);
            決定通知書Entity.set口座種別(RString.EMPTY);
            決定通知書Entity.set口座番号(RString.EMPTY);
            決定通知書Entity.set口座名義人(RString.EMPTY);
            決定通知書Entity.set支払予定日(RString.EMPTY);
            決定通知書Entity.set持物１(RString.EMPTY);
            決定通知書Entity.set持物２(RString.EMPTY);
            決定通知書Entity.set持物３(RString.EMPTY);
            決定通知書Entity.set支払場所(RString.EMPTY);
            決定通知書Entity.set支払期間開始年月日(RString.EMPTY);
            決定通知書Entity.set支払期間終了年月日(RString.EMPTY);
            決定通知書Entity.set支払期間開始時間(RString.EMPTY);
            決定通知書Entity.set支払期間_２(RString.EMPTY);
            決定通知書Entity.set支払期間終了時間(RString.EMPTY);
            決定通知書Entity.set種目ﾀｲﾄﾙ(定値_口座種別);
            決定通知書Entity.set番号ﾀｲﾄﾙ(定値_口座番号);
        }
    }

    private void set窓口払い(JigyouKetteiTutisyoEntity 決定通知書Entity,
            ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        ChohyoSeigyoHanyo 帳票制御汎用_持物１ = load帳票制御汎用(帳票分類ID, 定値_持ち物内容文言１);
        if (帳票制御汎用_持物１ != null) {
            決定通知書Entity.set持物１(帳票制御汎用_持物１.get設定値());
        }
        ChohyoSeigyoHanyo 帳票制御汎用_持物２ = load帳票制御汎用(帳票分類ID, 定値_持ち物内容文言２);
        if (帳票制御汎用_持物２ != null) {
            決定通知書Entity.set持物２(帳票制御汎用_持物２.get設定値());
        }
        ChohyoSeigyoHanyo 帳票制御汎用_持物３ = load帳票制御汎用(帳票分類ID, 定値_持ち物内容文言３);
        if (帳票制御汎用_持物３ != null) {
            決定通知書Entity.set持物３(帳票制御汎用_持物３.get設定値());
        }
        決定通知書Entity.set支払場所(事業高額介護サービス費支給情報.get支払場所());
        if (事業高額介護サービス費支給情報.get支払期間開始年月日() != null
                && !事業高額介護サービス費支給情報.get支払期間開始年月日().isEmpty()) {
            決定通知書Entity.set支払期間開始年月日(formatDate(事業高額介護サービス費支給情報.get支払期間開始年月日()).concat(定値_曲線));
        } else if (事業高額介護サービス費支給情報.get支払期間終了年月日() != null
                && !事業高額介護サービス費支給情報.get支払期間終了年月日().isEmpty()) {
            決定通知書Entity.set支払期間開始年月日(formatDate(事業高額介護サービス費支給情報.get支払期間終了年月日()));
        }
        if (事業高額介護サービス費支給情報.get支払期間終了年月日() != null
                && !事業高額介護サービス費支給情報.get支払期間終了年月日().isEmpty()) {
            決定通知書Entity.set支払期間終了年月日(formatDate(事業高額介護サービス費支給情報.get支払期間終了年月日()));
        }
        決定通知書Entity.set支払期間開始時間(set時間(事業高額介護サービス費支給情報.get支払窓口開始時間()));
        決定通知書Entity.set支払期間_２(定値_曲線);
        決定通知書Entity.set支払期間終了時間(set時間(事業高額介護サービス費支給情報.get支払窓口終了時間()));
        決定通知書Entity.set金融機関名(RString.EMPTY);
        決定通知書Entity.set金融機関支店名(RString.EMPTY);
        決定通知書Entity.set口座種別(RString.EMPTY);
        決定通知書Entity.set口座番号(RString.EMPTY);
        決定通知書Entity.set口座名義人(RString.EMPTY);
        決定通知書Entity.set支払予定日(RString.EMPTY);
        決定通知書Entity.set種目ﾀｲﾄﾙ(定値_口座種別);
        決定通知書Entity.set番号ﾀｲﾄﾙ(定値_口座番号);
    }

    private void set口座払い(JigyouKetteiTutisyoEntity 決定通知書Entity, ShikibetsuCode 識別コード, FlexibleDate 支払予定日,
            ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        RString マスクフラグ = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_口座マスク,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);

        IKoza 口座 = null;
        IKozaManager iKozaManager = KozaService.createKozaManager();
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set口座ID(事業高額介護サービス費支給情報.get口座ID())
                .set識別コード(識別コード)
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付).build();
        if (定値_1.equals(マスクフラグ)) {
            口座 = iKozaManager.getマスク済口座(searchKey).isEmpty() ? null : iKozaManager.getマスク済口座(searchKey).get(0);
        } else if (定値_0.equals(マスクフラグ)) {
            口座 = iKozaManager.get口座(searchKey).isEmpty() ? null : iKozaManager.get口座(searchKey).get(0);
        }
        if (口座 != null) {
            決定通知書Entity.set金融機関名(口座.get金融機関() == null ? RString.EMPTY : 口座.get金融機関().get金融機関名称());
            決定通知書Entity.set金融機関支店名(口座.get支店() == null ? RString.EMPTY : 口座.get支店().get支店名称());
            if (口座.get金融機関コード() != null && RSTRING_9900.equals(口座.get金融機関コード().value().substring(1, NUM_4))) {
                決定通知書Entity.set種目ﾀｲﾄﾙ(定値_店番);
            } else {
                決定通知書Entity.set種目ﾀｲﾄﾙ(定値_口座種別);
            }
            決定通知書Entity.set口座種別(口座.get預金種別() == null ? RString.EMPTY : 口座.get預金種別().get預金種別略称());
            決定通知書Entity.set番号ﾀｲﾄﾙ(定値_口座番号);
            決定通知書Entity.set口座番号(口座.get口座番号());
            決定通知書Entity.set口座名義人(口座.get口座名義人() == null ? RString.EMPTY : 口座.get口座名義人().getColumnValue());
            RString 印字有無 = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_支払予定日印字有無,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            if (定値_1.equals(印字有無)
                    || ShiharaiHohoKubun.窓口払.getコード().equals(事業高額介護サービス費支給情報.get支払方法区分コード())) {
                決定通知書Entity.set支払予定日(支払予定日 == null || 支払予定日.isEmpty() ? RString.EMPTY
                        : 支払予定日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString());
            }
        }
        決定通知書Entity.set持物１(RString.EMPTY);
        決定通知書Entity.set持物２(RString.EMPTY);
        決定通知書Entity.set持物３(RString.EMPTY);
        決定通知書Entity.set支払場所(RString.EMPTY);
        決定通知書Entity.set支払期間開始年月日(RString.EMPTY);
        決定通知書Entity.set支払期間終了年月日(RString.EMPTY);
        決定通知書Entity.set支払期間開始時間(RString.EMPTY);
        決定通知書Entity.set支払期間_２(RString.EMPTY);
        決定通知書Entity.set支払期間終了時間(RString.EMPTY);
    }

    private void set問い合わせ文言(JigyouKetteiTutisyoEntity 決定通知書Entity, RString 様式,
            ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        RString 帳票文言様式 = DbBusinessConfig.get(ConfigNameDBC.事業高額決定通知書_帳票文言様式,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (定値_0.equals(様式)) {
            set初回申請用(決定通知書Entity, 帳票文言様式, 事業高額介護サービス費支給情報);
        } else if (定値_1.equals(様式)) {
            set自動償還用(決定通知書Entity, 帳票文言様式);
        }
    }

    private void set初回申請用(JigyouKetteiTutisyoEntity 決定通知書Entity, RString 帳票文言様式,
            ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) <= 0
                || ShikyuKubun.不支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())) {
            Map<Integer, RString> レイヤ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_1);
            決定通知書Entity.set文言1(レイヤ.get(0));
            決定通知書Entity.set文言2(レイヤ.get(NUM_1));
            if (定値_1.equals(帳票文言様式)) {
                決定通知書Entity.set通知文1(レイヤ.get(NUM_2));
            } else if (定値_2.equals(帳票文言様式)) {
                Map<Integer, RString> レイヤ大 = ReportUtil
                        .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_2);
                決定通知書Entity.set通知文2大(レイヤ大.get(NUM_2));
            } else if (定値_3.equals(帳票文言様式)) {
                Map<Integer, RString> レイヤ混在 = ReportUtil
                        .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_3);
                決定通知書Entity.set通知文3_上小(レイヤ混在.get(NUM_2));
                決定通知書Entity.set通知文4_下大(レイヤ混在.get(NUM_3));
            } else if (定値_4.equals(帳票文言様式)) {
                Map<Integer, RString> レイヤ混在2 = ReportUtil
                        .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_4);
                決定通知書Entity.set通知文5_上大(レイヤ混在2.get(NUM_2));
                決定通知書Entity.set通知文6_下小(レイヤ混在2.get(NUM_3));
            }
        } else if (Decimal.ZERO.compareTo(nullToZero(事業高額介護サービス費支給情報.get支給金額())) > 0
                && ShikyuKubun.不支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())) {
            Map<Integer, RString> レイヤ = ReportUtil
                    .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_11);
            決定通知書Entity.set文言1(レイヤ.get(0));
            決定通知書Entity.set文言2(レイヤ.get(NUM_1));
            if (定値_1.equals(帳票文言様式)) {
                決定通知書Entity.set通知文1(レイヤ.get(NUM_2));
            } else if (定値_2.equals(帳票文言様式)) {
                Map<Integer, RString> レイヤ大 = ReportUtil
                        .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_12);
                決定通知書Entity.set通知文2大(レイヤ大.get(NUM_2));
            } else if (定値_3.equals(帳票文言様式)) {
                Map<Integer, RString> レイヤ混在 = ReportUtil
                        .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_13);
                決定通知書Entity.set通知文3_上小(レイヤ混在.get(NUM_2));
                決定通知書Entity.set通知文4_下大(レイヤ混在.get(NUM_3));
            } else if (定値_4.equals(帳票文言様式)) {
                Map<Integer, RString> レイヤ混在2 = ReportUtil
                        .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_14);
                決定通知書Entity.set通知文5_上大(レイヤ混在2.get(NUM_2));
                決定通知書Entity.set通知文6_下小(レイヤ混在2.get(NUM_3));
            }
        }
    }

    private void set自動償還用(JigyouKetteiTutisyoEntity 決定通知書Entity, RString 帳票文言様式) {
        Map<Integer, RString> レイヤ = ReportUtil
                .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_21);
        決定通知書Entity.set文言1(レイヤ.get(0));
        決定通知書Entity.set文言2(レイヤ.get(NUM_1));
        if (定値_1.equals(帳票文言様式)) {
            決定通知書Entity.set通知文1(レイヤ.get(NUM_2));
        } else if (定値_2.equals(帳票文言様式)) {
            Map<Integer, RString> レイヤ大 = ReportUtil
                    .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_22);
            決定通知書Entity.set通知文2大(レイヤ大.get(NUM_2));
        } else if (定値_3.equals(帳票文言様式)) {
            Map<Integer, RString> レイヤ混在 = ReportUtil
                    .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_23);
            決定通知書Entity.set通知文3_上小(レイヤ混在.get(NUM_2));
            決定通知書Entity.set通知文4_下大(レイヤ混在.get(NUM_3));
        } else if (定値_4.equals(帳票文言様式)) {
            Map<Integer, RString> レイヤ混在2 = ReportUtil
                    .get通知文(SubGyomuCode.DBC介護給付, 帳票分類ID, KamokuCode.EMPTY, NUM_24);
            決定通知書Entity.set通知文5_上大(レイヤ混在2.get(NUM_2));
            決定通知書Entity.set通知文6_下小(レイヤ混在2.get(NUM_3));
        }
    }

    private Decimal nullToZero(Decimal 金額) {
        return 金額 == null ? Decimal.ZERO : 金額;
    }

    private RString addカッコ(RString rst) {
        return 括弧全角_L.concat(rst).concat(括弧全角_R);
    }

    private RString toDecimal(Decimal decimal) {
        if (null == decimal) {
            return 定値_0;
        }
        return DecimalFormatter.toコンマ区切りRString(decimal, 0);
    }

    private RString formatDate(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private void setﾀｲﾄﾙ_取消し線用(JigyouKetteiTutisyoEntity 決定通知書Entity,
            ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        if (ShikyuKubun.支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())) {
            決定通知書Entity.setﾀｲﾄﾙ_2_2_1_取消し線用(ShikyuKubun.支給.get名称());
            決定通知書Entity.setﾀｲﾄﾙ_2_2_2_取消し線用(RString.EMPTY);
            決定通知書Entity.setﾀｲﾄﾙ_2_3_1_取消し線用(RString.EMPTY);
            決定通知書Entity.setﾀｲﾄﾙ_2_3_2_取消し線用(addカッコ(ShikyuKubun.不支給.get名称()));
            決定通知書Entity.setﾀｲﾄﾙ_2_4_取消し線用(定値_決定通知書);
        } else if (ShikyuKubun.不支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())) {
            決定通知書Entity.setﾀｲﾄﾙ_2_2_1_取消し線用(RString.EMPTY);
            決定通知書Entity.setﾀｲﾄﾙ_2_2_2_取消し線用(ShikyuKubun.支給.get名称());
            決定通知書Entity.setﾀｲﾄﾙ_2_3_1_取消し線用(addカッコ(ShikyuKubun.不支給.get名称()));
            決定通知書Entity.setﾀｲﾄﾙ_2_3_2_取消し線用(RString.EMPTY);
            決定通知書Entity.setﾀｲﾄﾙ_2_4_取消し線用(定値_決定通知書);
        }
    }

    private void setﾀｲﾄﾙ_取消し線用_調整用(JigyouKetteiTutisyoEntity 決定通知書Entity,
            ServiceNoKanribangouRendouEntity 事業高額介護サービス費支給情報) {
        if (ShikyuKubun.支給.getコード().equals(事業高額介護サービス費支給情報.get支給区分コード())) {
            決定通知書Entity.setﾀｲﾄﾙ_3_2_1_取消し線用_調整用(ShikyuKubun.支給.get名称());
            決定通知書Entity.setﾀｲﾄﾙ_3_2_2_取消し線用_調整用(RString.EMPTY);
            決定通知書Entity.setﾀｲﾄﾙ_3_3_1_取消し線用_調整用(RString.EMPTY);
            決定通知書Entity.setﾀｲﾄﾙ_3_3_2_取消し線用_調整用(addカッコ(ShikyuKubun.不支給.get名称()));
            決定通知書Entity.setﾀｲﾄﾙ_3_4_取消し線用_調整用(定値_決定通知書調整用);
        }
    }

    private RString set時間(RString time) {
        if (time == null || time.isEmpty()) {
            return RString.EMPTY;
        }
        RString 時間;
        RString hh = time.substring(0, NUM_2);
        RString mm = time.substring(NUM_2, NUM_4);
        if (hh.compareTo(RSTRING_12) < 0) {
            時間 = 午前.concat(trimZero(hh)).concat(時);
        } else {
            時間 = 午後.concat(trimZero(hh)).concat(時);
        }
        if (!RSTRING_00.equals(mm)) {
            時間 = 時間.concat(trimZero(mm)).concat(分);
        }
        return 時間;
    }

    private RString trimZero(RString str) {
        str = str.trimStart(ZERO);
        if (str.length() == NUM_1) {
            str = RString.HALF_SPACE.concat(str);
        }
        return str;
    }
}
