/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.KaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.KaisaiYoteiJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.KaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催予定情報クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class ShiryoShinsakaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShiryoShinsakaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    ShiryoShinsakaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShiryoShinsakaiFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShiryoShinsakaiFinder}のインスタンス
     */
    public static ShiryoShinsakaiFinder createInstance() {
        return InstanceProvider.create(ShiryoShinsakaiFinder.class);
    }

    /**
     * 審査会自動割付を検索します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @return KaisaiYoteiJohoBusiness
     */
    @Transaction
    public KaisaiYoteiJohoBusiness get開催予定情報(RString 審査会開催番号) {
        KaisaiYoteiJohoMyBatisParameter parametere = new KaisaiYoteiJohoMyBatisParameter(審査会開催番号);
        IShiryoShinsakaiIinMapper mapper = mapperProvider.create(IShiryoShinsakaiIinMapper.class);
        KaisaiYoteiJohoEntity 開催予定情報 = mapper.get開催予定情報(parametere);
        if (開催予定情報 == null) {
            return null;
        }
        return new KaisaiYoteiJohoBusiness(開催予定情報);
    }

    /**
     * 申請書管理番号を指定して履歴番号が最大の認定調査票概況調査情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return NinteichosahyoGaikyoChosa
     */
    @Transaction
    public NinteichosahyoGaikyoChosa get認定調査票概況調査(ShinseishoKanriNo 申請書管理番号) {
        IShiryoShinsakaiIinMapper mapper = mapperProvider.create(IShiryoShinsakaiIinMapper.class);
        DbT5202NinteichosahyoGaikyoChosaEntity 認定調査票概況調査Entity = mapper.get認定調査票概況調査(申請書管理番号);
        if (認定調査票概況調査Entity == null) {
            return null;
        }
        return new NinteichosahyoGaikyoChosa(認定調査票概況調査Entity);
    }
}
