/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsuhoryutaishosha;

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
public interface TennyuTenshutsuHoryuTaishosha {

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    ShikibetsuCode get識別コード();

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    HihokenshaNo get被保険者番号();

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    Decimal get履歴番号();

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 住民種別コードのgetメソッドです。
     *
     * @return 住民種別コード
     */
    RString get住民種別コード();

    /**
     * 宛名氏名のgetメソッドです。
     *
     * @return 宛名氏名
     */
    AtenaMeisho get宛名氏名();

    /**
     * 宛名カナ氏名のgetメソッドです。
     *
     * @return 宛名カナ氏名
     */
    AtenaKanaMeisho get宛名カナ氏名();

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    FlexibleDate get生年月日();

    /**
     * 性別のgetメソッドです。
     *
     * @return 性別
     */
    RString get性別();

    /**
     * 異動事由コードのgetメソッドです。
     *
     * @return 異動事由コード
     */
    RString get異動事由コード();

    /**
     * 異動年月日のgetメソッドです。
     *
     * @return 登録異動年月日
     */
    FlexibleDate get異動年月日();

    /**
     * 転出予定住所のgetメソッドです。
     *
     * @return 転出予定住所
     */
    AtenaJusho get転出予定住所();
}
