/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 受給者台帳一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbWT1512JukyushaDaichoEntity extends DbTableEntityBase<DbWT1512JukyushaDaichoEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString rirekiNo;
    @PrimaryKey
    private RString edaban;
    @PrimaryKey
    private Code yokaigoJotaiKubunCode;
    @PrimaryKey
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private Decimal shikyuGendoTanisu;
    private FlexibleDate shikyuGendoKaishiYMD;
    private FlexibleDate shikyuGendoShuryoYMD;
    private boolean kyuSochishaFlag;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString kyotakuServiceSakuseiKubunCode;
    private RString keisakuSakuseiJigyoshaNo;
    private ShikibetsuCode sikibetsuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private RString koikinaiJushochiTokureiFlag;
    private RString koikinaiTokureiSochimotoShichosonCode;
    private RString kyuShichosonCode;
    private FlexibleYearMonth ninteiYukoKikanKaishiYM;
    private FlexibleYearMonth ninteiYukoKikanShuryoYM;
    private boolean shutsuryokuFlag;
}
