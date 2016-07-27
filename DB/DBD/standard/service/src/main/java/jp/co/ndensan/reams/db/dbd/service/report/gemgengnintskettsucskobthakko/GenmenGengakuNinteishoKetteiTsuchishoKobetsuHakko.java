/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko;

import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.FutanGendogakuNinteishoPrintService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.business.report.GemmenGengakuNinteishoKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100020.FutanGendogakuNinteishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100017.HomKaigRiysFutgGengNinteishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100015.RiysFutgGengMenjNinteishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100012.ShakFuksHjRiysFutKgTsKtTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100022.TokubchiiKasHomKaigRiysFutGengKakuninshoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100013.FutanGendogakuKetteiTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100011.HomKaigRiysFutgGengKettTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100009.RiysFutgGengMenjKettTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100014.HomKaigRiysFutGenmKettTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.util.AtesakiPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.util.ShikibetsuTaishoPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.util.IAtesakiPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.util.IShikibetsuTaishoPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenManager;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.FutanGendogakuKetteiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.HomKaigRiysFutGenmKettTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.HomKaigRiysFutgGengKettsuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.HomKaigRiysFutgGengNintshoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.RiysFutgGengMenjNinteishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.RiysFutgGengMenjKettTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.ShakFukusHojRiysFutKeigTaisKetTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.ShakfukusRiysFutKeigTaisKakuninshoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printservice.TokubChiiKasRiysFutGengKakuninshoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.IHakkoRirekiManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 減免減額認定証・決定通知書個別発行（画面）というビジネスクラスです。
 *
 * @reamsid_L DBD-3540-030 wangchao
 */
public class GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko {

