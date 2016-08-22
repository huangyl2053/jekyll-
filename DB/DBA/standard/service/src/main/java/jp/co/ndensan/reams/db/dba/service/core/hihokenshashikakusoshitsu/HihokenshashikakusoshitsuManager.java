/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshashikakusoshitsu;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
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
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 被保険者台帳管理（資格喪失）クラスです。
 *
 * @reamsid_L DBA-0552-010 huangh
 */
public class HihokenshashikakusoshitsuManager {

    private static final int 年齢_65 = 65;
    private static final RString SIKAKU_SOUSITU_YMD = new RString("資格喪失年月日");
    private static final RString SIKAKU_SYUTOKU_YMD = new RString("資格取得年月日");

    /**
     * コンストラクタです。
     */
    public HihokenshashikakusoshitsuManager() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshashoHakkoKanriboFinder}のインスタンスを返します。
     *
     * @return HihokenshashoHakkoKanriboFinder
     */
    public static HihokenshashikakusoshitsuManager createInstance() {
        return InstanceProvider.create(HihokenshashikakusoshitsuManager.class);
    }

    /**
     * 被保険者台帳管理（資格喪失）登録処理
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 資格喪失年月日 資格喪失年月日
     * @param 資格喪失事由コード 資格喪失事由コード
     * @param 資格喪失届出年月日 資格喪失届出年月日
     *
     * @return 登録件数
     */
    public int saveHihokenshaShikakuSoshitsu(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 資格喪失年月日,
            RString 資格喪失事由コード, FlexibleDate 資格喪失届出年月日) {
        RealInitialLocker.lock(new LockingKey(被保険者番号));

        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = manager.getSaishinDeta(識別コード, 被保険者番号);

        DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity = hihokenshaShutokuJyoho.get被保険者台帳管理();
        dbT1001HihokenshaDaichoEntity.setIdoYMD(資格喪失年月日);
        dbT1001HihokenshaDaichoEntity.setIdoJiyuCode(ShikakuSoshitsuJiyu.他特例者.getコード());
        dbT1001HihokenshaDaichoEntity.setShikakuSoshitsuJiyuCode(ShikakuSoshitsuJiyu.他特例者.getコード());
        dbT1001HihokenshaDaichoEntity.setShikakuSoshitsuYMD(資格喪失年月日);
        dbT1001HihokenshaDaichoEntity.setShikakuSoshitsuTodokedeYMD(資格喪失届出年月日);

        RString edaNo = manager.getSaidaiEdaban(dbT1001HihokenshaDaichoEntity.getHihokenshaNo(), dbT1001HihokenshaDaichoEntity.getIdoYMD());
        dbT1001HihokenshaDaichoEntity.setEdaNo(edaNo);

        RealInitialLocker.release(new LockingKey(被保険者番号));

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
     */
    public void shikakuSoshitsuTorokuCheck(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            FlexibleDate 喪失年月日, IDateOfBirth 当該識別対象の生年月日, List<TokusoRireki> tokusoRirekiList, List<SikakuKikan> sikakuKikanList) {
        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = manager.getSaishinDeta(識別コード, 被保険者番号);
        if (hihokenshaShutokuJyoho != null) {
            年齢到達取得異動未登録Check(識別コード, 喪失年月日, 当該識別対象の生年月日,
                    hihokenshaShutokuJyoho, tokusoRirekiList, sikakuKikanList);
        } else {
            throw new ApplicationException(DbaErrorMessages.資格喪失登録不可.getMessage());
        }
    }

    /**
     * 画面喪失チェック処理
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public boolean shikakuSoshitsuCheck(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        HihokenshaShikakuShutokuManager manager = HihokenshaShikakuShutokuManager.createInstance();
        HihokenshaShutokuJyoho hihokenshaShutokuJyoho = manager.getSaishinDeta(識別コード, 被保険者番号);
        if (hihokenshaShutokuJyoho != null) {
            FlexibleDate 資格取得年月日 = hihokenshaShutokuJyoho.get資格取得年月日();
            FlexibleDate 資格喪失年月日 = hihokenshaShutokuJyoho.get資格喪失年月日();
            if ((資格喪失年月日 != null && !資格喪失年月日.isEmpty())) {
                解除期間情報の判定(hihokenshaShutokuJyoho);
            }
            if ((資格喪失年月日 == null || 資格喪失年月日.isEmpty())) {
                解除期間情報の再判定(hihokenshaShutokuJyoho);
            }
            if ((資格取得年月日 != null && !資格取得年月日.isEmpty()) && (資格喪失年月日 != null && !資格喪失年月日.isEmpty())) {
                throw new ApplicationException(DbaErrorMessages.資格喪失登録不可.getMessage());
            }
        return(true) ;
        }
        else{
            return(false);
        }
    }

    private void 解除期間情報の判定(HihokenshaShutokuJyoho hihokenshaShutokuJyoho) {
        FlexibleDate 適用年月日 = hihokenshaShutokuJyoho.get適用年月日();
        FlexibleDate 資格喪失日 = hihokenshaShutokuJyoho.get資格喪失年月日();
        if ((適用年月日 != null && !適用年月日.isEmpty())) {
            if ((資格喪失日.compareTo(適用年月日))>0) {
            throw new ApplicationException(DbzErrorMessages.他の期間情報との期間重複.getMessage());
            }
        }
    }
  
    private void 解除期間情報の再判定(HihokenshaShutokuJyoho hihokenshaShutokuJyoho) {
        FlexibleDate 適用年月日 = hihokenshaShutokuJyoho.get適用年月日();
            FlexibleDate 資格取得年月日 = hihokenshaShutokuJyoho.get資格取得年月日();
        if ((適用年月日 != null && !適用年月日.isEmpty())) {
            if ((資格取得年月日.compareTo(適用年月日))>0) {
            throw new ApplicationException(DbzErrorMessages.他の期間情報との期間重複.getMessage());
            }
        }
    }

    private void 年齢到達取得異動未登録Check(ShikibetsuCode 識別コード, FlexibleDate 喪失年月日, IDateOfBirth 当該識別対象の生年月日,
            HihokenshaShutokuJyoho hihokenshaShutokuJyoho, List<TokusoRireki> tokusoRirekiList, List<SikakuKikan> sikakuKikanList) {
        FlexibleDate 第1号資格取得年月日 = hihokenshaShutokuJyoho.get第1号資格取得年月日();
        if (第1号資格取得年月日 == null || 第1号資格取得年月日.isEmpty()) {
            AgeCalculator agecalculator = new AgeCalculator(当該識別対象の生年月日,
                    JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, 喪失年月日);
            if (Integer.valueOf(agecalculator.get年齢().toString()) >= 年齢_65) {
                throw new ApplicationException(DbaErrorMessages.年齢到達取得異動未登録.getMessage());
            }
        }

        if (喪失年月日.isBefore(hihokenshaShutokuJyoho.get資格取得年月日())) {
            throw new ApplicationException(DbzErrorMessages.期間が不正_過去日付不可.getMessage()
                    .replace(SIKAKU_SOUSITU_YMD.toString(), SIKAKU_SYUTOKU_YMD.toString()));
        }

        SikakuIdoCheckManager sikakuIdoCheckManager = SikakuIdoCheckManager.createInstance();
        sikakuIdoCheckManager.sikakuKikanRirekiChofukuCheck(sikakuKikanList);
        sikakuIdoCheckManager.tokusouTanoKikanChofukuCheck(tokusoRirekiList, 識別コード);
    }
}
