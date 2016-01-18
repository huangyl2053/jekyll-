/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
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
    private final ChosainCode ninteiChosainCode;
    private final boolean uses支所コード;
    private final boolean uses調査員コード;

    private NinnteiChousairaiParameter(
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            RString shishoCode,
            ChosaItakusakiCode ninteichosaItakusakiCode,
            ChosainCode ninteiChosainCode,
            boolean uses支所コード,
            boolean uses調査員コード) {

        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.shishoCode = shishoCode;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.ninteiChosainCode = ninteiChosainCode;
        this.uses支所コード = uses支所コード;
        this.uses調査員コード = uses調査員コード;
    }

    /**
     * 認定調査委託先のパラメータを生成します。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param shishoCode 支所コード
     * @return 認定調査委託先情報パラメータ
     */
    public static NinnteiChousairaiParameter createParam調査委託先Or未割付申請者(
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            RString shishoCode) {
        boolean uses支所コード = true;
        if (shishoCode == null || shishoCode.isEmpty()) {
            uses支所コード = false;
        }
        return new NinnteiChousairaiParameter(shoKisaiHokenshaNo, shishoCode, ChosaItakusakiCode.EMPTY, ChosainCode.EMPTY, uses支所コード, false);
    }

    /**
     * 調査員情報のパラメータを生成します。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param shishoCode 支所コード
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     * @return 調査員情報パラメータ
     */
    public static NinnteiChousairaiParameter createParamfor調査員情報(
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            RString shishoCode,
            ChosaItakusakiCode ninteichosaItakusakiCode) {
        boolean uses支所コード = true;
        if (shishoCode == null || shishoCode.isEmpty()) {
            uses支所コード = false;
        }
        return new NinnteiChousairaiParameter(shoKisaiHokenshaNo, shishoCode, ninteichosaItakusakiCode, ChosainCode.EMPTY, uses支所コード, false);
    }

    /**
     * 割付済み申請者一覧のパラメータを生成します。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param shishoCode 支所コード
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @return 割付済み申請者一覧パラメータ
     */
    public static NinnteiChousairaiParameter createParamfor割付済み申請者一覧(
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            RString shishoCode,
            ChosaItakusakiCode ninteichosaItakusakiCode,
            ChosainCode ninteiChosainCode) {
        boolean uses支所コード = true;
        boolean uses調査員コード = true;
        if (shishoCode == null || shishoCode.isEmpty()) {
            uses支所コード = false;
        }
        if (ninteiChosainCode == null) {
            uses調査員コード = false;
        }
        return new NinnteiChousairaiParameter(shoKisaiHokenshaNo, shishoCode, ninteichosaItakusakiCode, ninteiChosainCode, uses支所コード, uses調査員コード);
    }
}
