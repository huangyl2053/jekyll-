/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 帳票分類管理エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7068ChohyoBunruiKanriEntityGenerator {

    public static final SubGyomuCode DEFAULT_サブ業務コード = new SubGyomuCode("000001");
    public static final ReportId DEFAULT_帳票ID = new ReportId("000001");
    public static final ReportId DEFAULT_帳票分類ID = new ReportId("000001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7068ChohyoBunruiKanriEntityGenerator() {
    }

    public static DbT7068ChohyoBunruiKanriEntity createDbT7068ChohyoBunruiKanriEntity() {
        DbT7068ChohyoBunruiKanriEntity entity = new DbT7068ChohyoBunruiKanriEntity();
        entity.setSubGyomuCode(DEFAULT_サブ業務コード);
        entity.setReportID(DEFAULT_帳票ID);
        entity.setChohyoBunruiID(DEFAULT_帳票分類ID);
        return entity;
    }
}
