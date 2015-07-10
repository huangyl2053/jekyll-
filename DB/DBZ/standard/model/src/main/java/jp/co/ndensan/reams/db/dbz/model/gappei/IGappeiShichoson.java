/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村のインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IGappeiShichoson {

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
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    LasdecCode get旧市町村コード();

    /**
     * 運用開始日を返します。
     *
     * @return 運用開始日
     */
    FlexibleDate get運用開始日();

    /**
     * 運用終了日を返します。
     *
     * @return 運用終了日
     */
    FlexibleDate get運用終了日();

    /**
     * 旧保険者番号を返します。
     *
     * @return 旧保険者番号
     */
    ShoKisaiHokenshaNo get旧保険者番号();

    /**
     * 旧市町村名称を返します。
     *
     * @return 旧市町村名称
     */
    RString get旧市町村名称();

    /**
     * 都道府県名称を返します。
     *
     * @return 都道府県名称
     */
    RString get都道府県名称();

    /**
     * 郡名称を返します。
     *
     * @return 郡名称
     */
    RString get郡名称();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    RString get老人保健市町村番号();

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return 老人保健受給者番号体系
     */
    RString get老人保健受給者番号体系();

    /**
     * 表示有無を返します。
     *
     * @return 表示有無
     */
    RString get表示有無();
}
