/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1320011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060020.DBC060020_KyufuhiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuCsvEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.KyufuTsuchiSakuseiIkatuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011.grdTuuchiJoho_Row;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 給付費通知書作成(一括)のHandlerです。
 *
 * @reamsid_L DBC-2280-010 chenxiangyu
 */
public class KyufuTsuchiSakuseiIkatuHandler {

    private final KyufuTsuchiSakuseiIkatuDiv div;
    private static final ReportId 帳票ID = new ReportId(new RString("DBC100041_KyufuhiTsuchisho"));
    private static final RString すべて選択 = new RString("すべて");
    private static final RString 事務広域 = new RString("111");
    private static final RString 事務単一 = new RString("120");
    private static final RString TWO = new RString("2");
    private static final RString ONE = new RString("1");
    private static final RString ZERO = new RString("0");
    private static final RString 給付費通知書１_A4縦 = new RString("DBC100041_KyufuhiTsuchishoCover");
    private static final RString 給付費通知書２_A4縦 = new RString("DBC100041_KyufuhiTsuchishoDetail");
    private static final RString 給付費通知書_シーラタイプ = new RString("DBC100042_KyufuhiTsuchishoSealer");
    private static final RString 給付費通知発行一覧表 = new RString("DBC200044_KyufuhiTuchiHakkoIchiran");
    private static final RString 給付費通知書３_A4縦_福祉用具貸与品目ページ = new RString(
            "DBC100043_KyufuhiTsuchishoFukushiYoguTaiyoHinmoku");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString KEY4 = new RString("key4");
    private static final RString KEY5 = new RString("key5");
    private static final RString KEY6 = new RString("key6");
    private static final RString KEY7 = new RString("key7");
    private static final RString KEY8 = new RString("key8");
    // TODO Redmine#98349(1602) バッチパラメータ「一括処理制御（合併区分）」の設定値の処理方がありません。
//    private static final RString KEY9 = new RString("key9");
//    private static final RString 非該当 = new RString("01");
    private static final RString 要支援_経過的要介護 = new RString("11");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final RString 帳票レコード種別 = new RString("F1");
    private static final RString 広域の場合市町村コード = new RString("000000");
    private static final RString 国保連IF取込レコードファイル名 = new RString("32200000.CSV");
    private static final RString 共有ファイル名 = new RString("国保連IF取込レコードファイル");
    private static final RString 共有ファイルPATH = new RString("C:\\Users\\ChenXiangyu\\shared\\sharedFiles\\DB\\");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");

    /**
     * コンストラクタです。
     *
     * @param div 給付費通知書作成(一括)のdiv
     */
    public KyufuTsuchiSakuseiIkatuHandler(KyufuTsuchiSakuseiIkatuDiv div) {
        this.div = div;
    }

    /**
     * 給付費通知書作成(一括)初期化を処理します。
     *
     * @param joho 市町村セキュリティの情報
     */
    public void onLoad(ShichosonSecurityJoho joho) {
        if (joho.get導入形態コード() != null) {
            if (事務広域.equals(joho.get導入形態コード().getKey())) {
                div.getKyufuTsuchiSakusei().setHdn市町村コード(広域の場合市町村コード);
            }
            if (事務単一.equals(joho.get導入形態コード().getKey())) {
                div.getKyufuTsuchiSakusei().setHdn市町村コード(
                        new LasdecCode(Association.getLasdecCode().code市町村()).code市町村RString());
            }
            div.getKyufuTsuchiSakusei().setHdn保険者構成key(joho.get導入形態コード().getKey());
        }
        div.getTdrServiceYM().setFromValue(null);
        div.getTdrServiceYM().setToValue(null);
        div.getKyufuTsuchiSakuseiPrint().getKyufuTsuchiSakuseiSetting().
                initialize(true, RDate.getNowDate(), true, false, null, false);
        div.getOptServiceType().setSelectedValue(すべて選択);
        div.getKyufuTsuchiSakuseiPrint().getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
        div.getKyufuTsuchiSakusei().getTxtHihokenshaNo().setValue(RString.EMPTY);
    }

