package jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho.kozajohopsm.KozaJohoPSM;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shiharaihohojyoho.KozaJohoPSMEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shiharaihohojyoho.IShiharaiHohoJyohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.mapper.IKozaRelateMapper;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 支払方法情報を取得するクラスです。
 *
 * @reamsid_L DBC-0300-020 houtianpeng
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

        IShiharaiHohoJyohoMapper mapper = mapperProvider.create(IShiharaiHohoJyohoMapper.class);
        List<KozaJohoPSM> 口座ID = new ArrayList<>();
        List<KozaJohoPSMEntity> entityList = mapper.get口座IDリストByKozaParameter(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(口座ID, 0, false);
        }
        for (KozaJohoPSMEntity entity : entityList) {
            口座ID.add(new KozaJohoPSM(entity));
        }
        return SearchResult.of(口座ID, 0, false);
    }

    /**
     * 口座IDで口座情報を取得します。
     *
     * @param parameter 口座ID
     * @return SearchResult<KozaJohoPSM>
     */
    public SearchResult<KozaJohoPSM> getKozaJyoho(KozaParameter parameter) {
        IShiharaiHohoJyohoMapper mapper = mapperProvider.create(IShiharaiHohoJyohoMapper.class);
        IKozaRelateMapper kozaMapper = mapperProvider.create(IKozaRelateMapper.class);
        List<KozaJohoPSMEntity> entityList = mapper.get口座情報ByKey(parameter);
        List<KozaJohoPSM> kozaJohoPSMList = new ArrayList<>();
        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        if (entityList != null && !entityList.isEmpty()) {
            kozaBuilder.set業務コード(entityList.get(0).getGyomuCode());
            kozaBuilder.setサブ業務コード(entityList.get(0).getSubGyomuCode());
            kozaBuilder.set科目コード(entityList.get(0).getKamokuCode());
            kozaBuilder.set用途区分(new KozaYotoKubunCodeValue(entityList.get(0).getYotoKubun() == null
                    ? Code.EMPTY : entityList.get(0).getYotoKubun()));
        }
        List<RString> 業務固有キーList = new ArrayList<>();
        List<KamokuCode> kamokuCodeList = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (KozaJohoPSMEntity entity : entityList) {
                kamokuCodeList.add(entity.getKamokuCode());
                業務固有キーList.add(entity.getGyomuKoyuKey());
                kozaBuilder.set業務固有キーリスト(業務固有キーList);
            }
        }
        KozaSearchParameter kozaSearchParameter = new KozaSearchParameter(kozaBuilder.build(), kamokuCodeList);
        List<KozaRelateEntity> kozaRelateList = null;
        if (kozaSearchParameter.has権限有科目()) {
            kozaRelateList = kozaMapper.select(kozaSearchParameter);
        }
        if (kozaRelateList == null) {
            KozaJohoPSMEntity psmEntity = new KozaJohoPSMEntity();
            kozaJohoPSMList.add(new KozaJohoPSM(psmEntity));
            return SearchResult.of(kozaJohoPSMList, 0, false);
        }
        for (KozaRelateEntity entity : kozaRelateList) {
            KozaJohoPSMEntity psmEntity = new KozaJohoPSMEntity();
            psmEntity.setKinyuKikanCode(entity.getUaT0310KozaEntity().getKinyuKikanCode());
            psmEntity.setKinyuKikanShitenCode(entity.getUaT0310KozaEntity().getKinyuKikanShitenCode());
            psmEntity.setTemban(entity.getUaT0310KozaEntity().getTemban());
            psmEntity.setYokinShubetsu(entity.getUaT0310KozaEntity().getYokinShubetsu());
            psmEntity.setKozaNo(entity.getUaT0310KozaEntity().getKozaNo());
            psmEntity.setKozaMeiginin(entity.getUaT0310KozaEntity().getKozaMeiginin());
            psmEntity.setKozaMeigininKanji(entity.getUaT0310KozaEntity().getKozaMeigininKanji());
            kozaJohoPSMList.add(new KozaJohoPSM(psmEntity));
        }
        return SearchResult.of(kozaJohoPSMList, 0, false);
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
