/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteiimagekanri.ImagekanriJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ管理情報を取得するビジネスクラスです。
 *
 * @reamsid_L DBE-1670-010 wangxiaodong
 */
public class ImagekanriJoho implements Serializable {

    private final ImagekanriJohoEntity entity;

    /**
     * コンストラクタです。<br/>
     * イメージ管理情報の新規作成時に使用します。
     *
     * @param entity イメージ管理情報
     */
    public ImagekanriJoho(ImagekanriJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.getIkenshoIraiRirekiNo();
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査受領年月日を返します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.getNinteichosaJuryoYMD();
    }

    /**
     * 概況調査テキストイメージ区分を返します。
     *
     * @return 概況調査テキストイメージ区分
     */
    public RString get概況調査テキストイメージ区分() {
        return entity.getGaikyoChosaTextImageKubun();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public JigyoshaNo get認定調査委託先コード() {
        return entity.getChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getChosainCode();
    }

    /**
     * 概況特記テキストイメージ区分を返します。
     *
     * @return 概況特記テキストイメージ区分
     */
    public RString get概況特記テキストイメージ区分() {
        return entity.getGaikyoTokkiTextImageKubun();
    }

    /**
     * 主治医意見書読取年月日を返します。
     *
     * @return 主治医意見書読取年月日
     */
    public FlexibleDate get主治医意見書読取年月日() {
        return entity.getIkenshoReadYMD();
    }

    /**
     * 主治医意見書記入年月日を返します。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate get主治医意見書記入年月日() {
        return entity.getIkenshoKinyuYMD();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryoKikanCode();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 認定申請日を返します。
     *
     * @return 認定申請日
     */
    public FlexibleDate get認定申請日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * イメージ共有ファイルIDを返します。
     *
     * @return イメージ共有ファイルID
     */
    public RDateTime getイメージ共有ファイルID() {
        return entity.getImageSharedFileId();
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.getNinteiShinsakaiKanryoYMD();
    }

    /**
     * センター送信年月日を返します。
     *
     * @return センター送信年月日
     */
    public FlexibleDate getセンター送信年月日() {
        return entity.getCenterSoshinYMD();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

}
