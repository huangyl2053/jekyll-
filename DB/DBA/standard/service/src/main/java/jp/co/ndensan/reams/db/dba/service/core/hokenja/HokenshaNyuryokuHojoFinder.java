/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hokenja;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hokenja.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokenja.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokenja.HokenjaMapperParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hokenja.HokenjaMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoSearchShurui;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJusho;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.hokenja.UrT0507HokenjaDac;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.zenkokujusho.UrT0101ZenkokuJushoDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 保険者情報を管理するサービスクラスです。
 */
public class HokenshaNyuryokuHojoFinder {

    private final UrT0101ZenkokuJushoDac urT0101Dac;
    private final UrT0507HokenjaDac urT0507Dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    HokenshaNyuryokuHojoFinder() {
        this.urT0101Dac = InstanceProvider.create(UrT0101ZenkokuJushoDac.class);
        this.urT0507Dac = InstanceProvider.create(UrT0507HokenjaDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param UrT0101ZenkokuJushoDac urT0101Dac
     * @param UrT0507HokenjaDac urT0507Dac
     * @paramMapperProvider mapperProvider
     */
    HokenshaNyuryokuHojoFinder(UrT0101ZenkokuJushoDac urT0101Dac, UrT0507HokenjaDac urT0507Dac, MapperProvider mapperProvider) {
        this.urT0101Dac = urT0101Dac;
        this.urT0507Dac = urT0507Dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HokenshaNyuryokuHojoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HokenshaNyuryokuHojoFinder}のインスタンス
     */
    public static HokenshaNyuryokuHojoFinder createInstance() {
        return InstanceProvider.create(HokenshaNyuryokuHojoFinder.class);
    }

    /**
     * 保険者情報を特定して取得します。
     *
     * @param parameter 保険者情報のパラメータ
     * @return 保険者情報Entity（Hokensha）
     */
    public Hokensha getHokensha(HokenjaMapperParameter parameter) {
        UrT0507HokenjaEntity entity = urT0507Dac.selectByKey(parameter.getHokenjaNo(), new HokenjaShubetsu(new RString("08")));
        if (entity == null) {
            return null;
        }
        return new Hokensha(entity);
    }

    /**
     * 県コード取得リストを取得します。
     *
     * @return List<KenCodeJigyoshaInputGuide> 県コード取得リスト
     */
    public List<KenCodeJigyoshaInputGuide> getKenCodeJigyoshaInputGuide() {
        List<KenCodeJigyoshaInputGuide> kenCodeList = new ArrayList<>();
        List<UrT0101ZenkokuJushoEntity> urT0101List = urT0101Dac.select(
                and(not(eq(UrT0101ZenkokuJusho.isDeleted, true)), eq(UrT0101ZenkokuJusho.dataKubun, ZenkokuJushoSearchShurui.都道府県.getDataKubun())));
        if (urT0101List == null || urT0101List.isEmpty()) {
            return kenCodeList;
        }
        for (UrT0101ZenkokuJushoEntity entity : urT0101List) {
            kenCodeList.add(new KenCodeJigyoshaInputGuide(entity));
        }
        return kenCodeList;
    }

    //TODO QA No.29
    /**
     * 保険者情報リストを取得します。
     *
     * @param parameter 保険者情報のパラメータ
     * @return List<KenCodeJigyoshaInputGuide> 保険者情報リスト
     */
    public List<Hokensha> getHokenshaList(HokenjaMapperParameter parameter) {
        List<Hokensha> hokenshaList = new ArrayList<>();
        HokenjaMapper hokenjamapper = mapperProvider.create(HokenjaMapper.class);
        List<UrT0507HokenjaEntity> entitylist = hokenjamapper.getHokenshaList(parameter);
        if (entitylist == null || entitylist.isEmpty()) {
            return hokenshaList;
        }
        for (UrT0507HokenjaEntity entity : entitylist) {
            hokenshaList.add(new Hokensha(entity));
        }
        return hokenshaList;
    }
}
