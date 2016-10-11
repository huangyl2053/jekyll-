/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd104010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010.DBD104010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijkouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijyotaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushagemmenjisshijokyo.JukyushaGemmenJisshiJokyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者減免実施状況のDataManagerクラスです。
 *
 * @reamsid_L DBD-3770-060 liuwei2
 */
public class JukyushagenmenshinseiDateManager {

    private final RString タイトル1_0 = new RString("標準負担申請受付件数");
    private final RString タイトル1_1 = new RString("　承認件数");
    private final RString タイトル1_2 = new RString("　金額 500円");
    private final RString タイトル1_3 = new RString("　金額 300円");
    private final RString タイトル1_4 = new RString("　金額 その他");
    private final RString タイトル1_5 = new RString("　不承認件数");
    private final RString タイトル1_6 = RString.EMPTY;

    private final RString タイトル2_0 = new RString("利用者負担申請受付件数");
    private final RString タイトル2_1 = new RString("　承認件数");
    private final RString タイトル2_2 = new RString("　給付率 91～95%");
    private final RString タイトル2_3 = new RString("　給付率 96～99%");
    private final RString タイトル2_4 = new RString("　給付率 100%");
    private final RString タイトル2_5 = new RString("　不承認件数");
    private final RString タイトル2_6 = RString.EMPTY;

    private final RString タイトル3_0 = new RString("特別対策申請受付件数");
    private final RString タイトル3_1 = new RString(" 施行時ホームヘルプ");
    private final RString タイトル3_2 = new RString("　承認件数");
    private final RString タイトル3_3 = new RString("　給付率 90～95%");
    private final RString タイトル3_4 = new RString("　給付率 96～99%");
    private final RString タイトル3_5 = new RString("　給付率 100%");
    private final RString タイトル3_6 = new RString("　不承認件数");
    private final RString タイトル3_7 = new RString(" 障害ホームヘルプ");
    private final RString タイトル3_8 = new RString("　承認件数");
    private final RString タイトル3_9 = new RString("　給付率 90～95%");
    private final RString タイトル3_10 = new RString("　給付率 96～99%");
    private final RString タイトル3_11 = new RString("　給付率 100%");
    private final RString タイトル3_12 = new RString("　不承認件数");
    private final RString タイトル3_13 = RString.EMPTY;

    private final RString タイトル4_0 = new RString("社会福祉法人申請受付件数");
    private final RString タイトル4_1 = new RString("　承認件数");
    private final RString タイトル4_2 = new RString("　軽減率 12.5/100");
    private final RString タイトル4_3 = new RString("　軽減率　 25/100");
    private final RString タイトル4_4 = new RString("　軽減率　 50/100");
    private final RString タイトル4_5 = new RString("　軽減率　その他");
    private final RString タイトル4_6 = new RString("　不承認件数");

    private final RString タイトル5_0 = new RString("特定入所者申請受付件数");
    private final RString タイトル5_1 = new RString("　承認件数");
    private final RString タイトル5_2 = new RString("　負担第４段階・旧措置");
    private final RString タイトル5_3 = new RString("　負担課税層第３段階・旧措置");
    private final RString タイトル5_4 = new RString("　負担第３段階・旧措置");
    private final RString タイトル5_5 = new RString("　負担第２段階・旧措置");
    private final RString タイトル5_6 = new RString("　負担第１段階・旧措置");
    private final RString タイトル5_7 = new RString("　負担第４段階");
    private final RString タイトル5_8 = new RString("　負担課税層第３段階");
    private final RString タイトル5_9 = new RString("　負担第３段階");
    private final RString タイトル5_10 = new RString("　負担第２段階");
    private final RString タイトル5_11 = new RString("　負担第１段階");
    private final RString タイトル5_12 = new RString("　不承認件数");
    private final RString タイトル5_13 = RString.EMPTY;

    private final RString タイトル6_0 = new RString("特別地域加算申請受付件数");
    private final RString タイトル6_1 = new RString("　承認件数");
    private final RString タイトル6_2 = new RString("　減額率 10/100");
    private final RString タイトル6_3 = new RString("　減額率　その他");
    private final RString タイトル6_4 = new RString("　不承認件数");
    private final RString タイトル6_5 = RString.EMPTY;
    private final RString タイトル6_6 = RString.EMPTY;
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
    private static final Decimal TWELVE = new Decimal(12);
    private static final Decimal THIRTEEN = new Decimal(13);
    private static final RString タイトルのみ印字 = new RString("タイトルのみ印字");

