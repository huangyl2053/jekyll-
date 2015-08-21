/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.testhelper.helper;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * DBテストでCSVデータを利用するためのユーティリティクラスです。<br />
 * 当クラスを使用した場合、引数で渡されたSQLセッション内での処理となるのでコミットされません。<br />
 * csvはsrc/test/resources内の、業務コード/サブ業務コード/指定パッケージ（デフォルトはpersistence）/helperに配置してください。
 *
 * @author N2203 木下 慶悟
 */
public class CSVDataUtilForUseSession extends CSVDataUtilBase {

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定しないコンストラクタです。<br />
     * persistenceで使用する事を想定しています。
     *
     */
    public CSVDataUtilForUseSession() {
        super();
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * _ControlDataHolderを特別に直接使用しています。（TestHelperのみの特例です）
     *
     * @param packageName パッケージ名
     */
    public CSVDataUtilForUseSession(RString packageName) {
        super(packageName);
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * _ControlDataHolderを特別に直接使用しています。（TestHelperのみの特例です）<br />
     * packageName の配下に任意の数の subPackageName を作成します。
     *
     * @param packageName パッケージ名
     * @param subPackageName サブパッケージ名
     */
    public CSVDataUtilForUseSession(RString packageName, RString... subPackageName) {
        super(packageName, subPackageName);
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * パッケージはデフォルトの{@literal persistence}となります。
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     */
    public CSVDataUtilForUseSession(SubGyomuCode subGyomuCode) {
        super(subGyomuCode);
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     * @param packageName CSVファイルが格納されているパッケージ名
     * @param subPackageNames CSVファイルが格納されているサブパッケージ名リスト
     */
    public CSVDataUtilForUseSession(SubGyomuCode subGyomuCode, RString packageName, RString... subPackageNames) {
        super(subGyomuCode, packageName, subPackageNames);
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     * @param packageName CSVファイルが格納されているパッケージ名
     * @param subPackageNameList CSVファイルが格納されているサブパッケージ名リスト
     */
    public CSVDataUtilForUseSession(SubGyomuCode subGyomuCode, RString packageName, List<RString> subPackageNameList) {
        super(subGyomuCode, packageName, subPackageNameList);
    }

    /**
     * 引数で指定したテーブルのデータを全件削除します。<br />
     * 当メソッドを使用して削除したテーブルは<br />
     * テスト後にロールバックされ、データが復元されることを想定しています。
     *
     * @param session SQLセッション
     * @param tableNames テーブル名
     */
    public void clearTable(SqlSession session, String... tableNames) {
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        for (String str : tableNames) {
            RString tableName = new RString(str);
            this.clearTable(session, tableName);
        }
    }

    /**
     * 事前準備を行います。<br />
     * テーブルのデータをバックアップファイルに書き出し、テストデータを注入します。<br />
     * テストデータファイルの名前は「(tableName).csv」としてください。
     *
     * @param session SQLセッション
     * @param tableNames テーブル名
     */
    public void prepare(SqlSession session, String... tableNames) {
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        for (String str : tableNames) {
            RString tableName = new RString(str);
            populate(session, tableName);
        }
    }

    /**
     * 事前準備を行います。<br />
     * 一時テーブルを作成し、テストデータを注入します。<br />
     * テストデータファイルの名前は「(tableName).csv」としてください。
     *
     * @param session 一時テーブル作成に使うSQLセッション
     * @param tempTableName 一時テーブル名
     * @param entity 一時テーブルのレコードとマッピング可能なエンティティ
     */
    public void prepare(SqlSession session, String tempTableName, IDbAccessable entity) {
        createTempTable(session, new RString(tempTableName), entity);
        populate(session, new RString(tempTableName));
    }

    private void clearTable(SqlSession session, RString tableName) {
        getHelper().truncateTable(session, tableName);
    }

    private void populate(SqlSession session, RString tableName) {
        getHelper().cleanInsertTestDataFiles(session, tableName, createTestFilePath(tableName));
    }

    private void createTempTable(SqlSession session, RString tempTableName, IDbAccessable entity) {
        getHelper().createTempTable(session, tempTableName, entity);
    }
}
