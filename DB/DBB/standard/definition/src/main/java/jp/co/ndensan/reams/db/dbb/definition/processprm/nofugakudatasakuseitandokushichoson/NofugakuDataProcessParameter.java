/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001.NofugakuDataTsushutsuJoken;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nofugakudatasakuseitandokushichoson.NofugakuDataMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 納付額データ作成ProcessParameterのパラメータです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class NofugakuDataProcessParameter implements IBatchProcessParameter {

    private RYear 対象年;
    private RString 出力順ID;
    private boolean is非課税年金;
    private NofugakuDataTsushutsuJoken 抽出条件;

    /**
     * toMybatisParameter
     *
     * @return NofugakuDataMybatisParameter
     */
    public NofugakuDataMybatisParameter toMybatisParameter() {
        return new NofugakuDataMybatisParameter(対象年,
                対象年.minusYear(1),
                is非課税年金,
                抽出条件.get集計日区分(),
                抽出条件.get市町村コード());
    }
}
