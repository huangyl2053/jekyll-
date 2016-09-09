/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給（不支給）決定通知書情報取込のMybatisパラメータ。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuKozaMyBatisParameter extends KozaSearchParameter implements IMyBatisParameter {

    private boolean hasValidKamoku;

    /**
     * ShikyuFushikyuMyBatisParameterのコンストラクタです。
     *
     * @param key IKozaSearchKey
     * @param kamokuList List<KamokuCode>
     */
    public ShikyuFushikyuKozaMyBatisParameter(IKozaSearchKey key, List<KamokuCode> kamokuList) {
        super(key, kamokuList);
        this.hasValidKamoku = super.has権限有科目();
    }

}
