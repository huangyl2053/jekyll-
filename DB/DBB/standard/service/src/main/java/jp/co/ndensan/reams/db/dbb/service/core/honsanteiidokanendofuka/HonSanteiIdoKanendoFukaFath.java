/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KeisangoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingakuFactory;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka.KeisangojohoToKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2013HokenryoDankaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定異動（過年度）（バッチ）のビジネスクラスです。
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
public class HonSanteiIdoKanendoFukaFath {

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int INT_15 = 15;
    private static final int INT_16 = 16;
    private static final int INT_17 = 17;
    private static final int INT_18 = 18;
    private static final int INT_19 = 19;
    private static final int INT_20 = 20;
    private final DbT2013HokenryoDankaiDac 保険料段階Dac;

    /**
     * コンストラクタです
     */
    HonSanteiIdoKanendoFukaFath() {
        this.保険料段階Dac = InstanceProvider.create(DbT2013HokenryoDankaiDac.class);
    }

    /**
     * 年額制御情報を取得します。
     *
     * @param 賦課年度 賦課年度
     * @return 年額制御情報
     */
    protected NengakuSeigyoJoho get年額制御情報(FlexibleYear 賦課年度) {
        RDate nowDate = RDate.getNowDate();
        Decimal 端数単位 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_通常,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        Decimal 端数単位_ランク用 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_ランク変更のみ,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法_ランク用 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_ランク変更のみ,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 端数調整対象 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整対象,
                nowDate, SubGyomuCode.DBB介護賦課);
        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<>();
        setランク別制御情報(ランク別制御情報, 賦課年度);
        NengakuSeigyoJohoFactory nengakuSeigyoJohoFactory = InstanceProvider.create(NengakuSeigyoJohoFactory.class);
        NengakuSeigyoJoho 年額制御情報 = nengakuSeigyoJohoFactory.createNengakuSeigyoJoho(
                端数単位,
                HasuChoseiHoho.toValue(端数調整方法),
                端数単位_ランク用,
                HasuChoseiHoho.toValue(端数調整方法_ランク用),
                HasuChoseiTaisho.toValue(端数調整対象),
                ランク別制御情報);
        return 年額制御情報;
    }

    private void setランク別制御情報(Map<RString, RankBetsuKijunKingaku> ランク別制御情報, FlexibleYear 賦課年度) {
        List<DbT2013HokenryoDankaiEntity> 保険料段階List = 保険料段階Dac.get保険料ランク別制御情報(賦課年度);
        if (保険料段階List.isEmpty()) {
            return;
        }
        List<DbT2013HokenryoDankaiEntity> 段階List = new ArrayList<>();
        DbT2013HokenryoDankaiEntity 段階 = 保険料段階List.get(0);
        段階List.add(段階);
        for (int i = INT_1; i < 保険料段階List.size(); i++) {
            if (段階.getRankuKubun().equals(保険料段階List.get(i).getRankuKubun())) {
                段階List.add(保険料段階List.get(i));
            } else {
                RankBetsuKijunKingaku gagu = createRankBetsuKijunKingaku(段階List);
                ランク別制御情報.put(段階.getRankuKubun(), gagu);
                段階List.clear();
                段階List.add(保険料段階List.get(i));
            }
            段階 = 保険料段階List.get(i);
        }
        RankBetsuKijunKingaku gagu = createRankBetsuKijunKingaku(段階List);
        ランク別制御情報.put(段階.getRankuKubun(), gagu);
    }

    private RankBetsuKijunKingaku createRankBetsuKijunKingaku(List<DbT2013HokenryoDankaiEntity> 段階List) {
        RankBetsuKijunKingakuFactory factory = InstanceProvider.create(RankBetsuKijunKingakuFactory.class);
        RankBetsuKijunKingaku 基準金額 = factory.createRankBetsuKijunKingaku(get基準金額(段階List, INT_1),
                get基準金額(段階List, INT_2),
                get基準金額(段階List, INT_3),
                get基準金額(段階List, INT_4),
                get基準金額(段階List, INT_5),
                get基準金額(段階List, INT_6),
                get基準金額(段階List, INT_7),
                get基準金額(段階List, INT_8),
                get基準金額(段階List, INT_9),
                get基準金額(段階List, INT_10),
                get基準金額(段階List, INT_11),
                get基準金額(段階List, INT_12),
                get基準金額(段階List, INT_13),
                get基準金額(段階List, INT_14),
                get基準金額(段階List, INT_15),
                get基準金額(段階List, INT_16),
                get基準金額(段階List, INT_17),
                get基準金額(段階List, INT_18),
                get基準金額(段階List, INT_19),
                get基準金額(段階List, INT_20));
        return 基準金額;
    }

    private Decimal get基準金額(List<DbT2013HokenryoDankaiEntity> 段階List, int index) {
        if (段階List.isEmpty()) {
            return Decimal.ZERO;
        }
        if (段階List.size() > index) {
            return 段階List.get(index - INT_1).getHokenryoRitsu();
        }
        return Decimal.ZERO;
    }

    /**
     * 資格の情報年度のsort処理です。
     *
     * @param 資格の情報年度 資格の情報年度
     */
    protected void sort資格情報By第1号資格取得年月日(List<HihokenshaDaicho> 資格の情報年度) {
        Collections.sort(資格の情報年度, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                return o1.get第1号資格取得年月日() != null && o2.get第1号資格取得年月日().isBefore(o1.get第1号資格取得年月日()) ? 1 : -1;
            }
        });
    }

    /**
     * 賦課の情報のsort処理です。
     *
     * @param 賦課の情報 賦課の情報
     */
    protected void sort賦課の情報By通知書番号(List<FukaJoho> 賦課の情報) {
        if (賦課の情報 == null || 賦課の情報.isEmpty()) {
            return;
        }
        Collections.sort(賦課の情報, new Comparator<FukaJoho>() {
            @Override
            public int compare(FukaJoho o1, FukaJoho o2) {
                return o1.get通知書番号().compareTo(o2.get通知書番号());
            }
        });
    }

    /**
     * 賦課の計算結果と、宛名口座情報を設定します。
     *
     * @param entity entity
     * @return KeisangojohoAtenaKozaEntity
     */
    protected KeisangojohoAtenaKozaEntity setKeisangojohoAtenaKozaEntity(KeisangojohoToKozaEntity entity) {
        KeisangoJoho keisangoJoho = new KeisangoJoho(entity.get計算後情報());
        KeisangojohoAtenaKozaEntity atenaKozaEntity = new KeisangojohoAtenaKozaEntity();
        atenaKozaEntity.set調定年度(keisangoJoho.get調定年度());
        atenaKozaEntity.set賦課年度(keisangoJoho.get賦課年度());
        atenaKozaEntity.set通知書番号(keisangoJoho.get通知書番号());
        atenaKozaEntity.set更正前後区分(keisangoJoho.get更正前後区分());
        atenaKozaEntity.set作成処理名(keisangoJoho.get作成処理名());
        atenaKozaEntity.set賦課履歴番号(keisangoJoho.get賦課履歴番号());
        atenaKozaEntity.set被保険者番号(keisangoJoho.get被保険者番号());
        atenaKozaEntity.set識別コード(keisangoJoho.get識別コード());
        atenaKozaEntity.set世帯コード(keisangoJoho.get世帯コード());
        atenaKozaEntity.set世帯員数(keisangoJoho.get世帯員数());
        atenaKozaEntity.set資格取得日(keisangoJoho.get資格取得日());
        atenaKozaEntity.set資格取得事由(keisangoJoho.get資格取得事由());
        atenaKozaEntity.set資格喪失日(keisangoJoho.get資格喪失日());
        atenaKozaEntity.set資格喪失事由(keisangoJoho.get資格喪失事由());
        atenaKozaEntity.set生活保護扶助種類(keisangoJoho.get生活保護扶助種類());
        atenaKozaEntity.set生保開始日(keisangoJoho.get生保開始日());
        atenaKozaEntity.set生保廃止日(keisangoJoho.get生保廃止日());
        atenaKozaEntity.set老齢開始日(keisangoJoho.get老齢開始日());
        atenaKozaEntity.set老齢廃止日(keisangoJoho.get老齢廃止日());
        atenaKozaEntity.set賦課期日(keisangoJoho.get賦課期日());
        atenaKozaEntity.set課税区分(keisangoJoho.get課税区分());
        atenaKozaEntity.set世帯課税区分(keisangoJoho.get世帯課税区分());
        atenaKozaEntity.set合計所得金額(keisangoJoho.get合計所得金額());
        atenaKozaEntity.set公的年金収入額(keisangoJoho.get公的年金収入額());
        atenaKozaEntity.set保険料段階(keisangoJoho.get保険料段階());
        atenaKozaEntity.set保険料算定段階1(keisangoJoho.get保険料算定段階1());
        atenaKozaEntity.set算定年額保険料1(keisangoJoho.get算定年額保険料1());
        atenaKozaEntity.set月割開始年月1(keisangoJoho.get月割開始年月1());
        atenaKozaEntity.set月割終了年月1(keisangoJoho.get月割終了年月1());
        atenaKozaEntity.set保険料算定段階2(keisangoJoho.get保険料算定段階2());
        atenaKozaEntity.set算定年額保険料2(keisangoJoho.get算定年額保険料2());
        atenaKozaEntity.set月割開始年月2(keisangoJoho.get月割開始年月2());
        atenaKozaEntity.set月割終了年月2(keisangoJoho.get月割終了年月2());
        atenaKozaEntity.set調定日時(keisangoJoho.get調定日時());
        atenaKozaEntity.set調定事由1(keisangoJoho.get調定事由1());
        atenaKozaEntity.set調定事由2(keisangoJoho.get調定事由2());
        atenaKozaEntity.set調定事由3(keisangoJoho.get調定事由3());
        atenaKozaEntity.set調定事由4(keisangoJoho.get調定事由4());
        atenaKozaEntity.set更正月(keisangoJoho.get更正月());
        atenaKozaEntity.set減免前介護保険料_年額(keisangoJoho.get減免前介護保険料_年額());
        atenaKozaEntity.set減免額(keisangoJoho.get減免額());
        atenaKozaEntity.set確定介護保険料_年額(keisangoJoho.get確定介護保険料_年額());
        atenaKozaEntity.set保険料段階_仮算定時(keisangoJoho.get保険料段階_仮算定時());
        atenaKozaEntity.set徴収方法履歴番号(keisangoJoho.get徴収方法履歴番号());
        atenaKozaEntity.set異動基準日時(keisangoJoho.get異動基準日時());
        atenaKozaEntity.set口座区分(keisangoJoho.get口座区分());
        atenaKozaEntity.set境界層区分(keisangoJoho.get境界層区分());
        atenaKozaEntity.set職権区分(keisangoJoho.get職権区分());
        atenaKozaEntity.set賦課市町村コード(keisangoJoho.get賦課市町村コード());
        atenaKozaEntity.set特徴歳出還付額(keisangoJoho.get特徴歳出還付額());
        atenaKozaEntity.set普徴歳出還付額(keisangoJoho.get普徴歳出還付額());
        atenaKozaEntity.set特徴期別金額01(keisangoJoho.get特徴期別金額01());
        atenaKozaEntity.set特徴期別金額02(keisangoJoho.get特徴期別金額02());
        atenaKozaEntity.set特徴期別金額03(keisangoJoho.get特徴期別金額03());
        atenaKozaEntity.set特徴期別金額04(keisangoJoho.get特徴期別金額04());
        atenaKozaEntity.set特徴期別金額05(keisangoJoho.get特徴期別金額05());
        atenaKozaEntity.set特徴期別金額06(keisangoJoho.get特徴期別金額06());
        atenaKozaEntity.set普徴期別金額01(keisangoJoho.get普徴期別金額01());
        atenaKozaEntity.set普徴期別金額02(keisangoJoho.get普徴期別金額02());
        atenaKozaEntity.set普徴期別金額03(keisangoJoho.get普徴期別金額03());
        atenaKozaEntity.set普徴期別金額04(keisangoJoho.get普徴期別金額04());
        atenaKozaEntity.set普徴期別金額05(keisangoJoho.get普徴期別金額05());
        atenaKozaEntity.set普徴期別金額06(keisangoJoho.get普徴期別金額06());
        atenaKozaEntity.set普徴期別金額07(keisangoJoho.get普徴期別金額07());
        atenaKozaEntity.set普徴期別金額08(keisangoJoho.get普徴期別金額08());
        atenaKozaEntity.set普徴期別金額09(keisangoJoho.get普徴期別金額09());
        atenaKozaEntity.set普徴期別金額10(keisangoJoho.get普徴期別金額10());
        atenaKozaEntity.set普徴期別金額11(keisangoJoho.get普徴期別金額11());
        atenaKozaEntity.set普徴期別金額12(keisangoJoho.get普徴期別金額12());
        atenaKozaEntity.set普徴期別金額13(keisangoJoho.get普徴期別金額13());
        atenaKozaEntity.set普徴期別金額14(keisangoJoho.get普徴期別金額14());
        atenaKozaEntity.set徴収方法4月(keisangoJoho.get徴収方法4月());
        atenaKozaEntity.set徴収方法5月(keisangoJoho.get徴収方法5月());
        atenaKozaEntity.set徴収方法6月(keisangoJoho.get徴収方法6月());
        atenaKozaEntity.set徴収方法7月(keisangoJoho.get徴収方法7月());
        atenaKozaEntity.set徴収方法8月(keisangoJoho.get徴収方法8月());
        atenaKozaEntity.set徴収方法9月(keisangoJoho.get徴収方法9月());
        atenaKozaEntity.set徴収方法10月(keisangoJoho.get徴収方法10月());
        atenaKozaEntity.set徴収方法11月(keisangoJoho.get徴収方法11月());
        atenaKozaEntity.set徴収方法12月(keisangoJoho.get徴収方法12月());
        atenaKozaEntity.set徴収方法1月(keisangoJoho.get徴収方法1月());
        atenaKozaEntity.set徴収方法2月(keisangoJoho.get徴収方法2月());
        atenaKozaEntity.set徴収方法3月(keisangoJoho.get徴収方法3月());
        atenaKozaEntity.set徴収方法翌4月(keisangoJoho.get徴収方法翌4月());
        atenaKozaEntity.set徴収方法翌5月(keisangoJoho.get徴収方法翌5月());
        atenaKozaEntity.set徴収方法翌6月(keisangoJoho.get徴収方法翌6月());
        atenaKozaEntity.set徴収方法翌7月(keisangoJoho.get徴収方法翌7月());
        atenaKozaEntity.set徴収方法翌8月(keisangoJoho.get徴収方法翌8月());
        atenaKozaEntity.set徴収方法翌9月(keisangoJoho.get徴収方法翌9月());
        atenaKozaEntity.set仮徴収_基礎年金番号(keisangoJoho.get仮徴収_基礎年金番号());
        atenaKozaEntity.set仮徴収_年金コード(keisangoJoho.get仮徴収_年金コード());
        atenaKozaEntity.set仮徴収_捕捉月(keisangoJoho.get仮徴収_捕捉月());
        atenaKozaEntity.set本徴収_基礎年金番号(keisangoJoho.get本徴収_基礎年金番号());
        atenaKozaEntity.set本徴収_年金コード(keisangoJoho.get本徴収_年金コード());
        atenaKozaEntity.set本徴収_捕捉月(keisangoJoho.get本徴収_捕捉月());
        atenaKozaEntity.set翌年度仮徴収_基礎年金番号(keisangoJoho.get翌年度仮徴収_基礎年金番号());
        atenaKozaEntity.set翌年度仮徴収_年金コード(keisangoJoho.get翌年度仮徴収_年金コード());
        atenaKozaEntity.set翌年度仮徴収_捕捉月(keisangoJoho.get翌年度仮徴収_捕捉月());
        atenaKozaEntity.set依頼情報送付済みフラグ(keisangoJoho.is依頼情報送付済みフラグ());
        atenaKozaEntity.set追加依頼情報送付済みフラグ(keisangoJoho.is追加依頼情報送付済みフラグ());
        atenaKozaEntity.set特別徴収停止日時(keisangoJoho.get特別徴収停止日時());
        atenaKozaEntity.set特別徴収停止事由コード(keisangoJoho.get特別徴収停止事由コード());
        atenaKozaEntity.set特徴収入額01(keisangoJoho.get特徴収入額01());
        atenaKozaEntity.set特徴収入額02(keisangoJoho.get特徴収入額02());
        atenaKozaEntity.set特徴収入額03(keisangoJoho.get特徴収入額03());
        atenaKozaEntity.set特徴収入額04(keisangoJoho.get特徴収入額04());
        atenaKozaEntity.set特徴収入額05(keisangoJoho.get特徴収入額05());
        atenaKozaEntity.set特徴収入額06(keisangoJoho.get特徴収入額06());
        atenaKozaEntity.set普徴収入額01(keisangoJoho.get普徴収入額01());
        atenaKozaEntity.set普徴収入額02(keisangoJoho.get普徴収入額02());
        atenaKozaEntity.set普徴収入額03(keisangoJoho.get普徴収入額03());
        atenaKozaEntity.set普徴収入額04(keisangoJoho.get普徴収入額04());
        atenaKozaEntity.set普徴収入額05(keisangoJoho.get普徴収入額05());
        atenaKozaEntity.set普徴収入額06(keisangoJoho.get普徴収入額06());
        atenaKozaEntity.set普徴収入額07(keisangoJoho.get普徴収入額07());
        atenaKozaEntity.set普徴収入額08(keisangoJoho.get普徴収入額08());
        atenaKozaEntity.set普徴収入額09(keisangoJoho.get普徴収入額09());
        atenaKozaEntity.set普徴収入額10(keisangoJoho.get普徴収入額10());
        atenaKozaEntity.set普徴収入額11(keisangoJoho.get普徴収入額11());
        atenaKozaEntity.set普徴収入額12(keisangoJoho.get普徴収入額12());
        atenaKozaEntity.set普徴収入額13(keisangoJoho.get普徴収入額13());
        atenaKozaEntity.set普徴収入額14(keisangoJoho.get普徴収入額14());
        atenaKozaEntity.set宛名Entity(entity.get宛名());
        atenaKozaEntity.set口座Entity(entity.get口座());
        return atenaKozaEntity;
    }
}
