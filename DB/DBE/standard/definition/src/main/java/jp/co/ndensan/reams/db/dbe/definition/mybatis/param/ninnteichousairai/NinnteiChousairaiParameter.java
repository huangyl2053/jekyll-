/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinnteiChousairaiParameter {

    private final ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private final RString shishoCode;
    private final ChosaItakusakiCode ninteichosaItakusakiCode;
    private final boolean flag;

    private NinnteiChousairaiParameter(
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            RString shishoCode,
            ChosaItakusakiCode ninteichosaItakusakiCode,
            boolean flag) {

        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.shishoCode = shishoCode;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.flag = flag;
    }

    /**
     * 認定調査委託先のパラメータを生成します。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param shishoCode 支所コード
     * @return 認定調査委託先情報パラメータ
     */
    public static NinnteiChousairaiParameter createSelectByKeyParam(
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            RString shishoCode) {
        boolean flag = true;
        if (shishoCode == null || shishoCode.isEmpty()) {
            flag = false;
        }
        return new NinnteiChousairaiParameter(shoKisaiHokenshaNo, shishoCode, ChosaItakusakiCode.EMPTY, flag);
    }

    /**
     * 認定調査委託先一覧のパラメータを生成します。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param shishoCode 支所コード
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     * @return 認定調査委託先一覧パラメータ
     */
    public static NinnteiChousairaiParameter createSelectByKeyParam(
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            RString shishoCode,
            ChosaItakusakiCode ninteichosaItakusakiCode) {
        boolean flag = true;
        if (shishoCode == null || shishoCode.isEmpty()) {
            flag = false;
        }
        return new NinnteiChousairaiParameter(shoKisaiHokenshaNo, shishoCode, ninteichosaItakusakiCode, flag);
    }
}