    /**
     * 給付費通知書作成パラメータを作成します。
     *
     * @return DBC060020_KyufuhiTsuchishoParameter
     */
    public DBC060020_KyufuhiTsuchishoParameter create給付費通知書作成パラメータ() {
        DBC060020_KyufuhiTsuchishoParameter parameter = new DBC060020_KyufuhiTsuchishoParameter();
        parameter.set処理年月日(new FlexibleDate(
                div.getKyufuTsuchiSakuseiPrint().getKyufuTsuchiSakuseiSetting().getIssueDate().toDateString()));
        parameter.setサービス種類区分(div.getKyufuTsuchiSakusei().getOptServiceType().getSelectedValue());
        parameter.setサービス開始年月(new FlexibleYearMonth(
                div.getKyufuTsuchiSakusei().getTdrServiceYM().getFromValue().getYearMonth().toDateString()));
        parameter.setサービス終了年月(new FlexibleYearMonth(
                div.getKyufuTsuchiSakusei().getTdrServiceYM().getToValue().getYearMonth().toDateString()));
        if (!div.getKyufuTsuchiSakusei().getGrdTuuchiJoho().getDataSource().isEmpty()) {
            parameter.setページ出力区分(ONE);
        } else {
            parameter.setページ出力区分(ZERO);
        }
        if (!div.getKyufuTsuchiSakusei().getChkServiceSyuruiSyuyaku().getSelectedItems().isEmpty()) {
            parameter.set集約区分(ONE);
        } else {
            parameter.set集約区分(ZERO);
        }
        if (ONE.equals(parameter.getページ出力区分())) {
            // TODO Redmine#98349(1602) バッチパラメータ「一括処理制御（合併区分）」の設定値の処理方がありません。
//        parameter.set一括処理制御(すべて選択);
            if (事務広域.equals(div.getKyufuTsuchiSakusei().getHdn保険者構成key())) {
                parameter.set保険者構成(TWO);
            } else if (事務単一.equals(div.getKyufuTsuchiSakusei().getHdn保険者構成key())) {
                parameter.set保険者構成(ONE);
            }
        }
        parameter.set市町村コード(div.getKyufuTsuchiSakusei().getHdn市町村コード());
        parameter.set要介護度(div.getKyufuTsuchiSakusei().getHdn要介護度());
        List<KeyValueDataSource> chkTyusyutuJokenList = div.getKyufuTsuchiSakusei().getChkTyusyutuJoken().getSelectedItems();
        for (KeyValueDataSource dataSource : chkTyusyutuJokenList) {
            if (KEY0.equals(dataSource.getKey())) {
                parameter.set死亡者分(ONE);
            } else if (KEY1.equals(dataSource.getKey())) {
                parameter.setゼロ査定実績(ONE);
            } else if (KEY2.equals(dataSource.getKey())) {
                parameter.set再審査分(ONE);
            } else if (KEY3.equals(dataSource.getKey())) {
                parameter.set過誤分(ONE);
            } else if (KEY4.equals(dataSource.getKey())) {
                parameter.set施設分(ONE);
            } else if (KEY5.equals(dataSource.getKey())) {
                parameter.set特定入所者介護(ONE);
            } else if (KEY6.equals(dataSource.getKey())) {
                parameter.set償還分(ONE);
            }
        }
        parameter.set被保険者番号(div.getKyufuTsuchiSakusei().getTxtHihokenshaNo().getValue());
        parameter.set帳票ＩＤ１(給付費通知書１_A4縦);
        parameter.set帳票ＩＤ２(給付費通知書２_A4縦);
        parameter.set帳票ＩＤ３(給付費通知書_シーラタイプ);
        parameter.set帳票ＩＤ４(給付費通知発行一覧表);
        parameter.set帳票ＩＤ５(給付費通知書３_A4縦_福祉用具貸与品目ページ);
        // TODO 出力顺の相関方針が確定しないので、実装ができません
        parameter.set文書番号(div.getKyufuTsuchiSakuseiPrint().getCcdBunsyobango().get文書番号());
        return parameter;
    }

