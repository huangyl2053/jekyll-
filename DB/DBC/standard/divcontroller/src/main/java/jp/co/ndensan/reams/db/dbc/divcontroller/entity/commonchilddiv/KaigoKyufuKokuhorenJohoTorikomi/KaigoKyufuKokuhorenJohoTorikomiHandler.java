/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KokiKokuhoShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 国保連情報受取データ取込_共有子DIVのハンドラクラスです。
 *
 * @reamsid_L DBC-0980-290 wangkanglei
 */
public class KaigoKyufuKokuhorenJohoTorikomiHandler {

    private final KaigoKyufuKokuhorenJohoTorikomiDiv div;
    private static final RString 同月過誤分ファイル名 = new RString("01110000");
    private static final RString 通常分ファイル名 = new RString("11100000");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString STR_1 = new RString("1");
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param div KaigoKyufuKokuhorenJohoTorikomiDiv
     */
    public KaigoKyufuKokuhorenJohoTorikomiHandler(KaigoKyufuKokuhorenJohoTorikomiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KaigoKyufuKokuhorenJohoTorikomiHandler
     */
    public static KaigoKyufuKokuhorenJohoTorikomiHandler of(KaigoKyufuKokuhorenJohoTorikomiDiv div) {
        return new KaigoKyufuKokuhorenJohoTorikomiHandler(div);
    }

    /**
     * Mode1画面初期化のメソッドます。
     *
     * @param parmater 国保連取込情報
     */
    public void onLoadMode1(KokuhorenDataTorikomiViewStateClass parmater) {
        RYearMonth 処理年月 = parmater.get処理年月();
        div.getTxtShoriYmd().setValue(new RDate(処理年月.toString()));
        RString 再処理区分 = parmater.get再処理区分();
        if (STR_1.equals(再処理区分)) {
            div.getTxtSaishoriKubun().setValue(SaiShoriKubun.toValue(再処理区分).get名称());
        } else {
            div.getTxtSaishoriKubun().setValue(RString.EMPTY);
        }
        div.getTxtShoriTaisho().setDisplayNone(true);
    }

    /**
     * ModeShutsuryokujunJoken2画面初期化のメソッドます。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     * @param parmater 国保連取込情報
     */
    public void onLoadModeShutsuryokujunJoken2(SubGyomuCode サブ業務コード,
            ReportId 帳票ID,
            KokuhorenDataTorikomiViewStateClass parmater) {
        onLoadMode1(parmater);
        RString 交換情報識別番号 = parmater.get交換情報識別番号();
        RString 処理区分 = RString.EMPTY;
        RString 処理対象 = RString.EMPTY;
        if (交換情報識別番号.length() == NUM_4) {
            処理区分 = 交換情報識別番号.substring(NUM_3, NUM_4);
            処理対象 = KaigoGassan_KokiKokuhoShoriKubun.toValue(処理区分).get名称();
            div.getTxtShoriTaisho().setDisplayNone(false);
        } else {
            div.getTxtShoriTaisho().setDisplayNone(true);
        }
        RString 再処理区分 = SaiShoriKubun.toValue(parmater.get再処理区分()).get名称();
        div.getTxtShoriTaisho().setValue(処理対象);
        div.getHdnShoriKubun().setValue(処理区分);
        div.getTxtSaishoriKubun().setValue(再処理区分);
        div.getShutsuRyokujun().getCcdChohyoShutsuryokujun().load(サブ業務コード, 帳票ID);
    }

    /**
     * ModeKakuninMsgJoken3画面初期化のメソッドます。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     * @param parmater 国保連取込情報
     */
    public void onLoadModeKakuninMsgJoken3(SubGyomuCode サブ業務コード,
            ReportId 帳票ID,
            KokuhorenDataTorikomiViewStateClass parmater) {
        onLoadModeShutsuryokujunJoken2(サブ業務コード, 帳票ID, parmater);
        List<RString> key = new ArrayList<>();
        if (!SharedFile.searchSharedFile(通常分ファイル名).isEmpty()) {
            key.add(KEY_1);
        }
        if (!SharedFile.searchSharedFile(同月過誤分ファイル名).isEmpty()) {
            key.add(KEY_0);
        }
        div.getShoriTaishoJoho().getChkTsuJobun().setSelectedItemsByKey(key);
    }
}
