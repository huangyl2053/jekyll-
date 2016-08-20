/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.iraijohodatatorikomi;

import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見項目のクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public class IkenshoKomoku {

    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;

    /**
     * 意見項目の取得処理です。
     *
     * @param 連番 連番
     * @param business IkenshokinyuyoshiBusiness
     * @return 意見項目
     */
    public RString get09A意見項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09A.点滴の管理.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.中心静脈栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.透析.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09A.ストーマの処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09A.酸素療法.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09A.レスピレーター.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09A.気管切開の処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09A.疼痛の看護.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09A.経管栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09A.モニター測定.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.じょくそうの処置.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.カテーテル.getコード().equals(new RString(連番))) {
            return business.get失禁への対応();
        } else if (IkenshoKomokuMapping09A.寝たきり度.getコード().equals(new RString(連番))) {
            return business.get寝たきり度();
        } else if (IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード().equals(new RString(連番))) {
            return business.get認知症高齢者の日常生活自立度();
        } else if (IkenshoKomokuMapping09A.短期記憶.getコード().equals(new RString(連番))) {
            return business.get短期記憶();
        } else if (IkenshoKomokuMapping09A.認知能力.getコード().equals(new RString(連番))) {
            return business.get認知能力();
        } else if (IkenshoKomokuMapping09A.伝達能力.getコード().equals(new RString(連番))) {
            return business.get伝達能力();
        } else {
            return get09A意見項目2(連番, business);
        }
    }

    private RString get09A意見項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09A.認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状有無();
        } else if (IkenshoKomokuMapping09A.幻視_幻聴.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.妄想.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.昼夜逆転.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09A.暴言.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09A.暴行.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09A.介護への抵抗.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09A.徘徊_認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09A.火の不始末.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09A.不潔行為.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09A.異食行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09A.性的問題行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping09A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKomokuMapping09A.専門医受診の有無.getコード().equals(new RString(連番))) {
            return business.get専門医受診有無();
        } else if (IkenshoKomokuMapping09A.利き腕.getコード().equals(new RString(連番))) {
            return business.get利き腕();
        } else if (IkenshoKomokuMapping09A.過去6カ月の体重の変化.getコード().equals(new RString(連番))) {
            return business.get体重の変化();
        } else {
            return get09A意見項目3(連番, business);
        }
    }

    private RString get09A意見項目3(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKomokuMapping09A.麻痺.getコード().equals(new RString(連番))) {
            return business.get麻痺();
        } else if (IkenshoKomokuMapping09A.麻痺_右上肢.getコード().equals(new RString(連番))) {
            return business.get麻痺右上肢();
        } else if (IkenshoKomokuMapping09A.麻痺_右上肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺右上肢程度();
        } else if (IkenshoKomokuMapping09A.麻痺_左上肢.getコード().equals(new RString(連番))) {
            return business.get麻痺左上肢();
        } else if (IkenshoKomokuMapping09A.麻痺_左上肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺左上肢程度();
        } else if (IkenshoKomokuMapping09A.麻痺_右下肢.getコード().equals(new RString(連番))) {
            return business.get麻痺右下肢();
        } else if (IkenshoKomokuMapping09A.麻痺_右下肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺右下肢程度();
        } else if (IkenshoKomokuMapping09A.麻痺_左下肢.getコード().equals(new RString(連番))) {
            return business.get麻痺左下肢();
        } else if (IkenshoKomokuMapping09A.麻痺_左下肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺左下肢程度();
        } else if (IkenshoKomokuMapping09A.麻痺_その他.getコード().equals(new RString(連番))) {
            return business.get麻痺その他();
        } else if (IkenshoKomokuMapping09A.麻痺_その他_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺その他程度();
        } else if (IkenshoKomokuMapping09A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKomokuMapping09A.筋力の低下_程度.getコード().equals(new RString(連番))) {
            return business.get筋力低下程度();
        } else if (IkenshoKomokuMapping09A.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else if (IkenshoKomokuMapping09A.関節の拘縮_程度.getコード().equals(new RString(連番))) {
            return business.get関節拘縮程度();
        } else if (IkenshoKomokuMapping09A.関節の痛み.getコード().equals(new RString(連番))) {
            return business.get関節痛み();
        } else {
            return get09A意見項目4(連番, business);
        }
    }

    private RString get09A意見項目4(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09A.関節の痛み_程度.getコード().equals(new RString(連番))) {
            return business.get関節痛み程度();
        } else if (IkenshoKomokuMapping09A.失調_不随意運動.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動();
        } else if (IkenshoKomokuMapping09A.失調_不随意運動_上肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.失調_不随意運動_上肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.失調_不随意運動_下肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.失調_不随意運動_下肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.失調_不随意運動_体幹_左.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.失調_不随意運動_体幹_右.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKomokuMapping09A.じょくそう_程度.getコード().equals(new RString(連番))) {
            return business.get褥瘡程度();
        } else if (IkenshoKomokuMapping09A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKomokuMapping09A.その他の皮膚疾患_程度.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾程度();
        } else if (IkenshoKomokuMapping09A.屋外歩行.getコード().equals(new RString(連番))) {
            return business.get屋外歩行();
        } else if (IkenshoKomokuMapping09A.車いすの使用.getコード().equals(new RString(連番))) {
            return business.get車いすの使用();
        } else if (IkenshoKomokuMapping09A.歩行補助具_装具の使用_用いていない.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.歩行補助具_装具の使用_屋外で使用.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.歩行補助具_装具の使用_屋内で使用.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09A.食事行為.getコード().equals(new RString(連番))) {
            return business.get食事行為();
        } else {
            return get09A意見項目5(連番, business);
        }
    }

    private RString get09A意見項目5(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09A.現在の栄養状態.getコード().equals(new RString(連番))) {
            return business.get現在の栄養状態();
        } else if (IkenshoKomokuMapping09A.尿失禁.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.転倒_骨折.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.移動能力の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09A.褥瘡.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09A.心肺機能の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09A.閉じこもり.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09A.意欲低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09A.徘徊_可能性が高い病態.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09A.低栄養.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09A.摂食_嚥下機能低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09A.脱水.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09A.易感染性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping09A.がん等による疼痛.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_12, INT_13);
        } else if (IkenshoKomokuMapping09A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKomokuMapping09A.生活機能の維持_改善の見通し.getコード().equals(new RString(連番))) {
            return business.getサービス利用による生活機能の維持_改善の見通し();
        } else {
            return get09A意見項目6(連番, business);
        }
    }

    private RString get09A意見項目6(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09A.訪問診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.訪問看護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.看護職員による相談.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09A.訪問歯科診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09A.訪問薬剤管理指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping09A.訪問リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09A.短期入所療養介護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09A.訪問歯科衛生指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09A.訪問栄養食事指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09A.通所リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09A.訪問診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping09A.訪問看護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping09A.看護職員による相談_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping09A.訪問歯科診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping09A.訪問薬剤管理指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else {
            return get09A意見項目7(連番, business);
        }
    }

    private RString get09A意見項目7(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping09A.訪問リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping09A.短期入所療養介護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping09A.訪問歯科衛生指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping09A.訪問栄養食事指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping09A.通所リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping09A.その他の医療系のサービス_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping09A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else if (IkenshoKomokuMapping09A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKomokuMapping09A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKomokuMapping09A.介護サービスの留意事項_運動.getコード().equals(new RString(連番))) {
            return business.getサービス提供運動();
        } else if (IkenshoKomokuMapping09A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKomokuMapping09A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 意見項目の取得処理です。
     *
     * @param 連番 連番
     * @param business IkenshokinyuyoshiBusiness
     * @return 意見項目
     */
    public RString get99A意見項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping99A.点滴の管理.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.中心静脈栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.透析.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(2, INT_3);
        } else if (IkenshoKomokuMapping99A.ストーマの処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping99A.酸素療法.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping99A.レスピレーター.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping99A.気管切開の処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping99A.疼痛の看護.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping99A.経管栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping99A.モニター測定.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.じょくそうの処置.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.カテーテル.getコード().equals(new RString(連番))) {
            return business.get失禁への対応();
        } else if (IkenshoKomokuMapping99A.寝たきり度.getコード().equals(new RString(連番))) {
            return business.get寝たきり度();
        } else if (IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード().equals(new RString(連番))) {
            return business.get認知症高齢者の日常生活自立度();
        } else if (IkenshoKomokuMapping99A.短期記憶.getコード().equals(new RString(連番))) {
            return business.get短期記憶();
        } else if (IkenshoKomokuMapping99A.認知能力.getコード().equals(new RString(連番))) {
            return business.get認知能力();
        } else if (IkenshoKomokuMapping99A.伝達能力.getコード().equals(new RString(連番))) {
            return business.get伝達能力();
        } else {
            return get99A意見項目2(連番, business);
        }
    }

    private RString get99A意見項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping99A.認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状有無();
        } else if (IkenshoKomokuMapping99A.幻視_幻聴.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.妄想.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.昼夜逆転.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(2, INT_3);
        } else if (IkenshoKomokuMapping99A.暴言.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping99A.暴行.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping99A.介護への抵抗.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping99A.火の不始末.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping99A.不潔行為.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping99A.異食行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping99A.性的問題行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping99A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping99A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKomokuMapping99A.専門医受診の有無.getコード().equals(new RString(連番))) {
            return business.get専門医受診有無();
        } else if (IkenshoKomokuMapping99A.利き腕.getコード().equals(new RString(連番))) {
            return business.get利き腕();
        } else {
            return get99A意見項目3(連番, business);
        }
    }

    private RString get99A意見項目3(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping99A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKomokuMapping99A.麻痺.getコード().equals(new RString(連番))) {
            return business.get麻痺();
        } else if (IkenshoKomokuMapping99A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKomokuMapping99A.筋力の低下_程度.getコード().equals(new RString(連番))) {
            return business.get筋力低下程度();
        } else if (IkenshoKomokuMapping99A.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else {
            return get99A意見項目4(連番, business);
        }
    }

    private RString get99A意見項目4(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping99A.失調_不随意運動.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動();
        } else if (IkenshoKomokuMapping99A.失調_不随意運動_上肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.失調_不随意運動_上肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.失調_不随意運動_下肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.失調_不随意運動_下肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.失調_不随意運動_体幹_左.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.失調_不随意運動_体幹_右.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKomokuMapping99A.じょくそう_程度.getコード().equals(new RString(連番))) {
            return business.get褥瘡程度();
        } else if (IkenshoKomokuMapping99A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKomokuMapping99A.その他の皮膚疾患_程度.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾程度();
        } else {
            return get99A意見項目5(連番, business);
        }
    }

    private RString get99A意見項目5(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping99A.尿失禁.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.転倒_骨折.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.褥瘡.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping99A.心肺機能の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping99A.徘徊_可能性が高い病態.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping99A.脱水.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping99A.易感染性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping99A.がん等による疼痛.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_12, INT_13);
        } else if (IkenshoKomokuMapping99A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else {
            return get99A意見項目6(連番, business);
        }
    }

    private RString get99A意見項目6(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping99A.訪問診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.訪問看護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.訪問歯科診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping99A.訪問薬剤管理指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping99A.訪問リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping99A.短期入所療養介護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping99A.訪問歯科衛生指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping99A.訪問栄養食事指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping99A.通所リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping99A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping99A.訪問診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping99A.訪問看護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping99A.訪問歯科診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping99A.訪問薬剤管理指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else {
            return get99A意見項目7(連番, business);
        }
    }

    private RString get99A意見項目7(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping99A.訪問リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping99A.短期入所療養介護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping99A.訪問歯科衛生指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping99A.訪問栄養食事指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping99A.通所リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping99A.その他の医療系のサービス_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping99A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else if (IkenshoKomokuMapping99A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKomokuMapping99A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKomokuMapping99A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKomokuMapping99A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 意見項目の取得処理です。
     *
     * @param 連番 連番
     * @param business IkenshokinyuyoshiBusiness
     * @return 意見項目
     */
    public RString get06A意見項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping06A.点滴の管理.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.中心静脈栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.透析.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(2, INT_3);
        } else if (IkenshoKomokuMapping06A.ストーマの処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping06A.酸素療法.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping06A.レスピレーター.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping06A.気管切開の処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping06A.疼痛の看護.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping06A.経管栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping06A.モニター測定.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.じょくそうの処置.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.カテーテル.getコード().equals(new RString(連番))) {
            return business.get失禁への対応();
        } else if (IkenshoKomokuMapping06A.寝たきり度.getコード().equals(new RString(連番))) {
            return business.get寝たきり度();
        } else if (IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード().equals(new RString(連番))) {
            return business.get認知症高齢者の日常生活自立度();
        } else if (IkenshoKomokuMapping06A.短期記憶.getコード().equals(new RString(連番))) {
            return business.get短期記憶();
        } else if (IkenshoKomokuMapping06A.認知能力.getコード().equals(new RString(連番))) {
            return business.get認知能力();
        } else if (IkenshoKomokuMapping06A.伝達能力.getコード().equals(new RString(連番))) {
            return business.get伝達能力();
        } else {
            return get06A意見項目2(連番, business);
        }
    }

    private RString get06A意見項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping06A.認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状有無();
        } else if (IkenshoKomokuMapping06A.幻視_幻聴.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.妄想.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.昼夜逆転.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(2, INT_3);
        } else if (IkenshoKomokuMapping06A.暴言.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping06A.暴行.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping06A.介護への抵抗.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping06A.徘徊_認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping06A.火の不始末.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping06A.不潔行為.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping06A.異食行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping06A.性的問題行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping06A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping06A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKomokuMapping06A.専門医受診の有無.getコード().equals(new RString(連番))) {
            return business.get専門医受診有無();
        } else if (IkenshoKomokuMapping06A.利き腕.getコード().equals(new RString(連番))) {
            return business.get利き腕();
        } else if (IkenshoKomokuMapping06A.過去6カ月の体重の変化.getコード().equals(new RString(連番))) {
            return business.get体重の変化();
        } else {
            return get06A意見項目3(連番, business);
        }
    }

    private RString get06A意見項目3(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping06A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKomokuMapping06A.麻痺.getコード().equals(new RString(連番))) {
            return business.get麻痺();
        } else if (IkenshoKomokuMapping06A.麻痺_右上肢.getコード().equals(new RString(連番))) {
            return business.get麻痺右上肢();
        } else if (IkenshoKomokuMapping06A.麻痺_右上肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺右上肢程度();
        } else if (IkenshoKomokuMapping06A.麻痺_左上肢.getコード().equals(new RString(連番))) {
            return business.get麻痺左上肢();
        } else if (IkenshoKomokuMapping06A.麻痺_左上肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺左上肢程度();
        } else if (IkenshoKomokuMapping06A.麻痺_右下肢.getコード().equals(new RString(連番))) {
            return business.get麻痺右下肢();
        } else if (IkenshoKomokuMapping06A.麻痺_右下肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺右下肢程度();
        } else if (IkenshoKomokuMapping06A.麻痺_左下肢.getコード().equals(new RString(連番))) {
            return business.get麻痺左下肢();
        } else if (IkenshoKomokuMapping06A.麻痺_左下肢_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺左下肢程度();
        } else if (IkenshoKomokuMapping06A.麻痺_その他.getコード().equals(new RString(連番))) {
            return business.get麻痺その他();
        } else if (IkenshoKomokuMapping06A.麻痺_その他_程度.getコード().equals(new RString(連番))) {
            return business.get麻痺その他程度();
        } else if (IkenshoKomokuMapping06A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKomokuMapping06A.筋力の低下_程度.getコード().equals(new RString(連番))) {
            return business.get筋力低下程度();
        } else if (IkenshoKomokuMapping06A.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else if (IkenshoKomokuMapping06A.関節の拘縮_程度.getコード().equals(new RString(連番))) {
            return business.get関節拘縮程度();
        } else if (IkenshoKomokuMapping06A.関節の痛み.getコード().equals(new RString(連番))) {
            return business.get関節痛み();
        } else {
            return get06A意見項目4(連番, business);
        }
    }

    private RString get06A意見項目4(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping06A.関節の痛み_程度.getコード().equals(new RString(連番))) {
            return business.get関節痛み程度();
        } else if (IkenshoKomokuMapping06A.失調_不随意運動.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動();
        } else if (IkenshoKomokuMapping06A.失調_不随意運動_上肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.失調_不随意運動_上肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.失調_不随意運動_下肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.失調_不随意運動_下肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.失調_不随意運動_体幹_左.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.失調_不随意運動_体幹_右.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKomokuMapping06A.じょくそう_程度.getコード().equals(new RString(連番))) {
            return business.get褥瘡程度();
        } else if (IkenshoKomokuMapping06A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKomokuMapping06A.その他の皮膚疾患_程度.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾程度();
        } else if (IkenshoKomokuMapping06A.屋外歩行.getコード().equals(new RString(連番))) {
            return business.get屋外歩行();
        } else if (IkenshoKomokuMapping06A.車いすの使用.getコード().equals(new RString(連番))) {
            return business.get車いすの使用();
        } else if (IkenshoKomokuMapping06A.歩行補助具_装具の使用_用いていない.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋外で使用.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.歩行補助具_装具の使用_屋内で使用.getコード().equals(new RString(連番))) {
            return business.get歩行補助具_装具の使用().substring(2, INT_3);
        } else if (IkenshoKomokuMapping06A.食事行為.getコード().equals(new RString(連番))) {
            return business.get食事行為();
        } else {
            return get06A意見項目5(連番, business);
        }
    }

    private RString get06A意見項目5(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping06A.現在の栄養状態.getコード().equals(new RString(連番))) {
            return business.get現在の栄養状態();
        } else if (IkenshoKomokuMapping06A.尿失禁.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.転倒_骨折.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.移動能力の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping06A.褥瘡.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping06A.心肺機能の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping06A.閉じこもり.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping06A.意欲低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping06A.徘徊_可能性が高い病態.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping06A.低栄養.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping06A.摂食_嚥下機能低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping06A.脱水.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping06A.易感染性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping06A.がん等による疼痛.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_12, INT_13);
        } else if (IkenshoKomokuMapping06A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else if (IkenshoKomokuMapping06A.生活機能の維持_改善の見通し.getコード().equals(new RString(連番))) {
            return business.getサービス利用による生活機能の維持_改善の見通し();
        } else {
            return get06A意見項目6(連番, business);
        }
    }

    private RString get06A意見項目6(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping06A.訪問診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.訪問看護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.訪問歯科診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping06A.訪問薬剤管理指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping06A.訪問リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping06A.短期入所療養介護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping06A.訪問歯科衛生指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping06A.訪問栄養食事指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping06A.通所リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping06A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping06A.訪問診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping06A.訪問看護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping06A.訪問歯科診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping06A.訪問薬剤管理指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else {
            return get06A意見項目7(連番, business);
        }
    }

    private RString get06A意見項目7(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping06A.訪問リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping06A.短期入所療養介護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping06A.訪問歯科衛生指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping06A.訪問栄養食事指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping06A.通所リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping06A.その他の医療系のサービス_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping06A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else if (IkenshoKomokuMapping06A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKomokuMapping06A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKomokuMapping06A.介護サービスの留意事項_運動.getコード().equals(new RString(連番))) {
            return business.getサービス提供運動();
        } else if (IkenshoKomokuMapping06A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKomokuMapping06A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }

    /**
     * 意見項目の取得処理です。
     *
     * @param 連番 連番
     * @param business IkenshokinyuyoshiBusiness
     * @return 意見項目
     */
    public RString get02A意見項目1(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping02A.点滴の管理.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.中心静脈栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.透析.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(2, INT_3);
        } else if (IkenshoKomokuMapping02A.ストーマの処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping02A.酸素療法.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping02A.レスピレーター.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping02A.気管切開の処置.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping02A.疼痛の看護.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping02A.経管栄養.getコード().equals(new RString(連番))) {
            return business.get処置内容().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping02A.モニター測定.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.じょくそうの処置.getコード().equals(new RString(連番))) {
            return business.get特別な対応().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.カテーテル.getコード().equals(new RString(連番))) {
            return business.get失禁への対応();
        } else if (IkenshoKomokuMapping02A.寝たきり度.getコード().equals(new RString(連番))) {
            return business.get寝たきり度();
        } else if (IkenshoKomokuMapping02A.認知症高齢者の日常生活自立度.getコード().equals(new RString(連番))) {
            return business.get認知症高齢者の日常生活自立度();
        } else if (IkenshoKomokuMapping02A.短期記憶.getコード().equals(new RString(連番))) {
            return business.get短期記憶();
        } else if (IkenshoKomokuMapping02A.認知能力.getコード().equals(new RString(連番))) {
            return business.get認知能力();
        } else if (IkenshoKomokuMapping02A.伝達能力.getコード().equals(new RString(連番))) {
            return business.get伝達能力();
        } else {
            return get02A意見項目2(連番, business);
        }
    }

    private RString get02A意見項目2(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping02A.認知症の周辺症状.getコード().equals(new RString(連番))) {
            return business.get周辺症状有無();
        } else if (IkenshoKomokuMapping02A.幻視_幻聴.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.妄想.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.昼夜逆転.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(2, INT_3);
        } else if (IkenshoKomokuMapping02A.暴言.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping02A.暴行.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping02A.介護への抵抗.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping02A.火の不始末.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping02A.不潔行為.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping02A.異食行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping02A.性的問題行動.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping02A.その他.getコード().equals(new RString(連番))) {
            return business.get周辺症状詳細().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping02A.その他の精神_神経症状.getコード().equals(new RString(連番))) {
            return business.get精神神経症状有無();
        } else if (IkenshoKomokuMapping02A.専門医受診の有無.getコード().equals(new RString(連番))) {
            return business.get専門医受診有無();
        } else if (IkenshoKomokuMapping02A.利き腕.getコード().equals(new RString(連番))) {
            return business.get利き腕();
        } else {
            return get02A意見項目3(連番, business);
        }
    }

    private RString get02A意見項目3(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping02A.四肢欠損.getコード().equals(new RString(連番))) {
            return business.get四肢欠損();
        } else if (IkenshoKomokuMapping02A.麻痺.getコード().equals(new RString(連番))) {
            return business.get麻痺();
        } else if (IkenshoKomokuMapping02A.筋力の低下.getコード().equals(new RString(連番))) {
            return business.get筋力低下();
        } else if (IkenshoKomokuMapping02A.筋力の低下_程度.getコード().equals(new RString(連番))) {
            return business.get筋力低下程度();
        } else if (IkenshoKomokuMapping02A.関節の拘縮.getコード().equals(new RString(連番))) {
            return business.get関節拘縮();
        } else {
            return get02A意見項目4(連番, business);
        }
    }

    private RString get02A意見項目4(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping02A.失調_不随意運動.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動();
        } else if (IkenshoKomokuMapping02A.失調_不随意運動_上肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.失調_不随意運動_上肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動上肢().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.失調_不随意運動_下肢_左.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.失調_不随意運動_下肢_右.getコード().equals(new RString(連番))) {
            return business.get失調不随意運動下肢().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.失調_不随意運動_体幹_左.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.失調_不随意運動_体幹_右.getコード().equals(new RString(連番))) {
            return business.get体幹().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.じょくそう.getコード().equals(new RString(連番))) {
            return business.get褥瘡();
        } else if (IkenshoKomokuMapping02A.じょくそう_程度.getコード().equals(new RString(連番))) {
            return business.get褥瘡程度();
        } else if (IkenshoKomokuMapping02A.その他の皮膚疾患.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾患();
        } else if (IkenshoKomokuMapping02A.その他の皮膚疾患_程度.getコード().equals(new RString(連番))) {
            return business.getその他皮膚疾程度();
        } else {
            return get02A意見項目5(連番, business);
        }
    }

    private RString get02A意見項目5(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping02A.尿失禁.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.転倒_骨折.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.褥瘡.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping02A.心肺機能の低下.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping02A.徘徊_可能性が高い病態.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping02A.脱水.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_10, INT_11);
        } else if (IkenshoKomokuMapping02A.易感染性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_11, INT_12);
        } else if (IkenshoKomokuMapping02A.がん等による疼痛.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_12, INT_13);
        } else if (IkenshoKomokuMapping02A.病態_その他.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_13, INT_14);
        } else {
            return get02A意見項目6(連番, business);
        }
    }

    private RString get02A意見項目6(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping02A.訪問診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.訪問看護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.訪問歯科診療.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping02A.訪問薬剤管理指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else if (IkenshoKomokuMapping02A.訪問リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping02A.短期入所療養介護.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping02A.訪問歯科衛生指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping02A.訪問栄養食事指導.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping02A.通所リハビリテーション.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping02A.その他の医療系のサービス.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping02A.訪問診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(0, 1);
        } else if (IkenshoKomokuMapping02A.訪問看護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(1, 2);
        } else if (IkenshoKomokuMapping02A.訪問歯科診療_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_5, INT_6);
        } else if (IkenshoKomokuMapping02A.訪問薬剤管理指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_7, INT_8);
        } else {
            return get02A意見項目7(連番, business);
        }
    }

    private RString get02A意見項目7(int 連番, IkenshokinyuyoshiBusiness business) {
        if (IkenshoKomokuMapping02A.訪問リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(2, INT_3);
        } else if (IkenshoKomokuMapping02A.短期入所療養介護_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_4, INT_5);
        } else if (IkenshoKomokuMapping02A.訪問歯科衛生指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_6, INT_7);
        } else if (IkenshoKomokuMapping02A.訪問栄養食事指導_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_8, INT_9);
        } else if (IkenshoKomokuMapping02A.通所リハビリテーション_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_3, INT_4);
        } else if (IkenshoKomokuMapping02A.その他の医療系のサービス_必要性.getコード().equals(new RString(連番))) {
            return business.get発生可能性状態().substring(INT_9, INT_10);
        } else if (IkenshoKomokuMapping02A.介護サービスの留意事項_血圧.getコード().equals(new RString(連番))) {
            return business.getサービス提供血圧();
        } else if (IkenshoKomokuMapping02A.介護サービスの留意事項_移動.getコード().equals(new RString(連番))) {
            return business.getサービス提供移動();
        } else if (IkenshoKomokuMapping02A.介護サービスの留意事項_摂食.getコード().equals(new RString(連番))) {
            return business.getサービス提供摂食();
        } else if (IkenshoKomokuMapping02A.介護サービスの留意事項_嚥下.getコード().equals(new RString(連番))) {
            return business.getサービス提供嚥下();
        } else if (IkenshoKomokuMapping02A.感染症の有無.getコード().equals(new RString(連番))) {
            return business.get感染症有無();
        } else {
            return RString.EMPTY;
        }
    }
}
