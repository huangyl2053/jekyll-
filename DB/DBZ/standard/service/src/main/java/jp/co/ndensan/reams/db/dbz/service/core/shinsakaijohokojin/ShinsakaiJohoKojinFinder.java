/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shinsakaijohokojin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaijohokojin.WariateIinAndIinJoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shinsakaijohokojin.ShinsakaiJohoKojinMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.KaisaiKekkaAndBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.WariateIinAndIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaijohokojin.IShinsakaiJohoKojinMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会情報照会(個人)のクラスです。
 *
 * @reamsid_L DBE-3000-070 zhengshukai
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
     * @param 介護認定審査会開催番号 RString
     * @return KaisaiKekkaAndBashoJohoEntity
     */
    public KaisaiKekkaAndBashoJohoEntity onLoad1(ShinseishoKanriNo 申請書管理番号, RString 介護認定審査会開催番号) {
        IShinsakaiJohoKojinMapper mapper = mapperProvider.create(IShinsakaiJohoKojinMapper.class);
        KaisaiKekkaAndBashoJohoEntity entity = mapper.getKaisaikekkaandbashojoho(申請書管理番号, 介護認定審査会開催番号);
        if (entity == null) {
            entity = new KaisaiKekkaAndBashoJohoEntity();
        }
        return entity;
    }

    /**
     * 審査会委員情報を取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会開催年月日 審査会開催年月日
     * @return WariateIinAndIinJohoEntity
     */
    public List<WariateIinAndIinJoho> onLoad2(int 合議体番号, RString 介護認定審査会開催番号, FlexibleDate 介護認定審査会開催年月日) {
        IShinsakaiJohoKojinMapper mapper = mapperProvider.create(IShinsakaiJohoKojinMapper.class);
        List<WariateIinAndIinJohoEntity> shinsakaijlist = mapper.getShinsakaijyouhou(ShinsakaiJohoKojinMapperParameter.
                createParam(合議体番号, 介護認定審査会開催番号, 介護認定審査会開催年月日));

        List<WariateIinAndIinJoho> list = new ArrayList<>();
        for (WariateIinAndIinJohoEntity entity : shinsakaijlist) {
            WariateIinAndIinJoho business = new WariateIinAndIinJoho(entity);
            list.add(business);
        }
        return list;
    }

    /**
     * 補欠委員情報を取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会開催年月日 介護認定審査会開催年月日
     * @return WariateIinAndIinJohoEntity
     */
    public List<WariateIinAndIinJoho> onLoad3(int 合議体番号, RString 介護認定審査会開催番号, FlexibleDate 介護認定審査会開催年月日) {
        IShinsakaiJohoKojinMapper mapper = mapperProvider.create(IShinsakaiJohoKojinMapper.class);
        List<WariateIinAndIinJohoEntity> kaijyouhoulist = mapper.getHoketsukaijyouhou(ShinsakaiJohoKojinMapperParameter.
                createParam(合議体番号, 介護認定審査会開催番号, 介護認定審査会開催年月日));

        List<WariateIinAndIinJoho> list = new ArrayList<>();
        for (WariateIinAndIinJohoEntity entity : kaijyouhoulist) {
            WariateIinAndIinJoho business = new WariateIinAndIinJoho(entity);
            list.add(business);
        }
        return list;
    }
}
