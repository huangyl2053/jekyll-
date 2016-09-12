/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinsei;

import jp.co.ndensan.reams.db.dbe.definition.core.YokaigoNinteiShinseiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2006 立野 啓子
 */
public class NinteiShinseiJohoValidate {

    private static final int I = 60;

    /**
     *
     * @param shinseiKbn 申請区分
     * @param shinseiYMD 申請日
     * @param zenkaiYukoKikanEnd 前回有効終了日
     * @return チェック結果
     */
    public boolean validateShinseiKbn(RString shinseiKbn, RDate shinseiYMD, RString zenkaiYukoKikanEnd) {
        if (shinseiKbn.equalsIgnoreCase(YokaigoNinteiShinseiKubun.更新申請.getCode())) {
            if (zenkaiYukoKikanEnd.isEmpty()) {
                return true;
            }
            if (shinseiYMD.isBefore(new RDate(zenkaiYukoKikanEnd.toString()).minusDay(I))) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param jigyoshaCode 事業者CODE
     * @param jigyoshaName 事業者Name
     * @return チェック結果
     */
    public boolean validateJigyosha(RString jigyoshaCode, RString jigyoshaName) {
        if (jigyoshaCode.isEmpty() && jigyoshaName.isEmpty()) {
            return false;
        }
        if (jigyoshaCode.isEmpty() || jigyoshaName.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param iryokikanCode 医療機関CODE
     * @param iryokikanName 医療機関Name
     * @return チェック結果
     */
    public boolean validateIryokikan(RString iryokikanCode, RString iryokikanName) {
        if (iryokikanCode.isEmpty() && iryokikanName.isEmpty()) {
            return false;
        }
        if (iryokikanCode.isEmpty() || iryokikanName.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 主治医のチェック処理です。
     *
     * @param shujiiCode 主治医コード
     * @param shujiiName 主治医名
     * @return チェック結果
     */
    public boolean validateShujii(RString shujiiCode, RString shujiiName) {
        if (shujiiCode.isEmpty() && shujiiName.isEmpty()) {
            return false;
        }
        if (shujiiCode.isEmpty() || shujiiName.isEmpty()) {
            return true;
        }
        return false;
    }

}