    /**
     * コンストラクタです。
     */
    public JukyushagenmenshinseiDateManager() {
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
    public NinteijkouTempTableEntity set受給者減免月別申請認定状況表中間テーブル(NinteijyotaiEntity entity, Decimal num, LasdecCode 市町村コード, RString 市町村名称) {
        NinteijkouTempTableEntity newEntity = new NinteijkouTempTableEntity();
        if (ONE.equals(entity.getTableFlag()) || TWO.equals(entity.getTableFlag())) {
            if (SIX.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (THREE.equals(entity.getTableFlag())) {
            if (ONE.equals(num) || SEVEN.equals(num) || THIRTEEN.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (FIVE.equals(entity.getTableFlag())) {
            if (THIRTEEN.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (SIX.equals(entity.getTableFlag())) {
            if (FIVE.equals(num) || SIX.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else {
            newEntity.setInnjiKubun(RString.EMPTY);
        }
        newEntity.setTitle(setタイトル(entity.getTableFlag(), num));
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

        Decimal sum = entity.getIchigatukensu().add(entity.getNigatukensu()).add(entity.getSangatukensu())
                .add(entity.getSigatukensu()).add(entity.getGogatukensu()).add(entity.getLokugatukensu()).add(entity.getShichigatukensu())
                .add(entity.getHachigatukensu()).add(entity.getKugatukensu()).add(entity.getJyugatukensu()).add(entity.getJyuichigatukensu())
                .add(entity.getJyuichigatukensu());
        newEntity.setGoukeikensu(sum);
        newEntity.setGoukeisotishakensu(Decimal.ZERO);

        return newEntity;
    }

    /**
     * 空の中間テーブルを設定します。
     *
     * @param tableflag Decimal
     * @param num Decimal
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @return NinteijkouTempTableEntity
     */
    public NinteijkouTempTableEntity add受給者減免月別申請認定状況表中間テーブルEmpty(Decimal tableflag, Decimal num, LasdecCode 市町村コード, RString 市町村名称) {
        NinteijkouTempTableEntity newEntity = new NinteijkouTempTableEntity();

        if (ONE.equals(tableflag) || TWO.equals(tableflag)) {
            if (SIX.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (THREE.equals(tableflag)) {
            if (ONE.equals(num) || SEVEN.equals(num) || THIRTEEN.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (FIVE.equals(tableflag)) {
            if (THIRTEEN.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else if (SIX.equals(tableflag)) {
            if (FIVE.equals(num) || SIX.equals(num)) {
                newEntity.setInnjiKubun(タイトルのみ印字);
            }
        } else {
            newEntity.setInnjiKubun(RString.EMPTY);
        }

        newEntity.setTitle(setタイトル(tableflag, num));
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
     * 宛名抽出条件を設定します。
     *
     * @param processParameter DBD104010ProcessParameter
     * @return ShikibetsuTaishoPSMSearchKeyBuilder
     */
    public ShikibetsuTaishoPSMSearchKeyBuilder set抽出条件(DBD104010ProcessParameter processParameter) {
        ShikibetsuTaishoPSMSearchKeyBuilder build
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList<>();
        List<JuminJotai> 住民状態List = new ArrayList<>();
        build.setデータ取得区分(DataShutokuKubun.直近レコード);
        build.set住民種別(get住民種別(住民種別List));
        build.set住民状態(get住民状態(住民状態List));
        build.set地区コード1開始値(new ChikuCode(processParameter.get宛名抽出条件().getChiku1_From()));
        build.set地区コード1終了値(new ChikuCode(processParameter.get宛名抽出条件().getChiku1_To()));
        build.set地区コード2開始値(new ChikuCode(processParameter.get宛名抽出条件().getChiku2_From()));
        build.set地区コード2終了値(new ChikuCode(processParameter.get宛名抽出条件().getChiku2_To()));
        build.set地区コード3開始値(new ChikuCode(processParameter.get宛名抽出条件().getChiku3_From()));
        build.set地区コード3終了値(new ChikuCode(processParameter.get宛名抽出条件().getChiku3_To()));
        build.set行政区コード開始値(new GyoseikuCode(processParameter.get宛名抽出条件().getGyoseiku_From()));
        build.set行政区コード終了値(new GyoseikuCode(processParameter.get宛名抽出条件().getGyoseiku_To()));
        build.set町域コード開始値(new ChoikiCode(processParameter.get宛名抽出条件().getJusho_From()));
        build.set町域コード終了値(new ChoikiCode(processParameter.get宛名抽出条件().getJusho_To()));
        return build;
    }

    /**
     * 受給者減免月別申請認定状況帳票出力データを設定します。
     *
     * @param t NinteijkouTempTableEntity
     * @return JukyushaGemmenJisshiJokyoEntity
     */
    public JukyushaGemmenJisshiJokyoEntity set受給者減免月別申請認定状況帳票出力(NinteijkouTempTableEntity t) {
        JukyushaGemmenJisshiJokyoEntity データリスト = new JukyushaGemmenJisshiJokyoEntity();

        データリスト.setタイトル(t.getTitle());
        データリスト.set一月(new RString(t.getIchigatukensu().longValue()));
        データリスト.set二月(new RString(t.getNigatukensu().longValue()));
        データリスト.set三月(new RString(t.getSangatukensu().longValue()));
        データリスト.set四月(new RString(t.getSigatukensu().longValue()));
        データリスト.set五月(new RString(t.getGogatukensu().longValue()));
        データリスト.set六月(new RString(t.getLokugatukensu().longValue()));
        データリスト.set七月(new RString(t.getShichigatukensu().longValue()));
        データリスト.set八月(new RString(t.getHachigatukensu().longValue()));
        データリスト.set九月(new RString(t.getKugatukensu().longValue()));
        データリスト.set十月(new RString(t.getJyugatukensu().longValue()));
        データリスト.set十一月(new RString(t.getJyuichigatukensu().longValue()));
        データリスト.set十二月(new RString(t.getJyunigatukensu().longValue()));
        データリスト.set合計(new RString(t.getGoukeikensu().longValue()));
        return データリスト;
    }

    /**
     * 受給者減免月別申請認定状況帳票出力データを設定します。
     *
     * @param t NinteijkouTempTableEntity
     * @return JukyushaGemmenJisshiJokyoEntity
     */
    public JukyushaGemmenJisshiJokyoEntity set受給者減免月別申請認定状況帳票出力_タイトルのみ印字(NinteijkouTempTableEntity t) {
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

    private RString setタイトル(Decimal tableflag, Decimal num) {
        RString title = RString.EMPTY;
        if (標準負担額減免.equals(tableflag)) {
            title = setタイトル1(num);
            if (!title.isEmpty()) {
                return title;
            }
        }
        if (利用者負担額減額.equals(tableflag)) {
            title = setタイトル2(num);
            if (title != null) {
                return title;
            }
        }
        if (訪問介護利用者負担額減額.equals(tableflag)) {
            title = setタイトル3(num);
            if (title != null) {
                return title;
            }
        }
        if (社会福祉法人減免.equals(tableflag)) {
            title = setタイトル4(num);
            if (title != null) {
                return title;
            }
        }
        if (介護保険負担限度額認定.equals(tableflag)) {
            title = setタイトル5(num);
            if (title != null) {
                return title;
            }
        }
        if (特別地域加算減免.equals(tableflag)) {
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
        if (SIX.equals(num)) {
            return タイトル1_6;
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
        if (SIX.equals(num)) {
            return タイトル2_6;
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
        if (TWELVE.equals(num)) {
            return タイトル3_12;
        }
        if (THIRTEEN.equals(num)) {
            return タイトル3_13;
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
        if (TWELVE.equals(num)) {
            return タイトル5_12;
        }
        if (THIRTEEN.equals(num)) {
            return タイトル5_13;
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
        if (SIX.equals(num)) {
            return タイトル6_6;
        }
        return RString.EMPTY;
    }

    private List<JuminShubetsu> get住民種別(List<JuminShubetsu> 住民種別List) {
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        return 住民種別List;
    }

    private List<JuminJotai> get住民状態(List<JuminJotai> 住民状態List) {
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        return 住民状態List;
    }
}
