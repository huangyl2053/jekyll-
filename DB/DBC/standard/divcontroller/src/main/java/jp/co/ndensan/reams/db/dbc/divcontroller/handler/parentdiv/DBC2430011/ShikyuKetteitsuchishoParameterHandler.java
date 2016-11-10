/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2430011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho.KetteiTimestampBusiness;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100020.DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2430011.ShikyuKetteitsuchishoParameterDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成の検証ハンドラクラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public class ShikyuKetteitsuchishoParameterHandler {

    private final ShikyuKetteitsuchishoParameterDiv div;

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
     * @param business2 事業者の情報
     */
    public void onLoad(KetteiTimestampBusiness business, SearchResult<KetteiTimestampBusiness> business2) {

        Map<JigyoshaNo, AtenaMeisho> map = new HashMap<>();
        for (KetteiTimestampBusiness businesslist : business2.records()) {
            JigyoshaNo 事業者番号 = businesslist.get介護住宅改修理由書作成事業者番号();
            AtenaMeisho 事業者名称 = businesslist.get介護住宅改修事業者名称();
            if (!map.containsKey(事業者番号)) {
                map.put(事業者番号, 事業者名称);
            }
        }
        List<KeyValueDataSource> list = new ArrayList<>();
        for (Map.Entry<JigyoshaNo, AtenaMeisho> entry : map.entrySet()) {
            KeyValueDataSource datasource = new KeyValueDataSource();
            datasource.setKey(entry.getKey().value());
            datasource.setValue(entry.getValue().value());
            list.add(datasource);
        }
        div.getDdlJigyosha().setDataSource(list);
        div.getTxtKetteiYMD().setToValue(RDate.getNowDate());
        div.getCcdBunshoBangoInput().initialize(ReportIdDBC.DBC100044.getReportId());
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100044.getReportId());
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
        parameter.set出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        parameter.set作成日(FlexibleDate.getNowDate());
        return parameter;
    }
}
