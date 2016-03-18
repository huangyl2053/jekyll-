/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0020001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.PublishedReportInfo;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkoGoIdosha;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoshaListJoho;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.DBB0020001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.IdoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0020001.IdoTaishoshaIchiranHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbb.entity.tsuchishohakkogoidosha.DbT2017Uaft200EntityResult;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoHaaku;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM32001_通知書発行後異動把握
 */
public class IdoTaishoshaIchiran {

    private static final RString 一覧表を = new RString("btnHakko");
    private static final RString 即時賦課更生 = new RString("btnToSokujiKosei");
    private static final RString 各種通知書発行 = new RString("btnToKakushuTsuchishoHakko");

    public ResponseData onLoad(IdoTaishoshaIchiranDiv div) {
        List<PublishedReportInfo> 発行帳票情報List = TsuchiShoHakkogoIdoHaaku.createInstance().get帳票情報();
        Map<RString, RString> 帳票名Map = TsuchiShoHakkogoIdoHaaku.createInstance().get通知書名称(発行帳票情報List);
        div.getDdlTsuchishoMeisho().setDataSource(KeyValueDataSourceConverter.getDataSource(帳票名Map));
        div.getDdlTsuchishoMeisho().setSelectedIndex(0);
        Map<ReportId, List<YMDHMS>> 発行日時Map = TsuchiShoHakkogoIdoHaaku.createInstance().get作成日時(発行帳票情報List);
        ViewStateHolder.put(ViewStateKeys.発行日時Map, (Serializable) 発行日時Map);
        getHandler(div).set作成日時();
        getHandler(div).set最終計算処理日時();
        return ResponseData.of(div).respond();
    }

    public ResponseData<IdoTaishoshaIchiranDiv> onChange_ddlMeisho(IdoTaishoshaIchiranDiv div) {
        getHandler(div).set作成日時();
        getHandler(div).set最終計算処理日時();
        div.getDgIdoTaishoshaIchiran().getDataSource().clear();
        return ResponseData.of(div).respond();
    }

    public ResponseData<IdoTaishoshaIchiranDiv> onChange_ddlYMD(IdoTaishoshaIchiranDiv div) {
        getHandler(div).set最終計算処理日時();
        div.getDgIdoTaishoshaIchiran().getDataSource().clear();
        return ResponseData.of(div).respond();
    }

    public ResponseData<IdoTaishoshaIchiranDiv> onClick_btnIdoShaCheck(IdoTaishoshaIchiranDiv div) {
        List<DbT2017Uaft200EntityResult> entityList = getHandler(div).set異動者チェック情報();
        if (entityList == null || entityList.isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbbInformationMessages.期間内異動なし.getMessage()).respond();
            }
            if (new RString(DbbInformationMessages.期間内異動なし.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(一覧表を, true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(即時賦課更生, true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(各種通知書発行, true);
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).initialize(entityList);
        ViewStateHolder.put(ViewStateKeys.異動者一覧データ, (Serializable) entityList);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(即時賦課更生, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(各種通知書発行, true);
        return ResponseData.of(div).respond();
    }

    public ResponseData<IdoTaishoshaIchiranDiv> onClick_show(IdoTaishoshaIchiranDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(即時賦課更生, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(各種通知書発行, false);
        return ResponseData.of(div).respond();
    }

    public ResponseData<IdoTaishoshaIchiranDiv> onClick_btnToKakushu(IdoTaishoshaIchiranDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBB0020001TransitionEventName.各種通知書作成へ).respond();
    }

    public ResponseData<IdoTaishoshaIchiranDiv> onClick_btnToSokujiKosei(IdoTaishoshaIchiranDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).forwardWithEventName(DBB0020001TransitionEventName.即時更生へ).respond();
    }

    public ResponseData<IdoTaishoshaIchiranDiv> onClick_btnHakko(IdoTaishoshaIchiranDiv div) {
        List<TsuchiShoHakkoGoIdosha> 異動者リスト = new ArrayList<>();
        List<DbT2017Uaft200EntityResult> entityList = ViewStateHolder.get(ViewStateKeys.異動者一覧データ, List.class);
        YMDHMS 通知書発行日時 = new YMDHMS(div.getDdlSakuseiYMD().getSelectedKey());
        String[] time = div.getTxtLastKeisanShoriTime().getValue().toString().split(" ");
        String yms = (new RDate(time[0])).toString();
        String[] hhmmss = time[1].split(":");
        String hh = hhmmss[0];
        String mm = hhmmss[1];
        String ss = hhmmss[2];
        String hms = hh + mm + ss;
        String ymshms = yms + hms;
        YMDHMS 最終計算処理日時 = new YMDHMS(ymshms);
        RString 通知書名 = div.getDdlTsuchishoMeisho().getSelectedValue();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        YMDHMS 帳票作成日時 = YMDHMS.now();
        for (final DbT2017Uaft200EntityResult entity : entityList) {
            TsuchiShoHakkoGoIdosha 異動者Entity = new TsuchiShoHakkoGoIdosha();
            異動者Entity.set帳票ID(Integer.parseInt(
                    entity.getDbT2017Entity().getReportID().getColumnValue().toString()));
            異動者Entity.set帳票作成日時(entity.getDbT2017Entity().getChohyosakuseiTimestamp());
            異動者Entity.set通知書番号(entity.getDbT2017Entity().getTsuchishoNo());
            異動者Entity.set被保険者番号(entity.getDbT2017Entity().getHihokenshaNo());
            異動者Entity.set該当連番(entity.getDbT2017Entity().getGaitoRemban());
            異動者Entity.set異動日(entity.getDbT2017Entity().getIdoYMD());
            異動者Entity.set異動内容(entity.getDbT2017Entity().getIdoNaiyo());
            異動者Entity.set計算処理日時(entity.getDbT2017Entity().getKeisanTimestamp());
            IName in = new IName() {
                @Override
                public AtenaMeisho getName() {
                    return entity.get名称();
                }

                @Override
                public AtenaKanaMeisho getKana() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
            異動者Entity.set氏名(in);
            異動者リスト.add(異動者Entity);
        }
        TsuchiShoHakkogoIdoshaListJoho 発行後異動者一覧情報 = new TsuchiShoHakkogoIdoshaListJoho(
                通知書発行日時, 最終計算処理日時, 通知書名, 異動者リスト);
        return ResponseData.of(div).respond();
//        return ResponseData.of(new HakkogoIdoTaishoshaIchiranPrintService().
//                print(発行後異動者一覧情報, association, 帳票作成日時)).respond();
    }

    private IdoTaishoshaIchiranHandler getHandler(IdoTaishoshaIchiranDiv div) {
        return IdoTaishoshaIchiranHandler.of(div);
    }

}
