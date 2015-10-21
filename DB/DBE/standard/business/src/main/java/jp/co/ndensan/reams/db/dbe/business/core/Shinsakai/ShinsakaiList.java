/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaino.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 審査会のListを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiList implements Iterable<Shinsakai> {

    private final List<Shinsakai> 審査会List;

    /**
     * 引数から審査会のListを受け取り、インスタンスを生成します。
     *
     * @param 審査会List 審査会List
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ShinsakaiList(List<Shinsakai> 審査会List) throws NullPointerException {
        this.審査会List = requireNonNull(審査会List, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("審査会List", getClass().getName()));
    }

    /**
     * 審査会開催番号を指定して、Listから審査会を1件取得します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @return 審査会
     * @throws IllegalArgumentException 対応する審査会が存在しないとき
     */
    public Shinsakai get審査会(ShinsakaiKaisaiNo 審査会開催番号)
            throws IllegalArgumentException {
        for (Shinsakai 審査会 : 審査会List) {
            if (isキー項目が一致(審査会, 審査会開催番号)) {
                return 審査会;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する審査会").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する審査会").getMessage());
    }

    private boolean isキー項目が一致(Shinsakai 審査会, ShinsakaiKaisaiNo 審査会開催番号) {
        if (!審査会.get審査会情報().get審査会開催番号().equals(審査会開催番号)) {
            return false;
        }
        return true;
    }

    /**
     * 審査会Listが空であるか否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 審査会List.isEmpty();
    }

    /**
     * 審査会Listのサイズを返します。
     *
     * @return サイズ
     */
    public int size() {
        return 審査会List.size();
    }

    @Override
    public Iterator<Shinsakai> iterator() {
        return 審査会List.iterator();
    }
}
