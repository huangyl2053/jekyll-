package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoKyufuKokuhorenJohoTorikomiDiv extends ICommonChildDivBaseProperties {

    void onLoadMode1();

    void onLoadModeShutsuryokujunJoken2(SubGyomuCode サブ業務コード, ReportId 帳票ID);

    void onLoadModeKakuninMsgJoken3(SubGyomuCode サブ業務コード, ReportId 帳票ID);

    List<RString> get処理対象情報();
}
