/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * @author N8235 船山 洋介
 */
public interface IShujiiIryokikanJoho {

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    ShujiiIryokikanCode get主治医医療機関コード();

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    IryoKikanCode get医療機関コード();

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    RString get医療機関名称();

    /**
     * 医療機関名称カナを返します。
     *
     * @return 医療機関名称カナ
     */
    RString get医療機関名称カナ();

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
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    boolean is状況フラグ();

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    EntityDataState getState();

    /**
     * ShujiiIryoKikanJohoEntityを返します。
     *
     * @return DbTableEntityBase
     */
    IDbAccessable getEntity();

}
