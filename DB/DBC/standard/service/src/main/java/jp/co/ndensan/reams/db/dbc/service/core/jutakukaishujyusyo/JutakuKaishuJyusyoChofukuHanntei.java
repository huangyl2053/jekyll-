/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.JutakuKaishuJyusyoChofukuHannteiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHannteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujyusyo.IJutakuKaishuIJyusyoChofukuHannteiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author ycb
 */
public class JutakuKaishuJyusyoChofukuHanntei {

    private final MapperProvider mapperProvider;

    public JutakuKaishuJyusyoChofukuHanntei() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    public JutakuKaishuJyusyoChofukuHanntei(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    public static JutakuKaishuJyusyoChofukuHanntei createInstance() {
        return InstanceProvider.create(JutakuKaishuJyusyoChofukuHanntei.class);
    }

    /**
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 改修住宅住所
     * @return
     */
    @Transaction
    public boolean checkKaishuJyusyoChofukuToroku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 改修住宅住所) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(改修住宅住所, UrSystemErrorMessages.値がnull.getReplacedMessage("改修住宅住所"));
        IJutakuKaishuIJyusyoChofukuHannteiMapper mapper = mapperProvider.create(IJutakuKaishuIJyusyoChofukuHannteiMapper.class);
        JutakuKaishuJyusyoChofukuHannteiMapperParameter parameter = JutakuKaishuJyusyoChofukuHannteiMapperParameter.createSelectByKeyParam(被保険者番号, サービス提供年月);
        List<JutakuKaishuJyusyoChofukuHannteiEntity> entityList = mapper.selectKaishuJyusyoChofukuToroku(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return false;
        }
        for (JutakuKaishuJyusyoChofukuHannteiEntity entity : entityList) {
            if (改修住宅住所.equals(entity.getJutakuKaishuJutakuAddress())) {
                return true;
            }
            if (entity.isJutakuJushoHenko() == true) {
                return false;
            }
        }
        return false;
    }

}
