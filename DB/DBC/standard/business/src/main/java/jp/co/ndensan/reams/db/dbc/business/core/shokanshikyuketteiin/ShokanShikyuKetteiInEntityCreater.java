/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanshikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanShikyuKetteiInHeaderCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShokanShikyuKetteiInMeisaiCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraShiketteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraiShikyuKetteiJohoItijiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給決定情報取込のEntityCreater。
 */
public class ShokanShikyuKetteiInEntityCreater {

    private static final char TRIM_MOJI = '"';
    private static final RString 支給不支給区分_支給 = new RString("1");

    /**
     * 償還払支給決定情報Entityを作成する。
     *
     * @param headEntity 償還払支給決定情報取込のヘッダ部
     * @param meisaiEntity 償還払支給決定情報取込の明細部
     * @return 償還払支給決定情報Entity
     */
    public ShokanBaraShiketteiJohoEntity createShokanBaraShiketteiJohoEntity(ShokanShikyuKetteiInHeaderCSVEntity headEntity,
            ShokanShikyuKetteiInMeisaiCSVEntity meisaiEntity) {
        ShokanBaraShiketteiJohoEntity entity = new ShokanBaraShiketteiJohoEntity();
        entity.set交換情報識別番号(headEntity.get交換情報識別番号());
        entity.set帳票レコード種別_ヘッダ(headEntity.get帳票レコード種別());
        entity.set証記載保険者番号(headEntity.get証記載保険者番号());
        entity.set保険者名(headEntity.get保険者名());
        entity.set作成年月日(headEntity.get作成年月日());
        entity.set国保連合会名(headEntity.get国保連合会名());
        entity.set帳票レコード種別(meisaiEntity.get帳票レコード種別());
        entity.setNo(meisaiEntity.getNo());
        entity.set整理番号(meisaiEntity.get整理番号());
        entity.set被保険者番号(meisaiEntity.get被保険者番号());
        entity.set被保険者氏名_漢字(meisaiEntity.get被保険者氏名_漢字());
        entity.setサービス提供年月(meisaiEntity.getサービス提供年月());
        entity.set事業所番号(meisaiEntity.get事業所番号());
        entity.set事業所名_漢字(meisaiEntity.get事業所名_漢字());
        entity.setサービス種類コード(meisaiEntity.getサービス種類コード());
        entity.setサービス種類名(meisaiEntity.getサービス種類名());
        entity.set単位数_金額(meisaiEntity.get単位数_金額());
        entity.set支払金額(meisaiEntity.get支払金額());
        entity.set増減単位数(meisaiEntity.get増減単位数());
        entity.set支払方法区分コード(meisaiEntity.get支払方法区分コード());
        entity.set備考(meisaiEntity.get備考());
        return entity;
    }

    /**
     * 償還払支給決定情報一時TBLの登録
     *
     * @param entity 償還払支給決定情報Entity
     * @return ShokanBaraiShikyuKetteiJohoItijiEntity 償還払支給決定情報一時TBL
     */
    public ShokanBaraiShikyuKetteiJohoItijiEntity createShokanBaraiShikyuKetteiJohoItijiEntity(ShokanBaraShiketteiJohoEntity entity) {
        ShokanBaraiShikyuKetteiJohoItijiEntity entityItiji = new ShokanBaraiShikyuKetteiJohoItijiEntity();
        entityItiji.set交換情報識別番号(new KokanShikibetsuNo(trim囲み文字(entity.get交換情報識別番号())));
        entityItiji.set帳票レコード種別_ヘッダ(trim囲み文字(entity.get帳票レコード種別_ヘッダ()));
        entityItiji.set証記載保険者番号(new ShoKisaiHokenshaNo(trim囲み文字(entity.get証記載保険者番号())));
        entityItiji.set保険者名(trim囲み文字(entity.get保険者名()));
        entityItiji.set作成年月日(new FlexibleDate(trim囲み文字(entity.get作成年月日())));
        entityItiji.set国保連合会名(trim囲み文字(entity.get国保連合会名()));
        entityItiji.set帳票レコード種別(trim囲み文字(entity.get帳票レコード種別()));
        entityItiji.setNo(trim囲み文字(entity.getNo()));
        entityItiji.set整理番号(entity.get整理番号());
        entityItiji.set被保険者番号(new HihokenshaNo(trim囲み文字(entity.get被保険者番号())));
        entityItiji.set被保険者氏名_漢字(trim囲み文字(entity.get被保険者氏名_漢字()));
        entityItiji.setサービス提供年月(new FlexibleYearMonth(trim囲み文字(entity.getサービス提供年月())));
        entityItiji.set事業所番号(new JigyoshaNo(trim囲み文字(entity.get事業所番号())));
        entityItiji.set事業所名_漢字(trim囲み文字(entity.get事業所名_漢字()));
        entityItiji.setサービス種類コード(new ServiceShuruiCode(trim囲み文字(entity.getサービス種類コード())));
        entityItiji.setサービス種類名(trim囲み文字(entity.getサービス種類名()));
        entityItiji.set単位数_金額(new Decimal(trim囲み文字(entity.get単位数_金額()).toString()));
        entityItiji.set支払金額(new Decimal(trim囲み文字(entity.get支払金額()).toString()));
        entityItiji.set増減単位数(changeRStringToInt(trim囲み文字(entity.get増減単位数())));
        entityItiji.set支払方法区分コード(trim囲み文字(entity.get支払方法区分コード()));
        entityItiji.set備考(trim囲み文字(entity.get備考()));
        entityItiji.set支給不支給区分(支給不支給区分_支給);
        entityItiji.set更新DB無(false);
        return entityItiji;
    }

    /**
     * ヘッダレコードの項目
     *
     * @param line CSVの一行データ。
     * @return 償還払支給決定情報取込のヘッダ部。
     */
    public ShokanShikyuKetteiInHeaderCSVEntity createCsvHeader(List<RString> line) {
        return ListToObjectMappingHelper.toObject(ShokanShikyuKetteiInHeaderCSVEntity.class, line);
    }

    /**
     * 明細レコードの項目
     *
     * @param line CSVの一行データ。
     * @return 償還払支給決定情報取込の明細部。
     */
    public ShokanShikyuKetteiInMeisaiCSVEntity createCsvMeisai(List<RString> line) {
        return ListToObjectMappingHelper.toObject(ShokanShikyuKetteiInMeisaiCSVEntity.class, line);
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
