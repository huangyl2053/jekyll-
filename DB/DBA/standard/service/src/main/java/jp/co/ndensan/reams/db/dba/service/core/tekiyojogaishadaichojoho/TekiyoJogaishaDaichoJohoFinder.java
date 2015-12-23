/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tekiyojogaishadaichojoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaishadaichojoho.TekiyoJogaishaDaichoJoho;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaishadaichojoho.TekiyoJogaiShisetuJyohoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho.ShikibetsuTaishoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho.TekiyoJogaiShisetuJyohoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho.TekiyoJogaishaDaichoJohoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaishadaichojoho.ITekiyoJogaiShisetuJyohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者台帳するクラスです。
 */
public class TekiyoJogaishaDaichoJohoFinder {

    private static final int ページ目 = 1;
    private static final int 住所_LENGTH_40 = 40;
    private static final int 住所_LENGTH_41 = 41;
    private static final int 住所_LENGTH_80 = 80;
    private static final int 住所_LENGTH_81 = 81;
    private static final int 住所_LENGTH_120 = 120;
    private static final int 住所_LENGTH_121 = 121;
    private static final int 導入形態コード_LENGTH_1 = 1;
    private static final int 導入形態コード_LENGTH_3 = 3;
    private static final int 導入形態コード_LENGTH_4 = 4;
    private static final RString 広域 = new RString("11");
    private static final RString 改行 = new RString("\r\n");
    private static final RString 状態 = new RString("適用除外者");
    private static final RString 性別_男 = new RString("1");
    private static final RString 男 = new RString("男");
    private static final RString 女 = new RString("女");
    private static final RString 住所 = new RString("住所");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 転入前住所 = new RString("転入前住所");
    private static final RString 連絡先 = new RString("連絡先");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TekiyoJogaishaDaichoJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TekiyoJogaishaDaichoJohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaDaichoJohoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaDaichoJohoFinder}のインスタンス
     */
    public static TekiyoJogaishaDaichoJohoFinder createInstance() {
        return InstanceProvider.create(TekiyoJogaishaDaichoJohoFinder.class);
    }

    /**
     *
     * @param 識別コード 識別コード
     * @return SearchResult<TekiyoJogaishaDaichoJoho> 適用除外者台帳情報
     */
    @Transaction
    public SearchResult<TekiyoJogaishaDaichoJoho> getTekiyoJogaishaDaichoJoho(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        List<TekiyoJogaishaDaichoJoho> daichoJohoList = new ArrayList<>();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        TekiyoJogaiShisetuJyohoParameter parameter = TekiyoJogaiShisetuJyohoParameter.createParamFor識別コード(
                識別コード, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        ITekiyoJogaiShisetuJyohoMapper daichoJohoMapper = mapperProvider.create(ITekiyoJogaiShisetuJyohoMapper.class);
        ShikibetsuTaishoRelateEntity 宛名情報PSM = daichoJohoMapper.select宛名情報(parameter);
        if (宛名情報PSM == null) {
            TekiyoJogaishaDaichoJohoRelateEntity 適用除外者台帳情報Entity = new TekiyoJogaishaDaichoJohoRelateEntity();
            適用除外者台帳情報Entity.set印刷日時(set印刷日時());
            適用除外者台帳情報Entity.setページ目(ページ目);
            適用除外者台帳情報Entity.set状態(状態);
            daichoJohoList.add(new TekiyoJogaishaDaichoJoho(適用除外者台帳情報Entity));
            return SearchResult.of(daichoJohoList, 0, false);
        }
        List<TekiyoJogaiShisetuJyohoRelateEntity> 適用除外施設情報List = get適用除外施設情報(
                TekiyoJogaiShisetuJyohoParameter.createParamFor識別コード(識別コード, RString.EMPTY)).records();
        if (適用除外施設情報List == null || 適用除外施設情報List.isEmpty()) {
            TekiyoJogaishaDaichoJohoRelateEntity 適用除外者台帳情報Entity = new TekiyoJogaishaDaichoJohoRelateEntity();
            適用除外者台帳情報Entity.setページ目(ページ目);
            return set適用除外者台帳情報(適用除外者台帳情報Entity, 宛名情報PSM);
        }
        RString 市町村名称 = get市町村名称(適用除外施設情報List.get(0).get市町村コード());

        for (TekiyoJogaiShisetuJyohoRelateEntity entity : 適用除外施設情報List) {
            TekiyoJogaishaDaichoJohoRelateEntity 適用除外者台帳情報Entity = new TekiyoJogaishaDaichoJohoRelateEntity();
            適用除外者台帳情報Entity.set市町村コード(宛名情報PSM.get現全国地方公共団体コード().getColumnValue());
            適用除外者台帳情報Entity.set市町村名称(市町村名称);
            適用除外者台帳情報Entity.set電話番号タイトル(連絡先);
            //TODO 凌護行 「宛名情報」の戻り値一覧に「連絡先」が無い、 QA274回答まち、2015/12/28まで
//            適用除外者台帳情報Entity.set電話番号１(宛名情報PSM.get連絡先());
            適用除外者台帳情報Entity.set電話番号２(RString.EMPTY);
            適用除外者台帳情報Entity.setNO(entity.getNO());
            適用除外者台帳情報Entity.set適用年月日(日付フォーマット(entity.get適用年月日()));
            適用除外者台帳情報Entity.set適用届出年月日(日付フォーマット(entity.get適用届出年月日()));
            適用除外者台帳情報Entity.set適用除外適用事由コード(entity.get適用除外適用事由コード());
            適用除外者台帳情報Entity.set適用除外適用事由名称(entity.get適用除外適用事由名称());
            適用除外者台帳情報Entity.set解除年月日(日付フォーマット(entity.get解除年月日()));
            適用除外者台帳情報Entity.set解除届出年月日(日付フォーマット(entity.get解除届出年月日()));
            適用除外者台帳情報Entity.set適用除外解除事由コード(entity.get適用除外解除事由コード());
            適用除外者台帳情報Entity.set適用除外解除事由名称(entity.get適用除外解除事由名称());
            適用除外者台帳情報Entity.set入所年月日(日付フォーマット(entity.get入所年月日()));
            適用除外者台帳情報Entity.set退所年月日(日付フォーマット(entity.get退所年月日()));
            適用除外者台帳情報Entity.set事業者名称(entity.get事業者名称());
            適用除外者台帳情報Entity.set事業者住所(entity.get事業者住所());
            適用除外者台帳情報Entity.set電話番号(entity.get電話番号());
            適用除外者台帳情報Entity.set郵便番号(entity.get郵便番号().getEditedYubinNo());
            set適用除外者台帳情報(適用除外者台帳情報Entity, 宛名情報PSM);
            daichoJohoList.add(new TekiyoJogaishaDaichoJoho(適用除外者台帳情報Entity));
        }
        return SearchResult.of(daichoJohoList, 0, false);
    }

    private SearchResult<TekiyoJogaiShisetuJyohoRelateEntity> get適用除外施設情報(TekiyoJogaiShisetuJyohoParameter parameter) {
        ITekiyoJogaiShisetuJyohoMapper daichoJohoMapper = this.mapperProvider.create(ITekiyoJogaiShisetuJyohoMapper.class);
        return set適用除外施設情報(daichoJohoMapper.select適用除外施設情報(parameter));
    }

    private SearchResult<TekiyoJogaiShisetuJyohoRelateEntity> set適用除外施設情報(List<TekiyoJogaiShisetuJyohoRelateEntity> shisetuJyohoRelateEntityList) {
        List<TekiyoJogaiShisetuJyohoRelateEntity> shisetuJyohoList = new ArrayList<>();
        for (TekiyoJogaiShisetuJyohoRelateEntity relateEntity : shisetuJyohoRelateEntityList) {
            if (relateEntity.get解除年月日() == null || relateEntity.get解除年月日().isEmpty()) {
                if (relateEntity.get退所年月日() == null || relateEntity.get退所年月日().isEmpty()
                        || relateEntity.get適用年月日().isBefore(relateEntity.get退所年月日())) {
                    shisetuJyohoList.add(relateEntity);
                }
            } else {
                if ((relateEntity.get退所年月日() == null || relateEntity.get退所年月日().isEmpty()
                        && relateEntity.get入所年月日().isBefore(relateEntity.get退所年月日()))
                        || (relateEntity.get入所年月日().isBefore(relateEntity.get退所年月日())
                        && relateEntity.get適用年月日().isBefore(relateEntity.get退所年月日()))) {
                    shisetuJyohoList.add(relateEntity);
                }
            }
        }
        if (!shisetuJyohoList.isEmpty()) {
            set事由コードより名称(shisetuJyohoList);
        }
        return SearchResult.of(shisetuJyohoList, 0, false);
    }

    private SearchResult<TekiyoJogaiShisetuJyohoRelateEntity> set事由コードより名称(List<TekiyoJogaiShisetuJyohoRelateEntity> shisetuJyohoList) {
        List<TekiyoJogaiShisetuJyohoRelateEntity> relateEntityList = new ArrayList<>();
        for (int i = 0; i < shisetuJyohoList.size(); i++) {
            TekiyoJogaiShisetuJyohoRelateEntity entity = shisetuJyohoList.get(i);
            entity.setNO(i + 1);
            entity.set適用除外適用事由名称(CodeMaster.getCodeMeisho(new CodeShubetsu("0119"), new Code(entity.get適用除外適用事由コード())));
            entity.set適用除外解除事由名称(CodeMaster.getCodeMeisho(new CodeShubetsu("0123"), new Code(entity.get適用除外解除事由コード())));
        }
        return SearchResult.of(relateEntityList, 0, false);
    }

    private SearchResult<TekiyoJogaishaDaichoJoho> set適用除外者台帳情報(
            TekiyoJogaishaDaichoJohoRelateEntity 適用除外者台帳情報Entity,
            ShikibetsuTaishoRelateEntity 宛名情報PSM) {
        List<TekiyoJogaishaDaichoJoho> daichoJohoList = new ArrayList<>();
        適用除外者台帳情報Entity.set印刷日時(set印刷日時());
        適用除外者台帳情報Entity.set状態(状態);
        適用除外者台帳情報Entity.set生年月日(new RString(宛名情報PSM.get生年月日().toString()));
        if (性別_男.equals(宛名情報PSM.get性別コード())) {
            適用除外者台帳情報Entity.set性別(男);
        } else {
            適用除外者台帳情報Entity.set性別(女);
        }
        適用除外者台帳情報Entity.set世帯コード(宛名情報PSM.get世帯コード().getColumnValue());
        適用除外者台帳情報Entity.set識別コード(宛名情報PSM.get識別コード().getColumnValue());
        適用除外者台帳情報Entity.set氏名カナ(宛名情報PSM.getカナ名称().getColumnValue());
        適用除外者台帳情報Entity.set氏名(宛名情報PSM.get名称().getColumnValue());
        適用除外者台帳情報Entity.set地区コード1(宛名情報PSM.get地区コード1().getColumnValue());
        適用除外者台帳情報Entity.set地区タイトル1(宛名情報PSM.get地区名1());
        適用除外者台帳情報Entity.set地区コード2(宛名情報PSM.get地区コード2().getColumnValue());
        適用除外者台帳情報Entity.set地区タイトル2(宛名情報PSM.get地区名2());
        適用除外者台帳情報Entity.set地区コード3(宛名情報PSM.get地区コード3().getColumnValue());
        適用除外者台帳情報Entity.set地区タイトル3(宛名情報PSM.get地区名3());
        適用除外者台帳情報Entity.set住所1(get住所の編集(宛名情報PSM.get住所().getColumnValue(), 宛名情報PSM.get住所().getColumnValue().length()));
        適用除外者台帳情報Entity.set住所タイトル1(住所);
        適用除外者台帳情報Entity.set住所コード(宛名情報PSM.get全国住所コード().getColumnValue());
        適用除外者台帳情報Entity.set行政区タイトル(行政区);
        適用除外者台帳情報Entity.set行政区コード(宛名情報PSM.get行政区コード().getColumnValue());
        // TODO 凌護行 項目「住所」の編集処理が無し、 QA282回答まち、2015/12/28まで、
//        適用除外者台帳情報Entity.set住所2(宛名情報PSM.get転入前住所().getColumnValue());
        適用除外者台帳情報Entity.set住所1(get住所の編集(宛名情報PSM.get転入前住所().getColumnValue(), 宛名情報PSM.get転入前住所().getColumnValue().length()));
        適用除外者台帳情報Entity.set住所タイトル2(転入前住所);
        適用除外者台帳情報Entity.set住所コード2(宛名情報PSM.get転入前全国住所コード().getColumnValue());
        daichoJohoList.add(new TekiyoJogaishaDaichoJoho(適用除外者台帳情報Entity));
        return SearchResult.of(daichoJohoList, 0, false);
    }

    private RString get市町村名称(LasdecCode 市町村コード) {
        RString 市町村名称 = RString.EMPTY;
        Code 導入形態コード = Code.EMPTY;
        SearchResult<KoikiZenShichosonJoho> 現市町村情報 = null;
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        }
        if (導入形態コード != null && !導入形態コード.isEmpty()
                && 導入形態コード.getColumnValue().length() >= 導入形態コード_LENGTH_4) {
            if (広域.equals(導入形態コード.getColumnValue().substringEmptyOnError(導入形態コード_LENGTH_1, 導入形態コード_LENGTH_3))) {
                現市町村情報 = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
            }
//TODO 凌護行 「QA #70076」回答により、機能「市町村情報取得_単一」いらないです、 QA259回答まち、2015/12/28まで
//            else {
//                現市町村情報 = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
//            }
        }
        if (現市町村情報 != null) {
            for (KoikiZenShichosonJoho 市町村情報 : 現市町村情報.records()) {
                if (市町村情報.get市町村コード() == null || 市町村情報.get市町村コード().isEmpty()) {
                    break;
                }
                if (市町村コード.getColumnValue().equals(市町村情報.get市町村コード().getColumnValue())) {
                    return 市町村情報.get市町村名称();
                }
            }
        }
        return 市町村名称;
    }

    private RString get住所の編集(RString 住所, int 住所_LENGTH) {
        if (住所_LENGTH_40 < 住所_LENGTH && 住所_LENGTH <= 住所_LENGTH_80) {
            RStringBuilder stringBuffer = new RStringBuilder();
            stringBuffer.append(住所.substringEmptyOnError(0, 住所_LENGTH_41))
                    .append(改行)
                    .append(住所.substringEmptyOnError(住所_LENGTH_41));
            return stringBuffer.toRString();
        }
        if (住所_LENGTH_80 < 住所_LENGTH && 住所_LENGTH <= 住所_LENGTH_120) {
            RStringBuilder stringBuffer = new RStringBuilder();
            stringBuffer.append(住所.substringEmptyOnError(0, 住所_LENGTH_41))
                    .append(改行)
                    .append(住所.substringEmptyOnError(住所_LENGTH_41, 住所_LENGTH_81))
                    .append(改行)
                    .append(住所.substringEmptyOnError(住所_LENGTH_81));
            return stringBuffer.toRString();
        }
        if (住所_LENGTH_120 < 住所_LENGTH) {
            RStringBuilder stringBuffer = new RStringBuilder();
            stringBuffer.append(住所.substringEmptyOnError(0, 住所_LENGTH_41))
                    .append(改行)
                    .append(住所.substringEmptyOnError(住所_LENGTH_41, 住所_LENGTH_81))
                    .append(改行)
                    .append(住所.substringEmptyOnError(住所_LENGTH_81, 住所_LENGTH_121));
            return stringBuffer.toRString();
        }
        return 住所;
    }

    private RString set印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

    private FlexibleDate 日付フォーマット(FlexibleDate 日付) {
        return new FlexibleDate(日付.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
    }
}
