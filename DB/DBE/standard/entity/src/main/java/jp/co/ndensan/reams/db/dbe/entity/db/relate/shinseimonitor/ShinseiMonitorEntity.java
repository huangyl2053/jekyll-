/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請モニタリストのEntityです。
 *
 * @reamsid_L DBE-1390-100 suguangjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiMonitorEntity {

    private RString 申請書管理番号;
    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名カナ;
    private RString 氏名;
    private RString 保険者名;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 認定申請区分申請時コード;
    private FlexibleDate 認定申請年月日;
    private RString 前回申請管理番号;
    private RString 前回申請区分;
    private FlexibleDate 前回認定申請年月日;
    private RString 前回二次判定結果コード;
    private RString 厚労省認定ソフトバージョン;
    private int 前回月数;
    private FlexibleDate 前回認定有効期間開始日;
    private FlexibleDate 前回認定有効期間終了日;
    private RString 調査事業所;
    private RString 調査員氏名;
    private RString 医療機関名;
    private RString 主治医氏名;
    private RString 住民状態コード;
    private FlexibleDate 消除異動年月日;

}
