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
    private static final String SAKUSEI_JYOUKEN = "sakuseijyouken";
    private static final String SAKUSEI_JYOUKENUSER = "sakuseijyoukenuser";
    private static final String SHORI_KAFROM = "shorikaFrom";
    private static final String SHORI_KATO = "shorikaTo";
    private static final String SHINNSEI_KAFROM = "shinnseikaFrom";
    private static final String SHINNSEI_KATO = "shinnseikaTo";

    @BatchParameter(key = SHINSEI_MONITORFLAG, name = "要介護認定申請モニタリストフラグ")
    private boolean shinseimonitorflag;
    @BatchParameter(key = YOKAIGOYOSHIENSEII_CHIRANFLAG, name = "要介護認定・要支援認定等申請者一覧フラグ")
    private boolean yokaigoyoshienseiichiranflag;
    @BatchParameter(key = SAKUSEI_JYOUKEN, name = "作成条件")
    private RString sakuseijyouken;
    @BatchParameter(key = SHORI_KAFROM, name = "処理日From")
    private RDateTime shorikaFrom;
    @BatchParameter(key = SHORI_KATO, name = "処理日To")
    private RDateTime shorikaTo;
    @BatchParameter(key = SHINNSEI_KAFROM, name = "申請日From")
    private FlexibleDate shinnseikaFrom;
    @BatchParameter(key = SHINNSEI_KATO, name = "申請日To")
    private FlexibleDate shinnseikaTo;
    @BatchParameter(key = SAKUSEI_JYOUKENUSER, name = "作成条件User")
    private boolean sakuseijyoukenuser;

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
        this.sakuseijyouken = sakuseijyouken;
        this.shorikaFrom = shorikaFrom;
        this.shorikaTo = shorikaTo;
        this.shinnseikaFrom = shinnseikaFrom;
        this.shinnseikaTo = shinnseikaTo;

    }

    /**
     * processのパラメータを生成します。
     *
     * @return TaisyosyaJidoWaritsukeProcessParameter
     */
    public ShinseiJouhouInsatuProcessParameter toShinseiJouhouInsatuProcessParameter() {
        return new ShinseiJouhouInsatuProcessParameter(shinseimonitorflag,
                yokaigoyoshienseiichiranflag,
                sakuseijyouken,
                shorikaFrom,
                shorikaTo,
                shinnseikaFrom,
                shinnseikaTo,
                sakuseijyoukenuser
        );
    }
}
