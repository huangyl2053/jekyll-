/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seikatsuhogorireki;

import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 生活保護履歴情報のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SeikatsuhogoParameter {

    private final ShikibetsuCode 識別コード;
    private final GyomuCode 業務コード;

    private SeikatsuhogoParameter(ShikibetsuCode 識別コード, GyomuCode 業務コード) {
        this.識別コード = 識別コード;
        this.業務コード = 業務コード;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param 業務コード 業務コード
     * @return 生活保護履歴情報パラメータ
     */
    public static SeikatsuhogoParameter createParameter(ShikibetsuCode 識別コード, GyomuCode 業務コード) {
        return new SeikatsuhogoParameter(識別コード, 業務コード);
    }
}
