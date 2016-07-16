/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.choshuhoho.ChoshuHohoResult;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri.ChosyuHohoHenkoMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuhoho.ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kanri.IChosyuHohoHenkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 徴収方法変更。
 *
 * @reamsid_L DBB-1760-030 sunhui
 */
public class ChosyuHohoHenko {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ
     */
    public ChosyuHohoHenko() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    public ChosyuHohoHenko(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosyuHohoHenko}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukushiyoguShohinInputGuideManager}のインスタンス
     */
    public static ChosyuHohoHenko createInstance() {
        return InstanceProvider.create(ChosyuHohoHenko.class);
    }

    /**
     * 徴収方法取得
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @return 該当賦課年度の徴収方法
     */
    public ChoshuHohoResult getChosyuHoho(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        IChosyuHohoHenkoMapper mapper = mapperProvider.create(IChosyuHohoHenkoMapper.class);
        ChosyuHohoHenkoMapperParameter parameter = ChosyuHohoHenkoMapperParameter
                .createSelectByKeyParam(賦課年度, 被保険者番号);
        ChoshuHohoEntity entity = mapper.selectChosyuHoho(parameter);
        if (null == entity) {
            return new ChoshuHohoResult(null, null);
        }

        DbT2001ChoshuHohoEntity dbT2001ChoshuHohoEntity = entity.getEntity().clone();
        dbT2001ChoshuHohoEntity.setState(EntityDataState.Unchanged);
        ChoshuHohoResult choshuHohoResult = new ChoshuHohoResult(
                new ChoshuHoho(dbT2001ChoshuHohoEntity), entity.getChoshuHoho3gat());
        return choshuHohoResult;
    }

}
