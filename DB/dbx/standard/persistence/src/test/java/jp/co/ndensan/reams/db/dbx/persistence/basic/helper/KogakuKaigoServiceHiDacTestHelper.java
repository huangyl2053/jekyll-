/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N9943 王 永康
 */
public class KogakuKaigoServiceHiDacTestHelper {

    private KogakuKaigoServiceHiDacTestHelper() {
    }

    /**
     * DbT3057KogakuShikyuHanteiKekkaEntityを生成します。
     *
     * @return KogakuKaigoServiceHiEntity 高額介護サービス費エンティティ
     */
    public static DbT3057KogakuShikyuHanteiKekkaEntity getSpiedInstance() {
        DbT3057KogakuShikyuHanteiKekkaEntity result = new DbT3057KogakuShikyuHanteiKekkaEntity();
        result.setHihokenshaNo(new RString("0000000001"));
        result.setServiceTeikyoYM(new FlexibleYearMonth("201312"));
        result.setShiharaiKingaku(new Decimal("100"));
        result.setHonninShiharaiGaku(new Decimal("200"));
        result.setShoKisaiHokenshaNo(new RString("000001"));
        result.setShoriTimestamp(RDateTime.now());
        result.setShiharaiKubunCode(new RString("2"));
        result.setShinsaKekkaHaneiKubun(new RString("2"));

        return result;
    }
}
