/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績D31一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111DKyufuJissekiD31CsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private KokanShikibetsuNo 交換情報識別番号;
    @CsvField(order = 40, name = "入力識別番号")
    private NyuryokuShikibetsuNo 入力識別番号;
    @CsvField(order = 50, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 60, name = "証記載保険者番号")
    private HokenshaNo 証記載保険者番号;
    @CsvField(order = 70, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 80, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 90, name = "事業所番号")
    private JigyoshaNo 事業所番号;
    @CsvField(order = 100, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 110, name = "特定診療情報レコード順次番号")
    private RString 特定診療情報レコード順次番号;
    @CsvField(order = 120, name = "傷病名")
    private RString 傷病名;
    @CsvField(order = 130, name = "保険_指導管理料等")
    private int 保険_指導管理料等;
    @CsvField(order = 140, name = "保険_単純エックス線")
    private int 保険_単純エックス線;
    @CsvField(order = 150, name = "保険_リハビリテーション")
    private int 保険_リハビリテーション;
    @CsvField(order = 160, name = "保険_精神科専門療法")
    private int 保険_精神科専門療法;
    @CsvField(order = 170, name = "保険_予備1")
    private RString 保険_予備1;
    @CsvField(order = 180, name = "保険_予備2")
    private RString 保険_予備2;
    @CsvField(order = 190, name = "保険_合計単位数")
    private int 保険_合計単位数;
    @CsvField(order = 200, name = "公費１_指導管理料等")
    private int 公費１_指導管理料等;
    @CsvField(order = 210, name = "公費１_単純エックス線")
    private int 公費１_単純エックス線;
    @CsvField(order = 220, name = "公費１_リハビリテーション")
    private int 公費１_リハビリテーション;
    @CsvField(order = 230, name = "公費１_精神科専門療法")
    private int 公費１_精神科専門療法;
    @CsvField(order = 240, name = "公費1_予備1")
    private RString 公費1_予備1;
    @CsvField(order = 250, name = "公費1_予備2")
    private RString 公費1_予備2;
    @CsvField(order = 260, name = "公費１_合計単位数")
    private int 公費１_合計単位数;
    @CsvField(order = 270, name = "公費２_指導管理料等")
    private int 公費２_指導管理料等;
    @CsvField(order = 280, name = "公費２_単純エックス線")
    private int 公費２_単純エックス線;
    @CsvField(order = 290, name = "公費２_リハビリテーション")
    private int 公費２_リハビリテーション;
    @CsvField(order = 300, name = "公費２_精神科専門療法")
    private int 公費２_精神科専門療法;
    @CsvField(order = 310, name = "公費２_予備1")
    private RString 公費２_予備1;
    @CsvField(order = 320, name = "公費２_予備2")
    private RString 公費２_予備2;
    @CsvField(order = 330, name = "公費２_合計単位数")
    private int 公費２_合計単位数;
    @CsvField(order = 340, name = "公費３_指導管理料等")
    private int 公費３_指導管理料等;
    @CsvField(order = 350, name = "公費３_単純エックス線")
    private int 公費３_単純エックス線;
    @CsvField(order = 360, name = "公費３_リハビリテーション")
    private int 公費３_リハビリテーション;
    @CsvField(order = 370, name = "公費３_精神科専門療法")
    private int 公費３_精神科専門療法;
    @CsvField(order = 380, name = "公費３_予備1")
    private RString 公費３_予備1;
    @CsvField(order = 390, name = "公費３_予備2")
    private RString 公費３_予備2;
    @CsvField(order = 400, name = "公費３_合計単位数")
    private int 公費３_合計単位数;
    @CsvField(order = 410, name = "摘要１")
    private RString 摘要1;
    @CsvField(order = 420, name = "摘要２")
    private RString 摘要2;
    @CsvField(order = 430, name = "摘要３")
    private RString 摘要3;
    @CsvField(order = 440, name = "摘要４")
    private RString 摘要4;
    @CsvField(order = 450, name = "摘要５")
    private RString 摘要5;
    @CsvField(order = 460, name = "摘要６")
    private RString 摘要6;
    @CsvField(order = 470, name = "摘要７")
    private RString 摘要7;
    @CsvField(order = 480, name = "摘要８")
    private RString 摘要8;
    @CsvField(order = 490, name = "摘要９")
    private RString 摘要9;
    @CsvField(order = 500, name = "摘要１０")
    private RString 摘要10;
    @CsvField(order = 510, name = "摘要１１")
    private RString 摘要11;
    @CsvField(order = 520, name = "摘要１２")
    private RString 摘要12;
    @CsvField(order = 530, name = "摘要１３")
    private RString 摘要13;
    @CsvField(order = 540, name = "摘要１４")
    private RString 摘要14;
    @CsvField(order = 550, name = "摘要１５")
    private RString 摘要15;
    @CsvField(order = 560, name = "摘要１６")
    private RString 摘要16;
    @CsvField(order = 570, name = "摘要１７")
    private RString 摘要17;
    @CsvField(order = 580, name = "摘要１８")
    private RString 摘要18;
    @CsvField(order = 590, name = "摘要１１")
    private RString 摘要19;
    @CsvField(order = 600, name = "摘要２０")
    private RString 摘要20;
    @CsvField(order = 610, name = "後_保険_指導管理料等")
    private int 後_保険_指導管理料等;
    @CsvField(order = 620, name = "後_保険_単純エックス線")
    private int 後_保険_単純エックス線;
    @CsvField(order = 630, name = "後_保険_リハビリテーション")
    private int 後_保険_リハビリテーション;
    @CsvField(order = 640, name = "後_保険_精神科専門療法")
    private int 後_保険_精神科専門療法;
    @CsvField(order = 650, name = "後_保険_予備1")
    private RString 後_保険_予備1;
    @CsvField(order = 660, name = "後_保険_予備2")
    private RString 後_保険_予備2;
    @CsvField(order = 670, name = "後_公費１_指導管理料等")
    private int 後_公費１_指導管理料等;
    @CsvField(order = 680, name = "後_公費１_単純エックス線")
    private int 後_公費１_単純エックス線;
    @CsvField(order = 690, name = "後_公費１_リハビリテーション")
    private int 後_公費１_リハビリテーション;
    @CsvField(order = 700, name = "後_公費１_精神科専門療法")
    private int 後_公費１_精神科専門療法;
    @CsvField(order = 710, name = "後_公費１_予備1")
    private RString 後_公費１_予備1;
    @CsvField(order = 720, name = "後_公費１_予備2")
    private RString 後_公費１_予備2;
    @CsvField(order = 730, name = "後_公費２_指導管理料等")
    private int 後_公費２_指導管理料等;
    @CsvField(order = 740, name = "後_公費２_単純エックス線")
    private int 後_公費２_単純エックス線;
    @CsvField(order = 750, name = "後_公費２_リハビリテーション")
    private int 後_公費２_リハビリテーション;
    @CsvField(order = 760, name = "後_公費２_精神科専門療法")
    private int 後_公費２_精神科専門療法;
    @CsvField(order = 770, name = "後_公費2_予備1")
    private RString 後_公費2_予備1;
    @CsvField(order = 780, name = "後_公費2_予備2")
    private RString 後_公費2_予備2;
    @CsvField(order = 790, name = "後_公費３_指導管理料等")
    private int 後_公費３_指導管理料等;
    @CsvField(order = 800, name = "後_公費３_単純エックス線")
    private int 後_公費３_単純エックス線;
    @CsvField(order = 810, name = "後_公費３_リハビリテーション")
    private int 後_公費３_リハビリテーション;
    @CsvField(order = 820, name = "後_公費３_精神科専門療法")
    private int 後_公費３_精神科専門療法;
    @CsvField(order = 830, name = "後_公費3_予備1")
    private RString 後_公費3_予備1;
    @CsvField(order = 840, name = "後_公費3_予備2")
    private RString 後_公費3_予備2;
    @CsvField(order = 850, name = "再審査回数")
    private int 再審査回数;
    @CsvField(order = 860, name = "過誤回数")
    private int 過誤回数;
    @CsvField(order = 870, name = "審査年月")
    private FlexibleYearMonth 審査年月;

}
