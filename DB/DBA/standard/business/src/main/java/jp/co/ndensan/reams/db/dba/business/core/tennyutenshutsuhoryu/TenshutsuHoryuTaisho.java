/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshutsuhoryu.TenshutsuHoryuTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishosha;
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

/**
 * 転入 広域保留対象者情報の取得処理の取得します。
 *
 * @reamsid_L DBA-0470-010 wangxiaodong
 */
public class TenshutsuHoryuTaisho implements Serializable {

    private final HihokenshaDaicho 被保険者台帳;
    private final TenshutsuHoryuTaishosha 転出保留対象者;

    /**
     * 転出保留対象者情報の取得のEntity
     *
     * @param entity TennyushutsuHoryuTaishoshaEntity
     */
    public TenshutsuHoryuTaisho(TenshutsuHoryuTaishoshaRelateEntity entity) {
        this.被保険者台帳 = new HihokenshaDaicho(entity.getHihokenshaDaicho());
        this.転出保留対象者 = new TenshutsuHoryuTaishosha(entity.getTenshutsuHoryuTaishosha());
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 転出保留対象者.get識別コード();
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者台帳.get被保険者番号();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return 転出保留対象者.get履歴番号();
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 転出保留対象者.get市町村コード();
    }

    /**
     * 住民種別のgetメソッドです。
     *
     * @return 住民種別
     */
    public RString get住民種別() {
        if (転出保留対象者.get住民種別コード() == null) {
            return RString.EMPTY;
        }
        return JuminShubetsu.toValue(転出保留対象者.get住民種別コード()).toRString();
    }

    /**
     * 宛名氏名のgetメソッドです。
     *
     * @return 宛名氏名
     */
    public AtenaMeisho get宛名氏名() {
        return 転出保留対象者.get宛名氏名();
    }

    /**
     * 宛名カナ氏名のgetメソッドです。
     *
     * @return 宛名カナ氏名
     */
    public AtenaKanaMeisho get宛名カナ氏名() {
        return 転出保留対象者.get宛名カナ氏名();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return 転出保留対象者.get生年月日();
    }

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    public RString get性別() {
        if (転出保留対象者.get性別コード() == null) {
            return RString.EMPTY;
        }
        return Gender.toValue(転出保留対象者.get性別コード()).getCommonName();
    }

    /**
     * 異動事由のgetメソッドです。
     *
     * @return 異動事由
     */
    public RString get異動事由() {
        if (転出保留対象者.get異動事由コード() == null) {
            return RString.EMPTY;
        }
        return JukiIdoJiyu.toValue(転出保留対象者.get異動事由コード()).get異動事由正式名称();
    }

    /**
     * 異動年月日のgetメソッドです。
     *
     * @return 登録異動年月日
     */
    public FlexibleDate get異動日() {
        if (!get転出確定異動日().isEmpty()) {
            return get転出確定異動日();
        }
        return get転出予定異動日();
    }

    /**
     * 転入転出予定住所のgetメソッドです。
     *
     * @return 転入転出予定住所
     */
    public AtenaJusho get転入転出予定住所() {
        if (!get転出確定住所().isEmpty()) {
            return get転出確定住所();
        }
        return get転出予定住所();
    }

    /**
     * HihokenshaDaichoのgetメソッドです。
     *
     * @return 被保険者台帳管理
     */
    public HihokenshaDaicho get被保険者台帳管理() {
        return this.被保険者台帳;
    }

    /**
     * 被保険者台帳管理異動日のgetメソッドです。
     *
     * @return 被保険者台帳管理異動日
     */
    public FlexibleDate get被保険者異動日() {
        return 被保険者台帳.get異動日();
    }

    /**
     * 被保険者台帳管理枝番のgetメソッドです。
     *
     * @return 被保険者台帳管理枝番
     */
    public RString get被保険者枝番() {
        return 被保険者台帳.get枝番();
    }

    /**
     * TenshutsuHoryuTaishoshaのgetメソッドです。
     *
     * @return TenshutsuHoryuTaishosha
     */
    public TenshutsuHoryuTaishosha get転出保留対象者() {
        return this.転出保留対象者;
    }

    private AtenaJusho get転出確定住所() {
        if (転出保留対象者.get転出確定住所() == null) {
            return AtenaJusho.EMPTY;
        }
        return 転出保留対象者.get転出確定住所();
    }

    private AtenaJusho get転出予定住所() {
        if (転出保留対象者.get転出予定住所() == null) {
            return AtenaJusho.EMPTY;
        }
        return 転出保留対象者.get転出予定住所();
    }

    private FlexibleDate get転出確定異動日() {
        if (転出保留対象者.get転出確定異動年月日() == null) {
            return FlexibleDate.EMPTY;
        }
        return 転出保留対象者.get転出確定異動年月日();
    }

    private FlexibleDate get転出予定異動日() {
        if (転出保留対象者.get転出予定異動年月日() == null) {
            return FlexibleDate.EMPTY;
        }
        return 転出保留対象者.get転出予定異動年月日();
    }
}
