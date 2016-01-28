/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御汎用エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7067ChohyoSeigyoHanyoEntityGenerator {

    public static final SubGyomuCode DEFAULT_サブ業務コード = new SubGyomuCode("DBZ");
    public static final ReportId DEFAULT_帳票分類ID = new ReportId("0000000001");
    public static final FlexibleYear DEFAULT_管理年度 = new FlexibleYear("2016");
    public static final RString DEFAULT_項目名 = new RString("Data");
    public static final RString DEFAULT_設定値 = new RString("Data");
    public static final RString DEFAULT_説明 = new RString("Data");
    public static final boolean DEFAULT_変更可否 = false;
    public static final SubGyomuCode DEFAULT_コードマスタサブ業務コード = new SubGyomuCode("DBZ");
    public static final CodeShubetsu DEFAULT_コードマスタコード種別 = new CodeShubetsu("0001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7067ChohyoSeigyoHanyoEntityGenerator() {
    }

    public static DbT7067ChohyoSeigyoHanyoEntity createDbT7067ChohyoSeigyoHanyoEntity() {
        DbT7067ChohyoSeigyoHanyoEntity entity = new DbT7067ChohyoSeigyoHanyoEntity();
        entity.setSubGyomuCode(DEFAULT_サブ業務コード);
        entity.setChohyoBunruiID(DEFAULT_帳票分類ID);
        entity.setKanriNendo(DEFAULT_管理年度);
        entity.setKomokuName(DEFAULT_項目名);
        entity.setKomokuValue(DEFAULT_設定値);
        entity.setKomokuSetsumei(DEFAULT_説明);
        entity.setHenkoKahi(DEFAULT_変更可否);
        entity.setCodeMasterSubGyomuCode(DEFAULT_コードマスタサブ業務コード);
        entity.setCodeMasterCodeShubetsu(DEFAULT_コードマスタコード種別);
        return entity;
    }
}
