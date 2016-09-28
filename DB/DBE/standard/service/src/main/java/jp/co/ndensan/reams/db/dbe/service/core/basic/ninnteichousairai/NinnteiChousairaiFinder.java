/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinteichosaIraiJohoRelateBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.SaiChekkuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai.SaiChekkuhyoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.NinnteiChousairaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.NinteichosaIraiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.SaiChekkuhyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai.WaritsukeEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ininnteichousairai.INinnteiChousairaiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報を管理するクラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class NinnteiChousairaiFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    NinnteiChousairaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider
     * @param DbT7051KoseiShichosonMasterDac
     */
    NinnteiChousairaiFinder(MapperProvider mapperProvider, DbT7051KoseiShichosonMasterDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiFinder}のインスタンス
     */
    public static NinnteiChousairaiFinder createInstance() {
        return InstanceProvider.create(NinnteiChousairaiFinder.class);
    }

    /**
     * 認定調査委託先情報を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<NinnteiChousairaiBusiness> 認定調査委託先情報
     */
    @Transaction
    public SearchResult<NinnteiChousairaiBusiness> getNinnteiChousaItaku(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<NinnteiChousairaiEntity> entityList = mapper.selectNinnteiChousaItaku(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinnteiChousairaiBusiness>emptyList(), 0, false);
        }
        List<NinnteiChousairaiBusiness> 認定調査委託先List = new ArrayList<>();
        for (NinnteiChousairaiEntity entity : entityList) {
            認定調査委託先List.add(new NinnteiChousairaiBusiness(entity));
        }
        return SearchResult.of(認定調査委託先List, 0, false);
    }

    /**
     * 調査員情報を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<NinnteiChousairaiBusiness> 調査員情報
     */
    @Transaction
    public SearchResult<NinnteiChousairaiBusiness> getChousaIn(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<NinnteiChousairaiEntity> entityList = mapper.selectChousaIn(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinnteiChousairaiBusiness>emptyList(), 0, false);
        }
        List<NinnteiChousairaiBusiness> 調査員情報 = new ArrayList<>();
        for (NinnteiChousairaiEntity entity : entityList) {
            調査員情報.add(new NinnteiChousairaiBusiness(entity));
        }
        return SearchResult.of(調査員情報, 0, false);
    }

    /**
     * 割付済み申請者一覧を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<WaritsukeBusiness> 割付済み申請者一覧
     */
    @Transaction
    public SearchResult<WaritsukeBusiness> getWaritsuke(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.getWaritsuke(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<WaritsukeBusiness>emptyList(), 0, false);
        }
        List<WaritsukeBusiness> 割付済み申請者一覧 = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            割付済み申請者一覧.add(new WaritsukeBusiness(entity));
        }
        return SearchResult.of(割付済み申請者一覧, 0, false);
    }

    /**
     * 未割付申請者一覧（新規依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<WaritsukeBusiness> 未割付申請者一覧（新規依頼）
     */
    @Transaction
    public SearchResult<WaritsukeBusiness> getShiteWaritsuke(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.getShiteWaritsuke(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<WaritsukeBusiness>emptyList(), 0, false);
        }
        List<WaritsukeBusiness> 未割付申請者一覧 = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            未割付申請者一覧.add(new WaritsukeBusiness(entity));
        }
        return SearchResult.of(未割付申請者一覧, 0, false);
    }

    /**
     * 未割付申請者一覧（再依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<WaritsukeBusiness> 未割付申請者一覧（再依頼）
     */
    @Transaction
    public SearchResult<WaritsukeBusiness> getShiteWaritsukeSai(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.getShiteWaritsukeSai(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<WaritsukeBusiness>emptyList(), 0, false);
        }
        List<WaritsukeBusiness> 未割付再依頼一覧 = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            未割付再依頼一覧.add(new WaritsukeBusiness(entity));
        }
        return SearchResult.of(未割付再依頼一覧, 0, false);
    }

    /**
     * 割付済み一覧を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<NinteichosaIraiJohoRelateBusiness> 割付済み一覧
     */
    @Transaction
    public SearchResult<NinteichosaIraiJohoRelateBusiness> getNinteichosaIraiJohoList(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        NinteichosaIraiJohoRelateEntity entity = mapper.getNinteichosaIraiJohoList(parametere);
        if (entity == null) {
            return SearchResult.of(Collections.<NinteichosaIraiJohoRelateBusiness>emptyList(), 0, false);
        }
        List<NinteichosaIraiJohoRelateBusiness> 割付済み一覧 = new ArrayList<>();
        List<NinteiKanryoJoho> ninteiKanryoJohoList = new ArrayList<>();
        for (DbT5105NinteiKanryoJohoEntity ninteiKanryoJohoEntity : entity.getNinteiKanryoJohoEntity()) {
            ninteiKanryoJohoEntity.initializeMd5();
            ninteiKanryoJohoList.add(new NinteiKanryoJoho(ninteiKanryoJohoEntity));
        }

        List<NinteichosaIraiJoho> ninteichosaIraiJohoList = new ArrayList<>();
        for (DbT5201NinteichosaIraiJohoEntity ninteichosaIraiJohoEntity : entity.getNinteichosaIraiJohoEntity()) {
            ninteichosaIraiJohoEntity.initializeMd5();
            ninteichosaIraiJohoList.add(new NinteichosaIraiJoho(ninteichosaIraiJohoEntity));
        }
        割付済み一覧.add(new NinteichosaIraiJohoRelateBusiness(ninteichosaIraiJohoList, ninteiKanryoJohoList));
        return SearchResult.of(割付済み一覧, 0, false);
    }

    /**
     * 市町村名称を取得します。
     *
     * @param shoKisaiHokenshaNo 保険者番号
     * @return SearchResult<ShichosonMeishoBusiness> 市町村名称リスト
     */
    @Transaction
    public SearchResult<ShichosonMeishoBusiness> getShichosonMeisho(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.getshichosonMeisho(shoKisaiHokenshaNo);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShichosonMeishoBusiness>emptyList(), 0, false);
        }
        List<ShichosonMeishoBusiness> shichosonMeisho = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            shichosonMeisho.add(new ShichosonMeishoBusiness(entity));
        }
        return SearchResult.of(shichosonMeisho, 0, false);
    }

    /**
     * 認定調査依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<NinteichosaIraiJoho> 認定調査依頼情報
     */
    @Transaction
    public SearchResult<NinteichosaIraiJoho> getNinteichosaIraiJoho(RString 申請書管理番号) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        DbT5201NinteichosaIraiJohoEntity entity = mapper.getNinteichosaIraiJoho(申請書管理番号);
        if (entity == null) {
            return SearchResult.of(Collections.<NinteichosaIraiJoho>emptyList(), 0, false);
        }
        entity.initializeMd5();
        List<NinteichosaIraiJoho> list = new ArrayList<>();
        list.add(new NinteichosaIraiJoho(entity));
        return SearchResult.of(list, 0, false);
    }

    /**
     * 認定調査票差異チェック票を取得します。
     *
     * @param parameter SaiChekkuhyoParameter
     * @return SearchResult<SaiChekkuhyoBusiness> 認定調査票差異チェック票
     */
    @Transaction
    public SearchResult<SaiChekkuhyoBusiness> get認定調査票差異チェック票情報(SaiChekkuhyoParameter parameter) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<SaiChekkuhyoEntity> entityList = mapper.get認定調査票差異チェック票情報(parameter);
        if (entityList == null) {
            return SearchResult.of(Collections.<SaiChekkuhyoBusiness>emptyList(), 0, false);
        }
        List<SaiChekkuhyoBusiness> list = new ArrayList<>();
        for (SaiChekkuhyoEntity entity : entityList) {
            list.add(new SaiChekkuhyoBusiness(entity));
        }
        return SearchResult.of(list, 0, false);
    }
}
