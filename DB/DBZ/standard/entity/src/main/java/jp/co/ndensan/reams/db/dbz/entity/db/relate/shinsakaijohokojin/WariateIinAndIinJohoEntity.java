/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 審査会委員情報のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class WariateIinAndIinJohoEntity implements IDbAccessable {

    private Code 介護認定審査会議長区分コード;
    private RString 介護認定審査会委員コード;
    private AtenaMeisho 介護認定審査会委員氏名;
    private Code 介護認定審査員資格コード;
}
