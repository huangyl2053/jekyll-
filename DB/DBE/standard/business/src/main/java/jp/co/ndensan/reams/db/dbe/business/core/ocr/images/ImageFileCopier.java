/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.images;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * OCR取込処理のために、指定の方法でイメージファイルをコピーします。
 */
public final class ImageFileCopier {

    private static final RString SEPARATOR = new RString(java.io.File.separator);

    private final RString directoryPath;
    private final OcrFiles imageFileFullPaths;
    private final IFileNameConvertionTheory theory;

    private ImageFileCopier(Builder aThis) {
        this.directoryPath = aThis.direcotryPath;
        this.imageFileFullPaths = aThis.ocrFiles;
        this.theory = aThis.theory;
    }

    /**
     * ファイルのコピーを行うためのパラメータの指定を開始します。 最初にコピー先のディレクトリを指定します。
     * <p/>
     * 後のメソッドに指定されたパラメータを利用して、ファイルのコピーを行います。
     *
     * @param directoryPath コピー先のディレクトリパス
     * @return {@link IOcrFilesBuilder}
     */
    public static IOcrFilesBuilder destinationDirecotry(RString directoryPath) {
        return new Builder(directoryPath);
    }

    /**
     * 指定のファイルをコピーします。
     *
     * @param imageFileNames コピー対象のファイル
     * @return {@link IProcessingResult}
     */
    public IProcessingResult copy(List<RString> imageFileNames) {
        List<RString> imagesNotFound = new ArrayList<>();
        for (RString imageFileName : imageFileNames) {
            RString path = imageFileFullPaths.findFilePathFromName(imageFileName);
            if (RString.isNullOrEmpty(path)) {
                imagesNotFound.add(imageFileName);
                continue;
            }
            RString newFilePath = new RStringBuilder(directoryPath).append(SEPARATOR).append(theory.convert(imageFileName)).toRString();
            File.copy(path, newFilePath);
        }
        if (!imagesNotFound.isEmpty()) {
            return warningHavingNotFoundImages(imagesNotFound);
        }
        return ProcessingResultFactory.success();
    }

    private static IProcessingResult warningHavingNotFoundImages(Iterable<? extends RString> notFoundImages) {
        RStringBuilder builder = new RStringBuilder()
                .append("以下のイメージファイルは、アップロードされなかったため、取り込めませんでした。\n");
        for (RString a : notFoundImages) {
            builder.append(RString.HALF_SPACE).append(a);
        }
        return ProcessingResultFactory.warning(builder.toRString());
    }

    /**
     * {@link OcrFiles}を指定します。
     */
    public interface IOcrFilesBuilder {

        /**
         * @param ocrFiles ファイル名のフルパスを取得する{@link OcrFiles}
         * @return {@link ITheoryBuilder}
         */
        ITheoryBuilder ocrFiles(OcrFiles ocrFiles);
    }

    /**
     * {@link IFileNameConvertionTheory}を指定し、{@link ImageFileCopier}を生成します。
     */
    public interface ITheoryBuilder {

        /**
         * @param theory ファイル名の変換方法を定義した{@link IFileNameConvertionTheory}
         * @return {@link IImageFileCopierBuilder}
         */
        ImageFileCopier theory(IFileNameConvertionTheory theory);
    }

    private static final class Builder implements IOcrFilesBuilder, ITheoryBuilder {

        private RString direcotryPath;
        private OcrFiles ocrFiles;
        private IFileNameConvertionTheory theory;

        private Builder(RString direcotryPath) {
            this.direcotryPath = direcotryPath;
        }

        @Override
        public ITheoryBuilder ocrFiles(OcrFiles ocrFiles) {
            this.ocrFiles = ocrFiles;
            return this;
        }

        @Override
        public ImageFileCopier theory(IFileNameConvertionTheory theory) {
            this.theory = theory;
            return new ImageFileCopier(this);
        }
    }
}
