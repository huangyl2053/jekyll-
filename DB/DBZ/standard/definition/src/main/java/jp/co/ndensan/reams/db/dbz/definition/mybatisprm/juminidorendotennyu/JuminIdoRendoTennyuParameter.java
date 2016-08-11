/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.juminidorendotennyu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録_転入のパラメータです。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class JuminIdoRendoTennyuParameter {

    private final RString hihokenshaNo;
    private final FlexibleDate idoYMD;

    private JuminIdoRendoTennyuParameter(RString hihokenshaNo, FlexibleDate idoYMD) {
        this.hihokenshaNo = hihokenshaNo;
        this.idoYMD = idoYMD;
    }

    /**
     * パラメータ設定です
     *
     * @param hihokenshaNo RString
     * @param idoYMD FlexibleDate
     * @return JuminIdoRendoTennyuParameter JuminIdoRendoTennyuParameter
     */
    public static JuminIdoRendoTennyuParameter createParam(RString hihokenshaNo, FlexibleDate idoYMD) {
        return new JuminIdoRendoTennyuParameter(hihokenshaNo, idoYMD);
    }
}
