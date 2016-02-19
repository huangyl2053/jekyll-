/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.tokucho.TokuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 月期対応取得_特徴のクラスです。
 */
public class TokuchoKiUtil {

    private final RDate 適用基準日;

    /**
     * コンストラクタです。
     *
     */
    public TokuchoKiUtil() {
        適用基準日 = RDate.getNowDate();
    }

    /**
     * コンストラクタです。
     *
     * @param fYear 年度
     */
    public TokuchoKiUtil(FlexibleYear fYear) {
        適用基準日 = NendoUtil.toNendoStartDate(fYear);
    }

    /**
     * 取得した対応から、期月リストを生成する。
     *
     * @return 期月リスト
     */
    public KitsukiList get期月リスト() {
        List<Kitsuki> list = new ArrayList<>();
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル1, ConfigNameDBB.特徴期情報_月の期1, ConfigNameDBB.特徴期情報_月処理区分1));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル2, ConfigNameDBB.特徴期情報_月の期2, ConfigNameDBB.特徴期情報_月処理区分2));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル3, ConfigNameDBB.特徴期情報_月の期3, ConfigNameDBB.特徴期情報_月処理区分3));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル4, ConfigNameDBB.特徴期情報_月の期4, ConfigNameDBB.特徴期情報_月処理区分4));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル5, ConfigNameDBB.特徴期情報_月の期5, ConfigNameDBB.特徴期情報_月処理区分5));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル6, ConfigNameDBB.特徴期情報_月の期6, ConfigNameDBB.特徴期情報_月処理区分6));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル7, ConfigNameDBB.特徴期情報_月の期7, ConfigNameDBB.特徴期情報_月処理区分7));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル8, ConfigNameDBB.特徴期情報_月の期8, ConfigNameDBB.特徴期情報_月処理区分8));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル9, ConfigNameDBB.特徴期情報_月の期9, ConfigNameDBB.特徴期情報_月処理区分9));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル10, ConfigNameDBB.特徴期情報_月の期10, ConfigNameDBB.特徴期情報_月処理区分10));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル11, ConfigNameDBB.特徴期情報_月の期11, ConfigNameDBB.特徴期情報_月処理区分11));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル12, ConfigNameDBB.特徴期情報_月の期12, ConfigNameDBB.特徴期情報_月処理区分12));
        return new KitsukiList(list);
    }

    private Kitsuki getKitsuki(ConfigNameDBB 月別テーブル, ConfigNameDBB 月の期, ConfigNameDBB 月処理区分) {
        RString 月別 = BusinessConfig.get(月別テーブル, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 期 = BusinessConfig.get(月の期, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 処理区分 = BusinessConfig.get(月処理区分, 適用基準日, SubGyomuCode.DBB介護賦課);
        Tsuki 月 = Tsuki.toValue(月別.padLeft(new RString("0"), 2));
        return new Kitsuki(月, 期, TokuchokiJohoTsukiShoriKubun.toValue(処理区分), true, new KitsukiHyoki(月, 期));
    }
}
