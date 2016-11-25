/*
 * To change ts license header, choose License Headers in Project Properties.
 * To change ts template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者給付実績台帳 のパラメータクラスです。
 *
 * @reamsid_L DBC-3080-040 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufuJissekidaichoData extends DbTableEntityBase<JukyushaKyufuJissekidaichoData> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempJukyushaKyufuJissekidaichoData"));
    }

    @TempTableColumnOrder(1)
    private RString 保険者コード;
    @TempTableColumnOrder(2)
    private RString 保険者名;
    @TempTableColumnOrder(3)
    private RString ページ数;
    @TempTableColumnOrder(4)
    private RString 被保険者番号;
    @TempTableColumnOrder(5)
    private RString 被保険者毎ページ数;
    @TempTableColumnOrder(6)
    private RString 被保険者毎総ページ数;
    @TempTableColumnOrder(7)
    private RString 被保険者氏名カナ;
    @TempTableColumnOrder(8)
    private RString 実績区分;
    @TempTableColumnOrder(9)
    private RString 生年月日;
    @TempTableColumnOrder(10)
    private RString 性別;
    @TempTableColumnOrder(11)
    private RString 要介護度;
    @TempTableColumnOrder(12)
    private RString 認定有効期間;
    @TempTableColumnOrder(13)
    private RString 証記載保険者番号;
    @TempTableColumnOrder(14)
    private RString 老健市町村番号;
    @TempTableColumnOrder(15)
    private RString 老健受給者番号;
    @TempTableColumnOrder(16)
    private RString 旧措置特例;
    @TempTableColumnOrder(17)
    private RString 警告区分;
    @TempTableColumnOrder(18)
    private RString 審査年月;
    @TempTableColumnOrder(19)
    private RString 被保険者氏名;
    @TempTableColumnOrder(20)
    private RString 住民コード;
    @TempTableColumnOrder(21)
    private RString 住所コード;
    @TempTableColumnOrder(22)
    private RString 行政区コード;
    @TempTableColumnOrder(23)
    private RString サービス提供年月;
    @TempTableColumnOrder(24)
    private RString 後期高齢者資格情報_保険者番号;
    @TempTableColumnOrder(25)
    private RString 後期高齢者資格情報_被保険者番号;
    @TempTableColumnOrder(26)
    private RString 国保資格情報_保険者番号;
    @TempTableColumnOrder(27)
    private RString 国保資格情報_被保険者証番号;
    @TempTableColumnOrder(28)
    private RString 国保資格情報_個人番号;
    @TempTableColumnOrder(29)
    private RString 世帯コード;
    @TempTableColumnOrder(30)
    private RString 住所;
    @TempTableColumnOrder(31)
    private RString 行政区;
    @TempTableColumnOrder(32)
    private RString 決定前_特別療養費請求額_保険lbl;
    @TempTableColumnOrder(33)
    private RString 決定前_特定入所者介護費等請求額_保険lbl;
    @TempTableColumnOrder(34)
    private RString 決定後_特別療養費請求額_保険lbl;
    @TempTableColumnOrder(35)
    private RString 決定後_特定入所者介護費等請求額_保険lbl;
    @TempTableColumnOrder(36)
    private RString 決定前_負担額_保険;
    @TempTableColumnOrder(37)
    private RString サービス計画作成1;
    @TempTableColumnOrder(38)
    private RString 居宅サービス計画事業者;
    @TempTableColumnOrder(39)
    private RString 居宅サービス計画事業者名1;
    @TempTableColumnOrder(40)
    private RString 決定前_ｻｰﾋﾞｽ単位数_保険;
    @TempTableColumnOrder(41)
    private RString 決定前_請求額_保険;
    @TempTableColumnOrder(42)
    private RString 決定前_施設療養費請求額_保険;
    @TempTableColumnOrder(43)
    private RString 決定前_特別療養費請求額_保険;
    @TempTableColumnOrder(44)
    private RString 決定前_特定入所者介護費等請求額_保険;
    @TempTableColumnOrder(45)
    private RString 外泊日数;
    @TempTableColumnOrder(46)
    private RString 整理番号;
    @TempTableColumnOrder(47)
    private RString 入所_院_期間;
    @TempTableColumnOrder(48)
    private RString 入所_院_実日数;
    @TempTableColumnOrder(49)
    private RString 保険_給付率;
    @TempTableColumnOrder(50)
    private RString サービス計画作成2;
    @TempTableColumnOrder(51)
    private RString 居宅サービス計画事業者名2;
    @TempTableColumnOrder(52)
    private RString 決定後_ｻｰﾋﾞｽ単位数_保険;
    @TempTableColumnOrder(53)
    private RString 決定後_請求額_保険;
    @TempTableColumnOrder(54)
    private RString 決定後_負担額_保険;
    @TempTableColumnOrder(55)
    private RString 決定後_施設療養費請求額_保険;
    @TempTableColumnOrder(56)
    private RString 決定後_特別療養費請求額_保険;
    @TempTableColumnOrder(57)
    private RString 決定後_特定入所者介護費等請求額_保険;
    @TempTableColumnOrder(58)
    private RString 決定前_サービス単位数_公費1;
    @TempTableColumnOrder(59)
    private RString 決定前_請求額_公費1;
    @TempTableColumnOrder(60)
    private RString 決定前_負担額_公費1;
    @TempTableColumnOrder(61)
    private RString 決定前_施設療養費請求額_公費1;
    @TempTableColumnOrder(62)
    private RString 決定前_特別療養費請求額_公費1;
    @TempTableColumnOrder(63)
    private RString 決定前_特定入所者介護費等請求額_公費1;
    @TempTableColumnOrder(64)
    private RString 出力様式;
    @TempTableColumnOrder(65)
    private RString 公費受給者_公費1;
    @TempTableColumnOrder(66)
    private RString 給付率_公費1;
    @TempTableColumnOrder(67)
    private RString 公費負担者_公費1;
    @TempTableColumnOrder(68)
    private RString 決定後_サービス単位数_公費1;
    @TempTableColumnOrder(69)
    private RString 決定後_請求額_公費1;
    @TempTableColumnOrder(70)
    private RString 決定後_負担額_公費1;
    @TempTableColumnOrder(71)
    private RString 決定後_施設療養費請求額_公費1;
    @TempTableColumnOrder(72)
    private RString 決定後_特別療養費請求額_公費1;
    @TempTableColumnOrder(73)
    private RString 決定後_特定入所者介護費等請求額_公費1;
    @TempTableColumnOrder(74)
    private RString 決定前_請求額_公費2;
    @TempTableColumnOrder(75)
    private RString 決定前_負担額_公費2;
    @TempTableColumnOrder(76)
    private RString 出力様式1;
    @TempTableColumnOrder(77)
    private RString サービス事業者;
    @TempTableColumnOrder(78)
    private RString 決定前_サービス単位数_公費2;
    @TempTableColumnOrder(79)
    private RString 決定前_施設療養費請求額_公費2;
    @TempTableColumnOrder(80)
    private RString 決定前_特別療養費請求額_公費2;
    @TempTableColumnOrder(81)
    private RString 決定前_特定入所者介護費等請求額_公費2;
    @TempTableColumnOrder(82)
    private RString 公費受給者_公費2;
    @TempTableColumnOrder(83)
    private RString 給付率_公費2;
    @TempTableColumnOrder(84)
    private RString 退所_院_の状態;
    @TempTableColumnOrder(85)
    private RString 公費負担者_公費2;
    @TempTableColumnOrder(86)
    private RString 出力様式2;
    @TempTableColumnOrder(87)
    private RString サービス事業者名;
    @TempTableColumnOrder(88)
    private RString 決定後_サービス単位数_公費2;
    @TempTableColumnOrder(89)
    private RString 決定後_請求額_公費2;
    @TempTableColumnOrder(90)
    private RString 決定後_負担額_公費2;
    @TempTableColumnOrder(91)
    private RString 決定後_施設療養費請求額_公費2;
    @TempTableColumnOrder(92)
    private RString 決定後_特別療養費請求額_公費2;
    @TempTableColumnOrder(93)
    private RString 決定後_特定入所者介護費等請求額_公費2;
    @TempTableColumnOrder(94)
    private RString 決定前_サービス単位数_公費3;
    @TempTableColumnOrder(95)
    private RString 決定前_請求額_公費3;
    @TempTableColumnOrder(96)
    private RString 決定前_負担額_公費3;
    @TempTableColumnOrder(97)
    private RString 決定前_施設療養費請求額_公費3;
    @TempTableColumnOrder(98)
    private RString 決定前_特別療養費請求額_公費3;
    @TempTableColumnOrder(99)
    private RString 決定前_特定入所者介護費等請求額_公費3;
    @TempTableColumnOrder(100)
    private RString 給付率_公費3;
    @TempTableColumnOrder(101)
    private RString サービス期間;
    @TempTableColumnOrder(102)
    private RString 中止理由タイトル;
    @TempTableColumnOrder(103)
    private RString 中止理由;
    @TempTableColumnOrder(104)
    private RString 公費負担者_公費3;
    @TempTableColumnOrder(105)
    private RString 公費受給者_公費3;
    @TempTableColumnOrder(106)
    private RString 決定後_ｻｰﾋﾞｽ単位数_公費3;
    @TempTableColumnOrder(107)
    private RString 決定後_請求額_公費3;
    @TempTableColumnOrder(108)
    private RString 決定後_負担額_公費3;
    @TempTableColumnOrder(109)
    private RString 決定後_施設療養費請求額_公費3;
    @TempTableColumnOrder(110)
    private RString 決定後_特別療養費請求額_公費3;
    @TempTableColumnOrder(111)
    private RString 決定後_特定入所者介護費等請求額_公費3;
    @TempTableColumnOrder(112)
    private RString 決定前_日の回数1;
    @TempTableColumnOrder(113)
    private RString 決定前_サービス単位数1;
    @TempTableColumnOrder(114)
    private RString 決定前_日の回数1_公費1対象;
    @TempTableColumnOrder(115)
    private RString 決定前_サービス単位数1_公費1対象;
    @TempTableColumnOrder(116)
    private RString 決定前_単位数1;
    @TempTableColumnOrder(117)
    private RString 決定前_1日の回数1_公費2対象;
    @TempTableColumnOrder(118)
    private RString 決定前_サービス単位数1_公費2対象;
    @TempTableColumnOrder(119)
    private RString 決定前_日の回数1_公費3対象;
    @TempTableColumnOrder(120)
    private RString 決定前_サービス単位数1_公費3対象;
    @TempTableColumnOrder(121)
    private RString サービスコード1;
    @TempTableColumnOrder(122)
    private RString 過誤回数1_d;
    @TempTableColumnOrder(123)
    private RString サービス内容1;
    @TempTableColumnOrder(124)
    private RString 単位数識別1;
    @TempTableColumnOrder(125)
    private RString 摘要1;
    @TempTableColumnOrder(126)
    private RString 再審査回数1_d;
    @TempTableColumnOrder(127)
    private RString 審査年月1_d;
    @TempTableColumnOrder(128)
    private RString 決定後_単位数1;
    @TempTableColumnOrder(129)
    private RString 決定後_日の回数1;
    @TempTableColumnOrder(130)
    private RString 決定後_サービス単位数1;
    @TempTableColumnOrder(131)
    private RString 決定後_日の回数1_公費1対象;
    @TempTableColumnOrder(132)
    private RString 決定後_サービス単位数1_公費1対象;
    @TempTableColumnOrder(133)
    private RString 決定後_1日の回数1_公費2対象;
    @TempTableColumnOrder(134)
    private RString 決定後_サービス単位数1_公費2対象;
    @TempTableColumnOrder(135)
    private RString 決定後_日の回数1_公費3対象;
    @TempTableColumnOrder(136)
    private RString 決定後_サービス単位数1_公費3対象;
    @TempTableColumnOrder(137)
    private RString 決定前_単位数2;
    @TempTableColumnOrder(138)
    private RString 決定前_日の回数2;
    @TempTableColumnOrder(139)
    private RString 決定前_サービス単位数2;
    @TempTableColumnOrder(140)
    private RString 決定前_日の回数2_公費1対象;
    @TempTableColumnOrder(141)
    private RString 決定前_サービス単位数2_公費1対象;
    @TempTableColumnOrder(142)
    private RString 決定前_日の回数2_公費2対象;
    @TempTableColumnOrder(143)
    private RString 決定前_サービス単位数2_公費2対象;
    @TempTableColumnOrder(144)
    private RString 決定前_日の回数2_公費3対象;
    @TempTableColumnOrder(145)
    private RString 決定前_サービス単位数2_公費3対象;
    @TempTableColumnOrder(146)
    private RString サービスコードﾞ2_d;
    @TempTableColumnOrder(147)
    private RString サービス内容2_d;
    @TempTableColumnOrder(148)
    private RString 摘要2;
    @TempTableColumnOrder(149)
    private RString 再審査回数2_d;
    @TempTableColumnOrder(150)
    private RString 過誤回数2_d;
    @TempTableColumnOrder(151)
    private RString 審査年月2_d;
    @TempTableColumnOrder(152)
    private RString 単位数識別2;
    @TempTableColumnOrder(153)
    private RString 決定後_単位数2;
    @TempTableColumnOrder(154)
    private RString 決定後_日の回数2;
    @TempTableColumnOrder(155)
    private RString 決定後_サービス単位数2;
    @TempTableColumnOrder(156)
    private RString 決定後_日の回数2_公費1対象;
    @TempTableColumnOrder(157)
    private RString 決定後_サービス単位数2_公費1対象;
    @TempTableColumnOrder(158)
    private RString 決定後_日の回数2_公費2対象;
    @TempTableColumnOrder(159)
    private RString 決定後_サービス単位数2_公費2対象;
    @TempTableColumnOrder(160)
    private RString 決定後_日の回数2_公費3対象;
    @TempTableColumnOrder(161)
    private RString 決定後_サービス単位数2_公費3対象;
    @TempTableColumnOrder(162)
    private RString 決定前_単位数3;
    @TempTableColumnOrder(163)
    private RString 決定前_日の回数3;
    @TempTableColumnOrder(164)
    private RString 決定前_サービス単位数3;
    @TempTableColumnOrder(165)
    private RString 決定前_日の回数3_公費1対象;
    @TempTableColumnOrder(166)
    private RString 決定前_サービス単位数3_公費1対象;
    @TempTableColumnOrder(167)
    private RString 決定前_日の回数3_公費2対象;
    @TempTableColumnOrder(168)
    private RString 決定前_サービス単位数3_公費2対象;
    @TempTableColumnOrder(169)
    private RString 決定前_日の回数3_公費3対象;
    @TempTableColumnOrder(170)
    private RString 決定前_サービス単位数3_公費3対象;
    @TempTableColumnOrder(171)
    private RString サービスコードﾞ3_d;
    @TempTableColumnOrder(172)
    private RString 摘要3;
    @TempTableColumnOrder(173)
    private RString 再審査回数3_d;
    @TempTableColumnOrder(174)
    private RString 過誤回数3_d;
    @TempTableColumnOrder(175)
    private RString サービス内容3_d;
    @TempTableColumnOrder(176)
    private RString 単位数識別3;
    @TempTableColumnOrder(177)
    private RString 審査年月3_d;
    @TempTableColumnOrder(178)
    private RString 決定後_日の回数3_公費2対象;
    @TempTableColumnOrder(179)
    private RString 決定後_サービス単位数3_公費3対象;
    @TempTableColumnOrder(180)
    private RString 決定後_単位数3;
    @TempTableColumnOrder(181)
    private RString 決定後_日の回数3;
    @TempTableColumnOrder(182)
    private RString 決定後_サービス単位数3;
    @TempTableColumnOrder(183)
    private RString 決定後_日の回数3_公費1対象;
    @TempTableColumnOrder(184)
    private RString 決定後_サービス単位数3_公費1対象;
    @TempTableColumnOrder(185)
    private RString 決定後_サービス単位数3_公費2対象;
    @TempTableColumnOrder(186)
    private RString 決定後_日の回数3_公費3対象;
    @TempTableColumnOrder(187)
    private RString 決定前_公費1日数1;
    @TempTableColumnOrder(188)
    private RString 決定前_費用額1;
    @TempTableColumnOrder(189)
    private RString サービスコードﾞ1;
    @TempTableColumnOrder(190)
    private RString 決定前_費用単価1;
    @TempTableColumnOrder(191)
    private RString 決定前_日数1;
    @TempTableColumnOrder(192)
    private RString 決定前_公費2日数1;
    @TempTableColumnOrder(193)
    private RString 決定前_公費3日数1;
    @TempTableColumnOrder(194)
    private RString 決定前_保険分請求額1;
    @TempTableColumnOrder(195)
    private RString 決定前_公費1負担額1;
    @TempTableColumnOrder(196)
    private RString 決定前_公費2負担額1;
    @TempTableColumnOrder(197)
    private RString 決定前_公費3負担額1;
    @TempTableColumnOrder(198)
    private RString 決定前_利用者負担額1;
    @TempTableColumnOrder(199)
    private RString 審査年月1_k;
    @TempTableColumnOrder(200)
    private RString 番号1;
    @TempTableColumnOrder(201)
    private RString 負担限度額1;
    @TempTableColumnOrder(202)
    private RString 再審査回数1_k;
    @TempTableColumnOrder(203)
    private RString 過誤回数1_k;
    @TempTableColumnOrder(204)
    private RString 決定後_日数1;
    @TempTableColumnOrder(205)
    private RString 決定後_公費1日数1;
    @TempTableColumnOrder(206)
    private RString サービス内容1_k;
    @TempTableColumnOrder(207)
    private RString 決定後_費用単価1;
    @TempTableColumnOrder(208)
    private RString 決定後_公費2日数1;
    @TempTableColumnOrder(209)
    private RString 決定後_公費3日数1;
    @TempTableColumnOrder(210)
    private RString 決定後_保険分請求額1;
    @TempTableColumnOrder(211)
    private RString 決定後_公費1負担額1;
    @TempTableColumnOrder(212)
    private RString 決定後_公費2負担額1;
    @TempTableColumnOrder(213)
    private RString 決定後_公費3負担額1;
    @TempTableColumnOrder(214)
    private RString 決定後_利用者負担額1;
    @TempTableColumnOrder(215)
    private RString サービスコードﾞ2_k;
    @TempTableColumnOrder(216)
    private RString 決定前_費用単価2;
    @TempTableColumnOrder(217)
    private RString 決定前_日数2;
    @TempTableColumnOrder(218)
    private RString 決定前_公費1日数2;
    @TempTableColumnOrder(219)
    private RString 決定前_公費2日数2;
    @TempTableColumnOrder(220)
    private RString 決定前_公費3日数2;
    @TempTableColumnOrder(221)
    private RString 決定前_費用額2;
    @TempTableColumnOrder(222)
    private RString 決定前_保険分請求額2;
    @TempTableColumnOrder(223)
    private RString 決定前_公費1負担額2;
    @TempTableColumnOrder(224)
    private RString 決定前_公費2負担額2;
    @TempTableColumnOrder(225)
    private RString 決定前_公費3負担額2;
    @TempTableColumnOrder(226)
    private RString 決定前_利用者負担額2;
    @TempTableColumnOrder(227)
    private RString 決定前_費用額合計_合計情報;
    @TempTableColumnOrder(228)
    private RString 決定前_保険分請求額合計_合計情報;
    @TempTableColumnOrder(229)
    private RString 決定前_利用者負担額合計_合計情報;
    @TempTableColumnOrder(230)
    private RString 決定前_費用額合計_合計情報公費2;
    @TempTableColumnOrder(231)
    private RString 決定前_保険分請求額合計_合計情報公費2;
    @TempTableColumnOrder(232)
    private RString 決定前_利用者負担額合計_合計情報公費2;
    @TempTableColumnOrder(233)
    private RString 決定後_費用額1;
    @TempTableColumnOrder(234)
    private RString 審査年月2_k;
    @TempTableColumnOrder(235)
    private RString 番号2;
    @TempTableColumnOrder(236)
    private RString 負担限度額2;
    @TempTableColumnOrder(237)
    private RString 再審査回数2_k;
    @TempTableColumnOrder(238)
    private RString 過誤回数2_k;
    @TempTableColumnOrder(239)
    private RString 決定後_日数2;
    @TempTableColumnOrder(240)
    private RString 決定後_公費1日数2;
    @TempTableColumnOrder(241)
    private RString サービス内容2_k;
    @TempTableColumnOrder(242)
    private RString 決定後_費用単価2;
    @TempTableColumnOrder(243)
    private RString 決定後_公費2日数2;
    @TempTableColumnOrder(244)
    private RString 決定後_公費3日数2;
    @TempTableColumnOrder(245)
    private RString 決定後_費用額2;
    @TempTableColumnOrder(246)
    private RString 決定後_保険分請求額2;
    @TempTableColumnOrder(247)
    private RString 決定後_公費1負担額2;
    @TempTableColumnOrder(248)
    private RString 決定後_公費2負担額2;
    @TempTableColumnOrder(249)
    private RString 決定後_公費3負担額2;
    @TempTableColumnOrder(250)
    private RString 決定後_利用者負担額2;
    @TempTableColumnOrder(251)
    private RString 決定後_費用額合計_合計情報;
    @TempTableColumnOrder(252)
    private RString 決定後_保険分請求額合計_合計情報;
    @TempTableColumnOrder(253)
    private RString 決定後_利用者負担額合計_合計情報;
    @TempTableColumnOrder(254)
    private RString 決定後_費用額合計_合計情報公費2;
    @TempTableColumnOrder(255)
    private RString 決定後_保険分請求額合計_合計情報公費2;
    @TempTableColumnOrder(256)
    private RString 決定後_利用者負担額合計_合計情報公費2;
    @TempTableColumnOrder(257)
    private RString サービスコードﾞ3_k;
    @TempTableColumnOrder(258)
    private RString 決定前_費用単価3;
    @TempTableColumnOrder(259)
    private RString 決定前_日数3;
    @TempTableColumnOrder(260)
    private RString 決定前_公費1日数3;
    @TempTableColumnOrder(261)
    private RString 決定前_公費2日数3;
    @TempTableColumnOrder(262)
    private RString 決定前_公費3日数3;
    @TempTableColumnOrder(263)
    private RString 決定前_費用額3;
    @TempTableColumnOrder(264)
    private RString 決定前_保険分請求額3;
    @TempTableColumnOrder(265)
    private RString 決定前_公費1負担額3;
    @TempTableColumnOrder(266)
    private RString 決定前_公費2負担額3;
    @TempTableColumnOrder(267)
    private RString 決定前_公費3負担額3;
    @TempTableColumnOrder(268)
    private RString 決定前_利用者負担額3;
    @TempTableColumnOrder(269)
    private RString 決定前_費用額合計_合計情報公費1;
    @TempTableColumnOrder(270)
    private RString 決定前_保険分請求額合計_合計情報公費1;
    @TempTableColumnOrder(271)
    private RString 決定前_利用者負担額合計_合計情報公費1;
    @TempTableColumnOrder(272)
    private RString 決定前_費用額合計_合計情報公費3;
    @TempTableColumnOrder(273)
    private RString 決定前_保険分請求額合計_合計情報公費3;
    @TempTableColumnOrder(274)
    private RString 決定前_利用者負担額合計_合計情報公費3;
    @TempTableColumnOrder(275)
    private RString 番号3;
    @TempTableColumnOrder(276)
    private RString 審査年月3_k;
    @TempTableColumnOrder(277)
    private RString 負担限度額3;
    @TempTableColumnOrder(278)
    private RString 再審査回数3_k;
    @TempTableColumnOrder(279)
    private RString 過誤回数3_k;
    @TempTableColumnOrder(280)
    private RString 決定後_公費1日数3;
    @TempTableColumnOrder(281)
    private RString 決定後_公費2日数3;
    @TempTableColumnOrder(282)
    private RString サービス内容3_k;
    @TempTableColumnOrder(283)
    private RString 決定後_費用単価3;
    @TempTableColumnOrder(284)
    private RString 決定後_日数3;
    @TempTableColumnOrder(285)
    private RString 決定後_公費3日数3;
    @TempTableColumnOrder(286)
    private RString 決定後_費用額3;
    @TempTableColumnOrder(287)
    private RString 決定後_保険分請求額3;
    @TempTableColumnOrder(288)
    private RString 決定後_公費1負担額3;
    @TempTableColumnOrder(289)
    private RString 決定後_公費2負担額3;
    @TempTableColumnOrder(290)
    private RString 決定後_公費3負担額3;
    @TempTableColumnOrder(291)
    private RString 決定後_利用者負担額3;
    @TempTableColumnOrder(292)
    private RString 決定後_費用額合計_合計情報公費1;
    @TempTableColumnOrder(293)
    private RString 決定後_保険分請求額合計_合計情報公費1;
    @TempTableColumnOrder(294)
    private RString 決定後_利用者負担額合計_合計情報公費1;
    @TempTableColumnOrder(295)
    private RString 決定後_費用額合計_合計情報公費3;
    @TempTableColumnOrder(296)
    private RString 決定後_保険分請求額合計_合計情報公費3;
    @TempTableColumnOrder(297)
    private RString 決定後_利用者負担額合計_合計情報公費3;
    @TempTableColumnOrder(298)
    private RString 決定後サービス計画日数1;
    @TempTableColumnOrder(299)
    private RString 決定後サービス実施日数1;
    @TempTableColumnOrder(300)
    private RString ヘッダー1;
    @TempTableColumnOrder(301)
    private RString ヘッダー4;
    @TempTableColumnOrder(302)
    private RString ヘッダー2;
    @TempTableColumnOrder(303)
    private RString ヘッダー5;
    @TempTableColumnOrder(304)
    private RString 決定後サービス実施日数2;
    @TempTableColumnOrder(305)
    private RString 決定後サービス計画日数2;
    @TempTableColumnOrder(306)
    private RString ヘッダー3;
    @TempTableColumnOrder(307)
    private RString ヘッダー6;
    @TempTableColumnOrder(308)
    private RString 決定後サービス実施日数3;
    @TempTableColumnOrder(309)
    private RString サービス種類名称1;
    @TempTableColumnOrder(310)
    private RString 記MaeTankiNissu;
    @TempTableColumnOrder(311)
    private RString 明細1;
    @TempTableColumnOrder(312)
    private RString 適用1;
    @TempTableColumnOrder(313)
    private RString ｻｰﾋﾞｽ種類;
    @TempTableColumnOrder(314)
    private RString 限度額管理対象単位数;
    @TempTableColumnOrder(315)
    private RString 限度額管理対象外単位数;
    @TempTableColumnOrder(316)
    private RString サービス実日数;
    @TempTableColumnOrder(317)
    private RString 計画単位数;
    @TempTableColumnOrder(318)
    private RString 短期日数;
    @TempTableColumnOrder(319)
    private RString 明細2;
    @TempTableColumnOrder(320)
    private RString 適用2;
    @TempTableColumnOrder(321)
    private RString サービス種類名称2;
    @TempTableColumnOrder(322)
    private RString 記AtoTankiNissu;
    @TempTableColumnOrder(323)
    private RString 明細3;
    @TempTableColumnOrder(324)
    private RString 適用3;
    @TempTableColumnOrder(325)
    private RString 明細4;
    @TempTableColumnOrder(326)
    private RString 適用4;
    @TempTableColumnOrder(327)
    private RString 明細5;
    @TempTableColumnOrder(328)
    private RString 適用5;
    @TempTableColumnOrder(329)
    private RString 明細6;
    @TempTableColumnOrder(330)
    private RString 適用6;
    @TempTableColumnOrder(331)
    private RString 決定前_単位数合計_保険;
    @TempTableColumnOrder(332)
    private RString 単位数単価_保険;
    @TempTableColumnOrder(333)
    private RString 決定前_請求額_保険_gaku;
    @TempTableColumnOrder(334)
    private RString 負担額_保険;
    @TempTableColumnOrder(335)
    private RString 決定前_出来高医療費単位数合計_保険;
    @TempTableColumnOrder(336)
    private RString 決定前_出来高医療費請求額_保険;
    @TempTableColumnOrder(337)
    private RString 出来高医療費負担額_保険;
    @TempTableColumnOrder(338)
    private RString 明細7;
    @TempTableColumnOrder(339)
    private RString 適用7;
    @TempTableColumnOrder(340)
    private RString 明細8;
    @TempTableColumnOrder(341)
    private RString 適用8;
    @TempTableColumnOrder(342)
    private RString 決定後_出来高医療費単位数合計_保険;
    @TempTableColumnOrder(343)
    private RString 明細9;
    @TempTableColumnOrder(344)
    private RString 決定後_単位数合計_保険;
    @TempTableColumnOrder(345)
    private RString 決定後_請求額_保険_gaku;
    @TempTableColumnOrder(346)
    private RString 決定後_出来高医療費請求額_保険;
    @TempTableColumnOrder(347)
    private RString 適用9;
    @TempTableColumnOrder(348)
    private RString 負担額_公費1;
    @TempTableColumnOrder(349)
    private RString 決定前_出来高医療費単位数合計_公費1;
    @TempTableColumnOrder(350)
    private RString 出来高医療費負担額_公費1;
    @TempTableColumnOrder(351)
    private RString 明細10;
    @TempTableColumnOrder(352)
    private RString 決定前_単位数合計_公費1;
    @TempTableColumnOrder(353)
    private RString 決定前_請求額_公費1_gaku;
    @TempTableColumnOrder(354)
    private RString 決定前_出来高医療費請求額_公費1;
    @TempTableColumnOrder(355)
    private RString 適用10;
    @TempTableColumnOrder(356)
    private RString 明細11;
    @TempTableColumnOrder(357)
    private RString 適用11;
    @TempTableColumnOrder(358)
    private RString 決定後_出来高医療費単位数合計_公費1;
    @TempTableColumnOrder(359)
    private RString 明細12;
    @TempTableColumnOrder(360)
    private RString 決定後_単位数合計_公費1;
    @TempTableColumnOrder(361)
    private RString 決定後_請求額_公費1_gaku;
    @TempTableColumnOrder(362)
    private RString 決定後_出来高医療費請求額_公費1;
    @TempTableColumnOrder(363)
    private RString 適用12;
    @TempTableColumnOrder(364)
    private RString 決定前_単位数合計_公費2;
    @TempTableColumnOrder(365)
    private RString 決定前_請求額_公費2_gaku;
    @TempTableColumnOrder(366)
    private RString 負担額_公費2;
    @TempTableColumnOrder(367)
    private RString 決定前_出来高医療費単位数合計_公費2;
    @TempTableColumnOrder(368)
    private RString 決定前_出来高医療費請求額_公費2;
    @TempTableColumnOrder(369)
    private RString 出来高医療費負担額_公費2;
    @TempTableColumnOrder(370)
    private RString 明細13;
    @TempTableColumnOrder(371)
    private RString 適用13;
    @TempTableColumnOrder(372)
    private RString 明細14;
    @TempTableColumnOrder(373)
    private RString 適用14;
    @TempTableColumnOrder(374)
    private RString 決定後_出来高医療費単位数合計_公費2;
    @TempTableColumnOrder(375)
    private RString 決定後_出来高医療費請求額_公費2;
    @TempTableColumnOrder(376)
    private RString 明細15;
    @TempTableColumnOrder(377)
    private RString 適用15;
    @TempTableColumnOrder(378)
    private RString 決定後_単位数合計_公費2;
    @TempTableColumnOrder(379)
    private RString 決定後_請求額_公費2_gaku;
    @TempTableColumnOrder(380)
    private RString 負担額_公費3;
    @TempTableColumnOrder(381)
    private RString 決定前_出来高医療費単位数合計_公費3;
    @TempTableColumnOrder(382)
    private RString 決定前_出来高医療費請求額_公費3;
    @TempTableColumnOrder(383)
    private RString 出来高医療費負担額_公費3;
    @TempTableColumnOrder(384)
    private RString 明細16;
    @TempTableColumnOrder(385)
    private RString 適用16;
    @TempTableColumnOrder(386)
    private RString 決定前_単位数合計_公費3;
    @TempTableColumnOrder(387)
    private RString 決定前_請求額_公費3_gaku;
    @TempTableColumnOrder(388)
    private RString 明細17;
    @TempTableColumnOrder(389)
    private RString 適用17;
    @TempTableColumnOrder(390)
    private RString 決定後_請求額_公費3_gaku;
    @TempTableColumnOrder(391)
    private RString 決定後_出来高医療費単位数合計_公費3;
    @TempTableColumnOrder(392)
    private RString 決定後_出来高医療費請求額_公費3;
    @TempTableColumnOrder(393)
    private RString 明細18;
    @TempTableColumnOrder(394)
    private RString 適用18;
    @TempTableColumnOrder(395)
    private RString 決定後_単位数合計_公費3;
    @TempTableColumnOrder(396)
    private RString 明細19;
    @TempTableColumnOrder(397)
    private RString 適用19;
    @TempTableColumnOrder(398)
    private RString 再審査回数;
    @TempTableColumnOrder(399)
    private RString 過誤回数;
    @TempTableColumnOrder(400)
    private RString 明細20;
    @TempTableColumnOrder(401)
    private RString 適用20;
    @TempTableColumnOrder(402)
    private RString 審査年月_B;
    @TempTableColumnOrder(403)
    private RString 明細21;
    @TempTableColumnOrder(404)
    private RString 適用21;
    @TempTableColumnOrder(405)
    private RString 発行日時;
    @TempTableColumnOrder(406)
    private RString 市町村コード;
    @TempTableColumnOrder(407)
    private RString 入力識別番号;
    @TempTableColumnOrder(408)
    private RString 事業所番号;

}
