/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.gappei;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichosonJoho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 合併市町村情報のコレクションクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonJohoCollection implements Iterable<IGappeiShichosonJoho> {

    private final List<IGappeiShichosonJoho> 合併市町村情報リスト;

    /**
     * コンストラクタです。
     *
     * @param 合併市町村情報リスト 合併市町村情報リスト
     * @throws NullPointerException 引数がNullの時
     */
    public GappeiShichosonJohoCollection(List<IGappeiShichosonJoho> 合併市町村情報リスト) throws NullPointerException {
        this.合併市町村情報リスト = requireNonNull(合併市町村情報リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村情報リスト"));
    }

    /**
     * 合併市町村情報リストのサイズを返します。
     *
     * @return サイズ
     */
    public int getSize() {
        return 合併市町村情報リスト.size();
    }

    @Override
    public Iterator<IGappeiShichosonJoho> iterator() {
        return this.合併市町村情報リスト.iterator();
    }
}
