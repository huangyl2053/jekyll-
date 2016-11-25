/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteidbtoroku;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsaketteidbtoroku.SaishinsaKetteiDBTorokuMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * マスタ登録パラメータです。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class SaishinsaKetteiDBProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;
    private RString 保険者区分;

    /**
     * データ取得のMybaticParameter作成する。
     *
     * @return {@link KogakugassanKeisankekkaRenrakuhyoOutMybatisParameter}
     */
    public SaishinsaKetteiDBTorokuMyBatisParameter toSaishinsaKetteiDBTorokuMyBatisParameter() {
        return new SaishinsaKetteiDBTorokuMyBatisParameter(処理年月, 保険者区分);
    }
}
