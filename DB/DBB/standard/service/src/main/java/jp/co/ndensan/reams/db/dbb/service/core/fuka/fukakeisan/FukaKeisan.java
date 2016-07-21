/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.ChoteiJiyuParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.choteijiyu.FukaJohoList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.CalculateChoteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaKokyoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.FukaShikakuPair;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShoriParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShoriResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShorikoaParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShorikoaResult;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiTaishoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoFuka;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.HokenryoDankaiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.fukakonkyo.FukaKonkyoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.FukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.SeigyojohoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.MonthShichoson;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.NengakuHokenryoKeisan;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyo;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTaisho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KyokaisoKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ShokkenKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.service.core.choshuhoho.ChoshuHohoKoshin;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.choteijiyu.ChoteiJiyuHantei;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoRank;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoBuilder;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課の計算のビジネスクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
public class FukaKeisan {

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
    private static final int DAY = 31;
    private static final RString エラーメッセージ = new RString("賦課の情報しか存在しない");
    private static final RString 使用する = new RString("1");
    private static final RString 使用しない = new RString("0");
    private static final RString 汎用キー_通知書番号 = new RString("通知書番号");
    private static final RString ゼロ_0000 = new RString("0000");

    /**
     * にて生成した{@link FukaKeisan}のインスタンスを返します。
     *
     * @return FukaKeisan
     */
    public static FukaKeisan createInstance() {
        return InstanceProvider.create(FukaKeisan.class);
    }

    /**
     * 更正処理メソッド
     *
     * @param param KoseiShoriParameter
     * @return KoseiShoriResult
     */
    public KoseiShoriResult do全履歴更正計算(KoseiShoriParameter param) {
        List<FukaShikakuPair> 賦課と資格のペア = pair賦課With資格(param.get賦課年度(),
                param.get年度分賦課リスト(), param.get資格の情報リスト());
        KoseiTaishoParameter 更正対象パラメータ = new KoseiTaishoParameter();
        更正対象パラメータ.set賦課年度(param.get賦課年度());
        更正対象パラメータ.set賦課の情報_資格の情報ペアのリスト(賦課と資格のペア);
        更正対象パラメータ.set通知書番号(param.get通知書番号());
        更正対象パラメータ.set世帯員所得情報List(param.get世帯員所得情報List());
        更正対象パラメータ.set生保の情報のリスト(param.get生保の情報のリスト());
        更正対象パラメータ.set老福の情報のリスト(param.get老福の情報のリスト());
        更正対象パラメータ.set境界層の情報のリスト(param.get境界層の情報のリスト());
        List<FukaShikakuPair> 更正対象 = mark更正対象(更正対象パラメータ);

        KoseiShorikoaParameter 更正計算パラメータ = new KoseiShorikoaParameter();
        更正計算パラメータ.set賦課年度(param.get賦課年度());
        更正計算パラメータ.set調定日時(YMDHMS.now());
        更正計算パラメータ.set徴収方法の情報_更正前(param.get徴収方法の情報());
        更正計算パラメータ.set世帯員所得情報List(param.get世帯員所得情報List());
        更正計算パラメータ.set生保の情報のリスト(param.get生保の情報のリスト());
        更正計算パラメータ.set老福の情報のリスト(param.get老福の情報のリスト());
        更正計算パラメータ.set境界層の情報のリスト(param.get境界層の情報のリスト());
        更正計算パラメータ.set口座のリスト(param.get口座のリスト());
        更正計算パラメータ.set保険料段階リスト(param.get保険料段階リスト());

        List<KoseiZengoFuka> 更正前後賦課リスト = new ArrayList<>();
        List<ChoshuHoho> 徴収方法の情報リスト = new ArrayList<>();
        List<HihokenshaDaicho> 資格の情報リスト = new ArrayList<>();
        for (FukaShikakuPair pair : 更正対象) {
            更正計算パラメータ.set年度分賦課リスト_更正前(pair.get年度分賦課リスト());
            更正計算パラメータ.set資格の情報(pair.get資格の情報());
            KoseiShorikoaResult 更正処理情報 = do更正計算(更正計算パラメータ);

            KoseiZengoFuka 更正前後賦課 = new KoseiZengoFuka();
            更正前後賦課.set賦課年度(param.get賦課年度());
            更正前後賦課.set通知書番号(param.get通知書番号());
            更正前後賦課.set更正前(pair.get年度分賦課リスト());
            更正前後賦課.set更正後(更正処理情報.get年度分賦課リスト_更正後());
            更正前後賦課リスト.add(更正前後賦課);

            徴収方法の情報リスト.add(更正処理情報.get徴収方法の情報_更正後());
            資格の情報リスト.add(更正処理情報.get資格の情報());
        }
        KoseiZengoChoshuHoho 更正前後徴収方法 = new KoseiZengoChoshuHoho();
        更正前後徴収方法.set賦課年度(param.get賦課年度());
        更正前後徴収方法.set被保険者番号(null);
        更正前後徴収方法.set更正前(param.get徴収方法の情報());

        for (ChoshuHoho entity : 徴収方法の情報リスト) {
            if (EntityDataState.Added.equals(entity.toEntity().getState())) {
                更正前後徴収方法.set更正後(entity);
                break;
            }
        }
        KoseiShoriResult result = new KoseiShoriResult();
        result.set更正前後徴収方法(更正前後徴収方法);
        result.set更正前後賦課のリスト(更正前後賦課リスト);
        result.set資格の情報(資格の情報リスト);
        return result;
    }

