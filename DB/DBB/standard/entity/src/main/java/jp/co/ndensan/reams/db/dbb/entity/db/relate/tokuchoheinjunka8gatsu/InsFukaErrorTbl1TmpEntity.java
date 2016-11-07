/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴平準化（特徴8月分）バッチTemp賦課エラー一覧です。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsFukaErrorTbl1TmpEntity extends DbTableEntityBase<InsFukaErrorTbl1TmpEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private SubGyomuCode subGyomuCode;
    @TempTableColumnOrder(2)
    private RString naibuChouhouID;
    @TempTableColumnOrder(3)
    //private RDateTime 内部帳票作成日時;
    private YMDHMS naibuChouhouSakuseiTime;
    @TempTableColumnOrder(4)
    //private FlexibleYear 賦課年度;
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(5)
    //private RString 通知書番号;
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(6)
    private RString batchID;
    @TempTableColumnOrder(7)
    //バッチ起動日時;
    private RDateTime batchKidouTime;
    @TempTableColumnOrder(8)
    // エラーコード;
    private RString errorCode;
    @TempTableColumnOrder(9)
    //被保険者番号;
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(10)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(11)
    //@PrimaryKey
    private Code shoriKubunCode;
    @TempTableColumnOrder(12)
    //private int 資格取得年月日;
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(13)
    //private HihokenshaNo 資格取得事由コード;
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(14)
    // 資格喪失年月日;
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(15)
    //資格喪失事由コート;
    private RString shikakuSoshitsuJiyuCode;

}
