/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kakushutsuchishosakusei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.FukaDaityouInfo;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoCommonInfo;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kakushutsuchishosakusei.IKakushuTsuchishoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dainonin.Dainonin;
import jp.co.ndensan.reams.ua.uax.business.core.dainonin.DainoninRelate;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.dainonin.DainoninRelateFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 各種通知書作成（個別）クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
public class KakushuTsuchishoSakuseiFath {

    private static final RString 処理名 = new RString("本算定賦課");
    private static final RString 番号 = new RString("0001");
    private static final RString キー_調定日 = new RString("調定日");
    private static final RString キー_識別コード = new RString("識別コード");
    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final DbT4021ShiharaiHohoHenkoDac 支払方法変更Dac;
    private final DbV4001JukyushaDaichoAliveDac 受給者台帳Dac;
    private final DbT7022ShoriDateKanriDac 処理日付Dac;

    /**
     * コンストラクタです。
     */
    public KakushuTsuchishoSakuseiFath() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.支払方法変更Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.受給者台帳Dac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        this.処理日付Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KakushuTsuchishoSakuseiFath}のインスタンスを返します。
     *
     * @return KakushuTsuchishoSakusei
     */
    public static KakushuTsuchishoSakuseiFath createInstance() {
        return InstanceProvider.create(KakushuTsuchishoSakuseiFath.class);
    }

    /**
     *
     * 賦課台帳情報取得メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return FukaDaityouInfo
     */
    public FukaDaityouInfo load賦課台帳情報(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        FukaJoho 賦課の情報_更正後 = parameter.get賦課の情報_更正後();
        FukaJoho 賦課の情報更正後 = 通知書共通情報.get賦課の情報_更正後().get賦課情報();
        if (賦課の情報_更正後 == null || 賦課の情報更正後 == null) {
            return null;
        }
        FukaDaityouInfo 賦課台帳情報 = new FukaDaityouInfo();
        IShikibetsuTaisho 識別対象 = null;
        List<GyomuCode> list = new ArrayList<>();
        list.add(GyomuCode.DB介護保険);
        List<DainoninRelate> 代納人情報リスト = DainoninRelateFinderFactory.createInstance().get代納人byサブ業務コード(
                賦課の情報_更正後.get識別コード(), list, SubGyomuCode.DBB介護賦課);
        if (代納人情報リスト != null && !代納人情報リスト.isEmpty()) {
            for (DainoninRelate 代納人情報 : 代納人情報リスト) {
                Dainonin 代納人 = 代納人情報.get代納人();
                FlexibleDate 発行日 = new FlexibleDate(RDate.getNowDate().toDateString());
                if (代納人.get開始年月日().isBeforeOrEquals(発行日) && 発行日.isBeforeOrEquals(代納人.get終了年月日())) {
                    識別対象 = 代納人情報.get識別対象();
                    break;
                }
            }
        }
        賦課台帳情報.set代納人情報(識別対象);

        SetaiinShotokuJohoFinder 世帯員所得情報Finder = SetaiinShotokuJohoFinder.createInstance();
        List<SetaiinShotoku> 世帯員所得情報 = 世帯員所得情報Finder.get世帯員所得情報(賦課の情報_更正後.get識別コード(),
                賦課の情報_更正後.get賦課期日(), 賦課の情報_更正後.get賦課年度(), null, false);
        賦課台帳情報.set世帯員所得情報(世帯員所得情報);
        TelNo 本人連絡先1 = 通知書共通情報.get宛名情報().get連絡先１();
        TelNo 本人連絡先2 = 通知書共通情報.get宛名情報().get連絡先２();
        TelNo 代納人連絡先1 = TelNo.EMPTY;
        TelNo 代納人連絡先2 = TelNo.EMPTY;

        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
        if (識別対象 != null) {
            Map<String, Object> para = new HashMap<>();
            para.put(キー_調定日.toString(), 賦課の情報_更正後.get調定日時().getDate().toDateString());
            para.put(キー_識別コード.toString(), 識別対象.get識別コード());
            UaFt200FindShikibetsuTaishoEntity 代納人の宛名情報 = mapper.get代納人の宛名情報(para);
            if (代納人の宛名情報 != null) {
                代納人連絡先1 = 代納人の宛名情報.getRenrakusaki1();
                代納人連絡先2 = 代納人の宛名情報.getRenrakusaki2();
            }
        }
        賦課台帳情報.set本人連絡先1(本人連絡先1);
        賦課台帳情報.set本人連絡先2(本人連絡先2);
        賦課台帳情報.set代納人連絡先1(代納人連絡先1);
        賦課台帳情報.set代納人連絡先2(代納人連絡先2);

        //TODO 4.1　境界層当該者情報を取得する。(介護保険者境界層当該者台帳)
        DbT1001HihokenshaDaichoEntity 被保険者台帳情報 = 被保険者台帳管理Dac.selectByHihokensha(賦課の情報更正後.get被保険者番号());
        賦課台帳情報.set被保険者台帳情報(被保険者台帳情報);
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更リスト = 支払方法変更Dac.get支支払方法変更(賦課の情報更正後.get被保険者番号());
        賦課台帳情報.set支払方法変更リスト(支払方法変更リスト);
        DbV4001JukyushaDaichoEntity 受給者台帳情報 = 受給者台帳Dac.select受給者台帳情報(賦課の情報更正後.get被保険者番号());
        賦課台帳情報.set受給者台帳情報(受給者台帳情報);
        DbT7022ShoriDateKanriEntity 処理日付マスタ
                = 処理日付Dac.selectByKey(SubGyomuCode.DBB介護賦課, 通知書共通情報.get地方公共団体().getLasdecCode_(),
                        処理名, 番号, 賦課の情報更正後.get賦課年度(), 番号);
        if (処理日付マスタ != null) {
            賦課台帳情報.set基準日時(処理日付マスタ.getKijunTimestamp());
        }
        return 賦課台帳情報;
    }
}
