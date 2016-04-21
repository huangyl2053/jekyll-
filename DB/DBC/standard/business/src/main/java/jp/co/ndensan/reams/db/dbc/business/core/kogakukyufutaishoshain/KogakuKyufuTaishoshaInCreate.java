/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukyufutaishoshain;

import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3054CSVDataMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3055CSVDataGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbTKogakuKyufuCSVDataHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.DbTKogakuKyufuTaishoshaDataTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費給付対象者取込のcreate
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInCreate {

    /**
     * 高額介護サービス費給付対象者取込の一時テーブル
     *
     * @param headEntity headEntity
     * @param meisaiEntity meisaiEntity
     * @param gokeiEntity gokeiEntity
     * @return DbTKogakuKyufuTaishoshaDataTempTableEntity
     */
    public DbTKogakuKyufuTaishoshaDataTempTableEntity createDataRecord(DbTKogakuKyufuCSVDataHeadEntity headEntity,
            DbT3054CSVDataMeisaiEntity meisaiEntity,
            DbT3055CSVDataGokeiEntity gokeiEntity) {

        DbTKogakuKyufuTaishoshaDataTempTableEntity result = new DbTKogakuKyufuTaishoshaDataTempTableEntity();
        result.setKokanShikibetsuNo((trim囲み文字(headEntity.getKokanShikibetsuNo())));
        result.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(trim囲み文字(headEntity.getShoKisaiHokenshaNo())));
        result.setHihokenshaName(trim囲み文字(headEntity.getHihokenshaName()));
        result.setSakuseiYMD(new FlexibleDate(trim囲み文字(headEntity.getSakuseiYMD())));
        result.setKokukoRengoukaiNa(trim囲み文字(headEntity.getKokukoRengoukaiNa()));
        result.setNo(trim囲み文字(meisaiEntity.getNo()));
        result.setHihokenshaNo(new HihokenshaNo(trim囲み文字(meisaiEntity.getHihokenshaNo())));
        result.setHiHokenshaSimei(trim囲み文字(meisaiEntity.getHiHokenshaSimei()));
        result.setServiceTeikyoYM(new FlexibleYearMonth(trim囲み文字(meisaiEntity.getServiceTeikyoYM())));
        result.setJigyoshaNo(new JigyoshaNo(trim囲み文字(meisaiEntity.getJigyoshaNo())));
        result.setJigyoshaName(trim囲み文字(meisaiEntity.getJigyoshaName()));
        result.setServiceShuruiCode(new ServiceShuruiCode(trim囲み文字(meisaiEntity.getServiceShuruiCode())));
        result.setServiceShuruiName(trim囲み文字(meisaiEntity.getServiceShuruiName()));
        result.setServiceHiyoGokeiGaku(checkDecimal(meisaiEntity.getServiceHiyoGokeiGaku()));
        result.setRiyoshaFutanGaku(checkDecimal(meisaiEntity.getRiyoshaFutanGaku()));
        result.setBikou(trim囲み文字(meisaiEntity.getBikou()));
        result.setShikakuSoshitsuYMD(FlexibleDate.EMPTY);
        result.setServiceHiyoGokeiGakuGokei(checkDecimal(gokeiEntity.getServiceHiyoGokeiGakuGokei()));
        result.setRiyoshaFutanGakuGokei(checkDecimal(gokeiEntity.getRiyoshaFutanGakuGokei()));
        result.setSanteiKijunGaku(checkDecimal(gokeiEntity.getSanteiKijunGaku()));
        result.setShiharaiSumiKingakuGokei(checkDecimal(gokeiEntity.getShiharaiSumiKingakuGokei()));
        result.setKogakuShikyuGaku(checkDecimal(gokeiEntity.getKogakuShikyuGaku()));
        result.setSetaiShuyakuNo(HihokenshaNo.EMPTY);

        return result;
    }

    /**
     * 高額介護サービス費給付対象者取込のhead一時テーブル
     *
     * @param headEntity headEntity
     * @return DbTKogakuKyufuTaishoshaDataTempTableEntity
     */
    public DbTKogakuKyufuTaishoshaDataTempTableEntity createDataRecord(DbTKogakuKyufuCSVDataHeadEntity headEntity) {
        DbTKogakuKyufuTaishoshaDataTempTableEntity result = new DbTKogakuKyufuTaishoshaDataTempTableEntity();
        result.setKokanShikibetsuNo((trim囲み文字(headEntity.getKokanShikibetsuNo())));
        result.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(trim囲み文字(headEntity.getShoKisaiHokenshaNo())));
        result.setHihokenshaName(trim囲み文字(headEntity.getHihokenshaName()));
        result.setSakuseiYMD(new FlexibleDate(trim囲み文字(headEntity.getSakuseiYMD())));
        result.setKokukoRengoukaiNa(trim囲み文字(headEntity.getKokukoRengoukaiNa()));
        return result;
    }

    private RString trim囲み文字(RString 対象文字列) {

        final char trim文字 = '"';

        try {

            対象文字列 = 対象文字列.trim(trim文字);
        } catch (NullPointerException e) {
            対象文字列 = RString.EMPTY;
        }
        return 対象文字列;
    }

    private Decimal checkDecimal(Decimal 金額) {
        if (金額 == null) {
            return new Decimal(0);
        }

        return 金額;
    }
}
