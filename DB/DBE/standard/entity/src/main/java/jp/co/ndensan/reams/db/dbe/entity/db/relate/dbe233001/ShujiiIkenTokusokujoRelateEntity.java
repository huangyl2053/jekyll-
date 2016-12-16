/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書督促状の取得のEntityクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenTokusokujoRelateEntity {

    private YubinNo temp_事業者郵便番号;
    private RString temp_市町村名称;
    private RString temp_事業者名称;
    private RString temp_事業者住所;
    private RString temp_主治医氏名;
    private RString temp_診療科名称;
    private RString temp_保険者番号;
    private RString temp_被保険者番号;
    private AtenaKanaMeisho temp_被保険者氏名カナ;
    private AtenaMeisho temp_被保険者氏名;
    private FlexibleDate temp_申請年月日;
    private Code temp_性別コード;
    private FlexibleDate temp_生年月日;
    private AtenaJusho temp_被保険者住所;
    private YubinNo temp_被保険者郵便番号;
    private ShinseishoKanriNo temp_申請書管理番号;
    private Code temp_申請区分コード;
    private RString temp_処理名;
    private DbT5301ShujiiIkenshoIraiJohoEntity 主治医意見書依頼情報;

    /**
     * デフォルトコンストラクタです。
     */
    public ShujiiIkenTokusokujoRelateEntity() {
        主治医意見書依頼情報 = new DbT5301ShujiiIkenshoIraiJohoEntity();
    }
}
