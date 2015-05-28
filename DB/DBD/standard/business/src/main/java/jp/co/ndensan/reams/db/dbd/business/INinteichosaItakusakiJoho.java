/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査委託先情報を表すインターフェースです。
 *
 * @author n8223　朴義一
 */
public interface INinteichosaItakusakiJoho {

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    ChosaItakusakiCode get認定調査委託先コード();

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    JigyoshaNo get事業者番号();

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    RString get事業者名称();

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    RString get事業者名称カナ();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    RString get住所();

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    TelNo getFAX番号();

    /**
     * 代表者名を返します。
     *
     * @return 代表者名
     */
    AtenaMeisho get代表者名();

    /**
     * 調査委託区分を返します。
     *
     * @return 調査委託区分
     */
    RString get調査委託区分();

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    int get割付定員();

    /**
     * 割付地区を返します。
     *
     * @return 割付地区
     */
    ChikuCode get割付地区();

    /**
     * 自動割付フラグを返します。
     *
     * @return 自動割付フラグ
     */
    boolean get自動割付フラグ();

    /**
     * 機関の区分を返します。
     *
     * @return 機関の区分
     */
    RString get機関の区分();

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    boolean get状況フラグ();

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    EntityDataState getState();

}
