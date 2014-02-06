/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 介護医療機関のコレクションを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikanCollection implements Iterable {

    private final List<KaigoIryoKikan> 介護医療機関List;

    /**
     * 引数からコレクションを受け取るコンストラクタです。
     *
     * @param 介護医療機関List 介護医療機関のリスト
     */
    public KaigoIryoKikanCollection(List<KaigoIryoKikan> 介護医療機関List) {
        this.介護医療機関List = requireNonNull(介護医療機関List,
                Messages.E00003.replace("介護医療機関List", getClass().getName()).getMessage());
    }

    /**
     * 引数から市町村コードと介護医療機関コードを渡し、それに対応した介護医療機関を返します。<br/>
     * 対応した介護医療機関が存在しない場合はnullが返ります。
     *
     * @param 市町村コード 市町村コード
     * @param 介護医療機関コード 介護医療機関コード
     * @return 対応した介護医療機関
     * @throws IllegalArgumentException 存在しない対象を指定したとき
     */
    public KaigoIryoKikan get介護医療機関(ShichosonCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード)
            throws IllegalArgumentException {
        for (KaigoIryoKikan kaigoIryoKikan : 介護医療機関List) {
            if (is市町村コードと介護機関コードが一致(kaigoIryoKikan, 市町村コード, 介護医療機関コード)) {
                return kaigoIryoKikan;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する介護医療機関").getMessage());
    }

    private boolean is市町村コードと介護機関コードが一致(KaigoIryoKikan kaigoIryoKikan, ShichosonCode 市町村コード,
            KaigoIryoKikanCode 介護医療機関コード) {
        return kaigoIryoKikan.get市町村コード().equals(市町村コード)
                && kaigoIryoKikan.get介護医療機関コード().equals(介護医療機関コード);
    }

    /**
     * 引数に医療機関区分を渡し、その医療機関区分に該当するものを抽出した介護医療機関のコレクションを返します。<br/>
     * 医療機関区分に該当するものがない場合、空のコレクションが返ります。
     *
     * @param 医療機関区分 医療機関区分
     * @return 指定した医療機関区分を持つ介護医療機関コレクション
     */
    public KaigoIryoKikanCollection sub介護医療機関Collection(IryoKikanKubun 医療機関区分) {
        List<KaigoIryoKikan> kaigoIryoKikanList = new ArrayList<>();
        for (KaigoIryoKikan kaigoIryoKikan : 介護医療機関List) {
            if (is医療機関区分が一致(kaigoIryoKikan, 医療機関区分)) {
                kaigoIryoKikanList.add(kaigoIryoKikan);
            }
        }

        return create介護医療機関Collection(kaigoIryoKikanList);
    }

    private boolean is医療機関区分が一致(KaigoIryoKikan 介護医療機関, IryoKikanKubun 医療機関区分) {
        return 介護医療機関.get医療機関区分().getCode().equals(医療機関区分.getCode());
    }

    private KaigoIryoKikanCollection create介護医療機関Collection(List<KaigoIryoKikan> kaigoIryoKikanList) {
        if (kaigoIryoKikanList.isEmpty()) {
            return new KaigoIryoKikanCollection(Collections.EMPTY_LIST);
        }
        return new KaigoIryoKikanCollection(kaigoIryoKikanList);
    }

    /**
     * 引数に医療機関状況を渡し、その医療機関状況に該当するものを抽出した介護医療機関のコレクションを返します。<br/>
     * 医療機関区分に該当するものがない場合、空のコレクションが返ります。
     *
     * @param 医療機関状況 医療機関状況
     * @return 指定した医療機関区分を持つ介護医療機関コレクション
     */
    public KaigoIryoKikanCollection sub介護医療機関Collection(IryoKikanJokyo 医療機関状況) {
        List<KaigoIryoKikan> kaigoIryoKikanList = new ArrayList<>();
        for (KaigoIryoKikan kaigoIryoKikan : 介護医療機関List) {
            if (is医療機関状況が一致(kaigoIryoKikan, 医療機関状況)) {
                kaigoIryoKikanList.add(kaigoIryoKikan);
            }
        }

        return create介護医療機関Collection(kaigoIryoKikanList);
    }

    private boolean is医療機関状況が一致(KaigoIryoKikan 介護医療機関, IryoKikanJokyo 医療機関状況) {
        return 介護医療機関.is有効() == 医療機関状況.is有効();
    }

    /**
     * 介護医療機関コレクションが空なら、trueを返します。
     *
     * @return コレクションが空ならtrue
     */
    public boolean isEmpty() {
        return 介護医療機関List.isEmpty();
    }

    /**
     * テスト用です。コレクションのサイズを返します。
     *
     * @return コレクションのサイズ
     */
    int size() {
        return 介護医療機関List.size();
    }

    @Override
    public Iterator iterator() {
        return 介護医療機関List.iterator();
    }
}
