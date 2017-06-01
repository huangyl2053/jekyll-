/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
    private final RString 申請書管理番号;

    private NinteiOcrMapperParamter(RString 証記載保険者番号,
            RString 被保険者番号,
            RString 認定申請日) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.認定申請日 = 認定申請日;
        this.申請書管理番号 = RString.EMPTY;
    }

    private NinteiOcrMapperParamter(RString 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
        this.証記載保険者番号 = RString.EMPTY;
        this.被保険者番号 = RString.EMPTY;
        this.認定申請日 = RString.EMPTY;
    }

    /**
     * 認定調査結果取込みの検索用パラメータを作成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請日 認定申請日
     * @return 認定調査結果取込みの検索用パラメータ
     */
    public static NinteiOcrMapperParamter searchByAmbiguousParams(RString 証記載保険者番号,
            RString 被保険者番号,
            RString 認定申請日) {
        return new NinteiOcrMapperParamter(証記載保険者番号, 被保険者番号, 認定申請日);
    }

    /**
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査結果取込みの検索用パラメータ
     */
    public static NinteiOcrMapperParamter searchByShinseishoKanriNo(ShinseishoKanriNo 申請書管理番号) {
        Objects.requireNonNull(申請書管理番号);
        return new NinteiOcrMapperParamter(申請書管理番号.value());
    }

}
