/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha;

import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理対象者が資格取得・喪失などが可能な住民であるかを、チェックするための処理を定義しています。
 *
 * @author n8178
 */
public final class ShikakuTokusoChecker {

    private ShikakuTokusoChecker() {
    }

    private enum ShutokuMenu {

        転入により取得("DBAMN21001"),
        第2号被保険者取得申請により取得("DBAMN21002"),
        外国人申請により取得("DBAMN21003"),
        年齢到達により取得("DBAMN21004"),
        転居により取得_施設退所等("DBAMN21005"),
        帰化により取得("DBAMN21006"),
        職権により取得("DBAMN21007"),
        その他事由により取得("DBAMN21008");

        private final RString id;

        private ShutokuMenu(String id) {
            this.id = new RString(id);
        }

        public static ShutokuMenu toValue(RString id) {
            for (ShutokuMenu menu : values()) {
                if (menu.id.equals(id)) {
                    return menu;
                }
            }
            throw new IllegalArgumentException("資格取得メニューに変換できない文字列が渡されました：" + id);
        }
    }

    private enum SoshitsuMenu {

        転出により喪失("DBAMN22001"),
        死亡により喪失("DBAMN22002"),
        転居により喪失_施設入所等("DBAMN22003"),
        国籍喪失により喪失("DBAMN22004"),
        医療保険未加入により喪失("DBAMN22005"),
        職権により喪失("DBAMN22006"),
        その他事由により喪失("DBAMN22007");

        private final RString id;

        private SoshitsuMenu(String id) {
            this.id = new RString(id);
        }

        public static SoshitsuMenu toValue(RString id) {
            for (SoshitsuMenu menu : values()) {
                if (menu.id.equals(id)) {
                    return menu;
                }
            }
            throw new IllegalArgumentException("資格喪失メニューに変換できない文字列が渡されました：" + id);
        }
    }

    /**
     * 資格が取得可能かをチェックします。
     *
     * @param 対象者 対象者
     * @param メニューID メニューID
     * @return 資格取得可能な場合true
     */
    public static boolean is取得可能(IKojin 対象者, RString メニューID) {
        JuminShubetsu 住民種別 = 対象者.get住民種別();
        JuminJotai 住民状態 = 対象者.get住民状態();

        switch (ShutokuMenu.toValue(メニューID)) {
            case 転入により取得:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case 第2号被保険者取得申請により取得:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case 外国人申請により取得:
                if (!is外国人(住民種別)) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case 年齢到達により取得:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態)
                    || JuminJotai.住登外.equals(住民状態)
                    || JuminJotai.消除者.equals(住民状態)
                    || JuminJotai.転出者.equals(住民状態)
                    || JuminJotai.死亡者.equals(住民状態)) {
                    return true;
                }
                break;
            case 転居により取得_施設退所等:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case 帰化により取得:
                if (!is日本人(住民種別)) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case 職権により取得:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case その他事由により取得:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態)
                    || JuminJotai.住登外.equals(住民状態)
                    || JuminJotai.消除者.equals(住民状態)
                    || JuminJotai.転出者.equals(住民状態)
                    || JuminJotai.死亡者.equals(住民状態)) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    /**
     * 資格が喪失可能かをチェックします。
     *
     * @param 対象者 対象者
     * @param メニューID メニューID
     * @return 資格喪失可能な場合true
     */
    public static boolean is喪失可能(IKojin 対象者, RString メニューID) {
        JuminShubetsu 住民種別 = 対象者.get住民種別();
        JuminJotai 住民状態 = 対象者.get住民状態();

        switch (SoshitsuMenu.toValue(メニューID)) {
            case 転出により喪失:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.転出者.equals(住民状態)) {
                    return true;
                }
                break;
            case 死亡により喪失:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.死亡者.equals(住民状態)) {
                    return true;
                }
                break;
            case 転居により喪失_施設入所等:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case 国籍喪失により喪失:
                if (!(is日本人(住民種別))) {
                    return false;
                }
                if (JuminJotai.消除者.equals(住民状態)) {
                    return true;
                }
                break;
            case 医療保険未加入により喪失:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態) || JuminJotai.住登外.equals(住民状態)) {
                    return true;
                }
                break;
            case 職権により喪失:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.消除者.equals(住民状態)) {
                    return true;
                }
                break;
            case その他事由により喪失:
                if (!(is日本人(住民種別) || is外国人(住民種別))) {
                    return false;
                }
                if (JuminJotai.住民.equals(住民状態)
                    || JuminJotai.住登外.equals(住民状態)
                    || JuminJotai.消除者.equals(住民状態)
                    || JuminJotai.転出者.equals(住民状態)
                    || JuminJotai.死亡者.equals(住民状態)) {
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    private static boolean is日本人(JuminShubetsu 住民種別) {
        return JuminShubetsu.住登外個人_日本人.equals(住民種別) || JuminShubetsu.日本人.equals(住民種別);
    }

    private static boolean is外国人(JuminShubetsu 住民種別) {
        return JuminShubetsu.住登外個人_外国人.equals(住民種別) || JuminShubetsu.外国人.equals(住民種別);
    }
}
