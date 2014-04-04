/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 認定調査結果取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishosha {

    private NinteiShinseiJoho 認定申請情報;
    private NinteichosaIrai 認定調査依頼情報;
    private KaigoNinteichosain 介護認定調査員;
    private IKojin 個人;

    /**
     * コンストラクタです。
     *
     * @param 認定申請情報 認定申請情報
     * @param 認定調査依頼情報 認定調査依頼情報
     * @param 介護認定調査員 介護認定調査員
     * @param 個人 個人
     */
    public NinteichosaKekkaTorikomiTaishosha(
            NinteiShinseiJoho 認定申請情報,
            NinteichosaIrai 認定調査依頼情報,
            KaigoNinteichosain 介護認定調査員,
            IKojin 個人) {
        this.認定申請情報 = requireNonNull(認定申請情報, Messages.E00003.replace("認定申請情報", "認定調査結果取込対象者").getMessage());
        this.認定調査依頼情報 = requireNonNull(認定調査依頼情報, Messages.E00003.replace("認定調査依頼情報", "認定調査結果取込対象者").getMessage());
        this.介護認定調査員 = requireNonNull(介護認定調査員, Messages.E00003.replace("介護認定調査員", "認定調査結果取込対象者").getMessage());
        this.個人 = requireNonNull(個人, Messages.E00003.replace("個人", "認定調査結果取込対象者").getMessage());
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
     * 介護認定調査員を返します。
     *
     * @return 介護認定調査員
     */
    public KaigoNinteichosain get介護認定調査員() {
        return 介護認定調査員;
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
