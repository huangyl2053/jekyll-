/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd104010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.JukyushaGenmenJissijokyo.NinteijokyohyoKijyunbiKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010.DBD104010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijkouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijyotaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteiyotaiTwoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushagemmenjisshijokyo.JukyushaGemmenJisshiJokyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.IJushoNyuryokuConfig;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者減免実施状況のDataManagerクラスです。
 *
 * @reamsid_L　DBD-3770-060 liuwei2
 */
public class JukyushagenmenninteiDateManager {

    private final RString タイトル1_0 = new RString("標準負担");
    private final RString タイトル1_1 = new RString("　承認件数　　　　　(旧措置)");
    private final RString タイトル1_2 = new RString("　金額 500円　　　　　(旧措置)");
    private final RString タイトル1_3 = new RString("　金額 300円　　　　　(旧措置)");
    private final RString タイトル1_4 = new RString("　金額 その他　　　　(旧措置)");
    private final RString タイトル1_5 = RString.EMPTY;

    private final RString タイトル2_0 = new RString("利用者負担");
    private final RString タイトル2_1 = new RString("　承認件数　　　　　(旧措置)");
    private final RString タイトル2_2 = new RString("　給付率 91～95%　　(旧措置)");
    private final RString タイトル2_3 = new RString("　給付率 96～99%　　(旧措置)");
    private final RString タイトル2_4 = new RString("　給付率 100% 　　　(旧措置)");
    private final RString タイトル2_5 = RString.EMPTY;

    private final RString タイトル3_0 = new RString("特別対策");
    private final RString タイトル3_1 = new RString(" 施行時ホームヘルプ");
    private final RString タイトル3_2 = new RString("　承認件数　　　　　(旧措置)");
    private final RString タイトル3_3 = new RString("　給付率 90～95%　　(旧措置)");
    private final RString タイトル3_4 = new RString("　給付率 96～99%　　(旧措置)");
    private final RString タイトル3_5 = new RString("　給付率 100% 　　　(旧措置)");
    private final RString タイトル3_6 = new RString(" 障害ホームヘルプ");
    private final RString タイトル3_7 = new RString("　承認件数　　　　　(旧措置)");
    private final RString タイトル3_8 = new RString("　給付率 90～95%　　(旧措置)");
    private final RString タイトル3_9 = new RString("　給付率 96～99%　　(旧措置)");
    private final RString タイトル3_10 = new RString("　給付率 100% 　　　(旧措置)");
    private final RString タイトル3_11 = RString.EMPTY;

    private final RString タイトル4_0 = new RString("社会福祉法人");
    private final RString タイトル4_1 = new RString("　承認件数　　　　　(旧措置)");
    private final RString タイトル4_2 = new RString("　軽減率 12.5/100 　(旧措置)");
    private final RString タイトル4_3 = new RString("　軽減率　 25/100 　(旧措置)");
    private final RString タイトル4_4 = new RString("　軽減率　 50/100 　(旧措置)");
    private final RString タイトル4_5 = new RString("　軽減率　その他　　(旧措置)");
    private final RString タイトル4_6 = RString.EMPTY;

    private final RString タイトル5_0 = new RString("特定入所者");
    private final RString タイトル5_1 = new RString("　承認件数　　　　　(旧措置)");
    private final RString タイトル5_2 = new RString("　負担第４段階　　　(旧措置)");
    private final RString タイトル5_3 = new RString("　負担課税層第３段階(旧措置)");
    private final RString タイトル5_4 = new RString("　負担第３段階　　　(旧措置)");
    private final RString タイトル5_5 = new RString("　負担第２段階　　　(旧措置)");
    private final RString タイトル5_6 = new RString("　負担第１段階　　　(旧措置)");
    private final RString タイトル5_7 = RString.EMPTY;
    private final RString タイトル5_8 = RString.EMPTY;
    private final RString タイトル5_9 = RString.EMPTY;
    private final RString タイトル5_10 = RString.EMPTY;
    private final RString タイトル5_11 = RString.EMPTY;

