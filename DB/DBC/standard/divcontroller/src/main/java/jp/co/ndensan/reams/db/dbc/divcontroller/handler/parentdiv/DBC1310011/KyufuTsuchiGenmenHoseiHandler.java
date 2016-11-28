/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1310011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060010.DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1310011.KyufuTsuchiGenmenHoseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知減免補正一覧表作成のHandlerクラスです。
 *
 * @reamsid_L DBC-2270-010 lijia
 */
public class KyufuTsuchiGenmenHoseiHandler {

    private final KyufuTsuchiGenmenHoseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     */
    public KyufuTsuchiGenmenHoseiHandler(KyufuTsuchiGenmenHoseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     */
    public void initialize() {
        if (is広域()) {
            div.getKyufuTsuchiGenmenHoseiListSakusei().getCcdHokenshaList().setDisplayNone(false);
        } else {
            div.getKyufuTsuchiGenmenHoseiListSakusei().getCcdHokenshaList().setDisplayNone(true);
        }
        div.getKyufuTsuchiGenmenHoseiListSakusei().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200043.getReportId());
    }

    /**
     * 給付費通知減免補正一覧表のバッチ用パラメータです。
     *
     * @return DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter 給付費通知減免補正一覧表のバッチ用パラメータ
     */
    public DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter btnPulish() {
        DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter paramter = new DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter();
        RString サービス開始年月 = div.getKyufuTsuchiGenmenHoseiListSakusei().getTxtServiceYM().getFromValue().getYearMonth().toDateString();
        RString サービス終了年月 = div.getKyufuTsuchiGenmenHoseiListSakusei().getTxtServiceYM().getToValue().getYearMonth().toDateString();
        paramter.setサービス開始年月(new FlexibleYearMonth(サービス開始年月));
        paramter.setサービス終了年月(new FlexibleYearMonth(サービス終了年月));
        paramter.set帳票出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        paramter.set市町村コード(div.getCcdHokenshaList().getSelectedItem().get市町村コード().value());
        paramter.set市町村名称(div.getCcdHokenshaList().getSelectedItem().get市町村名称());
        paramter.set証記載保険者番号(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value());
        return paramter;
    }

    private boolean is広域() {
        return DonyuKeitaiCode.事務広域.getCode()
                .equals(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value());
    }
}
