/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 一次判定警告のリストです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKeikokuList implements Iterable<IchijiHanteiKeikoku> {

    private final List<IchijiHanteiKeikoku> 警告List;
    private final RString 警告配列コード;
    private final IchijiHanteiKeikokuShubetsu 警告種別;

    /**
     * 警告配列コードと警告のリストを受け取り、インスタンスを生成します。
     *
     * @param 警告配列コード 警告配列コード
     * @param 警告種別 警告種別
     * @param 警告List 警告List
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public IchijiHanteiKeikokuList(RString 警告配列コード, IchijiHanteiKeikokuShubetsu 警告種別,
            List<IchijiHanteiKeikoku> 警告List) throws NullPointerException {
        requireNonNull(警告配列コード, Messages.E00003.replace("警告配列コード", getClass().getName()).getMessage());
        requireNonNull(警告種別, Messages.E00003.replace("警告種別", getClass().getName()).getMessage());
        requireNonNull(警告List, Messages.E00003.replace("警告List", getClass().getName()).getMessage());

        this.警告配列コード = 警告配列コード;
        this.警告種別 = 警告種別;
        this.警告List = 警告List;
    }

    /**
     * 警告配列コードを返します。
     *
     * @return 警告配列コード
     */
    public RString get警告配列コード() {
        return 警告配列コード;
    }

    /**
     * 警告種別を返します。
     *
     * @return 警告種別
     */
    public IchijiHanteiKeikokuShubetsu get警告種別() {
        return 警告種別;
    }

    /**
     * リストが空であるか否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 警告List.isEmpty();
    }

    /**
     * リストのサイズを返します。
     *
     * @return サイズ
     */
    public int size() {
        return 警告List.size();
    }

    @Override
    public Iterator<IchijiHanteiKeikoku> iterator() {
        return 警告List.iterator();
    }
}
