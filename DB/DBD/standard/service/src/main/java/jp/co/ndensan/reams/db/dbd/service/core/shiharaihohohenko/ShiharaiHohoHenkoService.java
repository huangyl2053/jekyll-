/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShokanHaraiShikyu;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.JukyushaSogoJigyoTaishoshaHantei;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShokanHaraiShikyuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenko.IShiharaiHohoHenkoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更管理（画面）のビジネスクラスです。
 *
 * @reamsid_L DBD-3620-070 xuyue
 */
public class ShiharaiHohoHenkoService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShiharaiHohoHenkoService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 支払方法変更管理（画面）のビジネスのIntanceを作成します。
     *
     * @return ShakaiFukushiHojinKeigenFinder
     */
    public static ShiharaiHohoHenkoService createIntance() {
        return InstanceProvider.create(ShiharaiHohoHenkoService.class);
    }

    /**
     * 支払方法変更管理情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 支払方法変更管理情報List
     */
    public ArrayList<ShiharaiHohoHenko> find支払方法変更(HihokenshaNo 被保険者番号) {
        ArrayList<ShiharaiHohoHenko> 支払方法変更管理情報List = new ArrayList<>();

        IShiharaiHohoHenkoMapper mapper = mapperProvider.create(IShiharaiHohoHenkoMapper.class);
        List<ShiharaiHohoHenkoEntity> entityList = mapper.findShiharaiHohoHenko(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (ShiharaiHohoHenkoEntity entity : entityList) {
                entity.initializeMd5ToEntities();
                支払方法変更管理情報List.add(new ShiharaiHohoHenko(entity));
            }
        }
        return 支払方法変更管理情報List;
    }

    /**
     * 支払方法変更管理情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 支払方法変更管理情報List
     */
    public ArrayList<ShiharaiHohoHenko> find支払方法変更Ignore論理削除(HihokenshaNo 被保険者番号) {
        ArrayList<ShiharaiHohoHenko> 支払方法変更管理情報List = new ArrayList<>();

        IShiharaiHohoHenkoMapper mapper = mapperProvider.create(IShiharaiHohoHenkoMapper.class);
        List<ShiharaiHohoHenkoEntity> entityList = mapper.findShiharaiHohoHenkoIgnoreDelete(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (ShiharaiHohoHenkoEntity entity : entityList) {
                entity.initializeMd5ToEntities();
                支払方法変更管理情報List.add(new ShiharaiHohoHenko(entity));
            }
        }
        return 支払方法変更管理情報List;
    }

    /**
     * 償還払支給情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 支払方法変更管理情報List
     */
    public ArrayList<ShokanHaraiShikyu> find償還払い支給(HihokenshaNo 被保険者番号) {
        ArrayList<ShokanHaraiShikyu> 償還払支給申請List = new ArrayList<>();
        IShiharaiHohoHenkoMapper mapper = mapperProvider.create(IShiharaiHohoHenkoMapper.class);
        List<ShokanHaraiShikyuEntity> entityList = mapper.find償還払支給申請(被保険者番号);
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanHaraiShikyuEntity entity : entityList) {
                償還払支給申請List.add(new ShokanHaraiShikyu(entity));
            }
        }
        return 償還払支給申請List;
    }

    /**
     * 支払方法変更管理画面で入力された支払方法変更管理情報を保存します。
     *
     * @param 支払方法変更の情報List 支払方法変更管理情報List
     */
    @Transaction
    public void save支払方法変更(List<ShiharaiHohoHenko> 支払方法変更の情報List) {
        ShiharaiHohoHenkoManager manager = ShiharaiHohoHenkoManager.createInstance();
        for (ShiharaiHohoHenko 支払方法変更 : 支払方法変更の情報List) {
            manager.save(支払方法変更);
        }
    }

    /**
     * 基準日時点で指定の被保険者が受給者もしくは事業対象者かを判定して返却します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return 受給者・事業対象者の判定結果
     */
    public boolean is受給者Or事業対象者(HihokenshaNo 被保険者番号, FlexibleDate 基準日) {
        IShiharaiHohoHenkoMapper mapper = mapperProvider.create(IShiharaiHohoHenkoMapper.class);
        JukyushaSogoJigyoTaishoshaHantei 判定Entity = mapper.get受給者or事業対象者の判定(被保険者番号, 基準日);
        return 判定Entity.is受給者() || 判定Entity.is総合事業対象者();
    }
}
