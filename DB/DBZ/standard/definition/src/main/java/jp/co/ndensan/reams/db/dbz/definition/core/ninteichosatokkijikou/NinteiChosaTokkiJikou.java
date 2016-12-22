/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査特記事項マッピングクラスです。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum NinteiChosaTokkiJikou {

    /**
     * 麻痺等の有無
     */
    麻痺等の有無("1-1", "麻痺等の有無", "101", "C3001-xx.png"),
    /**
     * 拘縮の有無
     */
    拘縮の有無("1-2", "拘縮の有無", "102", "C3006-xx.png"),
    /**
     * 寝返り
     */
    寝返り("1-3", "寝返り", "103", "C3010-xx.png"),
    /**
     * 起き上がり
     */
    起き上がり("1-4", "起き上がり", "104", "C3011-xx.png"),
    /**
     * 座位保持
     */
    座位保持("1-5", "座位保持", "105", "C3012-xx.png"),
    /**
     * 両足での立位保持
     */
    両足での立位保持("1-6", "両足での立位保持", "106", "C3013-xx.png"),
    /**
     * 歩行
     */
    歩行("1-7", "歩行", "107", "C3014-xx.png"),
    /**
     * 立ち上がり
     */
    立ち上がり("1-8", "立ち上がり", "108", "C3015-xx.png"),
    /**
     * 片足での立位
     */
    片足での立位("1-9", "片足での立位", "109", "C3016-xx.png"),
    /**
     * 洗身
     */
    洗身("1-10", "洗身", "110", "C3017-xx.png"),
    /**
     * つめ切り
     */
    つめ切り("1-11", "つめ切り", "111", "C3018-xx.png"),
    /**
     * 視力
     */
    視力("1-12", "視力", "112", "C3019-xx.png"),
    /**
     * 聴力
     */
    聴力("1-13", "聴力", "113", "C3020-xx.png"),
    /**
     * 移乗
     */
    移乗("2-1", "移乗", "201", "C3021-xx.png"),
    /**
     * 移動
     */
    移動("2-2", "移動", "202", "C3022-xx.png"),
    /**
     * えん下
     */
    えん下("2-3", "えん下", "203", "C3023-xx.png"),
    /**
     * 食事摂取
     */
    食事摂取("2-4", "食事摂取", "204", "C3024-xx.png"),
    /**
     * 排尿
     */
    排尿("2-5", "排尿", "205", "C3025-xx.png"),
    /**
     * 排便
     */
    排便("2-6", "排便", "206", "C3026-xx.png"),
    /**
     * 口腔清潔
     */
    口腔清潔("2-7", "口腔清潔", "207", "C3027-xx.png"),
    /**
     * 洗顔
     */
    洗顔("2-8", "洗顔", "208", "C3028-xx.png"),
    /**
     * 整髪
     */
    整髪("2-9", "整髪", "209", "C3029-xx.png"),
    /**
     * 上衣の着脱
     */
    上衣の着脱("2-10", "上衣の着脱", "210", "C3030-xx.png"),
    /**
     * ズボン等の着脱
     */
    ズボン等の着脱("2-11", "ズボン等の着脱", "211", "C3031-xx.png"),
    /**
     * 外出頻度
     */
    外出頻度("2-12", "外出頻度", "212", "C3032-xx.png"),
    /**
     * 意思の伝達
     */
    意思の伝達("3-1", "意思の伝達", "301", "C3033-xx.png"),
    /**
     * 毎日の日課を理解
     */
    毎日の日課を理解("3-2", "毎日の日課を理解", "302", "C3034-xx.png"),
    /**
     * 麻痺等の有無
     */
    生年月日や年齢を言う("3-3", "生年月日や年齢を言う", "303", "C3035-xx.png"),
    /**
     * 短期記憶
     */
    短期記憶("3-4", "短期記憶", "304", "C3036-xx.png"),
    /**
     * 自分の名前を言う
     */
    自分の名前を言う("3-5", "自分の名前を言う", "305", "C3037-xx.png"),
    /**
     * 今の季節を理解する
     */
    今の季節を理解する("3-6", "今の季節を理解する", "306", "C3038-xx.png"),
    /**
     * 場所の理解
     */
    場所の理解("3-7", "場所の理解", "307", "C3039-xx.png"),
    /**
     * 徘徊
     */
    徘徊("3-8", "徘徊", "308", "C3040-xx.png"),
    /**
     * 外出すると戻れない
     */
    外出すると戻れない("3-9", "外出すると戻れない", "309", "C3041-xx.png"),
    /**
     * 被害的
     */
    被害的("4-1", "被害的", "401", "C3042-xx.png"),
    /**
     * 作話
     */
    作話("4-2", "作話", "402", "C3043-xx.png"),
    /**
     * 感情が不安定
     */
    感情が不安定("4-3", "感情が不安定", "403", "C3044-xx.png"),
    /**
     * 昼夜逆転
     */
    昼夜逆転("4-4", "昼夜逆転", "404", "C3045-xx.png"),
    /**
     * 同じ話をする
     */
    同じ話をする("4-5", "同じ話をする", "405", "C3046-xx.png"),
    /**
     * 大声をだす
     */
    大声をだす("4-6", "大声をだす", "406", "C3047-xx.png"),
    /**
     * 介護に抵抗
     */
    介護に抵抗("4-7", "介護に抵抗", "407", "C3048-xx.png"),
    /**
     * 落ち着きなし
     */
    落ち着きなし("4-8", "落ち着きなし", "408", "C3049-xx.png"),
    /**
     * 一人で出たがる
     */
    一人で出たがる("4-9", "一人で出たがる", "409", "C3050-xx.png"),
    /**
     * 収集癖
     */
    収集癖("4-10", "収集癖", "410", "C3051-xx.png"),
    /**
     * 物や衣類を壊す
     */
    物や衣類を壊す("4-11", "物や衣類を壊す", "411", "C3052-xx.png"),
    /**
     * ひどい物忘れ
     */
    ひどい物忘れ("4-12", "ひどい物忘れ", "412", "C3053-xx.png"),
    /**
     * 独り言_独り笑い
     */
    独り言_独り笑い("4-13", "独り言・独り笑い", "413", "C3054-xx.png"),
    /**
     * 自分勝手に行動する
     */
    自分勝手に行動する("4-14", "自分勝手に行動する", "414", "C3055-xx.png"),
    /**
     * 話がまとまらない
     */
    話がまとまらない("4-15", "話がまとまらない", "415", "C3056-xx.png"),
    /**
     * 薬の内服
     */
    薬の内服("5-1", "薬の内服", "501", "C3057-xx.png"),
    /**
     * 金銭の管理
     */
    金銭の管理("5-2", "金銭の管理", "502", "C3058-xx.png"),
    /**
     * 日常の意思決定
     */
    日常の意思決定("5-3", "日常の意思決定", "503", "C3059-xx.png"),
    /**
     * 集団への不適用
     */
    集団への不適応("5-4", "集団への不適応", "504", "C3060-xx.png"),
    /**
     * 買い物
     */
    買い物("5-5", "買い物", "505", "C3061-xx.png"),
    /**
     * 簡単な調理
     */
    簡単な調理("5-6", "簡単な調理", "506", "C3062-xx.png"),
    /**
     * 点滴の管理
     */
    点滴の管理("6-1", "点滴の管理", "601", "C3063-xx.png"),
    /**
     * 中心静脈栄養
     */
    中心静脈栄養("6-2", "中心静脈栄養", "602", "C3064-xx.png"),
    /**
     * 透析
     */
    透析("6-3", "透析", "603", "C3065-xx.png"),
    /**
     * ストーマの処置
     */
    ストーマの処置("6-4", "ストーマの処置", "604", "C3066-xx.png"),
    /**
     * 酸素療法
     */
    酸素療法("6-5", "酸素療法", "605", "C3067-xx.png"),
    /**
     * レスピレーター
     */
    レスピレーター("6-6", "レスピレーター", "606", "C3068-xx.png"),
    /**
     * 気管切開
     */
    気管切開("6-7", "気管切開", "607", "C3069-xx.png"),
    /**
     * 疼痛の看護
     */
    疼痛の看護("6-8", "疼痛の看護", "608", "C3070-xx.png"),
    /**
     * 経管栄養
     */
    経管栄養("6-9", "経管栄養", "609", "C3071-xx.png"),
    /**
     * モニター測定
     */
    モニター測定("6-10", "モニター測定", "610", "C3072-xx.png"),
    /**
     * じょくそうの処置
     */
    じょくそうの処置("6-11", "じょくそうの処置", "611", "C3073-xx.png"),
    /**
     * カテーテル
     */
    カテーテル("6-12", "カテーテル", "612", "C3074-xx.png"),
    /**
     * 障害高齢者自立度
     */
    障害高齢者自立度("7-1", "障害高齢者自立度", "701", "C3075-xx.png"),
    /**
     * 認知症高齢者自立度
     */
    認知症高齢者自立度("7-2", "認知症高齢者自立度", "702", "C3076-xx.png");

    private final RString gamenJikouNo;
    private final RString tokkiJikouMei;
    private final RString dbt5205JikouNo;
    private final RString imageFile;

    private NinteiChosaTokkiJikou(String gamenJikouNo, String tokkiJikouMei, String dbt5205JikouNo, String imageFile) {
        this.gamenJikouNo = new RString(gamenJikouNo);
        this.tokkiJikouMei = new RString(tokkiJikouMei);
        this.dbt5205JikouNo = new RString(dbt5205JikouNo);
        this.imageFile = new RString(imageFile);
    }

    /**
     * 画面表示用特記事項番号を取得する。
     *
     * @return 画面表示用特記事項番号
     */
    public RString get画面表示用特記事項番号() {
        return gamenJikouNo;
    }

    /**
     * 特記事項名を取得する。
     *
     * @return 特記事項名
     */
    public RString get特記事項名() {
        return tokkiJikouMei;
    }

    /**
     * テーブルの認定調査特記事項番号を取得する。
     *
     * @return テーブルの認定調査特記事項番号
     */
    public RString get認定調査票_特記情報_認定調査特記事項番号() {
        return dbt5205JikouNo;
    }

    /**
     * イメージファイルを取得する。
     *
     * @return イメージファイル
     */
    public RString getイメージファイル() {
        return imageFile;
    }

    /**
     * テーブルの認定調査特記事項番号で、enumを取得する。
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return enum
     */
    public static NinteiChosaTokkiJikou getEnumByDbt5205認定調査特記事項番号(RString 認定調査特記事項番号) {

        for (NinteiChosaTokkiJikou value : NinteiChosaTokkiJikou.values()) {
            if (value.dbt5205JikouNo.equals(認定調査特記事項番号)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査特記事項マッピング"));
    }

    /**
     * 画面認定調査特記事項番号で、enumを取得する。
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return enum
     */
    public static NinteiChosaTokkiJikou getEnumBy画面認定調査特記事項番号(RString 認定調査特記事項番号) {

        for (NinteiChosaTokkiJikou value : NinteiChosaTokkiJikou.values()) {
            if (value.gamenJikouNo.equals(認定調査特記事項番号)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査特記事項マッピング"));
    }
}
