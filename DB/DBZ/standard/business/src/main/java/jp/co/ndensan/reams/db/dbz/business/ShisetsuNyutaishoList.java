/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 複数の施設入退所情報を表すクラスです。
 *
 * @author N3317 塚田 萌
 */
public class ShisetsuNyutaishoList implements Iterable<ShisetsuNyutaisho> {

    private final List<ShisetsuNyutaisho> 施設入退所List;

    /**
     * コンストラクタです。
     *
     * @param 施設入退所List 施設入退所List
     */
    public ShisetsuNyutaishoList(List<ShisetsuNyutaisho> 施設入退所List) {
        this.施設入退所List = requireNonNull(施設入退所List,
                UrSystemErrorMessages.値がnull.getReplacedMessage("施設入退所List"));
    }

    /**
     * 基準日を指定し、その基準日時点で入所している施設についての施設入退所情報を一意に取得します。
     *
     * @param 基準日 基準日
     * @return 指定した基準日に入所している施設入退所の情報
     * @throws IllegalArgumentException 施設入退所リスト内に、指定した日付に該当する施設入退所情報が存在しないとき
     */
    public ShisetsuNyutaisho get施設入退所(FlexibleDate 基準日) throws IllegalArgumentException {
        for (ShisetsuNyutaisho 施設入退所 : 施設入退所List) {
            if (is入所(施設入退所, 基準日)) {
                return 施設入退所;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する施設入退所").evaluate());
    }

    private boolean is入所(ShisetsuNyutaisho 施設入退所, FlexibleDate 基準日) {
        return 施設入退所.get入所期間().getFrom().isBeforeOrEquals(基準日);
    }

    /**
     * 施設入退所ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return 施設入退所List.isEmpty();
    }

    /**
     * 施設入退所Listの要素数を返します。
     *
     * @return 施設入退所Listの要素数
     */
    public int size() {
        return 施設入退所List.size();
    }

    @Override
    public Iterator<ShisetsuNyutaisho> iterator() {
        return 施設入退所List.iterator();
    }
}
