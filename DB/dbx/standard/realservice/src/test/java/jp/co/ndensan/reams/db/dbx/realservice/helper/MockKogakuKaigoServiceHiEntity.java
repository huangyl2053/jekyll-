/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice.helper;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;

/**
 * KogakuKaigoServiceHiEntityを生成するためのMockクラスです。
 *
 * @author N9943 王 永康
 */
public final class MockKogakuKaigoServiceHiEntity {

    private MockKogakuKaigoServiceHiEntity() {
    }

    /**
     * Mockito#spyでラップされたKogakuKaigoServiceHiEntityを生成します。
     *
     * @return KogakuKaigoServiceHiEntity Mockito#spyでラップされたインスタンス
     */
    public static DbV3057KogakuShikyuHanteiKekkaEntity getSpiedInstance() {
        DbV3057KogakuShikyuHanteiKekkaEntity result = new DbV3057KogakuShikyuHanteiKekkaEntity();
        result.setHihokenshaNo(new RString("0000000001"));
        result.setServiceTeikyoYM(new FlexibleYearMonth("201312"));
        result.setShiharaiKingaku(new Decimal("100"));
        result.setHonninShiharaiGaku(new Decimal("200"));
        result.setShoKisaiHokenshaNo(RString.HALF_SPACE);
        return spy(result);
    }
}
