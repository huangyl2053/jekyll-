/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha;

import jp.co.ndensan.reams.db.dba.entity.db.tennyutenshutsuhoryutaishosha.TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
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
 * 転出保留対象者情報の取得します
 */
public class TennyushutsuHoryuTaishoshaBusiness implements TennyuTenshutsuHoryuTaishosha {

    private final TennyushutsuHoryuTaishoshaEntity entity;

    /**
     * 転出保留対象者情報の取得のEntity
     *
     * @param entity TennyushutsuHoryuTaishoshaEntity
     */
    public TennyushutsuHoryuTaishoshaBusiness(TennyushutsuHoryuTaishoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    @Override
    public ShikibetsuCode get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    @Override
    public HihokenshaNo get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    @Override
    public Decimal get履歴番号() {
        return entity.get履歴番号();
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    @Override
    public LasdecCode get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 住民種別コードのgetメソッドです。
     *
     * @return 住民種別コード
     */
    @Override
    public RString get住民種別コード() {
        return new RString(JuminShubetsu.toValue(entity.get住民種別コード()).name());
    }

    /**
     * 宛名氏名のgetメソッドです。
     *
     * @return 宛名氏名
     */
    @Override
    public AtenaMeisho get宛名氏名() {
        return entity.get宛名氏名();
    }

    /**
     * 宛名カナ氏名のgetメソッドです。
     *
     * @return 宛名カナ氏名
     */
    @Override
    public AtenaKanaMeisho get宛名カナ氏名() {
        return entity.get宛名カナ氏名();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    @Override
    public FlexibleDate get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    @Override
    public RString get性別() {
        return Gender.toValue(entity.get性別コード()).getName().getShortJapanese();
    }

    /**
     * 異動事由コードのgetメソッドです。
     *
     * @return 異動事由コード
     */
    @Override
    public RString get異動事由コード() {
        return JukiIdoJiyu.toValue(entity.get異動事由コード()).get異動事由略称();
    }

    /**
     * 異動年月日のgetメソッドです。
     *
     * @return 登録異動年月日
     */
    @Override
    public FlexibleDate get異動年月日() {
        return entity.get転出確定異動年月日() != null ? entity.get転出確定異動年月日() : entity.get転出予定異動年月日();
    }

    /**
     * 転出予定住所のgetメソッドです。
     *
     * @return 転出予定住所
     */
    @Override
    public AtenaJusho get転出予定住所() {
        return entity.get転出確定住所() != null ? entity.get転出確定住所() : entity.get転出予定住所();

    }

}
