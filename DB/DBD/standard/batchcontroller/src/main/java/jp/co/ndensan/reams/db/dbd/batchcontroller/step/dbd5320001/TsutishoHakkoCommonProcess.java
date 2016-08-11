/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiIkatusHakkoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBA;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * バッチ設計_DBD5320001_processの共通処理クラスです。
 *
 * @reamsid_L DBD-1430-020 lit
 */
public class TsutishoHakkoCommonProcess {

    /**
     * 通知文_パターン番号_1
     */
    public static final int 通知文_パターン番号_1 = 1;
    /**
     * 通知文_パターン番号_2
     */
    public static final int 通知文_パターン番号_2 = 2;
    /**
     * 通知文_パターン番号_3
     */
    public static final int 通知文_パターン番号_3 = 3;
    /**
     * 通知文_パターン番号_4
     */
    public static final int 通知文_パターン番号_4 = 4;
    /**
     * 通知文_項目番号_1
     */
    public static final int 通知文_項目番号_1 = 1;
    /**
     * 通知文_項目番号_2
     */
    public static final int 通知文_項目番号_2 = 2;
    /**
     * 通知文_項目番号_3
     */
    public static final int 通知文_項目番号_3 = 3;
    /**
     * 通知文_項目番号_4
     */
    public static final int 通知文_項目番号_4 = 4;
    /**
     * 通知文_項目番号_5
     */
    public static final int 通知文_項目番号_5 = 5;
    /**
     * 通知文_項目番号_6
     */
    public static final int 通知文_項目番号_6 = 6;

    private static final RString 連絡符号 = new RString(",");

    /**
     * 帳票制御情報の取得。
     *
     * @param reportId ReportId
     * @return 帳票制御情報 帳票制御情報
     */
    public static ChohyoSeigyoHanyo get帳票制御情報(ReportId reportId) {
        SearchResult<ChohyoSeigyoHanyo> 帳票制御情報
                = new ChohyoSeigyoHanyoManager().get帳票制御汎用(SubGyomuCode.DBD介護受給, reportId);
        if (null != 帳票制御情報 && !帳票制御情報.records().isEmpty()) {
            return 帳票制御情報.records().get(0);
        }
        return null;
    }

    /**
     * 帳票共通情報の取得。
     *
     * @param reportId ReportId
     * @return 帳票共通情報 帳票共通情報
     */
    public static ChohyoSeigyoKyotsu get帳票共通情報(ReportId reportId) {
        return new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBD介護受給, reportId);
    }

    /**
     * 通知文の取得。
     *
     * @param reportId ReportId
     * @param パターン番号 int
     * @param 項目番号 int
     * @return 通知文 通知文
     */
    public static RString get通知文情報通知文(ReportId reportId, int パターン番号, int 項目番号) {
        Map<Integer, RString> 通知文情報 = ReportUtil.get通知文(SubGyomuCode.DBD介護受給,
                reportId, KamokuCode.EMPTY, パターン番号);
        return null != 通知文情報 ? 通知文情報.get(項目番号) : RString.EMPTY;
    }

    /**
     * 送付物宛先情報の取得。
     *
     * @param 帳票共通情報 ChohyoSeigyoKyotsu
     * @return 送付物宛先情報 送付物宛先情報
     */
    public static SofubutsuAtesakiSource get送付物宛先情報(ChohyoSeigyoKyotsu 帳票共通情報) {
        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        EditedAtesaki 編集後宛先 = EditedAtesakiBuilder.create編集後宛先(宛先, get地方公共団体(), 帳票共通情報);
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }

        return sofubutsuAtesakiSource;
    }

    /**
     * 地方公共団体の取得。
     *
     * @return 地方公共団体 地方公共団体
     */
    public static Association get地方公共団体() {
        return AssociationFinderFactory.createInstance().getAssociation();
    }

    /**
     * 文書番号の取得。
     *
     * @param 文書番号 RString
     * @param reportId ReportId
     * @param 発行日 FlexibleDate
     * @return 文書番号 文書番号
     */
    public static RString get文書番号(RString 文書番号, ReportId reportId, FlexibleDate 発行日) {
        if (null != 文書番号 && !文書番号.isEmpty()) {
            return 文書番号;
        }

        BunshoNo bushoNo = BunshoNoFinderFactory.createInstance().get文書番号管理(reportId, 発行日);
        return null != bushoNo ? bushoNo.edit文書番号() : RString.EMPTY;
    }

    /**
     * タイトルの取得。
     *
     * @param configName ConfigNameDBA
     * @return タイトル タイトル
     */
    public static RString getタイトル(ConfigNameDBA configName) {

        RString タイトル = DbBusinessConfig.get(configName, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        return null != タイトル ? タイトル : RString.EMPTY;
    }

    /**
     * 要介護度名を取得する。
     *
     * @param 厚労省IF識別コード RString
     * @param 要介護度コード RString
     * @return 要介護度名 要介護度名
     */
    public static RString get要介護度名(RString 厚労省IF識別コード, RString 要介護度コード) {
        try {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun99.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun02.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun06.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
                return YokaigoJotaiKubun09.toValue(要介護度コード).get名称();
            }
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return RString.EMPTY;
    }

    /**
     * サービス種類を取得。
     *
     * @param entity YokaigoNinteiIkatusHakkoEntity
     * @return サービス種類 サービス種類
     */
    public static RString getサービス種類(YokaigoNinteiIkatusHakkoEntity entity) {
        if (null == entity) {
            return RString.EMPTY;
        }
        RString サービス種類 = RString.EMPTY;
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類01());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類02());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類03());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類04());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類05());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類06());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類07());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類08());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類09());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類10());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類11());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類12());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類13());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類14());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類15());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類16());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類17());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類18());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類19());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類20());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類21());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類22());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類23());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類24());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類25());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類26());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類27());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類28());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類29());
        サービス種類 = get連絡後文字列(サービス種類, entity.get指定サービス種類30());

        return サービス種類;
    }

    private static RString get連絡後文字列(RString 連絡前文字列, ServiceShuruiCode サービス種類) {
        if (null == サービス種類 || サービス種類.isEmpty()) {
            return 連絡前文字列;
        }

        if (null == 連絡前文字列 || 連絡前文字列.isEmpty()) {
            return サービス種類.value();
        }

        return 連絡前文字列.concat(連絡符号).concat(サービス種類.value());
    }
}