    private final int パターン番号_１ = 1;
    private final int パターン番号_２ = 2;
    private final int パターン番号_３ = 3;
    private final int パターン番号_４ = 4;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko}のインスタンス
     */
    public static GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko createInstance() {
        return InstanceProvider.create(GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.class);
    }

    /**
     * 選択した帳票を発行する
     *
     * @param 帳票タイプリスト LIST<帳票タイプ>
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @param 減免減額種類 減免減額種類
     * @param 交付日 交付日
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param reportManager 帳票発行処理の制御機能
     */
    public void publish(List<RString> 帳票タイプリスト, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード,
            int 履歴番号, RString 減免減額種類, RDate 交付日, RDate 発行日, RString 文書番号, ReportManager reportManager) {

        Association association = get地方公共団体();
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = get宛名情報(識別コード);
        UaFt250FindAtesakiEntity uaFt250Entity = get宛先情報(識別コード);

        ReportId 帳票分類ID = get帳票分類ID(帳票タイプリスト);
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<DbT7067ChohyoSeigyoHanyoEntity> dbT7067EntityList = load帳票制御汎用(帳票分類ID);
        Ninshosha ninshosha = get認証者情報(new FlexibleDate(発行日.toDateString()));
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプリスト);
        for (RString 帳票タイプ : 帳票タイプリスト) {
            if (GemmenGengakuNinteishoKetteiTsuchisho.利用者負担額減額_免除等認定証.get名称().equals(帳票タイプ)) {
                RiyoshaFutangakuGengaku 利用者負担額減額情報 = getRiyoshaFutanGengaku(
                        被保険者番号, GemmenGengakuShurui.利用者負担額減額.getコード(), 履歴番号);
                RiysFutgGengMenjNinteishoItem item = new RiysFutgGengMenjNinteishoItem(
                        利用者負担額減額情報,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        交付日,
                        発行日,
                        帳票分類ID,
                        ninshosha);
                RiysFutgGengMenjNinteishoPrintService service = new RiysFutgGengMenjNinteishoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.利用者負担額減額_免除決定通知書.get名称().equals(帳票タイプ)) {
                RiyoshaFutangakuGengaku 利用者負担額減額情報 = getRiyoshaFutanGengaku(
                        被保険者番号, GemmenGengakuShurui.利用者負担額減額.getコード(), 履歴番号);
                RiysFutgGengMenjKettTsuchishoItem item = new RiysFutgGengMenjKettTsuchishoItem(
                        利用者負担額減額情報,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        発行日,
                        文書番号,
                        通知書定型文List,
                        帳票分類ID,
                        ninshosha);
                RiysFutgGengMenjKettTsuchishoPrintService service = new RiysFutgGengMenjKettTsuchishoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.負担限度額認定証.get名称().equals(帳票タイプ)) {
                FutanGendogakuNintei 負担限度額認定 = getFutanGendogaKunintei(被保険者番号, GemmenGengakuShurui.負担限度額認定.getコード(), 履歴番号);
                FutanGendogakuNinteishoItem item = new FutanGendogakuNinteishoItem(
                        負担限度額認定,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        交付日,
                        発行日,
                        帳票分類ID,
                        ninshosha);
                FutanGendogakuNinteishoPrintService service = new FutanGendogakuNinteishoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.負担限度額決定通知書.get名称().equals(帳票タイプ)) {
                FutanGendogakuNintei 負担限度額認定 = getFutanGendogaKunintei(被保険者番号, GemmenGengakuShurui.負担限度額認定.getコード(), 履歴番号);
                FutanGendogakuKetteiTsuchishoItem item = new FutanGendogakuKetteiTsuchishoItem(
                        負担限度額認定,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        発行日,
                        文書番号,
                        通知書定型文List,
                        帳票分類ID,
                        ninshosha);
                FutanGendogakuKetteiTsuchishoPrintService service = new FutanGendogakuKetteiTsuchishoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.訪問介護利用者負担額減額認定証.get名称().equals(帳票タイプ)) {
                HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額 = getHomonKaigoGengaku(
                        被保険者番号, GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(), 履歴番号);
                HomKaigRiysFutgGengNinteishoItem item = new HomKaigRiysFutgGengNinteishoItem(
                        訪問介護利用者負担額減額,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        交付日,
                        発行日,
                        帳票分類ID,
                        ninshosha);
                HomKaigRiysFutgGengNintshoPrintService service = new HomKaigRiysFutgGengNintshoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.訪問介護等利用者負担額減額決定通知書.get名称().equals(帳票タイプ)) {
                HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額 = getHomonKaigoGengaku(
                        被保険者番号, GemmenGengakuShurui.訪問介護利用者負担額減額.getコード(), 履歴番号);
                HomKaigRiysFutgGengKettTsuchishoItem item = new HomKaigRiysFutgGengKettTsuchishoItem(
                        訪問介護利用者負担額減額,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        発行日,
                        文書番号,
                        通知書定型文List,
                        帳票分類ID,
                        ninshosha);
                HomKaigRiysFutgGengKettsuchishoPrintService service = new HomKaigRiysFutgGengKettsuchishoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.社会福祉法人等利用者負担軽減対象確認証.get名称().equals(帳票タイプ)) {

                ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減 = getShafukuKeigen(
                        被保険者番号, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード(), 履歴番号);
                ShakfukusRiysFutKeigTaisKakuninshoItem item = new ShakfukusRiysFutKeigTaisKakuninshoItem(
                        社会福祉法人等利用者負担軽減,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        交付日,
                        発行日,
                        帳票分類ID,
                        ninshosha);
                ShakfukusRiysFutKeigTaisKakuninshoPrintService service = new ShakfukusRiysFutKeigTaisKakuninshoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.社会福祉法人等利用者負担軽減決定通知書.get名称().equals(帳票タイプ)) {
                ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減 = getShafukuKeigen(
                        被保険者番号, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード(), 履歴番号);
                ShakFuksHjRiysFutKgTsKtTsuchishoItem item = new ShakFuksHjRiysFutKgTsKtTsuchishoItem(
                        社会福祉法人等利用者負担軽減,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        発行日,
                        文書番号,
                        通知書定型文List,
                        帳票分類ID,
                        ninshosha);
                ShakFukusHojRiysFutKeigTaisKetTsuchishoPrintService service = new ShakFukusHojRiysFutKeigTaisKetTsuchishoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.特別地域加算に係る訪問介護利用者負担減額確認証.get名称().equals(帳票タイプ)) {
                TokubetsuchiikiKasanGemmen 特別地域加算減免 = getTokubetsuChikiKasanGemmen(
                        被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード(), 履歴番号);
                TokubchiiKasHomKaigRiysFutGengKakuninshoItem item = new TokubchiiKasHomKaigRiysFutGengKakuninshoItem(
                        特別地域加算減免,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        交付日,
                        発行日,
                        帳票分類ID,
                        ninshosha);
                TokubChiiKasRiysFutGengKakuninshoPrintService service = new TokubChiiKasRiysFutGengKakuninshoPrintService();
                service.print(item, reportManager);
            } else if (GemmenGengakuNinteishoKetteiTsuchisho.特別地域加算減免_訪問介護利用者負担減額決定通知書.get名称().equals(帳票タイプ)) {
                TokubetsuchiikiKasanGemmen 特別地域加算減免 = getTokubetsuChikiKasanGemmen(
                        被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード(), 履歴番号);
                HomKaigRiysFutGenmKettTsuchishoItem item = new HomKaigRiysFutGenmKettTsuchishoItem(
                        特別地域加算減免,
                        ShikibetsuTaishoFactory.createKojin(uaFt200Entity),
                        AtesakiFactory.createInstance(uaFt250Entity),
                        new ChohyoSeigyoKyotsu(dbT7065Entity),
                        dbT7067EntityList,
                        association,
                        発行日,
                        文書番号,
                        通知書定型文List,
                        帳票分類ID,
                        ninshosha);
                HomKaigRiysFutGenmKettTsuchishoPrintService service = new HomKaigRiysFutGenmKettTsuchishoPrintService();
                service.print(item, reportManager);
            }
        }
    }

    /**
     * 発行履歴の登録
     *
     * @param sourceData SourceDataCollectionのSourceData
     * @param 発行日 発行日
     * @param 識別コード 識別コード
     * @param hashMap 業務固有情報hashmap
     */
    public void insert発行履歴(SourceData sourceData, RDate 発行日, ShikibetsuCode 識別コード, HashMap<Code, RString> hashMap) {
        IHakkoRirekiManager manager = HakkoRirekiManagerFactory.createInstance();
        List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
        shikibetsuCodeList.add(識別コード);
        manager.insert帳票発行履歴(
                sourceData,
                new FlexibleDate(発行日.toDateString()),
                ChohyoHakkoRirekiJotai.新規作成,
                hashMap, shikibetsuCodeList
        );
    }

    private List get通知書定型文List(ReportId 帳票分類ID, DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity, List<RString> 帳票タイプリスト) {
        List<RString> 通知書定型文List = new ArrayList<>();
        if (GemmenGengakuNinteishoKetteiTsuchisho.利用者負担額減額_免除決定通知書.get名称().equals(帳票タイプリスト.get(0))
                || GemmenGengakuNinteishoKetteiTsuchisho.負担限度額決定通知書.get名称().equals(帳票タイプリスト.get(0))
                || GemmenGengakuNinteishoKetteiTsuchisho.社会福祉法人等利用者負担軽減決定通知書.get名称().equals(帳票タイプリスト.get(0))
                || GemmenGengakuNinteishoKetteiTsuchisho.訪問介護等利用者負担額減額決定通知書.get名称().equals(帳票タイプリスト.get(0))
                || GemmenGengakuNinteishoKetteiTsuchisho.特別地域加算減免_訪問介護利用者負担減額決定通知書.get名称().equals(帳票タイプリスト.get(0))) {
            int パターン番号 = 0;
            if (TeikeibunMojiSize.フォント小.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_１;
            } else if (TeikeibunMojiSize.フォント大.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_２;
            } else if (TeikeibunMojiSize.フォント上小下大.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_３;
            } else if (TeikeibunMojiSize.フォント上大下小.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_４;
            }
            Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票分類ID, KamokuCode.EMPTY, パターン番号);
            for (Map.Entry<Integer, RString> entry : 通知文Map.entrySet()) {
                通知書定型文List.add(entry.getValue());
            }
        }
        return 通知書定型文List;
    }

    private ReportId get帳票分類ID(List<RString> 帳票タイプリスト) {
        if (GemmenGengakuNinteishoKetteiTsuchisho.利用者負担額減額_免除決定通知書.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100009.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.利用者負担額減額_免除等認定証.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100015.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.負担限度額決定通知書.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100013.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.負担限度額認定証.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100020.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.社会福祉法人等利用者負担軽減決定通知書.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100012.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.社会福祉法人等利用者負担軽減対象確認証.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100018.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.訪問介護等利用者負担額減額決定通知書.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100011.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.訪問介護利用者負担額減額認定証.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100017.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.特別地域加算減免_訪問介護利用者負担減額決定通知書.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100014.getReportId();

        } else if (GemmenGengakuNinteishoKetteiTsuchisho.特別地域加算に係る訪問介護利用者負担減額確認証.get名称().equals(帳票タイプリスト.get(0))) {
            return ReportIdDBD.DBD100022.getReportId();
        }
        return null;
    }

    private RiyoshaFutangakuGengaku getRiyoshaFutanGengaku(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        RiyoshaFutangakuGengakuManager riyoshaFutangakuGengakuManager = RiyoshaFutangakuGengakuManager.createInstance();
        return riyoshaFutangakuGengakuManager.get利用者負担額減額(被保険者番号, 減免減額種類, 履歴番号);
    }

    private FutanGendogakuNintei getFutanGendogaKunintei(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        FutanGendogakuNinteiManager futanGendogakuNinteiManager = FutanGendogakuNinteiManager.createInstance();
        return futanGendogakuNinteiManager.get負担限度額認定(被保険者番号, 減免減額種類, 履歴番号);
    }

    private ShakaifukuRiyoshaFutanKeigen getShafukuKeigen(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        ShafukuRiyoshaFutanKeigenManager shafukuRiyoshaFutanKeigenManager = ShafukuRiyoshaFutanKeigenManager.createInstance();
        return shafukuRiyoshaFutanKeigenManager.get社会福祉法人等利用者負担軽減(被保険者番号, 減免減額種類, 履歴番号);
    }

    private HomonKaigoRiyoshaFutangakuGengaku getHomonKaigoGengaku(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        HomonKaigoRiyoshaFutangakuGengakuManager homonKaigoRiyoshaFutangakuGengakuManager = HomonKaigoRiyoshaFutangakuGengakuManager.createInstance();
        return homonKaigoRiyoshaFutangakuGengakuManager.get訪問介護利用者負担額減額(被保険者番号, 減免減額種類, 履歴番号);
    }

    private TokubetsuchiikiKasanGemmen getTokubetsuChikiKasanGemmen(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        TokubetsuchiikiKasanGemmenManager tokubetsuchiikiKasanGemmenManager = TokubetsuchiikiKasanGemmenManager.createInstance();
        return tokubetsuchiikiKasanGemmenManager.get特別地域加算減免(被保険者番号, 減免減額種類, 履歴番号);
    }

    private Association get地方公共団体() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        return finder.getAssociation();
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoPSMSearchKeyBuilder shikibetsuTaishoPSMKey
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        shikibetsuTaishoPSMKey.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = shikibetsuTaishoPSMKey.build();
        ShikibetsuTaishoPSMMybatisParameter shikibetsuTaishoPSMParameter = new ShikibetsuTaishoPSMMybatisParameter(shikibetsuTaishoPSMSearchKey);
        shikibetsuTaishoPSMParameter.setPsmShikibetsuTaisho(new RString(shikibetsuTaishoPSMParameter.toString()));
        IShikibetsuTaishoPSMMybatisMapper shikibetsuTaishoPSMMapper = this.mapperProvider.create(IShikibetsuTaishoPSMMybatisMapper.class);
        return shikibetsuTaishoPSMMapper.selectShikibetsuTaishoPSMMybatis(shikibetsuTaishoPSMParameter);
    }

    private UaFt250FindAtesakiEntity get宛先情報(ShikibetsuCode 識別コード) {
        AtesakiPSMSearchKeyBuilder atesakiPSMKey
                = new AtesakiPSMSearchKeyBuilder(AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        atesakiPSMKey.set識別コード(識別コード);
        IAtesakiPSMSearchKey atesakiPSMSearchKey = atesakiPSMKey.build();
        AtesakiPSMMybatisParameter atesakiPSMMybatisParameter = new AtesakiPSMMybatisParameter(atesakiPSMSearchKey);
        atesakiPSMMybatisParameter.setPsmAtesaki(new RString(atesakiPSMMybatisParameter.toString()));
        IAtesakiPSMMybatisMapper atesakiPSMMapper = this.mapperProvider.create(IAtesakiPSMMybatisMapper.class);
        return atesakiPSMMapper.selectAtesakiPSMMybatis(atesakiPSMMybatisParameter);
    }

    /**
     * 帳票制御共通を取得します
     *
     * @param 帳票分類ID 帳票分類ID
     * @return 帳票制御共通
     */
    public DbT7065ChohyoSeigyoKyotsuEntity load帳票制御共通(ReportId 帳票分類ID) {
        if (帳票分類ID == null || 帳票分類ID.isEmpty()) {
            throw new NullPointerException();
        }
        DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        return dbT7065Dac.selectByKey(SubGyomuCode.DBD介護受給, 帳票分類ID);
    }

    /**
     * 帳票制御汎用をキーから取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return List<帳票制御汎用>
     */
    public List load帳票制御汎用(ReportId 帳票分類ID) {
        DbT7067ChohyoSeigyoHanyoDac dbT7067Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        return dbT7067Dac.get帳票制御汎用(SubGyomuCode.DBD介護受給, 帳票分類ID, new FlexibleYear("0000"));
    }

    private Ninshosha get認証者情報(FlexibleDate kaisiYMD) {
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        return ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), kaisiYMD);
    }
}
