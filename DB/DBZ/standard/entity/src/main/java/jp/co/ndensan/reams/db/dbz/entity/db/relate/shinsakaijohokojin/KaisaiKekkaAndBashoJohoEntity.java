/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 開催結果情報と開催場所情報のRelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaisaiKekkaAndBashoJohoEntity implements IDbAccessable {

    private RString 介護認定審査会開催番号;
    private int 合議体番号;
    private FlexibleDate 介護認定審査会開催年月日;
    private RString 介護認定審査会開始時刻;
    private RString 介護認定審査会終了時刻;
    private int 所要時間合計;
    private RString 介護認定審査会開催場所名称;
    private Code 介護認定審査会開催地区コード;
    private RString 合議体名称;
}
