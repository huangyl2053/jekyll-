/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput;

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

    private RString t5101_証記載保険者番号;
    private RString t5101_被保険者番号;
    private RString t5101_被保険者氏名;
    private RString t5101_認定申請年月日;
    private boolean t5101_施設入所の有無;
    private RString t7051_市町村名称;
    private RString t5101_申請書管理番号;
    private RDateTime t5115_イメージ共有ファイルID;
    private RString t5912_主治医コード;
    private RString t5912_主治医氏名;
    private RString t5911_主治医医療機関コード;
    private RString t5911_医療機関名称;
    private RString t5101_厚労省IF識別コード;
    private RString t5301_主治医意見書作成依頼年月日;
    private RString t5301_主治医意見書依頼区分;
    private RString t5301_主治医医療機関コード;
    private RString t5301_主治医コード;
    private int t5301_主治医意見書作成依頼履歴番号;

}
