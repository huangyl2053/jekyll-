/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;

/**
 * 入所施設を作成するクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class NyushoShisetsuMapper {

    private NyushoShisetsuMapper() {
    }

    /**
     * 入所施設のインスタンスを作成します。
     *
     * @param 施設種類 施設種類
     * @param 施設コード 施設コード
     * @param 法人 法人
     * @return 入所施設のインスタンス
     */
    public static NyushoShisetsu toNyushoShisetsu(
            ShisetsuType 施設種類, ShisetsuCode 施設コード, IHojin 法人) {

        if (法人 == null) {
            return null;
        }

        return new NyushoShisetsu(
                施設種類,
                施設コード,
                法人.get氏名().getName().value(),
                法人.get氏名().getKana().value(),
                法人.get住所().get住所());
    }
}
