package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）のビジネスクラスです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
public class NinteiChosaDataOutputBusiness {

    private final NinteiChosaDataOutputRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 認定調査データ出力（モバイル）のRelateEntity
     */
    public NinteiChosaDataOutputBusiness(NinteiChosaDataOutputRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.get認定調査委託先コード();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.get認定調査員コード();
    }

    /**
     * モバイルデータ出力済フラグを取得します。
     *
     * @return モバイルデータ出力済フラグ
     */
    public boolean isモバイルデータ出力済フラグ() {
        return entity.isモバイルデータ出力済フラグ();
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
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return entity.get氏名();
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
     * 認定申請区分_申請時_コードを取得します。
     *
     * @return 認定申請区分_申請時_コード
     */
    public RString get認定申請区分_申請時_コード() {
        return entity.get認定申請区分_申請時_コード();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.get保険者();
    }

    /**
     * 調査委託先名称を取得します。
     *
     * @return 調査委託先名称
     */
    public RString get調査委託先名称() {
        return entity.get調査委託先名称();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.get調査員氏名();
    }

}
