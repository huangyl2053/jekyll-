/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.KijuntsukiShichosonjoh;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 *
 */
@lombok.Getter
public final class KijuntsukiShichosonjohMapperParameter {

    private final FlexibleDate 基準年月;
    private final RString 導入形態コード;

    /**
     * コンストラクタです。
     *
     * @param 基準年月 FlexibleDate
     * @param 導入形態コード RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KijuntsukiShichosonjohMapperParameter(
            FlexibleDate 基準年月,
            RString 導入形態コード
    ) {
        this.基準年月 = 基準年月;
        this.導入形態コード = 導入形態コード;
    }

    /**
     * パラメータを生成します。
     *
     * @param 基準年月 FlexibleDate
     * @param 導入形態コード RString
     * @return KijuntsukiShichosonjohMapperParameter パラメータ
     */
    public static KijuntsukiShichosonjohMapperParameter createKaokuParam(
            FlexibleDate 基準年月,
            RString 導入形態コード
    ) {
        return new KijuntsukiShichosonjohMapperParameter(基準年月, 導入形態コード);
    }

    /**
     * パラメータを生成します。
     *
     * @param 基準年月 FlexibleDate
     * @return KijuntsukiShichosonjohMapperParameter パラメータ
     */
    public static KijuntsukiShichosonjohMapperParameter yearMonthcreateKaokuParam(
            FlexibleDate 基準年月
    ) {
        return new KijuntsukiShichosonjohMapperParameter(基準年月, RString.EMPTY);
    }
}
