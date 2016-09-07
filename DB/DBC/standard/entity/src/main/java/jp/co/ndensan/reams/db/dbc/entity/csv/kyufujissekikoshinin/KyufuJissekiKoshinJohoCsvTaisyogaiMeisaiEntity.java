/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績更新結果情報取込の登録対象レコード以外のCsvMeisaiEntity
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity {
    
    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 50, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 60, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 80, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 90, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 100, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 110, name = "ブランク")
    private RString ブランク;
    
}
