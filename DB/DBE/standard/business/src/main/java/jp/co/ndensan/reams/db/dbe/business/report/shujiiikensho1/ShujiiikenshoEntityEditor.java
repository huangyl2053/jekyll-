/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShujiiikenshoEntityの編集クラスです。
 *
 * @author N3212 竹内 和紀
 */
public final class ShujiiikenshoEntityEditor {

    private static final RString マスキングあり = new RString("1");
    private static final RString FILENAME_BAK = new RString("E0001_BAK.png");
    private static final RString FILENAME = new RString("E0001.png");
    private static final RString FILENAME_BAK02 = new RString("E0002_BAK.png");
    private static final RString FILENAME02 = new RString("E0002.png");
    private static final RString SEPARATOR = new RString("/");

    private ShujiiikenshoEntityEditor() {
    }

    /**
     * ShujiiikenshoEntityを編集します。
     *
     * @param yokaigoNinteiJohoTeikyoEntity YokaigoNinteiJohoTeikyoEntity
     * @param イメージ共有ファイルID イメージ共有ファイルID
     * @param 主治医意見書マスキング区分 主治医意見書マスキング区分
     * @return ShujiiikenshoEntity
     */
    public static ShujiiikenshoEntity edit(YokaigoNinteiJohoTeikyoEntity yokaigoNinteiJohoTeikyoEntity,
            RDateTime イメージ共有ファイルID,
            RString 主治医意見書マスキング区分) {
        ShujiiikenshoEntity shujiEntity = new ShujiiikenshoEntity();
        shujiEntity.set保険者番号(yokaigoNinteiJohoTeikyoEntity.get保険者番号());
        shujiEntity.set被保険者番号(yokaigoNinteiJohoTeikyoEntity.get被保険者番号());
        shujiEntity.set被保険者氏名(yokaigoNinteiJohoTeikyoEntity.get被保険者氏名());
        shujiEntity.setTemp_保険者番号(yokaigoNinteiJohoTeikyoEntity.get保険者番号());
        shujiEntity.setTemp_被保険者番号(yokaigoNinteiJohoTeikyoEntity.get被保険者番号());
        shujiEntity.setTemp_申請書管理番号(yokaigoNinteiJohoTeikyoEntity.get申請書管理番号());
        shujiEntity.set申請日_元号(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set申請日_年(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set申請日_月(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set申請日_日(yokaigoNinteiJohoTeikyoEntity.get認定申請年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get認定申請年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        shujiEntity.set作成日_元号(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set作成日_年(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set作成日_月(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set作成日_日(RDate.getNowDate() == null ? RString.EMPTY : RDate.getNowDate()
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        shujiEntity.set調査日_元号(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set調査日_年(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set調査日_月(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set調査日_日(yokaigoNinteiJohoTeikyoEntity.get実施年月日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get実施年月日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        shujiEntity.set審査日_元号(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getEra());
        shujiEntity.set審査日_年(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear());
        shujiEntity.set審査日_月(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getMonth());
        shujiEntity.set審査日_日(yokaigoNinteiJohoTeikyoEntity.get審査会開催日() == null ? RString.EMPTY
                : yokaigoNinteiJohoTeikyoEntity.get審査会開催日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getDay());
        RString 共有フォルダ名 = yokaigoNinteiJohoTeikyoEntity.get保険者番号().concat(yokaigoNinteiJohoTeikyoEntity.get被保険者番号());
        if (イメージ共有ファイルID != null) {
            ReadOnlySharedFileEntryDescriptor descriptor = get共有ファイルエントリ情報(共有フォルダ名, イメージ共有ファイルID);
            RString path = copySharedFiles(descriptor);
            shujiEntity.setイメージファイル1(get表面イメージファイルパス(descriptor, path, 主治医意見書マスキング区分));
            shujiEntity.setイメージファイル2(get裏面イメージファイルパス(descriptor, path, 主治医意見書マスキング区分));
        }
        return shujiEntity;
    }

    private static RString get表面イメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor,
            RString path, RString 主治医意見書マスキング区分) {
        if (マスキングあり.equals(主治医意見書マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_BAK)) ? FILENAME_BAK : FILENAME;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private static RString get裏面イメージファイルパス(ReadOnlySharedFileEntryDescriptor descriptor,
            RString path, RString 主治医意見書マスキング区分) {
        if (マスキングあり.equals(主治医意見書マスキング区分)) {
            RString fineFullPath = getFilePath(path, FILENAME02);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        } else {
            List<SharedFileEntryInfoEntity> entryInfoList = SharedFile.getEntryInfo(descriptor);
            RString ファイル名 = (existマスキングファイル(entryInfoList, FILENAME_BAK02)) ? FILENAME_BAK02 : FILENAME02;
            RString fineFullPath = getFilePath(path, ファイル名);
            return (!RString.isNullOrEmpty(fineFullPath)) ? fineFullPath : RString.EMPTY;
        }
    }

    private static boolean existマスキングファイル(List<SharedFileEntryInfoEntity> entryInfoList, RString ファイル名) {
        for (SharedFileEntryInfoEntity entryInfo : entryInfoList) {
            if (entryInfo.getFilesEntity().getPathname().endsWith(ファイル名)) {
                return true;
            }
        }
        return false;
    }

    private static ReadOnlySharedFileEntryDescriptor get共有ファイルエントリ情報(RString 共有フォルダ名, RDateTime イメージ共有ファイルID) {
        return new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有フォルダ名), イメージ共有ファイルID);
    }

    private static RString copySharedFiles(ReadOnlySharedFileEntryDescriptor descriptor) {
        RString 出力イメージフォルダパス = Directory.createTmpDirectory();
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(出力イメージフォルダパス)).getCanonicalPath());
    }

    private static RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, SEPARATOR, ファイル名);
        }
        return RString.EMPTY;
    }
}
