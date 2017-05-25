/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書一覧のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoSakuseiIraiParameter {

    private final List<RString> 判定結果コードs_再調査 = Arrays.<RString>asList(
            HanteiKekkaCode.再調査_意見書のみ.getコード(),
            HanteiKekkaCode.再調査_調査_意見書.getコード()
    );
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final RString 支所コード;
    private final ShujiiIryokikanCode 主治医医療機関コード;
    private final ShujiiCode 主治医コード;
    private final boolean uses支所コード;
    private final boolean uses主治医コード;

    private ShujiiIkenshoSakuseiIraiParameter(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            ShujiiIryokikanCode 主治医医療機関コード,
            ShujiiCode 主治医コード,
            boolean uses支所コード,
            boolean uses主治医コード) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
        this.uses支所コード = uses支所コード;
        this.uses主治医コード = uses主治医コード;
    }

    /**
     * 主治医委託先のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @return 主治医委託先情報パラメータ
     */
    public static ShujiiIkenshoSakuseiIraiParameter createParam主治医医療機関Or未割付申請者(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード) {
        boolean uses支所コード = (支所コード != null && !支所コード.isEmpty());
        return new ShujiiIkenshoSakuseiIraiParameter(証記載保険者番号, 支所コード, ShujiiIryokikanCode.EMPTY, ShujiiCode.EMPTY, uses支所コード, false);
    }

    /**
     * 調査員情報のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 主治医委託先コード 認定調査委託先コード
     * @return 調査員情報パラメータ
     */
    public static ShujiiIkenshoSakuseiIraiParameter createParamfor主治医情報(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            ShujiiIryokikanCode 主治医委託先コード) {
        boolean uses支所コード = (支所コード != null && !支所コード.isEmpty());
        return new ShujiiIkenshoSakuseiIraiParameter(証記載保険者番号, 支所コード, 主治医委託先コード, ShujiiCode.EMPTY, uses支所コード, false);
    }

    /**
     * 割付済み申請者一覧のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 主治医委託先コード 主治医委託先コード
     * @param 主治医コード 主治医コード
     * @return 割付済み申請者一覧パラメータ
     */
    public static ShujiiIkenshoSakuseiIraiParameter createParamfor割付済み申請者一覧(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            ShujiiIryokikanCode 主治医委託先コード,
            ShujiiCode 主治医コード) {
        boolean uses支所コード = (支所コード != null && !支所コード.isEmpty());
        boolean uses調査員コード = (主治医委託先コード != null && 主治医委託先コード.value() != null);
        return new ShujiiIkenshoSakuseiIraiParameter(証記載保険者番号, 支所コード, 主治医委託先コード, 主治医コード, uses支所コード, uses調査員コード);
    }
}
