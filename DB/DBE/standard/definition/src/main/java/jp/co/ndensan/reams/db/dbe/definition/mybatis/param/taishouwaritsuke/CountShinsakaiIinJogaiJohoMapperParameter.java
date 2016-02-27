/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会対象者申請者オブザーバーチェックパラメータクラス。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class CountShinsakaiIinJogaiJohoMapperParameter {

    private final RString shinseishoKanriNo;
    private final RString kaisaiNo;

    private CountShinsakaiIinJogaiJohoMapperParameter(RString shinseishoKanriNo, RString kaisaiNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.kaisaiNo = kaisaiNo;
    }

    /**
     * 介護認定審査会対象者申請者オブザーバーチェックパラメータ作成
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param kaisaiNo 開催番号
     * @return 介護認定審査会対象者申請者オブザーバーチェックパラメータ
     */
    public static CountShinsakaiIinJogaiJohoMapperParameter createCountShinsakaiIinJogaiJohoMapperParameter(
            RString shinseishoKanriNo, RString kaisaiNo) {
        return new CountShinsakaiIinJogaiJohoMapperParameter(shinseishoKanriNo, kaisaiNo);
    }
}
