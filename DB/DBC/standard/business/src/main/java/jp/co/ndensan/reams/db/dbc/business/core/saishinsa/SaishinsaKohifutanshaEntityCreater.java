/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsa;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKohifutanshaHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKohifutanshaMesaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.SaishinsaKohifutanshaShukeiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishinsaMesaiIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishinsaShukeiIchijiEntity;
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
 * CSVデータより、エンティティを作成する。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class SaishinsaKohifutanshaEntityCreater {

    private static final char TRIM_MOJI = '"';

    /**
     * CSVデータより、一時テーブルエンティティを作成する。
     *
     * @param csvHeader CSVデータヘッダ部
     * @param csvMesai CSVデータ明細部
     * @return SaishinsaMesaiIchijiEntity
     */
    public SaishinsaMesaiIchijiEntity createMeisaiEntity(
            SaishinsaKohifutanshaHeaderCSVEntity csvHeader,
            SaishinsaKohifutanshaMesaiCSVEntity csvMesai) {

        SaishinsaMesaiIchijiEntity entity = new SaishinsaMesaiIchijiEntity();
        entity.set取扱年月(new FlexibleYearMonth(trim囲み文字(csvHeader.get取扱年月())));
        entity.set履歴番号(csvMesai.get履歴番号());
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
        entity.set再審査申立事由コード(new Code(trim囲み文字(csvMesai.get再審査申立事由コード())));
        entity.set再審査申立事由(csvMesai.get再審査申立事由());
        entity.set再審査結果コード(new Code(trim囲み文字(csvMesai.get再審査結果コード())));
        entity.set当初請求単位数(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get当初請求単位数()))));
        entity.set原番単位数(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get原番単位数()))));
        entity.set申立単位数(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get申立単位数()))));
        entity.set決定単位数(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get決定単位数()))));
        entity.set調整単位数(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get調整単位数()))));
        entity.set公費負担額(new Decimal(changeRStringToInt(trim囲み文字(csvMesai.get公費負担額()))));
        return entity;
    }

    /**
     * CSVデータより、集計一時テーブルエンティティを作成する。
     *
     * @param csvHeader CSVデータヘッダ部
     * @param csvShukei CSVデータ集計部
     * @return SaishinsaShukeiIchijiEntity
     */
    public SaishinsaShukeiIchijiEntity createShukeiEntity(
            SaishinsaKohifutanshaHeaderCSVEntity csvHeader,
            SaishinsaKohifutanshaShukeiCSVEntity csvShukei) {

        SaishinsaShukeiIchijiEntity entity = new SaishinsaShukeiIchijiEntity();
        entity.set取扱年月(new FlexibleYearMonth(trim囲み文字(csvHeader.get取扱年月())));
        entity.set履歴番号(csvShukei.get履歴番号());
        entity.set介護給付費請求件数(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費請求件数())));
        entity.set介護給付費請求単位数(new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費請求単位数()))));
        entity.set介護給付費請求公費負担額(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get介護給付費請求公費負担額()))));
        entity.set介護給付費決定件数(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費決定件数())));
        entity.set介護給付費決定単位数(new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費決定単位数()))));
        entity.set介護給付費決定公費負担額(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get介護給付費決定公費負担額()))));
        entity.set介護給付費調整件数(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費調整件数())));
        entity.set介護給付費調整単位数(new Decimal(changeRStringToInt(trim囲み文字(csvShukei.get介護給付費調整単位数()))));
        entity.set介護給付費調整公費負担額(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get介護給付費調整公費負担額()))));
        entity.set高額介護サービス費請求件数(changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費請求件数())));
        entity.set高額介護サービス費請求単位数(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費請求単位数()))));
        entity.set高額介護サービス費請求公費負担額(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費請求公費負担額()))));
        entity.set高額介護サービス費決定件数(changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費決定件数())));
        entity.set高額介護サービス費決定単位数(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費決定単位数()))));
        entity.set高額介護サービス費決定公費負担額(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費決定公費負担額()))));
        entity.set高額介護サービス費調整件数(changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費調整件数())));
        entity.set高額介護サービス費調整単位数(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費調整単位数()))));
        entity.set高額介護サービス費調整公費負担額(new Decimal(
                changeRStringToInt(trim囲み文字(csvShukei.get高額介護サービス費調整公費負担額()))));
        entity.set公費負担者番号(csvHeader.get公費負担者番号());
        entity.set公費負担者名(csvHeader.get公費負担者名());
        entity.set作成年月日(new FlexibleDate(trim囲み文字(csvHeader.get作成年月日())));
        entity.set国保連合会名(csvHeader.get国保連合会名());
        entity.set審査委員会名(csvHeader.get審査委員会名());
        return entity;
    }

    /**
     * CSVファイルのラインより、ヘッダエンティティ作成
     *
     * @param line データライン
     * @return KohifutanshaHeaderCSVEntity
     */
    public SaishinsaKohifutanshaHeaderCSVEntity createCsvHeader(List<RString> line) {
        return ListToObjectMappingHelper.toObject(SaishinsaKohifutanshaHeaderCSVEntity.class, line);
    }

    /**
     * CSVファイルのラインより、明細エンティティ作成
     *
     * @param line データライン
     * @return KohifutanshaMesaiCSVEntity
     */
    public SaishinsaKohifutanshaMesaiCSVEntity createCsvMeisai(List<RString> line) {
        return ListToObjectMappingHelper.toObject(SaishinsaKohifutanshaMesaiCSVEntity.class, line);
    }

    /**
     * CSVファイルのラインより、集計エンティティ作成
     *
     * @param line データライン
     * @return KohifutanshaShukeiCSVEntity
     */
    public SaishinsaKohifutanshaShukeiCSVEntity createCsvShukei(List<RString> line) {
        return ListToObjectMappingHelper.toObject(SaishinsaKohifutanshaShukeiCSVEntity.class, line);
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
