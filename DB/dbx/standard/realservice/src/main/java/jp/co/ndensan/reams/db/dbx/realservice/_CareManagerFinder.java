package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.ICareManager;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.business.mapper.CareManagerMapper;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IDbT7064CareManegerDac;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ケアマネージャマネージャーです。
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャ取得
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
class _CareManagerFinder implements ICareManagerFinder {

    private final IDbT7064CareManegerDac dac;

    /**
     * コンストラクタです。
     */
    public _CareManagerFinder() {
        dac = InstanceProvider.createWithCustomize(IDbT7064CareManegerDac.class);
    }

    _CareManagerFinder(IDbT7064CareManegerDac dac) {
        this.dac = dac;
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException 引数がnullの場合はスローされる
     */
    @Override
    public ICareManager getCareManager(RString 介護支援専門員番号) throws NullPointerException {
        Objects.requireNonNull(介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員番号"));

        DbT7064CareManegerEntity entity = dac.selectByNumber(介護支援専門員番号);
        if (entity == null) {
            return null;
        }
        return CareManagerMapper.toCareManager(entity, getJigyosha(entity.getShozokuJigyoshaNo()));
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException 引数がnullの場合はスローされる
     */
    @Override
    public List<ICareManager> get所属ケアマネージャ(IKaigoJigyosha 所属事業者) throws NullPointerException {
        Objects.requireNonNull(所属事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("所属事業者"));

        List<DbT7064CareManegerEntity> entityList = dac.selectByJigyoshaCode(所属事業者.get事業者番号());
        if (entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return CareManagerMapper.toCareManager(entityList, getJigyosha(所属事業者.get事業者番号()));
    }

    private IKaigoJigyosha getJigyosha(KaigoJigyoshaNo 介護支援専門員番号) {
        return KaigoJigyoshaFinderFactory.getInstance().get特定の事業者番号の介護事業者(介護支援専門員番号.value(), FlexibleDate.EMPTY);
    }
}
