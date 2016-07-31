/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.benmeitoroku;

import jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku.BenmeiTorokuMeisaiJoho;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.benmeitoroku.BenmeiTorokuMeisaiJohoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeitoroku.BenmeiTorokuMeisaiJohoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.benmeitoroku.IBenmeiTorokuMeisaiJohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7001FufukuMoshitateDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7002BemmeiNaiyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7003BemmeishaJohoDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 弁明登録情報の処理を行うです。
 *
 * @reamsid_L DBU-1080-030 lijia
 *
 */
public class BenmeiTorokuManager {

    private final DbT7001FufukuMoshitateDac dbT7001FufukuMoshitateDac;
    private final DbT7002BemmeiNaiyoDac dbT7002BemmeiNaiyoDac;
    private final DbT7003BemmeishaJohoDac dbT7003BemmeishaJohoDac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public BenmeiTorokuManager() {
        this.dbT7001FufukuMoshitateDac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
        this.dbT7002BemmeiNaiyoDac = InstanceProvider.create(DbT7002BemmeiNaiyoDac.class);
        this.dbT7003BemmeishaJohoDac = InstanceProvider.create(DbT7003BemmeishaJohoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    BenmeiTorokuManager(DbT7001FufukuMoshitateDac dbT7001FufukuMoshitateDac,
            DbT7002BemmeiNaiyoDac dbT7002BemmeiNaiyoDac,
            DbT7003BemmeishaJohoDac dbT7003BemmeishaJohoDac,
            MapperProvider mapperProvider
    ) {
        this.dbT7001FufukuMoshitateDac = dbT7001FufukuMoshitateDac;
        this.dbT7002BemmeiNaiyoDac = dbT7002BemmeiNaiyoDac;
        this.dbT7003BemmeishaJohoDac = dbT7003BemmeishaJohoDac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * クラスをcreateメソッドです
     *
     * @return 弁明登録情報の取得処理するクラス
     */
    public static BenmeiTorokuManager createInstance() {
        return InstanceProvider.create(BenmeiTorokuManager.class);
    }

    /**
     * 弁明登録明細情報の取得処理を行うです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @return BenmeiTorokuMeisaiJoho
     */
    @Transaction
    public BenmeiTorokuMeisaiJoho getBenmeiTorokuMeisaiJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 審査請求届出日
    ) {
        IBenmeiTorokuMeisaiJohoMapper benmeiTorokuMapper = mapperProvider.create(IBenmeiTorokuMeisaiJohoMapper.class);
        BenmeiTorokuMeisaiJohoEntity benmeiTorokuMeisaiJohoEntity
                = benmeiTorokuMapper.getBenmeiTorokuMeisaiJoho(BenmeiTorokuMeisaiJohoParameter.createParam_common(識別コード, 被保険者番号, 審査請求届出日));
        if (benmeiTorokuMeisaiJohoEntity != null) {
            return new BenmeiTorokuMeisaiJoho(benmeiTorokuMeisaiJohoEntity);
        }
        return null;
    }

    /**
     * 不服審査申立情報の取得処理を行うです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @return FufukuMoshitate
     */
    @Transaction
    public FufukuMoshitate getFufukuMoshitate(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 審査請求届出日
    ) {
        DbT7001FufukuMoshitateEntity entity = dbT7001FufukuMoshitateDac.selectByKey(識別コード, 被保険者番号, 審査請求届出日);
        if (entity == null) {
            return null;
        }
        return new FufukuMoshitate(entity);
    }

    /**
     * 弁明内容情報の取得処理を行うです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @param 弁明書作成日 FlexibleDate
     * @return BenmeiTorokuMeisaiJoho
     */
    @Transaction
    public BemmeiNaiyo getBenmeiNaiyo(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日
    ) {
        DbT7002BemmeiNaiyoEntity entity = dbT7002BemmeiNaiyoDac.selectByKey(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
        if (entity == null) {
            return null;
        }
        return new BemmeiNaiyo(entity);
    }

    /**
     * 弁明者情報の取得処理を行うです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @param 弁明書作成日 FlexibleDate
     * @return BemmeishaJoho
     */
    @Transaction
    public BemmeishaJoho getBenmeishaJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日
    ) {
        DbT7003BemmeishaJohoEntity entity = dbT7003BemmeishaJohoDac.selectByKey(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日, new Decimal(1));
        if (entity == null) {
            return null;
        }
        return new BemmeishaJoho(entity);
    }

    /**
     * 弁明登録情報の登録処理を行うです。
     *
     * @param fufukuMoshitate 不服審査申立情報
     * @param bemmeiNaiyo 弁明内容
     * @param bemmeishaJoho 弁明者情報
     * @return boolean
     */
    @Transaction
    public boolean insBenmeiTorokuJoho(FufukuMoshitate fufukuMoshitate, BemmeiNaiyo bemmeiNaiyo, BemmeishaJoho bemmeishaJoho) {
        boolean blnDbT7001 = getFufukuMoshitateINS(fufukuMoshitate);
        boolean blnDbT7002 = getBemmeiNaiyoINS(bemmeiNaiyo);
        boolean blnDbT7003 = getBemmeishaJohoINS(bemmeishaJoho);
        return blnDbT7001 && blnDbT7002 && blnDbT7003;
    }

    private boolean getFufukuMoshitateINS(FufukuMoshitate fufukuMoshitate) {
        DbT7001FufukuMoshitateEntity fufukuMoshitateEntity = fufukuMoshitate.toEntity();
        fufukuMoshitateEntity.setState(EntityDataState.Modified);
        int 戻る値 = dbT7001FufukuMoshitateDac.save(fufukuMoshitateEntity);
        return 戻る値 == 1;
    }

    private boolean getBemmeiNaiyoINS(BemmeiNaiyo bemmeiNaiyo) {
        DbT7002BemmeiNaiyoEntity bemmeiNaiyoEntity = bemmeiNaiyo.toEntity();
        bemmeiNaiyoEntity.setState(EntityDataState.Added);
        int 戻る値 = dbT7002BemmeiNaiyoDac.saveOrDelete(bemmeiNaiyoEntity);
        return 戻る値 == 1;
    }

    private boolean getBemmeishaJohoINS(BemmeishaJoho bemmeishaJoho) {
        DbT7003BemmeishaJohoEntity bemmeishaJohoEntity = bemmeishaJoho.toEntity();
        bemmeishaJohoEntity.setState(EntityDataState.Added);
        int 戻る値 = dbT7003BemmeishaJohoDac.saveOrDelete(bemmeishaJohoEntity);
        return 戻る値 == 1;
    }

    /**
     * 弁明登録情報の削除処理を行うです 。
     *
     * @param fufukuMoshitate 不服審査申立情報
     * @param bemmeiNaiyo 弁明内容
     * @param bemmeishaJoho 弁明者情報
     * @return boolean
     */
    @Transaction
    public boolean delBenmeiTorokuJoho(FufukuMoshitate fufukuMoshitate, BemmeiNaiyo bemmeiNaiyo, BemmeishaJoho bemmeishaJoho) {
        boolean blnDbT7001 = getFufukuMoshitateDEL(fufukuMoshitate);
        boolean blnDbT7002 = getBemmeiNaiyoDEL(bemmeiNaiyo);
        boolean blnDbT7003 = getBemmeishaJohoDEL(bemmeishaJoho);
        return blnDbT7001 && blnDbT7002 && blnDbT7003;
    }

    private boolean getFufukuMoshitateDEL(FufukuMoshitate fufukuMoshitate) {
        DbT7001FufukuMoshitateEntity dbT7001FufukuMoshitateEntity = fufukuMoshitate.toEntity();
        dbT7001FufukuMoshitateEntity.setState(EntityDataState.Modified);
        int 戻る値 = dbT7001FufukuMoshitateDac.saveOrDeletePhysicalBy(dbT7001FufukuMoshitateEntity);
        return 戻る値 == 1;
    }

    private boolean getBemmeiNaiyoDEL(BemmeiNaiyo bemmeiNaiyo) {
        DbT7002BemmeiNaiyoEntity bemmeiNaiyoEntity = bemmeiNaiyo.toEntity();
        bemmeiNaiyoEntity.setState(EntityDataState.Deleted);
        int 戻る値 = dbT7002BemmeiNaiyoDac.saveOrDelete(bemmeiNaiyoEntity);
        return 戻る値 == 1;
    }

    private boolean getBemmeishaJohoDEL(BemmeishaJoho bemmeishaJoho) {
        DbT7003BemmeishaJohoEntity bemmeishaJohoEntity = bemmeishaJoho.toEntity();
        bemmeishaJohoEntity.setState(EntityDataState.Deleted);
        int 戻る値 = dbT7003BemmeishaJohoDac.saveOrDelete(bemmeishaJohoEntity);
        return 戻る値 == 1;
    }

    /**
     * 地方公共団体コードを取得です 。
     *
     * @return LasdecCode
     */
    public LasdecCode get地方公共団体コード() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return association.get地方公共団体コード();
    }
}
