/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.choshuhoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.config.ConfigKeysHizuke;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 徴収方法更新のクラスです。
 *
 * @reamsid_L DBB-9070-010 huangyanan
 */
public class ChoshuHohoKoshin {

    private final Map<ConfigKeysHizuke, RString> configs;
    private final RString 特別徴収_厚生労働省 = new RString("1");
    private final RString 特別徴収_地共済 = new RString("2");
    private final FlexibleDate 最大の日 = FlexibleDate.MAX;
    private static final int 数字_1 = 1;
    private static final int 数字_2 = 2;
    private static final int 数字_3 = 3;
    private static final int 数字_4 = 4;
    private static final int 数字_5 = 5;
    private static final int 数字_6 = 6;
    private static final int 数字_7 = 7;
    private static final int 数字_8 = 8;
    private static final int 数字_9 = 9;
    private static final int 数字_10 = 10;
    private static final int 数字_11 = 11;
    private static final int 数字_12 = 12;
    private static final int 数字_13 = 13;
    private static final int 数字_14 = 14;
    private static final int 数字_15 = 15;
    private static final int 数字_16 = 16;
    private static final int 数字_17 = 17;
    private static final int 数字_18 = 18;

    /**
     * コンストラクタです。
     */
    ChoshuHohoKoshin() {
        this.configs = createMap();
    }

    private Map<ConfigKeysHizuke, RString> createMap() {
        Map<ConfigKeysHizuke, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHizuke target : ConfigKeysHizuke.values()) {
            map.put(target, DbBusinessConfig.get(target, nowDate));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param configs configs
     */
    ChoshuHohoKoshin(
            Map<ConfigKeysHizuke, RString> configs) {
        this.configs = configs;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChoshuHohoKoshin}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChoshuHohoKoshin}のインスタンス
     */
    public static ChoshuHohoKoshin createInstance() {
        return InstanceProvider.create(ChoshuHohoKoshin.class);
    }

