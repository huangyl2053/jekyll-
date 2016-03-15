/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0020001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.IdoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.dgIdoTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.idotaishoshaichiranpar.IdoTaishoshaIchiranPar;
import jp.co.ndensan.reams.db.dbb.entity.tsuchishohakkogoidosha.DbT2017Uaft200EntityResult;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoHaaku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 */
public class IdoTaishoshaIchiranHandler {

    private final IdoTaishoshaIchiranDiv div;

    private IdoTaishoshaIchiranHandler(IdoTaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * of
     *
     * @param div div
     * @return IdoTaishoshaIchiranHandler
     */
    public static IdoTaishoshaIchiranHandler of(IdoTaishoshaIchiranDiv div) {
        return new IdoTaishoshaIchiranHandler(div);
    }

    public void set作成日時() {
        RString select帳票ID = div.getDdlTsuchishoMeisho().getSelectedKey();
        Map<ReportId, List<YMDHMS>> map = ViewStateHolder.get(ViewStateKeys.発行日時Map, Map.class);
        List<YMDHMS> 作成日時List = map.get(new ReportId(select帳票ID));
        Comparator<YMDHMS> comparator = new Comparator<YMDHMS>() {
            @Override
            public int compare(YMDHMS s1, YMDHMS s2) {
                return s1.compareTo(s2);
            }
        };
        Collections.sort(作成日時List, comparator);
        List<KeyValueDataSource> 作成日時KeyValue = new ArrayList<>();
        for (YMDHMS 作成日時 : 作成日時List) {
            String hh = 作成日時.toString().substring(8, 10);
            String mm = 作成日時.toString().substring(10, 12);
            String ss = 作成日時.toString().substring(12, 14);
            String ymd = 作成日時.getDate().wareki().toDateString().toString();
            String hms = hh + ":" + mm + new RString(":") + ss;
            RString ymdhms = new RString(ymd + " " + hms);
            作成日時KeyValue.add(new KeyValueDataSource(new RString(作成日時.toString()), ymdhms));
        }
        div.getDdlSakuseiYMD().setDataSource(作成日時KeyValue);
        div.getDdlSakuseiYMD().setSelectedIndex(0);
    }

    public void set最終計算処理日時() {
        ReportId par帳票ID = new ReportId(div.getDdlTsuchishoMeisho().getSelectedKey());
        YMDHMS par帳票作成日時 = new YMDHMS(div.getDdlSakuseiYMD().getSelectedKey());
        YMDHMS 最終計算処理日時 = TsuchiShoHakkogoIdoHaaku.createInstance().get計算処理日時(par帳票ID, par帳票作成日時);
        String hh = 最終計算処理日時.toString().substring(8, 10);
        String mm = 最終計算処理日時.toString().substring(10, 12);
        String ss = 最終計算処理日時.toString().substring(12, 14);
        String ymd = 最終計算処理日時.getDate().wareki().toDateString().toString();
        String hms = hh + ":" + mm + new RString(":") + ss;
        RString ymdhms = new RString(ymd + " " + hms);
        div.getTxtLastKeisanShoriTime().setValue(ymdhms);
    }

    public List<DbT2017Uaft200EntityResult> set異動者チェック情報() {
        ReportId 帳票ID = new ReportId(div.getDdlTsuchishoMeisho().getSelectedKey());
        YMDHMS 帳票作成日時 = new YMDHMS(div.getDdlSakuseiYMD().getSelectedKey());
        List<DbT2017Uaft200EntityResult> entityList = TsuchiShoHakkogoIdoHaaku.createInstance()
                .get異動者チェック情報(帳票ID, 帳票作成日時);
        return entityList;
    }

    public void initialize(List<DbT2017Uaft200EntityResult> entityList) {
        List<dgIdoTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (DbT2017Uaft200EntityResult entity : entityList) {
            dgIdoTaishoshaIchiran_Row row = new dgIdoTaishoshaIchiran_Row();
            row.setTxtGaitoRenban(new RString(String.valueOf(entity.getDbT2017Entity().getGaitoRemban())));
            row.setTxtHihoNo(entity.getDbT2017Entity().getHihokenshaNo().getColumnValue());
            row.setTxtShikibetsuCode(entity.getDbT2017Entity().getShikibetsuCode().getColumnValue());
            row.setTxtTsuchishoNo(entity.getDbT2017Entity().getTsuchishoNo().getColumnValue());
            row.setTxtShimei(entity.get名称().getColumnValue());
            RString idoYMD = new RString(entity.getDbT2017Entity().getIdoYMD().wareki().toDateString().toString());
            row.setTxtIdoYMD(idoYMD);
            // TODO
            row.setTxtIdoNaiyo(entity.getDbT2017Entity().getIdoNaiyo());
            row.setTexYSeireki(entity.getDbT2017Entity().getFukaNendo().toDateString());
            rowList.add(row);
        }
        div.getDgIdoTaishoshaIchiran().setDataSource(rowList);
    }

    public void putViewState() {
        List<IdoTaishoshaIchiranPar> listPar = new ArrayList<>();
        List<dgIdoTaishoshaIchiran_Row> rowList = div.getDgIdoTaishoshaIchiran().getDataSource();
        for (dgIdoTaishoshaIchiran_Row row : rowList) {
            IdoTaishoshaIchiranPar par = new IdoTaishoshaIchiranPar(
                    new FlexibleYear(row.getTexYSeireki().toString()),
                    new HihokenshaNo(row.getTxtHihoNo().toString()),
                    new TsuchishoNo(row.getTxtTsuchishoNo().toString()),
                    new ShikibetsuCode(row.getTxtShikibetsuCode().toString())
            );
            listPar.add(par);
        }
        ViewStateHolder.put(ViewStateKeys.異動者一覧Par, (Serializable) listPar);
    }
}
