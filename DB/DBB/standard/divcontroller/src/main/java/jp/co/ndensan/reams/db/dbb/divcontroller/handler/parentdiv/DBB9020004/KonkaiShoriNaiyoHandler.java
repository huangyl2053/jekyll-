/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020004;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004.KonkaiShoriNaiyoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 完了ハンドラークラスです。
 */
public final class KonkaiShoriNaiyoHandler {

    private final KonkaiShoriNaiyoDiv div;
    private static final RString 新年度管理情報_未作成 = new RString("未作成");
    private static final RString 新年度管理情報_作成済 = new RString("作成済");
    private static final int 平成12年_西暦 = 2000;

    private KonkaiShoriNaiyoHandler(KonkaiShoriNaiyoDiv div) {
        this.div = div;
    }

    /**
     * ハンドラー生成するメソッドです。
     *
     * @param div 画面DIV
     * @return 完了ハンドラークラス
     */
    public static KonkaiShoriNaiyoHandler of(KonkaiShoriNaiyoDiv div) {
        return new KonkaiShoriNaiyoHandler(div);
    }

    /**
     * 調定年度Ddlを設定するメソッドです。
     */
    public void set調定年度() {
        RString 調定年度 = DbBusinessConfig.get(
                ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        ShoriDateKanriManager manager = InstanceProvider.create(ShoriDateKanriManager.class);
        ShoriDateKanri result = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課,
                ShoriName.新年度管理情報作成.toRString(),
                new FlexibleYear(調定年度).plusYear(1));
        RString 新年度管理情報 = 新年度管理情報_未作成;
        if (result != null && result.get基準年月日() != FlexibleDate.EMPTY) {
            新年度管理情報 = 新年度管理情報_作成済;
        }
        if (新年度管理情報_未作成.equals(新年度管理情報)) {
            setDataSource(Integer.parseInt(調定年度.toString()));
        } else if (新年度管理情報_作成済.equals(新年度管理情報)) {
            setDataSource(Integer.parseInt(調定年度.toString()) + 1);
        }
        div.getDdlChoteiNendo().setSelectedKey(調定年度);
    }

    private void setDataSource(int 調定年度) {
        List<KeyValueDataSource> ddlSourceList = new ArrayList<>();
        for (int i = 調定年度; i >= 平成12年_西暦; i--) {
            KeyValueDataSource source = new KeyValueDataSource(new RString(String.valueOf(i)),
                    new FlexibleYear(String.valueOf(i)).wareki().firstYear(FirstYear.ICHI_NEN).getYear());
            ddlSourceList.add(source);
        }
        div.getDdlChoteiNendo().setDataSource(ddlSourceList);
    }
}
