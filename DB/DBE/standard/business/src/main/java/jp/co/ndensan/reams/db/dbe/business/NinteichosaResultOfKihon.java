/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.core.chosahyo.NinteichosaItemForResult;
import jp.co.ndensan.reams.db.dbe.business.core.chosahyo.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果（基本調査）を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultOfKihon {

    private final ShinseishoKanriNo 申請書管理番号;
    private final NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
    private final KoroshoIFKubun 厚労省IF識別区分;
    private final Ninteichosahyo<NinteichosaItemKubunOfKihon, NinteichosaItemForResult> 認定調査票;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 厚労省IF識別区分 厚労省IF識別区分
     * @param 認定調査票 認定調査票
     */
    public NinteichosaResultOfKihon(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号,
            KoroshoIFKubun 厚労省IF識別区分, Ninteichosahyo<NinteichosaItemKubunOfKihon, NinteichosaItemForResult> 認定調査票) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.認定調査依頼履歴番号 = requireNonNull(認定調査依頼履歴番号, Messages.E00001.replace("認定調査依頼履歴番号").getMessage());
        this.厚労省IF識別区分 = requireNonNull(厚労省IF識別区分, Messages.E00001.replace("厚労省IF識別区分").getMessage());
        this.認定調査票 = requireNonNull(認定調査票, Messages.E00001.replace("認定調査票").getMessage());
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public NinteichosaIraiRirekiNo get認定調査依頼履歴番号() {
        return 認定調査依頼履歴番号;
    }

    /**
     * 厚労省IF識別区分を返します。
     *
     * @return 厚労省IF識別区分
     */
    public KoroshoIFKubun get厚労省IF識別区分() {
        return 厚労省IF識別区分;
    }

    /**
     * 認定調査票を返します。
     *
     * @return 認定調査票
     */
    public Ninteichosahyo<NinteichosaItemKubunOfKihon, NinteichosaItemForResult> get認定調査票() {
        return 認定調査票;
    }
}
