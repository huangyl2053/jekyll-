package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 給付管理票一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity
        extends DbTableEntityBase<DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity> implements IDbAccessable {

    @PrimaryKey
    private int renban;
    private HihokenshaNo hihokenshaNoIn;
    private RString taishoNendo;
    private HokenshaNo shoKisaiHokenshaNo;
    private RString shikyuShinseishoSeiriNo;
    private int rirekiNo;
    private RString jikoFutanSeiriNo;
    private RString hokenSeidoCode;
    private RString kokuho_HihokenshaShoKigo;
    private RString keisanKaishiYMD;
    private RString keisanShuryoYMD;
    private RString shinseiYMD;
    private RString ketteiYMD;
    private Decimal jikoFutanSogaku;
    private RString shikyuKubunCode;
    private Decimal shikyugaku;
    private RString kyufuShurui;
    private RString fushikyuRiyu;
    private RString biko;
    private RString shiharaiHohoKubun;
    private RString shiharaiBasho;
    private RString shiharaiKaishiYMD;
    private RString shiharaiShuryoYMD;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private RString kinyuKikanCode;
    private RString kinyuKikanMei;
    private RString kinyuKikanShitenCode;
    private RString kinyuKikanShitenMei;
    private RString kozaShumoku;
    private RString kozaShumokuMei;
    private RString kozaNo;
    private RString kozaMeiginin;
    private Long kozaID;
    private RString chohyoKanrenzukeNo;

}
