/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.JukyushaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.NinteiShinseiJohoModel;
import jp.co.ndensan.reams.db.dbz.model.NinteiKekkaJohoModel;
import jp.co.ndensan.reams.db.dbz.model.relate.NinteiShinseiKekkaModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請結果のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiShinseiKekkaDac {

    private final JukyushaDaichoDac 受給者台帳Dac = InstanceProvider.create(JukyushaDaichoDac.class);
    private final NinteiShinseiJohoDac 要介護認定申請情報Dac = InstanceProvider.create(NinteiShinseiJohoDac.class);
    private final NinteiKekkaJohoDac 要介護認定結果情報Dac = InstanceProvider.create(NinteiKekkaJohoDac.class);

    /**
     * 要介護認定申請・要介護認定結果を被保険者番号を指定した履歴で返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<KaigoNinteiShinseiKekkaModel>
     */
    @Transaction
    public IItemList<NinteiShinseiKekkaModel> select要介護認定申請結果履歴By被保険者番号(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        IItemList<JukyushaDaichoModel> 受給者台帳List = 受給者台帳Dac.select受給者台帳履歴By被保険者番号(被保険者番号);
        List<NinteiShinseiKekkaModel> list = new ArrayList<>();

        for (JukyushaDaichoModel 受給者台帳 : 受給者台帳List) {
            NinteiShinseiKekkaModel model = createModel(受給者台帳);
            if (model != null) {
                list.add(model);
            }
        }
        IItemList<NinteiShinseiKekkaModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    private NinteiShinseiJohoModel select要介護認定申請情報ByKey(ShinseishoKanriNo 申請書管理番号) {
        NinteiShinseiJohoModel model = 要介護認定申請情報Dac.select要介護認定申請情報By申請書管理番号(申請書管理番号);

        return (model == null) ? null : model;
    }

    private NinteiKekkaJohoModel select要介護認定結果情報ByKey(ShinseishoKanriNo 申請書管理番号) {
        NinteiKekkaJohoModel model = 要介護認定結果情報Dac.select直近要介護認定結果情報By申請書管理番号(申請書管理番号);

        return (model == null) ? null : model;
    }

    private NinteiShinseiKekkaModel createModel(JukyushaDaichoModel 受給者台帳) {
        if (受給者台帳 == null) {
            return null;
        }

        NinteiShinseiKekkaModel model = new NinteiShinseiKekkaModel(
                受給者台帳,
                DbOptional.ofNullable(select要介護認定申請情報ByKey(受給者台帳.get申請書管理番号())),
                DbOptional.ofNullable(select要介護認定結果情報ByKey(受給者台帳.get申請書管理番号())));

        if (!model.get要介護認定結果情報モデル().isPresent()) {
            return null;
        }
        if (model.get要介護認定結果情報モデル().get().get認定有効期間開始年月日().isEmpty()
                || !model.get要介護認定結果情報モデル().get().get要介護認定取消年月日().isEmpty()) {
            return null;
        }

        return model;
    }

}
