package jp.co.ndensan.reams.db.dbe.definition.processprm.shinseijouhouinnsatu;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseijouhouinnsatu.ShinseiJouhouInsatuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報印刷_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiJouhouInsatuProcessParameter implements IBatchProcessParameter {

    private boolean shinseimonitorflag;
    private boolean yokaigoyoshienseiichiranflag;
    private RString sakuseijyouken;
    private RDateTime shorikaFrom;
    private RDateTime shorikaTo;
    private FlexibleDate shinnseikaFrom;
    private FlexibleDate shinnseikaTo;
    private boolean sakuseijyoukenuser;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタ作成です。
     *
     * @param shinseimonitorflag 要介護認定申請モニタリストフラグ
     * @param yokaigoyoshienseiichiranflag 要介護認定・要支援認定等申請者一覧フラグ
     * @param sakuseijyouken 作成条件
     * @param shorikaFrom 処理日From
     * @param shorikaTo 処理日To
     * @param shinnseikaFrom 申請日From
     * @param shinnseikaTo 申請日To
     * @param sakuseijyoukenuser 作成条件
     */
    public ShinseiJouhouInsatuProcessParameter(boolean shinseimonitorflag,
            boolean yokaigoyoshienseiichiranflag,
            RString sakuseijyouken,
            RDateTime shorikaFrom,
            RDateTime shorikaTo,
            FlexibleDate shinnseikaFrom,
            FlexibleDate shinnseikaTo,
            boolean sakuseijyoukenuser
    ) {
        this.shinseimonitorflag = shinseimonitorflag;
        this.yokaigoyoshienseiichiranflag = yokaigoyoshienseiichiranflag;
        this.sakuseijyouken = sakuseijyouken;
        this.shorikaFrom = shorikaFrom;
        this.shorikaTo = shorikaTo;
        this.shinnseikaFrom = shinnseikaFrom;
        this.shinnseikaTo = shinnseikaTo;
        this.sakuseijyoukenuser = sakuseijyoukenuser;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return HanteiKekkaJohoShuturyokuMybatisParameter
     */
    public ShinseiJouhouInsatuMybatisParameter toShinseiJouhouInsatuMybatisParameter() {
        if (new RString("1").equals(sakuseijyouken)) {
            sakuseijyoukenuser = true;
        } else if (new RString("2").equals(sakuseijyouken)) {
            sakuseijyoukenuser = false;
        }
        return ShinseiJouhouInsatuMybatisParameter.creatParameter(
                sakuseijyouken,
                shorikaFrom,
                shorikaTo,
                shinnseikaFrom,
                shinnseikaTo,
                sakuseijyoukenuser,
                psmShikibetsuTaisho);
    }
}
