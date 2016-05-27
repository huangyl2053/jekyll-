/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 償還払い支給（不支給）決定通知書一括作成_金融機関と預金種別更新用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKetteiTsuchiShoUpdateParameter implements IMyBatisParameter {

    private FlexibleDate sysData;

    /**
     * コンストラクタです。
     */
    public ShokanKetteiTsuchiShoUpdateParameter() {
        this.sysData = FlexibleDate.getNowDate();
    }
}
