/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshosakuseiirai;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * IkenshoSakuseiIraiMapperで用いるパラメータです。
 */
@lombok.Getter
public class IkenshoSakuseiIraiMapperParameter {

    private final RString 申請書管理番号;
    private final List<RString> 判定結果コードs_再調査 = Arrays.<RString>asList(
            HanteiKekkaCode.再調査_意見書のみ.getコード(),
            HanteiKekkaCode.再調査_調査_意見書.getコード()
    );

    private IkenshoSakuseiIraiMapperParameter(RString 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }

    /**
     * @param 申請書管理番号 申請書管理番号
     * @return {@link IkenshoSakuseiIraiMapperParameter}
     */
    public static IkenshoSakuseiIraiMapperParameter searchBy申請書管理番号(RString 申請書管理番号) {
        return new IkenshoSakuseiIraiMapperParameter(申請書管理番号);
    }

}
