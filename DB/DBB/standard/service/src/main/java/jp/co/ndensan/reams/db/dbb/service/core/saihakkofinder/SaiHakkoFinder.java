/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.saihakkofinder;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.saihakkofinder.SaiHakko;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.saihakkofinder.SaiHakkoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.saihakkofinder.ISaiHakkoFinderMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51001_所得照会票一括発行のクラス
 *
 * @reamsid_L DBB-1720-030 lijunjun
 */
public class SaiHakkoFinder {

    private final MapperProvider mapperProvider;

    SaiHakkoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    SaiHakkoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaiHakkoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SaiHakkoFinder}のインスタンス
     */
    public static SaiHakkoFinder createInstance() {
        return InstanceProvider.create(SaiHakkoFinder.class);
    }

    /**
     * 再発行対象取得
     *
     * @param 処理年度 RYear
     * @return 再発行対象リスト
     */
    public List<SaiHakko> getSaiHakko(RYear 処理年度) {
        if (処理年度 == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        List<SaiHakko> 再発行対象List = new ArrayList<>();
        ISaiHakkoFinderMapper mapper = mapperProvider.create(ISaiHakkoFinderMapper.class);
        List<SaiHakkoEntity> 再発行対象リスト = mapper.select再発行対象(処理年度);
        if (再発行対象リスト != null && !再発行対象リスト.isEmpty()) {
            for (SaiHakkoEntity entity : 再発行対象リスト) {
                SaiHakko 再発行対象 = new SaiHakko(entity);
                再発行対象List.add(再発行対象);
            }
        } else {
            return null;
        }
        return 再発行対象List;
    }
}
