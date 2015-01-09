/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hokensha;

import java.util.Iterator;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 複数の{@link IKoikiKoseiShichoson}を扱います。
 *
 * @author N3327 三浦 凌
 */
public final class KoikiKoseiShichosons implements Iterable<IKoikiKoseiShichoson> {

    private final IItemList<IKoikiKoseiShichoson> shichosons;

    private KoikiKoseiShichosons(IItemList<? extends IKoikiKoseiShichoson> shichosons) {
        this.shichosons = ItemList.newItemList(shichosons);
    }

    /**
     * 指定の{@link IKoikiKoseiShichoson}をすべて保持する{@link KoikiKoseiShichosons}を生成します。
     *
     * @param shichosons {@link IKoikiKoseiShichoson}実装クラスを持ったitemList
     * @return
     * 指定の{@link IKoikiKoseiShichoson}をすべて保持する{@link KoikiKoseiShichosons}
     */
    public static KoikiKoseiShichosons of(IItemList<? extends IKoikiKoseiShichoson> shichosons) {
        Objects.requireNonNull(shichosons, UrSystemErrorMessages.値がnull.getReplacedMessage("引数"));
        return new KoikiKoseiShichosons(shichosons);
    }

    /**
     * 指定の{@link LasdecCode 市町村コード}を持った{@link IKoikiKoseiShichoson}を保持するかどうかを返します。
     * 保持する場合、{@code true}を返します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @return
     * 指定の{@link LasdecCode 市町村コード}を持った{@link IKoikiKoseiShichoson}を保持する時、{@code true}
     */
    public boolean contains(final LasdecCode 市町村コード) {
        return this.shichosons.anyMatch(new IPredicate<IKoikiKoseiShichoson>() {
            @Override
            public boolean evaluate(IKoikiKoseiShichoson t) {
                return t.get市町村コード().equals(市町村コード);
            }
        });
    }

    /**
     * 保持する{@link IKoikiKoseiShichoson}の数を返します。
     *
     * @return 保持する{@link IKoikiKoseiShichoson}の数
     */
    public int size() {
        return this.shichosons.size();
    }

    @Override
    public Iterator<IKoikiKoseiShichoson> iterator() {
        return this.shichosons.iterator();
    }

    /**
     * 保持するすべての要素を{@link IItemList}として返します。
     *
     * @return 保持するすべての要素を持った{@link IItemList}
     */
    public IItemList<IKoikiKoseiShichoson> asItemList() {
        return this.shichosons;
    }
}
