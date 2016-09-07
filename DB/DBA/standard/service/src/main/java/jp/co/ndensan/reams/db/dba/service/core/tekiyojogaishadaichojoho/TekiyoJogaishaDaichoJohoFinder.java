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
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho.TekiyoJogaiShisetuJyohoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaishadaichojoho.TekiyoJogaishaDaichoJohoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaishadaichojoho.ITekiyoJogaiShisetuJyohoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
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
 *
 * @reamsid_L DBA-0412-010 linghuhang
 */
public class TekiyoJogaishaDaichoJohoFinder {

    private static final int ページ目 = 1;
    private static final int 導入形態コード_LENGTH_1 = 1;
    private static final int 導入形態コード_LENGTH_3 = 3;
    private static final RString 広域 = new RString("11");
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
     * @return {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaDaichoJohoFinder}のインスタンス
     */
    public static TekiyoJogaishaDaichoJohoFinder createInstance() {
        return InstanceProvider.create(TekiyoJogaishaDaichoJohoFinder.class);
    }

    /**
     * 適用除外者台帳情報の取得します。
     *
     * @param 識別コード 識別コード
     * @return SearchResult<TekiyoJogaishaDaichoJoho> 適用除外者台帳情報
     */
    @Transaction
    public SearchResult<TekiyoJogaishaDaichoJoho> getTekiyoJogaishaDaichoJoho(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        List<TekiyoJogaishaDaichoJoho> daichoJohoList = new ArrayList<>();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        TekiyoJogaiShisetuJyohoParameter parameter = TekiyoJogaiShisetuJyohoParameter.createParamFor識別コード(
                ShikibetsuCode.EMPTY, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        ITekiyoJogaiShisetuJyohoMapper daichoJohoMapper = mapperProvider.create(ITekiyoJogaiShisetuJyohoMapper.class);
        UaFt200FindShikibetsuTaishoEntity 宛名情報PSM = daichoJohoMapper.select宛名情報(parameter);
        if (宛名情報PSM == null) {
            TekiyoJogaishaDaichoJohoRelateEntity 適用除外者台帳情報Entity = new TekiyoJogaishaDaichoJohoRelateEntity();
            適用除外者台帳情報Entity.set印刷日時(get印刷日時());
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
            適用除外者台帳情報Entity.set市町村コード(nullToEmpty(宛名情報PSM.getGenLasdecCode()));
            適用除外者台帳情報Entity.set市町村名称(市町村名称);
            適用除外者台帳情報Entity.set電話番号タイトル(連絡先);
            適用除外者台帳情報Entity.set電話番号１(nullToEmpty(宛名情報PSM.getRenrakusaki1()));
            適用除外者台帳情報Entity.set電話番号２(RString.EMPTY);
            適用除外者台帳情報Entity.set連番(entity.get連番());
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
            適用除外者台帳情報Entity.set郵便番号(郵便フォーマット(entity.get郵便番号()));
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
        FlexibleDate 基准日 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<TekiyoJogaiShisetuJyohoRelateEntity> relateEntityList = new ArrayList<>();
        for (int i = 0; i < shisetuJyohoList.size(); i++) {
            TekiyoJogaiShisetuJyohoRelateEntity entity = shisetuJyohoList.get(i);
            entity.set連番(i + 1);
            RString 適用除外適用事由名称 = CodeMaster.getCodeRyakusho(DBACodeShubetsu.介護資格適用事由_除外者.getコード(),
                    new Code(entity.get適用除外適用事由コード()), 基准日);
            RString 適用除外解除事由名称 = RString.EMPTY;
            if (!RString.isNullOrEmpty(entity.get適用除外解除事由コード())) {
                適用除外解除事由名称 = CodeMaster.getCodeRyakusho(DBACodeShubetsu.介護資格解除事由_除外者.getコード(),
                        new Code(entity.get適用除外解除事由コード()), 基准日);
            }
            entity.set適用除外適用事由名称(RString.EMPTY);
            entity.set適用除外解除事由名称(RString.EMPTY);
            if (適用除外適用事由名称 != null && !適用除外適用事由名称.isEmpty()) {
                entity.set適用除外適用事由名称(適用除外適用事由名称);
            }
            if (適用除外解除事由名称 != null && !適用除外解除事由名称.isEmpty()) {
                entity.set適用除外解除事由名称(適用除外解除事由名称);
            }
        }
        return SearchResult.of(relateEntityList, 0, false);
    }

    private SearchResult<TekiyoJogaishaDaichoJoho> set適用除外者台帳情報(
            TekiyoJogaishaDaichoJohoRelateEntity 適用除外者台帳情報Entity,
            UaFt200FindShikibetsuTaishoEntity 宛名情報PSM) {
        List<TekiyoJogaishaDaichoJoho> daichoJohoList = new ArrayList<>();
        適用除外者台帳情報Entity.set印刷日時(get印刷日時());
        適用除外者台帳情報Entity.setタイトル(new RString("介護保険　適用除外者台帳"));
        適用除外者台帳情報Entity.set状態(状態);
        適用除外者台帳情報Entity.set生年月日(nullToEmpty(宛名情報PSM.getSeinengappiYMD()));
        if (性別_男.equals(宛名情報PSM.getSeibetsuCode())) {
            適用除外者台帳情報Entity.set性別(男);
        } else {
            適用除外者台帳情報Entity.set性別(女);
        }
        適用除外者台帳情報Entity.set世帯コード(nullToEmpty(宛名情報PSM.getSetaiCode()));
        適用除外者台帳情報Entity.set識別コード(nullToEmpty(宛名情報PSM.getShikibetsuCode()));
        適用除外者台帳情報Entity.set氏名カナ(nullToEmpty(宛名情報PSM.getKanaMeisho()));
        適用除外者台帳情報Entity.set氏名(nullToEmpty(宛名情報PSM.getMeisho()));
        適用除外者台帳情報Entity.set地区コード1(nullToEmpty(宛名情報PSM.getChikuCode1()));
        適用除外者台帳情報Entity.set地区タイトル1(宛名情報PSM.getChikuName1());
        適用除外者台帳情報Entity.set地区コード2(nullToEmpty(宛名情報PSM.getChikuCode2()));
        適用除外者台帳情報Entity.set地区タイトル2(宛名情報PSM.getChikuName2());
        適用除外者台帳情報Entity.set地区コード3(nullToEmpty(宛名情報PSM.getChikuCode3()));
        適用除外者台帳情報Entity.set地区タイトル3(宛名情報PSM.getChikuName3());
        IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報PSM);
        ChohyoSeigyoKyotsu 帳票共通情報
                = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100010.getReportId());
        適用除外者台帳情報Entity.set住所1(JushoHenshu.editJusho(帳票共通情報, 宛名情報, AssociationFinderFactory.createInstance().getAssociation()));
        適用除外者台帳情報Entity.set住所タイトル1(住所);
        適用除外者台帳情報Entity.set住所コード(JushoHenshu.get住所コード(宛名情報PSM));
        適用除外者台帳情報Entity.set行政区タイトル(行政区);
        適用除外者台帳情報Entity.set行政区コード(nullToEmpty(宛名情報PSM.getGyoseikuCode()));
        適用除外者台帳情報Entity.set住所2(JushoHenshu.editJusho2(
                宛名情報PSM.getTennyumaeJusho(), 宛名情報PSM.getTennyumaeBanchi(), 宛名情報PSM.getTennyumaeKatagaki()));
        適用除外者台帳情報Entity.set住所タイトル2(転入前住所);
        適用除外者台帳情報Entity.set住所コード2(nullToEmpty(宛名情報PSM.getTennyumaeZenkokuJushoCode()));
        daichoJohoList.add(new TekiyoJogaishaDaichoJoho(適用除外者台帳情報Entity));
        return SearchResult.of(daichoJohoList, 0, false);
    }

