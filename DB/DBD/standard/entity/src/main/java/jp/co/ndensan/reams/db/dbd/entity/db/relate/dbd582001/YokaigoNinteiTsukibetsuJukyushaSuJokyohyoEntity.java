/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd582001;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定月別受給者数状況表（統計表）を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1771-033 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEntity {

    private RString 取得条件;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private Decimal 件数;
    private Decimal 件数旧措置;
    private Decimal 新規;
    private Decimal 新規旧措置;
    private Decimal 要支援;
    private Decimal 要支援旧措置;
    private Decimal 更新;
    private Decimal 更新旧措置;
    private Decimal 区分変更;
    private Decimal 区分変更旧措置;
    private Decimal 転入;
    private Decimal 転入旧措置;
    private Decimal 職権他;
    private Decimal 職権他旧措置;

}
