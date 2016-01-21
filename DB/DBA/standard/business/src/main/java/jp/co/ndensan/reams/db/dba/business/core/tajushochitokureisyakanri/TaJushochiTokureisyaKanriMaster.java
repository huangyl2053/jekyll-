/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri;

import jp.co.ndensan.reams.db.dba.entity.db.relate.TaJushochiTokureisyaKan.TaJushochiTokureisyaKanRirelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 他住所地特例者管理のbusinessクラスです。
 */
public class TaJushochiTokureisyaKanriMaster {

    private final TaJushochiTokureisyaKanRirelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity TaJushochiTokureisyaKanRirelateEntity
     */
    public TaJushochiTokureisyaKanriMaster(TaJushochiTokureisyaKanRirelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return entity.getShikibetsuCode();
    }

    /**
     * 異動日のgetメソッドです。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return entity.getEdaNo();
    }

    /**
     * 異動事由コードのgetメソッドです。
     *
     * @return 異動事由コード
     */
    public RString getIdoJiyuCode() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 他市町村住所地特例適用事由コードのgetメソッドです。
     *
     * @return 他市町村住所地特例適用事由コード
     */
    public KaigoTatokuTekiyoJiyu getTekiyoJiyuCode() {
        return entity.getTekiyoJiyuCode();
    }

    /**
     * 適用年月日のgetメソッドです。
     *
     * @return 適用年月日
     */
    public FlexibleDate getTekiyoYMD() {
        return entity.getTekiyoYMD();
    }

    /**
     * 適用届出年月日のgetメソッドです。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate getTekiyoTodokedeYMD() {
        return entity.getTekiyoTodokedeYMD();
    }

    /**
     * 適用受付年月日のgetメソッドです。
     *
     * @return 適用受付年月日
     */
    public FlexibleDate getTekiyoUketsukeYMD() {
        return entity.getTekiyoUketsukeYMD();
    }

    /**
     * 他市町村住所地特例解除事由コードのgetメソッドです。
     *
     * @return 他市町村住所地特例解除事由コード
     */
    public KaigoTatokuKaijoJiyu getKaijoJiyuCode() {
        return entity.getKaijoJiyuCode();
    }

    /**
     * 解除年月日のgetメソッドです。
     *
     * @return 解除年月日
     */
    public FlexibleDate getKaijoYMD() {
        return entity.getKaijoYMD();
    }

    /**
     * 解除届出年月日のgetメソッドです。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate getKaijoTodokedeYMD() {
        return entity.getKaijoTodokedeYMD();
    }

    /**
     * 解除受付年月日のgetメソッドです。
     *
     * @return 解除受付年月日
     */
    public FlexibleDate getKaijoUketsukeYMD() {
        return entity.getKaijoUketsukeYMD();
    }

    /**
     * 措置保険者番号のgetメソッドです。
     *
     * @return 措置保険者番号
     */
    public ShoKisaiHokenshaNo getSochiHokenshaNo() {
        return entity.getSochiHokenshaNo();
    }

    /**
     * 措置被保険者番号のgetメソッドです。
     *
     * @return 措置被保険者番号
     */
    public HihokenshaNo getSochiHihokenshaNo() {
        return entity.getSochiHihokenshaNo();
    }

    /**
     * 他特例連絡票発行年月日のgetメソッドです。
     *
     * @return 他特例連絡票発行年月日
     */
    public FlexibleDate getTatokuRenrakuhyoHakkoYMD() {
        return entity.getTatokuRenrakuhyoHakkoYMD();
    }

    /**
     * 施設退所通知発行年月日のgetメソッドです。
     *
     * @return 施設退所通知発行年月日
     */
    public FlexibleDate getShisetsuTaishoTsuchiHakkoYMD() {
        return entity.getShisetsuTaishoTsuchiHakkoYMD();
    }

    /**
     * 施設変更通知発行年月日のgetメソッドです。
     *
     * @return 施設変更通知発行年月日
     */
    public FlexibleDate getShisetsuHenkoTsuchiHakkoYMD() {
        return entity.getShisetsuHenkoTsuchiHakkoYMD();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return entity.getRirekiNo();
    }

    /**
     * 台帳種別のgetメソッドです。
     *
     * @return 台帳種別
     */
    public RString getDaichoShubetsu() {
        return entity.getDaichoShubetsu();
    }

    /**
     * 入所施設種類のgetメソッドです。
     *
     * @return 入所施設種類
     */
    public RString getNyushoShisetsuShurui() {
        return entity.getNyushoShisetsuShurui();
    }

    /**
     * 入所施設コードのgetメソッドです。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo getNyushoShisetsuCode() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 入所年月日のgetメソッドです。
     *
     * @return 入所年月日
     */
    public FlexibleDate getNyushoYMD() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所年月日のgetメソッドです。
     *
     * @return 退所年月日
     */
    public FlexibleDate getTaishoYMD() {
        return entity.getTaishoYMD();
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public AtenaMeisho getJigyoshaName() {
        return entity.getJigyoshaName();
    }

//    public FlexibleDate get生年月日() {
//        return 生年月日;
//    }
//
//    public LasdecCode get現全国地方公共団体コード() {
//        return 現全国地方公共団体コード;
//    }
//
//    public LasdecCode get旧全国地方公共団体コード() {
//        return 旧全国地方公共団体コード;
//    }
}
