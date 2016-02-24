/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.util.NendoUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.kanendo.KanendoTsukiShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 月期対応取得_過年度のクラスです。
 */
public class KanendoKiUtil {

    private final RDate 適用基準日;

    /**
     * コンストラクタです。
     *
     */
    public KanendoKiUtil() {
        適用基準日 = RDate.getNowDate();
    }

    /**
     * コンストラクタです。
     *
     * @param fYear 年度
     */
    public KanendoKiUtil(FlexibleYear fYear) {
        適用基準日 = NendoUtil.toNendoStartDate(fYear);
    }

    /**
     * 取得した対応から、期月リストを生成する。
     *
     * @return 期月リスト
     */
    public KitsukiList get期月リスト() {
        List<Kitsuki> list = new ArrayList<>();
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル1, ConfigNameDBB.過年度期情報_月の期1));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル2, ConfigNameDBB.過年度期情報_月の期2));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル3, ConfigNameDBB.過年度期情報_月の期3));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル4, ConfigNameDBB.過年度期情報_月の期4));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル5, ConfigNameDBB.過年度期情報_月の期5));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル6, ConfigNameDBB.過年度期情報_月の期6));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル7, ConfigNameDBB.過年度期情報_月の期7));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル8, ConfigNameDBB.過年度期情報_月の期8));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル9, ConfigNameDBB.過年度期情報_月の期9));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル10, ConfigNameDBB.過年度期情報_月の期10));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル11, ConfigNameDBB.過年度期情報_月の期11));
        list.add(getKitsuki(ConfigNameDBB.日付関連_月別テーブル12, ConfigNameDBB.過年度期情報_月の期12));
        return new KitsukiList(list);
    }

    private Kitsuki getKitsuki(ConfigNameDBB 月別テーブル, ConfigNameDBB 月の期) {
        RString 月別 = BusinessConfig.get(月別テーブル, 適用基準日, SubGyomuCode.DBB介護賦課);
        RString 期 = BusinessConfig.get(月の期, 適用基準日, SubGyomuCode.DBB介護賦課);
        Tsuki 月 = Tsuki.toValue(月別.padLeft(new RString("0"), 2));
        return new Kitsuki(月, 期, KanendoTsukiShoriKubun.随時, true, new KitsukiHyoki(月, 期));
    }
}
