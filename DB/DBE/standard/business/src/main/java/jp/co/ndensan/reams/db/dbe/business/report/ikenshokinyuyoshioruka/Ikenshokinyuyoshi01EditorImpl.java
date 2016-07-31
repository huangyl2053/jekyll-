/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.HomonShubetsu;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.Anteisei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 主治医意見書（オルカ）のEditorです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
public class Ikenshokinyuyoshi01EditorImpl implements IIkenshokinyuyoshi01Editor {

    private static final RString 問題なし = new RString("1");
    private static final RString 問題あり = new RString("2");
    private static final RString 選択 = new RString("1");
    private static final int LENGTH_3 = 3;
    private static final int LENGTH_4 = 4;
    private static final int LENGTH_5 = 5;
    private static final int LENGTH_6 = 6;
    private static final int LENGTH_7 = 7;
    private static final int LENGTH_8 = 8;
    private static final int LENGTH_9 = 9;
    private static final int LENGTH_10 = 10;
    private static final int LENGTH_11 = 11;
    private static final int LENGTH_12 = 12;
    private static final RString チェック = new RString("✔");
    private final IkenshokinyuyoshiBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link IkenshokinyuyoshiBusiness}
     */
    protected Ikenshokinyuyoshi01EditorImpl(IkenshokinyuyoshiBusiness business) {
        this.business = business;
    }

    /**
     * 主治医意見書（オルカ）を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public Ikenshokinyuyoshi01ReportSource edit(Ikenshokinyuyoshi01ReportSource source) {
        return editSource(source);
    }

    private Ikenshokinyuyoshi01ReportSource editSource(Ikenshokinyuyoshi01ReportSource source) {
        source.timeStamp = business.getタイムスタンプ();
        source.kinyuYMD = パターン34(business.get記入日());
        source.iryokikanNo = business.get事業所番号();
        source.sofuYMD = パターン34(business.get送付日());
        source.iraiNo = business.get依頼番号();
        source.hokenshaNo = business.get保険者番号();
        source.hokenshaName = business.get保険者名称();
        source.hihokenshaNo = business.get被保険者番号().padZeroToLeft(LENGTH_10);
        source.shinseiYMD = パターン34(business.get申請日());
        source.sakuseiYMD = パターン34(business.get作成依頼日());
        source.hihokenshaName1 = business.get患者名();
        source.hihokenshaKana1 = RStringUtil.convertカタカナtoひらがな(business.get患者名かな());
        source.seinengappi = パターン34(business.get生年月日());
        source.age1 = business.get患者_年齢();
        source.seibetsu = Seibetsu.toValue(business.get性別()).get名称();
        source.yubinNo1 = business.get郵便番号();
        source.jusho1 = business.get住所();
        source.hihokenshaTel1 = business.get連絡先電話番号();
        source.doiNashi = get意見書同意無チェック();
        source.doiAri = get意見書同意チェック();
        source.shujiiName1 = business.get医師氏名();
        source.ishiNo = business.get医師番号();
        source.iryokikanName1 = business.get医療機関名();
        source.iryokikanYubinNo = business.get医療機関郵便番号().getEditedYubinNo();
        source.iryokikanAdress1 = business.get医療機関所在地();
        source.iryokikanNameTel1 = business.get医療機関電話番号();
        source.iryokikanFax1 = business.get医療機関FAX番号();
        source.saishuShinsatsuYMD = パターン34(business.get最終診察日());
        source.sakuseiKaisu = IkenshoSakuseiKaisuKubun.toValue(business.get意見書作成回数()).getコード();
        if (HomonShubetsu.在宅.getコード().equals(business.get種別())) {
            source.shubetsuZaitaku = チェック;
        }
        if (HomonShubetsu.施設.getコード().equals(business.get種別())) {
            source.shubetsuShisetsu = チェック;
        }
        source.takajushinAri = get他科受診有チェック();
        source.takajushinNashi = get他科受診無チェック();
        if (選択.equals(business.get他科名().substring(0, 1))) {
            source.taNaika = チェック;
        }
        if (選択.equals(business.get他科名().substring(1, 2))) {
            source.taSeishinka = チェック;
        }
        if (選択.equals(business.get他科名().substring(2, LENGTH_3))) {
            source.taGeka = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_3, LENGTH_4))) {
            source.taSeikeigeka = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_4, LENGTH_5))) {
            source.taNoshinkeigeka = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_5, LENGTH_6))) {
            source.taHifuka = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_6, LENGTH_7))) {
            source.taHinyokika = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_7, LENGTH_8))) {
            source.taFujinka = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_8, LENGTH_9))) {
            source.taGanka = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_9, LENGTH_10))) {
            source.taJibiinkoka = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_10, LENGTH_11))) {
            source.taRihabirika = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_11, LENGTH_12))) {
            source.taShika = チェック;
        }
        if (選択.equals(business.get他科名().substring(LENGTH_12))) {
            source.taSonota = チェック;
        }
        source.taSonotakamei = business.getその他の他科名();
        source.shindamName1 = business.get診断名1();
        source.hasshoYMD1 = パターン12(business.get発症年月日1());
        source.shindamName2 = business.get診断名2();
        source.hasshoYMD2 = パターン12(business.get発症年月日2());
        source.shindamName3 = business.get診断名3();
        source.hasshoYMD3 = パターン12(business.get発症年月日3());
        if (Anteisei.安定.getコード().equals(business.get症状安定性())) {
            source.byojoAntei = チェック;
        } else if (Anteisei.不安定.getコード().equals(business.get症状安定性())) {
            source.byojoFuantei = チェック;
        } else if (Anteisei.不明.getコード().equals(business.get症状安定性())) {
            source.byojoFumei = チェック;
        }
        source.gutaitekiJokyo = business.get症状不安定時の具体的状況();
        return editSource2(source);
    }

    private Ikenshokinyuyoshi01ReportSource editSource2(Ikenshokinyuyoshi01ReportSource source) {
        source.chiryonaiyo = business.get経過及び治療内容();
        if (選択.equalsIgnoreCase(business.get処置内容().substring(0, 1))) {
            source.tokubetsuTenteki = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(1, 2))) {
            source.tokubetsuEiyo = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(2, LENGTH_3))) {
            source.tokubetsuToseki = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(LENGTH_3, LENGTH_4))) {
            source.tokubetsuSutoma = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(LENGTH_4, LENGTH_5))) {
            source.tokubetsuSanso = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(LENGTH_5, LENGTH_6))) {
            source.tokubetsuResupireta = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(LENGTH_6, LENGTH_7))) {
            source.tokubetsuKikansekkai = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(LENGTH_7, LENGTH_8))) {
            source.tokubetsuTotsu = チェック;
        }
        if (選択.equalsIgnoreCase(business.get処置内容().substring(LENGTH_8))) {
            source.tokubetsuKeikaneiyo = チェック;
        }
        if (選択.equalsIgnoreCase(business.get特別な対応().substring(0, 1))) {
            source.tokubetsuMonita = チェック;
        }
        if (選択.equalsIgnoreCase(business.get特別な対応().substring(1))) {
            source.tokubetsuJokuso = チェック;
        }
        if (選択.equals(business.get失禁への対応())) {
            source.tokubetsuKateteru = チェック;
        }
        return editSource3(source);
    }

    private Ikenshokinyuyoshi01ReportSource editSource3(Ikenshokinyuyoshi01ReportSource source) {
        if (IkenKomoku02.自立.getコード().equals(business.get寝たきり度())) {
            source.shogaiJiritsu = チェック;
        } else if (IkenKomoku02.J1.getコード().equals(business.get寝たきり度())) {
            source.shogaiJ1 = チェック;
        } else if (IkenKomoku02.J2.getコード().equals(business.get寝たきり度())) {
            source.shogaiJ2 = チェック;
        } else if (IkenKomoku02.A1.getコード().equals(business.get寝たきり度())) {
            source.shogaiA1 = チェック;
        } else if (IkenKomoku02.A2.getコード().equals(business.get寝たきり度())) {
            source.shogaiA2 = チェック;
        } else if (IkenKomoku02.B1.getコード().equals(business.get寝たきり度())) {
            source.shogaiB1 = チェック;
        } else if (IkenKomoku02.B2.getコード().equals(business.get寝たきり度())) {
            source.shogaiB2 = チェック;
        } else if (IkenKomoku02.C1.getコード().equals(business.get寝たきり度())) {
            source.shogaiC1 = チェック;
        } else if (IkenKomoku02.C2.getコード().equals(business.get寝たきり度())) {
            source.shogaiC2 = チェック;
        }
        if (IkenKomoku03.自立.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchishoJiritsu = チェック;
        }
        if (IkenKomoku03.Ⅰ.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchisho1 = チェック;
        }
        return editSource4(source);
    }

    private Ikenshokinyuyoshi01ReportSource editSource4(Ikenshokinyuyoshi01ReportSource source) {
        if (IkenKomoku03.Ⅱa.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchisho2a = チェック;
        }
        if (IkenKomoku03.Ⅱb.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchisho2b = チェック;
        }
        if (IkenKomoku03.Ⅲa.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchisho3a = チェック;
        }
        if (IkenKomoku03.Ⅲb.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchisho3b = チェック;
        }
        if (IkenKomoku03.Ⅳ.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchisho4 = チェック;
        }
        if (IkenKomoku03.M.getコード().equals(business.get認知症高齢者の日常生活自立度())) {
            source.ninchishoM = チェック;
        }
        if (問題なし.equals(business.get短期記憶())) {
            source.tankikiokuNashi = チェック;
        } else if (問題あり.equals(business.get短期記憶())) {
            source.tankikiokuAri = チェック;
        }
        if (IkenKomoku05.自立.getコード().equals(business.get認知能力())) {
            source.ninchinoryokuJiritsu = チェック;
        } else if (IkenKomoku05.いくらか困難.getコード().equals(business.get認知能力())) {
            source.ninchinoryokuKonnan = チェック;
        } else if (IkenKomoku05.見守りが必要.getコード().equals(business.get認知能力())) {
            source.ninchinoryokuHitsuyo = チェック;
        } else if (IkenKomoku05.判断できない.getコード().equals(business.get認知能力())) {
            source.ninchinoryokuDekinai = チェック;
        }
        if (IkenKomoku06.伝えられる.getコード().equals(business.get伝達能力())) {
            source.dentatsuDekiru = チェック;
        } else if (IkenKomoku06.いくらか困難.getコード().equals(business.get伝達能力())) {
            source.dentatsuKonnan = チェック;
        } else if (IkenKomoku06.具体的要求に限られる.getコード().equals(business.get伝達能力())) {
            source.dentatsuGentei = チェック;
        } else if (IkenKomoku06.伝えられない.getコード().equals(business.get伝達能力())) {
            source.dentatsuDekinai = チェック;
        }
        if (問題なし.equals(business.get周辺症状有無())) {
            source.shuhenjokyoNashi = チェック;
        } else if (問題あり.equals(business.get周辺症状有無())) {
            source.shuhenjokyoAri = チェック;
        }
        return editSource5(source);
    }

    private Ikenshokinyuyoshi01ReportSource editSource5(Ikenshokinyuyoshi01ReportSource source) {
        if (選択.equals(business.get周辺症状詳細().substring(0, 1))) {
            source.shuhenjokyoGenshi = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(1, 2))) {
            source.shuhenjokyoMoso = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(2, LENGTH_3))) {
            source.shuhenjokyoGyakuten = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_3, LENGTH_4))) {
            source.shuhenjokyoBogen = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_4, LENGTH_5))) {
            source.shuhenjokyoBoko = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_5, LENGTH_6))) {
            source.shuhenjokyoTeiko = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_6, LENGTH_7))) {
            source.shuhenjokyoHaikai = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_7, LENGTH_8))) {
            source.shuhenjoHi = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_8, LENGTH_9))) {
            source.shuhenjoFuketsu = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_9, LENGTH_10))) {
            source.shuhenjoIshoku = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_10, LENGTH_11))) {
            source.shuhenjoSeiteki = チェック;
        }
        if (選択.equals(business.get周辺症状詳細().substring(LENGTH_11))) {
            source.shuhenjoSonota = チェック;
        }
        source.shuhenjoSonotaKisai = business.getその他の周辺症状();
        if (IkenKomoku07.有.getコード().equals(business.get精神神経症状有無())) {
            source.seishinAri = チェック;
        } else if (IkenKomoku07.無.getコード().equals(business.get精神神経症状有無())) {
            source.seishinNashi = チェック;
        }
        source.seishinName = business.get精神神経症状名();
        if (IkenKomoku07.有.getコード().equals(business.get専門医受診有無())) {
            source.semmonijushinAri = チェック;
        } else if (IkenKomoku07.無.getコード().equals(business.get専門医受診有無())) {
            source.semmonijushinNashi = チェック;
        }
        source.semmonijushinName = business.get専門医受診科名();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(business.get被保険者番号())) {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), business.get被保険者番号());
        }
        return source;
    }

    //TODO 改行コード(CRLF)を垂直タブ(VT)で置き換え（先頭から11個まで）その他特記事項は700文字／12行以内の処理対応待ち。
//    private RString get経過及び治療内容() {
//        List<RString> list = business.get経過及び治療内容().split("\r\n");
//        RStringBuilder 経過及び治療内容 = new RStringBuilder();
//        if (0 < list.size()) {
//            経過及び治療内容.append(list.get(0)).append(System.lineSeparator());
//        }
//        if (1 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(1)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (2 > list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(2)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_3 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_3)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_4 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_4)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_5 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_5)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_6 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_6)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_7 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_7)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_8 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_8)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        return get経過及び治療内容(経過及び治療内容, list);
//    }
//
//    private RString get経過及び治療内容(RStringBuilder 経過及び治療内容, List<RString> list) {
//        if (LENGTH_9 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_9)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_10 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_10)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_11 < list.size()) {
//            if (経過及び治療内容.length() <= LENGTH_700) {
//                経過及び治療内容 = 経過及び治療内容.append(list.get(LENGTH_11)).append(System.lineSeparator());
//            } else {
//                return 経過及び治療内容.substring(0, LENGTH_700);
//            }
//        }
//        if (LENGTH_700 <= 経過及び治療内容.length()) {
//            return 経過及び治療内容.substring(0, LENGTH_700);
//        }
//        return 経過及び治療内容.toRString();
//    }
    private RString get他科受診有チェック() {
        if (business.is他科受診有無()) {
            return チェック;
        }
        return RString.EMPTY;
    }

    private RString get他科受診無チェック() {
        if (!business.is他科受診有無()) {
            return チェック;
        }
        return RString.EMPTY;
    }

    private RString get意見書同意チェック() {
        if (business.is同意の有無()) {
            return チェック;
        }
        return RString.EMPTY;
    }

    private RString get意見書同意無チェック() {
        if (!business.is同意の有無()) {
            return チェック;
        }
        return RString.EMPTY;
    }

    private RString パターン12(FlexibleDate 申請日) {
        if (申請日 == null || 申請日.isEmpty()) {
            return RString.EMPTY;
        }
        return 申請日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString パターン34(FlexibleDate 申請日) {
        if (申請日 == null || 申請日.isEmpty()) {
            return RString.EMPTY;
        }
        return 申請日.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
    }

}
