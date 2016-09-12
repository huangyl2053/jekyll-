/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.FuseigoCheckResult;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.FuseigoCheckResultOfTatokurei;
import jp.co.ndensan.reams.db.dbz.business.core.shikakufuseigo.FuseigoCheckResultOfTekiyoJogai;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakufuseigo.DaichoFuseigoJotai;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.hihokenshadaicho.HihokenshaDaichoSearchCondition;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.TashichosonJushochiTokureiManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.TekiyoJogaishaManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格不整合修正サービスクラス
 *
 * @reamsid_L DBB-0630-050 chengsanyuan
 */
public class ShikakuFuseigoShuseiService {

    private final HihokenshaDaichoManager dbt1001manager;
    private final TekiyoJogaishaManager dbt1002manager;
    private final TashichosonJushochiTokureiManager dbt1003manager;

    /**
     * コンストラクタです。
     */
    ShikakuFuseigoShuseiService() {
        dbt1001manager = HihokenshaDaichoManager.createInstance();
        dbt1002manager = TekiyoJogaishaManager.createInstance();
        dbt1003manager = TashichosonJushochiTokureiManager.createInstance();
    }

    /**
     * テスト用コンストラクタです。
     */
    ShikakuFuseigoShuseiService(HihokenshaDaichoManager dbt1001manager,
            TekiyoJogaishaManager dbt1002manager, TashichosonJushochiTokureiManager dbt1003manager) {
        this.dbt1001manager = dbt1001manager;
        this.dbt1002manager = dbt1002manager;
        this.dbt1003manager = dbt1003manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuFuseigoShuseiService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShikakuFuseigoShuseiService}のインスタンス
     */
    public static ShikakuFuseigoShuseiService createInstance() {
        return InstanceProvider.create(ShikakuFuseigoShuseiService.class);
    }

