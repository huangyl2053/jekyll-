/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護サービスコードのクラスです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービスコード
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public class _KaigoServiceCode implements IKaigoServiceCode {

    private final KaigoServiceShuruiCode サービス種類コード;
    private final RString サービス項目コード;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     */
    public _KaigoServiceCode(KaigoServiceShuruiCode サービス種類コード, RString サービス項目コード) {

        this.サービス種類コード = requireNonNull(
                サービス種類コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("サービス種類コード", "介護サービスコード"));
        this.サービス項目コード = requireNonNull(
                サービス項目コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("サービス項目コード", "介護サービスコード"));

    }

    @Override
    public KaigoServiceShuruiCode getサービス種類コード() {
        return サービス種類コード;
    }

    @Override
    public RString getサービス項目コード() {
        return サービス項目コード;
    }

    @Override
    public RString getサービスコード() {
        return サービス種類コード.value().concat(サービス項目コード);
    }
}
