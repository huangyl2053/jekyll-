/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsahoshuichiran.ShinsaHoshuIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsahoshuichiran.ShinsaHoshuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.ShinsakauIinHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6040001.dgShinsakaiIinHoshu_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 審査会委員報酬照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1920-010 zhaoyao
 */
public class ShinsakauIinHoshuShokaiHandler {

    private static final RString 一覧表を発行する = new RString("btnPulish");
    private static final RString CSVを出力する = new RString("btnShutsutyoku");
    private static final RString 条件に戻る = new RString("btnBackToKensaku");
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
     * 画面初期状態の設定です。
     */
    public void set初期状態() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(一覧表を発行する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, false);
        div.getShinsakaiIinHoshu().setDisplayNone(true);
        div.getShinsakaiKaisaibi().setDisplayNone(false);
        div.getShinsakaiKaisaibi().getTxtShinsakaiKaisaiYM().setPlaceHolder(
                RDate.getNowDate().getYearMonth().wareki().toDateString());
    }

    /**
     * 画面一覧状態の設定です。
     */
    public void set一覧状態() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(一覧表を発行する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, true);
        div.getShinsakaiIinHoshu().setDisplayNone(false);
        div.getShinsakaiKaisaibi().setDisplayNone(true);
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

            dgShinsakaiIinHoshu_Row row = new dgShinsakaiIinHoshu_Row(new RString(data.get合議体番号()),
                    data.get介護認定審査会委員氏名(),
                    data.get出席状況_1日(),
                    data.get出席状況_2日(),
                    data.get出席状況_3日(),
                    data.get出席状況_4日(),
                    data.get出席状況_5日(),
                    data.get出席状況_6日(),
                    data.get出席状況_7日(),
                    data.get出席状況_8日(),
                    data.get出席状況_9日(),
                    data.get出席状況_10日(),
                    data.get出席状況_11日(),
                    data.get出席状況_12日(),
                    data.get出席状況_13日(),
                    data.get出席状況_14日(),
                    data.get出席状況_15日(),
                    data.get出席状況_16日(),
                    data.get出席状況_17日(),
                    data.get出席状況_18日(),
                    data.get出席状況_19日(),
                    data.get出席状況_20日(),
                    data.get出席状況_21日(),
                    data.get出席状況_22日(),
                    data.get出席状況_23日(),
                    data.get出席状況_24日(),
                    data.get出席状況_25日(),
                    data.get出席状況_26日(),
                    data.get出席状況_27日(),
                    data.get出席状況_28日(),
                    data.get出席状況_29日(),
                    data.get出席状況_30日(),
                    data.get出席状況_31日(),
                    new RString(data.get出席回数()),
                    DecimalFormatter.toコンマ区切りRString(data.get報酬総額(), ZERO),
                    DecimalFormatter.toコンマ区切りRString(data.getその他費用(), ZERO),
                    DecimalFormatter.toコンマ区切りRString(data.get税額控除(), ZERO),
                    DecimalFormatter.toコンマ区切りRString(data.get報酬合計(), ZERO)
            );
            rowList.add(row);
        }
        div.getShinsakaiIinHoshu().setDisplayNone(false);
        div.getDgShinsakaiIinHoshu().setDataSource(rowList);
        div.getTxtShinsaKaisu().setValue(総合計_審査回数);
        div.getTxtHoshuSogaku().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_報酬総額());
        div.getTxtSonotaHiyo().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_その他費用());
        div.getTxtZeiKojoGaku().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_税控除額());
        div.getTxtHoshuGokei().setValue(ihinsaHoshuIchiranList.get(ZERO).get総合計_報酬合計());
    }

    /**
     * 介護認定審査会委員報酬一覧表のBatchParameter作成
     *
     * @param 帳票出力区分 帳票出力区分のフラグ
     * @return BatchParameter
     */
    public ShinsaHoshuIchiranBatchParameter createBatchParam(RString 帳票出力区分) {
        ShinsaHoshuIchiranBatchParameter param = new ShinsaHoshuIchiranBatchParameter();
        param.setShinsakaiKaisaiYMD(new RString(div.getTxtShinsakaiKaisaiYM().getValue().getYearMonth().toString()));
        param.setShisakaisu(new RString(div.getTxtShinsaKaisu().toString()));
        param.setHosyusogaku(new RString(div.getTxtHoshuSogaku().toString()));
        param.setSegakukojyo(new RString(div.getTxtZeiKojoGaku().toString()));
        param.setHosyugoke(new RString(div.getTxtHoshuGokei().toString()));
        param.setSyohyoSyuturyoku(帳票出力区分);
        return param;
    }
}
