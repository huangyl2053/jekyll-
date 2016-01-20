/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity;

import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者関連帳票発行指示データEntity
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TatokuKanrenChohyoShijiDataEntity {

    private YubinNo 保険者郵便番号;
    private BunshoNo 文書番号;
    private RString 保険者住所;
    private FlexibleDate 発行年月日;
    private RString 保険者名;
    private RString 保険者名敬称;
    private RString 担当部署名;
    private RString 担当部署名敬称;
    private RString 被保険者番号;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private FlexibleDate 入所年月日;
    private ShikibetsuCode 識別コード;

}
