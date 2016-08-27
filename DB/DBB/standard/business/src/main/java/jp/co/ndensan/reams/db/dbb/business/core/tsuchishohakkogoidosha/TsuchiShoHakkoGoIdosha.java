/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.db.dbb.definition.core.tsuchishohakkogoido.IdoNaiyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動者情報 通知書異動情報を格納する。
 *
 * @reamsid_L DBB-0690-020 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchiShoHakkoGoIdosha {

    private ReportId 帳票ID;
    private YMDHMS 帳票作成日時;
    private TsuchishoNo 通知書番号;
    private HihokenshaNo 被保険者番号;
    private int 該当連番;
    private FlexibleDate 異動日;
    private IdoNaiyo 異動内容;
    private YMDHMS 計算処理日時;
    private IName 氏名;
    private ShikibetsuCode 識別コード;
    private RYear 賦課年度;

    /**
     * コンストラクタです
     */
    public TsuchiShoHakkoGoIdosha() {

    }

    /**
     * コンストラクタです
     *
     * @param 帳票ID int
     * @param 帳票作成日時 YMDHMS
     * @param 通知書番号 TsuchishoNo
     * @param 被保険者番号 HihokenshaNo
     * @param 該当連番 int
     * @param 異動日 FlexibleDate
     * @param 異動内容 IdoNaiyo
     * @param 計算処理日時 YMDHMS
     * @param 氏名 IName
     * @param 識別コード ShikibetsuCode
     * @param 賦課年度 RYear
     */
    public TsuchiShoHakkoGoIdosha(ReportId 帳票ID, YMDHMS 帳票作成日時, TsuchishoNo 通知書番号, HihokenshaNo 被保険者番号, int 該当連番,
            FlexibleDate 異動日, IdoNaiyo 異動内容, YMDHMS 計算処理日時, IName 氏名, ShikibetsuCode 識別コード, RYear 賦課年度) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
        this.通知書番号 = 通知書番号;
        this.被保険者番号 = 被保険者番号;
        this.該当連番 = 該当連番;
        this.異動日 = 異動日;
        this.異動内容 = 異動内容;
        this.計算処理日時 = 計算処理日時;
        this.氏名 = 氏名;
        this.識別コード = 識別コード;
        this.賦課年度 = 賦課年度;
    }
}
