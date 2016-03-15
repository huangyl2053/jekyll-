/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動者情報
 */
@lombok.Getter
@lombok.Setter
public class TsuchiShoHakkoGoIdosha {

    public TsuchiShoHakkoGoIdosha() {
    }

    public TsuchiShoHakkoGoIdosha(int 帳票ID, YMDHMS 帳票作成日時, TsuchishoNo 通知書番号, HihokenshaNo 被保険者番号, int 該当連番, FlexibleDate 異動日, RString 異動内容, YMDHMS 計算処理日時, IName 氏名) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
        this.通知書番号 = 通知書番号;
        this.被保険者番号 = 被保険者番号;
        this.該当連番 = 該当連番;
        this.異動日 = 異動日;
        this.異動内容 = 異動内容;
        this.計算処理日時 = 計算処理日時;
        this.氏名 = 氏名;
    }

    private int 帳票ID;
    private YMDHMS 帳票作成日時;
    private TsuchishoNo 通知書番号;
    private HihokenshaNo 被保険者番号;
    private int 該当連番;
    private FlexibleDate 異動日;
    private RString 異動内容;
    private YMDHMS 計算処理日時;
    private IName 氏名;

}
