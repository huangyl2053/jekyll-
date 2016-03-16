package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoKyufuKokuhorenJohoTorikomiDiv extends ICommonChildDivBaseProperties {

    /**
     * onLoadMode1
     */
    public void onLoadMode1();

    /**
     * onLoadModeShutsuryokujunJoken2
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     */
    public void onLoadModeShutsuryokujunJoken2(SubGyomuCode サブ業務コード, ReportId 帳票ID);

    /**
     * onLoadModeKakuninMsgJoken3
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     */
    public void onLoadModeKakuninMsgJoken3(SubGyomuCode サブ業務コード, ReportId 帳票ID);

    /**
     * get処理対象情報
     *
     * @return list
     */
    public List<RString> get処理対象情報();

    /**
     * get処理年月
     *
     * @return RDate
     */
    public RDate get処理年月();

    /**
     * get再処理区分
     *
     * @return RString
     */
    public RString get再処理区分();

    /**
     * get出力順ID
     *
     * @return long
     */
    public Long get出力順ID();
}
