/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikenshoprint;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼書・認定調査票(OCR)・主治医意見書印刷ためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosaIraishoAndChosahyoAndIkenshoPrintParameter {

    private final List<ShinseishoKanriNo> 申請書管理番号リスト;
    private final RString 証記載保険者番号;
    private final RString 申請書管理番号;
    private final boolean uses証記載保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト List<ShinseishoKanriNo>
     * @param 証記載保険者番号 証記載保険者番号
     * @param 申請書管理番号 申請書管理番号
     * @param uses証記載保険者番号 uses証記載保険者番号
     */
    private ChosaIraishoAndChosahyoAndIkenshoPrintParameter(List<ShinseishoKanriNo> 申請書管理番号リスト,
            RString 証記載保険者番号,
            RString 申請書管理番号,
            boolean uses証記載保険者番号) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
        this.証記載保険者番号 = 証記載保険者番号;
        this.申請書管理番号 = 申請書管理番号;
        this.uses証記載保険者番号 = uses証記載保険者番号;
    }

    /**
     * 申請書管理番号リストにより、パラメターを作成します。
     *
     * @param 申請書管理番号リスト List<ShinseishoKanriNo>
     * @param 証記載保険者番号 証記載保険者番号
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     */
    public static ChosaIraishoAndChosahyoAndIkenshoPrintParameter createParameter(List<ShinseishoKanriNo> 申請書管理番号リスト,
            RString 証記載保険者番号) {
        return new ChosaIraishoAndChosahyoAndIkenshoPrintParameter(申請書管理番号リスト,
                証記載保険者番号,
                RString.EMPTY,
                !RString.isNullOrEmpty(証記載保険者番号));
    }

    /**
     * 申請書管理番号により、パラメターを作成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return ChosaIraishoAndChosahyoAndIkenshoPrintParameter
     */
    public static ChosaIraishoAndChosahyoAndIkenshoPrintParameter createParameter(RString 申請書管理番号) {
        return new ChosaIraishoAndChosahyoAndIkenshoPrintParameter(new ArrayList<ShinseishoKanriNo>(),
                RString.EMPTY,
                申請書管理番号,
                false);
    }
}
