/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入所施設を表すクラスです。
 *
 * @author N3317 塚田 萌
 */
public class NyushoShisetsu {

    private final ShisetsuType 施設種類;
    private final ShisetsuCode 施設コード;
    private final RString 施設名称;
    private final RString 施設カナ名称;
    private final RString 施設所在地住所;

    /**
     * コンストラクタです。
     *
     * @param 施設種類 施設種類
     * @param 施設コード 施設コード
     * @param 施設名称 施設名称
     * @param 施設カナ名称 施設カナ名称
     * @param 施設所在地住所 施設所在地住所
     */
    public NyushoShisetsu(ShisetsuType 施設種類,
            ShisetsuCode 施設コード,
            RString 施設名称,
            RString 施設カナ名称,
            RString 施設所在地住所) {

        this.施設種類 = requireNonNull(施設種類, Messages.E00001.replace("施設種類").getMessage());
        this.施設コード = requireNonNull(施設コード, Messages.E00001.replace("施設コード").getMessage());
        this.施設名称 = 施設名称;
        this.施設カナ名称 = 施設カナ名称;
        this.施設所在地住所 = 施設所在地住所;
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public ShisetsuType get施設種類() {
        return 施設種類;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public ShisetsuCode get施設コード() {
        return 施設コード;
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称
     */
    public RString get施設名称() {
        return 施設名称;
    }

    /**
     * 施設カナ名称を返します。
     *
     * @return 施設カナ名称
     */
    public RString get施設カナ名称() {
        return 施設カナ名称;
    }

    /**
     * 施設所在地住所を返します。
     *
     * @return 施設所在地住所
     */
    public RString get施設所在地住所() {
        return 施設所在地住所;
    }
}
