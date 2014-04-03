/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiYMD;

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
        this.審査会List = requireNonNull(審査会List, Messages.E00003.replace("審査会List", getClass().getName()).getMessage());
    }

    /**
     * 開催番号と開催年月日を指定して、Listから審査会を1件取得します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @return 審査会
     * @throws IllegalArgumentException 対応する審査会が存在しないとき
     */
    public Shinsakai get審査会(ShinsakaiKaisaiNo 開催番号, ShinsakaiKaisaiYMD 開催年月日)
            throws IllegalArgumentException {
        for (Shinsakai 審査会 : 審査会List) {
            if (isキー項目が一致(審査会, 開催番号, 開催年月日)) {
                return 審査会;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する審査会").getMessage());
    }

    private boolean isキー項目が一致(Shinsakai 審査会, ShinsakaiKaisaiNo 開催番号, ShinsakaiKaisaiYMD 開催年月日) {
        if (!審査会.get審査会情報().get審査会開催番号().equals(開催番号)) {
            return false;
        }
        if (!審査会.get審査会情報().get審査会開催年月日().equals(開催年月日)) {
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
