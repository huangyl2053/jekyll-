/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureishisetsutaishotsuchisho;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.TaShichosonJushochiTokureiShisetsuTaishoTsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoTaishoTsuchishoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.taShichosonJushochiTokureiShisetsuTaishoTsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha._NinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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

/**
 * 介護保険住所地特例施設退所通知書のビジネスクラスです。
 */
public class TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder {

    private final MapperProvider mapperProvider;
    private TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity getEntity;

    public TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.getEntity = new TaShichosonJushochiTokureiShisetsuTaishoTsuchishoRelateEntity();
    }

    /**
     * 他住特施設退所通知書データ作成
     *
     * @param inEntity 他市町村住所地特例者関連帳票発行指示データEntity
     * @return 他住特施設退所通知書データEntity
     */
    public TatokuKanrenChohyoTaishoTsuchishoEntity setTatokuKanrenChohyoTaishoTsuchisho(TatokuKanrenChohyoShijiDataEntity inEntity) {
        TatokuKanrenChohyoTaishoTsuchishoEntity outEntity = new TatokuKanrenChohyoTaishoTsuchishoEntity();
        outEntity.set保険者郵便番号(inEntity.get保険者郵便番号().getEditedYubinNo());
        outEntity.set文書番号(new RString(inEntity.get文書番号().toString()));
        outEntity.set保険者住所(inEntity.get保険者住所());
        outEntity.set発行年月日(inEntity.get発行年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outEntity.set保険者名(inEntity.get保険者名());
        outEntity.set保険者名敬称(inEntity.get保険者名敬称());
        outEntity.set担当部署名(inEntity.get担当部署名());
        outEntity.set担当部署名敬称(inEntity.get担当部署名敬称());

        CustomerBarCode barCode = new CustomerBarCode();
        if (inEntity.get保険者郵便番号() != null && inEntity.get保険者住所() != null) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(new RString(inEntity.get保険者郵便番号().toString()), inEntity.get保険者住所());

            if (result != null) {
                outEntity.setバーコード情報(result.getCustomerBarCode());
            }
        }

        //TODO 見出し文
        RString 被保険者番号 = inEntity.get被保険者番号();
        if (被保険者番号 != null && 10 <= 被保険者番号.length()) {
            outEntity.set被保険者番号１(被保険者番号.substring(0, 1));
            outEntity.set被保険者番号２(被保険者番号.substring(1, 2));
            outEntity.set被保険者番号３(被保険者番号.substring(2, 3));
            outEntity.set被保険者番号４(被保険者番号.substring(3, 4));
            outEntity.set被保険者番号５(被保険者番号.substring(4, 5));
            outEntity.set被保険者番号６(被保険者番号.substring(5, 6));
            outEntity.set被保険者番号７(被保険者番号.substring(6, 7));
            outEntity.set被保険者番号８(被保険者番号.substring(7, 8));
            outEntity.set被保険者番号９(被保険者番号.substring(8, 9));
            outEntity.set被保険者番号１０(被保険者番号.substring(9, 10));
        }

        TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper mapper = mapperProvider.create(TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper.class);
        getEntity = mapper.getTaShichosonJushochiTokureiShisetsuTaishoTsuchisho(inEntity);
        if (getEntity != null) {
            outEntity.set退所年月日(getEntity.get退所年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            outEntity.set退所事由(CodeMaster.getCodeMeisho(new CodeShubetsu("0011"), new Code(getEntity.get他市町村住所地特例解除事由コード())));
            outEntity.set施設名称(getEntity.get事業者名称());
            outEntity.set施設電話番号(getEntity.get電話番号());
            outEntity.set施設FAX番号(getEntity.getFAX番号());
            outEntity.set施設郵便番号(getEntity.get郵便番号());
            outEntity.set施設住所(getEntity.get事業者住所());
        }

        //TODO 宛名取得
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set基準日(new FlexibleDate(outEntity.get退所年月日()));
        key.set識別コード(inEntity.get識別コード());

        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter params = new TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatisParameter(shikibetsuTaishoPSMSearchKey);
        TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper mapper1 = this.mapperProvider.create(TaShichosonJushochiTokureiShisetsuTaishoTsuchishoMapper.class);
        getEntity = mapper1.selectTaShichosonJushochiTokureiShisetsuTaishoTsuchishoMybatis(params);
        if (getEntity != null) {
            if (new RString("3").equals(getEntity.get住民状態コード())) {
                if (!getEntity.get転出確定郵便番号().isEmpty()) {
                    outEntity.set郵便番号(getEntity.get転出確定郵便番号());
                } else {
                    outEntity.set郵便番号(getEntity.get転出予定郵便番号());
                }
                if (!getEntity.get転出確定住所().isEmpty()) {
                    outEntity.set住所(getEntity.get転出確定住所());
                } else {
                    outEntity.set住所(getEntity.get転出予定住所());
                }

            } else {
                outEntity.set郵便番号(getEntity.get郵便番号());
                outEntity.set住所(getEntity.get住所());
            }
        }

        // TODO TechWikiの認証者・電子公印利用ガイド
        INinshoshaSourceBuilderCreator builderCreator = new _NinshoshaSourceBuilderCreator();
        INinshoshaSourceBuilder builder = builderCreator.create(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, null);
        outEntity.set電子公印(builder.buildSource().denshiKoin);

        return outEntity;
    }

}
