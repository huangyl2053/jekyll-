/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成報酬照会のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
@lombok.Getter
@lombok.Setter
public class IkenshoHoshuShokaiRelateEntity {

    private RString 市町村コード;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private RString 主治医氏名;
    private FlexibleDate 主治医意見書作成依頼年月日;
    private FlexibleDate 主治医意見書記入年月日;
    private FlexibleDate 主治医意見書受領年月日;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 在宅_新;
    private RString 在宅_継;
    private RString 施設_新;
    private RString 施設_継;
    private RString 主治医意見書依頼区分;
    private RString 主治医コード;
    private int 主治医意見書作成料;
    private int 主治医意見書別途診療費;
    private int 主治医意見書報酬;
    private RString 申請書管理番号;
    private int 主治医意見書作成依頼履歴番号;
    private int 在新_合計;
    private int 在継_合計;
    private int 施新_合計;
    private int 施継_合計;
    private int 作成料_合計;
    private int 診断検査費用_合計;
    private int 合計;
    private int 件数;
}
