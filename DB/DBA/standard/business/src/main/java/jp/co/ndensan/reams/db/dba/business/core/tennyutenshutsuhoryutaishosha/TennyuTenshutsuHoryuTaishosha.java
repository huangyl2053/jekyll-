/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha;

import jp.co.ndensan.reams.db.dba.entity.db.tennyutenshutsuhoryutaishosha.TennyuTenshutsuHoryuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 転出転入保留対象者情報の取得します
 */
public class TennyuTenshutsuHoryuTaishosha {

    private final TennyuTenshutsuHoryuEntity entity;

    /**
     * 転出転入保留対象者情報の取得のEntity
     *
     * @param entity TennyuTenshutsuHoryuEntity
     */
    public TennyuTenshutsuHoryuTaishosha(TennyuTenshutsuHoryuEntity entity) {
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
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return entity.getHihokenshaNo();
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
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 住民種別コードのgetメソッドです。
     *
     * @return 住民種別コード
     */
    public RString getJuminShubetsuCode() {
        return entity.getJuminShubetsuCode();
    }

    /**
     * 宛名氏名のgetメソッドです。
     *
     * @return 宛名氏名
     */
    public AtenaMeisho getAtenaShimei() {
        return entity.getAtenaShimei();
    }

    /**
     * 宛名カナ氏名のgetメソッドです。
     *
     * @return 宛名カナ氏名
     */
    public AtenaKanaMeisho getAtenaKanaShimei() {
        return entity.getAtenaKanaShimei();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    public RString getSeibetsuCode() {
        return entity.getSeibetsuCode();
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
     * 異動年月日のgetメソッドです。
     *
     * @return 登録異動年月日
     */
    public FlexibleDate getTorokuIdoYMD() {
        return entity.getTorokuIdoYMD();
    }

    /**
     * 転出予定住所のgetメソッドです。
     *
     * @return 転出予定住所
     */
    public AtenaJusho getTenshutsuYoteiJusho() {
        return entity.getTenshutsuYoteiJusho();
    }
}
