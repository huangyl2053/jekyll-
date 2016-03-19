/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付対象者headCsvField
 */
@Getter
@Setter
public class DbTKogakuKyufuCSVDataHeadEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;
    @CsvField(order = 40, name = "保険者番号")
    private RString hokenshaNo;
    @CsvField(order = 50, name = "保険者名")
    private RString hihokenshaName;
    @CsvField(order = 60, name = "作成年月日")
    private RString sakuseiYMD;
    @CsvField(order = 70, name = "国保連合会名")
    private RString kokukoRengoukaiNa;

    public boolean equals(DbTKogakuKyufuCSVDataHeadEntity entity) {
        return this.toERString().equals(entity.toERString());
    }

    private RString toERString() {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(null == kokanShikibetsuNo ? RString.EMPTY : kokanShikibetsuNo)
                .append(null == chouhyouCodeShubetsu ? RString.EMPTY : chouhyouCodeShubetsu)
                .append(null == shoKisaiHokenshaNo ? RString.EMPTY : shoKisaiHokenshaNo)
                .append(null == hokenshaNo ? RString.EMPTY : hokenshaNo)
                .append(null == hihokenshaName ? RString.EMPTY : hihokenshaName)
                .append(null == sakuseiYMD ? RString.EMPTY : sakuseiYMD)
                .append(null == kokukoRengoukaiNa ? RString.EMPTY : kokukoRengoukaiNa)
                .toRString();
    }
}
