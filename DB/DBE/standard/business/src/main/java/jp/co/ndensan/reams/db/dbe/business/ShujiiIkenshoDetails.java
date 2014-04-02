/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書の詳細情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoDetails {

    private final ShinseishoKanriNo 申請書管理番号;
    private final IkenshosakuseiIraiRirekiNo 意見書履歴番号;
    private final KoroshoIFKubun 厚労省IF識別区分;
    private final ShujiiIkensho<ShujiiIkenshoItemKubun, ShujiiIkenshoItemForResult> 主治医意見書;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書履歴番号 意見書履歴番号
     * @param 厚労省IF識別区分 厚労省IF識別区分
     * @param 主治医意見書 主治医意見書
     */
    public ShujiiIkenshoDetails(
            ShinseishoKanriNo 申請書管理番号,
            IkenshosakuseiIraiRirekiNo 意見書履歴番号,
            KoroshoIFKubun 厚労省IF識別区分,
            ShujiiIkensho<ShujiiIkenshoItemKubun, ShujiiIkenshoItemForResult> 主治医意見書) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.意見書履歴番号 = requireNonNull(意見書履歴番号, Messages.E00001.replace("意見書履歴番号").getMessage());
        this.厚労省IF識別区分 = requireNonNull(厚労省IF識別区分, Messages.E00001.replace("厚労省IF識別区分").getMessage());
        this.主治医意見書 = requireNonNull(主治医意見書, Messages.E00001.replace("主治医意見書").getMessage());
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
     * 意見書履歴番号を返します。
     *
     * @return 意見書履歴番号
     */
    public IkenshosakuseiIraiRirekiNo get意見書履歴番号() {
        return 意見書履歴番号;
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
     * 主治医意見書を返します。
     *
     * @return 主治医意見書
     */
    public ShujiiIkensho<ShujiiIkenshoItemKubun, ShujiiIkenshoItemForResult> get主治医意見書() {
        return 主治医意見書;
    }
}
