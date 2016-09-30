/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2430011;

import jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho.KetteiTimestampBusiness;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100020.DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2430011.ShikyuKetteitsuchishoParameterDiv;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成の検証ハンドラクラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public class ShikyuKetteitsuchishoParameterHandler {

    private final ShikyuKetteitsuchishoParameterDiv div;
    private static final int ZERO = 0;
    private static final int EIGHT = 8;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShikyuKetteitsuchishoParameterHandler(ShikyuKetteitsuchishoParameterDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化します。
     *
     * @param business 住宅改修理由書作成手数料支給（不支給）決定通知書作成の前回実行情報
     */
    public void onLoad(KetteiTimestampBusiness business) {
        if (business != null) {
            RDate 決定日_開始日 = null;
            if (!RString.isNullOrEmpty(business.getTemp_前回決定日_開始日())) {
                RDate 前回決定日_開始日 = new RDate(business.getTemp_前回決定日_開始日().substring(ZERO, EIGHT).toString());
                div.getTxtZnkaiKetteiYMD().setFromValue(前回決定日_開始日);
                決定日_開始日 = 前回決定日_開始日.plusDay(1);
            }
            if (!RString.isNullOrEmpty(business.getTemp_前回決定日_終了日())) {
                div.getTxtZnkaiKetteiYMD().setToValue(new RDate(business.getTemp_前回決定日_終了日().substring(ZERO, EIGHT).toString()));
                div.getTxtKetteiYMD().setFromValue(決定日_開始日);
            }
        }
        div.getTxtKetteiYMD().setToValue(RDate.getNowDate());
        div.getCcdBunshoBangoInput().initialize(ReportIdDBC.DBC100044.getReportId());
        // TODO 出力順の相関方針が確定しないので、実装ができません
//        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100044.getReportId());
    }

    /**
     * 事業者DDL表示制御を変更します。
     */
    public void onChange_chkShiteiJigyoshaNomi() {
        if (div.getChkShiteiJigyoshaNomi().getSelectedItems() != null
                && !div.getChkShiteiJigyoshaNomi().getSelectedItems().isEmpty()) {
            div.getDdlJigyosha().setDisabled(false);
        } else {
            div.getDdlJigyosha().setDisabled(true);
        }
    }

    /**
     * 住宅改修理由書作成手数料支給（不支給）決定通知書作成のバッチパラメータを作成します。
     *
     * @return DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter
     */
    public DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter create決定通知書作成パラメータ() {
        DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter parameter = new DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter();
        parameter.set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value());
        parameter.set決定日_開始日(new FlexibleDate(div.getTxtKetteiYMD().getFromValue().toDateString()));
        parameter.set決定日_終了日(new FlexibleDate(div.getTxtKetteiYMD().getToValue().toDateString()));
        if (div.getChkShiteiJigyoshaNomi().getSelectedItems() != null
                && !div.getChkShiteiJigyoshaNomi().getSelectedItems().isEmpty()) {
            parameter.set指定事業者のみフラグ(Boolean.TRUE);
            parameter.set事業者コード(div.getDdlJigyosha().getSelectedKey());
        } else {
            parameter.set指定事業者のみフラグ(Boolean.FALSE);
        }
        parameter.set文書情報(div.getCcdBunshoBangoInput().get文書番号());
        // TODO 出力順の相関方針が確定しないので、実装ができません
//        parameter.set出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        parameter.set作成日(FlexibleDate.getNowDate());
        return parameter;
    }
}
