package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE011001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseijouhouinnsatu.ShinseiJouhouInsatuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請情報印刷のバチパラメータクラスです。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE011001_ShinseiInfoPrintParameter extends BatchParameterBase {

    private static final long serialVersionUID = -3010965675691712156L;
    private static final String SHINSEI_MONITORFLAG = "shinseimonitorflag";
    private static final String YOKAIGOYOSHIENSEII_CHIRANFLAG = "yokaigoyoshienseiichiranflag";
    private static final String MONITOR_SAKUSEI_JYOUKEN = "monitorsakuseijyouken";
    private static final String SHINSEISHAICHIRAN_SAKUSEI_JYOUKEN = "shinseishaichiransakuseijyouken";
    private static final String MONITOR_SAKUSEI_JYOUKENUSER = "monitorsakuseijyoukenuser";
    private static final String SHINSEISHAICHIRAN_SAKUSEI_JYOUKENUSER = "shinseishasakuseijyoukenuser";
    private static final String MONITOR_SHORI_KAFROM = "monitorshorikaFrom";
    private static final String MONITOR_SHORI_KATO = "monitorshorikaTo";
    private static final String MONITOR_SHINNSEI_KAFROM = "monitorshinnseikaFrom";
    private static final String MONITOR_SHINNSEI_KATO = "monitorshinnseikaTo";
    private static final String SHINSEISHAICHIRAN_SHORI_KAFROM = "shinseishashorikaFrom";
    private static final String SHINSEISHAICHIRAN_SHORI_KATO = "shinseishashorikaTo";
    private static final String SHINSEISHAICHIRAN_SHINNSEI_KAFROM = "shinseishashinnseikaFrom";
    private static final String SHINSEISHAICHIRAN_SHINNSEI_KATO = "shinseishashinnseikaTo";

    @BatchParameter(key = SHINSEI_MONITORFLAG, name = "要介護認定申請モニタリストフラグ")
    private boolean shinseimonitorflag;
    @BatchParameter(key = YOKAIGOYOSHIENSEII_CHIRANFLAG, name = "要介護認定・要支援認定等申請者一覧フラグ")
    private boolean yokaigoyoshienseiichiranflag;
    @BatchParameter(key = MONITOR_SAKUSEI_JYOUKEN, name = "モニタリスト作成条件")
    private RString monitorsakuseijyouken;
    @BatchParameter(key = SHINSEISHAICHIRAN_SAKUSEI_JYOUKEN, name = "申請者一覧作成条件")
    private RString shinseishaichiransakuseijyouken;
    @BatchParameter(key = MONITOR_SHORI_KAFROM, name = "モニタリスト処理日From")
    private RDateTime monitorshorikaFrom;
    @BatchParameter(key = SHINSEISHAICHIRAN_SHORI_KAFROM, name = "申請者一覧処理日From")
    private RDateTime shinseishashorikaFrom;
    @BatchParameter(key = MONITOR_SHORI_KATO, name = "モニタリスト処理日To")
    private RDateTime monitorshorikaTo;
    @BatchParameter(key = SHINSEISHAICHIRAN_SHORI_KATO, name = "申請者一覧処理日To")
    private RDateTime shinseishashorikaTo;
    @BatchParameter(key = MONITOR_SHINNSEI_KAFROM, name = "モニタリスト申請日From")
    private FlexibleDate monitorshinnseikaFrom;
    @BatchParameter(key = SHINSEISHAICHIRAN_SHINNSEI_KAFROM, name = "申請者一覧申請日From")
    private FlexibleDate shinseishashinnseikaFrom;
    @BatchParameter(key = MONITOR_SHINNSEI_KATO, name = "モニタリスト申請日To")
    private FlexibleDate monitorshinnseikaTo;
    @BatchParameter(key = SHINSEISHAICHIRAN_SHINNSEI_KATO, name = "申請者一覧申請日To")
    private FlexibleDate shinseishashinnseikaTo;
    @BatchParameter(key = MONITOR_SAKUSEI_JYOUKENUSER, name = "モニタリスト作成条件User")
    private boolean monitorsakuseijyoukenuser;
    @BatchParameter(key = SHINSEISHAICHIRAN_SAKUSEI_JYOUKENUSER, name = "申請者一覧作成条件User")
    private boolean shinseishasakuseijyoukenuser;

    /**
     * コンストラクタです。
     */
    public DBE011001_ShinseiInfoPrintParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param shinseimonitorflag 要介護認定申請モニタリストフラグ
     * @param yokaigoyoshienseiichiranflag 要介護認定・要支援認定等申請者一覧フラグ
     * @param sakuseijyouken 作成条件
     * @param shorikaFrom 処理日From
     * @param shorikaTo 処理日To
     * @param shinnseikaFrom 申請日From
     * @param shinnseikaTo 申請日To
     */
    public DBE011001_ShinseiInfoPrintParameter(
            boolean shinseimonitorflag,
            boolean yokaigoyoshienseiichiranflag,
            RString sakuseijyouken,
            RDateTime shorikaFrom,
            RDateTime shorikaTo,
            FlexibleDate shinnseikaFrom,
            FlexibleDate shinnseikaTo
    ) {
        this.shinseimonitorflag = shinseimonitorflag;
        this.yokaigoyoshienseiichiranflag = yokaigoyoshienseiichiranflag;
        this.monitorsakuseijyouken = sakuseijyouken;
        this.monitorshorikaFrom = shorikaFrom;
        this.monitorshorikaTo = shorikaTo;
        this.monitorshinnseikaFrom = shinnseikaFrom;
        this.monitorshinnseikaTo = shinnseikaTo;

    }

    /**
     * processのパラメータを生成します。
     *
     * @return TaisyosyaJidoWaritsukeProcessParameter
     */
    public ShinseiJouhouInsatuProcessParameter toMonitorPrintParameter() {
        return new ShinseiJouhouInsatuProcessParameter(shinseimonitorflag,
                yokaigoyoshienseiichiranflag,
                monitorsakuseijyouken,
                monitorshorikaFrom,
                monitorshorikaTo,
                monitorshinnseikaFrom,
                monitorshinnseikaTo,
                monitorsakuseijyoukenuser
        );
    }

    /**
     * processのパラメータを生成します。
     *
     * @return TaisyosyaJidoWaritsukeProcessParameter
     */
    public ShinseiJouhouInsatuProcessParameter toShinseishaIchiranPrintParameter() {
        return new ShinseiJouhouInsatuProcessParameter(shinseimonitorflag,
                yokaigoyoshienseiichiranflag,
                shinseishaichiransakuseijyouken,
                shinseishashorikaFrom,
                shinseishashorikaTo,
                shinseishashinnseikaFrom,
                shinseishashinnseikaTo,
                shinseishasakuseijyoukenuser
        );
    }

}
