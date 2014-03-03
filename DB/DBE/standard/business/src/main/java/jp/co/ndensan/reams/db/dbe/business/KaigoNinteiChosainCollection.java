/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoChosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 介護認定調査員のコレクションを扱うクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteiChosainCollection implements Iterable {

    private final List<KaigoNinteiChosain> 介護認定調査員List;
    private final List<NinteichosaItakusaki> 認定調査委託先List;

    /**
     * コンストラクタです。
     *
     * @param 介護認定調査員List 介護認定調査員リスト
     */
    public KaigoNinteiChosainCollection(List<KaigoNinteiChosain> 介護認定調査員List, List<NinteichosaItakusaki> 認定調査委託先List) {
        this.介護認定調査員List = requireNonNull(介護認定調査員List, Messages.E00001.replace("介護認定調査員リスト").getMessage());
        this.認定調査委託先List = requireNonNull(認定調査委託先List, Messages.E00001.replace("認定調査委託先リスト").getMessage());
    }

    /**
     * 引数の条件に該当する介護認定調査員を返します。<br />
     * 対応した介護認定調査員が存在しない場合はnullが返ります。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @return 介護認定調査員
     * @throws IllegalArgumentException 存在しない対象を指定したとき
     */
    public KaigoNinteiChosain get介護認定調査員(
            ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号)
            throws IllegalArgumentException {
        for (KaigoNinteiChosain 介護認定調査員 : 介護認定調査員List) {
            if (介護認定調査員.get市町村コード().equals(市町村コード)
                    && 介護認定調査員.get介護事業者番号().equals(介護事業者番号)
                    && 介護認定調査員.get介護調査員番号().equals(介護調査員番号)) {
                return 介護認定調査員;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("介護認定調査員").getMessage());
    }

    /**
     * 引数の条件に該当する認定調査委託先を返します。<br />
     * 対応した認定調査委託先が存在しない場合はnullが返ります。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @return 認定調査委託先
     * @throws IllegalArgumentException 存在しない対象を指定したとき
     */
    public NinteichosaItakusaki get認定調査委託先(
            ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoChosainNo 介護調査員番号)
            throws IllegalArgumentException {
        int index = 0;
        for (KaigoNinteiChosain 介護認定調査員 : 介護認定調査員List) {
            if (介護認定調査員.get市町村コード().equals(市町村コード)
                    && 介護認定調査員.get介護事業者番号().equals(介護事業者番号)
                    && 介護認定調査員.get介護調査員番号().equals(介護調査員番号)) {
                return 認定調査委託先List.get(index);
            }
            index++;
        }
        throw new IllegalArgumentException(Messages.E00006.replace("認定調査委託先").getMessage());
    }

    /**
     * 引数の条件に該当する介護認定調査員のコレクションを返します。<br />
     * 該当するものがない場合、空のコレクションが返ります。
     *
     * @param 介護事業者番号 介護事業者番号
     * @return 介護認定調査員のコレクション
     */
    public KaigoNinteiChosainCollection sub介護認定調査員List(KaigoJigyoshaNo 介護事業者番号) {
        List<KaigoNinteiChosain> sub介護認定調査員List = new ArrayList<>();
        List<NinteichosaItakusaki> sub認定調査委託先List = new ArrayList<>();
        int index = 0;
        for (KaigoNinteiChosain 介護認定調査員 : 介護認定調査員List) {
            if (介護認定調査員.get介護事業者番号().equals(介護事業者番号)) {
                sub介護認定調査員List.add(介護認定調査員);
                sub認定調査委託先List.add(認定調査委託先List.get(index));
            }
            index++;
        }
        return create介護認定調査員Collection(sub介護認定調査員List, sub認定調査委託先List);
    }

    /**
     * 引数の条件に該当する介護認定調査員のコレクションを返します。<br />
     * 該当するものがない場合、空のコレクションが返ります。
     *
     * @param 市町村コード 市町村コード
     * @return 介護認定調査員のコレクション
     */
    public KaigoNinteiChosainCollection sub介護認定調査員List(ShichosonCode 市町村コード) {
        List<KaigoNinteiChosain> sub介護認定調査員List = new ArrayList<>();
        List<NinteichosaItakusaki> sub認定調査委託先List = new ArrayList<>();
        int index = 0;
        for (KaigoNinteiChosain 介護認定調査員 : 介護認定調査員List) {
            if (介護認定調査員.get市町村コード().equals(市町村コード)) {
                sub介護認定調査員List.add(介護認定調査員);
                sub認定調査委託先List.add(認定調査委託先List.get(index));
            }
            index++;
        }
        return create介護認定調査員Collection(sub介護認定調査員List, sub認定調査委託先List);
    }

    /**
     * 引数の条件に該当する介護認定調査員のコレクションを返します。<br />
     * 該当するものがない場合、空のコレクションが返ります。
     *
     * @param 介護調査員番号 介護調査員番号
     * @return 介護認定調査員のコレクション
     */
    public KaigoNinteiChosainCollection sub介護認定調査員List(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号) {
        List<KaigoNinteiChosain> sub介護認定調査員List = new ArrayList<>();
        List<NinteichosaItakusaki> sub認定調査委託先List = new ArrayList<>();
        int index = 0;
        for (KaigoNinteiChosain 介護認定調査員 : 介護認定調査員List) {
            if (介護認定調査員.get市町村コード().equals(市町村コード)
                    && 介護認定調査員.get介護事業者番号().equals(介護事業者番号)) {
                sub介護認定調査員List.add(介護認定調査員);
                sub認定調査委託先List.add(認定調査委託先List.get(index));
            }
            index++;
        }
        return create介護認定調査員Collection(sub介護認定調査員List, sub認定調査委託先List);
    }

    private KaigoNinteiChosainCollection create介護認定調査員Collection(
            List<KaigoNinteiChosain> sub介護認定調査員List,
            List<NinteichosaItakusaki> sub認定調査委託先List) {
        if (sub介護認定調査員List.isEmpty()
                || sub認定調査委託先List.isEmpty()) {
            return new KaigoNinteiChosainCollection(Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        }
        return new KaigoNinteiChosainCollection(sub介護認定調査員List, sub認定調査委託先List);
    }

    /**
     * 介護認定調査員リストがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合はtrueを返します。
     */
    public boolean isEmpty() {
        return 介護認定調査員List.isEmpty();
    }

    /**
     * 介護認定調査員リストの要素数を返します。
     *
     * @return 介護認定調査員リストの要素数。
     */
    public int size() {
        return 介護認定調査員List.size();
    }

    @Override
    public Iterator iterator() {
        return 介護認定調査員List.iterator();
    }
}
