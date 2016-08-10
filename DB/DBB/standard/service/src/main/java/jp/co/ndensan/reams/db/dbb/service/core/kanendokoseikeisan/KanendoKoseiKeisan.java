/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanendokoseikeisan;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.kanendokoseikeisan.KoseigoFukaResult;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.GennenZuijiHantei;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.SuitoSeiriTaishoNendo;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendokoseikeisan.KanendoKoseiKeisanEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.ITsukiShorkiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ur.urd.business.core.kiwarikeisan.ChoteiNendoKibetsuClass;
import jp.co.ndensan.reams.ur.urd.business.core.kiwarikeisan.FuchoTsukiClass;
import jp.co.ndensan.reams.ur.urd.business.core.kiwarikeisan.FukaKoseiJohoClass;
import jp.co.ndensan.reams.ur.urd.business.core.kiwarikeisan.GyomuConfigJohoClass;
import jp.co.ndensan.reams.ur.urd.business.core.kiwarikeisan.KiwariKeisan;
import jp.co.ndensan.reams.ur.urd.business.core.kiwarikeisan.KiwariKeisanInput;
import jp.co.ndensan.reams.ur.urd.business.core.kiwarikeisan.KiwariKeisanOutput;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 過年度更正計算クラスです。
 *
 * @reamsid_L DBB-9050-010 xicongwang
 */
public class KanendoKoseiKeisan {

    private static final RString 算定日時_空白メッセージ = new RString("算定日時（年月日時分秒）");
    private static final RString 調定年度_空白メッセージ = new RString("調定年度");
    private static final RString 賦課の情報_空白メッセージ = new RString("賦課の情報");
    private static final RString 徴収方法の情報_空白メッセージ = new RString("徴収方法の情報");
    private static final RString 関係_メッセージ = new RString("調定年度ー賦課年度　が　0,1,2,3,4,5以外");
    private static final RString 定数_翌年度4月 = new RString("104");
    private static final RString 定数_翌年度5月 = new RString("105");
    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final RString 定数_5 = new RString("5");
    private static final RString 定数_6 = new RString("6");
    private static final RString 定数_7 = new RString("7");
    private static final RString 定数_8 = new RString("8");
    private static final RString 定数_9 = new RString("9");
    private static final RString 定数_10 = new RString("10");
    private static final RString 定数_11 = new RString("11");
    private static final RString 定数_12 = new RString("12");
    private static final RString 定数_13 = new RString("13");
    private static final RString 定数_14 = new RString("14");
    private static final RString 重複させない = new RString("00");
    private static final RString 重複させる_01期 = new RString("01");
    private static final RString 重複させる_02期 = new RString("02");
    private static final RString 重複させる_03期 = new RString("03");
    private static final RString 重複させる_04期 = new RString("04");
    private static final RString 重複させる_05期 = new RString("05");
    private static final RString 重複させる_06期 = new RString("06");
    private static final RString 重複させる_07期 = new RString("07");
    private static final RString 重複させる_08期 = new RString("08");
    private static final RString 重複させる_09期 = new RString("09");
    private static final RString 重複させる_10期 = new RString("10");
    private static final RString 重複させる_11期 = new RString("11");
    private static final RString 重複させる_12期 = new RString("12");
    private static final RString 重複させる_13期 = new RString("13");
    private static final RString 重複させる_14期 = new RString("14");
    private static final RString 特別徴収_厚生労働省 = new RString("1");
    private static final RString 特別徴収_地共済 = new RString("2");
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

    /**
     * 該当クラスの対象を返しメソッドです。
     *
     * @return KanendoKoseiKeisan 該当クラスの対象
     */
    public static KanendoKoseiKeisan createInstance() {
        return InstanceProvider.create(KanendoKoseiKeisan.class);
    }

