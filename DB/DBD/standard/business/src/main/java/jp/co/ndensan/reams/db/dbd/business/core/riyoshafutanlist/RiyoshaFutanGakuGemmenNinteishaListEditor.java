/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanlist;

import jp.co.ndensan.reams.db.dbd.definition.core.convertparameter.TorikomiRecordPunctuation;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.TorikomiCsvDataEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.temptable.TorikomiTempTableEntity;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 取込データ一時作成の編集処理です。
 *
 * @reamsid_L DBD-4910-030 x_youyj
 */
public class RiyoshaFutanGakuGemmenNinteishaListEditor {

    /**
     * データレコードEntityの取得します.
     *
     * @param record record
     * @param レコード区分 レコード区分
     * @return TorikomiTempTableEntity
     */
    public TorikomiCsvDataEntity getDataRecordEntity(RString record, RString レコード区分) {
        TorikomiCsvDataEntity dataRecordEntity = new TorikomiCsvDataEntity();
        dataRecordEntity.setレコード区分(レコード区分);
        dataRecordEntity.set市町村コード(record.substringEmptyOnError(TorikomiRecordPunctuation.市町村コード.get開始位置(),
                TorikomiRecordPunctuation.市町村コード.get終了位置()).trim());
        dataRecordEntity.set年金保険者コード(record.substringEmptyOnError(TorikomiRecordPunctuation.年金保険者コード.get開始位置(),
                TorikomiRecordPunctuation.年金保険者コード.get終了位置()).trim());
        dataRecordEntity.set通知内容コード(record.substringEmptyOnError(TorikomiRecordPunctuation.通知内容コード.get開始位置(),
                TorikomiRecordPunctuation.通知内容コード.get終了位置()).trim());
        dataRecordEntity.set予備1(record.substringEmptyOnError(TorikomiRecordPunctuation.予備1.get開始位置(),
                TorikomiRecordPunctuation.予備1.get終了位置()).trim());
        dataRecordEntity.set制度コード(record.substringEmptyOnError(TorikomiRecordPunctuation.制度コード.get開始位置(),
                TorikomiRecordPunctuation.制度コード.get終了位置()).trim());
        dataRecordEntity.set作成年月日(toFlexibleDate(record.substringEmptyOnError(TorikomiRecordPunctuation.作成年月日.get開始位置(),
                TorikomiRecordPunctuation.作成年月日.get終了位置()).trim()));
        dataRecordEntity.set基礎年金番号(record.substringEmptyOnError(TorikomiRecordPunctuation.基礎年金番号.get開始位置(),
                TorikomiRecordPunctuation.基礎年金番号.get終了位置()).trim());
        dataRecordEntity.set年金コード(record.substringEmptyOnError(TorikomiRecordPunctuation.年金コード.get開始位置(),
                TorikomiRecordPunctuation.年金コード.get終了位置()).trim());
        dataRecordEntity.set予備2(record.substringEmptyOnError(TorikomiRecordPunctuation.予備2.get開始位置(),
                TorikomiRecordPunctuation.予備2.get終了位置()).trim());
        dataRecordEntity.set生年月日(toFlexibleDate(record.substringEmptyOnError(TorikomiRecordPunctuation.生年月日.get開始位置(),
                TorikomiRecordPunctuation.生年月日.get終了位置())));
        dataRecordEntity.set性別(record.substringEmptyOnError(TorikomiRecordPunctuation.性別.get開始位置(),
                TorikomiRecordPunctuation.性別.get終了位置()).trim());
        dataRecordEntity.setカナ氏名(record.substringEmptyOnError(TorikomiRecordPunctuation.カナ氏名.get開始位置(),
                TorikomiRecordPunctuation.カナ氏名.get終了位置()).trim());
        dataRecordEntity.set漢字氏名(record.substringEmptyOnError(TorikomiRecordPunctuation.漢字氏名.get開始位置(),
                TorikomiRecordPunctuation.漢字氏名.get終了位置()).trim());
        dataRecordEntity.set郵便番号(toYubinNo(record.substringEmptyOnError(TorikomiRecordPunctuation.郵便番号.get開始位置(),
                TorikomiRecordPunctuation.郵便番号.get終了位置()).trim()));
        dataRecordEntity.setカナ住所(record.substringEmptyOnError(TorikomiRecordPunctuation.カナ住所.get開始位置(),
                TorikomiRecordPunctuation.カナ住所.get終了位置()).trim());
        dataRecordEntity.set漢字住所(record.substringEmptyOnError(TorikomiRecordPunctuation.漢字住所.get開始位置(),
                TorikomiRecordPunctuation.漢字住所.get終了位置()).trim());
        dataRecordEntity.set対象年(toFlexibleYear(record.substringEmptyOnError(TorikomiRecordPunctuation.対象年.get開始位置(),
                TorikomiRecordPunctuation.対象年.get終了位置()).trim()));
        dataRecordEntity.set訂正表示(record.substringEmptyOnError(TorikomiRecordPunctuation.訂正表示.get開始位置(),
                TorikomiRecordPunctuation.訂正表示.get終了位置()).trim());
        dataRecordEntity.set各種区分(record.substringEmptyOnError(TorikomiRecordPunctuation.各種区分.get開始位置(),
                TorikomiRecordPunctuation.各種区分.get終了位置()).trim());
        dataRecordEntity.set処理結果(record.substringEmptyOnError(TorikomiRecordPunctuation.処理結果.get開始位置(),
                TorikomiRecordPunctuation.処理結果.get終了位置()).trim());
        dataRecordEntity.set予備3(record.substringEmptyOnError(TorikomiRecordPunctuation.予備3.get開始位置(),
                TorikomiRecordPunctuation.予備3.get終了位置()).trim());
        dataRecordEntity.set予備4(record.substringEmptyOnError(TorikomiRecordPunctuation.予備4.get開始位置(),
                TorikomiRecordPunctuation.予備4.get終了位置()));
        dataRecordEntity.set金額１(toDecimal(record.substringEmptyOnError(TorikomiRecordPunctuation.金額１.get開始位置(),
                TorikomiRecordPunctuation.金額１.get終了位置())));
        dataRecordEntity.set金額予備1(toDecimal(record.substringEmptyOnError(TorikomiRecordPunctuation.金額予備1.get開始位置(),
                TorikomiRecordPunctuation.金額予備1.get終了位置())));
        dataRecordEntity.set金額予備2(toDecimal(record.substringEmptyOnError(TorikomiRecordPunctuation.金額予備2.get開始位置(),
                TorikomiRecordPunctuation.金額予備2.get終了位置())));
        dataRecordEntity.set予備5(record.substringEmptyOnError(TorikomiRecordPunctuation.予備5.get開始位置(),
                TorikomiRecordPunctuation.予備5.get終了位置()).trim());
        dataRecordEntity.set共済年金証書記号番号(record.substringEmptyOnError(TorikomiRecordPunctuation.共済年金証書記号番号.get開始位置(),
                TorikomiRecordPunctuation.共済年金証書記号番号.get終了位置()).trim());
        return dataRecordEntity;

    }

