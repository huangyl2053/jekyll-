/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shinsakaijohokojin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.shinsakaijohokojin.WariateIinAndIinJoho;
import jp.co.ndensan.reams.db.dbz.definition.param.shinsakaijohokojin.ShinsakaiJohoKojinMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.KaisaiKekkaAndBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.WariateIinAndIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaijohokojin.IShinsakaiJohoKojinMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会情報照会(個人)のクラスです。
 */
public class ShinsakaiJohoKojinFinder {

    private final MapperProvider mapperProvider;
    private final DbT5502ShinsakaiWariateJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiJohoKojinFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     * @param dac {@link DbT5502ShinsakaiWariateJohoDac}
     */
    ShinsakaiJohoKojinFinder(MapperProvider mapperProvider, DbT5502ShinsakaiWariateJohoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiJohoKojinFinder}のインスタンスを返します。
     *
     * @return ShinsakaiJohoKojinFinder
     */
    public static ShinsakaiJohoKojinFinder createInstance() {
        return InstanceProvider.create(ShinsakaiJohoKojinFinder.class);
    }

    /**
     * 審査会未割当入力チェックです。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 情報件数
     */
    public int 審査会未割当チェック(ShinseishoKanriNo 申請書管理番号) {
        return dac.getcount(申請書管理番号);
    }

    /**
     * 開催結果情報と開催場所情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return KaisaiKekkaAndBashoJohoEntity
     */
    public KaisaiKekkaAndBashoJohoEntity onLoad1(ShinseishoKanriNo 申請書管理番号) {
        IShinsakaiJohoKojinMapper mapper = mapperProvider.create(IShinsakaiJohoKojinMapper.class);
        return mapper.getKaisaikekkaandbashojoho(申請書管理番号);
    }

    /**
     * 審査会委員情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return WariateIinAndIinJohoEntity
     */
    public List<WariateIinAndIinJoho> onLoad2(ShinseishoKanriNo 申請書管理番号) {
        IShinsakaiJohoKojinMapper mapper = mapperProvider.create(IShinsakaiJohoKojinMapper.class);
        List<WariateIinAndIinJoho> list = new ArrayList<>();
        KaisaiKekkaAndBashoJohoEntity kaisaientity = onLoad1(申請書管理番号);
        List<WariateIinAndIinJohoEntity> shinsakaijlist = mapper.getShinsakaijyouhou(ShinsakaiJohoKojinMapperParameter.
                createParam(kaisaientity.get合議体番号(), kaisaientity.get介護認定審査会開催番号(), FlexibleDate.getNowDate()));
        for (WariateIinAndIinJohoEntity entity : shinsakaijlist) {
            WariateIinAndIinJoho business = new WariateIinAndIinJoho(entity);
            list.add(business);
        }
        return list;
    }

    /**
     * 補欠委員情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return WariateIinAndIinJohoEntity
     */
    public List<WariateIinAndIinJoho> onLoad3(ShinseishoKanriNo 申請書管理番号) {
        IShinsakaiJohoKojinMapper mapper = mapperProvider.create(IShinsakaiJohoKojinMapper.class);
        List<WariateIinAndIinJoho> list = new ArrayList<>();
        KaisaiKekkaAndBashoJohoEntity kaisaientity = onLoad1(申請書管理番号);
        List<WariateIinAndIinJohoEntity> kaijyouhoulist = mapper.getHoketsukaijyouhou(ShinsakaiJohoKojinMapperParameter.
                createParam(kaisaientity.get合議体番号(), kaisaientity.get介護認定審査会開催番号(), FlexibleDate.getNowDate()));
        for (WariateIinAndIinJohoEntity entity : kaijyouhoulist) {
            WariateIinAndIinJoho business = new WariateIinAndIinJoho(entity);
            list.add(business);
        }
        return list;
    }
}
