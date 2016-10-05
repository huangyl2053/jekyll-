/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給申請書情報作成の業務別主キー取得のMybatisパラメータ。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KozaKyomuBetsuMybatisParameter implements IMyBatisParameter {

    private KamokuCode 科目コード;
}
