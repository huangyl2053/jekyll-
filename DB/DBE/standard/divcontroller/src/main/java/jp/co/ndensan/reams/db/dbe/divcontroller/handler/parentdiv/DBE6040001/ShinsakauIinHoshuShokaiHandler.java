/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran.ShinsaHoshuIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601006.DBE601006_ShinsakaiiinHoshuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.dgShinsakaiIinHoshu_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 審査会委員報酬照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1920-010 zhaoyao
 */
public class ShinsakauIinHoshuShokaiHandler {

    private static final int ZERO = 0;
    private final ShinsakauIinHoshuShokaiDiv div;
    private Decimal 総合計_審査回数 = Decimal.ZERO;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShinsakauIinHoshuShokaiHandler(ShinsakauIinHoshuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param ihinsaHoshuIchiranList 介護認定審査会委員報酬一覧表のリストデタ
     */
    public void onClick_BtnKensaku(List<ShinsaHoshuIchiran> ihinsaHoshuIchiranList) {

        List<dgShinsakaiIinHoshu_Row> rowList = new ArrayList<>();

        for (ShinsaHoshuIchiran data : ihinsaHoshuIchiranList) {

            総合計_審査回数 = 総合計_審査回数.add(data.get出席回数());

            dgShinsakaiIinHoshu_Row row = new dgShinsakaiIinHoshu_Row();
            row.getGogitaiBango().setValue(new Decimal(data.get合議体番号()));
            row.setShinsaIinMei(data.get介護認定審査会委員氏名());
            row.setShussekijokyo1(data.get出席状況_1日());
            row.setShussekijokyo2(data.get出席状況_2日());
            row.setShussekijokyo3(data.get出席状況_3日());
            row.setShussekijokyo4(data.get出席状況_4日());
            row.setShussekijokyo5(data.get出席状況_5日());
            row.setShussekijokyo6(data.get出席状況_6日());
            row.setShussekijokyo7(data.get出席状況_7日());
            row.setShussekijokyo8(data.get出席状況_8日());
            row.setShussekijokyo9(data.get出席状況_9日());
            row.setShussekijokyo10(data.get出席状況_10日());
            row.setShussekijokyo11(data.get出席状況_11日());
            row.setShussekijokyo12(data.get出席状況_12日());
            row.setShussekijokyo13(data.get出席状況_13日());
            row.setShussekijokyo14(data.get出席状況_14日());
            row.setShussekijokyo15(data.get出席状況_15日());
            row.setShussekijokyo16(data.get出席状況_16日());
            row.setShussekijokyo17(data.get出席状況_17日());
            row.setShussekijokyo18(data.get出席状況_18日());
            row.setShussekijokyo19(data.get出席状況_19日());
            row.setShussekijokyo20(data.get出席状況_20日());
            row.setShussekijokyo21(data.get出席状況_21日());
            row.setShussekijokyo22(data.get出席状況_22日());
            row.setShussekijokyo23(data.get出席状況_23日());
            row.setShussekijokyo24(data.get出席状況_24日());
            row.setShussekijokyo25(data.get出席状況_25日());
            row.setShussekijokyo26(data.get出席状況_26日());
            row.setShussekijokyo27(data.get出席状況_27日());
            row.setShussekijokyo28(data.get出席状況_28日());
            row.setShussekijokyo29(data.get出席状況_29日());
            row.setShussekijokyo30(data.get出席状況_30日());
            row.setShussekijokyo31(data.get出席状況_31日());            
            row.getShussekiKaisu().setValue(new Decimal(data.get出席回数()));
            row.getSogaku().setValue(data.get報酬総額());
            row.getSonotaHiyo().setValue(data.getその他費用());
            row.getZeiKojoGaku().setValue(data.get税額控除());
            row.getSashihikiHoshu().setValue(data.get報酬合計());
            rowList.add(row);
        }
        div.getDgShinsakaiIinHoshu().setDataSource(rowList);
        div.getTxtShinsaKaisu().setValue(総合計_審査回数);
        if (!ihinsaHoshuIchiranList.isEmpty()) {
            div.getTxtHoshuSogaku().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_報酬総額());
            div.getTxtSonotaHiyo().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_その他費用());
            div.getTxtZeiKojoGaku().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_税控除額());
            div.getTxtHoshuGokei().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_報酬合計());
        } else {
            div.getTxtHoshuSogaku().setValue(Decimal.ZERO);
            div.getTxtSonotaHiyo().setValue(Decimal.ZERO);
            div.getTxtZeiKojoGaku().setValue(Decimal.ZERO);
            div.getTxtHoshuGokei().setValue(Decimal.ZERO);
        }
    }

    /**
     * 介護認定審査会委員報酬一覧表のBatchParameter作成
     *
     * @param 帳票出力区分 帳票出力区分のフラグ
     * @return BatchParameter
     */
    public DBE601006_ShinsakaiiinHoshuParameter createBatchParam(RString 帳票出力区分) {
        DBE601006_ShinsakaiiinHoshuParameter param = new DBE601006_ShinsakaiiinHoshuParameter();
        param.setShinsakaiKaisaiYMD(new RString(div.getShinsakaiKaisaibi().getTxtShinsakaiKaisaiYM().getValue().getYearMonth().toString()));
        param.setSyohyoSyuturyoku(帳票出力区分);
        return param;
    }
}
