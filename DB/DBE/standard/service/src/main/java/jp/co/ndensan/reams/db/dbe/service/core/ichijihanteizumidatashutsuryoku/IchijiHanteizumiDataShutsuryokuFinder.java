/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ichijihanteizumidatashutsuryoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness.NinteichosaSchedulBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 一次判定データ出力です。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijiHanteizumiDataShutsuryokuFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    IchijiHanteizumiDataShutsuryokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    IchijiHanteizumiDataShutsuryokuFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IchijiHanteizumiDataShutsuryokuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IchijiHanteizumiDataShutsuryokuFinder}のインスタンス
     */
    public static IchijiHanteizumiDataShutsuryokuFinder createInstance() {
        return InstanceProvider.create(IchijiHanteizumiDataShutsuryokuFinder.class);
    }

    /**
     * 一次判定済みデータの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<IchijiHanteizumiDataShutsuryokuBusiness> get次判定済みデータ(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<IchijiHanteizumiDataShutsuryokuBusiness> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<IchijiHanteizumiDataShutsuryokuRelateEntity> 一次判定済みlist = mapper.get一次判定済みデータ(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (IchijiHanteizumiDataShutsuryokuRelateEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new IchijiHanteizumiDataShutsuryokuBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 一次判定済みデータの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<IchijiHanteizumiDataBusiness> get一次判定結果情報(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<IchijiHanteizumiDataBusiness> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<IchijiHanteizumiDataRelateEntity> 一次判定済みlist = mapper.get一次判定結果票(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (IchijiHanteizumiDataRelateEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new IchijiHanteizumiDataBusiness(entity));
        }

        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }
}
