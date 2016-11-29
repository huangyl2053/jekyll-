/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei.HasuChoseiFactory;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei.IHasuChosei;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.RankBetsuKijunKingaku;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 年額計算
 *
 * @author N2810
 */
public class NengakuHokenryoKeisan {

    private final List<NengaokuHokenryoHoji> nengakuHokenryoHojiList;
    private static final int TAISHOTSUKI = 3;
    private static final Decimal NENTSUKISU = new Decimal(12);

    /**
     * コンストラクタ
     */
    public NengakuHokenryoKeisan() {
        nengakuHokenryoHojiList = new ArrayList<>();
    }

    /**
     * 年額計算
     *
     * @param nengakuHokenryoKeisanParameter 保険料段階判定パラメータ
     * @return NengakuHokenryo
     */
    public NengakuHokenryo calculate年額保険料(NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter) {

        NengakuHokenryo nengakuHokenryo;

        // ①年額計算
        // ①-1 集計
        //List<NengakuHokenryoHoji> nengakuhokenryohoji = new ArrayList<>();
        //NengakuHokenryoHoji nengakuhokenryohoji = new NengaokuHokenryoHoji();
        Map<RString, RString> hokenryoDankaiMap = nengakuHokenryoKeisanParameter.get年額賦課根拠().get月別保険料段階().createHokenryoDankaiMap();
        Map<RString, RString> rankMap = nengakuHokenryoKeisanParameter.get年額賦課根拠().createRankMap();
        Set<Map.Entry<RString, RString>> set = hokenryoDankaiMap.entrySet();
        Iterator<Map.Entry<RString, RString>> it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<RString, RString> entry = it.next();
            RString key = entry.getKey();
            if (kikannaiShikakuUmu(nengakuHokenryoKeisanParameter, key)) {
                dankaiShukei(hokenryoDankaiMap.get(key), rankMap.get(key));
            }
        }

        // ①-2 年額保険料算出
        Decimal hokenryoNengaku;
        hokenryoNengaku = nengakuKeisan(nengakuHokenryoKeisanParameter);

        // ②端数処理
        HasuChoseiFactory 端数調整factory = new HasuChoseiFactory();
        IHasuChosei 端数調整 = 端数調整factory.getIncetance(nengakuHokenryoKeisanParameter);
        hokenryoNengaku = 端数調整.calc端数(hokenryoNengaku);

        // ③出力データ作成
        nengakuHokenryo = new NengakuHokenryo();
        nengakuHokenryo.setFukaNendo(nengakuHokenryoKeisanParameter.get賦課年度());
        nengakuHokenryo.setHokenryoNengaku(hokenryoNengaku);

