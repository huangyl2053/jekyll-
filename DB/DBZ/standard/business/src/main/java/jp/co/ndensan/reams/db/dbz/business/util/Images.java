/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.util;

import java.io.File;
import java.nio.file.Files;
import jp.co.ndensan.reams.uz.uza.externalcharacter.util._Base64Converter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * UIでイメージファイルを扱う際の共通的な処理を提供します。
 */
public final class Images {

    private static final RString REPLACEE = new RString("xxx");
    private static final RString IMAGE_HEADER
            = new RStringBuilder().append("data:image/").append(REPLACEE).append(";base64,").toRString();

    private Images() {
    }

    /**
     * 扱うイメージファイルの拡張子です。
     */
    public static enum FileExtentions {

        PNG("png");

        private final RString aValue;

        private FileExtentions(String value) {
            this.aValue = new RString(value);
        }

        RString value() {
            return this.aValue;
        }

        static FileExtentions acquireFromPath(RString pathString) {
            for (FileExtentions e : values()) {
                if (pathString.toLowerCase().endsWith(e.value().toLowerCase())) {
                    return e;
                }
            }
            return null;
        }
    }

    /**
     * @param filePath イメージファイルのパス
     * @return 指定のイメージファイルをhtmlで表示可能な形式へ変換した結果の文字列
     */
    public static RString toBinaryString(RString filePath) {
        File file = new File(filePath.toString());
        if (!file.exists()) {
            return RString.EMPTY;
        }
        FileExtentions ext = FileExtentions.acquireFromPath(filePath);
        if (ext == null) {
            return RString.EMPTY;
        }
        try {
            return new RStringBuilder()
                    .append(IMAGE_HEADER.replace(REPLACEE, ext.value()))
                    .append(_Base64Converter.encodeBase64RString(Files.readAllBytes(file.toPath())))
                    .toRString();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
