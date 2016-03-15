/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kagoketteikohifutanshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiKohifutanshaInHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiKohifutanshaInMesaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KagoKetteiKohifutanshaInShukeiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoketteiMesaiIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoketteiShukeiIchijiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 */
public class KagoKetteiKohifutanshaInEntityCreater {

    private static final char TRIM_MOJI = '"';

    /**
     * CSVデータより、一時テーブルエンティティを作成する。
     *
     * @param csvHeader CSVデータヘッダ部
     * @param csvMesai CSVデータ明細部
     * @return KagoketteiMesaiIchijiEntity
     */
    public KagoketteiMesaiIchijiEntity createMeisaiEntity(
            KagoKetteiKohifutanshaInHeaderCSVEntity csvHeader,
            KagoKetteiKohifutanshaInMesaiCSVEntity csvMesai) {
        KagoketteiMesaiIchijiEntity entity = new KagoketteiMesaiIchijiEntity();
        entity.set交換情報識別番号(trim囲み文字(csvHeader.get交換情報識別番号()));
        entity.set帳票レコード種別ヘッダ部(trim囲み文字(csvHeader.get帳票レコード種別()));
        entity.set取扱年月(new FlexibleYearMonth(trim囲み文字(csvHeader.get取扱年月())));
        entity.set公費負担者番号(trim囲み文字(csvHeader.get公費負担者番号()));
        entity.set公費負担者名(trim囲み文字(csvHeader.get公費負担者名()));
        entity.set作成年月日(new FlexibleDate(trim囲み文字(csvHeader.get作成年月日())));
        entity.set頁(trim囲み文字(csvHeader.get頁()));
        entity.set国保連合会名(trim囲み文字(csvHeader.get国保連合会名()));
        entity.set帳票レコード種別明細部(trim囲み文字(csvMesai.get帳票レコード種別()));
        entity.set事業所番号(new JigyoshaNo(trim囲み文字(csvMesai.get事業所番号())));
        entity.set事業所名(trim囲み文字(csvMesai.get事業所名()));
        entity.set公費受給者番号(trim囲み文字(csvMesai.get公費受給者番号()));
        entity.set公費受給者氏名(trim囲み文字(csvMesai.get公費受給者氏名()));
        entity.set証記載保険者番号(new HokenshaNo(trim囲み文字(csvMesai.get証記載保険者番号())));
        entity.set証記載保険者名(trim囲み文字(csvMesai.get証記載保険者名()));
        entity.set被保険者番号(new HihokenshaNo(trim囲み文字(csvMesai.get被保険者番号())));
        entity.setサービス提供年月(new FlexibleYearMonth(trim囲み文字(csvMesai.getサービス提供年月())));
        entity.setサービス種類コード(new ServiceShuruiCode(trim囲み文字(csvMesai.getサービス種類コード())));
        entity.setサービス種類名(trim囲み文字(csvMesai.getサービス種類名()));
        entity.set過誤申立事由コード(new Code(trim囲み文字(csvMesai.get過誤申立事由コード())));
        entity.set過誤申立事由(trim囲み文字(csvMesai.get過誤申立事由()));
        entity.set単位数(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get単位数()))));
        entity.set公費負担額(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get公費負担額()))));

        return entity;
    }

    /**
     * CSVデータより、集計一時テーブルエンティティを作成する。
     *
     * @param csvHeader CSVデータヘッダ部
     * @param csvShukei CSVデータ集計部
     * @return KagoketteiShukeiIchijiEntity
     */
    public KagoketteiShukeiIchijiEntity createShukeiEntity(
            KagoKetteiKohifutanshaInHeaderCSVEntity csvHeader,
            KagoKetteiKohifutanshaInShukeiCSVEntity csvShukei) {
        KagoketteiShukeiIchijiEntity entity = new KagoketteiShukeiIchijiEntity();
        entity.set交換情報識別番号(trim囲み文字(csvHeader.get交換情報識別番号()));
        entity.set帳票レコード種別ヘッダ部(trim囲み文字(csvHeader.get帳票レコード種別()));
        entity.set取扱年月(new FlexibleYearMonth(trim囲み文字(csvHeader.get取扱年月())));
        entity.set公費負担者番号(trim囲み文字(csvHeader.get公費負担者番号()));
        entity.set公費負担者名(trim囲み文字(csvHeader.get公費負担者名()));
        entity.set作成年月日(new FlexibleDate(trim囲み文字(csvHeader.get作成年月日())));
        entity.set頁(trim囲み文字(csvHeader.get頁()));
        entity.set国保連合会名(trim囲み文字(csvHeader.get国保連合会名()));
        entity.set帳票レコード種別集計部(trim囲み文字(csvShukei.get帳票レコード種別()));
        entity.set介護給付費の件数(
                changeRStringToInt(trim囲み文字(csvShukei.get介護給付費の件数())));
        entity.set介護給付費の単位数(
                new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費の単位数()))));
        entity.set介護給付費の公費負担額(
                new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費の公費負担額()))));
        entity.set高額介護サービス費の件数(
                changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費の件数())));
        entity.set高額介護サービス費の単位数(
                new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費の単位数()))));
        entity.set高額介護サービス費の公費負担額(
                new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費の公費負担額()))));
        entity.set特定入所者介護サービス費等の件数(
                changeRStringToInt(trim囲み文字(csvShukei.get特定入所者介護サービス費等の件数())));
        entity.set特定入所者介護サービス費等の単位数(
                new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get特定入所者介護サービス費等の費用額()))));
        entity.set特定入所者介護サービス費等の公費負担額(
                new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get特定入所者介護サービス費等の公費負担額()))));

        return entity;
    }

    /**
     * CSVファイルのラインより、ヘッダエンティティ作成
     *
     * @param line データライン
     * @return KagoKetteiKohifutanshaInHeaderCSVEntity
     */
    public KagoKetteiKohifutanshaInHeaderCSVEntity createCsvHeader(List<RString> line) {
        return ListToObjectMappingHelper.toObject(KagoKetteiKohifutanshaInHeaderCSVEntity.class, line);
    }

    /**
     * CSVファイルのラインより、明細エンティティ作成
     *
     * @param line データライン
     * @return KagoKetteiKohifutanshaInMesaiCSVEntity
     */
    public KagoKetteiKohifutanshaInMesaiCSVEntity createCsvMeisai(List<RString> line) {
        return ListToObjectMappingHelper.toObject(KagoKetteiKohifutanshaInMesaiCSVEntity.class, line);
    }

    /**
     * CSVファイルのラインより、集計エンティティ作成
     *
     * @param line データライン
     * @return KagoKetteiKohifutanshaInShukeiCSVEntity
     */
    public KagoKetteiKohifutanshaInShukeiCSVEntity createCsvShukei(List<RString> line) {
        return ListToObjectMappingHelper.toObject(KagoKetteiKohifutanshaInShukeiCSVEntity.class, line);
    }

    private int changeRStringToInt(RString from) {
        if (null != from && !RString.EMPTY.equals(from)) {
            return Integer.parseInt(from.toString());
        }
        return 0;
    }

    /**
     * trim囲み文字
     *
     * @param 対象文字列 対象文字列
     * @return RString
     */
    public RString trim囲み文字(RString 対象文字列) {

        if (null != 対象文字列 && !RString.EMPTY.equals(対象文字列)) {
            return 対象文字列.trim(TRIM_MOJI);
        }

        return RString.EMPTY;
    }
}
