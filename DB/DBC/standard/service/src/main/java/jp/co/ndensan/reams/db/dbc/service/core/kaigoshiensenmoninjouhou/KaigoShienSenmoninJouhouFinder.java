/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kaigoshiensenmoninjouhou;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigoshiensenmoninjouhou.IKaigoShienSenmoninJouhouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護支援専門員登録画面 Finderクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoShienSenmoninJouhouFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KaigoShienSenmoninJouhouFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KaigoShienSenmoninJouhouFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInKouhiFutann}のインスタンス
     */
    public static KaigoShienSenmoninJouhouFinder createInstance() {
        return InstanceProvider.create(KaigoShienSenmoninJouhouFinder.class);
    }

    /**
     * 介護支援専門員情報を取得します。
     *
     * @param param KaigoShienSenmoninJouhouParameter
     * @return KaigoShienSenmoninJouhouResultのリスト
     */
    @Transaction
    public List<KaigoShienSenmoninJouhouResult> get介護支援専門員情報(KaigoShienSenmoninJouhouParameter param) {
        IKaigoShienSenmoninJouhouMapper mapper = mapperProvider.create(IKaigoShienSenmoninJouhouMapper.class);
        List<KaigoShienSenmoninJouhouEntity> entityList = mapper.select介護支援専門員情報(param);
        List<KaigoShienSenmoninJouhouResult> resultList = new ArrayList<>();
        if (null != entityList) {
            for (KaigoShienSenmoninJouhouEntity entity : entityList) {
                resultList.add(new KaigoShienSenmoninJouhouResult(entity.getCareManegerentity(),
                        entity.getShozokuJigyoshaNo(), entity.getShozokuJigyoshaMei()));
            }
        }
        return resultList;
    }

    /**
     * 介護支援専門員番号の重複チェックを取得します。
     *
     * @param param KaigoShienSenmoninJouhouParameter
     * @return int
     */
    @Transaction
    public int get介護支援専門員番号の重複チェック(KaigoShienSenmoninJouhouParameter param) {
        IKaigoShienSenmoninJouhouMapper mapper = mapperProvider.create(IKaigoShienSenmoninJouhouMapper.class);
        return mapper.select介護支援専門員番号の重複チェック(param);
    }
}
