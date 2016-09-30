/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定調査票差異チェック票パラメータクラスです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaiChekkuhyoItem {

    private final RString zenkaiIchijiHantei;
    private final RString hihokenshaKubun;
    private final RString hokenshaName;
    private final RString age;
    private final RString zenkaiNijiHantei;
    private final RString zenkaiNijihanteiYMD;
    private final RString seinengappi;
    private final RString listIchigun_1;
    private final RString listIchigun_2;
    private final RString listIchigun_3;
    private final RString listIchigun_4;
    private final RString listIchigun_5;
    private final RString listIchigun_6;
    private final RString listIchigun_7;
    private final RString listIchigun_8;
    private final RString listIchigun_9;
    private final RString listIchigun_10;
    private final RString listIchigun_11;
    private final RString listIchigun_12;
    private final RString listIchigun_13;
    private final RString listIchigun_14;
    private final RString listIchigun_15;
    private final RString listIchigun_16;
    private final RString listIchigun_17;
    private final RString listIchigun_18;
    private final RString listIchigun_19;
    private final RString listIchigun_20;
    private final RString listNigun_1;
    private final RString listNigun_2;
    private final RString listNigun_3;
    private final RString listNigun_4;
    private final RString listNigun_5;
    private final RString listNigun_6;
    private final RString listNigun_7;
    private final RString listNigun_8;
    private final RString listNigun_9;
    private final RString listNigun_10;
    private final RString listNigun_11;
    private final RString listNigun_12;
    private final RString listSangun_1;
    private final RString listSangun_2;
    private final RString listSangun_3;
    private final RString listSangun_4;
    private final RString listSangun_5;
    private final RString listSangun_6;
    private final RString listSangun_7;
    private final RString listSangun_8;
    private final RString listSangun_9;
    private final RString listYongun_1;
    private final RString listYongun_2;
    private final RString listYongun_3;
    private final RString listYongun_4;
    private final RString listYongun_5;
    private final RString listYongun_6;
    private final RString listYongun_7;
    private final RString listYongun_8;
    private final RString listYongun_9;
    private final RString listYongun_10;
    private final RString listYongun_11;
    private final RString listYongun_12;
    private final RString listYongun_13;
    private final RString listYongun_14;
    private final RString listYongun_15;
    private final RString listGogun_1;
    private final RString listGogun_2;
    private final RString listGogun_3;
    private final RString listGogun_4;
    private final RString listGogun_5;
    private final RString listGogun_6;
    private final RString listRokugun_1;
    private final RString listRokugun_2;
    private final RString listRokugun_3;
    private final RString listRokugun_4;
    private final RString listRokugun_5;
    private final RString listRokugun_6;
    private final RString listRokugun_7;
    private final RString listRokugun_8;
    private final RString listRokugun_9;
    private final RString listRokugun_10;
    private final RString listRokugun_11;
    private final RString listRokugun_12;
    private final RString listJiritsudo_1;
    private final RString listJiritsudo_2;

    /**
     * コンストラクタです。
     *
     * @param zenkaiIchijiHantei 前回一次判定結果
     * @param hihokenshaKubun 被保険者番号
     * @param hokenshaName 氏名
     * @param age 年齢
     * @param zenkaiNijiHantei 前回二次判定結果
     * @param zenkaiNijihanteiYMD 前回二次判定日
     * @param seinengappi 生年月日
     * @param listIchigun_1 麻痺(左-上肢)
     * @param listIchigun_2 麻痺(右-上肢)
     * @param listIchigun_3 麻痺(左-下肢)
     * @param listIchigun_4 麻痺(右-下肢)
     * @param listIchigun_5 麻痺(その他)
     * @param listIchigun_6 拘縮(肩関節)
     * @param listIchigun_7 拘縮(股関節)
     * @param listIchigun_8 拘縮(膝関節)
     * @param listIchigun_9 拘縮(その他)
     * @param listIchigun_10 寝返り
     * @param listIchigun_11 起き上がり
     * @param listIchigun_12 座位保持
     * @param listIchigun_13 両足での立位
     * @param listIchigun_14 歩行
     * @param listIchigun_15 立ち上がり
     * @param listIchigun_16 片足での立位
     * @param listIchigun_17 洗身
     * @param listIchigun_18 つめ切り
     * @param listIchigun_19 視力
     * @param listIchigun_20 聴力
     * @param listNigun_1 移乗
     * @param listNigun_2 移動
     * @param listNigun_3 嚥下
     * @param listNigun_4 食事摂取
     * @param listNigun_5 排尿
     * @param listNigun_6 排便
     * @param listNigun_7 口腔清潔
     * @param listNigun_8 洗顔
     * @param listNigun_9 整髪
     * @param listNigun_10 上衣の着脱
     * @param listNigun_11 ズボン等の着脱
     * @param listNigun_12 外出頻度
     * @param listSangun_1 意思の伝達
     * @param listSangun_2 毎日の日課を理解
     * @param listSangun_3 生年月日をいう
     * @param listSangun_4 短期記憶
     * @param listSangun_5 自分の名前をいう
     * @param listSangun_6 今の季節を理解
     * @param listSangun_7 場所の理解
     * @param listSangun_8 常時の徘徊
     * @param listSangun_9 外出して戻れない
     * @param listYongun_1 被害的
     * @param listYongun_2 作話
     * @param listYongun_3 感情が不安定
     * @param listYongun_4 昼夜逆転
     * @param listYongun_5 同じ話をする
     * @param listYongun_6 大声を出す
     * @param listYongun_7 介護に抵抗
     * @param listYongun_8 落ち着きなし
     * @param listYongun_9 一人で出たがる
     * @param listYongun_10 収集癖
     * @param listYongun_11 物や衣類を壊す
     * @param listYongun_12 ひどい物忘れ
     * @param listYongun_13 独り言・独り笑い
     * @param listYongun_14 自分勝手に行動する
     * @param listYongun_15 話がまとまらない
     * @param listGogun_1 薬の内服
     * @param listGogun_2 金銭の管理
     * @param listGogun_3 日常の意思決定
     * @param listGogun_4 集団参加ができない
     * @param listGogun_5 買い物
     * @param listGogun_6 簡単な調理
     * @param listRokugun_1 点滴の管理
     * @param listRokugun_2 中心静脈栄養
     * @param listRokugun_3 透析
     * @param listRokugun_4 ストーマの処置
     * @param listRokugun_5 酸素療法
     * @param listRokugun_6 レスピレーター
     * @param listRokugun_7 気管切開
     * @param listRokugun_8 疼痛の看護
     * @param listRokugun_9 経管栄養
     * @param listRokugun_10 モニター測定
     * @param listRokugun_11 じょくそうの処置
     * @param listRokugun_12 カテーテル
     * @param listJiritsudo_1 障害高齢者自立度
     * @param listJiritsudo_2 認知症高齢者自立度
     */
    public SaiChekkuhyoItem(
            RString zenkaiIchijiHantei,
            RString hihokenshaKubun,
            RString hokenshaName,
            RString age,
            RString zenkaiNijiHantei,
            RString zenkaiNijihanteiYMD,
            RString seinengappi,
            RString listIchigun_1,
            RString listIchigun_2,
            RString listIchigun_3,
            RString listIchigun_4,
            RString listIchigun_5,
            RString listIchigun_6,
            RString listIchigun_7,
            RString listIchigun_8,
            RString listIchigun_9,
            RString listIchigun_10,
            RString listIchigun_11,
            RString listIchigun_12,
            RString listIchigun_13,
            RString listIchigun_14,
            RString listIchigun_15,
            RString listIchigun_16,
            RString listIchigun_17,
            RString listIchigun_18,
            RString listIchigun_19,
            RString listIchigun_20,
            RString listNigun_1,
            RString listNigun_2,
            RString listNigun_3,
            RString listNigun_4,
            RString listNigun_5,
            RString listNigun_6,
            RString listNigun_7,
            RString listNigun_8,
            RString listNigun_9,
            RString listNigun_10,
            RString listNigun_11,
            RString listNigun_12,
            RString listSangun_1,
            RString listSangun_2,
            RString listSangun_3,
            RString listSangun_4,
            RString listSangun_5,
            RString listSangun_6,
            RString listSangun_7,
            RString listSangun_8,
            RString listSangun_9,
            RString listYongun_1,
            RString listYongun_2,
            RString listYongun_3,
            RString listYongun_4,
            RString listYongun_5,
            RString listYongun_6,
            RString listYongun_7,
            RString listYongun_8,
            RString listYongun_9,
            RString listYongun_10,
            RString listYongun_11,
            RString listYongun_12,
            RString listYongun_13,
            RString listYongun_14,
            RString listYongun_15,
            RString listGogun_1,
            RString listGogun_2,
            RString listGogun_3,
            RString listGogun_4,
            RString listGogun_5,
            RString listGogun_6,
            RString listRokugun_1,
            RString listRokugun_2,
            RString listRokugun_3,
            RString listRokugun_4,
            RString listRokugun_5,
            RString listRokugun_6,
            RString listRokugun_7,
            RString listRokugun_8,
            RString listRokugun_9,
            RString listRokugun_10,
            RString listRokugun_11,
            RString listRokugun_12,
            RString listJiritsudo_1,
            RString listJiritsudo_2
    ) {
        this.zenkaiIchijiHantei = zenkaiIchijiHantei;
        this.hihokenshaKubun = hihokenshaKubun;
        this.hokenshaName = hokenshaName;
        this.age = age;
        this.zenkaiNijiHantei = zenkaiNijiHantei;
        this.zenkaiNijihanteiYMD = zenkaiNijihanteiYMD;
        this.seinengappi = seinengappi;
        this.listIchigun_1 = listIchigun_1;
        this.listIchigun_2 = listIchigun_2;
        this.listIchigun_3 = listIchigun_3;
        this.listIchigun_4 = listIchigun_4;
        this.listIchigun_5 = listIchigun_5;
        this.listIchigun_6 = listIchigun_6;
        this.listIchigun_7 = listIchigun_7;
        this.listIchigun_8 = listIchigun_8;
        this.listIchigun_9 = listIchigun_9;
        this.listIchigun_10 = listIchigun_10;
        this.listIchigun_11 = listIchigun_11;
        this.listIchigun_12 = listIchigun_12;
        this.listIchigun_13 = listIchigun_13;
        this.listIchigun_14 = listIchigun_14;
        this.listIchigun_15 = listIchigun_15;
        this.listIchigun_16 = listIchigun_16;
        this.listIchigun_17 = listIchigun_17;
        this.listIchigun_18 = listIchigun_18;
        this.listIchigun_19 = listIchigun_19;
        this.listIchigun_20 = listIchigun_20;
        this.listNigun_1 = listNigun_1;
        this.listNigun_2 = listNigun_2;
        this.listNigun_3 = listNigun_3;
        this.listNigun_4 = listNigun_4;
        this.listNigun_5 = listNigun_5;
        this.listNigun_6 = listNigun_6;
        this.listNigun_7 = listNigun_7;
        this.listNigun_8 = listNigun_8;
        this.listNigun_9 = listNigun_9;
        this.listNigun_10 = listNigun_10;
        this.listNigun_11 = listNigun_11;
        this.listNigun_12 = listNigun_12;
        this.listSangun_1 = listSangun_1;
        this.listSangun_2 = listSangun_2;
        this.listSangun_3 = listSangun_3;
        this.listSangun_4 = listSangun_4;
        this.listSangun_5 = listSangun_5;
        this.listSangun_6 = listSangun_6;
        this.listSangun_7 = listSangun_7;
        this.listSangun_8 = listSangun_8;
        this.listSangun_9 = listSangun_9;
        this.listYongun_1 = listYongun_1;
        this.listYongun_2 = listYongun_2;
        this.listYongun_3 = listYongun_3;
        this.listYongun_4 = listYongun_4;
        this.listYongun_5 = listYongun_5;
        this.listYongun_6 = listYongun_6;
        this.listYongun_7 = listYongun_7;
        this.listYongun_8 = listYongun_8;
        this.listYongun_9 = listYongun_9;
        this.listYongun_10 = listYongun_10;
        this.listYongun_11 = listYongun_11;
        this.listYongun_12 = listYongun_12;
        this.listYongun_13 = listYongun_13;
        this.listYongun_14 = listYongun_14;
        this.listYongun_15 = listYongun_15;
        this.listGogun_1 = listGogun_1;
        this.listGogun_2 = listGogun_2;
        this.listGogun_3 = listGogun_3;
        this.listGogun_4 = listGogun_4;
        this.listGogun_5 = listGogun_5;
        this.listGogun_6 = listGogun_6;
        this.listRokugun_1 = listRokugun_1;
        this.listRokugun_2 = listRokugun_2;
        this.listRokugun_3 = listRokugun_3;
        this.listRokugun_4 = listRokugun_4;
        this.listRokugun_5 = listRokugun_5;
        this.listRokugun_6 = listRokugun_6;
        this.listRokugun_7 = listRokugun_7;
        this.listRokugun_8 = listRokugun_8;
        this.listRokugun_9 = listRokugun_9;
        this.listRokugun_10 = listRokugun_10;
        this.listRokugun_11 = listRokugun_11;
        this.listRokugun_12 = listRokugun_12;
        this.listJiritsudo_1 = listJiritsudo_1;
        this.listJiritsudo_2 = listJiritsudo_2;
    }
}
