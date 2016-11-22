/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給不支給決定通知書一時TBLを更新します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class UpdHakkoutaisyouFlgProcess extends SimpleBatchProcessBase {

    private static final RString 帳票制御汎用キー_償還払い支給不支給決定通知書 = new RString("２号発行有無");
    private static final RString 発行有無_発行しない = new RString("0");

    @Override
    protected void process() {
        RString 資格区分 = null;
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎発行有無 = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 帳票制御汎用キー_償還払い支給不支給決定通知書);
        if (帳票制御汎発行有無 != null && 発行有無_発行しない.equals(帳票制御汎発行有無.get設定値())) {
            資格区分 = ShikakuKubun._２号.getコード();
        }
        getMapper(IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.class).upd通知書発行対象フラグ(資格区分);
    }
}

