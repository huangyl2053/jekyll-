/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.NinteichosaIrai;

//import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.core.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先のクラスです。
 *
 * @author N1013 松本直樹
 */
public class NinteichosaItakusaki {

    private final LasdecCode 市町村コード;
    private final KaigoJigyoshaNo 介護事業者番号;
    private final JigyoshaNo 事業者番号;
    private final boolean 有効区分;
    private final ChosaItakuKubun 調査委託区分;
    private final int 割付定員;
    private final RString 割付地区;
    private final RString 機関の区分;

    /**
     * コンストラクタクラスです。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 事業者番号 事業者番号
     * @param 有効区分 有効区分
     * @param 調査委託区分 調査委託区分
     * @param 割付定員 割付定員
     * @param 割付地区 割付地区
     * @param 機関の区分 機関の区分
     * @throws NullPointerException 引数がnullの場合
     */
    public NinteichosaItakusaki(LasdecCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, JigyoshaNo 事業者番号,
            boolean 有効区分, ChosaItakuKubun 調査委託区分,
            int 割付定員, RString 割付地区, RString 機関の区分) throws NullPointerException {

        requireNonNull(市町村コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("市町村コード", getClass().getName()));
        requireNonNull(事業者番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("事業者番号", getClass().getName()));
        requireNonNull(介護事業者番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護事業者番号", getClass().getName()));
        requireNonNull(有効区分, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護保険事業者の状況", getClass().getName()));

        this.市町村コード = 市町村コード;
        this.事業者番号 = 事業者番号;
        this.介護事業者番号 = 介護事業者番号;
        this.有効区分 = 有効区分;
        this.調査委託区分 = 調査委託区分;
        this.割付定員 = 割付定員;
        this.割付地区 = 割付地区;
        this.機関の区分 = 機関の区分;
    }

    /**
     * 事業者コードを取得します。
     *
     * @return 事業者コード
     */
    public JigyoshaNo getJigyoshaNo() {
        return 事業者番号;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return 市町村コード;
    }

    /**
     * 介護事業者番号を取得します。
     *
     * @return 介護事業者番号
     */
    public KaigoJigyoshaNo getKaigoJigyoshaNo() {
        return 介護事業者番号;
    }

    /**
     * 介護事業者状況を判定します。
     *
     * @return 介護事業者状況
     */
    public boolean is有効() {
        return 有効区分;
    }

    /**
     * 調査委託区分を取得します。
     *
     * @return 調査委託区分
     */
    public ChosaItakuKubun getChosaItakuKubun() {
        return 調査委託区分;
    }

    /**
     * 割付定員を取得します。
     *
     * @return 割付定員
     */
    public int getWaritsukeTeiin() {
        return 割付定員;
    }

    /**
     * 割付地区を取得します。
     *
     * @return 割付地区
     */
    public RString getWaritsukeChiku() {
        return 割付地区;
    }

    /**
     * 機関の区分を取得します。
     *
     * @return 機関の区分
     */
    public RString getKikanKubun() {
        return 機関の区分;
    }
}
