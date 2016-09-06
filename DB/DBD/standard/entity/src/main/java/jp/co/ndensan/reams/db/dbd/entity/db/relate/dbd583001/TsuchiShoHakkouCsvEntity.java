/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 通知書発行対象者一覧csvファイルEntityクラスです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchiShoHakkouCsvEntity {

    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 1, name = "保険者")
    private RString 保険者;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 3, name = "氏名")
    private RString 氏名;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 4, name = "認定申請日")
    private RString 認定申請日;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 5, name = "申請区分（申請時）")
    private RString 申請区分申請時;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 6, name = "申請区分（法令）")
    private RString 申請区分法令;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 7, name = "通知完了日")
    private RString 通知完了日;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 8, name = "認定結果通知書発行日")
    private RString 認定結果通知書発行日;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 9, name = "区分変更通知書発行日")
    private RString 区分変更通知書発行日;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 10, name = "サービス変更通知書発行日")
    private RString サービス変更通知書発行日;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 11, name = "認定却下通知書発行日")
    private RString 認定却下通知書発行日;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 12, name = "認定取消通知書発行日")
    private RString 認定取消通知書発行日;
}
