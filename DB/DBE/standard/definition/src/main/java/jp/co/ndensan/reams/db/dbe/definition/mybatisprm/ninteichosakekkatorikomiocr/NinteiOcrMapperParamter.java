/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査結果取込みの検索用パラメータクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiOcrMapperParamter {

    private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    private final RString 認定申請日;

    private NinteiOcrMapperParamter(RString 証記載保険者番号,
            RString 被保険者番号,
            RString 認定申請日) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.認定申請日 = 認定申請日;
    }

    /**
     * 認定調査結果取込みの検索用パラメータを作成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請日 認定申請日
     * @return 認定調査結果取込みの検索用パラメータ
     */
    public static NinteiOcrMapperParamter createParamter(RString 証記載保険者番号,
            RString 被保険者番号,
            RString 認定申請日) {
        return new NinteiOcrMapperParamter(証記載保険者番号, 被保険者番号, 認定申請日);
    }

}
