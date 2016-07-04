/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用主治医意見書のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuShinsakaiWariateJohoBusiness {

    private final ShinsakaiWariateJohoEntity entity;
    private static final RString ファイルID_E0001 = new RString("E0001.png");
    private static final RString ファイルID_E0001_BAK = new RString("E0001_BAK.png");
    private static final RString ファイルID_E0002 = new RString("E0002.png");
    private static final RString ファイルID_E0002_BAK = new RString("E0002_BAK.png");

    /**
     * コンストラクタです。
     *
     * @param entity ShinsakaiWariateJohoEntity
     */
    public JimuShinsakaiWariateJohoBusiness(ShinsakaiWariateJohoEntity entity) {
        this.entity = entity;
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
     * 審査会資料作成年月日を取得します。
     *
     * @return 審査会資料作成年月日
     */
    public FlexibleDate get審査会資料作成年月日() {
        return FlexibleDate.getNowDate();
    }

    /**
     * 今回認定申請年月日を取得します。
     *
     * @return 今回認定申請年月日
     */
    public FlexibleDate get今回認定申請年月日() {
        return entity.getNinteiShinseiYMD();
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
     * 今回認定調査実施年月日を取得します。
     *
     * @return 今回認定調査実施年月日
     */
    public FlexibleDate get今回認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
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
     * 今回認定審査年月日を取得します。
     *
     * @return 今回認定審査年月日
     */
    public FlexibleDate get今回認定審査年月日() {
        return entity.getShinsakaiKaisaiYMD();
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
     * 左の主治医意見書イメージを取得します。
     *
     * @return 左の主治医意見書イメージ
     */
    public RString get左の主治医意見書イメージ() {
        return 共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_E0001);
    }

    /**
     * 右の主治医意見書イメージを取得します。
     *
     * @return 右の主治医意見書イメージ
     */
    public RString get右の主治医意見書イメージ() {
        return 共有ファイル2を引き出す(entity.getImageSharedFileId(), ファイルID_E0002);
    }

    /**
     * 主治医意見書イメージ１を取得します。
     *
     * @return 主治医意見書イメージ１
     */
    public RString get主治医意見書イメージ１() {
        return 共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_E0001);
    }

    /**
     * 主治医意見書イメージ２を取得します。
     *
     * @return 主治医意見書イメージ２
     */
    public RString get主治医意見書イメージ２() {
        return 共有ファイルを引き出す(entity.getImageSharedFileId(), ファイルID_E0001);
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_E0001_BAK);
            }
        }
        return imagePath;
    }

    private RString 共有ファイル2を引き出す(RDateTime イメージID, RString イメージID01) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージID01);
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージID, ファイルID_E0002_BAK);
            }
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }
}
