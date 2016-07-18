/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課計算に設定のParameter
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CaluculateFukaParameter extends KozaSearchParameter {

    /**
     * コンストラクタです。
     *
     * @param key IKozaSearchKey
     * @param 権限有科目リスト List<KamokuCode>
     */
    public CaluculateFukaParameter(IKozaSearchKey key, List<KamokuCode> 権限有科目リスト) {
        super(key, 権限有科目リスト);
    }

    /**
     * パラメータメソッドです。
     *
     * @param key IKozaSearchKey
     * @param list List<KamokuCode>
     * @return CaluculateFukaParameter
     */
    public static CaluculateFukaParameter createSelectByKeyParam(
            IKozaSearchKey key,
            List<KamokuCode> list) {
        return new CaluculateFukaParameter(key, list);
    }

}