    private final RString タイトル6_0 = new RString("特別地域加算");
    private final RString タイトル6_1 = new RString("　承認件数　　　　　(旧措置)");
    private final RString タイトル6_2 = new RString("　減額率 10/100 　　(旧措置)");
    private final RString タイトル6_3 = new RString("　減額率　その他　　(旧措置)");
    private final RString タイトル6_4 = RString.EMPTY;
    private final RString タイトル6_5 = RString.EMPTY;
    private final Decimal 標準負担額減免 = new Decimal(1);
    private final Decimal 利用者負担額減額 = new Decimal(2);
    private final Decimal 訪問介護利用者負担額減額 = new Decimal(3);
    private final Decimal 社会福祉法人減免 = new Decimal(4);
    private final Decimal 介護保険負担限度額認定 = new Decimal(5);
    private final Decimal 特別地域加算減免 = new Decimal(6);
    private static final Decimal ZERO = new Decimal(0);
    private static final Decimal ONE = new Decimal(1);
    private static final Decimal TWO = new Decimal(2);
    private static final Decimal THREE = new Decimal(3);
    private static final Decimal FOUR = new Decimal(4);
    private static final Decimal FIVE = new Decimal(5);
    private static final Decimal SIX = new Decimal(6);
    private static final Decimal SEVEN = new Decimal(7);
    private static final Decimal EIGHT = new Decimal(8);
    private static final Decimal NINE = new Decimal(9);
    private static final Decimal TEN = new Decimal(10);
    private static final Decimal ELEVEN = new Decimal(11);
    private static final int ZERO1 = 0;
    private static final int ONE1 = 1;
    private static final int TWO1 = 2;
    private static final int THREE1 = 3;
    private static final int FOUR1 = 4;
    private static final int FIVE1 = 5;
    private static final int SIX1 = 6;
    private static final int SEVEN1 = 7;
    private static final int EIGHT1 = 8;
    private static final int NINE1 = 9;
    private static final int TEN1 = 10;
    private static final int ELEVEN1 = 11;

    private static final RString すべて = new RString("すべて");
    private static final RString 区分_基準日 = NinteijokyohyoKijyunbiKubun.基準日.getコード();
    private static final RString 区分_基準年月 = NinteijokyohyoKijyunbiKubun.基準年月.getコード();
    private static final RString 年齢層抽出方法_年齢 = NenreiSoChushutsuHoho.年齢範囲.getコード();
    private static final RString 年齢層抽出方法_生年月日 = NenreiSoChushutsuHoho.生年月日範囲.getコード();

    private static final RString タイトルのみ印字 = new RString("タイトルのみ印字");

    /**
     * コンストラクタです。
     */
    public JukyushagenmenninteiDateManager() {
    }

    /**
     * NinteijyotaiEntityを設定します。
     *
     * @param 月の件数 List<NinteiyotaiTwoEntity>
     * @return NinteijyotaiEntity
     */
    public NinteijyotaiEntity setNinteijyotaiEntity(List<NinteiyotaiTwoEntity> 月の件数) {
        NinteijyotaiEntity entity = new NinteijyotaiEntity();
        entity.setTableFlag(月の件数.get(0).getTableFlag());
        entity.setFlag(月の件数.get(0).getFlag());

        entity.setShichigatukensu(月の件数.get(ZERO1).getKensu());
        entity.setGogatukensu(月の件数.get(ONE1).getKensu());
        entity.setLokugatukensu(月の件数.get(TWO1).getKensu());
        entity.setShichigatukensu(月の件数.get(THREE1).getKensu());
        entity.setHachigatukensu(月の件数.get(FOUR1).getKensu());
        entity.setKugatukensu(月の件数.get(FIVE1).getKensu());
        entity.setJyugatukensu(月の件数.get(SIX1).getKensu());
        entity.setJyuichigatukensu(月の件数.get(SEVEN1).getKensu());
        entity.setJyunigatukensu(月の件数.get(EIGHT1).getKensu());
        entity.setIchigatukensu(月の件数.get(NINE1).getKensu());
        entity.setNigatukensu(月の件数.get(TEN1).getKensu());
        entity.setSangatukensu(月の件数.get(ELEVEN1).getKensu());

        entity.setShichigatusotishakensu(月の件数.get(ZERO1).getSotishakensu());
        entity.setGogatusotishakensu(月の件数.get(ONE1).getSotishakensu());
        entity.setLokugatusotishakensu(月の件数.get(TWO1).getSotishakensu());
        entity.setShichigatusotishakensu(月の件数.get(THREE1).getSotishakensu());
        entity.setHachigatusotishakensu(月の件数.get(FOUR1).getSotishakensu());
        entity.setKugatusotishakensu(月の件数.get(FIVE1).getSotishakensu());
        entity.setJyugatusotishakensu(月の件数.get(SIX1).getSotishakensu());
        entity.setJyuichigatusotishakensu(月の件数.get(SEVEN1).getSotishakensu());
        entity.setJyunigatusotishakensu(月の件数.get(EIGHT1).getSotishakensu());
        entity.setIchigatusotishakensu(月の件数.get(NINE1).getSotishakensu());
        entity.setNigatusotishakensu(月の件数.get(TEN1).getSotishakensu());
        entity.setSangatusotishakensu(月の件数.get(ELEVEN1).getSotishakensu());

        return entity;
    }

