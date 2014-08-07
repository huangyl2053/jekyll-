/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.Messages;

/**
 *
 * @author N9606 漢那 憲作
 */
public class KaigoTeikeibun {

    private final RString 区分;
    private final RString 種別;
    private final RString コード;
    private final RString 内容;

    /**
     * インスタンスを生成します。
     *
     * @param 区分 RString
     * @param 種別 RString
     * @param コード RString
     * @param 内容 RString
     */
    public KaigoTeikeibun(RString 区分, RString 種別, RString コード, RString 内容) {

        this.区分 = requireNonNull(区分, Messages.E00001.getMessage());
        this.種別 = requireNonNull(種別, Messages.E00001.getMessage());
        this.コード = requireNonNull(コード, Messages.E00001.getMessage());
        this.内容 = 内容;

    }

    /**
     * 区分を取得します。
     *
     * @return 区分
     */
    public RString get区分() {
        return 区分;
    }

    /**
     * 種別を取得します。
     *
     * @return 種別
     */
    public RString get種別() {
        return 種別;
    }

    /**
     * コードを取得します。
     *
     * @return コード
     */
    public RString getコード() {
        return コード;
    }

    /**
     * 内容を取得します。
     *
     * @return 内容
     */
    public RString get内容() {
        return 内容;
    }
}
