/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.futangendogakuninteishinseisho;

import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護保険負担限度額認定申請書の施設情報のパラメータです。
 *
 * @reamsid_L DBA-0540-690 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class FutanGendogakuNinteiShinseishoParamter {

    private final ShikibetsuCode 識別コード;
    private final RString 入所施設コード;
    private final RString 住所地特例対象施設;
    private final RString 被保険者;

    private FutanGendogakuNinteiShinseishoParamter(ShikibetsuCode 識別コード,
            RString 入所施設コード,
            RString 住所地特例対象施設,
            RString 被保険者) {
        this.識別コード = 識別コード;
        this.入所施設コード = 入所施設コード;
        this.住所地特例対象施設 = 住所地特例対象施設;
        this.被保険者 = 被保険者;
    }

    /**
     * 施設情報の取得のパラメータを作成します。
     *
     * @param 識別コード 識別コード
     * @param 入所施設コード 入所施設コード
     * @return 施設情報の取得のパラメータ
     */
    public static FutanGendogakuNinteiShinseishoParamter createParamter(ShikibetsuCode 識別コード, RString 入所施設コード) {
        return new FutanGendogakuNinteiShinseishoParamter(識別コード,
                入所施設コード,
                JigyosyaType.住所地特例対象施設.getコード(),
                DaichoType.被保険者.getコード());
    }

}
