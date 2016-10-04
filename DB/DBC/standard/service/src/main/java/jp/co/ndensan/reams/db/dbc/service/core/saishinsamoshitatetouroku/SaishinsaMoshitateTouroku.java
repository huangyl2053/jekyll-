/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.KyufuJissekiGaitoshaBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.SaishinsaMoshitateJohoBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.ServiceCodeBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.ServiceShuruiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku.TokuteiSinryoShikibetsuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsamoshitatetouroku.ISaishinsaMoshitateTourokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護給付費再審査申立書作成のビジネスです。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
public class SaishinsaMoshitateTouroku {

    private static final RString ZERO = new RString("0");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SaishinsaMoshitateTouroku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    public SaishinsaMoshitateTouroku(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaishinsaMoshitateTouroku}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SaishinsaMoshitateTouroku}のインスタンス
     */
    public static SaishinsaMoshitateTouroku createInstance() {
        return InstanceProvider.create(SaishinsaMoshitateTouroku.class);
    }

    /**
     * 給付実績該当者一覧を取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 給付実績該当者一覧
     */
    public List<KyufuJissekiGaitoshaBusiness> selectKyufuJissekiList(SaishinsaMoshitateTourokuMybatisParameter parameter) {
        ISaishinsaMoshitateTourokuMapper mapper = mapperProvider.create(ISaishinsaMoshitateTourokuMapper.class);
        List<SaishinsaMoshitateTourokuRelateEntity> entityList = mapper.selectKyufuJissekiList(parameter);
        if (entityList.isEmpty()) {
            return null;
        }
        List<KyufuJissekiGaitoshaBusiness> businessList = new ArrayList();
        for (SaishinsaMoshitateTourokuRelateEntity entity : entityList) {
            businessList.add(new KyufuJissekiGaitoshaBusiness(entity));
        }
        return businessList;
    }

    /**
     * 再審査申立情報一覧を取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 再審査申立情報一覧
     */
    public List<SaishinsaMoshitateJohoBusiness> selectSaishinsaMoshitateJohoList(
            SaishinsaMoshitateTourokuMybatisParameter parameter) {
        ISaishinsaMoshitateTourokuMapper mapper = mapperProvider.create(ISaishinsaMoshitateTourokuMapper.class);
        List<SaishinsaMoshitateTourokuRelateEntity> entityList = mapper.selectSaishinsaMoshitateJohoList(parameter);
        if (entityList.isEmpty()) {
            return null;
        }
        List<SaishinsaMoshitateJohoBusiness> businessList = new ArrayList();
        for (SaishinsaMoshitateTourokuRelateEntity entity : entityList) {
            businessList.add(new SaishinsaMoshitateJohoBusiness(entity));
        }
        return businessList;
    }

    /**
     * サービス種類リストを取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return サービス種類リスト
     */
    public List<ServiceShuruiBusiness> selectSabisuShuruiList(SaishinsaMoshitateTourokuMybatisParameter parameter) {
        ISaishinsaMoshitateTourokuMapper mapper = mapperProvider.create(ISaishinsaMoshitateTourokuMapper.class);
        List<SaishinsaMoshitateTourokuRelateEntity> entityList = mapper.selectSabisuShuruiList(parameter);
        if (entityList.isEmpty()) {
            return null;
        }
        List<ServiceShuruiBusiness> businessList = new ArrayList();
        for (SaishinsaMoshitateTourokuRelateEntity entity : entityList) {
            businessList.add(new ServiceShuruiBusiness(entity));
        }
        return businessList;
    }

    /**
     * サービスコードリストを取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return サービスコードリスト
     */
    public List<ServiceCodeBusiness> selectSabisuKodoList(SaishinsaMoshitateTourokuMybatisParameter parameter) {
        ISaishinsaMoshitateTourokuMapper mapper = mapperProvider.create(ISaishinsaMoshitateTourokuMapper.class);
        List<SaishinsaMoshitateTourokuRelateEntity> entityList = mapper.selectSabisuKodoList(parameter);
        if (entityList.isEmpty()) {
            return null;
        }
        List<ServiceCodeBusiness> businessList = new ArrayList();
        for (SaishinsaMoshitateTourokuRelateEntity entity : entityList) {
            businessList.add(new ServiceCodeBusiness(entity));
        }
        return businessList;
    }

    /**
     * 特定診療識別リストを取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 特定診療識別リスト
     */
    public List<TokuteiSinryoShikibetsuBusiness> selectTokuteiShinryoShikibetsuList(
            SaishinsaMoshitateTourokuMybatisParameter parameter) {
        ISaishinsaMoshitateTourokuMapper mapper = mapperProvider.create(ISaishinsaMoshitateTourokuMapper.class);
        List<SaishinsaMoshitateTourokuRelateEntity> entityList = mapper.selectTokuteiShinryoShikibetsuList(parameter);
        if (entityList.isEmpty()) {
            return null;
        }
        List<TokuteiSinryoShikibetsuBusiness> businessList = new ArrayList();
        for (SaishinsaMoshitateTourokuRelateEntity entity : entityList) {
            businessList.add(new TokuteiSinryoShikibetsuBusiness(entity));
        }
        return businessList;
    }

    /**
     * 再審査申立情報の最大履歴番号を取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 再審査申立情報の最大履歴番号
     */
    public RString selectSaishinsaMoshitateJohoSidaiRenBan(SaishinsaMoshitateTourokuMybatisParameter parameter) {
        ISaishinsaMoshitateTourokuMapper mapper = mapperProvider.create(ISaishinsaMoshitateTourokuMapper.class);
        RString 最大履歴番号 = mapper.selectSaishinsaMoshitateJohoSidaiRenBan(parameter);
        if (最大履歴番号 == null || 最大履歴番号.isEmpty() || ZERO.equals(最大履歴番号)) {
            return null;
        } else {
            return 最大履歴番号;
        }
    }
}
