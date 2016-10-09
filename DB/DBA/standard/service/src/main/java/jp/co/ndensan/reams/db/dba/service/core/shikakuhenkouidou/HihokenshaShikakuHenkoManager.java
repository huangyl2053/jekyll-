/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.shikakuhenkouidou;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho.HihokenshaShikakuShutokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理（資格変更）処理クラスです。
 *
 * @reamsid_L DBA-1370-010 chengsanyuan
 */
public class HihokenshaShikakuHenkoManager {

    private static final int AGE_65 = 65;
    private static final RString KOIKINAI_JUSHOCHI_FLAG_ARI = new RString("1");
    private static final RString FIRST_HIHOKENNSHA = new RString("1");
    private static final RString SEC_HIHOKENNSHA = new RString("2");
    private final HihokenshaShikakuShutokuManager manager;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;

    /**
     * コンストラクタです。
     *
     */
    HihokenshaShikakuHenkoManager() {
        this.manager = HihokenshaShikakuShutokuManager.createInstance();
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param manager HihokenshaShikakuShutokuManager
     * @param DbT1001HihokenshaDaichoDac dbT1001Dac
     */
    HihokenshaShikakuHenkoManager(HihokenshaShikakuShutokuManager manager, DbT1001HihokenshaDaichoDac dbT1001Dac) {
        this.manager = manager;
        this.dbT1001Dac = dbT1001Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuHenkoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuHenkoManager}のインスタンス
     */
    public static HihokenshaShikakuHenkoManager createInstance() {
        return InstanceProvider.create(HihokenshaShikakuHenkoManager.class);
    }

    /**
     * 入力した内容を被保険者台帳管理（資格変更）に登録します。
     *
     * @param 被保険者台帳管理変更情報 被保険者台帳管理変更情報
     */
    @Transaction
    public void saveHihokenshaHenko(HihokenshaDaicho 被保険者台帳管理変更情報) {
        HihokenshaShutokuJyoho hihokensha = manager.getSaishinDeta(
                被保険者台帳管理変更情報.get識別コード(), 被保険者台帳管理変更情報.get被保険者番号());
        DbT1001HihokenshaDaichoEntity entity = setEntity(hihokensha, 被保険者台帳管理変更情報);
        entity.setEdaNo(manager.getSaidaiEdaban(hihokensha.get被保険者番号(), hihokensha.get異動日()));
        if (ShikakuHenkoJiyu.広域内転居.getコード().equals(被保険者台帳管理変更情報.get資格変更事由コード())) {
            entity.setShichosonCode(被保険者台帳管理変更情報.get市町村コード());
            entity.setShikibetsuCode(被保険者台帳管理変更情報.get識別コード());
        }
        if (ShikakuHenkoJiyu.広住特転居.getコード().equals(被保険者台帳管理変更情報.get資格変更事由コード())) {
            entity.setShichosonCode(被保険者台帳管理変更情報.get市町村コード());
            entity.setShikibetsuCode(被保険者台帳管理変更情報.get識別コード());
        }
        if (ShikakuHenkoJiyu.広住特適用.getコード().equals(被保険者台帳管理変更情報.get資格変更事由コード())) {
            entity.setShichosonCode(被保険者台帳管理変更情報.get市町村コード());
            entity.setShikibetsuCode(被保険者台帳管理変更情報.get識別コード());
            entity.setKoikinaiTokureiSochimotoShichosonCode(被保険者台帳管理変更情報.get広住特措置元市町村コード());
            entity.setKoikinaiJushochiTokureiFlag(KOIKINAI_JUSHOCHI_FLAG_ARI);
        }
        if (ShikakuHenkoJiyu.広住特転入.getコード().equals(被保険者台帳管理変更情報.get資格変更事由コード())) {
            entity.setShichosonCode(被保険者台帳管理変更情報.get市町村コード());
            entity.setShikibetsuCode(被保険者台帳管理変更情報.get識別コード());
            entity.setKoikinaiTokureiSochimotoShichosonCode(LasdecCode.EMPTY);
            entity.setKoikinaiJushochiTokureiFlag(RString.EMPTY);
        }
        if (ShikakuHenkoJiyu.広住特居住.getコード().equals(被保険者台帳管理変更情報.get資格変更事由コード())) {
            entity.setKoikinaiTokureiSochimotoShichosonCode(LasdecCode.EMPTY);
            entity.setKoikinaiJushochiTokureiFlag(RString.EMPTY);
        }
        if (ShikakuHenkoJiyu.合併内転居.getコード().equals(被保険者台帳管理変更情報.get資格変更事由コード())) {
            entity.setKyuShichosonCode(被保険者台帳管理変更情報.get旧市町村コード());
        }
        if (ShikakuHenkoJiyu._１号到達.getコード().equals(被保険者台帳管理変更情報.get資格変更事由コード())) {
            entity.setIchigoShikakuShutokuYMD(hihokensha.get資格変更年月日());
            entity.setHihokennshaKubunCode(FIRST_HIHOKENNSHA);
        }
        dbT1001Dac.save(entity);
    }

    private DbT1001HihokenshaDaichoEntity setEntity(HihokenshaShutokuJyoho hihokensha,
            HihokenshaDaicho 被保険者台帳管理変更情報) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setHihokenshaNo(hihokensha.get被保険者番号());
        entity.setIdoYMD(被保険者台帳管理変更情報.get資格変更年月日());
        entity.setIdoJiyuCode(被保険者台帳管理変更情報.get資格変更事由コード());
        entity.setShichosonCode(hihokensha.get市町村コード());
        entity.setShikibetsuCode(hihokensha.get識別コード());
        entity.setShikakuShutokuJiyuCode(hihokensha.get資格取得事由コード());
        entity.setShikakuShutokuYMD(hihokensha.get資格取得年月日());
        entity.setShikakuShutokuTodokedeYMD(hihokensha.get資格取得届出年月日());
        entity.setIchigoShikakuShutokuYMD(hihokensha.get第1号資格取得年月日());
        entity.setHihokennshaKubunCode(hihokensha.get被保険者区分コード());
        entity.setShikakuSoshitsuJiyuCode(hihokensha.get資格喪失事由コード());
        entity.setShikakuSoshitsuYMD(hihokensha.get資格喪失年月日());
        entity.setShikakuSoshitsuTodokedeYMD(hihokensha.get資格喪失届出年月日());
        entity.setShikakuHenkoJiyuCode(被保険者台帳管理変更情報.get資格変更事由コード());
        entity.setShikakuHenkoYMD(被保険者台帳管理変更情報.get資格変更年月日());
        entity.setShikakuHenkoTodokedeYMD(被保険者台帳管理変更情報.get資格変更届出年月日());
        entity.setJushochitokureiTekiyoJiyuCode(hihokensha.get住所地特例適用事由コード());
        entity.setJushochitokureiTekiyoYMD(hihokensha.get適用年月日());
        entity.setJushochitokureiTekiyoTodokedeYMD(hihokensha.get適用届出年月日());
        entity.setJushochitokureiKaijoJiyuCode(hihokensha.get住所地特例解除事由コード());
        entity.setJushochitokureiKaijoYMD(hihokensha.get解除年月日());
        entity.setJushochitokureiKaijoTodokedeYMD(hihokensha.get解除届出年月日());
        entity.setJushochiTokureiFlag(hihokensha.get住所地特例フラグ());
        entity.setKoikinaiJushochiTokureiFlag(hihokensha.get広域内住所地特例フラグ());
        entity.setKoikinaiTokureiSochimotoShichosonCode(hihokensha.get広住特措置元市町村コード());
        entity.setKyuShichosonCode(hihokensha.get旧市町村コード());
        entity.setIsDeleted(hihokensha.is論理削除フラグ());
        return entity;
    }

