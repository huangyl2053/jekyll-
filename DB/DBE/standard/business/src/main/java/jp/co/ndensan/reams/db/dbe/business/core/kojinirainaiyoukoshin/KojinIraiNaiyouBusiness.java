/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.kojinirainaiyoukoshin;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinirainaiyoukoshin.KojinIraiNaiyouRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 個人依頼内容更新(認定調査票・主治医意見書編集)のRelateBusinessクラスです。
 *
 * @reamsid_L DBE-1590-020 zhangzhiming
 */
public class KojinIraiNaiyouBusiness {

    private final KojinIraiNaiyouRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity KojinIraiNaiyouRelateEntity
     */
    public KojinIraiNaiyouBusiness(KojinIraiNaiyouRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査依頼区分コードのgetメソッドです。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.get認定調査依頼区分コード();
    }

    /**
     * 認定調査実施場所コードのgetメソッドです。
     *
     * @return 認定調査実施場所コード
     */
    public Code get認定調査実施場所コード() {
        return entity.get認定調査実施場所コード();
    }

    /**
     * 認定調査実施年月日のgetメソッドです。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.get認定調査実施年月日();
    }

    /**
     * 地区コードのgetメソッドです。
     *
     * @return 地区コード
     */
    public RString get地区コード() {
        return entity.get地区コード();
    }

    /**
     * 名称のgetメソッドです。
     *
     * @return 名称
     */
    public RString get名称() {
        return entity.get名称();
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.get認定調査委託先コード();
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.get事業者名称();
    }

    /**
     * 調査委託区分のgetメソッドです。
     *
     * @return 調査委託区分
     */
    public RString get調査委託区分() {
        return entity.get調査委託区分();
    }

    /**
     * 認定調査員コードのgetメソッドです。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.get認定調査員コード();
    }

    /**
     * 調査員氏名のgetメソッドです。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.get調査員氏名();
    }

    /**
     * 調査員資格のgetメソッドです。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.get調査員資格();
    }

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.get電話番号();
    }

    /**
     * 番号のgetメソッドです。
     *
     * @return 番号
     */
    public TelNo get番号() {
        return entity.get番号();
    }

    /**
     * 家庭訪問の有無のgetメソッドです。
     *
     * @return 家庭訪問の有無
     */
    public boolean is家庭訪問の有無() {
        return entity.is家庭訪問の有無();
    }

    /**
     * 申請書管理番号のgetメソッドです。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 主治医意見書作成依頼履歴番号のgetメソッドです。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.get主治医意見書作成依頼履歴番号();
    }

    /**
     * 主治医意見書依頼区分のgetメソッドです。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.get主治医意見書依頼区分();
    }

    /**
     * 主治医意見書作成回数のgetメソッドです。
     *
     * @return 主治医意見書作成回数
     */
    public int get主治医意見書作成回数() {
        return entity.get主治医意見書作成回数();
    }

    /**
     * 医師区分コードのgetメソッドです。
     *
     * @return 医師区分コード
     */
    public Code get医師区分コード() {
        return entity.get医師区分コード();
    }

    /**
     * 主治医意見書作成依頼年月日のgetメソッドです。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.get主治医意見書作成依頼年月日();
    }

    /**
     * 主治医意見書記入年月日のgetメソッドです。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate get主治医意見書記入年月日() {
        return entity.get主治医意見書記入年月日();
    }

    /**
     * 認定情報提供希望フラグのgetメソッドです。
     *
     * @return 認定情報提供希望フラグ
     */
    public boolean is認定情報提供希望フラグ() {
        return entity.is認定情報提供希望フラグ();
    }

    /**
     * 主治医コードのgetメソッドです。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.get主治医コード();
    }

    /**
     * 主治医氏名のgetメソッドです。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.get主治医氏名();
    }

    /**
     * 主治医医療機関コードのgetメソッドです。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.get主治医医療機関コード();
    }

    /**
     * 医療機関名称のgetメソッドです。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.get郵便番号();
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.get住所();
    }

    /**
     * 代表者名のgetメソッドです。
     *
     * @return 代表者名
     */
    public RString get代表者名所() {
        return entity.get代表者名();
    }
}
