/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshoiraishokai;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
public class ShujiiIkenshoIraiParameter {

    private final RString 申請書管理番号;
    private final List<RString> 判定結果コードs_再意見書 = Arrays.<RString>asList(
            HanteiKekkaCode.再調査_意見書のみ.getコード(),
            HanteiKekkaCode.再調査_調査_意見書.getコード()
    );

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     */
    private ShujiiIkenshoIraiParameter(RString 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }

    /**
     * 申請書管理番号により、パラメターを作成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinnteiChousairaiShudouParameter
     */
    public static ShujiiIkenshoIraiParameter createParameter(RString 申請書管理番号) {
        return new ShujiiIkenshoIraiParameter(申請書管理番号);
    }
}
