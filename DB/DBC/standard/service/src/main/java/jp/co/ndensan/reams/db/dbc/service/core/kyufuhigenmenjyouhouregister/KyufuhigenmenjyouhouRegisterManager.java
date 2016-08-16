/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufuhigenmenjyouhouregister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouRegisterResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister.GenmenJyouhouParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouregisterParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhigenmenjyouhouregister.KyufuJissekiJyouhouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouRegisterEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufuhigenmenjyouhouregister.Ikyufuhigenmenjyouhouregister;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBCMN71001_給付費通知減免情報補正登録クラスです。
 *
 * @reamsid_L DBC-2260-030 xuyongchao
 */
public class KyufuhigenmenjyouhouRegisterManager {

    private final MapperProvider mapperProvider;
    private static final RString REPLACED_MESSAGE = new RString("parameter");
    private static final RString STATE_INSERT = new RString("insert");
    private static final RString STATE_UPDATE = new RString("update");
    private static final RString STATE_DELETE = new RString("delete");

    /**
     * コンストラクタです。
     */
    KyufuhigenmenjyouhouRegisterManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac dac
     * @param MapperProvider mapperProvider
     */
    KyufuhigenmenjyouhouRegisterManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuhigenmenjyouhouRegisterManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyufuhigenmenjyouhouRegisterManager}のインスタンス
     */
    public static KyufuhigenmenjyouhouRegisterManager createInstance() {
        return InstanceProvider.create(KyufuhigenmenjyouhouRegisterManager.class);
    }

    /**
     * 減免補正情報の取得。
     *
     * @param parameter KyufuhigenmenjyouhouregisterParameter
     * @return SearchResult<KyufuhigenmenjyouhouRegisterResult> 減免補正情報
     */
    @Transaction
    public SearchResult<KyufuhigenmenjyouhouRegisterResult> getHihokenshaDaichoSakusei(KyufuhigenmenjyouhouregisterParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        Ikyufuhigenmenjyouhouregister mapper = mapperProvider.create(Ikyufuhigenmenjyouhouregister.class);
        List<KyufuhigenmenjyouhouRegisterEntity> entityList = mapper.getGenmenJyouhou(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<KyufuhigenmenjyouhouRegisterResult>emptyList(), 0, false);
        }
        List<KyufuhigenmenjyouhouRegisterResult> businessList = new ArrayList<>();
        for (KyufuhigenmenjyouhouRegisterEntity entity : entityList) {
            businessList.add(new KyufuhigenmenjyouhouRegisterResult(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 減免補正情報の保存。
     *
     * @param parameter GenmenJyouhouParameter
     */
    @Transaction
    public void regGenmenJyouhou(GenmenJyouhouParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        Ikyufuhigenmenjyouhouregister mapper = mapperProvider.create(Ikyufuhigenmenjyouhouregister.class);
        if (parameter.getState().equals(STATE_INSERT)) {
            mapper.insertGenmenJyouhou(parameter);
        } else if (parameter.getState().equals(STATE_UPDATE)) {
            mapper.updateGenmenJyouhou(parameter);
        } else if (parameter.getState().equals(STATE_DELETE)) {
            mapper.deleteGenmenJyouhou(parameter);
        }
    }

    /**
     * 給付実績情報の存在。
     *
     * @param parameter GenmenJyouhouParameter
     * @return boolean boolean
     */
    @Transaction
    public boolean isKyufuJissekiJyouhou(GenmenJyouhouParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACED_MESSAGE.toString()));
        Ikyufuhigenmenjyouhouregister mapper = mapperProvider.create(Ikyufuhigenmenjyouhouregister.class);
        KyufuJissekiJyouhouEntity entity = mapper.checkKyufuJissekiJyouhou(parameter);
        return entity.is存在();
    }
}
