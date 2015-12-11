/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.DBE5210001;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author soft863
 */
public class ShinsakaiKaisaiKekkaManager {

    private final MapperProvider mapperProvider;
    private final DbT5511ShinsakaiKaisaiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiKekkaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT5511ShinsakaiKaisaiKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    ShinsakaiKaisaiKekkaManager(
            DbT5511ShinsakaiKaisaiKekkaJohoDac dac,
            MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成したのインスタンス
     */
    public static ShinsakaiKaisaiKekkaManager createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiKekkaManager.class);
    }

    //    /**
    //     * ヘッドエリア内容を特定して取得します。
    //     *
    //     * @param  ヘッドエリア内容パラメータ
    //     * @return ヘッドエリア内容
    //     */
    //    @Transaction
//     public   getヘッドエリア内容検索(ShinsakaiMapperParameter parameter) {
//        ShinsakaiMapper mapper = mapperProvider.create(ShinsakaiMapper.class);
//
//        List<ShinsakaiKaisaiKekkaEntity>  Entity = mapper.getShinsakaiKaisaiKekkaEntity(parameter);
//        if (Entity == null) {
//            return null;
//        }
//        return Entity;
//    }
    /**
     * // * 審査会委員一覧を特定して取得します。 // * // * @param 審査会委員一覧パラメータ // * @return 審査会委員一覧検索 //
     */
    //    @Transaction
    //public  List<>  get審査会委員一覧検索(ShinsakaiMapperParameter parameter) {
//        ShinsakaiMapper mapper = mapperProvider.create(ShinsakaiMapper.class);
//
//        List<ShinsakaiIinTorokuEntity>  shinsakaiEntity = mapper.getShinsakaiIinTorokuEntity(parameter);
//        if (shinsakaiEntity == null) {
//            return null;
//        }
//        return shinsakaiEntity;
//    }
    /**
     * 介護認定審査会開催結果情報{@link ShinsakaiKaisaiKekkaJoho}を保存します。
     *
     * @param 介護認定審査会開催結果情報 {@link ShinsakaiKaisaiKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会開催結果情報(ShinsakaiKaisaiKekkaJoho 介護認定審査会開催結果情報) {
        requireNonNull(介護認定審査会開催結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催結果情報"));
        if (!介護認定審査会開催結果情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会開催結果情報.toEntity());
    }

}
