/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohohenko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更減額を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShiharaiHohoHenkoGengakuMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 管理区分;
    private final int 履歴番号;

    private final boolean uses被保険者番号;
    private final boolean uses管理区分;
    private final boolean uses履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 主キー1 主キー1
     * @param 主キー2 主キー2
     * @param uses主キー1 uses主キー1
     * @param uses主キー2 uses主キー2
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShiharaiHohoHenkoGengakuMapperParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull RString 管理区分,
            int 履歴番号,
            boolean uses被保険者番号,
            boolean uses管理区分,
            boolean uses履歴番号) {

        this.被保険者番号 = 被保険者番号;
        this.管理区分 = 管理区分;
        this.履歴番号 = 履歴番号;

        this.uses被保険者番号 = uses被保険者番号;
        this.uses管理区分 = uses管理区分;
        this.uses履歴番号 = uses履歴番号;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 管理区分 RString
     * @param 履歴番号 int
     * @return 身体手帳検索パラメータ
     */
    public static ShiharaiHohoHenkoGengakuMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号) {
        return new ShiharaiHohoHenkoGengakuMapperParameter(被保険者番号, 管理区分, 履歴番号, true, true, true);
    }
}
