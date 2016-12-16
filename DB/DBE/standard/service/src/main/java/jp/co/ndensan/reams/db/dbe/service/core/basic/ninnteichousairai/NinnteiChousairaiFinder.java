/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai;

import java.util.ArrayList;
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
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiFinder}のインスタンス
     */
    public static NinnteiChousairaiFinder createInstance() {
        return InstanceProvider.create(NinnteiChousairaiFinder.class);
    }

    /**
     * 認定調査委託先情報を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return List<NinnteiChousairaiBusiness> 認定調査委託先情報
     */
    @Transaction
    public List<NinnteiChousairaiBusiness> get認定調査委託先(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<NinnteiChousairaiEntity> entityList = mapper.select認定調査委託先情報(parametere);
        List<NinnteiChousairaiBusiness> 認定調査委託先List = new ArrayList<>();
        for (NinnteiChousairaiEntity entity : entityList) {
            認定調査委託先List.add(new NinnteiChousairaiBusiness(entity));
        }
        return 認定調査委託先List;
    }

    /**
     * 調査員情報を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<NinnteiChousairaiBusiness> 調査員情報
     */
    @Transaction
    public List<NinnteiChousairaiBusiness> get調査員(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<NinnteiChousairaiEntity> entityList = mapper.select調査員(parametere);
        List<NinnteiChousairaiBusiness> 調査員List = new ArrayList<>();
        for (NinnteiChousairaiEntity entity : entityList) {
            調査員List.add(new NinnteiChousairaiBusiness(entity));
        }
        return 調査員List;
    }

    /**
     * 割付済み申請者一覧を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<WaritsukeBusiness> 割付済み申請者一覧
     */
    @Transaction
    public List<WaritsukeBusiness> get割付済み申請者(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.select割付済み申請者(parametere);
        List<WaritsukeBusiness> 割付済み申請者List = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            割付済み申請者List.add(new WaritsukeBusiness(entity));
        }
        return 割付済み申請者List;
    }

    /**
     * 未割付申請者一覧（新規依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<WaritsukeBusiness> 未割付申請者一覧（新規依頼）
     */
    @Transaction
    public List<WaritsukeBusiness> get新規依頼未割付申請者(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.select新規依頼未割付申請者(parametere);
        List<WaritsukeBusiness> 未割付申請者List = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            未割付申請者List.add(new WaritsukeBusiness(entity));
        }
        return 未割付申請者List;
    }

    /**
     * 未割付申請者一覧（再依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<WaritsukeBusiness> 未割付申請者一覧（再依頼）
     */
    @Transaction
    public List<WaritsukeBusiness> get再依頼未割付申請者(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<WaritsukeEntity> entityList = mapper.select再依頼未割付申請者(parametere);
        List<WaritsukeBusiness> 未割付申請者List = new ArrayList<>();
        for (WaritsukeEntity entity : entityList) {
            未割付申請者List.add(new WaritsukeBusiness(entity));
        }
        return 未割付申請者List;
    }

    /**
     * 割付済み一覧を取得します。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return SearchResult<NinteichosaIraiJohoRelateBusiness> 割付済み一覧
     */
    @Transaction
    public List<NinteichosaIraiJohoRelateBusiness> getNinteichosaIraiJohoList(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        NinteichosaIraiJohoRelateEntity entity = mapper.getNinteichosaIraiJohoList(parametere);
        List<NinteichosaIraiJohoRelateBusiness> 割付済み一覧 = new ArrayList<>();
        if (entity == null) {
            return 割付済み一覧;
        }
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
        return 割付済み一覧;
    }

    /**
     * 市町村名称を取得します。
     *
     * @param shoKisaiHokenshaNo 保険者番号
     * @return SearchResult<ShichosonMeishoBusiness> 市町村名称リスト
     */
    @Transaction
    public List<ShichosonMeishoBusiness> get市町村名称(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.getshichosonMeisho(shoKisaiHokenshaNo);
        List<ShichosonMeishoBusiness> 市町村名称List = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            市町村名称List.add(new ShichosonMeishoBusiness(entity));
        }
        return 市町村名称List;
    }

    /**
     * 認定調査依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<NinteichosaIraiJoho> 認定調査依頼情報
     */
    @Transaction
    public NinteichosaIraiJoho get認定調査依頼情報(RString 申請書管理番号) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        DbT5201NinteichosaIraiJohoEntity entity = mapper.select認定調査依頼情報(申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosaIraiJoho(entity);
    }

    /**
     * 認定調査票差異チェック票を取得します。
     *
     * @param parameter SaiChekkuhyoParameter
     * @return SearchResult<SaiChekkuhyoBusiness> 認定調査票差異チェック票
     */
    @Transaction
    public List<SaiChekkuhyoBusiness> get認定調査票差異チェック票情報(SaiChekkuhyoParameter parameter) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<SaiChekkuhyoEntity> entityList = mapper.get認定調査票差異チェック票情報(parameter);
        List<SaiChekkuhyoBusiness> list = new ArrayList<>();
        for (SaiChekkuhyoEntity entity : entityList) {
            list.add(new SaiChekkuhyoBusiness(entity));
        }
        return list;
    }
}
