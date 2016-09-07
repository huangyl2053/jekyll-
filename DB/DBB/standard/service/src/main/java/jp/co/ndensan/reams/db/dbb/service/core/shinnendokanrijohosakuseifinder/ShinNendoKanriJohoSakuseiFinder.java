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
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shinnendokanrijohosakusei.ShinNendoKanriJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shinnendokanrijohosakusei.IShinNendoKanriJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBB9010001_新年度管理情報作成のハンドラクラスです。
 *
 * @reamsid_L DBB-5721-010 chenyadong
 */
public class ShinNendoKanriJohoSakuseiFinder {

    private final MapperProvider mapperProvider;
    private static final RString 年度_KEY = new RString("effectiveDate");

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
     * @param paramter HashMap<String, Object>
     * @return 再発行対象リスト
     */
    public List<ShinNendoKanriJohoSakuseiEntity> getShinNendoKanriJohoSakusei(HashMap<String, Object> paramter) {
        requireNonNull(paramter, UrSystemErrorMessages.値がnull.getReplacedMessage("paramter"));
        List<ShinNendoKanriJohoSakuseiEntity> businessList = new ArrayList<>();
        IShinNendoKanriJohoSakuseiMapper mapper = mapperProvider.create(IShinNendoKanriJohoSakuseiMapper.class);
        List<ShinNendoKanriJohoSakuseiEntity> 再発行対象リスト = mapper.selectカスタムコンフィグByKey(paramter);
        if (再発行対象リスト != null && !再発行対象リスト.isEmpty()) {
            for (ShinNendoKanriJohoSakuseiEntity entity : 再発行対象リスト) {
                entity.setEffectiveDate(new RDate(paramter.get(年度_KEY.toString()).toString()).plusYear(1));
                businessList.add(entity);
            }
        } else {
            return null;
        }
        return businessList;
    }

}
