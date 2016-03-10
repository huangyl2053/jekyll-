/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処調査項目09Aを表す列挙型です。
 *
 */
public enum NinteichosaKomoku09A {

    麻痺等の有無("001", "1", "1", "ない", "左上肢麻痺", "右上肢麻痺", "左下肢麻痺", "右下肢麻痺", "その他麻痺（四肢欠損）", "", "", ""),
    拘縮の有無("002", "1", "2", "ない", "肩関節", "股間接", "膝関節", "その他拘縮（四肢欠損）", "", "", "", ""),
    寝返り("", "1", "3", "つかまらないでできる", "何かにつかまればできる", "できない", "", "", "", "", "", ""),
    起き上がり("", "1", "4", "つかまらないでできる", "何かにつかまればできる", "できない", "", "", "", "", "", ""),
    座位保持("", "1", "5", "できる", "自分で支えれば可", "支えが必要", "できない", "", "", "", "", ""),
    両足での立位保持("", "1", "6", "支えなしでできる", "何か支えがあればできる", "できない", "", "", "", "", "", ""),
    歩行("", "1", "7", "つかまらないでできる", "何かにつかまればできる", "できない", "", "", "", "", "", ""),
    立ち上がり("", "1", "8", "つかまらないでできる", "何かにつかまればできる", "できない", "", "", "", "", "", ""),
    片足での立位("", "1", "9", "支えなしでできる", "何か支えがあればできる", "できない", "", "", "", "", "", ""),
    洗身("", "1", "10", "介助されていない", "一部介助", "全介助", "行っていない", "", "", "", "", ""),
    つめ切り("", "1", "11", "介助されていない", "一部介助", "全介助", "", "", "", "", "", ""),
    視力("", "1", "12", "普通（日常生活に支障がない）", "約1ｍ離れた視力確認表の図が見える", "目の前に置いた視力確認表の図が見える", "ほとんど見えない", "見えているのか判断不能", "", "", "", ""),
    聴力("", "1", "13", "普通", "普通の声がやっと聞き取れる", "かなり大きな声なら何とか聞き取れる", "ほとんど聞こえない", "聞こえているのか判断不能", "", "", "", ""),
    移乗("", "2", "1", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    移動("", "2", "2", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    えん下("", "2", "3", "できる", "見守り等", "できない", "", "", "", "", "", ""),
    食事摂取("", "2", "4", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    排尿("", "2", "5", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    排便("", "2", "6", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    口腔清潔("", "2", "7", "介助されていない", "一部介助", "全介助", "", "", "", "", "", ""),
    洗顔("", "2", "8", "介助されていない", "一部介助", "全介助", "", "", "", "", "", ""),
    整髪("", "2", "9", "介助されていない", "一部介助", "全介助", "", "", "", "", "", ""),
    上衣の着脱("", "2", "10", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    ズボン等の着脱("", "2", "11", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    外出頻度("", "2", "12", "週1回以上", "月1回以上", "月1回未満", "", "", "", "", "", ""),
    意思の伝達("", "3", "1", "調査対象者が意思を他者に伝達できる", "ときどき伝達できる", "ほとんど伝達できない", "できない", "", "", "", "", ""),
    毎日の日課を理解("", "3", "2", "できる", "できない", "", "", "", "", "", "", ""),
    生年月日や年齢を言う("", "3", "3", "できる", "できない", "", "", "", "", "", "", ""),
    短期記憶("", "3", "4", "できる", "できない", "", "", "", "", "", "", ""),
    自分の名前を言う("", "3", "5", "できる", "できない", "", "", "", "", "", "", ""),
    今の季節を理解する("", "3", "6", "できる", "できない", "", "", "", "", "", "", ""),
    場所の理解("", "3", "7", "できる", "できない", "", "", "", "", "", "", ""),
    徘徊("", "3", "8", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    外出すると戻れない("", "3", "9", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    被害的("", "4", "1", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    作話("", "4", "2", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    感情が不安定("", "4", "3", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    昼夜逆転("", "4", "4", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    同じ話をする("", "4", "5", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    大声を出す("", "4", "6", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    介護に抵抗("", "4", "7", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    落ち着きなし("", "4", "8", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    一人で出たがる("", "4", "9", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    収集癖("", "4", "10", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    物や衣類を壊す("", "4", "11", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    ひどい物忘れ("", "4", "12", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    独り言独り笑い("", "4", "13", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    自分勝手に行動する("", "4", "14", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    話がまとまらない("", "4", "15", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    薬の内服("", "5", "1", "介助されていない", "一部介助", "全介助", "", "", "", "", "", ""),
    金銭の管理("", "5", "2", "介助されていない", "一部介助", "全介助", "", "", "", "", "", ""),
    日常の意思決定("", "5", "3", "できる（特別な場合でもできる）", "特別な場合を除いてできる", "日常的に困難", "できない", "", "", "", "", ""),
    集団への不適応("", "5", "4", "ない", "ときどきある", "ある", "", "", "", "", "", ""),
    買い物("", "5", "5", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    簡単な調理("", "5", "6", "介助されていない", "見守り等", "一部介助", "全介助", "", "", "", "", ""),
    点滴の管理("", "6", "1", "中心静脈栄養", "透析", "ストーマ（人口肛門）の処置", "酸素療法", "レスピレーター（人口呼吸器）", "気管切開の処置", "疼痛の看護", "経管栄養", ""),
    モニター測定("", "6", "2", "じょくそうの処置", "カテーテル", "", "", "", "", "", "", ""),
    障害高齢者自立度("", "7", "1", "自立", "J1", "J2", "A1", "A2", "B1", "B2", "C1", "C2"),
    認知症高齢者自立度("", "7", "2", "自立", "Ⅰ", "Ⅱa", "Ⅱb", "Ⅲa", "Ⅲb", "Ⅳ", "M", "");

    private final RString code;
    private final RString groupNo;
    private final RString groupNaiNo;
    private final RString name1;
    private final RString name2;
    private final RString name3;
    private final RString name4;
    private final RString name5;
    private final RString name6;
    private final RString name7;
    private final RString name8;
    private final RString name9;

    private NinteichosaKomoku09A(String code, String groupNo, String groupNaiNo, String name1, String name2, String name3, String name4,
            String name5, String name6, String name7, String name8, String name9) {
        this.code = new RString(code);
        this.groupNo = new RString(groupNo);
        this.groupNaiNo = new RString(groupNaiNo);
        this.name1 = new RString(name1);
        this.name2 = new RString(name2);
        this.name3 = new RString(name3);
        this.name4 = new RString(name4);
        this.name5 = new RString(name5);
        this.name6 = new RString(name6);
        this.name7 = new RString(name7);
        this.name8 = new RString(name8);
        this.name9 = new RString(name9);

    }

    /**
     * 調査項目09Aのコードを返します。
     *
     * @return 調査項目09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 調査項目09Aの群番号を返します。
     *
     * @return 調査項目09Aの群番号
     */
    public RString get群番号() {
        return groupNo;
    }

    /**
     * 調査項目09Aの群内順序を返します。
     *
     * @return 調査項目09Aの群内順序
     */
    public RString get群内順序() {
        return groupNaiNo;
    }

    /**
     * 調査項目09A1の名称を返します。
     *
     * @return 調査項目09Aの名称1
     */
    public RString get名称1() {
        return name1;
    }

    /**
     * 調査項目09A3の名称を返します。
     *
     * @return 調査項目09Aの名称2
     */
    public RString get名称2() {
        return name2;
    }

    /**
     * 調査項目09A3の名称を返します。
     *
     * @return 調査項目09Aの名称3
     */
    public RString get名称3() {
        return name3;
    }

    /**
     * 調査項目09A4の名称を返します。
     *
     * @return 調査項目09Aの名称4
     */
    public RString get名称4() {
        return name4;
    }

    /**
     * 調査項目09A5の名称を返します。
     *
     * @return 調査項目09Aの名称5
     */
    public RString get名称5() {
        return name5;
    }

    /**
     * 調査項目09A6の名称を返します。
     *
     * @return 調査項目09Aの名称6
     */
    public RString get名称6() {
        return name6;
    }

    /**
     * 調査項目09A7の名称を返します。
     *
     * @return 調査項目09Aの名称7
     */
    public RString get名称7() {
        return name7;
    }

    /**
     * 調査項目09A8の名称を返します。
     *
     * @return 調査項目09Aの名称8
     */
    public RString get名称8() {
        return name8;
    }

    /**
     * 調査項目09A9の名称を返します。
     *
     * @return 調査項目09Aの名称9
     */
    public RString get名称9() {
        return name9;
    }

    /**
     * 調査項目09Aのコードと一致する内容を探します。
     *
     * @param code 調査項目09Aのコード
     * @return {@code code} に対応する調査項目09A
     */
    public static NinteichosaKomoku09A toValueCode(RString code) {

        for (NinteichosaKomoku09A value : NinteichosaKomoku09A.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("調査項目09A"));
    }

    /**
     * 調査項目09Aの群番号、群内順序と一致する内容を探します。
     *
     * @param groupNo 調査項目09Aの群番号
     * @param groupNaiNo 調査項目09Aの群内順序
     * @return {@code code} に対応する調査項目09A
     */
    public static NinteichosaKomoku09A toValueGroupNo(RString groupNo, RString groupNaiNo) {

        for (NinteichosaKomoku09A value : NinteichosaKomoku09A.values()) {
            if (value.groupNo.equals(groupNo)
                    && value.groupNaiNo.equals(groupNaiNo)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("調査項目09A"));
    }
}
