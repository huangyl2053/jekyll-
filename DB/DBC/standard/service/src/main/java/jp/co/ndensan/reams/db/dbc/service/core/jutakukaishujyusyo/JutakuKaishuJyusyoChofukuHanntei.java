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
 * 住宅改修費改修住所重複判定
 *
 * @reamsid_L DBC-0992-130 yangchenbing
 */
public class JutakuKaishuJyusyoChofukuHanntei {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ
     */
    public JutakuKaishuJyusyoChofukuHanntei() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    public JutakuKaishuJyusyoChofukuHanntei(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakuKaishuJyusyoChofukuHanntei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukushiyoguShohinInputGuideManager}のインスタンス
     */
    public static JutakuKaishuJyusyoChofukuHanntei createInstance() {
        return InstanceProvider.create(JutakuKaishuJyusyoChofukuHanntei.class);
    }

    /**
     * 重複判定
     *
     * @param 被保険者番号 被保険者番号
     * @param 開始サービス提供年月 FlexibleYearMonth
     * @param 終了サービス提供年月 FlexibleYearMonth
     * @param 改修住宅住所 改修住宅住所
     * @return 判定
     */
    @Transaction
    public boolean checkKaishuJyusyoChofukuToroku(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 開始サービス提供年月,
            FlexibleYearMonth 終了サービス提供年月,
            RString 改修住宅住所) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(開始サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始サービス提供年月"));
        requireNonNull(終了サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了サービス提供年月"));
        requireNonNull(改修住宅住所, UrSystemErrorMessages.値がnull.getReplacedMessage("改修住宅住所"));
        IJutakuKaishuIJyusyoChofukuHannteiMapper mapper = mapperProvider.create(IJutakuKaishuIJyusyoChofukuHannteiMapper.class);
        JutakuKaishuJyusyoChofukuHannteiMapperParameter parameter = JutakuKaishuJyusyoChofukuHannteiMapperParameter
                .createSelectByKeyParam(被保険者番号, 開始サービス提供年月, 終了サービス提供年月);
        List<JutakuKaishuJyusyoChofukuHannteiEntity> entityList = mapper.selectKaishuJyusyoChofukuToroku(parameter);
        if (null == entityList || entityList.isEmpty()) {
            return true;
        }
        for (JutakuKaishuJyusyoChofukuHannteiEntity entity : entityList) {
            if (!改修住宅住所.equals(entity.getJutakuKaishuJutakuAddress())) {
                return false;
            }
        }
        return true;
    }
}