    /**
     * 徴収方法更新
     *
     * @param 徴収方法の情報 徴収方法の情報
     * @param 特別徴収停止日時 特別徴収停止日時
     * @param 資格取得日 資格取得日
     * @param 資格喪失日 資格喪失日
     * @return 徴収方法の情報
     */
    public ChoshuHoho getChoshuHohoKoshinData(ChoshuHoho 徴収方法の情報, YMDHMS 特別徴収停止日時,
            FlexibleDate 資格取得日, FlexibleDate 資格喪失日) {
        int 特徴停止月;
        int 特徴停止月Idx = 0;
        int 資格取得月Idx;
        int 資格喪失月Idx;
        List<RString> 特徴停止月List = new ArrayList<>();
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル1));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル2));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル3));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル4));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル5));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル6));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル7));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル8));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル9));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル10));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル11));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル12));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル13));
        特徴停止月List.add(configs.get(ConfigKeysHizuke.日付関連_月別テーブル14));
        if (特別徴収停止日時 != null && !特別徴収停止日時.isEmpty()) {
            if (特別徴収停止日時.getMonthValue() % 2 == 0) {
                特徴停止月 = 特別徴収停止日時.getMonthValue();
            } else {
                if (特別徴収停止日時.getMonthValue() == 数字_1) {
                    特徴停止月 = 数字_12;
                } else {
                    特徴停止月 = 特別徴収停止日時.getMonthValue() - 1;
                }
            }

            for (int i = 1; i <= 数字_12; i++) {
                if (特徴停止月 == Integer.parseInt(特徴停止月List.get(i - 1).toString())) {
                    特徴停止月Idx = i;
                    break;
                }
            }
            if (特徴停止月 == 数字_2) {
                徴収方法の情報 = get特徴停止月が2月(徴収方法の情報, 特徴停止月Idx);
            } else {
                徴収方法の情報 = get特徴停止月が2月以外(徴収方法の情報, 特徴停止月, 特徴停止月Idx);
            }
            ChoshuHoho 徴収方法情報 = 徴収方法の情報;
            int 履歴番号 = 徴収方法の情報.get履歴番号() + 1;
            徴収方法の情報 = 徴収方法の情報.createBuilderForEdit().set履歴番号(履歴番号).build();
            RString 特別徴収停止事由コード = ChoteiJiyuCode.年金保険者からの通知.getコード();
            徴収方法の情報 = 徴収方法の情報.createBuilderForEdit().set特別徴収停止事由コード(特別徴収停止事由コード).build();

            if (資格取得日 == null || 資格喪失日 == null || 資格取得日.isEmpty() || 資格喪失日.isEmpty()) {
                return 徴収方法の情報;
            }
            資格取得月Idx = get資格取得月Idx(資格取得日, 特徴停止月List);
            資格喪失月Idx = get資格喪失月Idx(資格喪失日, 特徴停止月List);
            徴収方法の情報 = get徴収方法の変更(徴収方法の情報, 資格取得月Idx, 資格喪失月Idx);

            int 履歴番号の変更 = 徴収方法情報.get履歴番号() + 1;
            徴収方法の情報 = 徴収方法の情報.createBuilderForEdit().set履歴番号(履歴番号の変更).build();
            if (!資格喪失日.isEmpty() && (!最大の日.equals(資格喪失日))) {
                RString 特別徴収停止事由コードの変更 = ChoteiJiyuCode.資格喪失特徴中止.getコード();
                徴収方法の情報 = 徴収方法の情報.createBuilderForEdit().set特別徴収停止事由コード(特別徴収停止事由コードの変更).build();
            }
            return 徴収方法の情報;
        } else {
            資格取得月Idx = get資格取得月Idx(資格取得日, 特徴停止月List);
            for (int intIdx = 資格取得月Idx; intIdx <= 数字_18; intIdx++) {
                徴収方法の情報 = set徴収方法の情報(徴収方法の情報, intIdx, new RString("3"));
            }
            return 徴収方法の情報;
        }
    }

    private ChoshuHoho get徴収方法の変更(ChoshuHoho 徴収方法の情報, int 資格取得月Idx, int 資格喪失月Idx) {
        for (int intIdx = 資格取得月Idx; intIdx <= 数字_18; intIdx++) {
            if (intIdx < 資格喪失月Idx) {
                徴収方法の情報 = set徴収方法の情報(徴収方法の情報, intIdx, new RString("0"));
            }
        }

        for (int intIdx = 資格喪失月Idx; intIdx <= 数字_18; intIdx++) {
            徴収方法の情報 = set徴収方法の情報(徴収方法の情報, intIdx, new RString("0"));
        }
        return 徴収方法の情報;
    }

    private int get資格取得月Idx(FlexibleDate 資格取得日, List<RString> 特徴停止月List) {
        int 資格取得月Idx = 0;
        if (資格取得日.isBefore(new FlexibleDate(configs.get(ConfigKeysHizuke.日付関連_調定年度).toString()
                + "0401"))) {
            資格取得月Idx = 数字_1;
        } else {
            for (int i = 1; i <= 数字_12; i++) {
                if (資格取得日.getMonthValue() == Integer.parseInt(特徴停止月List.get(i - 1).toString())) {
                    資格取得月Idx = i;
                    break;
                }
            }
        }
        return 資格取得月Idx;
    }

    private int get資格喪失月Idx(FlexibleDate 資格喪失日, List<RString> 特徴停止月List) {
        int 資格喪失月Idx = 0;
        if ((new FlexibleDate(configs.get(ConfigKeysHizuke.日付関連_調定年度).toString() + "0401").plusYear(数字_1))
                .isBeforeOrEquals(資格喪失日)) {
            if (資格喪失日.getMonthValue() == 数字_4) {
                return 数字_13;
            }
            if (資格喪失日.getMonthValue() == 数字_5) {
                return 数字_14;
            }
            if (資格喪失日.getMonthValue() == 数字_6) {
                return 数字_15;
            }
            if (資格喪失日.getMonthValue() == 数字_7) {
                return 数字_16;
            }
            if (資格喪失日.getMonthValue() == 数字_8) {
                return 数字_17;
            }
            if (資格喪失日.getMonthValue() == 数字_9) {
                return 数字_18;
            }
        } else {
            if (資格喪失日.isBefore(new FlexibleDate(configs.get(ConfigKeysHizuke.日付関連_調定年度).toString()
                    + "0401"))) {
                return 数字_1;
            }
            for (int i = 1; i <= 数字_12; i++) {
                if (資格喪失日.getMonthValue() == Integer.parseInt(特徴停止月List.get(i - 1).toString())) {
                    資格喪失月Idx = i;
                    break;
                }
            }
        }
        return 資格喪失月Idx;
    }

    private ChoshuHoho get特徴停止月が2月(ChoshuHoho 徴収方法の情報, int 特徴停止月Idx) {
        RString 徴収方法 = get徴収方法(徴収方法の情報, 特徴停止月Idx);
        if (特別徴収_厚生労働省.equals(徴収方法) || 特別徴収_地共済.equals(徴収方法)) {
            for (int intIdx = 特徴停止月Idx; intIdx <= 数字_18; intIdx++) {
                徴収方法の情報 = set徴収方法の情報(徴収方法の情報, intIdx, new RString("3"));
            }
            徴収方法の情報 = 徴収方法の情報.createBuilderForEdit().set翌年度仮徴収_基礎年金番号(new RString(""))
                    .set翌年度仮徴収_年金コード(new RString("")).set翌年度仮徴収_捕捉月(new RString("")).build();
        }
        return 徴収方法の情報;
    }

    private ChoshuHoho get特徴停止月が2月以外(ChoshuHoho 徴収方法の情報, int 特徴停止月, int 特徴停止月Idx) {
        RString 徴収方法 = get徴収方法(徴収方法の情報, 特徴停止月Idx);
        if (特別徴収_厚生労働省.equals(徴収方法) || 特別徴収_地共済.equals(徴収方法)) {
            if (特徴停止月 > 数字_3 && 特徴停止月 < 数字_10) {
                for (int intIdx = 特徴停止月Idx; intIdx <= 数字_6; intIdx++) {
                    徴収方法の情報 = set徴収方法の情報(徴収方法の情報, intIdx, new RString("3"));
                }
            } else {
                for (int intIdx = 特徴停止月Idx; intIdx <= 数字_18; intIdx++) {
                    徴収方法の情報 = set徴収方法の情報(徴収方法の情報, intIdx, new RString("3"));
                }
                徴収方法の情報 = 徴収方法の情報.createBuilderForEdit().set翌年度仮徴収_基礎年金番号(new RString(""))
                        .set翌年度仮徴収_年金コード(new RString("")).set翌年度仮徴収_捕捉月(new RString("")).build();
            }
        }
        return 徴収方法の情報;
    }

    private RString get徴収方法(ChoshuHoho 徴収方法の情報, int 特徴停止月Idx) {
        switch (特徴停止月Idx) {
            case 数字_1:
                return 徴収方法の情報.get徴収方法4月();
            case 数字_2:
                return 徴収方法の情報.get徴収方法5月();
            case 数字_3:
                return 徴収方法の情報.get徴収方法6月();
            case 数字_4:
                return 徴収方法の情報.get徴収方法7月();
            case 数字_5:
                return 徴収方法の情報.get徴収方法8月();
            case 数字_6:
                return 徴収方法の情報.get徴収方法9月();
            case 数字_7:
                return 徴収方法の情報.get徴収方法10月();
            case 数字_8:
                return 徴収方法の情報.get徴収方法11月();
            case 数字_9:
                return 徴収方法の情報.get徴収方法12月();
            case 数字_10:
                return 徴収方法の情報.get徴収方法1月();
            case 数字_11:
                return 徴収方法の情報.get徴収方法2月();
            case 数字_12:
                return 徴収方法の情報.get徴収方法3月();
            case 数字_13:
                return 徴収方法の情報.get徴収方法翌4月();
            case 数字_14:
                return 徴収方法の情報.get徴収方法翌5月();
            case 数字_15:
                return 徴収方法の情報.get徴収方法翌6月();
            case 数字_16:
                return 徴収方法の情報.get徴収方法翌7月();
            case 数字_17:
                return 徴収方法の情報.get徴収方法翌8月();
            case 数字_18:
                return 徴収方法の情報.get徴収方法翌9月();
            default:
                return null;
        }
    }

    private ChoshuHoho set徴収方法の情報(ChoshuHoho 徴収方法の情報, int intIdx, RString 徴収の値) {
        switch (intIdx) {
            case 数字_1:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法4月(徴収の値).build();
            case 数字_2:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法5月(徴収の値).build();
            case 数字_3:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法6月(徴収の値).build();
            case 数字_4:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法7月(徴収の値).build();
            case 数字_5:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法8月(徴収の値).build();
            case 数字_6:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法9月(徴収の値).build();
            case 数字_7:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法10月(徴収の値).build();
            case 数字_8:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法11月(徴収の値).build();
            case 数字_9:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法12月(徴収の値).build();
            case 数字_10:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法1月(徴収の値).build();
            case 数字_11:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法2月(徴収の値).build();
            case 数字_12:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法3月(徴収の値).build();
            case 数字_13:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法翌4月(徴収の値).build();
            case 数字_14:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法翌5月(徴収の値).build();
            case 数字_15:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法翌6月(徴収の値).build();
            case 数字_16:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法翌7月(徴収の値).build();
            case 数字_17:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法翌8月(徴収の値).build();
            case 数字_18:
                return 徴収方法の情報.createBuilderForEdit().set徴収方法翌9月(徴収の値).build();
            default:
                return null;
        }
    }

}
