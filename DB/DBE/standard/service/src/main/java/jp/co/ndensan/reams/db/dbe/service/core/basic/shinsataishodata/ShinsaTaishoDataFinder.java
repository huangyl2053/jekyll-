/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.shinsataishodata;

import jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput.ISaikaiObjectOutPutBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.SaikaiObjectOutPutEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput.IShinsaTaishoDataOutPutMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会審査対象データ出力（モバイル）のクラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public class ShinsaTaishoDataFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShinsaTaishoDataFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ShinsaTaishoDataFinder(MapperProvider mapperProvider
    ) {
        this.mapperProvider = mapperProvider;

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsaTaishoDataFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsaTaishoDataFinder}のインスタンス
     */
    public static ShinsaTaishoDataFinder createInstance() {
        return InstanceProvider.create(ShinsaTaishoDataFinder.class);
    }

    /**
     * 審査対象取得
     *
     * @param kaisaiBangou kaisaiBangou
     * @return NijihanteiKekkaTorokuMobileRelateEntity
     */
    public ISaikaiObjectOutPutBusiness get審査対象Entity(RString kaisaiBangou) {
        IShinsaTaishoDataOutPutMapper mapper = mapperProvider.create(IShinsaTaishoDataOutPutMapper.class);
        SaikaiObjectOutPutEntity entity = mapper.get審査対象(kaisaiBangou);
        ISaikaiObjectOutPutBusiness business = new ISaikaiObjectOutPutBusiness();
        business.set申請書管理番号(entity.get申請書管理番号());
        business.set被保険者番号(entity.get被保険者番号());
        business.setイメージ共有ファイルID(entity.getイメージ共有ファイルID());
        business.set証記載保険者番号(entity.get証記載保険者番号());
        return business;
    }
}
