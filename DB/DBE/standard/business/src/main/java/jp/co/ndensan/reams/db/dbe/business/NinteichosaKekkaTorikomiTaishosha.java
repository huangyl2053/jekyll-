/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 認定調査結果取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishosha {

    private YokaigoNinteiProgress 認定進捗情報;
    private YokaigoNinteiShinsei 認定申請情報;
    private NinteichosaIrai 認定調査依頼情報;
    private KaigoNinteichosain 介護認定調査員;
    private IKojin 個人;

    /**
     * コンストラクタです。
     *
     * @param 認定進捗情報 認定進捗情報
     * @param 認定申請情報 認定申請情報
     * @param 認定調査依頼情報 認定調査依頼情報
     * @param 介護認定調査員 介護認定調査員
     * @param 個人 個人
     */
    public NinteichosaKekkaTorikomiTaishosha(
            YokaigoNinteiProgress 認定進捗情報,
            YokaigoNinteiShinsei 認定申請情報,
            NinteichosaIrai 認定調査依頼情報,
            KaigoNinteichosain 介護認定調査員,
            IKojin 個人) {
        this.認定進捗情報 = requireNonNull(認定進捗情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定進捗情報", getClass().getName()));
        this.認定申請情報 = requireNonNull(認定申請情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定申請情報", getClass().getName()));
        this.認定調査依頼情報 = requireNonNull(認定調査依頼情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査依頼情報", getClass().getName()));
        this.介護認定調査員 = requireNonNull(介護認定調査員, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護認定調査員", getClass().getName()));
        this.個人 = requireNonNull(個人, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("個人", getClass().getName()));
    }

    /**
     * 認定進捗情報を返します。
     *
     * @return 認定進捗情報
     */
    public YokaigoNinteiProgress get認定進捗情報() {
        return 認定進捗情報;
    }

    /**
     * 認定申請情報を返します。
     *
     * @return 認定申請情報
     */
    public YokaigoNinteiShinsei get認定申請情報() {
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
