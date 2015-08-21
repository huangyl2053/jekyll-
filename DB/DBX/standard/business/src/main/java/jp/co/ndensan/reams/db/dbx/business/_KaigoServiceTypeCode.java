/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 介護サービス種類コードを表したクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護サービスタイプコード
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス種類
 * @mainClass
 * @reference
 */
public class _KaigoServiceTypeCode implements IKaigoServiceTypeCode {

    private final RString serviceTypeCd;

    /**
     * 介護サービス種類コードを表したクラスのコンストラクタです。
     *
     * @param serviceTypeCd サービス種類コード
     */
    public _KaigoServiceTypeCode(RString serviceTypeCd) {
        this.serviceTypeCd = requireNonNull(serviceTypeCd, UrSystemErrorMessages.値がnull.getReplacedMessage("serviceTypeCd"));
    }

    @Override
    public RString getValue() {
        return serviceTypeCd;
    }
}
