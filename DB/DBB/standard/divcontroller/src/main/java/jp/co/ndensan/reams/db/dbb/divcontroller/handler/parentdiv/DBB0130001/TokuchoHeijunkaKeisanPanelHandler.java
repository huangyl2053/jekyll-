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
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        for (int i = 0; i < 特徴平準化.getShoriJohkyoList(調定年度).size(); i++) {
            dgHeijunka8ShoriKakunin1_Row row = new dgHeijunka8ShoriKakunin1_Row();
            if (ShoriName.当初所得引出.get名称().equals(特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName())) {
                if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName().isNullOrEmpty()) {
                    row.setTxtJokyo(未);
                    row.setTxtShoriNichiji(特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().toDateString());
                    rowList.add(row);

                } else {
                    if (DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, nowDate, SubGyomuCode.DBB介護賦課).
                            equals(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課))) {
                        row.setTxtJokyo(済);
                        row.setTxtShoriNichiji(RString.EMPTY);
                        rowList.add(row);

                    } else {
                        row.setTxtJokyo(未);
                        row.setTxtShoriNichiji(RString.EMPTY);
                        rowList.add(row);

                    }
                }
            }

            if (ShoriName.依頼金額計算.get名称().equals(特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName())) {
                if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName().isNullOrEmpty()) {
                    row.setTxtJokyo(未);
                    row.setTxtShoriNichiji(RString.EMPTY);
                    rowList.add(row);
                } else if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp() == null
                        || 特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().isEmpty()) {
                    row.setTxtJokyo(未);
                    row.setTxtShoriNichiji(RString.EMPTY);
                    rowList.add(row);
                } else {
                    row.setTxtJokyo(済);
                    row.setTxtShoriNichiji(特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().toDateString());
                    rowList.add(row);

                }
            }

            if (ShoriName.本算定賦課確定.get名称().equals(特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName())) {
                if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName().isNullOrEmpty()) {
                    row.setTxtJokyo(未);
                    row.setTxtShoriNichiji(RString.EMPTY);
                    rowList.add(row);
                } else if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp() == null
                        || 特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().isEmpty()) {
                    row.setTxtJokyo(未);
                    row.setTxtShoriNichiji(RString.EMPTY);
                    rowList.add(row);
                } else {
                    row.setTxtJokyo(済);
                    row.setTxtShoriNichiji(特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().toDateString());
                    rowList.add(row);
                }
            }

            if (ShoriName.特徴異動情報作成.get名称().equals(特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName())) {
                if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getShoriName().isNullOrEmpty()) {
                    row.setTxtJokyo(未);
                    row.setTxtShoriNichiji(RString.EMPTY);
                    rowList.add(row);
                } else if (特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp() == null
                        || 特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().isEmpty()) {
                    row.setTxtJokyo(未);
                    row.setTxtShoriNichiji(RString.EMPTY);
                    rowList.add(row);
                } else {
                    row.setTxtJokyo(済);
                    row.setTxtShoriNichiji(特徴平準化.getShoriJohkyoList(調定年度).get(i).getKijunTimestamp().toDateString());
                    rowList.add(row);
                }
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
        div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoGengaku().setValue(TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称());
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

        if (ONE.equals(増額時平準化)) {
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
        div.getHeijunka8KeisanHohoPanel().getTxtKeisanHohoZougaku().setValue(
                TokuchoHeijunkaKeisanHoho8Gatsu.平準化しない.get名称());
    }
}
