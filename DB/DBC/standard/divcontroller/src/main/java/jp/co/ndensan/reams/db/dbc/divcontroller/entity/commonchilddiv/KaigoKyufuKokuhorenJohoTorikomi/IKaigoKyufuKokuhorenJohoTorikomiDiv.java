package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBC-0980-290 wangkanglei
 */
public interface IKaigoKyufuKokuhorenJohoTorikomiDiv extends ICommonChildDivBaseProperties {

    /**
     * Mode1のメソッドます。
     */
    public void onLoadMode1();

    /**
     * ModeShutsuryokujunJoken2のメソッドます。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     */
    public void onLoadModeShutsuryokujunJoken2(SubGyomuCode サブ業務コード, ReportId 帳票ID);

    /**
     * ModeKakuninMsgJoken3のメソッドます。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportId
     */
    public void onLoadModeKakuninMsgJoken3(SubGyomuCode サブ業務コード, ReportId 帳票ID);

    /**
     * get処理対象情報のメソッドます。
     *
     * @return list
     */
    public List<RString> get処理対象情報();

    /**
     * get処理年月のメソッドます。
     *
     * @return RDate
     */
    public RDate get処理年月();

    /**
     * get再処理区分のメソッドます。
     *
     * @return RString
     */
    public RString get再処理区分();

    /**
     * get出力順IDのメソッドます。
     *
     * @return long
     */
    public Long get出力順ID();
}
