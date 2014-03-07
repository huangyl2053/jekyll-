/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
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
    private final int 調査票改定年度;
    private final Ninteichosahyo<NinteichosaResultOfItem> 基本情報;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 調査票改定年度 調査票改定年度
     * @param 基本情報 基本情報
     */
    public NinteichosaResultOfKihon(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号,
            int 調査票改定年度, Ninteichosahyo<NinteichosaResultOfItem> 基本情報) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.認定調査依頼履歴番号 = requireNonNull(認定調査依頼履歴番号, Messages.E00001.replace("認定調査依頼履歴番号").getMessage());
        this.調査票改定年度 = 調査票改定年度;
        this.基本情報 = requireNonNull(基本情報, Messages.E00001.replace("基本情報").getMessage());
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
     * 調査票改定年度を返します。
     *
     * @return 調査票改定年度
     */
    public int get調査票改定年度() {
        return 調査票改定年度;
    }

    /**
     * 調査結果（基本情報）を返します。
     *
     * @return 調査結果（基本情報）
     */
    public Ninteichosahyo<NinteichosaResultOfItem> get基本情報() {
        return 基本情報;
    }
}