        return nengakuHokenryo;
    }

    private boolean kikannaiShikakuUmu(NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter, RString taishotsuki) {

        boolean result = false;
        Calendar taishoYMD = Calendar.getInstance();
        Calendar shutokuYMD = Calendar.getInstance();
        Calendar soshitsuYMD = Calendar.getInstance();

        if (Integer.parseInt(taishotsuki.toString()) > TAISHOTSUKI) {
            taishoYMD.set(Integer.parseInt(
                    String.valueOf(nengakuHokenryoKeisanParameter.get賦課年度())), Integer.parseInt(taishotsuki.toString()), 1);
        } else {
            taishoYMD.set(Integer.parseInt(String.valueOf(
                    nengakuHokenryoKeisanParameter.get賦課年度())) + 1, Integer.parseInt(taishotsuki.toString()), 1);
        }

        //shutokuYMD.setTime(input.get年額賦課根拠().get資格取得日());
        shutokuYMD.set(nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格取得日().getYearValue(),
                nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格取得日().getMonthValue(), 1);
        //shutokuYMD.add(Calendar.MONTH, 1);

        if (nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日() != null
                && !nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日().isEmpty()) {
            //soshitsuYMD.setTime(input.get年額賦課根拠().get資格喪失日());
            soshitsuYMD.set(nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日().getYearValue(),
                    nengakuHokenryoKeisanParameter.get年額賦課根拠().get資格喪失日().getMonthValue(), 1);
            if (shutokuYMD.compareTo(taishoYMD) <= 0
                    && taishoYMD.compareTo(soshitsuYMD) < 0) {
                result = true;
            }
        } else if (shutokuYMD.compareTo(taishoYMD) <= 0) {
            result = true;
        }
        return result;
    }

    private void dankaiShukei(RString hokenryoDankai, RString rank) {

        NengaokuHokenryoHoji nengakuhokenryohoji;
        int idx;

        boolean umuHantei = false;
        for (idx = 0; idx < nengakuHokenryoHojiList.size(); idx++) {
            if (nengakuHokenryoHojiList.get(idx).getDankai().equals(hokenryoDankai)) {
                if (nengakuHokenryoHojiList.get(idx).getRank() == null
                        && rank == null) {
                    umuHantei = true;
                    break;
                } else if (nengakuHokenryoHojiList.get(idx).getRank().equals(rank)) {
                    umuHantei = true;
                    break;
                }

            }
        }

        if (umuHantei) {
            nengakuHokenryoHojiList.get(idx).setKosuu(nengakuHokenryoHojiList.get(idx).getKosuu() + 1);

        } else {
            nengakuhokenryohoji = new NengaokuHokenryoHoji();
            nengakuhokenryohoji.setDankai(hokenryoDankai);
            nengakuhokenryohoji.setRank(rank);
            nengakuhokenryohoji.setKosuu(1);
            nengakuHokenryoHojiList.add(nengakuhokenryohoji);
        }

    }

    private Decimal nengakuKeisan(NengakuHokenryoKeisanParameter input) {

        Decimal result = new Decimal(0);
        Decimal kosuu;

        for (NengaokuHokenryoHoji nengakuHokenryoHoji : nengakuHokenryoHojiList) {
            kosuu = new Decimal(nengakuHokenryoHoji.getKosuu());
            result = result.add(kijunNengakuShutoku(input.get年額制御情報(), nengakuHokenryoHoji).divide(NENTSUKISU).multiply(kosuu));
        }
        return result;
    }

    private Decimal kijunNengakuShutoku(NengakuSeigyoJoho seigyoJoho, NengaokuHokenryoHoji nengakuHokenryoHoji) {

        RString rank;
        if (nengakuHokenryoHoji.getRank() == null || nengakuHokenryoHoji.getRank().isEmpty()) {
            rank = new RString("01");
        } else {
            rank = nengakuHokenryoHoji.getRank();
        }

        RankBetsuKijunKingaku rankbetsuSeigyoJoho = seigyoJoho.getランク別制御情報().get(rank);
        Decimal result = new Decimal(0);

        result = getResult1(result, nengakuHokenryoHoji, rankbetsuSeigyoJoho);
        result = getResult2(result, nengakuHokenryoHoji, rankbetsuSeigyoJoho);

        return result;
    }

    private Decimal getResult1(Decimal result, NengaokuHokenryoHoji nengakuHokenryoHoji, RankBetsuKijunKingaku rankbetsuSeigyoJoho) {

        switch (String.valueOf(nengakuHokenryoHoji.getDankai())) {
            case "01":
                result = rankbetsuSeigyoJoho.getランク基準金額1();
                break;
            case "02":
                result = rankbetsuSeigyoJoho.getランク基準金額2();
                break;
            case "03":
                result = rankbetsuSeigyoJoho.getランク基準金額3();
                break;
            case "04":
                result = rankbetsuSeigyoJoho.getランク基準金額4();
                break;
            case "05":
                result = rankbetsuSeigyoJoho.getランク基準金額5();
                break;
            case "06":
                result = rankbetsuSeigyoJoho.getランク基準金額6();
                break;
            case "07":
                result = rankbetsuSeigyoJoho.getランク基準金額7();
                break;
            case "08":
                result = rankbetsuSeigyoJoho.getランク基準金額8();
                break;
            case "09":
                result = rankbetsuSeigyoJoho.getランク基準金額9();
                break;
            case "10":
                result = rankbetsuSeigyoJoho.getランク基準金額10();
                break;
            default:
                result = new Decimal(0);
        }
        return result;
    }

    private Decimal getResult2(Decimal result, NengaokuHokenryoHoji nengakuHokenryoHoji, RankBetsuKijunKingaku rankbetsuSeigyoJoho) {
        Decimal newResult;
        switch (String.valueOf(nengakuHokenryoHoji.getDankai())) {
            case "11":
                newResult = rankbetsuSeigyoJoho.getランク基準金額11();
                break;
            case "12":
                newResult = rankbetsuSeigyoJoho.getランク基準金額12();
                break;
            case "13":
                newResult = rankbetsuSeigyoJoho.getランク基準金額13();
                break;
            case "14":
                newResult = rankbetsuSeigyoJoho.getランク基準金額14();
                break;
            case "15":
                newResult = rankbetsuSeigyoJoho.getランク基準金額15();
                break;
            case "16":
                newResult = rankbetsuSeigyoJoho.getランク基準金額16();
                break;
            case "17":
                newResult = rankbetsuSeigyoJoho.getランク基準金額17();
                break;
            case "18":
                newResult = rankbetsuSeigyoJoho.getランク基準金額18();
                break;
            case "19":
                newResult = rankbetsuSeigyoJoho.getランク基準金額19();
                break;
            case "20":
                newResult = rankbetsuSeigyoJoho.getランク基準金額20();
                break;
            default:
                newResult = result;
        }
        return newResult;
    }
}
