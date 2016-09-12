/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定情報提供を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class YokaigoNinteiJohoTeiParameter {

    private final RString 被保険者番号;
    private final RString 証記載保険者番号;
    private final RString 支所コード;
    private final boolean shishoKengenuser;
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();

    private YokaigoNinteiJohoTeiParameter(RString 被保険者番号, RString 証記載保険者番号, RString 支所コード,
            boolean shishoKengenuser) {
        this.被保険者番号 = 被保険者番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.shishoKengenuser = shishoKengenuser;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param shishoKengenuser 支所条件
     * @return 被保険者情報パラメータ
     */
    public static YokaigoNinteiJohoTeiParameter createParameter(RString 被保険者番号, RString 証記載保険者番号,
            RString 支所コード, boolean shishoKengenuser) {
        shishoKengenuser = false;
        if (!RString.isNullOrEmpty(支所コード)) {
            shishoKengenuser = true;
        }
        return new YokaigoNinteiJohoTeiParameter(被保険者番号, 証記載保険者番号, 支所コード, shishoKengenuser);
    }
}
