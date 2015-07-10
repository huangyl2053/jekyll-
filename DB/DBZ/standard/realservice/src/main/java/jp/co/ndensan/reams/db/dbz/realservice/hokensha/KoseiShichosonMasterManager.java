/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 広域構成市町村を管理します。
 *
 * @author N3327 三浦 凌
 */
public class KoseiShichosonMasterManager {

    private final KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMasterManager() {
        this.dac = InstanceProvider.create(KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     */
    KoseiShichosonMasterManager(KoseiShichosonMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 旧市町村を含むか、含まないかを指定して、広域構成市町村を返します。
     *
     * @param contains合併旧市町村 contains合併旧市町村
     * @return 構成市町村マスタモデル
     */
    public IItemList<KoseiShichosonMasterModel> load広域構成市町村(ContainsKyuShichoson contains合併旧市町村) {
        return dac.selectBy(contains合併旧市町村);
    }

    /**
     * 引数に合致する広域構成市町村情報を返します。
     *
     * @param code 市町村コード
     * @param contains合併旧市町村 contains合併旧市町村
     * @return 構成市町村マスタモデル
     */
    public IItemList<KoseiShichosonMasterModel> find構成市町村(LasdecCode code, ContainsKyuShichoson contains合併旧市町村) {
        return dac.selectBy(code, contains合併旧市町村);
    }

    /**
     * 引数に合致する広域構成市町村情報を返します。
     *
     * @param searchCondition 検索条件
     * @return 構成市町村マスタモデル
     */
    public IItemList<KoseiShichosonMasterModel> find構成市町村(ISearchCondition searchCondition) {
        return dac.selectForm(searchCondition.makeSearchCondition());
    }

    /**
     * 広域構成市町村情報を登録します。
     *
     * @param model model
     * @return 登録件数
     */
    public int save(KoseiShichosonMasterModel model) {
        if (model.getState() == EntityDataState.Added) {
            return dac.insert(model);
        } else if (model.getState() == EntityDataState.Modified) {
            return dac.update(model);
        } else if (model.getState() == EntityDataState.Deleted) {
            return dac.delete(model);
        }
        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
