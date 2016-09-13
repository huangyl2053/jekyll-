///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin;
//
//import java.util.List;
//import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
//import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanFushikyuKetteiInHeaderCSVEntity;
//import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanFushikyuKetteiInMeisaiCSVEntity;
//import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
//import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;
//
///**
// * CSVデータより、償還払不支給決定情報一時テーブルエンティティを作成する。
// *
// * @reamsid_L DBC-2590-010 xuhao
// */
//public class ShokanFushikyuKetteiInEntityCreater {
//
//    private static final char TRIM_MOJI = '"';
//
//    /**
//     * CSVデータより、償還払不支給決定情報一時テーブルエンティティを作成する。
//     *
//     * @param csvHeader CSVデータヘッダ部
//     * @param csvMesai CSVデータ明細部
//     * @return ShokanFushikyuKetteiInEntity
//     */
//    public ShokanFushikyuKetteiInEntity createFushikyuEntity(
//            ShokanFushikyuKetteiInHeaderCSVEntity csvHeader,
//            ShokanFushikyuKetteiInMeisaiCSVEntity csvMesai) {
//        ShokanFushikyuKetteiInEntity entity = new ShokanFushikyuKetteiInEntity();
//        entity.setKokanShikibetsuNo(trim囲み文字(csvHeader.get交換情報識別番号()));
//        entity.setRecordTypeHeader(trim囲み文字(csvHeader.get帳票レコード種別()));
//        entity.setShokisaiHokenshaNo(new ShoKisaiHokenshaNo(trim囲み文字(csvHeader.get証記載保険者番号())));
//        entity.setHokenshaName(trim囲み文字(csvHeader.get保険者名()));
//        entity.setSakuseiYMD(new FlexibleDate(trim囲み文字(csvHeader.get作成年月日())));
//        entity.setKokuhoRenkokaiName(trim囲み文字(csvHeader.get国保連合会名()));
//        entity.setRecordTypeMesai(trim囲み文字(csvMesai.get帳票レコード種別()));
//        entity.setNo(trim囲み文字(csvMesai.getNo()));
//        entity.setSeiriNo(trim囲み文字(csvMesai.get整理番号()));
//        entity.setHiHokenshaNo(new HihokenshaNo(trim囲み文字(csvMesai.get被保険者番号())));
//        entity.setHiHokenshaName(trim囲み文字(csvMesai.get被保険者氏名_漢字()));
//        entity.setServiceTeikyoYM(new FlexibleYearMonth(trim囲み文字(csvMesai.getサービス提供年月())));
//        entity.setJigyoshoNo(new JigyoshaNo(trim囲み文字(csvMesai.get事業所番号())));
//        entity.setJigyoshoName(trim囲み文字(csvMesai.get事業所名_漢字()));
//        entity.setServiceShuruiCode(new ServiceShuruiCode(trim囲み文字(csvMesai.getサービス種類コード())));
//        entity.setServiceShuruiName(trim囲み文字(csvMesai.getサービス種類名()));
//        entity.setTensuKingaku(new Decimal(trim囲み文字(csvMesai.get単位数_金額()).toString()));
//        entity.setBikoOne(trim囲み文字(csvMesai.get備考１()));
//        entity.setBikoTwo(trim囲み文字(csvMesai.get備考２()));
//        entity.setIsUpdate(false);
//        entity.setShikyuKubunCode(ShikyuFushikyuKubun.不支給.getコード());
//        return entity;
//
//    }
//
//    /**
//     * ヘッダレコードの項目
//     *
//     * @param line CSVの一行データ。
//     * @return 償還払不支給決定情報取込のヘッダ部。
//     */
//    public ShokanFushikyuKetteiInHeaderCSVEntity createCsvHeader(List<RString> line) {
//        return ListToObjectMappingHelper.toObject(ShokanFushikyuKetteiInHeaderCSVEntity.class, line);
//    }
//
//    /**
//     * 明細レコードの項目
//     *
//     * @param line CSVの一行データ。
//     * @return 償還払不支給決定情報取込の明細部。
//     */
//    public ShokanFushikyuKetteiInMeisaiCSVEntity createCsvMeisai(List<RString> line) {
//        return ListToObjectMappingHelper.toObject(ShokanFushikyuKetteiInMeisaiCSVEntity.class, line);
//    }
//
//    /**
//     * trim囲み文字
//     *
//     * @param 対象文字列 対象文字列
//     * @return RString
//     */
//    public RString trim囲み文字(RString 対象文字列) {
//
//        if (null != 対象文字列 && !RString.EMPTY.equals(対象文字列)) {
//            return 対象文字列.trim(TRIM_MOJI);
//        }
//
//        return RString.EMPTY;
//    }
//
//}
