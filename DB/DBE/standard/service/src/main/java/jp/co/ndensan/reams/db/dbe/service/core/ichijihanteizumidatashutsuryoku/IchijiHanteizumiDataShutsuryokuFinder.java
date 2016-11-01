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
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness.NinteichosaSchedulBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
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

    /**
     * 認定調査票概況調査の取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<NinteichosahyoServiceJokyo> get認定調査票概況調査(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<NinteichosahyoServiceJokyo> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<DbT5207NinteichosahyoServiceJokyoEntity> 一次判定済みlist = mapper.get認定調査票サービス状況(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (DbT5207NinteichosahyoServiceJokyoEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new NinteichosahyoServiceJokyo(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 認定調査票フラグの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<NinteichosahyoServiceJokyoFlag> get認定調査票フラグ(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<NinteichosahyoServiceJokyoFlag> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<DbT5208NinteichosahyoServiceJokyoFlagEntity> 一次判定済みlist = mapper.get認定調査票フラグ(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<NinteichosahyoServiceJokyo>emptyList(), 0, false);
        }
        for (DbT5208NinteichosahyoServiceJokyoFlagEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new NinteichosahyoServiceJokyoFlag(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 認定調査票調査項目データの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<NinteichosahyoChosaItem> get認定調査票調査項目(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<NinteichosahyoChosaItem> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<DbT5211NinteichosahyoChosaItemEntity> 一次判定済みlist = mapper.get認定調査票調査項目(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<NinteichosahyoChosaItem>emptyList(), 0, false);
        }
        for (DbT5211NinteichosahyoChosaItemEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new NinteichosahyoChosaItem(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 前回認定調査票調査項目データの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<NinteichosahyoChosaItem> get前回認定調査票調査項目(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<NinteichosahyoChosaItem> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<DbT5211NinteichosahyoChosaItemEntity> 一次判定済みlist = mapper.get前回認定調査票調査項目(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<NinteichosahyoChosaItem>emptyList(), 0, false);
        }
        for (DbT5211NinteichosahyoChosaItemEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new NinteichosahyoChosaItem(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 主治医意見書意見項目データの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<ShujiiIkenshoIkenItem> get主治医意見書意見項目(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<ShujiiIkenshoIkenItem> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 一次判定済みlist = mapper.get主治医意見書意見項目(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<ShujiiIkenshoIkenItem>emptyList(), 0, false);
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new ShujiiIkenshoIkenItem(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 前回主治医意見書意見項目データの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<ShujiiIkenshoIkenItem> get前回主治医意見書意見項目(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<ShujiiIkenshoIkenItem> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 一次判定済みlist = mapper.get前回主治医意見書意見項目(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<ShujiiIkenshoIkenItem>emptyList(), 0, false);
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new ShujiiIkenshoIkenItem(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 認定調査特記事項番号データの取得します。
     *
     * @param parametere IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return 一次判定済みlist
     */
    @Transaction
    public SearchResult<NinteichosahyoTokkijiko> get認定調査特記事項番号(IchijiHanteizumiDataShutsuryokuMybitisParamter parametere) {
        List<NinteichosahyoTokkijiko> kojinJokyoShokaiList = new ArrayList();
        IchijiHanteizumiDataShutsuryokuMapper mapper = mapperProvider.create(IchijiHanteizumiDataShutsuryokuMapper.class);
        List<DbT5205NinteichosahyoTokkijikoEntity> 一次判定済みlist = mapper.get認定調査特記事項番号(parametere);
        if (一次判定済みlist == null || 一次判定済みlist.isEmpty()) {

            return SearchResult.of(Collections.<NinteichosahyoTokkijiko>emptyList(), 0, false);
        }
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 一次判定済みlist) {
            kojinJokyoShokaiList.add(new NinteichosahyoTokkijiko(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }
}
