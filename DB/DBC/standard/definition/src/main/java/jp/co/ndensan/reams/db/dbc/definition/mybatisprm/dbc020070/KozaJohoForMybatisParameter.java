/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import lombok.Getter;

/**
 * 更新用一時の内容を更新する処理のMYBATIS用パラメータクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KozaJohoForMybatisParameter extends KozaSearchParameter implements IMyBatisParameter {

    private final boolean hasValidKamoku;

    /**
     *
     * コンストラクタです。
     *
     * @param key key
     * @param kamokuList kamokuList
     */
    public KozaJohoForMybatisParameter(IKozaSearchKey key, List<KamokuCode> kamokuList) {
        super(key, kamokuList);
        this.hasValidKamoku = super.has権限有科目();
    }
}
