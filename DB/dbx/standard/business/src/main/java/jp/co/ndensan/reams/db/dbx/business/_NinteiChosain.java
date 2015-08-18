/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 認定調査員クラスです。
 *
 * @author N2204 三井 沙織
 * @jpName 認定調査員
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
public class _NinteiChosain implements INinteiChosain {

    private final RString 介護調査員番号;
    private final IName 氏名;
    private final IKaigoJigyosha 所属事業者;

    /**
     * コンストラクタです。
     *
     * @param 介護調査員番号 介護調査員番号
     * @param 氏名 氏名
     * @param 所属事業者 所属事業者
     * @throws NullPointerException いずれかの引数がNullの場合はスローされる。
     */
    public _NinteiChosain(RString 介護調査員番号, IName 氏名, IKaigoJigyosha 所属事業者) throws NullPointerException {

        Objects.requireNonNull(介護調査員番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護調査員番号", "認定調査員"));
        Objects.requireNonNull(氏名, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("氏名", "認定調査員"));
        Objects.requireNonNull(所属事業者, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("所属事業者", "認定調査員"));

        this.介護調査員番号 = 介護調査員番号;
        this.氏名 = 氏名;
        this.所属事業者 = 所属事業者;
    }

    @Override
    public RString get介護調査員番号() {
        return 介護調査員番号;
    }

    @Override
    public IName get氏名() {
        return 氏名;
    }

    @Override
    public IKaigoJigyosha get所属事業者() {
        return 所属事業者;
    }
}
