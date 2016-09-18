/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd519002;

import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519002.RenekeiDataSakuseiFourMasterProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosainDataCsvProcessEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosainDataReamsCsvProcessEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosainEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosaitakusakiDataCsvProcessEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosaitakusakiDataReamsCsvProcessEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ChosaitakusakiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiDataCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiDataReamsCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiIryokikanDataCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiIryokikanDataReamsCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002.ShujiiIryokikanEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定関連データCSVを管理するクラスです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
public class RenekeiDataSakuseiFourMasterCsvManager {

    private static final int シーケンシャル番号桁数 = 6;
    private static final RString 機能コード_追加_更新 = new RString("「 」（空白）");
    private static final RString 状況フラグ_TRUE = new RString("有効");
    private static final RString 状況フラグ_FALSE = new RString("無効");

    /**
     * 認定調査委託先情報CSV_電算版のentityを作成する。
     *
     * @param entity 認定調査員情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 認定調査委託先情報CSV_電算版のentity
     */
    public ChosaitakusakiDataReamsCsvProcessEntity toChosaitakusakiDataReamsCsvProcessEntity(
            ChosaitakusakiEntity entity,
            int シーケンシャル番号,
            RString 識別コード) {
        return new ChosaitakusakiDataReamsCsvProcessEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get認定調査委託先コード().value(),
                entity.get事業者名称(),
                entity.get郵便番号().getYubinNo(),
                entity.get住所(),
                entity.get電話番号().value(),
                ChosaItakuKubunCode.toValue(entity.get調査委託区分()).get名称(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 認定調査委託先情報CSVのentityを作成する。
     *
     * @param entity 認定調査員情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 認定調査委託先情報CSVのentity
     */
    public ChosaitakusakiDataCsvProcessEntity toChosaitakusakiDataCsvProcessEntity(
            ChosaitakusakiEntity entity,
            int シーケンシャル番号,
            RString 識別コード) {
        return new ChosaitakusakiDataCsvProcessEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get認定調査委託先コード().value(),
                entity.get事業者名称(),
                entity.get事業者名称カナ(),
                entity.get郵便番号().getYubinNo(),
                entity.get住所(),
                entity.get電話番号().value(),
                ChosaItakuKubunCode.toValue(entity.get調査委託区分()).get名称(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 認定調査員情報CSVのentityを作成する。
     *
     * @param entity 認定調査員情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 認定調査員情報CSVのentity
     */
    public ChosainDataCsvProcessEntity toChosainDataCsvProcessEntity(ChosainEntity entity, int シーケンシャル番号, RString 識別コード) {
        return new ChosainDataCsvProcessEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get認定調査委託先コード().value(),
                entity.get認定調査員コード().value(),
                entity.get調査員氏名(),
                entity.get調査員氏名カナ(),
                Sikaku.toValue(entity.get調査員資格()).get名称(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 認定調査員情報CSV_電算版のentityを作成する。
     *
     * @param entity 認定調査員情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 認定調査員情報CSV_電算版CSVのentity
     */
    public ChosainDataReamsCsvProcessEntity toChosainDataReamsCsvProcessEntity(ChosainEntity entity, int シーケンシャル番号, RString 識別コード) {
        return new ChosainDataReamsCsvProcessEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get認定調査委託先コード().value(),
                entity.get認定調査員コード().value(),
                entity.get調査員氏名(),
                Sikaku.toValue(entity.get調査員資格()).get名称(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 主治医医療機関情報CSV_電算版のentityを作成する。
     *
     * @param entity 主治医医療機関情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 主治医医療機関情報CSV_電算版のentity
     */
    public ShujiiIryokikanDataReamsCsvEntity toShujiiIryokikanDataReamsCsvEntity(
            ShujiiIryokikanEntity entity,
            int シーケンシャル番号,
            RString 識別コード) {
        return new ShujiiIryokikanDataReamsCsvEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get医療機関コード().value(),
                entity.get医療機関名称(),
                entity.get郵便番号().getYubinNo(),
                entity.get住所(),
                entity.get電話番号().value(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 主治医医療機関情報CSVのentityを作成する。
     *
     * @param entity 主治医医療機関情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 主治医医療機関情報CSV_電算版のentity
     */
    public ShujiiIryokikanDataCsvEntity toShujiiIryokikanDataCsvEntity(
            ShujiiIryokikanEntity entity,
            int シーケンシャル番号,
            RString 識別コード) {
        return new ShujiiIryokikanDataCsvEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get医療機関コード().value(),
                entity.get医療機関名称(),
                entity.get医療機関名称カナ(),
                entity.get郵便番号().getYubinNo(),
                entity.get住所(),
                entity.get電話番号().value(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 主治医情報CSV_電算版のentityを作成する。
     *
     * @param entity 主治医情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 主治医情報CSV_電算版のentity
     */
    public ShujiiDataReamsCsvEntity toShujiiDataReamsCsvEntity(
            ShujiiEntity entity,
            int シーケンシャル番号,
            RString 識別コード) {
        return new ShujiiDataReamsCsvEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get主治医医療機関コード().value(),
                entity.get主治医コード().value(),
                entity.get主治医氏名(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 主治医情報CSVのentityを作成する。
     *
     * @param entity 主治医情報ＩＦのcsv情報
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 識別コード 識別コード
     * @return 主治医情報CSVのentity
     */
    public ShujiiDataCsvEntity toShujiiDataCsvEntity(
            ShujiiEntity entity,
            int シーケンシャル番号,
            RString 識別コード) {
        return new ShujiiDataCsvEntity(
                formatシーケンシャル番号(シーケンシャル番号),
                機能コード_追加_更新,
                識別コード,
                entity.get主治医医療機関コード().value(),
                entity.get主治医コード().value(),
                entity.get主治医氏名(),
                entity.get主治医カナ(),
                format状況フラグ(entity.is状況フラグ()));
    }

    /**
     * 要介護認定外部データ出力履歴 追加処理。
     *
     * @param para 要介護認定関連データのパラメータ
     * @return 追加履歴
     */
    public DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity dbT7204YokaigoNinteiGaibuDataOutputHistoryInsert(
            RenekeiDataSakuseiFourMasterProcessParameter para) {
        DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity = new DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity();
        entity.setDataKubun(new Code(Datakubun.マスタ4.getコード()));
        entity.setDataOutputKaishiYMDHMS(new YMDHMS(para.getKonkaishoriymdtime_from().toString()));
        entity.setDataOutputShuryoYMDHMS(new YMDHMS(para.getKonkaishoriymdtime_to().toString()));
        return entity;
    }

    /**
     * 要介護認定外部データ出力履歴 更新処理。
     *
     * @param para 要介護認定関連データのパラメータ
     * @param entity 取得したentity
     * @return 更新したentity
     */
    public DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity dbT7204YokaigoNinteiGaibuDataOutputHistoryUpdate(
            RenekeiDataSakuseiFourMasterProcessParameter para,
            DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity) {
        entity.setDataOutputKaishiYMDHMS(new YMDHMS(para.getKonkaishoriymdtime_from().toString()));
        entity.setDataOutputShuryoYMDHMS(new YMDHMS(para.getKonkaishoriymdtime_to().toString()));
        return entity;
    }

    private RString formatシーケンシャル番号(int シーケンシャル番号) {
        return new RString(シーケンシャル番号).padZeroToLeft(シーケンシャル番号桁数);
    }

    private RString format状況フラグ(boolean 状況フラグ) {
        return 状況フラグ ? 状況フラグ_TRUE : 状況フラグ_FALSE;
    }
}
