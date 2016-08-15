/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijipanteisyori.IChiJiPanTeiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijipanteisyori.IChiJiPanTeiSyoRiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijipanteisyori.IIChiJiPanTeiSyoRiMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
public class IChiJiPanTeiSyoRiManager {

    private final MapperProvider mapperProvider;
    private final DbT5116IchijiHanteiKekkaJohoDac dbT5116Dac;

    /**
     * コンストラクタ。
     *
     */
    public IChiJiPanTeiSyoRiManager() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        dbT5116Dac = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IChiJiPanTeiSyoRiManager}のインスタンスを返します。
     *
     * @return JigyoshaInputGuideFinder
     */
    public static IChiJiPanTeiSyoRiManager createInstance() {
        return InstanceProvider.create(IChiJiPanTeiSyoRiManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapper取得
     */
    IChiJiPanTeiSyoRiManager(
            MapperProvider mapperProvider,
            DbT5116IchijiHanteiKekkaJohoDac dbT5116Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5116Dac = dbT5116Dac;
    }

    /**
     * 認定調査一覧を取得します。
     *
     * @param parameter IChiJiPanTeiSyoRiParameter
     * @return 認定調査一覧リスト
     */
    @Transaction
    public SearchResult<IChiJiPanTeiSyoRiBusiness> get対象者一覧(IChiJiPanTeiSyoRiParameter parameter) {
        List<IChiJiPanTeiSyoRiBusiness> 対象者一覧List = new ArrayList<>();
        IIChiJiPanTeiSyoRiMapper mapper = mapperProvider.create(IIChiJiPanTeiSyoRiMapper.class);
        List<IChiJiPanTeiSyoRiRelateEntity> entityList = mapper.get対象者一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<IChiJiPanTeiSyoRiBusiness>emptyList(), 0, false);
        }
        for (IChiJiPanTeiSyoRiRelateEntity entity : entityList) {
            対象者一覧List.add(new IChiJiPanTeiSyoRiBusiness(entity));
        }
        return SearchResult.of(対象者一覧List, 0, false);
    }

    /**
     * 要介護認定一次判定結果情報を取得します。
     *
     * @param parameter IChiJiPanTeiSyoRiParameter
     * @return 要介護認定一次判定結果情報リスト
     */
    @Transaction
    public SearchResult<IchijiHanteiKekkaJoho> get要介護認定一次判定結果情報(IChiJiPanTeiSyoRiParameter parameter) {
        List<IchijiHanteiKekkaJoho> 要介護認定一次判定結果情報List = new ArrayList<>();
        IIChiJiPanTeiSyoRiMapper mapper = mapperProvider.create(IIChiJiPanTeiSyoRiMapper.class);
        List<DbT5116IchijiHanteiKekkaJohoEntity> entityList = mapper.get要介護認定一次判定結果情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<IChiJiPanTeiSyoRiBusiness>emptyList(), 0, false);
        }
        for (DbT5116IchijiHanteiKekkaJohoEntity entity : entityList) {
            if (entity != null) {
                entity.initializeMd5();
                要介護認定一次判定結果情報List.add(new IchijiHanteiKekkaJoho(entity));
            }
        }
        return SearchResult.of(要介護認定一次判定結果情報List, 0, false);
    }

    /**
     * 認定調査票（概況調査）に登録する。
     *
     * @param 要介護認定一次判定結果情報 IchijiHanteiKekkaJoho
     * @return 要介護認定一次判定結果情報のCOUNT
     */
    @Transaction
    public boolean 要介護認定一次判定結果情報(IchijiHanteiKekkaJoho 要介護認定一次判定結果情報) {

        if (!要介護認定一次判定結果情報.hasChanged()) {
            return false;
        }
        return 1 == dbT5116Dac.save(要介護認定一次判定結果情報.toEntity());
    }
}