    /**
     * 賦課と資格のペア生成メソッド
     *
     * @param 賦課年度 FlexibleYear
     * @param 年度分賦課リスト List<NendobunFukaList>
     * @param 資格の情報リスト List<HihokenshaDaicho>
     * @return List<FukaShikakuPair>
     */
    public List<FukaShikakuPair> pair賦課With資格(FlexibleYear 賦課年度, List<NendobunFukaList> 年度分賦課リスト,
            List<HihokenshaDaicho> 資格の情報リスト) {
        List<FukaShikakuPair> 賦課の情報_資格の情報ペアのリスト = new ArrayList<>();
        List<HihokenshaDaicho> 有効な資格の情報リスト = get有効な資格の情報(資格の情報リスト, 賦課年度);

        Collections.sort(有効な資格の情報リスト, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                if (o1.get第1号資格取得年月日().isBefore(o2.get第1号資格取得年月日())) {
                    return 1;
                }
                return -1;
            }
        });
        Collections.sort(年度分賦課リスト, new Comparator<NendobunFukaList>() {
            @Override
            public int compare(NendobunFukaList o1, NendobunFukaList o2) {
                if (o1.get賦課期日().isBefore(o2.get賦課期日())) {
                    return 1;
                }
                return -1;
            }
        });

        if (年度分賦課リスト.size() <= 有効な資格の情報リスト.size()) {
            for (int i = 0; i < 年度分賦課リスト.size(); i++) {
                FukaShikakuPair 賦課の情報_資格の情報ペア = new FukaShikakuPair();
                賦課の情報_資格の情報ペア.set被保険者番号(有効な資格の情報リスト.get(i).get被保険者番号());
                賦課の情報_資格の情報ペア.set識別コード(有効な資格の情報リスト.get(i).get識別コード());
                賦課の情報_資格の情報ペア.set資格の情報(有効な資格の情報リスト.get(i));
                賦課の情報_資格の情報ペア.set年度分賦課リスト(年度分賦課リスト.get(i));
                賦課の情報_資格の情報ペアのリスト.add(賦課の情報_資格の情報ペア);
            }
            for (int i = 年度分賦課リスト.size(); i < 有効な資格の情報リスト.size(); i++) {
                FukaShikakuPair 賦課の情報_資格の情報ペア = new FukaShikakuPair();
                賦課の情報_資格の情報ペア.set被保険者番号(有効な資格の情報リスト.get(i).get被保険者番号());
                賦課の情報_資格の情報ペア.set識別コード(有効な資格の情報リスト.get(i).get識別コード());
                賦課の情報_資格の情報ペア.set資格の情報(有効な資格の情報リスト.get(i));
                賦課の情報_資格の情報ペアのリスト.add(賦課の情報_資格の情報ペア);
            }
        } else {
            throw new SystemException(エラーメッセージ.toString());
        }
        return 賦課の情報_資格の情報ペアのリスト;
    }

    private List<HihokenshaDaicho> get有効な資格の情報(List<HihokenshaDaicho> 資格の情報リスト, FlexibleYear 賦課年度) {
        Collections.sort(資格の情報リスト, new Comparator<HihokenshaDaicho>() {
            @Override
            public int compare(HihokenshaDaicho o1, HihokenshaDaicho o2) {
                int flag = 0;
                if (o2.get第1号資格取得年月日().isBefore(o1.get第1号資格取得年月日())) {
                    flag = 1;
                }
                if (flag == 0) {
                    if (o2.get異動日().isBefore(o1.get異動日())) {
                        flag = 1;
                    }
                    if (flag == 0) {
                        flag = o2.get枝番().compareTo(o1.get枝番());
                    }
                }
                return flag;
            }
        });
        List<HihokenshaDaicho> tmpList = new ArrayList<>();
        List<HihokenshaDaicho> 有効な資格の情報リスト = new ArrayList<>();
        tmpList.add(資格の情報リスト.get(0));
        for (int index = 1; index < 資格の情報リスト.size(); index++) {
            if (資格の情報リスト.get(index).get第1号資格取得年月日()
                    != 資格の情報リスト.get(index - 1).get第1号資格取得年月日()) {
                tmpList.add(資格の情報リスト.get(index));
            }
        }
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課年度).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課年度.plusYear(INT_1).getYearValue(), Month.MARCH.getValue(), DAY);
        FlexibleDate 本年度資格喪失日 = new FlexibleDate(賦課年度.getYearValue(), Month.MAY.getValue(), INT_1);
        for (HihokenshaDaicho 資格の情報 : tmpList) {
            FlexibleDate 第1号資格取得日 = 資格の情報.get第1号資格取得年月日();
            if (資格の情報.get第1号資格取得年月日() == null || 資格の情報.get第1号資格取得年月日().isEmpty()) {
                第1号資格取得日 = FlexibleDate.MIN;
            }
            FlexibleDate 資格喪失日 = 資格の情報.get資格喪失年月日();
            if (資格の情報.get資格喪失年月日() == null || 資格の情報.get資格喪失年月日().isEmpty()) {
                資格喪失日 = FlexibleDate.MAX;
            }
            if (第1号資格取得日.isBeforeOrEquals(本年度開始日) && 本年度終了日.isBeforeOrEquals(資格喪失日)) {
                有効な資格の情報リスト.add(資格の情報);
            } else if (本年度開始日.isBefore(第1号資格取得日) && 第1号資格取得日.isBefore(本年度終了日)) {
                有効な資格の情報リスト.add(資格の情報);
            } else if (本年度資格喪失日.isBeforeOrEquals(資格喪失日) && 資格喪失日.isBefore(本年度終了日)) {
                有効な資格の情報リスト.add(資格の情報);
            }
        }

        return 有効な資格の情報リスト;
    }

    /**
     * 更正対象導出メソッド
     *
     * @param param KoseiTaishoParameter
     * @return List<FukaShikakuPair>
     */
    public List<FukaShikakuPair> mark更正対象(KoseiTaishoParameter param) {
        List<FukaShikakuPair> 出力用ペアリスト = new ArrayList<>();
        if (param.get賦課の情報_資格の情報ペアのリスト().isEmpty()) {
            return 出力用ペアリスト;
        }
        if (is生活保護(param) || is老齢福祉年金(param) || is境界層(param)) {
            return param.get賦課の情報_資格の情報ペアのリスト();
        }
        List<FukaShikakuPair> 賦課の情報_資格の情報ペアリスト = param.get賦課の情報_資格の情報ペアのリスト();
        for (FukaShikakuPair pair : 賦課の情報_資格の情報ペアリスト) {
            if (is状況が変化(pair.get年度分賦課リスト(), pair.get資格の情報(), param)) {
                出力用ペアリスト.add(pair);
            }
        }
        return 出力用ペアリスト;
    }

    private boolean is生活保護(KoseiTaishoParameter param) {
        for (FukaShikakuPair pair : param.get賦課の情報_資格の情報ペアのリスト()) {
            if (pair.get年度分賦課リスト() == null) {
                return false;
            }
            FukaJoho 賦課の情報 = pair.get年度分賦課リスト().get現年度();
            if (is受給者として賦課(賦課の情報.get生保開始日())) {
                if (!is年度内に受給期間あり_生保(param.get生保の情報のリスト(), param.get賦課年度())) {
                    return true;
                }
            } else if (is年度内に受給期間あり_生保(param.get生保の情報のリスト(), param.get賦課年度())) {
                return true;
            }

        }
        return false;
    }

    private boolean is老齢福祉年金(KoseiTaishoParameter param) {
        for (FukaShikakuPair pair : param.get賦課の情報_資格の情報ペアのリスト()) {
            if (pair.get年度分賦課リスト() == null) {
                return false;
            }
            FukaJoho 賦課の情報 = pair.get年度分賦課リスト().get現年度();
            if (is受給者として賦課(賦課の情報.get老年開始日())) {
                if (!is年度内に受給期間あり_福祉(param.get老福の情報のリスト(), param.get賦課年度())) {
                    return true;
                }
            } else if (is年度内に受給期間あり_福祉(param.get老福の情報のリスト(), param.get賦課年度())) {
                return true;
            }

        }
        return false;
    }

    private boolean is境界層(KoseiTaishoParameter param) {
        for (FukaShikakuPair pair : param.get賦課の情報_資格の情報ペアのリスト()) {
            if (pair.get年度分賦課リスト() == null) {
                return false;
            }
            FukaJoho 賦課の情報 = pair.get年度分賦課リスト().get現年度();
            if (is境界層該当として賦課(賦課の情報.get境界層区分())) {
                if (!is年度内に適用期間あり(param.get境界層の情報のリスト(), param.get賦課年度())) {
                    return true;
                }
            } else if (is年度内に適用期間あり(param.get境界層の情報のリスト(), param.get賦課年度())) {
                return true;
            }

        }
        return false;
    }

    private boolean is受給者として賦課(FlexibleDate 開始日) {
        return 開始日 == null || 開始日.isEmpty();
    }

    private boolean is年度内に受給期間あり_生保(List<SeikatsuHogoJukyusha> 生保の情報リスト, FlexibleYear 賦課年度) {
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課年度).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課年度.plusYear(INT_1).getYearValue(), Month.MARCH.getValue(), DAY);
        if (生保の情報リスト == null || 生保の情報リスト.isEmpty()) {
            return false;
        }
        for (SeikatsuHogoJukyusha entity : 生保の情報リスト) {
            FlexibleDate 受給開始日 = entity.get受給開始日();
            FlexibleDate 受給廃止日 = entity.get受給廃止日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                return true;
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                return true;
            }
        }
        return false;
    }

    private boolean is年度内に受給期間あり_福祉(List<RoreiFukushiNenkinJukyusha> 老福の情報のリスト,
            FlexibleYear 賦課年度) {
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課年度).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課年度.plusYear(INT_1).getYearValue(), Month.MARCH.getValue(), DAY);
        if (老福の情報のリスト == null || 老福の情報のリスト.isEmpty()) {
            return false;
        }

        for (RoreiFukushiNenkinJukyusha entity : 老福の情報のリスト) {
            FlexibleDate 受給開始日 = entity.get受給開始年月日();
            FlexibleDate 受給廃止日 = entity.get受給終了年月日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                return true;
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                return true;
            }
        }
        return false;
    }

    private boolean is境界層該当として賦課(RString 境界層区分) {
        return KyokaisoKubun.該当.getコード().equals(境界層区分);
    }

    private boolean is年度内に適用期間あり(List<KyokaisoGaitosha> 境界層の情報のリスト,
            FlexibleYear 賦課年度) {
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課年度).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課年度.plusYear(INT_1).getYearValue(), Month.MARCH.getValue(), DAY);
        if (境界層の情報のリスト == null || 境界層の情報のリスト.isEmpty()) {
            return false;
        }
        for (KyokaisoGaitosha entity : 境界層の情報のリスト) {
            FlexibleDate 受給開始日 = entity.get適用開始年月日();
            FlexibleDate 受給廃止日 = entity.get適用終了年月日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                return true;
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                return true;
            }
        }
        return false;
    }

    private boolean is状況が変化(NendobunFukaList 年度分賦課リスト, HihokenshaDaicho 資格の情報, KoseiTaishoParameter param) {
        if (年度分賦課リスト == null || 年度分賦課リスト.get現年度() == null) {
            return true;
        }
        FukaJoho 賦課の情報 = 年度分賦課リスト.get現年度();
        if (賦課の情報.get通知書番号().equals(param.get通知書番号())) {
            return true;
        }
        for (SetaiinShotoku setai : param.get世帯員所得情報List()) {
            if (HonninKubun.本人.getCode().equals(setai.get本人区分())
                    && isRString変更(賦課の情報.get課税区分(), setai.get課税区分_住民税減免前())) {
                return true;
            } else if (HonninKubun.世帯構成員.getCode().equals(setai.get本人区分())
                    && isRString変更(賦課の情報.get世帯課税区分(), setai.get課税区分_住民税減免前())) {
                return true;
            }
            if (isDecimal変更(賦課の情報.get合計所得金額(), setai.get合計所得金額())
                    || isDecimal変更(賦課の情報.get公的年金収入額(), setai.get年金収入額())) {
                return true;
            }
        }
        return isFlexibleDate変更(賦課の情報.get資格取得日(), 資格の情報.get資格取得年月日())
                || isFlexibleDate変更(賦課の情報.get資格喪失日(), 資格の情報.get資格喪失年月日());
    }

    /**
     * 更正処理コアメソッド
     *
     * @param param KoseiShorikoaParameter
     * @return KoseiShorikoaResult
     */
    public KoseiShorikoaResult do更正計算(KoseiShorikoaParameter param) {
        FlexibleDate 賦課基準日 = findOut賦課基準日(param.get賦課年度(), param.get資格の情報());
        HokenryoDankaiHantei hantei = InstanceProvider.create(HokenryoDankaiHantei.class);
        HokenryoDankaiHanteiParameter 保険料段階パラメータ = new HokenryoDankaiHanteiParameter();
        保険料段階パラメータ.setFukaNendo(param.get賦課年度());

        FukaKonkyoFactory factory = InstanceProvider.create(FukaKonkyoFactory.class);
        FukaKonkyoParameter fukaKonkyoParameter = new FukaKonkyoParameter();
        fukaKonkyoParameter.set賦課基準日(賦課基準日);
        fukaKonkyoParameter.set生保の情報リスト(param.get生保の情報のリスト());
        fukaKonkyoParameter.set老齢の情報のリスト(param.get老福の情報のリスト());
        fukaKonkyoParameter.set世帯員所得情報List(param.get世帯員所得情報List());
        FukaKonkyo 賦課根拠 = factory.create(fukaKonkyoParameter);
        保険料段階パラメータ.setFukaKonkyo(賦課根拠);

        SeigyoJoho 月別保険料制御情報 = get月別保険料制御情報(param.get保険料段階リスト());
        保険料段階パラメータ.setSeigyoJoho(月別保険料制御情報);
        TsukibetsuHokenryoDankai 月別保険料段階 = hantei.determine月別保険料段階(保険料段階パラメータ);

        NengakuHokenryoKeisanParameter 年額保険料パラメータ = new NengakuHokenryoKeisanParameter();
        年額保険料パラメータ.set賦課年度(param.get賦課年度());

        List<HihokenshaDaicho> 資格 = new ArrayList<>();
        資格.add(param.get資格の情報());
        HokenryoRank rank = InstanceProvider.create(HokenryoRank.class);
        List<MonthShichoson> 月別ランク情報 = rank.get月別ランク情報(資格, param.get年度分賦課リスト_更正前().get賦課年度());

        NengakuFukaKonkyo 年額賦課根拠 = get年額賦課根拠(賦課基準日, param.get資格の情報().get第1号資格取得年月日(),
                param.get資格の情報().get資格喪失年月日(), 月別保険料段階, 月別ランク情報);
        年額保険料パラメータ.set年額賦課根拠(年額賦課根拠);

        NengakuSeigyoJoho 年額制御情報 = get年額制御情報();
        年額保険料パラメータ.set年額制御情報(年額制御情報);

        NengakuHokenryoKeisan 年額保険料の計算 = InstanceProvider.create(NengakuHokenryoKeisan.class);
        NengakuHokenryo 年額保険料 = 年額保険料の計算.calculate年額保険料(年額保険料パラメータ);

        FukaKokyoParameter 賦課根拠パラメータ = new FukaKokyoParameter();
        賦課根拠パラメータ.set賦課年度(param.get賦課年度());
        賦課根拠パラメータ.set資格の情報(param.get資格の情報());
        賦課根拠パラメータ.set世帯員所得情報List(param.get世帯員所得情報List());
        賦課根拠パラメータ.set生保の情報のリスト(param.get生保の情報のリスト());
        賦課根拠パラメータ.set老福の情報のリスト(param.get老福の情報のリスト());
        賦課根拠パラメータ.set境界層の情報のリスト(param.get境界層の情報のリスト());
        賦課根拠パラメータ.set賦課根拠パラメータ(賦課根拠);
        賦課根拠パラメータ.set月別保険料段階(月別保険料段階);
        賦課根拠パラメータ.set年額保険料(年額保険料.getHokenryoNengaku());
        賦課根拠パラメータ.set調定日時(param.get調定日時());

        CalculateChoteiParameter 調定計算パラメータ = new CalculateChoteiParameter();
        調定計算パラメータ.set賦課年度(param.get賦課年度());
        調定計算パラメータ.set調定日時(param.get調定日時());
        調定計算パラメータ.set徴収方法の情報_更正前(param.get徴収方法の情報_更正前());
        調定計算パラメータ.set年額保険料(年額保険料.getHokenryoNengaku());
        調定計算パラメータ.set資格の情報(param.get資格の情報());
        if (param.get年度分賦課リスト_更正前() == null) {
            return create新規の賦課処理コア(param, 賦課根拠パラメータ, 賦課基準日, 調定計算パラメータ);
        } else {
            return create既存の賦課処理コア(param, 賦課根拠パラメータ, 調定計算パラメータ, 年額保険料.getHokenryoNengaku());
        }
    }

    private KoseiShorikoaResult create新規の賦課処理コア(KoseiShorikoaParameter param, FukaKokyoParameter 賦課根拠パラメータ,
            FlexibleDate 賦課基準日, CalculateChoteiParameter 調定計算パラメータ) {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        CountedItem saiban = Saiban.get(SubGyomuCode.DBB介護賦課, 汎用キー_通知書番号, FlexibleDate.getNowDate().getNendo());
        TsuchishoNo 通知書番号 = create通知書番号(param.get資格の情報().get被保険者番号().getColumnValue(),
                saiban.nextString().trim());
        FukaJoho 新しい賦課の情報 = new FukaJoho(調定年度, param.get賦課年度(), 通知書番号, 0);

        賦課根拠パラメータ.set賦課の情報_設定前(新しい賦課の情報);
        FukaJoho 賦課の情報 = reflect賦課根拠(賦課根拠パラメータ);
        FukaJohoBuilder builder = 賦課の情報.createBuilderForEdit();

        NendobunFukaList 調定計算用年度分賦課リスト = new NendobunFukaList();
        調定計算用年度分賦課リスト.set賦課年度(賦課の情報.get賦課年度());
        調定計算用年度分賦課リスト.set通知書番号(賦課の情報.get通知書番号());
        調定計算用年度分賦課リスト.set賦課期日(賦課基準日);
        if (調定年度.equals(param.get賦課年度())) {
            調定計算用年度分賦課リスト.set現年度(賦課の情報);
        } else if (調定年度.equals(param.get賦課年度().plusYear(INT_1))) {
            調定計算用年度分賦課リスト.set過年度1(賦課の情報);
        } else if (調定年度.equals(param.get賦課年度().plusYear(INT_2))) {
            調定計算用年度分賦課リスト.set過年度2(賦課の情報);
        } else if (調定年度.equals(param.get賦課年度().plusYear(INT_3))) {
            調定計算用年度分賦課リスト.set過年度3(賦課の情報);
        } else if (調定年度.equals(param.get賦課年度().plusYear(INT_4))) {
            調定計算用年度分賦課リスト.set過年度4(賦課の情報);
        } else if (調定年度.equals(param.get賦課年度().plusYear(INT_5))) {
            調定計算用年度分賦課リスト.set過年度5(賦課の情報);
        }
        調定計算用年度分賦課リスト.set最新賦課の情報(賦課の情報);

        調定計算パラメータ.set年度分賦課リスト_更正前(調定計算用年度分賦課リスト);
        KoseiShorikoaResult 調定計算 = do調定計算(調定計算パラメータ);

        builder.set調定日時(param.get調定日時())
                .set異動基準日時(param.get調定日時())
                .set徴収方法履歴番号(調定計算.get徴収方法の情報_更正後().get履歴番号());
        if (!is普徴期別金額あり(調定計算.get年度分賦課リスト_更正後().get現年度())) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!param.get口座のリスト().isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        builder.set職権区分(ShokkenKubun.非該当.getコード());
        賦課の情報 = builder.build();

        KoseiShorikoaResult result = new KoseiShorikoaResult();
        result.set徴収方法の情報_更正後(調定計算.get徴収方法の情報_更正後());
        result.get年度分賦課リスト_更正後().set最新賦課の情報(賦課の情報);
        result.set資格の情報(調定計算.get資格の情報());
        return result;
    }

    private TsuchishoNo create通知書番号(RString 被保険者番号, RString 枝番号) {
        RStringBuilder rst = new RStringBuilder();
        rst.append(ゼロ_0000);
        rst.append(被保険者番号);
        rst.append(枝番号.padZeroToLeft(INT_2));
        return new TsuchishoNo(rst.toRString());
    }

    private KoseiShorikoaResult create既存の賦課処理コア(KoseiShorikoaParameter param, FukaKokyoParameter 賦課根拠パラメータ,
            CalculateChoteiParameter 調定計算パラメータ, Decimal 年額保険料) {
        NendobunFukaList 調定計算用年度分賦課リスト = param.get年度分賦課リスト_更正前();
        if (param.get年度分賦課リスト_更正前().get現年度() != null) {
            賦課根拠パラメータ.set賦課の情報_設定前(param.get年度分賦課リスト_更正前().get現年度());
            FukaJoho 賦課の情報 = reflect賦課根拠(賦課根拠パラメータ);
            調定計算用年度分賦課リスト.set現年度(賦課の情報);
            調定計算用年度分賦課リスト.set最新賦課の情報(賦課の情報);
        }
        if (param.get年度分賦課リスト_更正前().get過年度1() != null) {
            賦課根拠パラメータ.set賦課の情報_設定前(param.get年度分賦課リスト_更正前().get過年度1());
            FukaJoho 賦課の情報 = reflect賦課根拠(賦課根拠パラメータ);
            調定計算用年度分賦課リスト.set過年度1(賦課の情報);
            調定計算用年度分賦課リスト.set最新賦課の情報(賦課の情報);
        }
        if (param.get年度分賦課リスト_更正前().get過年度2() != null) {
            賦課根拠パラメータ.set賦課の情報_設定前(param.get年度分賦課リスト_更正前().get過年度2());
            FukaJoho 賦課の情報 = reflect賦課根拠(賦課根拠パラメータ);
            調定計算用年度分賦課リスト.set過年度2(賦課の情報);
            調定計算用年度分賦課リスト.set最新賦課の情報(賦課の情報);
        }
        if (param.get年度分賦課リスト_更正前().get過年度3() != null) {
            賦課根拠パラメータ.set賦課の情報_設定前(param.get年度分賦課リスト_更正前().get過年度3());
            FukaJoho 賦課の情報 = reflect賦課根拠(賦課根拠パラメータ);
            調定計算用年度分賦課リスト.set過年度3(賦課の情報);
            調定計算用年度分賦課リスト.set最新賦課の情報(賦課の情報);
        }
        if (param.get年度分賦課リスト_更正前().get過年度4() != null) {
            賦課根拠パラメータ.set賦課の情報_設定前(param.get年度分賦課リスト_更正前().get過年度4());
            FukaJoho 賦課の情報 = reflect賦課根拠(賦課根拠パラメータ);
            調定計算用年度分賦課リスト.set過年度4(賦課の情報);
            調定計算用年度分賦課リスト.set最新賦課の情報(賦課の情報);
        }
        if (param.get年度分賦課リスト_更正前().get過年度5() != null) {
            賦課根拠パラメータ.set賦課の情報_設定前(param.get年度分賦課リスト_更正前().get過年度5());
            FukaJoho 賦課の情報 = reflect賦課根拠(賦課根拠パラメータ);
            調定計算用年度分賦課リスト.set過年度5(賦課の情報);
            調定計算用年度分賦課リスト.set最新賦課の情報(賦課の情報);
        }

        NendobunFukaList 年度分賦課リスト_更正後 = 調定計算用年度分賦課リスト;
        ChoshuHoho 出力徴収方法の情報 = param.get徴収方法の情報_更正前();
        HihokenshaDaicho 資格の情報 = param.get資格の情報();
        if ((調定計算用年度分賦課リスト.get現年度() != null
                && !年額保険料.equals(調定計算用年度分賦課リスト.get現年度().get減免前介護保険料_年額()))
                || (param.get徴収方法の情報_更正前().get特別徴収停止事由コード() != null
                && !param.get徴収方法の情報_更正前().get特別徴収停止事由コード().isEmpty())) {
            調定計算パラメータ.set年度分賦課リスト_更正前(調定計算用年度分賦課リスト);
            KoseiShorikoaResult 調定計算 = do調定計算(調定計算パラメータ);
            年度分賦課リスト_更正後 = 調定計算.get年度分賦課リスト_更正後();
            出力徴収方法の情報 = 調定計算.get徴収方法の情報_更正後();
            資格の情報 = 調定計算.get資格の情報();
        }
        if (調定計算用年度分賦課リスト.get現年度() != null) {
            年度分賦課リスト_更正後.set現年度(create出力対象の生成(param, param.get年度分賦課リスト_更正前().get現年度(),
                    調定計算用年度分賦課リスト.get現年度(), 出力徴収方法の情報));
        }
        if (調定計算用年度分賦課リスト.get過年度1() != null) {
            年度分賦課リスト_更正後.set過年度1(create出力対象の生成(param, param.get年度分賦課リスト_更正前().get過年度1(),
                    調定計算用年度分賦課リスト.get過年度1(), 出力徴収方法の情報));
        }
        if (調定計算用年度分賦課リスト.get過年度2() != null) {
            年度分賦課リスト_更正後.set過年度2(create出力対象の生成(param, param.get年度分賦課リスト_更正前().get過年度2(),
                    調定計算用年度分賦課リスト.get過年度2(), 出力徴収方法の情報));
        }
        if (調定計算用年度分賦課リスト.get過年度3() != null) {
            年度分賦課リスト_更正後.set過年度3(create出力対象の生成(param, param.get年度分賦課リスト_更正前().get過年度3(),
                    調定計算用年度分賦課リスト.get過年度3(), 出力徴収方法の情報));
        }
        if (調定計算用年度分賦課リスト.get過年度4() != null) {
            年度分賦課リスト_更正後.set過年度4(create出力対象の生成(param, param.get年度分賦課リスト_更正前().get過年度4(),
                    調定計算用年度分賦課リスト.get過年度4(), 出力徴収方法の情報));
        }
        if (調定計算用年度分賦課リスト.get過年度5() != null) {
            年度分賦課リスト_更正後.set過年度5(create出力対象の生成(param, param.get年度分賦課リスト_更正前().get過年度5(),
                    調定計算用年度分賦課リスト.get過年度5(), 出力徴収方法の情報));
        }

        KoseiShorikoaResult result = new KoseiShorikoaResult();
        result.set年度分賦課リスト_更正後(年度分賦課リスト_更正後);
        result.set徴収方法の情報_更正後(出力徴収方法の情報);
        result.set資格の情報(資格の情報);
        return result;
    }

    private FukaJoho create出力対象の生成(KoseiShorikoaParameter param, FukaJoho 賦課の情報_更正前,
            FukaJoho 賦課の情報_更正後, ChoshuHoho 出力徴収方法の情報) {
        FukaJohoBuilder builder = 賦課の情報_更正後.createBuilderForEdit();
        if (賦課の情報_更正前 == null) {
            builder.set履歴番号(0);
        } else if (is変化有り(賦課の情報_更正前, 賦課の情報_更正後)) {
            builder.set履歴番号(賦課の情報_更正前.get履歴番号() + INT_1);
        }

        builder.set調定日時(param.get調定日時());
        builder.set異動基準日時(param.get調定日時());
        builder.set徴収方法履歴番号(出力徴収方法の情報.get履歴番号());
        if (!is普徴期別金額あり(賦課の情報_更正後)) {
            builder.set口座区分(KozaKubun.現金納付.getコード());
        } else {
            if (!param.get口座のリスト().isEmpty()) {
                builder.set口座区分(KozaKubun.口座振替.getコード());
            } else {
                builder.set口座区分(KozaKubun.現金納付.getコード());
            }
        }
        builder.set職権区分(ShokkenKubun.非該当.getコード());
        賦課の情報_更正後 = builder.build();
        return 賦課の情報_更正後;
    }

    private boolean is普徴期別金額あり(FukaJoho 賦課の情報) {
        return is金額あり(賦課の情報.get普徴期別金額01())
                || is金額あり(賦課の情報.get普徴期別金額02())
                || is金額あり(賦課の情報.get普徴期別金額03())
                || is金額あり(賦課の情報.get普徴期別金額04())
                || is金額あり(賦課の情報.get普徴期別金額05())
                || is金額あり(賦課の情報.get普徴期別金額06())
                || is金額あり(賦課の情報.get普徴期別金額07())
                || is金額あり(賦課の情報.get普徴期別金額08())
                || is金額あり(賦課の情報.get普徴期別金額09())
                || is金額あり(賦課の情報.get普徴期別金額10())
                || is金額あり(賦課の情報.get普徴期別金額11())
                || is金額あり(賦課の情報.get普徴期別金額12())
                || is金額あり(賦課の情報.get普徴期別金額13())
                || is金額あり(賦課の情報.get普徴期別金額14());
    }

    private boolean is金額あり(Decimal 金額) {
        return 金額 != null && !Decimal.ZERO.equals(金額);
    }

    private boolean is変化有り(FukaJoho 更正前, FukaJoho 更正後) {
        return is変化有り1(更正前, 更正後)
                || is変化有り2(更正前, 更正後)
                || is変化有り3(更正前, 更正後)
                || is変化有り4(更正前, 更正後);
    }

    private boolean is変化有り1(FukaJoho 更正前, FukaJoho 更正後) {
        return isTsuchishoNo変更(更正前.get通知書番号(), 更正後.get通知書番号())
                || isHihokenshaNo変更(更正前.get被保険者番号(), 更正後.get被保険者番号())
                || isShikibetsuCode変更(更正前.get識別コード(), 更正後.get識別コード())
                || isSetaiCode変更(更正前.get世帯コード(), 更正後.get世帯コード())
                || isInt変更(更正前.get世帯員数(), 更正後.get世帯員数())
                || isFlexibleDate変更(更正前.get資格取得日(), 更正後.get資格取得日())
                || isRString変更(更正前.get資格取得事由(), 更正後.get資格取得事由())
                || isFlexibleDate変更(更正前.get資格喪失日(), 更正後.get資格喪失日())
                || isRString変更(更正前.get資格喪失事由(), 更正後.get資格喪失事由())
                || isRString変更(更正前.get生活保護扶助種類(), 更正後.get生活保護扶助種類())
                || isFlexibleDate変更(更正前.get生保開始日(), 更正後.get生保開始日())
                || isFlexibleDate変更(更正前.get生保廃止日(), 更正後.get生保廃止日())
                || isFlexibleDate変更(更正前.get老年開始日(), 更正後.get老年開始日())
                || isFlexibleDate変更(更正前.get老年廃止日(), 更正後.get老年廃止日())
                || isFlexibleDate変更(更正前.get賦課期日(), 更正後.get賦課期日())
                || isRString変更(更正前.get課税区分(), 更正後.get課税区分())
                || isRString変更(更正前.get世帯課税区分(), 更正後.get世帯課税区分())
                || isDecimal変更(更正前.get合計所得金額(), 更正後.get合計所得金額());
    }

    private boolean is変化有り2(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get公的年金収入額(), 更正後.get公的年金収入額())
                || isRString変更(更正前.get保険料段階(), 更正後.get保険料段階())
                || isRString変更(更正前.get保険料算定段階1(), 更正後.get保険料算定段階1())
                || isDecimal変更(更正前.get算定年額保険料1(), 更正後.get算定年額保険料1())
                || isFlexibleYearMonth変更(更正前.get月割開始年月1(), 更正後.get月割開始年月1())
                || isFlexibleYearMonth変更(更正前.get月割終了年月1(), 更正後.get月割終了年月1())
                || isRString変更(更正前.get保険料算定段階2(), 更正後.get保険料算定段階2())
                || isDecimal変更(更正前.get算定年額保険料2(), 更正後.get算定年額保険料2())
                || isFlexibleYearMonth変更(更正前.get月割開始年月2(), 更正後.get月割開始年月2())
                || isFlexibleYearMonth変更(更正前.get月割終了年月2(), 更正後.get月割終了年月2())
                || isRString変更(更正前.get調定事由1(), 更正後.get調定事由1())
                || isRString変更(更正前.get調定事由2(), 更正後.get調定事由2())
                || isRString変更(更正前.get調定事由3(), 更正後.get調定事由3())
                || isRString変更(更正前.get調定事由4(), 更正後.get調定事由4())
                || isDecimal変更(更正前.get減免前介護保険料_年額(), 更正後.get減免前介護保険料_年額())
                || isDecimal変更(更正前.get減免額(), 更正後.get減免額())
                || isDecimal変更(更正前.get確定介護保険料_年額(), 更正後.get確定介護保険料_年額())
                || isRString変更(更正前.get保険料段階_仮算定時(), 更正後.get保険料段階_仮算定時())
                || isRString変更(更正前.get口座区分(), 更正後.get口座区分());
    }

    private boolean is変化有り3(FukaJoho 更正前, FukaJoho 更正後) {
        return isRString変更(更正前.get境界層区分(), 更正後.get境界層区分())
                || isRString変更(更正前.get職権区分(), 更正後.get職権区分())
                || isLasdecCode変更(更正前.get賦課市町村コード(), 更正後.get賦課市町村コード())
                || isDecimal変更(更正前.get特徴歳出還付額(), 更正後.get特徴歳出還付額())
                || isDecimal変更(更正前.get普徴歳出還付額(), 更正後.get普徴歳出還付額())
                || isDecimal変更(更正前.get特徴期別金額01(), 更正後.get特徴期別金額01())
                || isDecimal変更(更正前.get特徴期別金額02(), 更正後.get特徴期別金額02())
                || isDecimal変更(更正前.get特徴期別金額03(), 更正後.get特徴期別金額03())
                || isDecimal変更(更正前.get特徴期別金額04(), 更正後.get特徴期別金額04())
                || isDecimal変更(更正前.get特徴期別金額05(), 更正後.get特徴期別金額05())
                || isDecimal変更(更正前.get特徴期別金額06(), 更正後.get特徴期別金額06());
    }

    private boolean is変化有り4(FukaJoho 更正前, FukaJoho 更正後) {
        return isDecimal変更(更正前.get普徴期別金額01(), 更正後.get普徴期別金額01())
                || isDecimal変更(更正前.get普徴期別金額02(), 更正後.get普徴期別金額02())
                || isDecimal変更(更正前.get普徴期別金額03(), 更正後.get普徴期別金額03())
                || isDecimal変更(更正前.get普徴期別金額04(), 更正後.get普徴期別金額04())
                || isDecimal変更(更正前.get普徴期別金額05(), 更正後.get普徴期別金額05())
                || isDecimal変更(更正前.get普徴期別金額06(), 更正後.get普徴期別金額06())
                || isDecimal変更(更正前.get普徴期別金額07(), 更正後.get普徴期別金額07())
                || isDecimal変更(更正前.get普徴期別金額08(), 更正後.get普徴期別金額08())
                || isDecimal変更(更正前.get普徴期別金額09(), 更正後.get普徴期別金額09())
                || isDecimal変更(更正前.get普徴期別金額10(), 更正後.get普徴期別金額10())
                || isDecimal変更(更正前.get普徴期別金額11(), 更正後.get普徴期別金額11())
                || isDecimal変更(更正前.get普徴期別金額12(), 更正後.get普徴期別金額12())
                || isDecimal変更(更正前.get普徴期別金額13(), 更正後.get普徴期別金額13())
                || isDecimal変更(更正前.get普徴期別金額14(), 更正後.get普徴期別金額14());
    }

    private boolean isTsuchishoNo変更(TsuchishoNo 更正前, TsuchishoNo 更正後) {
        if (更正前 == null) {
            更正前 = TsuchishoNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = TsuchishoNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isHihokenshaNo変更(HihokenshaNo 更正前, HihokenshaNo 更正後) {
        if (更正前 == null) {
            更正前 = HihokenshaNo.EMPTY;
        }
        if (更正後 == null) {
            更正後 = HihokenshaNo.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isShikibetsuCode変更(ShikibetsuCode 更正前, ShikibetsuCode 更正後) {
        if (更正前 == null) {
            更正前 = ShikibetsuCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = ShikibetsuCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isSetaiCode変更(SetaiCode 更正前, SetaiCode 更正後) {
        if (更正前 == null) {
            更正前 = SetaiCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = SetaiCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isInt変更(int 更正前, int 更正後) {
        return 更正前 != 更正後;
    }

    private boolean isFlexibleDate変更(FlexibleDate 更正前, FlexibleDate 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleDate.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleDate.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isRString変更(RString 更正前, RString 更正後) {
        if (更正前 == null) {
            更正前 = RString.EMPTY;
        }
        if (更正後 == null) {
            更正後 = RString.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isFlexibleYearMonth変更(FlexibleYearMonth 更正前, FlexibleYearMonth 更正後) {
        if (更正前 == null) {
            更正前 = FlexibleYearMonth.EMPTY;
        }
        if (更正後 == null) {
            更正後 = FlexibleYearMonth.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isLasdecCode変更(LasdecCode 更正前, LasdecCode 更正後) {
        if (更正前 == null) {
            更正前 = LasdecCode.EMPTY;
        }
        if (更正後 == null) {
            更正後 = LasdecCode.EMPTY;
        }
        return !更正後.equals(更正前);
    }

    private boolean isDecimal変更(Decimal 更正前, Decimal 更正後) {
        if (更正前 == null) {
            更正前 = Decimal.ZERO;
        }
        if (更正後 == null) {
            更正後 = Decimal.ZERO;
        }
        return !更正後.equals(更正前);
    }

    /**
     * 賦課基準日導出メソッド
     *
     * @param 賦課年度 FlexibleYear
     * @param 資格の情報 HihokenshaDaicho
     * @return FlexibleDate
     */
    public FlexibleDate findOut賦課基準日(FlexibleYear 賦課年度, HihokenshaDaicho 資格の情報) {
        FlexibleDate 年度_0331 = new FlexibleDate(賦課年度.plusYear(INT_1).getYearValue(), Month.MARCH.getValue(), DAY);
        FlexibleDate 年度_0401 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課年度).toDateString());
        if (資格の情報 == null) {
            throw new IllegalArgumentException();
        }
        FlexibleDate 資格取得日 = 資格の情報.get第1号資格取得年月日();
        if (資格取得日 == null || 資格取得日.isEmpty()) {
            資格取得日 = FlexibleDate.MIN;
        }
        FlexibleDate 資格喪失日 = 資格の情報.get資格喪失年月日();
        if (資格喪失日 == null || 資格喪失日.isEmpty()) {
            資格喪失日 = FlexibleDate.MAX;
        }

        if (年度_0331.isBefore(資格取得日) || 資格喪失日.isBefore(年度_0401)) {
            throw new IllegalArgumentException();
        } else if (資格取得日.isBefore(年度_0401)) {
            return 年度_0401;
        } else {
            return 資格取得日;
        }
    }

    /**
     * 賦課根拠設定メソッド
     *
     * @param param FukaKokyoParameter
     * @return FukaJoho
     */
    public FukaJoho reflect賦課根拠(FukaKokyoParameter param) {
        FukaJoho 賦課の情報 = param.get賦課の情報_設定前();
        if (賦課の情報 == null) {
            return null;
        }
        FukaJohoBuilder builder = 賦課の情報.createBuilderForEdit();
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課の情報.get賦課年度()).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課の情報.get賦課年度().plusYear(INT_1).getYearValue(),
                Month.MARCH.getValue(), DAY);

        set生活保護(builder, param.get生保の情報のリスト(), 本年度開始日, 本年度終了日);

        set老齢福祉年金(builder, param.get老福の情報のリスト(), 本年度開始日, 本年度終了日);

        set境界層(builder, param.get境界層の情報のリスト(), 本年度開始日, 本年度終了日);

        set新しい賦課の情報(builder, param);
        賦課の情報 = builder.build();
        return 賦課の情報;
    }

    /**
     * 賦課根拠設定 (オーバロード)
     *
     * @param param FukaKokyoBatchParameter
     * @return FukaJoho
     */
    public FukaJoho reflect賦課根拠(FukaKokyoBatchParameter param) {
        FukaJoho 賦課の情報 = param.get賦課の情報_設定前();
        if (賦課の情報 == null) {
            return null;
        }
        FukaJohoBuilder builder = 賦課の情報.createBuilderForEdit();
        FlexibleDate 本年度開始日 = new FlexibleDate(NendoUtil.toNendoStartDate(賦課の情報.get賦課年度()).toDateString());
        FlexibleDate 本年度終了日 = new FlexibleDate(賦課の情報.get賦課年度().plusYear(INT_1).getYearValue(),
                Month.MARCH.getValue(), DAY);

        set生活保護(builder, param.get生保の情報のリスト(), 本年度開始日, 本年度終了日);

        set老齢福祉年金(builder, param.get老福の情報のリスト(), 本年度開始日, 本年度終了日);

        set境界層(builder, param.get境界層の情報のリスト(), 本年度開始日, 本年度終了日);

        set新しい賦課の情報_バッチ(builder, param);
        賦課の情報 = builder.build();
        return 賦課の情報;
    }

    private void set生活保護(FukaJohoBuilder builder, List<SeikatsuHogoJukyusha> 生保情報のリスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        if (生保情報のリスト == null) {
            return;
        }
        List<SeikatsuHogoJukyusha> 生活保護の情報のリスト = new ArrayList<>();
        for (SeikatsuHogoJukyusha entity : 生保情報のリスト) {
            FlexibleDate 受給開始日 = entity.get受給開始日();
            FlexibleDate 受給廃止日 = entity.get受給廃止日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                生活保護の情報のリスト.add(entity);
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                生活保護の情報のリスト.add(entity);
            }
        }
        if (!生活保護の情報のリスト.isEmpty()) {
            Collections.sort(生活保護の情報のリスト, new Comparator<SeikatsuHogoJukyusha>() {
                @Override
                public int compare(SeikatsuHogoJukyusha o1, SeikatsuHogoJukyusha o2) {
                    if (o2.get受給開始日().isBefore(o1.get受給開始日())) {
                        return 1;
                    }
                    return -1;
                }
            });
            // TODO QAのNo.950(Redmine#91760)
            RString 生活保護扶助種類 = get生活保護扶助種類(生活保護の情報のリスト.get(0).getSeikatsuHogoFujoShuruiList());
            builder.set生活保護扶助種類(生活保護扶助種類);
            builder.set生保開始日(生活保護の情報のリスト.get(0).get受給開始日());
            builder.set生保廃止日(生活保護の情報のリスト.get(0).get受給廃止日());
        } else {
            builder.set生活保護扶助種類(RString.EMPTY);
            builder.set生保開始日(FlexibleDate.EMPTY);
            builder.set生保廃止日(FlexibleDate.EMPTY);
        }
    }

    private RString get生活保護扶助種類(List<SeikatsuHogoFujoShurui> 扶助種類リスト) {
        List<RString> 扶助種類 = new ArrayList<>();
        if (扶助種類リスト == null || 扶助種類リスト.isEmpty()) {
            return RString.EMPTY;
        }
        for (SeikatsuHogoFujoShurui shurui : 扶助種類リスト) {
            扶助種類.add(shurui.get扶助種類コード().getColumnValue().getColumnValue());
        }
        Collections.sort(扶助種類);
        return 扶助種類.get(0);
    }

    private void set老齢福祉年金(FukaJohoBuilder builder, List<RoreiFukushiNenkinJukyusha> 老福の情報リスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        if (老福の情報リスト == null) {
            return;
        }
        List<RoreiFukushiNenkinJukyusha> 老齢福祉の情報リスト = new ArrayList<>();
        for (RoreiFukushiNenkinJukyusha entity : 老福の情報リスト) {
            FlexibleDate 受給開始日 = entity.get受給開始年月日();
            FlexibleDate 受給廃止日 = entity.get受給終了年月日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                老齢福祉の情報リスト.add(entity);
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                老齢福祉の情報リスト.add(entity);
            }
        }
        if (老齢福祉の情報リスト != null && !老齢福祉の情報リスト.isEmpty()) {
            Collections.sort(老齢福祉の情報リスト, new Comparator<RoreiFukushiNenkinJukyusha>() {
                @Override
                public int compare(RoreiFukushiNenkinJukyusha o1, RoreiFukushiNenkinJukyusha o2) {
                    if (o2.get受給開始年月日().isBefore(o1.get受給開始年月日())) {
                        return 1;
                    }
                    return -1;
                }
            });
            builder.set老年開始日(老齢福祉の情報リスト.get(0).get受給開始年月日());
            builder.set老年廃止日(老齢福祉の情報リスト.get(0).get受給終了年月日());
        } else {
            builder.set老年開始日(FlexibleDate.EMPTY);
            builder.set老年廃止日(FlexibleDate.EMPTY);
        }
    }

    private void set境界層(FukaJohoBuilder builder, List<KyokaisoGaitosha> 境界層の情報リスト,
            FlexibleDate 本年度開始日, FlexibleDate 本年度終了日) {
        if (境界層の情報リスト == null) {
            return;
        }
        List<KyokaisoGaitosha> 境界層の情報のリスト = new ArrayList<>();
        for (KyokaisoGaitosha entity : 境界層の情報リスト) {
            FlexibleDate 受給開始日 = entity.get適用開始年月日();
            FlexibleDate 受給廃止日 = entity.get適用終了年月日();
            if (受給開始日 == null || 受給開始日.isEmpty()) {
                受給開始日 = FlexibleDate.MIN;
            }
            if (受給廃止日 == null || 受給廃止日.isEmpty()) {
                受給廃止日 = FlexibleDate.MAX;
            }
            if (受給開始日.isBefore(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給開始日)) {
                境界層の情報のリスト.add(entity);
            } else if (受給廃止日.isBeforeOrEquals(本年度終了日) && 本年度開始日.isBeforeOrEquals(受給廃止日)) {
                境界層の情報のリスト.add(entity);
            }
        }
        if (境界層の情報のリスト != null && !境界層の情報のリスト.isEmpty()) {
            builder.set境界層区分(KyokaisoKubun.該当.getコード());
        } else {
            builder.set境界層区分(KyokaisoKubun.非該当.getコード());
        }
    }

    private void set新しい賦課の情報(FukaJohoBuilder builder, FukaKokyoParameter param) {
        builder.set識別コード(param.get資格の情報().get識別コード());
        builder.set資格取得日(param.get資格の情報().get第1号資格取得年月日());
        builder.set資格取得事由(param.get資格の情報().get資格取得事由コード());
        builder.set資格喪失日(param.get資格の情報().get資格喪失年月日());
        builder.set資格喪失事由(param.get資格の情報().get資格喪失事由コード());

        FlexibleDate 賦課期日 = findOut賦課基準日(param.get賦課の情報_設定前().get賦課年度(), param.get資格の情報());
        builder.set賦課期日(賦課期日);
        if (param.get世帯員所得情報List() != null) {
            for (SetaiinShotoku 世帯員 : param.get世帯員所得情報List()) {
                if (HonninKubun.本人.getCode().equals(世帯員.get本人区分())) {
                    builder.set世帯コード(new SetaiCode(世帯員.get世帯コード()));
                    builder.set課税区分(世帯員.get課税区分_住民税減免前());
                    builder.set合計所得金額(世帯員.get合計所得金額());
                    builder.set公的年金収入額(世帯員.get年金収入額());
                    break;
                }
            }
            builder.set世帯員数(param.get世帯員所得情報List().size());
        }

        if (param.get賦課根拠パラメータ() != null) {
            if (param.get賦課根拠パラメータ().is世帯課税(param.get賦課根拠パラメータ().getSetaiinKazeiKubunList())) {
                builder.set世帯課税区分(KazeiKubun.課税.getコード());
            } else {
                builder.set世帯課税区分(KazeiKubun.非課税.getコード());
            }
        }

        set保険料情報(builder, param.get賦課年度(), param.get月別保険料段階());

        if (param.get年額保険料() != null) {
            builder.set減免前介護保険料_年額(param.get年額保険料());
            builder.set確定介護保険料_年額(param.get年額保険料().subtract(param.get賦課の情報_設定前().get減免額() == null
                    ? Decimal.ZERO : param.get賦課の情報_設定前().get減免額()));
        }
        KoseiTsukiHantei hantei = InstanceProvider.create(KoseiTsukiHantei.class);
        Tsuki 更正月 = hantei.find更正月(param.get調定日時().getDate()).get月();
        builder.set更正月(更正月.getコード());
        builder.set職権区分(ShokkenKubun.非該当.getコード());
    }

    private void set新しい賦課の情報_バッチ(FukaJohoBuilder builder, FukaKokyoBatchParameter param) {
        builder.set識別コード(param.get資格の情報().get識別コード());
        builder.set資格取得日(param.get資格の情報().get第1号資格取得年月日());
        builder.set資格取得事由(param.get資格の情報().get資格取得事由コード());
        builder.set資格喪失日(param.get資格の情報().get資格喪失年月日());
        builder.set資格喪失事由(param.get資格の情報().get資格喪失事由コード());

        FlexibleDate 賦課期日 = findOut賦課基準日(param.get賦課の情報_設定前().get賦課年度(), param.get資格の情報());
        builder.set賦課期日(賦課期日);
        if (param.get世帯員所得情報List() != null) {
            for (SetaiShotokuEntity 世帯員 : param.get世帯員所得情報List()) {
                if (HonninKubun.本人.getCode().equals(世帯員.getHonninKubun())) {
                    builder.set世帯コード(世帯員.getSetaiCode());
                    builder.set課税区分(世帯員.getKazeiKubun());
                    builder.set合計所得金額(世帯員.getGokeiShotokuGaku());
                    builder.set公的年金収入額(世帯員.getNenkiniShunyuGaku());
                    break;
                }
            }
            builder.set世帯員数(param.get世帯員所得情報List().size());
        }
        if (param.get賦課根拠パラメータ() != null) {
            if (param.get賦課根拠パラメータ().is世帯課税(param.get賦課根拠パラメータ().getSetaiinKazeiKubunList())) {
                builder.set世帯課税区分(KazeiKubun.課税.getコード());
            } else {
                builder.set世帯課税区分(KazeiKubun.非課税.getコード());
            }
        }

        set保険料情報(builder, param.get賦課年度(), param.get月別保険料段階());

        if (param.get年額保険料() != null) {
            builder.set減免前介護保険料_年額(param.get年額保険料());
            builder.set確定介護保険料_年額(param.get年額保険料().subtract(param.get賦課の情報_設定前().get減免額() == null
                    ? Decimal.ZERO : param.get賦課の情報_設定前().get減免額()));
        }
        KoseiTsukiHantei hantei = InstanceProvider.create(KoseiTsukiHantei.class);
        Tsuki 更正月 = hantei.find更正月(param.get調定日時().getDate()).get月();
        builder.set更正月(更正月.getコード());
        builder.set職権区分(ShokkenKubun.非該当.getコード());
    }

    private void set保険料情報(FukaJohoBuilder builder, FlexibleYear 賦課年度,
            TsukibetsuHokenryoDankai 月別保険料段階) {
        if (月別保険料段階 == null) {
            return;
        }
        List<HokenryoDankai> dankaiList = new ArrayList<>();
        dankaiList.add(月別保険料段階.get保険料段階04月());
        dankaiList.add(月別保険料段階.get保険料段階05月());
        dankaiList.add(月別保険料段階.get保険料段階06月());
        dankaiList.add(月別保険料段階.get保険料段階07月());
        dankaiList.add(月別保険料段階.get保険料段階08月());
        dankaiList.add(月別保険料段階.get保険料段階09月());
        dankaiList.add(月別保険料段階.get保険料段階10月());
        dankaiList.add(月別保険料段階.get保険料段階11月());
        dankaiList.add(月別保険料段階.get保険料段階12月());
        dankaiList.add(月別保険料段階.get保険料段階01月());
        dankaiList.add(月別保険料段階.get保険料段階02月());
        dankaiList.add(月別保険料段階.get保険料段階03月());
        List<RString> 月 = new ArrayList<>();
        for (int i = INT_4; i <= INT_12; i++) {
            RStringBuilder rst = new RStringBuilder();
            rst.append(賦課年度).append(new RString(i).padZeroToLeft(INT_2));
            月.add(rst.toRString());
        }
        for (int i = INT_1; i <= INT_3; i++) {
            RStringBuilder rst = new RStringBuilder();
            rst.append(賦課年度.plusYear(INT_1)).append(new RString(i).padZeroToLeft(INT_2));
            月.add(rst.toRString());
        }
        int count = 0;
        for (int i = 0; i < dankaiList.size(); i++) {
            count = count + INT_1;
            if (dankaiList.get(i).get段階区分() != null && !dankaiList.get(i).get段階区分().isEmpty()) {
                builder.set保険料算定段階1(dankaiList.get(i).get段階区分());
                builder.set算定年額保険料1(dankaiList.get(i).get保険料率());
                builder.set月割開始年月1(new FlexibleYearMonth(月.get(i)));
                break;
            }
        }
        if (count == dankaiList.size()) {
            builder.set月割終了年月1(new FlexibleYearMonth(月.get(count - INT_1)));
            return;
        }
        int count2 = 0;
        for (int i = count; i < dankaiList.size(); i++) {
            count2 = count2 + INT_1;
            if (!dankaiList.get(count).get段階区分().equals(dankaiList.get(i).get段階区分())) {
                builder.set月割終了年月1(new FlexibleYearMonth(月.get(i)));
                break;
            }
        }

        if (count2 == dankaiList.size()) {
            return;
        }
        int count3 = 0;
        for (int i = count2; i < dankaiList.size(); i++) {
            count3 = count3 + INT_1;
            if (dankaiList.get(count2).get段階区分() != null && !dankaiList.get(i).get段階区分().isEmpty()) {
                builder.set保険料算定段階2(dankaiList.get(i).get段階区分());
                builder.set算定年額保険料2(dankaiList.get(i).get保険料率());
                builder.set月割開始年月2(new FlexibleYearMonth(月.get(i)));
                break;
            }
        }
        if (count3 == dankaiList.size()) {
            builder.set月割終了年月2(new FlexibleYearMonth(月.get(count3 - INT_1)));
            return;
        }
        for (int i = count3; i < dankaiList.size(); i++) {
            count3 = count3 + INT_1;
            if (!dankaiList.get(i).get段階区分().equals(dankaiList.get(i).get段階区分())) {
                builder.set月割終了年月2(new FlexibleYearMonth(月.get(i)));
                break;
            }
        }
        if (count3 == dankaiList.size()) {
            builder.set月割終了年月2(new FlexibleYearMonth(月.get(count3 - INT_1)));
        }
    }

    /**
     * 調定計算メソッド
     *
     * @param param CalculateChoteiParameter
     * @return KoseiShorikoaResult
     */
    public KoseiShorikoaResult do調定計算(CalculateChoteiParameter param) {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        if (param.get賦課年度().isBefore(調定年度)) {
            return get調定計算_過年度(param, 調定年度);
        } else {
            return get調定計算_現年度(param);
        }
    }

    private KoseiShorikoaResult get調定計算_過年度(CalculateChoteiParameter param, FlexibleYear 調定年度) {
        // TODO ビジネス設計_DBBBZ00002_過年度更正計算.xlsxの「更正後賦課情報取得」を使用する。   実装しない。
        List<FukaJoho> 賦課の情報リスト = new ArrayList<>();
        賦課の情報リスト.add(param.get年度分賦課リスト_更正前().get現年度());
        賦課の情報リスト.add(param.get年度分賦課リスト_更正前().get過年度1());
        賦課の情報リスト.add(param.get年度分賦課リスト_更正前().get過年度2());
        賦課の情報リスト.add(param.get年度分賦課リスト_更正前().get過年度3());
        賦課の情報リスト.add(param.get年度分賦課リスト_更正前().get過年度4());
        賦課の情報リスト.add(param.get年度分賦課リスト_更正前().get過年度5());
        ChoshuHoho 徴収方法の情報 = param.get徴収方法の情報_更正前();

        FukaJoho 現年度 = null;
        FukaJoho 過年度 = null;
        for (FukaJoho fuka : 賦課の情報リスト) {
            if (fuka.get賦課年度().equals(fuka.get調定年度())) {
                現年度 = fuka;
            }
            if (調定年度.equals(fuka.get調定年度())) {
                過年度 = fuka;
            }
        }

        ChoteiJiyuParameter choteiJiyuParameter = new ChoteiJiyuParameter();
        choteiJiyuParameter.set現年度(param.get年度分賦課リスト_更正前().get現年度());
        choteiJiyuParameter.set更正前徴収方法(param.get徴収方法の情報_更正前());
        choteiJiyuParameter.set更正後徴収方法(param.get徴収方法の情報_更正前());

        List<FukaJohoList> 更正後賦課リスト = new ArrayList<>();
        FukaJohoList johoList = new FukaJohoList();
        johoList.set現年度(現年度);
        if (現年度.get減免前介護保険料_年額().compareTo(param.get年額保険料()) < 0) {
            choteiJiyuParameter.set過年度(get過年度(param.get年度分賦課リスト_更正前(), 調定年度));
            johoList.set過年度(過年度);
        }
        更正後賦課リスト.add(johoList);
        choteiJiyuParameter.set更正後賦課リスト(更正後賦課リスト);
        ChoteiJiyuHantei hantei = ChoteiJiyuHantei.createInstance();
        List<FukaJohoList> fukaJohoList = hantei.set調定事由(choteiJiyuParameter);

        KoseiShorikoaResult result = new KoseiShorikoaResult();
        NendobunFukaList 年度分賦課リスト = param.get年度分賦課リスト_更正前();
        for (FukaJohoList fukaJoho : fukaJohoList) {
            年度分賦課リスト.set現年度(fukaJoho.get現年度());
            if (fukaJoho.get過年度() != null) {
                if (fukaJoho.get過年度().get賦課年度().equals(fukaJoho.get過年度().get調定年度().plusYear(INT_1))) {
                    年度分賦課リスト.set過年度1(fukaJoho.get過年度());
                } else if (fukaJoho.get過年度().get賦課年度().equals(fukaJoho.get過年度().get調定年度().plusYear(INT_2))) {
                    年度分賦課リスト.set過年度2(fukaJoho.get過年度());
                } else if (fukaJoho.get過年度().get賦課年度().equals(fukaJoho.get過年度().get調定年度().plusYear(INT_3))) {
                    年度分賦課リスト.set過年度3(fukaJoho.get過年度());
                } else if (fukaJoho.get過年度().get賦課年度().equals(fukaJoho.get過年度().get調定年度().plusYear(INT_4))) {
                    年度分賦課リスト.set過年度4(fukaJoho.get過年度());
                } else if (fukaJoho.get過年度().get賦課年度().equals(fukaJoho.get過年度().get調定年度().plusYear(INT_5))) {
                    年度分賦課リスト.set過年度5(fukaJoho.get過年度());
                }
            }
        }
        result.set年度分賦課リスト_更正後(年度分賦課リスト);
        result.set徴収方法の情報_更正後(徴収方法の情報);
        result.set資格の情報(param.get資格の情報());
        return result;
    }

    private KoseiShorikoaResult get調定計算_現年度(CalculateChoteiParameter param) {
        // TODO QAのNo.933(Redmine#91256)
        List<Decimal> 特徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INT_6; i++) {
            特徴期別金額.add(Decimal.ONE);
        }
        List<Decimal> 普徴期別金額 = new ArrayList<>();
        for (int i = 0; i < INT_14; i++) {
            普徴期別金額.add(Decimal.TEN);
        }
        RString 特徴停止事由コード = new RString("01");

        FukaJoho 現年度 = param.get年度分賦課リスト_更正前().get現年度();
        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(現年度.toEntity());
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        for (Kibetsu kibetsu : 現年度.getKibetsuList()) {
            if (ChoshuHohoKibetsu.特別徴収.getコード().equals(kibetsu.get徴収方法())) {
                set特徴期別金額(kibetsu, 特徴期別金額, 介護期別RelateEntity);
            } else if (ChoshuHohoKibetsu.普通徴収.getコード().equals(kibetsu.get徴収方法())) {
                set普徴期別金額(kibetsu, 普徴期別金額, 介護期別RelateEntity);
            }
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        現年度 = new FukaJoho(fukaJohoRelateEntity);

        FukaJoho 更正前 = param.get年度分賦課リスト_更正前().get現年度();
        ChoshuHoho 出力用徴収方法の情報 = param.get徴収方法の情報_更正前();
        if (!Tsuki._3月.getコード().equals(param.get調定日時().getMonthValue())) {
            Decimal 更正前の特別徴収額 = Decimal.ZERO;
            if (更正前.get特徴期別金額01() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(更正前.get特徴期別金額01());
            }
            if (更正前.get特徴期別金額02() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(更正前.get特徴期別金額02());
            }
            if (更正前.get特徴期別金額03() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(更正前.get特徴期別金額03());
            }
            if (更正前.get特徴期別金額04() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(更正前.get特徴期別金額04());
            }
            if (更正前.get特徴期別金額05() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(更正前.get特徴期別金額05());
            }
            if (更正前.get特徴期別金額06() != null) {
                更正前の特別徴収額 = 更正前の特別徴収額.add(更正前.get特徴期別金額06());
            }
            Decimal 更正後の特別徴収額 = Decimal.ZERO;
            for (Decimal decimal : 特徴期別金額) {
                更正後の特別徴収額.add(decimal);
            }
            if (更正前の特別徴収額.compareTo(更正後の特別徴収額) < 0
                    || (特徴停止事由コード != null && !特徴停止事由コード.isEmpty())) {
                ChoshuHohoBuilder builder = 出力用徴収方法の情報.createBuilderForEdit();
                builder.set特別徴収停止事由コード(特徴停止事由コード)
                        .set特別徴収停止日時(param.get調定日時());
                出力用徴収方法の情報 = builder.build();
                ChoshuHohoKoshin choshuHohoKoshin = ChoshuHohoKoshin.createInstance();
                出力用徴収方法の情報 = choshuHohoKoshin.getChoshuHohoKoshinData(出力用徴収方法の情報,
                        param.get調定日時(), 現年度.get資格取得日(), 現年度.get資格喪失日());
            }
        }

        ChoteiJiyuParameter choteiJiyuParameter = new ChoteiJiyuParameter();
        choteiJiyuParameter.set現年度(更正前);
        choteiJiyuParameter.set更正前徴収方法(param.get徴収方法の情報_更正前());
        choteiJiyuParameter.set更正後徴収方法(出力用徴収方法の情報);

        List<FukaJohoList> 更正後賦課リスト = new ArrayList<>();
        FukaJohoList johoList = new FukaJohoList();
        johoList.set現年度(現年度);
        更正後賦課リスト.add(johoList);

        choteiJiyuParameter.set更正後賦課リスト(更正後賦課リスト);
        ChoteiJiyuHantei hantei = ChoteiJiyuHantei.createInstance();
        List<FukaJohoList> fukaJohoList = hantei.set調定事由(choteiJiyuParameter);
        KoseiShorikoaResult result = new KoseiShorikoaResult();
        NendobunFukaList 年度分賦課リスト = param.get年度分賦課リスト_更正前();
        for (FukaJohoList fukaJoho : fukaJohoList) {
            年度分賦課リスト.set現年度(fukaJoho.get現年度());
        }
        result.set年度分賦課リスト_更正後(年度分賦課リスト);
        result.set徴収方法の情報_更正後(出力用徴収方法の情報);
        result.set資格の情報(param.get資格の情報());
        return result;
    }

    private void set特徴期別金額(Kibetsu kibetsu, List<Decimal> 特徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set期別金額(kibetsu, 特徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set期別金額(kibetsu, 特徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set期別金額(kibetsu, 特徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set期別金額(kibetsu, 特徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set期別金額(kibetsu, 特徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set期別金額(kibetsu, 特徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            default:
        }
    }

    private void set普徴期別金額(Kibetsu kibetsu, List<Decimal> 普徴期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        switch (kibetsu.get期()) {
            case INT_1:
                set期別金額(kibetsu, 普徴期別金額.get(0), 介護期別RelateEntity);
                break;
            case INT_2:
                set期別金額(kibetsu, 普徴期別金額.get(INT_1), 介護期別RelateEntity);
                break;
            case INT_3:
                set期別金額(kibetsu, 普徴期別金額.get(INT_2), 介護期別RelateEntity);
                break;
            case INT_4:
                set期別金額(kibetsu, 普徴期別金額.get(INT_3), 介護期別RelateEntity);
                break;
            case INT_5:
                set期別金額(kibetsu, 普徴期別金額.get(INT_4), 介護期別RelateEntity);
                break;
            case INT_6:
                set期別金額(kibetsu, 普徴期別金額.get(INT_5), 介護期別RelateEntity);
                break;
            case INT_7:
                set期別金額(kibetsu, 普徴期別金額.get(INT_6), 介護期別RelateEntity);
                break;
            case INT_8:
                set期別金額(kibetsu, 普徴期別金額.get(INT_7), 介護期別RelateEntity);
                break;
            case INT_9:
                set期別金額(kibetsu, 普徴期別金額.get(INT_8), 介護期別RelateEntity);
                break;
            case INT_10:
                set期別金額(kibetsu, 普徴期別金額.get(INT_9), 介護期別RelateEntity);
                break;
            case INT_11:
                set期別金額(kibetsu, 普徴期別金額.get(INT_10), 介護期別RelateEntity);
                break;
            case INT_12:
                set期別金額(kibetsu, 普徴期別金額.get(INT_11), 介護期別RelateEntity);
                break;
            case INT_13:
                set期別金額(kibetsu, 普徴期別金額.get(INT_12), 介護期別RelateEntity);
                break;
            case INT_14:
                set期別金額(kibetsu, 普徴期別金額.get(INT_13), 介護期別RelateEntity);
                break;
            default:
        }
    }

    private void set期別金額(Kibetsu kibetsu, Decimal 期別金額, List<KibetsuEntity> 介護期別RelateEntity) {
        if (kibetsu.getChoteiKyotsuList() != null && !kibetsu.getChoteiKyotsuList().isEmpty()) {
            KibetsuEntity kibetsuEntity = new KibetsuEntity();
            kibetsuEntity.set介護期別Entity(kibetsu.toEntity());
            UrT0705ChoteiKyotsuEntity entity = kibetsu.getChoteiKyotsuList().get(0).toEntity();
            entity.setChoteigaku(期別金額);
            List<UrT0705ChoteiKyotsuEntity> entityList = new ArrayList<>();
            entityList.add(entity);
            kibetsuEntity.set調定共通Entity(entityList);
            介護期別RelateEntity.add(kibetsuEntity);
        }
    }

    private FukaJoho get過年度(NendobunFukaList 年度分賦課リスト, FlexibleYear 調定年度) {
        if (年度分賦課リスト.get現年度() != null) {
            if (調定年度.equals(年度分賦課リスト.get現年度().get調定年度())) {
                return 年度分賦課リスト.get現年度();
            }
        }
        if (年度分賦課リスト.get過年度1() != null) {
            if (調定年度.equals(年度分賦課リスト.get過年度1().get調定年度())) {
                return 年度分賦課リスト.get過年度1();
            }
        }
        if (年度分賦課リスト.get過年度2() != null) {
            if (調定年度.equals(年度分賦課リスト.get過年度2().get調定年度())) {
                return 年度分賦課リスト.get過年度2();
            }
        }
        if (年度分賦課リスト.get過年度3() != null) {
            if (調定年度.equals(年度分賦課リスト.get過年度3().get調定年度())) {
                return 年度分賦課リスト.get過年度3();
            }
        }
        if (年度分賦課リスト.get過年度4() != null) {
            if (調定年度.equals(年度分賦課リスト.get過年度4().get調定年度())) {
                return 年度分賦課リスト.get過年度4();
            }
        }
        if (年度分賦課リスト.get過年度5() != null) {
            if (調定年度.equals(年度分賦課リスト.get過年度5().get調定年度())) {
                return 年度分賦課リスト.get過年度5();
            }
        }
        return null;
    }

    private SeigyoJoho get月別保険料制御情報(HokenryoDankaiList 保険料段階リスト) {
        RDate nowDate = RDate.getNowDate();
        Decimal 基準年金収入額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準年金収入額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準年金収入3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額01 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額1,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額02 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額2,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額03 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額3,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額04 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額4,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額05 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額5,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額06 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額6,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額07 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額7,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額08 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額8,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額09 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額9,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額10 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額10,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額11 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額11,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額12 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額12,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額13 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額13,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額14 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額14,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        Decimal 基準所得金額15 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.賦課基準_基準所得金額15,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 課税層所得段階 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税層保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 未申告段階使用有無 = false;
        if (使用する.equals(未申告段階使用)) {
            未申告段階使用有無 = true;
        } else if (使用しない.equals(未申告段階使用)) {
            未申告段階使用有無 = false;
        }
        RString 未申告段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 所得調査中段階使用有無 = false;
        if (使用する.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = true;
        } else if (使用しない.equals(所得調査中段階使用)) {
            所得調査中段階使用有無 = false;
        }
        RString 所得調査中段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消段階使用 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                nowDate, SubGyomuCode.DBB介護賦課);
        boolean 課税取消段階使用有無 = false;
        if (使用する.equals(課税取消段階使用)) {
            課税取消段階使用有無 = true;
        } else if (使用しない.equals(課税取消段階使用)) {
            課税取消段階使用有無 = false;
        }
        RString 課税取消段階インデックス = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分,
                nowDate, SubGyomuCode.DBB介護賦課);

        SeigyojohoFactory seigyojohoFactory = InstanceProvider.create(SeigyojohoFactory.class);
        SeigyoJoho 月別保険料制御情報 = seigyojohoFactory.createSeigyojoho(
                保険料段階リスト, 基準年金収入額01, 基準年金収入額02, 基準年金収入額03,
                基準所得金額01, 基準所得金額02, 基準所得金額03, 基準所得金額04, 基準所得金額05, 基準所得金額06,
                基準所得金額07, 基準所得金額08, 基準所得金額09, 基準所得金額10, 基準所得金額11, 基準所得金額12,
                基準所得金額13, 基準所得金額14, 基準所得金額15, 課税層所得段階,
                未申告段階使用有無, 未申告段階インデックス, KazeiKubun.toValue(未申告課税区分),
                所得調査中段階使用有無, 所得調査中段階インデックス, KazeiKubun.toValue(所得調査中課税区分),
                課税取消段階使用有無, 課税取消段階インデックス, KazeiKubun.toValue(課税取消課税区分));
        return 月別保険料制御情報;
    }

    private NengakuFukaKonkyo get年額賦課根拠(FlexibleDate 賦課基準日, FlexibleDate 資格取得日,
            FlexibleDate 資格喪失日, TsukibetsuHokenryoDankai 月別保険料段階, List<MonthShichoson> 月別ランク情報) {
        RString ランク_4月 = RString.EMPTY;
        RString ランク_5月 = RString.EMPTY;
        RString ランク_6月 = RString.EMPTY;
        RString ランク_7月 = RString.EMPTY;
        RString ランク_8月 = RString.EMPTY;
        RString ランク_9月 = RString.EMPTY;
        RString ランク_10月 = RString.EMPTY;
        RString ランク_11月 = RString.EMPTY;
        RString ランク_12月 = RString.EMPTY;
        RString ランク_1月 = RString.EMPTY;
        RString ランク_2月 = RString.EMPTY;
        RString ランク_3月 = RString.EMPTY;
        for (MonthShichoson 月別ランク : 月別ランク情報) {
            if (Tsuki._4月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_4月 = 月別ランク.getランク区分();
            } else if (Tsuki._5月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_5月 = 月別ランク.getランク区分();
            } else if (Tsuki._6月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_6月 = 月別ランク.getランク区分();
            } else if (Tsuki._7月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_7月 = 月別ランク.getランク区分();
            } else if (Tsuki._8月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_8月 = 月別ランク.getランク区分();
            } else if (Tsuki._9月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_9月 = 月別ランク.getランク区分();
            } else if (Tsuki._10月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_10月 = 月別ランク.getランク区分();
            } else if (Tsuki._11月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_11月 = 月別ランク.getランク区分();
            } else if (Tsuki._12月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_12月 = 月別ランク.getランク区分();
            } else if (Tsuki._1月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_1月 = 月別ランク.getランク区分();
            } else if (Tsuki._2月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_2月 = 月別ランク.getランク区分();
            } else if (Tsuki._3月.getコード().equals(月別ランク.get月().getコード())) {
                ランク_3月 = 月別ランク.getランク区分();
            }
        }
        NengakuFukaKonkyoFactory nengakuFukaKonkyo = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
        NengakuFukaKonkyo 年額賦課根拠 = nengakuFukaKonkyo.createNengakuFukaKonkyo(
                賦課基準日, 資格取得日, 資格喪失日, 月別保険料段階,
                ランク_4月, ランク_5月, ランク_6月, ランク_7月, ランク_8月, ランク_9月,
                ランク_10月, ランク_11月, ランク_12月, ランク_1月, ランク_2月, ランク_3月);
        return 年額賦課根拠;
    }

    private NengakuSeigyoJoho get年額制御情報() {
        RDate nowDate = RDate.getNowDate();
        Decimal 端数単位 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_通常,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        Decimal 端数単位_ランク用 = new Decimal(DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整単位_ランク変更のみ,
                nowDate, SubGyomuCode.DBB介護賦課).toString());
        RString 端数調整方法_ランク用 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整方法_通常,
                nowDate, SubGyomuCode.DBB介護賦課);
        RString 端数調整対象 = DbBusinessConfig.get(ConfigNameDBB.年額計算_端数調整対象,
                nowDate, SubGyomuCode.DBB介護賦課);
        Map<RString, RankBetsuKijunKingaku> ランク別制御情報 = new HashMap<RString, RankBetsuKijunKingaku>();

        // TODO QAのNo.957　「ランク別制御情報」の設定方法がない。
//        RankBetsuKijunKingaku gaku = new RankBetsuKijunKingaku();
//        gaku.setランク基準金額1(Decimal.ONE);
//        gaku.setランク基準金額2(Decimal.ONE);
//        ランク別制御情報.put(new RString("01"), gaku);
//        ランク別制御情報.put(new RString("1"), gaku);
        NengakuFukaKonkyoFactory nengakuFukaKonkyoFactory = InstanceProvider.create(NengakuFukaKonkyoFactory.class);
        NengakuSeigyoJoho 年額制御情報 = nengakuFukaKonkyoFactory.createNengakuSeigyoJoho(
                端数単位,
                HasuChoseiHoho.toValue(端数調整方法),
                端数単位_ランク用,
                HasuChoseiHoho.toValue(端数調整方法_ランク用),
                HasuChoseiTaisho.toValue(端数調整対象),
                ランク別制御情報);
        return 年額制御情報;
    }
}
