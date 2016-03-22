package jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho.KozaJohoPSM.KozaJohoPSM;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shiharaihohojyoho.KozaJohoPSMEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shiharaihohojyoho.IShiharaiHohoJyohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 支払方法情報を取得するクラスです。
 */
public class ShiharaiHohoJyohoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShiharaiHohoJyohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoJyohoFinder}のインスタンスを返します。
     *
     * @return ShiharaiHohoJyohoFinder
     */
    public static ShiharaiHohoJyohoFinder createInstance() {
        return InstanceProvider.create(ShiharaiHohoJyohoFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link MapperProvider}
     */
    ShiharaiHohoJyohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 口座情報パラメータで口座IDリストを取得します。
     *
     * @param parameter 口座情報パラメータ
     * @return SearchResult<KozaJoho>
     */
    public SearchResult<KozaJohoPSM> getKozaIDList(KozaParameter parameter) {

//        IShiharaiHohoJyohoMapper mapper = mapperProvider.create(IShiharaiHohoJyohoMapper.class);
        List<KozaJohoPSM> 口座ID = new ArrayList<>();
//        List<KozaJohoPSMEntity> entityList = mapper.get口座IDリストByKozaParameter(parameter);
        List<KozaJohoPSMEntity> entityList = new ArrayList<>();
        KozaJohoPSMEntity entity1 = new KozaJohoPSMEntity();
        entity1.setKozaId(1L);
        entityList.add(entity1);
//        if (entityList == null || entityList.isEmpty()) {
//            return SearchResult.of(口座ID, 0, false);
//        }
        for (KozaJohoPSMEntity entity : entityList) {
            口座ID.add(new KozaJohoPSM(entity));
        }
        return SearchResult.of(口座ID, 0, false);
    }

    /**
     * 口座IDで口座情報を取得します。
     *
     * @param parameter 口座ID
     * @return SearchResult<KozaJoho>
     */
    public KozaJohoPSM getKozaJyoho(KozaParameter parameter) {
//        IShiharaiHohoJyohoMapper mapper = mapperProvider.create(IShiharaiHohoJyohoMapper.class);
//        UrT0715KozaEntity entity = mapper.get口座情報ByKey(parameter);
//        if (entity == null) {
//            return null;
//        }
//        KozaSearchKeyBuilder kozaSearchKey = new KozaSearchKeyBuilder();
//        kozaSearchKey.setGyomuCode(entity.getGyomuCode());
//        kozaSearchKey.setSubGyomuCode(entity.getSubGyomuCode());
//        kozaSearchKey.setKamokuCode(entity.getKamokuCode());
//        kozaSearchKey.setCodeShubetsu(entity.getGyomuKoyuKey());
//        kozaSearchKey.setYotoKubun(entity.getYotoKubun());
//        UrFt700FindKozaFunction kozaPsm = new UrFt700FindKozaFunction(kozaSearchKey);

//        UrFt700FindKozaFunction.PSM_KEY, kozaPsm.toString();
        KozaJohoPSMEntity entity = new KozaJohoPSMEntity();
        entity.setKinyuKikanCode(new KinyuKikanCode(new RString("1234")));
        entity.setKinyuKikanShitenCode(new KinyuKikanShitenCode(new RString("456")));
        entity.setKinyuKikanMeisho(new RString("5555"));
        entity.setTemban(new RString("121"));
        entity.setYokinShubetsu(new RString("22"));
        entity.setKozaNo(new RString("11"));
        entity.setKozaMeiginin(new AtenaKanaMeisho("33"));
        entity.setKozaMeigininKanji(new AtenaMeisho(new RString("66")));
        return new KozaJohoPSM(entity);
    }

    /**
     * 契約事業者情報を取得します。
     *
     * @param parameter 契約事業者情報パラメータ
     * @return SearchResult<JuryoininKeiyakuJigyosha>
     */
    public JuryoininKeiyakuJigyosha getKeiyakuJigyosya(KeiyakushaParameter parameter) {
        IShiharaiHohoJyohoMapper mapper = mapperProvider.create(IShiharaiHohoJyohoMapper.class);
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = mapper.get契約事業者情報(parameter);
        if (entity == null) {
            return new JuryoininKeiyakuJigyosha(new DbT3077JuryoininKeiyakuJigyoshaEntity());
        }
        return new JuryoininKeiyakuJigyosha(entity);
    }
}
