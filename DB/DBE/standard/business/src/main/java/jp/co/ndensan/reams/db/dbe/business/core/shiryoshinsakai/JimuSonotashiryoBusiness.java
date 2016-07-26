/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.SonotaJohoEntity;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 事務局用その他資料情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuSonotashiryoBusiness {

    private final SonotaJohoEntity entity;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_10 = 10;
    private static final RString ファイルID_F1401A01 = new RString("F1401A01.png");
    private static final RString ファイルID_F1401A01_BAK = new RString("F1401A01_BAK.png");
    private static final RString ファイルID_F1401A02 = new RString("F1401A02.png");
    private static final RString ファイルID_F1401A02_BAK = new RString("F1401A02_BAK.png");

    /**
     * コンストラクタです。
     *
     * @param entity SonotaJohoEntity
     */
    public JimuSonotashiryoBusiness(SonotaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return RString.EMPTY;
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        if (entity.getHihokenshaName() == null || RString.isNullOrEmpty(entity.getHihokenshaName().getColumnValue())) {
            return RString.EMPTY;
        }
        return entity.getHihokenshaName().getColumnValue();
    }

    /**
     * 審査会資料作成年を取得します。
     *
     * @return 審査会資料作成年
     */
    public RString get審査会資料作成年() {
        return get年(new FlexibleDate(RDate.getNowDate().toDateString()));
    }

    /**
     * 審査会資料作成月を取得します。
     *
     * @return 審査会資料作成月
     */
    public RString get審査会資料作成月() {
        return get月(new FlexibleDate(RDate.getNowDate().toDateString()));
    }

    /**
     * 審査会資料作成日を取得します。
     *
     * @return 審査会資料作成日
     */
    public RString get審査会資料作成日() {
        return get日(new FlexibleDate(RDate.getNowDate().toDateString()));
    }

    /**
     * 今回認定申請年を取得します。
     *
     * @return 今回認定申請年
     */
    public RString get今回認定申請年() {
        return get年(entity.getNinteiShinseiYMD());
    }

    /**
     * 今回認定申請月を取得します。
     *
     * @return 今回認定申請月
     */
    public RString get今回認定申請月() {
        return get月(entity.getNinteiShinseiYMD());
    }

    /**
     * 今回認定申請日を取得します。
     *
     * @return 今回認定申請日
     */
    public RString get今回認定申請日() {
        return get日(entity.getNinteiShinseiYMD());
    }

    /**
     * 今回認定調査実施年を取得します。
     *
     * @return 今回認定調査実施年
     */
    public RString get今回認定調査実施年() {
        return get年(entity.getNinteichosaJisshiYMD());
    }

    /**
     * 今回認定調査実施月を取得します。
     *
     * @return 今回認定調査実施月
     */
    public RString get今回認定調査実施月() {
        return get月(entity.getNinteichosaJisshiYMD());
    }

    /**
     * 今回認定調査実施日を取得します。
     *
     * @return 今回認定調査実施日
     */
    public RString get今回認定調査実施日() {
        return get日(entity.getNinteichosaJisshiYMD());
    }

    /**
     * 今回認定審査年を取得します。
     *
     * @return 今回認定審査年
     */
    public RString get今回認定審査年() {
        return get年(entity.getShinsakaiKaisaiYMD());
    }

    /**
     * 今回認定審査月を取得します。
     *
     * @return 今回認定審査月
     */
    public RString get今回認定審査月() {
        return get月(entity.getShinsakaiKaisaiYMD());
    }

    /**
     * 今回認定審査日を取得します。
     *
     * @return 今回認定審査日
     */
    public RString get今回認定審査日() {
        return get日(entity.getShinsakaiKaisaiYMD());
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 左のその他資料イメージを取得します。
     *
     * @return 左のその他資料イメージ
     */
    public RString get左のその他資料イメージ() {
        return 共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_F1401A01);
    }

    /**
     * 右のその他資料イメージを取得します。
     *
     * @return 右のその他資料イメージ
     */
    public RString get右のその他資料イメージ() {
        return 共有ファイル2を引き出す(entity.getImageSharedFileId(), ファイルID_F1401A02);
    }

    /**
     * その他資料を取得します。
     *
     * @return その他資料
     */
    public RString getその他資料() {
        return 共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_F1401A01);
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(0, INT_4);
        }
        return RString.EMPTY;
    }

    private RString get月(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_5, INT_7);
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_8, INT_10);
        }
        return RString.EMPTY;
    }

    private RString パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_F1401A01_BAK);
            }
        }
        return imagePath;
    }

    private RString 共有ファイル2を引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_F1401A02_BAK);
            }
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }

}
