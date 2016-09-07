/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0020001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.PublishedReportInfo;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkoGoIdosha;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoshaListJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchishohakkogoido.IdoNaiyo;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.DBB0020001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.IdoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.dgIdoTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0020001.IdoTaishoshaIchiranHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.idotaishoshaichiranparameter.IdoTaishoshaIchiranparameter;
import jp.co.ndensan.reams.db.dbb.service.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoHaaku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM32001_通知書発行後異動把握
 *
 * @reamsid_L DBB-0690-010 xuhao
 */
public class IdoTaishoshaIchiran {

    private static final RString 一覧表発行する = new RString("btnHakko");
    private static final RString 即時賦課更生へ = new RString("btnToSokujiKosei");
    private static final RString 各種通知書発行へ = new RString("btnToKakushuTsuchishoHakko");
    private static final int 整数_ZERO = 0;

    /**
     * onLoad
     *
     * @param div div
     * @return div
     */
    public ResponseData onLoad(IdoTaishoshaIchiranDiv div) {
        List<PublishedReportInfo> 発行帳票情報List = TsuchiShoHakkogoIdoHaaku.createInstance().get帳票情報();
        Map<RString, RString> 帳票名Map = TsuchiShoHakkogoIdoHaaku.createInstance().get通知書名称(発行帳票情報List);
        div.getDdlTsuchishoMeisho().setDataSource(KeyValueDataSourceConverter.getDataSource(帳票名Map));
        if (帳票名Map.size() != 整数_ZERO) {
            div.getDdlTsuchishoMeisho().setSelectedIndex(整数_ZERO);
        }
        Map<ReportId, List<YMDHMS>> 発行日時Map = TsuchiShoHakkogoIdoHaaku.createInstance().get作成日時(発行帳票情報List);
        ViewStateHolder.put(ViewStateKeys.発行日時Map, (Serializable) 発行日時Map);
        getHandler(div).set作成日時(発行日時Map);
        getHandler(div).set最終計算処理日時();
        List<dgIdoTaishoshaIchiran_Row> rowList = new ArrayList<>();
        div.getDgIdoTaishoshaIchiran().setDataSource(rowList);
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_ddlMeisho
     *
     * @param div div
     * @return div
     */
    public ResponseData<IdoTaishoshaIchiranDiv> onChange_ddlMeisho(IdoTaishoshaIchiranDiv div) {
        Map<ReportId, List<YMDHMS>> map = ViewStateHolder.get(ViewStateKeys.発行日時Map, Map.class);
        getHandler(div).set作成日時(map);
        getHandler(div).set最終計算処理日時();
        div.getDgIdoTaishoshaIchiran().getDataSource().clear();
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_ddlYMD
     *
     * @param div div
     * @return div
     */
    public ResponseData<IdoTaishoshaIchiranDiv> onChange_ddlYMD(IdoTaishoshaIchiranDiv div) {
        getHandler(div).set最終計算処理日時();
        div.getDgIdoTaishoshaIchiran().getDataSource().clear();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnIdoShaCheck
     *
     * @param div div
     * @return div
     */
    public ResponseData<IdoTaishoshaIchiranDiv> onClick_btnIdoShaCheck(IdoTaishoshaIchiranDiv div) {
        List<TsuchiShoHakkoGoIdosha> entityList = getHandler(div).set異動者チェック情報();
        if (entityList == null || entityList.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbbInformationMessages.期間内異動なし.getMessage()).respond();
            }
            if (new RString(DbbInformationMessages.期間内異動なし.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                List<dgIdoTaishoshaIchiran_Row> rowList = new ArrayList<>();
                div.getDgIdoTaishoshaIchiran().setDataSource(rowList);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(一覧表発行する, true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(即時賦課更生へ, true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(各種通知書発行へ, true);
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).initialize(entityList);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(即時賦課更生へ, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(各種通知書発行へ, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(一覧表発行する, false);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_show
     *
     * @param div div
     * @return div
     */
    public ResponseData<IdoTaishoshaIchiranDiv> onClick_show(IdoTaishoshaIchiranDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(即時賦課更生へ, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(各種通知書発行へ, false);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnToKakushu
     *
     * @param div div
     * @return div
     */
    public ResponseData<IdoTaishoshaIchiranDiv> onClick_btnToKakushu(IdoTaishoshaIchiranDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBB0020001TransitionEventName.各種通知書作成へ).respond();
    }

    /**
     * onClick_btnToSokujiKosei
     *
     * @param div div
     * @return div
     */
    public ResponseData<IdoTaishoshaIchiranDiv> onClick_btnToSokujiKosei(IdoTaishoshaIchiranDiv div) {
        putViewState(div);
        return ResponseData.of(div).forwardWithEventName(DBB0020001TransitionEventName.即時更生へ).respond();
    }

    /**
     * onClick_btnHakko
     *
     * @param div div
     * @return div
     */
    public ResponseData<SourceDataCollection> onClick_btnHakko(IdoTaishoshaIchiranDiv div) {
        List<dgIdoTaishoshaIchiran_Row> rowList = div.getDgIdoTaishoshaIchiran().getDataSource();
        YMDHMS 通知書発行日時 = new YMDHMS(div.getDdlSakuseiYMD().getSelectedKey());
        List<RString> time = div.getTxtLastKeisanShoriTime().getValue().split(" ");
        RDate yms = new RDate(time.get(0).toString());
        RString hh = new RString(time.get(1).toString().split(":")[0]);
        RString mm = new RString(time.get(1).toString().split(":")[1]);
        RString ss = new RString(time.get(1).toString().split(":")[2]);
        RString hms = hh.concat(mm).concat(ss);
        RString ymshms = yms.toDateString().concat(hms);
        YMDHMS 最終計算処理日時 = new YMDHMS(ymshms);
        RString 通知書名 = div.getDdlTsuchishoMeisho().getSelectedValue();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        YMDHMS 帳票作成日時 = YMDHMS.now();
        List<TsuchiShoHakkoGoIdosha> 異動者リスト = new ArrayList<>();
        for (final dgIdoTaishoshaIchiran_Row row : rowList) {
            TsuchiShoHakkoGoIdosha 異動者Entity = new TsuchiShoHakkoGoIdosha();
            異動者Entity.set通知書番号(new TsuchishoNo(row.getTxtTsuchishoNo()));
            異動者Entity.set被保険者番号(new HihokenshaNo(row.getTxtHihoNo()));
            異動者Entity.set該当連番(Integer.valueOf(row.getTxtGaitoRenban().toString()));
            RDate 異動日 = new RDate(row.getTxtIdoYMD().toString());
            異動者Entity.set異動日(new FlexibleDate(異動日.toString()));
            異動者Entity.set異動内容(IdoNaiyo.toIdoNaiyo(row.getTxtIdoNaiyo()));
            IName in = new IName() {
                @Override
                public AtenaMeisho getName() {
                    return new AtenaMeisho(row.getTxtShimei());
                }

                @Override
                public AtenaKanaMeisho getKana() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
            異動者Entity.set氏名(in);
            異動者Entity.set識別コード(new ShikibetsuCode(row.getTxtShikibetsuCode()));
            異動者Entity.set賦課年度(new RYear(row.getTexYSeireki()));
            異動者リスト.add(異動者Entity);
        }
        TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報 = new TsuchiShoHakkogoIdoshaListJoho(
                通知書発行日時, 最終計算処理日時, 通知書名, 異動者リスト);
        return ResponseData.of(new HakkogoIdoTaishoshaIchiranPrintService().
                printSingle(発行後異動者一覧情報, association, 帳票作成日時)).respond();
    }

    private IdoTaishoshaIchiranHandler getHandler(IdoTaishoshaIchiranDiv div) {
        return IdoTaishoshaIchiranHandler.of(div);
    }

    private void putViewState(IdoTaishoshaIchiranDiv div) {
        dgIdoTaishoshaIchiran_Row row = div.getDgIdoTaishoshaIchiran().getClickedItem();
        IdoTaishoshaIchiranparameter par = new IdoTaishoshaIchiranparameter(
                new FlexibleYear(row.getTexYSeireki().toString()),
                new HihokenshaNo(row.getTxtHihoNo().toString()),
                new TsuchishoNo(row.getTxtTsuchishoNo().toString()),
                new ShikibetsuCode(row.getTxtShikibetsuCode().toString())
        );
        ViewStateHolder.put(ViewStateKeys.異動者一覧Par, par);
    }

}
