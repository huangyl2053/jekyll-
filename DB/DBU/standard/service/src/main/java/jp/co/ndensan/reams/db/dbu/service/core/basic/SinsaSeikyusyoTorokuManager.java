/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.SinsaSeikyusyoTorokuEntity;
import jp.co.ndensan.reams.db.dbu.persistence.ShoKofuKaishuJohoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SinsaSeikyusyoMeisaiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7001FufukuMoshitateDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査請求書登録を登録するクラスです。
 */
public class SinsaSeikyusyoTorokuManager {

    private final DbT7001FufukuMoshitateDac 審査請求書登録dac;
    private static final RString 画面モード_追加モード = new RString("追加");
    private static final RString 画面モード_修正モード = new RString("修正");

    /**
     * コンストラクタです。
     */
    public SinsaSeikyusyoTorokuManager() {
        審査請求書登録dac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7001FufukuMoshitateDac}
     */
    SinsaSeikyusyoTorokuManager(DbT7001FufukuMoshitateDac dac) {
        this.審査請求書登録dac = dac;
    }

    /**
     * 画面入力した条件より　審査請求書明細情報を取得します
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     *
     * @return 審査請求書明細情報
     */
    @Transaction
    public SinsaSeikyusyoMeisaiJoho getSinsaSeikyusyoMeisaiJoho(ShikibetsuCode 識別コード, HihokenshaNo 原処分被保険者番号, FlexibleDate 審査請求届出日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        return new SinsaSeikyusyoMeisaiJoho(審査請求書登録dac.selectByKey(識別コード, 原処分被保険者番号, 審査請求届出日));
    }

    /**
     * 審査請求書明細情報を登録します
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param entity DbT7001FufukuMoshitateEntity
     *
     * @return 登録件数
     */
    @Transaction
    public int intSinsaSeikyusyomeisaiJoho(ShikibetsuCode 識別コード, HihokenshaNo 原処分被保険者番号, DbT7001FufukuMoshitateEntity entity) {
        entity.setShikibetsuCode(識別コード);
        entity.setGenshobunsHihokennshaNo(原処分被保険者番号);
        entity.setBemmeishoTorokuFlag(false);
        return 審査請求書登録dac.save(entity);
    }

    /**
     * 審査請求書明細情報データを更新します
     *
     * @param sinsaseiEntity
     */
    @Transaction
    public void updSinsaSeikyusyomeisaiJoho(SinsaSeikyusyoTorokuEntity sinsaseiEntity) {
        DbT7001FufukuMoshitateEntity dbt7001Entity = 審査請求書登録dac.selectByKey(sinsaseiEntity.getShikibetsuCode(),
                sinsaseiEntity.getGenshobunsHihokennshaNo(), sinsaseiEntity.getShinsaSeikyuTodokedeYMD());
        dbt7001Entity.setShinsaSeikyuTodokedeYMD(sinsaseiEntity.getShinsaSeikyuTodokedeYMD());
        dbt7001Entity.setShinsaSeikyuninYubinNo(sinsaseiEntity.getShinsaSeikyuninYubinNo());
        dbt7001Entity.setShinsaSeikyuninJusho(sinsaseiEntity.getShinsaSeikyuninJusho());
        dbt7001Entity.setShinsaSeikyuninShimei(sinsaseiEntity.getShinsaSeikyuninShimei());
        dbt7001Entity.setShinsaSeikyuninTelNo(sinsaseiEntity.getShinsaSeikyuninTelNo());
        dbt7001Entity.setHihokenshaTonoKankeiCode(sinsaseiEntity.getHihokenshaTonoKankeiCode());
        dbt7001Entity.setHihokenshaTonoKankei(sinsaseiEntity.getHihokenshaTonoKankei());
        dbt7001Entity.setDairininYubinNo(sinsaseiEntity.getDairininYubinNo());
        dbt7001Entity.setDairininJusho(sinsaseiEntity.getDairininJusho());
        dbt7001Entity.setDairininShimei(sinsaseiEntity.getDairininShimei());
        dbt7001Entity.setDairininTelNo(sinsaseiEntity.getDairininTelNo());
        dbt7001Entity.setShobunCho(sinsaseiEntity.getShobunCho());
        dbt7001Entity.setShobunYMD(sinsaseiEntity.getShobunYMD());
        dbt7001Entity.setShobunShuruiCode(sinsaseiEntity.getShobunShuruiCode());
        dbt7001Entity.setShobunKakuninYMD(sinsaseiEntity.getShobunKakuninYMD());
        dbt7001Entity.setShinsaSeikyuRiyu(sinsaseiEntity.getShinsaSeikyuRiyu());
        dbt7001Entity.setShobunChoKyojiNaiyo(sinsaseiEntity.getShobunChoKyojiNaiyo());
        //TODO ※有り：TRUE  無し：FALSE
        dbt7001Entity.setTempuShoruiTo(true);
        dbt7001Entity.setShinsaSeikyuTorisageYMD(sinsaseiEntity.getShinsaSeikyuTorisageYMD());
        dbt7001Entity.setState(EntityDataState.Modified);
        審査請求書登録dac.save(dbt7001Entity);
    }

    /**
     * 審査請求書明細情報を削除します
     *
     * @param sinsaseiEntity
     */
    @Transaction
    public void delSinsaSeikyusyomeisaiJoho(SinsaSeikyusyoTorokuEntity sinsaseiEntity) {
        DbT7001FufukuMoshitateEntity dbt7001Entity = 審査請求書登録dac.selectByKey(sinsaseiEntity.getShikibetsuCode(),
                sinsaseiEntity.getGenshobunsHihokennshaNo(), sinsaseiEntity.getShinsaSeikyuTodokedeYMD());
        dbt7001Entity.setState(EntityDataState.Modified);
        審査請求書登録dac.save(dbt7001Entity);
    }

    /**
     * 審査請求届出日の重複チェック処理
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @param parameter
     *
     * @return チェックフラグ
     */
    public boolean checkSinsaSeikyuTodokede(ShikibetsuCode 識別コード, HihokenshaNo 原処分被保険者番号, FlexibleDate 審査請求届出日, ShoKofuKaishuJohoParameter parameter) {
        boolean isJuuHuku = true;
        DbT7001FufukuMoshitateEntity fufukuMoshitateEntity = 審査請求書登録dac.selectByKey(識別コード, 原処分被保険者番号, parameter.getShinsaSeikyuTodokedeYMD());
        if (fufukuMoshitateEntity == null) {
            return isJuuHuku;
        }
        if (画面モード_追加モード.equals(parameter.getGamennmodel())) {
            isJuuHuku = false;
        } else if (画面モード_修正モード.equals(parameter.getGamennmodel())) {
            if (!(fufukuMoshitateEntity.getShikibetsuCode() == 識別コード
                    && fufukuMoshitateEntity.getGenshobunsHihokennshaNo() == 原処分被保険者番号
                    && fufukuMoshitateEntity.getShinsaSeikyuTodokedeYMD() == 審査請求届出日)) {
                isJuuHuku = false;
            }
        }
        return isJuuHuku;
    }

}
