/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.IYubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医の情報を表すインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IShujii {

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    ShichosonCode get市町村コード();

    /**
     * 介護医療機関コードを返します。
     *
     * @return 介護医療機関コード
     */
    KaigoIryoKikanCode get介護医療機関コード();

    /**
     * 介護医師コードを返します。
     *
     * @return 介護医師コード
     */
    KaigoDoctorCode get介護医師コード();

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    IIryoKikanCode get医療機関コード();

    /**
     * 医師識別番号を返します。
     *
     * @return 医師識別番号
     */
    RString get医師識別番号();

    /**
     * 医師の状況が有効かどうかを判定します。
     *
     * @return 有効の場合はtrueを返します。
     */
    boolean is有効();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    IYubinNo get郵便番号();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    IJusho get住所();

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    RString get電話番号();

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    RString getFAX番号();
}
