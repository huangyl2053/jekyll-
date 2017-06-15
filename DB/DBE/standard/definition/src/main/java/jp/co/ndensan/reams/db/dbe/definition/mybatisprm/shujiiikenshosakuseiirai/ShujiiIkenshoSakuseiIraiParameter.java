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
    private final RString 市町村コード;
    private final ShujiiIryokikanCode 主治医医療機関コード;
    private final ShujiiCode 主治医コード;
    private final boolean uses支所コード;
    private final boolean uses主治医コード;

    private ShujiiIkenshoSakuseiIraiParameter(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            RString 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード,
            ShujiiCode 主治医コード
    ) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.支所コード = 支所コード;
        this.市町村コード = 市町村コード;
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
        this.uses支所コード = (支所コード != null && !支所コード.isEmpty());
        this.uses主治医コード = (主治医医療機関コード != null && 主治医医療機関コード.value() != null);
    }

    /**
     * 主治医委託先のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 市町村コード 市町村コード
     * @return 主治医委託先情報パラメータ
     */
    public static ShujiiIkenshoSakuseiIraiParameter createParam主治医医療機関Or未割付申請者(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            RString 市町村コード) {
        return new ShujiiIkenshoSakuseiIraiParameter(証記載保険者番号, 支所コード, 市町村コード, ShujiiIryokikanCode.EMPTY, ShujiiCode.EMPTY);
    }

    /**
     * 割付済み申請者一覧のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支所コード 支所コード
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @return 割付済み申請者一覧パラメータ
     */
    public static ShujiiIkenshoSakuseiIraiParameter createParamfor割付済み申請者一覧(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString 支所コード,
            RString 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード,
            ShujiiCode 主治医コード) {
        return new ShujiiIkenshoSakuseiIraiParameter(証記載保険者番号, 支所コード, 市町村コード, 主治医医療機関コード, 主治医コード);
    }
}