    /**
     * NinteijyotaiEntityを設定します。
     *
     * @param flag Decimal
     * @param tableflag Decimal
     * @return NinteiyotaiTwoEntity
     */
    public NinteiyotaiTwoEntity getNinteiyotai月の件数(Decimal flag, Decimal tableflag) {
        NinteiyotaiTwoEntity entity = new NinteiyotaiTwoEntity();
        entity.setTableFlag(tableflag);
        entity.setFlag(flag);
        entity.setKensu(ZERO);
        return entity;
    }

    /**
     * 受給者減免月別申請認定状況表の中間テーブルを設定します。
     *
     * @param entity NinteijyotaiEntity
     * @param num Decimal
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @return NinteijkouTempTableEntity
     */
    public NinteijkouTempTableEntity set受給者減免月別認定者数状況表中間テーブル(NinteijyotaiEntity entity, Decimal num, LasdecCode 市町村コード, RString 市町村名称) {
        NinteijkouTempTableEntity newEntity = new NinteijkouTempTableEntity();
        newEntity.setTitle(setタイトル(entity.getTableFlag(), num));
        if (ONE.equals(entity.getTableFlag()) || TWO.equals(entity.getTableFlag())) {
            if (FIVE.equals(num) || ONE.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (TWO.equals(entity.getTableFlag())) {
            if (ONE.equals(num) || FIVE.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (THREE.equals(entity.getTableFlag())) {
            if (ONE.equals(num) || ZERO.equals(num) || SIX.equals(num) || ELEVEN.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else {
            newEntity.setInnjiKubun(set受給者タイトルのみ印字(num, entity.getTableFlag()));
        }

        newEntity.setIchigatukensu(entity.getIchigatukensu());
        newEntity.setNigatukensu(entity.getNigatukensu());
        newEntity.setSangatukensu(entity.getSangatukensu());
        newEntity.setSigatukensu(entity.getSigatukensu());
        newEntity.setGogatukensu(entity.getGogatukensu());
        newEntity.setLokugatukensu(entity.getLokugatukensu());
        newEntity.setShichigatukensu(entity.getShichigatukensu());
        newEntity.setHachigatukensu(entity.getHachigatukensu());
        newEntity.setKugatukensu(entity.getKugatukensu());
        newEntity.setJyugatukensu(entity.getJyugatukensu());
        newEntity.setJyuichigatukensu(entity.getJyuichigatukensu());
        newEntity.setJyunigatukensu(entity.getJyunigatukensu());

        newEntity.setShichigatusotishakensu(entity.getIchigatusotishakensu());
        newEntity.setGogatusotishakensu(entity.getGogatusotishakensu());
        newEntity.setLokugatusotishakensu(entity.getLokugatusotishakensu());
        newEntity.setShichigatusotishakensu(entity.getShichigatusotishakensu());
        newEntity.setHachigatusotishakensu(entity.getHachigatusotishakensu());
        newEntity.setKugatusotishakensu(entity.getKugatusotishakensu());
        newEntity.setJyugatusotishakensu(entity.getJyugatusotishakensu());
        newEntity.setJyuichigatusotishakensu(entity.getJyuichigatusotishakensu());
        newEntity.setJyunigatusotishakensu(entity.getJyunigatusotishakensu());
        newEntity.setIchigatusotishakensu(entity.getIchigatusotishakensu());
        newEntity.setNigatusotishakensu(entity.getNigatusotishakensu());
        newEntity.setSangatusotishakensu(entity.getSangatusotishakensu());

        Decimal sum = entity.getIchigatukensu().add(entity.getNigatukensu()).add(entity.getSangatukensu())
                .add(entity.getSigatukensu()).add(entity.getGogatukensu()).add(entity.getLokugatukensu()).add(entity.getShichigatukensu())
                .add(entity.getHachigatukensu()).add(entity.getKugatukensu()).add(entity.getJyugatukensu()).add(entity.getJyuichigatukensu())
                .add(entity.getJyuichigatukensu());
        Decimal sotishasum = entity.getIchigatusotishakensu().add(entity.getNigatusotishakensu()).add(entity.getSangatusotishakensu())
                .add(entity.getSigatusotishakensu()).add(entity.getGogatusotishakensu()).add(entity.getLokugatusotishakensu())
                .add(entity.getShichigatusotishakensu())
                .add(entity.getHachigatusotishakensu()).add(entity.getKugatusotishakensu()).add(entity.getJyugatusotishakensu())
                .add(entity.getJyuichigatusotishakensu())
                .add(entity.getJyuichigatusotishakensu());
        newEntity.setGoukeikensu(sum);
        newEntity.setGoukeisotishakensu(sotishasum);
        return newEntity;
    }

    /**
     * 空の中間テーブルを設定します。
     *
     * @param tableFlag Decimal
     * @param num Decimal
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @return NinteijkouTempTableEntity
     */
    public NinteijkouTempTableEntity add受給者減免月別認定者数状況表中間テーブルEmpty(Decimal tableFlag, Decimal num, LasdecCode 市町村コード, RString 市町村名称) {
        NinteijkouTempTableEntity newEntity = new NinteijkouTempTableEntity();
        newEntity.setTitle(setタイトル(tableFlag, num));

        if (ONE.equals(tableFlag) || TWO.equals(tableFlag)) {
            if (FIVE.equals(num) || ONE.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (TWO.equals(tableFlag)) {
            if (ONE.equals(num) || FIVE.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (THREE.equals(tableFlag)) {
            if (ONE.equals(num) || ZERO.equals(num) || SIX.equals(num) || ELEVEN.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else {
            newEntity.setInnjiKubun(set受給者タイトルのみ印字(num, tableFlag));
        }
        newEntity.setIchigatukensu(Decimal.ZERO);
        newEntity.setNigatukensu(Decimal.ZERO);
        newEntity.setSangatukensu(Decimal.ZERO);
        newEntity.setSigatukensu(Decimal.ZERO);
        newEntity.setGogatukensu(Decimal.ZERO);
        newEntity.setLokugatukensu(Decimal.ZERO);
        newEntity.setShichigatukensu(Decimal.ZERO);
        newEntity.setHachigatukensu(Decimal.ZERO);
        newEntity.setKugatukensu(Decimal.ZERO);
        newEntity.setJyugatukensu(Decimal.ZERO);
        newEntity.setJyuichigatukensu(Decimal.ZERO);
        newEntity.setJyunigatukensu(Decimal.ZERO);
        newEntity.setGoukeikensu(Decimal.ZERO);

        newEntity.setIchigatusotishakensu(Decimal.ZERO);
        newEntity.setNigatusotishakensu(Decimal.ZERO);
        newEntity.setSangatusotishakensu(Decimal.ZERO);
        newEntity.setSigatusotishakensu(Decimal.ZERO);
        newEntity.setGogatusotishakensu(Decimal.ZERO);
        newEntity.setLokugatusotishakensu(Decimal.ZERO);
        newEntity.setShichigatusotishakensu(Decimal.ZERO);
        newEntity.setHachigatusotishakensu(Decimal.ZERO);
        newEntity.setKugatusotishakensu(Decimal.ZERO);
        newEntity.setJyugatusotishakensu(Decimal.ZERO);
        newEntity.setJyuichigatusotishakensu(Decimal.ZERO);
        newEntity.setJyunigatusotishakensu(Decimal.ZERO);
        newEntity.setGoukeisotishakensu(Decimal.ZERO);

        return newEntity;
    }

    /**
     * 受給者減免月別認定者数帳票出力データを設定します。
     *
     * @param t NinteijkouTempTableEntity
     * @return JukyushaGemmenJisshiJokyoEntity
     */
    public JukyushaGemmenJisshiJokyoEntity set受給者減免月別認定者数帳票出力(NinteijkouTempTableEntity t) {
        JukyushaGemmenJisshiJokyoEntity データリスト = new JukyushaGemmenJisshiJokyoEntity();
        データリスト.setタイトル(t.getTitle());
        RString yue1 = new RString(t.getIchigatukensu().longValue());
        RString yue2 = new RString(t.getIchigatukensu().longValue());
        RString yue3 = new RString(t.getIchigatukensu().longValue());
        RString yue4 = new RString(t.getIchigatukensu().longValue());
        RString yue5 = new RString(t.getIchigatukensu().longValue());
        RString yue6 = new RString(t.getIchigatukensu().longValue());
        RString yue7 = new RString(t.getIchigatukensu().longValue());
        RString yue8 = new RString(t.getIchigatukensu().longValue());
        RString yue9 = new RString(t.getIchigatukensu().longValue());
        RString yue10 = new RString(t.getIchigatukensu().longValue());
        RString yue11 = new RString(t.getIchigatukensu().longValue());
        RString yue12 = new RString(t.getIchigatukensu().longValue());
        RString yue合計 = new RString(t.getGoukeikensu().longValue());
        データリスト.set一月(yue1.concat("(").concat(new RString(t.getIchigatusotishakensu().longValue())).concat(")"));
        データリスト.set二月(yue2.concat("(").concat(new RString(t.getNigatusotishakensu().longValue())).concat(")"));
        データリスト.set三月(yue3.concat("(").concat(new RString(t.getSangatusotishakensu().longValue())).concat(")"));
        データリスト.set四月(yue4.concat("(").concat(new RString(t.getSigatusotishakensu().longValue())).concat(")"));
        データリスト.set五月(yue5.concat("(").concat(new RString(t.getGogatusotishakensu().longValue())).concat(")"));
        データリスト.set六月(yue6.concat("(").concat(new RString(t.getLokugatusotishakensu().longValue())).concat(")"));
        データリスト.set七月(yue7.concat("(").concat(new RString(t.getShichigatusotishakensu().longValue())).concat(")"));
        データリスト.set八月(yue8.concat("(").concat(new RString(t.getHachigatusotishakensu().longValue())).concat(")"));
        データリスト.set九月(yue9.concat("(").concat(new RString(t.getKugatusotishakensu().longValue())).concat(")"));
        データリスト.set十月(yue10.concat("(").concat(new RString(t.getJyugatusotishakensu().longValue())).concat(")"));
        データリスト.set十一月(yue11.concat("(").concat(new RString(t.getJyuichigatusotishakensu().longValue())).concat(")"));
        データリスト.set十二月(yue12.concat("(").concat(new RString(t.getJyunigatusotishakensu().longValue())).concat(")"));
        データリスト.set合計(yue合計.concat("(").concat(new RString(t.getGoukeisotishakensu().longValue())).concat(")"));
        return データリスト;
    }

    /**
     * 受給者減免月別申請認定状況帳票出力データを設定します。
     *
     * @param t NinteijkouTempTableEntity
     * @return JukyushaGemmenJisshiJokyoEntity
     */
    public JukyushaGemmenJisshiJokyoEntity set受給者減免月別認定者数帳票出力_タイトルのみ印字(NinteijkouTempTableEntity t) {
        JukyushaGemmenJisshiJokyoEntity データリスト = new JukyushaGemmenJisshiJokyoEntity();

        データリスト.setタイトル(t.getTitle());
        データリスト.set一月(RString.EMPTY);
        データリスト.set二月(RString.EMPTY);
        データリスト.set三月(RString.EMPTY);
        データリスト.set四月(RString.EMPTY);
        データリスト.set五月(RString.EMPTY);
        データリスト.set六月(RString.EMPTY);
        データリスト.set七月(RString.EMPTY);
        データリスト.set八月(RString.EMPTY);
        データリスト.set九月(RString.EMPTY);
        データリスト.set十月(RString.EMPTY);
        データリスト.set十一月(RString.EMPTY);
        データリスト.set十二月(RString.EMPTY);
        データリスト.set合計(RString.EMPTY);
        return データリスト;
    }

    /**
     * 出力条件を設定します。
     *
     * @param processParameter DBD104010ProcessParameter
     * @param 市町村名 RString
     * @return 出力条件 List<RString>
     */
    public List<RString> set出力条件(DBD104010ProcessParameter processParameter, RString 市町村名) {
        List<RString> 出力条件 = new ArrayList<>();

        if (!processParameter.get宛名抽出条件().getShichoson_Code().isEmpty() && !すべて.equals(processParameter.get宛名抽出条件().getShichoson_Code().value())) {
            出力条件.add(new RString("市町村：").concat(市町村名));
        }
        if (区分_基準日.equals(processParameter.get基準日区分())) {
            出力条件.add(new RString("基準日：").concat(processParameter.get基準日()).concat(new RString("日")));
        }
        if (区分_基準年月.equals(processParameter.get基準日区分())) {
            出力条件.add(new RString("基準日：月末日"));
        }
        set出力条件_年齢(processParameter, 出力条件);
        set出力条件_生年月日(processParameter, 出力条件);

        if (processParameter.get宛名抽出条件().getChiku_Kubun() != null && !すべて.equals(processParameter.get宛名抽出条件().getChiku_Kubun().getコード())) {
            set出力条件_町域行政区分(processParameter, 出力条件);

            IJushoNyuryokuConfig config = JushoNyuryokuConfigFactory.createInstance();

            if (!processParameter.get宛名抽出条件().getChiku1_From().isEmpty() && !processParameter.get宛名抽出条件().getChiku1_To().isEmpty()) {

                出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_From()).concat(new RString("）"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_FromMesho()).concat(new RString("　～　（"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_To()).concat(new RString("）"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_ToMesho()));
            }
            if (!processParameter.get宛名抽出条件().getChiku1_From().isEmpty() && processParameter.get宛名抽出条件().getChiku1_To().isEmpty()) {
                出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_From()).concat(new RString("）"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_FromMesho()).concat(new RString("　～　（"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_To()).concat(new RString("）"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_FromMesho()));
            }
            if (processParameter.get宛名抽出条件().getChiku1_From().isEmpty() && !processParameter.get宛名抽出条件().getChiku1_To().isEmpty()) {
                出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_From()).concat(new RString("）"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_ToMesho()).concat(new RString("　～　（"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_To()).concat(new RString("）"))
                        .concat(processParameter.get宛名抽出条件().getChiku1_ToMesho()));
            }
            set出力条件_地区2の分類(processParameter, 出力条件, config);
            set出力条件_地区3の分類(processParameter, 出力条件, config);
        }
        return 出力条件;
    }

    private void set出力条件_年齢(DBD104010ProcessParameter processParameter, List<RString> 出力条件) {
        if (年齢層抽出方法_年齢.equals(processParameter.get宛名抽出条件().getAgeSelectKijun().getコード())
                && processParameter.get宛名抽出条件().getNenreiKijunbi() != null) {
            if (processParameter.get宛名抽出条件().getNenreiRange().getFrom() != null
                    && processParameter.get宛名抽出条件().getNenreiRange().getTo() != null) {
                出力条件.add(new RString("年齢：").concat(new RString(processParameter.get宛名抽出条件().getNenreiRange().getFrom()
                        .longValue())).concat(new RString("歳　～　")).concat(new RString(processParameter.get宛名抽出条件().getNenreiRange().getTo()
                                        .longValue()).concat(new RString("歳"))).concat(new RString("　　（年齢基準日："))
                        .concat(processParameter.get宛名抽出条件().getNenreiKijunbi().toDateString()));
            } else if (processParameter.get宛名抽出条件().getNenreiRange().getFrom() != null
                    && processParameter.get宛名抽出条件().getNenreiRange().getTo() == null) {
                出力条件.add(new RString("年齢：").concat(new RString(processParameter.get宛名抽出条件().getNenreiRange().getFrom()
                        .longValue())).concat(new RString("歳　～　　（年齢基準日：")).concat(processParameter
                                .get宛名抽出条件().getNenreiKijunbi().toDateString()));
            } else if (processParameter.get宛名抽出条件().getNenreiRange().getFrom() == null
                    && processParameter.get宛名抽出条件().getNenreiRange().getTo() == null) {
                出力条件.add(new RString("年齢：～").concat(new RString(processParameter.get宛名抽出条件().getNenreiRange().getTo()
                        .longValue())).concat(new RString("歳　　（年齢基準日：")).concat(processParameter
                                .get宛名抽出条件().getNenreiKijunbi().toDateString()));
            }
        }
    }

    private void set出力条件_生年月日(DBD104010ProcessParameter processParameter, List<RString> 出力条件) {
        if (年齢層抽出方法_生年月日.equals(processParameter.get宛名抽出条件().getAgeSelectKijun().getコード())) {
            if (processParameter.get宛名抽出条件().getSeinengappiRange().getFrom() != null
                    && processParameter.get宛名抽出条件().getSeinengappiRange().getTo() != null) {
                出力条件.add(new RString("生年月日：").concat(processParameter.get宛名抽出条件().getSeinengappiRange().getFrom().toDateString())
                        .concat(new RString("　～　")).concat(processParameter.get宛名抽出条件().getSeinengappiRange().getTo().toDateString()));
            } else if (processParameter.get宛名抽出条件().getSeinengappiRange().getFrom() != null
                    && processParameter.get宛名抽出条件().getSeinengappiRange().getTo() == null) {
                出力条件.add(new RString("生年月日：").concat(processParameter.get宛名抽出条件().getSeinengappiRange().getFrom().toDateString())
                        .concat(new RString("　～　")));
            } else if (processParameter.get宛名抽出条件().getSeinengappiRange().getFrom() == null
                    && processParameter.get宛名抽出条件().getSeinengappiRange().getTo() == null) {
                出力条件.add(new RString("生年月日：　～　").concat(processParameter.get宛名抽出条件().getSeinengappiRange().getTo().toDateString()));
            }
        }
    }

    private void set出力条件_町域行政区分(DBD104010ProcessParameter processParameter, List<RString> 出力条件) {
        if (!processParameter.get宛名抽出条件().getJusho_From().isEmpty() && !processParameter.get宛名抽出条件().getJusho_To().isEmpty()) {
            出力条件.add(new RString("町域：（").concat(processParameter.get宛名抽出条件().getJusho_From())
                    .concat(new RString("）○○○　～　（")).concat(processParameter.get宛名抽出条件().getJusho_To())
                    .concat(new RString("）○○○")));
        }
        if (!processParameter.get宛名抽出条件().getJusho_From().isEmpty() && processParameter.get宛名抽出条件().getJusho_To().isEmpty()) {
            出力条件.add(new RString("町域：（").concat(processParameter.get宛名抽出条件().getJusho_From())
                    .concat(new RString("）○○○　～")));
        }
        if (processParameter.get宛名抽出条件().getJusho_From().isEmpty() && !processParameter.get宛名抽出条件().getJusho_To().isEmpty()) {
            出力条件.add(new RString("町域：～　（").concat(processParameter.get宛名抽出条件().getJusho_To())
                    .concat(new RString("）○○○")));
        }

        if (!processParameter.get宛名抽出条件().getGyoseiku_From().isEmpty() && !processParameter.get宛名抽出条件().getGyoseiku_To().isEmpty()) {
            出力条件.add(new RString("行政区：（").concat(processParameter.get宛名抽出条件().getGyoseiku_From())
                    .concat(new RString("）○○○　～　（")).concat(processParameter.get宛名抽出条件().getGyoseiku_To())
                    .concat(new RString("）○○○")));
        }
        if (!processParameter.get宛名抽出条件().getGyoseiku_From().isEmpty() && processParameter.get宛名抽出条件().getGyoseiku_To().isEmpty()) {
            出力条件.add(new RString("行政区：（").concat(processParameter.get宛名抽出条件().getGyoseiku_From())
                    .concat(new RString("）○○○　～")));
        }
        if (processParameter.get宛名抽出条件().getGyoseiku_From().isEmpty() && !processParameter.get宛名抽出条件().getGyoseiku_To().isEmpty()) {
            出力条件.add(new RString("行政区：～　（").concat(processParameter.get宛名抽出条件().getGyoseiku_To())
                    .concat(new RString("）○○○　～")));
        }

    }

    private void set出力条件_地区2の分類(DBD104010ProcessParameter processParameter, List<RString> 出力条件, IJushoNyuryokuConfig config) {
        if (!processParameter.get宛名抽出条件().getChiku2_From().isEmpty() && !processParameter.get宛名抽出条件().getChiku2_To().isEmpty()) {
            出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_From()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_FromMesho()).concat(new RString("　～　（"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_To()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_ToMesho()));
        }
        if (!processParameter.get宛名抽出条件().getChiku2_From().isEmpty() && processParameter.get宛名抽出条件().getChiku2_To().isEmpty()) {
            出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_From()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_FromMesho()).concat(new RString("　～　（"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_To()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_FromMesho()));
        }
        if (processParameter.get宛名抽出条件().getChiku2_From().isEmpty() && !processParameter.get宛名抽出条件().getChiku2_To().isEmpty()) {
            出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_From()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_ToMesho()).concat(new RString("　～　（"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_To()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku2_ToMesho()));
        }
    }

    private void set出力条件_地区3の分類(DBD104010ProcessParameter processParameter, List<RString> 出力条件, IJushoNyuryokuConfig config) {
        if (!processParameter.get宛名抽出条件().getChiku3_From().isEmpty() && !processParameter.get宛名抽出条件().getChiku3_To().isEmpty()) {
            出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_From()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_FromMesho()).concat(new RString("　～　（"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_To()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_ToMesho()));
        }
        if (!processParameter.get宛名抽出条件().getChiku3_From().isEmpty() && processParameter.get宛名抽出条件().getChiku3_To().isEmpty()) {
            出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_From()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_FromMesho()).concat(new RString("　～　（"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_To()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_FromMesho()));
        }
        if (processParameter.get宛名抽出条件().getChiku3_From().isEmpty() && !processParameter.get宛名抽出条件().getChiku3_To().isEmpty()) {
            出力条件.add(config.getコード名称(ConfigKeysCodeName.コード名称_地区の分類１).concat(new RString("：（"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_From()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_ToMesho()).concat(new RString("　～　（"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_To()).concat(new RString("）"))
                    .concat(processParameter.get宛名抽出条件().getChiku3_ToMesho()));
        }
    }

    private RString set受給者タイトルのみ印字(Decimal num, Decimal tableflag) {
        if (FOUR.equals(tableflag)) {
            if (ZERO.equals(num)) {
                return タイトルのみ印字;
            }
        } else if (FIVE.equals(tableflag)) {
            if (ZERO.equals(num) || SEVEN.equals(num) || EIGHT.equals(num) || NINE.equals(num) || TEN.equals(num) || ELEVEN.equals(num)) {
                return タイトルのみ印字;
            }
        } else if (SIX.equals(tableflag)) {
            if (FIVE.equals(num) || ZERO.equals(num) || FOUR.equals(num)) {
                return タイトルのみ印字;
            }
        }
        return RString.EMPTY;
    }

    private RString setタイトル(Decimal tableFlag, Decimal num) {
        RString title = RString.EMPTY;
        if (標準負担額減免.equals(tableFlag)) {
            title = setタイトル1(num);
            if (!title.isEmpty()) {
                return title;
            }
        }
        if (利用者負担額減額.equals(tableFlag)) {
            title = setタイトル2(num);
            if (title != null) {
                return title;
            }
        }
        if (訪問介護利用者負担額減額.equals(tableFlag)) {
            title = setタイトル3(num);
            if (title != null) {
                return title;
            }
        }
        if (社会福祉法人減免.equals(tableFlag)) {
            title = setタイトル4(num);
            if (title != null) {
                return title;
            }
        }
        if (介護保険負担限度額認定.equals(tableFlag)) {
            title = setタイトル5(num);
            if (title != null) {
                return title;
            }
        }
        if (特別地域加算減免.equals(tableFlag)) {
            title = setタイトル6(num);
            if (title != null) {
                return title;
            }
        }
        return title;
    }

    private RString setタイトル1(Decimal num) {
        if (ZERO.equals(num)) {
            return タイトル1_0;
        }
        if (ONE.equals(num)) {
            return タイトル1_1;
        }
        if (TWO.equals(num)) {
            return タイトル1_2;
        }
        if (THREE.equals(num)) {
            return タイトル1_3;
        }
        if (FOUR.equals(num)) {
            return タイトル1_4;
        }
        if (FIVE.equals(num)) {
            return タイトル1_5;
        }
        return RString.EMPTY;
    }

    private RString setタイトル2(Decimal num) {
        if (ZERO.equals(num)) {
            return タイトル2_0;
        }
        if (ONE.equals(num)) {
            return タイトル2_1;
        }
        if (TWO.equals(num)) {
            return タイトル2_2;
        }
        if (THREE.equals(num)) {
            return タイトル2_3;
        }
        if (FOUR.equals(num)) {
            return タイトル2_4;
        }
        if (FIVE.equals(num)) {
            return タイトル2_5;
        }
        return RString.EMPTY;
    }

    private RString setタイトル3(Decimal num) {
        if (ZERO.equals(num)) {
            return タイトル3_0;
        }
        if (ONE.equals(num)) {
            return タイトル3_1;
        }
        if (TWO.equals(num)) {
            return タイトル3_2;
        }
        if (THREE.equals(num)) {
            return タイトル3_3;
        }
        if (FOUR.equals(num)) {
            return タイトル3_4;
        }
        if (FIVE.equals(num)) {
            return タイトル3_5;
        }
        if (SIX.equals(num)) {
            return タイトル3_6;
        }
        if (SEVEN.equals(num)) {
            return タイトル3_7;
        }
        if (EIGHT.equals(num)) {
            return タイトル3_8;
        }
        if (NINE.equals(num)) {
            return タイトル3_9;
        }
        if (TEN.equals(num)) {
            return タイトル3_10;
        }
        if (ELEVEN.equals(num)) {
            return タイトル3_11;
        }
        return RString.EMPTY;
    }

    private RString setタイトル4(Decimal num) {
        if (ZERO.equals(num)) {
            return タイトル4_0;
        }
        if (ONE.equals(num)) {
            return タイトル4_1;
        }
        if (TWO.equals(num)) {
            return タイトル4_2;
        }
        if (THREE.equals(num)) {
            return タイトル4_3;
        }
        if (FOUR.equals(num)) {
            return タイトル4_4;
        }
        if (FIVE.equals(num)) {
            return タイトル4_5;
        }
        if (SIX.equals(num)) {
            return タイトル4_6;
        }
        return RString.EMPTY;
    }

    private RString setタイトル5(Decimal num) {
        if (ZERO.equals(num)) {
            return タイトル5_0;
        }
        if (ONE.equals(num)) {
            return タイトル5_1;
        }
        if (TWO.equals(num)) {
            return タイトル5_2;
        }
        if (THREE.equals(num)) {
            return タイトル5_3;
        }
        if (FOUR.equals(num)) {
            return タイトル5_4;
        }
        if (FIVE.equals(num)) {
            return タイトル5_5;
        }
        if (SIX.equals(num)) {
            return タイトル5_6;
        }
        if (SEVEN.equals(num)) {
            return タイトル5_7;
        }
        if (EIGHT.equals(num)) {
            return タイトル5_8;
        }
        if (NINE.equals(num)) {
            return タイトル5_9;
        }
        if (TEN.equals(num)) {
            return タイトル5_10;
        }
        if (ELEVEN.equals(num)) {
            return タイトル5_11;
        }
        return RString.EMPTY;
    }

    private RString setタイトル6(Decimal num) {
        if (ZERO.equals(num)) {
            return タイトル6_0;
        }
        if (ONE.equals(num)) {
            return タイトル6_1;
        }
        if (TWO.equals(num)) {
            return タイトル6_2;
        }
        if (THREE.equals(num)) {
            return タイトル6_3;
        }
        if (FOUR.equals(num)) {
            return タイトル6_4;
        }
        if (FIVE.equals(num)) {
            return タイトル6_5;
        }

        return RString.EMPTY;
    }

}
