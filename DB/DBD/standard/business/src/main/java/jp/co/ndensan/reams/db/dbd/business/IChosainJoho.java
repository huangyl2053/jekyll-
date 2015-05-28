/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調査員情報を表すインターフェースです。
 *
 * @author n8223　朴義一
 */
public interface IChosainJoho {

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
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    ChosainCode get認定調査員コード();

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    RString get調査員氏名();

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    RString get調査員氏名カナ();

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    RString get性別();

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    RString get調査員資格();

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    RString get地区コード();

    /**
     * 調査可能人数月を返します。
     *
     * @return 調査可能人数月
     */
    int get調査可能人数月();

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
    AtenaJusho get住所();

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
