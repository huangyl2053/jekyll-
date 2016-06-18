/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 前年度・特徴期別金額06更新パラメータを定義したEntityクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKibetsuKingaku06ProcessParameter implements IBatchProcessParameter {

    private RString 前年度特徴期別金額06;

}
