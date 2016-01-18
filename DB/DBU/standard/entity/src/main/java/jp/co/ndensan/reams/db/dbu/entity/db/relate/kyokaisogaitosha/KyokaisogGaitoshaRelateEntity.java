/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 境界層管理マスタリスト情報のRelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KyokaisogGaitoshaRelateEntity implements IDbAccessable {

    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo hihokenshaNo;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString kyuufugakuGengakuKisaiKiajoFlag;
    private RString hyojunFutanGengakuGaitoFlag;
    private Decimal hyojunFutanKeigengoFutangaku;
    private RString kyojuhinadoFutangakugengakuGaitoFlag;
    private RString kyojuhiKeigengoKyoshitsuShuruiCode;
    private RString shokuhiKeigengoHutangakuGaitoFlag;
    private Decimal shokuhiKeigengoHutangaku;
    private Decimal kyojuhiKeigengoHutangaku;
    private RString kogakuServicehiJogengakuGengakuGaitoFlag;
    private Decimal kogakuServicehiJogengakuGengakugoJogengaku;
    private RString hokenryoNofuGengakuFlag;
    private RString gengakuGoHokenryoDankai;
    private FlexibleDate shinseiYMD;
    private RString meisho;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private SetaiCode setaiCode;
    private RString kanaShimei;
    private RString juminShubetsuCode;
    private RString juminJotaiCode;
}
