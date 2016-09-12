package jp.co.ndensan.reams.db.dbe.service.core.basic.hokokushiryosakusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaijoho.GogitaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 報告資料発行のFinderクラスです。
 *
 * @reamsid_L DBE-1450-010 wangxiaodong
 */
public class HokokuShiryoSakuSeiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    HokokuShiryoSakuSeiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    HokokuShiryoSakuSeiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HokokuShiryoSakuSeiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HokokuShiryoSakuSeiFinder}のインスタンス
     */
    public static HokokuShiryoSakuSeiFinder createInstance() {
        return InstanceProvider.create(HokokuShiryoSakuSeiFinder.class);
    }

    /**
     * 合議体番号を検索します。
     *
     * @return 合議体番号リスト
     */
    @Transaction
    public SearchResult<GogitaiJoho> getGogitaiNo() {
        List<DbT5591GogitaiJohoEntity> 合議体番号リスト
                = mapperProvider.create(IHokokuShiryoSakuSeiMapper.class).getGogitaiNo(FlexibleDate.getNowDate());
        if (合議体番号リスト == null || 合議体番号リスト.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJoho>emptyList(), 0, false);
        }
        List<GogitaiJoho> gogitaiNoList = new ArrayList();
        for (DbT5591GogitaiJohoEntity entity : 合議体番号リスト) {
            GogitaiJohoRelateEntity relateEntity = new GogitaiJohoRelateEntity();
            relateEntity.set合議体情報Entity(entity);
            gogitaiNoList.add(new GogitaiJoho(relateEntity));
        }
        return SearchResult.of(gogitaiNoList, 0, false);
    }

}
