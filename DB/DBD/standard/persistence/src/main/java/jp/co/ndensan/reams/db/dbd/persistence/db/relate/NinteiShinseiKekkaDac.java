/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.relate;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請結果のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiShinseiKekkaDac {

    private final JukyushaDaichoDac 受給者台帳Dac = InstanceProvider.create(JukyushaDaichoDac.class);

    /**
     * 要介護認定申請・要介護認定結果を被保険者番号を指定した履歴で返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<KaigoDbT4102NinteiKekkaJohoEntity>
     */
    @Transaction
    public IItemList<DbT4001JukyushaDaichoEntity> select要介護認定申請結果履歴By被保険者番号(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        return 受給者台帳Dac.select受給者台帳履歴By被保険者番号(被保険者番号);
    }

}
