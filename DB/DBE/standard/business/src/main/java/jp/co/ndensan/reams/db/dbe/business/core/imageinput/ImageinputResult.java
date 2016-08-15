/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageinputRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込み関連データのビジネスクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageinputResult {

    private final ImageinputRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity イメージ取込み関連データRelateEntity
     */
    public ImageinputResult(ImageinputRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * T5101_証記載保険者番号を取得します。
     *
     * @return T5101_証記載保険者番号
     */
    public RString getT5101_証記載保険者番号() {
        return entity.getT5101_証記載保険者番号();
    }

    /**
     * T5101_被保険者番号を取得します。
     *
     * @return T5101_被保険者番号
     */
    public RString getT5101_被保険者番号() {
        return entity.getT5101_被保険者番号();
    }

    /**
     * T5101_被保険者氏名を取得します。
     *
     * @return T5101_被保険者氏名
     */
    public RString getT5101_被保険者氏名() {
        return entity.getT5101_被保険者氏名();
    }

    /**
     * T5101_認定申請年月日を取得します。
     *
     * @return T5101_認定申請年月日
     */
    public RString getT5101_認定申請年月日() {
        return entity.getT5101_認定申請年月日();
    }

    /**
     * getT5101_施設入所の有無を取得します。
     *
     * @return getT5101_施設入所の有無
     */
    public boolean isT5101_施設入所の有無() {
        return entity.isT5101_施設入所の有無();
    }

    /**
     * T7051_市町村名称を取得します。
     *
     * @return T7051_市町村名称
     */
    public RString getT7051_市町村名称() {
        return entity.getT7051_市町村名称();
    }

    /**
     * T5101_申請書管理番号を取得します。
     *
     * @return T5101_申請書管理番号
     */
    public RString getT5101_申請書管理番号() {
        return entity.getT5101_申請書管理番号();
    }

    /**
     * T5115_イメージ共有ファイルIDを取得します。
     *
     * @return T5115_イメージ共有ファイルID
     */
    public RDateTime getT5115_イメージ共有ファイルID() {
        return entity.getT5115_イメージ共有ファイルID();
    }

    /**
     * T5912_主治医コードを取得します。
     *
     * @return T5912_主治医コード
     */
    public RString getT5912_主治医コード() {
        return entity.getT5912_主治医コード();
    }

    /**
     * T5912_主治医氏名を取得します。
     *
     * @return T5912_主治医氏名
     */
    public RString getT5912_主治医氏名() {
        return entity.getT5912_主治医氏名();
    }

    /**
     * T5911_主治医医療機関コードを取得します。
     *
     * @return T5911_主治医医療機関コード
     */
    public RString getT5911_主治医医療機関コード() {
        return entity.getT5911_主治医医療機関コード();
    }

    /**
     * T5911_医療機関名称を取得します。
     *
     * @return T5911_医療機関名称
     */
    public RString getT5911_医療機関名称() {
        return entity.getT5911_医療機関名称();
    }

    /**
     * T5101_厚労省IF識別コードを取得します。
     *
     * @return T5101_厚労省IF識別コード
     */
    public RString getT5101_厚労省IF識別コード() {
        return entity.getT5101_厚労省IF識別コード();
    }

    /**
     * T5301_主治医意見書作成依頼年月日を取得します。
     *
     * @return T5301_主治医意見書作成依頼年月日
     */
    public RString getT5301_主治医意見書作成依頼年月日() {
        return entity.getT5301_主治医意見書作成依頼年月日();
    }

    /**
     * T5301_主治医意見書依頼区分を取得します。
     *
     * @return T5301_主治医意見書依頼区分
     */
    public RString getT5301_主治医意見書依頼区分() {
        return entity.getT5301_主治医意見書依頼区分();
    }

    /**
     * T5301_主治医医療機関コードを取得します。
     *
     * @return T5301_主治医医療機関コード
     */
    public RString getT5301_主治医医療機関コード() {
        return entity.getT5301_主治医医療機関コード();
    }

    /**
     * T5301_主治医コードを取得します。
     *
     * @return T5301_主治医コード
     */
    public RString getT5301_主治医コード() {
        return entity.getT5301_主治医コード();
    }

    /**
     * T5301_主治医意見書作成依頼履歴番号を取得します。
     *
     * @return T5301_主治医意見書作成依頼履歴番号
     */
    public int getT5301_主治医意見書作成依頼履歴番号() {
        return entity.getT5301_主治医意見書作成依頼履歴番号();
    }
}
