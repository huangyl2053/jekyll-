/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130001.TokuchoHeijunkaKeisanPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130001.dgHeijunka8ShoriKakunin1_Row;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka8.KaigoFukaTokuchoHeijunka8;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 特徴平準化（特徴8月分）の画面クラスです。
 *
 * @reamsid_L DBB-0860-010 lihang
 */
public class TokuchoHeijunkaKeisanPanelHandler {

    private final TokuchoHeijunkaKeisanPanelDiv div;
    private static final RString ONE = new RString("1");
    private static final RString ZERO = new RString("0");
    private static final RString TWO = new RString("2");
    private static final RString 未 = new RString("未");
    private static final RString 済 = new RString("済");
    private static final RString 当初所得引出 = new RString("当初所得引出");
    private static final RString 依頼金額計算 = new RString("依頼金額計算");
    private static final RString 本算定賦課 = new RString("本算定賦課");
    private static final RString 特徴異動情報作成 = new RString("特徴異動情報作成");
    private static final RString 実行するボタン = new RString("btnBatchRegister");

    /**
     * コンストラクタです。
     *
     *
     * @param div TokuchoHeijunkaKeisanPanelDiv
     */
    public TokuchoHeijunkaKeisanPanelHandler(TokuchoHeijunkaKeisanPanelDiv div) {
        this.div = div;
    }

