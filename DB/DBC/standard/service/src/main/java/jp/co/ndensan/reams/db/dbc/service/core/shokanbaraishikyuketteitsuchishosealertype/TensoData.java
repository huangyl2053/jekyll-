/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import lombok.Getter;

/**
 * 伝送データEntityです。
 *
 * @reamsid_L DBC-1000-030 zuotao
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TensoData {

    private final List<ShokanKetteiTsuchiShoSealer> 帳票ソースデータ;
    private final IDaikoPrint 代行プリント送付票;

    /**
     * コンストラクタです。
     *
     * @param 帳票ソースデータ 帳票ソースデータ
     * @param 代行プリント送付票 代行プリント送付票
     */
    public TensoData(List<ShokanKetteiTsuchiShoSealer> 帳票ソースデータ, IDaikoPrint 代行プリント送付票) {
        this.帳票ソースデータ = 帳票ソースデータ;
        this.代行プリント送付票 = 代行プリント送付票;
    }
}
