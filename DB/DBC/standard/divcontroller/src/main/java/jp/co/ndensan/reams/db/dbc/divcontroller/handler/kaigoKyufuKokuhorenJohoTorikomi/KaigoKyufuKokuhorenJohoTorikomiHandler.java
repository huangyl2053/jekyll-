/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.kaigoKyufuKokuhorenJohoTorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi.KaigoKyufuKokuhorenJohoTorikomiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigoKyufuKokuhorenJohoTorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報受取データ取込_共有子DIVのハンドラクラスです。
 */
public class KaigoKyufuKokuhorenJohoTorikomiHandler {

    private final KaigoKyufuKokuhorenJohoTorikomiDiv div;
    private final RString 同月過誤分ファイル名 = new RString("01110000");
    private final RString 通常分ファイル名 = new RString("11100000");

    private KaigoKyufuKokuhorenJohoTorikomiHandler(KaigoKyufuKokuhorenJohoTorikomiDiv div) {
        this.div = div;
    }

    /**
     * of
     *
     * @param div 画面DIV
     * @return KaigoKyufuKokuhorenJohoTorikomiHandler
     */
    public static KaigoKyufuKokuhorenJohoTorikomiHandler of(KaigoKyufuKokuhorenJohoTorikomiDiv div) {
        return new KaigoKyufuKokuhorenJohoTorikomiHandler(div);
    }

    /**
     * Mode1画面初期化
     */
    public void onLoadMode1() {
        KokuhorenDataTorikomiViewStateClass parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataTorikomiViewStateClass.class);
        RYearMonth 処理年月 = parmater.get処理年月();
        div.getTxtShoriYmd().setValue(new RDate(処理年月.toString()));
        RString 再処理区分 = parmater.get再処理区分();
        div.getTxtSaishoriKubun().setValue(SaiShoriKubun.toValue(再処理区分).get名称());
    }

    /**
     * ModeShutsuryokujunJoken2画面初期化
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     */
    public void onLoadModeShutsuryokujunJoken2(SubGyomuCode サブ業務コード, ReportId 帳票ID) {
        onLoadMode1();
        div.getShutsuRyokujun().getCcdChohyoShutsuryokujun().load(サブ業務コード, 帳票ID);
    }

    /**
     * ModeKakuninMsgJoken3画面初期化
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     */
    public void onLoadModeKakuninMsgJoken3(SubGyomuCode サブ業務コード, ReportId 帳票ID) {
        onLoadModeShutsuryokujunJoken2(サブ業務コード, 帳票ID);
        List<RString> key = new ArrayList<>();
        if (!SharedFile.searchSharedFile(通常分ファイル名).isEmpty()) {
            key.add(new RString("key1"));
        }
        if (!SharedFile.searchSharedFile(同月過誤分ファイル名).isEmpty()) {
            key.add(new RString("key0"));
        }
        div.getShoriTaishoJoho().getChkTsuJobun().setSelectedItemsByKey(key);
    }
}
