/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.IFileNameConvertionTheory;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 */
public class ImageJohoUpdater {

    private static final RString SEPARATOR = new RString(java.io.File.separator);

    private final ShinseishoKanriNo 申請書管理番号;
    private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    private final RDateTime 共有ファイルID;
    private final OcrFiles imageFilePaths;
    private final List<RString> targetImageFileNames;
    private final IFileNameConvertionTheory fileNameTheory;
    private final IOcrData ocrData;

    private ImageJohoUpdater(Builder builder) {
        this.申請書管理番号 = builder.申請書管理番号;
        this.証記載保険者番号 = builder.証記載保険者番号;
        this.被保険者番号 = builder.被保険者番号;
        this.共有ファイルID = builder.共有ファイルID;
        this.imageFilePaths = builder.imageFilePaths;
        this.targetImageFileNames = builder.targetImageFileNames;
        this.fileNameTheory = builder.theory;
        this.ocrData = builder.ocrData;
    }

    public static IStartBuilder shinseiKey(ShinseishoKanriNo 申請書管理番号, RString 証記載保険者番号, RString 被保険者番号) {
        return new Builder(申請書管理番号, 証記載保険者番号, 被保険者番号);
    }

    public Result save(IBatchTableWriter<? super DbT5115ImageEntity> dbWriter) {
        ProcessingResults result = new ProcessingResults();

        RString targetDirectoryPath = Directory.createTmpDirectory();
        CopyImageResult copyImageResult = copyImageFilesToDirectory(targetImageFileNames, targetDirectoryPath,
                imageFilePaths, fileNameTheory);
        if (!copyImageResult.getImagesNotFound().isEmpty()) {
            result.add(ProcessingResultFactory.warning(ocrData, OcrTorikomiMessages.TODO));
        }
        if (this.共有ファイルID == null) {
            SharedFileEntryDescriptor sfed = defineAndCopyToSharedFile(new FilesystemPath(targetDirectoryPath),
                    compose共有ファイル名(this.証記載保険者番号, this.被保険者番号));
            insertIntoImageJohoBy(dbWriter, this.申請書管理番号, sfed);
            return new Result(sfed.getSharedFileId(), result);
        } else {
            ReadOnlySharedFileEntryDescriptor ro_sfd = new ReadOnlySharedFileEntryDescriptor(
                    compose共有ファイル名(this.証記載保険者番号, this.被保険者番号), this.共有ファイルID);
            deletePastFiles(ro_sfd, copyImageResult.getSavingImageFileNames());
            SharedFile.appendNewFile(ro_sfd, new FilesystemPath(targetDirectoryPath), RString.EMPTY.toString(),
                    new SharedAppendOption().overWrite(true));
            return new Result(this.共有ファイルID, result);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="comment">
    private static CopyImageResult copyImageFilesToDirectory(List<RString> targetImageFileNames, RString targetDirectoryPath,
            OcrFiles imageFilePaths, IFileNameConvertionTheory fileNameTheory) {
        List<RString> imagesNotFound = new ArrayList<>(),
                savingImageFileNames = new ArrayList<>();
        for (RString imageFileName : targetImageFileNames) {
            RString fromPath = imageFilePaths.findFilePathFromName(imageFileName);
            if (RString.isNullOrEmpty(fromPath)) {
                imagesNotFound.add(imageFileName);
                continue;
            }
            RString convertedFileName = fileNameTheory.convert(imageFileName);
            savingImageFileNames.add(convertedFileName);
            RString destinationPath = new RStringBuilder(targetDirectoryPath).append(SEPARATOR).append(convertedFileName).toRString();
            File.copy(fromPath, destinationPath);
        }
        return new CopyImageResult(imagesNotFound, savingImageFileNames);
    }

    private static FilesystemName compose共有ファイル名(RString 証記載保険者番号1, RString 被保険者番号1) {
        return FilesystemName.fromString(証記載保険者番号1.concat(被保険者番号1));
    }

    private static SharedFileEntryDescriptor defineAndCopyToSharedFile(FilesystemPath targetDirectoryPath, FilesystemName sharedFileName) {
        SharedFileDescriptor sfd = SharedFile.defineSharedFile(sharedFileName);
        CopyToSharedFileOpts option = new CopyToSharedFileOpts().dateToDelete(RDate.MAX);
        SharedFileEntryDescriptor sfed = SharedFile.copyToSharedFile(sfd, targetDirectoryPath, option);
        return sfed;
    }

    private static void insertIntoImageJohoBy(IBatchTableWriter<? super DbT5115ImageEntity> dbWriter,
            ShinseishoKanriNo 申請書管理番号, SharedFileEntryDescriptor sfed) {
        DbT5115ImageEntity entityImage = new DbT5115ImageEntity();
        entityImage.setShinseishoKanriNo(申請書管理番号);
        entityImage.setImageSharedFileId(sfed.getSharedFileId());
        dbWriter.insert(entityImage);
    }

    private static void deletePastFiles(ReadOnlySharedFileEntryDescriptor ro_sfd, List<RString> saveFileNames) {
        List<RString> filePaths = listFilePathsInEntry(ro_sfd);
        for (RString target : saveFileNames) {
            deletePastFiles(target, filePaths, ro_sfd);
        }
    }

    private static List<RString> listFilePathsInEntry(ReadOnlySharedFileEntryDescriptor ro_sfd) {
        List<RString> list = new ArrayList<>();
        for (SharedFileEntryInfoEntity entity : SharedFile.getEntryInfo(ro_sfd)) {
            if (entity.getFilesEntity() == null) {
                continue;
            }
            list.add(entity.getFilesEntity().getPathname());
        }
        return list;
    }

    private static final RString PNG_EXTENTION = new RString("\\.(png|PNG)");

    private static void deletePastFiles(RString fileName, List<RString> filePaths,
            ReadOnlySharedFileEntryDescriptor ro_sfd) {
        for (RString filePath : filePaths) {
            if (fileNamePattern(fileName).matcher(filePath.toString()).find()) {
                SharedFile.deleteFileInEntry(ro_sfd, filePath.toString());
            }
        }
    }

    private static Pattern fileNamePattern(RString fileName) {
        return Pattern.compile(new RStringBuilder().append(fileName).append(PNG_EXTENTION).toString());
    }
    //</editor-fold>

    @lombok.Value
    private static class CopyImageResult {

        private List<RString> imagesNotFound, savingImageFileNames;
    }

    /**
     *
     */
    @lombok.Value
    public static class Result {

        private RDateTime 共有ファイルID;
        private IProcessingResults results;
    }

    public interface IShareFileIDBuilder {

        IOcrFilesBuilder sharedFileID(RDateTime 共有ファイルID);

    }

    /**
     *
     */
    public interface IStartBuilder extends IShareFileIDBuilder, IOcrFilesBuilder {
    }

    /**
     * {@link OcrFiles}を指定します。
     */
    public interface IOcrFilesBuilder {

        /**
         * @param ocrFiles ファイル名のフルパスを取得する{@link OcrFiles}
         * @return {@link ITheoryBuilder}
         */
        ITheoryBuilder imageFilePaths(OcrFiles ocrFiles);
    }

    /**
     * {@link IFileNameConvertionTheory}を指定します。
     */
    public interface ITheoryBuilder {

        /**
         * @param theory ファイル名の変換方法を定義した{@link IFileNameConvertionTheory}
         * @return {@link IImageFileCopierBuilder}
         */
        ITargetImageFileNamesBuilder fileNameTheory(IFileNameConvertionTheory theory);
    }

    /**
     *
     */
    public interface ITargetImageFileNamesBuilder {

        IOcrDataBuilder targetImageFileNames(Collection<? extends RString> targetImageFileNames);
    }

    public interface IOcrDataBuilder {

        ImageJohoUpdater ocrData(IOcrData ocrData);
    }

    private static final class Builder implements IStartBuilder, IOcrFilesBuilder, ITheoryBuilder,
            ITargetImageFileNamesBuilder, IOcrDataBuilder {

        private final ShinseishoKanriNo 申請書管理番号;
        private final RString 証記載保険者番号;
        private final RString 被保険者番号;
        private RDateTime 共有ファイルID = null;
        private OcrFiles imageFilePaths;
        private IFileNameConvertionTheory theory;
        private List<RString> targetImageFileNames;
        private IOcrData ocrData;

        private Builder(ShinseishoKanriNo 申請書管理番号, RString 証記載保険者番号, RString 被保険者番号) {
            this.申請書管理番号 = 申請書管理番号;
            this.証記載保険者番号 = 証記載保険者番号;
            this.被保険者番号 = 被保険者番号;
        }

        @Override
        public ITheoryBuilder imageFilePaths(OcrFiles imageFilePaths) {
            this.imageFilePaths = imageFilePaths;
            return this;
        }

        @Override
        public IOcrFilesBuilder sharedFileID(RDateTime 共有ファイルID) {
            this.共有ファイルID = 共有ファイルID;
            return this;
        }

        @Override
        public ITargetImageFileNamesBuilder fileNameTheory(IFileNameConvertionTheory theory) {
            this.theory = theory;
            return this;
        }

        @Override
        public IOcrDataBuilder targetImageFileNames(Collection<? extends RString> targetImageFileNames) {
            this.targetImageFileNames = new ArrayList<>(targetImageFileNames);
            return this;
        }

        @Override
        public ImageJohoUpdater ocrData(IOcrData ocrData) {
            this.ocrData = ocrData;
            return new ImageJohoUpdater(this);
        }
    }
}
