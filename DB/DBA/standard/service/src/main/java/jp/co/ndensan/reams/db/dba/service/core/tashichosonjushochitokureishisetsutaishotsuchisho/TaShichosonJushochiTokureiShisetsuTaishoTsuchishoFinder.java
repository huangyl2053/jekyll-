/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureishisetsutaishotsuchisho;

import java.util.Map;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsutaishotsuchisho.TatokuKanrenChohyoTaishoTsuchishoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji.TatokuKanrenChohyoShijiData;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tashitaishotsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashihenkotsuchisho.ShisetsuJyohoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashitaishotsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tashitaishotsuchisho.TatokuKanrenChohyoTaishoTsuchishoEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tashitaishotsuchisho.ITaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.ShisetsuJyohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
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
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険住所地特例施設退所通知書のビジネスクラスです。
 *
 * @reamsid_L DBA-0380-010 huangh
 */
public class TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder {

    private final MapperProvider mapperProvider;
    private TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity getEntity;
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
    public TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.getEntity = new TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder}のインスタンス
     */
    public static TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder createInstance() {
        return InstanceProvider.create(TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder.class);
    }

    /**
     * 他住特施設退所通知書データ作成
     *
     * @param inBusiness TatokuKanrenChohyoShijiData
     * @return 他住特施設退所通知書データBusiness
     */
    @Transaction
    public TatokuKanrenChohyoTaishoTsuchishoBusiness setTatokuKanrenChohyoTaishoTsuchisho(TatokuKanrenChohyoShijiData inBusiness) {
        TatokuKanrenChohyoTaishoTsuchishoEntity outEntity = new TatokuKanrenChohyoTaishoTsuchishoEntity();
        outEntity.set保険者郵便番号(inBusiness.get保険者郵便番号().getEditedYubinNo());
        outEntity.set文書番号(inBusiness.get文書番号());
        outEntity.set保険者住所(inBusiness.get保険者住所());
        outEntity.set発行年月日(inBusiness.get発行年月日().
                wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outEntity.set保険者名(inBusiness.get保険者名());
        outEntity.set保険者名敬称(inBusiness.get保険者名敬称());
        outEntity.set担当部署名(inBusiness.get担当部署名());
        outEntity.set担当部署名敬称(inBusiness.get担当部署名敬称());

        CustomerBarCode barCode = new CustomerBarCode();
        if (inBusiness.get保険者郵便番号() != null && inBusiness.get保険者住所() != null) {
            CustomerBarCodeResult result
                    = barCode.convertCustomerBarCode(new RString(inBusiness.get保険者郵便番号().toString()), inBusiness.get保険者住所());

            if (result != null) {
                outEntity.setバーコード情報(result.getCustomerBarCode());
            }
        }

        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfoTemp =  tsuchishoTeikeibunManager.get最新適用日(
                SubGyomuCode.DBA介護資格,
                new ReportId("DBA100005_JushochitokureiShisetsuTaishoTsuchisho"), 
                KamokuCode.EMPTY, 
                INT1, 
                INT1);
        
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchishoTeikeibunManager.get通知書定形文検索(
                SubGyomuCode.DBA介護資格,
                new ReportId("DBA100005_JushochitokureiShisetsuTaishoTsuchisho"),
                KamokuCode.EMPTY,
                INT1,
                INT1,
                tsuchishoTeikeibunInfoTemp.getチェック用最新適用日());
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
            outEntity.set退所年月日(施設情報Entity.get退所年月日().
                    wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
              outEntity.set退所事由(CodeMaster.getCodeRyakusho(
                    DBACodeShubetsu.介護資格解除事由_他特例者.getコード(),
                    new Code(施設情報Entity.get退所事由()),
                    FlexibleDate.getNowDate()));
            outEntity.set施設名称(施設情報Entity.get事業者名称());
            outEntity.set施設電話番号(施設情報Entity.get電話番号());
            outEntity.set施設FAX番号(施設情報Entity.getFax番号());
            outEntity.set施設郵便番号(!RString.isNullOrEmpty(施設情報Entity.get郵便番号())
                    ? new YubinNo(施設情報Entity.get郵便番号()).getEditedYubinNo() : RString.EMPTY);
            outEntity.set施設住所(施設情報Entity.get事業者住所());
            基準日 = 施設情報Entity.get退所年月日();
        }
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(基準日);
        key.set識別コード(inBusiness.get識別コード());

        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter params
                = new TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter(shikibetsuTaishoPSMSearchKey);

        params.setPsmShikibetsuTaisho(new RString(params.toString()));
        ITaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper mapper1
                = this.mapperProvider.create(ITaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper.class);
        getEntity = mapper1.selectTaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatis(params);
        if (getEntity != null) {
            if (!inBusiness.is住所出力不要フラグ()) {
                this.郵便番号と住所を編集する(outEntity);
            } else {
                outEntity.set郵便番号(RString.EMPTY);
                outEntity.set住所(RString.EMPTY);
            }

            outEntity.set対象者名カナ(getEntity.getカナ名称());
            outEntity.set対象者名(getEntity.get名称());
            outEntity.set誕生日(getEntity.get生年月日().
                    wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());

            if (Seibetsu.男.getコード().equals(getEntity.get性別コード())) {
                outEntity.set性別(Seibetsu.男.get名称());
            } else if (Seibetsu.女.getコード().equals(getEntity.get性別コード())) {
                outEntity.set性別(Seibetsu.女.get名称());
            }
        }

        return new TatokuKanrenChohyoTaishoTsuchishoBusiness(outEntity);
    }

    /**
     * 郵便番号と住所を編集する。
     */
    private void 郵便番号と住所を編集する(TatokuKanrenChohyoTaishoTsuchishoEntity outEntity) {
        if (new RString("3").equals(getEntity.get住民状態コード())) {
            if (getEntity.get転出確定郵便番号() != null) {
                outEntity.set郵便番号(getEntity.get転出確定郵便番号().getEditedYubinNo());
            } else if (getEntity.get転出予定郵便番号() != null) {
                outEntity.set郵便番号(getEntity.get転出予定郵便番号().getEditedYubinNo());
            }
            if (!getEntity.get転出確定住所().isEmpty()) {
                outEntity.set住所(getEntity.get転出確定住所());
            } else {
                outEntity.set住所(getEntity.get転出予定住所());
            }

        } else {
            if (getEntity.get郵便番号() != null) {
                outEntity.set郵便番号(getEntity.get郵便番号().getEditedYubinNo());
            }
            outEntity.set住所(getEntity.get住所());
        }
    }
}
