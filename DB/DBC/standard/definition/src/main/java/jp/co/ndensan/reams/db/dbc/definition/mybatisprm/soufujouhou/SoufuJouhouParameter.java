/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査申立送付情報のMybatisパラメータクラスです。
 *
 * @reamsid_L DBC-3050-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SoufuJouhouParameter implements IMyBatisParameter {

    private final RString 送付年月;
    private final RString 証記載保険者番号;
    private final boolean 送付年月フラグ;
    private final boolean 保険者番号フラグ;

    /**
     * コンストラクタです。
     *
     * @param 送付年月 送付年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 送付年月フラグ 送付年月フラグ
     * @param 保険者番号フラグ 保険者番号フラグ
     */
    protected SoufuJouhouParameter(RString 送付年月, RString 証記載保険者番号,
            boolean 送付年月フラグ, boolean 保険者番号フラグ) {
        this.送付年月 = 送付年月;
        this.証記載保険者番号 = 証記載保険者番号;
        this.送付年月フラグ = 送付年月フラグ;
        this.保険者番号フラグ = 保険者番号フラグ;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 送付年月 送付年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 送付年月フラグ 送付年月フラグ
     * @param 保険者番号フラグ 保険者番号フラグ
     * @return SoufuJouhouParameter
     */
    public static SoufuJouhouParameter creatParameter(RString 送付年月, RString 証記載保険者番号,
            boolean 送付年月フラグ, boolean 保険者番号フラグ) {
        return new SoufuJouhouParameter(送付年月, 証記載保険者番号, 送付年月フラグ, 保険者番号フラグ);
    }

}
