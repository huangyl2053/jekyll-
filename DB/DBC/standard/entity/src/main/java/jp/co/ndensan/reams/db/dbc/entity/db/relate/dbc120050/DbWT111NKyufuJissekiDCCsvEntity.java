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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績DC一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111NKyufuJissekiDCCsvEntity {

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
    @CsvField(order = 110, name = "緊急時施設療養情報レコード順次番号")
    private RString 緊急時施設療養情報レコード順次番号;
    @CsvField(order = 120, name = "緊急時傷病名１")
    private RString 緊急時傷病名１;
    @CsvField(order = 130, name = "緊急時傷病名２")
    private RString 緊急時傷病名２;
    @CsvField(order = 140, name = "緊急時傷病名３")
    private RString 緊急時傷病名３;
    @CsvField(order = 150, name = "緊急時治療開始年月日１")
    private FlexibleDate 緊急時治療開始年月日１;
    @CsvField(order = 160, name = "緊急時治療開始年月日２")
    private FlexibleDate 緊急時治療開始年月日２;
    @CsvField(order = 170, name = "緊急時治療開始年月日３")
    private FlexibleDate 緊急時治療開始年月日３;
    @CsvField(order = 180, name = "往診日数")
    private int 往診日数;
    @CsvField(order = 190, name = "往診医療機関名")
    private RString 往診医療機関名;
    @CsvField(order = 200, name = "通院日数")
    private int 通院日数;
    @CsvField(order = 210, name = "通院医療機関名")
    private RString 通院医療機関名;
    @CsvField(order = 220, name = "緊急時治療管理単位数")
    private int 緊急時治療管理単位数;
    @CsvField(order = 230, name = "緊急時治療管理日数")
    private int 緊急時治療管理日数;
    @CsvField(order = 240, name = "緊急時治療管理小計")
    private int 緊急時治療管理小計;
    @CsvField(order = 250, name = "リハビリテーション点数")
    private int リハビリテーション点数;
    @CsvField(order = 260, name = "処置点数")
    private int 処置点数;
    @CsvField(order = 270, name = "手術点数")
    private int 手術点数;
    @CsvField(order = 280, name = "麻酔点数")
    private int 麻酔点数;
    @CsvField(order = 290, name = "放射線治療点数")
    private int 放射線治療点数;
    @CsvField(order = 300, name = "摘要１")
    private RString 摘要１;
    @CsvField(order = 310, name = "摘要2")
    private RString 摘要2;
    @CsvField(order = 320, name = "摘要３")
    private RString 摘要３;
    @CsvField(order = 330, name = "摘要４")
    private RString 摘要４;
    @CsvField(order = 340, name = "摘要５")
    private RString 摘要５;
    @CsvField(order = 350, name = "摘要６")
    private RString 摘要６;
    @CsvField(order = 360, name = "摘要７")
    private RString 摘要７;
    @CsvField(order = 370, name = "摘要８")
    private RString 摘要８;
    @CsvField(order = 380, name = "摘要９")
    private RString 摘要９;
    @CsvField(order = 390, name = "摘要10")
    private RString 摘要10;
    @CsvField(order = 400, name = "摘要11")
    private RString 摘要11;
    @CsvField(order = 410, name = "摘要12")
    private RString 摘要12;
    @CsvField(order = 420, name = "摘要13")
    private RString 摘要13;
    @CsvField(order = 430, name = "摘要14")
    private RString 摘要14;
    @CsvField(order = 440, name = "摘要15")
    private RString 摘要15;
    @CsvField(order = 450, name = "摘要16")
    private RString 摘要16;
    @CsvField(order = 460, name = "摘要17")
    private RString 摘要17;
    @CsvField(order = 470, name = "摘要18")
    private RString 摘要18;
    @CsvField(order = 480, name = "摘要19")
    private RString 摘要19;
    @CsvField(order = 490, name = "摘要20")
    private RString 摘要20;
    @CsvField(order = 500, name = "緊急時施設療養費合計点数")
    private int 緊急時施設療養費合計点数;
    @CsvField(order = 510, name = "所定疾患施設療養費傷病名１")
    private RString 所定疾患施設療養費傷病名１;
    @CsvField(order = 520, name = "所定疾患施設療養費傷病名２")
    private RString 所定疾患施設療養費傷病名２;
    @CsvField(order = 530, name = "所定疾患施設療養費傷病名３")
    private RString 所定疾患施設療養費傷病名３;
    @CsvField(order = 540, name = "所定疾患施設療養費開始年月日１")
    private FlexibleDate 所定疾患施設療養費開始年月日１;
    @CsvField(order = 550, name = "所定疾患施設療養費開始年月日２")
    private FlexibleDate 所定疾患施設療養費開始年月日２;
    @CsvField(order = 560, name = "所定疾患施設療養費開始年月日３")
    private FlexibleDate 所定疾患施設療養費開始年月日３;
    @CsvField(order = 570, name = "所定疾患施設療養費単位数")
    private int 所定疾患施設療養費単位数;
    @CsvField(order = 580, name = "所定疾患施設療養費日数")
    private int 所定疾患施設療養費日数;
    @CsvField(order = 590, name = "所定疾患施設療養費小計")
    private int 所定疾患施設療養費小計;
    @CsvField(order = 600, name = "後_往診日数")
    private int 後_往診日数;
    @CsvField(order = 610, name = "後_通院日数")
    private int 後_通院日数;
    @CsvField(order = 620, name = "後_緊急時治療管理単位数")
    private int 後_緊急時治療管理単位数;
    @CsvField(order = 630, name = "後_緊急時治療管理日数")
    private int 後_緊急時治療管理日数;
    @CsvField(order = 640, name = "後_リハビリテーション点数")
    private int 後_リハビリテーション点数;
    @CsvField(order = 650, name = "後_処置点数")
    private int 後_処置点数;
    @CsvField(order = 660, name = "後_手術点数")
    private int 後_手術点数;
    @CsvField(order = 670, name = "後_麻酔点数")
    private int 後_麻酔点数;
    @CsvField(order = 680, name = "後_放射線治療点数")
    private int 後_放射線治療点数;
    @CsvField(order = 690, name = "後_所定疾患施設療養費単位数")
    private int 後_所定疾患施設療養費単位数;
    @CsvField(order = 700, name = "後_所定疾患施設療養費日数")
    private int 後_所定疾患施設療養費日数;
    @CsvField(order = 710, name = "再審査回数")
    private int 再審査回数;
    @CsvField(order = 720, name = "過誤回数")
    private int 過誤回数;
    @CsvField(order = 730, name = "審査年月")
    private FlexibleYearMonth 審査年月;
}
