/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

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
     * @throws NullPointerException 引数にNULLが渡された場合
     */
    public KaigoIryoKikanCollection(List<KaigoIryoKikan> 介護医療機関List) throws NullPointerException {
        this.介護医療機関List = requireNonNull(介護医療機関List,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護医療機関List", getClass().getName()));
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
    public KaigoIryoKikan get介護医療機関(LasdecCode 市町村コード, KaigoIryoKikanCode 介護医療機関コード)
            throws IllegalArgumentException {
        for (KaigoIryoKikan kaigoIryoKikan : 介護医療機関List) {
            if (is市町村コードと介護機関コードが一致(kaigoIryoKikan, 市町村コード, 介護医療機関コード)) {
                return kaigoIryoKikan;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する介護医療機関").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する介護医療機関").getMessage());

    }

    private boolean is市町村コードと介護機関コードが一致(KaigoIryoKikan kaigoIryoKikan, LasdecCode 市町村コード,
            KaigoIryoKikanCode 介護医療機関コード) {
        return is市町村コードが一致(kaigoIryoKikan, 市町村コード) && is介護機関コードが一致(kaigoIryoKikan, 介護医療機関コード);
    }

    private boolean is介護機関コードが一致(KaigoIryoKikan kaigoIryoKikan, KaigoIryoKikanCode 介護医療機関コード) {
        return kaigoIryoKikan.get介護医療機関コード().equals(介護医療機関コード);
    }

    private boolean is市町村コードが一致(KaigoIryoKikan kaigoIryoKikan, LasdecCode 市町村コード) {
        return kaigoIryoKikan.get市町村コード().equals(市町村コード);
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
        return 介護医療機関.get医療機関区分().equals(医療機関区分);
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
        return 介護医療機関.get医療機関状況() == 医療機関状況;
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
     * コレクションのサイズを返します。
     *
     * @return コレクションのサイズ
     */
    public int size() {
        return 介護医療機関List.size();
    }

    @Override
    public Iterator iterator() {
        return 介護医療機関List.iterator();
    }
}
