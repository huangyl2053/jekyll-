/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushoEditPattern;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * 保険者であることを表します。
 *
 * @author N3327 三浦 凌
 */
public interface IHokensha {

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    ShoKisaiHokenshaNo get証記載保険者番号();

    /**
     * 保険者の住所を返します。
     *
     * @return 住所
     */
    AtenaJusho get住所();

    /**
     * 保険者の郵便番号を返します。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 保険者の電話番号を返します。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * 群名を印字するかどうかの区分を返します。
     *
     * @return 群名を印字するかどうかの区分
     */
    GunNamePrint get群名表示有無();

    /**
     * 都道府県名を印字するかどうかの区分を返します。
     *
     * @return 都道府県名を印字するかどうかの区分
     */
    TodofukenNamePrint get都道府県名表示有無();

    /**
     * 市町村名を印字するかどうかの区分を返します。
     *
     * @return 市町村名を印字するかどうかの区分
     */
    ShichosonNamePrint get市町村名表示有無();

    /**
     * 方書を印字するかどうかの区分を返します。
     *
     * @return 方書を印字するかどうかの区分
     */
    KatagakiPrint get方書表示有無();

    /**
     * 住所の編集方法を返します。
     *
     * @return 住所の編集方法
     */
    JushoEditPattern get住所編集方法();
}
