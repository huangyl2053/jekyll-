/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査票の情報を、一次判定で扱う形で持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosahyoResult {

    private final RString 調査項目回答;
    private final ShinseishoKanriNo 申請書管理番号;
    private final NinteichosaRirekiNo 要介護認定調査履歴番号;
    private final KoroshoIFKubun 厚労省IF区分;

    /**
     * 引数から必要な値を受け取り、インスタンスを生成します。
     *
     * @param 調査項目回答 調査項目回答
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 厚労省IF区分 厚労省IF区分
     * @throws NullPointerException いずれかの引数にnullが渡されたとき
     */
    public NinteichosahyoResult(RString 調査項目回答, ShinseishoKanriNo 申請書管理番号, NinteichosaRirekiNo 要介護認定調査履歴番号,
            KoroshoIFKubun 厚労省IF区分) throws NullPointerException {
        requireNonNull(調査項目回答, Messages.E00003.replace("調査項目回答", getClass().getName()).getMessage());
        requireNonNull(申請書管理番号, Messages.E00003.replace("申請書管理番号", getClass().getName()).getMessage());
        requireNonNull(要介護認定調査履歴番号, Messages.E00003.replace("要介護認定調査履歴番号", getClass().getName()).getMessage());
        requireNonNull(厚労省IF区分, Messages.E00003.replace("厚労省IFコードを表す区分", getClass().getName()).getMessage());

        this.調査項目回答 = 調査項目回答;
        this.申請書管理番号 = 申請書管理番号;
        this.要介護認定調査履歴番号 = 要介護認定調査履歴番号;
        this.厚労省IF区分 = 厚労省IF区分;
    }

    /**
     * 調査項目の回答結果を元に作成した数列を返します。
     *
     * @return 調査項目回答
     */
    public RString get調査項目回答() {
        return 調査項目回答;
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
    public NinteichosaRirekiNo get要介護認定調査履歴番号() {
        return 要介護認定調査履歴番号;
    }

    /**
     * 厚労省IF区分を返します。
     *
     * @return 厚労省IF区分
     */
    public KoroshoIFKubun get厚労省IF区分() {
        return 厚労省IF区分;
    }
}
