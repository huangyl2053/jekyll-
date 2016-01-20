/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureishisetsuhenkotsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.TaShichosonJushochiTokureiShisetsuHenkoTsuchisho.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.TaShichosonJushochiTokureiShisetsuHenkoTsuchisho.TatokuKanrenChohyoRenrakuhyoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dba.entity.TatokuKanrenChohyoShijiDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.tashichosonjushochitokureishisetsuhenkotsuchisho.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 */
public class TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder {

    private final MapperProvider mapperProvider;

    public TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 他住特施設変更通知書データ作成
     *
     * @param inEntity 他市町村住所地特例者関連帳票発行指示データEntity
     * @return 他住特施設変更通知書データEntity
     */
    public TatokuKanrenChohyoHenkoTsuchishoEntity setTatokuKanrenChohyoTaishoTsuchisho(TatokuKanrenChohyoShijiDataEntity inEntity) {
        TatokuKanrenChohyoHenkoTsuchishoEntity outEntity = new TatokuKanrenChohyoHenkoTsuchishoEntity();
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
        //TODO　　QA #73406 見出し文
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

        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        builder.set基準日(inEntity.get入所年月日());
        builder.set識別コード(inEntity.get識別コード());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = builder.build();
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter params
                = new TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatisParameter(shikibetsuTaishoPSMSearchKey);
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper iShikibetsuTaishoPSMSearchKeyMapper = this.mapperProvider.create(TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper.class);
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity pSMEntity = iShikibetsuTaishoPSMSearchKeyMapper.selectTaShichosonJushochiTokureiShisetsuHenkoTsuchishoMybatis(params);
        if (pSMEntity != null) {
            outEntity.set対象者名カナ(pSMEntity.getカナ名称());
            outEntity.set対象者名(pSMEntity.get名称());
            outEntity.set誕生日(pSMEntity.get生年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            outEntity.set性別(pSMEntity.get性別コード());
        }

        outEntity.set変更年月日(inEntity.get入所年月日());
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper mapper = this.mapperProvider.create(TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper.class);
        List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> entityList = mapper.getTaShichosonJushochiTokureiShisetsuHenkoTsuchisho(inEntity);
        if (entityList.get(0) != null) {
            outEntity.set変更前施設名称(entityList.get(0).getJigyoshaMeisho());
            outEntity.set変更前施設電話番号(entityList.get(0).getTelNo());
            outEntity.set変更前施設FAX番号(entityList.get(0).getFaxNo());
            outEntity.set変更前施設郵便番号(entityList.get(0).getYubinNo());
            outEntity.set変更前施設住所(entityList.get(0).getJigyoshaJusho());
        }
        if (entityList.get(1) != null) {
            outEntity.set変更後施設名称(entityList.get(1).getJigyoshaMeisho());
            outEntity.set変更後施設電話番号(entityList.get(1).getTelNo());
            outEntity.set変更後施設FAX番号(entityList.get(1).getFaxNo());
            outEntity.set変更後施設郵便番号(entityList.get(1).getYubinNo());
            outEntity.set変更後施設住所(entityList.get(1).getJigyoshaJusho());
        }

        //TODO QA #73406 TechWikiの認証者・電子公印利用ガイド
        outEntity.set電子公印(new RString(""));
        outEntity.set証明発行日(inEntity.get発行年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outEntity.set首長名(new RString(""));
        outEntity.set市町村名(new RString(""));
        outEntity.set公印省略(new RString(""));
        return outEntity;
    }

    /**
     * 他住特施設退所通知書データ作成
     *
     * @param inEntity
     * @return 他住特施設連絡票データEntity
     */
    public TatokuKanrenChohyoRenrakuhyoEntity setTatokuKanrenChohyoRenrakuhyo(TatokuKanrenChohyoShijiDataEntity inEntity) {
        TatokuKanrenChohyoRenrakuhyoEntity outEntity = new TatokuKanrenChohyoRenrakuhyoEntity();
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
            CustomerBarCodeResult barresult = barCode.convertCustomerBarCode(new RString(inEntity.get保険者郵便番号().toString()), inEntity.get保険者住所());
            if (barresult != null) {
                outEntity.setバーコード情報(barresult.getCustomerBarCode());
            }
        }
        //TODO QA #73406見出し文
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

        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper mapper = this.mapperProvider.create(TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper.class);
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity getEntity = mapper.setTatokuKanrenChohyoRenrakuhyo(inEntity);
        if (getEntity != null) {
            outEntity.set入所年月日(getEntity.get入所年月日());
            outEntity.set施設名称(getEntity.get事業者名称());
            outEntity.set施設電話番号(getEntity.get電話番号());
            outEntity.set施設FAX番号(getEntity.getFAX番号());
            outEntity.set施設郵便番号(getEntity.get郵便番号().getEditedYubinNo());
            outEntity.set施設住所(getEntity.get事業者住所());
        }

        FlexibleDate 入所年月日 = FlexibleDate.EMPTY;
        if (getEntity != null) {
            入所年月日 = getEntity.get入所年月日();
        }
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set基準日(入所年月日);
        key.set識別コード(inEntity.get識別コード());

        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        TatokuKanrenChohyoRenrakuhyoMybatisParameter params = new TatokuKanrenChohyoRenrakuhyoMybatisParameter(shikibetsuTaishoPSMSearchKey);
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper iShikibetsuTaishoPSMSearchKeyMapper = this.mapperProvider.create(TaShichosonJushochiTokureiShisetsuHenkoTsuchishoMapper.class);
        TaShichosonJushochiTokureiShisetsuHenkoTsuchishoRelateEntity iShikibetsuTaishoPSMSearchKeyEntity = iShikibetsuTaishoPSMSearchKeyMapper.selectTatokuKanrenChohyoRenrakuhyoMybatis(params);
        if (iShikibetsuTaishoPSMSearchKeyEntity != null) {
            outEntity.set対象者名カナ(iShikibetsuTaishoPSMSearchKeyEntity.getカナ名称());
            outEntity.set対象者名(iShikibetsuTaishoPSMSearchKeyEntity.get名称());
            outEntity.set誕生日(iShikibetsuTaishoPSMSearchKeyEntity.get生年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            outEntity.set性別(iShikibetsuTaishoPSMSearchKeyEntity.get性別コード());
            outEntity.set郵便番号(iShikibetsuTaishoPSMSearchKeyEntity.get転入前郵便番号().getEditedYubinNo());
            outEntity.set住所(iShikibetsuTaishoPSMSearchKeyEntity.get転入前住所());
            outEntity.set転入年月日(iShikibetsuTaishoPSMSearchKeyEntity.get登録異動年月日());
        }

        //TODO QA #73406 TechWikiの認証者・電子公印利用ガイド
        // IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険);;
        // AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        outEntity.set電子公印(new RString(""));
        outEntity.set証明発行日(inEntity.get発行年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        outEntity.set首長名(new RString(""));
        outEntity.set市町村名(new RString(""));
        outEntity.set公印省略(new RString(""));
        return outEntity;
    }
}
