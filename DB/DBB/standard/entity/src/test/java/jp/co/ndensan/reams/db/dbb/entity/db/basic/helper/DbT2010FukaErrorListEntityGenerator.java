/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課エラー一覧エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2010FukaErrorListEntityGenerator {

    public static final SubGyomuCode DEFAULT_サブ業務コード = new GyomuCode("DB");
    public static final RString DEFAULT_内部帳票ID = new RString("Data");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1990");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo();
    public static final RDateTime DEFAULT_内部帳票作成日時 = RDateTime.of(1990, 1, 1, 8, 30, 0, 0);
    public static final RString DEFAULT_バッチID = new RString("Data");
    public static final RDateTime DEFAULT_バッチ起動日時 = RDateTime.of(1990, 1, 1, 8, 30, 0, 0);
    public static final Code DEFAULT_エラーコード = new Code();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final Code DEFAULT_処理区分コード = new Code();

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2010FukaErrorListEntityGenerator() {
    }

    public static DbT2010FukaErrorListEntity createDbT2010FukaErrorListEntity() {
        DbT2010FukaErrorListEntity entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(DEFAULT_サブ業務コード);
        entity.setInternalReportId(DEFAULT_内部帳票ID);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setInternalReportCreationDateTime(DEFAULT_内部帳票作成日時);
        entity.setBatchId(DEFAULT_バッチID);
        entity.setBatchStartingDateTime(DEFAULT_バッチ起動日時);
        entity.setErrorCode(DEFAULT_エラーコード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShoriKubunCode(DEFAULT_処理区分コード);
        return entity;
    }
}
