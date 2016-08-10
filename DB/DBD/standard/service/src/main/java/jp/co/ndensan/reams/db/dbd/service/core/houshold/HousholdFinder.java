/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.houshold;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold.HousholdParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.houshold.HousholdEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.houshold.IHousholdMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 非課税年金対象者情報登録のデータアクセスクラスです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
public class HousholdFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    HousholdFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * FinderのIntanceを作成します。
     *
     * @return HousholdFinder
     */
    public static HousholdFinder createIntance() {
        return InstanceProvider.create(HousholdFinder.class);
    }

    /**
     * 引数により、非課税年金検索する。
     *
     * @param 年度 年度
     * @param 被保険者番号 被保険者番号
     * @param 対象年 対象年
     * @param 年金保険者コード 年金保険者コード
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @return 非課税年金対象情報List
     */
    @Transaction
    public List<HousholdBusiness> getLastInputHousehold(FlexibleYear 年度, HihokenshaNo 被保険者番号,
            RString 対象年, RString 年金保険者コード, RString 基礎年金番号, RString 年金コード) {
        HousholdParameter para = new HousholdParameter(年度, 被保険者番号, 対象年, 年金保険者コード, 基礎年金番号, 年金コード);
        IHousholdMapper mapper = mapperProvider.create(IHousholdMapper.class);
        List<HousholdBusiness> 非課税年金対象情報BusinessList = new ArrayList<>();
        List<HousholdEntity> 非課税年金対象情報List = mapper.非課税年金対象情報取得(para);
        for (HousholdEntity 非課税年金対象情報 : 非課税年金対象情報List) {
            非課税年金対象情報BusinessList.add(new HousholdBusiness(非課税年金対象情報));
        }
        return 非課税年金対象情報BusinessList;
    }

}