    /**
     * データレコードTempEntityの取得します。
     *
     * @param dataRecordEntity dataRecordEntity
     * @return TorikomiTempTableEntity
     */
    public TorikomiTempTableEntity getDataRecordTempEntity(TorikomiCsvDataEntity dataRecordEntity) {
        TorikomiTempTableEntity tmpEntity = new TorikomiTempTableEntity();
        tmpEntity.setDtrekodoKubun(dataRecordEntity.getレコード区分());
        tmpEntity.setDtshichosonCode(dataRecordEntity.get市町村コード());
        tmpEntity.setDtnennkinnHokennshaCode(dataRecordEntity.get年金保険者コード());
        tmpEntity.setDttsuuchiContentCode(dataRecordEntity.get通知内容コード());
        tmpEntity.setDtyobi1(dataRecordEntity.get予備1());
        tmpEntity.setDtseidoCode(dataRecordEntity.get制度コード());
        tmpEntity.setDtcreateYMD(dataRecordEntity.get作成年月日());
        tmpEntity.setDtnennkinnNo(dataRecordEntity.get基礎年金番号());
        tmpEntity.setDtnennkinnCode(dataRecordEntity.get年金コード());
        tmpEntity.setDtyobi2(dataRecordEntity.get予備2());
        tmpEntity.setDtseinenngappi(dataRecordEntity.get生年月日());
        tmpEntity.setDtseibetsu(dataRecordEntity.get性別());
        tmpEntity.setDtkanaShimei(dataRecordEntity.getカナ氏名());
        tmpEntity.setDtshifutoCode1(dataRecordEntity.getシフトコード1());
        tmpEntity.setDtkanjiShimei(dataRecordEntity.get漢字氏名());
        tmpEntity.setDtshifutoCode2(dataRecordEntity.getシフトコード2());
        tmpEntity.setDtYubinNo(dataRecordEntity.get郵便番号());
        tmpEntity.setDtkanaJusyo(dataRecordEntity.getカナ住所());
        tmpEntity.setDtshifutoCode3(dataRecordEntity.getシフトコード3());
        tmpEntity.setDtkanjiJusyo(dataRecordEntity.get漢字住所());
        tmpEntity.setDtshifutoCode4(dataRecordEntity.getシフトコード4());
        tmpEntity.setDtTaishoYear(dataRecordEntity.get対象年());
        tmpEntity.setDtteiseiHyouji(dataRecordEntity.get訂正表示());
        tmpEntity.setDtkakushuKubun(dataRecordEntity.get各種区分());
        tmpEntity.setDtshoriResult(dataRecordEntity.get処理結果());
        tmpEntity.setDtyobi3(dataRecordEntity.get予備3());
        tmpEntity.setDtyobi4(dataRecordEntity.get予備4());
        tmpEntity.setDtkinngaku1(dataRecordEntity.get金額１());
        tmpEntity.setDtkinngakuYobi1(dataRecordEntity.get金額予備1());
        tmpEntity.setDtkinngakuYobi2(dataRecordEntity.get金額予備2());
        tmpEntity.setDtyobi5(dataRecordEntity.get予備5());
        tmpEntity.setDtkyousaiNennkinnShoushoKigouNo(dataRecordEntity.get共済年金証書記号番号());
        return tmpEntity;
    }

    private FlexibleDate toFlexibleDate(RString dateString) {
        if (dateString != null && !dateString.trim().isEmpty()) {
            return new FlexibleDate(dateString);
        } else {
            return FlexibleDate.EMPTY;
        }
    }

    private Decimal toDecimal(RString decimalString) {
        if (decimalString != null && !decimalString.trim().isEmpty()) {
            return new Decimal(decimalString.trim().toString());
        } else {
            return Decimal.ZERO;
        }
    }

    private FlexibleYear toFlexibleYear(RString decimalString) {
        if (decimalString != null && !decimalString.trim().isEmpty()) {
            return new FlexibleYear(decimalString.trim().toString());
        } else {
            return FlexibleYear.EMPTY;
        }
    }

    private YubinNo toYubinNo(RString decimalString) {
        if (decimalString != null && !decimalString.trim().isEmpty()) {
            return new YubinNo(decimalString.trim().toString());
        } else {
            return YubinNo.EMPTY;
        }
    }
}
