/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 一次判定警告のリストです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKeikokuList implements Iterable<IchijiHanteiKeikoku> {

    private final List<IchijiHanteiKeikoku> 警告List;
    private final IchijiHanteiKeikokuHairetsuCode 警告配列コード;

    /**
     * 警告配列コードと警告のリストを受け取り、インスタンスを生成します。
     *
     * @param 警告配列コード 警告配列コード
     * @param 一次判定警告List 一次判定警告List
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public IchijiHanteiKeikokuList(IchijiHanteiKeikokuHairetsuCode 警告配列コード,
            List<IchijiHanteiKeikoku> 一次判定警告List) throws NullPointerException {
        requireNonNull(警告配列コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("警告配列コード", getClass().getName()));
        requireNonNull(一次判定警告List, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("警告List", getClass().getName()));

        this.警告配列コード = 警告配列コード;
        this.警告List = 一次判定警告List;
    }

    /**
     * 警告配列コードを返します。
     *
     * @return 警告配列コード
     */
    public IchijiHanteiKeikokuHairetsuCode get警告配列コード() {
        return 警告配列コード;
    }

    /**
     * 警告種別を返します。
     *
     * @return 警告種別
     */
    public IchijiHanteiKeikokuShubetsu get警告種別() {
        return 警告配列コード.get警告種別();
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
