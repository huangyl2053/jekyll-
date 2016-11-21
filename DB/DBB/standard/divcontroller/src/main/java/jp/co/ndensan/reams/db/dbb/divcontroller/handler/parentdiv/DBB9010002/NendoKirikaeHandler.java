/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB901002.DBB901002_NendoKirikaeParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010002.NendoKirikaeDiv;
import jp.co.ndensan.reams.db.dbb.service.core.shoridatekanri.ShoriDateKanriFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 年度切替のクラスです
 *
 * @reamsid_L DBB-5722-010 zhengshenlei
 */
public class NendoKirikaeHandler {

    private static final RString 新年度管理情報作成 = new RString("新年度管理情報作成");
    private static final RString 特徴対象者同定_6月開始分 = new RString("特徴対象者同定（6月開始分）");
    private static final RString 年度切替 = new RString("年度切替");
    private final NendoKirikaeDiv div;
    private static final int NUM_1 = 1;

    /**
     * コンストラクタです。
     *
     * @param div NendoKirikaeDiv
     */
    public NendoKirikaeHandler(NendoKirikaeDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        RString 当年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        if (null != 当年度 && (!RString.isNullOrEmpty(当年度))) {
            新年度管理情報作成_終了チェック(当年度);
            特徴対象者同定_6月開始分_終了チェック(当年度);
            年度切替処理_終了チェック(当年度);RYear tokyo当年度 = new RYear(当年度.toString());
            RYear tokyo新年度 = tokyo当年度.plusYear(NUM_1);
            div.getDcLblTonendo().setValue(new RDate(tokyo当年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().toString()));
            div.getDcLblShinnendo().setValue(new RDate(tokyo新年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().toString()));
        }
    }

    private void 新年度管理情報作成_終了チェック(RString 当年度) {
        ShoriDateKanriFinder find = new ShoriDateKanriFinder();
        List<ShoriDateKanri> resultList = find.get処理日付管理情報(
                ShoriName.新年度管理情報作成.get名称(), new FlexibleYear(当年度.toString()));
        boolean is処理不可 = false;
        if (null == resultList || resultList.isEmpty()) {
            is処理不可 = true;
        } else {
            for (ShoriDateKanri result : resultList) {
                if (null == result.get基準日時()) {
                    is処理不可 = true;
                }
            }
        }
        if (is処理不可) {
            Message message = DbbErrorMessages.処理不可_関連機能未処理済.getMessage().replace(
                    新年度管理情報作成.toString(), 年度切替.toString());
            throw new ApplicationException(message.evaluate());
        }
    }

    private void 特徴対象者同定_6月開始分_終了チェック(RString 当年度) {
        ShoriDateKanriFinder find = new ShoriDateKanriFinder();
        List<ShoriDateKanri> resultList = find.get特徴対象者同定_6月開始分(
                ShoriName.特徴対象者同定.get名称(), new FlexibleYear(当年度.toString()));
        boolean is処理不可 = false;
        if (null == resultList || resultList.isEmpty()) {
            is処理不可 = true;
        } else {
            for (ShoriDateKanri result : resultList) {
                if (null == result.get基準日時()) {
                    is処理不可 = true;
                }
            }
        }
        if (is処理不可) {
            Message message = DbbErrorMessages.処理不可_関連機能未処理済.getMessage().replace(
                    特徴対象者同定_6月開始分.toString(), 年度切替.toString());
            throw new ApplicationException(message.evaluate());
        }
    }

    private void 年度切替処理_終了チェック(RString 当年度) {
        ShoriDateKanriFinder find = new ShoriDateKanriFinder();
        List<ShoriDateKanri> resultList = find.get処理日付管理情報(
                ShoriName.年度切替.get名称(), new FlexibleYear(当年度.toString()).plusYear(1));
        boolean is処理不可 = false;
        if (null != resultList && (!resultList.isEmpty())) {
            for (ShoriDateKanri result : resultList) {
                if (null != result.get基準日時()) {
                    is処理不可 = true;
                }
            }
        }
        if (is処理不可) {
            Message message = DbbErrorMessages.処理済み.getMessage().replace(年度切替.toString());
            throw new ApplicationException(message.evaluate());
        }
    }

    /**
     * バッチ実行のメソッドです
     *
     * @return DBB901002_NendoKirikaeParameter
     */
    public DBB901002_NendoKirikaeParameter バッチ実行() {
        DBB901002_NendoKirikaeParameter parameter = new DBB901002_NendoKirikaeParameter();
        RString 当年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        FlexibleYear 調定年度 = new FlexibleYear(当年度.toString());
        parameter.set調定年度(調定年度);
        return parameter;
    }

}
