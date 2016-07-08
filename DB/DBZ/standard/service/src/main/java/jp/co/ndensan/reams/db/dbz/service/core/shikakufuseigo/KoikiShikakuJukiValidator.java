/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakufuseigo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu.FuseigoRiyu;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格不整合チェック_広域クラス
 *
 * @reamsid_L DBB-0630-040 chengsanyuan
 */
public class KoikiShikakuJukiValidator {

    /**
     * コンストラクタです。
     */
    KoikiShikakuJukiValidator() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoikiShikakuJukiValidator}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoikiShikakuJukiValidator}のインスタンス
     */
    public static KoikiShikakuJukiValidator createInstance() {
        return InstanceProvider.create(KoikiShikakuJukiValidator.class);
    }

    /**
     * パラメータの個人と、被保険者台帳の情報を比較して、不整合チェック結果オブジェクトのインスタンスを返却します。
     *
     * @param 個人情報 IKojin
     * @param 資格の情報1 HihokenshaDaicho
     * @param 資格の情報2 HihokenshaDaicho
     * @return FuseigoRiyu
     * @throws IllegalStateException
     */
    public FuseigoRiyu checkFor資格不整合(IKojin 個人情報, HihokenshaDaicho 資格の情報1, HihokenshaDaicho 資格の情報2) {
        if (資格の情報1 != null && 資格の情報1.get識別コード().compareTo(個人情報.get識別コード()) != 0) {
            throw new IllegalStateException("同一人の比較にならないため");
        }
        if (資格の情報2 != null) {
            if (資格の情報1 == null) {
                throw new IllegalStateException("資格の情報2は資格の情報1の次の履歴として扱うため、資格の情報1が存在していなければおかしい");
            }
            if (資格の情報1.get被保険者番号().compareTo(資格の情報2.get被保険者番号()) != 0) {
                throw new IllegalStateException("同一人の比較にならないため");
            }
            if (資格の情報1.get識別コード().compareTo(資格の情報2.get識別コード()) != 0) {
                throw new IllegalStateException("別の構成市町村での履歴と比較したいため");
            }
            if (資格の情報1.get異動日().isBeforeOrEquals(資格の情報2.get異動日())) {
                throw new IllegalStateException("履歴の比較にならないため");
            }
        }
        ShikakuJukiValidator validator = ShikakuJukiValidator.createInstance();
        FuseigoRiyu 不整合理由 = validator.checkFor資格不整合(個人情報, 資格の情報1);
        if (不整合理由 == FuseigoRiyu.資格取得者_転出者) {
            return null;
        }
        return 不整合理由;
    }

    /**
     * パラメータの個人と、被保険者台帳の情報を比較して、バリデーションメッセージを返却します。
     *
     * @param 個人情報 IKojin
     * @param 資格の情報1 HihokenshaDaicho
     * @param 資格の情報2 HihokenshaDaicho
     * @return Map<RString, DbzErrorMessages>
     */
    public Map<RString, DbzErrorMessages> validate(IKojin 個人情報, HihokenshaDaicho 資格の情報1, HihokenshaDaicho 資格の情報2) {
        ShikakuJukiValidator validator = ShikakuJukiValidator.createInstance();
        return validator.createValidationMessages(checkFor資格不整合(個人情報, 資格の情報1, 資格の情報2), 個人情報, 資格の情報1.get資格喪失年月日());
    }
}
