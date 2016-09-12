package jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shiharaihohojyoho.IShiharaiHohoJyohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.authority.AuthorityKind;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
     * @return SearchResult<Koza>
     */
    public SearchResult<Koza> getKozaIDList(KozaParameter parameter) {

        requireNonNull(parameter.getShikibetsuCode(), UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        if (parameter.getShikibetsuCode().isEmpty()) {
            throw new IllegalArgumentException("引数の識別コードには空以外を指定してください。");
        }
        IShunoKamoku shunoKamoku = ShunoKamokuFinder.createInstance().get科目(parameter.getKamokuCode());
        if (shunoKamoku == null) {
            throw new ApplicationException("科目情報の取得に失敗しました。");
        }
        List<Koza> 口座ID = new ArrayList<>();
        KozaSearchKeyBuilder keyBuilder = new KozaSearchKeyBuilder();
        keyBuilder.set業務コード(GyomuCode.DB介護保険);
        keyBuilder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        keyBuilder.set科目コード(shunoKamoku.getコード());
        keyBuilder.set識別コード(parameter.getShikibetsuCode());
        List<Koza> kozaList = KozaService.createKozaManager(AuthorityKind.参照権限収納科目).get口座(keyBuilder.build());
        if (kozaList == null || kozaList.isEmpty()) {
            return SearchResult.of(口座ID, 0, false);
        }
        return SearchResult.of(kozaList, 0, false);
    }

    /**
     * 口座IDで口座情報を取得します。
     *
     * @param parameter 口座ID
     * @return SearchResult<Koza>
     */
    public SearchResult<Koza> getKozaJyoho(KozaParameter parameter) {
        KozaSearchKeyBuilder kozaBuilder = new KozaSearchKeyBuilder();
        kozaBuilder.set業務コード(GyomuCode.DB介護保険);
        kozaBuilder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        kozaBuilder.set口座ID(parameter.getKozaId());
        List<Koza> kozaList = new ArrayList<>();
        List<Koza> koza = KozaService.createKozaManager(AuthorityKind.参照権限収納科目).get口座(kozaBuilder.build());
        if (koza == null || koza.isEmpty()) {
            return SearchResult.of(kozaList, 0, false);
        }
        return SearchResult.of(koza, 0, false);
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
