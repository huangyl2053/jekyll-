/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 主治医意見書取込対象者を扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoTorikomiTaishosha {

    private YokaigoNinteiProgress 認定進捗情報;
    private YokaigoNinteiShinsei 認定申請情報;
    private ShujiiIkenshoSakuseiIrai 主治医意見書作成依頼情報;
    private IKojin 個人;
    private KaigoDoctor 介護主治医;

    /**
     * コンストラクタです。
     *
     * @param 認定進捗情報 認定進捗情報
     * @param 認定申請情報 認定申請情報
     * @param 主治医意見書作成依頼情報 主治医意見書作成依頼情報
     * @param 個人 個人
     * @param 介護主治医 介護主治医
     */
    public ShujiiIkenshoTorikomiTaishosha(
            YokaigoNinteiProgress 認定進捗情報,
            YokaigoNinteiShinsei 認定申請情報,
            ShujiiIkenshoSakuseiIrai 主治医意見書作成依頼情報,
            IKojin 個人,
            KaigoDoctor 介護主治医) {
        this.認定進捗情報 = requireNonNull(認定進捗情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定進捗情報", getClass().getName()));
        this.認定申請情報 = requireNonNull(認定申請情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定申請情報", getClass().getName()));
        this.主治医意見書作成依頼情報 = requireNonNull(主治医意見書作成依頼情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("主治医意見書作成依頼情報", getClass().getName()));
        this.個人 = requireNonNull(個人, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("個人", getClass().getName()));
        this.介護主治医 = requireNonNull(介護主治医, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護主治医", getClass().getName()));
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
     * 主治医意見書作成依頼情報を返します。
     *
     * @return 主治医意見書作成依頼情報
     */
    public ShujiiIkenshoSakuseiIrai get主治医意見書作成依頼情報() {
        return 主治医意見書作成依頼情報;
    }

    /**
     * 個人を返します。
     *
     * @return 個人
     */
    public IKojin get個人() {
        return 個人;
    }

    /**
     * 介護主治医を返します。
     *
     * @return 介護主治医
     */
    public KaigoDoctor get介護主治医() {
        return 介護主治医;
    }
}
