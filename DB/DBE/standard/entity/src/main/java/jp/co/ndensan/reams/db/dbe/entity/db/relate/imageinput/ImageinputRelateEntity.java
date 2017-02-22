/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込み関連データRelateEntityクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageinputRelateEntity {

    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 被保険者カナ;
    private FlexibleDate 認定申請年月日;
    private boolean 施設入所の有無;
    private RString 申請書管理番号;
    private boolean 論理削除フラグ;
    private RDateTime イメージ共有ファイルID;
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private RString 厚労省IF識別コード;
    private FlexibleDate 主治医意見書作成依頼年月日;
    private RString 主治医意見書依頼区分;
    private int 主治医意見書作成依頼履歴番号;
    private FlexibleDate 意見書作成依頼完了日;
    private Boolean 仮一次判定区分;
    private List<DbT5302ShujiiIkenshoJohoEntity> 主治医意見書情報;
    private List<DbT5305IkenshoImageJohoEntity> 意見書イメージ情報;
    private boolean matches指定申請日;

}
