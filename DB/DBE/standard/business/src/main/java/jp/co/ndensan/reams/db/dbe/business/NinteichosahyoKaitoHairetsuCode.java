/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査票の回答を、一次判定で扱う形で持つクラスです。<br/>
 * 認定調査票の情報を元にした、回答項目の羅列を持ちます。
 * <pre>
 * 例）認定調査票の回答が、
 * 麻痺などの有無（左上肢）...1
 * 麻痺などの有無（右上肢）...2
 * 麻痺などの有無（右下肢）...1
 * 麻痺などの有無（左下肢）...3
 * 麻痺などの有無（その他）...1
 * 間接の動く範囲の制限（股関節）...2
 * ....となっている場合、
 *
 * このクラスでは、
 * 121312.....
 * という文字列として回答を保持します。
 * </pre>
 *
 * @author n8178 城間篤人
 */
public class NinteichosahyoKaitoHairetsuCode {

    private final RString 調査項目回答;
    private final ShinseishoKanriNo 申請書管理番号;
    private final NinteichosaIraiRirekiNo 要介護認定調査履歴番号;
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
    public NinteichosahyoKaitoHairetsuCode(RString 調査項目回答, ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 要介護認定調査履歴番号,
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
    public NinteichosaIraiRirekiNo get要介護認定調査履歴番号() {
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
