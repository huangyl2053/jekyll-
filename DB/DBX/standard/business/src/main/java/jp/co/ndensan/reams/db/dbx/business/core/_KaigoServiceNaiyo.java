/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 介護サービス内容のクラスです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス内容
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class _KaigoServiceNaiyo implements IKaigoServiceNaiyo {

    private static final RString DESCRIPTION_OF_TO_CREATE;
    private final IKaigoServiceCode サービスコード;
    private final Range<FlexibleYearMonth> 適用年月;
    private final int 履歴番号;
    private final RString サービス名称;
    private final RString サービス略称;
    private final IKaigoServiceTani 介護サービス単位;

    static {
        DESCRIPTION_OF_TO_CREATE = new RString("介護サービス内容");
    }

    /**
     * インスタンスを生成します。
     *
     * @param サービスコード サービスコード
     * @param 適用年月 適用年月
     * @param 履歴番号 履歴番号
     * @param サービス名称 サービス名称
     * @param サービス略称 サービス略称
     * @param 介護サービス単位 介護サービス単位
     */
    public _KaigoServiceNaiyo(IKaigoServiceCode サービスコード, Range<FlexibleYearMonth> 適用年月,
            int 履歴番号, RString サービス名称, RString サービス略称, IKaigoServiceTani 介護サービス単位) {

        this.サービスコード = requireNonNull(サービスコード, composeInstantiationMessage("サービスコード"));
        this.適用年月 = requireNonNull(適用年月, composeInstantiationMessage("適用年月"));
        this.履歴番号 = 履歴番号;
        this.サービス名称 = requireNonNull(サービス名称, composeInstantiationMessage("サービス名称"));
        this.サービス略称 = requireNonNull(サービス略称, composeInstantiationMessage("サービス略称"));
        this.介護サービス単位 = requireNonNull(介護サービス単位, composeInstantiationMessage("介護サービス単位"));
    }

    /**
     * 削除用のインスタンスを生成します。
     *
     * @param サービスコード サービスコード
     */
    public _KaigoServiceNaiyo(IKaigoServiceCode サービスコード) {
        this.サービスコード = requireNonNull(サービスコード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("サービスコード", "介護サービス内容"));
        this.適用年月 = new Range<>(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX);
        this.履歴番号 = 0;
        this.サービス名称 = RString.EMPTY;
        this.サービス略称 = RString.EMPTY;
        this.介護サービス単位 = new _KaigoServiceTani(0, new TanisuShikibetsu(RString.EMPTY), new TanisuSanteiTani(RString.EMPTY));
    }

    @Override
    public IKaigoServiceCode getサービスコード() {
        return サービスコード;
    }

    @Override
    public Range<FlexibleYearMonth> get適用年月() {
        return 適用年月;
    }

    @Override
    public int get履歴番号() {
        return 履歴番号;
    }

    @Override
    public RString getサービス名称() {
        return サービス名称;
    }

    @Override
    public RString getサービス略称() {
        return サービス略称;
    }

    @Override
    public IKaigoServiceTani get介護サービス単位() {
        return 介護サービス単位;
    }

    private static String composeInstantiationMessage(String replaceMessage) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(replaceMessage, DESCRIPTION_OF_TO_CREATE.toString());
    }
}
