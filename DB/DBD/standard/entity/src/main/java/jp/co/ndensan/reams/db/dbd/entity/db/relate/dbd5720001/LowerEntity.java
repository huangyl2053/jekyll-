/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_受給者台帳異動チェックリストを取得するEntityクラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class LowerEntity {

    private Code 住所コード;
    private GyoseikuCode 行政区コード;
    private RString 行政区;
    private AtenaMeisho 氏名;
    private int 年齢;
    private RString 受給申請事由;
    private RString 要介護度;
    private FlexibleDate 認定有効終了日;
    private RString 旧措置者;
    private RString 処理内容;
    private RString 備考;

}
