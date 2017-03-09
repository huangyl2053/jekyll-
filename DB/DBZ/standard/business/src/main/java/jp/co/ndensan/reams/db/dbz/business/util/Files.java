/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイルに関する共通的な処理を扱います。
 */
public final class Files {

    private Files() {
    }

    /**
     * 指定のディレクトリ内（サブディレクトリも含む）のファイル名とそのパスのマップを生成します。
     * 同一名称のファイルが複数存在するケースに対応しません。同一名のファイルが複数存在する場合、1件の情報を残して、他は破棄されます。
     *
     * @param directoryPath ディレクトリのパス
     * @return ファイル名とファイルパスのマップ
     */
    public static Map<RString, RString> filePathByFileName(RString directoryPath) {
        return filePathsByFineName(new File(directoryPath.toString()));
    }

    /**
     * 指定のファイル内のファイル名とそのパスのマップを生成します。 ディレクトリの場合、その内部のファイルもすべて対象となります。
     * 同一名称のファイルが複数存在するケースに対応しません。同一名のファイルが複数存在する場合、1件の情報を残して、他は破棄されます。
     *
     * @param file ファイル
     * @return ファイル名とファイルパスのマップ
     */
    public static Map<RString, RString> filePathsByFineName(File file) {
        Map<RString, RString> map = new HashMap<>();
        if (file.isFile()) {
            putCanonicalPathIfPossible(map, file);
        }
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                putCanonicalPathIfPossible(map, f);
            } else {
                map.putAll(filePathsByFineName(f));
            }
        }
        return map;
    }

    private static void putCanonicalPathIfPossible(Map<RString, RString> map, File file) {
        try {
            RString pathString = new RString(file.getCanonicalPath());
            map.put(new RString(file.getName()), pathString);
        } catch (IOException ex) {
        }
    }

    /**
     * @param directoryPath ディレクトリのパス
     * @return 指定のディレクトリ内のすべてのファイルパス(サブディレクトリ内も含む)
     */
    public static List<RString> findFilePathsIn(RString directoryPath) {
        return findFilePathsIn(new File(directoryPath.toString()));
    }

    /**
     * @param file ファイル
     * @return 指定のファイルのパス.ディレクトリの場合、内包するすべてのファイル（サブディレクトリ内も含む）のパス。
     *
     */
    public static List<RString> findFilePathsIn(File file) {
        List<RString> list = new ArrayList<>();
        if (file.isFile()) {
            addCanonicalPathIfPossible(list, file);
            return list;
        }
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                addCanonicalPathIfPossible(list, f);
            } else {
                list.addAll(findFilePathsIn(f));
            }
        }
        return list;
    }

    private static void addCanonicalPathIfPossible(List<RString> target, File file) {
        try {
            RString pathString = new RString(file.getCanonicalPath());
            target.add(pathString);
        } catch (IOException ex) {
        }
    }
}
