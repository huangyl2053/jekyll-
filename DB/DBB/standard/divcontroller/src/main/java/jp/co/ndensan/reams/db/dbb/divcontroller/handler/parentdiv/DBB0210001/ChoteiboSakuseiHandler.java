/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 調定簿作成のHandlerクラスです。
 *
 * @reamsid_L DBB-0770-010 cuilin
 */
public final class ChoteiboSakuseiHandler {

    private final ChoteiboSakuseiDiv div;
    private static final FlexibleYear SHORI_START_NENDO = new FlexibleYear("1999");
    private static final int 四月 = 4;
    private static final int INT_1 = 1;

    private ChoteiboSakuseiHandler(ChoteiboSakuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 調定簿作成Div
     * @return 調定簿作成Handler
     */
    public static ChoteiboSakuseiHandler of(ChoteiboSakuseiDiv div) {
        return new ChoteiboSakuseiHandler(div);
    }

    /**
     * 調定簿作成初期化処理します。
     */
    public void initialize() {
        HizukeConfig config = new HizukeConfig();
        FlexibleYear 処理年度 = config.get調定年度();
        if (処理年度.isEmpty()) {
            return;
        }
        div.getDdlShoriNendo().setDataSource(createDropDownList(処理年度, SHORI_START_NENDO));
        div.getDdlShoriNendo().setSelectedKey(処理年度.toDateString());

        ShoriDateKanriManager manager = InstanceProvider.create(ShoriDateKanriManager.class);
        ShoriDateKanri result = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課,
                ShoriName.調定簿作成.get名称(),
                処理年度);
        if (result == null) {
            RDateTime dateTime = RDateTime.of(処理年度.getYearValue(), 四月, INT_1, 0, 0, 0);
            div.getTxtChushutsuStYMD().setValue(dateTime.getDate());
            div.getTxtChushutsuStTime().setValue(dateTime.getTime());
        } else {
            div.getTxtChushutsuStYMD().setValue(result.get対象終了日時().getDate());
            div.getTxtChushutsuStTime().setValue(result.get対象終了日時().getRDateTime().getTime());
        }
        div.getTxtChushutsuEdYMD().setValue(RDate.getNowDate());
        div.getTxtChushutsuEdTime().setValue(RDate.getNowTime());
    }

    /**
     * DropDownListを作成する
     *
     * @param 処理年度 処理年度
     * @param 処理開始年度 処理開始年度
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> createDropDownList(FlexibleYear 処理年度, FlexibleYear 処理開始年度) {
        List<KeyValueDataSource> list = new ArrayList<>();
        while (処理開始年度.isBeforeOrEquals(処理年度)) {
            KeyValueDataSource kv = new KeyValueDataSource(処理年度.toDateString(), 処理年度.wareki().toDateString());
            list.add(kv);
            処理年度 = 処理年度.minusYear(1);
        }
        return list;
    }
}
