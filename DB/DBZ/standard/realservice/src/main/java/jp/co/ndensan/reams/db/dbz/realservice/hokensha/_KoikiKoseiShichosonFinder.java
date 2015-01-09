/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.business.hokensha.GappeiKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.business.hokensha.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.business.hokensha.KoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.business.hokensha.KoikiKoseiShichosons;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import static jp.co.ndensan.reams.db.dbz.model.hokensha.KoikiKoseiShichosonMasterComparator.orderBy加入日;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonModel;
import static jp.co.ndensan.reams.db.dbz.realservice.hokensha._KoseiShichosonMapper.toKoikiKoseiShichoson;
import static jp.co.ndensan.reams.db.dbz.realservice.hokensha._KoseiShichosonMapper.toKoseiShichosonModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * {@link IKoikiKoseiShichosonFinder}の実装です。
 *
 * @author N3327 三浦 凌
 */
public class _KoikiKoseiShichosonFinder implements IKoikiKoseiShichosonFinder {

    private final KoseiShichosonMasterManager manager;

    _KoikiKoseiShichosonFinder(KoseiShichosonMasterManager manager) {
        this.manager = manager;
    }

    @Override
    public KoikiKoseiShichosons load広域構成市町村(ContainsKyuShichoson contains合併旧市町村) {
        return _createKoikiKoseiShichosons(this.manager.load広域構成市町村(contains合併旧市町村));
    }

    private KoikiKoseiShichosons _createKoikiKoseiShichosons(IItemList<KoseiShichosonMasterModel> models) {
        IItemList<KoseiShichosonModel> koseiShichosonModels = models.map(toKoseiShichosonModel());
        IItemList<KoikiKoseiShichoson> koseiShichosons = koseiShichosonModels.map(toKoikiKoseiShichoson());
        return KoikiKoseiShichosons.of(
                koseiShichosons
        );
    }

    private KoikiKoseiShichosons find構成市町村(ISearchCondition searchCondition) {
        return _createKoikiKoseiShichosons(this.manager.find構成市町村(searchCondition));
    }

    /**
     * 指定の{@link LasdecCode 市町村コード}を持つ{@link IKoikiKoseiShichoson}を検索し、返します。
     * {@link ContainsKyuShichoson}が{@link ContainsKyuShichoson#旧市町村を含まない 旧市町村を含まない}の場合は、加入日が最も新しい物を返します。
     * {@link ContainsKyuShichoson#旧市町村を含む 旧市町村を含む}の場合は、{@link GappeiKoikiKoseiShichoson}のインスタンスを返します。
     *
     * @param code {@link LasdecCode 市町村コード}
     * @param contains旧市町村 {@link ContainsKyuShichoson 旧市町村を含むかどうか}
     * @return 指定の{@link LasdecCode 市町村コード}を持つ{@link IKoikiKoseiShichoson}
     */
    @Override
    public IOptional<IKoikiKoseiShichoson> find構成市町村(LasdecCode code, ContainsKyuShichoson contains旧市町村) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage(LasdecCode.class.getSimpleName()));
        Objects.requireNonNull(contains旧市町村, UrSystemErrorMessages.値がnull.getReplacedMessage(ContainsKyuShichoson.class.getSimpleName()));
        return _createIKoikiKoseiShichoson(
                this.manager.find構成市町村(code, contains旧市町村),
                contains旧市町村
        );
    }

    IOptional<IKoikiKoseiShichoson> _createIKoikiKoseiShichoson(IItemList<KoseiShichosonMasterModel> searchResult, ContainsKyuShichoson kubun) {
        IItemList<KoseiShichosonModel> models = searchResult.sorted(orderBy加入日.desc()).map(toKoseiShichosonModel());
        switch (kubun) {
            case 旧市町村を含まない:
                return models.findFirst().<IKoikiKoseiShichoson>map(toKoikiKoseiShichoson());
            case 旧市町村を含む:
                return DbOptional.<IKoikiKoseiShichoson>of(
                        new GappeiKoikiKoseiShichoson(models.map(toKoikiKoseiShichoson()))
                );
        }
        return DbOptional.empty();
    }
}
