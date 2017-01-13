/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * Ocrで取り込むファイルパスの一覧を管理します。
 */
public final class OcrFiles implements Iterable<RString> {

    private static final RString PATH_SEPARATOR;

    static {
        PATH_SEPARATOR = new RString(File.separator);
    }

    private final List<RString> elements;
    private final Map<RString, RString> namePathMap;

    public OcrFiles(Collection<? extends RString> filePaths) {
        this.elements = new ArrayList<>(filePaths);
        this.namePathMap = toMap(filePaths);
    }

    OcrFiles() {
        this.elements = new ArrayList<>();
        this.namePathMap = new HashMap<>();
    }

    private static Map<RString, RString> toMap(Collection<? extends RString> filePaths) {
        Map<RString, RString> map = new HashMap<>();
        for (RString path : filePaths) {
            RString key = path.substringEmptyOnError(path.lastIndexOf(PATH_SEPARATOR) + 1);
            map.put(key, path);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 保持する要素の中からCSVファイルを検索し返します。存在しない場合は{@link RString#EMPTY}を返します。
     *
     * @return CSVファイルのパス. もしくは、{@link RString#EMPTY}.
     */
    public RString findCsvFilePath() {
        for (RString element : elements) {
            if (isCsvFile(element)) {
                return element;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 保持する要素の中からca3ファイルを検索し返します。存在しない場合は{@link RString#EMPTY}を返します。
     *
     * @return ca3ファイルのパス. もしくは、{@link RString#EMPTY}.
     */
    public RString findCa3FilePath() {
        for (RString element : elements) {
            if (isCa3File(element)) {
                return element;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 指定のファイル名（ディレクトリのパスは含まない）と対応するパスを返します。
     *
     * 存在しない場合、{@link RString#EMPTY}を返します。
     *
     * @param fileName ファイル名（ディレクトリのパスは含まない）
     * @return 絶対パス
     */
    public RString findFilePathFromName(RString fileName) {
        RString path = this.namePathMap.get(fileName);
        return path == null ? RString.EMPTY : path;
    }

    @Override
    public Iterator<RString> iterator() {
        return this.elements.iterator();
    }

    /**
     * @return 要素を持たないとき@code true}. それ以外は{@code false}.
     */
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    private enum FileExtentions {

        CSV(".csv"),
        CA3(".ca3");

        private final RString lowerCase;

        private FileExtentions(String lowerCase) {
            this.lowerCase = new RString(lowerCase);
        }

        private RString asLowerCase() {
            return this.lowerCase;
        }
    }

    /**
     * 指定のファイル名もしくはファイルパスがcsvファイルの物であれば{@code true}、そうでなければ{@code false}を返します。
     *
     * @param fileName ファイル名もしくはファイルパス
     * @return fileNameがcsvファイルの物であれば{@code true}、 そうでなければ{@code false}.
     */
    private static boolean isCsvFile(RString fileName) {
        return fileName.toLowerCase().endsWith(FileExtentions.CSV.asLowerCase());
    }

    /**
     * 指定のファイル名もしくはファイルパスがca3ファイルの物であれば{@code true}、そうでなければ{@code false}を返します。
     *
     * @param fileName ファイル名もしくはファイルパス
     * @return fileNameがca3ファイルの物であれば{@code true}、 そうでなければ{@code false}.
     */
    private static boolean isCa3File(RString fileName) {
        return fileName.toLowerCase().endsWith(FileExtentions.CA3.asLowerCase());
    }
}
