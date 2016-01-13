/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.benmeitoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku.BenmeiTorokuMeisaiJoho;
import jp.co.ndensan.reams.db.dbu.definition.mybatis.param.benmeitoroku.BenmeiTorokuMeisaiJohoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeitoroku.BenmeiTorokuMeisaiJohoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.benmeitoroku.IBenmeiTorokuMeisaiJohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 弁明登録情報の処理を行うです。
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
     * {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriMapperParameter}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriMapperParameter}のインスタンス
     */
    public static BenmeiTorokuManager createInstance() {
        return InstanceProvider.create(BenmeiTorokuManager.class);
    }

    /**
     * 弁明登録明細情報の取得処理を行うです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @return BenmeiTorokuMeisaiJoho
     */
    @Transaction
    public BenmeiTorokuMeisaiJoho getBenmeiTorokuMeisaiJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日
    ) {
        IBenmeiTorokuMeisaiJohoMapper benmeiTorokuMapper = mapperProvider.create(IBenmeiTorokuMeisaiJohoMapper.class);
        BenmeiTorokuMeisaiJohoEntity benmeiTorokuMeisaiJohoEntity
                = benmeiTorokuMapper.getBenmeiTorokuMeisaiJoho(BenmeiTorokuMeisaiJohoParameter.createParam_common(識別コード, 原処分被保険者番号, 審査請求届出日));
        if (benmeiTorokuMeisaiJohoEntity != null) {
            return new BenmeiTorokuMeisaiJoho(benmeiTorokuMeisaiJohoEntity);
        }
        return null;
    }

    /**
     * 弁明登録情報の登録処理を行うです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 弁明書提出日 FlexibleDate
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 弁明内容 RString
     * @param 審査請求届出日 FlexibleDate
     * @param 審査請求に係る処分内容 RString
     * @param 弁明書作成日 FlexibleDate
     * @param 弁明者 RString
     * @return RString
     */
    @Transaction
    public boolean insBenmeiTorokuJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 弁明者,
            RString 審査請求に係る処分内容,
            RString 弁明内容,
            FlexibleDate 弁明書提出日
    ) {
        boolean blnDbT7001 = getFufukuMoshitateINS(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日);
        boolean blnDbT7002
                = getBemmeiNaiyoINS(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日, 審査請求に係る処分内容, 弁明内容, 弁明書提出日);
        boolean blnDbT7003 = getBemmeishaJohoINS(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日, 弁明者);
        return blnDbT7001 && blnDbT7002 && blnDbT7003;
    }

    private boolean getFufukuMoshitateINS(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日) {
        DbT7001FufukuMoshitateEntity dbT7001FufukuMoshitateEntity
                = dbT7001FufukuMoshitateDac.selectByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        int 戻る値 = 0;
        if (dbT7001FufukuMoshitateEntity == null) {
            DbT7001FufukuMoshitateEntity fufukuMoshitateEntity = new DbT7001FufukuMoshitateEntity();
            fufukuMoshitateEntity.setShikibetsuCode(識別コード);
            fufukuMoshitateEntity.setGenshobunsHihokennshaNo(原処分被保険者番号);
            fufukuMoshitateEntity.setShinsaSeikyuTodokedeYMD(審査請求届出日);
            fufukuMoshitateEntity.setBemmeishoSakuseiYMD(弁明書作成日);
            fufukuMoshitateEntity.setState(EntityDataState.Added);
            戻る値 = dbT7001FufukuMoshitateDac.save(fufukuMoshitateEntity);
        }
        return 戻る値 == 1;
    }

    private boolean getBemmeiNaiyoINS(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 審査請求に係る処分内容,
            RString 弁明内容,
            FlexibleDate 弁明書提出日
    ) {
        DbT7002BemmeiNaiyoEntity dbT7002BemmeiNaiyoEntity = dbT7002BemmeiNaiyoDac.selectByKey(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日);
        int 戻る値 = 0;
        if (dbT7002BemmeiNaiyoEntity == null) {
            DbT7002BemmeiNaiyoEntity bemmeiNaiyoEntity = new DbT7002BemmeiNaiyoEntity();
            bemmeiNaiyoEntity.setShikibetsuCode(識別コード);
            bemmeiNaiyoEntity.setGenshobunHihokenshaNo(原処分被保険者番号);
            bemmeiNaiyoEntity.setShinsaseikyuTodokedeYMD(審査請求届出日);
            bemmeiNaiyoEntity.setBemmeishoSakuseiYMD(弁明書作成日);
            bemmeiNaiyoEntity.setShichosonCode(get地方公共団体コード());
            bemmeiNaiyoEntity.setShinsaseikyuKankeiShobunNaiyo(審査請求に係る処分内容);
            bemmeiNaiyoEntity.setBemmeiNaiyo(弁明内容);
            bemmeiNaiyoEntity.setBemmeishoTeishutsuYMD(弁明書提出日);
            bemmeiNaiyoEntity.setState(EntityDataState.Added);
            戻る値 = dbT7002BemmeiNaiyoDac.saveOrDelete(bemmeiNaiyoEntity);
        }
        return 戻る値 == 1;
    }

    private boolean getBemmeishaJohoINS(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 弁明者) {
        List<DbT7003BemmeishaJohoEntity> dbT7003BemmeishaJohoEntityList
                = dbT7003BemmeishaJohoDac.selectGyomuToutokuByKey(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日);
        int 戻る値 = 0;
        if (dbT7003BemmeishaJohoEntityList.isEmpty()) {
            DbT7003BemmeishaJohoEntity bemmeishaJohoEntity = new DbT7003BemmeishaJohoEntity();
            bemmeishaJohoEntity.setShikibetsuCode(識別コード);
            bemmeishaJohoEntity.setGenshobunHihokenshaNo(原処分被保険者番号);
            bemmeishaJohoEntity.setShinsaseikyuTodokedeYMD(審査請求届出日);
            bemmeishaJohoEntity.setBemmeishoSakuseiYMD(弁明書作成日);
            bemmeishaJohoEntity.setShichosonCode(get地方公共団体コード());
            bemmeishaJohoEntity.setBemmeisha(弁明者);
            bemmeishaJohoEntity.setState(EntityDataState.Added);
            戻る値 = dbT7003BemmeishaJohoDac.saveOrDelete(bemmeishaJohoEntity);
        }
        return 戻る値 == 1;
    }

    /**
     * 弁明登録情報の修正処理を行うです 。
     *
     * @param 識別コード ShikibetsuCode
     * @param 弁明書提出日 FlexibleDate
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 弁明内容 RString
     * @param 審査請求届出日 FlexibleDate
     * @param 審査請求に係る処分内容 RString
     * @param 弁明書作成日 FlexibleDate
     * @param 弁明者 RString
     * @return RString
     */
    @Transaction
    public boolean updBenmeiTorokuJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 弁明者,
            RString 審査請求に係る処分内容,
            RString 弁明内容,
            FlexibleDate 弁明書提出日
    ) {
        boolean blnDbT7001 = getFufukuMoshitateUPD(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日);
        boolean blnDbT7002
                = getBemmeiNaiyoUPD(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日, 審査請求に係る処分内容, 弁明内容, 弁明書提出日);
        boolean blnDbT7003 = getBemmeishaJohoUPD(識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日, 弁明者);
        return blnDbT7001 && blnDbT7002 && blnDbT7003;
    }

    private boolean getFufukuMoshitateUPD(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日) {
        DbT7001FufukuMoshitateEntity dbT7001FufukuMoshitateEntity
                = dbT7001FufukuMoshitateDac.selectByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        int 戻る値 = 0;
        if (dbT7001FufukuMoshitateEntity != null) {
            dbT7001FufukuMoshitateEntity.setBemmeishoSakuseiYMD(弁明書作成日);
            dbT7001FufukuMoshitateEntity.setState(EntityDataState.Modified);
            戻る値 = dbT7001FufukuMoshitateDac.save(dbT7001FufukuMoshitateEntity);
        }
        return 戻る値 == 1;
    }

    private boolean getBemmeiNaiyoUPD(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 審査請求に係る処分内容,
            RString 弁明内容,
            FlexibleDate 弁明書提出日
    ) {
        List<DbT7002BemmeiNaiyoEntity> dbT7002BemmeiNaiyoEntityList = dbT7002BemmeiNaiyoDac.selectGyomuByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        int 戻る値 = 0;
        for (DbT7002BemmeiNaiyoEntity bemmeiNaiyoEntity : dbT7002BemmeiNaiyoEntityList) {
            //TODO PKをUpdateする bemmeiNaiyoEntity.setBemmeishoSakuseiYMD(弁明書作成日);
            bemmeiNaiyoEntity.setShinsaseikyuKankeiShobunNaiyo(審査請求に係る処分内容);
            bemmeiNaiyoEntity.setBemmeiNaiyo(弁明内容);
            bemmeiNaiyoEntity.setBemmeishoTeishutsuYMD(弁明書提出日);
            bemmeiNaiyoEntity.setState(EntityDataState.Modified);
            戻る値 = dbT7002BemmeiNaiyoDac.saveOrDelete(bemmeiNaiyoEntity);
        }
        return 戻る値 == 1;
    }

    private boolean getBemmeishaJohoUPD(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 弁明者) {
        List<DbT7003BemmeishaJohoEntity> dbT7003BemmeishaJohoEntityList = dbT7003BemmeishaJohoDac.selectGyomuDelUpdByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        int 戻る値 = 0;
        for (DbT7003BemmeishaJohoEntity bemmeishaJohoEntity : dbT7003BemmeishaJohoEntityList) {
            //TODO PKをUpdateする bemmeishaJohoEntity.setBemmeishoSakuseiYMD(弁明書作成日);
            bemmeishaJohoEntity.setBemmeisha(弁明者);
            bemmeishaJohoEntity.setState(EntityDataState.Modified);
            戻る値 = dbT7003BemmeishaJohoDac.saveOrDelete(bemmeishaJohoEntity);
        }
        return 戻る値 == 1;
    }

    /**
     * 弁明登録情報の削除処理を行うです 。
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @return RString
     */
    @Transaction
    public boolean delBenmeiTorokuJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日
    ) {
        boolean blnDbT7001 = getFufukuMoshitateDEL(識別コード, 原処分被保険者番号, 審査請求届出日);
        boolean blnDbT7002 = getBemmeiNaiyoDEL(識別コード, 原処分被保険者番号, 審査請求届出日);
        boolean blnDbT7003 = getBemmeishaJohoDEL(識別コード, 原処分被保険者番号, 審査請求届出日);
        return blnDbT7001 && blnDbT7002 && blnDbT7003;
    }

    private boolean getFufukuMoshitateDEL(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) {
        DbT7001FufukuMoshitateEntity dbT7001FufukuMoshitateEntity
                = dbT7001FufukuMoshitateDac.selectByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        int 戻る値 = 0;
        if (dbT7001FufukuMoshitateEntity != null) {
            dbT7001FufukuMoshitateEntity.setBemmeishoSakuseiYMD(FlexibleDate.EMPTY);
            戻る値 = dbT7001FufukuMoshitateDac.save(dbT7001FufukuMoshitateEntity);
        }
        return 戻る値 == 1;
    }

    private boolean getBemmeiNaiyoDEL(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) {
        List<DbT7002BemmeiNaiyoEntity> dbT7002BemmeiNaiyoEntityList
                = dbT7002BemmeiNaiyoDac.selectGyomuByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        int 戻る値 = 0;
        for (DbT7002BemmeiNaiyoEntity bemmeiNaiyoEntity : dbT7002BemmeiNaiyoEntityList) {
            bemmeiNaiyoEntity.setState(EntityDataState.Deleted);
            戻る値 = dbT7002BemmeiNaiyoDac.saveOrDelete(bemmeiNaiyoEntity);
        }
        return 戻る値 == 1;
    }

    private boolean getBemmeishaJohoDEL(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) {
        List<DbT7003BemmeishaJohoEntity> dbT7003BemmeishaJohoEntityList
                = dbT7003BemmeishaJohoDac.selectGyomuDelUpdByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        int 戻る値 = 0;
        for (DbT7003BemmeishaJohoEntity bemmeishaJohoEntity : dbT7003BemmeishaJohoEntityList) {
            bemmeishaJohoEntity.setState(EntityDataState.Deleted);
            戻る値 = dbT7003BemmeishaJohoDac.saveOrDelete(bemmeishaJohoEntity);
        }
        return 戻る値 == 1;
    }

    private LasdecCode get地方公共団体コード() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return association.get地方公共団体コード();
    }
}
