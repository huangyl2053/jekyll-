/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shinnendokanrijohosakuseifinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.entity.db.basic.noki.nokikanri.UrT0729NokiKanriEntity;
import jp.co.ndensan.reams.ur.urc.persistence.db.mapper.noki.nokikanri.INokiKanriMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBB9010001_新年度管理情報作成のハンドラクラスです。
 *
 * @reamsid_L DBB-5721-010 chenyadong
 */
public class ShinNendoKanriJohoSakuseiFinder {

    private final MapperProvider mapperProvider;

    ShinNendoKanriJohoSakuseiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    ShinNendoKanriJohoSakuseiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaiHakkoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SaiHakkoFinder}のインスタンス
     */
    public static ShinNendoKanriJohoSakuseiFinder createInstance() {
        return InstanceProvider.create(ShinNendoKanriJohoSakuseiFinder.class);
    }

    /**
     * 再発行対象取得
     *
     * @param 調定年度 HashMap<String, Object>
     * @return 再発行対象リスト
     */
    public List<Noki> getShinNendoKanriJohoSakusei(HashMap<String, Object> 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        List<Noki> businessList = new ArrayList<>();
        INokiKanriMapper mapper = mapperProvider.create(INokiKanriMapper.class);
        List<UrT0729NokiKanriEntity> 再発行対象リスト = mapper.selectBy調定年度(調定年度);
        if (再発行対象リスト != null && !再発行対象リスト.isEmpty()) {
            for (UrT0729NokiKanriEntity entity : 再発行対象リスト) {
                Noki 再発行対象 = new Noki(entity);
                businessList.add(再発行対象);
            }
        } else {
            return null;
        }
        return businessList;
    }

}
