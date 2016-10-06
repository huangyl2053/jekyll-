/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.testhelper.helper;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
//CHECKSTYLE IGNORE ImportControl FOR NEXT 1 LINES
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBテストでCSVデータを利用するためのユーティリティクラスです。<br />
 * 当クラスを使用した場合、別セッションでの動作となるのでコミットされることに注意してください。<br />
 * csvはsrc/test/resources内の、業務コード/サブ業務コード/指定パッケージ（デフォルトはpersistence）/helperに配置してください。
 *
 * @author n3309 後藤貴幸
 */
public class CSVDataUtil extends CSVDataUtilBase {

    private GyomuCode targetCode;

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定しないコンストラクタです。<br />
     * persistenceで使用する事を想定しています。
     *
     */
    public CSVDataUtil() {
        super();
        targetCode = _ControlDataHolder.getControlData().getGyomuCD();
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * _ControlDataHolderを特別に直接使用しています。（TestHelperのみの特例です）
     *
     * @param packageName パッケージ名
     */
    public CSVDataUtil(RString packageName) {
        super(packageName);
        targetCode = _ControlDataHolder.getControlData().getGyomuCD();
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * _ControlDataHolderを特別に直接使用しています。（TestHelperのみの特例です）<br />
     * packageName の配下に任意の数の subPackageName を作成します。
     *
     * @param packageName パッケージ名
     * @param subPackageName サブパッケージ名
     */
    public CSVDataUtil(RString packageName, RString... subPackageName) {
        super(packageName, subPackageName);
        targetCode = _ControlDataHolder.getControlData().getGyomuCD();
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * パッケージはデフォルトの{@literal persistence}となります。
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     */
    public CSVDataUtil(SubGyomuCode subGyomuCode) {
        super(subGyomuCode);
        targetCode = subGyomuCode.getGyomuCode();
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     * @param packageName CSVファイルが格納されているパッケージ名
     * @param subPackageNameList CSVファイルが格納されているサブパッケージ名リスト
     */
    public CSVDataUtil(SubGyomuCode subGyomuCode, RString packageName, List<RString> subPackageNameList) {
        super(subGyomuCode, packageName, subPackageNameList);
        targetCode = subGyomuCode.getGyomuCode();
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     * @param packageName CSVファイルが格納されているパッケージ名
     * @param subPackageNames CSVファイルが格納されているサブパッケージ名リスト
     */
    public CSVDataUtil(SubGyomuCode subGyomuCode, RString packageName, RString... subPackageNames) {
        super(subGyomuCode, packageName, subPackageNames);
        targetCode = subGyomuCode.getGyomuCode();
    }

    /**
     * 対象となるテーブルの業務コードを設定します。
     *
     * @param code テストデータを入れたいテーブルの業務コード
     * @throws NullPointerException 引数が{@code null}の場合
     */
    public void setTargetGyomu(GyomuCode code) throws NullPointerException {
        requireNonNull(code, "業務コードがnullです。");
        targetCode = code;
    }

    /**
     * テーブルのデータをバックアップファイルに書き出します。<br />
     * 「(tableName)Backup.csv」というファイルが生成されます。<br />
     * 同名のファイルが存在する場合上書きされます。<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     *
     * @param code バックアップを取りたいテーブルの業務コード
     * @param tableNames テーブル名
     */
    public void backup(GyomuCode code, String... tableNames) {
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        for (String str : tableNames) {
            RString tableName = new RString(str);
            this._backup(code, tableName);
        }
    }

    /**
     * 事前準備を行います。<br />
     * テーブルのデータをバックアップファイルに書き出し、テストデータを注入します。<br />
     * 「(tableName)Backup.csv」というファイルが生成されます。<br />
     * 同名のファイルが存在する場合上書きされます。<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * テストデータファイルの名前は「(tableName).csv」としてください。 <br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param code テストデータを入れたいテーブルの業務コード
     * @param tableNames テーブル名
     */
    public void prepare(GyomuCode code, String... tableNames) {
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        for (String str : tableNames) {
            RString tableName = new RString(str);
            this._backup(code, tableName);
            RString path = createTestFilePath(tableName);
            if (File.exists(path)) {
                this.populate(code, tableName);
            } else {
                this.clearTable(code, tableName);
            }
        }
    }

    /**
     * 事前準備を行います。<br />
     * テーブルのデータをバックアップファイルに書き出し、テストデータを注入します。<br />
     * 「(tableName)Backup.csv」というファイルが生成されます。<br />
     * 同名のファイルが存在する場合上書きされます。<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * テストデータファイルの名前は「(tableName).csv」としてください。<br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param code テストデータを入れたいテーブルの業務コード
     * @param tableNames テーブル名
     */
    public void prepare(GyomuCode code, List<String> tableNames) {
        //CHECKSTYLE IGNORE IllegalToken FOR NEXT 1 LINES
        this.prepare(code, tableNames.toArray(new String[tableNames.size()]));
    }

    /**
     * 事前準備を行います。<br />
     * デフォルトでは自業務の業務コードを使用します。<br />
     * テーブルのデータをバックアップファイルに書き出し、テストデータを注入します。<br />
     * 「(tableName)Backup.csv」というファイルが生成されます。<br />
     * 同名のファイルが存在する場合上書きされます。<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * テストデータファイルの名前は「(tableName).csv」としてください。<br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param tableNames テーブル名
     */
    public void prepare(String... tableNames) {
        this.prepare(targetCode, tableNames);
    }

    /**
     * 事前準備を行います。<br />
     * デフォルトでは自業務の業務コードを使用します。<br />
     * テーブルのデータをバックアップファイルに書き出し、テストデータを注入します。<br />
     * 「(tableName)Backup.csv」というファイルが生成されます。<br />
     * 同名のファイルが存在する場合上書きされます。<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * テストデータファイルの名前は「(tableName).csv」としてください。<br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param tableNames テーブル名
     */
    public void prepare(List<String> tableNames) {
        this.prepare(targetCode, tableNames);
    }

    /**
     * テーブルのデータをバックアップファイルから復帰させます。<br />
     * バックアップからの復帰後、ファイルは削除されます。<br />
     * 「(tableName)Backup.csv」というファイルを同じフォルダに入れている場合削除されますので、<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param code テストデータを入れたテーブルの業務コード
     * @param tableNames テーブル名
     */
    public void rollback(GyomuCode code, String... tableNames) {
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        for (String str : tableNames) {
            this.rollback(code, new RString(str));
        }
    }

    /**
     * テーブルのデータをバックアップファイルから復帰させます。<br />
     * バックアップからの復帰後、ファイルは削除されます。<br />
     * 「(tableName)Backup.csv」というファイルを同じフォルダに入れている場合削除されますので、<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param code テストデータを入れたテーブルの業務コード
     * @param tableNames テーブル名
     */
    public void rollback(GyomuCode code, List<String> tableNames) {
        //CHECKSTYLE IGNORE IllegalToken FOR NEXT 1 LINES
        this.rollback(code, tableNames.toArray(new String[tableNames.size()]));
    }

    /**
     * テーブルのデータをバックアップファイルから復帰させます。<br />
     * デフォルトでは自業務の業務コードを使用します。<br />
     * バックアップからの復帰後、ファイルは削除されます。<br />
     * 「(tableName)Backup.csv」というファイルを同じフォルダに入れている場合削除されますので、<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param tableNames テーブル名
     */
    public void rollback(String... tableNames) {
        this.rollback(targetCode, tableNames);
    }

    /**
     * テーブルのデータをバックアップファイルから復帰させます。<br />
     * デフォルトでは自業務の業務コードを使用します。<br />
     * バックアップからの復帰後、ファイルは削除されます。<br />
     * 「(tableName)Backup.csv」というファイルを同じフォルダに入れている場合削除されますので、<br />
     * テストデータのバックアップを取る場合は別の名前をつけるようにしてください。<br />
     * このメソッドは別セッションでの動作となるので、コミットされることに注意して下さい。
     *
     * @param tableNames テーブル名
     */
    public void rollback(List<String> tableNames) {
        this.rollback(targetCode, tableNames);
    }

    private void _backup(GyomuCode code, RString tableName) {
        getHelper().exportTableData(code, tableName, createBackUpFilePath(tableName));
    }

    private void populate(GyomuCode code, RString tableName) {
        getHelper().cleanInsertTestDataFiles(code, tableName, createTestFilePath(tableName));
    }

    private void clearTable(GyomuCode code, RString tableName) {
        getHelper().truncateTable(code, tableName);
    }

    private void rollback(GyomuCode code, RString tableName) {
        RString filePath = createBackUpFilePath(tableName);
        getHelper().cleanInsertTestDataFiles(code, tableName, filePath);
        File.deleteIfExists(filePath);
    }
}
