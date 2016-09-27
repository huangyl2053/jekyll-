package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 請求集計一時テーブルのエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3095JutakuKaishuRiyushoTesuryoShukeiEntity extends
        DbTableEntityBase<DbWT3095JutakuKaishuRiyushoTesuryoShukeiEntity> implements IDbAccessable {

    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleYearMonth shukeiKaishiYM;
    private FlexibleYearMonth shukeiShuryoYM;
    private Decimal riyushoSakuseiKensu;
    private Decimal riyushoSakuseiTanka;
    private Decimal riyushoSakuseiSeikyuKingaku;
}
