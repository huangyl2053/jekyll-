/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護サービス種類のクラスです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス種類
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class _KaigoServiceShurui implements IKaigoServiceShurui {

    private final KaigoServiceShuruiCode サービス種類コード;
    private final Range<FlexibleYearMonth> 提供年月;
    private final RString サービス種類名称;
    private final RString サービス種類名称略称;
    private final KaigoServiceBunruiCode サービス分類;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 提供年月 提供年月
     * @param サービス種類名称 サービス種類名称
     * @param サービス種類名称略称 サービス種類名称略称
     * @param サービス分類 サービス分類
     */
    public _KaigoServiceShurui(KaigoServiceShuruiCode サービス種類コード, Range<FlexibleYearMonth> 提供年月, RString サービス種類名称,
            RString サービス種類名称略称, KaigoServiceBunruiCode サービス分類) {
        RString instanceName = new RString("介護サービス種類");
        this.サービス種類コード = requireNonNull(サービス種類コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("サービス種類コード", instanceName.toString()));
        this.提供年月 = requireNonNull(提供年月, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("提供年月", instanceName.toString()));
        this.サービス種類名称 = requireNonNull(サービス種類名称, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("サービス種類名称", instanceName.toString()));
        this.サービス種類名称略称 = requireNonNull(サービス種類名称略称, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("サービス種類名称略称", instanceName.toString()));
        this.サービス分類 = requireNonNull(サービス分類, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("サービス分類", instanceName.toString()));
    }

    @Override
    public KaigoServiceShuruiCode getサービス種類コード() {
        return サービス種類コード;
    }

    @Override
    public Range<FlexibleYearMonth> get提供年月() {
        return 提供年月;
    }

    @Override
    public RString getサービス種類名称() {
        return サービス種類名称;
    }

    @Override
    public RString getサービス種類名称略称() {
        return サービス種類名称略称;
    }

    @Override
    public KaigoServiceBunruiCode getサービス分類() {
        return サービス分類;
    }

}
