package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.INinteiChosain;
import jp.co.ndensan.reams.db.dbx.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbx.business.mapper.NinteiChosainMapper;
import jp.co.ndensan.reams.db.dbx.persistence.basic.ChosainJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査員を取得するクラスです。
 *
 * @author N2204 三井 沙織
 * @jpName 認定調査員取得
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
public class _NinteiChosainFinder implements INinteiChosainFinder {

    private final ChosainJohoDac dac;
    private final IKaigoJigyoshaFinder finder;

    /**
     * 認定調査員検索クラスのコンストラクタです。
     */
    public _NinteiChosainFinder() {
        dac = InstanceProvider.createWithCustomize(ChosainJohoDac.class);
        finder = KaigoJigyoshaFinderFactory.getInstance();
    }

    /**
     * 認定調査員検索クラスのテスト用コンストラクタです。
     *
     * @param dac 調査員情報Dac
     * @param finder 事業者Finder
     */
    _NinteiChosainFinder(ChosainJohoDac dac, IKaigoJigyoshaFinder finder) {
        this.dac = dac;
        this.finder = finder;
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException 引数がnullの場合はスローされる
     */
    @Override
    public INinteiChosain get認定調査員(RString 介護調査員番号) throws NullPointerException {
        Objects.requireNonNull(介護調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護調査員番号"));

        ChosainJohoEntity entity = dac.selectByNumber(介護調査員番号);
        if (entity == null) {
            return null;
        }
        return NinteiChosainMapper.toNinteiChosain(entity, getJigyosha(entity.get介護事業者番号()));
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException 引数がnullの場合はスローされる
     */
    @Override
    public List<INinteiChosain> get所属認定調査員(IKaigoJigyosha 所属事業者) throws NullPointerException {
        Objects.requireNonNull(所属事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("所属事業者"));

        List<ChosainJohoEntity> entityList = dac.selectByJigyoshaCode(所属事業者.get事業者番号());
        if (entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return NinteiChosainMapper.toNinteiChosain(entityList, 所属事業者);
    }

    private IKaigoJigyosha getJigyosha(KaigoJigyoshaNo 介護事業者番号) {
        return finder.get特定の事業者番号の介護事業者(介護事業者番号.value());
    }
}
