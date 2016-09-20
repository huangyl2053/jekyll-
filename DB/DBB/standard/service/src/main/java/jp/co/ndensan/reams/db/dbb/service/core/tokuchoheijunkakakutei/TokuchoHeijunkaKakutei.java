/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunkakakutei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchoheijunkakakutei.HokenryoDankaibetu;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchoheijunkakakutei.Taishokensu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012002.DBB012002_TokuchoHeinjunkaKakuteiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.HeinjunkaAfterParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunkakakutei.ITokuchoHeijunkaKakuteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV2002FukaAliveDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBBBZ35004_特徴平準化確定のビジネスクラスです。
 *
 * @reamsid_L DBB-0830-020 wangkanglei
 */
public class TokuchoHeijunkaKakutei {

    private final MapperProvider mapperProvider;
    private final DbV2002FukaAliveDac 賦課NewestDac;
    private static final RString 賦課年度KEY = new RString("fukaNendo");
    private static final RString 処理日時KEY = new RString("choteiNichiji");
    private static final RString 遷移区分_0 = new RString("0");

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunkaKakutei() {
        this.賦課NewestDac = InstanceProvider.create(DbV2002FukaAliveDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 賦課NewestDac DbV2002FukaAliveDac
     */
    public TokuchoHeijunkaKakutei(MapperProvider mapperProvider, DbV2002FukaAliveDac 賦課NewestDac) {
        this.賦課NewestDac = 賦課NewestDac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * にて生成した{@link TokuchoHeijunkaKakutei}のインスタンスを返します。
     *
     * @return TokuchoHeijunkaKakutei
     */
    public static TokuchoHeijunkaKakutei createInstance() {
        return InstanceProvider.create(TokuchoHeijunkaKakutei.class);
    }

    /**
     * 平準化対象件数の取得のメソッドます。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 保険料段階List List<HokenryoDankai>
     *
     * @return 平準化対象件数
     */
    public List<Integer> getHeijunkaTaishoKensu(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            List<HokenryoDankai> 保険料段階List) {
        List<Integer> countList = new ArrayList<>();
        for (HokenryoDankai 段階 : 保険料段階List) {
            countList.add(賦課NewestDac.select件数(調定年度, 賦課年度, 調定日時, 段階.get段階区分()));
        }
        return countList;
    }

    /**
     * 確定対象件数と対象外件数の取得のメソッドます。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 遷移区分 RString
     * @param 保険料段階別List List<HokenryoDankaibetu>
     * @return 対象件数List
     */
    @Transaction
    public List<Taishokensu> getKakuteiKensu(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 遷移区分,
            List<HokenryoDankaibetu> 保険料段階別List) {
        List<Taishokensu> 対象件数List = new ArrayList<>();
        Taishokensu 対象件数Entity;
        ITokuchoHeijunkaKakuteiMapper mapper = mapperProvider.create(ITokuchoHeijunkaKakuteiMapper.class);
        mapper.create特徴平準化賦課Temp();
        for (HokenryoDankaibetu 段階 : 保険料段階別List) {
            Integer 確定対象件数 = 0;
            Integer 対象外件数 = 0;
            put平準化後の賦課の情報(mapper, 調定年度, 賦課年度, 調定日時, 段階.get保険料段階());
            List<TokuchoHeinjunkaKakuteiEntity> 特徴平準化賦課List = mapper.select特徴平準化賦課Temp();
            mapper.clear特徴平準化賦課Temp();
            for (TokuchoHeinjunkaKakuteiEntity kakuteiEntity : 特徴平準化賦課List) {
                if (遷移区分_0.equals(遷移区分)) {
                    Decimal 特徴期別金額_前 = kakuteiEntity.get平準化前特徴期別金額02();
                    Decimal 特徴期別金額_後 = kakuteiEntity.get特徴期別金額02();
                    if (特徴期別金額_前 == null) {
                        特徴期別金額_前 = Decimal.ZERO;
                    }
                    if (特徴期別金額_後 == null) {
                        特徴期別金額_後 = Decimal.ZERO;
                    }
                    int 金額1 = 特徴期別金額_前.subtract(特徴期別金額_後).abs().intValue();
                    if (金額1 <= 段階.get差額().intValue()) {
                        対象外件数 = 対象外件数 + 1;
                    } else {
                        確定対象件数 = 確定対象件数 + 1;
                    }
                } else {
                    Decimal 平準化前特徴期別金額 = kakuteiEntity.get平準化前特徴期別金額03();
                    Decimal 平準化後特徴期別金額 = kakuteiEntity.get特徴期別金額03();
                    if (平準化前特徴期別金額 == null) {
                        平準化前特徴期別金額 = Decimal.ZERO;
                    }
                    if (平準化後特徴期別金額 == null) {
                        平準化後特徴期別金額 = Decimal.ZERO;
                    }
                    int 金額2 = 平準化前特徴期別金額.subtract(平準化後特徴期別金額).abs().intValue();
                    if (金額2 <= 段階.get差額().intValue()) {
                        対象外件数 = 対象外件数 + 1;
                    } else {
                        確定対象件数 = 確定対象件数 + 1;
                    }
                }
            }
            対象件数Entity = new Taishokensu();
            対象件数Entity.set保険料段階(段階.get保険料段階());
            対象件数Entity.set確定対象件数(確定対象件数);
            対象件数Entity.set対象外件数(対象外件数);
            対象件数List.add(対象件数Entity);
        }
        return 対象件数List;
    }

    private void put平準化後の賦課の情報(ITokuchoHeijunkaKakuteiMapper mapper,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            RString 保険料段階) {
        HeinjunkaAfterParameter parameter = HeinjunkaAfterParameter.createParameter(調定年度, 賦課年度, 調定日時, 保険料段階);
        FukaJohoManager manager = FukaJohoManager.createInstance();
        List<FukaJoho> 平準化後の賦課の情報List = manager.get平準化後の賦課の情報_画面(parameter);
        if (平準化後の賦課の情報List != null) {
            for (FukaJoho 平準化後の賦課の情報 : 平準化後の賦課の情報List) {
                TokuchoHeinjunkaKakuteiEntity entity = new TokuchoHeinjunkaKakuteiEntity();
                entity.set調定年度(平準化後の賦課の情報.get調定年度());
                entity.set賦課年度(平準化後の賦課の情報.get賦課年度());
                entity.set通知書番号(平準化後の賦課の情報.get通知書番号());
                entity.set履歴番号(平準化後の賦課の情報.get履歴番号());
                entity.set被保険者番号(平準化後の賦課の情報.get被保険者番号());
                entity.set識別コード(平準化後の賦課の情報.get識別コード());
                entity.set世帯コード(平準化後の賦課の情報.get世帯コード());
                entity.set世帯員数(平準化後の賦課の情報.get世帯員数());
                entity.set資格取得日(平準化後の賦課の情報.get資格取得日());
                entity.set資格取得事由(平準化後の賦課の情報.get資格取得事由());
                entity.set資格喪失日(平準化後の賦課の情報.get資格喪失日());
                entity.set資格喪失事由(平準化後の賦課の情報.get資格喪失事由());
                entity.set生活保護扶助種類(平準化後の賦課の情報.get生活保護扶助種類());
                entity.set生保開始日(平準化後の賦課の情報.get生保開始日());
                entity.set生保廃止日(平準化後の賦課の情報.get生保廃止日());
                entity.set老年開始日(平準化後の賦課の情報.get老年開始日());
                entity.set老年廃止日(平準化後の賦課の情報.get老年廃止日());
                entity.set賦課期日(平準化後の賦課の情報.get賦課期日());
                entity.set課税区分(平準化後の賦課の情報.get課税区分());
                entity.set世帯課税区分(平準化後の賦課の情報.get世帯課税区分());
                entity.set合計所得金額(平準化後の賦課の情報.get合計所得金額());
                entity.set公的年金収入額(平準化後の賦課の情報.get公的年金収入額());
                entity.set保険料段階(平準化後の賦課の情報.get保険料段階());
                entity.set保険料算定段階1(平準化後の賦課の情報.get保険料算定段階1());
                entity.set算定年額保険料1(平準化後の賦課の情報.get算定年額保険料1());
                entity.set月割開始年月1(平準化後の賦課の情報.get月割開始年月1());
                entity.set月割終了年月1(平準化後の賦課の情報.get月割終了年月1());
                entity.set保険料算定段階2(平準化後の賦課の情報.get保険料算定段階2());
                entity.set算定年額保険料2(平準化後の賦課の情報.get算定年額保険料2());
                entity.set月割開始年月2(平準化後の賦課の情報.get月割開始年月2());
                entity.set月割終了年月2(平準化後の賦課の情報.get月割終了年月2());
                entity.set調定日時(平準化後の賦課の情報.get調定日時());
                entity.set調定事由1(平準化後の賦課の情報.get調定事由1());
                entity.set調定事由2(平準化後の賦課の情報.get調定事由2());
                entity.set調定事由3(平準化後の賦課の情報.get調定事由3());
                entity.set調定事由4(平準化後の賦課の情報.get調定事由4());
                entity.set減免前介護保険料_年額(平準化後の賦課の情報.get減免前介護保険料_年額());
                entity.set減免額(平準化後の賦課の情報.get減免額());
                entity.set確定介護保険料_年額(平準化後の賦課の情報.get確定介護保険料_年額());
                entity.set保険料段階_仮算定時(平準化後の賦課の情報.get保険料段階_仮算定時());
                entity.set徴収方法履歴番号(平準化後の賦課の情報.get徴収方法履歴番号());
                entity.set異動基準日時(平準化後の賦課の情報.get異動基準日時());
                entity.set口座区分(平準化後の賦課の情報.get口座区分());
                entity.set境界層区分(平準化後の賦課の情報.get境界層区分());
                entity.set職権区分(平準化後の賦課の情報.get職権区分());
                entity.set賦課市町村コード(平準化後の賦課の情報.get賦課市町村コード());
                entity.set特徴歳出還付額(平準化後の賦課の情報.get特徴歳出還付額());
                entity.set普徴歳出還付額(平準化後の賦課の情報.get普徴歳出還付額());
                entity.set特徴期別金額01(平準化後の賦課の情報.get特徴期別金額01());
                entity.set特徴期別金額02(平準化後の賦課の情報.get特徴期別金額02());
                entity.set特徴期別金額03(平準化後の賦課の情報.get特徴期別金額03());
                entity.set特徴期別金額04(平準化後の賦課の情報.get特徴期別金額04());
                entity.set特徴期別金額05(平準化後の賦課の情報.get特徴期別金額05());
                entity.set特徴期別金額06(平準化後の賦課の情報.get特徴期別金額06());
                entity.set普徴期別金額01(平準化後の賦課の情報.get普徴期別金額01());
                entity.set普徴期別金額02(平準化後の賦課の情報.get普徴期別金額02());
                entity.set普徴期別金額03(平準化後の賦課の情報.get普徴期別金額03());
                entity.set普徴期別金額04(平準化後の賦課の情報.get普徴期別金額04());
                entity.set普徴期別金額05(平準化後の賦課の情報.get普徴期別金額05());
                entity.set普徴期別金額06(平準化後の賦課の情報.get普徴期別金額06());
                entity.set普徴期別金額07(平準化後の賦課の情報.get普徴期別金額07());
                entity.set普徴期別金額08(平準化後の賦課の情報.get普徴期別金額08());
                entity.set普徴期別金額09(平準化後の賦課の情報.get普徴期別金額09());
                entity.set普徴期別金額10(平準化後の賦課の情報.get普徴期別金額10());
                entity.set普徴期別金額11(平準化後の賦課の情報.get普徴期別金額11());
                entity.set普徴期別金額12(平準化後の賦課の情報.get普徴期別金額12());
                entity.set普徴期別金額13(平準化後の賦課の情報.get普徴期別金額13());
                entity.set普徴期別金額14(平準化後の賦課の情報.get普徴期別金額14());
                mapper.inset特徴平準化賦課Temp(entity);
            }
            update特徴平準化賦課Temp(mapper);
        }
    }

    private void update特徴平準化賦課Temp(ITokuchoHeijunkaKakuteiMapper mapper) {
        List<FukaJohoRelateEntity> relateEntityList = mapper.select平準化前の賦課の情報();
        if (relateEntityList != null) {
            for (FukaJohoRelateEntity relateEntity : relateEntityList) {
                relateEntity.initializeMd5ToEntities();
                FukaJoho 平準化前の賦課の情報 = new FukaJoho(relateEntity);
                TokuchoHeinjunkaKakuteiEntity 平準化前entity = new TokuchoHeinjunkaKakuteiEntity();
                平準化前entity.set平準化前調定年度(平準化前の賦課の情報.get調定年度());
                平準化前entity.set平準化前賦課年度(平準化前の賦課の情報.get賦課年度());
                平準化前entity.set平準化前通知書番号(平準化前の賦課の情報.get通知書番号());
                平準化前entity.set平準化前履歴番号(平準化前の賦課の情報.get履歴番号());
                平準化前entity.set平準化前被保険者番号(平準化前の賦課の情報.get被保険者番号());
                平準化前entity.set平準化前識別コード(平準化前の賦課の情報.get識別コード());
                平準化前entity.set平準化前世帯コード(平準化前の賦課の情報.get世帯コード());
                平準化前entity.set平準化前世帯員数(平準化前の賦課の情報.get世帯員数());
                平準化前entity.set平準化前資格取得日(平準化前の賦課の情報.get資格取得日());
                平準化前entity.set平準化前資格取得事由(平準化前の賦課の情報.get資格取得事由());
                平準化前entity.set平準化前資格喪失日(平準化前の賦課の情報.get資格喪失日());
                平準化前entity.set平準化前資格喪失事由(平準化前の賦課の情報.get資格喪失事由());
                平準化前entity.set平準化前生活保護扶助種類(平準化前の賦課の情報.get生活保護扶助種類());
                平準化前entity.set平準化前生保開始日(平準化前の賦課の情報.get生保開始日());
                平準化前entity.set平準化前生保廃止日(平準化前の賦課の情報.get生保廃止日());
                平準化前entity.set平準化前老年開始日(平準化前の賦課の情報.get老年開始日());
                平準化前entity.set平準化前老年廃止日(平準化前の賦課の情報.get老年廃止日());
                平準化前entity.set平準化前賦課期日(平準化前の賦課の情報.get賦課期日());
                平準化前entity.set平準化前課税区分(平準化前の賦課の情報.get課税区分());
                平準化前entity.set平準化前世帯課税区分(平準化前の賦課の情報.get世帯課税区分());
                平準化前entity.set平準化前合計所得金額(平準化前の賦課の情報.get合計所得金額());
                平準化前entity.set平準化前公的年金収入額(平準化前の賦課の情報.get公的年金収入額());
                平準化前entity.set平準化前保険料段階(平準化前の賦課の情報.get保険料段階());
                平準化前entity.set平準化前保険料算定段階1(平準化前の賦課の情報.get保険料算定段階1());
                平準化前entity.set平準化前算定年額保険料1(平準化前の賦課の情報.get算定年額保険料1());
                平準化前entity.set平準化前月割開始年月1(平準化前の賦課の情報.get月割開始年月1());
                平準化前entity.set平準化前月割終了年月1(平準化前の賦課の情報.get月割終了年月1());
                平準化前entity.set平準化前保険料算定段階2(平準化前の賦課の情報.get保険料算定段階2());
                平準化前entity.set平準化前算定年額保険料2(平準化前の賦課の情報.get算定年額保険料2());
                平準化前entity.set平準化前月割開始年月2(平準化前の賦課の情報.get月割開始年月2());
                平準化前entity.set平準化前月割終了年月2(平準化前の賦課の情報.get月割終了年月2());
                平準化前entity.set平準化前調定日時(平準化前の賦課の情報.get調定日時());
                平準化前entity.set平準化前調定事由1(平準化前の賦課の情報.get調定事由1());
                平準化前entity.set平準化前調定事由2(平準化前の賦課の情報.get調定事由2());
                平準化前entity.set平準化前調定事由3(平準化前の賦課の情報.get調定事由3());
                平準化前entity.set平準化前調定事由4(平準化前の賦課の情報.get調定事由4());
                平準化前entity.set平準化前減免前介護保険料_年額(平準化前の賦課の情報.get減免前介護保険料_年額());
                平準化前entity.set平準化前減免額(平準化前の賦課の情報.get減免額());
                平準化前entity.set平準化前確定介護保険料_年額(平準化前の賦課の情報.get確定介護保険料_年額());
                平準化前entity.set平準化前保険料段階_仮算定時(平準化前の賦課の情報.get保険料段階_仮算定時());
                平準化前entity.set平準化前徴収方法履歴番号(平準化前の賦課の情報.get徴収方法履歴番号());
                平準化前entity.set平準化前異動基準日時(平準化前の賦課の情報.get異動基準日時());
                平準化前entity.set平準化前口座区分(平準化前の賦課の情報.get口座区分());
                平準化前entity.set平準化前境界層区分(平準化前の賦課の情報.get境界層区分());
                平準化前entity.set平準化前職権区分(平準化前の賦課の情報.get職権区分());
                平準化前entity.set平準化前賦課市町村コード(平準化前の賦課の情報.get賦課市町村コード());
                平準化前entity.set平準化前特徴歳出還付額(平準化前の賦課の情報.get特徴歳出還付額());
                平準化前entity.set平準化前普徴歳出還付額(平準化前の賦課の情報.get普徴歳出還付額());
                平準化前entity.set平準化前特徴期別金額01(平準化前の賦課の情報.get特徴期別金額01());
                平準化前entity.set平準化前特徴期別金額02(平準化前の賦課の情報.get特徴期別金額02());
                平準化前entity.set平準化前特徴期別金額03(平準化前の賦課の情報.get特徴期別金額03());
                平準化前entity.set平準化前特徴期別金額04(平準化前の賦課の情報.get特徴期別金額04());
                平準化前entity.set平準化前特徴期別金額05(平準化前の賦課の情報.get特徴期別金額05());
                平準化前entity.set平準化前特徴期別金額06(平準化前の賦課の情報.get特徴期別金額06());
                平準化前entity.set平準化前普徴期別金額01(平準化前の賦課の情報.get普徴期別金額01());
                平準化前entity.set平準化前普徴期別金額02(平準化前の賦課の情報.get普徴期別金額02());
                平準化前entity.set平準化前普徴期別金額03(平準化前の賦課の情報.get普徴期別金額03());
                平準化前entity.set平準化前普徴期別金額04(平準化前の賦課の情報.get普徴期別金額04());
                平準化前entity.set平準化前普徴期別金額05(平準化前の賦課の情報.get普徴期別金額05());
                平準化前entity.set平準化前普徴期別金額06(平準化前の賦課の情報.get普徴期別金額06());
                平準化前entity.set平準化前普徴期別金額07(平準化前の賦課の情報.get普徴期別金額07());
                平準化前entity.set平準化前普徴期別金額08(平準化前の賦課の情報.get普徴期別金額08());
                平準化前entity.set平準化前普徴期別金額09(平準化前の賦課の情報.get普徴期別金額09());
                平準化前entity.set平準化前普徴期別金額10(平準化前の賦課の情報.get普徴期別金額10());
                平準化前entity.set平準化前普徴期別金額11(平準化前の賦課の情報.get普徴期別金額11());
                平準化前entity.set平準化前普徴期別金額12(平準化前の賦課の情報.get普徴期別金額12());
                平準化前entity.set平準化前普徴期別金額13(平準化前の賦課の情報.get普徴期別金額13());
                平準化前entity.set平準化前普徴期別金額14(平準化前の賦課の情報.get普徴期別金額14());
                mapper.update特徴平準化賦課Temp(平準化前entity);
            }
        }
    }

    /**
     * 賦課処理状況の更新のメソッドます。
     *
     * @param 賦課年度 FlexibleYear
     * @param 処理日時 YMDHMS
     */
    @Transaction
    public void updateFukaShoriJokyo(FlexibleYear 賦課年度, YMDHMS 処理日時) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(賦課年度KEY.toString(), 賦課年度);
        parameter.put(処理日時KEY.toString(), 処理日時);
        ITokuchoHeijunkaKakuteiMapper mapper = mapperProvider.create(ITokuchoHeijunkaKakuteiMapper.class);
        mapper.update賦課処理状況(parameter);
    }

    /**
     * 特徴平準化確定画面で入力されたデータより、バッチ用パラメータクラスを作成する。
     *
     * @param 差額Map Map
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 遷移区分 RString
     * @return パラメータ
     */
    public DBB012002_TokuchoHeinjunkaKakuteiParameter createTokuchoHeijunkaKakuteiParameter(
            Map<RString, Decimal> 差額Map,
            FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            YMDHMS 調定日時,
            RString 遷移区分) {
        DBB012002_TokuchoHeinjunkaKakuteiParameter parameter = new DBB012002_TokuchoHeinjunkaKakuteiParameter();
        parameter.set差額Map(差額Map);
        parameter.set賦課年度(賦課年度);
        parameter.set調定年度(調定年度);
        parameter.set調定日時(調定日時);
        parameter.set遷移区分(遷移区分);
        return parameter;
    }
}
