/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaiyukokikankaishidate;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * {@link GogitaiYukoKikanKaishiDate}のバリデータークラスです。
 */
public class GogitaiYukoKikanKaishiDateValidator {

    private final GogitaiYukoKikanKaishiDate gogitaiYukoKikanKaishiDate;

    /**
     * コンストラクタです。
     *
     * @param gogitaiYukoKikanKaishiDate
     */
    public GogitaiYukoKikanKaishiDateValidator(GogitaiYukoKikanKaishiDate gogitaiYukoKikanKaishiDate) {
        requireNonNull(gogitaiYukoKikanKaishiDate, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体（介護認定審査会）の長や長代理、委員などの区分コード"));
        this.gogitaiYukoKikanKaishiDate = gogitaiYukoKikanKaishiDate;
    }

    /**
     * 保持するvalue{@link RString}について{@link GogitaiYukoKikanKaishiDate}の仕様を満たすかどうか検証し、<br/>
     * 結果として{@link IValidationMessages}を返します。
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages validate() {
        return ValidateChain.validateStart(gogitaiYukoKikanKaishiDate)
                .messages();
    }
}
