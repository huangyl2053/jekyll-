/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * ケアマネージャクラスです。
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャ
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
public class _CareManager implements ICareManager {

    private static final RString DESCRIPTION_OF_TO_CREATE = new RString("ケアマネージャ");
    //
    private final RString 介護支援専門員番号;
    private final IName 氏名;
    private final IKaigoJigyosha 所属事業者;
    private final Range<FlexibleDate> 有効年月日;

    /**
     * コンストラクタです。
     *
     * @param 介護支援専門員番号 介護支援専門員番号
     * @param 氏名 氏名
     * @param 所属事業者 所属事業者
     * @param 有効年月日 有効年月日
     * @throws NullPointerException いずれかの引数がnullの場合はスローされる。
     */
    public _CareManager(RString 介護支援専門員番号, IName 氏名, IKaigoJigyosha 所属事業者, Range<FlexibleDate> 有効年月日) throws NullPointerException {
        Objects.requireNonNull(介護支援専門員番号, composeInstantiationMessage("介護支援専門員番号"));
        Objects.requireNonNull(氏名, composeInstantiationMessage("氏名"));
        Objects.requireNonNull(所属事業者, composeInstantiationMessage("所属事業者"));
        Objects.requireNonNull(有効年月日, composeInstantiationMessage("有効年月日"));

        this.介護支援専門員番号 = 介護支援専門員番号;
        this.氏名 = 氏名;
        this.所属事業者 = 所属事業者;
        this.有効年月日 = 有効年月日;
    }

    @Override
    public RString get介護支援専門員番号() {
        return 介護支援専門員番号;
    }

    @Override
    public IName get氏名() {
        return 氏名;
    }

    @Override
    public IKaigoJigyosha get所属事業者() {
        return 所属事業者;
    }

    @Override
    public Range<FlexibleDate> get有効年月日() {
        return 有効年月日;
    }

    private String composeInstantiationMessage(String replaceMessage) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(replaceMessage, DESCRIPTION_OF_TO_CREATE.toString());
    }
}
