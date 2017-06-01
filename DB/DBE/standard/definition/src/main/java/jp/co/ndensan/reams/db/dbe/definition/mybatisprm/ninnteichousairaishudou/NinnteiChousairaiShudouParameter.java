/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairaishudou;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼(手動)ためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinnteiChousairaiShudouParameter {

    private final RString 申請書管理番号;
    private final RString 被保険者番号;
    private final List<RString> 判定結果コードs_再調査 = Arrays.<RString>asList(
            HanteiKekkaCode.再調査_調査のみ.getコード(),
            HanteiKekkaCode.再調査_調査_意見書.getコード()
    );

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     */
    private NinnteiChousairaiShudouParameter(
            RString 申請書管理番号, RString 被保険者番号) {
        this.申請書管理番号 = 申請書管理番号;
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 申請書管理番号により、パラメターを作成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinnteiChousairaiShudouParameter
     */
    public static NinnteiChousairaiShudouParameter createParameterBy申請書管理番号(RString 申請書管理番号) {
        return new NinnteiChousairaiShudouParameter(
                申請書管理番号, null);
    }

    /**
     * 被保険者番号により、パラメターを作成します。
     *
     * @param 被保険者番号 被保険者番号
     * @return NinnteiChousairaiShudouParameter
     */
    public static NinnteiChousairaiShudouParameter createParameterBy被保険者番号(RString 被保険者番号) {
        return new NinnteiChousairaiShudouParameter(
                null, 被保険者番号);
    }

    /**
     * 被保険者番号により、パラメターを作成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @return NinnteiChousairaiShudouParameter
     */
    public static NinnteiChousairaiShudouParameter createParameterBy申請書管理番号と被保険者番号(RString 申請書管理番号, RString 被保険者番号) {
        return new NinnteiChousairaiShudouParameter(
                申請書管理番号, 被保険者番号);
    }
}