    private RString get市町村名称(LasdecCode 市町村コード) {
        RString 市町村名称 = RString.EMPTY;
        Code 導入形態コード = Code.EMPTY;
        List<KoikiZenShichosonJoho> 現市町村情報リスト = new ArrayList<>();
        KoseiShichosonJoho shichosonJoho = null;
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード();
            shichosonJoho = 市町村セキュリティ情報.get市町村情報();
        }
        if (導入形態コード != null && !導入形態コード.isEmpty()
                && 導入形態コード.getColumnValue().length() >= 導入形態コード_LENGTH_3) {
            if (広域.equals(導入形態コード.getColumnValue().substringEmptyOnError(導入形態コード_LENGTH_1, 導入形態コード_LENGTH_3))) {
                現市町村情報リスト = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
            } else {
                if (shichosonJoho != null) {
                    return shichosonJoho.get市町村名称();
                }
            }
        }
        if (現市町村情報リスト != null && !現市町村情報リスト.isEmpty()) {
            for (KoikiZenShichosonJoho 市町村情報 : 現市町村情報リスト) {
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

    private RString get印刷日時() {
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

    private RString 日付フォーマット(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString 郵便フォーマット(YubinNo 郵便) {
        if (郵便 == null || 郵便.isEmpty()) {
            return RString.EMPTY;
        }
        return 郵便.getEditedYubinNo();
    }

    private RString nullToEmpty(TelNo 電話番号) {
        if (電話番号 == null || 電話番号.isEmpty()) {
            return RString.EMPTY;
        }
        return 電話番号.getColumnValue();
    }

    private RString nullToEmpty(LasdecCode 市町村コード) {
        if (市町村コード == null || 市町村コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 市町村コード.getColumnValue();
    }

    private RString nullToEmpty(SetaiCode 世帯コード) {
        if (世帯コード == null || 世帯コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 世帯コード.getColumnValue();
    }

    private RString nullToEmpty(FlexibleDate 生年月日) {
        if (生年月日 == null || 生年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(生年月日.toString());
    }

    private RString nullToEmpty(ShikibetsuCode 識別コード) {
        if (識別コード == null || 識別コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 識別コード.getColumnValue();
    }

    private RString nullToEmpty(AtenaKanaMeisho 氏名カナ) {
        if (氏名カナ == null || 氏名カナ.isEmpty()) {
            return RString.EMPTY;
        }
        return 氏名カナ.getColumnValue();
    }

    private RString nullToEmpty(AtenaMeisho 氏名) {
        if (氏名 == null || 氏名.isEmpty()) {
            return RString.EMPTY;
        }
        return 氏名.getColumnValue();
    }

    private RString nullToEmpty(ChikuCode 地区コード) {
        if (地区コード == null || 地区コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 地区コード.getColumnValue();
    }

    private RString nullToEmpty(ZenkokuJushoCode 住所コード) {
        if (住所コード == null || 住所コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 住所コード.getColumnValue();
    }

    private RString nullToEmpty(GyoseikuCode 行政区コード) {
        if (行政区コード == null || 行政区コード.isEmpty()) {
            return RString.EMPTY;
        }
        return 行政区コード.getColumnValue();
    }
}