    private void get未処理の場合() {
        RDate nowDate = RDate.getNowDate();
        KaigoFukaTokuchoHeijunka8 特徴平準化 = new KaigoFukaTokuchoHeijunka8();
        FlexibleYear 調定年度 = new FlexibleYear(
                div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtChoteiNendo().getValue());

        List<dgHeijunka8ShoriKakunin1_Row> rowList = new ArrayList<>();

        YMDHMS 処理日時0 = 特徴平準化.getShoriJohkyoList(調定年度).get(0).getKijunTimestamp();
        dgHeijunka8ShoriKakunin1_Row row1 = new dgHeijunka8ShoriKakunin1_Row();
        row1.setTxtShoriMei(当初所得引出);
        if (特徴平準化.getShoriJohkyoList(調定年度).get(0).getShoriName().isNullOrEmpty()) {
            row1.setTxtJokyo(未);
            row1.setTxtShoriNichiji(get当月処理日時(処理日時0));
            rowList.add(row1);

        } else {
            if (DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, nowDate, SubGyomuCode.DBB介護賦課).
                    equals(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課))) {
                row1.setTxtJokyo(済);
                row1.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row1);

            } else {
                row1.setTxtJokyo(未);
                row1.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row1);

            }
        }
        for (int i = 0, len = 特徴平準化.getShoriJohkyoList(調定年度).size(); i < len; i++) {
            dgHeijunka8ShoriKakunin1_Row row2 = new dgHeijunka8ShoriKakunin1_Row();
            YMDHMS 処理日時 = 特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp();
            row2.setTxtShoriMei(依頼金額計算);
            if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName().isNullOrEmpty()) {
                row2.setTxtJokyo(未);
                row2.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row2);
            } else if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp() == null
                    || 特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().isEmpty()) {
                row2.setTxtJokyo(未);
                row2.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row2);
            } else {
                row2.setTxtJokyo(済);
                row2.setTxtShoriNichiji(get当月処理日時(処理日時));
                rowList.add(row2);

            }
            dgHeijunka8ShoriKakunin1_Row row3 = new dgHeijunka8ShoriKakunin1_Row();
            row3.setTxtShoriMei(本算定賦課);
            if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName().isNullOrEmpty()) {
                row3.setTxtJokyo(未);
                row3.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row3);
            } else if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp() == null
                    || 特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().isEmpty()) {
                row3.setTxtJokyo(未);
                row3.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row3);
            } else {
                row3.setTxtJokyo(済);
                row3.setTxtShoriNichiji(get当月処理日時(処理日時));
                rowList.add(row3);
            }
            dgHeijunka8ShoriKakunin1_Row row4 = new dgHeijunka8ShoriKakunin1_Row();
            row4.setTxtShoriMei(特徴異動情報作成);
            if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName().isNullOrEmpty()) {
                row4.setTxtJokyo(未);
                row4.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row4);
            } else if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp() == null
                    || 特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().isEmpty()) {
                row4.setTxtJokyo(未);
                row4.setTxtShoriNichiji(RString.EMPTY);
                rowList.add(row4);
            } else {
                row4.setTxtJokyo(済);
                row4.setTxtShoriNichiji(get当月処理日時(処理日時));
                rowList.add(row4);
            }
        }
        div.getHeijunkaAugustKeisan().getHeijunka8ShoriKakunin().getDgHeijunka8ShoriKakunin1().setDataSource(rowList);
    }

    /**
     * get処理状態です
     */
    public void get処理状態() {
        KaigoFukaTokuchoHeijunka8 特徴平準化 = new KaigoFukaTokuchoHeijunka8();
        FlexibleYear 調定年度 = new FlexibleYear(
                div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtChoteiNendo().getValue());
        boolean is特徴平準化処理状況 = 特徴平準化.getHeijunka8MJyokyo(調定年度);
        if (is特徴平準化処理状況) {
            throw new ApplicationException(DbbErrorMessages.処理済み.getMessage().replace("特徴平準化（８月分）"));
        } else {
            get未処理の場合();

        }
    }

    /**
     * get減額平準化計算方法です
     */
    public void get減額平準化計算方法() {

        RDate 年度 = new RDate(div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtChoteiNendo().getValue().toString());
        RString 減額時平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_8月分減額, 年度,
                SubGyomuCode.DBB介護賦課);
        RString 平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_8月分, 年度,
                SubGyomuCode.DBB介護賦課);
        if (ZERO.equals(減額時平準化)) {
            div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoGengaku().setValue(
                    TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称());
        }
        if (ONE.equals(減額時平準化)) {
            if (ZERO.equals(平準化)) {
                div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoGengaku().setValue(
                        TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称());
            } else if (ONE.equals(平準化)) {
                div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoGengaku().setValue(
                        TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.get名称());
            } else if (TWO.equals(平準化)) {
                div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoGengaku().setValue(
                        TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.get名称());
            }
        }

    }

    /**
     * get増額平準化計算方法です
     */
    public void get増額平準化計算方法() {
        RDate 年度 = new RDate(div.getHeijunkaAugustKeisan().getHeijunka8ShoriNaiyo().getTxtChoteiNendo().getValue().toString());
        RString 平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_8月分, 年度,
                SubGyomuCode.DBB介護賦課);
        RString 増額時平準化 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_8月分増額, 年度,
                SubGyomuCode.DBB介護賦課);
        if (ZERO.equals(増額時平準化)) {
            div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoZougaku().setValue(
                    TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称());
        } else if (ONE.equals(増額時平準化)) {
            if (ZERO.equals(平準化)) {
                div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoZougaku().setValue(
                        TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称());
            } else if (ONE.equals(平準化)) {
                div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoZougaku().setValue(
                        TokuchoHeijunkaKeisanHoho8Gatsu.前半と後半を１_１にする.get名称());
            } else if (TWO.equals(平準化)) {
                div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoZougaku().setValue(
                        TokuchoHeijunkaKeisanHoho8Gatsu.年額より特徴３期分を含まない仮徴収額を引いた額を４期で割る.get名称());
            }
        }

    }

    private RString get当月処理日時(YMDHMS 当月処理日時) {
        if (null != 当月処理日時) {
            RDate date = 当月処理日時.getDate();
            RTime time = 当月処理日時.getRDateTime().getTime();
            return new RString(new YMDHMS(date, time).toString());
        }
        return RString.EMPTY;

    }

    /**
     * setボタン制御
     */
    public void setボタン制御() {
        boolean is処理状態1 = div.getHeijunkaAugustKeisan().getHeijunka8ShoriKakunin().getDgHeijunka8ShoriKakunin1().
                getDataSource().get(0).getTxtJokyo().equals(済)
                && div.getHeijunkaAugustKeisan().getHeijunka8ShoriKakunin().getDgHeijunka8ShoriKakunin1().
                getDataSource().get(1).getTxtJokyo().equals(済);
        boolean is処理状態2 = div.getHeijunkaAugustKeisan().getHeijunka8ShoriKakunin().getDgHeijunka8ShoriKakunin1().
                getDataSource().get(2).getTxtJokyo().equals(未)
                && div.getHeijunkaAugustKeisan().getHeijunka8ShoriKakunin().getDgHeijunka8ShoriKakunin1().
                getDataSource().get(3).getTxtJokyo().equals(未);
        if (is処理状態1 && is処理状態2) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行するボタン, false);
        }
    }
}
