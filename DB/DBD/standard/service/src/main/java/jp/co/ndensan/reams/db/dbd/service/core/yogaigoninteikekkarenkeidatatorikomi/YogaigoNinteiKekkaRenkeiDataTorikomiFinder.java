/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.yogaigoninteikekkarenkeidatatorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT7202KaigoNinteiHokaiseiKanriMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author x_miaojin
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomiFinder {

    private final MapperProvider mapperProvider;

    YogaigoNinteiKekkaRenkeiDataTorikomiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    YogaigoNinteiKekkaRenkeiDataTorikomiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YogaigoNinteiKekkaRenkeiDataTorikomiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YogaigoNinteiKekkaRenkeiDataTorikomiFinder}のインスタンス
     */
    public static YogaigoNinteiKekkaRenkeiDataTorikomiFinder createInstance() {
        return InstanceProvider.create(YogaigoNinteiKekkaRenkeiDataTorikomiFinder.class);
    }

    /**
     * 法改正施行年月日をを取得します。
     *
     * @return List<FlexibleDate>
     */
    public List<FlexibleDate> get法改正施行年月日() {
        List<FlexibleDate> 法改正施行年月日list = new ArrayList<>();
        List<DbT7202KaigoNinteiHokaiseiKanriEntity> entityList = mapperProvider.create(
                IDbT7202KaigoNinteiHokaiseiKanriMapper.class).select法改正施行年月日();
        if (法改正施行年月日list != null && !法改正施行年月日list.isEmpty()) {
            for (DbT7202KaigoNinteiHokaiseiKanriEntity entity : entityList) {
                法改正施行年月日list.add(entity.getHokaiseiShikoYMD());
            }
        }
        return 法改正施行年月日list;
    }
}
