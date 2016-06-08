/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 介護サービス種類を扱うクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護サービスタイプ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス種類
 * @mainClass
 * @reference
 */
public class _KaigoServiceType implements IKaigoServiceType {

    private final IKaigoServiceTypeCode サービス種類コード;
    private final RYearMonth 提供開始年月;
    private final RString サービス種類名称;
    private final RString サービス種類略称;
    private final RString サービス分類;

    /**
     * 介護サービス種類の操作を行うクラスです。
     *
     * @param サービス種類コード サービス種類コード
     * @param 提供開始年月 提供開始年月
     * @param サービス種類名称 サービス種類名称
     * @param サービス種類略称 サービス種類略称
     * @param サービス分類 サービス分類
     */
    public _KaigoServiceType(IKaigoServiceTypeCode サービス種類コード, RYearMonth 提供開始年月,
            RString サービス種類名称, RString サービス種類略称, RString サービス分類) {
        this.サービス種類コード = requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        this.提供開始年月 = requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));
        this.サービス種類名称 = requireNonNull(サービス種類名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類名称"));
        this.サービス種類略称 = requireNonNull(サービス種類略称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類略称"));
        this.サービス分類 = requireNonNull(サービス分類, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス分類"));
    }

    @Override
    public IKaigoServiceTypeCode getサービス種類コード() {
        return サービス種類コード;
    }

    @Override
    public RYearMonth get提供開始年月() {
        return 提供開始年月;
    }

    @Override
    public RString getサービス種類名称() {
        return サービス種類名称;
    }

    @Override
    public RString getサービス種類略称() {
        return サービス種類略称;
    }

    @Override
    public RString getサービス分類() {
        return サービス分類;
    }
}
