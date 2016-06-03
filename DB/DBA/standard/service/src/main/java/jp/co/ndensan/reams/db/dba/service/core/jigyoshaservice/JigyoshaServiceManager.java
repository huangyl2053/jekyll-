/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jigyoshaservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jigyoshaservice.JigyoshaServiceJoho;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT7130KaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護事業者指定サービス情報を物理削除します。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class JigyoshaServiceManager {

    private static final int 提供開始年月 = 6;
    private final DbT7063KaigoJigyoshaShiteiServiceDac dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public JigyoshaServiceManager() {
        dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7063KaigoJigyoshaShiteiServiceDac}
     */
    JigyoshaServiceManager(DbT7063KaigoJigyoshaShiteiServiceDac dac, MapperProvider mapperProvider) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JigyoshaServiceManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JigyoshaServiceManager}のインスタンス
     */
    public static JigyoshaServiceManager createInstance() {
        return InstanceProvider.create(JigyoshaServiceManager.class);
    }

    /**
     * 介護事業者指定サービス情報を物理削除します。
     *
     * @param joho 物理削除のデータ
     * @return 削除結果
     */
    public boolean 情報を物理削除(KaigoJigyoshaShiteiService joho) {
        joho = joho.deleted();
        return 1 == dac.delete(joho.toEntity());
    }

    /**
     * サービス種類ドロップダウンリストの取得します。
     *
     * @return SearchResult<JigyoshaServiceJoho>
     */
    public SearchResult<JigyoshaServiceJoho> getserviceShuruiCdDDL() {
        List<JigyoshaServiceJoho> jigyoshaServiceJohoList = new ArrayList<>();
        IDbT7130KaigoServiceShuruiMapper mapper = mapperProvider.create(IDbT7130KaigoServiceShuruiMapper.class);
        List<DbT7130KaigoServiceShuruiEntity> entityList = mapper.getserviceShuruiCdDDL(new RString(
                FlexibleDate.getNowDate().toString().substring(0, 提供開始年月)));
        for (DbT7130KaigoServiceShuruiEntity entity : entityList) {
            jigyoshaServiceJohoList.add(new JigyoshaServiceJoho(entity));
        }
        return SearchResult.of(jigyoshaServiceJohoList, 0, false);
    }

}
