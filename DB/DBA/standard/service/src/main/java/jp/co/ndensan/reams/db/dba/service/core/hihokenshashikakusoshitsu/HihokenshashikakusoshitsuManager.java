/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakusoshitsu;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.entity.HihokenshaDaichoAddJyoho;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.SikakuKikan;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.TokusoRireki;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.sikakuidocheck.SikakuIdoCheckManager;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳管理（資格喪失）クラスです。
 *
 */
public class HihokenshashikakusoshitsuManager {

    /**
     * コンストラクタです。
     */
    public HihokenshashikakusoshitsuManager() {
    }

    /**
     * 被保険者台帳管理（資格喪失）登録処理
     *
     * @param addJyoho 被保険者台帳管理追加情報
     * @return 登録件数
     */
    public int saveHihokenshaShikakuSoshitsu(HihokenshaDaichoAddJyoho addJyoho) {
        RealInitialLocker.lock(new LockingKey(addJyoho.get被保険者番号()));

        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = manager.getSaishinDeta(addJyoho.get識別コード(), addJyoho.get被保険者番号());

        DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity = hihokenshaShutokuJyoho.get被保険者台帳管理();
        dbT1001HihokenshaDaichoEntity.setIdoYMD(addJyoho.get資格喪失年月日());
        dbT1001HihokenshaDaichoEntity.setIdoJiyuCode(addJyoho.get資格喪失事由コード());
        dbT1001HihokenshaDaichoEntity.setShikakuSoshitsuJiyuCode(addJyoho.get資格喪失事由コード());
        dbT1001HihokenshaDaichoEntity.setShikakuSoshitsuYMD(addJyoho.get資格喪失年月日());
        dbT1001HihokenshaDaichoEntity.setShikakuSoshitsuTodokedeYMD(addJyoho.get資格喪失届出年月日());

        RString edaNo = manager.getSaidaiEdaban(dbT1001HihokenshaDaichoEntity.getHihokenshaNo(), dbT1001HihokenshaDaichoEntity.getIdoYMD());
        dbT1001HihokenshaDaichoEntity.setEdaNo(edaNo);

        RealInitialLocker.release(new LockingKey(addJyoho.get被保険者番号()));

        DbT1001HihokenshaDaichoDac dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        dbT1001HihokenshaDaichoEntity.setState(EntityDataState.Added);
        return dac.save(dbT1001HihokenshaDaichoEntity);
    }

    /**
     * 資格喪失登録チェック処理
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 喪失年月日 喪失年月日
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     * @param tokusoRirekiList List<TokusoRireki>
     * @param sikakuKikanList List<SikakuKikan>
     * @return エラーコード
     */
    public RString ShikakuSoshitsuTorokuCheck(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            FlexibleDate 喪失年月日, IDateOfBirth 当該識別対象の生年月日, List<TokusoRireki> tokusoRirekiList, List<SikakuKikan> sikakuKikanList) {
        RString errorCode;
        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = manager.getSaishinDeta(識別コード, 被保険者番号);

        if (hihokenshaShutokuJyoho != null) {
            FlexibleDate 第1号資格取得年月日 = hihokenshaShutokuJyoho.get第1号資格取得年月日();
            if (第1号資格取得年月日 == null || 第1号資格取得年月日.isEmpty()) {
                AgeCalculator agecalculator = new AgeCalculator(当該識別対象の生年月日,
                        JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, 喪失年月日);
                if (Integer.valueOf(agecalculator.get年齢().toString()) >= 65) {
                    errorCode = new RString(DbaErrorMessages.年齢到達取得異動未登録.getMessage().getCode());
                    return errorCode;
                }
            }
            if (喪失年月日.isBefore(hihokenshaShutokuJyoho.get資格取得年月日())) {
                errorCode = new RString(DbzErrorMessages.期間が不正_未来日付不可.getMessage().getCode());
                return errorCode;
            }
            SikakuIdoCheckManager sikakuIdoCheckManager = SikakuIdoCheckManager.createInstance();
            errorCode = sikakuIdoCheckManager.sikakuKikanRirekiChofukuCheck(sikakuKikanList);
            if (!errorCode.isEmpty()) {
                return errorCode;
            }
            errorCode = sikakuIdoCheckManager.tokusouTanoKikanChofukuCheck(tokusoRirekiList, 識別コード);
            if (!errorCode.isEmpty()) {
                return errorCode;
            }
        } else {
            errorCode = new RString(DbaErrorMessages.資格喪失登録不可.getMessage().getCode());
        }
        return errorCode;
    }

    /**
     * 画面喪失チェック処理
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return エラーコード
     */
    public RString ShikakuSoshitsuCheck(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        RString errorCode = RString.EMPTY;
        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = manager.getSaishinDeta(識別コード, 被保険者番号);
        if (hihokenshaShutokuJyoho != null) {
            FlexibleDate 資格取得年月日 = hihokenshaShutokuJyoho.get資格取得年月日();
            FlexibleDate 資格喪失年月日 = hihokenshaShutokuJyoho.get資格喪失年月日();
            if ((資格取得年月日 != null && !資格取得年月日.isEmpty()) && (資格喪失年月日 == null || 資格喪失年月日.isEmpty())) {
                errorCode = new RString(DbaErrorMessages.住所地特例として適用済.getMessage().getCode());
            }
            if ((資格取得年月日 != null && !資格取得年月日.isEmpty()) && (資格喪失年月日 != null && !資格喪失年月日.isEmpty())) {
                errorCode = new RString(DbaErrorMessages.資格喪失登録不可.getMessage().getCode());
            }
        } else {
            errorCode = new RString(DbaErrorMessages.資格喪失登録不可.getMessage().getCode());
        }
        return errorCode;
    }
}
