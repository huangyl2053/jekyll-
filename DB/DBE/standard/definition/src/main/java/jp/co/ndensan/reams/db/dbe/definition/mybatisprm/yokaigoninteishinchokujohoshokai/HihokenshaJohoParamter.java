/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteishinchokujohoshokai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class HihokenshaJohoParamter {

     private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    
    private HihokenshaJohoParamter(RString 証記載保険者番号, RString 被保険者番号) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @return 被保険者情報パラメータ
     */
    public static HihokenshaJohoParamter createParameter(RString 証記載保険者番号, RString 被保険者番号) {
        return new HihokenshaJohoParamter(証記載保険者番号, 被保険者番号);
    }
}
