/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.NonNull;

/**
 * 異動賦課情報一時テーブルの「更正前」計算後情報を更新するパラメータです。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdofukaKoseimaeParameter {

    private final RString 更正前情報有無区分;
    private final RString 更正前後区分;

    private IdofukaKoseimaeParameter(
            @NonNull RString 更正前情報有無区分,
            @NonNull RString 更正前後区分) {
        this.更正前後区分 = 更正前後区分;
        this.更正前情報有無区分 = 更正前情報有無区分;
    }

    /**
     * パラメータを作成する。
     *
     * @param 更正前情報有無区分 更正前情報有無区分
     * @param 更正前後区分 更正前後区分
     * @return 作成されたパラメータ
     */
    public static IdofukaKoseimaeParameter createParameter(
            RString 更正前情報有無区分,
            RString 更正前後区分) {
        return new IdofukaKoseimaeParameter(更正前情報有無区分, 更正前後区分);
    }
}
