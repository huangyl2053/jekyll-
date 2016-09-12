/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0020001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha.TsuchiShoHakkoGoIdosha;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.IdoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020001.dgIdoTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchishohakkogoidosha.TsuchiShoHakkogoIdoHaaku;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * IdoTaishoshaIchiranHandler
 *
 * @reamsid_L DBB-0690-010 xuhao
 */
public final class IdoTaishoshaIchiranHandler {

    private final IdoTaishoshaIchiranDiv div;
    private static final int EIGHT = 8;
    private static final int TEN = 10;
    private static final int TWELVE = 12;
    private static final int FOURTEEN = 14;
    private static final int 整数_ZERO = 0;

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

    /**
     * set作成日時
     *
     * @param map Map
     */
    public void set作成日時(Map<ReportId, List<YMDHMS>> map) {
        RString select帳票ID = div.getDdlTsuchishoMeisho().getSelectedKey();
        List<YMDHMS> 作成日時List = map.get(new ReportId(select帳票ID));
        if (作成日時List != null && !作成日時List.isEmpty()) {
            Comparator<YMDHMS> comparator = new Comparator<YMDHMS>() {
                @Override
                public int compare(YMDHMS s1, YMDHMS s2) {
                    return s2.compareTo(s1);
                }
            };
            Collections.sort(作成日時List, comparator);
            List<KeyValueDataSource> 作成日時KeyValue = new ArrayList<>();
            for (YMDHMS 作成日時 : 作成日時List) {
                RString hh = new RString(作成日時.toString().substring(EIGHT, TEN));
                RString mm = new RString(作成日時.toString().substring(TEN, TWELVE));
                RString ss = new RString(作成日時.toString().substring(TWELVE, FOURTEEN));
                RString ymd = new RString(作成日時.getDate().wareki().toDateString().toString());
                RString hms = hh.concat(new RString(":")).concat(mm).concat(new RString(":")).concat(ss);
                RString ymdhms = ymd.concat(new RString(" ")).concat(hms);
                if (!作成日時KeyValue.contains(
                        new KeyValueDataSource(new RString(作成日時.toString()), ymdhms))) {
                    作成日時KeyValue.add(new KeyValueDataSource(new RString(作成日時.toString()), ymdhms));
                }
            }
            div.getDdlSakuseiYMD().setDataSource(作成日時KeyValue);
            div.getDdlSakuseiYMD().setSelectedIndex(整数_ZERO);
        }
    }

    /**
     * set最終計算処理日時
     */
    public void set最終計算処理日時() {
        ReportId par帳票ID = new ReportId(div.getDdlTsuchishoMeisho().getSelectedKey());
        RString 帳票作成日時 = div.getDdlSakuseiYMD().getSelectedKey();
        YMDHMS par帳票作成日時 = new YMDHMS(帳票作成日時);
        YMDHMS 最終計算処理日時 = TsuchiShoHakkogoIdoHaaku.createInstance().get計算処理日時(par帳票ID, par帳票作成日時);
        if (最終計算処理日時 != null && 最終計算処理日時.isEmpty()) {
            RString hh = new RString(最終計算処理日時.toString().substring(EIGHT, TEN));
            RString mm = new RString(最終計算処理日時.toString().substring(TEN, TWELVE));
            RString ss = new RString(最終計算処理日時.toString().substring(TWELVE, FOURTEEN));
            RString ymd = new RString(最終計算処理日時.getDate().wareki().toDateString().toString());
            RString hms = hh.concat(new RString(":")).concat(mm).concat(new RString(":")).concat(ss);
            RString ymdhms = ymd.concat(new RString(" ")).concat(hms);
            div.getTxtLastKeisanShoriTime().setValue(ymdhms);
        }
    }

    /**
     * set異動者チェック情報
     *
     * @return List
     */
    public List<TsuchiShoHakkoGoIdosha> set異動者チェック情報() {
        ReportId 帳票ID = new ReportId(div.getDdlTsuchishoMeisho().getSelectedKey());
        YMDHMS 帳票作成日時 = new YMDHMS(div.getDdlSakuseiYMD().getSelectedKey());
        List<TsuchiShoHakkoGoIdosha> entityList = TsuchiShoHakkogoIdoHaaku.createInstance()
                .get異動者チェック情報(帳票ID, 帳票作成日時);
        return entityList;
    }

    /**
     * initialize
     *
     * @param entityList entityList
     */
    public void initialize(List<TsuchiShoHakkoGoIdosha> entityList) {
        List<dgIdoTaishoshaIchiran_Row> rowList = new ArrayList<>();
        for (TsuchiShoHakkoGoIdosha entity : entityList) {
            dgIdoTaishoshaIchiran_Row row = new dgIdoTaishoshaIchiran_Row();
            row.setTxtGaitoRenban(new RString(String.valueOf(entity.get該当連番())));
            row.setTxtHihoNo(entity.get被保険者番号().getColumnValue());
            row.setTxtShikibetsuCode(entity.get識別コード().getColumnValue());
            row.setTxtTsuchishoNo(entity.get通知書番号().getColumnValue());
            row.setTxtShimei(entity.get氏名().getName().getColumnValue());
            FlexibleDate ymd = entity.get異動日();
            RString idoYMD = null;
            if (ymd != null) {
                idoYMD = new RString(ymd.wareki().toDateString().toString());
            }
            row.setTxtIdoYMD(idoYMD);
            // TODO QA340(Redmine#78346)
            row.setTxtIdoNaiyo(entity.get異動内容().get名称());
            row.setTexYSeireki(entity.get賦課年度().toDateString());
            rowList.add(row);
        }
        div.getDgIdoTaishoshaIchiran().setDataSource(rowList);
    }

}
