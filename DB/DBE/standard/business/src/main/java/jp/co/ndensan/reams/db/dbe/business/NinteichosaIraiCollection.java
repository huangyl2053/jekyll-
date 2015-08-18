/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;

/**
 * 認定申請情報のリストを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIraiCollection implements Iterable {

    private final List<NinteichosaIrai> 認定調査依頼情報List;

    /**
     * コンストラクタです。引数からメンバとなるリストを受け取ります。
     *
     * @param 認定調査依頼情報List 認定調査依頼情報のリスト
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NinteichosaIraiCollection(List<NinteichosaIrai> 認定調査依頼情報List) throws NullPointerException {
        requireNonNull(認定調査依頼情報List, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査依頼情報List", getClass().getName()));
        this.認定調査依頼情報List = 認定調査依頼情報List;
    }

    /**
     * 申請書管理番号と認定調査依頼履歴番号に該当する、認定申請情報をコレクションから取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return 認定申請情報
     * @throws IllegalArgumentException 指定した引数に対応した認定申請情報がCollection内に存在しないとき
     */
    public NinteichosaIrai get認定申請情報(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号)
            throws IllegalArgumentException {
        for (NinteichosaIrai 認定調査依頼情報 : 認定調査依頼情報List) {
            if (is申請書管理番号と認定調査依頼履歴番号が一致(認定調査依頼情報, 申請書管理番号, 認定調査依頼履歴番号)) {
                return 認定調査依頼情報;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定申請情報").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定申請情報").getMessage());
    }

    private boolean is申請書管理番号と認定調査依頼履歴番号が一致(NinteichosaIrai 認定調査依頼情報, ShinseishoKanriNo 申請書管理番号,
            NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        return is申請書管理番号が一致(認定調査依頼情報, 申請書管理番号) && is認定調査依頼履歴番号が一致(認定調査依頼情報, 認定調査依頼履歴番号);
    }

    private boolean is申請書管理番号が一致(NinteichosaIrai 認定調査依頼情報, ShinseishoKanriNo 申請書管理番号) {
        return 認定調査依頼情報.get申請書管理番号().equals(申請書管理番号);
    }

    private boolean is認定調査依頼履歴番号が一致(NinteichosaIrai 認定調査依頼情報, NinteichosaIraiRirekiNo 認定調査依頼履歴番号) {
        return 認定調査依頼情報.get認定調査依頼履歴番号().equals(認定調査依頼履歴番号);
    }

    /**
     * コレクションが空か否かをbool値で返します。
     *
     * @return コレクションが空ならtrue
     */
    public boolean isEmpty() {
        return 認定調査依頼情報List.isEmpty();
    }

    /**
     * コレクションのサイズを返します。
     *
     * @return コレクションのサイズ
     */
    public int size() {
        return 認定調査依頼情報List.size();
    }

    @Override
    public Iterator iterator() {
        return 認定調査依頼情報List.iterator();
    }
}
