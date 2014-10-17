/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
public class NengakuKeisan {

    private List<NengakuHokenryoHoji> nengakuHokenryoHojiList = new ArrayList<>();

    public 年額計算Output calc年額保険料(保険料段階判定input input) {

        年額計算Output output;

        // ①年額計算
        // ①-1 集計
        //List<NengakuHokenryoHoji> nengakuhokenryohoji = new ArrayList<>();
        //NengakuHokenryoHoji nengakuhokenryohoji = new NengakuHokenryoHoji();
        Map<String, HokenryoDankai> hokenryoDankaiMap = input.get年額賦課根拠().createHokenryoDankaiMap();
        Map<String, String> rankMap = input.get年額賦課根拠().createRankMap();

        for (String tsuki : hokenryoDankaiMap.keySet()) {
            if (KikannaiShikakuUmu(input, tsuki)) {
                DankaiShukei(hokenryoDankaiMap.get(tsuki).getSystemDankai(), rankMap.get(tsuki));
            }
        }

        // ①-2 年額保険料算出
        Decimal hokenryoNengaku;
        hokenryoNengaku = NengakuKeisan(input);

        // ②端数処理
        端数調整Factory 端数調整factory = new 端数調整Factory();
        I端数調整 端数調整 = 端数調整factory.getIncetance(input);
        hokenryoNengaku = 端数調整.Calc端数(hokenryoNengaku);

        // ③出力データ作成
        output = new 年額計算Output();
        output.setFukaNendo(input.get賦課年度());
        output.setHokenryoNengaku(hokenryoNengaku);

        return output;
    }

    private boolean KikannaiShikakuUmu(保険料段階判定input input, String taishotsuki) {

        boolean result = false;
        Calendar taishoYMD = Calendar.getInstance();
        Calendar shutokuYMD = Calendar.getInstance();
        Calendar soshitsuYMD = Calendar.getInstance();

        if (Integer.parseInt(taishotsuki) > 3) {
            taishoYMD.set(Integer.parseInt(input.get賦課年度()), Integer.parseInt(taishotsuki), 1);
        } else {
            taishoYMD.set(Integer.parseInt(input.get賦課年度()) + 1, Integer.parseInt(taishotsuki), 1);
        }

        //shutokuYMD.setTime(input.get年額賦課根拠().get資格取得日());
        shutokuYMD.set(input.get年額賦課根拠().get資格取得日().getYearValue(),input.get年額賦課根拠().get資格取得日().getMonthValue(),1);
        //shutokuYMD.add(Calendar.MONTH, 1);

        if (input.get年額賦課根拠().get資格喪失日() != null) {
            //soshitsuYMD.setTime(input.get年額賦課根拠().get資格喪失日());
            soshitsuYMD.set(input.get年額賦課根拠().get資格喪失日().getYearValue(),input.get年額賦課根拠().get資格喪失日().getMonthValue(),1);
            if (shutokuYMD.compareTo(taishoYMD) <= 0
                    && taishoYMD.compareTo(soshitsuYMD) < 0) {
                result = true;
            }
        } else {
            if (shutokuYMD.compareTo(taishoYMD) <= 0) {
                result = true;
            }

        }
        return result;
    }

    private void DankaiShukei(String hokenryoDankai, String rank) {

        NengakuHokenryoHoji nengakuhokenryohoji;
        int idx;

        boolean umuHantei = false;
        for (idx = 0; idx < nengakuHokenryoHojiList.size(); idx++) {
            if (nengakuHokenryoHojiList.get(idx).getDankai().equals(hokenryoDankai)) {
                if (nengakuHokenryoHojiList.get(idx).getRank() == null) {
                    if (rank == null) {
                        umuHantei = true;
                        break;
                    }
                } else {
                    if (nengakuHokenryoHojiList.get(idx).getRank().equals(rank)) {
                        umuHantei = true;
                        break;
                    }
                }

            }
        }

        if (umuHantei) {
            nengakuHokenryoHojiList.get(idx).setKosuu(nengakuHokenryoHojiList.get(idx).getKosuu() + 1);

        } else {
            nengakuhokenryohoji = new NengakuHokenryoHoji();
            nengakuhokenryohoji.setDankai(hokenryoDankai);
            nengakuhokenryohoji.setRank(rank);
            nengakuhokenryohoji.setKosuu(1);
            nengakuHokenryoHojiList.add(nengakuhokenryohoji);
        }

    }

    private Decimal NengakuKeisan(保険料段階判定input input) {

        Decimal result = new Decimal(0);
        Decimal kosuu;
        Decimal nentsukisu = new Decimal(12);
        Decimal wariai;

        for (NengakuHokenryoHoji nengakuHokenryoHoji : nengakuHokenryoHojiList) {
            kosuu = new Decimal(nengakuHokenryoHoji.getKosuu());
            wariai = kosuu.divide(nentsukisu);
            result = result.add(KijunNengakuShutoku(input.get年額制御情報(), nengakuHokenryoHoji).multiply(wariai));

        }
        return result;
    }

    private Decimal KijunNengakuShutoku(NengakuSeigyoJoho seigyoJoho, NengakuHokenryoHoji nengakuHokenryoHoji) {

        String rank;
        if (nengakuHokenryoHoji.getRank() == null || nengakuHokenryoHoji.getRank().isEmpty()) {
            rank = "1";
        } else {
            rank = nengakuHokenryoHoji.getRank();
        }

        Rank別基準金額 rankbetsuSeigyoJoho = seigyoJoho.getランク別制御情報().get(rank);
        Decimal result;

        switch (nengakuHokenryoHoji.getDankai()) {
            case "1":
                result = rankbetsuSeigyoJoho.getランク基準金額1();
                break;
            case "2":
                result = rankbetsuSeigyoJoho.getランク基準金額2();
                break;
            case "3":
                result = rankbetsuSeigyoJoho.getランク基準金額3();
                break;
            case "4":
                result = rankbetsuSeigyoJoho.getランク基準金額4();
                break;
            case "5":
                result = rankbetsuSeigyoJoho.getランク基準金額5();
                break;
            case "6":
                result = rankbetsuSeigyoJoho.getランク基準金額6();
                break;
            case "7":
                result = rankbetsuSeigyoJoho.getランク基準金額7();
                break;
            case "8":
                result = rankbetsuSeigyoJoho.getランク基準金額8();
                break;
            case "9":
                result = rankbetsuSeigyoJoho.getランク基準金額9();
                break;
            case "10":
                result = rankbetsuSeigyoJoho.getランク基準金額10();
                break;
            case "11":
                result = rankbetsuSeigyoJoho.getランク基準金額11();
                break;
            case "12":
                result = rankbetsuSeigyoJoho.getランク基準金額12();
                break;
            case "13":
                result = rankbetsuSeigyoJoho.getランク基準金額13();
                break;
            case "14":
                result = rankbetsuSeigyoJoho.getランク基準金額14();
                break;
            case "15":
                result = rankbetsuSeigyoJoho.getランク基準金額15();
                break;
            case "16":
                result = rankbetsuSeigyoJoho.getランク基準金額16();
                break;
            case "17":
                result = rankbetsuSeigyoJoho.getランク基準金額17();
                break;
            case "18":
                result = rankbetsuSeigyoJoho.getランク基準金額18();
                break;
            case "19":
                result = rankbetsuSeigyoJoho.getランク基準金額19();
                break;
            case "20":
                result = rankbetsuSeigyoJoho.getランク基準金額20();
                break;
            default:
                result = new Decimal(0);
        }
        return result;
    }

}
