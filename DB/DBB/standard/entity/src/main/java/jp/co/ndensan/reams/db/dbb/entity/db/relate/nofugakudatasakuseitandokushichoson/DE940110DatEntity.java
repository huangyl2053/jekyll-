/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson;

import jp.co.ndensan.reams.uz.uza.io.fld.Align;
import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他社住民税用固定長ファイル作成CSVEntity
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class DE940110DatEntity {

    @FldField (order = 10, length = 5)
    private RString 市町村コード１;
    @FldField (order = 20, length = 4, align = Align.Left, paddingChar = "0")
    private RString 識別ＩＤ;
    @FldField (order = 30, length = 14)
    private RString タイムスタンプ;
    @FldField (order = 40, length = 1, align = Align.Left, paddingChar = " ")
    private RString 最終レコード区分;
    @FldField (order = 50, length = 7, align = Align.Left, paddingChar = "0")
    private RString 連番;
    @FldField (order = 60, length = 8, align = Align.Left, paddingChar = " ")
    private RString filler;
    @FldField (order = 70, length = 5)
    private RString 市町村コード２;
    @FldField (order = 80, length = 15, align = Align.Left, paddingChar = "0")
    private RString 識別コード;
    @FldField (order = 90, length = 10, align = Align.Left, paddingChar = "0")
    private RString 被保険者番号;
    @FldField (order = 100, length = 4)
    private RString 申告年;
    @FldField (order = 110, length = 8)
    private RString 普通徴収抽出開始日;
    @FldField (order = 120, length = 8)
    private RString 普通徴収抽出終了日;
    @FldField (order = 130, length = 11, align = Align.Left, paddingChar = "0")
    private RString 年間調定額合計;
    @FldField (order = 140, length = 11, align = Align.Left, paddingChar = "0")
    private RString 年間収入額合計;
    @FldField (order = 150, length = 5)
    private RString 特別徴収調定額_１月;
    @FldField (order = 160, length = 5)
    private RString 特別徴収調定額_２月;
    @FldField (order = 170, length = 5)
    private RString 特別徴収調定額_３月;
    @FldField (order = 180, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収調定額_４月;
    @FldField (order = 190, length = 5)
    private RString 特別徴収調定額_５月;
    @FldField (order = 200, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収調定額_６月;
    @FldField (order = 210, length = 5)
    private RString 特別徴収調定額_７月;
    @FldField (order = 220, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収調定額_８月;
    @FldField (order = 230, length = 5)
    private RString 特別徴収調定額_９月;
    @FldField (order = 240, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収調定額_１０月;
    @FldField (order = 250, length = 5)
    private RString 特別徴収調定額_１１月;
    @FldField (order = 260, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収調定額_１２月;
    @FldField (order = 270, length = 5)
    private RString 特別徴収収入額_１月;
    @FldField (order = 280, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収収入額_２月;
    @FldField (order = 290, length = 5)
    private RString 特別徴収収入額_３月;
    @FldField (order = 300, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収収入額_４月;
    @FldField (order = 310, length = 5)
    private RString 特別徴収収入額_５月;
    @FldField (order = 320, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収収入額_６月;
    @FldField (order = 330, length = 5)
    private RString 特別徴収収入額_７月;
    @FldField (order = 340, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収収入額_８月;
    @FldField (order = 350, length = 5)
    private RString 特別徴収収入額_９月;
    @FldField (order = 360, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収収入額_１０月;
    @FldField (order = 370, length = 5)
    private RString 特別徴収収入額_１１月;
    @FldField (order = 380, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収収入額_１２月;
    @FldField (order = 390, length = 5)
    private RString 特別徴収過年度分調定額;
    @FldField (order = 400, length = 5, align = Align.Left, paddingChar = "0")
    private RString 特別徴収過年度分収入額;
    @FldField (order = 410, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_１月;
    @FldField (order = 420, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_２月;
    @FldField (order = 430, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_３月;
    @FldField (order = 440, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_４月;
    @FldField (order = 450, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_５月;
    @FldField (order = 460, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_６月;
    @FldField (order = 470, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_７月;
    @FldField (order = 480, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_８月;
    @FldField (order = 490, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_９月;
    @FldField (order = 500, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_１０月;
    @FldField (order = 510, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_１１月;
    @FldField (order = 520, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収調定額_１２月;
    @FldField (order = 530, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_１月;
    @FldField (order = 540, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_２月;
    @FldField (order = 550, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_３月;
    @FldField (order = 560, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_４月;
    @FldField (order = 570, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_５月;
    @FldField (order = 580, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_６月;
    @FldField (order = 590, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_７月;
    @FldField (order = 600, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_８月;
    @FldField (order = 610, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_９月;
    @FldField (order = 620, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_１０月;
    @FldField (order = 630, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_１１月;
    @FldField (order = 640, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収収入額_１２月;
    @FldField (order = 650, length = 5)
    private RString 普通徴収過年度分調定額;
    @FldField (order = 660, length = 5, align = Align.Left, paddingChar = "0")
    private RString 普通徴収過年度分収入額;
    @FldField (order = 670, length = 1, align = Align.Left, paddingChar = "0")
    private RString 徴収区分;
    @FldField (order = 680, length = 1, align = Align.Left, paddingChar = "0")
    private RString 普通徴収集計日区分;
    @FldField (order = 690, length = 12, align = Align.Left, paddingChar = " ")
    private RString 通知書番号;
    @FldField (order = 700, length = 12, align = Align.Left, paddingChar = " ")
    private RString 予備;
    @FldField (order = 710, length = 14, align = Align.Left, paddingChar = "0")
    private RString 作成日時;

}