    /**
     * 更正後賦課情報取得するメソッドです。
     *
     * @param 賦課の情報List List<FukaJoho>
     * @param 徴収方法の情報 ChoshuHoho
     * @param 調定年度 FlexibleYear
     * @param 算定日時 YMDHMS
     * @return KoseigoFukaResult 更正後賦課情報
     * @throws ApplicationException 調定計算パラメータのチェック処理エラー
     */
    public KoseigoFukaResult getKoseigoFuka(List<FukaJoho> 賦課の情報List, ChoshuHoho 徴収方法の情報,
            FlexibleYear 調定年度, YMDHMS 算定日時) throws ApplicationException {

        choteiParameterCheck(賦課の情報List, 徴収方法の情報, 調定年度, 算定日時);

        FukaJoho 賦課の情報1 = null;
        FukaJoho 賦課の情報2 = null;
        FukaJoho 賦課の情報3 = null;
        FukaJoho 賦課の情報4 = null;
        FukaJoho 賦課の情報5 = null;
        FukaJoho 賦課の情報6 = null;
        for (FukaJoho 賦課の情報 : 賦課の情報List) {
            if (賦課の情報.get賦課年度().equals(賦課の情報.get調定年度())) {
                賦課の情報1 = 賦課の情報;
            } else if (賦課の情報.get賦課年度().equals(賦課の情報.get調定年度().minusYear(INT_1))) {
                賦課の情報2 = 賦課の情報;
            } else if (賦課の情報.get賦課年度().equals(賦課の情報.get調定年度().minusYear(INT_2))) {
                賦課の情報3 = 賦課の情報;
            } else if (賦課の情報.get賦課年度().equals(賦課の情報.get調定年度().minusYear(INT_3))) {
                賦課の情報4 = 賦課の情報;
            } else if (賦課の情報.get賦課年度().equals(賦課の情報.get調定年度().minusYear(INT_4))) {
                賦課の情報5 = 賦課の情報;
            } else if (賦課の情報.get賦課年度().equals(賦課の情報.get調定年度().minusYear(INT_5))) {
                賦課の情報6 = 賦課の情報;
            }
        }

        KanendoKoseiKeisanEntity entity = set確定保険料_金額合計(賦課の情報1, 賦課の情報2, 賦課の情報3, 賦課の情報4, 賦課の情報5, 賦課の情報6);
        Decimal 今回保険料 = entity.get今回保険料();
        Decimal 前回保険料 = entity.get前回保険料();
        Decimal 期割前_普徴期別金額合計 = entity.get普徴期別金額合計();
        Decimal 期割前_特徴期別金額合計 = entity.get特徴期別金額合計();

        KiwariKeisanInput kiwariKeisanInput = get期割計算の引数(徴収方法の情報, 調定年度, 算定日時, 賦課の情報1,
                賦課の情報2, 賦課の情報3, 賦課の情報4, 賦課の情報5, 賦課の情報6, 今回保険料, 前回保険料);
        KiwariKeisan kiwariKeisan = new KiwariKeisan();
        KiwariKeisanOutput kiwariKeisanOutputEntity = kiwariKeisan.getKibetsuGaku(kiwariKeisanInput);

        KoseigoFukaResult result = get変更後情報(kiwariKeisanOutputEntity, 徴収方法の情報, 算定日時, 賦課の情報1,
                賦課の情報2, 賦課の情報3, 賦課の情報4, 賦課の情報5, 賦課の情報6);
        KanendoKoseiKeisanEntity 期割計算処理後 = set確定保険料_金額合計(result.get賦課の情報リスト().get(0),
                get賦課情報(result.get賦課の情報リスト(), INT_1), get賦課情報(result.get賦課の情報リスト(), INT_2),
                get賦課情報(result.get賦課の情報リスト(), INT_3), get賦課情報(result.get賦課の情報リスト(), INT_4),
                get賦課情報(result.get賦課の情報リスト(), INT_5));
        Decimal 期割後_普徴期別金額合計 = 期割計算処理後.get普徴期別金額合計();
        Decimal 期割後_特徴期別金額合計 = 期割計算処理後.get特徴期別金額合計();

        if (前回保険料.compareTo(今回保険料) == 1) {
            Decimal 特徴歳出還付額 = 期割前_特徴期別金額合計.subtract(期割後_特徴期別金額合計);
            Decimal 普徴歳出還付額 = 期割前_普徴期別金額合計.subtract(期割後_普徴期別金額合計);

            GennenZuijiHantei 現年随時判定 = new GennenZuijiHantei();
            SuitoSeiriTaishoNendo 出納整理対象年度
                    = 現年随時判定.get出納整理対象年度(Tsuki.toValue(new RString(算定日時.getDate().getMonthValue()).padZeroToLeft(INT_2)));
            if (SuitoSeiriTaishoNendo.過年度_増額減額.equals(出納整理対象年度)) {
                update更正後賦課の情報(調定年度, 特徴歳出還付額, 普徴歳出還付額, result);
            }
        }

        return result;
    }

    private FukaJoho get賦課情報(List<FukaJoho> 賦課の情報リスト, int index) {
        if (index < 賦課の情報リスト.size()) {
            return 賦課の情報リスト.get(index);
        }
        return null;

    }

    private void update更正後賦課の情報(FlexibleYear 調定年度, Decimal 特徴歳出還付額, Decimal 普徴歳出還付額, KoseigoFukaResult result) {
        if (result.get賦課の情報リスト().size() == INT_1) {
            return;
        }
        for (int idx = 1; idx < result.get賦課の情報リスト().size(); idx++) {
            FukaJoho 賦課の情報tmp = result.get賦課の情報リスト().get(idx);
            if (調定年度.equals(賦課の情報tmp.get調定年度())) {
                賦課の情報tmp = 賦課の情報tmp.createBuilderForEdit().set普徴歳出還付額(普徴歳出還付額)
                        .set特徴歳出還付額(特徴歳出還付額).build();
                result.get賦課の情報リスト().remove(result.get賦課の情報リスト().get(idx));
                result.get賦課の情報リスト().add(idx, 賦課の情報tmp);
                break;
            }
        }
    }

    private KoseigoFukaResult get変更後情報(KiwariKeisanOutput kiwariKeisanOutputEntity, ChoshuHoho 徴収方法の情報,
            YMDHMS 算定日時, FukaJoho 賦課の情報1, FukaJoho 賦課の情報2, FukaJoho 賦課の情報3, FukaJoho 賦課の情報4,
            FukaJoho 賦課の情報5, FukaJoho 賦課の情報6) {

        List<FukaJoho> 賦課の情報リスト = new ArrayList<>();

        List<ChoteiNendoKibetsuClass> 調定年度期別クラス = kiwariKeisanOutputEntity.get調定年度期別クラス();
        for (int idx = 0; idx < INT_6; idx++) {
            set賦課の情報リスト(賦課の情報リスト, 調定年度期別クラス, idx, 算定日時, 賦課の情報1,
                    賦課の情報2, 賦課の情報3, 賦課の情報4, 賦課の情報5, 賦課の情報6);
        }

        return new KoseigoFukaResult(賦課の情報リスト, 徴収方法の情報);
    }

