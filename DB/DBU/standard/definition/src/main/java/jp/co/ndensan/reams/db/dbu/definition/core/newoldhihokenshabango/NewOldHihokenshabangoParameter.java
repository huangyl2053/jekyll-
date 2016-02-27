/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.newoldhihokenshabango;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 新旧被保険者番号変換のパラメタクラスです。
 *
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NewOldHihokenshabangoParameter {

    private final LasdecCode shichosonCode;
    private final RString shinNo;
    private final RString kyuNo;
    private final LasdecCode kyuShichosonCode;
    private final RString kyuNo2;

    private NewOldHihokenshabangoParameter(
            LasdecCode shichosonCode,
            RString shinNo,
            RString kyuNo,
            LasdecCode kyuShichosonCode,
            RString kyuNo2) {
        this.shichosonCode = shichosonCode;
        this.shinNo = shinNo;
        this.kyuNo = kyuNo;
        this.kyuShichosonCode = kyuShichosonCode;
        this.kyuNo2 = kyuNo2;
    }

    /**
     * 新旧被保険者番号変換のパラメータです。
     *
     * @param shichosonCode 市町村コード
     * @param shinNo 新番号
     * @param kyuNo 旧番号
     * @param kyuShichosonCode 旧市町村コード２
     * @param kyuNo2 旧番号２
     * @return NewOldHihokenshabangoParameter 新旧被保険者番号変換のパラメータ
     */

    public static NewOldHihokenshabangoParameter createParam_NewOldHihoken(
            LasdecCode shichosonCode,
            RString shinNo,
            RString kyuNo,
            LasdecCode kyuShichosonCode,
            RString kyuNo2) {
        return new NewOldHihokenshabangoParameter(
                shichosonCode,
                shinNo,
                kyuNo,
                kyuShichosonCode,
                kyuNo2);
    }
}