    /**
     * 資格変更登録チェック処理
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 変更日 変更日
     * @param 変更事由コード 変更事由コード
     * @param 生年月日 生年月日
     * @return DbaErrorMessages エラーコード
     */
    public DbaErrorMessages shikakuHenkoTorokuCheck(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            FlexibleDate 変更日, ShikakuHenkoJiyu 変更事由コード, FlexibleDate 生年月日) {
        HihokenshaShutokuJyoho hihokensha = manager.getSaishinDeta(
                識別コード, 被保険者番号);
        if (!hihokensha.get異動日().isBeforeOrEquals(変更日)) {
            return DbaErrorMessages.変更日移行新資格異動有り;
        }
        AgeCalculator ageCalculator = new AgeCalculator(
                DateOfBirthFactory.createInstance(生年月日), JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, 変更日);
        RString 年齢 = ageCalculator.get年齢();
        if (FIRST_HIHOKENNSHA.equals(hihokensha.get被保険者区分コード())) {
            if (AGE_65 <= Integer.parseInt(年齢.toString()) && ShikakuHenkoJiyu._１号到達 == 変更事由コード) {
                return DbaErrorMessages._１号被保険者対象外資格変更事由;
            }
            if (AGE_65 == Integer.parseInt(年齢.toString())) {
                return DbaErrorMessages.変更日１号年齢到達日以前;
            }
        }
        if (SEC_HIHOKENNSHA.equals(hihokensha.get被保険者区分コード())) {
            FlexibleDate age = ageCalculator.get年齢到達日(AGE_65);
            if (AGE_65 < Integer.parseInt(年齢.toString()) && ShikakuHenkoJiyu._１号到達 != 変更事由コード) {
                return DbaErrorMessages.年齢到達変更異動未登録;
            }
            if (AGE_65 < Integer.parseInt(年齢.toString()) && ShikakuHenkoJiyu._１号到達 == 変更事由コード && !変更日.equals(age)) {
                return DbaErrorMessages.変更日１号年齢到達日不一致;
            }
            if (AGE_65 == Integer.parseInt(年齢.toString()) && ShikakuHenkoJiyu._１号到達 == 変更事由コード) {
                return DbaErrorMessages.変更日１号年齢到達日不一致;
            }
        }
        if (ShikakuHenkoJiyu.広住特転入 == 変更事由コード || ShikakuHenkoJiyu.広住特居住 == 変更事由コード
                && !KOIKINAI_JUSHOCHI_FLAG_ARI.equals(hihokensha.get広域内住所地特例フラグ())) {
            return DbaErrorMessages.広域内住所地特例者でない;
        }
        return null;
    }
}
