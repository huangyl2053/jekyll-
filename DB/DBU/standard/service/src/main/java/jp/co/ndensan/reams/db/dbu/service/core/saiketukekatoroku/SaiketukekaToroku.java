/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.saiketukekatoroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.SaiketukekaMeisaiJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 *
 *
 */
public class SaiketukekaToroku {

    private final DbT7001FufukuMoshitateDac 不服審査申立情報dac;

    /**
     * SaiketukekaToroku
     */
    public SaiketukekaToroku() {
        不服審査申立情報dac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
    }

    /**
     * getSaiketukekaMeisaiJohoを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @return entity SaiketukekaMeisaiJoho
     */
    @Transaction
    public SaiketukekaMeisaiJoho getSaiketukekaMeisaiJoho(ShikibetsuCode 識別コード, HihokenshaNo 原処分被保険者番号, FlexibleDate 審査請求届出日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        DbT7001FufukuMoshitateEntity dbT7001entity = 不服審査申立情報dac.selectByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        SaiketukekaMeisaiJoho entity = new SaiketukekaMeisaiJoho();
        if (dbT7001entity != null) {
            entity.set弁明書作成日(dbT7001entity.getBemmeishoSakuseiYMD());
            entity.set裁決理由(dbT7001entity.getSaiketsuRiyu());
            entity.set裁決結果(dbT7001entity.getSaiketsuKekka());
            return entity;
        } else {
            return entity;
        }
    }

    /**
     * 裁決結果情報の更新処理
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @param 裁決結果 RString
     * @param 裁決理由 RString
     * @param 弁明書作成日 FlexibleDate
     * @return count
     */
    @Transaction
    public int updSaiketukekaMeisaiJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            RString 裁決結果,
            RString 裁決理由,
            FlexibleDate 弁明書作成日
    ) {

        DbT7001FufukuMoshitateEntity dbt7001Entity = 不服審査申立情報dac.selectByKey(識別コード,
                原処分被保険者番号, 審査請求届出日);
        dbt7001Entity.setSaiketsuKekka(裁決結果);
        dbt7001Entity.setSaiketsuRiyu(裁決理由);
        dbt7001Entity.setBemmeishoSakuseiYMD(弁明書作成日);
        dbt7001Entity.setState(EntityDataState.Modified);
        return 不服審査申立情報dac.save(dbt7001Entity);
    }

    /**
     * 裁決結果情報の削除処理
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 HihokenshaNo
     * @param 審査請求届出日 FlexibleDate
     * @return count
     */
    @Transaction
    public int delSaiketukekaMeisaiJoho(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日
    ) {
        DbT7001FufukuMoshitateEntity entity = 不服審査申立情報dac.selectByKey(識別コード,
                原処分被保険者番号, 審査請求届出日);
        entity.setShikibetsuCode(null);
        entity.setGenshobunsHihokennshaNo(null);
        entity.setShinsaSeikyuTodokedeYMD(null);
        entity.setState(EntityDataState.Modified);
        return 不服審査申立情報dac.save(entity);
    }
}
