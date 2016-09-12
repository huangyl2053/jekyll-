/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SaiChekkuhyoParameter {

    private final RString 通常;
    private final RString 延期;
    private final RString 申請書管理番号;

    private SaiChekkuhyoParameter(RString 通常, RString 延期, RString 申請書管理番号) {
        this.通常 = 通常;
        this.延期 = 延期;
        this.申請書管理番号 = 申請書管理番号;
    }

    /**
     * 認定調査票差異チェック票のパラメータを生成します。
     *
     * @param 通常 通常
     * @param 延期 延期
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査票差異チェック票パラメータ
     */
    public static SaiChekkuhyoParameter createParam(RString 通常, RString 延期, RString 申請書管理番号) {
        return new SaiChekkuhyoParameter(通常, 延期, 申請書管理番号);
    }
}
