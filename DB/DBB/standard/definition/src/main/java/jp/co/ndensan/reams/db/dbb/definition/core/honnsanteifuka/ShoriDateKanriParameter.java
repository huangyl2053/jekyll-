/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理日付管理を取得のParameterのクラス。
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriDateKanriParameter implements IMyBatisParameter {

    private FlexibleYear 年度;
}
