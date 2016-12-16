/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinnteiChousairaiParameter {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final RString 支所コード;
    private final ChosaItakusakiCode 認定調査委託先コード;
    private final ChosainCode 認定調査員コード;
    private final boolean uses支所コード;
    private final boolean uses調査員コード;

    private NinnteiChousairaiParameter(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード,
            boolean uses支所コード,
            boolean uses調査員コード) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.uses支所コード = uses支所コード;
        this.uses調査員コード = uses調査員コード;
    }

    /**
     * 認定調査委託先のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 認定調査委託先情報パラメータ
     */
    public static NinnteiChousairaiParameter createParam調査委託先Or未割付申請者(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード) {
        boolean uses支所コード = (支所コード != null && !支所コード.isEmpty());
        return new NinnteiChousairaiParameter(証記載保険者番号, 支所コード, ChosaItakusakiCode.EMPTY, ChosainCode.EMPTY, uses支所コード, false);
    }

    /**
     * 調査員情報のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 調査員情報パラメータ
     */
    public static NinnteiChousairaiParameter createParamfor調査員情報(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            ChosaItakusakiCode 認定調査委託先コード) {
        boolean uses支所コード = (支所コード != null && !支所コード.isEmpty());
        return new NinnteiChousairaiParameter(証記載保険者番号, 支所コード, 認定調査委託先コード, ChosainCode.EMPTY, uses支所コード, false);
    }

    /**
     * 割付済み申請者一覧のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return 割付済み申請者一覧パラメータ
     */
    public static NinnteiChousairaiParameter createParamfor割付済み申請者一覧(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) {
        boolean uses支所コード = (支所コード != null && !支所コード.isEmpty());
        boolean uses調査員コード = (認定調査員コード != null && 認定調査員コード.value() != null);
        return new NinnteiChousairaiParameter(証記載保険者番号, 支所コード, 認定調査委託先コード, 認定調査員コード, uses支所コード, uses調査員コード);
    }
}
