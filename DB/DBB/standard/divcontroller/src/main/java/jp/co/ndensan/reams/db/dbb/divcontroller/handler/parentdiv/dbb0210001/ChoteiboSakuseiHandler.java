/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.service.core.shoridatekanri.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 調定簿作成のHandlerクラスです。
 *
 * @author cuilin
 */
public class ChoteiboSakuseiHandler {

    private final ChoteiboSakuseiDiv div;
    private static final FlexibleYear START_CHOTEI_NENDO = new FlexibleYear("1999");

    private ChoteiboSakuseiHandler(ChoteiboSakuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div
     * @return
     */
    public static ChoteiboSakuseiHandler of(ChoteiboSakuseiDiv div) {
        return new ChoteiboSakuseiHandler(div);
    }

    public void initialize() {
        HizukeConfig config = new HizukeConfig();
        FlexibleYear choteiNendo = config.get調定年度();
        div.getDdlShoriNendo().setDataSource(createDropDownList(choteiNendo, START_CHOTEI_NENDO));
        div.getDdlShoriNendo().setSelectedKey(new RString(choteiNendo.toString()));

        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri result = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課,
                ShoriName.調定簿作成.toRString(),
                new FlexibleYear(choteiNendo.toString()));

        if (result == null) {
            RDateTime dateTime = RDateTime.of(choteiNendo.getYearValue(), 4, 1, 0, 0, 0);
            div.getTxtChushutsuStYMD().setValue(new RDate(dateTime.getDate().wareki().toDateString().toString()));
            div.getTxtChushutsuStTime().setValue(dateTime.getTime());
        } else {
            div.getTxtChushutsuStYMD().setValue(new RDate(result.get対象終了日時().getDate().wareki().toDateString().toString()));
            div.getTxtChushutsuStTime().setValue(result.get対象終了日時().getRDateTime().getTime());
        }
        div.getTxtChushutsuEdYMD().setValue(new RDate(RDate.getNowDate().wareki().toDateString().toString()));
        div.getTxtChushutsuEdTime().setValue(RDate.getNowTime());
    }

    /**
     * DropDownListを作成する
     *
     * @param choteinendo
     * @param kihonNendo
     * @return list
     */
    public List<KeyValueDataSource> createDropDownList(FlexibleYear choteinendo, FlexibleYear kihonNendo) {
        List<KeyValueDataSource> list = new ArrayList<>();

        while (kihonNendo.isBeforeOrEquals(choteinendo)) {
            KeyValueDataSource kv = new KeyValueDataSource(new RString(""), new RString(""));
            RStringBuilder rsb = new RStringBuilder();
            kv.setKey(new RString(choteinendo.toString()));
            rsb.append(choteinendo.wareki().eraType(EraType.KANJI).toDateString());
            rsb.append("年度");
            kv.setValue(rsb.toRString());
            list.add(kv);
            choteinendo = choteinendo.minusYear(1);
        }
        return list;
    }
}
