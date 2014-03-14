/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 認定調査結果取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishosha {

    private YokaigoninteiProgress 要介護認定進捗情報;
    private NinteiShinseiJoho 認定申請情報;
    private NinteichosaIrai 認定調査依頼情報;
    private KaigoNinteichosainCollection 介護認定調査員Collection;
    private IKaigoJigyosha 介護事業者情報;
    private IKojin 個人;

    /**
     * コンストラクタです。
     *
     * @param 要介護認定進捗情報 要介護認定進捗情報
     * @param 認定申請情報 認定申請情報
     * @param 認定調査依頼情報 認定調査依頼情報
     * @param 介護認定調査員Collection 介護認定調査員Collection
     * @param 介護事業者情報 介護事業者情報
     * @param 個人 個人
     */
    public NinteichosaKekkaTorikomiTaishosha(
            YokaigoninteiProgress 要介護認定進捗情報,
            NinteiShinseiJoho 認定申請情報,
            NinteichosaIrai 認定調査依頼情報,
            KaigoNinteichosainCollection 介護認定調査員Collection,
            IKaigoJigyosha 介護事業者情報,
            IKojin 個人) {
        this.要介護認定進捗情報 = requireNonNull(要介護認定進捗情報, Messages.E00003.replace("要介護認定進捗情報", "認定調査結果取込対象者").getMessage());
        this.認定申請情報 = requireNonNull(認定申請情報, Messages.E00003.replace("認定申請情報", "認定調査結果取込対象者").getMessage());
        this.認定調査依頼情報 = requireNonNull(認定調査依頼情報, Messages.E00003.replace("認定調査依頼情報", "認定調査結果取込対象者").getMessage());
        this.介護認定調査員Collection = requireNonNull(介護認定調査員Collection, Messages.E00003.replace("介護認定調査員Collection", "認定調査結果取込対象者").getMessage());
        this.介護事業者情報 = requireNonNull(介護事業者情報, Messages.E00003.replace("介護事業者情報", "認定調査結果取込対象者").getMessage());
        this.個人 = requireNonNull(個人, Messages.E00003.replace("個人", "認定調査結果取込対象者").getMessage());
    }

    /**
     * 要介護認定進捗情報を返します。
     *
     * @return 要介護認定進捗情報
     */
    public YokaigoninteiProgress get要介護認定進捗情報() {
        return 要介護認定進捗情報;
    }

    /**
     * 認定申請情報を返します。
     *
     * @return 認定申請情報
     */
    public NinteiShinseiJoho get認定申請情報() {
        return 認定申請情報;
    }

    /**
     * 認定調査依頼情報を返します。
     *
     * @return 認定調査依頼情報
     */
    public NinteichosaIrai get認定調査依頼情報() {
        return 認定調査依頼情報;
    }

    /**
     * 介護認定調査員Collectionを返します。
     *
     * @return 介護認定調査員Collection
     */
    public KaigoNinteichosainCollection get介護認定調査員Collection() {
        return 介護認定調査員Collection;
    }

    /**
     * 介護事業者情報を返します。
     *
     * @return 介護事業者情報
     */
    public IKaigoJigyosha get介護事業者情報() {
        return 介護事業者情報;
    }

    /**
     * 個人を返します。
     *
     * @return 個人
     */
    public IKojin get個人() {
        return 個人;
    }
}
