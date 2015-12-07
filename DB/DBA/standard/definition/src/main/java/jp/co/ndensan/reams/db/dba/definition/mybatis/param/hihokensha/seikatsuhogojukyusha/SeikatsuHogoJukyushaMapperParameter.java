/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokensha.seikatsuhogojukyusha;

import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 生活保護受給者を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class SeikatsuHogoJukyushaMapperParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final GyomuCode gyomuCode;
    private final FlexibleDate jukyuKaishiYMD;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param gyomuCode GyomuCode
     * @param jukyuKaishiYMD FlexibleDate
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private SeikatsuHogoJukyushaMapperParameter(
            ShikibetsuCode shikibetsuCode,
            GyomuCode gyomuCode,
            FlexibleDate jukyuKaishiYMD) {

        this.shikibetsuCode = shikibetsuCode;
        this.gyomuCode = gyomuCode;
        this.jukyuKaishiYMD = jukyuKaishiYMD;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param gyomuCode GyomuCode
     * @param jukyuKaishiYMD FlexibleDate
     * @return 生活保護受給者検索パラメータ
     */
    public static SeikatsuHogoJukyushaMapperParameter createSelectByKeyParam(
            ShikibetsuCode shikibetsuCode,
            GyomuCode gyomuCode,
            FlexibleDate jukyuKaishiYMD) {
        return new SeikatsuHogoJukyushaMapperParameter(shikibetsuCode, gyomuCode, jukyuKaishiYMD);
    }
}
