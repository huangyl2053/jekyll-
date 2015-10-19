/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 個別事項の介護情報を取得するクラスです。
 *
 * @author N2218 村松 優
 * @jpName 個別事項介護
 * @bizDomain 介護
 * @category 個別事項
 * @subCategory
 * @mainClass
 * @reference
 */
public class _KobetsuJikoKaigo implements IKobetsuJikoKaigo {

    private final IKobetsuJikoKaigoShikaku 介護資格;
    private final IKobetsuJikoKaigoJukyu 介護受給;

    /**
     * コンストラクタです。
     *
     * @param 介護資格 介護資格
     * @param 介護受給 介護受給
     * @throws NullPointerException 指定された文字列がnullの場合
     */
    public _KobetsuJikoKaigo(IKobetsuJikoKaigoShikaku 介護資格, IKobetsuJikoKaigoJukyu 介護受給) throws NullPointerException {
        RString message = new RString("介護情報");

        this.介護資格 = requireNonNull(介護資格, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護資格", message.toString()));
        this.介護受給 = requireNonNull(介護受給, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護受給", message.toString()));
    }

    @Override
    public IKobetsuJikoKaigoShikaku get介護資格() {
        return 介護資格;
    }

    @Override
    public IKobetsuJikoKaigoJukyu get介護受給() {
        return 介護受給;
    }
}
