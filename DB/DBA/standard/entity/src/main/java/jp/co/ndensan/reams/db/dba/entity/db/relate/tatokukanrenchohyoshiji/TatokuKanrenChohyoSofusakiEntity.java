/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tatokukanrenchohyoshiji;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他住所地特例者管理のRelateEntityクラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TatokuKanrenChohyoSofusakiEntity {

    private YubinNo 郵便番号;
    private RString 住所;
    private FlexibleDate 発行年月日;
    private RString 役所名;
    private RString 役所名敬称;
    private RString 担当課名;
    private RString 担当課名敬称;
    private FlexibleDate 発行日;
    private RString 文書番号;
}
