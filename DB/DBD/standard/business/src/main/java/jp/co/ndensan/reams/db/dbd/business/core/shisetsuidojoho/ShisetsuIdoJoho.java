/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shisetsuidojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shisetsuidojoho.ShisetsuIdoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】施設入退 介護施設入退所情報です。
 *
 * @reamsid_L DBD-3560-120 wangjie2
 */
public class ShisetsuIdoJoho {

    private final ShisetsuIdoJohoEntity 介護施設入退所情報;

    /**
     * コンストラクタです。
     *
     * @param 介護施設入退所情報 介護施設入退所情報
     */
    public ShisetsuIdoJoho(ShisetsuIdoJohoEntity 介護施設入退所情報) {
        requireNonNull(介護施設入退所情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護施設入退所情報のエンティティ"));
        this.介護施設入退所情報 = 介護施設入退所情報;
    }

    /**
     * 入所年月日を返します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return 介護施設入退所情報.get入所年月日();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return 介護施設入退所情報.get退所年月日();
    }

    /**
     * 入所施設種類を返します。
     *
     * @return 入所施設種類
     */
    public RString get入所施設種類() {
        return 介護施設入退所情報.get入所施設種類();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public RString get入所施設コード() {
        return 介護施設入退所情報.get入所施設コード();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return 介護施設入退所情報.get事業者名称();
    }

    /**
     * 転出先保険者番号を返します。
     *
     * @return 転出先保険者番号
     */
    public HihokenshaNo get転出先保険者番号() {
        return 介護施設入退所情報.get転出先保険者番号();
    }

}
