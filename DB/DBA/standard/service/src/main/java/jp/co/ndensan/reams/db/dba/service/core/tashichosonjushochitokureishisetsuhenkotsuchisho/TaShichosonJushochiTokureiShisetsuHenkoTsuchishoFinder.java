/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureishisetsuhenkotsuchisho;

import java.util.Map;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsuhenkotsuchisho.TatokuKanrenChohyoHenkoTsuchishoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsuhenkotsuchisho.TatokuKanrenChohyoRenrakuhyoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji.TatokuKanrenChohyoShijiData;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tashihenkotsuchisho.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tashihenkotsuchisho.TatokuKanrenChohyoRenrakuhyoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.ShisetsuJyohoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.TatokuKanrenChohyoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.TatokuKanrenChohyoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tashihenkotsuchisho.ITaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.ShisetsuJyohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護保険住所地特例施設変更通知書のビジネスクラスです。
 *
 * @reamsid_L DBA-0380-040 huangh
 */
public class TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder {

    private final MapperProvider mapperProvider;
    private static final int INT1 = 1;
    private static final int INT2 = 2;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;

    /**
     * コンストラクタです。
     */
    public TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder}のインスタンス
     */
    public static TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder createInstance() {
        return InstanceProvider.create(TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder.class);
    }

    /**
     * 他住特施設変更通知書データ作成
     *
     * @param inBusiness TatokuKanrenChohyoShijiData
     * @return 他住特施設変更通知書データBusiness
     */
    public TatokuKanrenChohyoHenkoTsuchishoBusiness setTatokuKanrenChohyoTaishoTsuchisho(TatokuKanrenChohyoShijiData inBusiness) {
        TatokuKanrenChohyoHenkoTsuchishoEntity outEntity = new TatokuKanrenChohyoHenkoTsuchishoEntity();
        outEntity.set保険者郵便番号(inBusiness.get保険者郵便番号().getEditedYubinNo());
        outEntity.set文書番号(inBusiness.get文書番号());
        outEntity.set保険者住所(inBusiness.get保険者住所());
        outEntity.set発行年月日(inBusiness.get発行年月日().
                wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outEntity.set保険者名(inBusiness.get保険者名());
        outEntity.set保険者名敬称(inBusiness.get保険者名敬称());
        outEntity.set担当部署名(inBusiness.get担当部署名());
        outEntity.set担当部署名敬称(inBusiness.get担当部署名敬称());

        CustomerBarCode barCode = new CustomerBarCode();
        if (inBusiness.get保険者郵便番号() != null && inBusiness.get保険者住所() != null) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(
                    new RString(inBusiness.get保険者郵便番号().toString()), inBusiness.get保険者住所());
            if (result != null) {
                outEntity.setバーコード情報(result.getCustomerBarCode());
            }
        }

        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        // TODO n8372王イクカン （tsuchishoTeikeibunManagerの日付範囲の検索メソッドの追加が必要です。暫定対応として、最新の日付に対する通知文を設定する。） 2016/08/25
        TsuchishoTeikeibunInfo kaishiYMDInfo = tsuchishoTeikeibunManager.get最新適用日(
                SubGyomuCode.DBA介護資格,
                new ReportId("DBA100006_JushochitokureiShisetsuHenkoTsuchisho"),
                KamokuCode.EMPTY,
                1,
                1);
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchishoTeikeibunManager.get通知書定形文検索(
                SubGyomuCode.DBA介護資格,
                new ReportId("DBA100006_JushochitokureiShisetsuHenkoTsuchisho"),
                KamokuCode.EMPTY,
                1,
                1,
                kaishiYMDInfo.getチェック用最新適用日());
        if (tsuchishoTeikeibunInfo != null
                && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            outEntity.set見出し(tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence());
        }

        RString 被保険者番号 = inBusiness.get被保険者番号();
        if (被保険者番号 != null && INT10 <= 被保険者番号.length()) {
            outEntity.set被保険者番号１(被保険者番号.substring(0, INT1));
            outEntity.set被保険者番号２(被保険者番号.substring(INT1, INT2));
            outEntity.set被保険者番号３(被保険者番号.substring(INT2, INT3));
            outEntity.set被保険者番号４(被保険者番号.substring(INT3, INT4));
            outEntity.set被保険者番号５(被保険者番号.substring(INT4, INT5));
            outEntity.set被保険者番号６(被保険者番号.substring(INT5, INT6));
            outEntity.set被保険者番号７(被保険者番号.substring(INT6, INT7));
            outEntity.set被保険者番号８(被保険者番号.substring(INT7, INT8));
            outEntity.set被保険者番号９(被保険者番号.substring(INT8, INT9));
            outEntity.set被保険者番号１０(被保険者番号.substring(INT9, INT10));
        }

        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        builder.set基準日(inBusiness.get入所年月日());
        builder.set識別コード(inBusiness.get識別コード());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = builder.build();
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter params
                = new TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter(shikibetsuTaishoPSMSearchKey);
        params.setPsmShikibetsuTaisho(new RString(params.toString()));
        ITaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper mapper
                = this.mapperProvider.create(ITaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper.class);
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity pSMEntity
                = mapper.selectTaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatis(params);
        if (pSMEntity != null) {
            outEntity.set対象者名カナ(pSMEntity.getカナ名称());
            outEntity.set対象者名(pSMEntity.get名称());
            outEntity.set誕生日(pSMEntity.get生年月日().
                    wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());

            if (Seibetsu.男.getコード().equals(pSMEntity.get性別コード())) {
                outEntity.set性別(Seibetsu.男.get名称());
            } else if (Seibetsu.女.getコード().equals(pSMEntity.get性別コード())) {
                outEntity.set性別(Seibetsu.女.get名称());
            }
        }

        outEntity.set変更年月日(inBusiness.get入所年月日().
                wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        Map<Integer, ShisetsuJyohoRelateEntity> 施設情報Map = ShisetsuJyohoFinder.createInstance().
                getTaJushochiTokureiTekiyoJyoho(inBusiness.get識別コード(), inBusiness.get異動日(), inBusiness.get枝番());
        ShisetsuJyohoRelateEntity 変更後施設情報 = 施設情報Map.get(1);
        ShisetsuJyohoRelateEntity 変更前施設情報 = 施設情報Map.get(2);
        if (変更前施設情報 != null) {
            outEntity.set変更前施設名称(変更前施設情報.get事業者名称());
            outEntity.set変更前施設電話番号(変更前施設情報.get電話番号());
            outEntity.set変更前施設FAX番号(変更前施設情報.getFax番号());
            outEntity.set変更前施設郵便番号(!RString.isNullOrEmpty(変更前施設情報.get郵便番号())
                    ? new YubinNo(変更前施設情報.get郵便番号()).getEditedYubinNo() : RString.EMPTY);
            outEntity.set変更前施設住所(変更前施設情報.get事業者住所());
        }
        if (変更後施設情報 != null) {
            outEntity.set変更後施設名称(変更後施設情報.get事業者名称());
            outEntity.set変更後施設電話番号(変更後施設情報.get電話番号());
            outEntity.set変更後施設FAX番号(変更後施設情報.getFax番号());
            outEntity.set変更後施設郵便番号(!RString.isNullOrEmpty(変更後施設情報.get郵便番号())
                    ? new YubinNo(変更後施設情報.get郵便番号()).getEditedYubinNo() : RString.EMPTY);
            outEntity.set変更後施設住所(変更後施設情報.get事業者住所());
        }
        return new TatokuKanrenChohyoHenkoTsuchishoBusiness(outEntity);
    }

    /**
     * 他住特施設連絡票データ作成
     *
     * @param inBusiness TatokuKanrenChohyoShijiData
     * @return 他住特施設連絡票データBusiness
     */
    public TatokuKanrenChohyoRenrakuhyoBusiness setTatokuKanrenChohyoRenrakuhyo(TatokuKanrenChohyoShijiData inBusiness) {
        TatokuKanrenChohyoRenrakuhyoEntity outEntity = new TatokuKanrenChohyoRenrakuhyoEntity();
        outEntity.set保険者郵便番号(inBusiness.get保険者郵便番号().getEditedYubinNo());
        outEntity.set文書番号(inBusiness.get文書番号());
        outEntity.set保険者住所(inBusiness.get保険者住所());
        outEntity.set発行年月日(inBusiness.get発行年月日().
                wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outEntity.set保険者名(inBusiness.get保険者名());
        outEntity.set保険者名敬称(inBusiness.get保険者名敬称());
        outEntity.set担当部署名(inBusiness.get担当部署名());
        outEntity.set担当部署名敬称(inBusiness.get担当部署名敬称());

        CustomerBarCode barCode = new CustomerBarCode();
        if (inBusiness.get保険者郵便番号() != null && inBusiness.get保険者住所() != null) {
            CustomerBarCodeResult barresult = barCode.convertCustomerBarCode(
                    new RString(inBusiness.get保険者郵便番号().toString()), inBusiness.get保険者住所());
            if (barresult != null) {
                outEntity.setバーコード情報(barresult.getCustomerBarCode());
            }
        }

        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        // TODO n8373けい政 （tsuchishoTeikeibunManagerの日付範囲の検索メソッドの追加が必要です。暫定対応として、最新の日付に対する通知文を設定する。） 2016/08/25
        TsuchishoTeikeibunInfo kaishiYMDInfo = tsuchishoTeikeibunManager.get最新適用日(
                SubGyomuCode.DBA介護資格,
                new ReportId("DBA100007_TashichosonJushochitokureishaRenrakuhyo"),
                KamokuCode.EMPTY,
                1,
                1);
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchishoTeikeibunManager.get通知書定形文検索(
                SubGyomuCode.DBA介護資格,
                new ReportId("DBA100007_TashichosonJushochitokureishaRenrakuhyo"),
                KamokuCode.EMPTY,
                1,
                1,
                kaishiYMDInfo.getチェック用最新適用日());
        if (tsuchishoTeikeibunInfo != null
                && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            outEntity.set見出し(tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence());
        }

        RString 被保険者番号 = inBusiness.get被保険者番号();
        if (被保険者番号 != null && INT10 <= 被保険者番号.length()) {
            outEntity.set被保険者番号１(被保険者番号.substring(0, INT1));
            outEntity.set被保険者番号２(被保険者番号.substring(INT1, INT2));
            outEntity.set被保険者番号３(被保険者番号.substring(INT2, INT3));
            outEntity.set被保険者番号４(被保険者番号.substring(INT3, INT4));
            outEntity.set被保険者番号５(被保険者番号.substring(INT4, INT5));
            outEntity.set被保険者番号６(被保険者番号.substring(INT5, INT6));
            outEntity.set被保険者番号７(被保険者番号.substring(INT6, INT7));
            outEntity.set被保険者番号８(被保険者番号.substring(INT7, INT8));
            outEntity.set被保険者番号９(被保険者番号.substring(INT8, INT9));
            outEntity.set被保険者番号１０(被保険者番号.substring(INT9, INT10));
        }

        Map<Integer, ShisetsuJyohoRelateEntity> 施設情報Map = ShisetsuJyohoFinder.createInstance().
                getTaJushochiTokureiTekiyoJyoho(inBusiness.get識別コード(), inBusiness.get異動日(), inBusiness.get枝番());
        ShisetsuJyohoRelateEntity 施設情報Entity = 施設情報Map.get(1);
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        if (施設情報Entity != null) {
            outEntity.set入所年月日(施設情報Entity.get入所年月日().
                    wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            outEntity.set施設名称(施設情報Entity.get事業者名称());
            outEntity.set施設電話番号(施設情報Entity.get電話番号());
            outEntity.set施設FAX番号(施設情報Entity.getFax番号());
            outEntity.set施設郵便番号(!RString.isNullOrEmpty(施設情報Entity.get郵便番号())
                    ? new YubinNo(施設情報Entity.get郵便番号()).getEditedYubinNo() : RString.EMPTY);
            outEntity.set施設住所(施設情報Entity.get事業者住所());
            基準日 = 施設情報Entity.get入所年月日();

        }
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(基準日);
        key.set識別コード(inBusiness.get識別コード());

        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        TatokuKanrenChohyoRenrakuhyoMybatisParameter params = new TatokuKanrenChohyoRenrakuhyoMybatisParameter(shikibetsuTaishoPSMSearchKey);
        params.setPsmShikibetsuTaisho(new RString(params.toString()));
        ITaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper searchKeyMapper
                = this.mapperProvider.create(ITaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper.class);
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity entity
                = searchKeyMapper.selectTatokuKanrenChohyoRenrakuhyoMybatis(params);
        if (entity != null) {
            outEntity.set対象者名カナ(entity.getカナ名称());
            outEntity.set対象者名(entity.get名称());
            outEntity.set誕生日(entity.get生年月日().
                    wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());

            if (Seibetsu.男.getコード().equals(entity.get性別コード())) {
                outEntity.set性別(Seibetsu.男.get名称());
            } else if (Seibetsu.女.getコード().equals(entity.get性別コード())) {
                outEntity.set性別(Seibetsu.女.get名称());
            }

            if (!inBusiness.is住所出力不要フラグ()) {
                YubinNo 転入前郵便番号 = entity.get転入前郵便番号();
                outEntity.set郵便番号(転入前郵便番号 == null ? RString.EMPTY : 転入前郵便番号.getEditedYubinNo());
                outEntity.set住所(entity.get転入前住所());
            } else {
                outEntity.set郵便番号(RString.EMPTY);
                outEntity.set住所(RString.EMPTY);
            }
            outEntity.set転入年月日(entity.get登録異動年月日().
                    wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }

        return new TatokuKanrenChohyoRenrakuhyoBusiness(outEntity);
    }
}
