/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査クラスです。
 *
 * @author N2204 三井 沙織
 * @jpName 要介護認定調査
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _YoKaigoNinteiChosa implements IYoKaigoNinteiChosa {

    private static final RString DESCRIPTION_OF_TO_CREATE;
    //
    private final RDate 依頼年月日;
    private final RDate 実施年月日;
    private final RDate 完了年月日;
    private final RString 認定調査員コード;
    private final RString 認定調査員氏名;
    private final RString 事業者コード;
    private final RString 事業者名称;

    static {
        DESCRIPTION_OF_TO_CREATE = new RString("要介護認定調査");
    }

    /**
     * コンストラクタです。
     *
     * @param 依頼年月日 依頼年月日
     * @param 実施年月日 実施年月日
     * @param 完了年月日 完了年月日
     * @param 認定調査員コード 認定調査員コード
     * @param 認定調査員氏名 認定調査員氏名
     * @param 事業者コード 事業者コード
     * @param 事業者名称 事業者名称
     */
    public _YoKaigoNinteiChosa(RDate 依頼年月日, RDate 実施年月日, RDate 完了年月日, RString 認定調査員コード, RString 認定調査員氏名,
            RString 事業者コード, RString 事業者名称) {

        this.依頼年月日 = requireNonNull(依頼年月日, composeInstantiationMessage("依頼年月日"));
        this.実施年月日 = requireNonNull(実施年月日, composeInstantiationMessage("実施年月日"));
        this.完了年月日 = requireNonNull(完了年月日, composeInstantiationMessage("完了年月日"));
        this.認定調査員コード = requireNonNull(認定調査員コード, composeInstantiationMessage("認定調査員コード"));
        this.認定調査員氏名 = requireNonNull(認定調査員氏名, composeInstantiationMessage("認定調査員氏名"));
        this.事業者コード = requireNonNull(事業者コード, composeInstantiationMessage("事業者コード"));
        this.事業者名称 = requireNonNull(事業者名称, composeInstantiationMessage("事業者名称"));
    }

    @Override
    public RDate get依頼年月日() {
        return 依頼年月日;
    }

    @Override
    public RDate get実施年月日() {
        return 実施年月日;
    }

    @Override
    public RDate get完了年月日() {
        return 完了年月日;
    }

    @Override
    public RString get認定調査員コード() {
        return 認定調査員コード;
    }

    @Override
    public RString get認定調査員氏名() {
        return 認定調査員氏名;
    }

    @Override
    public RString get事業者コード() {
        return 事業者コード;
    }

    @Override
    public RString get事業者名称() {
        return 事業者名称;
    }

    private static String composeInstantiationMessage(String replaceMessage) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(replaceMessage, DESCRIPTION_OF_TO_CREATE.toString());
    }
}
