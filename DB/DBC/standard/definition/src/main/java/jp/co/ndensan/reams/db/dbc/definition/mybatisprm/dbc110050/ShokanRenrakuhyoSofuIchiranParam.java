/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票送付一覧表用パラメータクラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanRenrakuhyoSofuIchiranParam implements IMyBatisParameter {

    private boolean 送付除外フラグ;
    private RString orderBy;
}
