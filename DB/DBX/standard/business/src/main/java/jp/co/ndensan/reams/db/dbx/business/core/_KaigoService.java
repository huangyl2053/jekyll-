/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 介護サービスのクラスです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class _KaigoService implements IKaigoService {

    private final IKaigoServiceShurui 介護サービス種類;
    private final List<IKaigoServiceNaiyo> 介護サービス内容リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 介護サービス種類 介護サービス種類
     * @param 介護サービス内容リスト 介護サービス内容リスト
     */
    public _KaigoService(
            IKaigoServiceShurui 介護サービス種類, List<IKaigoServiceNaiyo> 介護サービス内容リスト) {

        this.介護サービス種類 = requireNonNull(介護サービス種類, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("介護サービス種類", "介護サービス"));
        this.介護サービス内容リスト = 介護サービス内容リスト;
    }

    @Override
    public IKaigoServiceShurui get介護サービス種類() {
        return 介護サービス種類;
    }

    @Override
    public List<IKaigoServiceNaiyo> get介護サービス内容リスト() {
        return 介護サービス内容リスト;
    }
}
