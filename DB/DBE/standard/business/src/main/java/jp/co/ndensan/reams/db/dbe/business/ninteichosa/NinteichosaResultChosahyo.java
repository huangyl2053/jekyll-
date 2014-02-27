/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果情報（調査票）を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultChosahyo {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 要介護認定調査履歴番号;
    private final int 調査票改定年度;
    private final Map<ChosahyoItems, NinteichosaItemResult> 調査票結果;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 調査票改定年度 調査票改定年度
     * @param 調査票結果 調査票結果
     */
    public NinteichosaResultChosahyo(
            ShinseishoKanriNo 申請書管理番号, int 要介護認定調査履歴番号, int 調査票改定年度, Map<ChosahyoItems, NinteichosaItemResult> 調査票結果) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.要介護認定調査履歴番号 = 要介護認定調査履歴番号;
        this.調査票改定年度 = 調査票改定年度;
        this.調査票結果 = requireNonNull(調査票結果, Messages.E00001.replace("調査票結果").getMessage());
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
     * 要介護認定調査履歴番号を返します。
     *
     * @return 要介護認定調査履歴番号
     */
    public int get要介護認定調査履歴番号() {
        return 要介護認定調査履歴番号;
    }

    /**
     * 調査票改定年度を返します。
     *
     * @return 調査票改定年度
     */
    public int get調査票改定年度() {
        return 調査票改定年度;
    }

    /**
     * 調査票結果を返します。
     *
     * @return 調査票結果
     */
    public Map<ChosahyoItems, NinteichosaItemResult> get調査票結果() {
        return 調査票結果;
    }
}