    private void set賦課の情報リスト(List<FukaJoho> 賦課の情報リスト, List<ChoteiNendoKibetsuClass> 調定年度期別クラス, int idx,
            YMDHMS 算定日時, FukaJoho 賦課の情報1, FukaJoho 賦課の情報2, FukaJoho 賦課の情報3,
            FukaJoho 賦課の情報4, FukaJoho 賦課の情報5, FukaJoho 賦課の情報6) {

        int size = 調定年度期別クラス.size();
        if (idx == 0) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(idx).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(idx).get特徴期別額();
            賦課の情報1 = get賦課の情報(賦課の情報1, 算定日時, 普徴期別額List, 特徴期別額List).build();
            賦課の情報リスト.add(賦課の情報1);
        } else if (idx == INT_1 && INT_1 < size) {
            if (賦課の情報2 != null) {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(idx).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(idx).get特徴期別額();
                賦課の情報2 = get賦課の情報(賦課の情報2, 算定日時, 普徴期別額List, 特徴期別額List).build();
                賦課の情報リスト.add(賦課の情報2);
            } else {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(0).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(0).get特徴期別額();
                賦課の情報1 = get賦課の情報(賦課の情報1, 算定日時, 普徴期別額List, 特徴期別額List)
                        .set調定年度(賦課の情報1.get賦課年度().plusYear(INT_1)).build();
                賦課の情報リスト.add(賦課の情報1);
            }
        } else if (idx == INT_2 && INT_2 < size) {
            if (賦課の情報3 != null) {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(idx).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(idx).get特徴期別額();
                賦課の情報3 = get賦課の情報(賦課の情報3, 算定日時, 普徴期別額List, 特徴期別額List).build();
                賦課の情報リスト.add(賦課の情報3);
            } else if (賦課の情報2 != null) {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_1).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_1).get特徴期別額();
                賦課の情報2 = get賦課の情報(賦課の情報2, 算定日時, 普徴期別額List, 特徴期別額List)
                        .set調定年度(賦課の情報2.get賦課年度().plusYear(INT_1)).build();
                賦課の情報リスト.add(賦課の情報2);
            } else {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(0).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(0).get特徴期別額();
                賦課の情報1 = get賦課の情報(賦課の情報1, 算定日時, 普徴期別額List, 特徴期別額List)
                        .set調定年度(賦課の情報1.get賦課年度().plusYear(INT_2)).build();
                賦課の情報リスト.add(賦課の情報1);
            }
        } else if (idx == INT_3 && INT_3 < size) {
            if (賦課の情報4 != null) {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(idx).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(idx).get特徴期別額();
                賦課の情報4 = get賦課の情報(賦課の情報4, 算定日時, 普徴期別額List, 特徴期別額List).build();
                賦課の情報リスト.add(賦課の情報4);
            } else if (賦課の情報3 != null) {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_2).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_2).get特徴期別額();
                賦課の情報3 = get賦課の情報(賦課の情報3, 算定日時, 普徴期別額List, 特徴期別額List)
                        .set調定年度(賦課の情報3.get賦課年度().plusYear(INT_1)).build();
                賦課の情報リスト.add(賦課の情報3);
            } else if (賦課の情報2 != null) {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_1).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_1).get特徴期別額();
                賦課の情報2 = get賦課の情報(賦課の情報2, 算定日時, 普徴期別額List, 特徴期別額List)
                        .set調定年度(賦課の情報2.get賦課年度().plusYear(INT_2)).build();
                賦課の情報リスト.add(賦課の情報2);
            } else {
                List<Decimal> 普徴期別額List = 調定年度期別クラス.get(0).get普徴期別額();
                List<Decimal> 特徴期別額List = 調定年度期別クラス.get(0).get特徴期別額();
                賦課の情報1 = get賦課の情報(賦課の情報1, 算定日時, 普徴期別額List, 特徴期別額List)
                        .set調定年度(賦課の情報1.get賦課年度().plusYear(INT_3)).build();
                賦課の情報リスト.add(賦課の情報1);
            }
        } else if (idx == INT_4 && INT_4 < size) {
            set賦課の情報5(賦課の情報リスト, 調定年度期別クラス, idx, 算定日時, 賦課の情報1,
                    賦課の情報2, 賦課の情報3, 賦課の情報4, 賦課の情報5);
        } else if (idx == INT_5 && INT_5 < size) {
            set賦課の情報6(賦課の情報リスト, 調定年度期別クラス, idx, 算定日時, 賦課の情報1,
                    賦課の情報2, 賦課の情報3, 賦課の情報4, 賦課の情報5, 賦課の情報6);
        }
    }

    private void set賦課の情報5(List<FukaJoho> 賦課の情報リスト, List<ChoteiNendoKibetsuClass> 調定年度期別クラス, int idx,
            YMDHMS 算定日時, FukaJoho 賦課の情報1, FukaJoho 賦課の情報2, FukaJoho 賦課の情報3,
            FukaJoho 賦課の情報4, FukaJoho 賦課の情報5) {
        if (賦課の情報5 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(idx).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(idx).get特徴期別額();
            賦課の情報5 = get賦課の情報(賦課の情報5, 算定日時, 普徴期別額List, 特徴期別額List).build();
            賦課の情報リスト.add(賦課の情報5);
        } else if (賦課の情報4 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_3).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_3).get特徴期別額();
            賦課の情報4 = get賦課の情報(賦課の情報4, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報4.get賦課年度().plusYear(INT_1)).build();
            賦課の情報リスト.add(賦課の情報4);
        } else if (賦課の情報3 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_2).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_2).get特徴期別額();
            賦課の情報3 = get賦課の情報(賦課の情報3, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報3.get賦課年度().plusYear(INT_2)).build();
            賦課の情報リスト.add(賦課の情報3);
        } else if (賦課の情報2 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_1).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_1).get特徴期別額();
            賦課の情報2 = get賦課の情報(賦課の情報2, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報2.get賦課年度().plusYear(INT_3)).build();
            賦課の情報リスト.add(賦課の情報2);
        } else {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(0).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(0).get特徴期別額();
            賦課の情報1 = get賦課の情報(賦課の情報1, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報1.get賦課年度().plusYear(INT_4)).build();
            賦課の情報リスト.add(賦課の情報1);
        }
    }

    private void set賦課の情報6(List<FukaJoho> 賦課の情報リスト, List<ChoteiNendoKibetsuClass> 調定年度期別クラス, int idx,
            YMDHMS 算定日時, FukaJoho 賦課の情報1, FukaJoho 賦課の情報2, FukaJoho 賦課の情報3,
            FukaJoho 賦課の情報4, FukaJoho 賦課の情報5, FukaJoho 賦課の情報6) {
        if (賦課の情報6 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(idx).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(idx).get特徴期別額();
            賦課の情報6 = get賦課の情報(賦課の情報6, 算定日時, 普徴期別額List, 特徴期別額List).build();
            賦課の情報リスト.add(賦課の情報6);
        } else if (賦課の情報5 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_4).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_4).get特徴期別額();
            賦課の情報5 = get賦課の情報(賦課の情報5, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報5.get賦課年度().plusYear(INT_1)).build();
            賦課の情報リスト.add(賦課の情報5);
        } else if (賦課の情報4 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_3).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_3).get特徴期別額();
            賦課の情報4 = get賦課の情報(賦課の情報4, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報4.get賦課年度().plusYear(INT_2)).build();
            賦課の情報リスト.add(賦課の情報4);
        } else if (賦課の情報3 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_2).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_2).get特徴期別額();
            賦課の情報3 = get賦課の情報(賦課の情報3, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報3.get賦課年度().plusYear(INT_3)).build();
            賦課の情報リスト.add(賦課の情報3);
        } else if (賦課の情報2 != null) {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(INT_1).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(INT_1).get特徴期別額();
            賦課の情報2 = get賦課の情報(賦課の情報2, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報2.get賦課年度().plusYear(INT_4)).build();
            賦課の情報リスト.add(賦課の情報2);
        } else {
            List<Decimal> 普徴期別額List = 調定年度期別クラス.get(0).get普徴期別額();
            List<Decimal> 特徴期別額List = 調定年度期別クラス.get(0).get特徴期別額();
            賦課の情報1 = get賦課の情報(賦課の情報1, 算定日時, 普徴期別額List, 特徴期別額List)
                    .set調定年度(賦課の情報1.get賦課年度().plusYear(INT_5)).build();
            賦課の情報リスト.add(賦課の情報1);
        }
    }

    private FukaJohoBuilder get賦課の情報(FukaJoho 賦課の情報, YMDHMS 算定日時, List<Decimal> 普徴期別額List, List<Decimal> 特徴期別額List) {
        return 賦課の情報.createBuilderForEdit().set特徴期別金額01(特徴期別額List.get(0))
                .set特徴期別金額02(特徴期別額List.get(INT_1)).set特徴期別金額03(特徴期別額List.get(INT_2))
                .set特徴期別金額04(特徴期別額List.get(INT_3)).set特徴期別金額05(特徴期別額List.get(INT_4))
                .set特徴期別金額06(特徴期別額List.get(INT_5)).set普徴期別金額01(普徴期別額List.get(0))
                .set普徴期別金額02(普徴期別額List.get(INT_1)).set普徴期別金額03(普徴期別額List.get(INT_2))
                .set普徴期別金額04(普徴期別額List.get(INT_3)).set普徴期別金額05(普徴期別額List.get(INT_4))
                .set普徴期別金額06(普徴期別額List.get(INT_5)).set普徴期別金額07(普徴期別額List.get(INT_6))
                .set普徴期別金額08(普徴期別額List.get(INT_7)).set普徴期別金額09(普徴期別額List.get(INT_8))
                .set普徴期別金額10(普徴期別額List.get(INT_9)).set普徴期別金額11(普徴期別額List.get(INT_10))
                .set普徴期別金額12(普徴期別額List.get(INT_11)).set普徴期別金額13(普徴期別額List.get(INT_12))
                .set普徴期別金額14(普徴期別額List.get(INT_13)).set調定日時(算定日時);
    }

    private KiwariKeisanInput get期割計算の引数(ChoshuHoho 徴収方法の情報, FlexibleYear 調定年度, YMDHMS 算定日時,
            FukaJoho 賦課の情報1, FukaJoho 賦課の情報2, FukaJoho 賦課の情報3,
            FukaJoho 賦課の情報4, FukaJoho 賦課の情報5, FukaJoho 賦課の情報6,
            Decimal 今回保険料, Decimal 前回保険料) {

        KiwariKeisanInput kiwariKeisanInput = new KiwariKeisanInput();

        KoseiTsukiHantei 更正月判定 = new KoseiTsukiHantei();
        Kitsuki 過年度期月 = 更正月判定.find過年度更正月(算定日時.getDate());
        int 過年度算定期 = 過年度期月.get期AsInt();

        ITsukiShorkiKubun 過年期区分 = 過年度期月.get月処理区分();
        kiwariKeisanInput.set現在調定年度(調定年度);
        kiwariKeisanInput.set現在月(get現在月(過年度期月));
        kiwariKeisanInput.set現在期(過年度算定期);
        kiwariKeisanInput.set現在期区分(INT_5);
        kiwariKeisanInput.set特徴停止可能期(0);
        kiwariKeisanInput.set現在特徴期区分(INT_4);
        kiwariKeisanInput.set現在過年期(new RString(過年度算定期));
        kiwariKeisanInput.set現在過年期区分(過年期区分.get区分());
        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
        RDate 適用基準日 = RDate.getNowDate();
        RString 現年定例納期数 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_定例納期数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set現年定例納期数(Integer.parseInt(現年定例納期数.toString()));
        RString 普徴仮算定期数 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_仮算定期数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set普徴仮算定期数(Integer.parseInt(普徴仮算定期数.toString()));
        RString 特徴定例納期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_設定納期数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set特徴定例納期数(Integer.parseInt(特徴定例納期数.toString()));
        List<FlexibleDate> 年金支払日List = new ArrayList<>();
        RString 年金支払日_4月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_4月, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 年金支払日_6月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_6月, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 年金支払日_8月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_8月, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 年金支払日_10月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_10月, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 年金支払日_12月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_12月, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 年金支払日_2月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年金支払日_2月, 適用基準日, SubGyomuCode.DBB介護賦課);
        年金支払日List.add(new FlexibleDate(年金支払日_4月));
        年金支払日List.add(new FlexibleDate(年金支払日_6月));
        年金支払日List.add(new FlexibleDate(年金支払日_8月));
        年金支払日List.add(new FlexibleDate(年金支払日_10月));
        年金支払日List.add(new FlexibleDate(年金支払日_12月));
        年金支払日List.add(new FlexibleDate(年金支払日_2月));
        業務コンフィグ情報.set年金支払日(年金支払日List);
        RString 特徴開始前普通徴収_8月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_8月, 適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴開始前普通徴収_8月)) {
            業務コンフィグ情報.set捕捉分開始前普徴区分(定数_1);
        } else if (定数_0.equals(特徴開始前普通徴収_8月)) {
            業務コンフィグ情報.set捕捉分開始前普徴区分(定数_2);
        }
        RString 特徴開始前普通徴収_10月 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_10月, 適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴開始前普通徴収_10月)) {
            業務コンフィグ情報.set特徴開始前普徴区分(定数_1);
        } else if (定数_0.equals(特徴開始前普通徴収_10月)) {
            業務コンフィグ情報.set特徴開始前普徴区分(定数_2);
        }

        set普徴切替時期別区分(業務コンフィグ情報, 適用基準日);

        業務コンフィグ情報.set増額時普調切替区分(定数_0);
        業務コンフィグ情報.set捕捉計算区分(定数_0);
        RString 特徴減額期割方法 = DbBusinessConfig.get(ConfigNameDBB.期割計算_特徴減額期割方法, 適用基準日, SubGyomuCode.DBB介護賦課);
        if (定数_1.equals(特徴減額期割方法)) {
            業務コンフィグ情報.set併徴現年減額区分(定数_2);
        } else if (定数_2.equals(特徴減額期割方法)) {
            業務コンフィグ情報.set併徴現年減額区分(定数_0);
        }
        RString 特別徴収_期別端数 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別端数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set端数区分特徴期別額(Integer.parseInt(特別徴収_期別端数.toString()));
        RString 普通徴収_期別端数 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_期別端数, 適用基準日, SubGyomuCode.DBB介護賦課);
        業務コンフィグ情報.set端数区分普徴期別額(Integer.parseInt(普通徴収_期別端数.toString()));
        業務コンフィグ情報.set減免処理区分(INT_2);
        業務コンフィグ情報.set特徴依頼送付状況区分_10月(INT_1);
        業務コンフィグ情報.set特徴依頼送付状況区分_12月(INT_1);
        業務コンフィグ情報.set特徴依頼送付状況区分_2月(INT_1);

        業務コンフィグ情報.set普徴月クラス(get普徴月クラスリスト(調定年度));

        業務コンフィグ情報.set特徴月テーブル(get特徴月テーブル());

        kiwariKeisanInput.set業務コンフィグ情報(業務コンフィグ情報);

        kiwariKeisanInput.set賦課更正情報(get賦課更正情報(賦課の情報1, 賦課の情報2, 賦課の情報3, 賦課の情報4,
                賦課の情報5, 賦課の情報6, 前回保険料));

        kiwariKeisanInput.set変更後_確定年税額(今回保険料);
        kiwariKeisanInput.set減免額(Decimal.ZERO);
        kiwariKeisanInput.set生年月日(FlexibleDate.EMPTY);
        kiwariKeisanInput.set全部喪失年月日(FlexibleDate.EMPTY);
        kiwariKeisanInput.set特徴開始停止区分(0);
        //TODO 仕様確認 QA1087追加
        kiwariKeisanInput.set特徴開始停止期(0);

        kiwariKeisanInput.set期別徴収方法区分(get期別徴収方法区分(徴収方法の情報));

        return kiwariKeisanInput;
    }

    private RString get現在月(Kitsuki 過年度期月) {
        if (Tsuki._1月.equals(過年度期月.get月()) || Tsuki._2月.equals(過年度期月.get月())
                || Tsuki._3月.equals(過年度期月.get月())) {
            return 定数_1.concat(new RString(過年度期月.get月AsInt()).padZeroToLeft(INT_2));
        } else if (Tsuki.翌年度4月.equals(過年度期月.get月())) {
            return 定数_翌年度4月;
        } else if (Tsuki.翌年度5月.equals(過年度期月.get月())) {
            return 定数_翌年度5月;
        }
        return new RString(過年度期月.get月AsInt()).padZeroToLeft(INT_3);
    }

    private List<RString> get期別徴収方法区分(ChoshuHoho 徴収方法の情報) {
        List<RString> 期別徴収方法区分 = new ArrayList<>();
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法4月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法5月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法6月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法7月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法8月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法9月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法10月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法11月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法12月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法1月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法2月()));
        期別徴収方法区分.add(set期別徴収方法(徴収方法の情報.get徴収方法3月()));
        return 期別徴収方法区分;
    }

    private RString set期別徴収方法(RString 徴収方法) {
        if (特別徴収_厚生労働省.equals(徴収方法) || 特別徴収_地共済.equals(徴収方法)) {
            return 定数_1;
        } else {
            return 定数_0;
        }
    }

    private FukaKoseiJohoClass get賦課更正情報(FukaJoho 賦課の情報1, FukaJoho 賦課の情報2, FukaJoho 賦課の情報3,
            FukaJoho 賦課の情報4, FukaJoho 賦課の情報5, FukaJoho 賦課の情報6, Decimal 前回保険料) {
        FukaKoseiJohoClass 賦課更正情報 = new FukaKoseiJohoClass();
        if (賦課の情報1 != null) {
            賦課更正情報.set課税年度(賦課の情報1.get賦課年度());
        } else if (賦課の情報2 != null) {
            賦課更正情報.set課税年度(賦課の情報2.get賦課年度());
        } else if (賦課の情報3 != null) {
            賦課更正情報.set課税年度(賦課の情報3.get賦課年度());
        } else if (賦課の情報4 != null) {
            賦課更正情報.set課税年度(賦課の情報4.get賦課年度());
        } else if (賦課の情報5 != null) {
            賦課更正情報.set課税年度(賦課の情報5.get賦課年度());
        } else if (賦課の情報6 != null) {
            賦課更正情報.set課税年度(賦課の情報6.get賦課年度());
        }

        賦課更正情報.set変更前_確定年税額(前回保険料);

        List<ChoteiNendoKibetsuClass> 調定年度期別クラス = new ArrayList<>();
        調定年度期別クラス.add(get調定年度期別クラス(賦課の情報1));
        調定年度期別クラス.add(get調定年度期別クラス(賦課の情報2));
        調定年度期別クラス.add(get調定年度期別クラス(賦課の情報3));
        調定年度期別クラス.add(get調定年度期別クラス(賦課の情報4));
        調定年度期別クラス.add(get調定年度期別クラス(賦課の情報5));
        調定年度期別クラス.add(get調定年度期別クラス(賦課の情報6));
        //TODO qa1101確認
        //調定年度期別クラス.add(new ChoteiNendoKibetsuClass());
        //調定年度期別クラス.add(new ChoteiNendoKibetsuClass());
        //調定年度期別クラス.add(new ChoteiNendoKibetsuClass());

        賦課更正情報.set調定年度期別クラス(調定年度期別クラス);
        return 賦課更正情報;
    }

    private ChoteiNendoKibetsuClass get調定年度期別クラス(FukaJoho 賦課の情報) {
        if (賦課の情報 == null) {
            return new ChoteiNendoKibetsuClass();
        }
        ChoteiNendoKibetsuClass 調定年度期別 = new ChoteiNendoKibetsuClass();
        調定年度期別.set調定年度(賦課の情報.get調定年度());

        List<Decimal> 普徴期別額List = new ArrayList<>();
        普徴期別額List.add(賦課の情報.get普徴期別金額01());
        普徴期別額List.add(賦課の情報.get普徴期別金額02());
        普徴期別額List.add(賦課の情報.get普徴期別金額03());
        普徴期別額List.add(賦課の情報.get普徴期別金額04());
        普徴期別額List.add(賦課の情報.get普徴期別金額05());
        普徴期別額List.add(賦課の情報.get普徴期別金額06());
        普徴期別額List.add(賦課の情報.get普徴期別金額07());
        普徴期別額List.add(賦課の情報.get普徴期別金額08());
        普徴期別額List.add(賦課の情報.get普徴期別金額09());
        普徴期別額List.add(賦課の情報.get普徴期別金額10());
        普徴期別額List.add(賦課の情報.get普徴期別金額11());
        普徴期別額List.add(賦課の情報.get普徴期別金額12());
        普徴期別額List.add(賦課の情報.get普徴期別金額13());
        普徴期別額List.add(賦課の情報.get普徴期別金額14());
        調定年度期別.set普徴期別額(普徴期別額List);

        List<Decimal> 特徴期別額List = new ArrayList<>();
        特徴期別額List.add(賦課の情報.get特徴期別金額01());
        特徴期別額List.add(賦課の情報.get特徴期別金額02());
        特徴期別額List.add(賦課の情報.get特徴期別金額03());
        特徴期別額List.add(賦課の情報.get特徴期別金額04());
        特徴期別額List.add(賦課の情報.get特徴期別金額05());
        特徴期別額List.add(賦課の情報.get特徴期別金額06());
        調定年度期別.set特徴期別額(特徴期別額List);

        return 調定年度期別;
    }

    private void set普徴切替時期別区分(GyomuConfigJohoClass 業務コンフィグ情報, RDate 適用基準日) {
        RString 普徴切替方法 = DbBusinessConfig.get(ConfigNameDBB.期割計算_普徴切替方法, 適用基準日, SubGyomuCode.DBB介護賦課);
        if (重複させない.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_0);
        } else if (重複させる_01期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_1);
        } else if (重複させる_02期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_2);
        } else if (重複させる_03期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_3);
        } else if (重複させる_04期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_4);
        } else if (重複させる_05期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_5);
        } else if (重複させる_06期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_6);
        } else if (重複させる_07期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_7);
        } else if (重複させる_08期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_8);
        } else if (重複させる_09期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_9);
        } else if (重複させる_10期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_10);
        } else if (重複させる_11期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_11);
        } else if (重複させる_12期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_12);
        } else if (重複させる_13期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_13);
        } else if (重複させる_14期.equals(普徴切替方法)) {
            業務コンフィグ情報.set普徴切替時期別区分(定数_14);
        }
    }

    private List<FuchoTsukiClass> get普徴月クラスリスト(FlexibleYear 調定年度) {
        List<FuchoTsukiClass> 普徴月クラス = new ArrayList<>();
        普徴月クラス.add(get普徴月クラス(調定年度, INT_5));
        普徴月クラス.add(get普徴月クラス(調定年度, INT_4));
        普徴月クラス.add(get普徴月クラス(調定年度, INT_3));
        普徴月クラス.add(get普徴月クラス(調定年度, INT_2));
        普徴月クラス.add(get普徴月クラス(調定年度, INT_1));
        普徴月クラス.add(get普徴月クラス(調定年度, 0));
        //TODO qa1101確認
        //普徴月クラス.add(new FuchoTsukiClass());
        //普徴月クラス.add(new FuchoTsukiClass());
        //普徴月クラス.add(new FuchoTsukiClass());
        return 普徴月クラス;
    }

    private FuchoTsukiClass get普徴月クラス(FlexibleYear 調定年度, int idx) {
        FuchoTsukiClass fuchoTsukiClass = new FuchoTsukiClass();
        List<Integer> 普徴月テーブル = new ArrayList<>();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil(調定年度.minusYear(idx));
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 期月リスト = 期月リスト_普徴.toList();
        for (Kitsuki 期月 : 期月リスト) {
            普徴月テーブル.add(期月.get月AsInt());
        }

        fuchoTsukiClass.set普徴月テーブル(普徴月テーブル);
        return fuchoTsukiClass;
    }

    private List<Integer> get特徴月テーブル() {
        List<Integer> 特徴月テーブル = new ArrayList<>();
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月情報 = 月期対応取得_特徴.get期月リスト();
        List<Kitsuki> 期月リスト = 期月情報.toList();
        for (Kitsuki 期月 : 期月リスト) {
            特徴月テーブル.add(期月.get月AsInt());
        }
        return 特徴月テーブル;
    }

    private KanendoKoseiKeisanEntity set確定保険料_金額合計(FukaJoho 賦課の情報1, FukaJoho 賦課の情報2, FukaJoho 賦課の情報3,
            FukaJoho 賦課の情報4, FukaJoho 賦課の情報5, FukaJoho 賦課の情報6) {
        Decimal 今回保険料 = Decimal.ZERO;
        Decimal 前回保険料 = Decimal.ZERO;
        Decimal 期割前_普徴期別金額合計 = Decimal.ZERO;
        Decimal 期割前_特徴期別金額合計 = Decimal.ZERO;
        boolean 賦課情報年度分 = false;
        if (賦課の情報6 != null) {
            賦課情報年度分 = true;
            今回保険料 = 賦課の情報6.get確定介護保険料_年額();
            前回保険料 = 普徴期別金額合計(賦課の情報6).add(特徴期別金額合計(賦課の情報6));
            期割前_普徴期別金額合計 = 期割前_普徴期別金額合計.add(普徴期別金額合計(賦課の情報6));
            期割前_特徴期別金額合計 = 期割前_特徴期別金額合計.add(特徴期別金額合計(賦課の情報6));
        }
        if (賦課の情報5 != null) {
            if (!賦課情報年度分) {
                賦課情報年度分 = true;
                今回保険料 = 賦課の情報5.get確定介護保険料_年額();
                前回保険料 = 普徴期別金額合計(賦課の情報5).add(特徴期別金額合計(賦課の情報5));
            }
            期割前_普徴期別金額合計 = 期割前_普徴期別金額合計.add(普徴期別金額合計(賦課の情報5));
            期割前_特徴期別金額合計 = 期割前_特徴期別金額合計.add(特徴期別金額合計(賦課の情報5));
        }
        if (賦課の情報4 != null) {
            if (!賦課情報年度分) {
                賦課情報年度分 = true;
                今回保険料 = 賦課の情報4.get確定介護保険料_年額();
                前回保険料 = 普徴期別金額合計(賦課の情報4).add(特徴期別金額合計(賦課の情報4));
            }
            期割前_普徴期別金額合計 = 期割前_普徴期別金額合計.add(普徴期別金額合計(賦課の情報4));
            期割前_特徴期別金額合計 = 期割前_特徴期別金額合計.add(特徴期別金額合計(賦課の情報4));
        }
        if (賦課の情報3 != null) {
            if (!賦課情報年度分) {
                賦課情報年度分 = true;
                今回保険料 = 賦課の情報3.get確定介護保険料_年額();
                前回保険料 = 普徴期別金額合計(賦課の情報3).add(特徴期別金額合計(賦課の情報3));
            }
            期割前_普徴期別金額合計 = 期割前_普徴期別金額合計.add(普徴期別金額合計(賦課の情報3));
            期割前_特徴期別金額合計 = 期割前_特徴期別金額合計.add(特徴期別金額合計(賦課の情報3));
        }
        if (賦課の情報2 != null) {
            if (!賦課情報年度分) {
                賦課情報年度分 = true;
                今回保険料 = 賦課の情報2.get確定介護保険料_年額();
                前回保険料 = 普徴期別金額合計(賦課の情報2).add(特徴期別金額合計(賦課の情報2));
            }
            期割前_普徴期別金額合計 = 期割前_普徴期別金額合計.add(普徴期別金額合計(賦課の情報2));
            期割前_特徴期別金額合計 = 期割前_特徴期別金額合計.add(特徴期別金額合計(賦課の情報2));
        }
        if (賦課の情報1 != null) {
            if (!賦課情報年度分) {
                今回保険料 = 賦課の情報1.get確定介護保険料_年額();
                前回保険料 = 普徴期別金額合計(賦課の情報1).add(特徴期別金額合計(賦課の情報1));
            }
            期割前_普徴期別金額合計 = 期割前_普徴期別金額合計.add(普徴期別金額合計(賦課の情報1));
            期割前_特徴期別金額合計 = 期割前_特徴期別金額合計.add(特徴期別金額合計(賦課の情報1));
        }
        KanendoKoseiKeisanEntity entity = new KanendoKoseiKeisanEntity();
        entity.set今回保険料(今回保険料);
        entity.set前回保険料(前回保険料);
        entity.set普徴期別金額合計(期割前_普徴期別金額合計);
        entity.set特徴期別金額合計(期割前_特徴期別金額合計);
        return entity;
    }

    /**
     * 調定計算パラメータのチェック処理メソッドです。
     *
     * @param 賦課の情報List List<FukaJoho>
     * @param 徴収方法の情報 ChoshuHoho
     * @param 調定年度 FlexibleYear
     * @param 算定日時 YMDHMS
     * @throws ApplicationException 調定計算パラメータのチェック処理エラー
     */
    public void choteiParameterCheck(List<FukaJoho> 賦課の情報List, ChoshuHoho 徴収方法の情報,
            FlexibleYear 調定年度, YMDHMS 算定日時) throws ApplicationException {

        if (算定日時 == null || 算定日時.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(算定日時_空白メッセージ.toString()).evaluate());
        } else if (!new FlexibleDate(算定日時.getDate().toDateString()).isValid()) {
            throw new ApplicationException(UrErrorMessages.フォーマットが不正.getMessage()
                    .replace(算定日時_空白メッセージ.toString()).evaluate());
        } else if (調定年度 == null || 調定年度.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(調定年度_空白メッセージ.toString()).evaluate());
        } else if (賦課の情報List == null || 賦課の情報List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace(賦課の情報_空白メッセージ.toString()).evaluate());
        } else if (徴収方法の情報 == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace(徴収方法の情報_空白メッセージ.toString()).evaluate());
        }
        for (FukaJoho fukaJoho : 賦課の情報List) {
            if (fukaJoho.get賦課年度().isBefore(調定年度.minusYear(INT_5)) || 調定年度.isBefore(fukaJoho.get賦課年度())) {
                throw new ApplicationException(UrErrorMessages.大小関係が不正.getMessage()
                        .replace(関係_メッセージ.toString()).evaluate());
            }
        }
    }

    /**
     * 普徴期別金額合計の取得するメソッドです。
     *
     * @param fukaJoho FukaJoho
     * @return Decimal 普徴期別金額合計
     */
    private Decimal 普徴期別金額合計(FukaJoho fukaJoho) {
        return nullTOEmpty((fukaJoho.get普徴期別金額01())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額02())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額03())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額04())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額05())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額06())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額07())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額08())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額09())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額10())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額11())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額12())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額13())).
                add(nullTOEmpty(fukaJoho.get普徴期別金額14()));
    }

    /**
     * 特徴期別金額合計の取得するメソッドです。
     *
     * @param fukaJoho FukaJoho
     * @return Decimal 特徴期別金額合計
     */
    private Decimal 特徴期別金額合計(FukaJoho fukaJoho) {
        return nullTOEmpty(fukaJoho.get特徴期別金額01()).
                add(nullTOEmpty(fukaJoho.get特徴期別金額02())).
                add(nullTOEmpty(fukaJoho.get特徴期別金額03())).
                add(nullTOEmpty(fukaJoho.get特徴期別金額04())).
                add(nullTOEmpty(fukaJoho.get特徴期別金額05())).
                add(nullTOEmpty(fukaJoho.get特徴期別金額06()));
    }

    private Decimal nullTOEmpty(Decimal 金額) {
        if (金額 == null) {
            return Decimal.ZERO;
        }
        return 金額;
    }
}
