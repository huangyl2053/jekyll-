package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 要介護認定申請情報一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbT5101TempKoroshoEntity extends DbTableEntityBase<DbT5101TempKoroshoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString シーケンシャル番号;
    @TempTableColumnOrder(2)
    private RString 機能コード;
    @TempTableColumnOrder(3)
    private RString 識別コード;
    @TempTableColumnOrder(4)
    private RString 保険者番号;
    @TempTableColumnOrder(5)
    private RString 被保険者番号;
    @TempTableColumnOrder(6)
    private RString 認定申請日;
    @TempTableColumnOrder(7)
    private RString 主キー補助項目;
    @TempTableColumnOrder(8)
    private RString 申請区分_法令コード;
    @TempTableColumnOrder(9)
    private RString 申請区分_申請時コード;
    @TempTableColumnOrder(10)
    private RString 取下区分コード;
    @TempTableColumnOrder(11)
    private RString 被保険者区分コード;
    @TempTableColumnOrder(12)
    private RString 申請代行区分コード;
    @TempTableColumnOrder(13)
    private RString 生年月日;
    @TempTableColumnOrder(14)
    private RString 年齢;
    @TempTableColumnOrder(15)
    private RString 性別;
    @TempTableColumnOrder(16)
    private RString 氏名_カナ;
    @TempTableColumnOrder(17)
    private RString 氏名;
    @TempTableColumnOrder(18)
    private RString 郵便番号;
    @TempTableColumnOrder(19)
    private RString 住所;
    @TempTableColumnOrder(20)
    private RString 本人連絡先1;
    @TempTableColumnOrder(21)
    private RString 病院施設等の名称;
    @TempTableColumnOrder(22)
    private RString 病院施設等の住所;
    @TempTableColumnOrder(23)
    private RString 前回の審査会結果;
    @TempTableColumnOrder(24)
    private RString 前回の認定有効開始期間;
    @TempTableColumnOrder(25)
    private RString 前回の認定有効終了期間;
    @TempTableColumnOrder(26)
    private RString 主治医医療機関コード;
    @TempTableColumnOrder(27)
    private RString 主治医番号;
    @TempTableColumnOrder(28)
    private RString 意見書依頼日;
    @TempTableColumnOrder(29)
    private RString 意見書入手日;
    @TempTableColumnOrder(30)
    private RString 意見書短期記憶;
    @TempTableColumnOrder(31)
    private RString 意見書認知能力;
    @TempTableColumnOrder(32)
    private RString 意見書伝達能力;
    @TempTableColumnOrder(33)
    private RString 意見書食事;
    @TempTableColumnOrder(34)
    private RString 認知症高齢者の日常生活自立度;
    @TempTableColumnOrder(35)
    private RString 麻痺_左上肢;
    @TempTableColumnOrder(36)
    private RString 麻痺_右上肢;
    @TempTableColumnOrder(37)
    private RString 麻痺_左下肢;
    @TempTableColumnOrder(38)
    private RString 麻痺_右下肢;
    @TempTableColumnOrder(39)
    private RString 麻痺_その他;
    @TempTableColumnOrder(40)
    private RString 拘縮_肩関節;
    @TempTableColumnOrder(41)
    private RString 拘縮_股関節;
    @TempTableColumnOrder(42)
    private RString 拘縮_膝関節;
    @TempTableColumnOrder(43)
    private RString 拘縮_その他;
    @TempTableColumnOrder(44)
    private RString 寝返り;
    @TempTableColumnOrder(45)
    private RString 起き上がり;
    @TempTableColumnOrder(46)
    private RString 座位保持;
    @TempTableColumnOrder(47)
    private RString 両足での立位;
    @TempTableColumnOrder(48)
    private RString 歩行;
    @TempTableColumnOrder(49)
    private RString 立ち上がり;
    @TempTableColumnOrder(50)
    private RString 片足での立位;
    @TempTableColumnOrder(51)
    private RString 洗身;
    @TempTableColumnOrder(52)
    private RString つめ切り;
    @TempTableColumnOrder(53)
    private RString 視力;
    @TempTableColumnOrder(54)
    private RString 聴力;
    @TempTableColumnOrder(55)
    private RString 移乗;
    @TempTableColumnOrder(56)
    private RString 移動;
    @TempTableColumnOrder(57)
    private RString えん下;
    @TempTableColumnOrder(58)
    private RString 食事摂取;
    @TempTableColumnOrder(59)
    private RString 排尿;
    @TempTableColumnOrder(60)
    private RString 排便;
    @TempTableColumnOrder(61)
    private RString 口腔清潔;
    @TempTableColumnOrder(62)
    private RString 洗顔;
    @TempTableColumnOrder(63)
    private RString 整髪;
    @TempTableColumnOrder(64)
    private RString 上衣の着脱;
    @TempTableColumnOrder(65)
    private RString ズボン等の着脱;
    @TempTableColumnOrder(66)
    private RString 外出頻度;
    @TempTableColumnOrder(67)
    private RString 意思の伝達;
    @TempTableColumnOrder(68)
    private RString 毎日の日課を理解;
    @TempTableColumnOrder(69)
    private RString 生年月日をいう;
    @TempTableColumnOrder(70)
    private RString 短期記憶;
    @TempTableColumnOrder(71)
    private RString 自分の名前をいう;
    @TempTableColumnOrder(72)
    private RString 今の季節を理解;
    @TempTableColumnOrder(73)
    private RString 場所の理解;
    @TempTableColumnOrder(74)
    private RString 常時の徘徊;
    @TempTableColumnOrder(75)
    private RString 外出して戻れない;
    @TempTableColumnOrder(76)
    private RString 被害的;
    @TempTableColumnOrder(77)
    private RString 作話;
    @TempTableColumnOrder(78)
    private RString 感情が不安定;
    @TempTableColumnOrder(79)
    private RString 昼夜逆転;
    @TempTableColumnOrder(80)
    private RString 同じ話をする;
    @TempTableColumnOrder(81)
    private RString 大声をだす;
    @TempTableColumnOrder(82)
    private RString 介護に抵抗;
    @TempTableColumnOrder(83)
    private RString 落ち着きなし;
    @TempTableColumnOrder(84)
    private RString 一人で出たがる;
    @TempTableColumnOrder(85)
    private RString 収集癖;
    @TempTableColumnOrder(86)
    private RString 物や衣類を壊す;
    @TempTableColumnOrder(87)
    private RString ひどい物忘れ;
    @TempTableColumnOrder(88)
    private RString 独り言独り笑い;
    @TempTableColumnOrder(89)
    private RString 自分勝手に行動する;
    @TempTableColumnOrder(90)
    private RString 話がまとまらない;
    @TempTableColumnOrder(91)
    private RString 薬の内服;
    @TempTableColumnOrder(92)
    private RString 金銭の管理;
    @TempTableColumnOrder(93)
    private RString 日常の意思決定;
    @TempTableColumnOrder(94)
    private RString 集団への不適応;
    @TempTableColumnOrder(95)
    private RString 買い物;
    @TempTableColumnOrder(96)
    private RString 簡単な調理;
    @TempTableColumnOrder(97)
    private RString 点滴管理;
    @TempTableColumnOrder(98)
    private RString 中心静脈栄養;
    @TempTableColumnOrder(99)
    private RString 透析;
    @TempTableColumnOrder(100)
    private RString ストーマの処置;
    @TempTableColumnOrder(101)
    private RString 酸素療法;
    @TempTableColumnOrder(102)
    private RString レスピレーター;
    @TempTableColumnOrder(103)
    private RString 気管切開の処置;
    @TempTableColumnOrder(104)
    private RString 疼痛の看護;
    @TempTableColumnOrder(105)
    private RString 経管栄養;
    @TempTableColumnOrder(106)
    private RString モニター測定;
    @TempTableColumnOrder(107)
    private RString じょくそうの処置;
    @TempTableColumnOrder(108)
    private RString カテーテル;
    @TempTableColumnOrder(109)
    private RString 障害高齢者自立度;
    @TempTableColumnOrder(110)
    private RString 認知症高齢者自立度;
    @TempTableColumnOrder(111)
    private RString 一次判定結果;
    @TempTableColumnOrder(112)
    private RString 一次判定結果_認知症加算;
    @TempTableColumnOrder(113)
    private RString 要介護認定等基準時間;
    @TempTableColumnOrder(114)
    private RString 食事;
    @TempTableColumnOrder(115)
    private RString 排泄;
    @TempTableColumnOrder(116)
    private RString 等基準時間移動;
    @TempTableColumnOrder(117)
    private RString 清潔保持;
    @TempTableColumnOrder(118)
    private RString 間接ケア;
    @TempTableColumnOrder(119)
    private RString bPSD関連;
    @TempTableColumnOrder(120)
    private RString 機能訓練;
    @TempTableColumnOrder(121)
    private RString 医療関連;
    @TempTableColumnOrder(122)
    private RString 認知症加算;
    @TempTableColumnOrder(123)
    private RString 第1群;
    @TempTableColumnOrder(124)
    private RString 第2群;
    @TempTableColumnOrder(125)
    private RString 第3群;
    @TempTableColumnOrder(126)
    private RString 第4群;
    @TempTableColumnOrder(127)
    private RString 第5群;
    @TempTableColumnOrder(128)
    private RString 一次判定警告コード;
    @TempTableColumnOrder(129)
    private RString 状態の安定性;
    @TempTableColumnOrder(130)
    private RString 蓋然性;
    @TempTableColumnOrder(131)
    private RString 給付区分;
    @TempTableColumnOrder(132)
    private RString 申請日;
    @TempTableColumnOrder(133)
    private RString 二次判定日;
    @TempTableColumnOrder(134)
    private RString 現在のサービス区分コード;
    @TempTableColumnOrder(135)
    private RString 現在の状況;
    @TempTableColumnOrder(136)
    private RString 訪問介護_ホームヘルプサービ;
    @TempTableColumnOrder(137)
    private RString 訪問入浴介護;
    @TempTableColumnOrder(138)
    private RString 訪問看護;
    @TempTableColumnOrder(139)
    private RString 訪問リハビリテーション;
    @TempTableColumnOrder(140)
    private RString 居宅療養管理指導;
    @TempTableColumnOrder(141)
    private RString 通所介護_デイサービス;
    @TempTableColumnOrder(142)
    private RString 通所リハビリテーション;
    @TempTableColumnOrder(143)
    private RString ショートステイ;
    @TempTableColumnOrder(144)
    private RString 短期入所療養介護;
    @TempTableColumnOrder(145)
    private RString 特定施設入居者生活介護;
    @TempTableColumnOrder(146)
    private RString 福祉用具貸与;
    @TempTableColumnOrder(147)
    private RString 特定福祉用具販売;
    @TempTableColumnOrder(148)
    private RString 住宅改修_介護給付;
    @TempTableColumnOrder(149)
    private RString 夜間対応型訪問介護;
    @TempTableColumnOrder(150)
    private RString 認知症対応型通所介護;
    @TempTableColumnOrder(151)
    private RString 小規模多機能型居宅介護;
    @TempTableColumnOrder(152)
    private RString 共同生活介護_グループホーム;
    @TempTableColumnOrder(153)
    private RString 地域特定施設入居者生活介護;
    @TempTableColumnOrder(154)
    private RString 老人福祉施設入所者生活介護;
    @TempTableColumnOrder(155)
    private RString 随時対応型訪問介護看護;
    @TempTableColumnOrder(156)
    private RString 複合型サービス;
    @TempTableColumnOrder(157)
    private RString ホームヘルプサービス;
    @TempTableColumnOrder(158)
    private RString 介護予防訪問入浴介護;
    @TempTableColumnOrder(159)
    private RString 介護予防訪問看護;
    @TempTableColumnOrder(160)
    private RString 予防訪問リハビリテーション;
    @TempTableColumnOrder(161)
    private RString 介護予防居宅療養管理指導;
    @TempTableColumnOrder(162)
    private RString 予防通所介護_デイサービス;
    @TempTableColumnOrder(163)
    private RString 予防通所リハビリテーション;
    @TempTableColumnOrder(164)
    private RString 生活介護ショートステイ;
    @TempTableColumnOrder(165)
    private RString 療養介護;
    @TempTableColumnOrder(166)
    private RString 予防特定施設入居者生活介護;
    @TempTableColumnOrder(167)
    private RString 介護予防福祉用具貸与;
    @TempTableColumnOrder(168)
    private RString 特定介護予防福祉用具販売;
    @TempTableColumnOrder(169)
    private RString 住宅改修_予防給付;
    @TempTableColumnOrder(170)
    private RString 通所介護;
    @TempTableColumnOrder(171)
    private RString 予防小規模多機能型居宅介護;
    @TempTableColumnOrder(172)
    private RString 介護予防認知症;
    @TempTableColumnOrder(173)
    private RString 前回識別コード;
    @TempTableColumnOrder(174)
    private RString コメント等;
}
