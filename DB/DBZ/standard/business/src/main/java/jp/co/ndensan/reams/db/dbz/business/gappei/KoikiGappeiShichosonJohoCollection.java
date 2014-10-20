/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.gappei;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.gappei.IKoikiGappeiShichosonJoho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 広域合併市町村情報のコレクションクラスです。
 *
 * @author N8156 宮本 康
 */
public class KoikiGappeiShichosonJohoCollection implements Iterable<IKoikiGappeiShichosonJoho> {

    private final List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト;

    /**
     * コンストラクタです。
     *
     * @param 広域合併市町村情報リスト 広域合併市町村情報リスト
     * @throws NullPointerException 引数がNullの時
     */
    public KoikiGappeiShichosonJohoCollection(List<IKoikiGappeiShichosonJoho> 広域合併市町村情報リスト) throws NullPointerException {
        this.広域合併市町村情報リスト = requireNonNull(広域合併市町村情報リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("広域合併市町村情報リスト"));
    }

    /**
     * 広域合併市町村情報リストのサイズを返します。
     *
     * @return サイズ
     */
    public int getSize() {
        return 広域合併市町村情報リスト.size();
    }

    @Override
    public Iterator<IKoikiGappeiShichosonJoho> iterator() {
        return this.広域合併市町村情報リスト.iterator();
    }
}
