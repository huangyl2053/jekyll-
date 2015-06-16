/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.IShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医情報のインターフェースです。
 *
 * @author N8235 船山 洋介
 */
public interface IShujiiJoho {

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
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    ShujiiCode get主治医コード();

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    AtenaMeisho get主治医氏名();

    /**
     * 主治医カナを返します。
     *
     * @return 主治医カナ
     */
    AtenaKanaMeisho get主治医カナ();

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
     * 診療科名称を返します。
     *
     * @return 診療科名称
     */
    RString get診療科名称();

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    boolean is指定医フラグ();

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
     * IShujiiJohoEntityを返します。
     *
     * @return IShujiiJohoEntity
     */
    IShujiiJohoEntity getEntity();
}
