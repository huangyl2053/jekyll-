/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイルに関する共通的な処理を扱います。
 */
public final class Files {

    private Files() {
    }

    /**
     * @param directoryPath ディレクトリのパス
     * @return 指定のディレクトリ内のすべてのファイルパス(サブディレクトリ内も含む)
     */
    public static List<RString> findFilePathsIn(RString directoryPath) {
        return findFilePathsIn(new File(directoryPath.toString()));
    }

    /**
     * @param file ファイル.
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
