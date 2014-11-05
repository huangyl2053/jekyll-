/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報のインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IGappeiJoho {

    /**
     * 合併日を返します。
     *
     * @return 合併日
     */
    FlexibleDate get合併日();

    /**
     * 地域番号を返します。
     *
     * @return 地域番号
     */
    RString get地域番号();

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    RString get市町村コード();

    /**
     * 合併種類を返します。
     *
     * @return 合併種類
     */
    RString get合併種類();

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    ShoKisaiHokenshaNo get保険者番号();

    /**
     * 旧市町村情報付与終了日を返します。
     *
     * @return 旧市町村情報付与終了日
     */
    FlexibleDate get旧市町村情報付与終了日();

    /**
     * 国保連データ連携開始日を返します。
     *
     * @return 国保連データ連携開始日
     */
    FlexibleDate get国保連データ連携開始日();
}