    /**
     * 「要介護度」「すべて選択」チェックボックスを変更します。
     */
    public void onChange_cbxYokaigoJotai() {
        if (div.getKyufuTsuchiSakusei().getChkYokaigodo().isAllSelected()
                || div.getKyufuTsuchiSakusei().getChkYokaigodo().getSelectedItems().isEmpty()) {
            div.getKyufuTsuchiSakusei().setHdn要介護度(null);
        } else {
            List<RString> 要介護度きーリスト = div.getKyufuTsuchiSakusei().getChkYokaigodo().getSelectedKeys();
            RString 要介護度 = RString.EMPTY;
            for (RString key : 要介護度きーリスト) {
                if (KEY1.equals(key)) {
                    要介護度 = 要介護度.concat(要介護1).concat(EUC_WRITER_DELIMITER);
                } else if (KEY2.equals(key)) {
                    要介護度 = 要介護度.concat(要介護2).concat(EUC_WRITER_DELIMITER);
                } else if (KEY3.equals(key)) {
                    要介護度 = 要介護度.concat(要介護3).concat(EUC_WRITER_DELIMITER);
                } else if (KEY4.equals(key)) {
                    要介護度 = 要介護度.concat(要介護4).concat(EUC_WRITER_DELIMITER);
                } else if (KEY5.equals(key)) {
                    要介護度 = 要介護度.concat(要介護5).concat(EUC_WRITER_DELIMITER);
                } else if (KEY6.equals(key)) {
                    要介護度 = 要介護度.concat(要支援1).concat(EUC_WRITER_DELIMITER);
                } else if (KEY7.equals(key)) {
                    要介護度 = 要介護度.concat(要支援2).concat(EUC_WRITER_DELIMITER);
                } else if (KEY8.equals(key)) {
                    要介護度 = 要介護度.concat(要支援_経過的要介護).concat(EUC_WRITER_DELIMITER);
                }
                // TODO Redmine#98349(1602) シート「項目定義」の「要介護度 CheckBoxList」に要介護度の設定値「01:非該当」が存在しない。
//                else if (KEY9.equals(key)) {
//                    要介護度 = 要介護度.concat(非該当).concat(EUC_WRITER_DELIMITER);
//                }
            }
            div.getKyufuTsuchiSakusei().setHdn要介護度(
                    要介護度.substring(Integer.parseInt(ZERO.toString()), 要介護度.lastIndexOf(EUC_WRITER_DELIMITER)));
        }
    }

    /**
     * 給付費通知情報を取り込むします。
     */
    public void setRowFileData() {
        List<grdTuuchiJoho_Row> list = new ArrayList();
        try (CsvReader<KyufuTsuchiSakuseiIkatuCsvEntity> csvReader = new CsvReader.InstanceBuilder(
                Path.combinePath(共有ファイルPATH, 国保連IF取込レコードファイル名),
                KyufuTsuchiSakuseiIkatuCsvEntity.class)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(Boolean.TRUE).build()) {
            List<KyufuTsuchiSakuseiIkatuCsvEntity> csvEntityList = new ArrayList<>();
            while (true) {
                KyufuTsuchiSakuseiIkatuCsvEntity entity = csvReader.readLine();
                if (entity != null) {
                    csvEntityList.add(entity);
                } else {
                    break;
                }
            }
            csvEntityList.remove(csvEntityList.size() - Integer.parseInt(ONE.toString()));
            for (KyufuTsuchiSakuseiIkatuCsvEntity entity : csvEntityList) {
                grdTuuchiJoho_Row rowData = new grdTuuchiJoho_Row();
                if ((entity.get帳票レコード種別() != null) && 帳票レコード種別.equals(entity.get帳票レコード種別())) {
                    RYearMonth サービス提供年月 = new RDate(entity.getサービス提供年月().toString()).getYearMonth();
                    if (div.getKyufuTsuchiSakusei().getTdrServiceYM().getFromValue().getYearMonth().isBeforeOrEquals(
                            サービス提供年月)
                            && サービス提供年月.isBeforeOrEquals(
                                    div.getKyufuTsuchiSakusei().getTdrServiceYM().getToValue().getYearMonth())) {
                        rowData.setTxtFileName(共有ファイル名);
                        rowData.setTxtHokenshaName(HokenshaNyuryokuHojoFinder.createInstance().getHokensha(
                                new HokenjaNo(entity.get保険者番号())).get保険者名());
                        rowData.setTxtServiceNengetsu(entity.getサービス提供年月());
                        list.add(rowData);
                    }
                }
            }
        }
        div.getKyufuTsuchiSakusei().getGrdTuuchiJoho().setDataSource(list);
    }
}
