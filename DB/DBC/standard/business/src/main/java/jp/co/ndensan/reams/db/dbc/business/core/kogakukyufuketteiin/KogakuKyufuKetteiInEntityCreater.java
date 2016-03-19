/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukyufuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.KogakuKyufuKetteiInHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KogakuKyufuKetteiInMeisaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiShukeiIchijiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額サービス費決定情報一時TBLの登録
 */
public class KogakuKyufuKetteiInEntityCreater {

    private static final char TRIM_MOJI = '"';

    /**
     * createMeisaiEntityのメソっド
     *
     * @param csvHeader KogakuKyufuKetteiInHeaderCSVEntity
     * @param csvMesai KogakuKyufuKetteiInMeisaiCSVEntity
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    public KogakuKyufuKetteiInTempTableEntity createMeisaiEntity(
            KogakuKyufuKetteiInHeaderCSVEntity csvHeader,
            KogakuKyufuKetteiInMeisaiCSVEntity csvMesai) {
        KogakuKyufuKetteiInTempTableEntity entity = new KogakuKyufuKetteiInTempTableEntity();
        entity.set交換情報識別番号(trim囲み文字(csvHeader.get交換情報識別番号()));
        entity.set帳票レコード種別ヘッダ(trim囲み文字(csvHeader.get帳票レコード種別ヘッダ()));
        entity.set証記載保険者番号(new HokenshaNo(trim囲み文字(csvHeader.get証記載保険者番号())));
        entity.set保険者名(trim囲み文字(csvHeader.get保険者名()));
        entity.set作成年月日(new FlexibleDate(trim囲み文字(csvHeader.get作成年月日())));
        entity.set国保連合会名(trim囲み文字(csvHeader.get国保連合会名()));

        entity.set帳票レコード種別(trim囲み文字(csvMesai.get帳票レコード種別()));
        entity.setNo(Integer.parseInt(trim囲み文字(csvMesai.getNo()).toString()));
        entity.set被保険者番号(new HihokenshaNo(trim囲み文字(csvMesai.get被保険者番号())));
        entity.set被保険者氏名漢字(new AtenaMeisho(trim囲み文字(csvMesai.get被保険者氏名())));
        entity.setサービス提供年月(new FlexibleYearMonth(trim囲み文字(csvMesai.getサービス提供年月())));
        entity.set利用者負担額(new Decimal(trim囲み文字(csvMesai.get利用者負担額()).toString()));
        entity.set支給区分コード(trim囲み文字(csvMesai.get支給区分コード()));
        entity.set決定年月(new FlexibleYearMonth(trim囲み文字(csvMesai.get決定年月())));
        entity.set高額支給額(new Decimal(trim囲み文字(csvMesai.get高額支給額()).toString()));
        entity.set支払方法区分コード(trim囲み文字(csvMesai.get支払方法区分コード()));
        entity.set支払場所(trim囲み文字(csvMesai.get支払場所()));
        entity.set開始年月日(new FlexibleDate(trim囲み文字(csvMesai.get開始年月日())));
        entity.set終了年月日(new FlexibleDate(trim囲み文字(csvMesai.get終了年月日())));
        entity.set開始曜日(trim囲み文字(csvMesai.get開始曜日()));
        entity.set終了曜日(trim囲み文字(csvMesai.get終了曜日()));
        entity.set開始時間(trim囲み文字(csvMesai.get開始時間()));
        entity.set終了時間(trim囲み文字(csvMesai.get終了時間()));
        entity.set金融機関コード(new KinyuKikanCode(trim囲み文字(csvMesai.get金融機関コード())));
        entity.set金融機関名(trim囲み文字(csvMesai.get金融機関名()));
        entity.set金融機関支店コード(new KinyuKikanShitenCode(trim囲み文字(csvMesai.get金融機関支店コード())));
        entity.set金融機関支店名(trim囲み文字(csvMesai.get金融機関支店名()));
        entity.set口座種目(trim囲み文字(csvMesai.get口座種目()));
        entity.set口座種目名(trim囲み文字(csvMesai.get口座種目()));
        entity.set口座番号(trim囲み文字(csvMesai.get口座番号()));
        entity.set口座名義人カナ(new AtenaKanaMeisho(trim囲み文字(csvMesai.get口座名義人カナ())));
        entity.set識別コード(null);
        entity.set資格喪失事由(null);
        entity.set資格喪失年月日(null);
        entity.set全国住所コード(null);
        entity.set住所(null);
        entity.set行政区コード(null);
        entity.set行政区(null);
        entity.set氏名カナ(null);
        entity.set氏名(null);
        return entity;
    }

    /**
     * CSVファイルのラインより、ヘッダエンティティ作成
     *
     * @param line データライン
     * @return KagoKetteiKohifutanshaInHeaderCSVEntity
     */
    public KogakuKyufuKetteiInHeaderCSVEntity createCsvHeader(List<RString> line) {
        return ListToObjectMappingHelper.toObject(KogakuKyufuKetteiInHeaderCSVEntity.class, line);
    }

    /**
     * CSVファイルのラインより、明細エンティティ作成
     *
     * @param line データライン
     * @return KagoKetteiKohifutanshaInMesaiCSVEntity
     */
    public KogakuKyufuKetteiInMeisaiCSVEntity createCsvMeisai(List<RString> line) {
        return ListToObjectMappingHelper.toObject(KogakuKyufuKetteiInMeisaiCSVEntity.class, line);
    }

    /**
     * CSVファイルのラインより、集計エンティティ作成
     *
     * @param line データライン
     * @return KagoKetteiKohifutanshaInShukeiCSVEntity
     */
    public KogakuKyufuKetteiShukeiIchijiEntity createCsvShukei(List<RString> line) {
        return ListToObjectMappingHelper.toObject(KogakuKyufuKetteiShukeiIchijiEntity.class, line);
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