    /**
     * パラメータの個人と、被保険者番号から取得した被保険者台帳の情報を比較して、<br>
     * 不整合チェック結果オブジェクトのインスタンスを返却します。
     *
     * @param 個人情報 IKojin
     * @param 被保険者番号 HihokenshaNo
     * @return FuseigoCheckResult
     */
    public FuseigoCheckResult checkAndCorrect被保険者資格不整合(IKojin 個人情報, HihokenshaNo 被保険者番号) {
        FuseigoCheckResult result = new FuseigoCheckResult();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            return null;
        }
        HihokenshaDaicho 資格の情報 = dbt1001manager.find資格の情報(
                HihokenshaDaichoSearchCondition.createSelectByKeyParam(被保険者番号, true));
        FuseigoRiyu 不整合理由 = null;
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            KoikiShikakuJukiValidator validator = KoikiShikakuJukiValidator.createInstance();
            if (資格の情報 == null) {
                不整合理由 = validator.checkFor資格不整合(個人情報, null, null);
            } else {
                不整合理由 = validator.checkFor資格不整合(個人情報, 資格の情報,
                        dbt1001manager.get資格の情報For資格不整合(被保険者番号, 資格の情報.get識別コード(), 資格の情報.get異動日()));
            }
        } else {
            ShikakuJukiValidator validator = ShikakuJukiValidator.createInstance();
            不整合理由 = validator.checkFor資格不整合(個人情報, 資格の情報);
        }
        HihokenshaDaicho 修正後の資格の情報 = null;
        if (不整合理由 != null && FuseigoRiyu.資格管理情報未登録者 != 不整合理由) {
            ShikakuFuseigoCorrector corrector = ShikakuFuseigoCorrector.createInstance();
            修正後の資格の情報 = corrector.correct資格不整合(資格の情報, 個人情報, 不整合理由);
        }
        result.set不整合理由(不整合理由);
        result.set個人(個人情報);
        result.set現在の資格の情報(資格の情報);
        result.set修正後の資格の情報(修正後の資格の情報);
        if (資格の情報 == null) {
            result.set被保険者台帳状態(DaichoFuseigoJotai.未作成);
        } else {
            if (不整合理由 == null) {
                result.set被保険者台帳状態(DaichoFuseigoJotai.不整合なし);
            } else {
                result.set被保険者台帳状態(DaichoFuseigoJotai.不整合あり);
            }
        }

        return result;
    }

    /**
     * パラメータの個人と、識別コードから取得した適用除外者の情報を比較して、<br>
     * 不整合チェック結果オブジェクトのインスタンスを返却します。
     *
     * @param 個人情報 IKojin
     * @param 識別コード ShikibetsuCode
     * @return 不整合チェック結果
     */
    public FuseigoCheckResultOfTekiyoJogai checkAndCorrect適用除外者不整合(IKojin 個人情報, ShikibetsuCode 識別コード) {
        FuseigoCheckResultOfTekiyoJogai result = new FuseigoCheckResultOfTekiyoJogai();
        if (識別コード == null || 識別コード.isEmpty()) {
            return null;
        }
        TekiyoJogaisha 除外の情報 = dbt1002manager.get適用除外者By識別(識別コード);
        ShikakuJukiValidator validator = ShikakuJukiValidator.createInstance();
        FuseigoRiyu 不整合理由 = validator.checkFor除外不整合(個人情報, 除外の情報);
        TekiyoJogaisha 除外の情報修正後 = null;
        if (不整合理由 != null) {
            ShikakuFuseigoCorrector corrector = ShikakuFuseigoCorrector.createInstance();
            除外の情報修正後 = corrector.correct除外不整合(除外の情報, 個人情報, 不整合理由);
        }
        result.set不整合理由(不整合理由);
        result.set現在の除外の情報(除外の情報);
        result.set個人(個人情報);
        result.set修正後の除外の情報(除外の情報修正後);
        if (除外の情報 == null) {
            result.set適用除外者台帳状態(DaichoFuseigoJotai.未作成);
        }
        if (不整合理由 == null) {
            result.set適用除外者台帳状態(DaichoFuseigoJotai.不整合なし);
        } else {
            result.set適用除外者台帳状態(DaichoFuseigoJotai.不整合あり);
        }
        return result;
    }

    /**
     * パラメータの個人と、識別コードから取得した他市町村住所地特例の情報を比較して、<br>
     * 不整合チェック結果オブジェクトのインスタンスを返却します。
     *
     * @param 個人情報 IKojin
     * @param 識別コード ShikibetsuCode
     * @return FuseigoCheckResultOfTatokurei
     */
    public FuseigoCheckResultOfTatokurei checkAndCorrect他特例不整合(IKojin 個人情報, ShikibetsuCode 識別コード) {
        FuseigoCheckResultOfTatokurei result = new FuseigoCheckResultOfTatokurei();
        if (識別コード == null || 識別コード.isEmpty()) {
            return null;
        }
        TashichosonJushochiTokurei 他特の情報 = dbt1003manager.get他市町村住所地特例By識別(識別コード);
        ShikakuJukiValidator validator = ShikakuJukiValidator.createInstance();
        FuseigoRiyu 不整合理由 = validator.checkFor他特不整合(個人情報, 他特の情報);
        TashichosonJushochiTokurei 他特の情報修正後 = null;
        if (不整合理由 != null) {
            ShikakuFuseigoCorrector corrector = ShikakuFuseigoCorrector.createInstance();
            他特の情報修正後 = corrector.correct他特例不整合(他特の情報, 個人情報, 不整合理由);
        }
        result.set不整合理由(不整合理由);
        result.set現在の他特の情報(他特の情報);
        result.set個人(個人情報);
        result.set修正後の他特の情報(他特の情報修正後);
        if (他特の情報 == null) {
            result.set他市町村住所地特例台帳状態(DaichoFuseigoJotai.未作成);
        }
        if (不整合理由 == null) {
            result.set他市町村住所地特例台帳状態(DaichoFuseigoJotai.不整合なし);
        } else {
            result.set他市町村住所地特例台帳状態(DaichoFuseigoJotai.不整合あり);
        }
        return result;
    }

    /**
     * パラメータの個人と、被保険者台帳の情報を比較して、バリデーションメッセージを返却します。
     *
     * @param 個人情報 IKojin
     * @param 資格の情報 HihokenshaDaicho
     * @return Map<RString, DbzErrorMessages>
     */
    public Map<RString, DbzErrorMessages> validate被保台帳整合(IKojin 個人情報, HihokenshaDaicho 資格の情報) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            KoikiShikakuJukiValidator validator = KoikiShikakuJukiValidator.createInstance();
            return validator.validate(個人情報, 資格の情報, dbt1001manager.get資格の情報For資格不整合(
                    資格の情報.get被保険者番号(), 資格の情報.get識別コード(), 資格の情報.get異動日()));
        }
        return ShikakuJukiValidator.createInstance().validate(個人情報, 資格の情報);
    }

    /**
     * パラメータの個人と、適用除外者の情報を比較して、バリデーションメッセージを返却します。
     *
     * @param 個人情報 IKojin
     * @param 除外の情報 TekiyoJogaisha
     * @return Map<RString, DbzErrorMessages>
     */
    public Map<RString, DbzErrorMessages> validate被保台帳整合(IKojin 個人情報, TekiyoJogaisha 除外の情報) {
        return ShikakuJukiValidator.createInstance().validate適用除外者(個人情報, 除外の情報);
    }

    /**
     * パラメータの個人と、他市町村住所地特例の情報を比較して、バリデーションメッセージを返却します。
     *
     * @param 個人情報 IKojin
     * @param 他特の情報 TashichosonJushochiTokurei
     * @return Map<RString, DbzErrorMessages>
     */
    public Map<RString, DbzErrorMessages> validate被保台帳整合(IKojin 個人情報, TashichosonJushochiTokurei 他特の情報) {
        return ShikakuJukiValidator.createInstance().validate他特例(個人情報, 他特の情報);
    }
}
