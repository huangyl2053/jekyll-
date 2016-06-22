/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.chohyojushoeditor;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票住所編集です。
 *
 * @reamsid_L DBC-0980-580 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JushoEditHoho {

    private LasdecCode 市町村コード;
    private RString 管内住所編集_都道府県名付与有無;
    private RString 管内住所編集_郡名付与有無;
    private RString 管内住所編集_市町村名付与有無;
    private RString 管内住所編集_住所編集方法;
    private RString 住所編集_方書表示有無;
    private RString 都道府県名;
    private RString 郡名;
    private RString 市町村名;
}
