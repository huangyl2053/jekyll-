/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報テーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Setter
public class ShinseiJouhouCsvEntity implements IShinseiJoho {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
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

    @Override
    public RString getレコード種別() {
        return レコード種別;
    }

    @Override
    public RString getレコード番号() {
        return レコード番号;
    }

    @Override
    public RString getレコード種別コード() {
        return レコード種別コード;
    }

    @Override
    public RString get証記載保険者番号() {
        return 証記載保険者番号;
    }

    @Override
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    @Override
    public RString getサービス提供年月() {
        return サービス提供年月;
    }

    @Override
    public RString get事業所番号() {
        return 事業所番号;
    }

    @Override
    public RString get整理番号() {
        return 整理番号;
    }

    @Override
    public RString get交換情報識別番号() {
        return 交換情報識別番号;
    }

    @Override
    public RString get入力識別番号() {
        return 入力識別番号;
    }

    @Override
    public RString get給付実績情報作成区分コード() {
        return RString.EMPTY;
    }

    @Override
    public RString get給付実績区分コード() {
        return RString.EMPTY;
    }

    @Override
    public RString get警告区分コード() {
        return RString.EMPTY;
    }
}
