/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.testhelper.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
//CHECKSTYLE IGNORE ImportControl FOR NEXT 1 LINES
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;

/**
 * DBテストでCSVデータを利用するためのユーティリティクラスのベースクラスです。<br />
 * csvはsrc/test/resources内の、<br />
 * 業務コード/サブ業務コード/指定パッケージ（デフォルトはpersistence）/helper/指定サブパッケージ（任意）に配置してください。
 *
 * @author n2203 木下 慶悟
 */
public class CSVDataUtilBase {

    private static final RString DEFAULT_PACKAGE = new RString("persistence");

    private final RString gyomuCode;
    private final RString subGyomuCode;
    private final RString packageName;
    private final List<RString> subPackageNameList;
    private final DbTestHelper helper;

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定しないコンストラクタです。<br />
     * persistenceで使用する事を想定しています。
     */
    protected CSVDataUtilBase() {
        this(DEFAULT_PACKAGE);
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * _ControlDataHolderを特別に直接使用しています。（TestHelperのみの特例です）
     *
     * @param packageName パッケージ名
     */
    protected CSVDataUtilBase(RString packageName) {
        this(_ControlDataHolder.getControlData().getSubGyomuCD(), packageName, Collections.EMPTY_LIST);
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * _ControlDataHolderを特別に直接使用しています。（TestHelperのみの特例です）<br />
     * packageName の配下に任意の階層の subPackageName を作成します。
     *
     * @param packageName パッケージ名
     * @param subPackageNames サブパッケージ名
     */
    protected CSVDataUtilBase(RString packageName, RString... subPackageNames) {
        this(_ControlDataHolder.getControlData().getSubGyomuCD(), packageName, toRStringList(subPackageNames));
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     * パッケージはデフォルトの{@literal persistence}となります。
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     */
    protected CSVDataUtilBase(SubGyomuCode subGyomuCode) {
        this(subGyomuCode, DEFAULT_PACKAGE, Collections.EMPTY_LIST);
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     * @param packageName CSVファイルが格納されているパッケージ名
     * @param subPackageNames CSVファイルが格納されているサブパッケージ名リスト
     */
    protected CSVDataUtilBase(SubGyomuCode subGyomuCode, RString packageName, RString... subPackageNames) {
        this(subGyomuCode, packageName, toRStringList(subPackageNames));
    }

    /**
     * テストデータファイルを入れたhelperパッケージのあるパッケージを指定するコンストラクタです。<br />
     *
     * @param subGyomuCode CSVファイルが格納されているサブ業務コード
     * @param packageName CSVファイルが格納されているパッケージ名
     * @param subPackageNameList CSVファイルが格納されているサブパッケージ名リスト
     */
    protected CSVDataUtilBase(SubGyomuCode subGyomuCode, RString packageName, List<RString> subPackageNameList) {
        this.gyomuCode = subGyomuCode.getGyomuCode().value().toLowerCase();
        this.subGyomuCode = subGyomuCode.value().toLowerCase();
        this.packageName = packageName;
        this.subPackageNameList = subPackageNameList;
        helper = new DbTestHelper();
    }

    /**
     * DbTestHelperを返します。
     *
     * @return DbTestHelper
     */
    protected DbTestHelper getHelper() {
        return helper;
    }

    /**
     * テストファイルの格納パスを生成します。<br />
     * テストファイル名は「(tableName).csv」となります。
     *
     * @param tableName テーブル名
     * @return テストファイル格納パス
     */
    protected RString createTestFilePath(RString tableName) {
        RStringBuilder filepath = createShareFilePath();
        filepath.append(tableName.toString());
        filepath.append(".csv");
        return filepath.toRString();
    }

    /**
     * バックアップファイルの格納パスを生成します。<br />
     * バックアップファイル名は「(tableName)Backup.csv」となります。
     *
     * @param tableName テーブル名
     * @return バックアップファイル格納パス
     */
    protected RString createBackUpFilePath(RString tableName) {
        RStringBuilder filepath = createShareFilePath();
        filepath.append(tableName.toString());
        filepath.append("Backup.csv");
        return filepath.toRString();
    }

    /**
     * ファイルパスを生成します。<br />
     * （生成するパスは以下の通り） <br />
     * src/test/resources/jp/co/ndensan/reams/業務コード/サブ業務コード/パッケージ名/helper/サブパッケージ名
     * <br />
     * 「サブパッケージ名」部分にはコンストラクタで指定したsubPackageNameList分の階層を生成します。
     *
     * @return ファイルパス
     */
    protected RStringBuilder createShareFilePath() {
        RStringBuilder filepath = new RStringBuilder();
        filepath.append(System.getProperty("user.dir"));
        filepath.append(File.separator);
        filepath.append("src");
        filepath.append(File.separator);
        filepath.append("test");
        filepath.append(File.separator);
        filepath.append("resources");
        filepath.append(File.separator);
        filepath.append("jp");
        filepath.append(File.separator);
        filepath.append("co");
        filepath.append(File.separator);
        filepath.append("ndensan");
        filepath.append(File.separator);
        filepath.append("reams");
        filepath.append(File.separator);
        filepath.append(gyomuCode);
        filepath.append(File.separator);
        filepath.append(subGyomuCode);
        filepath.append(File.separator);
        filepath.append(packageName);
        filepath.append(File.separator);
        filepath.append("helper");
        filepath.append(File.separator);
        for (RString subPackageName : subPackageNameList) {
            filepath.append(subPackageName);
            filepath.append(File.separator);
        }
        return filepath;
    }

    private static List<RString> toRStringList(RString... packageNames) {
        List<RString> packageNameList = new ArrayList<>();
        packageNameList.addAll(Arrays.asList(packageNames));
        return packageNameList;
    }

}
