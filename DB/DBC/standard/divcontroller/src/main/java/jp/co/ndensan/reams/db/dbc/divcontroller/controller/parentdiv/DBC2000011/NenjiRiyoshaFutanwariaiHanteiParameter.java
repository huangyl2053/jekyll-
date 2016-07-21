/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000011;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author admin
 */
public class NenjiRiyoshaFutanwariaiHanteiParameter extends BatchParameterBase{
    private FlexibleYear 対象年度;
    private FlexibleDate 基準日;
    private RString 処理状態;
    private SaiShoriKubun  処理区分;
    private RString 年度終了年月日;
    private boolean テストモード;
    private FlexibleDate 処理日時;
}
