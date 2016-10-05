package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KokuhorenJohoSofu.KokuhorenJohoSofu;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBC-3300-030 wangxingpeng
 */
public interface IKokuhorenJohoSofuDiv extends ICommonChildDivBaseProperties {

    /**
     * Mode1のメソッドます。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 外部ＣＳＶファイル名 RString
     * @param 状態パターン RString
     */
    public void initialize(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名, RString 状態パターン);

    /**
     * Mode1のメソッドます。
     *
     * @param 処理年月 RYearMonth
     * @param 再処理区分 RString
     * @param 外部ＣＳＶファイル名 RString
     * @param サイクル区分 RString
     * @param 状態パターン RString
     */
    public void initialize(RYearMonth 処理年月, RString 再処理区分, RString 外部ＣＳＶファイル名, RString サイクル区分, RString 状態パターン);

    /**
     * get送付対象情報のkeyのメソッドます。
     *
     * @return RString
     */
    public RString get送付対象情報のkey();

    /**
     * get送付対象情報のValueメソッドます。
     *
     * @return RString
     */
    public RString get送付対象情報のValue();

    /**
     * get処理年月のValueのメソッドます。
     *
     * @return RDate
     */
    public RDate get処理年月のValue();

    /**
     * get再処理区分のValueのメソッドます。
     *
     * @return RString
     */
    public RString get再処理区分のValue();
}
