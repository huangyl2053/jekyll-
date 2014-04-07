/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import static java.util.Objects.requireNonNull;

/**
 * 介護医師情報のコレクションを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorCollection implements Iterable {

    private final List<KaigoDoctor> 介護医師リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 介護医師リスト 介護医師リスト
     */
    public KaigoDoctorCollection(List<KaigoDoctor> 介護医師リスト) {
        this.介護医師リスト = requireNonNull(介護医師リスト, Messages.E00001.replace("介護医師リスト").getMessage());
    }

    /**
     * 引数の条件に該当する介護医師情報を返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 介護医療機関コード 介護医療機関コード
     * @param 介護医師コード 介護医師コード
     * @return 介護医師情報
     */
    public KaigoDoctor get介護医師(ShoKisaiHokenshaNo 証記載保険者番号, KaigoIryoKikanCode 介護医療機関コード, KaigoDoctorCode 介護医師コード) {
        for (KaigoDoctor 介護医師 : 介護医師リスト) {
            if (介護医師.get証記載保険者番号().equals(証記載保険者番号)
                    && 介護医師.get介護医療機関コード().equals(介護医療機関コード)
                    && 介護医師.get介護医師コード().equals(介護医師コード)) {
                return 介護医師;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("介護医師").getMessage());
    }

    /**
     * 引数の条件に該当する介護医師情報のコレクションを返します。
     *
     * @param 介護医療機関コード 介護医療機関コード
     * @return 介護医師情報のコレクション
     */
    public KaigoDoctorCollection sub介護医師List(KaigoIryoKikanCode 介護医療機関コード) {
        List<KaigoDoctor> sub介護医師List = new ArrayList<>();
        for (KaigoDoctor 介護医師 : 介護医師リスト) {
            if (介護医師.get介護医療機関コード().equals(介護医療機関コード)) {
                sub介護医師List.add(介護医師);
            }
        }
        return new KaigoDoctorCollection(sub介護医師List);
    }

    /**
     * 介護医師リストがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合はtrueを返します。
     */
    public boolean isEmpty() {
        return 介護医師リスト.isEmpty();
    }

    /**
     * 介護医師リストのサイズを返します。
     *
     * @return 介護医師リストのサイズ
     */
    public int size() {
        return 介護医師リスト.size();
    }

    @Override
    public Iterator iterator() {
        return 介護医師リスト.iterator();
    }
}
