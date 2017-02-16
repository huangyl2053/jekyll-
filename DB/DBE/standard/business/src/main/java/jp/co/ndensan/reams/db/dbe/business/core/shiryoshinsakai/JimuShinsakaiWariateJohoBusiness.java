/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用主治医意見書のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuShinsakaiWariateJohoBusiness {

    private static final int INDEX_5 = 5;
    private final ShinsakaiSiryoKyotsuEntity entity;
    private RString fileName1;
    private RString fileName2;

    /**
     * コンストラクタです。
     *
     * @param entity ShinsakaiSiryoKyotsuEntity
     */
    public JimuShinsakaiWariateJohoBusiness(ShinsakaiSiryoKyotsuEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo().value();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        if (entity.isJimukyoku()) {
            return entity.getShoKisaiHokenshaNo();
        }
        return RString.EMPTY;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        if (entity.isJimukyoku()) {
            return entity.getHihokenshaNo();
        }
        return RString.EMPTY;
    }

    /**
     * 識別コードは証記載保険者番号（左から5桁）+被保険者番号を設定してください。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.getShoKisaiHokenshaNo().substring(0, INDEX_5).concat(entity.getHihokenshaNo());
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        if (entity.isJimukyoku()) {
            return entity.getHihokenshaName().getColumnValue();
        }
        return RString.EMPTY;
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
     * 今回認定調査実施年月日を取得します。
     *
     * @return 今回認定調査実施年月日
     */
    public FlexibleDate get今回認定調査実施年月日() {
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
     * 事務局用と委員用を取得します。
     *
     * @return is事務局
     */
    public boolean is事務局() {
        return entity.isJimukyoku();
    }

    /**
     * 主治医意見書イメージ１を取得します。
     *
     * @return 主治医意見書イメージ１
     */
    public RString get主治医意見書イメージ１() {
        return fileName1;
    }

    /**
     * 主治医意見書イメージ２を取得します。
     *
     * @return 主治医意見書イメージ２
     */
    public RString get主治医意見書イメージ２() {
        return fileName2;
    }

    /**
     * 主治医意見書イメージ１(E0001)を設定します。
     *
     * @param fileName イメージファイル名
     */
    public void set主治医意見書イメージ１(RString fileName) {
        this.fileName1 = fileName;
    }

    /**
     * 主治医意見書イメージ２(E0002)を設定します。
     *
     * @param fileName イメージファイル名
     */
    public void set主治医意見書イメージ２(RString fileName) {
        this.fileName2 = fileName;
    }

    /**
     * 審査順を取得します。
     *
     * @return 審査順
     */
    public RString get審査順() {
        return new RString(entity.getShinsakaiOrder());
    }
}
