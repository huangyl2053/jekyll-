/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請届出情報（ビジネス）を扱うインターフェースです。
 *
 * @author n8223 朴義一
 */
public interface IShinseitodokedeJoho {

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    ShinseishoKanriNo get申請書管理番号();

    /**
     * 申請届出代行区分コードを返します。
     *
     * @return 申請届出代行区分コード
     */
    Code get申請届出代行区分コード();

    /**
     * 申請届出者氏名を返します。
     *
     * @return 申請届出者氏名
     */
    AtenaMeisho get申請届出者氏名();

    /**
     * 申請届出者氏名カナを返します。
     *
     * @return 申請届出者氏名カナ
     */
    AtenaKanaMeisho get申請届出者氏名カナ();

    /**
     * 申請届出者続柄コードを返します。
     *
     * @return 申請届出者続柄コード
     */
    RString get申請届出者続柄コード();

    /**
     * 申請届出代行事業者番号を返します。
     *
     * @return 申請届出代行事業者番号
     */
    JigyoshaNo get申請届出代行事業者番号();

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    RString get事業者区分();

    /**
     * 申請届出者郵便番号を返します。
     *
     * @return 申請届出者郵便番号
     */
    YubinNo get申請届出者郵便番号();

    /**
     * 申請届出者住所を返します。
     *
     * @return 申請届出者住所
     */
    AtenaJusho get申請届出者住所();

    /**
     * 申請届出者電話番号を返します。
     *
     * @return 申請届出者電話番号
     */
    TelNo get申請届出者電話番号();

}
