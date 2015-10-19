/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuShikibetsu;

/**
 * 介護サービス単位のクラスです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス単位
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class _KaigoServiceTani implements IKaigoServiceTani {

    private final int 単位数;
    private final TanisuShikibetsu 単位数識別;
    private final TanisuSanteiTani 単位数算定単位;

    /**
     * インスタンスを生成します。
     *
     * @param 単位数 単位数
     * @param 単位数識別 単位数識別
     * @param 単位数算定単位 単位数算定単位
     */
    public _KaigoServiceTani(int 単位数, TanisuShikibetsu 単位数識別, TanisuSanteiTani 単位数算定単位) {

        this.単位数 = 単位数;
        this.単位数識別 = requireNonNull(単位数識別, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("単位数識別", "介護サービス内容"));
        this.単位数算定単位 = 単位数算定単位;
    }

    @Override
    public int get単位数() {
        return 単位数;
    }

    @Override
    public TanisuShikibetsu get単位数識別() {
        return 単位数識別;
    }

    @Override
    public TanisuSanteiTani get単位数算定単位() {
        return 単位数算定単位;
    }
}
