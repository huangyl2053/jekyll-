package jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.imagejohomasking.ImageJohoMaskingRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ情報マスキングのビジネスクラスです
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMaskingResult {

    private final ImageJohoMaskingRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity イメージ情報マスキングRelateEntity
     */
    public ImageJohoMaskingResult(ImageJohoMaskingRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * 認定申請区分_申請時コードを取得します。
     *
     * @return 認定申請区分_申請時コード
     */
    public Code get認定申請区分_申請時コード() {
        return entity.get認定申請区分_申請時コード();
    }

    /**
     * 介護認定審査会開催予定年月日を取得します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate get介護認定審査会開催予定年月日() {
        return entity.get介護認定審査会開催予定年月日();
    }

    /**
     * 主治医意見書受領年月日を取得します。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate get主治医意見書受領年月日() {
        return entity.get主治医意見書受領年月日();
    }

    /**
     * 認定調査受領年月日を取得します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.get認定調査受領年月日();
    }

    /**
     * 要介護認定一次判定年月日を取得します。
     *
     * @return 要介護認定一次判定年月日
     */
    public FlexibleDate get要介護認定一次判定年月日() {
        return entity.get要介護認定一次判定年月日();
    }

    /**
     * 認定調査依頼履歴番号を取得します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.get認定調査依頼履歴番号();
    }

    /**
     * 主治医意見書作成依頼履歴番号を取得します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.get主治医意見書作成依頼履歴番号();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 認定調査特記事項番号を取得します。
     *
     * @return 認定調査特記事項番号
     */
    public RString get認定調査特記事項番号() {
        return entity.get認定調査特記事項番号();
    }

    /**
     * 認定調査特記事項連番を取得します。
     *
     * @return 認定調査特記事項連番
     */
    public int get認定調査特記事項連番() {
        return entity.get認定調査特記事項連番();
    }

    /**
     * 帳票IDを取得します。
     *
     * @return 帳票ID
     */
    public Code get帳票ID() {
        return entity.get帳票ID();
    }

    /**
     * 取込みページ番号を取得します。
     *
     * @return 取込みページ番号
     */
    public int get取込みページ番号() {
        return entity.get取込みページ番号();
    }

    /**
     * 認定申請年を取得します。
     *
     * @return 認定申請年
     */
    public int get認定申請年() {
        return entity.get認定申請年();
    }

    /**
     * イメージ共有ファイルIDを取得します。
     *
     * @return イメージ共有ファイルID
     */
    public RDateTime getイメージ共有ファイルID() {
        return entity.getイメージ共有ファイルID();
    }

    /**
     * マスク区分を取得します。
     *
     * @return マスク区分
     */
    public RString getマスク区分() {
        return entity.getマスク区分();
    }

    /**
     * イメージ区分を取得します。
     *
     * @return イメージ区分
     */
    public RString getイメージ区分() {
        return entity.getイメージ区分();
    }

    /**
     * 特記事項を取得します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return entity.get特記事項();
    }

}
