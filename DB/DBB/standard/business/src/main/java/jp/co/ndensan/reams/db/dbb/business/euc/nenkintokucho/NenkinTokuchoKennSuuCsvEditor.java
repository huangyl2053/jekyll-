/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.euc.nenkintokucho;

import jp.co.ndensan.reams.db.dbb.entity.csv.IdoShoriKekkaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.IraiOrTuikaIraiShoriKekkaCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.KekkajohoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.TaishoshaOrTuikaKohoshaJohoCsvEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.entity.db.relate.uext00010.TorikomiFileTrailRecordTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みの件数表CSVデータの編集クラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
public class NenkinTokuchoKennSuuCsvEditor {

    /**
     * 対象者or追加候補者情報CSVレコードを取得します。
     *
     * @param tmpEntity TorikomiFileTrailRecordTempEntity
     * @param 該当件数 int
     * @param 市町村名 RString
     * @return TaishoshaOrTuikaKohoshaJohoCsvEntity
     */
    public TaishoshaOrTuikaKohoshaJohoCsvEntity get対象者or追加候補者情報CsvEntity(TorikomiFileTrailRecordTempEntity tmpEntity,
            int 該当件数, RString 市町村名) {
        TaishoshaOrTuikaKohoshaJohoCsvEntity csvEntity = new TaishoshaOrTuikaKohoshaJohoCsvEntity();
        csvEntity.set市町村名称(市町村名);
        csvEntity.set義務者コード(tmpEntity.getTokuchoGimuCode());
        csvEntity.set義務者名(get義務者名(tmpEntity.getTokuchoGimuCode()));
        csvEntity.set該当件数(getIntToRString(該当件数));
        return csvEntity;
    }

    /**
     * 処理結果情報件数表CSVレコードを取得します。
     *
     * @param tmpEntity TorikomiFileTrailRecordTempEntity
     * @param 該当件数 int
     * @param 市町村名 RString
     * @param エラー数 int
     * @param 停止数 int
     * @return IraiOrTuikaIraiShoriKekkaCsvEntity
     */
    public IraiOrTuikaIraiShoriKekkaCsvEntity get処理結果情報件数表CsvEntity(TorikomiFileTrailRecordTempEntity tmpEntity,
            int 該当件数, RString 市町村名, int エラー数, int 停止数) {
        IraiOrTuikaIraiShoriKekkaCsvEntity csvEntity = new IraiOrTuikaIraiShoriKekkaCsvEntity();
        csvEntity.set市町村名称(市町村名);
        csvEntity.set義務者コード(tmpEntity.getTokuchoGimuCode());
        csvEntity.set義務者名(get義務者名(tmpEntity.getTokuchoGimuCode()));
        csvEntity.set該当件数(getIntToRString(該当件数));
        csvEntity.setエラー件数(getIntToRString(エラー数));
        csvEntity.set停止件数(getIntToRString(停止数));
        return csvEntity;
    }

    /**
     * 特別徴収結果情報件数表CSVレコードを取得します。
     *
     * @param tmpEntity TorikomiFileTrailRecordTempEntity
     * @param 該当件数 int
     * @param 市町村名 RString
     * @param 合計金額 Decimal
     * @param 停止金額 Decimal
     * @param 停止数 int
     * @return KekkajohoCsvEntity
     */
    public KekkajohoCsvEntity get特別徴収結果情報件数表CsvEntity(TorikomiFileTrailRecordTempEntity tmpEntity,
            int 該当件数, RString 市町村名, Decimal 合計金額, Decimal 停止金額, int 停止数) {
        KekkajohoCsvEntity csvEntity = new KekkajohoCsvEntity();
        csvEntity.set市町村名称(市町村名);
        csvEntity.set義務者コード(tmpEntity.getTokuchoGimuCode());
        csvEntity.set義務者名(get義務者名(tmpEntity.getTokuchoGimuCode()));
        csvEntity.set該当件数(getIntToRString(該当件数));
        csvEntity.set停止件数(getIntToRString(停止数));
        csvEntity.set該当金額(new RString(合計金額.toString()));
        csvEntity.set停止金額(new RString(停止金額.toString()));
        return csvEntity;
    }

    /**
     * 特別徴収異動処理結果情報件数表CSVレコードを取得します。
     *
     * @param tmpEntity TorikomiFileTrailRecordTempEntity
     * @param 市町村名 RString
     * @param 資格喪失件数 int
     * @param 仮徴収額変更件数 int
     * @param 住所地特例件数 int
     * @param 資格喪失エラー件数 int
     * @param 仮徴収額変更エラー件数 int
     * @param 住所地特例エラー件数 int
     * @return IdoShoriKekkaJohoCsvEntity
     */
    public IdoShoriKekkaJohoCsvEntity get特別徴収異動処理結果情報件数表CsvEntity(TorikomiFileTrailRecordTempEntity tmpEntity,
            RString 市町村名, int 資格喪失件数, int 仮徴収額変更件数, int 住所地特例件数, int 資格喪失エラー件数,
            int 仮徴収額変更エラー件数, int 住所地特例エラー件数) {
        IdoShoriKekkaJohoCsvEntity csvEntity = new IdoShoriKekkaJohoCsvEntity();
        csvEntity.set市町村名称(市町村名);
        csvEntity.set義務者コード(tmpEntity.getTokuchoGimuCode());
        csvEntity.set義務者名(get義務者名(tmpEntity.getTokuchoGimuCode()));
        csvEntity.set該当件数(getIntToRString(資格喪失件数 + 仮徴収額変更件数 + 住所地特例件数));
        csvEntity.set資格喪失件数(getIntToRString(資格喪失件数));
        csvEntity.set仮徴収額変更件数(getIntToRString(仮徴収額変更件数));
        csvEntity.set住所地特例件数(getIntToRString(住所地特例件数));
        csvEntity.set資格喪失エラー件数(getIntToRString(資格喪失エラー件数));
        csvEntity.set仮徴収額変更エラー件数(getIntToRString(仮徴収額変更エラー件数));
        csvEntity.set住所地特例エラー件数(getIntToRString(住所地特例エラー件数));
        return csvEntity;
    }

    private RString get義務者名(RString 義務者コード) {
        if (!RString.isNullOrEmpty(義務者コード)) {
            return new TokubetsuChoshuGimushaCode(義務者コード).getMeisho();
        }
        return RString.EMPTY;
    }

    private RString getIntToRString(int 合計件数) {
        return new RString(String.valueOf(合計件数));
    }
}
