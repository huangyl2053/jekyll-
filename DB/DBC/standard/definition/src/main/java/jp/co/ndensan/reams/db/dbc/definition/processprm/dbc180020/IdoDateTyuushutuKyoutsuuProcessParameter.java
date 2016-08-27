/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020.IdoDateTyuushutuKyoutsuuMyBatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 異動データ抽出のProcessParameterのクラスです。
 *
 * @reamsid_L DBC-4950-033 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoDateTyuushutuKyoutsuuProcessParameter implements IBatchProcessParameter {

    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
    private FlexibleDate 対象年度開始日;
    private FlexibleDate 対象年度終了日;
    private FlexibleYear 対象年度;

    private IShikibetsuTaishoPSMSearchKey searchKey;

    /**
     * 異動データ抽出のMybaticParameter作成する。
     *
     * @return {@link IdoDateTyuushutuKyoutsuuMyBatisParameter}
     */
    public IdoDateTyuushutuKyoutsuuMyBatisParameter toMybatisParameter() {
        return new IdoDateTyuushutuKyoutsuuMyBatisParameter(抽出開始日時, 抽出終了日時, 対象年度開始日, 対象年度終了日,
                対象年度, searchKey);
    }

}
